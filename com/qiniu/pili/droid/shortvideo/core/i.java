package com.qiniu.pili.droid.shortvideo.core;

import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Build;
import com.qiniu.pili.droid.shortvideo.PLAudioEncodeSetting;
import com.qiniu.pili.droid.shortvideo.PLCameraSetting;
import com.qiniu.pili.droid.shortvideo.PLFaceBeautySetting;
import com.qiniu.pili.droid.shortvideo.PLMicrophoneSetting;
import com.qiniu.pili.droid.shortvideo.PLRecordSetting;
import com.qiniu.pili.droid.shortvideo.PLVideoEncodeSetting;
import com.qiniu.pili.droid.shortvideo.PLVideoSaveListener;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.Stack;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/core/i.class */
public class i {

    /* renamed from: a  reason: collision with root package name */
    private com.qiniu.pili.droid.shortvideo.muxer.b f27554a;
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private Stack<h> f27555c;
    private h d;
    private File e;
    private MediaFormat f;
    private MediaFormat g;
    private volatile boolean h;
    private PLRecordSetting i;
    private PLVideoEncodeSetting j;
    private PLAudioEncodeSetting k;
    private long l;
    private long m;
    private int n;
    private int o;
    private long p;
    private long q;
    private a r;
    private PLVideoSaveListener s;
    private volatile boolean t;
    private String u;
    private double v;
    private long w;

    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/core/i$a.class */
    public interface a {
        void a(long j, long j2, int i);

        void b(long j, long j2, int i);

        void i();
    }

    public i(Context context, PLRecordSetting pLRecordSetting, PLAudioEncodeSetting pLAudioEncodeSetting) {
        this.f27555c = new Stack<>();
        this.h = false;
        this.l = 0L;
        this.m = 0L;
        this.p = -1L;
        this.q = -1L;
        this.u = null;
        this.v = 1.0d;
        this.b = context.getApplicationContext();
        this.i = pLRecordSetting;
        this.k = pLAudioEncodeSetting;
        File videoCacheDir = pLRecordSetting.getVideoCacheDir();
        this.e = videoCacheDir;
        if (videoCacheDir == null || (!videoCacheDir.exists() && !this.e.mkdirs())) {
            this.e = context.getFilesDir();
        }
        if (this.i.getVideoFilepath() != null) {
            PLRecordSetting pLRecordSetting2 = this.i;
            pLRecordSetting2.setVideoFilepath(l.a(context, pLRecordSetting2.getVideoFilepath()));
            return;
        }
        File file = this.e;
        this.i.setVideoFilepath(new File(file, "pl-concated-" + System.currentTimeMillis() + ".mp4").getAbsolutePath());
    }

    public i(Context context, PLRecordSetting pLRecordSetting, PLAudioEncodeSetting pLAudioEncodeSetting, PLVideoEncodeSetting pLVideoEncodeSetting) {
        this(context, pLRecordSetting, pLAudioEncodeSetting);
        this.j = pLVideoEncodeSetting;
    }

