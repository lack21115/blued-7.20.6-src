package com.opos.exoplayer.core.h;

import android.net.Uri;
import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/h/p.class */
public final class p implements g {

    /* renamed from: a  reason: collision with root package name */
    private final t<? super p> f25464a;
    private RandomAccessFile b;

    /* renamed from: c  reason: collision with root package name */
    private Uri f25465c;
    private long d;
    private boolean e;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/h/p$a.class */
    public static class a extends IOException {
        public a(IOException iOException) {
            super(iOException);
        }
    }

    public p() {
        this(null);
    }

    public p(t<? super p> tVar) {
        this.f25464a = tVar;
    }

    @Override // com.opos.exoplayer.core.h.g
    public int a(byte[] bArr, int i, int i2) {
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
                t<? super p> tVar = this.f25464a;
                if (tVar != null) {
                    tVar.a((t<? super p>) this, read);
                }
            }
            return read;
        } catch (IOException e) {
            throw new a(e);
        }
    }

    @Override // com.opos.exoplayer.core.h.g
    public long a(i iVar) {
        try {
            this.f25465c = iVar.f25449a;
            RandomAccessFile randomAccessFile = new RandomAccessFile(iVar.f25449a.getPath(), "r");
            this.b = randomAccessFile;
            randomAccessFile.seek(iVar.d);
            long length = iVar.e == -1 ? this.b.length() - iVar.d : iVar.e;
            this.d = length;
            if (length < 0) {
                throw new EOFException();
            }
            this.e = true;
            t<? super p> tVar = this.f25464a;
            if (tVar != null) {
                tVar.a((t<? super p>) this, iVar);
            }
            return this.d;
        } catch (IOException e) {
            throw new a(e);
        }
    }

    @Override // com.opos.exoplayer.core.h.g
    public Uri a() {
        return this.f25465c;
    }

    @Override // com.opos.exoplayer.core.h.g
    public void b() {
        this.f25465c = null;
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
                t<? super p> tVar = this.f25464a;
                if (tVar != null) {
                    tVar.a(this);
                }
            }
        }
    }
}
