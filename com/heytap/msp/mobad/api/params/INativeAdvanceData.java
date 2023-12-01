package com.heytap.msp.mobad.api.params;

import android.content.Context;
import android.view.View;
import com.heytap.msp.mobad.api.ad.IBidding;
import com.heytap.msp.mobad.api.listener.INativeAdvanceInteractListener;
import com.heytap.msp.mobad.api.listener.INativeAdvanceMediaListener;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/heytap/msp/mobad/api/params/INativeAdvanceData.class */
public interface INativeAdvanceData extends IBidding {
    public static final int CREATIVE_TYPE_NATIVE_VIDEO = 13;
    public static final int CREATIVE_TYPE_TEXT_ICON = 3;
    public static final int CREATIVE_TYPE_TEXT_ICON_320X210 = 7;
    public static final int CREATIVE_TYPE_TEXT_ICON_640X320 = 6;
    public static final int CREATIVE_TYPE_TEXT_ICON_GROUP_320X210 = 8;

    void bindMediaView(Context context, MediaView mediaView, INativeAdvanceMediaListener iNativeAdvanceMediaListener);

    void bindToComplianceView(Context context, List<View> list, INativeComplianceListener iNativeComplianceListener, List<View> list2, INativeComplianceListener iNativeComplianceListener2);

    void bindToView(Context context, NativeAdvanceContainer nativeAdvanceContainer, List<View> list);

    String getClickBnText();

    INativeAdvanceComplianceInfo getComplianceInfo();

    int getCreativeType();

    String getDesc();

    String getExtra();

    List<INativeAdFile> getIconFiles();

    List<INativeAdFile> getImgFiles();

    INativeAdFile getLogoFile();

    String getTitle();

    int getVideoDuration();

    boolean isAdValid();

    void release();

    void setInteractListener(INativeAdvanceInteractListener iNativeAdvanceInteractListener);
}
