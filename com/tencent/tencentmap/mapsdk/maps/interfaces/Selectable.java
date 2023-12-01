package com.tencent.tencentmap.mapsdk.maps.interfaces;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tencentmap/mapsdk/maps/interfaces/Selectable.class */
public interface Selectable {

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tencentmap/mapsdk/maps/interfaces/Selectable$OnSelectedListener.class */
    public interface OnSelectedListener<T> {
        void onSelected(T t);
    }

    boolean isSelected();

    void setSelected(boolean z);

    <T> void setSelectedListener(OnSelectedListener<T> onSelectedListener);
}
