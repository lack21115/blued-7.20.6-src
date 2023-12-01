package com.blued.android.statistics.biz;

import com.blued.android.statistics.StatConfig;
import com.blued.android.statistics.grpc.connect.ClientManager;
import com.blued.das.client.ClientProtos;
import com.google.protobuf.Any;
import com.google.protobuf.Message;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/statistics/biz/Client.class */
public final class Client {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/statistics/biz/Client$InstanceHolder.class */
    public static class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final Client f18683a = new Client();

        private InstanceHolder() {
        }
    }

    private Client() {
    }

    public static Client a() {
        return InstanceHolder.f18683a;
    }

    public void a(Message message, long j) {
        if (message == null) {
            return;
        }
        try {
            ClientManager.a().a((ClientManager) ClientProtos.Request.newBuilder().setClientTime(System.currentTimeMillis()).setExtra(Any.pack(message)).setUid(j).build());
        } catch (Exception e) {
        }
    }

    public void a(boolean z) {
        StatConfig.c(z);
    }
}
