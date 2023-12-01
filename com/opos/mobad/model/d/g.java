package com.opos.mobad.model.d;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.sdk.api.SplashAd;
import com.opos.cmn.func.b.b.d;
import com.opos.mobad.b.a.b;
import com.opos.mobad.b.a.x;
import com.opos.mobad.b.a.y;
import com.opos.mobad.model.data.AdData;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.FloatLayerData;
import com.opos.mobad.model.data.MaterialData;
import com.opos.mobad.model.data.MaterialFileData;
import com.opos.mobad.model.data.PendantData;
import com.opos.mobad.provider.ad.AdEntity;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/model/d/g.class */
public class g implements n {
    private static final int e = y.e.APP_INSTALLED.a();
    private static final int f = y.e.APP_UNINSTALLED.a();

    /* renamed from: a  reason: collision with root package name */
    private Context f12730a;
    private com.opos.mobad.model.a.a b;

    /* renamed from: c  reason: collision with root package name */
    private o f12731c;
    private com.opos.mobad.provider.ad.a d;

    public g(Context context, com.opos.mobad.model.a.b bVar) {
        Context a2 = com.opos.mobad.service.b.a(context.getApplicationContext());
        this.f12730a = a2;
        this.d = new com.opos.mobad.provider.ad.a(a2);
        this.b = new com.opos.mobad.model.a.a.a(this.f12730a, bVar);
        this.f12731c = new j(this.f12730a);
    }

