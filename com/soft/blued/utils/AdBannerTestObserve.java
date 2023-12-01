package com.soft.blued.utils;

import com.blued.ad.ADConstants;
import com.blued.android.module.common.login.model.BluedADExtra;
import com.soft.blued.customview.BannerADView;
import com.soft.blued.ui.ab_test.models.BannerAdExtra;
import kotlin.Metadata;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/utils/AdBannerTestObserve.class */
public interface AdBannerTestObserve {
    void a(BluedADExtra bluedADExtra, ADConstants.AD_POSITION ad_position, BannerADView.ADListener aDListener);

    void a(BannerAdExtra bannerAdExtra, BannerADView.ADListener aDListener);
}
