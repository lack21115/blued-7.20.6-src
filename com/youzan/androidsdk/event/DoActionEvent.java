package com.youzan.androidsdk.event;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/androidsdk/event/DoActionEvent.class */
public class DoActionEvent implements Event {
    public static final String ACTION = "action";
    public static final String TAG = "DoActionEvent";

    /* renamed from: ˊ  reason: contains not printable characters */
    private EventCenter f1106;

    public DoActionEvent(EventCenter eventCenter) {
        this.f1106 = eventCenter;
    }

    @Override // com.youzan.androidsdk.event.Event
    public void call(Context context, String str) {
        try {
            String optString = new JSONObject(str).optString("action");
            if (TextUtils.isEmpty(optString)) {
                Log.e(TAG, "Action 异常");
            } else {
                this.f1106.dispatch(context, optString, str);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override // com.youzan.androidsdk.event.Event
    public String subscribe() {
        return "doAction";
    }
}
