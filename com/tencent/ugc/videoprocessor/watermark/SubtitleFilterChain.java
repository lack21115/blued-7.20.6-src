package com.tencent.ugc.videoprocessor.watermark;

import com.tencent.liteav.base.util.n;
import com.tencent.ugc.TXVideoEditConstants;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/videoprocessor/watermark/SubtitleFilterChain.class */
public class SubtitleFilterChain extends PasterBase {
    private CopyOnWriteArrayList<TXVideoEditConstants.TXSubtitle> mNormalizedList = new CopyOnWriteArrayList<>();
    private List<TXVideoEditConstants.TXSubtitle> mSubtitleList;

    private void clearSubtitleList(List<TXVideoEditConstants.TXSubtitle> list) {
        if (list != null) {
            for (TXVideoEditConstants.TXSubtitle tXSubtitle : list) {
                if (tXSubtitle != null && tXSubtitle.titleImage != null && !tXSubtitle.titleImage.isRecycled()) {
                    tXSubtitle.titleImage.recycle();
                    tXSubtitle.titleImage = null;
                }
            }
            list.clear();
        }
    }

    private TXVideoEditConstants.TXSubtitle construct(TXVideoEditConstants.TXSubtitle tXSubtitle, TXVideoEditConstants.TXRect tXRect) {
        TXVideoEditConstants.TXSubtitle tXSubtitle2 = new TXVideoEditConstants.TXSubtitle();
        tXSubtitle2.frame = tXRect;
        tXSubtitle2.titleImage = tXSubtitle.titleImage;
        tXSubtitle2.startTime = tXSubtitle.startTime;
        tXSubtitle2.endTime = tXSubtitle.endTime;
        return tXSubtitle2;
    }

    @Override // com.tencent.ugc.videoprocessor.watermark.PasterBase
    public void clear() {
        super.clear();
        clearSubtitleList(this.mNormalizedList);
        clearSubtitleList(this.mSubtitleList);
        this.mSubtitleList = null;
    }

    public List<TXVideoEditConstants.TXSubtitle> getSubtitleList() {
        return this.mNormalizedList;
    }

    @Override // com.tencent.ugc.videoprocessor.watermark.PasterBase
    public void normalized(int i, int i2, int i3) {
        List<TXVideoEditConstants.TXSubtitle> list = this.mSubtitleList;
        if (list == null || list.size() == 0) {
            return;
        }
        for (TXVideoEditConstants.TXSubtitle tXSubtitle : this.mSubtitleList) {
            if (tXSubtitle != null) {
                this.mNormalizedList.add(construct(tXSubtitle, calculateRect(i, i2, i3, tXSubtitle.frame)));
            }
        }
    }

    public void setSubtitleList(List<TXVideoEditConstants.TXSubtitle> list, n nVar) {
        this.mRenderSize = nVar;
        this.mSubtitleList = list;
        this.mNormalizedList.clear();
    }
}
