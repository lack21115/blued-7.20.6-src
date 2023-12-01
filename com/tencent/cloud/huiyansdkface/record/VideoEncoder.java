package com.tencent.cloud.huiyansdkface.record;

import android.graphics.YuvImage;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.os.Build;
import android.util.Log;
import com.tencent.cloud.huiyansdkface.normal.tools.WLogger;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.ByteBuffer;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/record/VideoEncoder.class */
public class VideoEncoder {
    public static final int COLOR_FORMAT_YUV_420_SEMI_PLANAR = 21;

    /* renamed from: a  reason: collision with root package name */
    private static final String f36051a = VideoEncoder.class.getSimpleName();
    private static int m;
    private static int n;
    private IYUVToVideoEncoderCallback b;

    /* renamed from: c  reason: collision with root package name */
    private File f36052c;
    private byte[] f;
    private MediaCodec g;
    private MediaMuxer h;
    private CountDownLatch l;
    private boolean o;
    private int q;
    private ByteArrayOutputStream y;
    private ConcurrentLinkedQueue<YuvImage> d = new ConcurrentLinkedQueue<>();
    private ConcurrentLinkedQueue<Object> e = new ConcurrentLinkedQueue<>();
    private boolean i = false;
    private final Object j = new Object();
    private final Object k = new Object();
    private int p = 0;
    private int r = 0;
    private boolean s = false;
    private boolean t = false;
    private boolean u = false;
    private int v = 21;
    private int w = 0;
    private byte[] x = new byte[0];

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/record/VideoEncoder$IYUVToVideoEncoderCallback.class */
    public interface IYUVToVideoEncoderCallback {
        void onEncodingComplete(File file);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/record/VideoEncoder$a.class */
    public enum a {
        VideoType
    }

    public VideoEncoder(IYUVToVideoEncoderCallback iYUVToVideoEncoderCallback, boolean z) {
        this.o = false;
        this.b = iYUVToVideoEncoderCallback;
        this.o = z;
    }

