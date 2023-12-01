package com.mokee.volley.toolbox;

import com.mokee.volley.NetworkResponse;
import com.mokee.volley.Request;
import com.mokee.volley.Response;
import java.io.UnsupportedEncodingException;

/* loaded from: source-4181928-dex2jar.jar:com/mokee/volley/toolbox/StringRequest.class */
public class StringRequest extends Request<String> {
    private final Response.Listener<String> p;

    public StringRequest(int i, String str, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        super(i, str, errorListener);
        this.p = listener;
    }

    public StringRequest(String str, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        this(0, str, listener, errorListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mokee.volley.Request
    public void deliverResponse(String str) {
        this.p.onResponse(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mokee.volley.Request
    public Response<String> parseNetworkResponse(NetworkResponse networkResponse) {
        String str;
        try {
            str = new String(networkResponse.data, HttpHeaderParser.parseCharset(networkResponse.headers));
        } catch (UnsupportedEncodingException e) {
            str = new String(networkResponse.data);
        }
        return Response.success(str, HttpHeaderParser.parseCacheHeaders(networkResponse));
    }
}
