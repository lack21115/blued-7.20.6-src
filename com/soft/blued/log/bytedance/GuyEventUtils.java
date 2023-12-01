package com.soft.blued.log.bytedance;

import android.text.TextUtils;
import com.anythink.expressad.foundation.d.l;
import com.blued.das.superexpose.SuperExposeProtos;
import com.blued.track.bytedance.ByteDanceLogUtils;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata
/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/log/bytedance/GuyEventUtils.class */
public final class GuyEventUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final GuyEventUtils f29688a = new GuyEventUtils();

    private GuyEventUtils() {
    }

    @JvmStatic
    public static final void a(int i, String couponId, int i2, int i3) {
        Intrinsics.e(couponId, "couponId");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("sku", i);
            jSONObject.put("coupon_id", couponId);
            jSONObject.put("strategy", i2);
            jSONObject.put("area", i3);
            ByteDanceLogUtils.a(SuperExposeProtos.Event.EXPOSE_BUY_PAGE_PAY_CLICK.name(), jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @JvmStatic
    public static final void a(String event) {
        Intrinsics.e(event, "event");
        ByteDanceLogUtils.a(event);
    }

    @JvmStatic
    public static final void a(String event, String target_uid) {
        Intrinsics.e(event, "event");
        Intrinsics.e(target_uid, "target_uid");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("target_uid", target_uid);
            ByteDanceLogUtils.a(event, jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @JvmStatic
    public static final void a(String source, String show_type, int i) {
        Intrinsics.e(source, "source");
        Intrinsics.e(show_type, "show_type");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("source", source);
            jSONObject.put("show_type", show_type);
            jSONObject.put(l.d, i);
            ByteDanceLogUtils.a("NEARBY_FRIEND_DRAW_MAX_NUM", jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @JvmStatic
    public static final void a(String sort_type, String str, String show_type, boolean z, boolean z2, boolean z3, boolean z4) {
        Intrinsics.e(sort_type, "sort_type");
        Intrinsics.e(show_type, "show_type");
        String str2 = str;
        if (TextUtils.isEmpty(str)) {
            str2 = "";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(com.anythink.core.common.l.ai, sort_type);
            jSONObject.put("target_uid", str2);
            jSONObject.put("show_type", show_type);
            jSONObject.put("call", z);
            jSONObject.put("special", z2);
            jSONObject.put("yy", z3);
            jSONObject.put("live", z4);
            ByteDanceLogUtils.a("NEARBY_FRIEND_PHOTO_DRAW", jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @JvmStatic
    public static final void b(String sort_type, String target_uid, String show_type, boolean z, boolean z2, boolean z3, boolean z4) {
        Intrinsics.e(sort_type, "sort_type");
        Intrinsics.e(target_uid, "target_uid");
        Intrinsics.e(show_type, "show_type");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(com.anythink.core.common.l.ai, sort_type);
            jSONObject.put("target_uid", target_uid);
            jSONObject.put("show_type", show_type);
            jSONObject.put("call", z);
            jSONObject.put("special", z2);
            jSONObject.put("yy", z3);
            jSONObject.put("live", z4);
            ByteDanceLogUtils.a("NEARBY_FRIEND_USER_PHOTO_CLICK", jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
