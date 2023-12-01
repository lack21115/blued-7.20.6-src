package com.amap.api.col.p0003sl;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.maps.model.LatLng;
import com.amap.api.trace.LBSTraceClient;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.amap.api.col.3sl.hl  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/hl.class */
public class hl {
    private static volatile hl b;
    private Map<String, a> a;

    /* renamed from: com.amap.api.col.3sl.hl$a */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/hl$a.class */
    final class a {
        private int b;
        private int c;
        private int e;
        private HashMap<Integer, List<LatLng>> g;
        private int d = 0;
        private int f = 0;
        private List<LatLng> h = new ArrayList();

        public a(int i, int i2, int i3, HashMap<Integer, List<LatLng>> hashMap) {
            this.b = 0;
            this.c = 0;
            this.e = 0;
            this.b = i2;
            this.g = hashMap;
            this.c = i;
            this.e = i3;
        }

        private void a(Handler handler, List<LatLng> list) {
            Message obtainMessage = handler.obtainMessage();
            obtainMessage.obj = list;
            obtainMessage.what = 100;
            obtainMessage.arg1 = this.d;
            Bundle bundle = new Bundle();
            bundle.putInt("lineID", this.c);
            obtainMessage.setData(bundle);
            handler.sendMessage(obtainMessage);
            this.d++;
            this.f++;
        }

        private void b(Handler handler) {
            if (this.f <= 0) {
                hl.a(handler, this.c, LBSTraceClient.MIN_GRASP_POINT_ERROR);
                return;
            }
            int a = hi.a(this.h);
            Message obtainMessage = handler.obtainMessage();
            obtainMessage.obj = this.h;
            obtainMessage.what = 101;
            obtainMessage.arg1 = a;
            obtainMessage.arg2 = this.e;
            Bundle bundle = new Bundle();
            bundle.putInt("lineID", this.c);
            obtainMessage.setData(bundle);
            handler.sendMessage(obtainMessage);
        }

        public final HashMap<Integer, List<LatLng>> a() {
            return this.g;
        }

        public final void a(Handler handler) {
            List<LatLng> list;
            int i = this.d;
            while (true) {
                int i2 = i;
                if (i2 > this.b || (list = this.g.get(Integer.valueOf(i2))) == null) {
                    break;
                }
                this.h.addAll(list);
                a(handler, list);
                i = i2 + 1;
            }
            if (this.d == this.b + 1) {
                b(handler);
            }
        }
    }

    public hl() {
        this.a = null;
        this.a = Collections.synchronizedMap(new HashMap());
    }

    public static hl a() {
        if (b == null) {
            synchronized (hl.class) {
                try {
                    if (b == null) {
                        b = new hl();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return b;
    }

    public static void a(Handler handler, int i, String str) {
        Message obtainMessage = handler.obtainMessage();
        obtainMessage.obj = str;
        obtainMessage.what = 102;
        Bundle bundle = new Bundle();
        bundle.putInt("lineID", i);
        obtainMessage.setData(bundle);
        handler.sendMessage(obtainMessage);
    }

    public final a a(String str) {
        synchronized (this) {
            if (this.a != null) {
                return this.a.get(str);
            }
            return null;
        }
    }

    public final void a(String str, int i, int i2, int i3) {
        synchronized (this) {
            if (this.a != null) {
                this.a.put(str, new a(i, i2, i3, new HashMap(16)));
            }
        }
    }

    public final void a(String str, int i, List<LatLng> list) {
        synchronized (this) {
            if (this.a != null) {
                this.a.get(str).a().put(Integer.valueOf(i), list);
            }
        }
    }
}
