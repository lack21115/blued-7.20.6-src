package s_a.s_a.s_a.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.anythink.core.api.ErrorCode;
import s_a.s_a.s_a.b;

/* loaded from: source-3503164-dex2jar.jar:s_a/s_a/s_a/a/g.class */
public class g {
    public volatile s_a.s_a.s_a.b a = null;
    public String b = null;
    public String c = null;
    public final Object d = new Object();
    public ServiceConnection e = new a();

    /* loaded from: source-3503164-dex2jar.jar:s_a/s_a/s_a/a/g$a.class */
    public class a implements ServiceConnection {
        public a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            f.a(ErrorCode.inNetworkErrorCodeRequestFailPacing);
            g.this.a = b.a.a(iBinder);
            synchronized (g.this.d) {
                f.a("2015");
                g.this.d.notify();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            f.a("2016");
            g.this.a = null;
        }
    }

    /* loaded from: source-3503164-dex2jar.jar:s_a/s_a/s_a/a/g$b.class */
    public static class b {
        public static final g a = new g();
    }

    public String a(Context context, String str) {
        String str2;
        try {
        } catch (RemoteException e) {
            str2 = "1005";
        }
        if (this.a == null) {
            f.a(ErrorCode.loadCappingError);
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(s_a.s_a.s_a.a.a.a("Y29tLmNvbG9yb3MubWNz"), "com.oplus.stdid.IdentifyService"));
            intent.setAction("action.com.oplus.stdid.ID_SERVICE");
            f.a(ErrorCode.c2sBiddingCacheError);
            try {
                if (context.bindService(intent, this.e, 1)) {
                    f.a(ErrorCode.networkFirmIdfilterSourceError);
                    if (this.a == null) {
                        synchronized (this.d) {
                            try {
                                if (this.a == null) {
                                    this.d.wait(10000L);
                                }
                            } catch (InterruptedException e2) {
                                Log.e("IDHelper", "1006");
                            }
                        }
                    }
                } else {
                    Log.e("IDHelper", "1007");
                }
            } catch (Exception e3) {
                StringBuilder sb = new StringBuilder();
                sb.append("1008 ");
                sb.append(e3.getMessage() != null ? e3.getMessage() : e3.getLocalizedMessage());
                Log.e("IDHelper", sb.toString());
            }
            if (this.a == null) {
                str2 = "1004";
                Log.e("IDHelper", str2);
                return "";
            }
            f.a(ErrorCode.filterSourceError);
        } else {
            f.a(ErrorCode.loadInShowingFilter);
        }
        return b(context, str);
    }

    public final String b(Context context, String str) {
        if (TextUtils.isEmpty(this.b)) {
            this.b = context.getPackageName();
        }
        if (TextUtils.isEmpty(this.c)) {
            this.c = s_a.s_a.s_a.a.a.a(context, this.b, "SHA1");
        }
        f.a("2017");
        if (this.a != null) {
            String a2 = this.a.a(this.b, this.c, str);
            f.a("2018");
            return TextUtils.isEmpty(a2) ? "" : a2;
        }
        Log.e("IDHelper", context.getPackageName() + " 1009");
        return "";
    }
}
