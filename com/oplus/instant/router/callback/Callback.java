package com.oplus.instant.router.callback;

import android.database.Cursor;
import com.oplus.instant.router.g.f;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/oplus/instant/router/callback/Callback.class */
public abstract class Callback {

    /* loaded from: source-8303388-dex2jar.jar:com/oplus/instant/router/callback/Callback$Response.class */
    public static class Response {
        public static final int DENIED = -8;
        public static final int FAIL = -4;
        public static final int SUCCESS = 1;
        public static final int UPDATE_CANCEL = -11;
        public static final String UPDATE_CANCEL_MESSAGE = "platform need update but user canceled";
        public static final int UPDATE_ERROR = -10;
        public static final String UPDATE_ERROR_MESSAGE = "platform need update but error occurred";
        public static final int UPDATE_SUCCESS = 10;
        public static final String UPDATE_SUCCESS_MESSAGE = "platform update success, please call request again";

        /* renamed from: a  reason: collision with root package name */
        int f24281a;
        String b;

        public int getCode() {
            return this.f24281a;
        }

        public String getMsg() {
            return this.b;
        }

        public void setCode(int i) {
            this.f24281a = i;
        }

        public void setMsg(String str) {
            this.b = str;
        }

        public String toString() {
            return this.f24281a + "#" + this.b;
        }
    }

    public abstract void onResponse(Response response);

    public void onResponse(Map<String, Object> map, Cursor cursor) {
        String str;
        Object obj;
        Map<String, Object> a2 = f.a(cursor);
        Response response = new Response();
        if (a2 == null || (obj = a2.get("code")) == null) {
            response.f24281a = -1;
            str = "fail to get response";
        } else {
            response.f24281a = Long.valueOf(((Long) obj).longValue()).intValue();
            str = (String) a2.get("msg");
        }
        response.b = str;
        onResponse(response);
    }
}
