package c.t.m.g;

import android.content.Context;
import android.location.GnssMeasurementsEvent;
import android.location.GnssNavigationMessage;
import android.location.GnssStatus;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.huawei.hms.support.api.entity.auth.AuthCode;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.tencentmap.lbssdk.service.RegTxGposListener;
import com.tencent.tencentmap.lbssdk.service.TxGposListener;
import com.tencent.tencentmap.lbssdk.service.TxRtkSvr;
import java.io.File;
import java.util.Objects;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/h4.class */
public class h4 {

    /* renamed from: a  reason: collision with root package name */
    public w6 f3829a;
    public y6 b;

    /* renamed from: c  reason: collision with root package name */
    public String f3830c;
    public b d;
    public boolean e = false;

    /* loaded from: source-8756600-dex2jar.jar:c/t/m/g/h4$a.class */
    public class a implements v6 {
        public a(h4 h4Var) {
        }

        @Override // c.t.m.g.v6
        public void a(String str, String str2) {
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:c/t/m/g/h4$b.class */
    public class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        public final void a(Message message) {
            switch (message.what) {
                case 6001:
                    if (Build.VERSION.SDK_INT >= 26) {
                        h4.this.b.a((GnssStatus) message.obj);
                        return;
                    }
                    return;
                case 6002:
                    if (Build.VERSION.SDK_INT >= 24) {
                        h4.this.b.a((GnssNavigationMessage) message.obj);
                        return;
                    }
                    return;
                case 6003:
                    h4.this.b.a(message.arg1);
                    return;
                case 6004:
                    if (Build.VERSION.SDK_INT >= 24) {
                        h4.this.b.a((GnssMeasurementsEvent) message.obj);
                        return;
                    }
                    return;
                case 6005:
                    h4.this.b.b(message.arg1);
                    return;
                case AuthCode.StatusCode.PERMISSION_EXPIRED /* 6006 */:
                    f5 f5Var = (f5) message.obj;
                    h4.this.b.a(f5Var.b(), f5Var.a());
                    return;
                case 6007:
                    Location location = (Location) message.obj;
                    h4.this.b.a(location);
                    if (h4.this.f3829a.i && location.getProvider().equals("gps")) {
                        if (h4.this.f3829a.b) {
                            h4.this.f3829a.g = SystemClock.elapsedRealtimeNanos();
                            h4.this.f3829a.h = h4.this.f3829a.g - h4.this.f3829a.f;
                            h4.this.b.a(h4.this.f3829a.h);
                        }
                        h4.this.f3829a.i = false;
                        return;
                    }
                    return;
                case 6008:
                    e5 e5Var = (e5) message.obj;
                    if (h4.this.f3829a.b) {
                        h4.this.b.a(e5Var.b(), e5Var.c(), e5Var.a());
                        return;
                    }
                    return;
                case 6009:
                    if (h4.this.b != null) {
                        h4.this.b.a();
                    }
                    TxRtkSvr.jni_stop_txgpos();
                    return;
                default:
                    return;
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            try {
                if (h4.this.e) {
                    a(message);
                }
            } catch (Throwable th) {
            }
        }
    }

    public h4(Context context) {
        this.f3829a = null;
        this.b = null;
        if (u6.f4014a) {
            try {
                u6.a(context, new File(context.getExternalFilesDir("data").getAbsolutePath() + "/s_l"));
                u6.a(new a(this));
            } catch (Throwable th) {
            }
        }
        this.f3830c = ((File) Objects.requireNonNull(context.getExternalFilesDir("dgnss"))).getAbsolutePath();
        this.b = new y6(context);
        this.f3829a = new w6(context, this.b);
    }

    public static boolean a(Location location) {
        Bundle extras;
        String string;
        return (location == null || (extras = location.getExtras()) == null || (string = extras.getString("gnss_source")) == null || string.isEmpty() || !string.equals(TencentLocation.BEIDOU_PROVIDER)) ? false : true;
    }

    public static boolean a(q5 q5Var) {
        Bundle extra;
        String string;
        return (q5Var == null || (extra = q5Var.getExtra()) == null || (string = extra.getString("gnss_source")) == null || string.isEmpty() || !string.equals(TencentLocation.BEIDOU_PROVIDER)) ? false : true;
    }

    public void a() {
        if (this.e) {
            this.e = false;
            c3.b(this.d, 6009);
        }
    }

    public void a(int i, int i2, int i3, Object obj) {
        c3.b(this.d, i, i2, i3, obj);
    }

    public void a(TxGposListener txGposListener, Looper looper) {
        if (this.e) {
            return;
        }
        this.e = true;
        this.d = new b(looper);
        this.b.j();
        TxRtkSvr.jni_set_ntrip_mode(1);
        RegTxGposListener.registTxGposListener(txGposListener);
        b();
    }

    public final int b() {
        if (u6.f4014a) {
            TxRtkSvr.jni_settrace_path(3, this.f3830c + "/txgpos_%Y_%m_%d_%h_%M_%S.trace");
            TxRtkSvr.jni_setlogger_path(this.f3830c + "/txgpos_%Y_%m_%d_%h_%M_%S.log");
            TxRtkSvr.jni_setsol_path(this.f3830c + "/txgpos_%Y_%m_%d_%h_%M_%S.sol");
        }
        return TxRtkSvr.jni_init_txgpos();
    }
}
