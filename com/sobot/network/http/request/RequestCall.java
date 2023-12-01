package com.sobot.network.http.request;

import com.sobot.network.http.SobotOkHttpUtils;
import com.sobot.network.http.callback.Callback;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/network/http/request/RequestCall.class */
public class RequestCall {
    private Call call;
    private OkHttpClient clone;
    private long connTimeOut;
    private OkHttpRequest okHttpRequest;
    private long readTimeOut;
    private Request request;
    private long writeTimeOut;

    public RequestCall(OkHttpRequest okHttpRequest) {
        this.okHttpRequest = okHttpRequest;
    }

    private Request generateRequest(Callback callback) {
        return this.okHttpRequest.generateRequest(callback);
    }

    public Call buildCall(Callback callback) {
        this.request = generateRequest(callback);
        if (this.readTimeOut > 0 || this.writeTimeOut > 0 || this.connTimeOut > 0) {
            long j = this.readTimeOut;
            if (j <= 0) {
                j = 10000;
            }
            this.readTimeOut = j;
            long j2 = this.writeTimeOut;
            if (j2 <= 0) {
                j2 = 10000;
            }
            this.writeTimeOut = j2;
            long j3 = this.connTimeOut;
            long j4 = 10000;
            if (j3 > 0) {
                j4 = j3;
            }
            this.connTimeOut = j4;
            OkHttpClient build = SobotOkHttpUtils.getInstance().getOkHttpClient().newBuilder().readTimeout(this.readTimeOut, TimeUnit.MILLISECONDS).writeTimeout(this.writeTimeOut, TimeUnit.MILLISECONDS).connectTimeout(this.connTimeOut, TimeUnit.MILLISECONDS).build();
            this.clone = build;
            this.call = build.newCall(this.request);
        } else {
            this.call = SobotOkHttpUtils.getInstance().getOkHttpClient().newCall(this.request);
        }
        return this.call;
    }

    public void cancel() {
        Call call = this.call;
        if (call != null) {
            call.cancel();
        }
    }

    public RequestCall connTimeOut(long j) {
        this.connTimeOut = j;
        return this;
    }

    public Response execute() throws IOException {
        buildCall(null);
        return this.call.execute();
    }

    public void execute(Callback callback) {
        buildCall(callback);
        if (callback != null) {
            callback.onBefore(this.request);
        }
        SobotOkHttpUtils.getInstance().execute(this, callback);
    }

    public Call getCall() {
        return this.call;
    }

    public OkHttpRequest getOkHttpRequest() {
        return this.okHttpRequest;
    }

    public Request getRequest() {
        return this.request;
    }

    public RequestCall readTimeOut(long j) {
        this.readTimeOut = j;
        return this;
    }

    public RequestCall writeTimeOut(long j) {
        this.writeTimeOut = j;
        return this;
    }
}
