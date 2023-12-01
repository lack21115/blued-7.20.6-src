package com.tencent.qimei.o;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qimei/o/o.class */
public class o implements com.tencent.qimei.d.c {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f24697a;
    public final /* synthetic */ r b;

    public o(r rVar, String str) {
        this.b = rVar;
        this.f24697a = str;
    }

    @Override // com.tencent.qimei.d.c
    public void a(String str, int i, String str2) {
        this.b.a(str, i, str2);
    }

    @Override // com.tencent.qimei.d.c
    public void a(String str, String... strArr) {
        r.b(this.b);
        this.b.a(str, this.f24697a);
    }
}