    private static int a(MediaCodecInfo mediaCodecInfo, String str) {
        MediaCodecInfo.CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType(str);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= capabilitiesForType.colorFormats.length) {
                return 0;
            }
            int i3 = capabilitiesForType.colorFormats[i2];
            String str2 = f36051a;
            WLogger.d(str2, "found colorformat: " + i3);
            if (a(i3)) {
                return i3;
            }
            i = i2 + 1;
        }
    }

    private long a(long j, int i) {
        return ((j * 1000000) / i) + 132;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x003e, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.media.MediaCodecInfo a(java.lang.String r3) {
        /*
            int r0 = android.media.MediaCodecList.getCodecCount()
            r6 = r0
            r0 = 0
            r4 = r0
        L6:
            r0 = r4
            r1 = r6
            if (r0 >= r1) goto L45
            r0 = r4
            android.media.MediaCodecInfo r0 = android.media.MediaCodecList.getCodecInfoAt(r0)
            r7 = r0
            r0 = r7
            boolean r0 = r0.isEncoder()
            if (r0 == 0) goto L3e
            r0 = r7
            java.lang.String[] r0 = r0.getSupportedTypes()
            r8 = r0
            r0 = 0
            r5 = r0
        L22:
            r0 = r5
            r1 = r8
            int r1 = r1.length
            if (r0 >= r1) goto L3e
            r0 = r8
            r1 = r5
            r0 = r0[r1]
            r1 = r3
            boolean r0 = r0.equalsIgnoreCase(r1)
            if (r0 == 0) goto L37
            r0 = r7
            return r0
        L37:
            r0 = r5
            r1 = 1
            int r0 = r0 + r1
            r5 = r0
            goto L22
        L3e:
            r0 = r4
            r1 = 1
            int r0 = r0 + r1
            r4 = r0
            goto L6
        L45:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.cloud.huiyansdkface.record.VideoEncoder.a(java.lang.String):android.media.MediaCodecInfo");
    }

    private ByteBuffer a(a aVar, int i) {
        return Build.VERSION.SDK_INT >= 21 ? this.g.getInputBuffer(i) : this.g.getInputBuffers()[i];
    }

    private void a() {
        WLogger.d(f36051a, "release");
        synchronized (this.k) {
            if (this.g != null) {
                try {
                    this.g.stop();
                } catch (Exception e) {
                    e.printStackTrace();
                    String str = f36051a;
                    WLogger.w(str, "videoEncoder stop failed:" + e.toString());
                }
                this.g.release();
                this.g = null;
                WLogger.d(f36051a, "RELEASE Video CODEC");
            }
            if (this.h != null) {
                try {
                    this.h.stop();
                    this.h.release();
                } catch (Exception e2) {
                    e2.printStackTrace();
                    String str2 = f36051a;
                    WLogger.e(str2, "media muxer stop failed:" + e2.toString());
                }
                this.h = null;
                this.i = false;
                WLogger.d(f36051a, "RELEASE MUXER");
            }
        }
    }

    private void a(a aVar, MediaFormat mediaFormat) {
        synchronized (this.k) {
            if (!this.i) {
                if (aVar == a.VideoType) {
                    this.q = this.h.addTrack(mediaFormat);
                    this.r++;
                }
                if (this.r >= 1) {
                    WLogger.d(f36051a, "Media muxer is starting...");
                    this.h.start();
                    this.i = true;
                    this.k.notifyAll();
                }
            }
        }
    }

    private static boolean a(int i) {
        if (i == 39 || i == 2130706688) {
            return true;
        }
        switch (i) {
            case 19:
            case 20:
            case 21:
                return true;
            default:
                return false;
        }
    }

    private byte[] a(int i, int i2, YuvImage yuvImage) {
        return this.v == 21 ? b(i, i2, yuvImage) : c(i, i2, yuvImage);
    }

    private ByteBuffer b(a aVar, int i) {
        return Build.VERSION.SDK_INT >= 21 ? this.g.getOutputBuffer(i) : this.g.getOutputBuffers()[i];
    }

    private byte[] b(int i, int i2, YuvImage yuvImage) {
        if (this.f == null) {
            this.f = new byte[((i * i2) * 3) / 2];
        }
        byte[] yuvData = yuvImage.getYuvData();
        int i3 = i * i2;
        if (i3 >= 0) {
            System.arraycopy((Object) yuvData, 0, (Object) this.f, 0, i3);
        }
        int i4 = i3;
        while (true) {
            int i5 = i4;
            if (i5 >= (i3 * 3) / 2) {
                return this.f;
            }
            int i6 = i5 + 1;
            if (i6 % 2 == 0) {
                byte[] bArr = this.f;
                int i7 = i5 - 1;
                bArr[i5] = yuvData[i7];
                bArr[i7] = yuvData[i5];
            }
            i4 = i6;
        }
    }

    private byte[] c(int i, int i2, YuvImage yuvImage) {
        if (this.f == null) {
            this.f = new byte[((i * i2) * 3) / 2];
        }
        byte[] yuvData = yuvImage.getYuvData();
        int i3 = i * i2;
        if (i3 >= 0) {
            System.arraycopy((Object) yuvData, 0, (Object) this.f, 0, i3);
        }
        int i4 = (i3 / 4) + i3;
        int i5 = i3;
        int i6 = i5;
        while (i5 < (i3 * 3) / 2) {
            byte[] bArr = this.f;
            bArr[i4] = yuvData[i5];
            bArr[i6] = yuvData[i5 + 1];
            i4++;
            i6++;
            i5 += 2;
        }
        return this.f;
    }

    public void abortEncoding() {
        this.u = false;
        if (this.f36052c != null) {
            WLogger.d(f36051a, "Clean up record file");
            this.f36052c.delete();
            this.f36052c = null;
        }
        ByteArrayOutputStream byteArrayOutputStream = this.y;
        if (byteArrayOutputStream != null) {
            try {
                byteArrayOutputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
                String str = f36051a;
                WLogger.e(str, "byteOutput close failed:" + e.toString());
            }
            this.y = null;
            WLogger.d(f36051a, "RELEASE byteOutput");
        }
        if (this.o) {
            if (this.g == null || this.h == null) {
                WLogger.i(f36051a, "Failed to abort encoding since it never started");
                return;
            }
            WLogger.i(f36051a, "Aborting encoding");
            a();
            this.s = true;
            this.t = true;
            this.d = new ConcurrentLinkedQueue<>();
            synchronized (this.j) {
                if (this.l != null && this.l.getCount() > 0) {
                    this.l.countDown();
                }
            }
        }
    }

    public void encode() {
        String str;
        String str2;
        CountDownLatch countDownLatch;
        if (this.o && this.u) {
            if (this.s && this.d.size() == 0) {
                return;
            }
            YuvImage poll = this.d.poll();
            YuvImage yuvImage = poll;
            if (poll == null) {
                synchronized (this.j) {
                    countDownLatch = new CountDownLatch(1);
                    this.l = countDownLatch;
                }
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                yuvImage = this.d.poll();
            }
            if (yuvImage != null) {
                try {
                    byte[] a2 = a(m, n, yuvImage);
                    int dequeueInputBuffer = this.g.dequeueInputBuffer(200000L);
                    long a3 = a(this.p, 30);
                    if (dequeueInputBuffer >= 0) {
                        ByteBuffer a4 = a(a.VideoType, dequeueInputBuffer);
                        a4.clear();
                        a4.put(a2);
                        this.g.queueInputBuffer(dequeueInputBuffer, 0, a2.length, a3, 0);
                        this.p++;
                    }
                    MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
                    int dequeueOutputBuffer = this.g.dequeueOutputBuffer(bufferInfo, 200000L);
                    if (dequeueOutputBuffer == -1) {
                        str = f36051a;
                        str2 = "No output from encoder available";
                    } else if (dequeueOutputBuffer == -2) {
                        a(a.VideoType, this.g.getOutputFormat());
                        return;
                    } else if (dequeueOutputBuffer < 0) {
                        str = f36051a;
                        str2 = "unexpected result from encoder.dequeueOutputBuffer: " + dequeueOutputBuffer;
                    } else if (bufferInfo.size == 0) {
                        return;
                    } else {
                        ByteBuffer b = b(a.VideoType, dequeueOutputBuffer);
                        if (b != null) {
                            b.position(bufferInfo.offset);
                            b.limit(bufferInfo.offset + bufferInfo.size);
                            WLogger.d(f36051a, "media muxer write video data outputindex " + this.p);
                            synchronized (this.h) {
                                this.h.writeSampleData(this.q, b, bufferInfo);
                            }
                            this.g.releaseOutputBuffer(dequeueOutputBuffer, false);
                            return;
                        }
                        str = f36051a;
                        str2 = "encoderOutputBuffer " + dequeueOutputBuffer + " was null";
                    }
                    WLogger.e(str, str2);
                } catch (Exception e2) {
                    StringWriter stringWriter = new StringWriter();
                    PrintWriter printWriter = new PrintWriter(stringWriter);
                    e2.printStackTrace(printWriter);
                    String stringWriter2 = stringWriter.toString();
                    try {
                        stringWriter.close();
                        printWriter.close();
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                    WLogger.e(f36051a, stringWriter2);
                    e2.printStackTrace();
                }
            }
        }
    }

    public void encodeH264() {
        byte[] bArr;
        String str;
        String str2;
        String str3;
        String str4;
        CountDownLatch countDownLatch;
        if (this.o && this.u) {
            WLogger.d(f36051a, "Encoder started");
            if (this.s && this.d.size() == 0) {
                return;
            }
            YuvImage poll = this.d.poll();
            YuvImage yuvImage = poll;
            if (poll == null) {
                synchronized (this.j) {
                    countDownLatch = new CountDownLatch(1);
                    this.l = countDownLatch;
                }
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                yuvImage = this.d.poll();
            }
            if (yuvImage != null) {
                try {
                    byte[] a2 = a(m, n, yuvImage);
                    int dequeueInputBuffer = this.g.dequeueInputBuffer(200000L);
                    long a3 = a(this.p, 30);
                    if (dequeueInputBuffer >= 0) {
                        ByteBuffer a4 = a(a.VideoType, dequeueInputBuffer);
                        a4.clear();
                        a4.put(a2);
                        this.g.queueInputBuffer(dequeueInputBuffer, 0, a2.length, a3, 0);
                        this.p++;
                    }
                    MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
                    int dequeueOutputBuffer = this.g.dequeueOutputBuffer(bufferInfo, 200000L);
                    if (dequeueOutputBuffer != -1) {
                        if (dequeueOutputBuffer == -2) {
                            str = f36051a;
                            str2 = "start output";
                        } else if (dequeueOutputBuffer < 0) {
                            str3 = f36051a;
                            str4 = "unexpected result from encoder.dequeueOutputBuffer: " + dequeueOutputBuffer;
                        } else if (bufferInfo.size == 0) {
                            return;
                        } else {
                            ByteBuffer b = b(a.VideoType, dequeueOutputBuffer);
                            int i = bufferInfo.size;
                            byte[] bArr2 = new byte[i];
                            b.get(bArr2);
                            if (bArr2[0] == 0 && bArr2[1] == 0 && bArr2[2] == 0 && bArr2[3] == 1 && bArr2[4] == 103) {
                                this.x = bArr2;
                                bArr = bArr2;
                            } else {
                                bArr = bArr2;
                                if (bArr2[0] == 0) {
                                    bArr = bArr2;
                                    if (bArr2[1] == 0) {
                                        bArr = bArr2;
                                        if (bArr2[2] == 0) {
                                            bArr = bArr2;
                                            if (bArr2[3] == 1) {
                                                bArr = bArr2;
                                                if (bArr2[4] == 101) {
                                                    bArr = new byte[this.x.length + i];
                                                    System.arraycopy((Object) this.x, 0, (Object) bArr, 0, this.x.length);
                                                    System.arraycopy((Object) bArr2, 0, (Object) bArr, this.x.length, i);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            this.y.write(bArr);
                            this.g.releaseOutputBuffer(dequeueOutputBuffer, false);
                            str = f36051a;
                            str2 = "videoEncoder releaseOutputBuffer";
                        }
                        WLogger.d(str, str2);
                        return;
                    }
                    str3 = f36051a;
                    str4 = "No output from encoder available";
                    WLogger.e(str3, str4);
                } catch (Exception e2) {
                    StringWriter stringWriter = new StringWriter();
                    PrintWriter printWriter = new PrintWriter(stringWriter);
                    e2.printStackTrace(printWriter);
                    String stringWriter2 = stringWriter.toString();
                    try {
                        stringWriter.close();
                        printWriter.close();
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                    WLogger.e(f36051a, stringWriter2);
                    e2.printStackTrace();
                }
            }
        }
    }

    public int getColorFormat() {
        return this.w;
    }

    public int getYUVImageSize() {
        return this.d.size();
    }

    public boolean isEncodingStarted() {
        return this.u;
    }

    public void queueFrame(YuvImage yuvImage) {
        if (this.o) {
            if (this.g == null || this.h == null) {
                Log.d(f36051a, "Failed to queue frame. Encoding not started");
                return;
            }
            WLogger.d(f36051a, "Queueing frame");
            this.d.add(yuvImage);
            synchronized (this.j) {
                if (this.l != null && this.l.getCount() > 0) {
                    this.l.countDown();
                }
            }
        }
    }

    public void queueFrameH264(YuvImage yuvImage) {
        if (this.o) {
            if (this.g == null) {
                Log.d(f36051a, "Failed to queue frame. Encoding not started");
                return;
            }
            this.d.add(yuvImage);
            synchronized (this.j) {
                if (this.l != null && this.l.getCount() > 0) {
                    this.l.countDown();
                }
            }
        }
    }

    public void startEncoding(int i, int i2, File file, int i3, int i4, int i5) {
        if (Build.VERSION.SDK_INT < 18) {
            WLogger.w(f36051a, "not support recording!");
            return;
        }
        WLogger.d(f36051a, "startEncoding");
        if (this.o) {
            m = i;
            n = i2;
            this.f36052c = file;
            try {
                String canonicalPath = file.getCanonicalPath();
                WLogger.d(f36051a, "new MediaMuxer");
                if (this.h == null) {
                    this.h = new MediaMuxer(canonicalPath, 0);
                }
                WLogger.d(f36051a, "selectCodec");
                MediaCodecInfo a2 = a("video/avc");
                if (a2 == null) {
                    WLogger.e(f36051a, "Unable to find an appropriate codec for video/avc");
                    return;
                }
                String str = f36051a;
                WLogger.i(str, "found codec: " + a2.getName());
                this.v = 21;
                try {
                    int a3 = a(a2, "video/avc");
                    this.v = a3;
                    this.w = a3;
                } catch (Exception e) {
                    e.printStackTrace();
                    WLogger.e(f36051a, "Unable to find color format use default");
                    this.v = 21;
                }
                try {
                    this.g = MediaCodec.createByCodecName(a2.getName());
                    WLogger.d(f36051a, "Create videoEncoder createByCodecName");
                    try {
                        MediaFormat createVideoFormat = MediaFormat.createVideoFormat("video/avc", m, n);
                        createVideoFormat.setInteger(MediaFormat.KEY_BIT_RATE, i3);
                        createVideoFormat.setInteger(MediaFormat.KEY_FRAME_RATE, i4);
                        createVideoFormat.setInteger(MediaFormat.KEY_COLOR_FORMAT, this.v);
                        createVideoFormat.setInteger(MediaFormat.KEY_I_FRAME_INTERVAL, i5);
                        this.g.configure(createVideoFormat, null, null, 1);
                        this.g.start();
                        String str2 = f36051a;
                        WLogger.i(str2, "Initialization complete. Starting encoder..." + Thread.currentThread().getName());
                        this.u = true;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        String str3 = f36051a;
                        WLogger.e(str3, "encoder configure failed:" + e2.toString());
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                    String str4 = f36051a;
                    WLogger.w(str4, "Unable to create MediaCodec " + e3.toString());
                }
            } catch (Exception e4) {
                e4.printStackTrace();
                String str5 = f36051a;
                WLogger.w(str5, "Unable to get path for " + file + "," + e4.toString());
            }
        }
    }

    public void startEncodingH264(int i, int i2, ByteArrayOutputStream byteArrayOutputStream, int i3, int i4, int i5) {
        if (Build.VERSION.SDK_INT < 18) {
            WLogger.w(f36051a, "not support recording!");
            return;
        }
        String str = f36051a;
        WLogger.d(str, "startEncoding:" + i + "," + i2);
        if (this.o) {
            m = i;
            n = i2;
            this.y = byteArrayOutputStream;
            WLogger.d(f36051a, "selectCodec");
            MediaCodecInfo a2 = a("video/avc");
            if (a2 == null) {
                WLogger.e(f36051a, "Unable to find an appropriate codec for video/avc");
                return;
            }
            String str2 = f36051a;
            WLogger.i(str2, "found codec: " + a2.getName());
            this.v = 21;
            try {
                int a3 = a(a2, "video/avc");
                this.v = a3;
                this.w = a3;
            } catch (Exception e) {
                e.printStackTrace();
                WLogger.e(f36051a, "Unable to find color format use default");
                this.v = 21;
            }
            try {
                this.g = MediaCodec.createByCodecName(a2.getName());
                WLogger.d(f36051a, "Create videoEncoder createByCodecName");
                try {
                    MediaFormat createVideoFormat = MediaFormat.createVideoFormat("video/avc", m, n);
                    createVideoFormat.setInteger(MediaFormat.KEY_BIT_RATE, i3);
                    createVideoFormat.setInteger(MediaFormat.KEY_FRAME_RATE, i4);
                    createVideoFormat.setInteger(MediaFormat.KEY_COLOR_FORMAT, this.v);
                    createVideoFormat.setInteger(MediaFormat.KEY_I_FRAME_INTERVAL, i5);
                    this.g.configure(createVideoFormat, null, null, 1);
                    this.g.start();
                    String str3 = f36051a;
                    WLogger.i(str3, "Initialization complete. Starting encoder..." + Thread.currentThread().getName());
                    this.u = true;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    String str4 = f36051a;
                    WLogger.e(str4, "encoder configure failed:" + e2.toString());
                }
            } catch (Exception e3) {
                e3.printStackTrace();
                String str5 = f36051a;
                WLogger.w(str5, "Unable to create MediaCodec " + e3.toString());
            }
        }
    }

    public void stopEncoding() {
        this.u = false;
        if (this.o) {
            if (this.g == null || this.h == null) {
                Log.i(f36051a, "Failed to stop encoding since it never started");
                return;
            }
            WLogger.i(f36051a, "Stopping encoding");
            this.s = true;
            synchronized (this.j) {
                if (this.l != null && this.l.getCount() > 0) {
                    this.l.countDown();
                }
            }
            a();
        }
    }

    public void stopEncodingH264() {
        this.u = false;
        if (this.o) {
            if (this.g == null) {
                Log.i(f36051a, "Failed to stop encoding since it never started");
                return;
            }
            WLogger.i(f36051a, "Stopping encodingH264");
            this.s = true;
            synchronized (this.j) {
                if (this.l != null && this.l.getCount() > 0) {
                    this.l.countDown();
                }
            }
            a();
        }
    }
}
