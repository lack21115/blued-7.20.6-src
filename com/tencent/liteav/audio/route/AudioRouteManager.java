package com.tencent.liteav.audio.route;

import android.content.Context;
import android.media.AudioManager;
import android.os.HandlerThread;
import com.tencent.liteav.audio.route.b;
import com.tencent.liteav.audio.route.m;
import com.tencent.liteav.audio.route.n;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.Log;
import com.tencent.liteav.base.annotations.JNINamespace;

@JNINamespace("liteav::audio")
/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/audio/route/AudioRouteManager.class */
public class AudioRouteManager extends n.a {
    private static final int BLUETOOTH_SCO_RECONNECT_INTERVAL = 1000;
    private static final long IN_CALL_DETECTION_TIME = 500;
    private static final String TAG = "AudioRouteManager";
    private final AudioManager mAudioManager;
    private final l mAudioRouteSupervisor;
    private final n mBroadcastReceiver;
    private final long mNativeAudioRouteManager;
    private com.tencent.liteav.base.util.b mHandler = null;
    private boolean mIsServiceStarted = false;
    private a mCurrentAudioIOScene = a.STOPPED;
    private a mExpectedAudioIOScene = a.STOPPED;
    private b.a mCurrentRouteType = b.a.NONE;
    private m.a mSwitcher = null;
    private String mCurrentRouteConfig = "";
    private final Runnable mForceUpdateRouteRunnable = c.a(this);
    private m.a.InterfaceC0924a mSwitcherListener = new m.a.InterfaceC0924a() { // from class: com.tencent.liteav.audio.route.AudioRouteManager.1
        @Override // com.tencent.liteav.audio.route.m.a.InterfaceC0924a
        public final void a(b.a aVar) {
            AudioRouteManager.nativeNotifyAudioRouteChangedFromJava(AudioRouteManager.this.mNativeAudioRouteManager, aVar.ordinal());
        }

        @Override // com.tencent.liteav.audio.route.m.a.InterfaceC0924a
        public final void b(b.a aVar) {
            if (aVar != b.a.BLUETOOTH_HEADSET) {
                Log.w(AudioRouteManager.TAG, "switch to %s failed, do nothing", aVar);
                return;
            }
            Log.w(AudioRouteManager.TAG, "switch to bluetooth failed, set it unavailable and update route again", new Object[0]);
            AudioRouteManager.this.mAudioRouteSupervisor.a(b.a.BLUETOOTH_HEADSET, false);
            AudioRouteManager.this.autoCheckRouteUpdate(false);
        }
    };

