package c.t.m.g;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.PowerManager;
import android.os.SystemClock;
import android.text.TextUtils;
import com.igexin.assist.util.AssistUtils;
import com.tencent.map.geolocation.TencentGeofence;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationListener;
import com.tencent.map.geolocation.TencentLocationRequest;
import com.tencent.map.geolocation.fence.TxGeofenceManagerState;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/a4.class */
public class a4 extends BroadcastReceiver implements PendingIntent.OnFinished, TencentLocationListener {

    /* renamed from: a  reason: collision with root package name */
    public final Context f3694a;
    public final p4 b;

    /* renamed from: c  reason: collision with root package name */
    public final PowerManager.WakeLock f3695c;
    public final PowerManager.WakeLock d;
    public final b e;
    public final d f;
    public final c g;
    public boolean h;
    public boolean i;
    public PendingIntent j;
    public final TencentLocationRequest k;
    public boolean l;
    public double m;

    /* loaded from: source-8756600-dex2jar.jar:c/t/m/g/a4$b.class */
    public final class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                a4.this.a(true);
            } else if (i != 2) {
            } else {
                a4.b("handleMessage: mock alarm --> wakeup");
                a4.this.f3694a.sendBroadcast(a4.this.b());
            }
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:c/t/m/g/a4$c.class */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public final List<x3> f3697a = new LinkedList();
        public boolean b = false;

        /* renamed from: c  reason: collision with root package name */
        public long f3698c = 60000;
        public Location d = null;
        public boolean e = false;
        public final float[] f = {-1.0f, -1.0f};

        public void a() {
            this.f3697a.clear();
            this.b = false;
            this.f3698c = 60000L;
            this.d = null;
            this.e = false;
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:c/t/m/g/a4$d.class */
    public final class d implements TxGeofenceManagerState {

        /* renamed from: a  reason: collision with root package name */
        public LinkedList<TencentLocation> f3699a;
        public List<Map<String, String>> b;

        public d() {
            this.f3699a = new LinkedList<>();
            this.b = new ArrayList();
        }

        @Override // com.tencent.map.geolocation.fence.TxGeofenceManagerState
        public void add(int i, TencentLocation tencentLocation) {
            if (i == 0) {
                this.f3699a.add(tencentLocation);
            } else {
                this.f3699a.add(q5.q.a(System.currentTimeMillis()));
            }
        }

        @Override // com.tencent.map.geolocation.fence.TxGeofenceManagerState
        public long getLastInterval() {
            return a4.this.g.f3698c;
        }

        @Override // com.tencent.map.geolocation.fence.TxGeofenceManagerState
        public TencentLocation getLastLocation() {
            return this.f3699a.isEmpty() ? q5.q : this.f3699a.getLast();
        }

        @Override // com.tencent.map.geolocation.fence.TxGeofenceManagerState
        public long getLastLocationTime() {
            if (this.f3699a.isEmpty()) {
                return 0L;
            }
            return this.f3699a.getLast().getTime();
        }

        @Override // com.tencent.map.geolocation.fence.TxGeofenceManagerState
        public Map<String, String> getLastSummary() {
            if (this.b.isEmpty()) {
                return Collections.emptyMap();
            }
            List<Map<String, String>> list = this.b;
            return list.get(list.size() - 1);
        }

        @Override // com.tencent.map.geolocation.fence.TxGeofenceManagerState
        public String getLocationTimes() {
            int size = this.f3699a.size();
            Iterator<TencentLocation> it = this.f3699a.iterator();
            int i = 0;
            while (it.hasNext()) {
                if (it.next() == q5.q) {
                    i++;
                }
            }
            return size + "/" + i;
        }

        @Override // com.tencent.map.geolocation.fence.TxGeofenceManagerState
        public List<TencentLocation> getLocations() {
            return new ArrayList(this.f3699a);
        }

        @Override // com.tencent.map.geolocation.fence.TxGeofenceManagerState
        public long getNextLocationTime() {
            return getLastLocationTime() + a4.this.g.f3698c;
        }

        @Override // com.tencent.map.geolocation.fence.TxGeofenceManagerState
        public double getSpeed() {
            return a4.this.f();
        }

        @Override // com.tencent.map.geolocation.fence.TxGeofenceManagerState
        public List<Map<String, String>> getSummary() {
            return this.b;
        }

        @Override // com.tencent.map.geolocation.fence.TxGeofenceManagerState
        public void reset() {
        }
    }

    public a4(Context context) {
        this(context, Looper.myLooper());
    }

    public a4(Context context, Looper looper) {
        this.g = new c();
        this.h = false;
        this.i = false;
        this.k = TencentLocationRequest.create().setRequestLevel(0).setInterval(0L);
        this.m = 1.0d;
        this.f3694a = context;
        this.b = new p4(t3.a(context));
        PowerManager powerManager = (PowerManager) this.f3694a.getSystemService(Context.POWER_SERVICE);
        this.f3695c = powerManager.newWakeLock(1, "GeofenceManager");
        PowerManager.WakeLock newWakeLock = powerManager.newWakeLock(1, "tencent_location");
        this.d = newWakeLock;
        newWakeLock.setReferenceCounted(false);
        this.e = new b(looper);
        this.f = new d();
        g();
    }

    public static void b(String str) {
    }

    public float a(List<Float> list) {
        float f;
        if (list.size() >= 1) {
            Collections.sort(list);
            Collections.reverse(list);
            f = list.get(0).floatValue();
        } else {
            f = 25.0f;
        }
        float[] fArr = this.g.f;
        if (fArr[0] > 0.0f) {
            fArr[0] = fArr[0] + f;
            fArr[0] = (float) (fArr[0] * 0.5d);
        } else {
            fArr[0] = f;
        }
        return this.g.f[0];
    }

    public final PendingIntent a(long j) {
        AlarmManager alarmManager = (AlarmManager) this.f3694a.getSystemService("alarm");
        PendingIntent pendingIntent = null;
        if (alarmManager == null) {
            return null;
        }
        String str = Build.MANUFACTURER;
        boolean contains = str != null ? str.toLowerCase(Locale.US).contains(AssistUtils.BRAND_XIAOMI) : false;
        PendingIntent pendingIntent2 = this.j;
        if (pendingIntent2 != null) {
            alarmManager.cancel(pendingIntent2);
            this.j = null;
            if (contains) {
                this.e.removeMessages(2);
            }
        }
        if (j > 0) {
            pendingIntent = c();
            this.j = pendingIntent;
            alarmManager.setRepeating(2, SystemClock.elapsedRealtime() + j, j, pendingIntent);
            if (contains) {
                this.e.sendEmptyMessageDelayed(2, 10000 + j);
            }
            b("setLocationAlarm: will triggered after " + j + " ms, isXiaomi=" + contains);
        }
        return pendingIntent;
    }

    public final void a() {
        if (this.h) {
            throw new IllegalStateException("this object has been destroyed!");
        }
    }

    public final void a(PendingIntent pendingIntent) {
        String str = "sendIntentEnter: pendingIntent=" + pendingIntent;
        Intent intent = new Intent();
        intent.putExtra(LocationManager.KEY_PROXIMITY_ENTERING, true);
        a(pendingIntent, intent);
    }

    public final void a(PendingIntent pendingIntent, Intent intent) {
        this.f3695c.acquire();
        try {
            pendingIntent.send(this.f3694a, 0, intent, this, null);
        } catch (PendingIntent.CanceledException e) {
            b(null, pendingIntent);
            this.f3695c.release();
        }
    }

    public void a(TencentGeofence tencentGeofence) {
        a();
        if (tencentGeofence == null) {
            return;
        }
        String str = "removeFence: fence=" + tencentGeofence;
        synchronized (this.g) {
            Iterator<x3> it = this.g.f3697a.iterator();
            while (it.hasNext()) {
                if (tencentGeofence.equals(it.next().f4005a)) {
                    it.remove();
                }
            }
            e("removeFence: --> schedule update fence");
        }
    }

    public void a(TencentGeofence tencentGeofence, PendingIntent pendingIntent) {
        a();
        if (tencentGeofence == null || pendingIntent == null) {
            throw null;
        }
        String str = "addFence: , geofence=" + tencentGeofence + ", intent=" + pendingIntent;
        x3 x3Var = new x3(tencentGeofence, tencentGeofence.getExpireAt(), "packageName", pendingIntent);
        c cVar = this.g;
        List<x3> list = cVar.f3697a;
        synchronized (cVar) {
            int size = list.size();
            while (true) {
                int i = size - 1;
                if (i < 0) {
                    break;
                }
                x3 x3Var2 = list.get(i);
                if (tencentGeofence.equals(x3Var2.f4005a) && pendingIntent.equals(x3Var2.d)) {
                    list.remove(i);
                    break;
                }
                size = i;
            }
            list.add(x3Var);
            e("addFence: --> schedule update fence");
        }
    }

    public final void a(boolean z) {
        double d2;
        long j;
        LinkedList<PendingIntent> linkedList = new LinkedList();
        LinkedList<PendingIntent> linkedList2 = new LinkedList();
        synchronized (this.g) {
            this.g.e = false;
            i();
            Location e = e();
            b("updateFences: fresh_location=" + e);
            ArrayList arrayList = new ArrayList();
            List<x3> list = this.g.f3697a;
            boolean isEmpty = list.isEmpty() ^ true;
            if (e != null) {
                y3.a(e);
                Iterator<x3> it = list.iterator();
                double d3 = Double.MAX_VALUE;
                while (true) {
                    d2 = d3;
                    if (!it.hasNext()) {
                        break;
                    }
                    x3 next = it.next();
                    int a2 = next.a(e);
                    if ((a2 & 1) != 0) {
                        linkedList.add(next.d);
                    }
                    if ((a2 & 2) != 0) {
                        linkedList2.add(next.d);
                    }
                    double a3 = next.a();
                    double d4 = d2;
                    if (a3 < d2) {
                        d4 = a3;
                    }
                    if (next.c()) {
                        arrayList.add(Float.valueOf(next.b()));
                    }
                    d3 = d4;
                }
                a(arrayList);
            } else {
                d2 = Double.MAX_VALUE;
            }
            if (isEmpty) {
                double f = f();
                if (e == null || Double.compare(d2, Double.MAX_VALUE) == 0) {
                    j = 60000;
                } else {
                    long min = (long) Math.min(900000.0d, Math.max(60000.0d, (d2 * 1000.0d) / f));
                    j = min;
                    if (d2 < 1000.0d) {
                        j = min;
                        if (min > 305000) {
                            j = 305000;
                        }
                    }
                }
                if (f >= 5.0d || d2 <= 800.0d) {
                    this.m = 1.0d;
                } else {
                    double d5 = this.m * 1.02d;
                    this.m = d5;
                    long j2 = (long) (d5 * 2.0d * 60000.0d);
                    j = j2;
                    if (j2 > 305000) {
                        j = 305000;
                    }
                }
                this.g.f3698c = j;
                boolean z2 = z && e == null;
                b(String.format(Locale.getDefault(), "updateFences: needUpdates=%s, interval=%d, minDist=%5g, speed=%.2f, reschedule=%s, rate=%.2f", Boolean.valueOf(isEmpty), Long.valueOf(j), Double.valueOf(d2), Double.valueOf(f), Boolean.valueOf(z2), Double.valueOf(this.m)));
                if (!this.g.b) {
                    this.g.b = true;
                    this.d.acquire(12000L);
                    this.b.a(this.k, this, this.e.getLooper());
                } else if (z2) {
                    a(-1L);
                    this.g.b = true;
                    this.d.acquire(12000L);
                    this.b.a(this.k, this, this.e.getLooper());
                }
            } else if (this.g.b) {
                this.g.b = false;
                j();
                k();
            }
            HashMap hashMap = new HashMap();
            for (x3 x3Var : list) {
                hashMap.put(x3Var.f4005a.getTag(), x3Var.toString());
            }
            this.f.b.add(hashMap);
        }
        for (PendingIntent pendingIntent : linkedList2) {
            b(pendingIntent);
        }
        for (PendingIntent pendingIntent2 : linkedList) {
            a(pendingIntent2);
        }
    }

    public final Intent b() {
        Intent intent = new Intent("com.tencent.map.geolocation.wakeup");
        intent.putExtra("com.tencent.map.geolocation.from_alarm", true);
        return intent;
    }

    public final void b(PendingIntent pendingIntent) {
        String str = "sendIntentExit: pendingIntent=" + pendingIntent;
        Intent intent = new Intent();
        intent.putExtra(LocationManager.KEY_PROXIMITY_ENTERING, false);
        a(pendingIntent, intent);
    }

    public final void b(TencentGeofence tencentGeofence, PendingIntent pendingIntent) {
        String str = "removeFence: fence=" + tencentGeofence + ", intent=" + pendingIntent;
        synchronized (this.g) {
            Iterator<x3> it = this.g.f3697a.iterator();
            while (it.hasNext()) {
                x3 next = it.next();
                if (next.d.equals(pendingIntent)) {
                    if (tencentGeofence == null) {
                        it.remove();
                    } else if (tencentGeofence.equals(next.f4005a)) {
                        it.remove();
                    }
                }
            }
            e("_removeFence: --> schedule update fence");
        }
    }

    public final PendingIntent c() {
        return Build.VERSION.SDK_INT >= 31 ? PendingIntent.getBroadcast(this.f3694a, 0, b(), 201326592) : PendingIntent.getBroadcast(this.f3694a, 0, b(), 134217728);
    }

    public void c(String str) {
        a();
        synchronized (this.g) {
            Iterator<x3> it = this.g.f3697a.iterator();
            while (it.hasNext()) {
                TencentGeofence tencentGeofence = it.next().f4005a;
                if (tencentGeofence == null || TextUtils.equals(tencentGeofence.getTag(), str)) {
                    it.remove();
                }
            }
            e("removeFence: " + str + " removed --> schedule update fence");
        }
    }

    public void d() {
        if (this.h) {
            return;
        }
        k();
        this.f3694a.unregisterReceiver(this);
        synchronized (this.g) {
            Arrays.fill(this.g.f, -1.0f);
            j();
        }
        this.i = false;
        this.h = true;
    }

    public final void d(String str) {
        if (a6.c(this.f3694a)) {
            if (this.g.e) {
                return;
            }
            b(str);
            this.g.e = true;
            this.e.sendEmptyMessage(1);
            return;
        }
        b("no data conn. skip [" + str + "]");
    }

    public final Location e() {
        c cVar = this.g;
        Location location = cVar.d;
        List<x3> list = cVar.f3697a;
        Location location2 = location;
        if (location == null) {
            location2 = location;
            if (!list.isEmpty()) {
                location2 = y3.a(this.b.k(), this.i);
            }
        }
        if (location2 != null && System.currentTimeMillis() - location2.getTime() < 60000) {
            return location2;
        }
        return null;
    }

    public final void e(String str) {
        if (this.g.e) {
            return;
        }
        b(str);
        this.g.e = true;
        this.e.sendEmptyMessage(1);
    }

    public final double f() {
        float f;
        if (z3.a(this.f3694a)) {
            return 1.0d;
        }
        float f2 = 1.0f;
        float f3 = 25.0f;
        if (h6.b(t3.a(this.f3694a))) {
            f3 = (float) (25.0f * 0.6d);
        } else {
            f2 = 3.0f;
        }
        if (this.g.f[0] < f2) {
            return a6.d(this.f3694a) ? f3 * 0.3d : f3;
        }
        double min = (Math.min(Math.max(f2, f), 10.0f + f3) * 0.8d) + ((f3 + f2) * 0.1d);
        double d2 = f2;
        double d3 = min;
        if (min < d2) {
            d3 = d2;
        }
        return d3;
    }

    public final void g() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_SCREEN_ON);
        intentFilter.addAction("com.tencent.map.geolocation.wakeup");
        intentFilter.addAction(Intent.ACTION_POWER_DISCONNECTED);
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        this.f3694a.registerReceiver(this, intentFilter, null, this.e);
    }

    public void h() {
        a();
        synchronized (this.g) {
            this.b.a(this);
            j();
        }
    }

    public final void i() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Iterator<x3> it = this.g.f3697a.iterator();
        while (it.hasNext()) {
            if (it.next().f4006c < elapsedRealtime) {
                it.remove();
            }
        }
    }

    public final void j() {
        this.g.a();
        this.f.reset();
    }

    public final void k() {
        a(-1L);
        this.e.removeMessages(2);
        this.b.a(this);
    }

    @Override // com.tencent.map.geolocation.TencentLocationListener
    public void onLocationChanged(TencentLocation tencentLocation, int i, String str) {
        Location a2 = y3.a(tencentLocation, this.i);
        b(y3.a(tencentLocation, i));
        if (!this.i || i == 0 || "gps".equals(tencentLocation.getProvider())) {
            if (!this.l) {
                this.b.a(this);
            }
            synchronized (this.g) {
                if (i == 0) {
                    this.f.add(i, tencentLocation);
                    if (this.g.b) {
                        this.g.d = a2;
                    }
                    if (this.g.e) {
                        this.e.removeMessages(1);
                    } else {
                        this.g.e = true;
                    }
                    b("onLocationChanged: fresh location got --> update fences");
                    a(false);
                } else {
                    this.g.f3698c = 60000L;
                    this.f.add(i, tencentLocation);
                }
                if (this.g.b) {
                    b("onLocationChanged: set a new repeat alarm, interval=" + this.g.f3698c);
                    a(this.g.f3698c);
                }
            }
            if (this.d.isHeld()) {
                this.d.release();
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        synchronized (this.g) {
            boolean z = e() == null;
            if (Intent.ACTION_SCREEN_ON.equals(action)) {
                if (z) {
                    d("onReceive: screen_on and no_fresh_location --> schedule update fence");
                }
            } else if ("com.tencent.map.geolocation.wakeup".equals(action)) {
                try {
                    b4.a(this.f3694a);
                    this.e.removeMessages(2);
                    e("onReceive: alarm --> schedule update fence");
                } catch (Exception e) {
                }
                b4.a();
            } else if (Intent.ACTION_POWER_DISCONNECTED.equals(action)) {
                if (z) {
                    d("onReceive: power_disconnected --> schedule update fence");
                }
            } else if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
                if (!a6.c(this.f3694a)) {
                    b("onReceive: disconnected and stop location updates temporaryly");
                    this.g.b = false;
                    this.g.f3698c = 60000L;
                    k();
                }
                d("onReceive: connected and no_fresh_location --> schedule update fence");
            }
        }
    }

    @Override // android.app.PendingIntent.OnFinished
    public void onSendFinished(PendingIntent pendingIntent, Intent intent, int i, String str, Bundle bundle) {
        this.f3695c.release();
    }

    @Override // com.tencent.map.geolocation.TencentLocationListener
    public void onStatusUpdate(String str, int i, String str2) {
    }
}
