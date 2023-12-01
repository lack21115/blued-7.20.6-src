package com.ss.android.socialbase.downloader.network;

import android.os.Handler;
import com.ss.android.socialbase.downloader.network.connectionpool.DownloadPreconnecter;
import com.ss.android.socialbase.downloader.thread.DownloadWatchDog;
import com.ss.android.socialbase.downloader.utils.LruCache;
import java.net.InetAddress;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/downloader/network/DownloadDnsManager.class */
public class DownloadDnsManager {
    private final LruCache<String, DnsRecord> cache;
    private final Handler cpuHandler;
    private final Handler networkHandler;

    /* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/downloader/network/DownloadDnsManager$Callback.class */
    public interface Callback {
        void onDnsResolved(String str, List<InetAddress> list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/downloader/network/DownloadDnsManager$DnsRecord.class */
    public static class DnsRecord {
        long timestamp;
        List<InetAddress> value;

        private DnsRecord() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/downloader/network/DownloadDnsManager$Holder.class */
    public static class Holder {
        private static final DownloadDnsManager INSTANCE = new DownloadDnsManager();

        private Holder() {
        }
    }

    private DownloadDnsManager() {
        this.cache = new LruCache<>(4, 16, false);
        this.networkHandler = new Handler(DownloadPreconnecter.getLooper());
        this.cpuHandler = new Handler(DownloadWatchDog.getThreadLooper());
    }

    public static DownloadDnsManager getInstance() {
        return Holder.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00c0, code lost:
        if (r13.isEmpty() != false) goto L45;
     */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0117 A[Catch: all -> 0x0127, TRY_ENTER, TryCatch #3 {all -> 0x0127, blocks: (B:2:0x0000, B:3:0x0011, B:9:0x0028, B:13:0x004f, B:15:0x005c, B:17:0x007c, B:19:0x0089, B:29:0x00b9, B:40:0x00e6, B:43:0x00f3, B:48:0x010b, B:50:0x0117, B:46:0x0103, B:31:0x00c3, B:5:0x0013, B:6:0x0022, B:22:0x0097, B:34:0x00ca), top: B:61:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void resolveDns(final java.lang.String r8, final com.ss.android.socialbase.downloader.network.DownloadDnsManager.Callback r9, long r10) {
        /*
            Method dump skipped, instructions count: 302
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.network.DownloadDnsManager.resolveDns(java.lang.String, com.ss.android.socialbase.downloader.network.DownloadDnsManager$Callback, long):void");
    }

    private void updateIpAddressToCache(String str, List<InetAddress> list) {
        synchronized (this.cache) {
            DnsRecord dnsRecord = this.cache.get(str);
            DnsRecord dnsRecord2 = dnsRecord;
            if (dnsRecord == null) {
                dnsRecord2 = new DnsRecord();
                this.cache.put(str, dnsRecord2);
            }
            dnsRecord2.value = list;
            dnsRecord2.timestamp = System.currentTimeMillis();
        }
    }

    public void resolveDnsAsync(final String str, final Callback callback, final long j) {
        this.networkHandler.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.network.DownloadDnsManager.1
            @Override // java.lang.Runnable
            public void run() {
                DownloadDnsManager.this.resolveDns(str, callback, j);
            }
        });
    }
}
