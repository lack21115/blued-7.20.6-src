package com.loopj.android.http;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;

/* loaded from: source-7994992-dex2jar.jar:com/loopj/android/http/FileAsyncHttpResponseHandler.class */
public abstract class FileAsyncHttpResponseHandler extends AsyncHttpResponseHandler {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String LOG_TAG = "FileAsyncHttpResponseHandler";
    protected final boolean append;
    protected final File mFile;

    public FileAsyncHttpResponseHandler(Context context) {
        this.mFile = getTemporaryFile(context);
        this.append = false;
    }

    public FileAsyncHttpResponseHandler(File file) {
        this(file, false);
    }

    public FileAsyncHttpResponseHandler(File file, boolean z) {
        AssertUtils.asserts(file != null, "File passed into FileAsyncHttpResponseHandler constructor must not be null");
        this.mFile = file;
        this.append = z;
    }

    public boolean deleteTargetFile() {
        return getTargetFile() != null && getTargetFile().delete();
    }

    @Override // com.loopj.android.http.AsyncHttpResponseHandler
    protected byte[] getResponseData(HttpEntity httpEntity) throws IOException {
        if (httpEntity != null) {
            InputStream content = httpEntity.getContent();
            long contentLength = httpEntity.getContentLength();
            FileOutputStream fileOutputStream = new FileOutputStream(getTargetFile(), this.append);
            if (content != null) {
                try {
                    byte[] bArr = new byte[4096];
                    int i = 0;
                    while (true) {
                        int read = content.read(bArr);
                        if (read == -1 || Thread.currentThread().isInterrupted()) {
                            break;
                        }
                        i += read;
                        fileOutputStream.write(bArr, 0, read);
                        sendProgressMessage(i, (int) contentLength);
                    }
                    return null;
                } finally {
                    AsyncHttpClient.silentCloseInputStream(content);
                    fileOutputStream.flush();
                    AsyncHttpClient.silentCloseOutputStream(fileOutputStream);
                }
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public File getTargetFile() {
        return this.mFile;
    }

    protected File getTemporaryFile(Context context) {
        AssertUtils.asserts(context != null, "Tried creating temporary file without having Context");
        try {
            return File.createTempFile("temp_", "_handled", context.getCacheDir());
        } catch (IOException e) {
            Log.e(LOG_TAG, "Cannot create temporary file", e);
            return null;
        }
    }

    public abstract void onFailure(int i, Header[] headerArr, Throwable th, File file);

    @Override // com.loopj.android.http.AsyncHttpResponseHandler
    public final void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
        onFailure(i, headerArr, th, getTargetFile());
    }

    public abstract void onSuccess(int i, Header[] headerArr, File file);

    @Override // com.loopj.android.http.AsyncHttpResponseHandler
    public final void onSuccess(int i, Header[] headerArr, byte[] bArr) {
        onSuccess(i, headerArr, getTargetFile());
    }
}
