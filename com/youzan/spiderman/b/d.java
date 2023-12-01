package com.youzan.spiderman.b;

import com.youzan.spiderman.utils.Logger;
import java.io.File;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/youzan/spiderman/b/d.class */
public final class d extends h<String, Long> {

    /* renamed from: c  reason: collision with root package name */
    private static d f28029c;

    /* renamed from: a  reason: collision with root package name */
    private String f28030a;
    private String b;

    private d(long j) {
        super(j);
        this.f28030a = com.youzan.spiderman.cache.g.i();
        this.b = com.youzan.spiderman.cache.g.h();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static d a() {
        if (f28029c == null) {
            f28029c = new d(c.d());
        }
        return f28029c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.youzan.spiderman.b.h
    public final /* synthetic */ void a(boolean z, String str, Long l, Long l2) {
        String str2 = str;
        super.a(z, str2, l, l2);
        File file = new File(this.b, str2);
        File file2 = new File(this.f28030a, str2);
        if (file.exists() && !file.delete()) {
            Logger.e("HtmlDataLruCache", "delete return false, file: " + file, new Object[0]);
        }
        if (!file2.exists() || file2.delete()) {
            return;
        }
        Logger.e("HtmlDataLruCache", "delete return false, file: " + file2, new Object[0]);
    }
}
