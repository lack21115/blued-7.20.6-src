package com.soft.blued.log.bytedance;

import com.blued.das.message.MessageProtos;
import com.blued.track.bytedance.ByteDanceLogUtils;
import com.bytedance.sdk.openadsdk.live.TTLiveConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata
/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/log/bytedance/MessageEventUtils.class */
public final class MessageEventUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final MessageEventUtils f15999a = new MessageEventUtils();

    private MessageEventUtils() {
    }

    @JvmStatic
    public static final void a() {
        try {
            ByteDanceLogUtils.a("APP_MSG_TAB_CLICK");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @JvmStatic
    public static final void a(MessageProtos.Event event, String str, String str2) {
        Intrinsics.e(event, "event");
        Intrinsics.e(str, "room_uid");
        Intrinsics.e(str2, TTLiveConstants.ROOMID_KEY);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("room_uid", str);
            jSONObject.put(TTLiveConstants.ROOMID_KEY, str2);
            ByteDanceLogUtils.a(event.name(), jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @JvmStatic
    public static final void a(String str) {
        Intrinsics.e(str, "status");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("status", str);
            ByteDanceLogUtils.a("MSG_VOCATIV_BTN_CLICK", jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(16:1|(1:3)(1:37)|4|(2:6|(12:8|9|(2:11|(9:13|14|(2:16|(1:18)(1:33))(1:34)|19|(1:21)|22|23|24|(2:26|27)(1:29)))|35|14|(0)(0)|19|(0)|22|23|24|(0)(0)))|36|9|(0)|35|14|(0)(0)|19|(0)|22|23|24|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0135, code lost:
        r7 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0136, code lost:
        r7.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    @kotlin.jvm.JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void a(java.lang.String r7, java.lang.String r8, com.blued.android.module.common.log.oldtrack.LogData r9) {
        /*
            Method dump skipped, instructions count: 341
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soft.blued.log.bytedance.MessageEventUtils.a(java.lang.String, java.lang.String, com.blued.android.module.common.log.oldtrack.LogData):void");
    }

    @JvmStatic
    public static final void b(String str) {
        Intrinsics.e(str, "url");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("url", str);
            ByteDanceLogUtils.a("BLUED_MSG_CLICK", jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @JvmStatic
    public static final void c(String str) {
        Intrinsics.e(str, "event");
        ByteDanceLogUtils.a(str);
    }
}
