package c.t.m.g;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.mobads.sdk.internal.bw;
import com.tencent.map.geolocation.TencentLocationListener;
import com.tencent.map.geolocation.TencentLocationManager;
import com.tencent.map.geolocation.TencentLocationRequest;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/g4.class */
public class g4 {
    public static g4 e;

    /* renamed from: a  reason: collision with root package name */
    public t3 f3819a;
    public TencentLocationListener b;
    public long d = 0;

    /* renamed from: c  reason: collision with root package name */
    public b f3820c = new b();

    /* loaded from: source-8756600-dex2jar.jar:c/t/m/g/g4$b.class */
    public class b extends Handler {
        public b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            l6 l6Var;
            int i;
            String str;
            if (message.what == 1 && (l6Var = (l6) k6.a(g4.this.f3819a).a()) != null) {
                if (l6Var == l6.k) {
                    str = "ERROR_NETWORK";
                    i = 1;
                } else {
                    i = 0;
                    str = bw.k;
                }
                if ((l6Var.getProvider() != null && !"network".equals(l6Var.getProvider())) || System.currentTimeMillis() - g4.this.d > 5000) {
                    g4.this.b.onLocationChanged(l6Var, i, str);
                }
                g4.this.f3820c.sendEmptyMessageDelayed(1, 1000L);
            }
        }
    }

    public g4(t3 t3Var) {
        this.f3819a = t3Var;
    }

    public static g4 a(t3 t3Var) {
        if (e == null) {
            synchronized (g4.class) {
                try {
                    if (e == null) {
                        e = new g4(t3Var);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return e;
    }

    public int a(int i, TencentLocationListener tencentLocationListener) {
        int i2;
        if (i == 10) {
            TencentLocationRequest create = TencentLocationRequest.create();
            create.setLocMode(10).setAllowGPS(true).setGpsFirst(true).setGpsFirstTimeOut(3000).setRequestLevel(3);
            return TencentLocationManager.getInstance(this.f3819a.f3992a).requestSingleFreshLocation(create, tencentLocationListener, Looper.getMainLooper());
        } else if (i == 12) {
            TencentLocationRequest create2 = TencentLocationRequest.create();
            create2.setLocMode(10).setAllowGPS(true).setLocMode(12).setInterval(1000L);
            return TencentLocationManager.getInstance(this.f3819a.f3992a).requestLocationUpdates(create2, tencentLocationListener, Looper.getMainLooper());
        } else {
            if (i != 11) {
                i2 = 0;
            } else if (!k6.a(this.f3819a).b()) {
                return -1;
            } else {
                this.b = tencentLocationListener;
                int a2 = k6.a(this.f3819a).a(TencentLocationManager.DR_TYPE_WALK);
                i2 = a2;
                if (a2 == 0) {
                    if (this.d == 0) {
                        this.d = System.currentTimeMillis();
                    }
                    this.f3820c.sendEmptyMessageDelayed(1, 1000L);
                    return a2;
                }
            }
            return i2;
        }
    }

    public void b(int i, TencentLocationListener tencentLocationListener) {
        if (i == 12) {
            TencentLocationManager.getInstance(this.f3819a.f3992a).removeUpdates(tencentLocationListener);
        } else if (i == 11) {
            k6.a(this.f3819a).d();
            this.f3820c.removeCallbacksAndMessages(null);
            this.d = 0L;
        }
    }
}
