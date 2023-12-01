package com.xiaomi.push.service;

import com.xiaomi.push.service.bx;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/by.class */
class by implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bx f41657a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public by(bx bxVar) {
        this.f41657a = bxVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ConcurrentHashMap concurrentHashMap;
        try {
            concurrentHashMap = this.f41657a.f1035a;
            for (bx.a aVar : concurrentHashMap.values()) {
                aVar.run();
            }
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m11394a("Sync job exception :" + e.getMessage());
        }
        this.f41657a.f1036a = false;
    }
}
