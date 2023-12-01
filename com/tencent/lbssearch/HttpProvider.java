package com.tencent.lbssearch;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.lbssearch.httpresponse.BaseObject;
import com.tencent.lbssearch.object.RequestParams;
import com.tencent.map.tools.json.JsonUtils;
import com.tencent.map.tools.net.NetConfig;
import com.tencent.map.tools.net.NetManager;
import com.tencent.map.tools.net.NetResponse;
import com.tencent.map.tools.net.http.HttpResponseListener;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLDecoder;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/lbssearch/HttpProvider.class */
public class HttpProvider {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/lbssearch/HttpProvider$a.class */
    public static final class a<T> extends AsyncTask<Void, Void, T> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f22517a;
        public final /* synthetic */ String b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ RequestParams f22518c;
        public final /* synthetic */ Class d;
        public final /* synthetic */ HttpResponseListener e;

        public a(String str, String str2, RequestParams requestParams, Class cls, HttpResponseListener httpResponseListener) {
            this.f22517a = str;
            this.b = str2;
            this.f22518c = requestParams;
            this.d = cls;
            this.e = httpResponseListener;
        }

        /* JADX WARN: Incorrect return type in method signature: ([Ljava/lang/Void;)TT; */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public BaseObject doInBackground(Void... voidArr) {
            NetResponse doGet = NetManager.getInstance().builder(this.f22517a).url(HttpProvider.getUrlWithQueryString(this.b, this.f22518c)).doGet();
            if (this.f22518c.isDebuggable()) {
                Log.v("TencentSearch", "[RESP]:\n" + doGet);
            }
            return HttpProvider.parse(doGet, this.d);
        }

        /* JADX WARN: Incorrect types in method signature: (TT;)V */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public void onPostExecute(BaseObject baseObject) {
            super.onPostExecute(baseObject);
            HttpResponseListener httpResponseListener = this.e;
            if (httpResponseListener == null) {
                return;
            }
            if (baseObject == null) {
                httpResponseListener.onFailure(-1, "unknown error", null);
            } else if (baseObject.isStatusOk()) {
                this.e.onSuccess(baseObject.status, baseObject);
            } else {
                this.e.onFailure(baseObject.status, baseObject.message, baseObject.exception);
            }
        }
    }

    private static String decodeUrl(String str) {
        try {
            URL url = new URL(URLDecoder.decode(str, "UTF-8"));
            return new URI(url.getProtocol(), url.getUserInfo(), url.getHost(), url.getPort(), url.getPath(), url.getQuery(), url.getRef()).toASCIIString();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return str;
        } catch (MalformedURLException e2) {
            e2.printStackTrace();
            return str;
        } catch (URISyntaxException e3) {
            e3.printStackTrace();
            return str;
        }
    }

    public static <T extends BaseObject> void get(Context context, String str, RequestParams requestParams, Class<T> cls, String str2, HttpResponseListener<T> httpResponseListener) {
        if (!NetManager.getInstance().available()) {
            NetManager.init(context, NetConfig.create());
        }
        new a(str2, str, requestParams, cls, httpResponseListener).execute(new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getUrlWithQueryString(String str, RequestParams requestParams) {
        if (str == null) {
            return null;
        }
        String decodeUrl = decodeUrl(str);
        String str2 = decodeUrl;
        if (requestParams != null) {
            String trim = requestParams.toString().trim();
            str2 = decodeUrl;
            if (!trim.equals("")) {
                str2 = decodeUrl;
                if (!trim.equals("?")) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(decodeUrl);
                    sb.append(decodeUrl.contains("?") ? ContainerUtils.FIELD_DELIMITER : "?");
                    str2 = sb.toString() + trim;
                }
            }
        }
        if (requestParams != null && requestParams.isDebuggable()) {
            Log.v("TencentSearch", "[REQ]: " + str2);
        }
        return str2;
    }

    public static <T extends BaseObject> T parse(NetResponse netResponse, Class<T> cls) {
        if (netResponse.available()) {
            return (T) JsonUtils.parseToModel(netResponse.toString(), cls, new Object[0]);
        }
        T t = (T) JsonUtils.parseToModel("", cls, new Object[0]);
        if (t != null) {
            t.exception = netResponse.exception;
        }
        return t;
    }
}
