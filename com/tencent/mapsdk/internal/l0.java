package com.tencent.mapsdk.internal;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/l0.class */
public interface l0 {
    void a(int i, float f);

    void a(int i, int i2, int i3, int i4, int i5);

    void a(int i, int[] iArr);

    void a(boolean z);

    void b(int i);

    void b(int i, int i2, int i3, int i4, int i5);

    void b(boolean z);

    boolean b();

    float c(int i);

    void d(int i);

    void e(int i);

    void f(int i);

    boolean isCompassEnabled();

    boolean isIndoorLevelPickerEnabled();

    boolean isMyLocationButtonEnabled();

    boolean isRotateGesturesEnabled();

    boolean isScrollGesturesEnabled();

    boolean isTiltGesturesEnabled();

    boolean isZoomControlsEnabled();

    boolean isZoomGesturesEnabled();

    void setAllGesturesEnabled(boolean z);

    void setCompassEnabled(boolean z);

    void setCompassExtraPadding(int i);

    void setCompassExtraPadding(int i, int i2);

    void setGestureRotateByMapCenter(boolean z);

    void setGestureScaleByMapCenter(boolean z);

    void setIndoorLevelPickerEnabled(boolean z);

    void setLogoScale(float f);

    void setLogoSize(int i);

    void setMyLocationButtonEnabled(boolean z);

    void setRotateGesturesEnabled(boolean z);

    void setScaleViewEnabled(boolean z);

    void setScaleViewFadeEnable(boolean z);

    void setScrollGesturesEnabled(boolean z);

    void setTiltGesturesEnabled(boolean z);

    void setZoomControlsEnabled(boolean z);

    void setZoomGesturesEnabled(boolean z);

    void setZoomPosition(int i);
}
