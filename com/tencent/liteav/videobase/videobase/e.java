package com.tencent.liteav.videobase.videobase;

import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videobase.frame.PixelFrame;
import com.tencent.liteav.videobase.videobase.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videobase/videobase/e.class */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    private final Map<com.tencent.liteav.videobase.videobase.a, g> f36673a = new HashMap();
    private com.tencent.liteav.videobase.frame.e b;

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videobase/videobase/e$a.class */
    public interface a {
        void onFrameConverted(int i, PixelFrame pixelFrame);
    }

    public final void a() {
        for (g gVar : this.f36673a.values()) {
            gVar.a();
        }
    }

    public final void a(int i, a aVar) {
        ArrayList<com.tencent.liteav.videobase.videobase.a> arrayList = new ArrayList();
        for (Map.Entry<com.tencent.liteav.videobase.videobase.a, g> entry : this.f36673a.entrySet()) {
            entry.getValue().a(i, aVar);
            if (!(!entry.getValue().e.isEmpty())) {
                arrayList.add(entry.getKey());
            }
        }
        for (com.tencent.liteav.videobase.videobase.a aVar2 : arrayList) {
            g gVar = this.f36673a.get(aVar2);
            if (gVar != null) {
                gVar.a();
            }
            this.f36673a.remove(aVar2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:63:0x027a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(long r8, com.tencent.liteav.videobase.frame.d r10) {
        /*
            Method dump skipped, instructions count: 917
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.videobase.videobase.e.a(long, com.tencent.liteav.videobase.frame.d):void");
    }

    public final void a(com.tencent.liteav.videobase.frame.e eVar) {
        this.b = eVar;
        for (g gVar : this.f36673a.values()) {
            gVar.a(eVar);
        }
    }

    public final void a(com.tencent.liteav.videobase.videobase.a aVar, GLConstants.PixelBufferType pixelBufferType, GLConstants.PixelFormatType pixelFormatType, int i, a aVar2) {
        g gVar = this.f36673a.get(aVar);
        g gVar2 = gVar;
        if (gVar == null) {
            gVar2 = new g(aVar);
            com.tencent.liteav.videobase.frame.e eVar = this.b;
            if (eVar != null) {
                gVar2.a(eVar);
            }
            this.f36673a.put(aVar, gVar2);
        }
        List<g.a> list = gVar2.e.get(pixelFormatType);
        ArrayList arrayList = list;
        if (list == null) {
            arrayList = new ArrayList();
            gVar2.e.put(pixelFormatType, arrayList);
        }
        for (g.a aVar3 : arrayList) {
            if (aVar3.b == i && aVar3.f36678c == aVar2) {
                return;
            }
        }
        arrayList.add(new g.a(pixelBufferType, i, aVar2));
    }
}
