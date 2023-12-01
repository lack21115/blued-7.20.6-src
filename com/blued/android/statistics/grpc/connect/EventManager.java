package com.blued.android.statistics.grpc.connect;

import android.os.SystemClock;
import com.amap.api.fence.GeoFence;
import com.blued.android.statistics.BluedStatistics;
import com.blued.android.statistics.StatConfig;
import com.blued.android.statistics.grpc.ConnectManager;
import com.blued.android.statistics.grpc.StatThreadManager;
import com.blued.android.statistics.util.NamedRunnable;
import com.blued.das.event.CustomEventProtos;
import com.blued.das.event.ReportServiceGrpc;
import com.efs.sdk.base.Constants;
import java.util.concurrent.TimeUnit;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/statistics/grpc/connect/EventManager.class */
public final class EventManager extends BaseManager<CustomEventProtos.Request> {

    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/statistics/grpc/connect/EventManager$EventRunnable.class */
    class EventRunnable extends NamedRunnable {
        private CustomEventProtos.Requests b;

        public EventRunnable(CustomEventProtos.Requests requests) {
            super(StatConfig.a(GeoFence.BUNDLE_KEY_FENCESTATUS));
            this.b = requests;
        }

        @Override // com.blued.android.statistics.util.NamedRunnable
        public void a() {
            CustomEventProtos.Response response;
            if (StatConfig.g()) {
                StatConfig.b().b("EVENT start-request \n", this.b);
            }
            ReportServiceGrpc.ReportServiceBlockingStub withDeadlineAfter = ConnectManager.a(ReportServiceGrpc.newBlockingStub(ConnectManager.a())).withCompression(Constants.CP_GZIP).withDeadlineAfter(30L, TimeUnit.SECONDS);
            CustomEventProtos.Response response2 = null;
            long uptimeMillis = SystemClock.uptimeMillis();
            try {
                CustomEventProtos.Response batchReport = withDeadlineAfter.batchReport(this.b);
                response = batchReport;
                if (batchReport != null) {
                    response2 = batchReport;
                    batchReport.getCode();
                    response = batchReport;
                }
            } catch (Exception e) {
                response = response2;
                if (StatConfig.g()) {
                    e.printStackTrace();
                    response = response2;
                }
            }
            long uptimeMillis2 = SystemClock.uptimeMillis();
            if (StatConfig.g()) {
                StatConfig.b().b("EVENT ", Long.valueOf(uptimeMillis2 - uptimeMillis), ", ", response);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/statistics/grpc/connect/EventManager$InstanceHolder.class */
    public static class InstanceHolder {
        private static final EventManager a = new EventManager();

        private InstanceHolder() {
        }
    }

    private EventManager() {
    }

    public static EventManager a() {
        return InstanceHolder.a;
    }

    @Override // com.blued.android.statistics.grpc.connect.BaseManager
    protected void a(Object[] objArr) {
        CustomEventProtos.Requests.Builder newBuilder = CustomEventProtos.Requests.newBuilder();
        newBuilder.setCommon(BluedStatistics.a().b());
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= objArr.length) {
                StatThreadManager.a(new EventRunnable(newBuilder.build()));
                return;
            } else {
                newBuilder.addRequest((CustomEventProtos.Request) objArr[i2]);
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
        return StatConfig.f();
    }
}
