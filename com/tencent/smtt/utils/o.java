package com.tencent.smtt.utils;

import android.os.Build;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/utils/o.class */
public class o {

    /* renamed from: a  reason: collision with root package name */
    private b f25280a = null;
    private b b = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/utils/o$a.class */
    public class a {
        private String b;

        /* renamed from: c  reason: collision with root package name */
        private long f25282c;
        private long d;

        a(String str, long j, long j2) {
            this.b = str;
            this.f25282c = j;
            this.d = j2;
        }

        long a() {
            return this.f25282c;
        }

        long b() {
            return this.d;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/utils/o$b.class */
    public class b {
        private Map<String, a> b;

        b(File file) {
            HashMap hashMap = new HashMap();
            this.b = hashMap;
            hashMap.clear();
            a(file);
        }

        private void a(File file) {
            if (!file.isDirectory()) {
                if (file.isFile()) {
                    a(file.getName(), file.length(), file.lastModified());
                    return;
                }
                return;
            }
            File[] listFiles = file.listFiles();
            if (listFiles == null && Build.VERSION.SDK_INT >= 26) {
                return;
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= listFiles.length) {
                    return;
                }
                a(listFiles[i2]);
                i = i2 + 1;
            }
        }

        private void a(String str, long j, long j2) {
            if (str == null || str.length() <= 0 || j <= 0 || j2 <= 0) {
                return;
            }
            a aVar = new a(str, j, j2);
            if (this.b.containsKey(str)) {
                return;
            }
            this.b.put(str, aVar);
        }

        Map<String, a> a() {
            return this.b;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean a(com.tencent.smtt.utils.o.b r6, com.tencent.smtt.utils.o.b r7) {
        /*
            r5 = this;
            r0 = r6
            if (r0 == 0) goto L8a
            r0 = r6
            java.util.Map r0 = r0.a()
            if (r0 == 0) goto L8a
            r0 = r7
            if (r0 == 0) goto L8a
            r0 = r7
            java.util.Map r0 = r0.a()
            if (r0 == 0) goto L8a
            r0 = r6
            java.util.Map r0 = r0.a()
            r8 = r0
            r0 = r7
            java.util.Map r0 = r0.a()
            r6 = r0
            r0 = r8
            java.util.Set r0 = r0.entrySet()
            java.util.Iterator r0 = r0.iterator()
            r7 = r0
        L2c:
            r0 = r7
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L88
            r0 = r7
            java.lang.Object r0 = r0.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            r9 = r0
            r0 = r9
            java.lang.Object r0 = r0.getKey()
            java.lang.String r0 = (java.lang.String) r0
            r8 = r0
            r0 = r9
            java.lang.Object r0 = r0.getValue()
            com.tencent.smtt.utils.o$a r0 = (com.tencent.smtt.utils.o.a) r0
            r9 = r0
            r0 = r6
            r1 = r8
            boolean r0 = r0.containsKey(r1)
            if (r0 == 0) goto L86
            r0 = r6
            r1 = r8
            java.lang.Object r0 = r0.get(r1)
            com.tencent.smtt.utils.o$a r0 = (com.tencent.smtt.utils.o.a) r0
            r8 = r0
            r0 = r9
            long r0 = r0.a()
            r1 = r8
            long r1 = r1.a()
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L86
            r0 = r9
            long r0 = r0.b()
            r1 = r8
            long r1 = r1.b()
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L2c
        L86:
            r0 = 0
            return r0
        L88:
            r0 = 1
            return r0
        L8a:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.utils.o.a(com.tencent.smtt.utils.o$b, com.tencent.smtt.utils.o$b):boolean");
    }

    public void a(File file) {
        this.f25280a = new b(file);
    }

    public boolean a() {
        b bVar = this.b;
        return bVar != null && this.f25280a != null && bVar.a().size() == this.f25280a.a().size() && a(this.f25280a, this.b);
    }

    public void b(File file) {
        this.b = new b(file);
    }
}
