package cn.com.chinatelecom.account.api.c;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Handler;
import android.os.Looper;
import cn.com.chinatelecom.account.api.CtAuth;
import java.net.InetAddress;

/* loaded from: source-8756600-dex2jar.jar:cn/com/chinatelecom/account/api/c/c.class */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static final String f4061a = c.class.getSimpleName();
    private static Handler b = new Handler(Looper.getMainLooper());

    /* renamed from: c  reason: collision with root package name */
    private boolean f4062c;
    private Context d;
    private ConnectivityManager.NetworkCallback e;

    public c(Context context) {
        this.d = context;
    }

    public static int a(String str) {
        try {
            byte[] address = InetAddress.getByName(str).getAddress();
            return (address[0] & 255) | ((address[3] & 255) << 24) | ((address[2] & 255) << 16) | ((address[1] & 255) << 8);
        } catch (Throwable th) {
            CtAuth.warn(f4061a, "When InetAddress.getByName(),throws exception", th);
            return -1;
        }
    }

    public static String b(String str) {
        int indexOf = str.indexOf("://");
        String str2 = str;
        if (indexOf > 0) {
            str2 = str.substring(indexOf + 3);
        }
        int indexOf2 = str2.indexOf(58);
        String str3 = str2;
        if (indexOf2 >= 0) {
            str3 = str2.substring(0, indexOf2);
        }
        int indexOf3 = str3.indexOf(47);
        String str4 = str3;
        if (indexOf3 >= 0) {
            str4 = str3.substring(0, indexOf3);
        }
        int indexOf4 = str4.indexOf(63);
        String str5 = str4;
        if (indexOf4 >= 0) {
            str5 = str4.substring(0, indexOf4);
        }
        return str5;
    }

    private void b(final b bVar) {
        b.postDelayed(new Runnable() { // from class: cn.com.chinatelecom.account.api.c.c.1
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.d() || bVar == null) {
                    return;
                }
                c.this.c();
                bVar.a();
            }
        }, 2500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int c(String str) {
        try {
            Class<?> cls = Class.forName("android.net.ConnectivityManager");
            ConnectivityManager connectivityManager = (ConnectivityManager) this.d.getSystemService(Context.CONNECTIVITY_SERVICE);
            if (connectivityManager.getNetworkInfo(5).getState().compareTo(NetworkInfo.State.CONNECTED) != 0) {
                cls.getMethod("startUsingNetworkFeature", Integer.TYPE, String.class).invoke(connectivityManager, 0, "enableHIPRI");
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= 5 || connectivityManager.getNetworkInfo(5).getState().compareTo(NetworkInfo.State.CONNECTED) == 0) {
                        break;
                    }
                    Thread.sleep(500L);
                    i = i2 + 1;
                }
            }
            boolean booleanValue = ((Boolean) cls.getMethod("requestRouteToHost", Integer.TYPE, Integer.TYPE).invoke(connectivityManager, 5, Integer.valueOf(a(b(str))))).booleanValue();
            String str2 = f4061a;
            CtAuth.info(str2, "STMN_V4 ：" + booleanValue);
            return booleanValue ? 0 : -2;
        } catch (Throwable th) {
            CtAuth.warn(f4061a, "STMN_V4_T", th);
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        synchronized (this) {
            this.f4062c = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d() {
        boolean z;
        synchronized (this) {
            z = this.f4062c;
        }
        return z;
    }

    public void a() {
        try {
            if (this.e != null) {
                ((ConnectivityManager) this.d.getSystemService(Context.CONNECTIVITY_SERVICE)).unregisterNetworkCallback(this.e);
                this.e = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void a(final b bVar) {
        final long currentTimeMillis = System.currentTimeMillis();
        try {
            b(bVar);
            ConnectivityManager connectivityManager = (ConnectivityManager) this.d.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkRequest.Builder builder = new NetworkRequest.Builder();
            builder.addCapability(12);
            builder.addTransportType(0);
            NetworkRequest build = builder.build();
            ConnectivityManager.NetworkCallback networkCallback = new ConnectivityManager.NetworkCallback() { // from class: cn.com.chinatelecom.account.api.c.c.2
                @Override // android.net.ConnectivityManager.NetworkCallback
                public void onAvailable(Network network) {
                    if (c.this.d() || bVar == null) {
                        return;
                    }
                    c.this.c();
                    bVar.a(network, System.currentTimeMillis() - currentTimeMillis);
                }
            };
            this.e = networkCallback;
            connectivityManager.requestNetwork(build, networkCallback);
        } catch (Throwable th) {
            if (d() || bVar == null) {
                return;
            }
            bVar.a(System.currentTimeMillis() - currentTimeMillis);
        }
    }

    public void a(final b bVar, final String str) {
        new d().a(new e() { // from class: cn.com.chinatelecom.account.api.c.c.3
            @Override // cn.com.chinatelecom.account.api.c.e
            public void a() {
                final long currentTimeMillis = System.currentTimeMillis();
                int c2 = c.this.c(str);
                if (c2 == 0) {
                    bVar.a(null, System.currentTimeMillis() - currentTimeMillis);
                } else if (c2 == -1) {
                    c.b.post(new Runnable() { // from class: cn.com.chinatelecom.account.api.c.c.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            bVar.a(System.currentTimeMillis() - currentTimeMillis);
                        }
                    });
                } else {
                    c.b.post(new Runnable() { // from class: cn.com.chinatelecom.account.api.c.c.3.2
                        @Override // java.lang.Runnable
                        public void run() {
                            bVar.a();
                        }
                    });
                }
            }
        });
    }
}
