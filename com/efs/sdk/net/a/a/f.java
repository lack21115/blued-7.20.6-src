package com.efs.sdk.net.a.a;

import java.io.InputStream;

/* loaded from: source-8110460-dex2jar.jar:com/efs/sdk/net/a/a/f.class */
public interface f {

    /* loaded from: source-8110460-dex2jar.jar:com/efs/sdk/net/a/a/f$a.class */
    public interface a extends b {
        String b();

        String c();

        byte[] d();
    }

    /* loaded from: source-8110460-dex2jar.jar:com/efs/sdk/net/a/a/f$b.class */
    public interface b {
        String a();
    }

    /* loaded from: source-8110460-dex2jar.jar:com/efs/sdk/net/a/a/f$c.class */
    public interface c extends d {
    }

    /* loaded from: source-8110460-dex2jar.jar:com/efs/sdk/net/a/a/f$d.class */
    public interface d {
        String a();

        int b();
    }

    InputStream a(String str, String str2, String str3, InputStream inputStream);

    void a();

    void a(a aVar);

    void a(c cVar);

    String b();
}
