package com.xiaomi.push;

import com.xiaomi.push.al;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/an.class */
class an implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ al.b f27563a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ al f136a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(al alVar, al.b bVar) {
        this.f136a = alVar;
        this.f27563a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f136a.a(this.f27563a);
    }
}
