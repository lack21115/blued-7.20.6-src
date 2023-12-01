package com.ss.android.downloadlib.mb.ox;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.ss.android.downloadlib.addownload.x;
import com.ss.android.downloadlib.mb.ox.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/mb/ox/mb.class */
public class mb {
    private static String h = "";
    private static String hj = "";
    private static volatile mb ko;
    private static String u = "";
    private Context jb;
    public b mb;
    private boolean ww = true;
    private boolean lz = false;
    private volatile boolean x = false;
    private final List<Pair<ox, hj>> je = new ArrayList();
    public final List<InterfaceC0706mb> ox = new ArrayList();
    private final ServiceConnection nk = new ServiceConnection() { // from class: com.ss.android.downloadlib.mb.ox.mb.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            synchronized (mb.this.b) {
                mb.this.mb(false);
                mb.this.mb = b.mb.mb(iBinder);
                mb.this.b();
                for (InterfaceC0706mb interfaceC0706mb : mb.this.ox) {
                    interfaceC0706mb.mb();
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            synchronized (mb.this.b) {
                mb.this.mb(false);
                mb.this.mb = null;
                for (InterfaceC0706mb interfaceC0706mb : mb.this.ox) {
                    interfaceC0706mb.ox();
                }
            }
        }
    };
    private String o = "";
    public final Object b = new Object();

    /* renamed from: com.ss.android.downloadlib.mb.ox.mb$mb  reason: collision with other inner class name */
    /* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/mb/ox/mb$mb.class */
    public interface InterfaceC0706mb {
        void mb();

        void ox();
    }

    private mb() {
    }

    public static mb mb() {
        if (ko == null) {
            synchronized (mb.class) {
                try {
                    if (ko == null) {
                        ko = new mb();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return ko;
    }

    public void b() {
        for (Pair<ox, hj> pair : this.je) {
            try {
                this.mb.mb(pair.first, pair.second);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        this.je.clear();
    }

    public boolean hj() {
        return this.x;
    }

    public Intent mb(Context context) {
        Intent intent = new Intent();
        intent.setAction(hj);
        List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
        Intent intent2 = null;
        if (queryIntentServices != null) {
            if (queryIntentServices.size() == 1) {
                Iterator<ResolveInfo> it = queryIntentServices.iterator();
                while (true) {
                    intent2 = null;
                    if (!it.hasNext()) {
                        break;
                    }
                    ResolveInfo next = it.next();
                    String str = next.serviceInfo.packageName;
                    String str2 = next.serviceInfo.name;
                    if (h.equals(str)) {
                        ComponentName componentName = new ComponentName(str, str2);
                        intent2 = new Intent(intent);
                        intent2.setComponent(componentName);
                        break;
                    }
                }
            } else {
                return null;
            }
        }
        return intent2;
    }

    public void mb(ox oxVar, hj hjVar) {
        synchronized (this.b) {
            oxVar.h = u;
            if (TextUtils.isEmpty(oxVar.u)) {
                oxVar.u = this.o;
            }
            if (this.mb != null) {
                try {
                    this.mb.mb(oxVar, hjVar);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            } else if (hj() || mb(this.jb, this.lz)) {
                this.je.add(Pair.create(oxVar, hjVar));
            }
        }
    }

    public void mb(boolean z) {
        this.x = z;
    }

    public boolean mb(Context context, boolean z) {
        if (TextUtils.isEmpty(hj)) {
            JSONObject lz = x.lz();
            String optString = lz.optString("s");
            hj = com.ss.android.socialbase.appdownloader.u.b.mb(lz.optString("q"), optString);
            h = com.ss.android.socialbase.appdownloader.u.b.mb(lz.optString("u"), optString);
            u = com.ss.android.socialbase.appdownloader.u.b.mb(lz.optString(IAdInterListener.AdReqParam.WIDTH), optString);
        }
        this.lz = z;
        if (context != null) {
            this.jb = context.getApplicationContext();
            if (TextUtils.isEmpty(u)) {
                u = this.jb.getPackageName();
            }
            if (this.mb != null || hj()) {
                return true;
            }
            return this.jb.bindService(mb(context), this.nk, 33);
        }
        return true;
    }

    public void ox() {
        if (this.mb != null) {
            this.jb.unbindService(this.nk);
            this.mb = null;
        }
        this.ox.clear();
        this.je.clear();
    }
}
