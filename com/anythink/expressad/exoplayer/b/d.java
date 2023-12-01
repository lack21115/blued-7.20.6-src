package com.anythink.expressad.exoplayer.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import com.anythink.expressad.exoplayer.k.af;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/b/d.class */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    c f4339a;
    private final Context b;

    /* renamed from: c  reason: collision with root package name */
    private final b f4340c;
    private final BroadcastReceiver d;

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/b/d$a.class */
    final class a extends BroadcastReceiver {
        private a() {
        }

        /* synthetic */ a(d dVar, byte b) {
            this();
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            if (isInitialStickyBroadcast()) {
                return;
            }
            c a2 = c.a(intent);
            if (a2.equals(d.this.f4339a)) {
                return;
            }
            d.this.f4339a = a2;
            b unused = d.this.f4340c;
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/b/d$b.class */
    public interface b {
        void a();
    }

    private d(Context context, b bVar) {
        this.b = (Context) com.anythink.expressad.exoplayer.k.a.a(context);
        this.f4340c = (b) com.anythink.expressad.exoplayer.k.a.a(bVar);
        this.d = af.f4793a >= 21 ? new a(this, (byte) 0) : null;
    }

    private c a() {
        BroadcastReceiver broadcastReceiver = this.d;
        c a2 = c.a(broadcastReceiver == null ? null : this.b.registerReceiver(broadcastReceiver, new IntentFilter(AudioManager.ACTION_HDMI_AUDIO_PLUG)));
        this.f4339a = a2;
        return a2;
    }

    private void b() {
        BroadcastReceiver broadcastReceiver = this.d;
        if (broadcastReceiver != null) {
            this.b.unregisterReceiver(broadcastReceiver);
        }
    }
}
