package com.tencent.tendinsv.utils;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tendinsv/utils/u.class */
public class u {

    /* renamed from: a  reason: collision with root package name */
    private static volatile u f25426a;
    private static SharedPreferences b;

    /* renamed from: c  reason: collision with root package name */
    private static SharedPreferences.Editor f25427c;
    private static final String d = "shanyan_share_data";

    private u() {
    }

    public static u a(Context context) {
        if (f25426a == null) {
            synchronized (u.class) {
                try {
                    if (f25426a == null) {
                        f25426a = new u();
                        SharedPreferences sharedPreferences = context.getSharedPreferences(d, 0);
                        b = sharedPreferences;
                        f25427c = sharedPreferences.edit();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f25426a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SharedPreferences a() {
        return b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SharedPreferences.Editor b() {
        return f25427c;
    }
}
