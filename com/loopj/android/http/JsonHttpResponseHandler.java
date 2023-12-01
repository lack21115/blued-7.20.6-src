package com.loopj.android.http;

import android.util.Log;
import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/loopj/android/http/JsonHttpResponseHandler.class */
public class JsonHttpResponseHandler extends TextHttpResponseHandler {
    private static final String LOG_TAG = "JsonHttpResponseHandler";

    public JsonHttpResponseHandler() {
        super("UTF-8");
    }

    public JsonHttpResponseHandler(String str) {
        super(str);
    }

    @Override // com.loopj.android.http.TextHttpResponseHandler
    public void onFailure(int i, Header[] headerArr, String str, Throwable th) {
        Log.w(LOG_TAG, "onFailure(int, Header[], String, Throwable) was not overriden, but callback was received", th);
    }

    public void onFailure(int i, Header[] headerArr, Throwable th, JSONArray jSONArray) {
        Log.w(LOG_TAG, "onFailure(int, Header[], Throwable, JSONArray) was not overriden, but callback was received", th);
    }

    public void onFailure(int i, Header[] headerArr, Throwable th, JSONObject jSONObject) {
        Log.w(LOG_TAG, "onFailure(int, Header[], Throwable, JSONObject) was not overriden, but callback was received", th);
    }

