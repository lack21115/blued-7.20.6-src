package com.soft.blued.ui.msg.controller.tools;

import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Message;
import com.blued.android.core.AppInfo;
import com.blued.android.core.utils.Log;
import com.blued.android.module.media.audio.audio_manager.BLAudioManager;
import com.blued.android.third_library.BluedMp3Recorder;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.Logger;
import java.io.IOException;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/controller/tools/MediaRecordHelper.class */
public class MediaRecordHelper {

    /* renamed from: c  reason: collision with root package name */
    private String f32255c;
    private BluedMp3Recorder d;
    private MediaPlayer e;
    private BLAudioManager f;
    private BLAudioManager.AudioManagerEvents g;
    private BLAudioManager.AudioDevice h;
    private OnRecordingListener i;
    private Timer k;
    private MediaPlayer.OnCompletionListener p;

    /* renamed from: a  reason: collision with root package name */
    public boolean f32254a = false;
    private boolean b = false;
    private long j = 0;
    private final int l = 0;
    private final int m = 1;
    private int n = 0;
    private final Handler o = new Handler() { // from class: com.soft.blued.ui.msg.controller.tools.MediaRecordHelper.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            MediaRecordHelper.this.g();
            MediaRecordHelper.this.f();
        }
    };
    private final Handler q = new Handler() { // from class: com.soft.blued.ui.msg.controller.tools.MediaRecordHelper.2
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (MediaRecordHelper.this.i != null) {
                MediaRecordHelper.this.i.a(message.arg1, message.arg2);
            }
        }
    };

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/controller/tools/MediaRecordHelper$OnRecordingListener.class */
    public interface OnRecordingListener {
        void a();

        void a(int i, int i2);

        void b();
    }

    public MediaRecordHelper() {
    }

    public MediaRecordHelper(String str) {
        this.f32255c = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(MediaPlayer mediaPlayer) {
        Log.c("MediaRecordHelper", "onCompletion");
        j();
        IMV4Constant.b = false;
        MediaPlayer.OnCompletionListener onCompletionListener = this.p;
        if (onCompletionListener != null) {
            onCompletionListener.onCompletion(mediaPlayer);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(BLAudioManager.AudioDevice audioDevice, Set set) {
        if (audioDevice == this.h || BluedPreferences.aV()) {
            return;
        }
        Log.c("MediaRecordHelper", "onAudioDeviceChanged: selectedAudioDevice = " + audioDevice);
        this.h = audioDevice;
        if (audioDevice == BLAudioManager.AudioDevice.EARPIECE) {
            h();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean a(MediaPlayer mediaPlayer, int i, int i2) {
        Log.c("MediaRecordHelper", "onError");
        j();
        IMV4Constant.b = false;
        return false;
    }

    private void d() {
        try {
            f();
            i();
        } catch (Throwable th) {
        }
    }

    private boolean e() {
        MediaPlayer mediaPlayer = this.e;
        return mediaPlayer != null && mediaPlayer.isPlaying();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (e()) {
            return;
        }
        IMV4Constant.b = true;
        MediaPlayer mediaPlayer = new MediaPlayer();
        this.e = mediaPlayer;
        mediaPlayer.setAudioStreamType(3);
        this.e.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.soft.blued.ui.msg.controller.tools.-$$Lambda$MediaRecordHelper$NcL1B2J1zyLcwnWEWrA57rjOWF0
            @Override // android.media.MediaPlayer.OnCompletionListener
            public final void onCompletion(MediaPlayer mediaPlayer2) {
                MediaRecordHelper.this.a(mediaPlayer2);
            }
        });
        this.e.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.soft.blued.ui.msg.controller.tools.-$$Lambda$MediaRecordHelper$EBf3oSwFGMf7aVNPKzp4KC8mKvo
            @Override // android.media.MediaPlayer.OnErrorListener
            public final boolean onError(MediaPlayer mediaPlayer2, int i, int i2) {
                boolean a2;
                a2 = MediaRecordHelper.this.a(mediaPlayer2, i, i2);
                return a2;
            }
        });
        try {
            this.e.setDataSource(this.f32255c);
            this.e.prepare();
            this.e.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        MediaPlayer mediaPlayer = this.e;
        if (mediaPlayer == null) {
            return;
        }
        if (mediaPlayer.isPlaying()) {
            this.e.stop();
        }
        this.e.release();
        this.e = null;
    }

    private void h() {
        this.o.removeCallbacksAndMessages(null);
        this.o.sendEmptyMessage(0);
    }

    private void i() {
        try {
            if (this.f == null) {
                this.f = BLAudioManager.a(AppInfo.d());
                this.g = new BLAudioManager.AudioManagerEvents() { // from class: com.soft.blued.ui.msg.controller.tools.-$$Lambda$MediaRecordHelper$fHSdCsq0AeUfT2tC-R5tWFIrGvc
                    @Override // com.blued.android.module.media.audio.audio_manager.BLAudioManager.AudioManagerEvents
                    public final void onAudioDeviceChanged(BLAudioManager.AudioDevice audioDevice, Set set) {
                        MediaRecordHelper.this.a(audioDevice, set);
                    }
                };
            }
            this.f.a(BluedPreferences.aV() ? BLAudioManager.AudioSwitchMode.EARPIECE_MODE : BLAudioManager.AudioSwitchMode.SPEAKERPHONE_MODE);
            this.f.a(this.g);
            this.f.a();
        } catch (Throwable th) {
        }
    }

    private void j() {
        try {
            if (this.f != null) {
                this.f.a((BLAudioManager.AudioManagerEvents) null);
                this.f.b();
            }
        } catch (Throwable th) {
        }
    }

    public void a() throws IllegalStateException, IOException {
        if (System.currentTimeMillis() - this.j <= 500) {
            OnRecordingListener onRecordingListener = this.i;
            if (onRecordingListener != null) {
                onRecordingListener.a();
            }
        } else if (this.b) {
        } else {
            this.b = true;
            if (this.n != 0) {
                OnRecordingListener onRecordingListener2 = this.i;
                if (onRecordingListener2 != null) {
                    onRecordingListener2.b();
                    return;
                }
                return;
            }
            try {
                BluedMp3Recorder bluedMp3Recorder = new BluedMp3Recorder(this.f32255c);
                this.d = bluedMp3Recorder;
                bluedMp3Recorder.a();
                this.n = 1;
                Timer timer = new Timer();
                this.k = timer;
                timer.schedule(new TimerTask() { // from class: com.soft.blued.ui.msg.controller.tools.MediaRecordHelper.3
                    private int b = 0;

                    /* renamed from: c  reason: collision with root package name */
                    private int f32259c = 0;

                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        if (MediaRecordHelper.this.d == null) {
                            cancel();
                            return;
                        }
                        int i = this.b + 1;
                        this.b = i;
                        if (i % 5 == 0) {
                            this.f32259c = i / 5;
                        }
                        int i2 = 100;
                        try {
                            if (MediaRecordHelper.this.d != null) {
                                i2 = MediaRecordHelper.this.d.d();
                            }
                        } catch (Exception e) {
                            i2 = 100;
                            if (MediaRecordHelper.this.f32254a) {
                                Logger.e("debug", "录音-->getMaxAmplitude异常-->", e);
                                i2 = 100;
                            }
                        }
                        Message obtain = Message.obtain();
                        obtain.arg1 = this.f32259c;
                        obtain.arg2 = i2;
                        MediaRecordHelper.this.q.sendMessage(obtain);
                    }
                }, 0L, 200L);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void a(MediaPlayer.OnCompletionListener onCompletionListener) {
        this.p = onCompletionListener;
    }

    public void a(OnRecordingListener onRecordingListener) {
        this.i = onRecordingListener;
    }

    public void a(String str) {
        this.f32255c = str;
    }

    public void a(boolean z) {
        this.j = System.currentTimeMillis();
        Timer timer = this.k;
        if (timer != null) {
            timer.cancel();
            this.k = null;
        }
        try {
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (this.b) {
            if (z) {
                AppInfo.n().postDelayed(new Runnable() { // from class: com.soft.blued.ui.msg.controller.tools.MediaRecordHelper.4
                    @Override // java.lang.Runnable
                    public void run() {
                        MediaRecordHelper.this.d.b();
                    }
                }, 1000L);
            } else {
                this.d.b();
            }
            this.b = false;
            this.n = 0;
        }
    }

    public void b() {
        IMV4Constant.b = false;
        this.o.removeCallbacksAndMessages(null);
        g();
        j();
        a((MediaPlayer.OnCompletionListener) null);
    }

    public void b(String str) {
        this.f32255c = str;
        d();
    }

    public boolean c() {
        BluedMp3Recorder bluedMp3Recorder = this.d;
        if (bluedMp3Recorder != null) {
            return bluedMp3Recorder.c();
        }
        return false;
    }
}
