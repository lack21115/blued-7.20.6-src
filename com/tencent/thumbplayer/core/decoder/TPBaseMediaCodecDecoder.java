package com.tencent.thumbplayer.core.decoder;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import com.anythink.expressad.exoplayer.k.o;
import com.tencent.thumbplayer.core.common.TPCodecUtils;
import com.tencent.thumbplayer.core.common.TPNativeLog;
import com.tencent.thumbplayer.core.common.TPSystemInfo;
import com.tencent.thumbplayer.g.a;
import com.tencent.thumbplayer.g.b;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/core/decoder/TPBaseMediaCodecDecoder.class */
public abstract class TPBaseMediaCodecDecoder implements ITPMediaCodecDecoder {
    private static final int DUMP_BYTE_BUFFER_BYTES = 100;
    private static final int DUMP_ONE_LINE_BYTES = 20;
    private static final int MEDIA_CODEC_ERROR_INDEX = -1000;
    private static long MEDIA_CODEC_INPUT_TIMEOUT_US = 2000;
    private static long MEDIA_CODEC_OUTPUT_TIMEOUT_US = 2000;
    private static final int MSG_FLUSH = 1002;
    private static final int MSG_RELEASE = 1003;
    private static final int MSG_RELEASE_OUTPUT_BUFFER = 1000;
    private static final int MSG_SET_OUTPUT_SURFACE = 1001;
    private static boolean sTMediaCodecInited = false;
    protected int mCodecId;
    private b mCodec = null;
    protected Surface mSurface = null;
    protected boolean mStarted = false;
    private TPFrameInfo mFrameInfo = new TPFrameInfo();
    private boolean mEnableSetOutputSurfaceApi = false;
    private MediaCodec.CryptoInfo mCryptoInfo = null;
    protected MediaCrypto mMediaCrypto = null;
    protected boolean mEnableAsyncMode = false;
    private HandlerThread mDecodeThread = null;
    private AsyncDecodeHandler mDecoderHandler = null;
    private BlockingQueue<Integer> mInputQueue = new LinkedBlockingQueue();
    private BlockingQueue<TPFrameInfo> mOutputQueue = new LinkedBlockingQueue();
    private boolean mRestartCodecOnException = false;
    protected int mDrmType = -1;
    private boolean mEnableAudioPassThrough = false;
    protected boolean mEnableMediaCodecReuse = false;
    private final Object mThreadLock = new Object();
    private int mHandlerResult = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/core/decoder/TPBaseMediaCodecDecoder$AsyncDecodeHandler.class */
    public class AsyncDecodeHandler extends Handler {
        AsyncDecodeHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            synchronized (TPBaseMediaCodecDecoder.this.mThreadLock) {
                int i = 0;
                boolean z = false;
                switch (message.what) {
                    case 1000:
                        TPBaseMediaCodecDecoder tPBaseMediaCodecDecoder = TPBaseMediaCodecDecoder.this;
                        int i2 = message.arg1;
                        if (message.arg2 == 1) {
                            z = true;
                        }
                        i = tPBaseMediaCodecDecoder.onReleaseOutputBuffer(i2, z);
                        break;
                    case 1001:
                        i = TPBaseMediaCodecDecoder.this.onSetOutputSurface((Surface) message.obj);
                        break;
                    case 1002:
                        i = TPBaseMediaCodecDecoder.this.onFlush();
                        break;
                    case 1003:
                        i = TPBaseMediaCodecDecoder.this.onRelease();
                        break;
                }
                TPBaseMediaCodecDecoder.this.handleMessageComplete(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/core/decoder/TPBaseMediaCodecDecoder$BufferCallback.class */
    public class BufferCallback extends b.a {
        private BufferCallback() {
        }

        @Override // com.tencent.thumbplayer.g.b.a
        public void onError(b bVar, MediaCodec.CodecException codecException) {
            String logTag = TPBaseMediaCodecDecoder.this.getLogTag();
            TPNativeLog.printLog(4, logTag, "onError: " + TPBaseMediaCodecDecoder.this.getStackTrace(codecException));
            TPBaseMediaCodecDecoder.this.handleRelease();
        }

        @Override // com.tencent.thumbplayer.g.b.a
        public void onInputBufferAvailable(b bVar, int i) {
            try {
                TPBaseMediaCodecDecoder.this.mInputQueue.put(Integer.valueOf(i));
            } catch (Exception e) {
                TPNativeLog.printLog(3, TPBaseMediaCodecDecoder.this.getLogTag(), TPBaseMediaCodecDecoder.this.getStackTrace(e));
            }
        }

        @Override // com.tencent.thumbplayer.g.b.a
        public void onOutputBufferAvailable(b bVar, int i, MediaCodec.BufferInfo bufferInfo) {
            try {
                TPFrameInfo tPFrameInfo = new TPFrameInfo();
                tPFrameInfo.errCode = 0;
                tPFrameInfo.bufferIndex = i;
                tPFrameInfo.ptsUs = bufferInfo.presentationTimeUs;
                TPBaseMediaCodecDecoder.this.processOutputBuffer(bVar, i, bufferInfo, tPFrameInfo);
                TPBaseMediaCodecDecoder.this.mOutputQueue.put(tPFrameInfo);
            } catch (Exception e) {
                TPNativeLog.printLog(3, TPBaseMediaCodecDecoder.this.getLogTag(), TPBaseMediaCodecDecoder.this.getStackTrace(e));
            }
        }

        @Override // com.tencent.thumbplayer.g.b.a
        public void onOutputFormatChanged(b bVar, MediaFormat mediaFormat) {
            TPBaseMediaCodecDecoder.this.processOutputFormatChanged(mediaFormat);
        }
    }

    public TPBaseMediaCodecDecoder(int i) {
        this.mCodecId = i;
        initTMediaCodec();
    }

    private void bufferSizeCheck(ByteBuffer byteBuffer, byte[] bArr) {
        if (byteBuffer.remaining() < bArr.length) {
            String logTag = getLogTag();
            TPNativeLog.printLog(4, logTag, "decodeAsync, not enough space, byteBuffer.remaining:" + byteBuffer.remaining() + ", buffer size:" + bArr.length);
            try {
                dumpByteArray(bArr, 0, 100, 20);
            } catch (Exception e) {
                TPNativeLog.printLog(4, getLogTag(), e.toString());
            }
        }
    }

    private int decodeAsync(byte[] bArr, boolean z, long j, boolean z2) {
        Integer poll = this.mInputQueue.poll();
        if (poll == null) {
            return 1;
        }
        try {
            ByteBuffer c2 = this.mCodec.c(poll.intValue());
            if (c2 != null) {
                bufferSizeCheck(c2, bArr);
                c2.put(bArr);
            }
            if (!z2 || this.mCryptoInfo == null) {
                this.mCodec.a(poll.intValue(), 0, bArr.length, j, z ? 1 : 0);
                return 0;
            }
            this.mCodec.a(poll.intValue(), 0, this.mCryptoInfo, j, z ? 1 : 0);
            return 0;
        } catch (Exception e) {
            return onMediaCodecException(e);
        }
    }

    private TPFrameInfo dequeueOutputBufferAsync() {
        this.mFrameInfo.errCode = 1;
        TPFrameInfo poll = this.mOutputQueue.poll();
        TPFrameInfo tPFrameInfo = poll;
        if (poll == null) {
            tPFrameInfo = this.mFrameInfo;
        }
        return tPFrameInfo;
    }

    private void dumpByteArray(byte[] bArr, int i, int i2, int i3) {
        if (bArr == null || i < 0 || i2 <= 0 || i >= bArr.length || i >= i2 || i3 <= 0) {
            throw new IllegalArgumentException();
        }
        int i4 = i2;
        if (bArr.length <= i2) {
            i4 = bArr.length;
        }
        int min = Math.min(i4 - i, 100);
        StringBuilder sb = new StringBuilder();
        TPNativeLog.printLog(2, getLogTag(), "dumpByteArray begin:");
        int i5 = 0;
        int i6 = i;
        while (true) {
            int i7 = i6;
            if (i7 >= min + i) {
                TPNativeLog.printLog(2, getLogTag(), "dumpByteArray end.");
                return;
            }
            String hexString = Integer.toHexString(bArr[i7] & 255);
            String str = hexString;
            if (hexString.length() == 1) {
                str = "0".concat(String.valueOf(hexString));
            }
            sb.append(str.toUpperCase());
            i5++;
            if (i5 % i3 == 0) {
                TPNativeLog.printLog(2, getLogTag(), sb.toString());
                sb.setLength(0);
            } else {
                sb.append(" ");
            }
            i6 = i7 + 1;
        }
    }

    private void exitDecodeThread() {
        if (this.mDecodeThread != null) {
            if (Build.VERSION.SDK_INT >= 18) {
                this.mDecodeThread.quitSafely();
            } else {
                this.mDecodeThread.quit();
            }
            try {
                this.mDecodeThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private int flushAsync() {
        TPNativeLog.printLog(2, getLogTag(), "flushAsync: ");
        Message obtainMessage = this.mDecoderHandler.obtainMessage();
        obtainMessage.what = 1002;
        return waitingForHandleMessage(obtainMessage);
    }

    private int handleFlush() {
        TPNativeLog.printLog(2, getLogTag(), "handleFlush: ");
        b bVar = this.mCodec;
        if (bVar == null) {
            return 104;
        }
        try {
            bVar.h();
            return 0;
        } catch (Exception e) {
            return onMediaCodecException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleMessageComplete(int i) {
        this.mHandlerResult = i;
        this.mThreadLock.notify();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int handleRelease() {
        b bVar = this.mCodec;
        if (bVar == null) {
            return 101;
        }
        this.mStarted = false;
        try {
            try {
                bVar.f();
                this.mCodec.g();
                this.mCodec = null;
                return 0;
            } catch (Exception e) {
                String logTag = getLogTag();
                TPNativeLog.printLog(4, logTag, "stop: failed!" + getStackTrace(e));
                this.mCodec.g();
                this.mCodec = null;
                return 3;
            }
        } catch (Throwable th) {
            this.mCodec.g();
            this.mCodec = null;
            throw th;
        }
    }

    private int handleReleaseOutputBuffer(int i, boolean z) {
        b bVar = this.mCodec;
        if (bVar == null || i < 0) {
            return 3;
        }
        try {
            bVar.a(i, z);
            return 0;
        } catch (Exception e) {
            return onMediaCodecException(e);
        }
    }

    private int handleSetOutputSurface(Surface surface) {
        int i;
        TPNativeLog.printLog(2, getLogTag(), "setOutputSurface: ".concat(String.valueOf(surface)));
        Surface surface2 = this.mSurface;
        if (surface2 == surface) {
            TPNativeLog.printLog(3, getLogTag(), "setOutputSurface: set the same surface.");
            return 0;
        }
        this.mSurface = surface;
        if (this.mCodec != null) {
            i = 3;
            if (surface2 != null) {
                i = 3;
                if (surface != null) {
                    i = 3;
                    try {
                        if (surface.isValid()) {
                            i = 3;
                            if (Build.VERSION.SDK_INT >= 23) {
                                i = 3;
                                if (this.mEnableSetOutputSurfaceApi) {
                                    this.mCodec.a(surface);
                                }
                            }
                        }
                    } catch (Exception e) {
                        TPNativeLog.printLog(4, getLogTag(), "setOutputSurface onMediaCodecException:\n" + getStackTrace(e));
                        return 3;
                    }
                }
            }
            return i;
        }
        i = 0;
        return i;
    }

    private int handleSignalEndOfStream(int i) {
        try {
            this.mCodec.a(i, 0, 0, 0L, 4);
            return 0;
        } catch (Exception e) {
            String logTag = getLogTag();
            TPNativeLog.printLog(4, logTag, "handleSignalEndOfStream: failed!" + getStackTrace(e));
            return 3;
        }
    }

    private boolean initMediaCodecInternal() {
        try {
            List<String> mimeCandidates = getMimeCandidates();
            String str = null;
            String str2 = null;
            boolean z = false;
            for (int i = 0; i < mimeCandidates.size() && str == null; i++) {
                str2 = mimeCandidates.get(i);
                TPNativeLog.printLog(2, getLogTag(), "initMediaCodec with mime:" + str2 + " mDrmType:" + this.mDrmType);
                z = this.mMediaCrypto != null ? this.mMediaCrypto.requiresSecureDecoderComponent(str2) : false;
                if (z && TPCodecUtils.isInDRMLevel1Blacklist(this.mDrmType)) {
                    TPNativeLog.printLog(2, getLogTag(), "Device " + TPSystemInfo.getDeviceName() + " DrmType " + this.mDrmType + " fallback to L3.");
                    z = false;
                }
                str = getCodecName(str2, z);
                TPNativeLog.printLog(2, getLogTag(), "initMediaCodec got codecName:" + str + " secureComponent " + z);
            }
            if (str == null) {
                TPNativeLog.printLog(4, getLogTag(), "initMediaCodec failed, codecName is null.");
                return false;
            }
            if (o.D.equals(str2)) {
                TPNativeLog.printLog(2, getLogTag(), "initMediaCodec current mime type:" + str2 + " is audio dts, need set input timeout to 0!");
                MEDIA_CODEC_INPUT_TIMEOUT_US = 0L;
                MEDIA_CODEC_OUTPUT_TIMEOUT_US = 0L;
            }
            b a2 = b.a(str);
            this.mCodec = a2;
            a2.a(this.mEnableMediaCodecReuse && !this.mEnableAsyncMode);
            this.mCodec.a(new com.tencent.thumbplayer.g.a.b() { // from class: com.tencent.thumbplayer.core.decoder.TPBaseMediaCodecDecoder.2
                @Override // com.tencent.thumbplayer.g.a.b, com.tencent.thumbplayer.g.a.a
                public void onReuseCodecAPIException(String str3, Throwable th) {
                    super.onReuseCodecAPIException(str3, th);
                    TPMediaCodecManager.onMediaCodecException(TPBaseMediaCodecDecoder.this.mCodecId, str3);
                }

                @Override // com.tencent.thumbplayer.g.a.b, com.tencent.thumbplayer.g.a.a
                public void onStarted(Boolean bool, String str3) {
                    super.onStarted(bool, str3);
                    TPMediaCodecManager.onMediaCodecReady(TPBaseMediaCodecDecoder.this.mCodecId, str3);
                }
            });
            TPNativeLog.printLog(2, getLogTag(), "initMediaCodec codec name: ".concat(String.valueOf(str)));
            if (this.mEnableAsyncMode && Build.VERSION.SDK_INT >= 23) {
                TPNativeLog.printLog(2, getLogTag(), "MediaCodec EnableAsyncMode！");
                HandlerThread handlerThread = new HandlerThread("MediaCodecThread");
                this.mDecodeThread = handlerThread;
                handlerThread.start();
                this.mDecoderHandler = new AsyncDecodeHandler(this.mDecodeThread.getLooper());
                this.mCodec.a(new BufferCallback(), this.mDecoderHandler);
            }
            TPMediaCodecManager.onMediaCodecReportEvent(this.mCodecId, 1);
            configCodec(this.mCodec, str2);
            TPMediaCodecManager.onMediaCodecReportEvent(this.mCodecId, 2);
            TPMediaCodecManager.onMediaCodecReportEvent(this.mCodecId, 3);
            TPNativeLog.printLog(2, getLogTag(), "initMediaCodec, start codec start");
            this.mCodec.e();
            TPNativeLog.printLog(2, getLogTag(), "initMediaCodec, start codec finished");
            TPMediaCodecManager.onMediaCodecReportEvent(this.mCodecId, 4);
            this.mStarted = true;
            if (this.mDrmType != -1) {
                boolean z2 = TPCodecUtils.getDecoderName(str2, true) != null;
                TPMediaDrmInfo tPMediaDrmInfo = new TPMediaDrmInfo();
                tPMediaDrmInfo.supportSecureDecoder = z2;
                tPMediaDrmInfo.supportSecureDecrypt = z;
                tPMediaDrmInfo.componentName = str;
                tPMediaDrmInfo.drmType = this.mDrmType;
                TPNativeLog.printLog(2, getLogTag(), "DRM Info: supportSecureDecoder: " + tPMediaDrmInfo.supportSecureDecoder + " supportSecureDecrypt:" + tPMediaDrmInfo.supportSecureDecrypt + " componentName: " + tPMediaDrmInfo.componentName + " drmType: " + tPMediaDrmInfo.drmType);
                TPMediaCodecManager.onMediaDrmInfo(this.mCodecId, tPMediaDrmInfo);
                return true;
            }
            return true;
        } catch (Exception e) {
            TPMediaCodecManager.onMediaCodecReportEvent(this.mCodecId, 4);
            TPNativeLog.printLog(4, getLogTag(), getStackTrace(e));
            return false;
        }
    }

    private static void initTMediaCodec() {
        synchronized (TPBaseMediaCodecDecoder.class) {
            try {
                if (sTMediaCodecInited) {
                    return;
                }
                a.b();
                a.a().a(true);
                a.a().a(new com.tencent.thumbplayer.g.h.a() { // from class: com.tencent.thumbplayer.core.decoder.TPBaseMediaCodecDecoder.1
                    @Override // com.tencent.thumbplayer.g.h.a
                    public final void d(String str, String str2) {
                        TPNativeLog.printLog(1, str, str2);
                    }

                    @Override // com.tencent.thumbplayer.g.h.a
                    public final void e(String str, String str2, Throwable th) {
                        TPNativeLog.printLog(4, str, str2);
                    }

                    @Override // com.tencent.thumbplayer.g.h.a
                    public final void i(String str, String str2) {
                        TPNativeLog.printLog(2, str, str2);
                    }

                    @Override // com.tencent.thumbplayer.g.h.a
                    public final void v(String str, String str2) {
                        TPNativeLog.printLog(0, str, str2);
                    }

                    @Override // com.tencent.thumbplayer.g.h.a
                    public final void w(String str, String str2, Throwable th) {
                        TPNativeLog.printLog(3, str, str2);
                    }
                });
                sTMediaCodecInited = true;
            } finally {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int onFlush() {
        this.mInputQueue.clear();
        this.mOutputQueue.clear();
        int handleFlush = handleFlush();
        this.mCodec.e();
        return handleFlush;
    }

    private int onMediaCodecException(Exception exc) {
        String logTag = getLogTag();
        TPNativeLog.printLog(4, logTag, "onMediaCodecException!\n" + getStackTrace(exc));
        resetFrameInfo();
        processMediaCodecException(exc);
        if (this.mRestartCodecOnException) {
            initMediaCodecInternal();
            return 4;
        }
        handleRelease();
        return 103;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int onRelease() {
        this.mInputQueue.clear();
        this.mOutputQueue.clear();
        return handleRelease();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int onReleaseOutputBuffer(int i, boolean z) {
        return handleReleaseOutputBuffer(i, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int onSetOutputSurface(Surface surface) {
        return handleSetOutputSurface(surface);
    }

    private int queueInputBuffer(byte[] bArr, long j, boolean z) {
        try {
            ByteBuffer[] j2 = this.mCodec.j();
            int a2 = this.mCodec.a(MEDIA_CODEC_INPUT_TIMEOUT_US);
            if (a2 < 0) {
                return a2 == -1 ? 1 : 103;
            }
            ByteBuffer byteBuffer = j2[a2];
            bufferSizeCheck(byteBuffer, bArr);
            byteBuffer.put(bArr);
            if (!z || this.mCryptoInfo == null) {
                this.mCodec.a(a2, 0, bArr.length, j, 0);
                return 0;
            }
            this.mCodec.a(a2, 0, this.mCryptoInfo, j, 0);
            return 0;
        } catch (Exception e) {
            return onMediaCodecException(e);
        }
    }

    private int releaseAsync() {
        TPNativeLog.printLog(2, getLogTag(), "releaseAsync: ");
        Message obtainMessage = this.mDecoderHandler.obtainMessage();
        obtainMessage.what = 1003;
        int waitingForHandleMessage = waitingForHandleMessage(obtainMessage);
        exitDecodeThread();
        return waitingForHandleMessage;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    private int releaseOutputBufferAsync(int i, boolean z) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    private void resetFrameInfo() {
        this.mFrameInfo.bufferIndex = -1000;
        this.mFrameInfo.ptsUs = -1L;
        this.mFrameInfo.data = null;
        this.mFrameInfo.errCode = 103;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0044, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private android.media.MediaCodecInfo selectCodec(java.lang.String r4) {
        /*
            r3 = this;
            int r0 = android.media.MediaCodecList.getCodecCount()
            r7 = r0
            r0 = 0
            r5 = r0
        L7:
            r0 = r5
            r1 = r7
            if (r0 >= r1) goto L4b
            r0 = r5
            android.media.MediaCodecInfo r0 = android.media.MediaCodecList.getCodecInfoAt(r0)
            r9 = r0
            r0 = r9
            boolean r0 = r0.isEncoder()
            if (r0 != 0) goto L44
            r0 = r9
            java.lang.String[] r0 = r0.getSupportedTypes()
            r10 = r0
            r0 = r10
            int r0 = r0.length
            r8 = r0
            r0 = 0
            r6 = r0
        L29:
            r0 = r6
            r1 = r8
            if (r0 >= r1) goto L44
            r0 = r10
            r1 = r6
            r0 = r0[r1]
            r1 = r4
            boolean r0 = r0.equalsIgnoreCase(r1)
            if (r0 == 0) goto L3d
            r0 = r9
            return r0
        L3d:
            r0 = r6
            r1 = 1
            int r0 = r0 + r1
            r6 = r0
            goto L29
        L44:
            r0 = r5
            r1 = 1
            int r0 = r0 + r1
            r5 = r0
            goto L7
        L4b:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.core.decoder.TPBaseMediaCodecDecoder.selectCodec(java.lang.String):android.media.MediaCodecInfo");
    }

    private int setOutputSurfaceAsync(Surface surface) {
        TPNativeLog.printLog(2, getLogTag(), "setOutputSurfaceAsync: ".concat(String.valueOf(surface)));
        Message obtainMessage = this.mDecoderHandler.obtainMessage();
        obtainMessage.what = 1001;
        obtainMessage.obj = surface;
        return waitingForHandleMessage(obtainMessage);
    }

    private int signalEndOfStreamAsync() {
        Integer poll = this.mInputQueue.poll();
        if (poll == null) {
            return 1;
        }
        return handleSignalEndOfStream(poll.intValue());
    }

    private int waitingForHandleMessage(Message message) {
        synchronized (this.mThreadLock) {
            message.sendToTarget();
            try {
                this.mThreadLock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return this.mHandlerResult;
    }

    abstract void configCodec(b bVar, String str);

    @Override // com.tencent.thumbplayer.core.decoder.ITPMediaCodecDecoder
    public int decode(byte[] bArr, boolean z, long j, boolean z2) {
        if (!this.mStarted || this.mCodec == null) {
            return 101;
        }
        return (!this.mEnableAsyncMode || Build.VERSION.SDK_INT < 23) ? queueInputBuffer(bArr, j, z2) : decodeAsync(bArr, z, j, z2);
    }

    @Override // com.tencent.thumbplayer.core.decoder.ITPMediaCodecDecoder
    public TPFrameInfo dequeueOutputBuffer() {
        String logTag;
        String str;
        if (this.mCodec == null) {
            return this.mFrameInfo;
        }
        resetFrameInfo();
        if (this.mEnableAsyncMode) {
            return dequeueOutputBufferAsync();
        }
        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
        try {
            int a2 = this.mCodec.a(bufferInfo, MEDIA_CODEC_OUTPUT_TIMEOUT_US);
            if (a2 < 0) {
                if (a2 == -2) {
                    processOutputFormatChanged(this.mCodec.i());
                } else if (a2 != -1) {
                    if (a2 != -3) {
                        if (bufferInfo.flags != 4) {
                            TPNativeLog.printLog(4, getLogTag(), "dequeueOutputBuffer: TP_ERROR_DECODE_FAILED! index = ".concat(String.valueOf(a2)));
                            this.mFrameInfo.errCode = 103;
                            return this.mFrameInfo;
                        }
                        logTag = getLogTag();
                        str = "dequeueOutputBuffer: BUFFER_FLAG_END_OF_STREAM!";
                        TPNativeLog.printLog(2, logTag, str);
                        this.mFrameInfo.errCode = 2;
                        return this.mFrameInfo;
                    }
                    TPNativeLog.printLog(2, getLogTag(), "dequeueOutputBuffer: INFO_OUTPUT_BUFFERS_CHANGED!");
                }
                this.mFrameInfo.errCode = 1;
                return this.mFrameInfo;
            } else if (bufferInfo.flags == 4) {
                logTag = getLogTag();
                str = "dequeueOutputBuffer: BUFFER_FLAG_END_OF_STREAM";
                TPNativeLog.printLog(2, logTag, str);
                this.mFrameInfo.errCode = 2;
                return this.mFrameInfo;
            } else {
                if (bufferInfo.flags == 2 && this.mEnableAudioPassThrough) {
                    TPNativeLog.printLog(2, getLogTag(), "dequeueOutputBuffer: BUFFER_FLAG_CODEC_CONFIG, AudioPassThrough");
                    this.mFrameInfo.bufferIndex = a2;
                    this.mFrameInfo.ptsUs = bufferInfo.presentationTimeUs;
                    processOutputConfigData(this.mCodec, a2, bufferInfo, this.mFrameInfo);
                } else {
                    this.mFrameInfo.bufferIndex = a2;
                    this.mFrameInfo.ptsUs = bufferInfo.presentationTimeUs;
                    this.mFrameInfo.errCode = 0;
                    processOutputBuffer(this.mCodec, a2, bufferInfo, this.mFrameInfo);
                }
                return this.mFrameInfo;
            }
        } catch (Exception e) {
            this.mFrameInfo.errCode = onMediaCodecException(e);
            return this.mFrameInfo;
        }
    }

    @Override // com.tencent.thumbplayer.core.decoder.ITPMediaCodecDecoder
    public int flush() {
        TPNativeLog.printLog(2, getLogTag(), "flush: ");
        if (this.mCodec == null) {
            return 104;
        }
        return this.mEnableAsyncMode ? flushAsync() : handleFlush();
    }

    abstract String getCodecName(String str, boolean z);

    abstract String getLogTag();

    abstract List<String> getMimeCandidates();

    /* JADX INFO: Access modifiers changed from: protected */
    public String getStackTrace(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    abstract void processMediaCodecException(Exception exc);

    abstract void processOutputBuffer(b bVar, int i, MediaCodec.BufferInfo bufferInfo, TPFrameInfo tPFrameInfo);

    abstract void processOutputConfigData(b bVar, int i, MediaCodec.BufferInfo bufferInfo, TPFrameInfo tPFrameInfo);

    abstract void processOutputFormatChanged(MediaFormat mediaFormat);

    @Override // com.tencent.thumbplayer.core.decoder.ITPMediaCodecDecoder
    public int release() {
        return this.mEnableAsyncMode ? releaseAsync() : handleRelease();
    }

    @Override // com.tencent.thumbplayer.core.decoder.ITPMediaCodecDecoder
    public int releaseOutputBuffer(int i, boolean z) {
        if (this.mCodec == null || i < 0) {
            return 3;
        }
        return this.mEnableAsyncMode ? releaseOutputBufferAsync(i, z) : handleReleaseOutputBuffer(i, z);
    }

    @Override // com.tencent.thumbplayer.core.decoder.ITPMediaCodecDecoder
    public void setCryptoInfo(int i, int[] iArr, int[] iArr2, byte[] bArr, byte[] bArr2, int i2) {
        if (this.mCryptoInfo == null) {
            this.mCryptoInfo = new MediaCodec.CryptoInfo();
        }
        this.mCryptoInfo.set(i, iArr, iArr2, bArr, bArr2, i2);
    }

    @Override // com.tencent.thumbplayer.core.decoder.ITPMediaCodecDecoder
    public int setOperateRate(float f) {
        if (this.mCodec != null) {
            try {
                if (Build.VERSION.SDK_INT >= 19) {
                    TPNativeLog.printLog(2, getLogTag(), "setOperateRate: ".concat(String.valueOf(f)));
                    Bundle bundle = new Bundle();
                    bundle.putShort("priority", (short) 0);
                    bundle.putFloat("operating-rate", f);
                    this.mCodec.a(bundle);
                    return 0;
                }
                return 0;
            } catch (Exception e) {
                String logTag = getLogTag();
                TPNativeLog.printLog(3, logTag, "setOperateRate: " + f + " failed.");
                return 0;
            }
        }
        return 0;
    }

    @Override // com.tencent.thumbplayer.core.decoder.ITPMediaCodecDecoder
    public int setOutputSurface(Surface surface) {
        return this.mEnableAsyncMode ? setOutputSurfaceAsync(surface) : handleSetOutputSurface(surface);
    }

    @Override // com.tencent.thumbplayer.core.decoder.ITPMediaCodecDecoder
    public boolean setParamBool(int i, boolean z) {
        if (i == 0) {
            this.mEnableSetOutputSurfaceApi = z;
            return true;
        } else if (i == 1) {
            if (this.mStarted) {
                TPNativeLog.printLog(3, getLogTag(), "BOOL_ENABLE_ASYNC_MODE must setup before started!");
                return true;
            }
            this.mEnableAsyncMode = z;
            return true;
        } else if (i != 3) {
            if (i != 4) {
                TPNativeLog.printLog(3, getLogTag(), "Unknown paramKey: ".concat(String.valueOf(i)));
                return false;
            }
            this.mEnableMediaCodecReuse = z;
            return true;
        } else {
            this.mEnableAudioPassThrough = z;
            String logTag = getLogTag();
            TPNativeLog.printLog(2, logTag, "BOOL_SET_IS_AUDIO_PASSTHROUGH mEnableAudioPassThrough:" + this.mEnableAudioPassThrough);
            return true;
        }
    }

    @Override // com.tencent.thumbplayer.core.decoder.ITPMediaCodecDecoder
    public boolean setParamBytes(int i, byte[] bArr) {
        return false;
    }

    @Override // com.tencent.thumbplayer.core.decoder.ITPMediaCodecDecoder
    public boolean setParamInt(int i, int i2) {
        return false;
    }

    @Override // com.tencent.thumbplayer.core.decoder.ITPMediaCodecDecoder
    public boolean setParamLong(int i, long j) {
        return false;
    }

    @Override // com.tencent.thumbplayer.core.decoder.ITPMediaCodecDecoder
    public boolean setParamObject(int i, Object obj) {
        if (i == 300) {
            this.mMediaCrypto = (MediaCrypto) obj;
            return true;
        }
        return false;
    }

    @Override // com.tencent.thumbplayer.core.decoder.ITPMediaCodecDecoder
    public boolean setParamString(int i, String str) {
        return false;
    }

    @Override // com.tencent.thumbplayer.core.decoder.ITPMediaCodecDecoder
    public int signalEndOfStream() {
        TPNativeLog.printLog(2, getLogTag(), "signalEndOfStream: ");
        b bVar = this.mCodec;
        if (bVar == null) {
            return 3;
        }
        if (this.mEnableAsyncMode) {
            return signalEndOfStreamAsync();
        }
        int a2 = bVar.a(MEDIA_CODEC_INPUT_TIMEOUT_US);
        return a2 >= 0 ? handleSignalEndOfStream(a2) : a2 == -1 ? 1 : 3;
    }

    @Override // com.tencent.thumbplayer.core.decoder.ITPMediaCodecDecoder
    public boolean startDecoder() {
        return initMediaCodecInternal();
    }
}
