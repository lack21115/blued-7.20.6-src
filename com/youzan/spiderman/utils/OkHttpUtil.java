package com.youzan.spiderman.utils;

import android.content.Context;
import com.youzan.spiderman.d.d;
import com.youzan.spiderman.html.HtmlHeader;
import com.youzan.spiderman.html.l;
import com.youzan.spiderman.html.m;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/spiderman/utils/OkHttpUtil.class */
public class OkHttpUtil {
    private static final String TAG = "OkHttpUtil";
    private static OkHttpClient mOkHttpClient;
    private static OkHttpClient mOkHttpClientForHtml;
    private static Charset sUtf8 = Charset.forName("UTF-8");

    public static d downloadFile(Context context, String str) {
        if (!NetWorkUtil.hasNetworkPermission(context)) {
            Logger.e(TAG, "has no network permission to download file", new Object[0]);
            return null;
        }
        try {
            ResponseBody body = withOkHttpClient().newCall(new Request.Builder().url(str).build()).execute().body();
            if (body != null) {
                return new d(getContentCharset(body), body.byteStream(), body.charStream());
            }
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void downloadFile(Context context, String str, final StreamCallback streamCallback) {
        if (NetWorkUtil.hasNetworkPermission(context)) {
            withOkHttpClient().newCall(new Request.Builder().url(str).build()).enqueue(new Callback() { // from class: com.youzan.spiderman.utils.OkHttpUtil.2
                @Override // okhttp3.Callback
                public final void onFailure(Call call, IOException iOException) {
                    StreamCallback.this.fail();
                }

                @Override // okhttp3.Callback
                public final void onResponse(Call call, Response response) throws IOException {
                    if (response.isSuccessful()) {
                        StreamCallback.this.success(response.body().byteStream());
                    }
                }
            });
            return;
        }
        Logger.e(TAG, "has no network permission to download file", new Object[0]);
        streamCallback.fail();
    }

    public static void downloadFile(Context context, String str, final File file, final FileCallback fileCallback) {
        if (NetWorkUtil.hasNetworkPermission(context)) {
            withOkHttpClient().newCall(new Request.Builder().url(str).build()).enqueue(new Callback() { // from class: com.youzan.spiderman.utils.OkHttpUtil.1
                @Override // okhttp3.Callback
                public final void onFailure(Call call, IOException iOException) {
                    fileCallback.fail(-1, iOException);
                }

                /* JADX WARN: Removed duplicated region for block: B:54:0x00f8 A[Catch: IOException -> 0x0124, TRY_ENTER, TRY_LEAVE, TryCatch #5 {IOException -> 0x0124, blocks: (B:51:0x00ec, B:54:0x00f8), top: B:66:0x00ec }] */
                /* JADX WARN: Removed duplicated region for block: B:66:0x00ec A[EXC_TOP_SPLITTER, SYNTHETIC] */
                @Override // okhttp3.Callback
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final void onResponse(okhttp3.Call r6, okhttp3.Response r7) throws java.io.IOException {
                    /*
                        Method dump skipped, instructions count: 296
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.youzan.spiderman.utils.OkHttpUtil.AnonymousClass1.onResponse(okhttp3.Call, okhttp3.Response):void");
                }
            });
            return;
        }
        Logger.e(TAG, "has no network permission to download file", new Object[0]);
        fileCallback.fail(-1, null);
    }

    public static m downloadHtml(HtmlHeader htmlHeader, l lVar) {
        try {
            Response execute = withOkHttpClientHtml().newCall(new Request.Builder().url(lVar.a()).headers(Headers.of(htmlHeader.getTransferdedHeader())).build()).execute();
            return new m(lVar, execute.headers(), execute);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Charset getContentCharset(ResponseBody responseBody) {
        MediaType contentType = responseBody.contentType();
        return contentType != null ? contentType.charset(sUtf8) : sUtf8;
    }

    private static OkHttpClient withOkHttpClient() {
        if (mOkHttpClient == null) {
            mOkHttpClient = new OkHttpClient();
        }
        return mOkHttpClient;
    }

    private static OkHttpClient withOkHttpClientHtml() {
        if (mOkHttpClientForHtml == null) {
            mOkHttpClientForHtml = new OkHttpClient.Builder().followRedirects(false).followSslRedirects(false).connectTimeout(15L, TimeUnit.SECONDS).build();
        }
        return mOkHttpClientForHtml;
    }
}
