package com.tencent.thumbplayer.core.decoder;

import android.view.Surface;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/core/decoder/ITPMediaCodecDecoder.class */
public interface ITPMediaCodecDecoder {
    public static final int BOOL_ENABLE_ASYNC_MODE = 1;
    public static final int BOOL_ENABLE_MEDIACODEC_OUTPUT_DATA = 5;
    public static final int BOOL_ENABLE_MEDIACODEC_REUSE = 4;
    public static final int BOOL_ENABLE_SET_OUTPUT_SURFACE_API = 0;
    public static final int BOOL_SET_IS_ADTS = 2;
    public static final int BOOL_SET_IS_AUDIO_PASSTHROUGH = 3;
    public static final int BYTES_SET_CSD0_DATA = 200;
    public static final int BYTES_SET_CSD1_DATA = 201;
    public static final int BYTES_SET_CSD2_DATA = 202;
    public static final int OBJECT_SET_MEDIA_CRYPTO = 300;
    public static final int TP_CODEC_RETURN_CODE_EOS = 2;
    public static final int TP_CODEC_RETURN_CODE_ERROR = 3;
    public static final int TP_CODEC_RETURN_CODE_INTERNAL_RESET = 4;
    public static final int TP_CODEC_RETURN_CODE_OK = 0;
    public static final int TP_CODEC_RETURN_CODE_TRY_AGAIN = 1;
    public static final int TP_ERROR_DECODE_FAILED = 103;
    public static final int TP_ERROR_FLUSH_FAILED = 104;
    public static final int TP_ERROR_INVALID_CODECPAR = 100;
    public static final int TP_ERROR_NO_CODEC = 101;
    public static final int TP_ERROR_OPEN_FAILED = 102;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/core/decoder/ITPMediaCodecDecoder$MediaCodecReturnCode.class */
    public @interface MediaCodecReturnCode {
    }

    int decode(byte[] bArr, boolean z, long j, boolean z2);

    TPFrameInfo dequeueOutputBuffer();

    int flush();

    boolean initDecoder(String str, int i, int i2, int i3, int i4);

    boolean initDecoder(String str, int i, int i2, int i3, Surface surface, int i4, int i5, int i6);

    int release();

    int releaseOutputBuffer(int i, boolean z);

    void setCryptoInfo(int i, int[] iArr, int[] iArr2, byte[] bArr, byte[] bArr2, int i2);

    int setOperateRate(float f);

    int setOutputSurface(Surface surface);

    boolean setParamBool(int i, boolean z);

    boolean setParamBytes(int i, byte[] bArr);

    boolean setParamInt(int i, int i2);

    boolean setParamLong(int i, long j);

    boolean setParamObject(int i, Object obj);

    boolean setParamString(int i, String str);

    int signalEndOfStream();

    boolean startDecoder();
}
