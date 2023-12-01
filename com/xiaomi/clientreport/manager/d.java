package com.xiaomi.clientreport.manager;

import com.xiaomi.push.ai;
import java.util.concurrent.ExecutorService;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/clientreport/manager/d.class */
public class d extends ai.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f41175a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.f41175a = aVar;
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public String mo11550a() {
        return "100888";
    }

    @Override // java.lang.Runnable
    public void run() {
        int a2;
        ExecutorService executorService;
        a2 = this.f41175a.a();
        if (a2 > 0) {
            executorService = this.f41175a.f100a;
            executorService.execute(new e(this));
        }
    }
}
