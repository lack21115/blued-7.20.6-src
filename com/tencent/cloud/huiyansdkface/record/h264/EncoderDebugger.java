package com.tencent.cloud.huiyansdkface.record.h264;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Build;
import android.preference.PreferenceManager;
import android.util.Base64;
import android.util.Log;
import com.baidu.mobads.sdk.internal.bw;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.tencent.cloud.huiyansdkface.normal.tools.WLogger;
import com.tencent.cloud.huiyansdkface.record.h264.CodecManager;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/record/h264/EncoderDebugger.class */
public class EncoderDebugger {
    public static final String TAG = "EncoderDebugger";

    /* renamed from: a  reason: collision with root package name */
    private int f36061a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private String f36062c;
    private MediaCodec d;
    private int e;
    private int f;
    private int g;
    private byte[] h;
    private byte[] i;
    private byte[] j;
    private byte[] k;
    private NV21Convert l;
    private SharedPreferences m;
    private byte[][] n;
    private byte[][] o;
    private String p;
    private String q;

    private EncoderDebugger(SharedPreferences sharedPreferences, int i, int i2) {
        WLogger.e(TAG, TAG);
        this.m = sharedPreferences;
        this.e = i;
        this.f = i2;
        this.g = i * i2;
        a();
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [byte[], byte[][]] */
    /* JADX WARN: Type inference failed for: r1v4, types: [byte[], byte[][]] */
    private void a() {
        this.l = new NV21Convert();
        this.n = new byte[50];
        this.o = new byte[34];
        this.f36062c = "";
        this.i = null;
        this.h = null;
    }

    private void a(boolean z) {
        String str = this.e + "x" + this.f + "-";
        SharedPreferences.Editor edit = this.m.edit();
        edit.putBoolean("libstreaming-" + str + bw.o, z);
        if (z) {
            edit.putInt("libstreaming-" + str + "lastSdk", Build.VERSION.SDK_INT);
            edit.putInt("libstreaming-" + str + "lastVersion", 3);
            edit.putInt("libstreaming-" + str + "sliceHeight", this.l.getSliceHeight());
            edit.putInt("libstreaming-" + str + MediaFormat.KEY_STRIDE, this.l.getStride());
            edit.putInt("libstreaming-" + str + "padding", this.l.getYPadding());
            edit.putBoolean("libstreaming-" + str + "planar", this.l.getPlanar());
            edit.putBoolean("libstreaming-" + str + "reversed", this.l.getUVPanesReversed());
            edit.putString("libstreaming-" + str + "encoderName", this.b);
            edit.putInt("libstreaming-" + str + "colorFormat", this.f36061a);
            edit.putString("libstreaming-" + str + "encoderName", this.b);
            edit.putString("libstreaming-" + str + "pps", this.p);
            edit.putString("libstreaming-" + str + "sps", this.q);
        }
        edit.commit();
    }

    private void a(boolean z, String str) {
        if (z) {
            return;
        }
        WLogger.e(TAG, str);
        throw new IllegalStateException(str);
    }

    private void b() {
        if (!c()) {
            String str = this.e + "x" + this.f + "-";
            if (!this.m.getBoolean("libstreaming-" + str + bw.o, false)) {
                throw new RuntimeException("Phone not supported with this resolution (" + this.e + "x" + this.f + ")");
            }
            this.l.setSize(this.e, this.f);
            this.l.setSliceHeight(this.m.getInt("libstreaming-" + str + "sliceHeight", 0));
            this.l.setStride(this.m.getInt("libstreaming-" + str + MediaFormat.KEY_STRIDE, 0));
            this.l.setYPadding(this.m.getInt("libstreaming-" + str + "padding", 0));
            this.l.setPlanar(this.m.getBoolean("libstreaming-" + str + "planar", false));
            this.l.setColorPanesReversed(this.m.getBoolean("libstreaming-" + str + "reversed", false));
            this.b = this.m.getString("libstreaming-" + str + "encoderName", "");
            this.f36061a = this.m.getInt("libstreaming-" + str + "colorFormat", 0);
            this.p = this.m.getString("libstreaming-" + str + "pps", "");
            this.q = this.m.getString("libstreaming-" + str + "sps", "");
            return;
        }
        WLogger.d(TAG, ">>>> Testing the phone for resolution " + this.e + "x" + this.f);
        CodecManager.a[] findEncodersForMimeType = CodecManager.findEncodersForMimeType("video/avc");
        int i = 0;
        for (int i2 = 0; i2 < findEncodersForMimeType.length; i2++) {
            i += findEncodersForMimeType[i2].b.length;
        }
        int i3 = 1;
        for (int i4 = 0; i4 < findEncodersForMimeType.length; i4++) {
            int i5 = 0;
            while (i5 < findEncodersForMimeType[i4].b.length) {
                a();
                this.b = findEncodersForMimeType[i4].f36060a;
                this.f36061a = findEncodersForMimeType[i4].b[i5].intValue();
                WLogger.v(TAG, ">> Test " + i3 + BridgeUtil.SPLIT_MARK + i + ": " + this.b + " with color format " + this.f36061a + " at " + this.e + "x" + this.f);
                this.l.setSize(this.e, this.f);
                this.l.setSliceHeight(this.f);
                this.l.setStride(this.e);
                this.l.setYPadding(0);
                this.l.setEncoderColorFormat(this.f36061a);
                d();
                this.j = this.l.convert(this.k);
                try {
                    try {
                        e();
                        g();
                        a(true);
                        Log.v(TAG, "The encoder " + this.b + " is usable with resolution " + this.e + "x" + this.f);
                        return;
                    } catch (Exception e) {
                        StringWriter stringWriter = new StringWriter();
                        e.printStackTrace(new PrintWriter(stringWriter));
                        String stringWriter2 = stringWriter.toString();
                        String str2 = "Encoder " + this.b + " cannot be used with color format " + this.f36061a;
                        WLogger.e(TAG, str2 + "," + e.toString());
                        this.f36062c += str2 + "\n" + stringWriter2;
                        e.printStackTrace();
                        f();
                        i5++;
                        i3++;
                    }
                } finally {
                    f();
                }
            }
        }
        a(false);
        Log.e(TAG, "No usable encoder were found on the phone for resolution " + this.e + "x" + this.f);
        throw new RuntimeException("No usable encoder were found on the phone for resolution " + this.e + "x" + this.f);
    }

    private boolean c() {
        String str = this.e + "x" + this.f + "-";
        SharedPreferences sharedPreferences = this.m;
        if (sharedPreferences == null) {
            return true;
        }
        if (sharedPreferences.contains("libstreaming-" + str + "lastSdk")) {
            int i = this.m.getInt("libstreaming-" + str + "lastSdk", 0);
            SharedPreferences sharedPreferences2 = this.m;
            StringBuilder sb = new StringBuilder();
            sb.append("libstreaming-");
            sb.append(str);
            sb.append("lastVersion");
            return Build.VERSION.SDK_INT > i || 3 > sharedPreferences2.getInt(sb.toString(), 0);
        }
        return true;
    }

    private void d() {
        int i;
        int i2;
        this.k = new byte[(this.g * 3) / 2];
        int i3 = 0;
        while (true) {
            int i4 = i3;
            i = this.g;
            if (i4 >= i) {
                break;
            }
            this.k[i4] = (byte) ((i4 % 199) + 40);
            i3 = i4 + 1;
        }
        for (i2 = i; i2 < (this.g * 3) / 2; i2 += 2) {
            byte[] bArr = this.k;
            bArr[i2] = (byte) ((i2 % 200) + 40);
            bArr[i2 + 1] = (byte) (((i2 + 99) % 200) + 40);
        }
    }

    public static EncoderDebugger debug(Context context, int i, int i2) {
        EncoderDebugger debug;
        synchronized (EncoderDebugger.class) {
            try {
                WLogger.e(TAG, "EncoderDebugger debug");
                debug = debug(PreferenceManager.getDefaultSharedPreferences(context), i, i2);
            } catch (Throwable th) {
                throw th;
            }
        }
        return debug;
    }

    public static EncoderDebugger debug(SharedPreferences sharedPreferences, int i, int i2) {
        EncoderDebugger encoderDebugger;
        synchronized (EncoderDebugger.class) {
            try {
                WLogger.e(TAG, "EncoderDebugger debug2");
                encoderDebugger = new EncoderDebugger(sharedPreferences, i, i2);
                encoderDebugger.b();
            } catch (Throwable th) {
                throw th;
            }
        }
        return encoderDebugger;
    }

    private void e() throws IOException {
        WLogger.e(TAG, "configureEncoder");
        this.d = MediaCodec.createByCodecName(this.b);
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat("video/avc", this.e, this.f);
        createVideoFormat.setInteger(MediaFormat.KEY_BIT_RATE, 1000000);
        createVideoFormat.setInteger(MediaFormat.KEY_FRAME_RATE, 20);
        createVideoFormat.setInteger(MediaFormat.KEY_COLOR_FORMAT, this.f36061a);
        createVideoFormat.setInteger(MediaFormat.KEY_I_FRAME_INTERVAL, 5);
        this.d.configure(createVideoFormat, null, null, 1);
        this.d.start();
    }

    private void f() {
        MediaCodec mediaCodec = this.d;
        if (mediaCodec != null) {
            try {
                mediaCodec.stop();
            } catch (Exception e) {
            }
            try {
                this.d.release();
            } catch (Exception e2) {
            }
        }
    }

    private long g() {
        ByteBuffer[] byteBufferArr;
        int i;
        int i2;
        WLogger.e(TAG, "searchSPSandPPS");
        long h = h();
        ByteBuffer[] inputBuffers = this.d.getInputBuffers();
        ByteBuffer[] outputBuffers = this.d.getOutputBuffers();
        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
        byte[] bArr = new byte[128];
        long j = 0;
        int i3 = 4;
        int i4 = 4;
        while (true) {
            int i5 = i4;
            if (j >= 3000000 || (this.h != null && this.i != null)) {
                break;
            }
            int dequeueInputBuffer = this.d.dequeueInputBuffer(50000L);
            if (dequeueInputBuffer >= 0) {
                a(inputBuffers[dequeueInputBuffer].capacity() >= this.j.length, "The input buffer is not big enough.");
                inputBuffers[dequeueInputBuffer].clear();
                ByteBuffer byteBuffer = inputBuffers[dequeueInputBuffer];
                byte[] bArr2 = this.j;
                byteBuffer.put(bArr2, 0, bArr2.length);
                this.d.queueInputBuffer(dequeueInputBuffer, 0, this.j.length, h(), 0);
            } else {
                WLogger.e(TAG, "No buffer available !");
            }
            int dequeueOutputBuffer = this.d.dequeueOutputBuffer(bufferInfo, 50000L);
            if (dequeueOutputBuffer == -2) {
                MediaFormat outputFormat = this.d.getOutputFormat();
                ByteBuffer byteBuffer2 = outputFormat.getByteBuffer("csd-0");
                ByteBuffer byteBuffer3 = outputFormat.getByteBuffer("csd-1");
                this.h = new byte[byteBuffer2.capacity() - 4];
                byteBuffer2.position(4);
                byte[] bArr3 = this.h;
                byteBuffer2.get(bArr3, 0, bArr3.length);
                this.i = new byte[byteBuffer3.capacity() - 4];
                byteBuffer3.position(4);
                byte[] bArr4 = this.i;
                byteBuffer3.get(bArr4, 0, bArr4.length);
                break;
            }
            if (dequeueOutputBuffer == -3) {
                byteBufferArr = this.d.getOutputBuffers();
                i = i3;
                i2 = i5;
            } else {
                byteBufferArr = outputBuffers;
                i = i3;
                i2 = i5;
                if (dequeueOutputBuffer >= 0) {
                    int i6 = bufferInfo.size;
                    i = i3;
                    i2 = i5;
                    if (i6 < 128) {
                        outputBuffers[dequeueOutputBuffer].get(bArr, 0, i6);
                        i = i3;
                        i2 = i5;
                        if (i6 > 0) {
                            i = i3;
                            i2 = i5;
                            if (bArr[0] == 0) {
                                i = i3;
                                i2 = i5;
                                if (bArr[1] == 0) {
                                    i = i3;
                                    i2 = i5;
                                    if (bArr[2] == 0) {
                                        i = i3;
                                        i2 = i5;
                                        if (bArr[3] == 1) {
                                            while (true) {
                                                i = i3;
                                                i2 = i5;
                                                if (i3 >= i6) {
                                                    break;
                                                }
                                                while (true) {
                                                    if ((bArr[i3 + 0] != 0 || bArr[i3 + 1] != 0 || bArr[i3 + 2] != 0 || bArr[i3 + 3] != 1) && i3 + 3 < i6) {
                                                        i3++;
                                                    }
                                                }
                                                int i7 = i3;
                                                if (i3 + 3 >= i6) {
                                                    i7 = i6;
                                                }
                                                if ((bArr[i5] & 31) == 7) {
                                                    int i8 = i7 - i5;
                                                    byte[] bArr5 = new byte[i8];
                                                    this.h = bArr5;
                                                    System.arraycopy((Object) bArr, i5, (Object) bArr5, 0, i8);
                                                } else {
                                                    int i9 = i7 - i5;
                                                    byte[] bArr6 = new byte[i9];
                                                    this.i = bArr6;
                                                    System.arraycopy((Object) bArr, i5, (Object) bArr6, 0, i9);
                                                }
                                                i5 = i7 + 4;
                                                i3 = i5;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    this.d.releaseOutputBuffer(dequeueOutputBuffer, false);
                    byteBufferArr = outputBuffers;
                }
            }
            j = h() - h;
            outputBuffers = byteBufferArr;
            i3 = i;
            i4 = i2;
        }
        boolean z = true;
        boolean z2 = this.i != null;
        if (this.h == null) {
            z = false;
        }
        a(z2 & z, "Could not determine the SPS & PPS.");
        byte[] bArr7 = this.i;
        this.p = Base64.encodeToString(bArr7, 0, bArr7.length, 2);
        byte[] bArr8 = this.h;
        this.q = Base64.encodeToString(bArr8, 0, bArr8.length, 2);
        WLogger.e(TAG, "searchSPSandPPS end");
        return j;
    }

    private long h() {
        return System.nanoTime() / 1000;
    }

    public int getEncoderColorFormat() {
        return this.f36061a;
    }

    public String getEncoderName() {
        return this.b;
    }

    public String getErrorLog() {
        return this.f36062c;
    }

    public NV21Convert getNV21Convertor() {
        return this.l;
    }

    public String toString() {
        return "EncoderDebugger [mEncoderColorFormat=" + this.f36061a + ", mEncoderName=" + this.b + ", mErrorLog=" + this.f36062c + ", mEncoder=" + this.d + ", mWidth=" + this.e + ", mHeight=" + this.f + ", mSize=" + this.g + ", mSPS=" + Arrays.toString(this.h) + ", mPPS=" + Arrays.toString(this.i) + ", mData=" + Arrays.toString(this.j) + ", mInitialImage=" + Arrays.toString(this.k) + ", mNV21=" + this.l + ", mPreferences=" + this.m + ", mVideo=" + Arrays.toString(this.n) + ", mDecodedVideo=" + Arrays.toString(this.o) + ", mB64PPS=" + this.p + ", mB64SPS=" + this.q + "]";
    }
}
