package com.mokee.volley.toolbox;

import com.mokee.volley.NetworkResponse;
import com.mokee.volley.Request;
import com.mokee.volley.Response;
import com.mokee.volley.VolleyLog;
import java.io.UnsupportedEncodingException;

/* loaded from: source-4181928-dex2jar.jar:com/mokee/volley/toolbox/JsonRequest.class */
public abstract class JsonRequest<T> extends Request<T> {
    private static final String r = null;
    private static final String[] s = null;
    private final String p;
    private final Response.Listener<T> q;

    static {
        String[] strArr = new String[3];
        throw new VerifyError("bad dex opcode");
    }

    public JsonRequest(int i, String str, String str2, Response.Listener<T> listener, Response.ErrorListener errorListener) {
        super(i, str, errorListener);
        this.q = listener;
        this.p = str2;
    }

    public JsonRequest(String str, String str2, Response.Listener<T> listener, Response.ErrorListener errorListener) {
        this(-1, str, str2, listener, errorListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mokee.volley.Request
    public void deliverResponse(T t) {
        this.q.onResponse(t);
    }

    @Override // com.mokee.volley.Request
    public byte[] getBody() {
        try {
            try {
                if (this.p == null) {
                    return null;
                }
                return this.p.getBytes(s[2]);
            } catch (UnsupportedEncodingException e) {
                throw e;
            }
        } catch (UnsupportedEncodingException e2) {
            VolleyLog.wtf(s[0], this.p, s[1]);
            return null;
        }
    }

    @Override // com.mokee.volley.Request
    public String getBodyContentType() {
        return r;
    }

    @Override // com.mokee.volley.Request
    public byte[] getPostBody() {
        return getBody();
    }

    @Override // com.mokee.volley.Request
    public String getPostBodyContentType() {
        return getBodyContentType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mokee.volley.Request
    public abstract Response<T> parseNetworkResponse(NetworkResponse networkResponse);
}
