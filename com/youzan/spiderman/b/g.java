package com.youzan.spiderman.b;

import com.youzan.spiderman.utils.Logger;
import java.io.File;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/youzan/spiderman/b/g.class */
public final class g extends h<String, Long> {
    private static g b;

    /* renamed from: a  reason: collision with root package name */
    private String f28039a;

    private g(int i) {
        super(i);
        this.f28039a = com.youzan.spiderman.cache.g.f();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static g a() {
        if (b == null) {
            b = new g(c.c());
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
        File file = new File(this.f28039a, str2);
        if (!file.exists() || file.delete()) {
            return;
        }
        Logger.e("ScriptLruCache", "delete return false, file:" + file, new Object[0]);
    }
}