    @Override // com.loopj.android.http.TextHttpResponseHandler, com.loopj.android.http.AsyncHttpResponseHandler
    public final void onFailure(final int i, final Header[] headerArr, final byte[] bArr, final Throwable th) {
        if (bArr == null) {
            Log.v(LOG_TAG, "response body is null, calling onFailure(Throwable, JSONObject)");
            onFailure(i, headerArr, th, (JSONObject) null);
            return;
        }
        Runnable runnable = new Runnable() { // from class: com.loopj.android.http.JsonHttpResponseHandler.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    final Object parseResponse = JsonHttpResponseHandler.this.parseResponse(bArr);
                    JsonHttpResponseHandler.this.postRunnable(new Runnable() { // from class: com.loopj.android.http.JsonHttpResponseHandler.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Object obj = parseResponse;
                            if (obj instanceof JSONObject) {
                                JsonHttpResponseHandler.this.onFailure(i, headerArr, th, (JSONObject) parseResponse);
                            } else if (obj instanceof JSONArray) {
                                JsonHttpResponseHandler.this.onFailure(i, headerArr, th, (JSONArray) parseResponse);
                            } else if (obj instanceof String) {
                                JsonHttpResponseHandler.this.onFailure(i, headerArr, (String) parseResponse, th);
                            } else {
                                JsonHttpResponseHandler jsonHttpResponseHandler = JsonHttpResponseHandler.this;
                                int i2 = i;
                                Header[] headerArr2 = headerArr;
                                jsonHttpResponseHandler.onFailure(i2, headerArr2, new JSONException("Unexpected response type " + parseResponse.getClass().getName()), (JSONObject) null);
                            }
                        }
                    });
                } catch (JSONException e) {
                    JsonHttpResponseHandler.this.postRunnable(new Runnable() { // from class: com.loopj.android.http.JsonHttpResponseHandler.2.2
                        @Override // java.lang.Runnable
                        public void run() {
                            JsonHttpResponseHandler.this.onFailure(i, headerArr, e, (JSONObject) null);
                        }
                    });
                }
            }
        };
        if (getUseSynchronousMode()) {
            runnable.run();
        } else {
            new Thread(runnable).start();
        }
    }

    @Override // com.loopj.android.http.TextHttpResponseHandler
    public void onSuccess(int i, Header[] headerArr, String str) {
        Log.w(LOG_TAG, "onSuccess(int, Header[], String) was not overriden, but callback was received");
    }

    public void onSuccess(int i, Header[] headerArr, JSONArray jSONArray) {
        Log.w(LOG_TAG, "onSuccess(int, Header[], JSONArray) was not overriden, but callback was received");
    }

    public void onSuccess(int i, Header[] headerArr, JSONObject jSONObject) {
        Log.w(LOG_TAG, "onSuccess(int, Header[], JSONObject) was not overriden, but callback was received");
    }

    @Override // com.loopj.android.http.TextHttpResponseHandler, com.loopj.android.http.AsyncHttpResponseHandler
    public final void onSuccess(final int i, final Header[] headerArr, final byte[] bArr) {
        if (i == 204) {
            onSuccess(i, headerArr, new JSONObject());
            return;
        }
        Runnable runnable = new Runnable() { // from class: com.loopj.android.http.JsonHttpResponseHandler.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    final Object parseResponse = JsonHttpResponseHandler.this.parseResponse(bArr);
                    JsonHttpResponseHandler.this.postRunnable(new Runnable() { // from class: com.loopj.android.http.JsonHttpResponseHandler.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Object obj = parseResponse;
                            if (obj instanceof JSONObject) {
                                JsonHttpResponseHandler.this.onSuccess(i, headerArr, (JSONObject) parseResponse);
                            } else if (obj instanceof JSONArray) {
                                JsonHttpResponseHandler.this.onSuccess(i, headerArr, (JSONArray) parseResponse);
                            } else if (obj instanceof String) {
                                JsonHttpResponseHandler.this.onFailure(i, headerArr, (String) parseResponse, new JSONException("Response cannot be parsed as JSON data"));
                            } else {
                                JsonHttpResponseHandler jsonHttpResponseHandler = JsonHttpResponseHandler.this;
                                int i2 = i;
                                Header[] headerArr2 = headerArr;
                                jsonHttpResponseHandler.onFailure(i2, headerArr2, new JSONException("Unexpected response type " + parseResponse.getClass().getName()), (JSONObject) null);
                            }
                        }
                    });
                } catch (JSONException e) {
                    JsonHttpResponseHandler.this.postRunnable(new Runnable() { // from class: com.loopj.android.http.JsonHttpResponseHandler.1.2
                        @Override // java.lang.Runnable
                        public void run() {
                            JsonHttpResponseHandler.this.onFailure(i, headerArr, e, (JSONObject) null);
                        }
                    });
                }
            }
        };
        if (getUseSynchronousMode()) {
            runnable.run();
        } else {
            new Thread(runnable).start();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0045, code lost:
        if (r5.startsWith("[") != false) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected java.lang.Object parseResponse(byte[] r5) throws org.json.JSONException {
        /*
            r4 = this;
            r0 = 0
            r8 = r0
            r0 = r5
            if (r0 != 0) goto L9
            r0 = 0
            return r0
        L9:
            r0 = r5
            r1 = r4
            java.lang.String r1 = r1.getCharset()
            java.lang.String r0 = getResponseString(r0, r1)
            r5 = r0
            r0 = r8
            r7 = r0
            r0 = r5
            r6 = r0
            r0 = r5
            if (r0 == 0) goto L56
            r0 = r5
            java.lang.String r0 = r0.trim()
            r6 = r0
            r0 = r6
            r5 = r0
            r0 = r6
            java.lang.String r1 = "\ufeff"
            boolean r0 = r0.startsWith(r1)
            if (r0 == 0) goto L31
            r0 = r6
            r1 = 1
            java.lang.String r0 = r0.substring(r1)
            r5 = r0
        L31:
            r0 = r5
            java.lang.String r1 = "{"
            boolean r0 = r0.startsWith(r1)
            if (r0 != 0) goto L48
            r0 = r8
            r7 = r0
            r0 = r5
            r6 = r0
            r0 = r5
            java.lang.String r1 = "["
            boolean r0 = r0.startsWith(r1)
            if (r0 == 0) goto L56
        L48:
            org.json.JSONTokener r0 = new org.json.JSONTokener
            r1 = r0
            r2 = r5
            r1.<init>(r2)
            java.lang.Object r0 = r0.nextValue()
            r7 = r0
            r0 = r5
            r6 = r0
        L56:
            r0 = r7
            if (r0 != 0) goto L5c
            r0 = r6
            return r0
        L5c:
            r0 = r7
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loopj.android.http.JsonHttpResponseHandler.parseResponse(byte[]):java.lang.Object");
    }
}
