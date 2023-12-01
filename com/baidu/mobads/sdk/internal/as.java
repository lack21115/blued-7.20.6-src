package com.baidu.mobads.sdk.internal;

import android.util.Log;
import com.baidu.mobads.sdk.internal.av;

/* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/internal/as.class */
public class as extends av.a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f9318a = "debug";

    private static void a(int i, String str, String str2) {
        try {
            if (i == 7) {
                Log.wtf(str, str2);
            } else {
                Log.println(i, str, str2);
            }
        } catch (Throwable th) {
        }
    }

    @Override // com.baidu.mobads.sdk.internal.av.a
    String a() {
        return "debug";
    }

    @Override // com.baidu.mobads.sdk.internal.av.a
    protected void a(int i, String str, String str2, Throwable th) {
        a(i, str, str2);
    }

    @Override // com.baidu.mobads.sdk.internal.av.a
    protected boolean a(String str, int i) {
        return av.f9322a.equals(str);
    }
}
