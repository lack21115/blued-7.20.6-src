package com.blued.track.bytedance;

import com.bytedance.applog.AppLog;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata
/* loaded from: source-7206380-dex2jar.jar:com/blued/track/bytedance/ByteDanceLogUtils.class */
public final class ByteDanceLogUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final ByteDanceLogUtils f7018a = new ByteDanceLogUtils();

    private ByteDanceLogUtils() {
    }

    public static final String a() {
        String did = AppLog.getDid();
        Intrinsics.c(did, "getDid()");
        return did;
    }

    @JvmStatic
    public static final void a(String str) {
        Intrinsics.a(str);
        AppLog.onEventV3(str);
    }

    @JvmStatic
    public static final void a(String str, JSONObject jSONObject) {
        Intrinsics.a(str);
        AppLog.onEventV3(str, jSONObject);
    }

    @JvmStatic
    public static final void a(HashMap<String, Object> hashMap) {
        Intrinsics.e(hashMap, "map");
        AppLog.setHeaderInfo(hashMap);
    }

    public static final String b() {
        String ssid = AppLog.getSsid();
        Intrinsics.c(ssid, "getSsid()");
        return ssid;
    }

    public final boolean c() {
        String str = (String) AppLog.getAbConfig("profileRecommend", "");
        return !Intrinsics.a(str, "controlGroup") && Intrinsics.a(str, "experimentalGroup1");
    }
}
