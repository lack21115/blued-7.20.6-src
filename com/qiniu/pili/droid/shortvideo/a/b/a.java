package com.qiniu.pili.droid.shortvideo.a.b;

import android.media.AudioRecord;
import android.media.audiofx.AcousticEchoCanceler;
import android.media.audiofx.NoiseSuppressor;
import com.qiniu.pili.droid.shortvideo.PLAudioFrameListener;
import com.qiniu.pili.droid.shortvideo.PLMicrophoneSetting;
import com.qiniu.pili.droid.shortvideo.f.e;
import java.util.Arrays;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/a/b/a.class */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private AudioRecord f13831a;
    private PLMicrophoneSetting b;

    /* renamed from: c  reason: collision with root package name */
    private int f13832c;
    private Thread d;
    private byte[] h;
    private PLAudioFrameListener k;
    private NoiseSuppressor l;
    private AcousticEchoCanceler m;
    private boolean e = false;
    private boolean f = false;
    private volatile boolean g = false;
    private long i = 0;
    private long j = 0;
    private final Runnable n = new Runnable() { // from class: com.qiniu.pili.droid.shortvideo.a.b.a.1
        @Override // java.lang.Runnable
        public void run() {
            while (!a.this.g) {
                if (a.this.h == null) {
                    a aVar = a.this;
                    aVar.h = new byte[aVar.f13832c * 1024 * 2];
                }
                int read = a.this.f13831a.read(a.this.h, 0, a.this.h.length);
                e eVar = e.f;
                eVar.a("AudioManager", "audio frame read size:" + read);
                if (read < 0) {
                    a.this.a(read);
                } else {
                    a aVar2 = a.this;
                    aVar2.a(aVar2.h);
                }
            }
        }
    };

    public a(PLMicrophoneSetting pLMicrophoneSetting) {
        this.b = pLMicrophoneSetting;
    }

    private long a(long j, long j2) {
        if (this.b.isAudioPtsOptimizeEnabled()) {
            long sampleRate = (j2 * 1000000) / this.b.getSampleRate();
            long j3 = j - sampleRate;
            if (this.j == 0) {
                this.i = j3;
                this.j = 0L;
            }
            long sampleRate2 = this.i + ((this.j * 1000000) / this.b.getSampleRate());
            if (j3 - sampleRate2 >= sampleRate * 2) {
                this.i = j3;
                this.j = 0L;
            } else {
                j3 = sampleRate2;
            }
            this.j += j2;
            return j3;
        }
        return j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        e eVar = e.f;
        eVar.e("AudioManager", "onAudioRecordFailed: " + i);
        PLAudioFrameListener pLAudioFrameListener = this.k;
        if (pLAudioFrameListener != null) {
            pLAudioFrameListener.onAudioRecordFailed(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(byte[] bArr) {
        if (this.k == null) {
            return;
        }
        if (this.f) {
            Arrays.fill(bArr, (byte) 0);
        }
        this.k.onAudioFrameAvailable(bArr, a(System.nanoTime() / 1000, (bArr.length / this.f13832c) / 2) * 1000);
    }

    private boolean c() {
        PLMicrophoneSetting pLMicrophoneSetting = this.b;
        return pLMicrophoneSetting != null && pLMicrophoneSetting.isNSEnabled();
    }

    private boolean d() {
        PLMicrophoneSetting pLMicrophoneSetting = this.b;
        return pLMicrophoneSetting != null && pLMicrophoneSetting.isAECEnabled();
    }

    public void a(PLAudioFrameListener pLAudioFrameListener) {
        this.k = pLAudioFrameListener;
    }

    public void a(boolean z) {
        this.f = z;
    }

    public boolean a() {
        e.f.c("AudioManager", "start audio recording +");
        if (this.e) {
            e.f.d("AudioManager", "recording already started !");
            return false;
        }
        this.f13832c = this.b.getChannelConfig() == 12 ? 2 : 1;
        int minBufferSize = AudioRecord.getMinBufferSize(this.b.getSampleRate(), this.b.getChannelConfig(), this.b.getAudioFormat());
        if (minBufferSize == -2) {
            e.f.e("AudioManager", "invalid parameter !");
            return false;
        }
        try {
            this.f13831a = new AudioRecord(this.b.getAudioSource(), this.b.getSampleRate(), this.b.getChannelConfig(), this.b.getAudioFormat(), minBufferSize * 4);
            if (c()) {
                NoiseSuppressor create = NoiseSuppressor.create(this.f13831a.getAudioSessionId());
                this.l = create;
                if (create != null) {
                    e.f.c("AudioManager", "set noise suppressor enabled");
                    this.l.setEnabled(true);
                }
            }
            if (d()) {
                AcousticEchoCanceler create2 = AcousticEchoCanceler.create(this.f13831a.getAudioSessionId());
                this.m = create2;
                if (create2 != null) {
                    e.f.c("AudioManager", "set acoustic echo canceler enabled");
                    this.m.setEnabled(true);
                }
            }
            if (this.f13831a.getState() == 0) {
                e.f.e("AudioManager", "AudioRecord initialize fail !");
                return false;
            }
            this.f13831a.startRecording();
            if (this.f13831a.getRecordingState() != 3) {
                e.f.e("AudioManager", "AudioRecord cannot recording !");
                return false;
            }
            this.j = 0L;
            this.i = 0L;
            this.g = false;
            Thread thread = new Thread(this.n);
            this.d = thread;
            thread.setPriority(10);
            this.d.start();
            this.e = true;
            e.f.c("AudioManager", "start audio recording -");
            return true;
        } catch (IllegalArgumentException e) {
            e eVar = e.f;
            eVar.e("AudioManager", "Create AudioRecord failed : " + e.getMessage());
            return false;
        }
    }

    public void b() {
        e.f.c("AudioManager", "stop audio recording +");
        if (!this.e) {
            e.f.d("AudioManager", "recording already stopped !");
            return;
        }
        this.g = true;
        try {
            this.d.interrupt();
            this.d.join(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (this.f13831a.getRecordingState() == 3) {
            this.f13831a.stop();
        }
        this.f13831a.release();
        if (this.l != null) {
            e.f.c("AudioManager", "set noise suppressor disabled");
            this.l.setEnabled(false);
            this.l.release();
        }
        if (this.m != null) {
            e.f.c("AudioManager", "set acoustic echo canceler disabled");
            this.m.setEnabled(false);
            this.m.release();
        }
        this.e = false;
        e.f.c("AudioManager", "stop audio recording -");
    }
}
