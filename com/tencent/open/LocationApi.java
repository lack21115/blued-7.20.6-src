package com.tencent.open;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import com.baidu.mobads.sdk.internal.bw;
import com.sina.weibo.sdk.constant.WBPageConstants;
import com.tencent.connect.auth.QQAuth;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;
import com.tencent.connect.common.Constants;
import com.tencent.open.a.f;
import com.tencent.open.c;
import com.tencent.open.utils.Global;
import com.tencent.open.utils.HttpUtils;
import com.tencent.open.utils.Util;
import com.tencent.tauth.IRequestListener;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/open/LocationApi.class */
public class LocationApi extends BaseApi implements c.a {

    /* renamed from: a  reason: collision with root package name */
    private HandlerThread f38182a;
    private Handler b;

    /* renamed from: c  reason: collision with root package name */
    private Handler f38183c;
    private c d;
    private Bundle e;
    private IUiListener f;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/open/LocationApi$a.class */
    abstract class a implements IRequestListener {
        private a() {
        }

        protected abstract void a(Exception exc);

        @Override // com.tencent.tauth.IRequestListener
        public void onConnectTimeoutException(ConnectTimeoutException connectTimeoutException) {
            a(connectTimeoutException);
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onHttpStatusException(HttpUtils.HttpStatusException httpStatusException) {
            a(httpStatusException);
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onIOException(IOException iOException) {
            a(iOException);
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onJSONException(JSONException jSONException) {
            a(jSONException);
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onMalformedURLException(MalformedURLException malformedURLException) {
            a(malformedURLException);
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onNetworkUnavailableException(HttpUtils.NetworkUnavailableException networkUnavailableException) {
            a(networkUnavailableException);
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onSocketTimeoutException(SocketTimeoutException socketTimeoutException) {
            a(socketTimeoutException);
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onUnknowException(Exception exc) {
            a(exc);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/open/LocationApi$b.class */
    public class b extends a {

        /* renamed from: c  reason: collision with root package name */
        private IUiListener f38189c;

        public b(IUiListener iUiListener) {
            super();
            this.f38189c = iUiListener;
        }

        @Override // com.tencent.open.LocationApi.a
        protected void a(Exception exc) {
            IUiListener iUiListener = this.f38189c;
            if (iUiListener != null) {
                iUiListener.onError(new UiError(100, exc.getMessage(), null));
            }
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onComplete(JSONObject jSONObject) {
            IUiListener iUiListener = this.f38189c;
            if (iUiListener != null) {
                iUiListener.onComplete(jSONObject);
            }
            f.b("openSDK_LOG.LocationApi", "TaskRequestListener onComplete GetNearbySwitchEnd:" + SystemClock.elapsedRealtime());
        }
    }

    public LocationApi(QQAuth qQAuth, QQToken qQToken) {
        super(qQAuth, qQToken);
        a();
    }

    public LocationApi(QQToken qQToken) {
        super(qQToken);
        a();
    }

    private void a() {
        this.d = new c();
        HandlerThread handlerThread = new HandlerThread("get_location");
        this.f38182a = handlerThread;
        handlerThread.start();
        this.b = new Handler(this.f38182a.getLooper());
        this.f38183c = new Handler(Global.getContext().getMainLooper()) { // from class: com.tencent.open.LocationApi.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int i = message.what;
                if (i == 101) {
                    f.b("openSDK_LOG.LocationApi", "location: get location timeout.");
                    LocationApi.this.a(-13, Constants.MSG_LOCATION_TIMEOUT_ERROR);
                } else if (i == 103) {
                    f.b("openSDK_LOG.LocationApi", "location: verify sosocode success.");
                    LocationApi.this.d.a(Global.getContext(), LocationApi.this);
                    LocationApi.this.f38183c.sendEmptyMessageDelayed(101, 10000L);
                } else if (i == 104) {
                    f.b("openSDK_LOG.LocationApi", "location: verify sosocode failed.");
                    LocationApi.this.a(-14, Constants.MSG_LOCATION_VERIFY_ERROR);
                }
                super.handleMessage(message);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str) {
        this.d.b();
        if (this.f == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ret", i);
            jSONObject.put("errMsg", str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        this.f.onComplete(jSONObject);
    }

    private void a(Location location) {
        Bundle composeCGIParams;
        f.a("openSDK_LOG.LocationApi", "doSearchNearby location: search mParams: " + this.e);
        if (this.e != null) {
            composeCGIParams = new Bundle(this.e);
            composeCGIParams.putAll(composeCGIParams());
        } else {
            composeCGIParams = composeCGIParams();
        }
        double latitude = location.getLatitude();
        double longitude = location.getLongitude();
        composeCGIParams.putString("appid", this.mToken.getAppId());
        if (!composeCGIParams.containsKey("latitude")) {
            composeCGIParams.putString("latitude", String.valueOf(latitude));
        }
        if (!composeCGIParams.containsKey("longitude")) {
            composeCGIParams.putString("longitude", String.valueOf(longitude));
        }
        if (!composeCGIParams.containsKey(WBPageConstants.ParamKey.PAGE)) {
            composeCGIParams.putString(WBPageConstants.ParamKey.PAGE, String.valueOf(1));
        }
        composeCGIParams.putString("encrytoken", Util.encrypt("tencent&sdk&qazxc***14969%%" + this.mToken.getAccessToken() + this.mToken.getAppId() + this.mToken.getOpenId() + "qzone3.4"));
        StringBuilder sb = new StringBuilder();
        sb.append("location: search params: ");
        sb.append(composeCGIParams);
        f.a("openSDK_LOG.LocationApi", sb.toString());
        f.b("openSDK_LOG.LocationApi", "GetNearbySwitchStart:" + SystemClock.elapsedRealtime());
        HttpUtils.requestAsync(this.mToken, Global.getContext(), "http://fusion.qq.com/cgi-bin/qzapps/mapp_lbs_getnear.cgi", composeCGIParams, "GET", new b(this.f));
    }

    private void a(final String str, final String... strArr) {
        this.b.post(new Runnable() { // from class: com.tencent.open.LocationApi.3
            @Override // java.lang.Runnable
            public void run() {
                String[] strArr2 = strArr;
                if (strArr2 == null || strArr2.length == 0) {
                    return;
                }
                com.tencent.connect.a.a.a(Global.getContext(), LocationApi.this.mToken, "search_nearby".equals(str) ? "id_search_nearby" : "id_delete_location", strArr);
            }
        });
    }

    private void b() {
        this.d.b();
    }

    private boolean c() {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) Global.getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        return (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isAvailable()) ? false : true;
    }

    private JSONObject d() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ret", -9);
            jSONObject.put("errMsg", Constants.MSG_IO_ERROR);
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            return jSONObject;
        }
    }

    public void deleteLocation(Activity activity, Bundle bundle, IUiListener iUiListener) {
        Bundle composeCGIParams;
        if (!c()) {
            if (iUiListener != null) {
                iUiListener.onComplete(d());
                return;
            }
            return;
        }
        if (bundle != null) {
            composeCGIParams = new Bundle(bundle);
            composeCGIParams.putAll(composeCGIParams());
        } else {
            composeCGIParams = composeCGIParams();
        }
        composeCGIParams.putString("appid", this.mToken.getAppId());
        composeCGIParams.putString("timestamp", String.valueOf(System.currentTimeMillis()));
        composeCGIParams.putString("encrytoken", Util.encrypt("tencent&sdk&qazxc***14969%%" + this.mToken.getAccessToken() + this.mToken.getAppId() + this.mToken.getOpenId() + "qzone3.4"));
        StringBuilder sb = new StringBuilder();
        sb.append("location: delete params: ");
        sb.append(composeCGIParams);
        f.a("openSDK_LOG.LocationApi", sb.toString());
        HttpUtils.requestAsync(this.mToken, Global.getContext(), "http://fusion.qq.com/cgi-bin/qzapps/mapp_lbs_delete.cgi", composeCGIParams, "GET", new b(iUiListener));
        a("delete_location", bw.o);
    }

    @Override // com.tencent.open.c.a
    public void onLocationUpdate(Location location) {
        a(location);
        b();
        this.f38183c.removeMessages(101);
    }

    public void searchNearby(Activity activity, Bundle bundle, IUiListener iUiListener) {
        if (c()) {
            this.e = bundle;
            this.f = iUiListener;
            this.b.post(new Runnable() { // from class: com.tencent.open.LocationApi.2
                @Override // java.lang.Runnable
                public void run() {
                    if (LocationApi.this.d.a()) {
                        Message.obtain(LocationApi.this.f38183c, 103).sendToTarget();
                    } else {
                        Message.obtain(LocationApi.this.f38183c, 104).sendToTarget();
                    }
                }
            });
        } else if (iUiListener != null) {
            iUiListener.onComplete(d());
        }
    }
}