    private MediaFormat a(MediaExtractor mediaExtractor, String str) {
        int trackCount = mediaExtractor.getTrackCount();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= trackCount) {
                return null;
            }
            MediaFormat trackFormat = mediaExtractor.getTrackFormat(i2);
            if (trackFormat.getString(MediaFormat.KEY_MIME).startsWith(str)) {
                return trackFormat;
            }
            i = i2 + 1;
        }
    }

    private boolean a(h hVar) {
        MediaExtractor mediaExtractor = new MediaExtractor();
        try {
            mediaExtractor.setDataSource(hVar.f27552a.getAbsolutePath());
            MediaFormat a2 = a(mediaExtractor, "audio/");
            MediaFormat a3 = a(mediaExtractor, "video/");
            if (a2 == null) {
                com.qiniu.pili.droid.shortvideo.f.e.d.e("SectionManager", "Cannot get media format on recoverFromDraft");
                return false;
            }
            b(a2);
            if (h() && a3 == null) {
                com.qiniu.pili.droid.shortvideo.f.e.d.e("SectionManager", "Cannot get media format on recoverFromDraft");
                return false;
            }
            a(a3);
            return true;
        } catch (IOException e) {
            com.qiniu.pili.droid.shortvideo.f.e.d.e("SectionManager", "Invalid data source");
            return false;
        }
    }

    private void b(long j) {
        if (this.p == -1) {
            this.p = j;
        }
        if (j > this.q) {
            this.q = j;
        }
    }

    private long g() {
        int i;
        int samplerate;
        if (h()) {
            i = 1000;
            samplerate = this.j.getVideoEncodingFps();
        } else {
            i = 1024000;
            samplerate = this.k.getSamplerate();
        }
        return i / samplerate;
    }

    private boolean h() {
        return this.j != null;
    }

    private int i() {
        if (h()) {
            return this.j.getRotationInMetadata();
        }
        return 0;
    }

    public void a(double d) {
        this.v = d;
    }

    public void a(long j) {
        this.w = j;
    }

    public void a(MediaFormat mediaFormat) {
        this.g = mediaFormat;
    }

    public void a(PLVideoSaveListener pLVideoSaveListener) {
        synchronized (this) {
            this.t = false;
            this.s = pLVideoSaveListener;
            new Thread(new Runnable() { // from class: com.qiniu.pili.droid.shortvideo.core.i.1
                @Override // java.lang.Runnable
                public void run() {
                    i.this.f();
                }
            }).start();
        }
    }

    public void a(a aVar) {
        this.r = aVar;
    }

    public void a(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        synchronized (this) {
            if (this.h) {
                com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.n;
                eVar.b("SectionManager", "video write to muxer size:" + bufferInfo.size + " ts:" + bufferInfo.presentationTimeUs);
                b(bufferInfo.presentationTimeUs / 1000);
                this.f27554a.a(byteBuffer, bufferInfo);
                h hVar = this.d;
                hVar.g = hVar.g + 1;
            }
        }
    }

    public boolean a() {
        if (this.f != null) {
            return (this.g == null && h()) ? false : true;
        }
        return false;
    }

    public boolean a(com.qiniu.pili.droid.shortvideo.f.b bVar) {
        this.u = bVar.a();
        Stack<h> b = bVar.b();
        this.f27555c = b;
        Iterator<h> it = b.iterator();
        while (it.hasNext()) {
            if (!it.next().f27552a.exists()) {
                this.f27555c.clear();
                return false;
            }
        }
        h lastElement = this.f27555c.lastElement();
        this.d = lastElement;
        if (!a(lastElement)) {
            this.f27555c.clear();
            this.d = null;
            return false;
        }
        Iterator<h> it2 = this.f27555c.iterator();
        while (it2.hasNext()) {
            this.m += it2.next().e;
        }
        this.i = bVar.h();
        this.j = bVar.e();
        return true;
    }

    public boolean a(String str) {
        synchronized (this) {
            if (this.h) {
                com.qiniu.pili.droid.shortvideo.f.e.n.e("SectionManager", "begin section failed, in working state");
                return false;
            }
            com.qiniu.pili.droid.shortvideo.f.e.n.c("SectionManager", "begin section +");
            if (!a()) {
                com.qiniu.pili.droid.shortvideo.f.e.n.e("SectionManager", "beginSection failed, format not set !");
                return false;
            }
            long currentTimeMillis = System.currentTimeMillis();
            File file = this.e;
            if (str == null) {
                str = "pl-section-" + currentTimeMillis + ".mp4";
            }
            File file2 = new File(file, str);
            com.qiniu.pili.droid.shortvideo.muxer.b bVar = new com.qiniu.pili.droid.shortvideo.muxer.b();
            this.f27554a = bVar;
            if (!bVar.a(file2.getAbsolutePath(), this.g, this.f, i())) {
                com.qiniu.pili.droid.shortvideo.f.e.n.e("SectionManager", "beginSection failed, start failed !");
                return false;
            }
            h hVar = new h();
            this.d = hVar;
            hVar.f27552a = file2;
            this.d.f27553c = this.f27554a.b();
            this.d.b = this.f27554a.c();
            this.h = true;
            com.qiniu.pili.droid.shortvideo.f.e.n.c("SectionManager", "begin section - " + file2);
            return true;
        }
    }

    public boolean a(String str, PLCameraSetting pLCameraSetting, PLMicrophoneSetting pLMicrophoneSetting, PLVideoEncodeSetting pLVideoEncodeSetting, PLAudioEncodeSetting pLAudioEncodeSetting, PLFaceBeautySetting pLFaceBeautySetting, PLRecordSetting pLRecordSetting) {
        if (this.f27555c.size() == 0 || str == null || str.isEmpty()) {
            return false;
        }
        this.u = str;
        com.qiniu.pili.droid.shortvideo.f.b bVar = new com.qiniu.pili.droid.shortvideo.f.b(str);
        bVar.a(str);
        bVar.a(this.f27555c);
        bVar.a(pLCameraSetting);
        bVar.a(pLMicrophoneSetting);
        bVar.a(pLVideoEncodeSetting);
        bVar.a(pLAudioEncodeSetting);
        bVar.a(pLFaceBeautySetting);
        bVar.a(pLRecordSetting);
        return com.qiniu.pili.droid.shortvideo.f.c.a(this.b).a(bVar);
    }

    public boolean a(boolean z) {
        synchronized (this) {
            if (this.h) {
                com.qiniu.pili.droid.shortvideo.f.e.n.d("SectionManager", "mIsWorking, cannot delete !!!");
                return false;
            }
            Stack<h> stack = this.u == null ? new Stack<>() : com.qiniu.pili.droid.shortvideo.f.c.a(this.b).a(this.u).b();
            com.qiniu.pili.droid.shortvideo.f.e.n.c("SectionManager", "clear sections +");
            Iterator<h> it = this.f27555c.iterator();
            while (it.hasNext()) {
                h next = it.next();
                if (!stack.contains(next)) {
                    if (next.f27552a.delete()) {
                        com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.n;
                        eVar.c("SectionManager", "deleted section:" + next.f27552a);
                    } else {
                        com.qiniu.pili.droid.shortvideo.f.e eVar2 = com.qiniu.pili.droid.shortvideo.f.e.n;
                        eVar2.e("SectionManager", "deleted section failed:" + next.f27552a);
                    }
                }
            }
            this.f27555c.clear();
            if (z && this.r != null) {
                this.r.b(this.l, 0L, 0);
            }
            this.l = 0L;
            com.qiniu.pili.droid.shortvideo.f.e.n.c("SectionManager", "clear sections -");
            return true;
        }
    }

    public void b(MediaFormat mediaFormat) {
        this.f = mediaFormat;
    }

    public void b(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        synchronized (this) {
            if (this.h) {
                com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.n;
                eVar.b("SectionManager", "audio write to muxer size:" + bufferInfo.size + " ts:" + bufferInfo.presentationTimeUs);
                b(bufferInfo.presentationTimeUs / 1000);
                this.f27554a.b(byteBuffer, bufferInfo);
                h hVar = this.d;
                hVar.f = hVar.f + 1;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0111 A[Catch: all -> 0x0132, TryCatch #0 {, blocks: (B:4:0x0002, B:6:0x0009, B:9:0x0013, B:11:0x001d, B:13:0x0027, B:16:0x0031, B:20:0x003f, B:22:0x00e1, B:27:0x011b, B:23:0x00ff, B:25:0x0111, B:31:0x0123), top: B:42:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean b() {
        /*
            Method dump skipped, instructions count: 321
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiniu.pili.droid.shortvideo.core.i.b():boolean");
    }

    public boolean c() {
        synchronized (this) {
            if (this.h) {
                com.qiniu.pili.droid.shortvideo.f.e.n.d("SectionManager", "mIsWorking, cannot delete !!!");
                return false;
            } else if (this.f27555c.isEmpty()) {
                com.qiniu.pili.droid.shortvideo.f.e.n.e("SectionManager", "no sections, delete failed !");
                return false;
            } else {
                h pop = this.f27555c.pop();
                if (pop.f27552a.delete()) {
                    com.qiniu.pili.droid.shortvideo.f.e.n.c("SectionManager", "deleted section: " + pop.f27552a + ", " + pop.e + "Ms");
                } else {
                    com.qiniu.pili.droid.shortvideo.f.e.n.e("SectionManager", "deleted section failed:" + pop.f27552a);
                }
                this.l -= pop.e;
                if (this.r != null) {
                    this.r.b(pop.e, this.l, this.f27555c.size());
                }
                return true;
            }
        }
    }

    public long d() {
        return (this.q - this.p) + g();
    }

    public void e() {
        synchronized (this) {
            this.t = true;
        }
    }

    public void f() {
        long j;
        long j2;
        StringBuilder sb;
        synchronized (this) {
            if (this.f27555c.isEmpty()) {
                com.qiniu.pili.droid.shortvideo.f.e.n.d("SectionManager", "no section exist to concat");
                if (this.s != null) {
                    this.s.onSaveVideoFailed(2);
                    QosManager.a().a(2);
                }
                return;
            }
            String videoFilepath = this.i.getVideoFilepath();
            com.qiniu.pili.droid.shortvideo.f.e.n.c("SectionManager", "concat sections + to: " + videoFilepath);
            com.qiniu.pili.droid.shortvideo.muxer.b bVar = new com.qiniu.pili.droid.shortvideo.muxer.b();
            bVar.a(videoFilepath, this.g, this.f, i());
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(2097152);
            this.n = 0;
            this.o = 0;
            long j3 = 0;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.f27555c.size()) {
                    if (this.s != null) {
                        this.s.onProgressUpdate(1.0f);
                    }
                    if (bVar.a()) {
                        if (this.s != null) {
                            this.s.onSaveVideoSuccess(videoFilepath);
                        }
                    } else if (this.s != null) {
                        this.s.onSaveVideoFailed(0);
                        QosManager.a().a(0);
                    }
                    com.qiniu.pili.droid.shortvideo.f.e.n.c("SectionManager", "concat sections - total transferred audio frames: " + this.n + " video frames: " + this.o);
                    return;
                }
                h hVar = this.f27555c.get(i2);
                com.qiniu.pili.droid.shortvideo.f.e.n.c("SectionManager", "concating section:" + hVar.f27552a);
                MediaExtractor mediaExtractor = new MediaExtractor();
                try {
                    mediaExtractor.setDataSource(hVar.f27552a.getAbsolutePath());
                    int i3 = 0;
                    while (true) {
                        int i4 = i3;
                        if (i4 >= mediaExtractor.getTrackCount()) {
                            break;
                        }
                        String string = mediaExtractor.getTrackFormat(i4).getString(MediaFormat.KEY_MIME);
                        if (string.startsWith("video")) {
                            hVar.f27553c = i4;
                        } else if (string.startsWith("audio")) {
                            hVar.b = i4;
                        } else {
                            com.qiniu.pili.droid.shortvideo.f.e.n.d("SectionManager", "Unknown mimeType in section " + i2);
                        }
                        i3 = i4 + 1;
                    }
                    mediaExtractor.selectTrack(hVar.b);
                    if (hVar.f27553c >= 0) {
                        mediaExtractor.selectTrack(hVar.f27553c);
                    }
                    j = j3;
                    j2 = -1;
                } catch (IOException e) {
                    com.qiniu.pili.droid.shortvideo.f.e.n.e("SectionManager", e.getMessage());
                }
                while (!this.t) {
                    int readSampleData = mediaExtractor.readSampleData(allocateDirect, 0);
                    com.qiniu.pili.droid.shortvideo.f.e.n.b("SectionManager", "read sample size:" + readSampleData);
                    if (readSampleData < 0) {
                        com.qiniu.pili.droid.shortvideo.f.e.n.c("SectionManager", "EOF, no more encoded samples.");
                    } else {
                        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
                        bufferInfo.presentationTimeUs = mediaExtractor.getSampleTime() + j;
                        bufferInfo.flags = mediaExtractor.getSampleFlags();
                        bufferInfo.offset = 0;
                        bufferInfo.size = readSampleData;
                        if (Build.VERSION.SDK_INT >= 21) {
                            allocateDirect.position(0);
                        }
                        j2 = bufferInfo.presentationTimeUs;
                        if (((float) j2) < ((float) ((this.m + this.w) * 1000)) * 1.01f) {
                            boolean z = mediaExtractor.getSampleTrackIndex() == hVar.f27553c;
                            bVar.a(z ? bVar.b() : bVar.c(), allocateDirect, bufferInfo);
                            if (this.s != null && (z || !h())) {
                                this.s.onProgressUpdate((((float) bufferInfo.presentationTimeUs) / 1000.0f) / ((float) this.l));
                            }
                            mediaExtractor.advance();
                            com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.n;
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("transferred ");
                            if (z) {
                                sb = new StringBuilder();
                                int i5 = this.o + 1;
                                this.o = i5;
                                sb.append(i5);
                                sb.append("th video");
                            } else {
                                sb = new StringBuilder();
                                int i6 = this.n + 1;
                                this.n = i6;
                                sb.append(i6);
                                sb.append("th audio");
                            }
                            sb2.append(sb.toString());
                            eVar.b("SectionManager", sb2.toString());
                        }
                    }
                    long g = g();
                    Long.signum(g);
                    mediaExtractor.release();
                    j3 = j2 + (g * 1000);
                    i = i2 + 1;
                }
                com.qiniu.pili.droid.shortvideo.f.e.n.c("SectionManager", "concat canceled");
                mediaExtractor.release();
                bVar.a();
                new File(videoFilepath).delete();
                if (this.s != null) {
                    this.s.onSaveVideoCanceled();
                }
                return;
            }
        }
    }
}
