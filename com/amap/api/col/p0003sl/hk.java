package com.amap.api.col.p0003sl;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.amap.api.maps.CoordinateConverter;
import com.amap.api.maps.LocationSource;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.MyLocationStyle;
import com.amap.api.trace.LBSTraceBase;
import com.amap.api.trace.LBSTraceClient;
import com.amap.api.trace.TraceListener;
import com.amap.api.trace.TraceLocation;
import com.amap.api.trace.TraceStatusListener;
import com.android.internal.widget.LockPatternUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* renamed from: com.amap.api.col.3sl.hk  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/hk.class */
public final class hk implements LocationSource.OnLocationChangedListener, LBSTraceBase {
    private Context b;
    private CoordinateConverter c;
    private lb d;
    private lb e;
    private TraceStatusListener h;
    private av i;
    private c n;
    private long f = 2000;
    private int g = 5;
    private List<TraceLocation> j = new ArrayList();
    private int k = 0;
    private int l = 0;
    private long m = 0;
    private TraceLocation o = null;
    private List<LatLng> p = new ArrayList();
    private List<LatLng> q = new ArrayList();
    private List<LatLng> r = new ArrayList();
    int a = Runtime.getRuntime().availableProcessors();
    private BlockingQueue<Runnable> s = new LinkedBlockingQueue();
    private BlockingQueue<Runnable> t = new LinkedBlockingQueue();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.amap.api.col.3sl.hk$a */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/hk$a.class */
    public final class a extends lc {
        private int c;
        private int d;
        private List<TraceLocation> e;
        private TraceListener h;
        private List<TraceLocation> b = new ArrayList();
        private String g = Cdo.a();

        public a(int i, List<TraceLocation> list, int i2, TraceListener traceListener) {
            this.c = i2;
            this.d = i;
            this.e = list;
            this.h = traceListener;
        }

        private int a() {
            List<TraceLocation> list = this.e;
            int i = 0;
            int i2 = 0;
            if (list != null) {
                if (list.size() != 0) {
                    ArrayList arrayList = new ArrayList();
                    Iterator<TraceLocation> it = this.e.iterator();
                    while (true) {
                        i = i2;
                        if (!it.hasNext()) {
                            break;
                        }
                        TraceLocation next = it.next();
                        if (next != null) {
                            if (next.getSpeed() < 0.01d) {
                                arrayList.add(next);
                            } else {
                                i2 += a(arrayList);
                                arrayList.clear();
                            }
                        }
                    }
                } else {
                    return 0;
                }
            }
            return i;
        }

        private static int a(List<TraceLocation> list) {
            int size = list.size();
            if (size <= 1) {
                return 0;
            }
            TraceLocation traceLocation = list.get(0);
            TraceLocation traceLocation2 = list.get(size - 1);
            int i = 0;
            if (traceLocation != null) {
                if (traceLocation2 == null) {
                    return 0;
                }
                i = 0;
                if (traceLocation != null) {
                    i = 0;
                    if (traceLocation2 != null) {
                        i = (int) ((traceLocation2.getTime() - traceLocation.getTime()) / 1000);
                    }
                }
            }
            return i;
        }

