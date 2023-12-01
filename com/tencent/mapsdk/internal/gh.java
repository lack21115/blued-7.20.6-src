package com.tencent.mapsdk.internal;

import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.tencent.mapsdk.core.components.protocol.jce.trafficevent.Basic;
import com.tencent.mapsdk.core.components.protocol.jce.trafficevent.Detail;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/gh.class */
public class gh {

    /* renamed from: a  reason: collision with root package name */
    private Map<String, a> f37492a = new ConcurrentHashMap();
    private final j1 b;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/gh$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final pd f37493a;
        public final Detail b;

        public a(pd pdVar, Detail detail) {
            this.f37493a = pdVar;
            this.b = detail;
        }
    }

    public gh(j1 j1Var) {
        this.b = j1Var;
    }

    public void a() {
        Map<String, a> map = this.f37492a;
        if (map == null) {
            return;
        }
        for (String str : map.keySet()) {
            a aVar = this.f37492a.get(str);
            if (aVar != null) {
                aVar.f37493a.remove();
            }
        }
        this.f37492a.clear();
    }

    public void a(List<Detail> list) {
        if (list.isEmpty()) {
            return;
        }
        for (Detail detail : list) {
            a aVar = this.f37492a.get(detail.basic.eventid);
            if (aVar != null) {
                aVar.f37493a.remove();
                this.f37492a.remove(detail.basic.eventid);
            }
        }
    }

    public void b() {
        a();
        this.f37492a = null;
    }

    public void b(List<Detail> list) {
        int i;
        if (this.b == null || list.isEmpty()) {
            return;
        }
        for (Detail detail : list) {
            String str = detail.basic.icon_normal;
            int lastIndexOf = str.lastIndexOf(BridgeUtil.SPLIT_MARK);
            if (lastIndexOf != -1 && (i = lastIndexOf + 1) <= str.length()) {
                String substring = str.substring(i);
                na.f(ma.m, "type:" + detail.basic.type + ", coord:" + detail.basic.coord_lat + ", " + detail.basic.coord_lon + ", minScale:" + detail.basic.min_scale + ", maxScale:" + detail.basic.max_scale);
                a aVar = this.f37492a.get(detail.basic.eventid);
                if (aVar == null) {
                    Basic basic = detail.basic;
                    rd rdVar = new rd(basic.coord_lat, basic.coord_lon, substring);
                    Basic basic2 = detail.basic;
                    rdVar.anchor(basic2.anchor_x, basic2.anchor_y);
                    rdVar.minScaleLevel(detail.basic.min_scale);
                    rdVar.maxScaleLevel(detail.basic.max_scale);
                    rdVar.avoidAnnotation(true);
                    rdVar.avoidOtherMarker(true);
                    this.f37492a.put(detail.basic.eventid, new a((pd) this.b.a((j1) rdVar), detail));
                } else {
                    rd f = aVar.f37493a.f();
                    Basic basic3 = detail.basic;
                    f.position(basic3.coord_lat, basic3.coord_lon);
                    f.iconName(substring);
                    Basic basic4 = detail.basic;
                    f.anchor(basic4.anchor_x, basic4.anchor_y);
                    f.minScaleLevel(detail.basic.min_scale);
                    f.maxScaleLevel(detail.basic.max_scale);
                    aVar.f37493a.a((pd) f);
                }
            }
        }
    }

    public Map<String, a> c() {
        return this.f37492a;
    }
}
