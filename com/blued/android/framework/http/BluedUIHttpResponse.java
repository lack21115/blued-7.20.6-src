package com.blued.android.framework.http;

import android.text.TextUtils;
import androidx.core.util.Pair;
import com.blued.android.core.AppInfo;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.net.StringHttpResponseHandler;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.utils.FileCache;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/framework/http/BluedUIHttpResponse.class */
public abstract class BluedUIHttpResponse<T extends BluedEntity> extends StringHttpResponseHandler implements IRequestHost {
    private static final String TAG = BluedUIHttpResponse.class.getSimpleName();
    private String cacheKey;
    private Type dataType;
    private boolean httpResult;
    private boolean readCache;
    private IRequestHost requestActive;
    private boolean runUiThread;
    private boolean writeCache;

    public BluedUIHttpResponse() {
        Type[] actualTypeArguments;
        this.readCache = false;
        this.writeCache = false;
        this.runUiThread = true;
        Type genericSuperclass = getClass().getGenericSuperclass();
        if (!(genericSuperclass instanceof ParameterizedType) || (actualTypeArguments = ((ParameterizedType) genericSuperclass).getActualTypeArguments()) == null || actualTypeArguments.length <= 0) {
            return;
        }
        this.dataType = actualTypeArguments[0];
    }

    public BluedUIHttpResponse(IRequestHost iRequestHost) {
        this();
        this.requestActive = iRequestHost;
    }

    public BluedUIHttpResponse(String str, IRequestHost iRequestHost) {
        this(iRequestHost);
        this.cacheKey = str;
    }