    public AudioRouteManager(long j) {
        this.mNativeAudioRouteManager = j;
        Context applicationContext = ContextUtils.getApplicationContext();
        this.mAudioRouteSupervisor = new l();
        this.mAudioManager = (AudioManager) applicationContext.getSystemService("audio");
        this.mBroadcastReceiver = new n(applicationContext, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0125  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void autoCheckRouteUpdate(boolean r7) {
        /*
            Method dump skipped, instructions count: 331
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.audio.route.AudioRouteManager.autoCheckRouteUpdate(boolean):void");
    }

    private void destroySwitcher() {
        m.a aVar = this.mSwitcher;
        if (aVar == null) {
            return;
        }
        aVar.b();
        this.mSwitcher = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleBluetoothHeadsetChangedInternal(boolean z) {
        if (!this.mIsServiceStarted) {
            Log.i(TAG, "ignore bluetooth headset changing, AudioRouteManager is not started", new Object[0]);
        } else if (this.mAudioRouteSupervisor.a(b.a.BLUETOOTH_HEADSET, z)) {
            autoCheckRouteUpdate(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleBluetoothSCOChangedInternal(boolean z) {
        m.a aVar = this.mSwitcher;
        if (aVar != null) {
            aVar.a(z);
        }
        removeCallbacksOnWorkThread(this.mForceUpdateRouteRunnable);
        if (z || !this.mIsServiceStarted || this.mCurrentAudioIOScene == a.STOPPED) {
            return;
        }
        runOnWorkThread(this.mForceUpdateRouteRunnable, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleWiredHeadsetChangedInternal(boolean z) {
        if (!this.mIsServiceStarted) {
            Log.i(TAG, "ignore wired headset changing, AudioRouteManager is not started", new Object[0]);
        } else if (this.mAudioRouteSupervisor.a(b.a.WIRED_HEADSET, z)) {
            autoCheckRouteUpdate(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$notifyAudioIOSceneChanged$2(AudioRouteManager audioRouteManager, int i) {
        audioRouteManager.mExpectedAudioIOScene = a.a(i);
        audioRouteManager.notifyAudioIOSceneChangedInternal();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeNotifyAudioRouteChangedFromJava(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyAudioIOSceneChangedInternal() {
        a aVar = this.mCurrentAudioIOScene;
        a aVar2 = this.mExpectedAudioIOScene;
        if (aVar == aVar2) {
            return;
        }
        Log.i(TAG, "notify audio io scene changed, %s -> %s", aVar, aVar2);
        if (this.mAudioManager.getMode() == 2) {
            runOnWorkThread(e.a(this), 500L);
            return;
        }
        int a2 = a.a(this.mExpectedAudioIOScene);
        Log.i(TAG, "setMode to ".concat(String.valueOf(a2)), new Object[0]);
        try {
            this.mAudioManager.setMode(a2);
        } catch (Exception e) {
            Log.w(TAG, "AudioManager setMode failed, ignore it", new Object[0]);
        }
        a aVar3 = this.mExpectedAudioIOScene;
        this.mCurrentAudioIOScene = aVar3;
        m.a aVar4 = this.mSwitcher;
        if (aVar4 != null) {
            aVar4.a(aVar3);
        } else {
            autoCheckRouteUpdate(false);
        }
    }

    private void removeCallbacksOnWorkThread(Runnable runnable) {
        com.tencent.liteav.base.util.b bVar = this.mHandler;
        if (bVar != null) {
            bVar.removeCallbacks(runnable);
        }
    }

    private void runOnWorkThread(Runnable runnable) {
        com.tencent.liteav.base.util.b bVar = this.mHandler;
        if (bVar != null) {
            bVar.post(runnable);
        }
    }

    private void runOnWorkThread(Runnable runnable, long j) {
        com.tencent.liteav.base.util.b bVar = this.mHandler;
        if (bVar != null) {
            bVar.postDelayed(runnable, j);
        }
    }

    private void runOnWorkThreadAndWaitDone(Runnable runnable, long j) {
        com.tencent.liteav.base.util.b bVar = this.mHandler;
        if (bVar != null) {
            bVar.a(runnable, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setHandFreeModeEnabledInternal(boolean r5) {
        /*
            r4 = this;
            r0 = r4
            boolean r0 = r0.mIsServiceStarted
            if (r0 != 0) goto L14
            java.lang.String r0 = "AudioRouteManager"
            java.lang.String r1 = "set handfree mode failed, AudioRouteManager is not started"
            r2 = 0
            java.lang.Object[] r2 = new java.lang.Object[r2]
            com.tencent.liteav.base.Log.w(r0, r1, r2)
            return
        L14:
            r0 = r4
            com.tencent.liteav.audio.route.l r0 = r0.mAudioRouteSupervisor
            r10 = r0
            r0 = r10
            boolean r0 = r0.f36265c
            if (r0 != 0) goto L33
            java.lang.String r0 = "AudioRouteSupervisor"
            java.lang.String r1 = "error in setHandFreeModeEnabled(), it's not been initialized yet"
            r2 = 0
            java.lang.Object[] r2 = new java.lang.Object[r2]
            com.tencent.liteav.base.Log.e(r0, r1, r2)
        L2e:
            r0 = 0
            r6 = r0
            goto Lb3
        L33:
            r0 = r10
            java.util.HashMap<com.tencent.liteav.audio.route.b$a, com.tencent.liteav.audio.route.b> r0 = r0.b
            com.tencent.liteav.audio.route.b$a r1 = com.tencent.liteav.audio.route.b.a.SPEAKERPHONE
            java.lang.Object r0 = r0.get(r1)
            com.tencent.liteav.audio.route.b r0 = (com.tencent.liteav.audio.route.b) r0
            r9 = r0
            r0 = r10
            java.util.HashMap<com.tencent.liteav.audio.route.b$a, com.tencent.liteav.audio.route.b> r0 = r0.b
            com.tencent.liteav.audio.route.b$a r1 = com.tencent.liteav.audio.route.b.a.EARPHONE
            java.lang.Object r0 = r0.get(r1)
            com.tencent.liteav.audio.route.b r0 = (com.tencent.liteav.audio.route.b) r0
            r10 = r0
            r0 = r9
            if (r0 == 0) goto La4
            r0 = r10
            if (r0 != 0) goto L60
            goto La4
        L60:
            r0 = r9
            int r0 = r0.f36252c
            r1 = r10
            int r1 = r1.f36252c
            int r0 = java.lang.Math.min(r0, r1)
            r6 = r0
            r0 = r9
            int r0 = r0.f36252c
            r1 = r10
            int r1 = r1.f36252c
            int r0 = java.lang.Math.max(r0, r1)
            r7 = r0
            r0 = r5
            if (r0 == 0) goto L86
            r0 = r7
            r8 = r0
            goto L89
        L86:
            r0 = r6
            r8 = r0
        L89:
            r0 = r9
            r1 = r8
            r0.f36252c = r1
            r0 = r5
            if (r0 == 0) goto L97
            goto L99
        L97:
            r0 = r7
            r6 = r0
        L99:
            r0 = r10
            r1 = r6
            r0.f36252c = r1
            r0 = 1
            r6 = r0
            goto Lb3
        La4:
            java.lang.String r0 = "AudioRouteSupervisor"
            java.lang.String r1 = "setHandFreeModeEnabled failed, speakerphone or earphone not existed"
            r2 = 0
            java.lang.Object[] r2 = new java.lang.Object[r2]
            com.tencent.liteav.base.Log.e(r0, r1, r2)
            goto L2e
        Lb3:
            r0 = r6
            if (r0 == 0) goto Lbc
            r0 = r4
            r1 = 0
            r0.autoCheckRouteUpdate(r1)
        Lbc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.audio.route.AudioRouteManager.setHandFreeModeEnabledInternal(boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0134 A[LOOP:0: B:24:0x008e->B:44:0x0134, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x003d A[EDGE_INSN: B:55:0x003d->B:11:0x003d ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void startInternal(java.lang.String r8) {
        /*
            Method dump skipped, instructions count: 440
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.audio.route.AudioRouteManager.startInternal(java.lang.String):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopInternal() {
        Log.i(TAG, "stopInternal", new Object[0]);
        if (!this.mIsServiceStarted) {
            Log.e(TAG, "AudioRouteManager is not started", new Object[0]);
            return;
        }
        destroySwitcher();
        try {
            this.mAudioManager.setMode(0);
        } catch (Exception e) {
            Log.w(TAG, "AudioManager setMode failed, ignore it", new Object[0]);
        }
        this.mCurrentRouteType = b.a.NONE;
        this.mCurrentAudioIOScene = a.STOPPED;
        this.mExpectedAudioIOScene = a.STOPPED;
        n nVar = this.mBroadcastReceiver;
        if (nVar.f36272a != null) {
            try {
                nVar.f36272a.unregisterReceiver(nVar);
            } catch (Exception e2) {
            }
            if (nVar.b != null) {
                n.b bVar = nVar.b;
                synchronized (bVar.f36275c) {
                    if (bVar.f36274a != null && bVar.b != null) {
                        bVar.b();
                        bVar.b = null;
                    }
                }
                nVar.b = null;
            }
        }
        l lVar = this.mAudioRouteSupervisor;
        if (lVar.f36265c) {
            lVar.b.clear();
            lVar.f36265c = false;
        } else {
            Log.w("AudioRouteSupervisor", "error in uninitialize(), it's not been initialized yet", new Object[0]);
        }
        this.mCurrentRouteConfig = "";
        this.mIsServiceStarted = false;
    }

    private void updateAudioRouteStatus() {
        if (this.mBroadcastReceiver == null) {
            this.mAudioRouteSupervisor.a(b.a.BLUETOOTH_HEADSET, false);
        } else {
            l lVar = this.mAudioRouteSupervisor;
            b.a aVar = b.a.BLUETOOTH_HEADSET;
            n nVar = this.mBroadcastReceiver;
            lVar.a(aVar, nVar.b == null ? false : nVar.b.a());
        }
        this.mAudioRouteSupervisor.a(b.a.WIRED_HEADSET, this.mAudioManager.isWiredHeadsetOn());
        this.mAudioRouteSupervisor.a(b.a.SPEAKERPHONE, true);
        this.mAudioRouteSupervisor.a(b.a.EARPHONE, true);
        autoCheckRouteUpdate(false);
    }

    public void initialize() {
        HandlerThread handlerThread = new HandlerThread("AudioRouteManagerLooper");
        handlerThread.start();
        this.mHandler = new com.tencent.liteav.base.util.b(handlerThread.getLooper());
    }

    public void notifyAudioIOSceneChanged(int i, long j) {
        runOnWorkThreadAndWaitDone(h.a(this, i), j);
    }

    @Override // com.tencent.liteav.audio.route.n.a
    public void onBluetoothConnectionChanged(boolean z) {
        runOnWorkThread(k.a(this, z));
    }

    @Override // com.tencent.liteav.audio.route.n.a
    public void onBluetoothSCOConnected(boolean z) {
        runOnWorkThread(d.a(this, z));
    }

    @Override // com.tencent.liteav.audio.route.n.a
    public void onWiredHeadsetConnectionChanged(boolean z) {
        runOnWorkThread(j.a(this, z));
    }

    public void setHandFreeModeEnabled(boolean z) {
        runOnWorkThread(i.a(this, z));
    }

    public void start(String str) {
        runOnWorkThread(f.a(this, str));
    }

    public void stop() {
        runOnWorkThread(g.a(this));
    }

    public void uninitialize() {
        com.tencent.liteav.base.util.b bVar = this.mHandler;
        this.mHandler = null;
        if (bVar != null) {
            bVar.a();
            try {
                bVar.getLooper().getThread().join();
            } catch (InterruptedException e) {
            }
        }
    }
}
