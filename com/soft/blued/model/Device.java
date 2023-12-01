package com.soft.blued.model;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/model/Device.class */
public class Device {
    public int connectiontype;
    public int devicetype;
    public Ext ext;
    public String imei;
    public String imei_md5;
    public String ip;
    public String oaid;

    public Device(String str, String str2, String str3, String str4, int i, int i2, Ext ext) {
        this.ip = str;
        this.imei = str2;
        this.imei_md5 = str3;
        this.oaid = str4;
        this.connectiontype = i;
        this.devicetype = i2;
        this.ext = ext;
    }
}
