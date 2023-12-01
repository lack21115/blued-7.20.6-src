package com.blued.android.core.net.http;

import com.blued.android.core.net.HttpManager;
import com.blued.android.core.utils.Log;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;
import okhttp3.Dns;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/net/http/SyncOkHttpDns.class */
public class SyncOkHttpDns implements Dns {

    /* renamed from: a  reason: collision with root package name */
    private static SyncOkHttpDns f9697a;

    public static SyncOkHttpDns a() {
        if (f9697a == null) {
            f9697a = new SyncOkHttpDns();
        }
        return f9697a;
    }

    @Override // okhttp3.Dns
    public List<InetAddress> lookup(String str) throws UnknownHostException {
        String a2 = HttpDnsUtils.a(str);
        if (HttpManager.c()) {
            Log.b("HttpManager", "httpdns lookup, hostname:" + str + ", ip:" + a2);
        }
        if (a2 != null) {
            List<InetAddress> asList = Arrays.asList(InetAddress.getAllByName(a2));
            if (HttpManager.c()) {
                Log.b("HttpManager", "SyncOkHttpDns lookup, hostname:" + str + ", inetAddresses:" + asList);
            }
            return asList;
        }
        return Dns.SYSTEM.lookup(str);
    }
}
