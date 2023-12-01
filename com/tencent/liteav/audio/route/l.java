package com.tencent.liteav.audio.route;

import com.tencent.liteav.audio.route.b;
import com.tencent.liteav.base.Log;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/audio/route/l.class */
public final class l {

    /* renamed from: a  reason: collision with root package name */
    static final b.a f36264a = b.a.SPEAKERPHONE;
    final HashMap<b.a, b> b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    boolean f36265c = false;

    private static boolean a(b.a aVar) {
        return aVar == b.a.WIRED_HEADSET || aVar == b.a.BLUETOOTH_HEADSET;
    }

    private void b(b.a aVar) {
        b bVar = this.b.get(aVar);
        if (bVar == null) {
            Log.e("AudioRouteSupervisor", "error in promoteRoutePriority, route(%s) is not existed", aVar);
            return;
        }
        int i = bVar.f36252c;
        if (i == this.b.size() - 1) {
            return;
        }
        bVar.f36252c = this.b.size() - 1;
        for (Map.Entry<b.a, b> entry : this.b.entrySet()) {
            b value = entry.getValue();
            if (aVar != value.f36251a && value.f36252c >= i) {
                value.f36252c--;
            }
        }
    }

    public final boolean a(b.a aVar, boolean z) {
        if (!this.f36265c) {
            Log.e("AudioRouteSupervisor", "error in updateRouteAvailability(), it's not been initialized yet", new Object[0]);
            return false;
        }
        b bVar = this.b.get(aVar);
        if (bVar == null) {
            Log.e("AudioRouteSupervisor", "updateRouteAvailability failed, name: %s", aVar);
            return false;
        }
        bVar.b = z;
        if (z && a(aVar)) {
            b(aVar);
            return true;
        }
        return true;
    }
}
