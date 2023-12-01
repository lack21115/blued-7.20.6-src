package com.efs.sdk.net.a.a;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.zip.GZIPInputStream;

/* loaded from: source-8110460-dex2jar.jar:com/efs/sdk/net/a/a/e.class */
public final class e extends FilterOutputStream {
    private static final ExecutorService b = Executors.newCachedThreadPool();

    /* renamed from: a  reason: collision with root package name */
    private final Future<Void> f8229a;

    /* loaded from: source-8110460-dex2jar.jar:com/efs/sdk/net/a/a/e$a.class */
    static final class a implements Callable<Void> {

        /* renamed from: a  reason: collision with root package name */
        private final InputStream f8230a;
        private final OutputStream b;

        public a(InputStream inputStream, OutputStream outputStream) {
            this.f8230a = inputStream;
            this.b = outputStream;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Void call() {
            GZIPInputStream gZIPInputStream = new GZIPInputStream(this.f8230a);
            try {
                i.a(gZIPInputStream, this.b, new byte[1024]);
                gZIPInputStream.close();
                this.b.close();
                return null;
            } catch (Throwable th) {
                gZIPInputStream.close();
                this.b.close();
                throw th;
            }
        }
    }

    private e(OutputStream outputStream, Future<Void> future) {
        super(outputStream);
        this.f8229a = future;
    }

    public static e a(OutputStream outputStream) {
        PipedInputStream pipedInputStream = new PipedInputStream();
        return new e(new PipedOutputStream(pipedInputStream), b.submit(new a(pipedInputStream, outputStream)));
    }

    private static <T> T a(Future<T> future) {
        while (true) {
            try {
                return future.get();
            } catch (InterruptedException e) {
            } catch (ExecutionException e2) {
                Throwable cause = e2.getCause();
                d.a(cause, IOException.class);
                d.a(cause, Error.class);
                d.a(cause, RuntimeException.class);
                throw new RuntimeException(cause);
            }
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        try {
            super.close();
            try {
            } catch (IOException e) {
                throw e;
            }
        } finally {
            try {
                a(this.f8229a);
            } catch (IOException e2) {
            }
        }
    }
}
