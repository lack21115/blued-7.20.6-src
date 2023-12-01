package com.tencent.ugc.common;

import android.media.MediaFormat;
import com.blued.das.live.LiveProtos;
import com.cdo.oaps.ad.p;
import com.sina.weibo.sdk.constant.WBConstants;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.n;
import com.tencent.liteav.videobase.utils.Rotation;
import com.tencent.liteav.videoproducer.encoder.VideoEncodeParams;
import com.tencent.liteav.videoproducer.encoder.VideoEncoderDef;
import com.tencent.ugc.UGCTransitionRules;
import com.tencent.ugc.common.UGCConstants;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/common/UGCTranscodeVideoEncodeParamsDecider.class */
public class UGCTranscodeVideoEncodeParamsDecider {
    private static final String TAG = "UGCTranscodeVideoEncodeParamsDecider";
    private List<MediaFormat> mVideoMediaFormatList;
    private n mVideoResolution;
    private final n mExpectSize = new n(1080, WBConstants.SDK_NEW_PAY_VERSION);
    private n mGenerateSize = new n();
    private UGCConstants.SourceType mSourceType = UGCConstants.SourceType.VIDEO;
    private boolean mFullIFrame = false;
    private int mVideoCompress = 4;
    private int mEncodeBitrate = 0;
    private VideoEncoderDef.EncoderProfile mEncodeProfile = VideoEncoderDef.EncoderProfile.PROFILE_HIGH;
    private Rotation mEncodeRotation = Rotation.NORMAL;

    private n adjustPictureOutSize(n nVar, n nVar2) {
        int c2;
        int i;
        if (((float) nVar.c()) >= nVar2.c()) {
            c2 = nVar2.f36340a;
            i = (int) (c2 / nVar.c());
        } else {
            c2 = (int) (nVar2.b * nVar.c());
            i = nVar2.b;
        }
        n nVar3 = new n();
        nVar3.f36340a = ((c2 + 15) / 16) * 16;
        nVar3.b = ((i + 15) / 16) * 16;
        LiteavLog.i(TAG, "origin= " + nVar + ", expectSize= " + nVar2 + ", outSize= " + nVar3);
        return nVar3;
    }

    private n adjustVideoOutSize(n nVar, n nVar2) {
        if ((nVar.f36340a > nVar2.f36340a || nVar.b > nVar2.b) && (nVar.f36340a > nVar2.b || nVar.b > nVar2.f36340a)) {
            double c2 = nVar.c();
            int min = nVar.f36340a >= nVar.b ? Math.min((int) (nVar2.f36340a * c2), nVar2.b) : Math.min((int) (nVar2.b * c2), nVar2.f36340a);
            int i = (((int) (min / c2)) + 15) / 16;
            n nVar3 = new n();
            nVar3.f36340a = ((min + 15) / 16) * 16;
            nVar3.b = i * 16;
            LiteavLog.i(TAG, "adjustOutSize origin: " + nVar + ", expectSize: " + nVar2 + ", outSize: " + nVar3);
            return nVar3;
        }
        return new n(nVar);
    }

    private int getDecidedGOP() {
        List<MediaFormat> list = this.mVideoMediaFormatList;
        if (list == null) {
            return 3;
        }
        return getNumberFromMediaFormat(list.get(0), MediaFormat.KEY_I_FRAME_INTERVAL, 3);
    }

    private n getDecidedOutputSize() {
        n nVar;
        n nVar2 = this.mVideoResolution;
        if (nVar2 != null) {
            nVar = new n(nVar2);
        } else {
            List<MediaFormat> list = this.mVideoMediaFormatList;
            if (list == null) {
                this.mGenerateSize = this.mExpectSize;
            } else if (list.size() > 1) {
                this.mGenerateSize = getOutputSizeForMultipleSource(this.mVideoMediaFormatList);
            } else {
                this.mGenerateSize = getOutputSizeForSingleSource(this.mVideoMediaFormatList.get(0));
            }
            nVar = new n(this.mGenerateSize);
        }
        if (this.mEncodeRotation == Rotation.ROTATION_90 || this.mEncodeRotation == Rotation.ROTATION_270) {
            nVar.a();
        }
        nVar.f36340a = ((nVar.f36340a + 15) / 16) * 16;
        nVar.b = ((nVar.b + 15) / 16) * 16;
        return nVar;
    }