        @Override // com.amap.api.col.p0003sl.lc
        public final void runTask() {
            try {
                hk.this.n.a(this.h);
                int a = a();
                if (this.e != null && this.e.size() >= 2) {
                    for (TraceLocation traceLocation : this.e) {
                        TraceLocation copy = traceLocation.copy();
                        if (copy != null && copy.getLatitude() > 0.0d && copy.getLongitude() > 0.0d) {
                            this.b.add(copy);
                        }
                    }
                    int size = (this.b.size() - 2) / 500;
                    hl.a().a(this.g, this.d, size, a);
                    int i = 500;
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 > size) {
                            return;
                        }
                        if (i3 == size) {
                            i = this.b.size();
                        }
                        ArrayList arrayList = new ArrayList();
                        int i4 = 0;
                        while (true) {
                            int i5 = i4;
                            if (i5 >= i) {
                                break;
                            }
                            TraceLocation remove = this.b.remove(0);
                            if (remove != null) {
                                if (this.c != 1) {
                                    if (this.c == 3) {
                                        hk.this.c.from(CoordinateConverter.CoordType.BAIDU);
                                    } else if (this.c == 2) {
                                        hk.this.c.from(CoordinateConverter.CoordType.GPS);
                                    }
                                    hk.this.c.coord(new LatLng(remove.getLatitude(), remove.getLongitude()));
                                    LatLng convert = hk.this.c.convert();
                                    if (convert != null) {
                                        remove.setLatitude(convert.latitude);
                                        remove.setLongitude(convert.longitude);
                                    }
                                }
                                arrayList.add(remove);
                            }
                            i4 = i5 + 1;
                        }
                        int i6 = i3;
                        if (arrayList.size() >= 2) {
                            i6 = i3;
                            if (arrayList.size() <= 500) {
                                final hj hjVar = new hj(hk.this.b, hk.this.n, arrayList, this.g, this.d, i3);
                                hk.this.e.a(new lc() { // from class: com.amap.api.col.3sl.hk.a.1
                                    @Override // com.amap.api.col.p0003sl.lc
                                    public final void runTask() {
                                        hjVar.run();
                                    }
                                });
                                i6 = i3 + 1;
                                try {
                                    Thread.sleep(50L);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                        i2 = i6;
                    }
                }
                hl.a();
                hl.a(hk.this.n, this.d, LBSTraceClient.MIN_GRASP_POINT_ERROR);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.amap.api.col.3sl.hk$b */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/hk$b.class */
    public final class b implements TraceListener {
        private final List<TraceLocation> b;

        public b(List<TraceLocation> list) {
            this.b = list;
        }

        private void a(int i, List<LatLng> list) {
            try {
                synchronized (hk.this.r) {
                    hk.this.r.clear();
                    hk.this.r.addAll(list);
                }
                hk.this.q.clear();
                if (i == 0) {
                    hk.this.q.addAll(hk.this.r);
                } else {
                    hk.this.q.addAll(hk.this.p);
                    hk.this.q.addAll(hk.this.r);
                }
                hk.this.h.onTraceStatus(hk.this.j, hk.this.q, LBSTraceClient.TRACE_SUCCESS);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        @Override // com.amap.api.trace.TraceListener
        public final void onFinished(int i, List<LatLng> list, int i2, int i3) {
            a(i, list);
        }

        @Override // com.amap.api.trace.TraceListener
        public final void onRequestFailed(int i, String str) {
            ArrayList arrayList = new ArrayList();
            if (hk.this.r != null) {
                arrayList.addAll(hk.this.r);
            }
            List<TraceLocation> list = this.b;
            if (list != null) {
                int size = list.size();
                if (this.b.size() > hk.this.g) {
                    int i2 = size - hk.this.g;
                    while (true) {
                        int i3 = i2;
                        if (i3 >= size) {
                            break;
                        }
                        TraceLocation traceLocation = this.b.get(i3);
                        if (traceLocation != null) {
                            arrayList.add(new LatLng(traceLocation.getLatitude(), traceLocation.getLongitude()));
                        }
                        i2 = i3 + 1;
                    }
                }
            }
            a(i, arrayList);
        }

        @Override // com.amap.api.trace.TraceListener
        public final void onTraceProcessing(int i, int i2, List<LatLng> list) {
        }
    }

    /* renamed from: com.amap.api.col.3sl.hk$c */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/hk$c.class */
    static final class c extends Handler {
        private TraceListener a;

        public c(Looper looper) {
            super(looper);
        }

        public final void a(TraceListener traceListener) {
            this.a = traceListener;
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            Bundle data;
            try {
                if (this.a == null || (data = message.getData()) == null) {
                    return;
                }
                int i = data.getInt("lineID");
                switch (message.what) {
                    case 100:
                        this.a.onTraceProcessing(i, message.arg1, (List) message.obj);
                        return;
                    case 101:
                        this.a.onFinished(i, (List) message.obj, message.arg1, message.arg2);
                        return;
                    case 102:
                        this.a.onRequestFailed(i, (String) message.obj);
                        return;
                    default:
                        return;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public hk(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.b = applicationContext;
        this.c = new CoordinateConverter(applicationContext);
        this.n = new c(Looper.getMainLooper());
        hu.a().a(this.b);
        this.d = dv.a(this.a * 2, this.s, "AMapTraceManagerProcess");
        this.e = dv.a(this.a * 2, this.t, "AMapTraceManagerRequest");
    }

    private static double a(double d, double d2, double d3, double d4) {
        double d5 = d > d3 ? d - d3 : d3 - d;
        double d6 = d2 > d4 ? d2 - d4 : d4 - d2;
        return Math.sqrt((d5 * d5) + (d6 * d6));
    }

    private void a() {
        int size = this.j.size();
        if (size < this.g) {
            return;
        }
        if (size <= 50) {
            ArrayList arrayList = new ArrayList(this.j);
            queryProcessedTrace(0, arrayList, 1, new b(arrayList));
            return;
        }
        int i = size - 50;
        if (i < 0) {
            return;
        }
        a(new ArrayList(this.j.subList(i - this.g, i)));
        ArrayList arrayList2 = new ArrayList(this.j.subList(i, size));
        queryProcessedTrace(i, arrayList2, 1, new b(arrayList2));
    }

    private void a(List<TraceLocation> list) {
        hk hkVar = this;
        synchronized (hkVar.r) {
            try {
                if (list.size() <= 0) {
                    return;
                }
                if (hkVar.r.size() <= 0) {
                    return;
                }
                LatLng latLng = null;
                double d = 0.0d;
                TraceLocation traceLocation = null;
                double d2 = 0.0d;
                for (TraceLocation traceLocation2 : list) {
                    if (traceLocation2 != null) {
                        if (traceLocation != null) {
                            double a2 = a(traceLocation.getLatitude(), traceLocation.getLongitude(), traceLocation2.getLatitude(), traceLocation2.getLongitude());
                            if (a2 <= 100.0d) {
                                d2 += a2;
                            }
                        }
                        traceLocation = traceLocation2;
                    }
                }
                Iterator<LatLng> it = hkVar.r.iterator();
                while (it.hasNext()) {
                    LatLng next = it.next();
                    if (next == null) {
                        it.remove();
                    } else {
                        if (latLng == null) {
                            hkVar.p.add(next);
                            it.remove();
                        } else {
                            try {
                                d += a(latLng.latitude, latLng.longitude, next.latitude, next.longitude);
                                if (d >= d2) {
                                    break;
                                }
                                hkVar = this;
                                hkVar.p.add(next);
                                it.remove();
                            } catch (Throwable th) {
                                th = th;
                                throw th;
                            }
                        }
                        latLng = next;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    private static boolean a(TraceLocation traceLocation, TraceLocation traceLocation2) {
        return traceLocation != null && traceLocation.getLatitude() == traceLocation2.getLatitude() && traceLocation.getLongitude() == traceLocation2.getLongitude();
    }

    private void b() {
        av avVar = this.i;
        if (avVar != null) {
            avVar.deactivate();
            this.i = null;
        }
    }

    private void c() {
        this.s.clear();
        this.t.clear();
        List<TraceLocation> list = this.j;
        if (list != null) {
            synchronized (list) {
                if (this.j != null) {
                    this.j.clear();
                }
                this.l = 0;
                this.k = 0;
                this.m = 0L;
                this.o = null;
            }
        }
    }

    @Override // com.amap.api.trace.LBSTraceBase
    public final void destroy() {
        try {
            stopTrace();
            if (this.d != null) {
                this.d.e();
                this.d = null;
            }
            if (this.e != null) {
                this.e.e();
                this.e = null;
            }
            this.j = null;
            this.h = null;
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.b = null;
        this.c = null;
    }

    @Override // com.amap.api.maps.LocationSource.OnLocationChangedListener
    public final void onLocationChanged(Location location) {
        Bundle extras;
        if (this.h != null) {
            try {
                if (System.currentTimeMillis() - this.m >= LockPatternUtils.FAILED_ATTEMPT_TIMEOUT_MS && this.h != null) {
                    this.h.onTraceStatus(null, null, LBSTraceClient.LOCATE_TIMEOUT_ERROR);
                }
                this.m = System.currentTimeMillis();
                int i = location.getExtras().getInt(MyLocationStyle.ERROR_CODE);
                if (i != 0) {
                    Log.w("LBSTraceClient", "Locate failed [errorCode:\"" + i + "\"  errorInfo:" + extras.getString(MyLocationStyle.ERROR_INFO) + "\"]");
                    return;
                }
                synchronized (this.j) {
                    TraceLocation traceLocation = new TraceLocation(location.getLatitude(), location.getLongitude(), location.getSpeed(), location.getBearing(), location.getTime());
                    if (a(this.o, traceLocation)) {
                        return;
                    }
                    this.j.add(traceLocation);
                    this.o = traceLocation;
                    int i2 = this.k + 1;
                    this.k = i2;
                    if (i2 == this.g) {
                        this.l += i2;
                        a();
                        this.k = 0;
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // com.amap.api.trace.LBSTraceBase
    public final void queryProcessedTrace(int i, List<TraceLocation> list, int i2, TraceListener traceListener) {
        try {
            this.d.a(new a(i, list, i2, traceListener));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.trace.LBSTraceBase
    public final void setLocationInterval(long j) {
        this.f = j;
    }

    @Override // com.amap.api.trace.LBSTraceBase
    public final void setTraceStatusInterval(int i) {
        this.g = Math.max(i, 2);
    }

    @Override // com.amap.api.trace.LBSTraceBase
    public final void startTrace(TraceStatusListener traceStatusListener) {
        if (this.b == null) {
            Log.w("LBSTraceClient", "Context need to be initialized");
            return;
        }
        this.m = System.currentTimeMillis();
        this.h = traceStatusListener;
        if (this.i == null) {
            av avVar = new av(this.b);
            this.i = avVar;
            avVar.a(this.f);
            this.i.activate(this);
        }
    }

    @Override // com.amap.api.trace.LBSTraceBase
    public final void stopTrace() {
        b();
        c();
    }
}
