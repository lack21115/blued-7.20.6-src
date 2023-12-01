package com.youzan.spiderman.d;

import com.youzan.spiderman.utils.Logger;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.concurrent.CountDownLatch;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/spiderman/d/c.class */
public final class c implements Runnable {
    private static Charset e = Charset.forName("UTF-8");

    /* renamed from: a  reason: collision with root package name */
    private d f41812a;
    private PipedInputStream b = new PipedInputStream(8192);

    /* renamed from: c  reason: collision with root package name */
    private PipedOutputStream f41813c;
    private CountDownLatch d;

    public c(d dVar) {
        this.f41812a = dVar;
        try {
            this.f41813c = new PipedOutputStream(this.b);
        } catch (IOException e2) {
            Logger.e("StreamEncodingTransfer", "piped output stream exception", e2);
        }
        this.d = new CountDownLatch(1);
    }

    public final InputStream a() {
        return new BufferedInputStream(this.b) { // from class: com.youzan.spiderman.d.c.1
            @Override // java.io.BufferedInputStream, java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public final void close() throws IOException {
                c.this.d.countDown();
                super.close();
            }
        };
    }

    @Override // java.lang.Runnable
    public final void run() {
        OutputStreamWriter outputStreamWriter;
        IOException e2;
        Reader b = this.f41812a.b();
        char[] cArr = new char[4096];
        OutputStreamWriter outputStreamWriter2 = null;
        try {
            try {
                outputStreamWriter = new OutputStreamWriter(new BufferedOutputStream(this.f41813c), e);
                while (true) {
                    try {
                        int read = b.read(cArr, 0, 4096);
                        if (read != -1) {
                            outputStreamWriter.write(cArr, 0, read);
                        } else {
                            try {
                                break;
                            } catch (IOException e3) {
                                Logger.e("StreamEncodingTransfer", "close exception", e3);
                            }
                        }
                    } catch (IOException e4) {
                        e2 = e4;
                        outputStreamWriter2 = outputStreamWriter;
                        Logger.e("StreamEncodingTransfer", "transfer exception", e2);
                        try {
                            b.close();
                        } catch (IOException e5) {
                            Logger.e("StreamEncodingTransfer", "close exception", e5);
                        }
                        if (outputStreamWriter != null) {
                            try {
                                outputStreamWriter.close();
                            } catch (IOException e6) {
                                Logger.e("StreamEncodingTransfer", "close output stream reader exception", e6);
                            }
                        }
                        if (this.d.getCount() != 0) {
                            try {
                                this.d.await();
                                return;
                            } catch (InterruptedException e7) {
                                Logger.e("StreamEncodingTransfer", "latch wait exception", e7);
                                return;
                            }
                        }
                        return;
                    } catch (Throwable th) {
                        outputStreamWriter2 = outputStreamWriter;
                        th = th;
                        try {
                            b.close();
                        } catch (IOException e8) {
                            Logger.e("StreamEncodingTransfer", "close exception", e8);
                        }
                        if (outputStreamWriter2 != null) {
                            try {
                                outputStreamWriter2.close();
                            } catch (IOException e9) {
                                Logger.e("StreamEncodingTransfer", "close output stream reader exception", e9);
                            }
                        }
                        if (this.d.getCount() != 0) {
                            try {
                                this.d.await();
                            } catch (InterruptedException e10) {
                                Logger.e("StreamEncodingTransfer", "latch wait exception", e10);
                            }
                        }
                        throw th;
                    }
                }
                b.close();
                try {
                    outputStreamWriter.close();
                } catch (IOException e11) {
                    Logger.e("StreamEncodingTransfer", "close output stream reader exception", e11);
                }
                if (this.d.getCount() != 0) {
                    try {
                        this.d.await();
                    } catch (InterruptedException e12) {
                        Logger.e("StreamEncodingTransfer", "latch wait exception", e12);
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e13) {
            outputStreamWriter = null;
            e2 = e13;
        }
    }
}
