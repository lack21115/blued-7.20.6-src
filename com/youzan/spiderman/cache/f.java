package com.youzan.spiderman.cache;

import java.io.File;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/spiderman/cache/f.class */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    private static f f41805a;
    private final File b = new File(g.f());

    /* renamed from: c  reason: collision with root package name */
    private final File f41806c = new File(g.g());

    private f() {
    }

    public static f a() {
        if (f41805a == null) {
            f41805a = new f();
        }
        return f41805a;
    }

    public final File a(CacheUrl cacheUrl) {
        String md5 = cacheUrl.getMd5();
        File file = cacheUrl.isScript() ? new File(this.b, md5) : cacheUrl.isImg() ? new File(this.f41806c, md5) : null;
        if (file == null || !file.exists()) {
            return null;
        }
        return file;
    }
}
