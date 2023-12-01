package com.youzan.spiderman.b;

import com.youzan.spiderman.utils.Logger;
import java.io.File;
import java.util.LinkedHashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/youzan/spiderman/b/b.class */
public final class b extends com.youzan.spiderman.a.a {
    private static void b() {
        String[] list;
        e a2 = e.a();
        LinkedHashMap<String, Long> linkedHashMap = new LinkedHashMap<>();
        File file = new File(com.youzan.spiderman.cache.g.g());
        if (file.exists() && file.isDirectory() && (list = file.list()) != null) {
            int length = list.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                String str = list[i2];
                if (!a2.a((e) str)) {
                    linkedHashMap.put(str, Long.valueOf(new File(file, str).length()));
                }
                i = i2 + 1;
            }
        }
        if (linkedHashMap.isEmpty()) {
            return;
        }
        f.a().b(linkedHashMap);
    }

    private static void c() {
        String[] list;
        d a2 = d.a();
        LinkedHashMap<String, Long> linkedHashMap = new LinkedHashMap<>();
        File file = new File(com.youzan.spiderman.cache.g.h());
        if (file.exists() && file.isDirectory() && (list = file.list()) != null) {
            int length = list.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                String str = list[i2];
                if (!a2.a((d) str)) {
                    linkedHashMap.put(str, Long.valueOf(new File(file, str).length()));
                }
                i = i2 + 1;
            }
        }
        if (linkedHashMap.isEmpty()) {
            return;
        }
        f.a().c(linkedHashMap);
    }

    @Override // com.youzan.spiderman.a.a
    public final void a() throws Throwable {
        String[] list;
        g a2 = g.a();
        LinkedHashMap<String, Long> linkedHashMap = new LinkedHashMap<>();
        File file = new File(com.youzan.spiderman.cache.g.f());
        if (file.exists() && file.isDirectory() && (list = file.list()) != null) {
            int length = list.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                String str = list[i2];
                if (!a2.a((g) str)) {
                    linkedHashMap.put(str, Long.valueOf(new File(file, str).length()));
                }
                i = i2 + 1;
            }
        }
        if (!linkedHashMap.isEmpty()) {
            f.a().a(linkedHashMap);
        }
        b();
        c();
    }

    @Override // com.youzan.spiderman.a.a
    public final void a(Throwable th) {
        Logger.e("CheckCacheJob", th);
    }
}
