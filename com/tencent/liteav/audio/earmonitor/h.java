package com.tencent.liteav.audio.earmonitor;

import android.content.Context;
import android.media.AudioManager;
import com.tencent.liteav.audio.LiteavAudioTrack;
import com.tencent.liteav.base.Log;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.StringTokenizer;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/audio/earmonitor/h.class */
public final class h extends SystemAudioKit {

    /* renamed from: a  reason: collision with root package name */
    private final AudioManager f36245a;
    private a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/audio/earmonitor/h$a.class */
    public static final class a extends Thread {

        /* renamed from: a  reason: collision with root package name */
        volatile boolean f36246a = false;
        private final SystemAudioKit b;

        public a(SystemAudioKit systemAudioKit) {
            this.b = systemAudioKit;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            LiteavAudioTrack liteavAudioTrack = new LiteavAudioTrack();
            liteavAudioTrack.startPlayout(3, 48000, 12, 3840);
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(3840);
            byte[] bArr = new byte[3840];
            Arrays.fill(bArr, (byte) 0);
            allocateDirect.put(bArr);
            while (!this.f36246a && !isInterrupted()) {
                try {
                    liteavAudioTrack.write(allocateDirect, 0, 3840);
                } catch (Exception e) {
                    SystemAudioKit systemAudioKit = this.b;
                    systemAudioKit.notifySystemError(systemAudioKit);
                }
            }
            liteavAudioTrack.stopPlayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(long j, Context context) {
        super(j);
        this.f36245a = (AudioManager) context.getSystemService("audio");
    }

    private void a(String str) {
        try {
            this.f36245a.setParameters(str);
        } catch (Throwable th) {
            Log.e("VivoSystemAudioKit", "setParameters failed. ".concat(String.valueOf(th)), new Object[0]);
            notifySystemError(this);
        }
    }

    private boolean a() {
        try {
            String parameters = this.f36245a.getParameters("vivo_ktv_mic_type");
            if (parameters == null) {
                return false;
            }
            StringTokenizer stringTokenizer = new StringTokenizer(parameters, "=");
            if (stringTokenizer.countTokens() == 2 && stringTokenizer.nextToken().equals("vivo_ktv_mic_type")) {
                try {
                    int parseInt = Integer.parseInt(stringTokenizer.nextToken());
                    return parseInt == 0 || parseInt == 1;
                } catch (NumberFormatException e) {
                    return false;
                }
            }
            return false;
        } catch (Throwable th) {
            Log.e("VivoSystemAudioKit", "getParameters failed. ".concat(String.valueOf(th)), new Object[0]);
            return false;
        }
    }

    @Override // com.tencent.liteav.audio.earmonitor.SystemAudioKit
    public final void initialize() {
        if (!a()) {
            Log.w("VivoSystemAudioKit", "initialize failed. current device dose not support system ear monitoring.", new Object[0]);
            notifyEarMonitoringInitialized(this, false);
            return;
        }
        try {
            this.f36245a.setParameters("vivo_ktv_mode=1");
            this.f36245a.setParameters("vivo_ktv_rec_source=0");
            this.f36245a.setParameters("vivo_ktv_play_source=0");
            notifyEarMonitoringInitialized(this, true);
        } catch (Throwable th) {
            Log.d("VivoSystemAudioKit", "initialize failed. ".concat(String.valueOf(th)), new Object[0]);
            notifyEarMonitoringInitialized(this, false);
        }
    }

    @Override // com.tencent.liteav.audio.earmonitor.SystemAudioKit
    public final void setEarMonitoringVolume(int i) {
        a("vivo_ktv_volume_mic=".concat(String.valueOf(Math.min(com.tencent.liteav.base.util.h.a(i, 0, 100) / 6, 15))));
    }

    @Override // com.tencent.liteav.audio.earmonitor.SystemAudioKit
    public final void startEarMonitoring() {
        if (this.b != null) {
            return;
        }
        a("vivo_ktv_play_source=1");
        a aVar = new a(this);
        this.b = aVar;
        aVar.start();
    }

    @Override // com.tencent.liteav.audio.earmonitor.SystemAudioKit
    public final void stopEarMonitoring() {
        if (this.b == null) {
            return;
        }
        a("vivo_ktv_play_source=0");
        this.b.f36246a = true;
        this.b = null;
    }

    @Override // com.tencent.liteav.audio.earmonitor.SystemAudioKit
    public final void terminate() {
        a("vivo_ktv_mode=0");
        stopEarMonitoring();
    }
}
