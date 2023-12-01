package com.kwad.sdk.core.diskcache.a;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.core.network.kwai.a;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.kwai.e;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.av;
import java.io.File;
import java.io.IOException;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/diskcache/a/a.class */
public final class a {
    private com.kwad.sdk.core.diskcache.kwai.a aeR;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.sdk.core.diskcache.a.a$a  reason: collision with other inner class name */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/diskcache/a/a$a.class */
    public static final class C0556a {
        static final a aeS = new a((byte) 0);
    }

    private a() {
    }

    /* synthetic */ a(byte b) {
        this();
    }

    private File bJ(String str) {
        if (vt() || TextUtils.isEmpty(str)) {
            return null;
        }
        return b.a(this.aeR, str);
    }

    private void init(Context context) {
        synchronized (this) {
            if (this.aeR != null || context == null) {
                return;
            }
            try {
                this.aeR = com.kwad.sdk.core.diskcache.kwai.a.a(av.cA(context), 1, 1, 209715200L);
            } catch (Throwable th) {
            }
        }
    }

    public static a vs() {
        return C0556a.aeS;
    }

    private boolean vt() {
        init(((e) ServiceProvider.get(e.class)).getContext());
        return this.aeR == null;
    }

    public final boolean a(String str, a.C0564a c0564a) {
        File bJ;
        if (vt() || TextUtils.isEmpty(str)) {
            return false;
        }
        String bK = c.bK(str);
        return b.a(this.aeR, str, bK, c0564a) && (bJ = bJ(bK)) != null && bJ.exists();
    }

    public final File aX(String str) {
        if (vt() || TextUtils.isEmpty(str)) {
            return null;
        }
        return bJ(c.bK(str));
    }

    public final boolean b(String str, String str2, a.C0564a c0564a) {
        File bJ;
        if (vt() || TextUtils.isEmpty(str)) {
            return false;
        }
        String bK = c.bK(str2);
        return b.a(this.aeR, str, bK, c0564a) && (bJ = bJ(bK)) != null && bJ.exists();
    }

    public final void bI(String str) {
        if (vt() || TextUtils.isEmpty(str)) {
            return;
        }
        b.a(this.aeR, str, c.bK(str));
    }

    public final void delete() {
        if (vt()) {
            return;
        }
        try {
            this.aeR.delete();
        } catch (IOException e) {
        }
    }

    public final boolean remove(String str) {
        if (vt()) {
            return false;
        }
        try {
            ao.ah(str, "cacheKey is not allowed empty");
            return this.aeR.remove(c.bK(str));
        } catch (IOException e) {
            return false;
        }
    }
}
