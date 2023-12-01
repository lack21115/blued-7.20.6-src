package com.amap.api.col.p0003sl;

import android.os.SystemClock;
import android.text.TextUtils;
import com.amap.api.col.p0003sl.kb;
import com.amap.api.maps.AMapException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;

/* renamed from: com.amap.api.col.3sl.ju  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/ju.class */
public class ju {
    public static int a = 0;
    public static String b = "";
    public static HashMap<String, String> c;
    public static HashMap<String, String> d;
    public static HashMap<String, String> e;
    private static ju f;

    /* renamed from: com.amap.api.col.3sl.ju$a */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/ju$a.class */
    public interface a {
        URLConnection a();
    }

    public ju() {
        hp.e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static int a(kb kbVar, long j) {
        try {
            d(kbVar);
            long elapsedRealtime = j == 0 ? 0L : SystemClock.elapsedRealtime() - j;
            int conntectionTimeout = kbVar.getConntectionTimeout();
            if (kbVar.getDegradeAbility() != kb.a.FIX && kbVar.getDegradeAbility() != kb.a.SINGLE) {
                long j2 = conntectionTimeout;
                if (elapsedRealtime < j2) {
                    long j3 = j2 - elapsedRealtime;
                    if (j3 >= 1000) {
                        return (int) j3;
                    }
                }
                return Math.min(1000, kbVar.getConntectionTimeout());
            }
            return conntectionTimeout;
        } catch (Throwable th) {
            return 5000;
        }
    }

    public static ju a() {
        if (f == null) {
            f = new ju();
        }
        return f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static kb.b a(kb kbVar, boolean z) {
        if (kbVar.getDegradeAbility() == kb.a.FIX) {
            return kb.b.FIX_NONDEGRADE;
        }
        if (kbVar.getDegradeAbility() != kb.a.SINGLE && z) {
            return kb.b.FIRST_NONDEGRADE;
        }
        return kb.b.NEVER_GRADE;
    }

    public static kc a(kb kbVar) throws hn {
        return d(kbVar, kbVar.isHttps());
    }

    private static kc a(kb kbVar, kb.b bVar, int i) throws hn {
        try {
            d(kbVar);
            kbVar.setDegradeType(bVar);
            kbVar.setReal_max_timeout(i);
            return new jy().c(kbVar);
        } catch (hn e2) {
            throw e2;
        } catch (Throwable th) {
            th.printStackTrace();
            throw new hn(AMapException.ERROR_UNKNOWN);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static kb.b b(kb kbVar, boolean z) {
        return kbVar.getDegradeAbility() == kb.a.FIX ? z ? kb.b.FIX_DEGRADE_BYERROR : kb.b.FIX_DEGRADE_ONLY : z ? kb.b.DEGRADE_BYERROR : kb.b.DEGRADE_ONLY;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean b(kb kbVar) throws hn {
        d(kbVar);
        try {
            String ipv6url = kbVar.getIPV6URL();
            if (TextUtils.isEmpty(ipv6url)) {
                return false;
            }
            String host = new URL(ipv6url).getHost();
            if (!TextUtils.isEmpty(kbVar.getIPDNSName())) {
                host = kbVar.getIPDNSName();
            }
            return hp.d(host);
        } catch (Throwable th) {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static int c(kb kbVar, boolean z) {
        try {
            d(kbVar);
            int conntectionTimeout = kbVar.getConntectionTimeout();
            int i = hp.e;
            if (kbVar.getDegradeAbility() != kb.a.FIX) {
                if (kbVar.getDegradeAbility() != kb.a.SINGLE && conntectionTimeout >= i) {
                    if (z) {
                        return i;
                    }
                }
                return conntectionTimeout;
            }
            return conntectionTimeout;
        } catch (Throwable th) {
            return 5000;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean c(kb kbVar) throws hn {
        d(kbVar);
        try {
            if (b(kbVar)) {
                if (kbVar.getURL().equals(kbVar.getIPV6URL()) || kbVar.getDegradeAbility() == kb.a.SINGLE) {
                    return false;
                }
                return hp.h;
            }
            return true;
        } catch (Throwable th) {
            return true;
        }
    }

    @Deprecated
    private static kc d(kb kbVar, boolean z) throws hn {
        d(kbVar);
        kbVar.setHttpProtocol(z ? kb.c.HTTPS : kb.c.HTTP);
        long j = 0;
        boolean z2 = false;
        kc kcVar = null;
        if (b(kbVar)) {
            boolean c2 = c(kbVar);
            j = 0;
            try {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                j = elapsedRealtime;
                kcVar = a(kbVar, a(kbVar, c2), c(kbVar, c2));
                j = elapsedRealtime;
                z2 = false;
            } catch (hn e2) {
                if (e2.f() == 21 && kbVar.getDegradeAbility() == kb.a.INTERRUPT_IO) {
                    throw e2;
                }
                if (!c2) {
                    throw e2;
                }
                z2 = true;
                kcVar = null;
            }
        }
        if (kcVar == null || kcVar.a == null || kcVar.a.length <= 0) {
            try {
                return a(kbVar, b(kbVar, z2), a(kbVar, j));
            } catch (hn e3) {
                throw e3;
            }
        }
        return kcVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void d(kb kbVar) throws hn {
        if (kbVar == null) {
            throw new hn("requeust is null");
        }
        if (kbVar.getURL() == null || "".equals(kbVar.getURL())) {
            throw new hn("request url is empty");
        }
    }
}
