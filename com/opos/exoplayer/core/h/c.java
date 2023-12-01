package com.opos.exoplayer.core.h;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/h/c.class */
public final class c implements g {

    /* renamed from: a  reason: collision with root package name */
    private final AssetManager f25442a;
    private final t<? super c> b;

    /* renamed from: c  reason: collision with root package name */
    private Uri f25443c;
    private InputStream d;
    private long e;
    private boolean f;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/h/c$a.class */
    public static final class a extends IOException {
        public a(IOException iOException) {
            super(iOException);
        }
    }

    public c(Context context, t<? super c> tVar) {
        this.f25442a = context.getAssets();
        this.b = tVar;
    }

    @Override // com.opos.exoplayer.core.h.g
    public int a(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return 0;
        }
        long j = this.e;
        if (j != 0) {
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
            t<? super c> tVar = this.b;
            if (tVar != null) {
                tVar.a((t<? super c>) this, read);
            }
            return read;
        }
        return -1;
    }

    @Override // com.opos.exoplayer.core.h.g
    public long a(i iVar) {
        String str;
        try {
            Uri uri = iVar.f25449a;
            this.f25443c = uri;
            String path = uri.getPath();
            if (path.startsWith("/android_asset/")) {
                str = path.substring(15);
            } else {
                str = path;
                if (path.startsWith(BridgeUtil.SPLIT_MARK)) {
                    str = path.substring(1);
                }
            }
            InputStream open = this.f25442a.open(str, 1);
            this.d = open;
            if (open.skip(iVar.d) >= iVar.d) {
                if (iVar.e != -1) {
                    this.e = iVar.e;
                } else {
                    long available = this.d.available();
                    this.e = available;
                    if (available == 2147483647L) {
                        this.e = -1L;
                    }
                }
                this.f = true;
                t<? super c> tVar = this.b;
                if (tVar != null) {
                    tVar.a((t<? super c>) this, iVar);
                }
                return this.e;
            }
            throw new EOFException();
        } catch (IOException e) {
            throw new a(e);
        }
    }

    @Override // com.opos.exoplayer.core.h.g
    public Uri a() {
        return this.f25443c;
    }

    @Override // com.opos.exoplayer.core.h.g
    public void b() {
        this.f25443c = null;
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
                t<? super c> tVar = this.b;
                if (tVar != null) {
                    tVar.a(this);
                }
            }
        }
    }
}
