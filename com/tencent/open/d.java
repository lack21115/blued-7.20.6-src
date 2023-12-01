package com.tencent.open;

import android.location.Location;
import android.location.LocationManager;
import com.tencent.open.a.f;
import com.tencent.open.c;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/open/d.class */
public class d extends com.tencent.map.a.a.b {

    /* renamed from: a  reason: collision with root package name */
    private c.a f38265a;

    public d(c.a aVar) {
        super(1, 0, 0, 8);
        this.f38265a = aVar;
    }

    @Override // com.tencent.map.a.a.b
    public void a(int i) {
        f.c("openSDK_LOG.SosoLocationListener", "location: onStatusUpdate = " + i);
        super.a(i);
    }

    @Override // com.tencent.map.a.a.b
    public void a(com.tencent.map.a.a.d dVar) {
        f.c("openSDK_LOG.SosoLocationListener", "location: onLocationUpdate = " + dVar);
        super.a(dVar);
        if (dVar == null) {
            return;
        }
        Location location = new Location(LocationManager.PASSIVE_PROVIDER);
        location.setLatitude(dVar.b);
        location.setLongitude(dVar.f37199c);
        c.a aVar = this.f38265a;
        if (aVar != null) {
            aVar.onLocationUpdate(location);
        }
    }

    @Override // com.tencent.map.a.a.b
    public void a(byte[] bArr, int i) {
        super.a(bArr, i);
    }
}
