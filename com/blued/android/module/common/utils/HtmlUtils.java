package com.blued.android.module.common.utils;

import android.text.TextUtils;
import com.blued.android.framework.pool.ThreadExecutor;
import com.blued.android.framework.pool.ThreadManager;
import com.blued.android.framework.utils.Logger;
import com.j256.ormlite.stmt.query.SimpleComparison;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/utils/HtmlUtils.class */
public class HtmlUtils {

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/utils/HtmlUtils$HtmlCallback.class */
    public interface HtmlCallback {
        void onUIData(String str);
    }

    public static String a(String str) {
        int indexOf;
        String substring;
        int lastIndexOf;
        Logger.c("HttpUtils", "html===========" + str);
        return (TextUtils.isEmpty(str) || (indexOf = str.indexOf("</title>")) < 0 || (lastIndexOf = (substring = str.substring(0, indexOf)).lastIndexOf(SimpleComparison.GREATER_THAN_OPERATION)) < 0) ? "" : substring.substring(lastIndexOf + 1, substring.length());
    }

    public static void a(final String str, final HtmlCallback htmlCallback) {
        ThreadManager.a().a(new ThreadExecutor("HtmlUtils") { // from class: com.blued.android.module.common.utils.HtmlUtils.1
            @Override // com.blued.android.framework.pool.ThreadExecutor
            public void execute() {
                htmlCallback.onUIData(HtmlUtils.a(HtmlUtils.b(str)));
            }
        });
    }

    public static byte[] a(InputStream inputStream) throws IOException {
        byte[] bArr = new byte[1024];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                inputStream.close();
                byteArrayOutputStream.close();
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:75:0x012d  */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.net.HttpURLConnection] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String b(java.lang.String r6) {
        /*
            Method dump skipped, instructions count: 320
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.common.utils.HtmlUtils.b(java.lang.String):java.lang.String");
    }
}
