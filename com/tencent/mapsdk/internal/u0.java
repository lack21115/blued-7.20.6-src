package com.tencent.mapsdk.internal;

import com.tencent.tencentmap.mapsdk.maps.model.CustomLayer;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/u0.class */
public final class u0 implements CustomLayer {
    private final kg g;

    public u0(kg kgVar) {
        this.g = kgVar;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.CustomLayer
    public void clearDiskCache() {
        kg kgVar = this.g;
        if (kgVar == null) {
            return;
        }
        kgVar.clearTileCache();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof u0)) {
            return this.g.equals(((u0) obj).g);
        }
        return false;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.IOverlay
    public String getId() {
        kg kgVar = this.g;
        return kgVar == null ? "" : kgVar.y();
    }

    public int hashCode() {
        kg kgVar = this.g;
        if (kgVar == null) {
            return 0;
        }
        return kgVar.hashCode();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Removable
    public boolean isRemoved() {
        kg kgVar = this.g;
        if (kgVar != null) {
            return kgVar.isRemoved();
        }
        return false;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Removable
    public void releaseData() {
        kg kgVar = this.g;
        if (kgVar != null) {
            kgVar.releaseData();
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.CustomLayer
    public void reload() {
        kg kgVar = this.g;
        if (kgVar == null) {
            return;
        }
        kgVar.reload();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Removable
    public void remove() {
        kg kgVar = this.g;
        if (kgVar == null) {
            return;
        }
        kgVar.remove();
        ra.i(ma.f23951a);
    }
}
