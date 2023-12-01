package com.amap.api.col.p0003sl;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.amap.api.col.p0003sl.kb;
import com.amap.api.col.p0003sl.la;
import com.amap.api.maps.AMapException;
import java.util.Map;

/* renamed from: com.amap.api.col.3sl.ka  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/ka.class */
public final class ka extends ju {
    private static ka f;
    private lb g;
    private Handler h;

    /* renamed from: com.amap.api.col.3sl.ka$a */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/ka$a.class */
    static final class a extends Handler {
        public a() {
        }

        private a(Looper looper) {
            super(looper);
        }

        /* synthetic */ a(Looper looper, byte b) {
            this(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            try {
                int i = message.what;
                if (i == 0) {
                    Object obj = message.obj;
                } else if (i != 1) {
                } else {
                    Object obj2 = message.obj;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private ka(boolean z) {
        if (z) {
            try {
                this.g = lb.a(new la.a().a("amap-netmanger-threadpool-%d").b());
            } catch (Throwable th) {
                iw.c(th, "NetManger", "NetManger1");
                th.printStackTrace();
                return;
            }
        }
        if (Looper.myLooper() == null) {
            this.h = new a(Looper.getMainLooper(), (byte) 0);
        } else {
            this.h = new a();
        }
    }

    private static ka a(boolean z) {
        ka kaVar;
        synchronized (ka.class) {
            try {
                if (f == null) {
                    f = new ka(z);
                } else if (z && f.g == null) {
                    f.g = lb.a(new la.a().a("amap-netmanger-threadpool-%d").b());
                }
                kaVar = f;
            }
        }
        return kaVar;
    }

    private static Map<String, String> a(kb kbVar, kb.b bVar, int i) throws hn {
        try {
            d(kbVar);
            kbVar.setDegradeType(bVar);
            kbVar.setReal_max_timeout(i);
            return new jy().a(kbVar);
        } catch (hn e) {
            throw e;
        } catch (Throwable th) {
            th.printStackTrace();
            throw new hn(AMapException.ERROR_UNKNOWN);
        }
    }

    public static ka b() {
        return a(true);
    }

    private static kc b(kb kbVar, kb.b bVar, int i) throws hn {
        try {
            d(kbVar);
            kbVar.setDegradeType(bVar);
            kbVar.setReal_max_timeout(i);
            return new jy().b(kbVar);
        } catch (hn e) {
            throw e;
        } catch (Throwable th) {
            th.printStackTrace();
            throw new hn(AMapException.ERROR_UNKNOWN);
        }
    }

    public static ka c() {
        return a(false);
    }

    @Deprecated
    public static Map<String, String> d(kb kbVar, boolean z) throws hn {
        d(kbVar);
        kbVar.setHttpProtocol(z ? kb.c.HTTPS : kb.c.HTTP);
        long j = 0;
        boolean z2 = false;
        Map<String, String> map = null;
        if (b(kbVar)) {
            boolean c = c(kbVar);
            j = 0;
            try {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                j = elapsedRealtime;
                map = a(kbVar, a(kbVar, c), c(kbVar, c));
                j = elapsedRealtime;
                z2 = false;
            } catch (hn e) {
                if (!c) {
                    throw e;
                }
                z2 = true;
                map = null;
            }
        }
        if (map == null) {
            try {
                return a(kbVar, b(kbVar, z2), a(kbVar, j));
            } catch (hn e2) {
                throw e2;
            }
        }
        return map;
    }

    public static kc e(kb kbVar) throws hn {
        return e(kbVar, kbVar.isHttps());
    }

    @Deprecated
    private static kc e(kb kbVar, boolean z) throws hn {
        d(kbVar);
        kbVar.setHttpProtocol(z ? kb.c.HTTPS : kb.c.HTTP);
        long j = 0;
        boolean z2 = false;
        kc kcVar = null;
        if (b(kbVar)) {
            boolean c = c(kbVar);
            j = 0;
            try {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                j = elapsedRealtime;
                kcVar = b(kbVar, a(kbVar, c), c(kbVar, c));
                j = elapsedRealtime;
                z2 = false;
            } catch (hn e) {
                if (e.f() == 21 && kbVar.getDegradeAbility() == kb.a.INTERRUPT_IO) {
                    throw e;
                }
                if (!c) {
                    throw e;
                }
                z2 = true;
                kcVar = null;
            }
        }
        if (kcVar == null || kcVar.a == null || kcVar.a.length <= 0) {
            try {
                return b(kbVar, b(kbVar, z2), a(kbVar, j));
            } catch (hn e2) {
                throw e2;
            }
        }
        return kcVar;
    }
}
