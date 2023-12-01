package com.meizu.cloud.pushsdk.c.c;

import java.util.ArrayList;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/meizu/cloud/pushsdk/c/c/b.class */
public class b extends j {

    /* renamed from: a  reason: collision with root package name */
    private static final g f10407a = g.a("application/x-www-form-urlencoded");
    private final List<String> b;

    /* renamed from: c  reason: collision with root package name */
    private final List<String> f10408c;

    /* loaded from: source-7994992-dex2jar.jar:com/meizu/cloud/pushsdk/c/c/b$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final List<String> f10409a = new ArrayList();
        private final List<String> b = new ArrayList();

        public a a(String str, String str2) {
            this.f10409a.add(f.a(str, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true));
            this.b.add(f.a(str2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true));
            return this;
        }

        public b a() {
            return new b(this.f10409a, this.b);
        }

        public a b(String str, String str2) {
            this.f10409a.add(f.a(str, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true));
            this.b.add(f.a(str2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true));
            return this;
        }
    }

    private b(List<String> list, List<String> list2) {
        this.b = m.a(list);
        this.f10408c = m.a(list2);
    }

    private long a(com.meizu.cloud.pushsdk.c.g.c cVar, boolean z) {
        com.meizu.cloud.pushsdk.c.g.b bVar = z ? new com.meizu.cloud.pushsdk.c.g.b() : cVar.b();
        int size = this.b.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                bVar.b(38);
            }
            bVar.b(this.b.get(i));
            bVar.b(61);
            bVar.b(this.f10408c.get(i));
        }
        if (z) {
            long a2 = bVar.a();
            bVar.j();
            return a2;
        }
        return 0L;
    }

    @Override // com.meizu.cloud.pushsdk.c.c.j
    public g a() {
        return f10407a;
    }

    @Override // com.meizu.cloud.pushsdk.c.c.j
    public void a(com.meizu.cloud.pushsdk.c.g.c cVar) {
        a(cVar, false);
    }

    @Override // com.meizu.cloud.pushsdk.c.c.j
    public long b() {
        return a((com.meizu.cloud.pushsdk.c.g.c) null, true);
    }
}