    private static final int a(AdData adData) {
        if (adData != null) {
            try {
                if (adData.f() == null || adData.f().size() <= 0) {
                    return 0;
                }
                return adData.f().get(0).X();
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.b("FetchAdTask", "", e2);
                return 0;
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.opos.mobad.model.b.d a(com.opos.mobad.model.b.d dVar, h hVar) {
        com.opos.cmn.func.b.b.e eVar;
        List<com.opos.mobad.b.a.b> h;
        Context context;
        try {
            h = dVar.h();
        } catch (Throwable th) {
            th = th;
            eVar = null;
        }
        if (h != null && h.size() > 0) {
            JSONArray jSONArray = new JSONArray();
            for (com.opos.mobad.b.a.b bVar : h) {
                if (bVar.A != null && bVar.A.size() > 0) {
                    y yVar = bVar.A.get(0);
                    if (a(yVar, hVar)) {
                        if (c(yVar)) {
                            List<x> list = yVar.aq;
                            if (list != null && list.size() > 0) {
                                if (!a(bVar, list)) {
                                    hVar.e(yVar);
                                    com.opos.mobad.model.e.e.a(this.f12730a, yVar);
                                }
                            }
                            hVar.d(yVar);
                        }
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("adId", bVar.x);
                        jSONObject.put("adSource", bVar.R);
                        jSONObject.put("bizTraceId", yVar.aU);
                        jSONObject.put("posId", bVar.y);
                        jSONArray.put(jSONObject);
                    }
                }
            }
            com.opos.cmn.an.f.a.b("FetchAdTask", "data size:" + jSONArray.length());
            if (jSONArray.length() <= 0) {
                context = this.f12730a;
                hVar.a(context, 1);
                return null;
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("adReqInfoList", jSONArray);
            HashMap hashMap = new HashMap();
            hashMap.put("Content-Type", "application/json");
            hashMap.put("Route-Data", com.opos.cmn.biz.a.e.a(this.f12730a));
            com.opos.cmn.func.b.b.e a2 = com.opos.cmn.func.b.b.b.a().a(this.f12730a, new d.a().a(jSONObject2.toString().getBytes()).a(hashMap).a("POST").b("https://uapi.ads.heytapmobi.com/union/ads/advert/aol").a());
            try {
                com.opos.cmn.an.f.a.b("FetchAdTask", "check code:" + a2.f11174a);
            } catch (Throwable th2) {
                th = th2;
                eVar = a2;
                try {
                    com.opos.cmn.an.f.a.b("FetchAdTask", "check fail", th);
                    if (eVar == null) {
                        return null;
                    }
                    eVar.a();
                    return null;
                } catch (Throwable th3) {
                    if (eVar != null) {
                        eVar.a();
                    }
                    throw th3;
                }
            }
            if (a2 == null || 200 != a2.f11174a) {
                if (a2 != null) {
                    a2.a();
                }
                hVar.a(this.f12730a, 3);
                return null;
            }
            BufferedInputStream bufferedInputStream = new BufferedInputStream(a2.f11175c);
            byte[] bArr = new byte[1024];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (true) {
                int read = bufferedInputStream.read(bArr);
                if (read == -1) {
                    break;
                } else if (read > 0) {
                    byteArrayOutputStream.write(bArr, 0, read);
                }
            }
            String str = new String(byteArrayOutputStream.toByteArray(), Charset.forName("UTF-8"));
            com.opos.cmn.an.f.a.b("FetchAdTask", "check result:" + str);
            JSONObject jSONObject3 = new JSONObject(str);
            if (jSONObject3.getInt("code") == 0) {
                JSONArray optJSONArray = jSONObject3.optJSONArray("traceIdList");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    HashSet hashSet = new HashSet(optJSONArray.length());
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= optJSONArray.length()) {
                            break;
                        }
                        hashSet.add(optJSONArray.getString(i2));
                        i = i2 + 1;
                    }
                    ArrayList arrayList = new ArrayList();
                    for (com.opos.mobad.b.a.b bVar2 : h) {
                        if (bVar2.A != null && bVar2.A.size() > 0) {
                            y yVar2 = bVar2.A.get(0);
                            if (hashSet.contains(yVar2.aU)) {
                                hVar.i(yVar2);
                                arrayList.add(bVar2);
                            } else {
                                hVar.h(yVar2);
                            }
                        }
                    }
                    com.opos.cmn.an.f.a.a("FetchAdTask", "enable size:" + arrayList.size());
                    if (arrayList.size() > 0) {
                        hVar.a(this.f12730a);
                        com.opos.mobad.model.b.d dVar2 = new com.opos.mobad.model.b.d(dVar.c(), arrayList, dVar.i());
                        bufferedInputStream.close();
                        if (a2 != null) {
                            a2.a();
                        }
                        return dVar2;
                    }
                    hVar.a(this.f12730a, 4);
                    bufferedInputStream.close();
                    if (a2 == null) {
                        return null;
                    }
                    eVar = a2;
                }
                hVar.a(this.f12730a, 4);
                bufferedInputStream.close();
                if (a2 == null) {
                    return null;
                }
                eVar = a2;
            } else {
                hVar.a(this.f12730a, 3);
                bufferedInputStream.close();
                if (a2 == null) {
                    return null;
                }
                eVar = a2;
            }
            eVar.a();
            return null;
        }
        context = this.f12730a;
        hVar.a(context, 1);
        return null;
    }

    private com.opos.mobad.model.b.d a(String str, com.opos.mobad.model.b.c cVar, AtomicBoolean atomicBoolean, l lVar) {
        com.opos.mobad.model.b.b bVar;
        CountDownLatch countDownLatch = new CountDownLatch(1);
        AtomicReference atomicReference = new AtomicReference(null);
        a(str, cVar.a(), countDownLatch, atomicReference, lVar, cVar);
        a(str, cVar, countDownLatch, atomicReference, atomicBoolean, lVar);
        try {
            countDownLatch.await();
            bVar = (com.opos.mobad.model.b.d) atomicReference.get();
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.b("FetchAdTask", "response, select fail", e2);
            bVar = null;
        }
        com.opos.mobad.model.b.b bVar2 = bVar;
        if (bVar == null) {
            bVar2 = new com.opos.mobad.model.b.b(-1, "unknown error.");
        }
        return bVar2;
    }

    private com.opos.mobad.model.b.e a(x xVar) {
        if (com.opos.cmn.d.b.a(com.opos.cmn.d.c.a(this.f12730a, xVar.d), xVar.e)) {
            return null;
        }
        com.opos.mobad.model.b.e eVar = new com.opos.mobad.model.b.e();
        eVar.a(xVar.d);
        eVar.b(xVar.e);
        eVar.c(com.opos.cmn.d.c.a(this.f12730a, xVar.d));
        return eVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:76:0x01fa, code lost:
        if (r0.V.size() > 0) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x020f, code lost:
        if (r0.S.size() > 0) goto L74;
     */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0285 A[Catch: Exception -> 0x0417, TryCatch #0 {Exception -> 0x0417, blocks: (B:4:0x0004, B:7:0x0013, B:9:0x0019, B:10:0x0034, B:12:0x003f, B:15:0x004c, B:17:0x0057, B:18:0x0073, B:20:0x00b4, B:25:0x00c7, B:28:0x00dd, B:30:0x00e9, B:33:0x00f6, B:36:0x010b, B:38:0x0116, B:41:0x0126, B:42:0x0131, B:44:0x013a, B:45:0x0145, B:47:0x014d, B:51:0x015c, B:52:0x0167, B:54:0x0170, B:56:0x017c, B:59:0x0189, B:61:0x0194, B:62:0x01a8, B:64:0x01b0, B:88:0x022a, B:90:0x0285, B:92:0x028c, B:67:0x01bb, B:69:0x01c1, B:71:0x01d2, B:72:0x01dd, B:73:0x01e8, B:75:0x01f0, B:78:0x01ff, B:80:0x0205, B:83:0x0214, B:85:0x021a, B:94:0x029d, B:95:0x02a8, B:97:0x02b4, B:99:0x02c2, B:100:0x02ef, B:100:0x02ef, B:101:0x02f2, B:103:0x0319, B:108:0x032b, B:110:0x0339, B:111:0x0352, B:113:0x0362, B:114:0x0376, B:116:0x0386, B:118:0x0395, B:120:0x039e, B:121:0x03b7, B:106:0x0322, B:122:0x03fe), top: B:132:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.opos.mobad.model.data.AdData a(java.lang.String r16, com.opos.mobad.model.b.c r17, com.opos.mobad.model.b.d r18, boolean r19, com.opos.mobad.model.d.l r20, java.util.concurrent.atomic.AtomicBoolean r21) {
        /*
            Method dump skipped, instructions count: 1081
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.model.d.g.a(java.lang.String, com.opos.mobad.model.b.c, com.opos.mobad.model.b.d, boolean, com.opos.mobad.model.d.l, java.util.concurrent.atomic.AtomicBoolean):com.opos.mobad.model.data.AdData");
    }

    private MaterialFileData a(com.opos.mobad.b.a.b bVar, Set<com.opos.mobad.model.b.e> set, boolean z, q qVar) {
        x xVar = bVar.D;
        if (z) {
            set = null;
        }
        return a(xVar, true, set, qVar);
    }

    private MaterialFileData a(x xVar, boolean z) {
        if (xVar != null) {
            MaterialFileData materialFileData = new MaterialFileData();
            materialFileData.a(z ? xVar.d : com.opos.cmn.d.c.a(this.f12730a, xVar.d));
            materialFileData.b(xVar.e);
            return materialFileData;
        }
        return null;
    }

    private MaterialFileData a(x xVar, boolean z, Set<com.opos.mobad.model.b.e> set, q qVar) {
        if (xVar == null || com.opos.cmn.an.c.a.a(xVar.d)) {
            return null;
        }
        if (set != null) {
            com.opos.mobad.model.b.e a2 = a(xVar);
            if (a2 != null) {
                set.add(a2);
                if (!z) {
                    com.opos.mobad.service.j.n.a().a(false);
                }
            } else {
                if (!z) {
                    com.opos.mobad.service.j.n.a().a(true);
                }
                qVar.a(xVar.d, 2);
                com.opos.cmn.an.f.a.b("FetchAdTask", "material File " + xVar.toString() + " exists,don't need download again!!!");
            }
            return a(xVar, false);
        }
        return a(xVar, true);
    }

    private List<MaterialData> a(y yVar, Set<com.opos.mobad.model.b.e> set, Set<com.opos.mobad.model.b.e> set2, boolean z, q qVar) {
        List<MaterialFileData> a2;
        List<MaterialFileData> a3;
        List<MaterialFileData> a4;
        List<x> list = yVar.V;
        if (z) {
            a2 = a(list, (Set<com.opos.mobad.model.b.e>) null, qVar);
            a3 = a(yVar.ba, (Set<com.opos.mobad.model.b.e>) null, qVar);
            a4 = yVar.Q == y.b.RAW_VIDEO ? a(yVar.S, set2, qVar) : a(yVar.S, (Set<com.opos.mobad.model.b.e>) null, qVar);
        } else {
            a2 = a(list, set, qVar);
            a3 = a(yVar.ba, set2, qVar);
            a4 = a(yVar.S, set, qVar);
        }
        MaterialData materialData = new MaterialData(yVar, a4, a2, a(yVar.aq, (Set<com.opos.mobad.model.b.e>) null, qVar), a3, yVar.aH != null ? new FloatLayerData(yVar.aH, a(yVar.aH.d, false, set, qVar), a(yVar.aH.g, set2, qVar), a(yVar.aH.h, set2, qVar)) : null, yVar.aY != null ? new PendantData(a(yVar.aY.g, false, set2, qVar), yVar.aY) : null);
        ArrayList arrayList = new ArrayList();
        arrayList.add(materialData);
        return arrayList;
    }

    private List<MaterialFileData> a(List<x> list, Set<com.opos.mobad.model.b.e> set, q qVar) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            if (list.size() <= 0) {
                return arrayList;
            }
            for (x xVar : list) {
                MaterialFileData a2 = a(xVar, false, set, qVar);
                if (a2 != null) {
                    arrayList.add(a2);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<com.opos.mobad.b.a.b> a(byte[] bArr) throws IOException {
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
        ArrayList arrayList = new ArrayList();
        while (dataInputStream.available() > 0) {
            int readInt = dataInputStream.readInt();
            byte[] bArr2 = new byte[readInt];
            dataInputStream.read(bArr2, 0, readInt);
            arrayList.add(com.opos.mobad.b.a.b.f12020c.a(bArr2));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FutureTask<AdData> a(final String str, final com.opos.mobad.model.b.c cVar, final boolean z) {
        return new FutureTask<>(new Callable<AdData>() { // from class: com.opos.mobad.model.d.g.2
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public AdData call() throws Exception {
                return g.this.b(str, cVar, z);
            }
        });
    }

    private void a(final String str, final com.opos.mobad.model.b.c cVar, final CountDownLatch countDownLatch, final AtomicReference atomicReference, final AtomicBoolean atomicBoolean, final l lVar) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.model.d.g.4
            @Override // java.lang.Runnable
            public void run() {
                long currentTimeMillis = System.currentTimeMillis();
                com.opos.mobad.model.b.d a2 = g.this.b.a(str, cVar, lVar);
                if (a2 != null && a2.f() == 1035) {
                    com.opos.mobad.service.f.c().a(str, false, a2.l());
                }
                g.this.a(str, cVar.a(), a2.f(), System.currentTimeMillis() - currentTimeMillis);
                if (atomicReference.compareAndSet(null, a2)) {
                    com.opos.cmn.an.f.a.b("FetchAdTask", "fetch data select");
                    countDownLatch.countDown();
                    return;
                }
                com.opos.cmn.an.f.a.b("FetchAdTask", "cache new fetchAd");
                if (a2 == null || a2.f() != 0 || a2.b() <= 0 || a2.h() == null || a2.h().size() <= 0) {
                    return;
                }
                List<com.opos.mobad.b.a.b> subList = a2.h().subList(0, Math.min(a2.b(), a2.h().size()));
                atomicBoolean.set(true);
                g.this.a(str, a2, subList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final String str, final com.opos.mobad.model.b.d dVar, final List<com.opos.mobad.b.a.b> list) {
        StringBuilder sb = new StringBuilder();
        sb.append("cache list num:");
        sb.append(list != null ? list.size() : 0);
        com.opos.cmn.an.f.a.b("FetchAdTask", sb.toString());
        if (list == null || list.size() <= 0) {
            return;
        }
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.model.d.g.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    byte[] b = g.this.b(list);
                    g.this.d.a(str, new AdEntity(com.opos.mobad.b.a.d.f12034c.b((com.heytap.nearx.a.a.e<com.opos.mobad.b.a.d>) dVar.c()), b, dVar.i()));
                } catch (Exception e2) {
                    com.opos.cmn.an.f.a.a("FetchAdTask", "cache fail", (Throwable) e2);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, int i, long j) {
        com.opos.mobad.cmn.a.b.d.a(this.f12730a, str, str2, i, j);
    }

    private void a(final String str, final String str2, final CountDownLatch countDownLatch, final AtomicReference atomicReference, final l lVar, final com.opos.mobad.model.b.c cVar) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.model.d.g.3
            @Override // java.lang.Runnable
            public void run() {
                AdEntity a2;
                String str3;
                if (com.opos.mobad.service.a.c.a().d()) {
                    com.opos.mobad.model.b.c cVar2 = cVar;
                    if (cVar2 == null || !com.opos.mobad.service.f.a.a(cVar2.i())) {
                        h hVar = new h(str, str2);
                        try {
                            a2 = g.this.d.a(str);
                        } catch (Exception e2) {
                            com.opos.cmn.an.f.a.b("FetchAdTask", "fail cache", e2);
                        }
                        if (a2 == null) {
                            hVar.a(g.this.f12730a, 1);
                            return;
                        } else if (System.currentTimeMillis() >= a2.f13423c) {
                            hVar.a(g.this.f12730a, 2);
                            return;
                        } else {
                            com.opos.mobad.model.b.d dVar = new com.opos.mobad.model.b.d(com.opos.mobad.b.a.d.f12034c.a(a2.f13422a), g.this.a(a2.b), a2.f13423c);
                            com.opos.cmn.an.f.a.b("FetchAdTask", "cache data:", dVar);
                            if (dVar.h() != null && dVar.h().size() > 0) {
                                l lVar2 = lVar;
                                if (lVar2 != null) {
                                    lVar2.a();
                                }
                                com.opos.mobad.model.b.d a3 = g.this.a(dVar, hVar);
                                if (a3 != null) {
                                    if (atomicReference.compareAndSet(null, a3)) {
                                        com.opos.cmn.an.f.a.b("FetchAdTask", "check cache select");
                                        countDownLatch.countDown();
                                        return;
                                    }
                                    return;
                                }
                                str3 = "cache check fail";
                            }
                            hVar.a(g.this.f12730a, 1);
                            return;
                        }
                    }
                    str3 = "cache but in childMode";
                    com.opos.cmn.an.f.a.b("FetchAdTask", str3);
                }
            }
        });
    }

    private void a(List<AdItemData> list) {
        MaterialData materialData;
        com.opos.cmn.an.f.a.b("FetchAdTask", "prepare web" + list);
        if (list == null || list.size() <= 0) {
            return;
        }
        for (AdItemData adItemData : list) {
            List<MaterialData> i = adItemData.i();
            if (i != null && i.size() > 0 && (materialData = i.get(0)) != null) {
                u.a(this.f12730a, materialData.i, materialData.h);
            }
        }
    }

    private boolean a(com.opos.mobad.b.a.b bVar, List<x> list) {
        if (bVar.M == b.c.PLAY_CACHE) {
            x xVar = list.get(0);
            if (TextUtils.isEmpty(com.opos.cmn.d.d.a(this.f12730a, xVar.d, xVar.e))) {
                com.opos.mobad.service.j.n.a().b(false);
                com.opos.cmn.an.f.a.b("FetchAdTask", "isVideoEnableMaterial but not cache video");
                return false;
            }
            com.opos.mobad.service.j.n.a().b(true);
        }
        com.opos.cmn.an.f.a.b("FetchAdTask", "isVideoEnableMaterial");
        return true;
    }

    private boolean a(y yVar) {
        String str;
        if (!b(yVar) || yVar.ax != y.c.DOWNLOADER) {
            str = "is not downloader mat";
        } else if (yVar.ax != y.c.DOWNLOADER) {
            com.opos.cmn.an.f.a.b("FetchAdTask", "is invalid downloader mat");
            return false;
        } else {
            str = "is downloader mat";
        }
        com.opos.cmn.an.f.a.b("FetchAdTask", str);
        return true;
    }

    private boolean a(y yVar, q qVar) {
        boolean z = yVar == null || !b(yVar, qVar);
        com.opos.cmn.an.f.a.b("FetchAdTask", "isValidMaterialEntity materialEntity=", yVar, "result=", Boolean.valueOf(z));
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AdData b(String str, com.opos.mobad.model.b.c cVar, boolean z) {
        AdData adData;
        com.opos.cmn.an.f.a.b("FetchAdTask", "fetchAdData");
        try {
            l lVar = new l(str, cVar.a());
            com.opos.cmn.an.f.a.a("FetchAdTask", "fetchAdRequest=", cVar);
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            com.opos.mobad.model.b.d a2 = a(str, cVar, atomicBoolean, lVar);
            com.opos.cmn.an.f.a.b("FetchAdTask", "fetchAdResponse end");
            com.opos.mobad.model.e.d.a(this.f12730a, str, a2.d());
            lVar.b();
            if (a2.p()) {
                com.opos.mobad.service.i.d.a().b();
            }
            if (a2.q()) {
                com.opos.mobad.service.f.b().a();
            }
            adData = z ? a(str, cVar, a2, false, lVar, atomicBoolean) : a(str, cVar, a2, true, lVar, atomicBoolean);
            try {
                if (adData.d() != 10000) {
                    lVar.a(this.f12730a, adData.d(), adData.e(), a2.a(), cVar.i());
                    return adData;
                }
                lVar.a(this.f12730a, a2.j(), a2.a(), cVar.i(), a(adData));
                return adData;
            } catch (Exception e2) {
                e = e2;
                com.opos.cmn.an.f.a.a("FetchAdTask", "fetchAdData", (Throwable) e);
                return adData;
            }
        } catch (Exception e3) {
            e = e3;
            adData = null;
        }
    }

    private boolean b(y yVar) {
        return yVar.R == y.h.DOWNLOAD || yVar.au == y.h.DOWNLOAD || yVar.av == y.h.DOWNLOAD || yVar.aI == y.h.DOWNLOAD || yVar.aJ == y.h.DOWNLOAD;
    }

    private boolean b(y yVar, q qVar) {
        if (yVar.aL == null) {
            return false;
        }
        int intValue = yVar.aL.intValue();
        int i = e;
        if (i == (i & intValue) && !TextUtils.isEmpty(yVar.X) && com.opos.cmn.an.h.d.a.d(this.f12730a, yVar.X)) {
            com.opos.cmn.an.f.a.b("FetchAdTask", "filter install");
            qVar.a(yVar);
            return true;
        }
        int i2 = f;
        if (i2 != (intValue & i2) || TextUtils.isEmpty(yVar.X) || com.opos.cmn.an.h.d.a.d(this.f12730a, yVar.X)) {
            return false;
        }
        com.opos.cmn.an.f.a.b("FetchAdTask", "filter uninstall");
        qVar.g(yVar);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public byte[] b(List<com.opos.mobad.b.a.b> list) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        for (com.opos.mobad.b.a.b bVar : list) {
            byte[] b = com.opos.mobad.b.a.b.f12020c.b((com.heytap.nearx.a.a.e<com.opos.mobad.b.a.b>) bVar);
            dataOutputStream.writeInt(b.length);
            dataOutputStream.write(b);
        }
        dataOutputStream.flush();
        return byteArrayOutputStream.toByteArray();
    }

    private boolean c(y yVar) {
        return yVar.Q == y.b.VIDEO || yVar.Q == y.b.FULL_VIDEO || yVar.Q == y.b.POP_WINDOW_VIDEO || yVar.Q == y.b.RAW_VIDEO || yVar.Q == y.b.VIDEO_HTML || yVar.Q == y.b.VIDEO_TIP_BAR;
    }

    public void a(final String str, final com.opos.mobad.model.b.c cVar, final com.opos.mobad.model.c.a aVar, final long j, final boolean z, final Object... objArr) {
        com.opos.cmn.an.j.b.b(new Runnable() { // from class: com.opos.mobad.model.d.g.1
            @Override // java.lang.Runnable
            public void run() {
                com.opos.cmn.an.f.a.b("FetchAdTask", "fetchAd fetchTimeout=" + j + ",needDownloadMaterial=" + z);
                try {
                    try {
                        FutureTask a2 = g.this.a(str, cVar, z);
                        com.opos.cmn.an.j.b.b(a2);
                        AdData adData = (AdData) a2.get(j, TimeUnit.MILLISECONDS);
                        com.opos.mobad.model.c.a aVar2 = aVar;
                        if (aVar2 != null) {
                            if (adData != null) {
                                aVar2.a(adData.d(), adData.e(), adData, objArr);
                            } else {
                                aVar2.a(-1, "unknown error.", null, objArr);
                            }
                        }
                    } catch (Exception e2) {
                        com.opos.cmn.an.f.a.c("FetchAdTask", SplashAd.KEY_FETCHAD, e2);
                        com.opos.mobad.model.c.a aVar3 = aVar;
                        if (aVar3 != null) {
                            aVar3.a(-1, "unknown error.", null, objArr);
                        }
                    }
                } catch (Throwable th) {
                    com.opos.mobad.model.c.a aVar4 = aVar;
                    if (aVar4 != null) {
                        aVar4.a(-1, "unknown error.", null, objArr);
                    }
                    throw th;
                }
            }
        });
    }
}
