package com.blued.android.module.common.url;

import com.blued.android.framework.urlmanager.HostConfig;
import com.blued.android.framework.urlmanager.UrlFormatUtil;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/url/ActivityUrl.class */
public final class ActivityUrl {
    private static final String[] a = {"0/hd/2020/series%s", "0/hd/2020/share-test%s", "0/hd/chat/draw/card%s", "0/hd/chat/weekstar/plus/winner%s"};

    private static String a() {
        return HostConfig.a("ACTIVITY") + "";
    }

    public static String a(int i) {
        return UrlFormatUtil.a(a[i], a(), new Object[0]);
    }
}
