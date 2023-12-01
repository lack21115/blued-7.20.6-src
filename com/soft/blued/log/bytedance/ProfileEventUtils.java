package com.soft.blued.log.bytedance;

import com.blued.track.bytedance.ByteDanceLogUtils;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata
/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/log/bytedance/ProfileEventUtils.class */
public final class ProfileEventUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final ProfileEventUtils f16000a = new ProfileEventUtils();

    private ProfileEventUtils() {
    }

    @JvmStatic
    public static final void a(String str) {
        Intrinsics.e(str, "event");
        ByteDanceLogUtils.a(str);
    }

    @JvmStatic
    public static final void a(String str, String str2) {
        Intrinsics.e(str, "eventName");
        Intrinsics.e(str2, "target_uid");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("target_uid", str2);
            ByteDanceLogUtils.a(str, jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @JvmStatic
    public static final void a(String str, String str2, String str3, String str4, String str5) {
        Intrinsics.e(str, "source");
        Intrinsics.e(str3, "is_follow");
        Intrinsics.e(str4, "is_appreciate_call");
        Intrinsics.e(str5, "is_exposure");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("source", str);
            jSONObject.put("target_uid", str2);
            jSONObject.put("is_follow", str3);
            jSONObject.put("is_appreciate_call", str4);
            jSONObject.put("is_exposure", str5);
            ByteDanceLogUtils.a("PERSONAL_PROFILE_FOLLOWED_BTN_CLICK", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
