package com.tencent.thumbplayer.b;

import com.tencent.thumbplayer.api.composition.ITPMediaAsset;
import com.tencent.thumbplayer.api.composition.ITPMediaAssetExtraParam;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/b/d.class */
public class d implements ITPMediaAsset {

    /* renamed from: a  reason: collision with root package name */
    private ITPMediaAssetExtraParam f25530a;

    @Override // com.tencent.thumbplayer.api.composition.ITPMediaAsset
    public ITPMediaAssetExtraParam getExtraParam() {
        return this.f25530a;
    }

    @Override // com.tencent.thumbplayer.api.composition.ITPMediaAsset
    public int getMediaType() {
        return 0;
    }

    @Override // com.tencent.thumbplayer.api.composition.ITPMediaAsset
    public String getUrl() {
        return "";
    }

    @Override // com.tencent.thumbplayer.api.composition.ITPMediaAsset
    public void setExtraParam(ITPMediaAssetExtraParam iTPMediaAssetExtraParam) {
        this.f25530a = iTPMediaAssetExtraParam;
    }
}
