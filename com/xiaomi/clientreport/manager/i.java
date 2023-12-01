package com.xiaomi.clientreport.manager;

import com.xiaomi.push.bp;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/clientreport/manager/i.class */
class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f27489a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ bp f57a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(a aVar, bp bpVar) {
        this.f27489a = aVar;
        this.f57a = bpVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f57a.run();
    }
}
