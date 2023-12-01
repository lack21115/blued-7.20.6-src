package com.alipay.security.mobile.module.http;

import com.alipay.tscenter.biz.rpc.report.general.DataReportService;
import com.alipay.tscenter.biz.rpc.report.general.model.DataReportRequest;
import com.alipay.tscenter.biz.rpc.report.general.model.DataReportResult;

/* loaded from: source-6737240-dex2jar.jar:com/alipay/security/mobile/module/http/c.class */
class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ DataReportRequest f4716a;
    final /* synthetic */ b b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, DataReportRequest dataReportRequest) {
        this.b = bVar;
        this.f4716a = dataReportRequest;
    }

    @Override // java.lang.Runnable
    public void run() {
        DataReportResult dataReportResult;
        DataReportResult dataReportResult2;
        DataReportService dataReportService;
        try {
            dataReportService = this.b.f4715c;
            DataReportResult unused = b.e = dataReportService.reportData(this.f4716a);
        } catch (Throwable th) {
            DataReportResult unused2 = b.e = new DataReportResult();
            dataReportResult = b.e;
            dataReportResult.success = false;
            dataReportResult2 = b.e;
            dataReportResult2.resultCode = "static data rpc upload error, " + com.alipay.security.mobile.module.a.a.a(th);
            new StringBuilder("rpc failed:").append(com.alipay.security.mobile.module.a.a.a(th));
        }
    }
}
