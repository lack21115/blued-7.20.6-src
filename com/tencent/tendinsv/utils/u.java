package com.tencent.tendinsv.utils;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tendinsv/utils/u.class */
public class u {

    /* renamed from: a  reason: collision with root package name */
    private static volatile u f39117a;
    private static SharedPreferences b;

    /* renamed from: c  reason: collision with root package name */
    private static SharedPreferences.Editor f39118c;
    private static final String d = "shanyan_share_data";

    private u() {
    }

    public static u a(Context context) {
        if (f39117a == null) {
            synchronized (u.class) {
                try {
                    if (f39117a == null) {
                        f39117a = new u();
                        SharedPreferences sharedPreferences = context.getSharedPreferences(d, 0);
                        b = sharedPreferences;
                        f39118c = sharedPreferences.edit();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f39117a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SharedPreferences a() {
        return b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SharedPreferences.Editor b() {
        return f39118c;
    }
}
