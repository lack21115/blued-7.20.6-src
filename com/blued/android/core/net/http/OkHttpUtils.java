package com.blued.android.core.net.http;

import android.os.Build;
import android.text.TextUtils;
import com.blued.android.core.net.BinaryHttpResponseHandler;
import com.blued.android.core.net.FileHttpResponseHandler;
import com.blued.android.core.net.HttpRequestWrapper;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.net.exception.OkHttpException;
import com.blued.android.core.net.http.ssl.HttpsIPAccessUtils;
import com.blued.android.core.utils.Log;
import com.google.common.net.HttpHeaders;
import com.tencent.ugc.common.UGCConstants;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;
import java.util.WeakHashMap;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/net/http/OkHttpUtils.class */
public class OkHttpUtils {

    /* renamed from: a  reason: collision with root package name */
    static OkHttpClient f9687a;
    private static final WeakHashMap<IRequestHost, List<WeakReference<Call>>> b = new WeakHashMap<>();

    public static void a() {
        if (f9687a == null) {
            int i = 4;
            if (Runtime.getRuntime().availableProcessors() > 4) {
                i = Runtime.getRuntime().availableProcessors();
            } else if (Build.VERSION.SDK_INT >= 26) {
                i = 8;
            }
            Dispatcher dispatcher = new Dispatcher();
            dispatcher.setMaxRequests(i);
            OkHttpClient.Builder dispatcher2 = new OkHttpClient.Builder().dns(SyncOkHttpDns.a()).dispatcher(dispatcher);
            HttpsIPAccessUtils.a(dispatcher2);
            f9687a = dispatcher2.build();
        }
    }

    public static void a(HttpRequestWrapper httpRequestWrapper) {
        Call a2 = new OkHttpUrlRequest().a(httpRequestWrapper);
        httpRequestWrapper.a(a2);
        IRequestHost d = httpRequestWrapper.d();
        if (a2 == null || d == null) {
            return;
        }
        synchronized (b) {
            List<WeakReference<Call>> list = b.get(d);
            LinkedList linkedList = list;
            if (list == null) {
                linkedList = new LinkedList();
                b.put(d, linkedList);
            }
            linkedList.add(new WeakReference<>(a2));
        }
    }

    public static void a(IRequestHost iRequestHost) {
        synchronized (b) {
            List<WeakReference<Call>> list = b.get(iRequestHost);
            if (list != null) {
                for (WeakReference<Call> weakReference : list) {
                    Call call = weakReference.get();
                    if (call != null) {
                        call.cancel();
                    }
                }
                list.clear();
            }
            b.remove(iRequestHost);
        }
    }

    public static void a(String str, BinaryHttpResponseHandler binaryHttpResponseHandler) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            if (binaryHttpResponseHandler == null) {
                return;
            }
            try {
                binaryHttpResponseHandler.sendStartMessage();
                Response execute = f9687a.newCall(new Request.Builder().url(str).build()).execute();
                if (!Thread.currentThread().isInterrupted()) {
                    binaryHttpResponseHandler.sendResponseMessage(str, execute);
                }
            } catch (IOException e) {
                e.printStackTrace();
                binaryHttpResponseHandler.sendFailureMessage(str, e, StatusCode.a(e), null);
            } catch (Exception e2) {
                e2.printStackTrace();
                binaryHttpResponseHandler.sendFailureMessage(str, e2, UGCConstants.ERR_BGM_UNSUPPORT_SYSTEM, null);
            } catch (OutOfMemoryError e3) {
                e3.printStackTrace();
                binaryHttpResponseHandler.sendFailureMessage(str, e3, -3001, null);
            }
        } finally {
            binaryHttpResponseHandler.sendFinishMessage();
        }
    }

    public static void a(final String str, final String str2, final FileHttpResponseHandler fileHttpResponseHandler, final IRequestHost iRequestHost) throws OkHttpException {
        if (TextUtils.isEmpty(str)) {
            if (fileHttpResponseHandler != null) {
                fileHttpResponseHandler.sendFailureMessage(str, new Exception("url is empty"), -1002, null);
            }
        } else if (Base64ImageUrlDownloader.a(str)) {
            Base64ImageUrlDownloader.a(str, str2, fileHttpResponseHandler, iRequestHost);
        } else {
            try {
                f9687a.newCall(new Request.Builder().url(str).addHeader(HttpHeaders.ACCEPT, "image/webp, */*").build()).enqueue(new Callback() { // from class: com.blued.android.core.net.http.OkHttpUtils.1
                    @Override // okhttp3.Callback
                    public void onFailure(Call call, IOException iOException) {
                        FileHttpResponseHandler fileHttpResponseHandler2 = FileHttpResponseHandler.this;
                        if (fileHttpResponseHandler2 != null) {
                            fileHttpResponseHandler2.sendFailureMessage(str, iOException, StatusCode.a(iOException), null);
                        }
                    }

                    @Override // okhttp3.Callback
                    public void onResponse(Call call, Response response) {
                        OkHttpUtils.b(response, str, str2, FileHttpResponseHandler.this, iRequestHost);
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
                if (fileHttpResponseHandler != null) {
                    fileHttpResponseHandler.sendFailureMessage(str, e, UGCConstants.ERR_BGM_UNSUPPORT_SYSTEM, null);
                }
            }
        }
    }

    public static void b(String str, String str2, FileHttpResponseHandler fileHttpResponseHandler, IRequestHost iRequestHost) throws OkHttpException {
        Response execute;
        if (TextUtils.isEmpty(str)) {
            execute = null;
        } else {
            try {
                execute = f9687a.newCall(new Request.Builder().url(str).addHeader(HttpHeaders.ACCEPT, "image/webp, */*").build()).execute();
            } catch (IOException e) {
                Log.e("HttpManager", "okHttp failed, exception:" + e);
                throw new OkHttpException(e);
            } catch (Exception e2) {
                if (Base64ImageUrlDownloader.a(str)) {
                    Base64ImageUrlDownloader.a(str, str2, fileHttpResponseHandler, iRequestHost);
                    return;
                }
                Log.e("HttpManager", "okHttp failed, exception:" + e2);
                throw new OkHttpException(e2);
            }
        }
        b(execute, str, str2, fileHttpResponseHandler, iRequestHost);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Not initialized variable reg: 19, insn: 0x0354: MOVE  (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r19 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:150:0x0354 */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0282  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x02d0  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x031e  */
    /* JADX WARN: Removed duplicated region for block: B:178:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:179:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:180:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void b(okhttp3.Response r6, java.lang.String r7, java.lang.String r8, com.blued.android.core.net.FileHttpResponseHandler r9, com.blued.android.core.net.IRequestHost r10) {
        /*
            Method dump skipped, instructions count: 913
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.core.net.http.OkHttpUtils.b(okhttp3.Response, java.lang.String, java.lang.String, com.blued.android.core.net.FileHttpResponseHandler, com.blued.android.core.net.IRequestHost):void");
    }
}
