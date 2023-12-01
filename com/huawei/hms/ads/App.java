package com.huawei.hms.ads;

import java.io.Serializable;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/App.class */
public class App implements Serializable {
    private static final long serialVersionUID = 30421300;
    private Integer brand;
    private String name__;
    private String pkgname__;
    private String version__;

    public App() {
    }

    public App(String str, String str2, String str3) {
        this.name__ = str2;
        this.pkgname__ = str;
        this.version__ = str3;
    }

    public App(String str, String str2, String str3, Integer num) {
        this.version__ = str;
        this.name__ = str2;
        this.pkgname__ = str3;
        this.brand = num;
    }

    public Integer getBrand() {
        return this.brand;
    }

    public String getName__() {
        return this.name__;
    }

    public String getPkgname__() {
        return this.pkgname__;
    }

    public String getVersion__() {
        return this.version__;
    }

    public void setBrand(Integer num) {
        this.brand = num;
    }

    public void setName__(String str) {
        this.name__ = str;
    }

    public void setPkgname__(String str) {
        this.pkgname__ = str;
    }

    public void setVersion__(String str) {
        this.version__ = str;
    }
}
