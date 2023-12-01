package com.sobot.network.http;

import android.os.Handler;
import android.os.Looper;
import com.sobot.network.http.builder.GetBuilder;
import com.sobot.network.http.builder.HeadBuilder;
import com.sobot.network.http.builder.OtherRequestBuilder;
import com.sobot.network.http.builder.PostFileBuilder;
import com.sobot.network.http.builder.PostFormBuilder;
import com.sobot.network.http.builder.PostMultipartFormBuilder;
import com.sobot.network.http.builder.PostStringBuilder;
import com.sobot.network.http.callback.Callback;
import com.sobot.network.http.callback.FileCallBack;
import com.sobot.network.http.log.LoggerInterceptor;
import com.sobot.network.http.log.SobotNetLogUtils;
import com.sobot.network.http.request.RequestCall;
import java.io.IOException;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Response;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/network/http/SobotOkHttpUtils.class */
public class SobotOkHttpUtils {
    public static final long DEFAULT_MILLISECONDS = 10000;
    private static SobotOkHttpUtils mInstance;
    private Handler mDelivery;
    private OkHttpClient mOkHttpClient;

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/network/http/SobotOkHttpUtils$METHOD.class */
    public static class METHOD {
        public static final String DELETE = "DELETE";
        public static final String HEAD = "HEAD";
        public static final String PATCH = "PATCH";
        public static final String PUT = "PUT";
    }

