package com.tencent.liteav.videoproducer.encoder;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.SystemClock;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.tencent.liteav.base.storage.PersistStorage;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videobase.common.EncodedVideoFrame;
import com.tencent.liteav.videobase.videobase.IVideoReporter;
import com.tencent.liteav.videoproducer.encoder.bf;
import com.tencent.liteav.videoproducer.producer.ServerVideoProducerConfig;
import com.tencent.liteav.videoproducer.producer.VideoProducerDef;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/encoder/x.class */
public final class x {

    /* renamed from: a  reason: collision with root package name */
    String f37043a;
    final Bundle b;

    /* renamed from: c  reason: collision with root package name */
    com.tencent.liteav.base.util.b f37044c;
    MediaCodec d;
    bf.a e;
    VideoEncodeParams f;
    ServerVideoProducerConfig i;
    private final IVideoReporter o;
    private final VideoProducerDef.StreamType p;
    private byte[] q = null;
    private boolean r = true;
    long g = 0;
    com.tencent.liteav.base.util.r h = null;
    private long s = 0;
    private long t = 0;
    private long u = 0;
    private int v = -1;
    private final Deque<Long> w = new LinkedList();
    private long x = 0;
    private long y = 0;
    private long z = 0;
    private long A = Long.MIN_VALUE;
    private boolean B = false;
    private double C = 0.0d;
    private long D = 0;
    private long E = 0;
    private long F = 0;
    private long G = 0;
    private long H = 0;
    boolean j = true;
    final Deque<Long> k = new LinkedList();
    int l = 0;
    private final AtomicLong I = new AtomicLong(0);
    private final List<Long> J = new ArrayList();
    private final AtomicLong K = new AtomicLong(0);
    final Runnable m = y.a(this);
    final Runnable n = aa.a(this);

    public x(Bundle bundle, IVideoReporter iVideoReporter, VideoProducerDef.StreamType streamType) {
        this.o = iVideoReporter;
        this.b = bundle;
        this.p = streamType;
        this.f37043a = "SurfaceInputVideoEncoder_" + streamType + BridgeUtil.UNDERLINE_STR + hashCode();
    }

    private boolean a(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        if (mediaFormat == null) {
            return false;
        }
        try {
            LiteavLog.i(this.f37043a, "configure format: %s", mediaFormat);
            mediaCodec.configure(mediaFormat, null, null, 1);
            return true;
        } catch (Exception e) {
            LiteavLog.e(this.f37043a, "configure failed.", e);
            return false;
        }
    }

    private static byte[] a(byte[] bArr) {
        int i;
        if (bArr.length > 5 && bArr[0] == 0 && bArr[1] == 0 && bArr[2] == 0 && bArr[3] == 0 && bArr[4] == 0) {
            if (bArr[5] != 0) {
                return bArr;
            }
            int i2 = 0;
            while (true) {
                int i3 = i2;
                int i4 = i3 + 3;
                if (i4 >= bArr.length) {
                    i = 0;
                    break;
                }
                if (bArr[i3] == 0 && bArr[i3 + 1] == 0 && bArr[i3 + 2] == 0) {
                    i = i3;
                    if (bArr[i4] == 1) {
                        break;
                    }
                }
                if (bArr[i3] == 0 && bArr[i3 + 1] == 0 && bArr[i3 + 2] == 1) {
                    i = i3;
                    break;
                }
                i2 = i3 + 1;
            }
            if (i != 0) {
                int length = bArr.length - i;
                byte[] bArr2 = new byte[length];
                System.arraycopy((Object) bArr, i, (Object) bArr2, 0, length);
                return bArr2;
            }
        }
        return bArr;
    }

    private MediaCodec b(String str) throws Exception {
        String str2;
        MediaCodec createEncoderByType = MediaCodec.createEncoderByType(str);
        try {
            str2 = createEncoderByType.getName();
        } catch (Exception e) {
            LiteavLog.w(this.f37043a, "mediaCodec getName failed.", e);
            str2 = null;
        }
        LiteavLog.d(this.f37043a, "codecName=".concat(String.valueOf(str2)));
        if (str2 != null && str2.equals("OMX.google.h264.encoder")) {
            LiteavLog.w(this.f37043a, "will be destroyed codecName=".concat(String.valueOf(str2)));
            a(createEncoderByType);
            throw new IOException("this is a Google H264 soft encoder. cancel use MediaCodec.");
        }
        return createEncoderByType;
    }

