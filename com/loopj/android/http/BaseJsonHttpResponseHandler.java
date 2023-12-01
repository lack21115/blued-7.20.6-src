package com.loopj.android.http;

import android.util.Log;
import org.apache.http.Header;

/* loaded from: source-7994992-dex2jar.jar:com/loopj/android/http/BaseJsonHttpResponseHandler.class */
public abstract class BaseJsonHttpResponseHandler<JSON_TYPE> extends TextHttpResponseHandler {
    private static final String LOG_TAG = "BaseJsonHttpResponseHandler";

    public BaseJsonHttpResponseHandler() {
        this("UTF-8");
    }

    public BaseJsonHttpResponseHandler(String str) {
        super(str);
    }

    @Override // com.loopj.android.http.TextHttpResponseHandler
    public final void onFailure(final int i, final Header[] headerArr, final String str, final Throwable th) {
        if (str == null) {
            onFailure(i, headerArr, th, null, null);
            return;
        }
        Runnable runnable = new Runnable() { // from class: com.loopj.android.http.BaseJsonHttpResponseHandler.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    final Object parseResponse = BaseJsonHttpResponseHandler.this.parseResponse(str, true);
                    BaseJsonHttpResponseHandler.this.postRunnable(new Runnable() { // from class: com.loopj.android.http.BaseJsonHttpResponseHandler.2.1
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // java.lang.Runnable
                        public void run() {
                            BaseJsonHttpResponseHandler.this.onFailure(i, headerArr, th, str, parseResponse);
                        }
                    });
                } catch (Throwable th2) {
                    Log.d(BaseJsonHttpResponseHandler.LOG_TAG, "parseResponse thrown an problem", th2);
                    BaseJsonHttpResponseHandler.this.postRunnable(new Runnable() { // from class: com.loopj.android.http.BaseJsonHttpResponseHandler.2.2
                        @Override // java.lang.Runnable
                        public void run() {
                            BaseJsonHttpResponseHandler.this.onFailure(i, headerArr, th, str, null);
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

    public abstract void onFailure(int i, Header[] headerArr, Throwable th, String str, JSON_TYPE json_type);

    @Override // com.loopj.android.http.TextHttpResponseHandler
    public final void onSuccess(final int i, final Header[] headerArr, final String str) {
        if (i == 204) {
            onSuccess(i, headerArr, null, null);
            return;
        }
        Runnable runnable = new Runnable() { // from class: com.loopj.android.http.BaseJsonHttpResponseHandler.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    final Object parseResponse = BaseJsonHttpResponseHandler.this.parseResponse(str, false);
                    BaseJsonHttpResponseHandler.this.postRunnable(new Runnable() { // from class: com.loopj.android.http.BaseJsonHttpResponseHandler.1.1
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // java.lang.Runnable
                        public void run() {
                            BaseJsonHttpResponseHandler.this.onSuccess(i, headerArr, str, parseResponse);
                        }
                    });
                } catch (Throwable th) {
                    Log.d(BaseJsonHttpResponseHandler.LOG_TAG, "parseResponse thrown an problem", th);
                    BaseJsonHttpResponseHandler.this.postRunnable(new Runnable() { // from class: com.loopj.android.http.BaseJsonHttpResponseHandler.1.2
                        @Override // java.lang.Runnable
                        public void run() {
                            BaseJsonHttpResponseHandler.this.onFailure(i, headerArr, th, str, null);
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

    public abstract void onSuccess(int i, Header[] headerArr, String str, JSON_TYPE json_type);

    protected abstract JSON_TYPE parseResponse(String str, boolean z) throws Throwable;
}
