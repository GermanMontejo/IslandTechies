package com.islandtechies.model;

import android.content.Context;

import com.islandtechies.R;
import com.islandtechies.presenter.ContentPresenter;
import com.squareup.okhttp.Authenticator;
import com.squareup.okhttp.Credentials;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;

import java.io.IOException;
import java.io.InputStream;
import java.net.Proxy;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.OkClient;
import retrofit.client.Response;

public class RestClient implements IRestClient {
    private static final String BASE_ENDPOINT = "https://api.islandtechies.org:6984";
    private static RestAdapter restAdapter;
    private static OkHttpClient okHttpClient;
    private static Context context;
    private static ContentApiService contentApiService;
    private ContentPresenter contentPresenter;

    public RestClient(ContentPresenter contentPresenter, Context context) {
        this.context = context;
        restAdapter = createRestAdapter();
        contentApiService = restAdapter.create(ContentApiService.class);
        this.contentPresenter = contentPresenter;
    }

    public static RestAdapter createRestAdapter() {
        try {
            okHttpClient = initializeOkHttpClient();
        } catch (CertificateException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyStoreException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // something happened that halted the initialization of the okhttpclient
        // with the ssl certificate, so we just use a default okhttp client.
        // note that this may not be able to connect to island techies endpoint.
        if (okHttpClient == null) {
            okHttpClient = new OkHttpClient();
        }
        if (restAdapter == null) {
            restAdapter = new RestAdapter.Builder()
                    .setLogLevel(RestAdapter.LogLevel.FULL)
                    .setEndpoint(BASE_ENDPOINT)
                    .setClient(new OkClient(okHttpClient))
                    .build();
        }
        return restAdapter;
    }

    private static OkHttpClient initializeOkHttpClient() throws CertificateException, IOException, KeyStoreException, NoSuchAlgorithmException, KeyManagementException {
        OkHttpClient okHttpClient = new OkHttpClient();

        // create a certificate using the certificate we obtained from the server
        CertificateFactory cf = CertificateFactory.getInstance("X.509");
        InputStream isCert = context.getResources().openRawResource(R.raw.island_techies);
        Certificate ca = cf.generateCertificate(isCert);
        isCert.close();

        // create a keystore that would contain this self-signed certificate
        KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
        keyStore.load(null, null);
        keyStore.setCertificateEntry("ca", ca);

        // create a TrustManager that would trust the CAs in the keystore
        String algorithm = TrustManagerFactory.getDefaultAlgorithm();
        TrustManagerFactory tmf = TrustManagerFactory.getInstance(algorithm);
        tmf.init(keyStore);

        // create an SSL Socket Factory that would use the TrustManager
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(null, tmf.getTrustManagers(), null);
        okHttpClient.setSslSocketFactory(sslContext.getSocketFactory());

        okHttpClient.setAuthenticator(new Authenticator() {

            @Override
            public Request authenticate(Proxy proxy, com.squareup.okhttp.Response response) throws IOException {
                String credential = Credentials.basic("android", "rAh1QvRsNbjHa3xZnXIlyj90G");
                return response.request().newBuilder().header("Authorization", credential).build();
            }

            @Override
            public Request authenticateProxy(Proxy proxy, com.squareup.okhttp.Response response) throws IOException {
                return null;
            }
        });
        return okHttpClient;
    }

    @Override
    public void loadContents() {
        contentApiService.loadContents(new Callback<ListContentModels>() {

            @Override
            public void success(ListContentModels listContentModels, Response response) {
                contentPresenter.invokePresenterToDisplayContents(listContentModels);
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }
}
