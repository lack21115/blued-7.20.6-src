package com.soft.blued.ui.find.manager;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.utils.NetworkUtils;
import com.blued.android.module.common.user.model.ConstellationModel;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.user.model.UserTagAll;
import com.soft.blued.R;
import com.soft.blued.ui.user.utils.VirtualImageUtils;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.StringUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.JobKt__JobKt;

@Metadata
/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/manager/FilterNewHelper.class */
public final class FilterNewHelper {

    /* renamed from: a  reason: collision with root package name */
    public static final FilterNewHelper f30593a = new FilterNewHelper();
    private static final boolean b;

    /* renamed from: c  reason: collision with root package name */
    private static final String f30594c;
    private static final String d;
    private static final String e;
    private static final String f;

    static {
        Resources resources;
        int i;
        String string;
        b = BluedPreferences.aF() == 2;
        String string2 = AppInfo.d().getResources().getString(R.string.unlimited);
        Intrinsics.c(string2, "getAppContext().resource…tring(R.string.unlimited)");
        f30594c = string2;
        String string3 = AppInfo.d().getResources().getString(R.string.filter_new_unlimited);
        Intrinsics.c(string3, "getAppContext().resource…ing.filter_new_unlimited)");
        d = string3;
        if (b) {
            resources = AppInfo.d().getResources();
            i = 2131889110;
        } else {
            resources = AppInfo.d().getResources();
            i = 2131889058;
        }
        String string4 = resources.getString(i);
        Intrinsics.c(string4, "if (isLBS_IN) AppInfo.ge…es.getString(R.string.kg)");
        e = string4;
        if (b) {
            string = "";
        } else {
            string = AppInfo.d().getResources().getString(R.string.cm);
            Intrinsics.c(string, "getAppContext().resources.getString(R.string.cm)");
        }
        f = string;
    }

    private FilterNewHelper() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(UserTagAll userTagAll) {
        ArrayList arrayList = new ArrayList();
        List<ConstellationModel> list = userTagAll.zodiac;
        if (list == null || list.isEmpty()) {
            return;
        }
        List<ConstellationModel> list2 = userTagAll.zodiac;
        Intrinsics.c(list2, "data.zodiac");
        for (ConstellationModel constellationModel : list2) {
            String str = constellationModel.icon_gray;
            Intrinsics.c(str, "model.icon_gray");
            arrayList.add(str);
            String str2 = constellationModel.dark_icon_gray;
            Intrinsics.c(str2, "model.dark_icon_gray");
            arrayList.add(str2);
        }
        VirtualImageUtils.Companion.a(arrayList);
    }

    public final String a(Integer num, Integer num2, Context context) {
        if (context == null || num == null) {
            return "";
        }
        int intValue = num.intValue();
        if (num2 == null) {
            return "";
        }
        int intValue2 = num2.intValue();
        String string = context.getResources().getString(R.string.old);
        Intrinsics.c(string, "context.resources.getString(R.string.old)");
        String[] a2 = f30593a.a(context);
        String string2 = context.getString(R.string.filter_new_above);
        Intrinsics.c(string2, "context.getString(R.string.filter_new_above)");
        String str = "";
        if (intValue < a2.length) {
            str = "";
            if (intValue2 < a2.length) {
                String str2 = a2[intValue];
                String str3 = a2[intValue2];
                StringBuilder sb = new StringBuilder();
                sb.append(intValue);
                sb.append('-');
                sb.append(intValue2);
                BluedPreferences.l(sb.toString());
                if (f30593a.a(str3)) {
                    BluedPreferences.l(intValue + "-300");
                    str = str2 + string + string2;
                } else if (Intrinsics.a((Object) str2, (Object) str3)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(intValue);
                    sb2.append('-');
                    sb2.append(intValue2);
                    BluedPreferences.l(sb2.toString());
                    str = Intrinsics.a(str2, (Object) string);
                } else {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(intValue);
                    sb3.append('-');
                    sb3.append(intValue2);
                    BluedPreferences.l(sb3.toString());
                    str = str2 + " ～ " + str3 + string;
                }
            }
        }
        return str;
    }

    public final boolean a() {
        return b;
    }

    public final boolean a(String unLimit) {
        Intrinsics.e(unLimit, "unLimit");
        String str = unLimit;
        return TextUtils.equals(str, "Unlimited") || TextUtils.equals(str, "不限") || TextUtils.equals(str, "No limit") || TextUtils.equals(str, "不限制");
    }

    public final String[] a(Context context) {
        Intrinsics.e(context, "context");
        String[] stringArray = context.getResources().getStringArray(R.array.age_array_key_all);
        Intrinsics.c(stringArray, "context.resources.getStr….array.age_array_key_all)");
        return stringArray;
    }

    public final String b() {
        return d;
    }

