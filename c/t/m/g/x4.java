package c.t.m.g;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.provider.Settings;
import com.blued.das.live.LiveProtos;
import com.tencent.liteav.TXLiteAVCode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/x4.class */
public final class x4 extends BroadcastReceiver {
    public static boolean p;

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f4007a;
    public final t3 b;

    /* renamed from: c  reason: collision with root package name */
    public final WifiManager f4008c;
    public long d;
    public HashSet<String> e;
    public volatile Handler f;
    public volatile Handler g;
    public volatile c h;
    public volatile List<ScanResult> i;
    public volatile List<ScanResult> j;
    public Runnable k;
    public Runnable l;
    public String m;
    public long n = 30000;
    public final byte[] o = new byte[0];

    /* loaded from: source-8756600-dex2jar.jar:c/t/m/g/x4$a.class */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            x4.this.e();
            if (x4.this.n > 0) {
                x4 x4Var = x4.this;
                x4Var.a(x4Var.n);
            }
            long unused = x4.this.n;
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:c/t/m/g/x4$b.class */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(WifiManager.WIFI_STATE_CHANGED_ACTION);
            intentFilter.addAction(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION);
            try {
                if (x4.this.g != null) {
                    x4.this.b.f3944a.registerReceiver(x4.this, intentFilter, null, x4.this.g);
                } else {
                    x4.this.b.f3944a.registerReceiver(x4.this, intentFilter);
                }
            } catch (Exception e) {
            }
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:c/t/m/g/x4$c.class */
    public class c extends Handler {
        public c(Looper looper) {
            super(looper);
        }

        public final void a() {
            try {
                List<ScanResult> list = x4.this.i;
                if (list != null && list.size() > 0) {
                    if (x4.this.j == null) {
                        x4.this.j = new ArrayList();
                    }
                    x4.this.m = "";
                    int i = 1;
                    for (ScanResult scanResult : list) {
                        if (i <= 20) {
                            x4.this.m = x4.this.m + scanResult.SSID + "," + scanResult.BSSID + "|";
                            i++;
                        }
                    }
                    x4.this.j.clear();
                    x4.this.j.addAll(list);
                    y4.a(x4.this.j);
                    if (x4.this.j == null || x4.this.j.size() <= 0) {
                        return;
                    }
                    x4.this.a();
                    return;
                }
                x4.this.b.a(g5.d);
                x4.this.m = "";
            } catch (Throwable th) {
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            synchronized (x4.this.o) {
                switch (message.what) {
                    case 1201:
                        x4.this.b();
                        break;
                    case 1202:
                        a();
                        break;
                    case TXLiteAVCode.WARNING_MICROPHONE_NOT_AUTHORIZED /* 1203 */:
                        x4.this.a((Intent) message.obj);
                        break;
                }
            }
        }
    }

    public x4(t3 t3Var) {
        this.b = t3Var;
        this.f4008c = t3Var.f();
        f6.f3764a = 0L;
        this.e = new HashSet<>();
        this.k = new a();
        this.l = new b();
    }

    public final void a() {
        List<ScanResult> list = this.j;
        if (this.e == null) {
            this.e = new HashSet<>();
        }
        if (list == null) {
            return;
        }
        if (this.e.size() == 0) {
            for (ScanResult scanResult : list) {
                HashSet<String> hashSet = this.e;
                hashSet.add(scanResult.BSSID + scanResult.level);
            }
            this.d = System.currentTimeMillis();
            b(list);
            return;
        }
        int size = this.e.size();
        if (size != list.size()) {
            this.e.clear();
            for (ScanResult scanResult2 : list) {
                HashSet<String> hashSet2 = this.e;
                hashSet2.add(scanResult2.BSSID + scanResult2.level);
            }
            this.d = System.currentTimeMillis();
            b(list);
            return;
        }
        for (ScanResult scanResult3 : list) {
            HashSet<String> hashSet3 = this.e;
            hashSet3.add(scanResult3.BSSID + scanResult3.level);
        }
        if (size != this.e.size()) {
            this.e.clear();
            for (ScanResult scanResult4 : list) {
                HashSet<String> hashSet4 = this.e;
                hashSet4.add(scanResult4.BSSID + scanResult4.level);
            }
            this.d = System.currentTimeMillis();
            b(list);
        }
    }

    public final void a(int i) {
        if (this.h != null) {
            c3.b(this.h, i);
        }
    }

    public void a(long j) {
        Handler handler = this.f;
        Runnable runnable = this.k;
        Looper looper = handler == null ? null : handler.getLooper();
        if (looper == null || !looper.getThread().isAlive()) {
            return;
        }
        handler.removeCallbacks(runnable);
        handler.postDelayed(runnable, j);
    }

