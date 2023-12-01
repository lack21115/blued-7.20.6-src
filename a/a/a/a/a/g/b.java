package a.a.a.a.a.g;

import a.a.a.a.a.e.e;
import android.content.Context;
import android.media.AudioRecord;
import android.media.audiofx.AcousticEchoCanceler;
import android.os.Build;
import com.qiniu.pili.droid.streaming.MicrophoneStreamingSetting;
import java.nio.ByteBuffer;

/* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/g/b.class */
public final class b implements Runnable {
    public boolean g;
    public byte[] h;
    public MicrophoneStreamingSetting j;
    public a k;
    public AudioRecord m;
    public ByteBuffer n;
    public AcousticEchoCanceler o;
    public Context p;
    public int q;

    /* renamed from: a  reason: collision with root package name */
    public volatile a.a.a.a.a.f.c f1329a = a.a.a.a.a.f.c.IDLE;
    public volatile a.a.a.a.a.f.a b = a.a.a.a.a.f.a.NONE;

    /* renamed from: c  reason: collision with root package name */
    public long f1330c = 0;
    public long d = 0;
    public long e = 0;
    public int f = 0;
    public boolean i = true;
    public c l = new c();

    /* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/g/b$a.class */
    public interface a {
        void a(ByteBuffer byteBuffer, int i, long j, boolean z);

        void b(int i);

        void c(boolean z);
    }

    public b(MicrophoneStreamingSetting microphoneStreamingSetting, a aVar) {
        this.k = aVar;
        this.j = microphoneStreamingSetting;
    }

    public int a() {
        return 2;
    }

    public final long a(long j, long j2) {
        if (this.j.b()) {
            long reqSampleRate = (j2 * 1000000) / this.j.getReqSampleRate();
            long j3 = j - reqSampleRate;
            if (this.e == 0) {
                this.d = j3;
                this.e = 0L;
            }
            long reqSampleRate2 = this.d + ((this.e * 1000000) / this.j.getReqSampleRate());
            if (j3 - reqSampleRate2 >= reqSampleRate * 2) {
                this.d = j3;
                this.e = 0L;
            } else {
                j3 = reqSampleRate2;
            }
            this.e += j2;
            return j3;
        }
        return j;
    }

    public void a(Context context) {
        synchronized (this) {
            if (this.f1329a == a.a.a.a.a.f.c.RUNNING) {
                e.g.d("AudioManager", "startRecording failed as already being running");
            } else if (this.f1329a == a.a.a.a.a.f.c.STOPPING) {
                e.g.c("AudioManager", "set pending action as START");
                this.p = context;
                this.b = a.a.a.a.a.f.a.START;
            } else if (this.f1329a == a.a.a.a.a.f.c.STARTING) {
                e.g.d("AudioManager", "startRecording failed as it is starting");
            } else {
                e.g.c("AudioManager", "startRecording +");
                this.f1329a = a.a.a.a.a.f.c.STARTING;
                this.f1330c = 0L;
                this.e = 0L;
                this.d = 0L;
                int i = 1;
                this.i = true;
                if (this.j.getChannelConfig() == 12) {
                    i = 2;
                }
                this.q = i;
                if (e()) {
                    e.g.c("AudioManager", "SCO enabled. register");
                    this.l.a(context);
                }
                Thread thread = new Thread(this, "AudioManager");
                thread.setPriority(10);
                thread.start();
            }
        }
    }

    public void a(boolean z) {
        this.g = z;
    }

    public final void b() {
        if (this.b == a.a.a.a.a.f.a.START) {
            a(this.p);
        } else if (this.b == a.a.a.a.a.f.a.STOP) {
            b(this.p);
        }
        this.b = a.a.a.a.a.f.a.NONE;
    }

    public void b(Context context) {
        synchronized (this) {
            if (this.f1329a == a.a.a.a.a.f.c.IDLE) {
                e.g.d("AudioManager", "stopRecording failed as not being running");
            } else if (this.f1329a == a.a.a.a.a.f.c.STARTING) {
                e.g.c("AudioManager", "set pending action as STOP");
                this.p = context;
                this.b = a.a.a.a.a.f.a.STOP;
            } else if (this.f1329a == a.a.a.a.a.f.c.STOPPING) {
                e.g.d("AudioManager", "stopRecording failed as it is stopping");
            } else {
                e.g.c("AudioManager", "stopRecording +");
                this.f1329a = a.a.a.a.a.f.c.STOPPING;
                if (e()) {
                    e.g.c("AudioManager", "SCO enabled. unregister");
                    this.l.b(context);
                }
            }
        }
    }

