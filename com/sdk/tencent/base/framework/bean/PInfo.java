package com.sdk.tencent.base.framework.bean;

import com.sdk.tencent.k.a;
import java.util.ArrayList;

/* loaded from: source-8303388-dex2jar.jar:com/sdk/tencent/base/framework/bean/PInfo.class */
public class PInfo {

    /* renamed from: c  reason: collision with root package name */
    private String f14334c;
    private ArrayList<String> imei;
    private String mac;
    private String n;
    private String os;

    public String getC() {
        return this.f14334c;
    }

    public ArrayList<String> getImei() {
        return this.imei;
    }

    public String getMac() {
        return this.mac;
    }

    public String getN() {
        return this.n;
    }

    public String getOs() {
        return this.os;
    }

    public void setC(String str) {
        this.f14334c = str;
    }

    public void setImei(ArrayList<String> arrayList) {
        this.imei = arrayList;
    }

    public void setMac(String str) {
        this.mac = str;
    }

    public void setN(String str) {
        this.n = str;
    }

    public void setOs(String str) {
        this.os = str;
    }

    public String toString() {
        return a.a(this);
    }
}
