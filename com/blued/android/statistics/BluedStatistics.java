package com.blued.android.statistics;

import android.content.Context;
import android.text.TextUtils;
import com.blued.android.statistics.biz.Abtest;
import com.blued.android.statistics.biz.Apm;
import com.blued.android.statistics.biz.Client;
import com.blued.android.statistics.biz.Common;
import com.blued.android.statistics.biz.Dau;
import com.blued.android.statistics.biz.Event;
import com.blued.android.statistics.biz.Page;
import com.blued.android.statistics.grpc.ConnectManager;
import com.blued.android.statistics.grpc.StatThreadManager;
import com.qiniu.android.dns.DnsManager;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/statistics/BluedStatistics.class */
public class BluedStatistics {
    private BluedStatistics() {
    }

    public static Common a() {
        return Common.a();
    }

    public static void a(Context context, String str, int i, DnsManager dnsManager) {
        if (context == null) {
            return;
        }
        StatConfig.a(true);
        StatConfig.a(context.getApplicationContext());
        StatThreadManager.a();
        ConnectManager.a(str, i, dnsManager);
    }

    public static void a(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            str2 = "";
        } else {
            str2 = "Basic " + str;
        }
        ConnectManager.a("Authorization", str2);
    }

    public static Apm b() {
        return Apm.a();
    }

    public static Event c() {
        return Event.a();
    }

    public static Page d() {
        return Page.a();
    }

    public static Dau e() {
        return Dau.a();
    }

    public static Client f() {
        return Client.a();
    }

    public static Abtest g() {
        return Abtest.a();
    }
}
