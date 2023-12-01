package com.huawei.openalliance.ad.beans.metadata;

import java.io.Serializable;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/beans/metadata/InstallConfig.class */
public class InstallConfig implements Serializable {
    private static final long serialVersionUID = 546555599564481045L;
    private String appBtnInstallWay;
    private String creativeInstallWay;

    public String Code() {
        return this.creativeInstallWay;
    }

    public void Code(String str) {
        this.creativeInstallWay = str;
    }

    public String V() {
        return this.appBtnInstallWay;
    }

    public void V(String str) {
        this.appBtnInstallWay = str;
    }
}
