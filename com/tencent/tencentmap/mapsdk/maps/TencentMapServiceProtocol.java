package com.tencent.tencentmap.mapsdk.maps;

import com.tencent.tencentmap.mapsdk.maps.TencentMapComponent;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tencentmap/mapsdk/maps/TencentMapServiceProtocol.class */
public interface TencentMapServiceProtocol extends TencentMapComponent.Component {
    public static final String SERVICE_NAME_AUTHORIZATION = "authorization";
    public static final String SERVICE_NAME_BLOCK_ROUTE_DATA = "blockroutedata";
    public static final String SERVICE_NAME_INDOOR_DATA = "indoordata";
    public static final String SERVICE_NAME_MAP_DATA = "mapdata";
    public static final String SERVICE_NAME_MAP_POI_DATA = "mappoidata";
    public static final String SERVICE_NAME_MAP_STYLE = "mapstyle";
    public static final String SERVICE_NAME_OFFLINE_MAP_DATA = "offlinemapdata";
    public static final String SERVICE_NAME_OVERSEA_DATA = "overseadata";
    public static final String SERVICE_NAME_RTT_DATA = "rttdata";
    public static final String SERVICE_NAME_SATELLITE_DATA = "satellitedata";
    public static final String SERVICE_NAME_SKETCH_DATA = "sketchdata";
    public static final String SERVICE_NAME_STATISTIC = "statistic";
    public static final String SERVICE_NAME_TRAFFIC_EVENT = "trafficevent";

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tencentmap/mapsdk/maps/TencentMapServiceProtocol$IMapService.class */
    public interface IMapService {
        void setAllow(boolean z);

        void setUseHttps(boolean z);

        void setUseTest(boolean z);
    }

    IMapService getMapService(String str);
}
