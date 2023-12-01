package com.tencent.tencentmap.mapsdk.maps.model;

import android.text.TextUtils;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tencentmap/mapsdk/maps/model/CustomLayerOptions.class */
public class CustomLayerOptions {
    private String mLayerId;
    private String mLayerVersion;

    public String getLayerId() {
        return this.mLayerId;
    }

    public CustomLayerOptions layerId(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mLayerId = str;
        }
        return this;
    }
}
