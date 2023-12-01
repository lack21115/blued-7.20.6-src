package com.tencent.mapsdk.internal;

import com.tencent.mapsdk.engine.jni.models.TappedElement;
import com.tencent.mapsdk.internal.jf;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.AoiLayer;
import com.tencent.tencentmap.mapsdk.maps.model.AoiLayerOptions;
import com.tencent.tencentmap.mapsdk.maps.model.SubPoi;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/kf.class */
public class kf implements c5, AoiLayer.OnAoiLayerLoadListener {
    private final rc e;
    private TencentMap.OnMapPoiClickListener f;
    private final List<Cif> d = new CopyOnWriteArrayList();
    private final Map<String, AoiLayer.OnAoiLayerLoadListener> g = new HashMap();

    public kf(rc rcVar) {
        this.e = rcVar;
    }

    public q1 a() {
        return this.e;
    }

    public AoiLayer a(String str, AoiLayerOptions aoiLayerOptions, AoiLayer.OnAoiLayerLoadListener onAoiLayerLoadListener) {
        Cif cif;
        Iterator<Cif> it = this.d.iterator();
        while (true) {
            if (!it.hasNext()) {
                cif = null;
                break;
            }
            cif = it.next();
            if (cif.getId() != null && cif.getId().equals(str)) {
                break;
            }
        }
        Cif cif2 = cif;
        if (cif == null) {
            Cif cif3 = new Cif(this, str, aoiLayerOptions, this);
            this.d.add(cif3);
            cif2 = cif3;
            if (onAoiLayerLoadListener != null) {
                this.g.put(str, onAoiLayerLoadListener);
                cif2 = cif3;
            }
        }
        cif2.a(aoiLayerOptions);
        return cif2;
    }

    public void a(Cif cif) {
        this.d.remove(cif);
    }

    @Override // com.tencent.mapsdk.internal.c5
    public void a(v5 v5Var) {
    }

    public void a(TencentMap.OnMapPoiClickListener onMapPoiClickListener) {
        this.f = onMapPoiClickListener;
    }

    public boolean a(TappedElement tappedElement) {
        SubPoi subPoi;
        if (this.f == null || tappedElement == null || tappedElement.type != 4) {
            return false;
        }
        long j = tappedElement.itemId;
        Iterator<Cif> it = this.d.iterator();
        while (true) {
            subPoi = null;
            if (!it.hasNext()) {
                break;
            }
            Cif next = it.next();
            jf.d a2 = next.a(j);
            if (a2 != null) {
                subPoi = next.a(next.getId(), a2);
                break;
            }
        }
        if (subPoi != null) {
            this.f.onClicked(subPoi);
            return true;
        }
        return false;
    }

    public rc b() {
        return this.e;
    }

    public void c() {
        this.f = null;
        this.d.clear();
        this.g.clear();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.AoiLayer.OnAoiLayerLoadListener
    public void onAoiLayerLoaded(boolean z, AoiLayer aoiLayer) {
        if (aoiLayer == null || this.e == null) {
            return;
        }
        AoiLayer.OnAoiLayerLoadListener onAoiLayerLoadListener = this.g.get(aoiLayer.getId());
        if (onAoiLayerLoadListener != null) {
            onAoiLayerLoadListener.onAoiLayerLoaded(z, aoiLayer);
        }
        if (z) {
            this.e.w().b().b();
        }
    }
}