    public SobotOkHttpUtils(OkHttpClient okHttpClient) {
        if (okHttpClient != null) {
            this.mOkHttpClient = okHttpClient;
            return;
        }
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.addInterceptor(new SobotInternetPermissionExceptionInterceptor());
        this.mDelivery = new Handler(Looper.getMainLooper());
        try {
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init((KeyStore) null);
            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
            if (trustManagers.length != 1 || !(trustManagers[0] instanceof X509TrustManager)) {
                SobotNetLogUtils.e("Unexpected default trust managers:" + Arrays.toString(trustManagers));
            }
            X509TrustManager x509TrustManager = (X509TrustManager) trustManagers[0];
            builder.sslSocketFactory(createSSLSocketFactory(x509TrustManager), x509TrustManager);
            this.mOkHttpClient = builder.build();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static SSLSocketFactory createSSLSocketFactory(X509TrustManager x509TrustManager) {
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, new TrustManager[]{x509TrustManager}, new SecureRandom());
            return sSLContext.getSocketFactory();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static OtherRequestBuilder delete() {
        return new OtherRequestBuilder("DELETE");
    }

    public static void download(String str, FileCallBack fileCallBack) {
        get().url(str).build().execute(fileCallBack);
    }

    public static GetBuilder get() {
        return new GetBuilder();
    }

    public static SobotOkHttpUtils getInstance() {
        if (mInstance == null) {
            synchronized (SobotOkHttpUtils.class) {
                try {
                    if (mInstance == null) {
                        mInstance = new SobotOkHttpUtils(null);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return mInstance;
    }

    public static SobotOkHttpUtils getInstance(OkHttpClient okHttpClient) {
        if (mInstance == null) {
            synchronized (SobotOkHttpUtils.class) {
                try {
                    if (mInstance == null) {
                        mInstance = new SobotOkHttpUtils(okHttpClient);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return mInstance;
    }

    public static HeadBuilder head() {
        return new HeadBuilder();
    }

    public static OtherRequestBuilder patch() {
        return new OtherRequestBuilder(METHOD.PATCH);
    }

    public static PostFormBuilder post() {
        return new PostFormBuilder();
    }

    public static PostFileBuilder postFile() {
        return new PostFileBuilder();
    }

    public static PostMultipartFormBuilder postMultipart() {
        return new PostMultipartFormBuilder();
    }

    public static PostStringBuilder postString() {
        return new PostStringBuilder();
    }

    public static OtherRequestBuilder put() {
        return new OtherRequestBuilder("PUT");
    }

    public static void runOnUiThread(Runnable runnable) {
        getInstance().mDelivery.post(runnable);
    }

    public void cancelTag(Object obj) {
        for (Call call : this.mOkHttpClient.dispatcher().queuedCalls()) {
            if (obj.equals(call.request().tag())) {
                call.cancel();
            }
        }
        for (Call call2 : this.mOkHttpClient.dispatcher().runningCalls()) {
            if (obj.equals(call2.request().tag())) {
                call2.cancel();
            }
        }
    }

    public SobotOkHttpUtils debug(String str) {
        this.mOkHttpClient = getOkHttpClient().newBuilder().addInterceptor(new LoggerInterceptor(str, false)).build();
        return this;
    }

    public SobotOkHttpUtils debug(String str, boolean z) {
        this.mOkHttpClient = getOkHttpClient().newBuilder().addInterceptor(new LoggerInterceptor(str, z)).build();
        return this;
    }

    public void execute(RequestCall requestCall, Callback callback) {
        Callback callback2 = callback;
        if (callback == null) {
            callback2 = Callback.CALLBACK_DEFAULT;
        }
        final Callback callback3 = callback2;
        requestCall.getCall().enqueue(new okhttp3.Callback() { // from class: com.sobot.network.http.SobotOkHttpUtils.1
            public void onFailure(Call call, IOException iOException) {
                SobotOkHttpUtils.this.sendFailResultCallback(call, iOException, callback3);
            }

            public void onResponse(Call call, Response response) {
                if (!response.isSuccessful()) {
                    try {
                        SobotOkHttpUtils.this.sendFailResultCallback(call, new RuntimeException(response.body().string()), callback3);
                        return;
                    } catch (IOException e) {
                        e.printStackTrace();
                        return;
                    }
                }
                try {
                    SobotOkHttpUtils.this.sendSuccessResultCallback(callback3.parseNetworkResponse(response), callback3);
                } catch (Exception e2) {
                    SobotOkHttpUtils.this.sendFailResultCallback(call, e2, callback3);
                }
            }
        });
    }

    public Handler getDelivery() {
        return this.mDelivery;
    }

    public OkHttpClient getOkHttpClient() {
        return this.mOkHttpClient;
    }

    public void sendFailResultCallback(final Call call, final Exception exc, final Callback callback) {
        if (callback == null || call.isCanceled()) {
            return;
        }
        this.mDelivery.post(new Runnable() { // from class: com.sobot.network.http.SobotOkHttpUtils.2
            @Override // java.lang.Runnable
            public void run() {
                callback.onError(call, exc);
                callback.onAfter();
            }
        });
    }

    public void sendSuccessResultCallback(final Object obj, final Callback callback) {
        if (callback == null) {
            return;
        }
        this.mDelivery.post(new Runnable() { // from class: com.sobot.network.http.SobotOkHttpUtils.3
            @Override // java.lang.Runnable
            public void run() {
                callback.onResponse(obj);
                callback.onAfter();
            }
        });
    }

    public void setConnectTimeout(int i, TimeUnit timeUnit) {
        this.mOkHttpClient = getOkHttpClient().newBuilder().connectTimeout(i, timeUnit).build();
    }

    public void setHostNameVerifier(HostnameVerifier hostnameVerifier) {
        this.mOkHttpClient = getOkHttpClient().newBuilder().hostnameVerifier(hostnameVerifier).build();
    }

    public void setOkHttpClient(OkHttpClient okHttpClient) {
        this.mOkHttpClient = okHttpClient;
    }

    public void setReadTimeout(int i, TimeUnit timeUnit) {
        this.mOkHttpClient = getOkHttpClient().newBuilder().readTimeout(i, timeUnit).build();
    }

    public void setWriteTimeout(int i, TimeUnit timeUnit) {
        this.mOkHttpClient = getOkHttpClient().newBuilder().writeTimeout(i, timeUnit).build();
    }
}
