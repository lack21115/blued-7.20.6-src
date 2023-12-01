package com.tencent.mapsdk.internal;

import com.tencent.tencentmap.mapsdk.maps.model.TileOverlay;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/z0.class */
public final class z0 implements TileOverlay {
    private final kg g;

    public z0(kg kgVar) {
        this.g = kgVar;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.TileOverlay
    public void clearTileCache() {
        kg kgVar = this.g;
        if (kgVar == null) {
            return;
        }
        kgVar.clearTileCache();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof z0)) {
            return this.g.equals(((z0) obj).g);
        }
        return false;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.TileOverlay, com.tencent.tencentmap.mapsdk.maps.model.IOverlay
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

    @Override // com.tencent.tencentmap.mapsdk.maps.model.TileOverlay
    public void reload() {
        kg kgVar = this.g;
        if (kgVar == null) {
            return;
        }
        kgVar.reload();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.TileOverlay
    public void remove() {
        kg kgVar = this.g;
        if (kgVar == null) {
            return;
        }
        kgVar.remove();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.TileOverlay
    public void setDiskCacheDir(String str) {
        kg kgVar = this.g;
        if (kgVar == null) {
            return;
        }
        kgVar.a(str);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.TileOverlay
    public void setZindex(int i) {
        kg kgVar = this.g;
        if (kgVar == null) {
            return;
        }
        kgVar.c(i);
    }
}