    private static byte[] b(byte[] bArr) {
        int i;
        int i2;
        int i3;
        int length = bArr.length;
        ArrayList arrayList = new ArrayList(20);
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (true) {
            int i7 = i6;
            if (i4 > length) {
                break;
            }
            int i8 = i4 + 2;
            if (i8 < length && bArr[i4] == 0 && bArr[i4 + 1] == 0 && bArr[i8] == 1) {
                i = 3;
            } else {
                int i9 = i4 + 3;
                i = (i9 < length && bArr[i4] == 0 && bArr[i4 + 1] == 0 && bArr[i8] == 0 && bArr[i9] == 1) ? 4 : 1;
            }
            if (i != 3 && i != 4) {
                i2 = i5;
                i3 = i7;
                if (i4 != length) {
                    i4 += i;
                    i5 = i2;
                    i6 = i3;
                }
            }
            i2 = i5;
            if (i7 != i4) {
                arrayList.add(new int[]{i7, i4});
                i2 = i5 + (i4 - i7);
            }
            i3 = i4 + i;
            i4 += i;
            i5 = i2;
            i6 = i3;
        }
        byte[] bArr2 = new byte[i5 + (arrayList.size() * 4)];
        Iterator<E> it = arrayList.iterator();
        int i10 = 0;
        while (true) {
            int i11 = i10;
            if (!it.hasNext()) {
                return bArr2;
            }
            int[] iArr = (int[]) it.next();
            int i12 = iArr[1] - iArr[0];
            ByteBuffer order = ByteBuffer.wrap(new byte[4]).order(ByteOrder.BIG_ENDIAN);
            order.putInt(i12);
            System.arraycopy((Object) order.array(), 0, (Object) bArr2, i11, 4);
            int i13 = iArr[0];
            int i14 = i11 + 4;
            System.arraycopy((Object) bArr, i13, (Object) bArr2, i14, i12);
            i10 = i14 + i12;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        boolean z;
        long j;
        while (true) {
            MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
            try {
                int dequeueOutputBuffer = this.d.dequeueOutputBuffer(bufferInfo, TimeUnit.MILLISECONDS.toMicros(4L));
                if (dequeueOutputBuffer == -1) {
                    break;
                } else if (dequeueOutputBuffer == -3) {
                    LiteavLog.i(this.f37043a, "encoder output buffers changed");
                } else if (dequeueOutputBuffer == -2) {
                    try {
                        MediaFormat outputFormat = this.d.getOutputFormat();
                        if (this.e != null) {
                            this.e.onOutputFormatChanged(outputFormat);
                        }
                        LiteavLog.i(this.f37043a, "encoder output format changed: %s", outputFormat);
                    } catch (Throwable th) {
                        a(th.getMessage());
                        LiteavLog.e(this.f37043a, "getOutputFormat failed.", th);
                    }
                } else if (dequeueOutputBuffer < 0) {
                    a("dequeueOutputBuffer return ".concat(String.valueOf(dequeueOutputBuffer)));
                    break;
                } else {
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    this.J.add(Long.valueOf(elapsedRealtime - this.I.getAndSet(elapsedRealtime)));
                    try {
                        ByteBuffer outputBuffer = LiteavSystemInfo.getSystemOSVersionInt() >= 21 ? this.d.getOutputBuffer(dequeueOutputBuffer) : this.d.getOutputBuffers()[dequeueOutputBuffer];
                        if (outputBuffer == null || (bufferInfo.size == 0 && (bufferInfo.flags & 4) == 0)) {
                            a("size is zero, but it isn't end of stream");
                        } else {
                            byte[] bArr = new byte[bufferInfo.size];
                            outputBuffer.position(bufferInfo.offset);
                            outputBuffer.limit(bufferInfo.offset + bufferInfo.size);
                            outputBuffer.get(bArr);
                            byte[] a2 = a(bArr);
                            VideoEncodeParams videoEncodeParams = this.f;
                            byte[] bArr2 = a2;
                            if (videoEncodeParams != null) {
                                bArr2 = a2;
                                if (!videoEncodeParams.annexb) {
                                    bArr2 = b(a2);
                                }
                            }
                            byte[] bArr3 = bArr2;
                            if (this.r) {
                                bArr3 = bArr2;
                                if ((bufferInfo.flags & 1) > 0) {
                                    byte[] bArr4 = this.q;
                                    bArr3 = new byte[bArr4.length + bArr2.length];
                                    System.arraycopy((Object) bArr4, 0, (Object) bArr3, 0, bArr4.length);
                                    System.arraycopy((Object) bArr2, 0, (Object) bArr3, this.q.length, bArr2.length);
                                }
                            }
                            if ((bufferInfo.flags & 2) > 0) {
                                this.q = (byte[]) bArr3.clone();
                            } else {
                                boolean z2 = (bufferInfo.flags & 1) > 0;
                                if (z2) {
                                    this.v = -1;
                                }
                                VideoEncodeParams videoEncodeParams2 = this.f;
                                if (videoEncodeParams2 != null && !videoEncodeParams2.fullIFrame) {
                                    int i = this.v + 1;
                                    this.v = i;
                                    if (i == this.f.fps * this.f.gop) {
                                        b();
                                    }
                                }
                                long length = bArr3.length;
                                long elapsedRealtime2 = SystemClock.elapsedRealtime();
                                if (z2) {
                                    if (elapsedRealtime2 > 1000 + this.G) {
                                        this.F = (long) (((this.H * 8000.0d) / (elapsedRealtime2 - j)) / 1024.0d);
                                        this.H = 0L;
                                        this.G = elapsedRealtime2;
                                        if (!this.k.isEmpty() && this.f.fps - ((int) this.C) <= Math.max(this.f.fps / 2, 5) && SystemClock.elapsedRealtime() > this.k.peekFirst().longValue()) {
                                            this.k.removeFirst();
                                            if (this.l - this.F > Math.max(this.f.bitrate / 2, 100)) {
                                                this.b.putBoolean("need_restart_when_down_bitrate", true);
                                                this.m.run();
                                                this.k.clear();
                                            }
                                        }
                                    }
                                }
                                this.H += length;
                                d();
                                if (z2) {
                                    this.t++;
                                    this.u = 0L;
                                } else {
                                    this.u++;
                                }
                                this.s++;
                                long e = e();
                                long millis = TimeUnit.MICROSECONDS.toMillis(bufferInfo.presentationTimeUs);
                                if (this.x == 0) {
                                    this.x = e;
                                }
                                if (this.y == 0) {
                                    this.y = millis;
                                }
                                long j2 = millis + (this.x - this.y);
                                long j3 = this.z;
                                long j4 = e;
                                if (e <= j3) {
                                    j4 = j3 + 1;
                                }
                                long j5 = j4;
                                if (j4 > j2) {
                                    j5 = j2;
                                }
                                this.z = j5;
                                EncodedVideoFrame encodedVideoFrame = new EncodedVideoFrame();
                                encodedVideoFrame.nalType = z2 ? com.tencent.liteav.videobase.common.a.IDR : com.tencent.liteav.videobase.common.a.P;
                                encodedVideoFrame.data = ByteBuffer.allocateDirect(bArr3.length);
                                encodedVideoFrame.data.put(bArr3);
                                encodedVideoFrame.data.rewind();
                                encodedVideoFrame.dts = j5;
                                encodedVideoFrame.pts = j2;
                                encodedVideoFrame.info = bufferInfo;
                                encodedVideoFrame.gopIndex = this.t;
                                encodedVideoFrame.frameIndex = this.u;
                                encodedVideoFrame.gopFrameIndex = this.u;
                                encodedVideoFrame.refFrameIndex = z2 ? this.u : this.u - 1;
                                encodedVideoFrame.profileType = com.tencent.liteav.videobase.common.b.BASELINE;
                                encodedVideoFrame.codecType = this.f.codecType;
                                encodedVideoFrame.width = this.f.width;
                                encodedVideoFrame.height = this.f.height;
                                if ((bufferInfo.flags & 4) > 0) {
                                    a();
                                    z = true;
                                } else {
                                    if (!this.f.enableBFrame && !this.B && encodedVideoFrame.pts < this.A) {
                                        LiteavLog.i(this.f37043a, "has B frame,isEnablesBframe=%b,mLastPresentationTimestamp=%d,packet.pts=%d", Boolean.valueOf(this.f.enableBFrame), Long.valueOf(this.A), Long.valueOf(encodedVideoFrame.pts));
                                        this.B = true;
                                        PersistStorage persistStorage = new PersistStorage(PersistStorage.GLOBAL_DOMAIN);
                                        persistStorage.put("Liteav.Video.android.local.rtc.enable.high.profile", 0);
                                        persistStorage.commit();
                                        bf.a aVar = this.e;
                                        if (aVar != null) {
                                            aVar.a();
                                        }
                                    }
                                    this.A = encodedVideoFrame.pts;
                                    z = false;
                                }
                                bf.a aVar2 = this.e;
                                if (aVar2 != null) {
                                    aVar2.onEncodedNAL(encodedVideoFrame, z);
                                }
                            }
                        }
                        try {
                            this.d.releaseOutputBuffer(dequeueOutputBuffer, false);
                        } catch (Throwable th2) {
                            a(th2.getMessage());
                            LiteavLog.e(this.f37043a, "releaseOutputBuffer failed.", th2);
                        }
                    } catch (Throwable th3) {
                        a(th3.getMessage());
                        LiteavLog.e(this.f37043a, "getOutputBuffer failed.", th3);
                    }
                }
            } catch (Throwable th4) {
                a(th4.getMessage());
                LiteavLog.e(this.f37043a, "dequeueOutputBuffer failed.", th4);
            }
        }
        synchronized (this.w) {
            if (this.w.size() != 0) {
                int i2 = this.f.fps != 0 ? 500 / this.f.fps : 10;
                if (LiteavSystemInfo.getSystemOSVersionInt() < 29) {
                    this.f37044c.postDelayed(this.n, i2);
                } else if (!this.f37044c.hasCallbacks(this.n)) {
                    this.f37044c.postDelayed(this.n, i2);
                }
            }
        }
    }

    private void d() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (elapsedRealtime <= this.D + TimeUnit.SECONDS.toMillis(2L)) {
            this.E++;
            return;
        }
        this.C = (this.E * 1000.0d) / (elapsedRealtime - this.D);
        this.E = 1L;
        this.D = elapsedRealtime;
        long j = -1;
        for (Long l : this.J) {
            long longValue = l.longValue();
            if (j < longValue) {
                j = longValue;
            }
        }
        this.K.set(j);
        this.J.clear();
    }

