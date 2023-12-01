package com.tencent.mapsdk.internal;

import android.graphics.BitmapFactory;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.SparseArray;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.tencent.map.tools.EncryptAesUtils;
import com.tencent.map.tools.net.NetManager;
import com.tencent.map.tools.net.NetResponse;
import com.tencent.mapsdk.core.components.protocol.jce.trafficevent.Detail;
import com.tencent.mapsdk.core.components.protocol.jce.trafficevent.Response;
import com.tencent.mapsdk.internal.gh;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds;
import com.tencent.tencentmap.mapsdk.maps.model.TrafficEvent;
import java.io.File;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.crypto.spec.IvParameterSpec;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/hh.class */
public class hh implements ne {
    public static final String p = "d8ab2f7b7a7536a71894084e1c812fd0";
    public static final IvParameterSpec q = new IvParameterSpec("c0ab1f54he78k36d".getBytes());
    public static int r = 0;
    public static int s = 1;
    public static int t = 2;
    private volatile boolean g;
    private volatile boolean h;
    private volatile boolean i;
    private rc j;
    private gh l;
    private String n;
    private t3 o;
    private final SparseArray<eh> k = new SparseArray<>(32);
    private final a m = new a();

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/hh$a.class */
    public class a extends Thread {

        /* renamed from: c  reason: collision with root package name */
        private static final int f37528c = 60000;

        public a() {
            setName("tms-traffic");
            hh.this.h = false;
            hh.this.i = false;
        }

        /* JADX WARN: Code restructure failed: missing block: B:29:0x00cd, code lost:
            if (r7.f37419c == null) goto L64;
         */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                Method dump skipped, instructions count: 343
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mapsdk.internal.hh.a.run():void");
        }
    }

    public hh(rc rcVar) {
        if (rcVar == null) {
            return;
        }
        this.j = rcVar;
        rcVar.a(this);
        this.l = new gh(this.j.g());
        this.n = mc.b(rcVar.getContext()).i();
        this.o = (t3) n2.a(t3.class);
    }

    private eh a(int i, LatLng latLng, LatLng latLng2, LatLng latLng3) {
        byte[] bArr;
        NetResponse mapTrafficEvent = ((f3) this.o.d()).mapTrafficEvent(URLEncoder.encode(EncryptAesUtils.encryptAes256Base64("lblat=" + latLng.latitude + "&lblon=" + latLng.longitude + "&rtlat=" + latLng2.latitude + "&rtlon=" + latLng2.longitude + "&zoom=" + i + "&suid=" + c7.A() + "&version=" + c7.E() + "&nt=" + c7.G() + "&location=" + latLng3.latitude + "," + latLng3.longitude, p, q)));
        if (mapTrafficEvent == null || (bArr = mapTrafficEvent.data) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("rsp = ");
            sb.append(mapTrafficEvent != null ? Integer.valueOf(mapTrafficEvent.statusCode) : com.igexin.push.core.b.l);
            na.c("net", sb.toString());
            return null;
        }
        m mVar = new m(bArr);
        mVar.a("UTF-8");
        Response response = new Response();
        response.readFrom(mVar);
        eh ehVar = null;
        if (response.error == 0) {
            ehVar = null;
            if (response.detail != null) {
                ehVar = new eh(new LatLngBounds.Builder().include(latLng).include(latLng2).build(), response.detail);
            }
        }
        return ehVar;
    }

    private void a(List<Detail> list) {
        int i;
        byte[] h;
        byte[] bArr;
        for (Detail detail : list) {
            String str = detail.basic.icon_normal;
            int lastIndexOf = str.lastIndexOf(BridgeUtil.SPLIT_MARK);
            if (lastIndexOf != -1 && (i = lastIndexOf + 1) <= str.length()) {
                String substring = str.substring(i);
                if (b7.e.a(substring) == null) {
                    File file = new File(this.n, substring);
                    if (file.exists()) {
                        h = ga.h(file);
                    } else {
                        NetResponse doGet = NetManager.getInstance().builder().url(str).doGet();
                        if (doGet != null && (bArr = doGet.data) != null) {
                            ga.b(file, bArr);
                            h = doGet.data;
                        }
                    }
                    if (h != null && h.length > 0) {
                        b7.e.a(substring, BitmapFactory.decodeByteArray(h, 0, h.length));
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public eh b(int i) {
        rc rcVar = this.j;
        if (rcVar != null) {
            if (rcVar.V() == null || !this.j.V().A()) {
                na.c(ma.m, "traffic event tobe fetch data from net!");
                Rect e = this.j.e();
                return a(i, this.j.getProjection().a(new PointF(e.width() * (-2), e.height() * 3)), this.j.getProjection().a(new PointF(e.width() * 3, e.height() * (-2))), fa.d(this.j.b().a()));
            }
            return null;
        }
        return null;
    }

    public TrafficEvent a(int i) {
        gh ghVar = this.l;
        if (ghVar == null) {
            return null;
        }
        for (String str : ghVar.c().keySet()) {
            gh.a aVar = this.l.c().get(str);
            if (aVar != null && aVar.f37493a.d() == i) {
                return new fh(aVar.b);
            }
        }
        return null;
    }

    public void a() {
        this.i = true;
        this.g = false;
        synchronized (this.m) {
            this.m.notifyAll();
        }
    }

    public void a(eh ehVar) {
        List<Detail> list;
        w6 w;
        if (ehVar == null || (list = ehVar.f37419c) == null || list.isEmpty()) {
            return;
        }
        rc rcVar = this.j;
        if (rcVar != null && (w = rcVar.w()) != null) {
            w.o().b();
        }
        a(ehVar.f37419c);
        this.l.b(ehVar.f37419c);
    }

    public void a(eh ehVar, eh ehVar2) {
        List<Detail> list;
        List<Detail> list2;
        boolean z;
        if (ehVar2 == null || (list = ehVar2.f37419c) == null) {
            return;
        }
        if (list.isEmpty()) {
            this.l.a();
            return;
        }
        LinkedList linkedList = new LinkedList();
        if (ehVar == null || (list2 = ehVar.f37419c) == null || list2.isEmpty()) {
            return;
        }
        List<Detail> list3 = ehVar.f37419c;
        List<Detail> list4 = ehVar2.f37419c;
        for (Detail detail : list3) {
            Iterator<Detail> it = list4.iterator();
            while (true) {
                z = false;
                if (it.hasNext()) {
                    if (it.next().basic.eventid.equals(detail.basic.eventid)) {
                        z = true;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (!z) {
                linkedList.add(detail);
            }
        }
        this.l.a(linkedList);
    }

    public void a(boolean z) {
        this.g = z;
        if (z) {
            try {
                synchronized (this.m) {
                    this.m.start();
                }
                return;
            } catch (Exception e) {
                return;
            }
        }
        this.g = false;
        synchronized (this.m) {
            this.m.notifyAll();
        }
    }

    public void b() {
        this.h = true;
    }

    public void c() {
        this.h = false;
        synchronized (this.m) {
            this.m.notifyAll();
        }
    }

    @Override // com.tencent.mapsdk.internal.ne
    public void onMapCameraChangeStopped() {
        synchronized (this.m) {
            this.m.notifyAll();
        }
    }

    @Override // com.tencent.mapsdk.internal.ne
    public void onMapCameraChanged() {
    }
}
