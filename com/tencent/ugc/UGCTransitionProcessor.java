package com.tencent.ugc;

import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videobase.frame.PixelFrame;
import com.tencent.ugc.TXVideoEditConstants;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/UGCTransitionProcessor.class */
public class UGCTransitionProcessor {
    private final String TAG = "UGCTransitionProcessor";
    private final UGCCombineFrameFilter mCombineFrameFilter;
    private final int mOutputPixelHeight;
    private final int mOutputPixelWidth;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/UGCTransitionProcessor$TXCCombineFrame.class */
    public static class TXCCombineFrame {
        public PixelFrame drawInputFrame;
        public TXVideoEditConstants.TXAbsoluteRect drawRect;
        public TransformParams transformParams;
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/UGCTransitionProcessor$TransformParams.class */
    public static class TransformParams {
        public float scale = 1.0f;
        public int rotate = 0;
        public float alpha = 1.0f;
        public boolean isBackgroundTransparent = false;
    }

    public UGCTransitionProcessor(int i, int i2, com.tencent.liteav.videobase.frame.e eVar) {
        LiteavLog.i("UGCTransitionProcessor", "UGCTransitionProcessor pixelWidth = " + i + " pixelHeight = " + i2);
        this.mOutputPixelWidth = i;
        this.mOutputPixelHeight = i2;
        this.mCombineFrameFilter = new UGCCombineFrameFilter(eVar);
    }

    private void Retain(List<PixelFrame> list) {
        for (PixelFrame pixelFrame : list) {
            if (pixelFrame != null) {
                pixelFrame.retain();
            }
        }
    }

    private com.tencent.liteav.videobase.frame.d combineFramesWithTransitionType(List<TXCCombineFrame> list, long j, int i) {
        switch (i) {
            case 1:
                return processTwoPicLeftRightCombine(list, j);
            case 2:
                return processTwoPicUpDownCombine(list, j);
            case 3:
                return processTwoPicRotation(list, j);
            case 4:
            case 5:
                return processTwoPicZoom(list, j, i);
            case 6:
                return processTwoPicFaceInOut(list, j);
            default:
                return null;
        }
    }

    private static float getAlpha(int i, long j) {
        float f;
        long stayDurationMs = UGCTransitionRules.getStayDurationMs(i);
        long motionDurationMs = UGCTransitionRules.getMotionDurationMs(i);
        long j2 = stayDurationMs + motionDurationMs;
        long j3 = j - ((j / j2) * j2);
        if (i == 4 || i == 5) {
            float f2 = (float) stayDurationMs;
            float f3 = (float) motionDurationMs;
            float f4 = f2 + (0.8f * f3);
            float f5 = (float) j3;
            f = 1.0f;
            if (f5 > f4) {
                f = 1.0f;
                if (j3 <= j2) {
                    f = 1.0f - ((f5 - f4) / (f3 * 0.2f));
                }
            }
        } else if (i != 6) {
            return 1.0f;
        } else {
            f = 1.0f;
            if (j3 > stayDurationMs) {
                f = 1.0f;
                if (j3 <= j2) {
                    return 1.0f - (((float) (j3 - stayDurationMs)) / ((float) motionDurationMs));
                }
            }
        }
        return f;
    }

    private static float getCropOffset(int i, long j) {
        long stayDurationMs = UGCTransitionRules.getStayDurationMs(i);
        long motionDurationMs = UGCTransitionRules.getMotionDurationMs(i);
        long j2 = stayDurationMs + motionDurationMs;
        long j3 = j - ((j / j2) * j2);
        if (j3 < 0 || j3 > stayDurationMs) {
            return ((float) (j3 - stayDurationMs)) / ((float) motionDurationMs);
        }
        return 0.0f;
    }

