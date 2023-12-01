package im.zego.connection;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/* loaded from: source-8829756-dex2jar.jar:im/zego/connection/NetworkStateChangeReceiver28020.class */
public class NetworkStateChangeReceiver28020 extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private long f42237a;
    private Context b;

    private int a(NetworkInfo networkInfo) {
        int type = networkInfo.getType();
        if (type != 0) {
            if (type != 1) {
                return type != 9 ? 32 : 1;
            }
            return 2;
        }
        switch (networkInfo.getSubtype()) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
            case 16:
                return 3;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
            case 17:
                return 4;
            case 13:
            case 18:
                return 5;
            case 19:
            default:
                return 32;
            case 20:
                return 6;
        }
    }

    static native void onNetTypeChanged(long j, int i, String str);

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        int i;
        String str;
        synchronized (this) {
            if (this.b == null) {
                return;
            }
            ConnectivityManager connectivityManager = (ConnectivityManager) this.b.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = null;
            if (connectivityManager != null) {
                networkInfo = connectivityManager.getActiveNetworkInfo();
            }
            if (networkInfo == null) {
                i = 0;
                str = "";
            } else {
                String networkInfo2 = networkInfo.toString();
                i = a(networkInfo);
                str = networkInfo2;
            }
            onNetTypeChanged(this.f42237a, i, str);
        }
    }
}
