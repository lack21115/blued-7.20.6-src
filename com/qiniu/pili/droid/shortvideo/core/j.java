package com.qiniu.pili.droid.shortvideo.core;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaCodec;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaPlayer;
import android.net.wifi.WifiScanner;
import android.view.Surface;
import com.qiniu.pili.droid.shortvideo.PLAudioEncodeSetting;
import com.qiniu.pili.droid.shortvideo.PLAudioFrameListener;
import com.qiniu.pili.droid.shortvideo.PLMicrophoneSetting;
import com.qiniu.pili.droid.shortvideo.PLRecordSetting;
import com.qiniu.pili.droid.shortvideo.PLRecordStateListener;
import com.qiniu.pili.droid.shortvideo.PLVideoSaveListener;
import com.qiniu.pili.droid.shortvideo.core.a;
import com.qiniu.pili.droid.shortvideo.core.b;
import com.qiniu.pili.droid.shortvideo.core.i;
import com.qiniu.pili.droid.shortvideo.d.b;
import com.qiniu.pili.droid.shortvideo.encode.SWAudioEncoder;
import com.qiniu.pili.droid.shortvideo.encode.a;
import com.qiniu.pili.droid.shortvideo.transcoder.audio.b;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Stack;
import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/core/j.class */
public class j implements PLAudioFrameListener, i.a {
    private MediaPlayer A;
    private Stack<Integer> B;
    private Stack<Object> C;
    private boolean D;
    private boolean E;
    private String F;
    private double G;
    private long H;
    private com.qiniu.pili.droid.shortvideo.d.b L;
    private MediaExtractor M;
    private com.qiniu.pili.droid.shortvideo.transcoder.audio.b N;
    private volatile long O;
    private long Q;
    private Stack<Long> R;
    private long S;
    private int T;
    private volatile boolean U;

    /* renamed from: a  reason: collision with root package name */
    private com.qiniu.pili.droid.shortvideo.encode.a f13869a;
    private PLAudioFrameListener b;

