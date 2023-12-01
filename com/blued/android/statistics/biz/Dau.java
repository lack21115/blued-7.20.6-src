package com.blued.android.statistics.biz;

import com.blued.android.statistics.grpc.connect.DauManager;
import com.blued.das.dau.DayActiveUserProtos;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/statistics/biz/Dau.class */
public class Dau {
    private AtomicBoolean a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/statistics/biz/Dau$InstanceHolder.class */
    public static class InstanceHolder {
        private static final Dau a = new Dau();

        private InstanceHolder() {
        }
    }

    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/statistics/biz/Dau$OnDauListener.class */
    public interface OnDauListener {
        void a(DayActiveUserProtos.NAME name);
    }

    private Dau() {
        this.a = new AtomicBoolean(false);
    }

    public static Dau a() {
        return InstanceHolder.a;
    }

    private void a(DayActiveUserProtos.Request.Builder builder) {
        builder.setClientTime(System.currentTimeMillis());
        DauManager.a().a(builder);
    }

    private void b(DayActiveUserProtos.Request.Builder builder) {
        builder.setClientTime(System.currentTimeMillis());
        DauManager.a().b(builder);
    }

    public void b() {
        this.a.set(true);
        b(DayActiveUserProtos.Request.newBuilder().setName(DayActiveUserProtos.NAME.LOGIN).setClientTime(System.currentTimeMillis()));
    }

    public void c() {
        if (this.a.get()) {
            b(DayActiveUserProtos.Request.newBuilder().setName(DayActiveUserProtos.NAME.SWITCH_TO_FRONT).setClientTime(System.currentTimeMillis()));
        }
    }

    public void d() {
        if (this.a.get()) {
            a(DayActiveUserProtos.Request.newBuilder().setName(DayActiveUserProtos.NAME.SWITCH_TO_BACK).setClientTime(System.currentTimeMillis()));
        }
    }

    public void e() {
        this.a.set(false);
        a(DayActiveUserProtos.Request.newBuilder().setName(DayActiveUserProtos.NAME.LOGOUT).setClientTime(System.currentTimeMillis()));
    }
}
