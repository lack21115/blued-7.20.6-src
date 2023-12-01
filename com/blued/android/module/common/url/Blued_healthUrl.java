package com.blued.android.module.common.url;

import com.blued.android.framework.urlmanager.HostConfig;
import com.blued.android.framework.urlmanager.UrlFormatUtil;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/url/Blued_healthUrl.class */
public final class Blued_healthUrl {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f10846a = {"0/health/kb/home?redirect=1%s", "0/health/kb/home?register=1%s"};

    private static String a() {
        return HostConfig.a("BLUED_HEALTH") + "";
    }

    public static String a(int i) {
        return UrlFormatUtil.a(f10846a[i], a(), new Object[0]);
    }
}