    public final String b(Integer num, Integer num2, Context context) {
        if (context == null || num == null) {
            return "";
        }
        int intValue = num.intValue();
        if (num2 == null) {
            return "";
        }
        int intValue2 = num2.intValue();
        String[] b2 = f30593a.b(context);
        String string = context.getString(R.string.filter_new_below);
        Intrinsics.c(string, "context.getString(R.string.filter_new_below)");
        String string2 = context.getString(R.string.filter_new_above);
        Intrinsics.c(string2, "context.getString(R.string.filter_new_above)");
        String str = "";
        if (intValue < b2.length) {
            str = "";
            if (intValue2 < b2.length) {
                String b3 = f30593a.a(b2[intValue]) ? f30593a.b() : b2[intValue];
                String b4 = f30593a.a(b2[intValue2]) ? f30593a.b() : b2[intValue2];
                if (Intrinsics.a((Object) b3, (Object) b4)) {
                    if (f30593a.a(b3)) {
                        BluedPreferences.m("0-500");
                        return b3;
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append(intValue);
                    sb.append('-');
                    sb.append(intValue2);
                    BluedPreferences.m(sb.toString());
                    return Intrinsics.a(b3, (Object) f30593a.d());
                } else if (f30593a.a(b3)) {
                    BluedPreferences.m(Intrinsics.a("0-", (Object) Integer.valueOf(intValue2)));
                    return b4 + f30593a.d() + string;
                } else if (f30593a.a(b4)) {
                    BluedPreferences.m(intValue + "-500");
                    return b3 + f30593a.d() + string2;
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(intValue);
                    sb2.append('-');
                    sb2.append(intValue2);
                    BluedPreferences.m(sb2.toString());
                    str = b3 + " ～ " + b4 + f30593a.d();
                }
            }
        }
        return str;
    }

    public final String[] b(Context context) {
        Intrinsics.e(context, "context");
        String[] stringArray = context.getResources().getStringArray(b ? 2130903085 : 2130903079);
        Intrinsics.c(stringArray, "context.resources.getStr…ray.height_array_key_all)");
        return stringArray;
    }

    public final String c() {
        return e;
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x01ff  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String c(java.lang.Integer r5, java.lang.Integer r6, android.content.Context r7) {
        /*
            Method dump skipped, instructions count: 529
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soft.blued.ui.find.manager.FilterNewHelper.c(java.lang.Integer, java.lang.Integer, android.content.Context):java.lang.String");
    }

    public final String[] c(Context context) {
        Intrinsics.e(context, "context");
        if (b) {
            String[] a2 = StringUtils.a(context);
            Intrinsics.c(a2, "getWeightAllData(context)");
            return a2;
        }
        String[] stringArray = context.getResources().getStringArray(R.array.weight_key_all);
        Intrinsics.c(stringArray, "context.resources.getStr…y(R.array.weight_key_all)");
        return stringArray;
    }

    public final String d() {
        return f;
    }

    public final String d(Integer num, Integer num2, Context context) {
        if (context == null || num == null) {
            return "";
        }
        int intValue = num.intValue();
        if (num2 == null) {
            return "";
        }
        num2.intValue();
        String string = context.getString(R.string.filter_new_mins);
        Intrinsics.c(string, "context.getString(R.string.filter_new_mins)");
        String[] d2 = f30593a.d(context);
        String string2 = context.getString(R.string.filter_new_below);
        Intrinsics.c(string2, "context.getString(R.string.filter_new_below)");
        String string3 = context.getString(R.string.filter_new_above);
        Intrinsics.c(string3, "context.getString(R.string.filter_new_above)");
        String str = "";
        if (intValue < d2.length) {
            str = "";
            if (num2.intValue() < d2.length) {
                String str2 = d2[intValue];
                String str3 = d2[num2.intValue()];
                if (f30593a.a(str2) && !f30593a.a(str3)) {
                    str2 = str3 + string + string2;
                    BluedPreferences.w(Intrinsics.a("0-", (Object) str3));
                } else if (!f30593a.a(str2) && f30593a.a(str3)) {
                    String str4 = str2 + string + string3;
                    BluedPreferences.w(Intrinsics.a(str2, (Object) "-max"));
                    return str4;
                } else if (!Intrinsics.a((Object) str2, (Object) str3)) {
                    BluedPreferences.w(str2 + '-' + str3);
                    str = str2 + " ～ " + str3 + string;
                } else if (f30593a.a(str2)) {
                    BluedPreferences.w("0-max");
                } else {
                    String a2 = Intrinsics.a(str2, (Object) string);
                    BluedPreferences.w(str2 + '-' + str3);
                    str = a2;
                }
                return str2;
            }
        }
        return str;
    }

    public final String[] d(Context context) {
        Intrinsics.e(context, "context");
        String[] stringArray = context.getResources().getStringArray(R.array.inch_online_time_list_all);
        Intrinsics.c(stringArray, "context.resources.getStr…nch_online_time_list_all)");
        return stringArray;
    }

    public final String e(Integer num, Integer num2, Context context) {
        if (context == null || num == null) {
            return "";
        }
        int intValue = num.intValue();
        if (num2 == null) {
            return "";
        }
        num2.intValue();
        String[] e2 = f30593a.e(context);
        String string = context.getString(R.string.filter_new_below);
        Intrinsics.c(string, "context.getString(R.string.filter_new_below)");
        String string2 = context.getString(R.string.filter_new_above);
        Intrinsics.c(string2, "context.getString(R.string.filter_new_above)");
        String str = "";
        if (intValue < e2.length) {
            str = "";
            if (num2.intValue() < e2.length) {
                String str2 = e2[intValue];
                String str3 = e2[num2.intValue()];
                if (f30593a.a(str2) && !f30593a.a(str3)) {
                    str2 = str3 + "km" + string;
                    BluedPreferences.v(Intrinsics.a("0-", (Object) str3));
                } else if (!f30593a.a(str2) && f30593a.a(str3)) {
                    String str4 = str2 + "km" + string2;
                    BluedPreferences.v(Intrinsics.a(str2, (Object) "-max"));
                    return str4;
                } else if (!Intrinsics.a((Object) str2, (Object) str3)) {
                    BluedPreferences.v(str2 + '-' + str3);
                    str = str2 + " ～ " + str3 + "km";
                } else if (f30593a.a(str2)) {
                    BluedPreferences.v("0-max");
                } else {
                    String a2 = Intrinsics.a(str2, (Object) "km");
                    BluedPreferences.v(str2 + '-' + str3);
                    str = a2;
                }
                return str2;
            }
        }
        return str;
    }

    public final boolean e() {
        if (UserInfo.getInstance().getLoginUserInfo().vip_grade != 0 || BluedConfig.a().g().is_filter_vip == 1) {
            return BluedPreferences.S();
        }
        return false;
    }

    public final String[] e(Context context) {
        Intrinsics.e(context, "context");
        String[] stringArray = context.getResources().getStringArray(R.array.inch_distance_list_all);
        Intrinsics.c(stringArray, "context.resources.getStr…y.inch_distance_list_all)");
        return stringArray;
    }

    public final boolean f() {
        if (UserInfo.getInstance().getLoginUserInfo().vip_grade != 0 || BluedConfig.a().g().is_filter_vip == 1) {
            String aa = BluedPreferences.aa();
            boolean z = false;
            if (!TextUtils.isEmpty(aa)) {
                z = false;
                if (!Intrinsics.a((Object) aa, (Object) "0-max")) {
                    z = true;
                }
            }
            return z;
        }
        return false;
    }

    public final boolean g() {
        if (UserInfo.getInstance().getLoginUserInfo().vip_grade != 0 || BluedConfig.a().g().is_filter_vip == 1) {
            String Z = BluedPreferences.Z();
            boolean z = false;
            if (!TextUtils.isEmpty(Z)) {
                z = false;
                if (!Intrinsics.a((Object) Z, (Object) "0-max")) {
                    z = true;
                }
            }
            return z;
        }
        return false;
    }

    public final boolean h() {
        String K = BluedPreferences.K();
        if (TextUtils.isEmpty(K)) {
            return false;
        }
        Context d2 = AppInfo.d();
        Intrinsics.c(d2, "getAppContext()");
        return !Intrinsics.a((Object) K, (Object) Intrinsics.a("0-", (Object) Integer.valueOf(a(d2).length - 1)));
    }

    public final boolean i() {
        String M = b ? BluedPreferences.M() : BluedPreferences.L();
        if (TextUtils.isEmpty(M)) {
            return false;
        }
        Context d2 = AppInfo.d();
        Intrinsics.c(d2, "getAppContext()");
        return !Intrinsics.a((Object) M, (Object) Intrinsics.a("0-", (Object) Integer.valueOf(b(d2).length - 1)));
    }

    public final boolean j() {
        String O = b ? BluedPreferences.O() : BluedPreferences.N();
        if (TextUtils.isEmpty(O)) {
            return false;
        }
        Context d2 = AppInfo.d();
        Intrinsics.c(d2, "getAppContext()");
        return !Intrinsics.a((Object) O, (Object) Intrinsics.a("0-", (Object) Integer.valueOf(c(d2).length - 1)));
    }

    public final void k() {
        CompletableJob a2;
        if (NetworkUtils.a()) {
            return;
        }
        a2 = JobKt__JobKt.a(null, 1, null);
        CoroutineScope a3 = CoroutineScopeKt.a(a2.plus(Dispatchers.b()));
        BuildersKt__Builders_commonKt.a(a3, null, null, new FilterNewHelper$preLoadImages$1(a3, null), 3, null);
    }
}
