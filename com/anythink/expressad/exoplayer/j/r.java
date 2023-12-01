package com.anythink.expressad.exoplayer.j;

import android.net.Uri;
import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/j/r.class */
public final class r implements h {

    /* renamed from: a  reason: collision with root package name */
    private final aa<? super r> f7600a;
    private RandomAccessFile b;

    /* renamed from: c  reason: collision with root package name */
    private Uri f7601c;
    private long d;
    private boolean e;

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/j/r$a.class */
    public static final class a extends IOException {
        public a(IOException iOException) {
            super(iOException);
        }
    }

    public r() {
        this(null);
    }

    public r(aa<? super r> aaVar) {
        this.f7600a = aaVar;
    }

    @Override // com.anythink.expressad.exoplayer.j.h
    public final int a(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return 0;
        }
        long j = this.d;
        if (j == 0) {
            return -1;
        }
        try {
            int read = this.b.read(bArr, i, (int) Math.min(j, i2));
            if (read > 0) {
                this.d -= read;
                aa<? super r> aaVar = this.f7600a;
                if (aaVar != null) {
                    aaVar.a(read);
                }
            }
            return read;
        } catch (IOException e) {
            throw new a(e);
        }
    }

    @Override // com.anythink.expressad.exoplayer.j.h
    public final long a(k kVar) {
        try {
            this.f7601c = kVar.f7584c;
            RandomAccessFile randomAccessFile = new RandomAccessFile(kVar.f7584c.getPath(), "r");
            this.b = randomAccessFile;
            randomAccessFile.seek(kVar.f);
            long length = kVar.g == -1 ? this.b.length() - kVar.f : kVar.g;
            this.d = length;
            if (length < 0) {
                throw new EOFException();
            }
            this.e = true;
            aa<? super r> aaVar = this.f7600a;
            if (aaVar != null) {
                aaVar.b();
            }
            return this.d;
        } catch (IOException e) {
            throw new a(e);
        }
    }

    @Override // com.anythink.expressad.exoplayer.j.h
    public final Uri a() {
        return this.f7601c;
    }

    @Override // com.anythink.expressad.exoplayer.j.h
    public final void b() {
        this.f7601c = null;
        try {
            try {
                if (this.b != null) {
                    this.b.close();
                }
            } catch (IOException e) {
                throw new a(e);
            }
        } finally {
            this.b = null;
            if (this.e) {
                this.e = false;
                aa<? super r> aaVar = this.f7600a;
                if (aaVar != null) {
                    aaVar.c();
                }
            }
        }
    }
}
