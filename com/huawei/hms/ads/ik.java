package com.huawei.hms.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import java.lang.ref.WeakReference;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/ik.class */
public class ik {
    public static final float Code = -1.0f;
    private static final String I = "android.media.VOLUME_CHANGED_ACTION";
    private static final String V = "VolumeChangeObserver";
    private static final String Z = "android.media.EXTRA_VOLUME_STREAM_TYPE";
    private b B;
    private a C;
    private boolean D = false;
    private AudioManager F;
    private Context S;

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/ik$a.class */
    static class a extends BroadcastReceiver {
        private WeakReference<ik> Code;

        a(ik ikVar) {
            this.Code = new WeakReference<>(ikVar);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            ik ikVar;
            b I;
            try {
                if (!(("android.media.VOLUME_CHANGED_ACTION".equals(intent.getAction()) && intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", 0) == 3) || intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", 0) == 1) || (ikVar = this.Code.get()) == null || (I = ikVar.I()) == null) {
                    return;
                }
                I.Code();
            } catch (Throwable th) {
                ge.I(ik.V, "onReceive error:" + th.getClass().getSimpleName());
            }
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/ik$b.class */
    public interface b {
        void Code();
    }

    public ik(Context context) {
        this.S = context;
        this.F = (AudioManager) context.getApplicationContext().getSystemService("audio");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b I() {
        return this.B;
    }

    public float Code(boolean z) {
        AudioManager audioManager = this.F;
        if (audioManager != null) {
            return il.Code(audioManager, z);
        }
        return 0.0f;
    }

    public void Code() {
        if (this.C == null) {
            this.C = new a(this);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
            try {
                this.S.registerReceiver(this.C, intentFilter);
            } catch (Exception e) {
                ge.V(V, "registerReceiver, " + e.getClass().getSimpleName());
            }
            this.D = true;
        }
    }

    public void Code(b bVar) {
        this.B = bVar;
    }

    public void V() {
        if (this.D) {
            try {
                this.S.unregisterReceiver(this.C);
            } catch (Exception e) {
                ge.V(V, "unregisterReceiver, " + e.getClass().getSimpleName());
            }
            this.B = null;
            this.D = false;
        }
    }
}
