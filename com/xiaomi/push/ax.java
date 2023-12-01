package com.xiaomi.push;

import android.content.Context;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/ax.class */
public class ax {

    /* renamed from: a  reason: collision with root package name */
    static int f27574a;

    public static as a(Context context) {
        if (j.m8997a()) {
            f27574a = 1;
            return new aw(context);
        } else if (ap.a(context)) {
            f27574a = 2;
            return new ap(context);
        } else if (az.a(context)) {
            f27574a = 4;
            return new az(context);
        } else if (bd.a(context)) {
            f27574a = 5;
            return new bd(context);
        } else if (av.a(context)) {
            f27574a = 3;
            return new at(context);
        } else {
            f27574a = 0;
            return new bc();
        }
    }
}
