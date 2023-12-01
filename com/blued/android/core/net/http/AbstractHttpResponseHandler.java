package com.blued.android.core.net.http;

import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.anythink.core.common.g.g;
import com.blued.android.core.AppInfo;
import com.blued.android.core.net.HttpManager;
import com.blued.android.core.net.HttpRequestWrapper;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.utils.Log;
import com.blued.android.statistics.BluedStatistics;
import java.io.IOException;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/net/http/AbstractHttpResponseHandler.class */
public abstract class AbstractHttpResponseHandler<T> {
    protected static final int CANCEL_MESSAGE = 5;
    protected static final int FAILURE_MESSAGE = 1;
    protected static final int FINISH_MESSAGE = 3;
    protected static final int PROGRESS_MESSAGE = 4;
    protected static final int START_MESSAGE = 2;
    protected static final int SUCCESS_MESSAGE = 0;
    private Object extraData;
    protected HttpRequestWrapper requestWrapper;
    private String serverIP;
    private long startTime;
    private boolean uiCallback;

    public AbstractHttpResponseHandler() {
        this(false);
    }

    public AbstractHttpResponseHandler(boolean z) {
        this.startTime = 0L;
        this.serverIP = "";
        this.uiCallback = z;
    }

    private boolean isActive() {
        HttpRequestWrapper httpRequestWrapper = this.requestWrapper;
        return httpRequestWrapper == null || httpRequestWrapper.d() == null || this.requestWrapper.d().isActive();
    }

    public Object getData() {
        return this.extraData;
    }

    public HttpRequestWrapper getRequestWrapper() {
        return this.requestWrapper;
    }

    public abstract long getResponseLength(T t);

    public abstract String getResponseType();

    protected void handleCancelMessage() {
        if (isActive()) {
            onCancel();
        }
    }

    protected void handleFailureMessage(String str, Throwable th, int i, T t) {
        if (isActive()) {
            long j = 0;
            if (0 != this.startTime) {
                j = SystemClock.uptimeMillis() - this.startTime;
            }
            BluedStatistics.b().a(str, i, getResponseType(), th, j, this.serverIP);
            onFailure(th, i, t);
        }
    }

