package com.blued.android.core.net.http;

import android.text.TextUtils;
import android.util.Base64;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.FileHttpResponseHandler;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.utils.ByteArrayPool;
import com.tencent.ugc.common.UGCConstants;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/net/http/Base64ImageUrlDownloader.class */
public class Base64ImageUrlDownloader {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v7, types: [java.io.OutputStream, java.io.FileOutputStream] */
    public static void a(String str, String str2, FileHttpResponseHandler fileHttpResponseHandler, IRequestHost iRequestHost) {
        OutputStream outputStream;
        OutputStream outputStream2;
        File file;
        int indexOf = str.indexOf(";base64,");
        if (indexOf <= 0) {
            return;
        }
        String substring = str.substring(indexOf + 8);
        try {
            try {
                file = new File((String) str2);
                if (!file.exists()) {
                    file.createNewFile();
                }
                str2 = new FileOutputStream(file);
            } catch (IOException e) {
                e = e;
                outputStream2 = null;
            } catch (Exception e2) {
                e = e2;
                outputStream = null;
            } catch (Throwable th) {
                th = th;
                str2 = 0;
            }
            try {
                str2.write(Base64.decode(substring, 0));
                str2.flush();
                if (fileHttpResponseHandler != null) {
                    fileHttpResponseHandler.sendSuccessMessage(str, 200, file);
                }
                ByteArrayPool.f9730a.a((byte[]) null);
                AppMethods.a((OutputStream) str2);
                if (fileHttpResponseHandler == null) {
                    return;
                }
            } catch (IOException e3) {
                e = e3;
                outputStream2 = str2;
                e.printStackTrace();
                if (fileHttpResponseHandler != null) {
                    fileHttpResponseHandler.sendFailureMessage(str, e, StatusCode.a(e), null);
                }
                ByteArrayPool.f9730a.a((byte[]) null);
                AppMethods.a(outputStream2);
                if (fileHttpResponseHandler == null) {
                    return;
                }
                fileHttpResponseHandler.sendFinishMessage();
            } catch (Exception e4) {
                e = e4;
                outputStream = str2;
                e.printStackTrace();
                if (fileHttpResponseHandler != null) {
                    fileHttpResponseHandler.sendFailureMessage(str, e, UGCConstants.ERR_BGM_UNSUPPORT_SYSTEM, null);
                }
                ByteArrayPool.f9730a.a((byte[]) null);
                AppMethods.a(outputStream);
                if (fileHttpResponseHandler == null) {
                    return;
                }
                fileHttpResponseHandler.sendFinishMessage();
            } catch (Throwable th2) {
                th = th2;
                ByteArrayPool.f9730a.a((byte[]) null);
                AppMethods.a((OutputStream) str2);
                if (fileHttpResponseHandler != null) {
                    fileHttpResponseHandler.sendFinishMessage();
                }
                throw th;
            }
            fileHttpResponseHandler.sendFinishMessage();
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("data:image/gif;base64,") || str.startsWith("data:image/png;base64,") || str.startsWith("data:image/jpeg;base64,") || str.startsWith("data:image/x-icon;base64,");
    }
}
