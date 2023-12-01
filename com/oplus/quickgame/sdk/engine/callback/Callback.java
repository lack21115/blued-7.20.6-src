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
        int f10712a;
        String b;

        /* renamed from: c  reason: collision with root package name */
        Map<String, Object> f10713c = new HashMap();

        public int getCode() {
            return this.f10712a;
        }

        public String getMsg() {
            return this.b;
        }

        public Map<String, Object> getParams() {
            return this.f10713c;
        }

        public void putParams(Map<String, Object> map) {
            this.f10713c.putAll(map);
        }

        public void setCode(int i) {
            this.f10712a = i;
        }

        public void setMsg(String str) {
            this.b = str;
        }

        public String toString() {
            return this.f10712a + "#" + this.b;
        }
    }

    public abstract void onResponse(Response response);

    public void onResponse(Map<String, Object> map, Cursor cursor) {
        Map<String, Object> b = k.b(cursor);
        Response response = new Response();
        if (b != null) {
            response.f10712a = Long.valueOf(((Long) b.get("code")).longValue()).intValue();
            response.b = (String) b.get("msg");
            response.putParams(b);
        } else {
            response.f10712a = -1;
            response.b = "fail to get response";
        }
        onResponse(response);
    }
}
