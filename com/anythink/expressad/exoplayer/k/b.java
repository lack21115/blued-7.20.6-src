package com.anythink.expressad.exoplayer.k;

import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/k/b.class */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static final String f7635a = "AtomicFile";
    private final File b;

    /* renamed from: c  reason: collision with root package name */
    private final File f7636c;

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/k/b$a.class */
    static final class a extends OutputStream {

        /* renamed from: a  reason: collision with root package name */
        private final FileOutputStream f7639a;
        private boolean b = false;

        public a(File file) {
            this.f7639a = new FileOutputStream(file);
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            if (this.b) {
                return;
            }
            this.b = true;
            flush();
            try {
                this.f7639a.getFD().sync();
            } catch (IOException e) {
                Log.w(b.f7635a, "Failed to sync file descriptor:", e);
            }
            this.f7639a.close();
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public final void flush() {
            this.f7639a.flush();
        }

        @Override // java.io.OutputStream
        public final void write(int i) {
            this.f7639a.write(i);
        }

        @Override // java.io.OutputStream
        public final void write(byte[] bArr) {
            this.f7639a.write(bArr);
        }

        @Override // java.io.OutputStream
        public final void write(byte[] bArr, int i, int i2) {
            this.f7639a.write(bArr, i, i2);
        }
    }

    public b(File file) {
        this.b = file;
        this.f7636c = new File(file.getPath() + ".bak");
    }

    private void d() {
        if (this.f7636c.exists()) {
            this.b.delete();
            this.f7636c.renameTo(this.b);
        }
    }

    public final void a() {
        this.b.delete();
        this.f7636c.delete();
    }

    public final void a(OutputStream outputStream) {
        outputStream.close();
        this.f7636c.delete();
    }

    public final OutputStream b() {
        if (this.b.exists()) {
            if (this.f7636c.exists()) {
                this.b.delete();
            } else if (!this.b.renameTo(this.f7636c)) {
                Log.w(f7635a, "Couldn't rename file " + this.b + " to backup file " + this.f7636c);
            }
        }
        try {
            return new a(this.b);
        } catch (FileNotFoundException e) {
            if (!this.b.getParentFile().mkdirs()) {
                throw new IOException("Couldn't create directory " + this.b, e);
            }
            try {
                return new a(this.b);
            } catch (FileNotFoundException e2) {
                throw new IOException("Couldn't create " + this.b, e2);
            }
        }
    }

    public final InputStream c() {
        if (this.f7636c.exists()) {
            this.b.delete();
            this.f7636c.renameTo(this.b);
        }
        return new FileInputStream(this.b);
    }
}
