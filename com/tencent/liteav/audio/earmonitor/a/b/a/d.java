package com.tencent.liteav.audio.earmonitor.a.b.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.heytap.nearx.tapplugin.pluginapi.BuildConfig;
import com.tencent.liteav.audio.earmonitor.a.a.a;
import com.tencent.liteav.base.util.LiteavLog;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/audio/earmonitor/a/b/a/d.class */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    private static final List<Integer> f36234a = new ArrayList(0);
    private Context b;
    private b e;

    /* renamed from: c  reason: collision with root package name */
    private com.tencent.liteav.audio.earmonitor.a.a.a f36235c = null;
    private boolean d = false;
    private IBinder f = null;
    private ServiceConnection g = new ServiceConnection() { // from class: com.tencent.liteav.audio.earmonitor.a.b.a.d.1
        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            d.this.f36235c = a.AbstractBinderC0921a.a(iBinder);
            if (d.this.f36235c != null) {
                d.this.d = true;
                d.this.e.a(0);
                d dVar = d.this;
                d.a(dVar, dVar.b.getPackageName(), BuildConfig.VERSION_NAME);
                d.a(d.this, iBinder);
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
            d.this.f36235c = null;
            d.this.d = false;
            d.this.e.a(4);
        }
    };
    private IBinder.DeathRecipient h = new IBinder.DeathRecipient() { // from class: com.tencent.liteav.audio.earmonitor.a.b.a.d.2
        @Override // android.os.IBinder.DeathRecipient
        public final void binderDied() {
            d.this.f.unlinkToDeath(d.this.h, 0);
            d.this.e.a(6);
            LiteavLog.e("HwAudioKit.HwAudioKit", "service binder died");
            d.f(d.this);
        }
    };

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/audio/earmonitor/a/b/a/d$a.class */
    public enum a {
        HWAUDIO_FEATURE_KARAOKE;
        
        int mFeatureType = 1;

        /* JADX WARN: Incorrect types in method signature: (I)V */
        a(String str) {
        }
    }

    public d(Context context, e eVar) {
        this.b = null;
        b a2 = b.a();
        this.e = a2;
        a2.f36227a = eVar;
        this.b = context;
    }

    static /* synthetic */ void a(d dVar, IBinder iBinder) {
        dVar.f = iBinder;
        if (iBinder != null) {
            try {
                iBinder.linkToDeath(dVar.h, 0);
            } catch (RemoteException e) {
                dVar.e.a(5);
                LiteavLog.e("HwAudioKit.HwAudioKit", "serviceLinkToDeath, RemoteException");
            }
        }
    }

    static /* synthetic */ void a(d dVar, String str, String str2) {
        try {
            if (dVar.f36235c == null || !dVar.d) {
                return;
            }
            dVar.f36235c.a(str, str2);
        } catch (RemoteException e) {
            LiteavLog.e("HwAudioKit.HwAudioKit", "isFeatureSupported,RemoteException ex : %s", e.getMessage());
        }
    }

    static /* synthetic */ IBinder f(d dVar) {
        dVar.f = null;
        return null;
    }

    public final void a() {
        Context context = this.b;
        if (context == null) {
            this.e.a(7);
        } else if (!b.a(context)) {
            this.e.a(2);
        } else {
            Context context2 = this.b;
            if (this.e == null || this.d) {
                return;
            }
            b.a(context2, this.g, "com.huawei.multimedia.audioengine.HwAudioEngineService");
        }
    }

    public final boolean a(a aVar) {
        if (aVar == null) {
            return false;
        }
        try {
            if (this.f36235c == null || !this.d) {
                return false;
            }
            return this.f36235c.a(aVar.mFeatureType);
        } catch (RemoteException e) {
            LiteavLog.e("HwAudioKit.HwAudioKit", "isFeatureSupported,RemoteException ex : %s", e.getMessage());
            return false;
        }
    }

    public final <T extends com.tencent.liteav.audio.earmonitor.a.b.a.a> T b(a aVar) {
        if (this.e == null || aVar == null) {
            return null;
        }
        return (T) b.a(aVar.mFeatureType, this.b);
    }

    public final void b() {
        if (this.d) {
            this.d = false;
            b.a(this.b, this.g);
        }
    }
}
