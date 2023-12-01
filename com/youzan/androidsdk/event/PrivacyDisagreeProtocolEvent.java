package com.youzan.androidsdk.event;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.applog.util.WebViewJsUtil;
import com.huawei.openalliance.ad.constant.bc;
import com.youzan.androidsdk.ui.YouzanClient;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/androidsdk/event/PrivacyDisagreeProtocolEvent.class */
public abstract class PrivacyDisagreeProtocolEvent implements Event {

    /* renamed from: ˊ  reason: contains not printable characters */
    private final YouzanClient f1061;

    public PrivacyDisagreeProtocolEvent(YouzanClient youzanClient) {
        this.f1061 = youzanClient;
    }

    public static String injectSupportPrivacyDisagreeProtocol() {
        return "javascript:window.supportAppSdkDisagreeProtocol=true;";
    }

    @Override // com.youzan.androidsdk.event.Event
    public final void call(Context context, String str) {
        YouzanClient youzanClient;
        YouzanClient youzanClient2;
        YouzanClient youzanClient3;
        boolean z = false;
        boolean z2 = false;
        try {
            try {
                boolean call = call(context);
                z2 = call;
                z = call;
                String optString = new JSONObject(str).optString(bc.e.D);
                if (TextUtils.isEmpty(optString) || (youzanClient3 = this.f1061) == null) {
                    return;
                }
                youzanClient3.loadUrl(WebViewJsUtil.JS_URL_PREFIX + optString + "(" + call + ")");
            } catch (JSONException e) {
                z2 = z;
                e.printStackTrace();
                if (TextUtils.isEmpty(null) || (youzanClient = this.f1061) == null) {
                    return;
                }
                youzanClient.loadUrl(WebViewJsUtil.JS_URL_PREFIX + ((String) null) + "(" + z + ")");
            }
        } catch (Throwable th) {
            if (!TextUtils.isEmpty(null) && (youzanClient2 = this.f1061) != null) {
                youzanClient2.loadUrl(WebViewJsUtil.JS_URL_PREFIX + ((String) null) + "(" + z2 + ")");
            }
            throw th;
        }
    }

    public abstract boolean call(Context context);

    @Override // com.youzan.androidsdk.event.Event
    public String subscribe() {
        return EventAPI.EVENT_INVOKE_DISAGREE_PROTOCOL;
    }
}
