package com.opos.exoplayer.core.h;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import com.anythink.expressad.exoplayer.j.y;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/h/s.class */
public final class s implements g {

    /* renamed from: a  reason: collision with root package name */
    private final Resources f25477a;
    private final t<? super s> b;

    /* renamed from: c  reason: collision with root package name */
    private Uri f25478c;
    private AssetFileDescriptor d;
    private InputStream e;
    private long f;
    private boolean g;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/h/s$a.class */
    public static class a extends IOException {
        public a(IOException iOException) {
            super(iOException);
        }

        public a(String str) {
            super(str);
        }
    }

    public s(Context context, t<? super s> tVar) {
        this.f25477a = context.getResources();
        this.b = tVar;
    }

    @Override // com.opos.exoplayer.core.h.g
    public int a(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return 0;
        }
        long j = this.f;
        if (j != 0) {
            if (j != -1) {
                try {
                    i2 = (int) Math.min(j, i2);
                } catch (IOException e) {
                    throw new a(e);
                }
            }
            int read = this.e.read(bArr, i, i2);
            if (read == -1) {
                if (this.f == -1) {
                    return -1;
                }
                throw new a(new EOFException());
            }
            long j2 = this.f;
            if (j2 != -1) {
                this.f = j2 - read;
            }
            t<? super s> tVar = this.b;
            if (tVar != null) {
                tVar.a((t<? super s>) this, read);
            }
            return read;
        }
        return -1;
    }

    @Override // com.opos.exoplayer.core.h.g
    public long a(i iVar) {
        try {
            Uri uri = iVar.f25449a;
            this.f25478c = uri;
            if (TextUtils.equals(y.f7618a, uri.getScheme())) {
                try {
                    this.d = this.f25477a.openRawResourceFd(Integer.parseInt(this.f25478c.getLastPathSegment()));
                    FileInputStream fileInputStream = new FileInputStream(this.d.getFileDescriptor());
                    this.e = fileInputStream;
                    fileInputStream.skip(this.d.getStartOffset());
                    if (this.e.skip(iVar.d) >= iVar.d) {
                        long j = -1;
                        if (iVar.e != -1) {
                            this.f = iVar.e;
                        } else {
                            long length = this.d.getLength();
                            if (length != -1) {
                                j = length - iVar.d;
                            }
                            this.f = j;
                        }
                        this.g = true;
                        t<? super s> tVar = this.b;
                        if (tVar != null) {
                            tVar.a((t<? super s>) this, iVar);
                        }
                        return this.f;
                    }
                    throw new EOFException();
                } catch (NumberFormatException e) {
                    throw new a("Resource identifier must be an integer.");
                }
            }
            throw new a("URI must use scheme rawresource");
        } catch (IOException e2) {
            throw new a(e2);
        }
    }

    @Override // com.opos.exoplayer.core.h.g
    public Uri a() {
        return this.f25478c;
    }

    @Override // com.opos.exoplayer.core.h.g
    public void b() {
        this.f25478c = null;
        try {
            try {
                if (this.e != null) {
                    this.e.close();
                }
                this.e = null;
                try {
                    try {
                        if (this.d != null) {
                            this.d.close();
                        }
                    } catch (IOException e) {
                        throw new a(e);
                    }
                } finally {
                    this.d = null;
                    if (this.g) {
                        this.g = false;
                        t<? super s> tVar = this.b;
                        if (tVar != null) {
                            tVar.a(this);
                        }
                    }
                }
            } catch (IOException e2) {
                throw new a(e2);
            }
        } catch (Throwable th) {
            this.e = null;
            try {
                try {
                    if (this.d != null) {
                        this.d.close();
                    }
                    this.d = null;
                    if (this.g) {
                        this.g = false;
                        t<? super s> tVar2 = this.b;
                        if (tVar2 != null) {
                            tVar2.a(this);
                        }
                    }
                    throw th;
                } finally {
                    this.d = null;
                    if (this.g) {
                        this.g = false;
                        t<? super s> tVar3 = this.b;
                        if (tVar3 != null) {
                            tVar3.a(this);
                        }
                    }
                }
            } catch (IOException e3) {
                throw new a(e3);
            }
        }
    }
}
