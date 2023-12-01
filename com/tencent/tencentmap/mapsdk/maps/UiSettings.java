package com.tencent.tencentmap.mapsdk.maps;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tencentmap/mapsdk/maps/UiSettings.class */
public interface UiSettings {
    boolean isCompassEnabled();

    boolean isIndoorLevelPickerEnabled();

    boolean isMyLocationButtonEnabled();

    boolean isRotateGesturesEnabled();

    boolean isScaleViewEnabled();

    boolean isScrollGesturesEnabled();

    boolean isTiltGesturesEnabled();

    boolean isZoomControlsEnabled();

    boolean isZoomGesturesEnabled();

    void setAllGesturesEnabled(boolean z);

    void setCompassEnabled(boolean z);

    void setCompassExtraPadding(int i);

    void setCompassExtraPadding(int i, int i2);

    void setFlingGestureEnabled(boolean z);

    void setGestureRotateByMapCenter(boolean z);

    void setGestureScaleByMapCenter(boolean z);

    void setIndoorLevelPickerEnabled(boolean z);

    void setLogoPosition(int i);

    void setLogoPosition(int i, int[] iArr);

    void setLogoPositionWithMargin(int i, int i2, int i3, int i4, int i5);

    void setLogoScale(float f);

    void setLogoSize(int i);

    void setMyLocationButtonEnabled(boolean z);

    void setRotateGesturesEnabled(boolean z);

    void setScaleViewEnabled(boolean z);

    void setScaleViewFadeEnable(boolean z);

    void setScaleViewPosition(int i);

    void setScaleViewPositionWithMargin(int i, int i2, int i3, int i4, int i5);

    void setScrollGesturesEnabled(boolean z);

    void setTiltGesturesEnabled(boolean z);

    void setZoomControlsEnabled(boolean z);

    void setZoomGesturesEnabled(boolean z);

    void setZoomPosition(int i);
}
