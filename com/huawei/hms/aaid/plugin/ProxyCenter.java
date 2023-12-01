package com.huawei.hms.aaid.plugin;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/aaid/plugin/ProxyCenter.class */
public class ProxyCenter {
    private PushProxy proxy;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/aaid/plugin/ProxyCenter$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private static ProxyCenter f8788a = new ProxyCenter();
    }

    private static ProxyCenter getInstance() {
        return a.f8788a;
    }

    public static PushProxy getProxy() {
        return getInstance().proxy;
    }

    public static void register(PushProxy pushProxy) {
        getInstance().proxy = pushProxy;
    }
}
