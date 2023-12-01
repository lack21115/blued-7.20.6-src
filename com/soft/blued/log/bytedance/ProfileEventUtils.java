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
    public static final ProfileEventUtils f29690a = new ProfileEventUtils();

    private ProfileEventUtils() {
    }

    @JvmStatic
    public static final void a(String event) {
        Intrinsics.e(event, "event");
        ByteDanceLogUtils.a(event);
    }

    @JvmStatic
    public static final void a(String eventName, String target_uid) {
        Intrinsics.e(eventName, "eventName");
        Intrinsics.e(target_uid, "target_uid");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("target_uid", target_uid);
            ByteDanceLogUtils.a(eventName, jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @JvmStatic
    public static final void a(String source, String str, String is_follow, String is_appreciate_call, String is_exposure) {
        Intrinsics.e(source, "source");
        Intrinsics.e(is_follow, "is_follow");
        Intrinsics.e(is_appreciate_call, "is_appreciate_call");
        Intrinsics.e(is_exposure, "is_exposure");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("source", source);
            jSONObject.put("target_uid", str);
            jSONObject.put("is_follow", is_follow);
            jSONObject.put("is_appreciate_call", is_appreciate_call);
            jSONObject.put("is_exposure", is_exposure);
            ByteDanceLogUtils.a("PERSONAL_PROFILE_FOLLOWED_BTN_CLICK", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