    private TXVideoEditConstants.TXAbsoluteRect getFirstDrawRect(int i, int i2) {
        int i3;
        TXVideoEditConstants.TXAbsoluteRect tXAbsoluteRect = new TXVideoEditConstants.TXAbsoluteRect();
        tXAbsoluteRect.width = this.mOutputPixelWidth;
        tXAbsoluteRect.height = this.mOutputPixelHeight;
        float f = i;
        float f2 = i2;
        float f3 = f / f2;
        int i4 = this.mOutputPixelWidth;
        if (f3 >= i4 / this.mOutputPixelHeight) {
            float f4 = (i4 * i2) / f;
            tXAbsoluteRect.x = 0;
            tXAbsoluteRect.y = ((int) (this.mOutputPixelHeight - f4)) / 2;
            tXAbsoluteRect.height = (int) f4;
            return tXAbsoluteRect;
        }
        float f5 = (i3 * i) / f2;
        tXAbsoluteRect.x = ((int) (i4 - f5)) / 2;
        tXAbsoluteRect.y = 0;
        tXAbsoluteRect.width = (int) f5;
        return tXAbsoluteRect;
    }

    private static int getRotation(int i, long j) {
        if (i != 3) {
            return 0;
        }
        long stayDurationMs = UGCTransitionRules.getStayDurationMs(i);
        long motionDurationMs = UGCTransitionRules.getMotionDurationMs(i);
        long j2 = stayDurationMs + motionDurationMs;
        long j3 = j - ((j / j2) * j2);
        int i2 = 0;
        if (j3 > stayDurationMs) {
            i2 = 0;
            if (j3 <= j2) {
                i2 = (int) ((((float) (j3 - stayDurationMs)) / ((float) motionDurationMs)) * 360.0f);
            }
        }
        return i2;
    }

    private static float getScale(int i, long j) {
        long stayDurationMs = UGCTransitionRules.getStayDurationMs(i);
        long motionDurationMs = UGCTransitionRules.getMotionDurationMs(i);
        long j2 = stayDurationMs + motionDurationMs;
        long j3 = j - ((j / j2) * j2);
        if (i == 3) {
            if (j3 <= stayDurationMs || j3 > j2) {
                return 1.0f;
            }
            return 1.0f - (((float) (j3 - stayDurationMs)) / ((float) motionDurationMs));
        } else if (i == 4) {
            if (j3 <= stayDurationMs || j3 >= j2) {
                return 1.0f;
            }
            return ((((float) (j3 - stayDurationMs)) * 0.1f) / ((float) motionDurationMs)) + 1.0f;
        } else if (i != 5) {
            return 1.0f;
        } else {
            if (j3 < 0 || j3 > stayDurationMs) {
                if (j3 <= stayDurationMs || j3 > j2) {
                    return 1.0f;
                }
                return 1.1f - ((((float) (j3 - stayDurationMs)) * 0.1f) / ((float) motionDurationMs));
            }
            return 1.1f;
        }
    }

    private TXVideoEditConstants.TXAbsoluteRect getSecondDrawRect(int i, int i2, int i3) {
        int i4;
        TXVideoEditConstants.TXAbsoluteRect tXAbsoluteRect = new TXVideoEditConstants.TXAbsoluteRect();
        tXAbsoluteRect.width = this.mOutputPixelWidth;
        tXAbsoluteRect.height = this.mOutputPixelHeight;
        float f = i;
        float f2 = i2;
        float f3 = f / f2;
        int i5 = this.mOutputPixelWidth;
        if (f3 < i5 / this.mOutputPixelHeight) {
            float f4 = (i4 * i) / f2;
            if (i3 == 1) {
                tXAbsoluteRect.x = i5 + (((int) (i5 - f4)) / 2);
            } else {
                tXAbsoluteRect.x = ((int) (i5 - f4)) / 2;
            }
            if (i3 == 2) {
                tXAbsoluteRect.y = this.mOutputPixelHeight;
            } else {
                tXAbsoluteRect.y = 0;
            }
            tXAbsoluteRect.width = (int) f4;
            return tXAbsoluteRect;
        }
        float f5 = (i2 * i5) / f;
        if (i3 == 1) {
            tXAbsoluteRect.x = i5;
        } else {
            tXAbsoluteRect.x = 0;
        }
        if (i3 == 2) {
            int i6 = this.mOutputPixelHeight;
            tXAbsoluteRect.y = i6 + (((int) (i6 - f5)) / 2);
        } else {
            tXAbsoluteRect.y = ((int) (this.mOutputPixelHeight - f5)) / 2;
        }
        tXAbsoluteRect.height = (int) f5;
        return tXAbsoluteRect;
    }

