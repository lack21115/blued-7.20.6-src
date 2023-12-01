package com.soft.blued.ui.find.model;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/model/SearchPositionModel.class */
public class SearchPositionModel {
    public boolean isDel;
    public double lat;
    public double lon;
    public String name;

    public SearchPositionModel() {
    }

    public SearchPositionModel(String str) {
        this.name = str;
    }

    public SearchPositionModel(String str, double d, double d2) {
        this.name = str;
        this.lat = d;
        this.lon = d2;
    }

    public void update(SearchPositionModel searchPositionModel) {
        this.name = searchPositionModel.name;
        this.lat = searchPositionModel.lat;
        this.lon = searchPositionModel.lon;
        this.isDel = searchPositionModel.isDel;
    }
}
