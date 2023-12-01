package com.tencent.tmsqmsp.sdk.f;

import java.io.File;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsqmsp/sdk/f/k.class */
public class k {
    public static int a(String str, String str2) {
        try {
            return j.a(str, new File(str2));
        } catch (Throwable th) {
            th.printStackTrace();
            return -1;
        }
    }
}
