package com.blued.login.vm;

import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.collection.ArrayMap;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.anythink.pd.ExHandler;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.utils.AesCrypto2;
import com.blued.android.module.common.base.mvvm.BaseViewModel;
import com.blued.android.module.device_identity.library.BluedDeviceIdentity;
import com.blued.login.auto.LoginServiceManager;
import com.blued.login.model.ProfileInfoModel;
import com.blued.login.utils.LoginPreferences;
import com.blued.track.bytedance.ByteDanceLogUtils;
import com.sina.weibo.sdk.constant.WBPageConstants;
import com.tencent.tendinsv.a.b;
import com.tencent.ugc.datereport.UGCDataReportDef;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;

@Metadata
/* loaded from: source-7206380-dex2jar.jar:com/blued/login/vm/FinishProfileVM.class */
public final class FinishProfileVM extends BaseViewModel {

    /* renamed from: a  reason: collision with root package name */
    public ProfileInfoModel f6999a;
    public Context b;

    /* renamed from: c  reason: collision with root package name */
    private final MutableLiveData<String> f7000c = new MutableLiveData<>();

    public final void a(Context context) {
        Intrinsics.e(context, "<set-?>");
        this.b = context;
    }

    public final void a(ProfileInfoModel profileInfoModel) {
        Intrinsics.e(profileInfoModel, "<set-?>");
        this.f6999a = profileInfoModel;
    }

    public final void a(String str, String str2) {
        Intrinsics.e(str, "token");
        Intrinsics.e(str2, WBPageConstants.ParamKey.NICK);
        BuildersKt.a(ViewModelKt.getViewModelScope((ViewModel) this), (CoroutineContext) null, (CoroutineStart) null, new FinishProfileVM$checkNick$1(str, str2, this, null), 3, (Object) null);
    }

    public final void b(ProfileInfoModel profileInfoModel) {
        Intrinsics.e(profileInfoModel, "model");
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put("token", profileInfoModel.g());
        arrayMap.put("password", "");
        String b = LoginServiceManager.a().b();
        Intrinsics.c(b, "getLoginService().deviceId");
        if (!TextUtils.isEmpty(b)) {
            arrayMap.put(UGCDataReportDef.DR_KEY_DEV_ID, b);
        }
        arrayMap.put("name", profileInfoModel.a());
        arrayMap.put("height", profileInfoModel.d());
        arrayMap.put("weight", profileInfoModel.e());
        arrayMap.put("role", profileInfoModel.f());
        arrayMap.put("birthday", profileInfoModel.c());
        String a2 = LoginPreferences.a();
        Intrinsics.c(a2, "getADRESS()");
        arrayMap.put("city_settled", a2);
        String b2 = LoginPreferences.b();
        Intrinsics.c(b2, "getLATITUDE()");
        arrayMap.put("lat", b2);
        String c2 = LoginPreferences.c();
        Intrinsics.c(c2, "getLONGITUDE()");
        arrayMap.put("lon", c2);
        arrayMap.put("no_height_weight", "0");
        String h = profileInfoModel.h();
        if (h != null) {
            arrayMap.put("health_test_result", h);
        }
        String i = profileInfoModel.i();
        if (i != null) {
            arrayMap.put("health_test_time", i);
        }
        String j = profileInfoModel.j();
        if (j != null) {
            arrayMap.put("health_prpe_use_situation", j);
        }
        String str = AppInfo.e;
        Intrinsics.c(str, "mac");
        arrayMap.put("mac", str);
        String str2 = AppInfo.d;
        Intrinsics.c(str2, b.a.f25299c);
        arrayMap.put(ExHandler.JSON_REQUEST_IMEI, str2);
        String str3 = AppInfo.c;
        Intrinsics.c(str3, "channel");
        arrayMap.put("channel", str3);
        String d = BluedDeviceIdentity.a().d();
        Intrinsics.c(d, "getInstance().shumengId");
        arrayMap.put("dev_dna", d);
        String e = BluedDeviceIdentity.a().e();
        Intrinsics.c(e, "getInstance().shumengDeviceLabel");
        arrayMap.put("dev_dna_label", e);
        String f = BluedDeviceIdentity.a().f();
        Intrinsics.c(f, "getInstance().shumeiId");
        arrayMap.put("smid", f);
        String g = BluedDeviceIdentity.a().g();
        Intrinsics.c(g, "getInstance().shumeiBoxId");
        arrayMap.put("boxid", g);
        String h2 = BluedDeviceIdentity.a().h();
        Intrinsics.c(h2, "getInstance().oaid");
        arrayMap.put("oaid", h2);
        String string = Settings.System.getString(AppInfo.d().getContentResolver(), "android_id");
        if (!TextUtils.isEmpty(string)) {
            Intrinsics.c(string, "android_id");
            arrayMap.put("android_id", string);
        }
        arrayMap.put("bddid", ByteDanceLogUtils.a());
        HashMap hashMap = new HashMap();
        try {
            String b3 = AesCrypto2.b(AppInfo.f().toJson(arrayMap));
            Intrinsics.c(b3, "enS");
            hashMap.put("_", b3);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        BuildersKt.a(ViewModelKt.getViewModelScope((ViewModel) this), (CoroutineContext) null, (CoroutineStart) null, new FinishProfileVM$register$4(hashMap, profileInfoModel, this, null), 3, (Object) null);
    }

    public final MutableLiveData<String> d() {
        return this.f7000c;
    }

    public final Context getContext() {
        Context context = this.b;
        if (context != null) {
            return context;
        }
        Intrinsics.c("context");
        return null;
    }
}
