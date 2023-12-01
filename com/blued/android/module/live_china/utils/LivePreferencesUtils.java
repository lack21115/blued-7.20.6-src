package com.blued.android.module.live_china.utils;

import com.blued.android.module.common.utils.BluedSharedPreferences;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/utils/LivePreferencesUtils.class */
public class LivePreferencesUtils {

    /* renamed from: a  reason: collision with root package name */
    private static BluedSharedPreferences f14187a;

    public static BluedSharedPreferences a() {
        if (f14187a == null) {
            f14187a = BluedSharedPreferences.a();
        }
        return f14187a;
    }

    public static void a(long j) {
        BluedSharedPreferences.Editor c2 = a().c();
        c2.a(LiveRoomInfo.a().f() + "live_upload_timer_is_done_time", j).b();
    }

    public static void a(boolean z) {
        BluedSharedPreferences.Editor c2 = a().c();
        c2.a(LiveRoomInfo.a().f() + "live_enter_room", z).b();
    }

    public static long b() {
        BluedSharedPreferences a2 = a();
        return a2.a(LiveRoomInfo.a().f() + "live_upload_timer_is_done_time", 0L);
    }

    public static void b(boolean z) {
        BluedSharedPreferences.Editor c2 = a().c();
        c2.a(LiveRoomInfo.a().f() + "live_blind_date_room", z).b();
    }

    public static void c(boolean z) {
        BluedSharedPreferences.Editor c2 = a().c();
        c2.a(LiveRoomInfo.a().f() + "live_show_big_photo", z).b();
    }

    public static boolean c() {
        BluedSharedPreferences a2 = a();
        return a2.a(LiveRoomInfo.a().f() + "live_enter_room", false);
    }

    public static void d(boolean z) {
        BluedSharedPreferences.Editor c2 = a().c();
        c2.a(LiveRoomInfo.a().f() + "live_scroll_guide", z).b();
    }

    public static boolean d() {
        BluedSharedPreferences a2 = a();
        return a2.a(LiveRoomInfo.a().f() + "live_blind_date_room", false);
    }

    public static boolean e() {
        BluedSharedPreferences a2 = a();
        return a2.a(LiveRoomInfo.a().f() + "live_show_big_photo", false);
    }

    public static boolean f() {
        BluedSharedPreferences a2 = a();
        return a2.a(LiveRoomInfo.a().f() + "live_scroll_guide", false);
    }
}
