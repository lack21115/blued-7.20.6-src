package com.blued.android.statistics.grpc.connect;

import android.os.SystemClock;
import com.blued.android.statistics.BluedStatistics;
import com.blued.android.statistics.StatConfig;
import com.blued.android.statistics.grpc.ConnectManager;
import com.blued.android.statistics.grpc.StatThreadManager;
import com.blued.android.statistics.util.NamedRunnable;
import com.blued.das.apm.ApmProtos;
import com.blued.das.apm.ReportServiceGrpc;
import java.util.concurrent.TimeUnit;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/statistics/grpc/connect/ApmManager.class */
public final class ApmManager extends BaseManager<ApmProtos.Request> {

    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/statistics/grpc/connect/ApmManager$ApmRunnable.class */
    class ApmRunnable extends NamedRunnable {
        private ApmProtos.Requests b;

        public ApmRunnable(ApmProtos.Requests requests) {
            super(StatConfig.a("apm"));
            this.b = requests;
        }

        @Override // com.blued.android.statistics.util.NamedRunnable
        public void a() {
            ApmProtos.Response response;
            if (StatConfig.e()) {
                StatConfig.b().b("APM start-request @", Thread.currentThread().getName(), "\n", this.b);
            }
            ReportServiceGrpc.ReportServiceBlockingStub reportServiceBlockingStub = (ReportServiceGrpc.ReportServiceBlockingStub) ((ReportServiceGrpc.ReportServiceBlockingStub) ((ReportServiceGrpc.ReportServiceBlockingStub) ConnectManager.a(ReportServiceGrpc.newBlockingStub(ConnectManager.a()))).withCompression("gzip")).withDeadlineAfter(30L, TimeUnit.SECONDS);
            ApmProtos.Response response2 = null;
            long uptimeMillis = SystemClock.uptimeMillis();
            try {
                ApmProtos.Response batchReport = reportServiceBlockingStub.batchReport(this.b);
                response = batchReport;
                if (batchReport != null) {
                    response2 = batchReport;
                    batchReport.getCode();
                    response = batchReport;
                }
            } catch (Exception e) {
                response = response2;
                if (StatConfig.e()) {
                    e.printStackTrace();
                    response = response2;
                }
            }
            long uptimeMillis2 = SystemClock.uptimeMillis();
            if (StatConfig.e()) {
                StatConfig.b().b("APM ", Long.valueOf(uptimeMillis2 - uptimeMillis), ", ", response);
            }
        }
    }

    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/statistics/grpc/connect/ApmManager$InstanceHolder.class */
    static class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final ApmManager f18712a = new ApmManager();

        private InstanceHolder() {
        }
    }

    private ApmManager() {
    }

    public static ApmManager a() {
        return InstanceHolder.f18712a;
    }

    @Override // com.blued.android.statistics.grpc.connect.BaseManager
    protected void a(Object[] objArr) {
        ApmProtos.Requests.Builder newBuilder = ApmProtos.Requests.newBuilder();
        newBuilder.setCommon(BluedStatistics.a().b());
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= objArr.length) {
                StatThreadManager.a(new ApmRunnable(newBuilder.build()));
                return;
            } else {
                newBuilder.addRequest((ApmProtos.Request) objArr[i2]);
                i = i2 + 1;
            }
        }
    }

    @Override // com.blued.android.statistics.grpc.connect.BaseManager
    protected long b() {
        return 5000L;
    }

    @Override // com.blued.android.statistics.grpc.connect.BaseManager
    protected boolean c() {
        return StatConfig.d();
    }
}
