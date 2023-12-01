package com.tencent.mapsdk.core.components.protocol.jce.rtt;

import com.qq.taf.jce.MapJceStruct;
import com.tencent.mapsdk.internal.k;
import com.tencent.mapsdk.internal.m;
import com.tencent.mapsdk.internal.n;
import com.tencent.mapsdk.internal.q;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/core/components/protocol/jce/rtt/RttRequest.class */
public final class RttRequest extends MapJceStruct implements Cloneable {
    public ArrayList<Integer> bounds;
    public short zip;
    public short zoom;
    public static final /* synthetic */ boolean d = !RttRequest.class.desiredAssertionStatus();

    /* renamed from: c  reason: collision with root package name */
    public static ArrayList<Integer> f23576c = new ArrayList<>();

    static {
        f23576c.add(0);
    }

    public RttRequest() {
        this.bounds = null;
        this.zoom = (short) 0;
        this.zip = (short) 0;
    }

    public RttRequest(ArrayList<Integer> arrayList, short s, short s2) {
        this.bounds = null;
        this.zoom = (short) 0;
        this.zip = (short) 0;
        this.bounds = arrayList;
        this.zoom = s;
        this.zip = s2;
    }

    @Override // com.tencent.mapsdk.internal.p
    public String className() {
        return "navsns.RttRequest";
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            if (d) {
                return null;
            }
            throw new AssertionError();
        }
    }

    @Override // com.tencent.mapsdk.internal.p
    public void display(StringBuilder sb, int i) {
        k kVar = new k(sb, i);
        kVar.a((Collection) this.bounds, "bounds");
        kVar.a(this.zoom, "zoom");
        kVar.a(this.zip, "zip");
    }

    @Override // com.tencent.mapsdk.internal.p
    public void displaySimple(StringBuilder sb, int i) {
        k kVar = new k(sb, i);
        kVar.a((Collection) this.bounds, true);
        kVar.a(this.zoom, true);
        kVar.a(this.zip, false);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        RttRequest rttRequest = (RttRequest) obj;
        boolean z = false;
        if (q.a((Object) this.bounds, (Object) rttRequest.bounds)) {
            z = false;
            if (q.b(this.zoom, rttRequest.zoom)) {
                z = false;
                if (q.b(this.zip, rttRequest.zip)) {
                    z = true;
                }
            }
        }
        return z;
    }

    public ArrayList<Integer> getBounds() {
        return this.bounds;
    }

    public short getZip() {
        return this.zip;
    }

    public short getZoom() {
        return this.zoom;
    }

    public int hashCode() {
        try {
            throw new Exception("Need define key first!");
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override // com.tencent.mapsdk.internal.p
    public void readFrom(m mVar) {
        this.bounds = (ArrayList) mVar.a((m) f23576c, 0, true);
        this.zoom = mVar.a(this.zoom, 1, true);
        this.zip = mVar.a(this.zip, 2, true);
    }

    public void setBounds(ArrayList<Integer> arrayList) {
        this.bounds = arrayList;
    }

    public void setZip(short s) {
        this.zip = s;
    }

    public void setZoom(short s) {
        this.zoom = s;
    }

    @Override // com.tencent.mapsdk.internal.p
    public void writeTo(n nVar) {
        nVar.a((Collection) this.bounds, 0);
        nVar.a(this.zoom, 1);
        nVar.a(this.zip, 2);
    }
}
