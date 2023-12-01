package com.blued.android.core.net;

import android.content.ContentResolver;
import java.io.File;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/net/FileHttpResponseHandler.class */
public abstract class FileHttpResponseHandler extends HttpResponseHandler<File> {
    @Override // com.blued.android.core.net.http.AbstractHttpResponseHandler
    public long getResponseLength(File file) {
        if (file == null) {
            return 0L;
        }
        return file.length();
    }

    @Override // com.blued.android.core.net.http.AbstractHttpResponseHandler
    public String getResponseType() {
        return ContentResolver.SCHEME_FILE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00a0, code lost:
        sendCancelMessage("request is cancelled");
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00a8, code lost:
        r15 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0153 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.blued.android.core.net.http.AbstractHttpResponseHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.io.File parseResponse(int r6, okhttp3.ResponseBody r7) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 370
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.core.net.FileHttpResponseHandler.parseResponse(int, okhttp3.ResponseBody):java.io.File");
    }
}
