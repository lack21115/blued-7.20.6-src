package com.tencent.tencentmap.mapsdk.maps.model;

import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tencentmap/mapsdk/maps/model/MarkerGroup.class */
public interface MarkerGroup {
    void addMarker(Marker marker);

    void addMarkerById(String str);

    void addMarkerList(List<Marker> list);

    void clear();

    boolean containMarker(Marker marker);

    boolean containMarkerById(String str);

    Marker findMarkerById(String str);

    String getId();

    List<String> getMarkerIdList();

    List<Marker> getMarkerList();

    boolean removeMarker(Marker marker);

    boolean removeMarkerById(String str);

    void setMarkerGroupOnTapMapBubblesHidden(boolean z);

    void setMarkerGroupOnTapMapInfoWindowHidden(boolean z);

    boolean setMarkerOnTapMapBubblesHidden(Marker marker, boolean z);

    boolean setOnTapMapBubblesHiddenById(String str, boolean z);

    boolean updateMarkerOptionById(String str, MarkerOptions markerOptions);
}
