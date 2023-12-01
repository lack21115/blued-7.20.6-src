package com.qiniu.android.dns;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Uri;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/android/dns/NetworkReceiver.class */
public final class NetworkReceiver extends BroadcastReceiver {
    private static final Uri PREFERRED_APN_URI = Uri.parse("content://telephony/carriers/preferapn");
    private static DnsManager mdnsManager;

    /* JADX WARN: Code restructure failed: missing block: B:16:0x006f, code lost:
        if (r0.startsWith("ctnet") != false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00cc, code lost:
        if (r0.equals("uniwap") != false) goto L36;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.qiniu.android.dns.NetworkInfo createNetInfo(android.net.NetworkInfo r7, android.content.Context r8) {
        /*
            Method dump skipped, instructions count: 227
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiniu.android.dns.NetworkReceiver.createNetInfo(android.net.NetworkInfo, android.content.Context):com.qiniu.android.dns.NetworkInfo");
    }

    public static void setDnsManager(DnsManager dnsManager) {
        mdnsManager = dnsManager;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (mdnsManager == null) {
            return;
        }
        mdnsManager.onNetworkChange(createNetInfo(((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo(), context));
    }
}
