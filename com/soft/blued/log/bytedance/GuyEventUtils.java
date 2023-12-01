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
    public static final GuyEventUtils f15998a = new GuyEventUtils();

    private GuyEventUtils() {
    }

    @JvmStatic
    public static final void a(int i, String str, int i2, int i3) {
        Intrinsics.e(str, "couponId");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("sku", i);
            jSONObject.put("coupon_id", str);
            jSONObject.put("strategy", i2);
            jSONObject.put("area", i3);
            ByteDanceLogUtils.a(SuperExposeProtos.Event.EXPOSE_BUY_PAGE_PAY_CLICK.name(), jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @JvmStatic
    public static final void a(String str) {
        Intrinsics.e(str, "event");
        ByteDanceLogUtils.a(str);
    }

    @JvmStatic
    public static final void a(String str, String str2) {
        Intrinsics.e(str, "event");
        Intrinsics.e(str2, "target_uid");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("target_uid", str2);
            ByteDanceLogUtils.a(str, jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @JvmStatic
    public static final void a(String str, String str2, int i) {
        Intrinsics.e(str, "source");
        Intrinsics.e(str2, "show_type");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("source", str);
            jSONObject.put("show_type", str2);
            jSONObject.put(l.d, i);
            ByteDanceLogUtils.a("NEARBY_FRIEND_DRAW_MAX_NUM", jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @JvmStatic
    public static final void a(String str, String str2, String str3, boolean z, boolean z2, boolean z3, boolean z4) {
        Intrinsics.e(str, "sort_type");
        Intrinsics.e(str3, "show_type");
        String str4 = str2;
        if (TextUtils.isEmpty(str2)) {
            str4 = "";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("sort_type", str);
            jSONObject.put("target_uid", str4);
            jSONObject.put("show_type", str3);
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
    public static final void b(String str, String str2, String str3, boolean z, boolean z2, boolean z3, boolean z4) {
        Intrinsics.e(str, "sort_type");
        Intrinsics.e(str2, "target_uid");
        Intrinsics.e(str3, "show_type");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("sort_type", str);
            jSONObject.put("target_uid", str2);
            jSONObject.put("show_type", str3);
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
