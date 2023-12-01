package com.zk_oaction.adengine.lk_unlock;

import java.util.ArrayList;

/* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_unlock/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private com.zk_oaction.adengine.lk_sdk.c f28289a;
    private com.zk_oaction.adengine.lk_expression.a b;

    /* renamed from: c  reason: collision with root package name */
    private com.zk_oaction.adengine.lk_expression.a f28290c;
    private ArrayList<C0940a> d = new ArrayList<>();
    private float e;
    private float f;
    private boolean g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.zk_oaction.adengine.lk_unlock.a$a  reason: collision with other inner class name */
    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_unlock/a$a.class */
    public static class C0940a {

        /* renamed from: a  reason: collision with root package name */
        com.zk_oaction.adengine.lk_expression.a f28291a;
        com.zk_oaction.adengine.lk_expression.a b;

        public C0940a(com.zk_oaction.adengine.lk_expression.a aVar, com.zk_oaction.adengine.lk_expression.a aVar2) {
            this.f28291a = aVar;
            this.b = aVar2;
        }
    }

    public a(com.zk_oaction.adengine.lk_sdk.c cVar) {
        this.f28289a = cVar;
    }

    private void a(float f, boolean z) {
        C0940a c0940a;
        C0940a c0940a2;
        C0940a c0940a3;
        float a2;
        com.zk_oaction.adengine.lk_expression.a aVar;
        int i = 0;
        float a3 = this.d.get(0).b.a() + f;
        C0940a c0940a4 = this.d.get(0);
        float a4 = c0940a4.b.a();
        ArrayList<C0940a> arrayList = this.d;
        C0940a c0940a5 = arrayList.get(arrayList.size() - 1);
        float a5 = c0940a5.b.a();
        float f2 = a4;
        C0940a c0940a6 = c0940a5;
        float f3 = a5;
        C0940a c0940a7 = c0940a4;
        if (a4 > a5) {
            f3 = a4;
            c0940a7 = c0940a5;
            c0940a6 = c0940a4;
            f2 = a5;
        }
        int i2 = (a3 > f2 ? 1 : (a3 == f2 ? 0 : -1));
        if (i2 > 0 || z) {
            int i3 = (a3 > f3 ? 1 : (a3 == f3 ? 0 : -1));
            if (i3 < 0 || z) {
                if (i2 <= 0 && z) {
                    c0940a = this.d.get(0);
                    c0940a3 = this.d.get(1);
                } else if (i3 < 0 || !z) {
                    c0940a = null;
                    C0940a c0940a8 = null;
                    while (true) {
                        c0940a2 = c0940a8;
                        if (i >= this.d.size() - 1) {
                            break;
                        }
                        C0940a c0940a9 = this.d.get(i);
                        i++;
                        C0940a c0940a10 = this.d.get(i);
                        c0940a = c0940a9;
                        c0940a2 = c0940a10;
                        if ((a3 - c0940a9.b.a()) * (a3 - c0940a10.b.a()) <= 0.0f) {
                            break;
                        }
                        c0940a = c0940a9;
                        c0940a8 = c0940a10;
                    }
                    this.e = c0940a.f28291a.a() + ((c0940a2.f28291a.a() - c0940a.f28291a.a()) * ((a3 - c0940a.b.a()) / (c0940a2.b.a() - c0940a.b.a()))) + this.b.a();
                    a2 = this.f28290c.a() + a3;
                    this.f = a2;
                } else {
                    ArrayList<C0940a> arrayList2 = this.d;
                    c0940a = arrayList2.get(arrayList2.size() - 2);
                    ArrayList<C0940a> arrayList3 = this.d;
                    c0940a3 = arrayList3.get(arrayList3.size() - 1);
                }
                c0940a2 = c0940a3;
                this.e = c0940a.f28291a.a() + ((c0940a2.f28291a.a() - c0940a.f28291a.a()) * ((a3 - c0940a.b.a()) / (c0940a2.b.a() - c0940a.b.a()))) + this.b.a();
                a2 = this.f28290c.a() + a3;
                this.f = a2;
            }
            this.e = c0940a6.f28291a.a() + this.b.a();
            aVar = c0940a6.b;
        } else {
            this.e = c0940a7.f28291a.a() + this.b.a();
            aVar = c0940a7.b;
        }
        a2 = aVar.a() + this.f28290c.a();
        this.f = a2;
    }

    private void b(float f, boolean z) {
        C0940a c0940a;
        C0940a c0940a2;
        C0940a c0940a3;
        float a2;
        com.zk_oaction.adengine.lk_expression.a aVar;
        int i = 0;
        float a3 = this.d.get(0).f28291a.a() + f;
        C0940a c0940a4 = this.d.get(0);
        float a4 = c0940a4.f28291a.a();
        ArrayList<C0940a> arrayList = this.d;
        C0940a c0940a5 = arrayList.get(arrayList.size() - 1);
        float a5 = c0940a5.f28291a.a();
        float f2 = a4;
        C0940a c0940a6 = c0940a5;
        float f3 = a5;
        C0940a c0940a7 = c0940a4;
        if (a4 > a5) {
            f3 = a4;
            c0940a7 = c0940a5;
            c0940a6 = c0940a4;
            f2 = a5;
        }
        int i2 = (a3 > f2 ? 1 : (a3 == f2 ? 0 : -1));
        if (i2 > 0 || z) {
            int i3 = (a3 > f3 ? 1 : (a3 == f3 ? 0 : -1));
            if (i3 < 0 || z) {
                if (i2 <= 0 && z) {
                    c0940a = this.d.get(0);
                    c0940a3 = this.d.get(1);
                } else if (i3 < 0 || !z) {
                    c0940a = null;
                    C0940a c0940a8 = null;
                    while (true) {
                        c0940a2 = c0940a8;
                        if (i >= this.d.size() - 1) {
                            break;
                        }
                        C0940a c0940a9 = this.d.get(i);
                        i++;
                        C0940a c0940a10 = this.d.get(i);
                        c0940a = c0940a9;
                        c0940a2 = c0940a10;
                        if ((a3 - c0940a9.f28291a.a()) * (a3 - c0940a10.f28291a.a()) <= 0.0f) {
                            break;
                        }
                        c0940a = c0940a9;
                        c0940a8 = c0940a10;
                    }
                    float a6 = (a3 - c0940a.f28291a.a()) / (c0940a2.f28291a.a() - c0940a.f28291a.a());
                    float a7 = c0940a2.b.a();
                    float a8 = c0940a.b.a();
                    this.e = this.b.a() + a3;
                    a2 = c0940a.b.a() + ((a7 - a8) * a6);
                    this.f = a2 + this.f28290c.a();
                } else {
                    ArrayList<C0940a> arrayList2 = this.d;
                    c0940a = arrayList2.get(arrayList2.size() - 2);
                    ArrayList<C0940a> arrayList3 = this.d;
                    c0940a3 = arrayList3.get(arrayList3.size() - 1);
                }
                c0940a2 = c0940a3;
                float a62 = (a3 - c0940a.f28291a.a()) / (c0940a2.f28291a.a() - c0940a.f28291a.a());
                float a72 = c0940a2.b.a();
                float a82 = c0940a.b.a();
                this.e = this.b.a() + a3;
                a2 = c0940a.b.a() + ((a72 - a82) * a62);
                this.f = a2 + this.f28290c.a();
            }
            this.e = c0940a6.f28291a.a() + this.b.a();
            aVar = c0940a6.b;
        } else {
            this.e = c0940a7.f28291a.a() + this.b.a();
            aVar = c0940a7.b;
        }
        a2 = aVar.a();
        this.f = a2 + this.f28290c.a();
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
        if (java.lang.Math.abs(r0.f28291a.a() - r0.f28291a.a()) >= java.lang.Math.abs(r0.b.a() - r0.b.a())) goto L30;
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
