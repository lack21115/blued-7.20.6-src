package com.xiaomi.push.service;

import com.xiaomi.push.service.bx;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/by.class */
class by implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bx f27966a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public by(bx bxVar) {
        this.f27966a = bxVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ConcurrentHashMap concurrentHashMap;
        try {
            concurrentHashMap = this.f27966a.f988a;
            for (bx.a aVar : concurrentHashMap.values()) {
                aVar.run();
            }
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m8344a("Sync job exception :" + e.getMessage());
        }
        this.f27966a.f989a = false;
    }
}
