package com.xiaomi.push;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/ge.class */
class ge implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ gb f41434a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f507a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ge(gb gbVar, String str) {
        this.f41434a = gbVar;
        this.f507a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        ct.a().a(this.f507a, true);
    }
}
