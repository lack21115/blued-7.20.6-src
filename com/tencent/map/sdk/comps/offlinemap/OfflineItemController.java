package com.tencent.map.sdk.comps.offlinemap;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/map/sdk/comps/offlinemap/OfflineItemController.class */
public interface OfflineItemController {
    boolean checkInvalidate();

    boolean close();

    boolean open();

    boolean removeCache();

    void startDownload();

    void stopDownload();
}
