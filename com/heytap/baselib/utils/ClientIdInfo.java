package com.heytap.baselib.utils;

import android.text.Spanned;
import android.text.TextUtils;

/* loaded from: source-7994992-dex2jar.jar:com/heytap/baselib/utils/ClientIdInfo.class */
public class ClientIdInfo {
    private String imei;
    private String localId;
    private int retCode;
    private String tvUUID;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ClientIdInfo(IDResult iDResult) {
        if (ClientIdHelper.hasIMEIRetCode(iDResult.retCode)) {
            this.imei = iDResult.mResult;
        } else if (ClientIdHelper.hasTVUUIDRetCode(iDResult.retCode)) {
            this.tvUUID = iDResult.mResult;
        } else {
            this.localId = iDResult.mResult;
        }
        this.retCode = iDResult.retCode;
    }

    public int getIMEIRetCode() {
        return this.retCode & 255;
    }

    public String getImei() {
        return this.imei;
    }

    public int getLocalIDRetCode() {
        return this.retCode & 65280;
    }

    public String getLocalId() {
        return this.localId;
    }

    public int getRetCode() {
        return this.retCode;
    }

    public int getTVUUIDDRetCode() {
        return this.retCode & Spanned.SPAN_PRIORITY;
    }

    public String getTvUUID() {
        return this.tvUUID;
    }

    public boolean hasIMEI() {
        return TextUtils.isEmpty(this.imei);
    }

    public boolean hasLocalID() {
        return TextUtils.isEmpty(this.localId);
    }

    public boolean hasTVUUID() {
        return TextUtils.isEmpty(this.tvUUID);
    }

    public String toString() {
        return "ClientIdInfo{imei='" + this.imei + "', localId='" + this.localId + "', tvUUID='" + this.tvUUID + "', retCode=" + this.retCode + '}';
    }
}
