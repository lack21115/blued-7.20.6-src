package com.zk_oaction.adengine.bitmap;

import java.util.HashMap;

/* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/bitmap/a.class */
class a {

    /* renamed from: a  reason: collision with root package name */
    HashMap<String, C1100a> f41864a = new HashMap<>();

    /* renamed from: com.zk_oaction.adengine.bitmap.a$a  reason: collision with other inner class name */
    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/bitmap/a$a.class */
    class C1100a {

        /* renamed from: a  reason: collision with root package name */
        String f41865a;
        byte[] b;

        C1100a(a aVar, String str) {
            this.f41865a = str;
        }

        /* JADX WARN: Removed duplicated region for block: B:58:0x00a2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public byte[] a() {
            /*
                Method dump skipped, instructions count: 197
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.zk_oaction.adengine.bitmap.a.C1100a.a():byte[]");
        }
    }

    public void a() {
        synchronized (this) {
            this.f41864a.clear();
        }
    }

    public byte[] a(String str) {
        C1100a c1100a;
        synchronized (this) {
            C1100a c1100a2 = this.f41864a.get(str);
            c1100a = c1100a2;
            if (c1100a2 == null) {
                c1100a = new C1100a(this, str);
                this.f41864a.put(str, c1100a);
            }
        }
        return c1100a.a();
    }
}
