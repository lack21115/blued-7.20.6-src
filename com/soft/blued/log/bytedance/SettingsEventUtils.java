package com.soft.blued.log.bytedance;

import com.blued.track.bytedance.ByteDanceLogUtils;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata
/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/log/bytedance/SettingsEventUtils.class */
public final class SettingsEventUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final SettingsEventUtils f29691a = new SettingsEventUtils();

    private SettingsEventUtils() {
    }

    @JvmStatic
    public static final void a(String eventName, String str) {
        Intrinsics.e(eventName, "eventName");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("link_url", str);
            ByteDanceLogUtils.a(eventName, jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
