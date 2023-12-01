package com.blued.android.module.yy_china.test;

import com.blued.android.core.utils.skin.BluedSkinPreferences;
import com.blued.android.module.common.utils.BluedSharedPreferences;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/test/TestPreferences.class */
public class TestPreferences {

    /* renamed from: a  reason: collision with root package name */
    public static BluedSharedPreferences f17807a;

    public static BluedSharedPreferences a() {
        if (f17807a == null) {
            f17807a = BluedSharedPreferences.a();
        }
        return f17807a;
    }

    public static void a(int i) {
        a().c().a("blued_skin_name", i).b();
    }

    public static void a(boolean z) {
        a().c().a("change_skin", z).b();
    }

    public static void b(boolean z) {
        BluedSkinPreferences.a(z);
        if (z) {
            a(3);
        } else {
            a(b() ? 1 : 2);
        }
    }

    public static final boolean b() {
        return a().a("change_skin", false);
    }

    public static boolean c() {
        return BluedSkinPreferences.a();
    }
}
