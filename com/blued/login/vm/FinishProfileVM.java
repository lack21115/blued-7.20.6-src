package com.blued.login.vm;

import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.collection.ArrayMap;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.anythink.core.common.g.c;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.utils.AesCrypto2;
import com.blued.android.module.common.base.mvvm.BaseViewModel;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.blued.android.module.device_identity.library.BluedDeviceIdentity;
import com.blued.login.auto.LoginServiceManager;
import com.blued.login.model.ProfileInfoModel;
import com.blued.login.utils.LoginPreferences;
import com.blued.track.bytedance.ByteDanceLogUtils;
import com.tencent.ugc.datereport.UGCDataReportDef;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

@Metadata
/* loaded from: source-7206380-dex2jar.jar:com/blued/login/vm/FinishProfileVM.class */
public final class FinishProfileVM extends BaseViewModel {

    /* renamed from: a  reason: collision with root package name */
    public ProfileInfoModel f20605a;
    public Context b;

    /* renamed from: c  reason: collision with root package name */
    private final MutableLiveData<String> f20606c = new MutableLiveData<>();

    public final void a(Context context) {
        Intrinsics.e(context, "<set-?>");
        this.b = context;
    }

    public final void a(ProfileInfoModel profileInfoModel) {
        Intrinsics.e(profileInfoModel, "<set-?>");
        this.f20605a = profileInfoModel;
    }

    public final void a(String token, String nick) {
        Intrinsics.e(token, "token");
        Intrinsics.e(nick, "nick");
        BuildersKt__Builders_commonKt.a(ViewModelKt.getViewModelScope(this), null, null, new FinishProfileVM$checkNick$1(token, nick, this, null), 3, null);
    }

    public final void b(ProfileInfoModel model) {
        Intrinsics.e(model, "model");
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put("token", model.g());
        arrayMap.put("password", "");
        String b = LoginServiceManager.a().b();
        Intrinsics.c(b, "getLoginService().deviceId");
        if (!TextUtils.isEmpty(b)) {
            arrayMap.put(UGCDataReportDef.DR_KEY_DEV_ID, b);
        }
        arrayMap.put("name", model.a());
        arrayMap.put("height", model.d());
        arrayMap.put("weight", model.e());
        arrayMap.put("role", model.f());
        arrayMap.put("birthday", model.c());
        String a2 = LoginPreferences.a();
        Intrinsics.c(a2, "getADRESS()");
        arrayMap.put("city_settled", a2);
        String b2 = LoginPreferences.b();
        Intrinsics.c(b2, "getLATITUDE()");
        arrayMap.put("lat", b2);
        String c2 = LoginPreferences.c();
        Intrinsics.c(c2, "getLONGITUDE()");
        arrayMap.put(c.C, c2);
        arrayMap.put("no_height_weight", "0");
        String h = model.h();
        if (h != null) {
            arrayMap.put("health_test_result", h);
        }
        String i = model.i();
        if (i != null) {
            arrayMap.put("health_test_time", i);
        }
        String j = model.j();
        if (j != null) {
            arrayMap.put("health_prpe_use_situation", j);
        }
        String mac = AppInfo.e;
        Intrinsics.c(mac, "mac");
        arrayMap.put("mac", mac);
        String IMEI = AppInfo.d;
        Intrinsics.c(IMEI, "IMEI");
        arrayMap.put("imei", IMEI);
        String channel = AppInfo.f9487c;
        Intrinsics.c(channel, "channel");
        arrayMap.put("channel", channel);
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
        String android_id = Settings.System.getString(AppInfo.d().getContentResolver(), "android_id");
        if (!TextUtils.isEmpty(android_id)) {
            Intrinsics.c(android_id, "android_id");
            arrayMap.put("android_id", android_id);
        }
        arrayMap.put("bddid", ByteDanceLogUtils.a());
        HashMap hashMap = new HashMap();
        try {
            String enS = AesCrypto2.b(AppInfo.f().toJson(arrayMap));
            Intrinsics.c(enS, "enS");
            hashMap.put(BridgeUtil.UNDERLINE_STR, enS);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        BuildersKt__Builders_commonKt.a(ViewModelKt.getViewModelScope(this), null, null, new FinishProfileVM$register$4(hashMap, model, this, null), 3, null);
    }

    public final MutableLiveData<String> d() {
        return this.f20606c;
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
