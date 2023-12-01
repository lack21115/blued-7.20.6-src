package com.youzan.androidsdk.event;

import android.content.Context;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/androidsdk/event/AbsAuthorizationErrorEvent.class */
public abstract class AbsAuthorizationErrorEvent implements Event {
    public abstract void call(Context context, int i, String str);

    @Override // com.youzan.androidsdk.event.Event
    public final void call(Context context, String str) {
        int i;
        String str2;
        String str3 = "";
        try {
            JSONObject jSONObject = new JSONObject(str);
            str2 = jSONObject.optString("msg");
            str3 = str2;
            i = jSONObject.optInt("code");
        } catch (JSONException e) {
            e.printStackTrace();
            i = 0;
            str2 = str3;
        }
        call(context, i, str2);
    }

    @Override // com.youzan.androidsdk.event.Event
    public String subscribe() {
        return EventAPI.EVENT_AUTHORIZATION_ERROR;
    }
}
