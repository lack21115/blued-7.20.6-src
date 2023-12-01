package com.bytedance.applog.util;

import com.bytedance.applog.UriConfig;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/applog/util/UriConstants.class */
public class UriConstants {
    public static final int DEFAULT = 0;
    public static final int REGION_DEFAULT = 0;
    public static final UriConfig TOB_CHINA_NEW;

    static {
        new UriConfig.Builder().setRegisterUri("https://log.snssdk.com/service/2/device_register/").setActiveUri("https://ichannel.snssdk.com/service/2/app_alert_check/").setSendUris(new String[]{"https://log.snssdk.com/service/2/app_log/", "https://applog.snssdk.com/service/2/app_log/"}).setRealUris(new String[]{"https://rtlog.snssdk.com/service/2/app_log/", "https://rtapplog.snssdk.com/service/2/app_log/"}).setSettingUri("https://log.snssdk.com/service/2/log_settings/").setALinkAttributionUri("https://toblog-alink.ctobsnssdk.com/service/2/attribution_data").setALinkQueryUri("https://toblog-alink.ctobsnssdk.com/service/2/alink_data").build();
        new UriConfig.Builder().setRegisterUri("https://toblog.ctobsnssdk.com/service/2/device_register/").setActiveUri("https://toblog.ctobsnssdk.com/service/2/app_alert_check/").setSendUris(new String[]{"https://toblog.ctobsnssdk.com/service/2/app_log/", "https://tobapplog.ctobsnssdk.com/service/2/app_log/"}).setProfileUri("https://toblog.ctobsnssdk.com/service/2/profile/").setSettingUri("https://toblog.ctobsnssdk.com/service/2/log_settings/").setAbUri("https://toblog.ctobsnssdk.com/service/2/abtest_config/").setALinkAttributionUri("https://toblog-alink.ctobsnssdk.com/service/2/attribution_data").setALinkQueryUri("https://toblog-alink.ctobsnssdk.com/service/2/alink_data").build();
        TOB_CHINA_NEW = new UriConfig.Builder().setRegisterUri("https://klink.volceapplog.com/service/2/device_register/").setActiveUri("https://klink.volceapplog.com/service/2/app_alert_check/").setSendUris(new String[]{"https://toblog.volceapplog.com/service/2/app_log/", "https://tobapplog.volceapplog.com/service/2/app_log/"}).setProfileUri("https://toblog.volceapplog.com/service/2/profile/").setSettingUri("https://toblog.volceapplog.com/service/2/log_settings/").setAbUri("https://abtest.volceapplog.com/service/2/abtest_config/").setALinkAttributionUri("https://alink.volceapplog.com/service/2/attribution_data").setALinkQueryUri("https://alink.volceapplog.com/service/2/alink_data").build();
    }

    public static final UriConfig createUriConfig(int i) {
        return TOB_CHINA_NEW;
    }
}
