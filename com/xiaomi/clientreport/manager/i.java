package com.xiaomi.clientreport.manager;

import com.xiaomi.push.bp;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/clientreport/manager/i.class */
class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f41180a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ bp f104a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(a aVar, bp bpVar) {
        this.f41180a = aVar;
        this.f104a = bpVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f104a.run();
    }
}
