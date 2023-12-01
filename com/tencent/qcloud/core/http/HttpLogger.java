package com.tencent.qcloud.core.http;

import com.tencent.qcloud.core.http.HttpLoggingInterceptor;
import com.tencent.qcloud.core.logger.FileLogAdapter;
import com.tencent.qcloud.core.logger.QCloudLogger;
import java.util.ArrayList;
import java.util.List;
import okhttp3.Response;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qcloud/core/http/HttpLogger.class */
public class HttpLogger implements HttpLoggingInterceptor.Logger {
    private boolean debuggable;
    private FileLogAdapter fileLogAdapter;
    private List<String> mRequestBufferLogs;
    private String tag;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HttpLogger(boolean z) {
        this(z, QCloudHttpClient.HTTP_LOG_TAG);
    }

    public HttpLogger(boolean z, String str) {
        this.debuggable = z;
        this.tag = str;
        this.mRequestBufferLogs = new ArrayList(10);
    }

    private void flushRequestBufferLogs() {
        synchronized (this) {
            synchronized (this.mRequestBufferLogs) {
                if (this.fileLogAdapter != null && this.mRequestBufferLogs.size() > 0) {
                    for (String str : this.mRequestBufferLogs) {
                        this.fileLogAdapter.log(4, this.tag, str, null);
                    }
                    this.mRequestBufferLogs.clear();
                }
            }
        }
    }

    @Override // com.tencent.qcloud.core.http.HttpLoggingInterceptor.Logger
    public void logException(Exception exc, String str) {
        QCloudLogger.i(this.tag, str, new Object[0]);
        if (this.fileLogAdapter != null && exc != null) {
            flushRequestBufferLogs();
            this.fileLogAdapter.log(4, this.tag, str, exc);
            return;
        }
        synchronized (this.mRequestBufferLogs) {
            this.mRequestBufferLogs.clear();
        }
    }

    @Override // com.tencent.qcloud.core.http.HttpLoggingInterceptor.Logger
    public void logRequest(String str) {
        if (this.debuggable) {
            QCloudLogger.i(this.tag, str, new Object[0]);
        }
        FileLogAdapter fileLogAdapter = (FileLogAdapter) QCloudLogger.getAdapter(FileLogAdapter.class);
        this.fileLogAdapter = fileLogAdapter;
        if (fileLogAdapter != null) {
            synchronized (this.mRequestBufferLogs) {
                this.mRequestBufferLogs.add(str);
            }
        }
    }

    @Override // com.tencent.qcloud.core.http.HttpLoggingInterceptor.Logger
    public void logResponse(Response response, String str) {
        if (this.debuggable) {
            QCloudLogger.i(this.tag, str, new Object[0]);
        }
        if (this.fileLogAdapter != null && response != null && !response.isSuccessful()) {
            flushRequestBufferLogs();
            this.fileLogAdapter.log(4, this.tag, str, null);
            return;
        }
        synchronized (this.mRequestBufferLogs) {
            this.mRequestBufferLogs.clear();
        }
    }

    public void setDebug(boolean z) {
        this.debuggable = z;
    }

    public void setTag(String str) {
        this.tag = str;
    }
}
