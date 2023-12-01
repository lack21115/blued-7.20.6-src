package com.amap.api.services.route;

import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:com/amap/api/services/route/ElecConsumeInfo.class */
public class ElecConsumeInfo {

    /* renamed from: a  reason: collision with root package name */
    private int f5712a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private LatLonPoint f5713c;
    private List<Integer> d = new ArrayList();

    public int getConsumeEnergy() {
        return this.f5712a;
    }

    public List<Integer> getLeftEnergy() {
        return this.d;
    }

    public LatLonPoint getRunOutPoint() {
        return this.f5713c;
    }

    public int getRunOutStepIndex() {
        return this.b;
    }

    public void setConsumeEnergy(int i) {
        this.f5712a = i;
    }

    public void setLeftEnergy(List<Integer> list) {
        this.d = list;
    }

    public void setRunOutPoint(LatLonPoint latLonPoint) {
        this.f5713c = latLonPoint;
    }

    public void setRunOutStepIndex(int i) {
        this.b = i;
    }
}
