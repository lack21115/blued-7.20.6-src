package com.qiniu.android.http;

import com.qiniu.android.http.CancellationHandler;
import com.qiniu.android.utils.AsyncRun;
import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.Buffer;
import okio.BufferedSink;
import okio.ForwardingSink;
import okio.Okio;
import okio.Sink;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/android/http/CountingRequestBody.class */
public final class CountingRequestBody extends RequestBody {
    private static final int SEGMENT_SIZE = 2048;
    private final RequestBody body;
    private final CancellationHandler cancellationHandler;
    private final ProgressHandler progress;
    private final long totalSize;

    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/android/http/CountingRequestBody$CountingSink.class */
    public final class CountingSink extends ForwardingSink {
        private int bytesWritten;

        public CountingSink(Sink sink) {
            super(sink);
            this.bytesWritten = 0;
        }

        @Override // okio.ForwardingSink, okio.Sink
        public void write(Buffer buffer, long j) throws IOException {
            if (CountingRequestBody.this.cancellationHandler == null && CountingRequestBody.this.progress == null) {
                super.write(buffer, j);
            } else if (CountingRequestBody.this.cancellationHandler != null && CountingRequestBody.this.cancellationHandler.isCancelled()) {
                throw new CancellationHandler.CancellationException();
            } else {
                super.write(buffer, j);
                this.bytesWritten = (int) (this.bytesWritten + j);
                if (CountingRequestBody.this.progress != null) {
                    AsyncRun.runInMain(new Runnable() { // from class: com.qiniu.android.http.CountingRequestBody.CountingSink.1
                        @Override // java.lang.Runnable
                        public void run() {
                            CountingRequestBody.this.progress.onProgress(CountingSink.this.bytesWritten, CountingRequestBody.this.totalSize);
                        }
                    });
                }
            }
        }
    }

    public CountingRequestBody(RequestBody requestBody, ProgressHandler progressHandler, long j, CancellationHandler cancellationHandler) {
        this.body = requestBody;
        this.progress = progressHandler;
        this.totalSize = j;
        this.cancellationHandler = cancellationHandler;
    }

    @Override // okhttp3.RequestBody
    public long contentLength() throws IOException {
        return this.body.contentLength();
    }

    @Override // okhttp3.RequestBody
    public MediaType contentType() {
        return this.body.contentType();
    }

    @Override // okhttp3.RequestBody
    public void writeTo(BufferedSink bufferedSink) throws IOException {
        BufferedSink buffer = Okio.buffer(new CountingSink(bufferedSink));
        this.body.writeTo(buffer);
        buffer.flush();
    }
}