    private com.tencent.liteav.videobase.frame.d processTwoPicFaceInOut(List<TXCCombineFrame> list, long j) {
        float alpha = getAlpha(6, j);
        TXCCombineFrame tXCCombineFrame = list.get(0);
        tXCCombineFrame.transformParams = new TransformParams();
        tXCCombineFrame.transformParams.alpha = alpha;
        if (list.size() > 1) {
            TXCCombineFrame tXCCombineFrame2 = list.get(1);
            tXCCombineFrame2.transformParams = new TransformParams();
            tXCCombineFrame2.transformParams.alpha = 1.0f - alpha;
        }
        this.mCombineFrameFilter.setCanvasSize(this.mOutputPixelWidth, this.mOutputPixelHeight);
        this.mCombineFrameFilter.setCropRect(null);
        return this.mCombineFrameFilter.combineFrame(list);
    }

    private com.tencent.liteav.videobase.frame.d processTwoPicLeftRightCombine(List<TXCCombineFrame> list, long j) {
        int cropOffset = (int) (getCropOffset(1, j) * this.mOutputPixelWidth);
        TXVideoEditConstants.TXAbsoluteRect tXAbsoluteRect = new TXVideoEditConstants.TXAbsoluteRect();
        tXAbsoluteRect.x = cropOffset;
        tXAbsoluteRect.width = this.mOutputPixelWidth;
        tXAbsoluteRect.height = this.mOutputPixelHeight;
        this.mCombineFrameFilter.setCanvasSize(this.mOutputPixelWidth * 2, this.mOutputPixelHeight);
        this.mCombineFrameFilter.setCropRect(tXAbsoluteRect);
        return this.mCombineFrameFilter.combineFrame(list);
    }

    private com.tencent.liteav.videobase.frame.d processTwoPicRotation(List<TXCCombineFrame> list, long j) {
        TXCCombineFrame tXCCombineFrame;
        int rotation = getRotation(3, j);
        float scale = getScale(3, j);
        TXCCombineFrame tXCCombineFrame2 = list.get(0);
        tXCCombineFrame2.transformParams = new TransformParams();
        tXCCombineFrame2.transformParams.rotate = rotation;
        tXCCombineFrame2.transformParams.scale = scale;
        tXCCombineFrame2.transformParams.isBackgroundTransparent = true;
        if (list.size() > 1) {
            tXCCombineFrame = list.get(1);
            tXCCombineFrame.transformParams = new TransformParams();
        } else {
            tXCCombineFrame = null;
        }
        if (rotation != 0) {
            tXCCombineFrame2.transformParams.isBackgroundTransparent = true;
            if (tXCCombineFrame != null) {
                tXCCombineFrame.transformParams.isBackgroundTransparent = true;
            }
        } else {
            tXCCombineFrame2.transformParams.alpha = 1.0f;
            if (tXCCombineFrame != null) {
                tXCCombineFrame.transformParams.alpha = 0.0f;
            }
        }
        this.mCombineFrameFilter.setCanvasSize(this.mOutputPixelWidth, this.mOutputPixelHeight);
        this.mCombineFrameFilter.setCropRect(null);
        return this.mCombineFrameFilter.combineFrame(list);
    }

