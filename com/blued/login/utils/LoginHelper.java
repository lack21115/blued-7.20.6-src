package com.blued.login.utils;

import android.content.Context;
import android.provider.SearchIndexablesContract;
import android.view.animation.Animation;
import android.view.animation.CycleInterpolator;
import android.view.animation.TranslateAnimation;
import androidx.collection.ArrayMap;
import com.blued.android.core.AppInfo;
import com.blued.das.login.LoginAndRegisterProtos;
import com.blued.login.R;
import com.blued.login.auto.LoginServiceManager;
import com.blued.login.model.ProfileInfoModel;
import com.google.gson.Gson;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-7206380-dex2jar.jar:com/blued/login/utils/LoginHelper.class */
public final class LoginHelper {
    private static ProfileInfoModel b;

    /* renamed from: a  reason: collision with root package name */
    public static final LoginHelper f6984a = new LoginHelper();

    /* renamed from: c  reason: collision with root package name */
    private static final String[] f6985c = {AppInfo.d().getString(R.string.login_constellation_sp), AppInfo.d().getString(R.string.login_constellation_sy), AppInfo.d().getString(R.string.login_constellation_by), AppInfo.d().getString(R.string.login_constellation_jn), AppInfo.d().getString(R.string.login_constellation_shuang_zi), AppInfo.d().getString(R.string.login_constellation_jx), AppInfo.d().getString(R.string.login_constellation_sz), AppInfo.d().getString(R.string.login_constellation_cn), AppInfo.d().getString(R.string.login_constellation_tp), AppInfo.d().getString(R.string.login_constellation_tx), AppInfo.d().getString(R.string.login_constellation_ss), AppInfo.d().getString(R.string.login_constellation_mj)};
    private static final int[] d = {20, 19, 21, 21, 21, 22, 23, 23, 23, 23, 22, 22};

    private LoginHelper() {
    }

    @JvmStatic
    public static final void b(ProfileInfoModel profileInfoModel) {
        Intrinsics.e(profileInfoModel, "model");
        b = profileInfoModel;
    }

    public final Animation a(int i) {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 10.0f, 0.0f, 0.0f);
        translateAnimation.setInterpolator(new CycleInterpolator(i));
        translateAnimation.setDuration(400L);
        return translateAnimation;
    }

    public final LoginAndRegisterProtos.Source a(ProfileInfoModel profileInfoModel) {
        if (profileInfoModel != null) {
            if (profileInfoModel.k() == 0) {
                return LoginAndRegisterProtos.Source.EMAIL;
            }
            if (profileInfoModel.k() == 1) {
                return LoginAndRegisterProtos.Source.PHONE;
            }
            if (profileInfoModel.k() == 2) {
                return profileInfoModel.l() != LoginAndRegisterProtos.Source.ONE_CLICK ? LoginAndRegisterProtos.Source.WECHAT : LoginAndRegisterProtos.Source.ONE_CLICK;
            }
        }
        return LoginAndRegisterProtos.Source.UNKNOWN_SOURCE;
    }

    public final ProfileInfoModel a() {
        return b;
    }

    public final String a(int i, int i2) {
        int i3 = i;
        if (i2 < d[i]) {
            i3 = i - 1;
        }
        if (i3 >= 0) {
            String str = f6985c[i3];
            Intrinsics.c(str, "constellationArray[m]");
            return str;
        }
        String str2 = f6985c[11];
        Intrinsics.c(str2, "constellationArray[11]");
        return str2;
    }

    public final String a(String str, String str2, String str3) {
        Intrinsics.e(str, "access_token");
        Intrinsics.e(str2, SearchIndexablesContract.RawData.COLUMN_USER_ID);
        Intrinsics.e(str3, "three_type");
        Gson f = AppInfo.f();
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put("access_token", str);
        arrayMap.put(SearchIndexablesContract.RawData.COLUMN_USER_ID, str2);
        arrayMap.put("three_type", str3);
        String json = f.toJson(arrayMap);
        Intrinsics.c(json, "gson.toJson(hashMap)");
        return json;
    }

    public final void a(Context context) {
        LoginServiceManager.a().b(context);
    }
}
