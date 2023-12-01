package com.xiaomi.clientreport.manager;

import com.xiaomi.clientreport.data.EventClientReport;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/clientreport/manager/b.class */
public class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ EventClientReport f27482a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ a f54a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, EventClientReport eventClientReport) {
        this.f54a = aVar;
        this.f27482a = eventClientReport;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f54a.b(this.f27482a);
    }
}
