package com.blued.android.statistics.grpc.connect;

import android.os.SystemClock;
import com.blued.android.statistics.BluedStatistics;
import com.blued.android.statistics.StatConfig;
import com.blued.android.statistics.grpc.ConnectManager;
import com.blued.android.statistics.grpc.StatThreadManager;
import com.blued.android.statistics.util.NamedRunnable;
import com.blued.das.page.PageDurationProtos;
import com.blued.das.page.ReportServiceGrpc;
import com.sina.weibo.sdk.constant.WBPageConstants;
import java.util.concurrent.TimeUnit;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/statistics/grpc/connect/PageManager.class */
public final class PageManager extends BaseManager<PageDurationProtos.Request> {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/statistics/grpc/connect/PageManager$InstanceHolder.class */
    public static class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final PageManager f18724a = new PageManager();

        private InstanceHolder() {
        }
    }

    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/statistics/grpc/connect/PageManager$PageRunnable.class */
    class PageRunnable extends NamedRunnable {
        private PageDurationProtos.Requests b;

        public PageRunnable(PageDurationProtos.Requests requests) {
            super(StatConfig.a(WBPageConstants.ParamKey.PAGE));
            this.b = requests;
        }

        @Override // com.blued.android.statistics.util.NamedRunnable
        public void a() {
            PageDurationProtos.Response response;
            if (StatConfig.i()) {
                StatConfig.b().b("PAGE start-request \n", this.b);
            }
            ReportServiceGrpc.ReportServiceBlockingStub reportServiceBlockingStub = (ReportServiceGrpc.ReportServiceBlockingStub) ((ReportServiceGrpc.ReportServiceBlockingStub) ((ReportServiceGrpc.ReportServiceBlockingStub) ConnectManager.a(ReportServiceGrpc.newBlockingStub(ConnectManager.a()))).withCompression("gzip")).withDeadlineAfter(30L, TimeUnit.SECONDS);
            PageDurationProtos.Response response2 = null;
            long uptimeMillis = SystemClock.uptimeMillis();
            try {
                PageDurationProtos.Response batchReport = reportServiceBlockingStub.batchReport(this.b);
                response = batchReport;
                if (batchReport != null) {
                    response2 = batchReport;
                    batchReport.getCode();
                    response = batchReport;
                }
            } catch (Exception e) {
                response = response2;
                if (StatConfig.i()) {
                    e.printStackTrace();
                    response = response2;
                }
            }
            long uptimeMillis2 = SystemClock.uptimeMillis();
            if (StatConfig.i()) {
                StatConfig.b().b("PAGE ", Long.valueOf(uptimeMillis2 - uptimeMillis), ", ", response);
            }
        }
    }

    private PageManager() {
    }

    public static PageManager a() {
        return InstanceHolder.f18724a;
    }

    @Override // com.blued.android.statistics.grpc.connect.BaseManager
    protected void a(Object[] objArr) {
        PageDurationProtos.Requests.Builder newBuilder = PageDurationProtos.Requests.newBuilder();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= objArr.length) {
                newBuilder.setCommon(BluedStatistics.a().b());
                StatThreadManager.a(new PageRunnable(newBuilder.build()));
                return;
            }
            newBuilder.addRequest((PageDurationProtos.Request) objArr[i2]);
            i = i2 + 1;
        }
    }

    @Override // com.blued.android.statistics.grpc.connect.BaseManager
    protected long b() {
        return 5000L;
    }

    @Override // com.blued.android.statistics.grpc.connect.BaseManager
    protected boolean c() {
        return StatConfig.h();
    }
}
