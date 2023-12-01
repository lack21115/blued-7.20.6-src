package com.tencent.tencentmap.mapsdk.maps.model;

import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tencentmap/mapsdk/maps/model/IndoorBuilding.class */
public final class IndoorBuilding implements Cloneable {
    private int mActiveLevelIndex;
    private String mBuidlingId;
    private String mBuildingName;
    private LatLng mLatLng;
    private List<IndoorLevel> mLevels;

    public IndoorBuilding(String str, String str2, LatLng latLng, List<IndoorLevel> list, int i) {
        this.mBuidlingId = str;
        this.mBuildingName = str2;
        this.mLatLng = latLng;
        this.mLevels = list;
        this.mActiveLevelIndex = i;
    }

    public Object clone() throws CloneNotSupportedException {
        IndoorBuilding indoorBuilding = (IndoorBuilding) super.clone();
        if (this.mLevels != null) {
            indoorBuilding.mLevels = new ArrayList(this.mLevels.size());
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.mLevels.size()) {
                    break;
                }
                indoorBuilding.mLevels.add(new IndoorLevel(this.mLevels.get(i2).getName()));
                i = i2 + 1;
            }
        }
        LatLng latLng = this.mLatLng;
        if (latLng != null) {
            indoorBuilding.mLatLng = new LatLng(latLng.latitude, latLng.longitude);
        }
        return indoorBuilding;
    }

    public int getActiveLevelIndex() {
        return this.mActiveLevelIndex;
    }

    public String getBuidlingId() {
        return this.mBuidlingId;
    }

    public LatLng getBuildingLatLng() {
        return this.mLatLng;
    }

    public String getBuildingName() {
        return this.mBuildingName;
    }

    public List<IndoorLevel> getLevels() {
        return this.mLevels;
    }

    public String toString() {
        List<IndoorLevel> list;
        if (this.mBuidlingId == null || (list = this.mLevels) == null || list.size() <= this.mActiveLevelIndex) {
            return "";
        }
        return this.mBuidlingId + BridgeUtil.UNDERLINE_STR + this.mLevels.get(this.mActiveLevelIndex).getName();
    }
}