    private int getDecidedVideoBitrate(n nVar) {
        if (this.mFullIFrame) {
            return (nVar.f36340a >= 1280 || nVar.b >= 1280) ? 15000 : 24000;
        }
        int i = this.mEncodeBitrate;
        if (i != 0) {
            return i;
        }
        int i2 = this.mVideoCompress;
        if (i2 == 0 || i2 == 1) {
            return 2400;
        }
        if (i2 != 2) {
            if (i2 != 3) {
                return i2 != 4 ? 5000 : 12000;
            }
            return 9600;
        }
        return p.f;
    }

    private int getDecidedVideoFPS() {
        List<MediaFormat> list = this.mVideoMediaFormatList;
        int i = 30;
        if (list == null) {
            return 30;
        }
        if (list.size() == 1) {
            i = getNumberFromMediaFormat(this.mVideoMediaFormatList.get(0), MediaFormat.KEY_FRAME_RATE, 30);
        }
        return i;
    }

    private int getNumberFromMediaFormat(MediaFormat mediaFormat, String str, int i) {
        if (mediaFormat.containsKey(str)) {
            try {
                return mediaFormat.getInteger(str);
            } catch (ClassCastException e) {
                LiteavLog.w(TAG, "getNumberFromMediaFormat integer ClassCastException: ".concat(String.valueOf(e)));
                try {
                    return (int) mediaFormat.getFloat(str);
                } catch (ClassCastException e2) {
                    LiteavLog.w(TAG, "getNumberFromMediaFormat float ClassCastException: ".concat(String.valueOf(e2)));
                    return i;
                }
            }
        }
        return i;
    }

