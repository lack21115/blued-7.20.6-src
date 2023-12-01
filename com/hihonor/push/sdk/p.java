package com.hihonor.push.sdk;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import com.hihonor.push.framework.aidl.IPushInvoke;
import com.hihonor.push.sdk.bean.RemoteServiceBean;
import com.hihonor.push.sdk.internal.HonorPushErrorEnum;
import com.hihonor.push.sdk.j;
import com.hihonor.push.sdk.l;

/* loaded from: source-7994992-dex2jar.jar:com/hihonor/push/sdk/p.class */
public class p implements ServiceConnection {
    public static final Object e = new Object();

    /* renamed from: a  reason: collision with root package name */
    public final RemoteServiceBean f22316a;
    public a b;

    /* renamed from: c  reason: collision with root package name */
    public Handler f22317c = null;
    public boolean d = false;

    /* loaded from: source-7994992-dex2jar.jar:com/hihonor/push/sdk/p$a.class */
    public interface a {
    }

    public p(RemoteServiceBean remoteServiceBean) {
        this.f22316a = remoteServiceBean;
    }

    public final void a() {
        synchronized (e) {
            Handler handler = this.f22317c;
            if (handler != null) {
                handler.removeMessages(1001);
                this.f22317c = null;
            }
        }
    }

    public final void a(int i) {
        a aVar = this.b;
        if (aVar != null) {
            m mVar = (m) aVar;
            mVar.f22312a.f22313a.set(i == HonorPushErrorEnum.ERROR_SERVICE_TIME_OUT.statusCode ? 2 : 1);
            mVar.f22312a.a(i);
            mVar.f22312a.b = null;
        }
    }

    public void b() {
        try {
            Log.i("AIDLSrvConnection", "trying to unbind service from ".concat(String.valueOf(this)));
            d.e.a().unbindService(this);
        } catch (Exception e2) {
            new StringBuilder("on unBind service exception:").append(e2.getMessage());
        }
    }

    public void onNullBinding(ComponentName componentName) {
        Log.i("AIDLSrvConnection", "enter onNullBinding, than unBind.");
        if (this.d) {
            this.d = false;
            return;
        }
        b();
        a();
        a aVar = this.b;
        if (aVar != null) {
            m mVar = (m) aVar;
            mVar.f22312a.f22313a.set(1);
            mVar.f22312a.a(HonorPushErrorCode.ERROR_SERVICE_NULL_BINDING);
            mVar.f22312a.b = null;
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Log.i("AIDLSrvConnection", "enter onServiceConnected.");
        a();
        a aVar = this.b;
        if (aVar != null) {
            m mVar = (m) aVar;
            mVar.f22312a.b = IPushInvoke.Stub.asInterface(iBinder);
            if (mVar.f22312a.b == null) {
                mVar.f22312a.d.b();
                mVar.f22312a.f22313a.set(1);
                mVar.f22312a.a(HonorPushErrorCode.ERROR_BIND_SERVICE);
                return;
            }
            mVar.f22312a.f22313a.set(3);
            l.a aVar2 = mVar.f22312a.f22314c;
            if (aVar2 != null) {
                j.a aVar3 = (j.a) aVar2;
                if (Looper.myLooper() == j.this.f22303a.getLooper()) {
                    aVar3.b();
                } else {
                    j.this.f22303a.post(new h(aVar3));
                }
            }
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        Log.i("AIDLSrvConnection", "enter onServiceDisconnected.");
        a aVar = this.b;
        if (aVar != null) {
            m mVar = (m) aVar;
            mVar.f22312a.f22313a.set(1);
            mVar.f22312a.a(HonorPushErrorCode.ERROR_SERVICE_DISCONNECTED);
            mVar.f22312a.b = null;
        }
    }
}
