package com.youzan.spiderman.b;

import com.youzan.spiderman.utils.Logger;
import java.io.File;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/youzan/spiderman/b/e.class */
public final class e extends h<String, Long> {
    private static e b;

    /* renamed from: a  reason: collision with root package name */
    private String f41722a;

    private e(int i) {
        super(i);
        this.f41722a = com.youzan.spiderman.cache.g.g();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static e a() {
        if (b == null) {
            b = new e(c.b());
        }
        return b;
    }

    @Override // com.youzan.spiderman.b.h
    protected final /* synthetic */ long a(String str, Long l) {
        return l.longValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.youzan.spiderman.b.h
    public final /* synthetic */ void a(boolean z, String str, Long l, Long l2) {
        String str2 = str;
        super.a(z, str2, l, l2);
        File file = new File(this.f41722a, str2);
        if (!file.exists() || file.delete()) {
            return;
        }
        Logger.e("ImageLruCache", "delete return false, file:" + file, new Object[0]);
    }
}
