package com.sobot.network.http.request;

import com.sobot.network.http.SobotOkHttpUtils;
import com.sobot.network.http.callback.Callback;
import com.sobot.network.http.model.SobotProgress;
import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.Buffer;
import okio.BufferedSink;
import okio.ForwardingSink;
import okio.Okio;
import okio.Sink;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/network/http/request/ProgressRequestBody.class */
public class ProgressRequestBody extends RequestBody {
    private Callback callback;
    private UploadInterceptor interceptor;
    private RequestBody requestBody;

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/network/http/request/ProgressRequestBody$CountingSink.class */
    final class CountingSink extends ForwardingSink {
        private SobotProgress progress;

        CountingSink(Sink sink) {
            super(sink);
            SobotProgress sobotProgress = new SobotProgress();
            this.progress = sobotProgress;
            sobotProgress.totalSize = ProgressRequestBody.this.contentLength();
        }

        @Override // okio.ForwardingSink, okio.Sink
        public void write(Buffer buffer, long j) throws IOException {
            super.write(buffer, j);
            SobotProgress.changeProgress(this.progress, j, new SobotProgress.Action() { // from class: com.sobot.network.http.request.ProgressRequestBody.CountingSink.1
                @Override // com.sobot.network.http.model.SobotProgress.Action
                public void call(SobotProgress sobotProgress) {
                    if (ProgressRequestBody.this.interceptor != null) {
                        ProgressRequestBody.this.interceptor.uploadProgress(sobotProgress);
                    } else {
                        ProgressRequestBody.this.onProgress(sobotProgress);
                    }
                }
            });
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/network/http/request/ProgressRequestBody$UploadInterceptor.class */
    public interface UploadInterceptor {
        void uploadProgress(SobotProgress sobotProgress);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ProgressRequestBody(RequestBody requestBody, Callback callback) {
        this.requestBody = requestBody;
        this.callback = callback;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onProgress(final SobotProgress sobotProgress) {
        SobotOkHttpUtils.runOnUiThread(new Runnable() { // from class: com.sobot.network.http.request.ProgressRequestBody.1
            @Override // java.lang.Runnable
            public void run() {
                if (ProgressRequestBody.this.callback != null) {
                    ProgressRequestBody.this.callback.inProgress(sobotProgress.fraction);
                }
            }
        });
    }

    @Override // okhttp3.RequestBody
    public long contentLength() {
        try {
            return this.requestBody.contentLength();
        } catch (IOException e) {
            return -1L;
        }
    }

    @Override // okhttp3.RequestBody
    public MediaType contentType() {
        return this.requestBody.contentType();
    }

    public void setInterceptor(UploadInterceptor uploadInterceptor) {
        this.interceptor = uploadInterceptor;
    }

    @Override // okhttp3.RequestBody
    public void writeTo(BufferedSink bufferedSink) throws IOException {
        BufferedSink buffer = Okio.buffer(new CountingSink(bufferedSink));
        this.requestBody.writeTo(buffer);
        buffer.flush();
    }
}
