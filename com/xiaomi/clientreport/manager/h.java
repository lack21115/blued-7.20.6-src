package com.xiaomi.clientreport.manager;

import com.xiaomi.push.bo;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/clientreport/manager/h.class */
class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f27488a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ bo f56a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(a aVar, bo boVar) {
        this.f27488a = aVar;
        this.f56a = boVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f56a.run();
    }
}
