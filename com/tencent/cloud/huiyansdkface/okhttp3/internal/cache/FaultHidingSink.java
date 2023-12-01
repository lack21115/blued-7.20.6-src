package com.tencent.cloud.huiyansdkface.okhttp3.internal.cache;

import com.tencent.cloud.huiyansdkface.okio.Buffer;
import com.tencent.cloud.huiyansdkface.okio.ForwardingSink;
import com.tencent.cloud.huiyansdkface.okio.Sink;
import java.io.IOException;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/okhttp3/internal/cache/FaultHidingSink.class */
class FaultHidingSink extends ForwardingSink {

    /* renamed from: a  reason: collision with root package name */
    private boolean f35926a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FaultHidingSink(Sink sink) {
        super(sink);
    }

    protected void a(IOException iOException) {
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.ForwardingSink, com.tencent.cloud.huiyansdkface.okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f35926a) {
            return;
        }
        try {
            super.close();
        } catch (IOException e) {
            this.f35926a = true;
            a(e);
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.ForwardingSink, com.tencent.cloud.huiyansdkface.okio.Sink, java.io.Flushable
    public void flush() throws IOException {
        if (this.f35926a) {
            return;
        }
        try {
            super.flush();
        } catch (IOException e) {
            this.f35926a = true;
            a(e);
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.ForwardingSink, com.tencent.cloud.huiyansdkface.okio.Sink
    public void write(Buffer buffer, long j) throws IOException {
        if (this.f35926a) {
            buffer.skip(j);
            return;
        }
        try {
            super.write(buffer, j);
        } catch (IOException e) {
            this.f35926a = true;
            a(e);
        }
    }
}
