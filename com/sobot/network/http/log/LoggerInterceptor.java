package com.sobot.network.http.log;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.mobads.sdk.internal.a;
import java.io.IOException;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/network/http/log/LoggerInterceptor.class */
public class LoggerInterceptor implements Interceptor {
    public static final String TAG = "OkHttpUtils";
    private boolean showResponse;
    private String tag;

    public LoggerInterceptor(String str) {
        this(str, false);
    }

    public LoggerInterceptor(String str, boolean z) {
        String str2 = TextUtils.isEmpty(str) ? TAG : str;
        this.showResponse = z;
        this.tag = str2;
    }

    private String bodyToString(Request request) {
        try {
            Request build = request.newBuilder().build();
            Buffer buffer = new Buffer();
            build.body().writeTo(buffer);
            return buffer.readUtf8();
        } catch (IOException e) {
            return "something error when show requestBody.";
        }
    }

    private boolean isText(MediaType mediaType) {
        if (mediaType.type() == null || !mediaType.type().equals("text")) {
            if (mediaType.subtype() != null) {
                return mediaType.subtype().equals("json") || mediaType.subtype().equals("xml") || mediaType.subtype().equals(a.f) || mediaType.subtype().equals("webviewhtml");
            }
            return false;
        }
        return true;
    }

    private void logForRequest(Request request) {
        MediaType contentType;
        try {
            String httpUrl = request.url().toString();
            Headers headers = request.headers();
            Log.e(this.tag, "========request'log=======");
            String str = this.tag;
            Log.e(str, "method : " + request.method());
            String str2 = this.tag;
            Log.e(str2, "url : " + httpUrl);
            if (headers != null && headers.size() > 0) {
                String str3 = this.tag;
                Log.e(str3, "headers : " + headers.toString());
            }
            RequestBody body = request.body();
            if (body != null && (contentType = body.contentType()) != null) {
                String str4 = this.tag;
                Log.e(str4, "requestBody's contentType : " + contentType.toString());
                if (isText(contentType)) {
                    String str5 = this.tag;
                    Log.e(str5, "requestBody's content : " + bodyToString(request));
                } else {
                    Log.e(this.tag, "requestBody's content :  maybe [file part] , too large too print , ignored!");
                }
            }
            Log.e(this.tag, "========request'log=======end");
        } catch (Exception e) {
        }
    }

    private Response logForResponse(Response response) {
        ResponseBody body;
        MediaType contentType;
        try {
            Log.e(this.tag, "========response'log=======");
            Response build = response.newBuilder().build();
            String str = this.tag;
            Log.e(str, "url : " + build.request().url());
            String str2 = this.tag;
            Log.e(str2, "code : " + build.code());
            String str3 = this.tag;
            Log.e(str3, "protocol : " + build.protocol());
            if (!TextUtils.isEmpty(build.message())) {
                String str4 = this.tag;
                Log.e(str4, "message : " + build.message());
            }
            if (this.showResponse && (body = build.body()) != null && (contentType = body.contentType()) != null) {
                String str5 = this.tag;
                Log.e(str5, "responseBody's contentType : " + contentType.toString());
                if (isText(contentType)) {
                    String string = body.string();
                    String str6 = this.tag;
                    Log.e(str6, "responseBody's content : " + string);
                    return response.newBuilder().body(ResponseBody.create(contentType, string)).build();
                }
                Log.e(this.tag, "responseBody's content :  maybe [file part] , too large too print , ignored!");
            }
            Log.e(this.tag, "========response'log=======end");
            return response;
        } catch (Exception e) {
            return response;
        }
    }

    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        logForRequest(request);
        return logForResponse(chain.proceed(request));
    }
}