    /* renamed from: c  reason: collision with root package name */
    private volatile boolean f13870c;
    private volatile boolean d;
    private PLVideoSaveListener e;
    protected volatile boolean g;
    protected volatile boolean h;
    protected volatile boolean i;
    protected volatile boolean j;
    protected volatile boolean k;
    protected volatile boolean l;
    protected Context m;
    protected PLRecordSetting n;
    protected PLMicrophoneSetting o;
    protected PLAudioEncodeSetting p;
    protected com.qiniu.pili.droid.shortvideo.a.b.a q;
    protected i r;
    protected PLRecordStateListener s;
    protected boolean w;
    protected volatile double x;
    protected double t = 1.0d;
    private boolean f = false;
    private a z = new a();
    protected String u = null;
    protected AssetFileDescriptor v = null;
    private long I = -1;
    private Stack<Double> J = new Stack<>();
    private Stack<Long> K = new Stack<>();
    private final Object P = new Object();
    private b.a V = new b.a() { // from class: com.qiniu.pili.droid.shortvideo.core.j.4
        @Override // com.qiniu.pili.droid.shortvideo.transcoder.audio.b.a
        public void a(ByteBuffer byteBuffer, int i) {
            j.this.f13869a.a(byteBuffer, i, j.this.O);
            j.this.O += j.this.Q;
        }
    };
    private b.c W = new b.c() { // from class: com.qiniu.pili.droid.shortvideo.core.j.5
        private boolean a() {
            if (j.this.U) {
                j.this.b();
                j.this.v();
                j.this.U = false;
                return true;
            }
            return false;
        }

        @Override // com.qiniu.pili.droid.shortvideo.d.b.c
        public void a(ByteBuffer byteBuffer, int i, long j, long j2, boolean z) {
            if (j.this.j) {
                synchronized (j.this.P) {
                    j.this.N.a(byteBuffer, byteBuffer.position(), i);
                    j.this.S = j;
                    do {
                        if (!j.this.x()) {
                            return;
                        }
                        if (a()) {
                            return;
                        }
                        try {
                            j.this.P.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } while (!a());
                }
            }
        }
    };
    protected a.InterfaceC0575a y = new a.InterfaceC0575a() { // from class: com.qiniu.pili.droid.shortvideo.core.j.6
        @Override // com.qiniu.pili.droid.shortvideo.encode.a.InterfaceC0575a
        public void a(MediaFormat mediaFormat) {
            com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.n;
            eVar.c("ShortAudioRecorderCore", "got audio format:" + mediaFormat.toString());
            j.this.r.b(mediaFormat);
            j.this.k = true;
            j.this.r();
        }

        @Override // com.qiniu.pili.droid.shortvideo.encode.a.InterfaceC0575a
        public void a(Surface surface) {
        }

        @Override // com.qiniu.pili.droid.shortvideo.encode.a.InterfaceC0575a
        public void a(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
            if (j.this.l) {
                com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.h;
                eVar.b("ShortAudioRecorderCore", "audio encoded frame size:" + bufferInfo.size + " ts:" + bufferInfo.presentationTimeUs);
                j.this.r.b(byteBuffer, bufferInfo);
            }
        }

        @Override // com.qiniu.pili.droid.shortvideo.encode.a.InterfaceC0575a
        public void a(boolean z) {
            com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.h;
            eVar.c("ShortAudioRecorderCore", "audio encoder started: " + z);
            j.this.j = z;
            if (z || j.this.s == null) {
                return;
            }
            j.this.i = false;
            j.this.s.onError(7);
            QosManager.a().a(7);
        }

        @Override // com.qiniu.pili.droid.shortvideo.encode.a.InterfaceC0575a
        public void b(boolean z) {
            com.qiniu.pili.droid.shortvideo.f.e.h.c("ShortAudioRecorderCore", "audio encoder stopped.");
            j.this.j = false;
            j.this.k = false;
            j.this.I = -1L;
            j.this.x = 0.0d;
            j.this.O = 0L;
            j.this.s();
        }
    };

    public j() {
        com.qiniu.pili.droid.shortvideo.f.e.d.c("ShortAudioRecorderCore", "init");
    }

    private void a(long j) {
        long j2;
        if (this.I == -1) {
            this.G += WifiScanner.MAX_SCAN_PERIOD_MS / this.p.getSamplerate();
            this.x += WifiScanner.MAX_SCAN_PERIOD_MS / this.p.getSamplerate();
            return;
        }
        this.G += ((j - j2) / this.t) / 1000000.0d;
        this.x += ((j - this.I) / this.t) / 1000000.0d;
    }

    private void a(Object obj) {
        com.qiniu.pili.droid.shortvideo.f.e.d.c("ShortAudioRecorderCore", "configMusicPlayer...");
        MediaPlayer mediaPlayer = this.A;
        if (mediaPlayer != null) {
            mediaPlayer.reset();
            this.d = false;
        }
        if (this.A == null) {
            this.A = new MediaPlayer();
            this.B = new Stack<>();
            this.C = new Stack<>();
            this.R = new Stack<>();
        }
        try {
            if (obj instanceof String) {
                this.A.setDataSource((String) obj);
            } else {
                this.A.setDataSource(((AssetFileDescriptor) obj).getFileDescriptor(), ((AssetFileDescriptor) obj).getStartOffset(), ((AssetFileDescriptor) obj).getLength());
            }
            if (this.E) {
                this.A.setVolume(0.0f, 0.0f);
            }
            this.A.prepare();
            this.A.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.qiniu.pili.droid.shortvideo.core.j.2
                @Override // android.media.MediaPlayer.OnCompletionListener
                public void onCompletion(MediaPlayer mediaPlayer2) {
                    j.this.A.seekTo(j.this.T);
                    j.this.A.start();
                }
            });
            this.d = true;
            this.S = 0L;
        } catch (IOException e) {
            com.qiniu.pili.droid.shortvideo.f.e.d.e("ShortAudioRecorderCore", e.toString());
            w();
            PLRecordStateListener pLRecordStateListener = this.s;
            if (pLRecordStateListener != null) {
                pLRecordStateListener.onError(0);
            }
        }
    }

    private boolean a() {
        return this.A != null && this.w;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        this.j = false;
        this.f13869a.c();
    }

    private void c(boolean z) {
        int i;
        Object pop = this.C.pop();
        int intValue = this.B.pop().intValue();
        long longValue = this.R.pop().longValue();
        Object obj = pop;
        int i2 = intValue;
        long j = longValue;
        if (z) {
            while (true) {
                i = intValue;
                if (this.C.size() <= 0) {
                    break;
                }
                pop = this.C.pop();
            }
            while (true) {
                j = longValue;
                if (this.B.size() <= 0) {
                    break;
                }
                i = this.B.pop().intValue();
            }
            while (true) {
                obj = pop;
                i2 = i;
                if (this.R.size() <= 0) {
                    break;
                }
                j = this.R.pop().longValue();
            }
        }
        if (obj instanceof String) {
            String str = this.u;
            if (str == null || !str.equals((String) obj)) {
                this.u = (String) obj;
                this.v = null;
                a(obj);
            }
        } else {
            AssetFileDescriptor assetFileDescriptor = this.v;
            if (assetFileDescriptor == null || !assetFileDescriptor.equals((AssetFileDescriptor) obj)) {
                this.v = (AssetFileDescriptor) obj;
                this.u = null;
                a(obj);
            }
        }
        this.A.seekTo(i2);
        this.D = false;
        this.S = j;
    }

    private void u() {
        com.qiniu.pili.droid.shortvideo.f.e.d.c("ShortAudioRecorderCore", "startMusicExtractorInternal + ");
        AssetFileDescriptor assetFileDescriptor = this.v;
        if (assetFileDescriptor != null) {
            this.M = com.qiniu.pili.droid.shortvideo.f.g.a(assetFileDescriptor);
        } else {
            this.M = com.qiniu.pili.droid.shortvideo.f.g.a(this.u);
        }
        MediaFormat a2 = com.qiniu.pili.droid.shortvideo.f.g.a(this.M);
        if (a2 == null) {
            com.qiniu.pili.droid.shortvideo.f.e.d.e("ShortAudioRecorderCore", "start music extractor failed!");
            return;
        }
        com.qiniu.pili.droid.shortvideo.d.b bVar = new com.qiniu.pili.droid.shortvideo.d.b(this.M, a2);
        this.L = bVar;
        bVar.a(true);
        this.L.a(this.W);
        this.L.a(new b.d() { // from class: com.qiniu.pili.droid.shortvideo.core.j.3
            @Override // com.qiniu.pili.droid.shortvideo.d.b.d
            public void a(MediaFormat mediaFormat) {
                j.this.N = new com.qiniu.pili.droid.shortvideo.transcoder.audio.b();
                j.this.N.a(j.this.V);
                j.this.N.a(mediaFormat.getInteger(MediaFormat.KEY_SAMPLE_RATE), mediaFormat.getInteger(MediaFormat.KEY_CHANNEL_COUNT), 16, j.this.p.getSamplerate(), j.this.p.getChannels(), 16);
            }
        });
        this.L.a(this.S);
        com.qiniu.pili.droid.shortvideo.f.e.d.c("ShortAudioRecorderCore", "startMusicExtractorInternal - ");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        com.qiniu.pili.droid.shortvideo.d.b bVar = this.L;
        if (bVar != null) {
            bVar.c();
            this.L = null;
        }
        MediaExtractor mediaExtractor = this.M;
        if (mediaExtractor != null) {
            mediaExtractor.release();
            this.M = null;
        }
        com.qiniu.pili.droid.shortvideo.transcoder.audio.b bVar2 = this.N;
        if (bVar2 != null) {
            bVar2.a();
            this.N = null;
        }
    }

    private void w() {
        MediaPlayer mediaPlayer = this.A;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            this.A.release();
        }
        this.A = null;
        this.B = null;
        this.C = null;
        this.d = false;
        this.D = false;
        this.R = null;
        this.T = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean x() {
        return ((double) this.O) > this.x * 1000.0d;
    }

    public void a(double d) {
        if (a(b.a.record_speed)) {
            if (d()) {
                com.qiniu.pili.droid.shortvideo.f.e.d.d("ShortAudioRecorderCore", "can't set speed while recording!!!");
                return;
            }
            int i = (d > 1.0d ? 1 : (d == 1.0d ? 0 : -1));
            if (!((i > 0 && d % 2.0d == 0.0d) || (d < 1.0d && (1.0d / d) % 2.0d == 0.0d) || i == 0)) {
                com.qiniu.pili.droid.shortvideo.f.e.d.d("ShortAudioRecorderCore", "only support multiple of 2 !!!");
                return;
            }
            com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.d;
            eVar.c("ShortAudioRecorderCore", "set record speed to: " + d);
            this.t = d;
            this.z.a(d);
            this.r.a(this.t);
        }
    }

    public void a(int i) {
        MediaPlayer mediaPlayer = this.A;
        if (mediaPlayer == null) {
            com.qiniu.pili.droid.shortvideo.f.e.d.e("ShortAudioRecorderCore", "setMusicPosition failed, you must set music file firstly!");
            return;
        }
        this.T = i;
        mediaPlayer.seekTo(i);
        this.S = i * 1000;
    }

    @Override // com.qiniu.pili.droid.shortvideo.core.i.a
    public void a(long j, long j2, int i) {
        double d = j;
        long j3 = (long) ((j2 - j) + (this.t * d));
        this.J.push(new Double(this.t));
        this.K.push(new Long(j3));
        this.H += j;
        com.qiniu.pili.droid.shortvideo.f.e.d.c("ShortAudioRecorderCore", "Section increased speed: " + this.t + "; Section count" + i + "; Total duration: " + j2 + "; Section duration: " + j + "; Recording duration: " + j3);
        PLRecordStateListener pLRecordStateListener = this.s;
        if (pLRecordStateListener != null) {
            pLRecordStateListener.onSectionIncreased((long) (d * this.t), j3, i);
        }
    }

    public void a(Context context, PLMicrophoneSetting pLMicrophoneSetting, PLAudioEncodeSetting pLAudioEncodeSetting, PLRecordSetting pLRecordSetting) {
        com.qiniu.pili.droid.shortvideo.f.e.d.c("ShortAudioRecorderCore", "prepare +");
        l.a(context);
        this.m = context;
        this.n = pLRecordSetting;
        this.o = pLMicrophoneSetting;
        this.p = pLAudioEncodeSetting;
        this.q = new com.qiniu.pili.droid.shortvideo.a.b.a(pLMicrophoneSetting);
        if (pLAudioEncodeSetting.isHWCodecEnabled()) {
            this.f13869a = new com.qiniu.pili.droid.shortvideo.encode.c(pLAudioEncodeSetting);
        } else {
            this.f13869a = new SWAudioEncoder(pLAudioEncodeSetting);
        }
        i g = g();
        this.r = g;
        g.a(pLRecordSetting.getMaxRecordDuration());
        this.r.a(this);
        this.f13869a.a(this.y);
        this.q.a(this);
        this.Q = (long) ((1024 * 1000000.0d) / this.p.getSamplerate());
        com.qiniu.pili.droid.shortvideo.f.e.d.c("ShortAudioRecorderCore", "prepare -");
    }

    public void a(AssetFileDescriptor assetFileDescriptor) {
        if (a(b.a.record_audio_mix)) {
            if (d()) {
                com.qiniu.pili.droid.shortvideo.f.e.d.e("ShortAudioRecorderCore", "Cannot add audio file when recording!");
            } else if (assetFileDescriptor == null) {
                w();
            } else {
                a(true);
                this.u = null;
                this.v = assetFileDescriptor;
                a((Object) assetFileDescriptor);
            }
        }
    }

    public final void a(PLAudioFrameListener pLAudioFrameListener) {
        this.b = pLAudioFrameListener;
    }

    public final void a(PLRecordStateListener pLRecordStateListener) {
        this.s = pLRecordStateListener;
    }

    public void a(PLVideoSaveListener pLVideoSaveListener) {
        com.qiniu.pili.droid.shortvideo.f.e.d.c("ShortAudioRecorderCore", "concatSections +");
        if (!u.a().b()) {
            com.qiniu.pili.droid.shortvideo.f.e.b.d("unauthorized !");
            QosManager.a().a(8);
            if (pLVideoSaveListener != null) {
                pLVideoSaveListener.onSaveVideoFailed(8);
            }
        } else if (this.i) {
            com.qiniu.pili.droid.shortvideo.f.e.d.d("ShortAudioRecorderCore", "cannot concat sections while readying !!!");
            QosManager.a().a(1);
            if (pLVideoSaveListener != null) {
                pLVideoSaveListener.onSaveVideoFailed(1);
            }
        } else {
            if (this.l) {
                this.f13870c = true;
                this.e = pLVideoSaveListener;
                c();
            } else {
                this.r.a(pLVideoSaveListener);
            }
            com.qiniu.pili.droid.shortvideo.f.e.d.c("ShortAudioRecorderCore", "concatSections -");
        }
    }

    public void a(String str, boolean z) {
        this.E = z;
        b(str);
    }

    public void a(boolean z) {
        if (a(b.a.record_mute)) {
            com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.d;
            eVar.c("ShortAudioRecorderCore", "mute: " + z);
            this.w = z;
            this.q.a(z);
        }
    }

    public boolean a(Context context, com.qiniu.pili.droid.shortvideo.f.b bVar) {
        if (bVar == null) {
            com.qiniu.pili.droid.shortvideo.f.e.d.e("ShortAudioRecorderCore", "Error on recoverFromDraft, null draft");
            return false;
        }
        this.n = bVar.h();
        this.o = bVar.d();
        PLAudioEncodeSetting f = bVar.f();
        this.p = f;
        a(context, this.o, f, this.n);
        i g = g();
        this.r = g;
        g.a(this.n.getMaxRecordDuration());
        this.r.a(this);
        return this.r.a(bVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(b.a aVar) {
        if (u.a().a(aVar)) {
            return true;
        }
        PLRecordStateListener pLRecordStateListener = this.s;
        if (pLRecordStateListener != null) {
            pLRecordStateListener.onError(8);
        }
        QosManager.a().a(8);
        return false;
    }

    public boolean a(String str) {
        synchronized (this) {
            com.qiniu.pili.droid.shortvideo.f.e.d.c("ShortAudioRecorderCore", "beginSection +");
            if (a(b.a.record_microphone_capture)) {
                if (!this.n.IsRecordSpeedVariable() && !this.f) {
                    this.n.setMaxRecordDuration((long) (this.n.getMaxRecordDuration() / this.t));
                    this.f = true;
                }
                if (this.A != null && !this.d) {
                    com.qiniu.pili.droid.shortvideo.f.e.d.c("ShortAudioRecorderCore", "player is not prepared!");
                    return false;
                }
                if (!this.i && !this.l) {
                    if (this.H >= this.n.getMaxRecordDuration()) {
                        com.qiniu.pili.droid.shortvideo.f.e.d.d("ShortAudioRecorderCore", "reached the max record duration");
                        return false;
                    }
                    this.F = str;
                    this.i = true;
                    this.z.a(new a.InterfaceC0573a() { // from class: com.qiniu.pili.droid.shortvideo.core.j.1
                        @Override // com.qiniu.pili.droid.shortvideo.core.a.InterfaceC0573a
                        public void a(ByteBuffer byteBuffer, int i, long j) {
                            j.this.f13869a.a(byteBuffer, i, j);
                        }
                    });
                    this.f13869a.a();
                    if (this.A != null && !this.D) {
                        this.C.push(this.u == null ? this.v : this.u);
                        this.A.start();
                        this.B.push(Integer.valueOf(this.A.getCurrentPosition()));
                        this.R.push(Long.valueOf(this.S));
                    }
                    com.qiniu.pili.droid.shortvideo.f.e.d.c("ShortAudioRecorderCore", "beginSection -");
                    return true;
                }
                com.qiniu.pili.droid.shortvideo.f.e.d.d("ShortAudioRecorderCore", "section begin ongoing !!!");
                return false;
            }
            return false;
        }
    }

    @Override // com.qiniu.pili.droid.shortvideo.core.i.a
    public void b(long j, long j2, int i) {
        if (i == 0 && !this.n.IsRecordSpeedVariable()) {
            this.f = false;
            PLRecordSetting pLRecordSetting = this.n;
            pLRecordSetting.setMaxRecordDuration((long) (pLRecordSetting.getMaxRecordDuration() * this.t));
        }
        while (this.K.size() > i) {
            this.K.pop();
        }
        long j3 = this.H - j;
        this.H = j3;
        this.G = j3;
        double doubleValue = this.J.isEmpty() ? 0.0d : this.J.pop().doubleValue();
        long longValue = this.K.isEmpty() ? 0L : this.K.pop().longValue();
        com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.d;
        eVar.c("ShortAudioRecorderCore", "Section decreased speed: " + doubleValue + "; Section count" + i + "RecDurationStackSz: " + this.K.size() + "; Total duration: " + j2 + "; Section duration: " + j + "; Recording duration: " + longValue);
        PLRecordStateListener pLRecordStateListener = this.s;
        if (pLRecordStateListener != null) {
            pLRecordStateListener.onSectionDecreased((long) (j * doubleValue), longValue, i);
        }
    }

    public void b(String str) {
        if (a(b.a.record_audio_mix)) {
            if (d()) {
                com.qiniu.pili.droid.shortvideo.f.e.d.e("ShortAudioRecorderCore", "cannot add audio file when recording!");
            } else if (str == null) {
                w();
            } else {
                a(true);
                this.u = str;
                this.v = null;
                a((Object) str);
            }
        }
    }

    public void b(boolean z) {
        com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.d;
        eVar.c("ShortAudioRecorderCore", "destroy + clearSections: " + z);
        if (z) {
            this.r.a(false);
        }
        com.qiniu.pili.droid.shortvideo.f.e.d.c("ShortAudioRecorderCore", "destroy -");
    }

    public boolean c() {
        synchronized (this) {
            com.qiniu.pili.droid.shortvideo.f.e.d.c("ShortAudioRecorderCore", "endSection +");
            if (!this.i && !this.l) {
                com.qiniu.pili.droid.shortvideo.f.e.d.d("ShortAudioRecorderCore", "not started !!!");
                return false;
            }
            if (this.A != null) {
                this.A.pause();
            }
            if (a()) {
                synchronized (this.P) {
                    this.U = true;
                    if (x()) {
                        this.P.notify();
                    }
                }
            } else {
                b();
            }
            com.qiniu.pili.droid.shortvideo.f.e.d.c("ShortAudioRecorderCore", "endSection -");
            return true;
        }
    }

    public boolean c(String str) {
        return this.r.a(str, null, this.o, null, this.p, null, this.n);
    }

    protected boolean d() {
        return this.j;
    }

    protected boolean e() {
        return this.k;
    }

    protected boolean f() {
        return !this.k;
    }

    protected i g() {
        return new i(this.m, this.n, this.p);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public JSONObject h() {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    @Override // com.qiniu.pili.droid.shortvideo.core.i.a
    public void i() {
        PLRecordStateListener pLRecordStateListener = this.s;
        if (pLRecordStateListener != null) {
            pLRecordStateListener.onDurationTooShort();
        }
    }

    public void j() {
        PLRecordStateListener pLRecordStateListener;
        com.qiniu.pili.droid.shortvideo.f.e.d.c("ShortAudioRecorderCore", "resume +");
        if (l()) {
            com.qiniu.pili.droid.shortvideo.f.e.d.d("ShortAudioRecorderCore", "sources already ready !!!");
        } else if (this.g) {
            com.qiniu.pili.droid.shortvideo.f.e.d.d("ShortAudioRecorderCore", "source readying !!!");
        } else {
            this.g = true;
            if (!this.q.a() && (pLRecordStateListener = this.s) != null) {
                pLRecordStateListener.onError(5);
                QosManager.a().a(5);
            }
            com.qiniu.pili.droid.shortvideo.f.e.d.c("ShortAudioRecorderCore", "resume -");
        }
    }

    public void k() {
        com.qiniu.pili.droid.shortvideo.f.e.d.c("ShortAudioRecorderCore", "pause +");
        c();
        this.g = false;
        this.h = false;
        this.k = false;
        this.q.b();
        com.qiniu.pili.droid.shortvideo.f.e.d.c("ShortAudioRecorderCore", "pause -");
    }

    protected boolean l() {
        return this.h;
    }

    public boolean m() {
        com.qiniu.pili.droid.shortvideo.f.e.d.c("ShortAudioRecorderCore", "deleteLastSection +");
        if (this.i || this.l) {
            com.qiniu.pili.droid.shortvideo.f.e.d.d("ShortAudioRecorderCore", "cannot delete while working !!!");
            return false;
        }
        boolean c2 = this.r.c();
        Stack<Object> stack = this.C;
        if (stack != null && stack.empty()) {
            w();
        }
        if (c2 && this.A != null) {
            c(false);
        }
        com.qiniu.pili.droid.shortvideo.f.e.d.c("ShortAudioRecorderCore", "deleteLastSection -");
        return c2;
    }

    public boolean n() {
        com.qiniu.pili.droid.shortvideo.f.e.d.c("ShortAudioRecorderCore", "deleteAllSections +");
        if (this.i || this.l) {
            com.qiniu.pili.droid.shortvideo.f.e.d.d("ShortAudioRecorderCore", "cannot delete sections while working !!!");
            return false;
        }
        boolean a2 = this.r.a(true);
        Stack<Object> stack = this.C;
        if (stack != null && stack.empty()) {
            w();
        }
        if (a2 && this.A != null) {
            c(true);
        }
        com.qiniu.pili.droid.shortvideo.f.e.d.c("ShortAudioRecorderCore", "deleteAllSections -");
        return a2;
    }

    public void o() {
        com.qiniu.pili.droid.shortvideo.f.e.d.c("ShortAudioRecorderCore", "cancelConcat +");
        this.r.e();
        com.qiniu.pili.droid.shortvideo.f.e.d.c("ShortAudioRecorderCore", "cancelConcat -");
    }

    @Override // com.qiniu.pili.droid.shortvideo.PLAudioFrameListener
    public void onAudioFrameAvailable(byte[] bArr, long j) {
        if (this.g && !this.h) {
            this.h = true;
            q();
        }
        PLAudioFrameListener pLAudioFrameListener = this.b;
        if (pLAudioFrameListener != null) {
            pLAudioFrameListener.onAudioFrameAvailable(bArr, j);
        }
        if (d()) {
            if (this.G >= ((float) this.n.getMaxRecordDuration()) * 1.02f) {
                com.qiniu.pili.droid.shortvideo.f.e.d.d("ShortAudioRecorderCore", "reached the max record duration");
                c();
                t();
                return;
            }
            if (a()) {
                synchronized (this.P) {
                    a(j);
                }
            } else {
                a(j);
            }
            com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.d;
            eVar.c("ShortAudioRecorderCore", "mVideoTailMs: " + this.G + "; END: " + (((float) this.n.getMaxRecordDuration()) * 1.02f));
            this.I = j;
            PLRecordStateListener pLRecordStateListener = this.s;
            if (pLRecordStateListener != null) {
                double d = this.G;
                pLRecordStateListener.onSectionRecording((long) (d - this.H), (long) d, this.K.size() + 1);
            }
            if (!a()) {
                ByteBuffer wrap = ByteBuffer.wrap(bArr);
                this.z.c(wrap, wrap.remaining(), j / 1000);
            } else if (!this.k) {
                ByteBuffer allocateDirect = ByteBuffer.allocateDirect(bArr.length);
                this.f13869a.a(allocateDirect, allocateDirect.remaining(), 0L);
            }
        }
        if (a()) {
            synchronized (this.P) {
                if (!x()) {
                    this.P.notify();
                }
            }
        }
    }

    @Override // com.qiniu.pili.droid.shortvideo.PLAudioFrameListener
    public void onAudioRecordFailed(int i) {
        PLAudioFrameListener pLAudioFrameListener = this.b;
        if (pLAudioFrameListener != null) {
            pLAudioFrameListener.onAudioRecordFailed(i);
        }
    }

    public int p() {
        MediaPlayer mediaPlayer = this.A;
        if (mediaPlayer != null) {
            return mediaPlayer.getCurrentPosition();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void q() {
        synchronized (this) {
            if (l()) {
                this.g = false;
                com.qiniu.pili.droid.shortvideo.f.e.d.c("ShortAudioRecorderCore", "sources are set, we are ready now.");
                if (this.s != null) {
                    this.s.onReady();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void r() {
        synchronized (this) {
            if (!this.l && e()) {
                com.qiniu.pili.droid.shortvideo.f.e.n.c("ShortAudioRecorderCore", "formats are set, begin section now.");
                this.r.a(this.F);
                this.l = true;
                this.i = false;
                if (this.s != null) {
                    this.s.onRecordStarted();
                }
                if (a()) {
                    u();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void s() {
        synchronized (this) {
            this.i = false;
            if (this.l && f()) {
                com.qiniu.pili.droid.shortvideo.f.e.n.c("ShortAudioRecorderCore", "formats are unset, end section now.");
                this.r.b();
                this.l = false;
                if (this.s != null) {
                    this.s.onRecordStopped();
                }
                if (this.f13870c) {
                    this.f13870c = false;
                    this.r.a(this.e);
                }
                this.z.b();
            }
        }
    }

    public void t() {
        this.G = 0.0d;
        PLRecordStateListener pLRecordStateListener = this.s;
        if (pLRecordStateListener != null) {
            pLRecordStateListener.onRecordCompleted();
        }
        MediaPlayer mediaPlayer = this.A;
        if (mediaPlayer != null) {
            mediaPlayer.pause();
            this.D = true;
        }
    }
}