    private long e() {
        long longValue;
        synchronized (this.w) {
            Long pollFirst = this.w.pollFirst();
            longValue = pollFirst == null ? 0L : pollFirst.longValue();
        }
        return longValue;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01ad A[Catch: Exception -> 0x0239, TRY_ENTER, TryCatch #3 {Exception -> 0x0239, blocks: (B:39:0x014a, B:40:0x014d, B:42:0x016a, B:44:0x0175, B:46:0x0185, B:48:0x0190, B:53:0x01ad, B:66:0x022e, B:67:0x0238), top: B:92:0x014a }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x022e A[Catch: Exception -> 0x0239, TRY_ENTER, TryCatch #3 {Exception -> 0x0239, blocks: (B:39:0x014a, B:40:0x014d, B:42:0x016a, B:44:0x0175, B:46:0x0185, B:48:0x0190, B:53:0x01ad, B:66:0x022e, B:67:0x0238), top: B:92:0x014a }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.view.Surface a(com.tencent.liteav.videoproducer.encoder.VideoEncodeParams r8) {
        /*
            Method dump skipped, instructions count: 788
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.videoproducer.encoder.x.a(com.tencent.liteav.videoproducer.encoder.VideoEncodeParams):android.view.Surface");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a() {
        if (this.h != null) {
            LiteavLog.i(this.f37043a, "stopEosTimer");
            this.h.a();
            this.h = null;
        }
    }

    public final void a(long j) {
        if (this.f.fullIFrame) {
            this.f37044c.a(ad.a(this));
        }
        synchronized (this.w) {
            if (this.w.isEmpty()) {
                this.I.set(SystemClock.elapsedRealtime());
            }
            this.w.addLast(Long.valueOf(j));
            if (this.w.size() > 30) {
                LiteavLog.e(this.f37043a, "too much unencoded frame, hw encoder error");
                this.f37044c.post(this.m);
            }
        }
        this.f37044c.postDelayed(this.n, 10L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(MediaCodec mediaCodec) {
        if (mediaCodec != null) {
            try {
                mediaCodec.stop();
            } catch (Exception e) {
                LiteavLog.e(this.f37043a, "destroy mediaCodec stop failed.", e);
            }
            try {
                mediaCodec.release();
            } catch (Exception e2) {
                LiteavLog.e(this.f37043a, "destroy mediaCodec release failed.", e2);
            }
        }
    }

    public final void a(String str) {
        this.f37044c.post(ag.a(this, str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b() {
        if (LiteavSystemInfo.getSystemOSVersionInt() < 19 || this.d == null) {
            return;
        }
        try {
            Bundle bundle = new Bundle();
            bundle.putInt(MediaCodec.PARAMETER_KEY_REQUEST_SYNC_FRAME, 0);
            this.d.setParameters(bundle);
        } catch (Throwable th) {
            LiteavLog.e(this.f37043a, "requestSyncFrame failed.", th);
        }
    }
}
