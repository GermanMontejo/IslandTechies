package com.islandtechies.model;

public class NavData {
    private String navIconLabel;
    private int icon;

    public NavData(int icon, String navIconLabel) {
        this.icon = icon;
        this.navIconLabel = navIconLabel;
    }

    public String getNavIconLabel() {
        return navIconLabel;
    }

    public int getIcon() {
        return icon;
    }
}
