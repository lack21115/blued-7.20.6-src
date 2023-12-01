package com.youzan.spiderman.cache;

import java.io.File;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/spiderman/cache/f.class */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    private static f f28114a;
    private final File b = new File(g.f());

    /* renamed from: c  reason: collision with root package name */
    private final File f28115c = new File(g.g());

    private f() {
    }

    public static f a() {
        if (f28114a == null) {
            f28114a = new f();
        }
        return f28114a;
    }

    public final File a(CacheUrl cacheUrl) {
        String md5 = cacheUrl.getMd5();
        File file = cacheUrl.isScript() ? new File(this.b, md5) : cacheUrl.isImg() ? new File(this.f28115c, md5) : null;
        if (file == null || !file.exists()) {
            return null;
        }
        return file;
    }
}