    private void onReadCache() {
        if (this.readCache || TextUtils.isEmpty(this.cacheKey)) {
            return;
        }
        this.readCache = true;
        try {
            final T parseData = parseData(FileCache.a(this.cacheKey));
            if (this.runUiThread) {
                AppInfo.n().post(new Runnable() { // from class: com.blued.android.framework.http.BluedUIHttpResponse.5
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.lang.Runnable
                    public void run() {
                        if (BluedUIHttpResponse.this.isActive()) {
                            BluedUIHttpResponse.this.onUICache(parseData);
                        }
                    }
                });
            } else if (isActive()) {
                onUICache(parseData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void onSaveCache(String str) {
        if (TextUtils.isEmpty(str) || this.writeCache || TextUtils.isEmpty(this.cacheKey)) {
            return;
        }
        FileCache.a(this.cacheKey, str);
        this.writeCache = true;
    }

    @Override // com.blued.android.core.net.IRequestHost
    public boolean isActive() {
        IRequestHost iRequestHost = this.requestActive;
        if (iRequestHost != null) {
            return iRequestHost.isActive();
        }
        return true;
    }

    @Override // com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
    @Deprecated
    public void onFailure(Throwable th, int i, final String str) {
        super.onFailure(th, i, (int) str);
        this.httpResult = false;
        final Pair<Integer, String> a = BluedHttpUtils.a(th, i, str);
        if (this.runUiThread) {
            AppInfo.n().post(new Runnable() { // from class: com.blued.android.framework.http.BluedUIHttpResponse.2
                @Override // java.lang.Runnable
                public void run() {
                    if (!BluedUIHttpResponse.this.isActive() || BluedUIHttpResponse.this.onUIFailure(((Integer) a.first).intValue(), (String) a.second, str)) {
                        return;
                    }
                    BluedHttpUtils.b.a(((Integer) a.first).intValue(), (String) a.second);
                }
            });
        } else if (!isActive() || onUIFailure(((Integer) a.first).intValue(), (String) a.second, str)) {
        } else {
            BluedHttpUtils.b.a(((Integer) a.first).intValue(), (String) a.second);
        }
    }

    @Override // com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
    @Deprecated
    public final void onFinish() {
        if (this.runUiThread) {
            AppInfo.n().post(new Runnable() { // from class: com.blued.android.framework.http.BluedUIHttpResponse.3
                @Override // java.lang.Runnable
                public void run() {
                    if (BluedUIHttpResponse.this.isActive()) {
                        BluedUIHttpResponse bluedUIHttpResponse = BluedUIHttpResponse.this;
                        bluedUIHttpResponse.onUIFinish(bluedUIHttpResponse.httpResult);
                    }
                }
            });
        } else if (isActive()) {
            onUIFinish(this.httpResult);
        }
    }

    @Override // com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
    @Deprecated
    public final void onStart() {
        super.onStart();
        this.httpResult = false;
        if (this.runUiThread) {
            AppInfo.n().post(new Runnable() { // from class: com.blued.android.framework.http.BluedUIHttpResponse.1
                @Override // java.lang.Runnable
                public void run() {
                    if (BluedUIHttpResponse.this.isActive()) {
                        BluedUIHttpResponse.this.onUIStart();
                    }
                }
            });
        } else if (isActive()) {
            onUIStart();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0091  */
    @Override // com.blued.android.core.net.http.AbstractHttpResponseHandler
    @java.lang.Deprecated
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onSuccess(int r7, java.lang.String r8) {
        /*
            r6 = this;
            r0 = r6
            r1 = r7
            r2 = r8
            super.onSuccess(r1, r2)
            r0 = 0
            r9 = r0
            r0 = r6
            r1 = r8
            com.blued.android.framework.http.parser.BluedEntity r0 = r0.parseData(r1)     // Catch: java.lang.Exception -> L3a
            r10 = r0
            r0 = r9
            r11 = r0
            r0 = r10
            r12 = r0
            r0 = r10
            if (r0 != 0) goto L56
            r0 = r6
            java.lang.reflect.Type r0 = r0.dataType     // Catch: java.lang.Exception -> L36
            if (r0 != 0) goto L2c
            r0 = r9
            r11 = r0
            r0 = r10
            r12 = r0
            goto L56
        L2c:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException     // Catch: java.lang.Exception -> L36
            r1 = r0
            java.lang.String r2 = "response is null or parse data failed"
            r1.<init>(r2)     // Catch: java.lang.Exception -> L36
            throw r0     // Catch: java.lang.Exception -> L36
        L36:
            r9 = move-exception
            goto L3e
        L3a:
            r9 = move-exception
            r0 = 0
            r10 = r0
        L3e:
            r0 = r9
            r11 = r0
            r0 = r10
            r12 = r0
            boolean r0 = com.blued.android.core.AppInfo.m()
            if (r0 == 0) goto L56
            r0 = r9
            r0.printStackTrace()
            r0 = r10
            r12 = r0
            r0 = r9
            r11 = r0
        L56:
            r0 = r11
            r1 = r7
            r2 = r8
            boolean r0 = com.blued.android.framework.http.BluedHttpUtils.b(r0, r1, r2)
            if (r0 == 0) goto L91
            r0 = r6
            r1 = 1
            r0.httpResult = r1
            r0 = r6
            r1 = r8
            r0.onSaveCache(r1)
            r0 = r6
            boolean r0 = r0.runUiThread
            if (r0 == 0) goto L83
            android.os.Handler r0 = com.blued.android.core.AppInfo.n()
            com.blued.android.framework.http.BluedUIHttpResponse$4 r1 = new com.blued.android.framework.http.BluedUIHttpResponse$4
            r2 = r1
            r3 = r6
            r4 = r12
            r2.<init>()
            boolean r0 = r0.post(r1)
            return
        L83:
            r0 = r6
            boolean r0 = r0.isActive()
            if (r0 == 0) goto L90
            r0 = r6
            r1 = r12
            r0.onUIUpdate(r1)
        L90:
            return
        L91:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r1 = r0
            r2 = r11
            r1.<init>(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.framework.http.BluedUIHttpResponse.onSuccess(int, java.lang.String):void");
    }

    @Override // com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
    @Deprecated
    public void onSuccess(String str) {
    }

    public void onUICache(T t) {
    }

    public boolean onUIFailure(int i, String str) {
        return false;
    }

    public boolean onUIFailure(int i, String str, String str2) {
        return onUIFailure(i, str);
    }

    public void onUIFinish() {
    }

    public void onUIFinish(boolean z) {
        onUIFinish();
    }

    public void onUIStart() {
    }

    protected abstract void onUIUpdate(T t);

    public T parseData(String str) {
        if (this.dataType == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return (T) AppInfo.f().fromJson(str, this.dataType);
    }

    public void refresh() {
        this.writeCache = false;
        onReadCache();
    }

    public void setDataType(Type type) {
        this.dataType = type;
    }

    public void setRequestHost(IRequestHost iRequestHost) {
        this.requestActive = iRequestHost;
    }

    public void setRunUiThread(boolean z) {
        this.runUiThread = z;
    }
}
