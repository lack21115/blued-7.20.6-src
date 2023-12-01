package com.heytap.msp.mobad.api.params;

import android.view.View;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/heytap/msp/mobad/api/params/INativeAdData.class */
public interface INativeAdData {
    public static final int CREATIVE_TYPE_FULL_IMAGE = 5;
    public static final int CREATIVE_TYPE_FULL_VIDEO = 11;
    public static final int CREATIVE_TYPE_IMAGE = 2;
    public static final int CREATIVE_TYPE_NO = 0;
    public static final int CREATIVE_TYPE_POP_WINDOW_VIDEO = 12;
    public static final int CREATIVE_TYPE_TEXT = 1;
    public static final int CREATIVE_TYPE_TEXT_ICON = 3;
    public static final int CREATIVE_TYPE_TEXT_ICON_320X210 = 7;
    public static final int CREATIVE_TYPE_TEXT_ICON_640X320 = 6;
    public static final int CREATIVE_TYPE_TEXT_ICON_GROUP_320X210 = 8;
    public static final int CREATIVE_TYPE_VIDEO = 4;
    public static final int CREATIVE_TYPE_VIDEO_HTML = 9;
    public static final int CREATIVE_TYPE_VIDEO_TIP_BAR = 10;
    public static final int CREATIVE_TYPR_NATIVE_VIDEO = 13;
    public static final int INTERACTION_TYPE_DOWNLOAD = 2;
    public static final int INTERACTION_TYPE_MIDDLE_PAGE_DOWNLOAD = 3;
    public static final int INTERACTION_TYPE_NO = 0;
    public static final int INTERACTION_TYPE_OPEN_DETAIL_PAGE = 5;
    public static final int INTERACTION_TYPE_OPEN_HOME_PAGE = 4;
    public static final int INTERACTION_TYPE_OPEN_INSTANT = 6;
    public static final int INTERACTION_TYPE_SURFING = 1;

    String getClickBnText();

    INativeComplianceInfo getComplianceInfo();

    int getCreativeType();

    String getDesc();

    String getExtra();

    List<INativeAdFile> getIconFiles();

    List<INativeAdFile> getImgFiles();

    int getInteractionType();

    INativeAdFile getLogoFile();

    String getTitle();

    boolean isAdValid();

    boolean isCurrentApp(String str);

    boolean launchApp();

    void onAdClick(View view);

    void onAdShow(View view);
}
