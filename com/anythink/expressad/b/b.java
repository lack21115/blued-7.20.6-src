package com.anythink.expressad.b;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Map;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/b/b.class */
public final class b extends com.anythink.core.common.res.image.b {

    /* renamed from: a  reason: collision with root package name */
    String f4281a;

    private b(String str, String str2) {
        super(str);
        this.f4281a = str2;
    }

    public final Map<String, String> a() {
        return null;
    }

    public final void a(com.anythink.core.common.k.b.b bVar) {
        com.anythink.core.common.k.b.a.a().a(bVar, 2);
    }

    public final void a(String str, String str2) {
    }

    public final boolean a(InputStream inputStream) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(this.f4281a);
            byte[] bArr = new byte[2048];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    fileOutputStream.close();
                    return true;
                }
                fileOutputStream.write(bArr, 0, read);
            }
        } catch (Throwable th) {
            return false;
        }
    }

    public final void b() {
    }

    public final void c() {
    }
}
