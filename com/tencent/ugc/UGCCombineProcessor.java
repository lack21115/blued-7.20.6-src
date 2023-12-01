package com.tencent.ugc;

import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videobase.frame.PixelFrame;
import com.tencent.ugc.TXVideoEditConstants;
import com.tencent.ugc.UGCTransitionProcessor;
import java.util.LinkedList;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/UGCCombineProcessor.class */
public class UGCCombineProcessor {
    private final String TAG = "UGCCombineProcessor";
    private final com.tencent.liteav.videobase.frame.e mGLTexturePool;
    private final int mOutputPixelHeight;
    private final int mOutputPixelWidth;
    private final List<TXVideoEditConstants.TXAbsoluteRect> mScaleRectList;
    private final List<com.tencent.liteav.videobase.frame.j> mScaleRendererList;
    private final UGCCombineFrameFilter mUGCCombineProcessor;

    public UGCCombineProcessor(int i, int i2, com.tencent.liteav.videobase.frame.e eVar) {
        LiteavLog.i("UGCCombineProcessor", "UGCCombineProcessor pixelWidth = " + i + " pixelHeight = " + i2);
        this.mOutputPixelWidth = i;
        this.mOutputPixelHeight = i2;
        this.mGLTexturePool = eVar;
        this.mScaleRendererList = new LinkedList();
        this.mScaleRectList = new LinkedList();
        this.mUGCCombineProcessor = new UGCCombineFrameFilter(eVar);
    }

