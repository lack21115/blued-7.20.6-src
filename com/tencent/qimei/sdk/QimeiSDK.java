package com.tencent.qimei.sdk;

import com.tencent.qimei.o.u;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qimei/sdk/QimeiSDK.class */
public class QimeiSDK {
    public static final String TAG = "QmSDK";

    public static IQimeiSDK getInstance(String str) {
        return u.a(str);
    }
}
