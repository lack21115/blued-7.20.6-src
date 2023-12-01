package com.tencent.liteav.audio.earmonitor.a.b.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.tencent.liteav.audio.earmonitor.a.a.b;
import com.tencent.liteav.base.util.LiteavLog;
import com.zego.ve.HwAudioKit;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/audio/earmonitor/a/b/a/c.class */
public final class c extends com.tencent.liteav.audio.earmonitor.a.b.a.a {

    /* renamed from: a  reason: collision with root package name */
    Context f22537a;
    b b;
    com.tencent.liteav.audio.earmonitor.a.a.b d;

    /* renamed from: c  reason: collision with root package name */
    boolean f22538c = false;
    IBinder e = null;
    private ServiceConnection g = new ServiceConnection() { // from class: com.tencent.liteav.audio.earmonitor.a.b.a.c.1
        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            c.this.d = b.a.a(iBinder);
            if (c.this.d != null) {
                c.this.f22538c = true;
                c.this.b.a(1000);
                c cVar = c.this;
                String packageName = cVar.f22537a.getPackageName();
                try {
                    if (cVar.d != null && cVar.f22538c) {
                        cVar.d.a(packageName);
                    }
                } catch (RemoteException e) {
                    LiteavLog.e("HwAudioKit.HwAudioKaraokeFeatureKit", "isFeatureSupported,RemoteException ex : %s", e.getMessage());
                }
                c.a(c.this, iBinder);
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
            c.this.f22538c = false;
            if (c.this.b != null) {
                c.this.b.a(1001);
            }
        }
    };
    IBinder.DeathRecipient f = new IBinder.DeathRecipient() { // from class: com.tencent.liteav.audio.earmonitor.a.b.a.c.2
        @Override // android.os.IBinder.DeathRecipient
        public final void binderDied() {
            LiteavLog.e("HwAudioKit.HwAudioKaraokeFeatureKit", "binderDied");
            c.this.e.unlinkToDeath(c.this.f, 0);
            c.this.b.a(1003);
            c.this.e = null;
        }
    };

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/audio/earmonitor/a/b/a/c$a.class */
    public enum a {
        CMD_SET_AUDIO_EFFECT_MODE_BASE("Karaoke_reverb_mode="),
        CMD_SET_VOCAL_VOLUME_BASE("Karaoke_volume="),
        CMD_SET_VOCAL_EQUALIZER_MODE("Karaoke_eq_mode=");
        
        String mParameName;

        a(String str) {
            this.mParameName = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public c(Context context) {
        this.b = null;
        this.b = b.a();
        this.f22537a = context;
    }

    static /* synthetic */ void a(c cVar, IBinder iBinder) {
        cVar.e = iBinder;
        if (iBinder != null) {
            try {
                iBinder.linkToDeath(cVar.f, 0);
            } catch (RemoteException e) {
                cVar.b.a(1002);
                LiteavLog.e("HwAudioKit.HwAudioKaraokeFeatureKit", "serviceLinkToDeath, RemoteException");
            }
        }
    }

    public final int a(a aVar, int i) {
        if (aVar == null) {
            return HwAudioKit.PARAME_VALUE_ERROR;
        }
        try {
            if (this.d == null || !this.f22538c) {
                return -2;
            }
            return this.d.a(aVar.mParameName, i);
        } catch (RemoteException e) {
            LiteavLog.e("HwAudioKit.HwAudioKaraokeFeatureKit", "setParameter,RemoteException ex : %s", e.getMessage());
            return -2;
        }
    }

    public final int a(boolean z) {
        try {
            if (this.d == null || !this.f22538c) {
                return -2;
            }
            return this.d.a(z);
        } catch (RemoteException e) {
            LiteavLog.e("HwAudioKit.HwAudioKaraokeFeatureKit", "enableKaraokeFeature,RemoteException ex : %s", e.getMessage());
            return -2;
        }
    }

    public final void a() {
        if (this.f22538c) {
            this.f22538c = false;
            b.a(this.f22537a, this.g);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(Context context) {
        if (context == null) {
            return;
        }
        if (!b.a(context)) {
            this.b.a(2);
        } else if (this.b == null || this.f22538c) {
        } else {
            b.a(context, this.g, "com.huawei.multimedia.audioengine.HwAudioKaraokeFeatureService");
        }
    }
}
