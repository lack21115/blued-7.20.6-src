package com.umeng.commonsdk.framework;

import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/commonsdk/framework/UMLogDataProtocol.class */
public interface UMLogDataProtocol {

    /* loaded from: source-8829756-dex2jar.jar:com/umeng/commonsdk/framework/UMLogDataProtocol$UMBusinessType.class */
    public enum UMBusinessType {
        U_APP,
        U_INTERNAL,
        U_ZeroEnv,
        U_Silent
    }

    void removeCacheData(Object obj);

    JSONObject setupReportData(long j);

    void workEvent(Object obj, int i);
}
