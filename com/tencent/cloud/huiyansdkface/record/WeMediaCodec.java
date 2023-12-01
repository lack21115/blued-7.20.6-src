package com.tencent.cloud.huiyansdkface.record;

import android.content.Context;
import android.hardware.Camera;
import android.media.MediaCodec;
import android.media.MediaFormat;
import com.tencent.cloud.huiyansdkface.normal.tools.WLogger;
import com.tencent.cloud.huiyansdkface.record.h264.EncoderDebugger;
import com.tencent.cloud.huiyansdkface.record.h264.NV21Convert;
import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.ByteBuffer;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/record/WeMediaCodec.class */
public class WeMediaCodec {
    private static int g;

    /* renamed from: a  reason: collision with root package name */
    private int f22363a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private MediaCodec f22364c;
    private NV21Convert d;
    private WbRecordFinishListener e;
    private boolean f;
    private int h;
    private int i;
    private int j;
    private byte[] k = new byte[0];
    private byte[] l = null;
    private WeWrapMp4Jni m;
    private byte[] n;
    private byte[] o;
    private byte[] p;
    private int q;
    private int r;
    private ByteArrayOutputStream s;

    public WeMediaCodec(Context context, WeWrapMp4Jni weWrapMp4Jni, int i, int i2, int i3, int i4) {
        this.h = i2;
        this.i = i3;
        this.m = weWrapMp4Jni;
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        Camera.getCameraInfo(i, cameraInfo);
        this.r = cameraInfo.orientation;
        int i5 = ((this.h * this.i) * 3) / 2;
        this.n = new byte[i5];
        this.o = new byte[i5];
        this.p = new byte[i5];
        this.j = i4;
        this.s = new ByteArrayOutputStream();
    }

    public void destroy() {
        WLogger.d("WeMediaCodec", "destroy");
        this.l = null;
        this.n = null;
        this.o = null;
        this.p = null;
        try {
            this.s.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.s = null;
        MediaCodec mediaCodec = this.f22364c;
        if (mediaCodec != null) {
            mediaCodec.stop();
            this.f22364c.release();
            this.f22364c = null;
        }
    }

    public ByteArrayOutputStream getVideoByte() {
        return this.s;
    }

    public boolean initMediaCodec(Context context) {
        WLogger.i("WeMediaCodec", "initMediaCodec");
        g = 0;
        this.f22363a = 30;
        this.b = 1000000;
        try {
            EncoderDebugger debug = EncoderDebugger.debug(context, this.h, this.i);
            this.d = debug.getNV21Convertor();
            this.q = debug.getEncoderColorFormat();
            this.f22364c = MediaCodec.createByCodecName(debug.getEncoderName());
            MediaFormat createVideoFormat = MediaFormat.createVideoFormat("video/avc", this.h, this.i);
            createVideoFormat.setInteger(MediaFormat.KEY_BIT_RATE, this.b);
            createVideoFormat.setInteger(MediaFormat.KEY_FRAME_RATE, this.f22363a);
            createVideoFormat.setInteger(MediaFormat.KEY_COLOR_FORMAT, debug.getEncoderColorFormat());
            createVideoFormat.setInteger(MediaFormat.KEY_I_FRAME_INTERVAL, 5);
            this.f22364c.configure(createVideoFormat, null, null, 1);
            this.f22364c.start();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            WLogger.w("WeMediaCodec", "initMediaCodec error:" + e.toString());
            return false;
        }
    }

    public void onPreviewFrame(byte[] bArr) {
        byte[] bArr2;
        if (this.f) {
            return;
        }
        if (g > this.j) {
            WLogger.i("WeMediaCodec", "onPreviewFrame*** mVideoFrameCount > MAX_VIDEO_FRAME_NUM,no more record");
            this.f = true;
            WbRecordFinishListener wbRecordFinishListener = this.e;
            if (wbRecordFinishListener != null) {
                wbRecordFinishListener.onRecordFinish();
                return;
            }
            return;
        }
        ByteBuffer[] inputBuffers = this.f22364c.getInputBuffers();
        ByteBuffer[] outputBuffers = this.f22364c.getOutputBuffers();
        try {
            int dequeueInputBuffer = this.f22364c.dequeueInputBuffer(10000L);
            if (dequeueInputBuffer < 0) {
                WLogger.e("WeMediaCodec", "No buffer available !");
                return;
            }
            inputBuffers[dequeueInputBuffer].clear();
            this.m.NV21ToTarget(bArr, this.p, this.h, this.i, this.q, this.r, this.n, this.o);
            inputBuffers[dequeueInputBuffer].put(this.p, 0, this.p.length);
            this.f22364c.queueInputBuffer(dequeueInputBuffer, 0, inputBuffers[dequeueInputBuffer].position(), System.nanoTime() / 1000, 0);
            MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
            int dequeueOutputBuffer = this.f22364c.dequeueOutputBuffer(bufferInfo, 0L);
            g++;
            WLogger.d("WeMediaCodec", "video frame count=" + g);
            while (dequeueOutputBuffer >= 0) {
                ByteBuffer byteBuffer = outputBuffers[dequeueOutputBuffer];
                int i = bufferInfo.size;
                byte[] bArr3 = new byte[i];
                byteBuffer.get(bArr3);
                if (bArr3[0] == 0 && bArr3[1] == 0 && bArr3[2] == 0 && bArr3[3] == 1 && bArr3[4] == 103) {
                    this.k = bArr3;
                    bArr2 = bArr3;
                } else {
                    bArr2 = bArr3;
                    if (bArr3[0] == 0) {
                        bArr2 = bArr3;
                        if (bArr3[1] == 0) {
                            bArr2 = bArr3;
                            if (bArr3[2] == 0) {
                                bArr2 = bArr3;
                                if (bArr3[3] == 1) {
                                    bArr2 = bArr3;
                                    if (bArr3[4] == 101) {
                                        bArr2 = new byte[this.k.length + i];
                                        System.arraycopy(this.k, 0, bArr2, 0, this.k.length);
                                        System.arraycopy(bArr3, 0, bArr2, this.k.length, i);
                                    }
                                }
                            }
                        }
                    }
                }
                this.s.write(bArr2);
                this.f22364c.releaseOutputBuffer(dequeueOutputBuffer, false);
                dequeueOutputBuffer = this.f22364c.dequeueOutputBuffer(bufferInfo, 0L);
            }
        } catch (Exception e) {
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            e.printStackTrace(printWriter);
            String stringWriter2 = stringWriter.toString();
            try {
                stringWriter.close();
                printWriter.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            WLogger.e("WeMediaCodec", stringWriter2);
            e.printStackTrace();
        }
    }

    public void start(WbRecordFinishListener wbRecordFinishListener) {
        this.s.reset();
        g = 0;
        if (wbRecordFinishListener != null) {
            this.e = wbRecordFinishListener;
        }
    }

    public void stop() {
        WLogger.d("WeMediaCodec", "stop:" + g);
    }
}
