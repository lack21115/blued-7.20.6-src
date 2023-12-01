package com.anythink.core.api;

import android.graphics.Bitmap;
import android.view.View;
import java.util.List;
import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/api/IATThirdPartyMaterial.class */
public interface IATThirdPartyMaterial {
    ATAdAppInfo getAdAppInfo();

    String getAdChoiceIconUrl();

    String getAdFrom();

    View getAdIconView();

    Bitmap getAdLogo();

    View getAdLogoView();

    View getAdMediaView(Object... objArr);

    String getAdType();

    String getAdvertiserName();

    int getAppCommentNum();

    View getAppDownloadButton();

    double getAppPrice();

    String getCallToActionText();

    String getDescriptionText();

    String getDomain();

    String getIconImageUrl();

    List<String> getImageUrlList();

    int getMainImageHeight();

    String getMainImageUrl();

    int getMainImageWidth();

    int getNativeAdInteractionType();

    ATCustomVideo getNativeCustomVideo();

    int getNativeExpressHeight();

    int getNativeExpressWidth();

    int getNativeType();

    Map<String, Object> getNetworkInfoMap();

    View getShakeView(int i, int i2, ATShakeViewListener aTShakeViewListener);

    Double getStarRating();

    String getTitle();

    double getVideoDuration();

    int getVideoHeight();

    double getVideoProgress();

    String getVideoUrl();

    int getVideoWidth();

    String getWarning();
}
