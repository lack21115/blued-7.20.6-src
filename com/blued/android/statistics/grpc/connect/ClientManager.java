package com.blued.android.statistics.grpc.connect;

import android.os.SystemClock;
import com.blued.android.statistics.BluedStatistics;
import com.blued.android.statistics.StatConfig;
import com.blued.android.statistics.grpc.ConnectManager;
import com.blued.android.statistics.grpc.StatThreadManager;
import com.blued.android.statistics.util.NamedRunnable;
import com.blued.das.client.ClientProtos;
import com.blued.das.client.ReportServiceGrpc;
import com.efs.sdk.base.Constants;
import java.util.concurrent.TimeUnit;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/statistics/grpc/connect/ClientManager.class */
public final class ClientManager extends BaseManager<ClientProtos.Request> {

    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/statistics/grpc/connect/ClientManager$ClientRunnable.class */
    class ClientRunnable extends NamedRunnable {
        private ClientProtos.Requests b;

        public ClientRunnable(ClientProtos.Requests requests) {
            super(StatConfig.a("client"));
            this.b = requests;
        }

        @Override // com.blued.android.statistics.util.NamedRunnable
        public void a() {
            ClientProtos.Response response;
            if (StatConfig.m()) {
                StatConfig.b().b("CLIENT start-request \n", this.b);
            }
            ReportServiceGrpc.ReportServiceBlockingStub withDeadlineAfter = ConnectManager.a(ReportServiceGrpc.newBlockingStub(ConnectManager.a())).withCompression(Constants.CP_GZIP).withDeadlineAfter(30L, TimeUnit.SECONDS);
            ClientProtos.Response response2 = null;
            long uptimeMillis = SystemClock.uptimeMillis();
            try {
                ClientProtos.Response batchReport = withDeadlineAfter.batchReport(this.b);
                response = batchReport;
                if (batchReport != null) {
                    response2 = batchReport;
                    batchReport.getCode();
                    response = batchReport;
                }
            } catch (Exception e) {
                response = response2;
                if (StatConfig.m()) {
                    e.printStackTrace();
                    response = response2;
                }
            }
            long uptimeMillis2 = SystemClock.uptimeMillis();
            if (StatConfig.m()) {
                StatConfig.b().b("CLIENT ", Long.valueOf(uptimeMillis2 - uptimeMillis), ", ", response);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/statistics/grpc/connect/ClientManager$InstanceHolder.class */
    public static class InstanceHolder {
        private static final ClientManager a = new ClientManager();

        private InstanceHolder() {
        }
    }

    private ClientManager() {
    }

    public static ClientManager a() {
        return InstanceHolder.a;
    }

    @Override // com.blued.android.statistics.grpc.connect.BaseManager
    protected void a(Object[] objArr) {
        ClientProtos.Requests.Builder newBuilder = ClientProtos.Requests.newBuilder();
        newBuilder.setCommon(BluedStatistics.a().b());
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= objArr.length) {
                StatThreadManager.a(new ClientRunnable(newBuilder.build()));
                return;
            } else {
                newBuilder.addRequest((ClientProtos.Request) objArr[i2]);
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
        return StatConfig.l();
    }
}
