package com.xiaomi.clientreport.manager;

import com.xiaomi.push.bo;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/clientreport/manager/h.class */
class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f41179a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ bo f103a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(a aVar, bo boVar) {
        this.f41179a = aVar;
        this.f103a = boVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f103a.run();
    }
}
