package com.soft.blued.ui.msg;

import com.blued.android.module.common.utils.BluedSharedPreferences;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/MsgPreferences.class */
public class MsgPreferences {

    /* renamed from: a  reason: collision with root package name */
    public static BluedSharedPreferences f18197a;
    public static String b = "MSG_FILTER_NEW_MSG_GUIDE";

    public static void a() {
        d().c().a(b, false).a();
    }

    public static void a(String str) {
        d().c().a("chat_recent_photos", str).b();
    }

    public static String b() {
        return d().a("chat_recent_photos", "");
    }

    public static void c() {
        d().c().a("chat_recent_photos_guide", false).b();
    }

    private static BluedSharedPreferences d() {
        if (f18197a == null) {
            f18197a = BluedSharedPreferences.a();
        }
        return f18197a;
    }
}