    private n getOutputSizeForMultipleSource(List<MediaFormat> list) {
        boolean z;
        Iterator<MediaFormat> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = true;
                break;
            }
            n sizeFromMediaFormat = getSizeFromMediaFormat(it.next());
            if (sizeFromMediaFormat.b > sizeFromMediaFormat.f36340a) {
                z = false;
                break;
            }
        }
        n nVar = new n(this.mExpectSize);
        if (z) {
            nVar.a();
        }
        return nVar;
    }

    private n getOutputSizeForSingleSource(MediaFormat mediaFormat) {
        if (mediaFormat == null) {
            return new n(0, 0);
        }
        n sizeFromMediaFormat = getSizeFromMediaFormat(mediaFormat);
        if (sizeFromMediaFormat.f36340a != 0 && sizeFromMediaFormat.b != 0) {
            return this.mSourceType == UGCConstants.SourceType.VIDEO ? adjustVideoOutSize(sizeFromMediaFormat, this.mExpectSize) : adjustPictureOutSize(sizeFromMediaFormat, this.mExpectSize);
        }
        LiteavLog.i(TAG, "calculateGenerateSize origin: ".concat(String.valueOf(sizeFromMediaFormat)));
        return sizeFromMediaFormat;
    }

    private n getSizeFromMediaFormat(MediaFormat mediaFormat) {
        int integer;
        n nVar = new n();
        nVar.f36340a = mediaFormat.getInteger("width");
        nVar.b = mediaFormat.getInteger("height");
        if (LiteavSystemInfo.getSystemOSVersionInt() >= 23) {
            try {
                integer = mediaFormat.getInteger("rotation-degrees");
            } catch (Exception e) {
                LiteavLog.i(TAG, "get KEY_ROTATION fail, ".concat(String.valueOf(e)));
            }
            if (integer != 90 || integer == 270) {
                nVar.a();
            }
            return nVar;
        }
        integer = 0;
        if (integer != 90) {
        }
        nVar.a();
        return nVar;
    }

    public VideoEncodeParams getDecidedEncodeParams() {
        VideoEncodeParams videoEncodeParams = new VideoEncodeParams();
        videoEncodeParams.annexb = true;
        videoEncodeParams.bitrateMode = VideoEncoderDef.BitrateMode.VBR;
        videoEncodeParams.fullIFrame = false;
        videoEncodeParams.isTranscodingMode = true;
        videoEncodeParams.encoderProfile = this.mEncodeProfile;
        n decidedOutputSize = getDecidedOutputSize();
        videoEncodeParams.width = decidedOutputSize.f36340a;
        videoEncodeParams.height = decidedOutputSize.b;
        videoEncodeParams.setFullIFrame(this.mFullIFrame);
        videoEncodeParams.gop = getDecidedGOP();
        videoEncodeParams.fps = getDecidedVideoFPS();
        videoEncodeParams.bitrate = getDecidedVideoBitrate(this.mGenerateSize);
        LiteavLog.i(TAG, "getVideoEncodeParams: ".concat(String.valueOf(videoEncodeParams)));
        return videoEncodeParams;
    }

    public void setEncodeBitrate(int i) {
        if (this.mEncodeBitrate == i) {
            return;
        }
        LiteavLog.i(TAG, "setVideoBitrate ".concat(String.valueOf(i)));
        this.mEncodeBitrate = i;
    }

    public void setEncodeOutputSize(n nVar) {
        this.mVideoResolution = nVar;
    }

    public void setEncodeProfile(int i) {
        LiteavLog.i(TAG, "setEncodeProfile ".concat(String.valueOf(i)));
        if (i == 2) {
            this.mEncodeProfile = VideoEncoderDef.EncoderProfile.PROFILE_MAIN;
        } else if (i == 3) {
            this.mEncodeProfile = VideoEncoderDef.EncoderProfile.PROFILE_HIGH;
        } else {
            this.mEncodeProfile = VideoEncoderDef.EncoderProfile.PROFILE_BASELINE;
        }
    }

    public void setEncodeRotation(Rotation rotation) {
        if (this.mEncodeRotation == rotation) {
            return;
        }
        LiteavLog.i(TAG, "setRenderRotation ".concat(String.valueOf(rotation)));
        this.mEncodeRotation = rotation;
    }

    public void setFullIFrame(boolean z) {
        if (z == this.mFullIFrame) {
            return;
        }
        LiteavLog.i(TAG, "setFullIFrame ".concat(String.valueOf(z)));
        this.mFullIFrame = z;
    }

    public void setInputVideoMediaFormat(List<MediaFormat> list) {
        this.mVideoMediaFormatList = list;
    }

    public void setOutputResolution(int i) {
        if (i == this.mVideoCompress) {
            return;
        }
        this.mVideoCompress = i;
        if (i == 0) {
            this.mExpectSize.f36340a = 360;
            this.mExpectSize.b = 640;
        } else if (i == 1) {
            this.mExpectSize.f36340a = 480;
            this.mExpectSize.b = 640;
        } else if (i == 2) {
            this.mExpectSize.f36340a = LiveProtos.Event.LIVE_BAG_CHAT_MARK_SHOW_VALUE;
            this.mExpectSize.b = 960;
        } else if (i == 3) {
            this.mExpectSize.f36340a = UGCTransitionRules.DEFAULT_IMAGE_WIDTH;
            this.mExpectSize.b = 1280;
        } else if (i == 4) {
            this.mExpectSize.f36340a = 1080;
            this.mExpectSize.b = WBConstants.SDK_NEW_PAY_VERSION;
        }
        LiteavLog.i(TAG, "setVideoCompress " + i + ", expectSize = " + this.mExpectSize);
    }

    public void setSourceType(UGCConstants.SourceType sourceType) {
        if (this.mSourceType == sourceType) {
            return;
        }
        LiteavLog.i(TAG, "setSourceType ".concat(String.valueOf(sourceType)));
        this.mSourceType = sourceType;
    }
}
