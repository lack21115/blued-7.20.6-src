package com.anythink.expressad.exoplayer.j;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/j/c.class */
public final class c implements h {

    /* renamed from: a  reason: collision with root package name */
    private final AssetManager f7574a;
    private final aa<? super c> b;

    /* renamed from: c  reason: collision with root package name */
    private Uri f7575c;
    private InputStream d;
    private long e;
    private boolean f;

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/j/c$a.class */
    public static final class a extends IOException {
        public a(IOException iOException) {
            super(iOException);
        }
    }

    private c(Context context) {
        this(context, null);
    }

    public c(Context context, aa<? super c> aaVar) {
        this.f7574a = context.getAssets();
        this.b = aaVar;
    }

    @Override // com.anythink.expressad.exoplayer.j.h
    public final int a(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return 0;
        }
        long j = this.e;
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
        int read = this.d.read(bArr, i, i2);
        if (read == -1) {
            if (this.e == -1) {
                return -1;
            }
            throw new a(new EOFException());
        }
        long j2 = this.e;
        if (j2 != -1) {
            this.e = j2 - read;
        }
        aa<? super c> aaVar = this.b;
        if (aaVar != null) {
            aaVar.a(read);
        }
        return read;
    }

    @Override // com.anythink.expressad.exoplayer.j.h
    public final long a(k kVar) {
        String str;
        try {
            Uri uri = kVar.f7584c;
            this.f7575c = uri;
            String path = uri.getPath();
            if (path.startsWith("/android_asset/")) {
                str = path.substring(15);
            } else {
                str = path;
                if (path.startsWith(BridgeUtil.SPLIT_MARK)) {
                    str = path.substring(1);
                }
            }
            InputStream open = this.f7574a.open(str, 1);
            this.d = open;
            if (open.skip(kVar.f) >= kVar.f) {
                if (kVar.g != -1) {
                    this.e = kVar.g;
                } else {
                    long available = this.d.available();
                    this.e = available;
                    if (available == 2147483647L) {
                        this.e = -1L;
                    }
                }
                this.f = true;
                aa<? super c> aaVar = this.b;
                if (aaVar != null) {
                    aaVar.b();
                }
                return this.e;
            }
            throw new EOFException();
        } catch (IOException e) {
            throw new a(e);
        }
    }

    @Override // com.anythink.expressad.exoplayer.j.h
    public final Uri a() {
        return this.f7575c;
    }

    @Override // com.anythink.expressad.exoplayer.j.h
    public final void b() {
        this.f7575c = null;
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
            if (this.f) {
                this.f = false;
                aa<? super c> aaVar = this.b;
                if (aaVar != null) {
                    aaVar.c();
                }
            }
        }
    }
}
