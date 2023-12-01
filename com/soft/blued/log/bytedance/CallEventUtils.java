package com.soft.blued.log.bytedance;

import com.blued.track.bytedance.ByteDanceLogUtils;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata
/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/log/bytedance/CallEventUtils.class */
public final class CallEventUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final CallEventUtils f29686a = new CallEventUtils();

    private CallEventUtils() {
    }

    @JvmStatic
    public static final void a(String vocative_source_page) {
        Intrinsics.e(vocative_source_page, "vocative_source_page");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vocative_source_page", vocative_source_page);
            ByteDanceLogUtils.a("HOME_GUY_PAGE_VOCATIVE_PRICE_WINDOW_SHOW", jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @JvmStatic
    public static final void a(String vocative_source_page, int i) {
        Intrinsics.e(vocative_source_page, "vocative_source_page");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vocative_source_page", vocative_source_page);
            jSONObject.put("sku", i);
            ByteDanceLogUtils.a("HOME_GUY_PAGE_VOCATIVE_PAY_BTN_CLICK", jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
