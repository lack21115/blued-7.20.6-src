package com.oplus.quickgame.sdk.engine.callback;

import android.database.Cursor;
import com.oplus.quickgame.sdk.engine.utils.k;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/oplus/quickgame/sdk/engine/callback/Callback.class */
public abstract class Callback {

    /* loaded from: source-8303388-dex2jar.jar:com/oplus/quickgame/sdk/engine/callback/Callback$Response.class */
    public static class Response {
        public static final int DENIED = -8;
        public static final int ENGINE_VERSION_TOO_LOW = -16;
        public static final int FAIL = -4;
        public static final int SUCCESS = 1;
        public static final int UPDATE_CANCEL = -11;
        public static final String UPDATE_CANCEL_MESSAGE = "platform need update but user canceled";
        public static final int UPDATE_ERROR = -10;
        public static final String UPDATE_ERROR_MESSAGE = "platform need update but error occurred";
        public static final int UPDATE_SUCCESS = 10;
        public static final String UPDATE_SUCCESS_MESSAGE = "platform update success, please call request again";

        /* renamed from: a  reason: collision with root package name */
        int f24399a;
        String b;

        /* renamed from: c  reason: collision with root package name */
        Map<String, Object> f24400c = new HashMap();

        public int getCode() {
            return this.f24399a;
        }

        public String getMsg() {
            return this.b;
        }

        public Map<String, Object> getParams() {
            return this.f24400c;
        }

        public void putParams(Map<String, Object> map) {
            this.f24400c.putAll(map);
        }

        public void setCode(int i) {
            this.f24399a = i;
        }

        public void setMsg(String str) {
            this.b = str;
        }

        public String toString() {
            return this.f24399a + "#" + this.b;
        }
    }

    public abstract void onResponse(Response response);

    public void onResponse(Map<String, Object> map, Cursor cursor) {
        Map<String, Object> b = k.b(cursor);
        Response response = new Response();
        if (b != null) {
            response.f24399a = Long.valueOf(((Long) b.get("code")).longValue()).intValue();
            response.b = (String) b.get("msg");
            response.putParams(b);
        } else {
            response.f24399a = -1;
            response.b = "fail to get response";
        }
        onResponse(response);
    }
}