    private void Retain(List<PixelFrame> list) {
        for (PixelFrame pixelFrame : list) {
            if (pixelFrame != null) {
                pixelFrame.retain();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x006a, code lost:
        if (r0.height != r8.height) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.tencent.liteav.videobase.frame.PixelFrame preScale(com.tencent.liteav.videobase.frame.PixelFrame r7, com.tencent.ugc.TXVideoEditConstants.TXAbsoluteRect r8, int r9) {
        /*
            r6 = this;
            r0 = r6
            java.util.List<com.tencent.liteav.videobase.frame.j> r0 = r0.mScaleRendererList
            int r0 = r0.size()
            r1 = r9
            r2 = 1
            int r1 = r1 + r2
            if (r0 >= r1) goto L33
            r0 = r6
            java.util.List<com.tencent.liteav.videobase.frame.j> r0 = r0.mScaleRendererList
            com.tencent.liteav.videobase.frame.j r1 = new com.tencent.liteav.videobase.frame.j
            r2 = r1
            r3 = r8
            int r3 = r3.width
            r4 = r8
            int r4 = r4.height
            r2.<init>(r3, r4)
            boolean r0 = r0.add(r1)
            r0 = r6
            java.util.List<com.tencent.ugc.TXVideoEditConstants$TXAbsoluteRect> r0 = r0.mScaleRectList
            r1 = r8
            boolean r0 = r0.add(r1)
        L33:
            r0 = r6
            java.util.List<com.tencent.liteav.videobase.frame.j> r0 = r0.mScaleRendererList
            r1 = r9
            java.lang.Object r0 = r0.get(r1)
            com.tencent.liteav.videobase.frame.j r0 = (com.tencent.liteav.videobase.frame.j) r0
            r11 = r0
            r0 = r6
            java.util.List<com.tencent.ugc.TXVideoEditConstants$TXAbsoluteRect> r0 = r0.mScaleRectList
            r1 = r9
            java.lang.Object r0 = r0.get(r1)
            com.tencent.ugc.TXVideoEditConstants$TXAbsoluteRect r0 = (com.tencent.ugc.TXVideoEditConstants.TXAbsoluteRect) r0
            r12 = r0
            r0 = r12
            int r0 = r0.width
            r1 = r8
            int r1 = r1.width
            if (r0 != r1) goto L6d
            r0 = r11
            r10 = r0
            r0 = r12
            int r0 = r0.height
            r1 = r8
            int r1 = r1.height
            if (r0 == r1) goto L9a
        L6d:
            r0 = r11
            r0.a()
            com.tencent.liteav.videobase.frame.j r0 = new com.tencent.liteav.videobase.frame.j
            r1 = r0
            r2 = r8
            int r2 = r2.width
            r3 = r8
            int r3 = r3.height
            r1.<init>(r2, r3)
            r10 = r0
            r0 = r6
            java.util.List<com.tencent.liteav.videobase.frame.j> r0 = r0.mScaleRendererList
            r1 = r9
            java.lang.Object r0 = r0.remove(r1)
            r0 = r6
            java.util.List<com.tencent.liteav.videobase.frame.j> r0 = r0.mScaleRendererList
            r1 = r9
            r2 = r10
            r0.add(r1, r2)
        L9a:
            r0 = r6
            com.tencent.liteav.videobase.frame.e r0 = r0.mGLTexturePool
            r1 = r8
            int r1 = r1.width
            r2 = r8
            int r2 = r2.height
            com.tencent.liteav.videobase.frame.d r0 = r0.a(r1, r2)
            r8 = r0
            r0 = r10
            r1 = r7
            com.tencent.liteav.videobase.base.GLConstants$GLScaleType r2 = com.tencent.liteav.videobase.base.GLConstants.GLScaleType.CENTER_CROP
            r3 = r8
            r0.a(r1, r2, r3)
            r0 = r8
            r1 = r7
            java.lang.Object r1 = r1.getGLContext()
            com.tencent.liteav.videobase.frame.PixelFrame r0 = r0.a(r1)
            r10 = r0
            r0 = r10
            r1 = r7
            long r1 = r1.getTimestamp()
            r0.setTimestamp(r1)
            r0 = r8
            r0.release()
            r0 = r7
            r0.release()
            r0 = r10
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.ugc.UGCCombineProcessor.preScale(com.tencent.liteav.videobase.frame.PixelFrame, com.tencent.ugc.TXVideoEditConstants$TXAbsoluteRect, int):com.tencent.liteav.videobase.frame.PixelFrame");
    }

    private void releaseFrameList(List<UGCTransitionProcessor.TXCCombineFrame> list) {
        for (UGCTransitionProcessor.TXCCombineFrame tXCCombineFrame : list) {
            if (tXCCombineFrame.drawInputFrame != null) {
                tXCCombineFrame.drawInputFrame.release();
            }
        }
    }

    public PixelFrame processFrame(List<PixelFrame> list, List<TXVideoEditConstants.TXAbsoluteRect> list2) {
        if (list == null || list.size() == 0) {
            LiteavLog.e("UGCCombineProcessor", "frameList is empty");
            return null;
        }
        Retain(list);
        LinkedList linkedList = new LinkedList();
        long j = 0;
        int i = 0;
        while (i < list.size()) {
            PixelFrame pixelFrame = list.get(i);
            long j2 = j;
            if (pixelFrame.getTimestamp() > j) {
                j2 = pixelFrame.getTimestamp();
            }
            UGCTransitionProcessor.TXCCombineFrame tXCCombineFrame = new UGCTransitionProcessor.TXCCombineFrame();
            tXCCombineFrame.drawRect = i < list2.size() ? list2.get(i) : new TXVideoEditConstants.TXAbsoluteRect();
            tXCCombineFrame.drawInputFrame = preScale(pixelFrame, tXCCombineFrame.drawRect, i);
            linkedList.add(tXCCombineFrame);
            i++;
            j = j2;
        }
        this.mUGCCombineProcessor.setCanvasSize(this.mOutputPixelWidth, this.mOutputPixelHeight);
        this.mUGCCombineProcessor.setCropRect(null);
        com.tencent.liteav.videobase.frame.d combineFrame = this.mUGCCombineProcessor.combineFrame(linkedList);
        releaseFrameList(linkedList);
        if (combineFrame == null) {
            return null;
        }
        PixelFrame a2 = combineFrame.a(list.get(0).getGLContext());
        combineFrame.release();
        a2.setTimestamp(j);
        return a2;
    }

    public void release() {
        this.mUGCCombineProcessor.release();
        for (com.tencent.liteav.videobase.frame.j jVar : this.mScaleRendererList) {
            if (jVar != null) {
                jVar.a();
            }
        }
        this.mScaleRendererList.clear();
        this.mScaleRectList.clear();
    }
}
