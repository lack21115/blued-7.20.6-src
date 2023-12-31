package com.blued.android.statistics.grpc.connect;

import android.os.SystemClock;
import com.blued.android.statistics.BluedStatistics;
import com.blued.android.statistics.StatConfig;
import com.blued.android.statistics.biz.Dau;
import com.blued.android.statistics.grpc.ConnectManager;
import com.blued.android.statistics.grpc.StatThreadManager;
import com.blued.android.statistics.util.NamedRunnable;
import com.blued.android.statistics.util.Utils;
import com.blued.das.dau.DayActiveUserProtos;
import com.blued.das.dau.ReportServiceGrpc;
import com.efs.sdk.base.Constants;
import java.util.concurrent.TimeUnit;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/statistics/grpc/connect/DauManager.class */
public final class DauManager {
    private Runnable a;
    private Dau.OnDauListener b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/statistics/grpc/connect/DauManager$DauRunnable.class */
    public class DauRunnable extends NamedRunnable {
        private DayActiveUserProtos.Request b;

        public DauRunnable(DayActiveUserProtos.Request request) {
            super(StatConfig.a("dau"));
            this.b = request;
        }

        @Override // com.blued.android.statistics.util.NamedRunnable
        public void a() {
            DayActiveUserProtos.Response response;
            if (StatConfig.k()) {
                StatConfig.b().b("DAU start-request @", Thread.currentThread().getName(), "\n", this.b);
            }
            ReportServiceGrpc.ReportServiceBlockingStub withDeadlineAfter = ConnectManager.a(ReportServiceGrpc.newBlockingStub(ConnectManager.a())).withCompression(Constants.CP_GZIP).withDeadlineAfter(30L, TimeUnit.SECONDS);
            DayActiveUserProtos.Response response2 = null;
            long uptimeMillis = SystemClock.uptimeMillis();
            try {
                DayActiveUserProtos.Response report = withDeadlineAfter.report(this.b);
                response = report;
                if (report != null) {
                    response2 = report;
                    report.getCode();
                    response = report;
                }
            } catch (Exception e) {
                response = response2;
                if (StatConfig.k()) {
                    e.printStackTrace();
                    response = response2;
                }
            }
            long uptimeMillis2 = SystemClock.uptimeMillis();
            if (StatConfig.k()) {
                StatConfig.b().b("DAU ", Long.valueOf(uptimeMillis2 - uptimeMillis), ", ", response);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/statistics/grpc/connect/DauManager$InstanceHolder.class */
    public static class InstanceHolder {
        private static final DauManager a = new DauManager();

        private InstanceHolder() {
        }
    }

    private DauManager() {
        this.a = new Runnable() { // from class: com.blued.android.statistics.grpc.connect.DauManager.1
            @Override // java.lang.Runnable
            public void run() {
                StatThreadManager.a(new DauRunnable(DayActiveUserProtos.Request.newBuilder().setCommon(BluedStatistics.a().b()).setName(DayActiveUserProtos.NAME.REGULAR).build()));
                if (DauManager.this.b != null) {
                    DauManager.this.b.a(DayActiveUserProtos.NAME.REGULAR);
                }
                if (StatConfig.j()) {
                    Utils.a(DauManager.this.a, 300000L);
                }
            }
        };
    }

    public static DauManager a() {
        return InstanceHolder.a;
    }

    private void a(DayActiveUserProtos.Request.Builder builder, boolean z) {
        if (StatConfig.j() && ConnectManager.b()) {
            builder.setCommon(BluedStatistics.a().b());
            StatThreadManager.a(new DauRunnable(builder.build()));
            Dau.OnDauListener onDauListener = this.b;
            if (onDauListener != null) {
                onDauListener.a(builder.getName());
            }
            Utils.b(this.a);
            if (z) {
                Utils.a(this.a, 300000L);
            }
        }
    }

    public void a(DayActiveUserProtos.Request.Builder builder) {
        a(builder, false);
    }

    public void b(DayActiveUserProtos.Request.Builder builder) {
        a(builder, true);
    }
}