    private com.tencent.liteav.videobase.frame.d processTwoPicUpDownCombine(List<TXCCombineFrame> list, long j) {
        int cropOffset = (int) (getCropOffset(2, j) * this.mOutputPixelHeight);
        TXVideoEditConstants.TXAbsoluteRect tXAbsoluteRect = new TXVideoEditConstants.TXAbsoluteRect();
        tXAbsoluteRect.y = cropOffset;
        tXAbsoluteRect.width = this.mOutputPixelWidth;
        tXAbsoluteRect.height = this.mOutputPixelHeight;
        this.mCombineFrameFilter.setCanvasSize(this.mOutputPixelWidth, this.mOutputPixelHeight * 2);
        this.mCombineFrameFilter.setCropRect(tXAbsoluteRect);
        return this.mCombineFrameFilter.combineFrame(list);
    }

    private com.tencent.liteav.videobase.frame.d processTwoPicZoom(List<TXCCombineFrame> list, long j, int i) {
        float scale = getScale(i, j);
        float alpha = getAlpha(i, j);
        TXCCombineFrame tXCCombineFrame = list.get(0);
        tXCCombineFrame.transformParams = new TransformParams();
        tXCCombineFrame.transformParams.scale = scale;
        tXCCombineFrame.transformParams.alpha = alpha;
        if (list.size() > 1) {
            TXCCombineFrame tXCCombineFrame2 = list.get(1);
            tXCCombineFrame2.transformParams = new TransformParams();
            if (i == 5) {
                tXCCombineFrame2.transformParams.scale = 1.1f;
            }
            tXCCombineFrame2.transformParams.alpha = 1.0f - alpha;
        }
        this.mCombineFrameFilter.setCanvasSize(this.mOutputPixelWidth, this.mOutputPixelHeight);
        this.mCombineFrameFilter.setCropRect(null);
        return this.mCombineFrameFilter.combineFrame(list);
    }

    private void releaseFrameList(List<TXCCombineFrame> list) {
        for (TXCCombineFrame tXCCombineFrame : list) {
            if (tXCCombineFrame.drawInputFrame != null) {
                tXCCombineFrame.drawInputFrame.release();
            }
        }
    }

    public PixelFrame processFrame(List<PixelFrame> list, int i) {
        if (list == null || list.size() == 0) {
            LiteavLog.e("UGCTransitionProcessor", "frameList is empty");
            return null;
        }
        Retain(list);
        ArrayList arrayList = new ArrayList();
        TXCCombineFrame tXCCombineFrame = new TXCCombineFrame();
        tXCCombineFrame.drawInputFrame = list.get(0);
        tXCCombineFrame.drawRect = getFirstDrawRect(tXCCombineFrame.drawInputFrame.getWidth(), tXCCombineFrame.drawInputFrame.getHeight());
        arrayList.add(tXCCombineFrame);
        if (list.size() > 1) {
            TXCCombineFrame tXCCombineFrame2 = new TXCCombineFrame();
            tXCCombineFrame2.drawInputFrame = list.get(1);
            tXCCombineFrame2.drawRect = getSecondDrawRect(tXCCombineFrame2.drawInputFrame.getWidth(), tXCCombineFrame2.drawInputFrame.getHeight(), i);
            arrayList.add(tXCCombineFrame2);
        }
        long timestamp = list.get(0).getTimestamp();
        com.tencent.liteav.videobase.frame.d combineFramesWithTransitionType = combineFramesWithTransitionType(arrayList, timestamp, i);
        releaseFrameList(arrayList);
        if (combineFramesWithTransitionType == null) {
            return null;
        }
        PixelFrame a2 = combineFramesWithTransitionType.a(list.get(0).getGLContext());
        a2.setTimestamp(timestamp);
        combineFramesWithTransitionType.release();
        return a2;
    }

    public void release() {
        this.mCombineFrameFilter.release();
    }
}