    public final void a(Intent intent) {
        if (intent == null) {
            return;
        }
        try {
            String action = intent.getAction();
            boolean equals = WifiManager.WIFI_STATE_CHANGED_ACTION.equals(action);
            if (equals) {
                a(1201);
            }
            boolean equals2 = WifiManager.SCAN_RESULTS_AVAILABLE_ACTION.equals(action);
            if (equals2 || equals) {
                this.i = h6.a(this.f4008c, equals2);
                a(1202);
            }
        } catch (Throwable th) {
        }
    }

    public void a(Handler handler, Handler handler2, Handler handler3, boolean z) {
        synchronized (this.o) {
            if (this.f4007a) {
                return;
            }
            this.f4007a = true;
            f6.f3764a = 0L;
            p = z;
            this.f = handler;
            this.g = handler3;
            if (this.h == null || this.h.getLooper() != handler.getLooper()) {
                if (this.h != null) {
                    this.h.removeCallbacksAndMessages(null);
                }
                if (handler != null) {
                    this.h = new c(handler.getLooper());
                }
            }
            handler2.post(this.l);
            if (!p) {
                a(0L);
            }
        }
    }

    public final boolean a(List<ScanResult> list) {
        boolean z = true;
        if (this.f4008c != null) {
            z = true;
            if (!m3.a((Collection) list)) {
                z = true;
                boolean z2 = true;
                try {
                    if (!this.f4008c.isWifiEnabled()) {
                        z = true;
                        if (Build.VERSION.SDK_INT >= 18) {
                            z = true;
                            if (!this.f4008c.isScanAlwaysAvailable()) {
                                long j = 0;
                                for (ScanResult scanResult : list) {
                                    if (scanResult.timestamp > j) {
                                        j = scanResult.timestamp;
                                    }
                                }
                                long elapsedRealtime = SystemClock.elapsedRealtime() - (j / 1000);
                                z = elapsedRealtime <= 60000;
                                StringBuilder sb = new StringBuilder();
                                boolean z3 = z;
                                sb.append("wifi closed,list v=");
                                boolean z4 = z;
                                sb.append(z);
                                boolean z5 = z;
                                sb.append(",d_t=");
                                boolean z6 = z;
                                sb.append(elapsedRealtime);
                                boolean z7 = z;
                                sb.append("ms");
                                z2 = z;
                                s3.a("WIFI", sb.toString());
                            }
                        }
                    }
                } catch (Throwable th) {
                    return z2;
                }
            }
        }
        return z;
    }

    public final void b() {
        try {
            int a2 = h6.a(this.f4008c);
            int i = 1;
            if (a2 == 3) {
                a(0L);
            } else if (a2 == 1) {
                i = 0;
                if (!h6.c(this.b)) {
                    if (this.j != null) {
                        this.j.clear();
                    }
                    i = 0;
                    if (this.f != null) {
                        c3.b(this.f, LiveProtos.Event.LIVE_ONLINE_USER_PAGE_SHOW_VALUE);
                        i = 0;
                    }
                }
            } else {
                i = -1;
            }
            int i2 = i;
            try {
                if (Build.VERSION.SDK_INT >= 23) {
                    i2 = i;
                    if (Settings.Secure.getInt(this.b.f3944a.getContentResolver(), Settings.Secure.LOCATION_MODE) == 0) {
                        i2 = 5;
                    }
                }
            } catch (Throwable th) {
                i2 = i;
            }
            Message message = new Message();
            message.what = 12999;
            message.arg1 = 12001;
            message.arg2 = i2;
            this.b.a(message);
        } catch (Throwable th2) {
        }
    }

    public void b(long j) {
        this.n = j;
    }

    public final void b(List<ScanResult> list) {
        if (list == null || list.size() == 0) {
            b();
        } else if (h6.f3785a) {
            h6.f3785a = false;
            b();
        }
        if (a(list)) {
            this.b.a(new g5(list, this.d, h6.a(this.f4008c)));
        }
    }

    public int c() {
        return !e();
    }

    public void d() {
        synchronized (this.o) {
            if (this.f4007a) {
                this.f4007a = false;
                f6.f3764a = 0L;
                try {
                    this.b.f3944a.unregisterReceiver(this);
                } catch (Exception e) {
                }
                this.e = null;
                if (this.j != null) {
                    this.j.clear();
                }
                if (this.e != null) {
                    this.e.clear();
                }
                if (this.h != null) {
                    this.h.removeCallbacksAndMessages(null);
                    this.h = null;
                }
            }
        }
    }

    public final boolean e() {
        if (!h6.c(this.b) || p) {
            return false;
        }
        boolean b2 = h6.b(this.f4008c);
        s3.a("WIFI", "fs:" + m3.a(b2));
        return b2;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        c cVar = this.h;
        if (cVar != null) {
            Message obtainMessage = cVar.obtainMessage();
            obtainMessage.obj = intent;
            obtainMessage.what = TXLiteAVCode.WARNING_MICROPHONE_NOT_AUTHORIZED;
            c3.a(cVar, obtainMessage);
        }
    }
}
