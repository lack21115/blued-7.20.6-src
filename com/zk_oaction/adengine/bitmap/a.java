package com.zk_oaction.adengine.bitmap;

import java.util.HashMap;

/* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/bitmap/a.class */
class a {

    /* renamed from: a  reason: collision with root package name */
    HashMap<String, C0930a> f28173a = new HashMap<>();

    /* renamed from: com.zk_oaction.adengine.bitmap.a$a  reason: collision with other inner class name */
    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/bitmap/a$a.class */
    class C0930a {

        /* renamed from: a  reason: collision with root package name */
        String f28174a;
        byte[] b;

        C0930a(a aVar, String str) {
            this.f28174a = str;
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
            throw new UnsupportedOperationException("Method not decompiled: com.zk_oaction.adengine.bitmap.a.C0930a.a():byte[]");
        }
    }

    public void a() {
        synchronized (this) {
            this.f28173a.clear();
        }
    }

    public byte[] a(String str) {
        C0930a c0930a;
        synchronized (this) {
            C0930a c0930a2 = this.f28173a.get(str);
            c0930a = c0930a2;
            if (c0930a2 == null) {
                c0930a = new C0930a(this, str);
                this.f28173a.put(str, c0930a);
            }
        }
        return c0930a.a();
    }
}
