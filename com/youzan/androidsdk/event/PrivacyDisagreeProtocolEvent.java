package com.youzan.androidsdk.event;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.openalliance.ad.constant.bc;
import com.youzan.androidsdk.ui.YouzanClient;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/androidsdk/event/PrivacyDisagreeProtocolEvent.class */
public abstract class PrivacyDisagreeProtocolEvent implements Event {

    /* renamed from: ˊ  reason: contains not printable characters */
    private final YouzanClient f1108;

    public PrivacyDisagreeProtocolEvent(YouzanClient youzanClient) {
        this.f1108 = youzanClient;
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
                if (TextUtils.isEmpty(optString) || (youzanClient3 = this.f1108) == null) {
                    return;
                }
                youzanClient3.loadUrl("javascript:" + optString + "(" + call + ")");
            } catch (JSONException e) {
                z2 = z;
                e.printStackTrace();
                if (TextUtils.isEmpty(null) || (youzanClient = this.f1108) == null) {
                    return;
                }
                youzanClient.loadUrl("javascript:" + ((String) null) + "(" + z + ")");
            }
        } catch (Throwable th) {
            if (!TextUtils.isEmpty(null) && (youzanClient2 = this.f1108) != null) {
                youzanClient2.loadUrl("javascript:" + ((String) null) + "(" + z2 + ")");
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
