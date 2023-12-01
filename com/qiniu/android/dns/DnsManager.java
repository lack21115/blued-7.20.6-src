package com.qiniu.android.dns;

import android.content.Context;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.qiniu.android.dns.local.Hosts;
import com.qiniu.android.dns.util.LruCache;
import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/android/dns/DnsManager.class */
public final class DnsManager {
    private final LruCache<String, Record[]> cache;
    private final Hosts hosts;
    private volatile int index;
    private volatile NetworkInfo info;
    private final IResolver[] resolvers;
    private final IpSorter sorter;

    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/android/dns/DnsManager$DummySorter.class */
    static class DummySorter implements IpSorter {
        private AtomicInteger pos;

        private DummySorter() {
            this.pos = new AtomicInteger();
        }

        @Override // com.qiniu.android.dns.IpSorter
        public String[] sort(String[] strArr) {
            return strArr;
        }
    }

    public DnsManager(NetworkInfo networkInfo, IResolver[] iResolverArr) {
        this(networkInfo, iResolverArr, null);
    }

    public DnsManager(NetworkInfo networkInfo, IResolver[] iResolverArr, IpSorter ipSorter) {
        this.hosts = new Hosts();
        this.info = null;
        this.index = 0;
        this.info = networkInfo == null ? NetworkInfo.normal : networkInfo;
        this.resolvers = (IResolver[]) iResolverArr.clone();
        this.cache = new LruCache<>();
        this.sorter = ipSorter == null ? new DummySorter() : ipSorter;
    }

    private void clearCache() {
        synchronized (this.cache) {
            this.cache.clear();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x002c, code lost:
        if ("Asia/Urumqi".equals(r0) != false) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean needHttpDns() {
        /*
            r0 = 0
            r3 = r0
            java.util.TimeZone r0 = java.util.TimeZone.getDefault()     // Catch: java.lang.Exception -> L33
            java.lang.String r0 = r0.getID()     // Catch: java.lang.Exception -> L33
            r5 = r0
            java.lang.String r0 = "Asia/Shanghai"
            r1 = r5
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Exception -> L33
            if (r0 != 0) goto L2f
            java.lang.String r0 = "Asia/Chongqing"
            r1 = r5
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Exception -> L33
            if (r0 != 0) goto L2f
            java.lang.String r0 = "Asia/Harbin"
            r1 = r5
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Exception -> L33
            if (r0 != 0) goto L2f
            java.lang.String r0 = "Asia/Urumqi"
            r1 = r5
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Exception -> L33
            r4 = r0
            r0 = r4
            if (r0 == 0) goto L31
        L2f:
            r0 = 1
            r3 = r0
        L31:
            r0 = r3
            return r0
        L33:
            r5 = move-exception
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiniu.android.dns.DnsManager.needHttpDns():boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:116:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0196 A[EDGE_INSN: B:136:0x0196->B:85:0x0196 ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00ca  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String[] queryInternal(com.qiniu.android.dns.Domain r5) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 553
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiniu.android.dns.DnsManager.queryInternal(com.qiniu.android.dns.Domain):java.lang.String[]");
    }

    private static String[] records2Ip(Record[] recordArr) {
        if (recordArr == null || recordArr.length == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(recordArr.length);
        int length = recordArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                break;
            }
            arrayList.add(recordArr[i2].value);
            i = i2 + 1;
        }
        if (arrayList.size() == 0) {
            return null;
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    private static void rotate(Record[] recordArr) {
        if (recordArr == null || recordArr.length <= 1) {
            return;
        }
        Record record = recordArr[0];
        System.arraycopy(recordArr, 1, recordArr, 0, recordArr.length - 1);
        recordArr[recordArr.length - 1] = record;
    }

    private static Record[] trimCname(Record[] recordArr) {
        ArrayList arrayList = new ArrayList(recordArr.length);
        int length = recordArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return (Record[]) arrayList.toArray(new Record[arrayList.size()]);
            }
            Record record = recordArr[i2];
            if (record != null && record.type == 1) {
                arrayList.add(record);
            }
            i = i2 + 1;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x00b2, code lost:
        if (r5.charAt(r5.length() - 1) == '.') goto L38;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean validIP(java.lang.String r5) {
        /*
            Method dump skipped, instructions count: 188
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiniu.android.dns.DnsManager.validIP(java.lang.String):boolean");
    }

    public void invalidDnsResult(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.cache) {
            this.cache.delete(str);
        }
        synchronized (this.resolvers) {
            this.index++;
            if (this.index == this.resolvers.length) {
                this.index = 0;
            }
        }
    }

    public void onNetworkChange(NetworkInfo networkInfo) {
        clearCache();
        NetworkInfo networkInfo2 = networkInfo;
        if (networkInfo == null) {
            networkInfo2 = NetworkInfo.normal;
        }
        this.info = networkInfo2;
        synchronized (this.resolvers) {
            this.index = 0;
        }
    }

    public DnsManager putHosts(String str, String str2) {
        this.hosts.put(str, str2);
        return this;
    }

    public DnsManager putHosts(String str, String str2, int i) {
        this.hosts.put(str, new Hosts.Value(str2, i));
        return this;
    }

    public String[] query(Domain domain) throws IOException {
        if (domain != null) {
            if (domain.domain == null || domain.domain.trim().length() == 0) {
                throw new IOException("empty domain " + domain.domain);
            } else if (validIP(domain.domain)) {
                return new String[]{domain.domain};
            } else {
                String[] queryInternal = queryInternal(domain);
                String[] strArr = queryInternal;
                if (queryInternal != null) {
                    if (queryInternal.length <= 1) {
                        return queryInternal;
                    }
                    strArr = this.sorter.sort(queryInternal);
                }
                return strArr;
            }
        }
        throw new IOException("null domain");
    }

    public String[] query(String str) throws IOException {
        return query(new Domain(str));
    }

    public String[] queryFromCache(String str) {
        synchronized (this.cache) {
            if (this.info.equals(NetworkInfo.normal) && Network.isNetworkChanged()) {
                this.cache.clear();
                synchronized (this.resolvers) {
                    this.index = 0;
                }
            } else {
                Record[] recordArr = this.cache.get(str);
                if (recordArr != null && recordArr.length != 0 && !recordArr[0].isExpired()) {
                    return records2Ip(recordArr);
                }
            }
            return null;
        }
    }

    public InetAddress[] queryInetAdress(Domain domain) throws IOException {
        String[] query = query(domain);
        InetAddress[] inetAddressArr = new InetAddress[query.length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= query.length) {
                return inetAddressArr;
            }
            inetAddressArr[i2] = InetAddress.getByName(query[i2]);
            i = i2 + 1;
        }
    }

    public void registerNetworkReceiver(Context context) {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            context.registerReceiver(new NetworkReceiver(), intentFilter);
        } catch (Exception e) {
        }
    }
}
