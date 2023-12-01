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
    public static final ByteDanceLogUtils f20624a = new ByteDanceLogUtils();

    private ByteDanceLogUtils() {
    }

    public static final String a() {
        String did = AppLog.getDid();
        Intrinsics.c(did, "getDid()");
        return did;
    }

    @JvmStatic
    public static final void a(String str) {
        Intrinsics.a((Object) str);
        AppLog.onEventV3(str);
    }

    @JvmStatic
    public static final void a(String str, JSONObject jSONObject) {
        Intrinsics.a((Object) str);
        AppLog.onEventV3(str, jSONObject);
    }

    @JvmStatic
    public static final void a(HashMap<String, Object> map) {
        Intrinsics.e(map, "map");
        AppLog.setHeaderInfo(map);
    }

    public static final String b() {
        String ssid = AppLog.getSsid();
        Intrinsics.c(ssid, "getSsid()");
        return ssid;
    }

    public final boolean c() {
        String str = (String) AppLog.getAbConfig("profileRecommend", "");
        return !Intrinsics.a((Object) str, (Object) "controlGroup") && Intrinsics.a((Object) str, (Object) "experimentalGroup1");
    }
}
