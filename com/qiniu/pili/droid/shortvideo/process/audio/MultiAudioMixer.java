package com.qiniu.pili.droid.shortvideo.process.audio;

import com.qiniu.pili.droid.shortvideo.PLMixAudioFile;
import com.qiniu.pili.droid.shortvideo.f.e;
import com.qiniu.pili.droid.shortvideo.f.h;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/process/audio/MultiAudioMixer.class */
public class MultiAudioMixer implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f14098a = h.a().c();
    private ArrayList<PLMixAudioFile> b;

    /* renamed from: c  reason: collision with root package name */
    private a f14099c;
    private volatile long g;
    private long mMixerId = 0;
    private volatile boolean d = false;
    private volatile boolean e = false;
    private volatile boolean f = false;

    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/process/audio/MultiAudioMixer$a.class */
    public interface a {
        void a();

        void a(int i);

        void a(byte[] bArr, long j);
    }

    private static void a(a aVar) {
        e.q.c("MultiAudioMixer", "onAudioMixCompleted !");
        if (aVar != null) {
            aVar.a();
        }
    }

    private static void a(a aVar, int i) {
        e eVar = e.q;
        eVar.e("MultiAudioMixer", "onAudioMixFailed: " + i);
        if (aVar != null) {
            aVar.a(i);
        }
    }

    private static void a(a aVar, byte[] bArr, long j) {
        e eVar = e.q;
        eVar.a("MultiAudioMixer", "onAudioMixed: " + j);
        if (aVar != null) {
            aVar.a(bArr, j);
        }
    }

    private void a(ByteBuffer[] byteBufferArr, float[] fArr, long j) {
        byte[] mix = mix(byteBufferArr, fArr);
        if (mix != null) {
            a(this.f14099c, mix, j);
        }
    }

    private void b(long j) {
        ByteBuffer[] byteBufferArr;
        float[] fArr;
        e.q.b("MultiAudioMixer", "doAudioMixing +");
        ArrayList<PLMixAudioFile> c2 = c(j);
        if (j >= this.g * 1000) {
            this.f = true;
            a(this.f14099c);
            return;
        }
        if (c2.isEmpty()) {
            byteBufferArr = new ByteBuffer[]{ByteBuffer.allocateDirect(2048)};
            fArr = new float[]{0.0f};
        } else {
            byteBufferArr = new ByteBuffer[c2.size()];
            fArr = new float[c2.size()];
            for (int i = 0; i < c2.size(); i++) {
                byteBufferArr[i] = c2.get(i).e();
                fArr[i] = c2.get(i).getVolume();
            }
        }
        a(byteBufferArr, fArr, j);
        e.q.b("MultiAudioMixer", "doAudioMixing -");
    }

    private boolean b() {
        return this.g > 0;
    }

    private ArrayList<PLMixAudioFile> c(long j) {
        ArrayList<PLMixAudioFile> arrayList = new ArrayList<>();
        Iterator<PLMixAudioFile> it = this.b.iterator();
        while (it.hasNext()) {
            PLMixAudioFile next = it.next();
            if (next.a(j) && !next.b().c() && next.b().a(next.e()) > 0) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    private void c() {
        e.q.c("MultiAudioMixer", "triggerAudioResample +");
        Iterator<PLMixAudioFile> it = this.b.iterator();
        while (it.hasNext()) {
            PLMixAudioFile next = it.next();
            next.b().a(next.getFilepath(), next.getStartTime(), next.getEndTime(), 44100, 1, 2048);
        }
        init(2048);
        e.q.c("MultiAudioMixer", "triggerAudioResample -");
    }

    private void d() {
        e.q.c("MultiAudioMixer", "releaseAudioResample +");
        Iterator<PLMixAudioFile> it = this.b.iterator();
        while (it.hasNext()) {
            PLMixAudioFile next = it.next();
            if (this.e) {
                next.d();
            } else {
                next.c();
            }
        }
        release();
        e.q.c("MultiAudioMixer", "releaseAudioResample -");
    }

    private void e() {
        long j = 0;
        while (true) {
            long j2 = j;
            if (this.e || this.f) {
                return;
            }
            b(j2);
            j = j2 + 23219;
        }
    }

    private void f() {
        while (!this.e && !this.f) {
            g();
        }
    }

    private void g() {
        e.q.b("MultiAudioMixer", "doAudioMixing +");
        long d = this.b.get(0).b().d();
        ArrayList<PLMixAudioFile> c2 = c(d);
        if (this.b.get(0).b().c() || c2.isEmpty() || !c2.contains(this.b.get(0))) {
            this.f = true;
            a(this.f14099c);
            return;
        }
        ByteBuffer[] byteBufferArr = new ByteBuffer[c2.size()];
        float[] fArr = new float[c2.size()];
        for (int i = 0; i < c2.size(); i++) {
            byteBufferArr[i] = c2.get(i).e();
            fArr[i] = c2.get(i).getVolume();
        }
        a(byteBufferArr, fArr, d);
        e.q.b("MultiAudioMixer", "doAudioMixing -");
    }

    private native boolean init(int i);

    private native byte[] mix(ByteBuffer[] byteBufferArr, float[] fArr);

    private native boolean release();

    public void a() {
        e.q.c("MultiAudioMixer", "cancel +");
        this.e = true;
        e.q.c("MultiAudioMixer", "cancel -");
    }

    public void a(long j) {
        this.g = j;
    }

    public void a(List<PLMixAudioFile> list, a aVar) {
        if (!f14098a) {
            e.r.c("can't found pldroid_amix.so !");
            a(aVar, 12);
            return;
        }
        e.q.c("MultiAudioMixer", "mix +");
        if (this.d) {
            e.q.e("MultiAudioMixer", "mix already started");
            a(aVar, 1);
        } else if (list == null || (list.size() < 2 && !b())) {
            e.q.e("MultiAudioMixer", "invalid params !");
            a(aVar, 10);
        } else {
            this.b = new ArrayList<>(list);
            this.f14099c = aVar;
            this.e = false;
            this.f = false;
            new Thread(this).start();
            e.q.c("MultiAudioMixer", "mix -");
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        e.q.c("MultiAudioMixer", "run +");
        this.d = true;
        c();
        if (b()) {
            e();
        } else {
            f();
        }
        d();
        if (this.e) {
            a(this.f14099c);
        }
        this.d = false;
        this.e = false;
        e.q.c("MultiAudioMixer", "run -");
    }
}
