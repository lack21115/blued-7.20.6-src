package com.youzan.androidsdk.event;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/androidsdk/event/AbsChooserEvent.class */
public abstract class AbsChooserEvent implements Event {

    /* loaded from: source-8829756-dex2jar.jar:com/youzan/androidsdk/event/AbsChooserEvent$Meta.class */
    public static final class Meta {
        private static final String KEY_ACCEPT_TYPE = "accept_type";
        private static final String KEY_REQUEST_ID = "request_id";
        public String acceptType;
        public int requestId;

        public Meta() {
        }

        Meta(String str) throws JSONException {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(str);
            this.requestId = jSONObject.optInt("request_id");
            this.acceptType = jSONObject.optString(KEY_ACCEPT_TYPE);
        }

        public final String toJSON() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("request_id", String.valueOf(this.requestId));
                jSONObject.put(KEY_ACCEPT_TYPE, this.acceptType);
            } catch (JSONException e) {
            }
            return jSONObject.toString();
        }
    }

    public abstract void call(Context context, Intent intent, int i) throws ActivityNotFoundException;

    @Override // com.youzan.androidsdk.event.Event
    public final void call(Context context, String str) {
        try {
            Meta meta = new Meta(str);
            Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
            intent.setType(meta.acceptType);
            call(context, intent, meta.requestId);
        } catch (Exception e) {
        }
    }

    @Override // com.youzan.androidsdk.event.Event
    public String subscribe() {
        return EventAPI.EVENT_FILE_CHOOSER;
    }
}
