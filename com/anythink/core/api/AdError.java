package com.anythink.core.api;

import android.text.TextUtils;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/api/AdError.class */
public class AdError {
    protected String code;
    protected String desc;
    protected String itemsErrorInfo = "";
    protected String platformCode;
    protected String platformMSG;

    /* JADX INFO: Access modifiers changed from: protected */
    public AdError(String str, String str2, String str3, String str4) {
        this.code = str;
        this.desc = str2;
        this.platformCode = str3;
        this.platformMSG = str4;
    }

    public String getCode() {
        return this.code;
    }

    public String getDesc() {
        return this.desc;
    }

    public String getFullErrorInfo() {
        if (!TextUtils.isEmpty(this.itemsErrorInfo)) {
            return "\ncode[ " + this.code + " ]\ndesc[ " + this.desc + " ]\ndetail[ " + this.itemsErrorInfo + " \n]";
        }
        return "code:[ " + this.code + " ]desc:[ " + this.desc + " ]platformCode:[ " + this.platformCode + " ]platformMSG:[ " + this.platformMSG + " ]";
    }

    public String getPlatformCode() {
        return this.platformCode;
    }

    public String getPlatformMSG() {
        return this.platformMSG;
    }

    public String printStackTrace() {
        return "code:[ " + this.code + " ]desc:[ " + this.desc + " ]platformCode:[ " + this.platformCode + " ]platformMSG:[ " + this.platformMSG + " ]";
    }

    public void putNetworkErrorMsg(String str, int i, String str2, AdError adError) {
        this.platformCode = adError.platformCode;
        this.platformMSG = adError.platformMSG;
        this.itemsErrorInfo += "\n  { ad_source_id[ " + str + " ];network_firm_id[ " + i + " ];network_name=[ " + str2 + " ];network_error:[ " + adError.printStackTrace() + " ] }";
    }

    public String toString() {
        return printStackTrace();
    }
}