    public final void b(boolean z) {
        ByteBuffer byteBuffer = this.n;
        if (byteBuffer == null) {
            e.g.e("AudioManager", "AudioRecord read buffer is null !!!");
        } else if (this.k == null) {
            e.g.e("AudioManager", "callback listener is null !!!");
        } else {
            byteBuffer.clear();
            int read = this.m.read(this.n, this.q * 2048);
            if (this.i) {
                this.i = false;
                this.k.c(read < 0);
            }
            if (read < 0) {
                this.f1329a = a.a.a.a.a.f.c.IDLE;
                this.k.b(read);
            } else if (read <= 0) {
                e.g.d("AudioManager", "AudioRecord read audioDataLength: 0");
            } else {
                if (this.g) {
                    byte[] bArr = this.h;
                    if (bArr == null || bArr.length < read) {
                        e eVar = e.g;
                        eVar.c("AudioManager", "mute on, new temp zero byte array: " + read);
                        this.h = new byte[read];
                    }
                    this.n.put(this.h, 0, read);
                    this.n.clear();
                } else if (this.h != null) {
                    e.g.c("AudioManager", "mute off");
                    this.h = null;
                }
                long nanoTime = System.nanoTime() / 1000;
                this.f1330c = nanoTime;
                long a2 = a(nanoTime, (read / this.q) / 2);
                this.f1330c = a2;
                this.k.a(this.n, read, a2, z);
            }
        }
    }

    public final void c() {
        this.f = AudioRecord.getMinBufferSize(this.j.getReqSampleRate(), this.j.getChannelConfig(), 2);
        this.m = new AudioRecord(this.j.getAudioSource(), this.j.getReqSampleRate(), this.j.getChannelConfig(), 2, this.f * 4);
        if (!f() || Build.VERSION.SDK_INT < 16) {
            return;
        }
        AcousticEchoCanceler create = AcousticEchoCanceler.create(this.m.getAudioSessionId());
        this.o = create;
        if (create != null) {
            e.g.c("AudioManager", "set echo canceler enabled");
            this.o.setEnabled(true);
        }
    }

    public final void d() {
        AudioRecord audioRecord = this.m;
        if (audioRecord != null && audioRecord.getState() != 0) {
            if (this.m.getRecordingState() != 1) {
                try {
                    this.m.stop();
                } catch (IllegalStateException e) {
                    e eVar = e.g;
                    eVar.d("AudioManager", "e.msg:" + e.getMessage());
                }
            }
            e.g.c("AudioManager", "releaseAudioRecord");
            this.m.release();
        }
        if (this.o != null) {
            e.g.c("AudioManager", "set echo canceler disabled");
            this.o.setEnabled(false);
            this.o.release();
        }
    }

    public final boolean e() {
        MicrophoneStreamingSetting microphoneStreamingSetting = this.j;
        return microphoneStreamingSetting != null && microphoneStreamingSetting.isBluetoothSCOEnabled();
    }

    public final boolean f() {
        MicrophoneStreamingSetting microphoneStreamingSetting = this.j;
        return microphoneStreamingSetting != null && microphoneStreamingSetting.a();
    }

    /* JADX WARN: Finally extract failed */
    @Override // java.lang.Runnable
    public void run() {
        try {
            try {
                c();
                this.m.startRecording();
                this.n = ByteBuffer.allocateDirect(this.f * 4);
                synchronized (this) {
                    this.f1329a = a.a.a.a.a.f.c.RUNNING;
                    b();
                }
                e.g.c("AudioManager", "startRecording -");
                while (this.f1329a == a.a.a.a.a.f.c.RUNNING) {
                    b(false);
                }
                b(true);
                d();
                e.g.c("AudioManager", "stopRecording -");
                synchronized (this) {
                    this.f1329a = a.a.a.a.a.f.c.IDLE;
                    b();
                }
            } catch (Throwable th) {
                e.g.c("AudioManager", "startRecording -");
                throw th;
            }
        } catch (Exception e) {
            e eVar = e.g;
            eVar.e("AudioManager", "startRecording error. e.msg:" + e.getMessage());
            if (this.k != null) {
                this.k.b(-100);
            }
            synchronized (this) {
                this.f1329a = a.a.a.a.a.f.c.IDLE;
                b();
                e.g.c("AudioManager", "startRecording -");
            }
        }
    }
}
