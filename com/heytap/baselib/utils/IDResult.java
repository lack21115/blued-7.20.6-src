package com.heytap.baselib.utils;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-7994992-dex2jar.jar:com/heytap/baselib/utils/IDResult.class */
public class IDResult {
    String mResult;
    int retCode;

    /* JADX INFO: Access modifiers changed from: package-private */
    public IDResult(String str, int i) {
        this.mResult = "";
        this.mResult = str;
        this.retCode = i;
    }

    public String toString() {
        return "IDResult{mResult='" + this.mResult + "', mCode=" + this.retCode + '}';
    }
}
