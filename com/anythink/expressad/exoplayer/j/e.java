package com.anythink.expressad.exoplayer.j;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.FileChannel;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/j/e.class */
public final class e implements h {

    /* renamed from: a  reason: collision with root package name */
    private final ContentResolver f4737a;
    private final aa<? super e> b;

    /* renamed from: c  reason: collision with root package name */
    private Uri f4738c;
    private AssetFileDescriptor d;
    private FileInputStream e;
    private long f;
    private boolean g;

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/j/e$a.class */
    public static final class a extends IOException {
        public a(IOException iOException) {
            super(iOException);
        }
    }

    private e(Context context) {
        this(context, null);
    }

    public e(Context context, aa<? super e> aaVar) {
        this.f4737a = context.getContentResolver();
        this.b = aaVar;
    }

    @Override // com.anythink.expressad.exoplayer.j.h
    public final int a(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return 0;
        }
        long j = this.f;
        if (j == 0) {
            return -1;
        }
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
        aa<? super e> aaVar = this.b;
        if (aaVar != null) {
            aaVar.a(read);
        }
        return read;
    }

    @Override // com.anythink.expressad.exoplayer.j.h
    public final long a(k kVar) {
        try {
            Uri uri = kVar.f4745c;
            this.f4738c = uri;
            AssetFileDescriptor openAssetFileDescriptor = this.f4737a.openAssetFileDescriptor(uri, "r");
            this.d = openAssetFileDescriptor;
            if (openAssetFileDescriptor == null) {
                throw new FileNotFoundException("Could not open file descriptor for: " + this.f4738c);
            }
            this.e = new FileInputStream(this.d.getFileDescriptor());
            long startOffset = this.d.getStartOffset();
            long skip = this.e.skip(kVar.f + startOffset) - startOffset;
            if (skip == kVar.f) {
                long j = -1;
                if (kVar.g != -1) {
                    this.f = kVar.g;
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
                aa<? super e> aaVar = this.b;
                if (aaVar != null) {
                    aaVar.b();
                }
                return this.f;
            }
            throw new EOFException();
        } catch (IOException e) {
            throw new a(e);
        }
    }

    @Override // com.anythink.expressad.exoplayer.j.h
    public final Uri a() {
        return this.f4738c;
    }

    @Override // com.anythink.expressad.exoplayer.j.h
    public final void b() {
        this.f4738c = null;
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
                        aa<? super e> aaVar = this.b;
                        if (aaVar != null) {
                            aaVar.c();
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
                        aa<? super e> aaVar2 = this.b;
                        if (aaVar2 != null) {
                            aaVar2.c();
                        }
                    }
                    throw th;
                } catch (IOException e3) {
                    throw new a(e3);
                }
            } finally {
                this.d = null;
                if (this.g) {
                    this.g = false;
                    aa<? super e> aaVar3 = this.b;
                    if (aaVar3 != null) {
                        aaVar3.c();
                    }
                }
            }
        }
    }
}
