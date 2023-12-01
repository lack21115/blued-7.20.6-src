package com.efs.sdk.base.core.d;

import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.protocol.ILogProtocol;
import java.io.File;

/* loaded from: source-7206380-dex2jar.jar:com/efs/sdk/base/core/d/b.class */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public a f8158a;
    public c b = new c();

    /* renamed from: c  reason: collision with root package name */
    public byte[] f8159c;
    public File d;

    public b(String str, byte b) {
        this.f8158a = new a(str, b);
    }

    public static b a(ILogProtocol iLogProtocol) {
        b bVar;
        b bVar2;
        try {
            bVar2 = new b(iLogProtocol.getLogType(), iLogProtocol.getLogProtocol());
        } catch (Exception e) {
            e = e;
            bVar = null;
        }
        try {
            int bodyType = iLogProtocol.getBodyType();
            if (bodyType == 0) {
                bVar2.b(0);
                bVar2.a(iLogProtocol.generate());
                return bVar2;
            } else if (bodyType == 1) {
                bVar2.b(1);
                bVar2.d = new File(iLogProtocol.getFilePath());
                return bVar2;
            } else {
                Log.w("efs.base", "Can not support body type: " + iLogProtocol.getBodyType());
                return bVar2;
            }
        } catch (Exception e2) {
            bVar = bVar2;
            e = e2;
            Log.e("efs.base", "log send error", e);
            return bVar;
        }
    }

    private void d() {
        byte[] bArr;
        if (this.f8158a.f8157c == 0 && (bArr = this.f8159c) != null) {
            this.f8158a.f = bArr.length;
        } else if (this.f8158a.f8157c == 1 && this.d.exists()) {
            this.f8158a.f = this.d.length();
        }
    }

    public final long a() {
        d();
        return this.f8158a.f;
    }

    public final void a(int i) {
        this.f8158a.e = i;
        d();
    }

    public final void a(String str) {
        this.f8158a.d = str;
    }

    public final void a(byte[] bArr) {
        this.f8159c = bArr;
        d();
    }

    public final void b(int i) {
        this.f8158a.f8157c = i;
    }

    public final boolean b() {
        return !"none".equals(this.f8158a.d);
    }

    public final void c() {
        this.b.f8160a = true;
    }
}
