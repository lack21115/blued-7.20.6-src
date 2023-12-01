package com.kwad.sdk.core.network.kwai;

import android.text.TextUtils;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.List;
import okhttp3.Dns;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/network/kwai/d.class */
public final class d implements Dns {
    private static final Dns SYSTEM = Dns.SYSTEM;

    public final List<InetAddress> lookup(String str) {
        String ea = com.kwad.sdk.ip.direct.a.ea(str);
        if (TextUtils.isEmpty(ea)) {
            com.kwad.sdk.core.d.b.d("IpDirect_OkHttpDns", "Dns.SYSTEM.lookup(hostname):" + Dns.SYSTEM.lookup(str));
        } else {
            List<InetAddress> asList = Arrays.asList(InetAddress.getAllByName(ea));
            if (asList != null && !asList.isEmpty()) {
                com.kwad.sdk.core.d.b.d("IpDirect_OkHttpDns", "inetAddresses:" + asList);
                return asList;
            }
        }
        return SYSTEM.lookup(str);
    }
}
