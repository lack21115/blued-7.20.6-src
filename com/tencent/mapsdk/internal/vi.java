package com.tencent.mapsdk.internal;

import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.IndoorBuilding;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/vi.class */
public class vi implements TencentMap.OnIndoorStateChangeListener {
    private yi g;

    public vi(yi yiVar) {
        this.g = yiVar;
    }

    private boolean j() {
        return this.g == null;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.OnIndoorStateChangeListener
    public boolean onIndoorBuildingDeactivated() {
        yi yiVar = this.g;
        if (yiVar == null) {
            return false;
        }
        yiVar.onIndoorBuildingDeactivated();
        TencentMap.OnIndoorStateChangeListener onIndoorStateChangeListener = this.g.Z;
        if (onIndoorStateChangeListener != null) {
            onIndoorStateChangeListener.onIndoorBuildingDeactivated();
            return true;
        }
        return true;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.OnIndoorStateChangeListener
    public boolean onIndoorBuildingFocused() {
        yi yiVar = this.g;
        if (yiVar == null) {
            return false;
        }
        yiVar.onIndoorBuildingFocused();
        TencentMap.OnIndoorStateChangeListener onIndoorStateChangeListener = this.g.Z;
        if (onIndoorStateChangeListener != null) {
            onIndoorStateChangeListener.onIndoorBuildingFocused();
            return true;
        }
        return true;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.OnIndoorStateChangeListener
    public boolean onIndoorLevelActivated(IndoorBuilding indoorBuilding) {
        yi yiVar = this.g;
        if (yiVar == null) {
            return false;
        }
        yiVar.onIndoorLevelActivated(indoorBuilding);
        TencentMap.OnIndoorStateChangeListener onIndoorStateChangeListener = this.g.Z;
        if (onIndoorStateChangeListener != null) {
            onIndoorStateChangeListener.onIndoorLevelActivated(indoorBuilding);
            return true;
        }
        return true;
    }
}
