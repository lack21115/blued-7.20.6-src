package com.soft.blued.ui.web.modelloader.model;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/web/modelloader/model/DeviceModel.class */
public class DeviceModel {
    public int battery;
    public String density;
    public int height;
    public String name;
    public String osVersion;
    public String version;
    public int width;

    public DeviceModel(String str, String str2, String str3, String str4, int i, int i2, int i3) {
        this.density = str;
        this.name = str2;
        this.osVersion = str3;
        this.version = str4;
        this.width = i;
        this.height = i2;
        this.battery = i3;
    }

    public String toString() {
        return "DeviceModel{density='" + this.density + "', name='" + this.name + "', osVersion='" + this.osVersion + "', version='" + this.version + "', width=" + this.width + ", height=" + this.height + ", battery=" + this.battery + '}';
    }
}
