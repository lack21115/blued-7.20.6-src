package com.tencent.ugc.videoprocessor.watermark;

import com.tencent.liteav.base.util.n;
import com.tencent.ugc.TXVideoEditConstants;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/videoprocessor/watermark/PasterFilterChain.class */
public class PasterFilterChain extends PasterBase {
    private CopyOnWriteArrayList<TXVideoEditConstants.TXPaster> mNormalizedList = new CopyOnWriteArrayList<>();
    private List<TXVideoEditConstants.TXPaster> mPasterList;

    private void clearPasterList(List<TXVideoEditConstants.TXPaster> list) {
        if (list != null) {
            for (TXVideoEditConstants.TXPaster tXPaster : list) {
                if (tXPaster != null && tXPaster.pasterImage != null && !tXPaster.pasterImage.isRecycled()) {
                    tXPaster.pasterImage.recycle();
                    tXPaster.pasterImage = null;
                }
            }
            list.clear();
        }
    }

    private TXVideoEditConstants.TXPaster construct(TXVideoEditConstants.TXPaster tXPaster, TXVideoEditConstants.TXRect tXRect) {
        TXVideoEditConstants.TXPaster tXPaster2 = new TXVideoEditConstants.TXPaster();
        tXPaster2.frame = tXRect;
        tXPaster2.pasterImage = tXPaster.pasterImage;
        tXPaster2.startTime = tXPaster.startTime;
        tXPaster2.endTime = tXPaster.endTime;
        return tXPaster2;
    }

    @Override // com.tencent.ugc.videoprocessor.watermark.PasterBase
    public void clear() {
        super.clear();
        clearPasterList(this.mNormalizedList);
        clearPasterList(this.mPasterList);
        this.mPasterList = null;
    }

    public List<TXVideoEditConstants.TXPaster> getPasterList() {
        return this.mNormalizedList;
    }

    @Override // com.tencent.ugc.videoprocessor.watermark.PasterBase
    public void normalized(int i, int i2, int i3) {
        List<TXVideoEditConstants.TXPaster> list = this.mPasterList;
        if (list == null || list.size() == 0) {
            return;
        }
        for (TXVideoEditConstants.TXPaster tXPaster : this.mPasterList) {
            if (tXPaster != null) {
                TXVideoEditConstants.TXRect calculateRect = calculateRect(i, i2, i3, tXPaster.frame);
                if (calculateRect == null) {
                    return;
                }
                this.mNormalizedList.add(construct(tXPaster, calculateRect));
            }
        }
    }

    public void setPasterList(List<TXVideoEditConstants.TXPaster> list, n nVar) {
        this.mRenderSize = nVar;
        this.mPasterList = list;
        clearPasterList(this.mNormalizedList);
    }
}
