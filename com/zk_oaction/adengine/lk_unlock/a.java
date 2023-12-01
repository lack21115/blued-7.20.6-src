package com.zk_oaction.adengine.lk_unlock;

import java.util.ArrayList;

/* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_unlock/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private com.zk_oaction.adengine.lk_sdk.c f41980a;
    private com.zk_oaction.adengine.lk_expression.a b;

    /* renamed from: c  reason: collision with root package name */
    private com.zk_oaction.adengine.lk_expression.a f41981c;
    private ArrayList<C1110a> d = new ArrayList<>();
    private float e;
    private float f;
    private boolean g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.zk_oaction.adengine.lk_unlock.a$a  reason: collision with other inner class name */
    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_unlock/a$a.class */
    public static class C1110a {

        /* renamed from: a  reason: collision with root package name */
        com.zk_oaction.adengine.lk_expression.a f41982a;
        com.zk_oaction.adengine.lk_expression.a b;

        public C1110a(com.zk_oaction.adengine.lk_expression.a aVar, com.zk_oaction.adengine.lk_expression.a aVar2) {
            this.f41982a = aVar;
            this.b = aVar2;
        }
    }

    public a(com.zk_oaction.adengine.lk_sdk.c cVar) {
        this.f41980a = cVar;
    }

    private void a(float f, boolean z) {
        C1110a c1110a;
        C1110a c1110a2;
        C1110a c1110a3;
        float a2;
        com.zk_oaction.adengine.lk_expression.a aVar;
        int i = 0;
        float a3 = this.d.get(0).b.a() + f;
        C1110a c1110a4 = this.d.get(0);
        float a4 = c1110a4.b.a();
        ArrayList<C1110a> arrayList = this.d;
        C1110a c1110a5 = arrayList.get(arrayList.size() - 1);
        float a5 = c1110a5.b.a();
        float f2 = a4;
        C1110a c1110a6 = c1110a5;
        float f3 = a5;
        C1110a c1110a7 = c1110a4;
        if (a4 > a5) {
            f3 = a4;
            c1110a7 = c1110a5;
            c1110a6 = c1110a4;
            f2 = a5;
        }
        int i2 = (a3 > f2 ? 1 : (a3 == f2 ? 0 : -1));
        if (i2 > 0 || z) {
            int i3 = (a3 > f3 ? 1 : (a3 == f3 ? 0 : -1));
            if (i3 < 0 || z) {
                if (i2 <= 0 && z) {
                    c1110a = this.d.get(0);
                    c1110a3 = this.d.get(1);
                } else if (i3 < 0 || !z) {
                    c1110a = null;
                    C1110a c1110a8 = null;
                    while (true) {
                        c1110a2 = c1110a8;
                        if (i >= this.d.size() - 1) {
                            break;
                        }
                        C1110a c1110a9 = this.d.get(i);
                        i++;
                        C1110a c1110a10 = this.d.get(i);
                        c1110a = c1110a9;
                        c1110a2 = c1110a10;
                        if ((a3 - c1110a9.b.a()) * (a3 - c1110a10.b.a()) <= 0.0f) {
                            break;
                        }
                        c1110a = c1110a9;
                        c1110a8 = c1110a10;
                    }
                    this.e = c1110a.f41982a.a() + ((c1110a2.f41982a.a() - c1110a.f41982a.a()) * ((a3 - c1110a.b.a()) / (c1110a2.b.a() - c1110a.b.a()))) + this.b.a();
                    a2 = this.f41981c.a() + a3;
                    this.f = a2;
                } else {
                    ArrayList<C1110a> arrayList2 = this.d;
                    c1110a = arrayList2.get(arrayList2.size() - 2);
                    ArrayList<C1110a> arrayList3 = this.d;
                    c1110a3 = arrayList3.get(arrayList3.size() - 1);
                }
                c1110a2 = c1110a3;
                this.e = c1110a.f41982a.a() + ((c1110a2.f41982a.a() - c1110a.f41982a.a()) * ((a3 - c1110a.b.a()) / (c1110a2.b.a() - c1110a.b.a()))) + this.b.a();
                a2 = this.f41981c.a() + a3;
                this.f = a2;
            }
            this.e = c1110a6.f41982a.a() + this.b.a();
            aVar = c1110a6.b;
        } else {
            this.e = c1110a7.f41982a.a() + this.b.a();
            aVar = c1110a7.b;
        }
        a2 = aVar.a() + this.f41981c.a();
        this.f = a2;
    }

    private void b(float f, boolean z) {
        C1110a c1110a;
        C1110a c1110a2;
        C1110a c1110a3;
        float a2;
        com.zk_oaction.adengine.lk_expression.a aVar;
        int i = 0;
        float a3 = this.d.get(0).f41982a.a() + f;
        C1110a c1110a4 = this.d.get(0);
        float a4 = c1110a4.f41982a.a();
        ArrayList<C1110a> arrayList = this.d;
        C1110a c1110a5 = arrayList.get(arrayList.size() - 1);
        float a5 = c1110a5.f41982a.a();
        float f2 = a4;
        C1110a c1110a6 = c1110a5;
        float f3 = a5;
        C1110a c1110a7 = c1110a4;
        if (a4 > a5) {
            f3 = a4;
            c1110a7 = c1110a5;
            c1110a6 = c1110a4;
            f2 = a5;
        }
        int i2 = (a3 > f2 ? 1 : (a3 == f2 ? 0 : -1));
        if (i2 > 0 || z) {
            int i3 = (a3 > f3 ? 1 : (a3 == f3 ? 0 : -1));
            if (i3 < 0 || z) {
                if (i2 <= 0 && z) {
                    c1110a = this.d.get(0);
                    c1110a3 = this.d.get(1);
                } else if (i3 < 0 || !z) {
                    c1110a = null;
                    C1110a c1110a8 = null;
                    while (true) {
                        c1110a2 = c1110a8;
                        if (i >= this.d.size() - 1) {
                            break;
                        }
                        C1110a c1110a9 = this.d.get(i);
                        i++;
                        C1110a c1110a10 = this.d.get(i);
                        c1110a = c1110a9;
                        c1110a2 = c1110a10;
                        if ((a3 - c1110a9.f41982a.a()) * (a3 - c1110a10.f41982a.a()) <= 0.0f) {
                            break;
                        }
                        c1110a = c1110a9;
                        c1110a8 = c1110a10;
                    }
                    float a6 = (a3 - c1110a.f41982a.a()) / (c1110a2.f41982a.a() - c1110a.f41982a.a());
                    float a7 = c1110a2.b.a();
                    float a8 = c1110a.b.a();
                    this.e = this.b.a() + a3;
                    a2 = c1110a.b.a() + ((a7 - a8) * a6);
                    this.f = a2 + this.f41981c.a();
                } else {
                    ArrayList<C1110a> arrayList2 = this.d;
                    c1110a = arrayList2.get(arrayList2.size() - 2);
                    ArrayList<C1110a> arrayList3 = this.d;
                    c1110a3 = arrayList3.get(arrayList3.size() - 1);
                }
                c1110a2 = c1110a3;
                float a62 = (a3 - c1110a.f41982a.a()) / (c1110a2.f41982a.a() - c1110a.f41982a.a());
                float a72 = c1110a2.b.a();
                float a82 = c1110a.b.a();
                this.e = this.b.a() + a3;
                a2 = c1110a.b.a() + ((a72 - a82) * a62);
                this.f = a2 + this.f41981c.a();
            }
            this.e = c1110a6.f41982a.a() + this.b.a();
            aVar = c1110a6.b;
        } else {
            this.e = c1110a7.f41982a.a() + this.b.a();
            aVar = c1110a7.b;
        }
        a2 = aVar.a();
        this.f = a2 + this.f41981c.a();
    }

    public float a() {
        return this.e;
    }

    public void a(float f, float f2, boolean z) {
        if (this.g) {
            a(f2, z);
        } else {
            b(f, z);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x005e, code lost:
        r0 = r12.d.get(0);
        r0 = r12.d;
        r0 = r0.get(r0.size() - 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x00a2, code lost:
        if (java.lang.Math.abs(r0.f41982a.a() - r0.f41982a.a()) >= java.lang.Math.abs(r0.b.a() - r0.b.a())) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x00a5, code lost:
        r12.g = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x010f, code lost:
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:?, code lost:
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(org.xmlpull.v1.XmlPullParser r13, java.lang.String r14) {
        /*
            Method dump skipped, instructions count: 273
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zk_oaction.adengine.lk_unlock.a.a(org.xmlpull.v1.XmlPullParser, java.lang.String):boolean");
    }

    public float b() {
        return this.f;
    }
}
