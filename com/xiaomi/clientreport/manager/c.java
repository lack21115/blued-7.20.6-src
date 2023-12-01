package com.xiaomi.clientreport.manager;

import com.xiaomi.clientreport.data.PerfClientReport;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/clientreport/manager/c.class */
public class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PerfClientReport f27483a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ a f55a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar, PerfClientReport perfClientReport) {
        this.f55a = aVar;
        this.f27483a = perfClientReport;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f55a.b(this.f27483a);
    }
}
