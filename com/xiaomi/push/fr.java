package com.xiaomi.push;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/fr.class */
public class fr extends Thread {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ fq f27725a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fr(fq fqVar, String str) {
        super(str);
        this.f27725a = fqVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        fl flVar;
        try {
            flVar = this.f27725a.f27724a;
            flVar.m8718a();
        } catch (Exception e) {
            this.f27725a.c(9, e);
        }
    }
}
