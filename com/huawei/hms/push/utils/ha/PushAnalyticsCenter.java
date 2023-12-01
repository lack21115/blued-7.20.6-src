package com.huawei.hms.push.utils.ha;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/push/utils/ha/PushAnalyticsCenter.class */
public class PushAnalyticsCenter {

    /* renamed from: a  reason: collision with root package name */
    private PushBaseAnalytics f22866a;

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/push/utils/ha/PushAnalyticsCenter$a.class */
    static class a {

        /* renamed from: a  reason: collision with root package name */
        private static PushAnalyticsCenter f22867a = new PushAnalyticsCenter();
    }

    public static PushAnalyticsCenter getInstance() {
        return a.f22867a;
    }

    public PushBaseAnalytics getPushAnalytics() {
        return this.f22866a;
    }

    public void register(PushBaseAnalytics pushBaseAnalytics) {
        this.f22866a = pushBaseAnalytics;
    }
}
