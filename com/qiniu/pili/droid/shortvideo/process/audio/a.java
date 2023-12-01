package com.qiniu.pili.droid.shortvideo.process.audio;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.view.Surface;
import com.qiniu.pili.droid.shortvideo.PLAudioEncodeSetting;
import com.qiniu.pili.droid.shortvideo.PLComposeItem;
import com.qiniu.pili.droid.shortvideo.d.b;
import com.qiniu.pili.droid.shortvideo.encode.a;
import com.qiniu.pili.droid.shortvideo.f.e;
import com.qiniu.pili.droid.shortvideo.f.f;
import com.qiniu.pili.droid.shortvideo.f.h;
import com.qiniu.pili.droid.shortvideo.transcoder.audio.AudioMixer;
import com.qiniu.pili.droid.shortvideo.transcoder.audio.AudioTransformer;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/process/audio/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f27794a = h.a().c();
    private b D;
    private long E;
    private LinkedList<PLComposeItem> b;

    /* renamed from: c  reason: collision with root package name */
    private int f27795c;
    private int d;
    private long e;
    private int f;
    private com.qiniu.pili.droid.shortvideo.encode.c g;
    private com.qiniu.pili.droid.shortvideo.d.b h;
    private com.qiniu.pili.droid.shortvideo.d.b i;
    private long j;
    private a.InterfaceC0745a k;
    private String l;
    private AudioTransformer m;
    private ByteBuffer n;
    private MediaFormat p;
    private volatile boolean q;
    private volatile boolean r;
    private volatile AudioMixer s;
    private ByteBuffer t;
    private int u;
    private boolean v;
    private boolean x;
    private boolean z;
    private long o = 0;
    private Object w = new Object();
    private Object y = new Object();
    private Object A = new Object();
    private float B = 1.0f;
    private float C = 1.0f;
    private boolean F = false;
    private a.InterfaceC0745a G = new a.InterfaceC0745a() { // from class: com.qiniu.pili.droid.shortvideo.process.audio.a.1
        @Override // com.qiniu.pili.droid.shortvideo.encode.a.InterfaceC0745a
        public void a(MediaFormat mediaFormat) {
            if (a.this.k != null) {
                a.this.k.a(mediaFormat);
            }
        }

        @Override // com.qiniu.pili.droid.shortvideo.encode.a.InterfaceC0745a
        public void a(Surface surface) {
        }

        @Override // com.qiniu.pili.droid.shortvideo.encode.a.InterfaceC0745a
        public void a(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
            e eVar = e.t;
            eVar.b("MultiAudioComposer", "muxer write audio: " + bufferInfo.presentationTimeUs);
            if (a.this.k != null) {
                a.this.k.a(byteBuffer, bufferInfo);
            }
        }

        @Override // com.qiniu.pili.droid.shortvideo.encode.a.InterfaceC0745a
        public void a(boolean z) {
            if (z) {
                a aVar = a.this;
                aVar.a((PLComposeItem) aVar.b.poll());
            }
            if (a.this.k != null) {
                a.this.k.a(z);
            }
        }

        @Override // com.qiniu.pili.droid.shortvideo.encode.a.InterfaceC0745a
        public void b(boolean z) {
            e.t.c("MultiAudioComposer", "audio encode stopped");
            if (a.this.k != null) {
                a.this.k.b(z);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.qiniu.pili.droid.shortvideo.process.audio.a$a  reason: collision with other inner class name */
    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/process/audio/a$a.class */
    public class C0751a implements b.c {
        private long b;

        private C0751a() {
        }

        @Override // com.qiniu.pili.droid.shortvideo.d.b.c
        public void a(ByteBuffer byteBuffer, int i, long j, long j2, boolean z) {
            if (a.this.m == null) {
                e.t.d("mResampler has not been init !");
            } else if (z) {
                a.this.j += this.b + a.this.e;
                a.this.m.destroy(a.this.o);
                a.this.m = null;
                a.this.f();
            } else {
                if (a.this.n == null) {
                    a.this.n = ByteBuffer.allocateDirect(byteBuffer.capacity() * 4);
                    e.t.c("MultiAudioComposer", "init mResampledFramesBuffer with size: " + a.this.n.capacity());
                }
                a.this.n.position(a.this.n.position() + a.this.m.resample(a.this.o, byteBuffer, byteBuffer.position(), i, a.this.n, a.this.n.position(), 0));
                while (a.this.n.position() >= a.this.f) {
                    int position = a.this.n.position();
                    int i2 = a.this.f;
                    a.this.n.flip();
                    a.this.g.a(a.this.n, a.this.f, a.this.j + this.b);
                    a.this.n.clear();
                    a.this.n.put(a.this.n.array(), a.this.n.arrayOffset() + a.this.f, position - i2);
                    this.b += a.this.e;
                }
                if (a.this.q) {
                    a.this.h();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/process/audio/a$b.class */
    public class b implements b.c {
        private b() {
        }

        private void a() {
            synchronized (a.this.y) {
                a.this.x = true;
                a.this.y.notify();
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x003b A[Catch: all -> 0x0060, TRY_ENTER, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x000a, B:7:0x0018, B:9:0x0023, B:14:0x003b, B:17:0x005d, B:15:0x0047), top: B:27:0x000a }] */
        /* JADX WARN: Removed duplicated region for block: B:15:0x0047 A[Catch: all -> 0x0060, TRY_ENTER, TryCatch #0 {, blocks: (B:4:0x000a, B:7:0x0018, B:9:0x0023, B:14:0x003b, B:17:0x005d, B:15:0x0047), top: B:27:0x000a }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private boolean b() {
            /*
                r4 = this;
                r0 = r4
                com.qiniu.pili.droid.shortvideo.process.audio.a r0 = com.qiniu.pili.droid.shortvideo.process.audio.a.this
                java.lang.Object r0 = com.qiniu.pili.droid.shortvideo.process.audio.a.q(r0)
                r6 = r0
                r0 = r6
                monitor-enter(r0)
                r0 = r4
                com.qiniu.pili.droid.shortvideo.process.audio.a r0 = com.qiniu.pili.droid.shortvideo.process.audio.a.this     // Catch: java.lang.Throwable -> L60
                com.qiniu.pili.droid.shortvideo.encode.c r0 = com.qiniu.pili.droid.shortvideo.process.audio.a.n(r0)     // Catch: java.lang.Throwable -> L60
                boolean r0 = r0.l()     // Catch: java.lang.Throwable -> L60
                if (r0 == 0) goto L35
            L17:
                r0 = r4
                com.qiniu.pili.droid.shortvideo.process.audio.a r0 = com.qiniu.pili.droid.shortvideo.process.audio.a.this     // Catch: java.lang.Throwable -> L60
                boolean r0 = com.qiniu.pili.droid.shortvideo.process.audio.a.w(r0)     // Catch: java.lang.Throwable -> L60
                r5 = r0
                r0 = r5
                if (r0 != 0) goto L30
                r0 = r4
                com.qiniu.pili.droid.shortvideo.process.audio.a r0 = com.qiniu.pili.droid.shortvideo.process.audio.a.this     // Catch: java.lang.Throwable -> L60 java.lang.InterruptedException -> L65
                java.lang.Object r0 = com.qiniu.pili.droid.shortvideo.process.audio.a.q(r0)     // Catch: java.lang.Throwable -> L60 java.lang.InterruptedException -> L65
                r0.wait()     // Catch: java.lang.Throwable -> L60 java.lang.InterruptedException -> L65
                goto L17
            L30:
                r0 = 1
                r5 = r0
                goto L37
            L35:
                r0 = 0
                r5 = r0
            L37:
                r0 = r5
                if (r0 == 0) goto L47
                r0 = r4
                com.qiniu.pili.droid.shortvideo.process.audio.a r0 = com.qiniu.pili.droid.shortvideo.process.audio.a.this     // Catch: java.lang.Throwable -> L60
                r1 = 0
                boolean r0 = com.qiniu.pili.droid.shortvideo.process.audio.a.b(r0, r1)     // Catch: java.lang.Throwable -> L60
                goto L5c
            L47:
                com.qiniu.pili.droid.shortvideo.f.e r0 = com.qiniu.pili.droid.shortvideo.f.e.s     // Catch: java.lang.Throwable -> L60
                java.lang.String r1 = "MultiAudioComposer"
                java.lang.String r2 = "src audio eof, so stop music audio too."
                r0.c(r1, r2)     // Catch: java.lang.Throwable -> L60
                r0 = r4
                com.qiniu.pili.droid.shortvideo.process.audio.a r0 = com.qiniu.pili.droid.shortvideo.process.audio.a.this     // Catch: java.lang.Throwable -> L60
                com.qiniu.pili.droid.shortvideo.d.b r0 = com.qiniu.pili.droid.shortvideo.process.audio.a.x(r0)     // Catch: java.lang.Throwable -> L60
                boolean r0 = r0.c()     // Catch: java.lang.Throwable -> L60
            L5c:
                r0 = r6
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L60
                r0 = r5
                return r0
            L60:
                r7 = move-exception
                r0 = r6
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L60
                r0 = r7
                throw r0
            L65:
                r7 = move-exception
                goto L35
            */
            throw new UnsupportedOperationException("Method not decompiled: com.qiniu.pili.droid.shortvideo.process.audio.a.b.b():boolean");
        }

        @Override // com.qiniu.pili.droid.shortvideo.d.b.c
        public void a(ByteBuffer byteBuffer, int i, long j, long j2, boolean z) {
            if (a.this.q) {
                a.this.h();
            } else if (z) {
                a.this.f();
            } else if (a.this.F || b()) {
                while (a.this.s.a(a.this.t, a.this.u)) {
                    a();
                    b();
                }
                a.this.s.b(byteBuffer, i);
                a.this.F = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/process/audio/a$c.class */
    public class c implements b.c {
        private c() {
        }

        private void a() {
            synchronized (a.this.w) {
                a.this.v = true;
                a.this.w.notify();
            }
        }

        private void b() {
            synchronized (a.this.y) {
                while (!a.this.x) {
                    try {
                        a.this.y.wait();
                    } catch (InterruptedException e) {
                        return;
                    }
                }
                a.this.x = false;
            }
        }

        @Override // com.qiniu.pili.droid.shortvideo.d.b.c
        public void a(ByteBuffer byteBuffer, int i, long j, long j2, boolean z) {
            if (!z) {
                a.this.t = byteBuffer;
                a.this.u = i;
                a();
                b();
                a.this.g.a(byteBuffer, i, j);
                a.this.E = j;
                return;
            }
            while (a.this.g.l()) {
                ByteBuffer allocateDirect = ByteBuffer.allocateDirect(a.this.f);
                a.this.t = allocateDirect;
                a.this.u = allocateDirect.capacity();
                a();
                b();
                a.this.E += a.this.e;
                a.this.g.a(a.this.t, a.this.u, a.this.E);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/process/audio/a$d.class */
    public class d implements b.d {
        private d() {
        }

        @Override // com.qiniu.pili.droid.shortvideo.d.b.d
        public void a(MediaFormat mediaFormat) {
            e eVar = e.t;
            eVar.c("MultiAudioComposer", "got src audio decoder format: " + mediaFormat);
            if (!a.this.e()) {
                a.this.b(mediaFormat.getInteger(MediaFormat.KEY_SAMPLE_RATE), mediaFormat.getInteger(MediaFormat.KEY_CHANNEL_COUNT), a.this.f27795c, a.this.d);
                return;
            }
            a aVar = a.this;
            aVar.a(aVar.f27795c, a.this.d, mediaFormat.getInteger(MediaFormat.KEY_SAMPLE_RATE), mediaFormat.getInteger(MediaFormat.KEY_CHANNEL_COUNT));
        }
    }

    public a(List<PLComposeItem> list) {
        this.b = new LinkedList<>(list);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.b.size()) {
                return;
            }
            if (this.b.get(i2).getItemType() == PLComposeItem.ItemType.VIDEO) {
                f fVar = new f(this.b.get(i2).getFilePath(), false, true);
                if (fVar.f() != null) {
                    this.p = fVar.f();
                    this.f27795c = fVar.o();
                    this.d = fVar.n();
                    fVar.a();
                    e eVar = e.t;
                    eVar.c("MultiAudioComposer", "found output audio format: " + this.p + " in file: " + this.b.get(i2).getFilePath());
                    return;
                }
                fVar.a();
            }
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, int i3, int i4) {
        if (this.s != null) {
            this.s.a();
        }
        this.s = new AudioMixer();
        this.s.a(this.C, this.B);
        this.s.a(i, i2, i3, i4);
        e eVar = e.t;
        eVar.c("MultiAudioComposer", "setupAudioMixer : mainSampleRate " + i + " mainChannels " + i2 + " otherSampleRate " + i3 + " otherChannels " + i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final PLComposeItem pLComposeItem) {
        e eVar = e.t;
        eVar.c("MultiAudioComposer", "compose audio + " + pLComposeItem.getFilePath());
        if (e() && this.i == null) {
            a((b.d) null, new c());
        }
        f fVar = new f(pLComposeItem.getFilePath(), false, true);
        if (fVar.f() != null) {
            b(pLComposeItem);
        } else {
            new Thread(new Runnable() { // from class: com.qiniu.pili.droid.shortvideo.process.audio.a.2
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.e()) {
                        a.this.d(pLComposeItem);
                    } else {
                        a.this.c(pLComposeItem);
                    }
                }
            }).start();
        }
        fVar.a();
        e.t.c("MultiAudioComposer", "compose audio -");
    }

    private void a(b.d dVar, b.c cVar) {
        f fVar = new f(this.l, false, true);
        if (fVar.f() != null) {
            com.qiniu.pili.droid.shortvideo.d.b bVar = new com.qiniu.pili.droid.shortvideo.d.b(fVar.d(), fVar.f());
            this.i = bVar;
            if (cVar != null) {
                bVar.a(cVar);
            }
            if (dVar != null) {
                this.i.a(dVar);
            }
            this.i.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2, int i3, int i4) {
        AudioTransformer audioTransformer = new AudioTransformer();
        this.m = audioTransformer;
        this.o = audioTransformer.init(i, i2, 16, i3, i4, 16);
    }

    private void b(PLComposeItem pLComposeItem) {
        f fVar = new f(pLComposeItem.getFilePath(), false, true);
        if (fVar.f() == null) {
            e eVar = e.t;
            eVar.c("MultiAudioComposer", "the item has no audio format, do not need startSrcExtractor ! item path is : " + pLComposeItem.getFilePath());
            return;
        }
        this.h = new com.qiniu.pili.droid.shortvideo.d.b(fVar.d(), fVar.f());
        if (e()) {
            b bVar = new b();
            this.D = bVar;
            this.h.a(bVar);
        } else {
            this.h.a(new C0751a());
        }
        this.h.a(new d());
        this.h.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(PLComposeItem pLComposeItem) {
        long j;
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(this.f);
        long durationMs = pLComposeItem.getDurationMs();
        long j2 = 0;
        while (true) {
            j = j2;
            if (j >= durationMs * 1000 || this.q) {
                break;
            }
            this.g.a(allocateDirect, allocateDirect.remaining(), this.j + j);
            allocateDirect.clear();
            j2 = j + this.e;
        }
        if (this.q) {
            h();
            return;
        }
        this.j += j;
        f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(PLComposeItem pLComposeItem) {
        int i = this.f27795c;
        int i2 = this.d;
        a(i, i2, i, i2);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(this.f);
        long durationMs = pLComposeItem.getDurationMs();
        if (this.D == null) {
            this.D = new b();
        }
        long j = 0;
        while (true) {
            long j2 = j;
            if (j2 >= durationMs * 1000 || this.q) {
                break;
            }
            this.D.a(allocateDirect, allocateDirect.capacity(), 0L, 0L, false);
            j = j2 + this.e;
        }
        this.D.a(allocateDirect, allocateDirect.capacity(), 0L, 0L, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e() {
        return this.l != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (this.b.isEmpty()) {
            this.g.c();
        } else {
            a(this.b.poll());
        }
    }

    private boolean g() {
        a(new b.d() { // from class: com.qiniu.pili.droid.shortvideo.process.audio.a.3
            @Override // com.qiniu.pili.droid.shortvideo.d.b.d
            public void a(MediaFormat mediaFormat) {
                e eVar = e.t;
                eVar.c("MultiAudioComposer", "got music decoder format: " + mediaFormat);
                a.this.p = mediaFormat;
                a.this.f27795c = mediaFormat.getInteger(MediaFormat.KEY_SAMPLE_RATE);
                a.this.d = mediaFormat.getInteger(MediaFormat.KEY_CHANNEL_COUNT);
                synchronized (a.this.A) {
                    a.this.z = true;
                    a.this.A.notify();
                }
            }
        }, (b.c) null);
        synchronized (this.A) {
            while (!this.z) {
                try {
                    this.A.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    return false;
                }
            }
        }
        this.i.c();
        this.i = null;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        com.qiniu.pili.droid.shortvideo.d.b bVar = this.h;
        if (bVar != null) {
            bVar.c();
        }
        com.qiniu.pili.droid.shortvideo.d.b bVar2 = this.i;
        if (bVar2 != null) {
            bVar2.c();
        }
        com.qiniu.pili.droid.shortvideo.encode.c cVar = this.g;
        if (cVar != null) {
            cVar.c();
        }
    }

    public void a(float f, float f2) {
        this.B = f;
        this.C = f2;
    }

    public void a(a.InterfaceC0745a interfaceC0745a) {
        this.k = interfaceC0745a;
    }

    public void a(String str) {
        if (str == null) {
            e.t.e("MultiAudioComposer", "setAudioMixFile error, the audio mix file can not be null !");
            return;
        }
        f fVar = new f(str, false, true);
        if (fVar.f() != null) {
            this.l = str;
            this.p = fVar.f();
            e eVar = e.t;
            eVar.c("MultiAudioComposer", "setAudioMixFile the mix file is : " + this.l);
        } else {
            e eVar2 = e.t;
            eVar2.e("MultiAudioComposer", "setAudioMixFile error, there is no audio format can be found! the file is : " + str);
        }
        fVar.a();
    }

    public boolean a() {
        synchronized (this) {
            this.r = false;
            if (this.p != null && f27794a) {
                if (e() && !g()) {
                    return false;
                }
                this.f = 2048 * this.d;
                this.e = (long) ((1024 * 1000000.0d) / this.f27795c);
                PLAudioEncodeSetting pLAudioEncodeSetting = new PLAudioEncodeSetting();
                pLAudioEncodeSetting.setChannels(this.d);
                pLAudioEncodeSetting.setSampleRate(this.f27795c);
                com.qiniu.pili.droid.shortvideo.encode.c cVar = new com.qiniu.pili.droid.shortvideo.encode.c(pLAudioEncodeSetting);
                this.g = cVar;
                cVar.a(this.G);
                this.g.a();
                this.r = true;
            }
            return this.r;
        }
    }

    public void b() {
        synchronized (this) {
            if (this.r) {
                this.q = true;
                e.t.c("MultiAudioComposer", "cancel compose");
            } else {
                e.t.d("MultiAudioComposer", "cancel compose failed");
            }
        }
    }

    public void c() {
        synchronized (this) {
            e.t.e("MultiAudioComposer", "destroy +");
            if (this.m != null) {
                this.m.destroy(this.o);
                this.m = null;
            }
            if (this.s != null) {
                this.s.a();
            }
            this.f27795c = 0;
            this.d = 0;
            this.e = 0L;
            this.f = 0;
            this.b = null;
            this.h = null;
            this.i = null;
            this.n = null;
            this.o = 0L;
            this.j = 0L;
            this.g = null;
            this.l = null;
            this.p = null;
            this.q = false;
            this.r = false;
            this.s = null;
            this.t = null;
            this.u = 0;
            this.v = false;
            this.x = false;
            this.z = false;
            e.t.e("MultiAudioComposer", "destroy -");
        }
    }

    public boolean d() {
        return this.r;
    }
}
