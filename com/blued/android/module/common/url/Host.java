package com.blued.android.module.common.url;

import com.blued.android.framework.urlmanager.HostConfig;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/url/Host.class */
public final class Host {
    public static String a(String str) {
        return HostConfig.a(str);
    }

    public static void a() {
        HostConfig.b();
        HostConfig.a("H5", new String[]{"https://app.blued.cn", "https://app-testenv.blued.cn", "https://app.blued.cn"});
        HostConfig.a("HTTP", new String[]{"https://argo.blued.cn", "https://dev-argo.blued.cn", "https://pre-argo.blued.cn"});
        HostConfig.a("PAY", new String[]{"https://pay.blued.cn", "https://pay-test.blued.cn", "https://pre-pay.blued.cn"});
        HostConfig.a("SDK", new String[]{"https://sdk.blued.cn", "https://sdk-test.blued.cn", "https://sdk.blued.cn"});
        HostConfig.a("CHAT", new String[]{"h4.blued.cn", "140.143.221.114", "h4.blued.cn"});
        HostConfig.a("ACTIVITY", new String[]{"https://activity.blued.cn", "https://activity-test.blued.cn", "https://activity.blued.cn"});
        HostConfig.a("HEALTH", new String[]{"https://health.blued.cn", "https://healthtest.blued.cn", "https://health.blued.cn"});
        HostConfig.a("BLUED_HEALTH", new String[]{"https://activity.bluedhealth.com", "https://activity-test.bluedhealth.com", "https://activity.bluedhealth.com"});
        HostConfig.a("DANLAN_LOVE", new String[]{"https://www.danlanlove.com", "https://wealtest.blued.cn/#", "https://www.danlanlove.com"});
        HostConfig.a("DATA", new String[]{"blued.irisdt.cn", "blued-test.irisdt.cn", "blued.irisdt.cn"});
        HostConfig.a("WEB", new String[]{"https://i.blued.cn", "http://test.i.blued.cn", "https://i.blued.cn"});
        HostConfig.a("M", new String[]{BluedHttpUrl.f10844a, "http://m-test.blued.cn", BluedHttpUrl.f10844a});
        HostConfig.a("GRPC_CHAT", new String[]{"h8.blued.cn", "h8-test.blued.cn", "h8.blued.cn"});
        HostConfig.a("H5_INVOICE", new String[]{"https://app.blued.cn/home/invoice", "https://app-testenv.blued.cn/home/invoice", "https://app.blued.cn/home/invoice"});
        HostConfig.a("LIVE_IM", new String[]{"https://live-im.blued.cn", "https://test-live-im.blued.cn", "https://pre-live-im.blued.cn"});
        HostConfig.a(HostConfig.AREA.CHINA);
    }

    public static void a(int i) {
        HostConfig.a(i);
    }

    public static String b() {
        return HostConfig.a();
    }
}
