package com.xiaomi.clientreport.manager;

import com.xiaomi.push.ai;
import java.util.concurrent.ExecutorService;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/clientreport/manager/f.class */
public class f extends ai.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f41177a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(a aVar) {
        this.f41177a = aVar;
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public String mo11550a() {
        return "100889";
    }

    @Override // java.lang.Runnable
    public void run() {
        int b;
        ExecutorService executorService;
        b = this.f41177a.b();
        if (b > 0) {
            executorService = this.f41177a.f100a;
            executorService.execute(new g(this));
        }
    }
}
