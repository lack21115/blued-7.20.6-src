package com.anythink.core.common.g.a;

import com.anythink.core.common.g.a.d;
import java.io.ByteArrayOutputStream;
import java.util.zip.GZIPOutputStream;
import org.json.JSONObject;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/g/a/c.class */
public abstract class c {
    public static final int d = 1;
    public static final int e = 2;
    public static final int f = 2;
    public static final int g = 3;
    public static final int h = 4;

    /* renamed from: a  reason: collision with root package name */
    private final int f6712a = 0;
    protected int i;
    protected String j;

    /* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/g/a/c$a.class */
    public interface a {
        void a(Object obj);

        void a(Throwable th);
    }

    private static JSONObject a() {
        return com.anythink.core.common.g.c.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static byte[] a(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(str.getBytes("utf-8"));
            gZIPOutputStream.close();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return byteArrayOutputStream.toByteArray();
    }

    public final void a(int i, String str) {
        this.i = i;
        this.j = str;
    }

    public final void a(a aVar) {
        com.anythink.core.common.k.b.a.a().a((com.anythink.core.common.k.b.b) new d.AnonymousClass1(this, aVar), 4);
    }

    public void a(String str, String str2, String str3, int i) {
    }

    public abstract int c();

    public abstract int d();

    public abstract byte[] e();

    public abstract boolean f();

    /* JADX INFO: Access modifiers changed from: protected */
    public final JSONObject g() {
        return com.anythink.core.common.g.c.a(h());
    }

    protected int h() {
        return 0;
    }
}
