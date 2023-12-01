package com.tencent.map.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/map/b/g.class */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    private Context f23540a = null;
    private WifiManager b = null;

    /* renamed from: c  reason: collision with root package name */
    private a f23541c = null;
    private Handler d = null;
    private Runnable e = new Runnable() { // from class: com.tencent.map.b.g.1
        @Override // java.lang.Runnable
        public final void run() {
            g.a(g.this);
        }
    };
    private int f = 1;
    private c g = null;
    private b h = null;
    private boolean i = false;
    private byte[] j = new byte[0];

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/map/b/g$a.class */
    public final class a extends BroadcastReceiver {

        /* renamed from: a  reason: collision with root package name */
        private int f23543a = 4;
        private List<ScanResult> b = null;

        /* renamed from: c  reason: collision with root package name */
        private boolean f23544c = false;

        public a() {
        }

        private void a(List<ScanResult> list) {
            if (list == null) {
                return;
            }
            if (!this.f23544c) {
                List<ScanResult> list2 = this.b;
                if (list2 == null) {
                    this.b = new ArrayList();
                } else {
                    list2.clear();
                }
                for (ScanResult scanResult : list) {
                    this.b.add(scanResult);
                }
                return;
            }
            if (this.b == null) {
                this.b = new ArrayList();
            }
            int size = this.b.size();
            for (ScanResult scanResult2 : list) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= size) {
                        break;
                    } else if (this.b.get(i2).BSSID.equals(scanResult2.BSSID)) {
                        this.b.remove(i2);
                        break;
                    } else {
                        i = i2 + 1;
                    }
                }
                this.b.add(scanResult2);
            }
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            g gVar;
            List<ScanResult> list;
            if (intent.getAction().equals(WifiManager.WIFI_STATE_CHANGED_ACTION)) {
                this.f23543a = intent.getIntExtra("wifi_state", 4);
                if (g.this.g != null) {
                    g.this.g.b(this.f23543a);
                }
            }
            if (intent.getAction().equals(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION) || intent.getAction().equals(WifiManager.WIFI_STATE_CHANGED_ACTION)) {
                List<ScanResult> list2 = null;
                if (g.this.b != null) {
                    list2 = g.this.b.getScanResults();
                }
                if (intent.getAction().equals(WifiManager.WIFI_STATE_CHANGED_ACTION)) {
                    if (list2 == null) {
                        return;
                    }
                    if (list2 != null && list2.size() == 0) {
                        return;
                    }
                }
                if (!this.f23544c && (list = this.b) != null && list.size() >= 4 && list2 != null && list2.size() <= 2) {
                    a(list2);
                    this.f23544c = true;
                    g.this.a(0L);
                    return;
                }
                a(list2);
                this.f23544c = false;
                g gVar2 = g.this;
                gVar2.h = new b(gVar2, this.b, System.currentTimeMillis(), this.f23543a);
                if (g.this.g != null) {
                    g.this.g.a(g.this.h);
                }
                g.this.a(gVar.f * 20000);
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/map/b/g$b.class */
    public final class b implements Cloneable {

        /* renamed from: a  reason: collision with root package name */
        private List<ScanResult> f23545a;

        public b(g gVar, List<ScanResult> list, long j, int i) {
            this.f23545a = null;
            if (list != null) {
                this.f23545a = new ArrayList();
                for (ScanResult scanResult : list) {
                    this.f23545a.add(scanResult);
                }
            }
        }

        public final List<ScanResult> a() {
            return this.f23545a;
        }

        public final Object clone() {
            b bVar;
            try {
                bVar = (b) super.clone();
            } catch (Exception e) {
                bVar = null;
            }
            if (this.f23545a != null) {
                ArrayList arrayList = new ArrayList();
                bVar.f23545a = arrayList;
                arrayList.addAll(this.f23545a);
            }
            return bVar;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/map/b/g$c.class */
    public interface c {
        void a(b bVar);

        void b(int i);
    }

    static /* synthetic */ void a(g gVar) {
        WifiManager wifiManager = gVar.b;
        if (wifiManager == null || !wifiManager.isWifiEnabled()) {
            return;
        }
        gVar.b.startScan();
    }

    public final void a() {
        synchronized (this.j) {
            if (this.i) {
                if (this.f23540a == null || this.f23541c == null) {
                    return;
                }
                try {
                    this.f23540a.unregisterReceiver(this.f23541c);
                } catch (Exception e) {
                }
                this.d.removeCallbacks(this.e);
                this.i = false;
            }
        }
    }

    public final void a(long j) {
        Handler handler = this.d;
        if (handler == null || !this.i) {
            return;
        }
        handler.removeCallbacks(this.e);
        this.d.postDelayed(this.e, j);
    }

    public final boolean a(Context context, c cVar, int i) {
        synchronized (this.j) {
            if (this.i) {
                return true;
            }
            if (context == null || cVar == null) {
                return false;
            }
            this.d = new Handler(Looper.getMainLooper());
            this.f23540a = context;
            this.g = cVar;
            this.f = 1;
            try {
                this.b = (WifiManager) context.getSystemService("wifi");
                IntentFilter intentFilter = new IntentFilter();
                a aVar = new a();
                this.f23541c = aVar;
                if (this.b == null || aVar == null) {
                    return false;
                }
                intentFilter.addAction(WifiManager.WIFI_STATE_CHANGED_ACTION);
                intentFilter.addAction(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION);
                this.f23540a.registerReceiver(this.f23541c, intentFilter);
                a(0L);
                this.i = true;
                return true;
            } catch (Exception e) {
                return false;
            }
        }
    }

    public final boolean b() {
        return this.i;
    }

    public final boolean c() {
        WifiManager wifiManager;
        if (this.f23540a == null || (wifiManager = this.b) == null) {
            return false;
        }
        return wifiManager.isWifiEnabled();
    }
}
