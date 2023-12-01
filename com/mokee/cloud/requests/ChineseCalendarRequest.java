package com.mokee.cloud.requests;

import android.os.SystemProperties;
import com.mokee.volley.AuthFailureError;
import com.mokee.volley.NetworkResponse;
import com.mokee.volley.ParseError;
import com.mokee.volley.Response;
import com.mokee.volley.VolleyError;
import com.mokee.volley.toolbox.HttpHeaderParser;
import com.mokee.volley.toolbox.StringRequest;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-4181928-dex2jar.jar:com/mokee/cloud/requests/ChineseCalendarRequest.class */
public class ChineseCalendarRequest extends StringRequest {
    public static final int CALENDAR_REQUEST_MAX_RETRIES = 3;
    public static final int CALENDAR_REQUEST_TIMEOUT = 5000;
    public static boolean q;
    private static final String[] r = null;

    static {
        String[] strArr = new String[5];
        throw new VerifyError("bad dex opcode");
    }

    public ChineseCalendarRequest(int i, String str, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        super(i, str, listener, errorListener);
    }

    @Override // com.mokee.volley.Request
    public Map<String, String> getHeaders() throws AuthFailureError {
        boolean z = false;
        boolean z2 = q;
        HashMap hashMap = new HashMap();
        try {
            hashMap.put(r[0], r[1]);
            if (VolleyError.b) {
                if (!z2) {
                    z = true;
                }
                q = z;
            }
            return hashMap;
        } catch (AuthFailureError e) {
            try {
                throw e;
            } catch (AuthFailureError e2) {
                throw e2;
            }
        }
    }

    @Override // com.mokee.volley.Request
    protected Map<String, String> getParams() throws AuthFailureError {
        boolean z = q;
        HashMap hashMap = new HashMap();
        try {
            hashMap.put(r[4], SystemProperties.get(r[3]));
            if (z) {
                VolleyError.b = !VolleyError.b;
            }
            return hashMap;
        } catch (AuthFailureError e) {
            try {
                throw e;
            } catch (AuthFailureError e2) {
                throw e2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mokee.volley.toolbox.StringRequest, com.mokee.volley.Request
    public Response<String> parseNetworkResponse(NetworkResponse networkResponse) {
        try {
            return Response.success(new String(networkResponse.data, r[2]), HttpHeaderParser.parseCacheHeaders(networkResponse));
        } catch (UnsupportedEncodingException e) {
            return Response.error(new ParseError(e));
        }
    }
}