    protected void handleFinishMessage() {
        if (isActive()) {
            onFinish();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void handleMessage(Message message) {
        int i = message.what;
        if (i == 0) {
            Object[] objArr = (Object[]) message.obj;
            handleSuccessMessage((String) objArr[0], ((Integer) objArr[1]).intValue(), objArr[2]);
        } else if (i == 1) {
            Object[] objArr2 = (Object[]) message.obj;
            handleFailureMessage((String) objArr2[0], (Throwable) objArr2[1], ((Integer) objArr2[2]).intValue(), objArr2[3]);
        } else if (i == 2) {
            handleStartMessage();
        } else if (i == 3) {
            handleFinishMessage();
        } else if (i == 4) {
            Object[] objArr3 = (Object[]) message.obj;
            handleProgressMessage(((Integer) objArr3[0]).intValue(), ((Integer) objArr3[1]).intValue());
        } else if (i == 5) {
            handleCancelMessage();
        } else {
            Log.e("HttpManager", "unknown msg:" + message);
            handleCancelMessage();
        }
    }

    protected void handleProgressMessage(int i, int i2) {
        if (isActive()) {
            onProgress(i, i2);
        }
    }

    protected void handleStartMessage() {
        this.startTime = SystemClock.uptimeMillis();
        if (isActive()) {
            onStart();
        }
    }

    protected void handleSuccessMessage(String str, int i, T t) {
        if (isActive()) {
            long j = 0;
            if (0 != this.startTime) {
                j = SystemClock.uptimeMillis() - this.startTime;
            }
            onSuccess(i, t);
            BluedStatistics.b().a(str, i, getResponseType(), getResponseLength(t), j, this.serverIP);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isCancelled() {
        IRequestHost d;
        if (Thread.currentThread().isInterrupted()) {
            return true;
        }
        HttpRequestWrapper httpRequestWrapper = this.requestWrapper;
        if (httpRequestWrapper == null || (d = httpRequestWrapper.d()) == null) {
            return false;
        }
        return !d.isActive();
    }

    protected Message obtainMessage(int i, Object obj) {
        if (this.uiCallback) {
            return AppInfo.n().obtainMessage(i, obj);
        }
        Message obtain = Message.obtain();
        obtain.what = i;
        obtain.obj = obj;
        return obtain;
    }

    public boolean onAccept(int i, long j) {
        return true;
    }

    public abstract void onCancel();

    @Deprecated
    public abstract void onFailure(Throwable th);

    public void onFailure(Throwable th, int i, T t) {
        onFailure(th);
    }

    public abstract void onFinish();

    public abstract void onProgress(int i, int i2);

    public abstract void onStart();

    public void onSuccess(int i, T t) {
        onSuccess(t);
    }

    public abstract void onSuccess(T t);

    protected abstract T parseResponse(int i, ResponseBody responseBody) throws IOException;

    /* JADX INFO: Access modifiers changed from: protected */
    public void sendCancelMessage(String str) {
        if (HttpManager.c()) {
            Log.a("HttpManager", "cancel, reason:" + str);
        }
        sendMessage(obtainMessage(5, null));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sendFailureMessage(String str, Throwable th, int i, T t) {
        if (HttpManager.c()) {
            Log.a("HttpManager", "fail, url:" + str + ", e:" + th + ", statusCode:" + i + ", responseBody:" + t);
        }
        sendMessage(obtainMessage(1, new Object[]{str, th, Integer.valueOf(i), t}));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sendFinishMessage() {
        sendMessage(obtainMessage(3, null));
    }

    protected void sendMessage(final Message message) {
        if (this.uiCallback) {
            AppInfo.n().post(new Runnable() { // from class: com.blued.android.core.net.http.AbstractHttpResponseHandler.1
                @Override // java.lang.Runnable
                public void run() {
                    AbstractHttpResponseHandler.this.handleMessage(message);
                }
            });
        } else {
            handleMessage(message);
        }
    }

    public void sendProgressMessage(int i, int i2) {
        sendMessage(obtainMessage(4, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sendResponseMessage(String str, Response response) {
        T t;
        if (response == null) {
            sendFailureMessage(str, new Exception("response is null!"), g.b, null);
            return;
        }
        ResponseBody body = response.body();
        int code = response.code();
        long contentLength = body != null ? body.contentLength() : 0L;
        if (!onAccept(code, contentLength)) {
            sendCancelMessage("response donot accept, statusCode:" + code + ", entityLength:" + contentLength);
            return;
        }
        try {
            t = parseResponse(code, body);
            e = null;
        } catch (IOException e) {
            e = e;
            t = null;
        }
        if (e != null) {
            int i = code;
            if (code == 0) {
                i = StatusCode.a(e);
            }
            sendFailureMessage(str, e, i, t);
        } else if (code < 300) {
            sendSuccessMessage(str, code, t);
        } else {
            if (HttpManager.c()) {
                Log.e("HttpManager", "status code is " + code);
            }
            sendFailureMessage(str, TextUtils.isEmpty(response.message()) ? null : new Exception(response.message()), code, t);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sendStartMessage() {
        sendMessage(obtainMessage(2, null));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sendSuccessMessage(String str, int i, T t) {
        if (HttpManager.c()) {
            Log.a("HttpManager", "success, url:" + str + ", statusCode:" + i + ", responseBody:" + t);
        }
        sendMessage(obtainMessage(0, new Object[]{str, Integer.valueOf(i), t}));
    }

    public void setData(Object obj) {
        this.extraData = obj;
    }

    public void setServerIP(String str) {
        this.serverIP = str;
    }
}
