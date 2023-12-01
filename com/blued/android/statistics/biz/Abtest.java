package com.blued.android.statistics.biz;

import com.blued.android.statistics.StatConfig;
import com.blued.android.statistics.grpc.connect.AbtestManager;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/statistics/biz/Abtest.class */
public class Abtest {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/statistics/biz/Abtest$InstanceHolder.class */
    public static class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final Abtest f18681a = new Abtest();

        private InstanceHolder() {
        }
    }

    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/statistics/biz/Abtest$OnLocalLoadedListener.class */
    public interface OnLocalLoadedListener {
        void a();
    }

    private Abtest() {
    }

    public static Abtest a() {
        return InstanceHolder.f18681a;
    }

    private boolean b() {
        return StatConfig.a() == null;
    }

    public String a(String str, String str2) {
        return b() ? "" : AbtestManager.a().a(str, str2);
    }

    public void a(String str, String str2, OnLocalLoadedListener onLocalLoadedListener) {
        if (b()) {
            return;
        }
        AbtestManager.a().a(str, str2, onLocalLoadedListener);
    }
}
