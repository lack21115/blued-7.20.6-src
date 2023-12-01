package com.blued.android.framework.http;

import com.qiniu.android.dns.DnsManager;
import com.qiniu.android.dns.Domain;
import com.qiniu.android.dns.IResolver;
import com.qiniu.android.dns.IpSorter;
import com.qiniu.android.dns.NetworkInfo;
import com.qiniu.android.dns.Record;
import com.qiniu.android.dns.http.DnspodEnterprise;
import com.qiniu.android.dns.http.GoogleHttpsDns;
import com.qiniu.android.dns.local.AndroidDnsServer;
import com.qiniu.android.dns.local.Resolver;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Random;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/framework/http/HappyDnsUtils.class */
public class HappyDnsUtils {
    private static DnsManager a;

    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/framework/http/HappyDnsUtils$FixIpResolver.class */
    public static class FixIpResolver implements IResolver {
        private String a;
        private String b;

        public Record[] resolve(Domain domain, NetworkInfo networkInfo) throws IOException {
            if (domain.domain.equalsIgnoreCase(this.a)) {
                return new Record[]{new Record(this.b, 1, 600, System.currentTimeMillis() / 1000)};
            }
            return null;
        }
    }

    public static boolean a() {
        return true;
    }

    public static String[] a(String[] strArr) {
        if (strArr != null && strArr.length > 0) {
            ArrayList arrayList = new ArrayList();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= strArr.length) {
                    break;
                }
                arrayList.add(Integer.valueOf(i2));
                i = i2 + 1;
            }
            String[] strArr2 = new String[strArr.length];
            Random random = new Random(System.currentTimeMillis());
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (arrayList.size() <= 1) {
                    strArr2[i4] = strArr[((Integer) arrayList.remove(0)).intValue()];
                    return strArr2;
                }
                strArr2[i4] = strArr[((Integer) arrayList.remove(random.nextInt(arrayList.size()))).intValue()];
                i3 = i4 + 1;
            }
        }
        return strArr;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x003e, code lost:
        if ("Asia/Riyadh".equalsIgnoreCase(r0) != false) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean b() {
        /*
            r0 = 0
            r3 = r0
            java.util.TimeZone r0 = java.util.TimeZone.getDefault()     // Catch: java.lang.Exception -> L45
            java.lang.String r0 = r0.getID()     // Catch: java.lang.Exception -> L45
            r5 = r0
            java.lang.String r0 = "Asia/Jakarta"
            r1 = r5
            boolean r0 = r0.equalsIgnoreCase(r1)     // Catch: java.lang.Exception -> L45
            if (r0 != 0) goto L41
            java.lang.String r0 = "Asia/Pontianak"
            r1 = r5
            boolean r0 = r0.equalsIgnoreCase(r1)     // Catch: java.lang.Exception -> L45
            if (r0 != 0) goto L41
            java.lang.String r0 = "Asia/Makassar"
            r1 = r5
            boolean r0 = r0.equalsIgnoreCase(r1)     // Catch: java.lang.Exception -> L45
            if (r0 != 0) goto L41
            java.lang.String r0 = "Asia/Jayapura"
            r1 = r5
            boolean r0 = r0.equalsIgnoreCase(r1)     // Catch: java.lang.Exception -> L45
            if (r0 != 0) goto L41
            java.lang.String r0 = "Asia/Dubai"
            r1 = r5
            boolean r0 = r0.equalsIgnoreCase(r1)     // Catch: java.lang.Exception -> L45
            if (r0 != 0) goto L41
            java.lang.String r0 = "Asia/Riyadh"
            r1 = r5
            boolean r0 = r0.equalsIgnoreCase(r1)     // Catch: java.lang.Exception -> L45
            r4 = r0
            r0 = r4
            if (r0 == 0) goto L43
        L41:
            r0 = 1
            r3 = r0
        L43:
            r0 = r3
            return r0
        L45:
            r5 = move-exception
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.framework.http.HappyDnsUtils.b():boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x002c, code lost:
        if ("Asia/Urumqi".equals(r0) != false) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean c() {
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
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.framework.http.HappyDnsUtils.c():boolean");
    }

    public static DnsManager d() {
        IResolver[] iResolverArr;
        if (a == null) {
            if (b()) {
                iResolverArr = new IResolver[]{new GoogleHttpsDns(), new DnspodEnterprise("9874", "jUG67TU4")};
            } else if (c()) {
                iResolverArr = new IResolver[]{new DnspodEnterprise("9874", "jUG67TU4"), AndroidDnsServer.defaultResolver()};
            } else {
                IResolver googleHttpsDns = new GoogleHttpsDns();
                IResolver iResolver = null;
                try {
                    iResolver = new Resolver(InetAddress.getByName("8.8.8.8"));
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                }
                IResolver defaultResolver = AndroidDnsServer.defaultResolver();
                iResolverArr = iResolver != null ? new IResolver[]{googleHttpsDns, iResolver, defaultResolver} : new IResolver[]{googleHttpsDns, defaultResolver};
            }
            a = new DnsManager(NetworkInfo.normal, iResolverArr, new IpSorter() { // from class: com.blued.android.framework.http.HappyDnsUtils.1
                public String[] sort(String[] strArr) {
                    return HappyDnsUtils.a(strArr);
                }
            });
        }
        return a;
    }
}
