package com.tencent.thumbplayer.api.richmedia;

import com.tencent.thumbplayer.core.richmedia.TPNativeRichMediaFeature;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/richmedia/TPRichMediaFeature.class */
public class TPRichMediaFeature {
    private final List<String> mBinding;
    private final String mFeatureType;
    private final boolean mIsSelected;

    public TPRichMediaFeature(TPNativeRichMediaFeature tPNativeRichMediaFeature) {
        this.mFeatureType = tPNativeRichMediaFeature.getFeatureType();
        this.mBinding = new ArrayList(Arrays.asList(tPNativeRichMediaFeature.getBinding()));
        this.mIsSelected = tPNativeRichMediaFeature.isSelected();
    }

    public List<String> getBinding() {
        return this.mBinding;
    }

    public String getFeatureType() {
        return this.mFeatureType;
    }

    public boolean isSelected() {
        return this.mIsSelected;
    }
}
