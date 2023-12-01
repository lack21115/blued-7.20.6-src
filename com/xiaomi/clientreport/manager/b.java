package com.xiaomi.clientreport.manager;

import com.xiaomi.clientreport.data.EventClientReport;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/clientreport/manager/b.class */
public class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ EventClientReport f41173a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ a f101a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, EventClientReport eventClientReport) {
        this.f101a = aVar;
        this.f41173a = eventClientReport;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f101a.b(this.f41173a);
    }
}
