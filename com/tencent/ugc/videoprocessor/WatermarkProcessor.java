package com.tencent.ugc.videoprocessor;

import android.graphics.Bitmap;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.n;
import com.tencent.liteav.beauty.b.o;
import com.tencent.liteav.videobase.frame.PixelFrame;
import com.tencent.liteav.videobase.utils.OpenGlUtils;
import com.tencent.ugc.TXVideoEditConstants;
import com.tencent.ugc.UGCLicenseChecker;
import com.tencent.ugc.UGCWatermarkFilter;
import com.tencent.ugc.datereport.UGCDataReport;
import com.tencent.ugc.videoprocessor.watermark.AnimatedPasterFilterChain;
import com.tencent.ugc.videoprocessor.watermark.PasterFilterChain;
import com.tencent.ugc.videoprocessor.watermark.SubtitleFilterChain;
import com.tencent.ugc.videoprocessor.watermark.TailWaterMarkChain;
import com.tencent.ugc.videoprocessor.watermark.data.TailWaterMark;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/videoprocessor/WatermarkProcessor.class */
public class WatermarkProcessor {
    private static final String TAG = "WatermarkProcessor";
    private com.tencent.liteav.videobase.frame.e mGLTexturePool;
    private ArrayList<o> mLastWaterMarkList = new ArrayList<>();
    private int mRenderMode = 1;
    private com.tencent.liteav.videobase.utils.d mDelayQueue = new com.tencent.liteav.videobase.utils.d();
    private n mRenderTargetSize = new n();
    private boolean mHasSetWaterMark = false;
    private UGCWatermarkFilter mWatermarkFilter = new UGCWatermarkFilter();
    private SubtitleFilterChain mSubtitleFilterChain = new SubtitleFilterChain();
    private PasterFilterChain mPasterFilterChain = new PasterFilterChain();
    private AnimatedPasterFilterChain mAnimatedPasterFilterChain = new AnimatedPasterFilterChain();
    private TailWaterMarkChain mTailWaterMarkChain = new TailWaterMarkChain();

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0019, code lost:
        if (r0.size() == 0) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void collectWaterMarkFromAnimatedPaster(java.util.ArrayList<com.tencent.liteav.beauty.b.o> r6, com.tencent.liteav.videobase.frame.PixelFrame r7) {
        /*
            r5 = this;
            r0 = r5
            com.tencent.ugc.videoprocessor.watermark.AnimatedPasterFilterChain r0 = r0.mAnimatedPasterFilterChain
            java.util.List r0 = r0.getAnimatedPasterList()
            r11 = r0
            r0 = r11
            if (r0 == 0) goto L1c
            r0 = r11
            r10 = r0
            r0 = r11
            int r0 = r0.size()
            if (r0 != 0) goto L38
        L1c:
            r0 = r5
            com.tencent.ugc.videoprocessor.watermark.AnimatedPasterFilterChain r0 = r0.mAnimatedPasterFilterChain
            r1 = r7
            int r1 = r1.getWidth()
            r2 = r7
            int r2 = r2.getHeight()
            r3 = r5
            int r3 = r3.mRenderMode
            r0.normalized(r1, r2, r3)
            r0 = r5
            com.tencent.ugc.videoprocessor.watermark.AnimatedPasterFilterChain r0 = r0.mAnimatedPasterFilterChain
            java.util.List r0 = r0.getAnimatedPasterList()
            r10 = r0
        L38:
            r0 = r10
            java.util.Iterator r0 = r0.iterator()
            r10 = r0
        L41:
            r0 = r10
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto Lb7
            r0 = r10
            java.lang.Object r0 = r0.next()
            com.tencent.ugc.videoprocessor.watermark.data.AnimatedPaster r0 = (com.tencent.ugc.videoprocessor.watermark.data.AnimatedPaster) r0
            r11 = r0
            r0 = r7
            long r0 = r0.getTimestamp()
            r8 = r0
            r0 = r8
            r1 = r11
            long r1 = r1.mStartTime
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 < 0) goto L41
            r0 = r8
            r1 = r11
            long r1 = r1.mEndTime
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 > 0) goto L41
            r0 = r11
            java.lang.String r0 = r0.mPasterPath
            android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeFile(r0)
            r12 = r0
            r0 = r12
            if (r0 == 0) goto L41
            r0 = r11
            float r0 = r0.mRotation
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L9c
            r0 = r6
            r1 = r5
            r2 = r12
            r3 = r11
            com.tencent.ugc.TXVideoEditConstants$TXRect r3 = r3.mFrame
            com.tencent.liteav.beauty.b.o r1 = r1.newWaterMarkTag(r2, r3)
            boolean r0 = r0.add(r1)
            goto L41
        L9c:
            r0 = r6
            r1 = r5
            r2 = r11
            float r2 = r2.mRotation
            r3 = r12
            android.graphics.Bitmap r2 = com.tencent.ugc.videoprocessor.util.BitmapUtils.rotateImage(r2, r3)
            r3 = r11
            com.tencent.ugc.TXVideoEditConstants$TXRect r3 = r3.mFrame
            com.tencent.liteav.beauty.b.o r1 = r1.newWaterMarkTag(r2, r3)
            boolean r0 = r0.add(r1)
            goto L41
        Lb7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.ugc.videoprocessor.WatermarkProcessor.collectWaterMarkFromAnimatedPaster(java.util.ArrayList, com.tencent.liteav.videobase.frame.PixelFrame):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0019, code lost:
        if (r0.size() == 0) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void collectWaterMarkFromStaticPaster(java.util.ArrayList<com.tencent.liteav.beauty.b.o> r6, com.tencent.liteav.videobase.frame.PixelFrame r7) {
        /*
            r5 = this;
            r0 = r5
            com.tencent.ugc.videoprocessor.watermark.PasterFilterChain r0 = r0.mPasterFilterChain
            java.util.List r0 = r0.getPasterList()
            r11 = r0
            r0 = r11
            if (r0 == 0) goto L1c
            r0 = r11
            r10 = r0
            r0 = r11
            int r0 = r0.size()
            if (r0 != 0) goto L38
        L1c:
            r0 = r5
            com.tencent.ugc.videoprocessor.watermark.PasterFilterChain r0 = r0.mPasterFilterChain
            r1 = r7
            int r1 = r1.getWidth()
            r2 = r7
            int r2 = r2.getHeight()
            r3 = r5
            int r3 = r3.mRenderMode
            r0.normalized(r1, r2, r3)
            r0 = r5
            com.tencent.ugc.videoprocessor.watermark.PasterFilterChain r0 = r0.mPasterFilterChain
            java.util.List r0 = r0.getPasterList()
            r10 = r0
        L38:
            r0 = r10
            java.util.Iterator r0 = r0.iterator()
            r10 = r0
        L41:
            r0 = r10
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L86
            r0 = r10
            java.lang.Object r0 = r0.next()
            com.tencent.ugc.TXVideoEditConstants$TXPaster r0 = (com.tencent.ugc.TXVideoEditConstants.TXPaster) r0
            r11 = r0
            r0 = r7
            long r0 = r0.getTimestamp()
            r8 = r0
            r0 = r8
            r1 = r11
            long r1 = r1.startTime
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 < 0) goto L41
            r0 = r8
            r1 = r11
            long r1 = r1.endTime
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 > 0) goto L41
            r0 = r6
            r1 = r5
            r2 = r11
            android.graphics.Bitmap r2 = r2.pasterImage
            r3 = r11
            com.tencent.ugc.TXVideoEditConstants$TXRect r3 = r3.frame
            com.tencent.liteav.beauty.b.o r1 = r1.newWaterMarkTag(r2, r3)
            boolean r0 = r0.add(r1)
            goto L41
        L86:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.ugc.videoprocessor.WatermarkProcessor.collectWaterMarkFromStaticPaster(java.util.ArrayList, com.tencent.liteav.videobase.frame.PixelFrame):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0019, code lost:
        if (r0.size() == 0) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void collectWaterMarkFromSubtitle(java.util.ArrayList<com.tencent.liteav.beauty.b.o> r6, com.tencent.liteav.videobase.frame.PixelFrame r7) {
        /*
            r5 = this;
            r0 = r5
            com.tencent.ugc.videoprocessor.watermark.SubtitleFilterChain r0 = r0.mSubtitleFilterChain
            java.util.List r0 = r0.getSubtitleList()
            r11 = r0
            r0 = r11
            if (r0 == 0) goto L1c
            r0 = r11
            r10 = r0
            r0 = r11
            int r0 = r0.size()
            if (r0 != 0) goto L38
        L1c:
            r0 = r5
            com.tencent.ugc.videoprocessor.watermark.SubtitleFilterChain r0 = r0.mSubtitleFilterChain
            r1 = r7
            int r1 = r1.getWidth()
            r2 = r7
            int r2 = r2.getHeight()
            r3 = r5
            int r3 = r3.mRenderMode
            r0.normalized(r1, r2, r3)
            r0 = r5
            com.tencent.ugc.videoprocessor.watermark.SubtitleFilterChain r0 = r0.mSubtitleFilterChain
            java.util.List r0 = r0.getSubtitleList()
            r10 = r0
        L38:
            r0 = r10
            java.util.Iterator r0 = r0.iterator()
            r10 = r0
        L41:
            r0 = r10
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L86
            r0 = r10
            java.lang.Object r0 = r0.next()
            com.tencent.ugc.TXVideoEditConstants$TXSubtitle r0 = (com.tencent.ugc.TXVideoEditConstants.TXSubtitle) r0
            r11 = r0
            r0 = r7
            long r0 = r0.getTimestamp()
            r8 = r0
            r0 = r8
            r1 = r11
            long r1 = r1.startTime
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 < 0) goto L41
            r0 = r8
            r1 = r11
            long r1 = r1.endTime
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 > 0) goto L41
            r0 = r6
            r1 = r5
            r2 = r11
            android.graphics.Bitmap r2 = r2.titleImage
            r3 = r11
            com.tencent.ugc.TXVideoEditConstants$TXRect r3 = r3.frame
            com.tencent.liteav.beauty.b.o r1 = r1.newWaterMarkTag(r2, r3)
            boolean r0 = r0.add(r1)
            goto L41
        L86:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.ugc.videoprocessor.WatermarkProcessor.collectWaterMarkFromSubtitle(java.util.ArrayList, com.tencent.liteav.videobase.frame.PixelFrame):void");
    }

    private void collectWaterMarkFromTail(ArrayList<o> arrayList, PixelFrame pixelFrame) {
        TailWaterMark tailWaterMark = this.mTailWaterMarkChain.getTailWaterMark(pixelFrame);
        if (tailWaterMark == null) {
            return;
        }
        arrayList.add(newWaterMarkTag(tailWaterMark.getWaterMark(), tailWaterMark.getmWaterMarkRect()));
        this.mWatermarkFilter.setAlpha(this.mTailWaterMarkChain.getAlpha());
    }

    private boolean compareWaterMarkList(List<o> list, List<o> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                return true;
            }
            o oVar = list.get(i2);
            o oVar2 = list2.get(i2);
            if (!oVar.f22706a.equals(oVar2.f22706a) || Math.abs(oVar.b - oVar2.b) > 1.0E-5d || Math.abs(oVar.f22707c - oVar2.f22707c) > 1.0E-5d || Math.abs(oVar.d - oVar2.d) > 1.0E-5d) {
                return false;
            }
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$setWaterMark$0(WatermarkProcessor watermarkProcessor, Bitmap bitmap, TXVideoEditConstants.TXRect tXRect) {
        watermarkProcessor.mHasSetWaterMark = true;
        watermarkProcessor.mWatermarkFilter.enableWatermark(true);
        watermarkProcessor.mWatermarkFilter.setWatermark(bitmap, tXRect.x, tXRect.y, tXRect.width);
    }

    private o newWaterMarkTag(Bitmap bitmap, TXVideoEditConstants.TXRect tXRect) {
        o oVar = new o();
        oVar.f22706a = bitmap;
        oVar.b = tXRect.x;
        oVar.f22707c = tXRect.y;
        oVar.d = tXRect.width;
        return oVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAnimatedPasterListInternal(List<TXVideoEditConstants.TXAnimatedPaster> list, n nVar) {
        LiteavLog.i(TAG, "setAnimatedPasterListInternal animatedPasterList: ".concat(String.valueOf(list)));
        if (!UGCLicenseChecker.isStandardFunctionSupport()) {
            LiteavLog.e(TAG, "setAnimatedPasterList is not supported in UGC_Smart license");
        } else if (list == null) {
            this.mAnimatedPasterFilterChain.setAnimatedPasterList(null, nVar);
        } else {
            UGCDataReport.reportDAU(1026);
            ArrayList arrayList = new ArrayList();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= list.size()) {
                    this.mAnimatedPasterFilterChain.setAnimatedPasterList(arrayList, nVar);
                    return;
                }
                TXVideoEditConstants.TXAnimatedPaster tXAnimatedPaster = list.get(i2);
                TXVideoEditConstants.TXAnimatedPaster tXAnimatedPaster2 = new TXVideoEditConstants.TXAnimatedPaster();
                TXVideoEditConstants.TXRect tXRect = new TXVideoEditConstants.TXRect();
                tXRect.width = tXAnimatedPaster.frame.width;
                tXRect.x = tXAnimatedPaster.frame.x;
                tXRect.y = tXAnimatedPaster.frame.y;
                tXAnimatedPaster2.frame = tXRect;
                tXAnimatedPaster2.animatedPasterPathFolder = tXAnimatedPaster.animatedPasterPathFolder;
                tXAnimatedPaster2.startTime = tXAnimatedPaster.startTime;
                tXAnimatedPaster2.endTime = tXAnimatedPaster.endTime;
                tXAnimatedPaster2.rotation = tXAnimatedPaster.rotation;
                arrayList.add(tXAnimatedPaster2);
                i = i2 + 1;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPasterListInternal(List<TXVideoEditConstants.TXPaster> list, n nVar) {
        if (!UGCLicenseChecker.isStandardFunctionSupport()) {
            LiteavLog.e(TAG, "setPasterList is not supported in UGC_Smart license");
            return;
        }
        LiteavLog.i(TAG, "==== setPasterList ==== pasterList: ".concat(String.valueOf(list)));
        if (list == null) {
            this.mPasterFilterChain.setPasterList(null, nVar);
            return;
        }
        UGCDataReport.reportDAU(1025);
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                this.mPasterFilterChain.setPasterList(arrayList, nVar);
                return;
            }
            TXVideoEditConstants.TXPaster tXPaster = list.get(i2);
            TXVideoEditConstants.TXPaster tXPaster2 = new TXVideoEditConstants.TXPaster();
            TXVideoEditConstants.TXRect tXRect = new TXVideoEditConstants.TXRect();
            tXRect.width = tXPaster.frame.width;
            tXRect.x = tXPaster.frame.x;
            tXRect.y = tXPaster.frame.y;
            tXPaster2.frame = tXRect;
            tXPaster2.pasterImage = tXPaster.pasterImage;
            tXPaster2.startTime = tXPaster.startTime;
            tXPaster2.endTime = tXPaster.endTime;
            arrayList.add(tXPaster2);
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSubtitleListInternal(List<TXVideoEditConstants.TXSubtitle> list, n nVar) {
        LiteavLog.i(TAG, "setSubtitleListInternal subtitleList: ".concat(String.valueOf(list)));
        if (list == null) {
            this.mSubtitleFilterChain.setSubtitleList(null, nVar);
            return;
        }
        UGCDataReport.reportDAU(1027);
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                this.mSubtitleFilterChain.setSubtitleList(arrayList, nVar);
                return;
            }
            TXVideoEditConstants.TXSubtitle tXSubtitle = list.get(i2);
            TXVideoEditConstants.TXSubtitle tXSubtitle2 = new TXVideoEditConstants.TXSubtitle();
            TXVideoEditConstants.TXRect tXRect = new TXVideoEditConstants.TXRect();
            tXRect.width = tXSubtitle.frame.width;
            tXRect.x = tXSubtitle.frame.x;
            tXRect.y = tXSubtitle.frame.y;
            tXSubtitle2.frame = tXRect;
            tXSubtitle2.titleImage = tXSubtitle.titleImage;
            tXSubtitle2.startTime = tXSubtitle.startTime;
            tXSubtitle2.endTime = tXSubtitle.endTime;
            arrayList.add(tXSubtitle2);
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTailWaterMarkInternal(Bitmap bitmap, TXVideoEditConstants.TXRect tXRect, long j, int i) {
        LiteavLog.i(TAG, "setTailWaterMarkInternal: " + bitmap + ", rect: " + tXRect + ", startTime: " + j + ", duration: " + i);
        UGCDataReport.reportDAU(1029);
        TXVideoEditConstants.TXRect tXRect2 = new TXVideoEditConstants.TXRect();
        tXRect2.width = tXRect.width;
        tXRect2.x = tXRect.x;
        tXRect2.y = tXRect.y;
        this.mTailWaterMarkChain.setTailWaterMark(new TailWaterMark(bitmap, tXRect2, j, i * 1000));
    }

    private boolean updateWaterMarkList(PixelFrame pixelFrame) {
        ArrayList<o> arrayList = new ArrayList<>();
        collectWaterMarkFromSubtitle(arrayList, pixelFrame);
        collectWaterMarkFromStaticPaster(arrayList, pixelFrame);
        collectWaterMarkFromAnimatedPaster(arrayList, pixelFrame);
        collectWaterMarkFromTail(arrayList, pixelFrame);
        if (compareWaterMarkList(this.mLastWaterMarkList, arrayList)) {
            ArrayList<o> arrayList2 = this.mLastWaterMarkList;
            return (arrayList2 != null && arrayList2.size() > 0) || this.mHasSetWaterMark;
        }
        this.mWatermarkFilter.setWaterMarkList(arrayList);
        this.mLastWaterMarkList.clear();
        this.mLastWaterMarkList = arrayList;
        return true;
    }

    public float getBlurLevel() {
        return this.mTailWaterMarkChain.getBlurLevel();
    }

    public void initialize(com.tencent.liteav.videobase.frame.e eVar, int i, int i2) {
        this.mGLTexturePool = eVar;
        this.mWatermarkFilter.initialize(eVar);
        this.mWatermarkFilter.enableWatermark(true);
        this.mWatermarkFilter.onOutputSizeChanged(i, i2);
    }

    public PixelFrame process(PixelFrame pixelFrame, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        this.mDelayQueue.a();
        if (updateWaterMarkList(pixelFrame)) {
            com.tencent.liteav.videobase.frame.d a2 = this.mGLTexturePool.a(pixelFrame.getWidth(), pixelFrame.getHeight());
            this.mWatermarkFilter.onDraw(pixelFrame.getTextureId(), a2, floatBuffer, floatBuffer2);
            PixelFrame a3 = a2.a(OpenGlUtils.getCurrentContext());
            a3.setTimestamp(pixelFrame.getTimestamp());
            a2.release();
            return a3;
        }
        return null;
    }

    public void setAnimatedPasterList(List<TXVideoEditConstants.TXAnimatedPaster> list) {
        this.mDelayQueue.a(d.a(this, list, new n(this.mRenderTargetSize)));
    }

    public void setPasterList(List<TXVideoEditConstants.TXPaster> list) {
        this.mDelayQueue.a(e.a(this, list, new n(this.mRenderTargetSize)));
    }

    public void setRenderMode(int i) {
        this.mRenderMode = i;
    }

    public void setRenderTargetSize(int i, int i2) {
        LiteavLog.i(TAG, "setRenderResolution: width:" + i + "  height:" + i2);
        this.mRenderTargetSize = new n(i, i2);
    }

    public void setSubtitleList(List<TXVideoEditConstants.TXSubtitle> list) {
        this.mDelayQueue.a(c.a(this, list, new n(this.mRenderTargetSize)));
    }

    public void setTailWaterMark(Bitmap bitmap, TXVideoEditConstants.TXRect tXRect, long j, int i) {
        this.mDelayQueue.a(b.a(this, bitmap, tXRect, j, i));
    }

    public void setWaterMark(Bitmap bitmap, TXVideoEditConstants.TXRect tXRect) {
        this.mDelayQueue.a(a.a(this, bitmap, tXRect));
    }

    public void uninitialize() {
        this.mWatermarkFilter.uninitialize();
        TailWaterMarkChain tailWaterMarkChain = this.mTailWaterMarkChain;
        if (tailWaterMarkChain != null) {
            tailWaterMarkChain.clear();
            this.mTailWaterMarkChain = null;
        }
        AnimatedPasterFilterChain animatedPasterFilterChain = this.mAnimatedPasterFilterChain;
        if (animatedPasterFilterChain != null) {
            animatedPasterFilterChain.clear();
            this.mAnimatedPasterFilterChain = null;
        }
        SubtitleFilterChain subtitleFilterChain = this.mSubtitleFilterChain;
        if (subtitleFilterChain != null) {
            subtitleFilterChain.clear();
            this.mSubtitleFilterChain = null;
        }
        PasterFilterChain pasterFilterChain = this.mPasterFilterChain;
        if (pasterFilterChain != null) {
            pasterFilterChain.clear();
            this.mPasterFilterChain = null;
        }
    }
}
