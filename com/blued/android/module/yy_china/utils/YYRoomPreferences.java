package com.blued.android.module.yy_china.utils;

import android.text.TextUtils;
import com.blued.android.core.AppInfo;
import com.blued.android.module.common.utils.BluedSharedPreferences;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/utils/YYRoomPreferences.class */
public class YYRoomPreferences {
    public static BluedSharedPreferences a;

    public static BluedSharedPreferences a() {
        if (a == null) {
            a = BluedSharedPreferences.a("blued_sf_yy", 0);
        }
        return a;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [com.blued.android.module.yy_china.utils.YYRoomPreferences$2] */
    public static ArrayList<String> a(String str) {
        String a2 = a().a(str, "");
        return TextUtils.isEmpty(a2) ? new ArrayList<>() : (ArrayList) AppInfo.f().fromJson(a2, new TypeToken<List<String>>() { // from class: com.blued.android.module.yy_china.utils.YYRoomPreferences.2
        }.getType());
    }

    public static void a(String str, List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        a().c().a(str, AppInfo.f().toJson(list)).a();
    }

    public static void a(List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        a().c().a("ktv_search_records", AppInfo.f().toJson(list)).a();
    }

    public static void a(boolean z) {
        a().c().a("SHOW_YY_DAILY_TASK_GUIDE", z).a();
    }

    public static boolean b() {
        return a().a("SHOW_YY_PRE_PAY_DIALOG_GUIDEs", false);
    }

    public static void c() {
        a().c().a("SHOW_YY_PRE_PAY_DIALOG_GUIDEs", true).a();
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [com.blued.android.module.yy_china.utils.YYRoomPreferences$1] */
    public static ArrayList<String> d() {
        String a2 = a().a("ktv_search_records", "");
        return TextUtils.isEmpty(a2) ? new ArrayList<>() : (ArrayList) AppInfo.f().fromJson(a2, new TypeToken<List<String>>() { // from class: com.blued.android.module.yy_china.utils.YYRoomPreferences.1
        }.getType());
    }
}
