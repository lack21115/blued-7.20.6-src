package com.tencent.tencentmap.mapsdk.maps.model;

import android.content.Context;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Accessible;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Alphable;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Anchorable;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Animationable;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Clickable;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Collisionable;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Draggable;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Levelable;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Removable;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Rotatable;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Scalable;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Tagable;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Visible;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tencentmap/mapsdk/maps/model/Marker.class */
public interface Marker extends Accessible, Alphable, Anchorable, Animationable, Clickable, Collisionable, Draggable, Levelable, Removable, Rotatable, Scalable, Tagable<Object>, Visible, IOverlay {
    int getDisplayLevel();

    int getHeight(Context context);

    TencentMap.OnMarkerDragListener getOnDragListener();

    MarkerOptions getOptions();

    LatLng getPosition();

    String getSnippet();

    String getTitle();

    int getWidth(Context context);

    void hideInfoWindow();

    boolean isFastLoad();

    boolean isInMapCenterState();

    boolean isInfoWindowAutoOverturn();

    boolean isInfoWindowEnable();

    boolean isInfoWindowShown();

    boolean onTapMapViewBubbleHidden();

    void refreshInfoWindow();

    void setFastLoad(boolean z);

    void setFixingPoint(int i, int i2);

    void setFixingPointEnable(boolean z);

    void setIcon(BitmapDescriptor bitmapDescriptor);

    void setIconLooper(BitmapDescriptor bitmapDescriptor, boolean z, int i);

    void setInMapCenterState(boolean z);

    void setInfoWindowAnchor(float f, float f2);

    void setInfoWindowEnable(boolean z);

    void setInfoWindowOffset(int i, int i2);

    void setMarkerOptions(MarkerOptions markerOptions);

    void setOnTapMapViewBubbleHidden(boolean z);

    void setPosition(LatLng latLng);

    void setSnippet(String str);

    void setTitle(String str);

    void showInfoWindow();
}
