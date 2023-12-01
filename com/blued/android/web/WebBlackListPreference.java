package com.blued.android.web;

import com.blued.android.core.AppInfo;
import com.blued.android.module.common.utils.BluedSharedPreferences;
import com.soft.blued.utils.StringUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/web/WebBlackListPreference.class */
public class WebBlackListPreference {

    /* renamed from: a  reason: collision with root package name */
    public static BluedSharedPreferences f18778a;

    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/web/WebBlackListPreference$PreferenceBlackList.class */
    public static class PreferenceBlackList {

        /* renamed from: a  reason: collision with root package name */
        public List<String> f18779a;
    }

    public static BluedSharedPreferences a() {
        if (f18778a == null) {
            f18778a = BluedSharedPreferences.a("web_black_list", 0);
        }
        return f18778a;
    }

    public static void a(String str) {
        ArrayList arrayList;
        List<String> b = b();
        if (b == null || b.size() <= 0) {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(str);
            arrayList = arrayList2;
        } else {
            b.add(str);
            arrayList = b;
        }
        a(arrayList);
    }

    private static void a(List<String> list) {
        PreferenceBlackList preferenceBlackList = new PreferenceBlackList();
        preferenceBlackList.f18779a = list;
        a().c().a("WEB_BLACK_LIST_JSON", AppInfo.f().toJson(preferenceBlackList)).a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static List<String> b() {
        String a2 = a().a("WEB_BLACK_LIST_JSON", "");
        List arrayList = new ArrayList();
        PreferenceBlackList preferenceBlackList = (PreferenceBlackList) AppInfo.f().fromJson(a2, (Class<Object>) PreferenceBlackList.class);
        if (preferenceBlackList != null) {
            arrayList = preferenceBlackList.f18779a;
        }
        return arrayList;
    }

    public static void b(String str) {
        List<String> b = b();
        if (b != null && b.size() > 0 && b.contains(str)) {
            b.remove(str);
        }
        a(b);
    }

    public static boolean c(String str) {
        boolean z;
        List<String> b = b();
        boolean z2 = false;
        if (b != null) {
            z2 = false;
            if (b.size() > 0) {
                z2 = false;
                for (int i = 0; i < b.size(); i++) {
                    String lowerCase = b.get(i).toLowerCase();
                    if (StringUtils.d(lowerCase)) {
                        z = true;
                        if (z2) {
                        }
                        z = false;
                    } else {
                        z = true;
                        if (!z2) {
                            if (lowerCase.equals(str.toLowerCase())) {
                                z = true;
                            }
                            z = false;
                        }
                    }
                    z2 = z;
                }
            }
        }
        return z2;
    }
}
