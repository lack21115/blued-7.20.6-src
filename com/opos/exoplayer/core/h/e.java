package com.opos.exoplayer.core.h;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.FileChannel;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/h/e.class */
public final class e implements g {

    /* renamed from: a  reason: collision with root package name */
    private final ContentResolver f25444a;
    private final t<? super e> b;

    /* renamed from: c  reason: collision with root package name */
    private Uri f25445c;
    private AssetFileDescriptor d;
    private FileInputStream e;
    private long f;
    private boolean g;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/h/e$a.class */
    public static class a extends IOException {
        public a(IOException iOException) {
            super(iOException);
        }
    }

    public e(Context context, t<? super e> tVar) {
        this.f25444a = context.getContentResolver();
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
            t<? super e> tVar = this.b;
            if (tVar != null) {
                tVar.a((t<? super e>) this, read);
            }
            return read;
        }
        return -1;
    }

    @Override // com.opos.exoplayer.core.h.g
    public long a(i iVar) {
        try {
            Uri uri = iVar.f25449a;
            this.f25445c = uri;
            AssetFileDescriptor openAssetFileDescriptor = this.f25444a.openAssetFileDescriptor(uri, "r");
            this.d = openAssetFileDescriptor;
            if (openAssetFileDescriptor == null) {
                throw new FileNotFoundException("Could not open file descriptor for: " + this.f25445c);
            }
            this.e = new FileInputStream(this.d.getFileDescriptor());
            long startOffset = this.d.getStartOffset();
            long skip = this.e.skip(iVar.d + startOffset) - startOffset;
            if (skip == iVar.d) {
                long j = -1;
                if (iVar.e != -1) {
                    this.f = iVar.e;
                } else {
                    long length = this.d.getLength();
                    if (length == -1) {
                        FileChannel channel = this.e.getChannel();
                        long size = channel.size();
                        if (size != 0) {
                            j = size - channel.position();
                        }
                        this.f = j;
                    } else {
                        this.f = length - skip;
                    }
                }
                this.g = true;
                t<? super e> tVar = this.b;
                if (tVar != null) {
                    tVar.a((t<? super e>) this, iVar);
                }
                return this.f;
            }
            throw new EOFException();
        } catch (IOException e) {
            throw new a(e);
        }
    }

    @Override // com.opos.exoplayer.core.h.g
    public Uri a() {
        return this.f25445c;
    }

    @Override // com.opos.exoplayer.core.h.g
    public void b() {
        this.f25445c = null;
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
                        t<? super e> tVar = this.b;
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
                        t<? super e> tVar2 = this.b;
                        if (tVar2 != null) {
                            tVar2.a(this);
                        }
                    }
                    throw th;
                } finally {
                    this.d = null;
                    if (this.g) {
                        this.g = false;
                        t<? super e> tVar3 = this.b;
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
