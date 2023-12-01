package com.opos.mobad.cmn.a;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.text.TextUtils;
import android.view.View;
import com.huawei.openalliance.ad.constant.at;
import com.opos.cmn.i.k;
import com.opos.cmn.i.o;
import com.opos.mobad.cmn.a.d;
import com.opos.mobad.cmn.service.pkginstall.b;
import com.opos.mobad.model.data.ActivatingData;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.ApkSignerData;
import com.opos.mobad.model.data.MaterialData;
import com.opos.mobad.service.event.EventDescription;
import com.opos.mobad.service.f;
import com.opos.mobad.service.g.a;
import com.tencent.qcloud.core.auth.AuthConstants;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/cmn/a/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f25817a = com.opos.cmn.an.a.b.a("aGV5dGFwX3VuaW9uX3Rva2Vu");
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private String f25818c;
    private com.opos.mobad.cmn.a.d d;
    private b e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.opos.mobad.cmn.a.a$6  reason: invalid class name */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/cmn/a/a$6.class */
    public static /* synthetic */ class AnonymousClass6 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f25829a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x004d -> B:37:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0051 -> B:33:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0055 -> B:31:0x002a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0059 -> B:27:0x0035). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x005d -> B:35:0x0040). Please submit an issue!!! */
        static {
            int[] iArr = new int[com.opos.mobad.cmn.a.b.a.values().length];
            f25829a = iArr;
            try {
                iArr[com.opos.mobad.cmn.a.b.a.Video.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f25829a[com.opos.mobad.cmn.a.b.a.ClickBt.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f25829a[com.opos.mobad.cmn.a.b.a.NonClickBt.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f25829a[com.opos.mobad.cmn.a.b.a.FloatLayerClickBt.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f25829a[com.opos.mobad.cmn.a.b.a.FloatLayerNonClickBt.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f25829a[com.opos.mobad.cmn.a.b.a.Pendant.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    /* renamed from: com.opos.mobad.cmn.a.a$a  reason: collision with other inner class name */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/cmn/a/a$a.class */
    public interface InterfaceC0679a {
        void a();

        void b();
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/cmn/a/a$b.class */
    public interface b {
        void a();

        void a(InterfaceC0679a interfaceC0679a);
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/cmn/a/a$c.class */
    public interface c {
        void a(int i);

        void a(int i, int i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/cmn/a/a$d.class */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        private String f25830a;
        private String b;

        /* renamed from: c  reason: collision with root package name */
        private String f25831c;
        private Signature d;

        public d(Signature signature) {
            this.d = signature;
        }

        public String a() {
            if (TextUtils.isEmpty(this.f25830a)) {
                try {
                    this.f25830a = k.a("md5", this.d);
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.b("AdHandler", "", e);
                }
            }
            return this.f25830a;
        }

        public String b() {
            if (TextUtils.isEmpty(this.b)) {
                try {
                    this.b = k.a(AuthConstants.SHA1, this.d);
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.b("AdHandler", "", e);
                }
            }
            return this.b;
        }

        public String c() {
            if (TextUtils.isEmpty(this.f25831c)) {
                try {
                    this.f25831c = k.a(at.aq, this.d);
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.b("AdHandler", "", e);
                }
            }
            return this.f25831c;
        }
    }

    public a(Context context, String str, com.opos.mobad.cmn.a.d dVar) {
        this.b = com.opos.mobad.service.b.a(context);
        this.f25818c = str;
        this.d = dVar;
    }

    private int a(ApkSignerData apkSignerData, List<d> list) {
        int i;
        int i2;
        if (TextUtils.isEmpty(apkSignerData.f26464a) && TextUtils.isEmpty(apkSignerData.b) && TextUtils.isEmpty(apkSignerData.f26465c)) {
            return -1;
        }
        int i3 = 0;
        while (true) {
            i = i3;
            i2 = -1;
            if (i >= list.size()) {
                break;
            }
            d dVar = list.get(i);
            if ((TextUtils.isEmpty(apkSignerData.f26464a) || apkSignerData.f26464a.equals(dVar.a())) && ((TextUtils.isEmpty(apkSignerData.b) || apkSignerData.b.equals(dVar.b())) && (TextUtils.isEmpty(apkSignerData.f26465c) || apkSignerData.f26465c.equals(dVar.c())))) {
                break;
            }
            i3 = i + 1;
        }
        i2 = i;
        return i2;
    }

    private int a(MaterialData materialData) {
        int D = materialData != null ? materialData.D() : 0;
        com.opos.cmn.an.f.a.b("AdHandler", "getSurfingType=" + D);
        return D;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, c cVar) {
        if (cVar != null) {
            cVar.a(i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, c cVar) {
        if (cVar != null) {
            cVar.a(i);
        }
    }

    private void a(final int i, final AdItemData adItemData, final MaterialData materialData, final boolean z, final int[] iArr, final Map<String, String> map, final com.opos.mobad.service.g.a aVar, final boolean z2, final b.InterfaceC0687b interfaceC0687b, final com.opos.mobad.cmn.a.b bVar, final c cVar) {
        com.opos.cmn.an.j.b.d(new Runnable() { // from class: com.opos.mobad.cmn.a.a.2
            @Override // java.lang.Runnable
            public void run() {
                com.opos.cmn.an.f.a.b("AdHandler", "handleAdClickActionAndSTEvent adItemData=", adItemData);
                adItemData.b();
                switch (i) {
                    case 1:
                        a.this.d(adItemData, materialData, z, iArr, map, aVar, (b.InterfaceC0687b) null, bVar, cVar);
                        return;
                    case 2:
                        if (com.opos.cmn.an.h.d.a.d(a.this.b, materialData.k())) {
                            a.this.a(adItemData, materialData, z, iArr, map, aVar, interfaceC0687b, bVar, cVar);
                            return;
                        } else if (1 == materialData.L()) {
                            a aVar2 = a.this;
                            AdItemData adItemData2 = adItemData;
                            MaterialData materialData2 = materialData;
                            aVar2.a(adItemData2, materialData2, materialData2.t(), z, iArr, (Map<String, String>) map, aVar, interfaceC0687b, false, cVar);
                            return;
                        } else if (2 == materialData.L()) {
                            a.this.a(adItemData, materialData, z, iArr, map, aVar, z2, interfaceC0687b, bVar, cVar);
                            return;
                        } else if (3 == materialData.L()) {
                            a aVar3 = a.this;
                            AdItemData adItemData3 = adItemData;
                            MaterialData materialData3 = materialData;
                            aVar3.a(adItemData3, materialData3, materialData3.t(), z, iArr, (Map<String, String>) map, aVar, interfaceC0687b, true, cVar);
                            return;
                        } else {
                            a aVar4 = a.this;
                            AdItemData adItemData4 = adItemData;
                            MaterialData materialData4 = materialData;
                            aVar4.a(adItemData4, materialData4, materialData4.t(), z, iArr, map, aVar, interfaceC0687b, materialData.R(), materialData.S(), bVar, cVar);
                            return;
                        }
                    case 3:
                        if (com.opos.cmn.an.h.d.a.d(a.this.b, materialData.k())) {
                            a.this.a(adItemData, materialData, z, iArr, map, aVar, interfaceC0687b, bVar, cVar);
                            return;
                        } else {
                            a.this.b(adItemData, materialData, z, iArr, map, aVar, interfaceC0687b, bVar, cVar);
                            return;
                        }
                    case 4:
                        a.this.b(adItemData, materialData, z, iArr, map, aVar, bVar, cVar);
                        return;
                    case 5:
                        a.this.c(adItemData, materialData, z, iArr, map, aVar, bVar, cVar);
                        return;
                    case 6:
                        a.this.c(adItemData, materialData, z, iArr, map, aVar, (b.InterfaceC0687b) null, bVar, cVar);
                        return;
                    case 7:
                        a.this.e(adItemData, materialData, z, iArr, map, aVar, (b.InterfaceC0687b) null, bVar, cVar);
                        return;
                    default:
                        a.this.a(0, -2, cVar);
                        return;
                }
            }
        });
    }

    private void a(AdItemData adItemData, MaterialData materialData, b.InterfaceC0687b interfaceC0687b) {
        if (adItemData == null || materialData == null) {
            return;
        }
        com.opos.cmn.an.f.a.b("AdHandler", "pkgInstallListener :" + interfaceC0687b);
        if (interfaceC0687b == null) {
            com.opos.mobad.cmn.service.pkginstall.b.a(this.b).a(materialData.k(), adItemData);
        } else {
            com.opos.mobad.cmn.service.pkginstall.b.a(this.b).a(materialData.k(), interfaceC0687b, adItemData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AdItemData adItemData, MaterialData materialData, String str, boolean z, int[] iArr, Map<String, String> map, com.opos.mobad.service.g.a aVar, b.InterfaceC0687b interfaceC0687b, String str2, String str3, com.opos.mobad.cmn.a.b bVar, c cVar) {
        if (adItemData == null || materialData == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("handleDLApkAndSTEvent pkgName=");
        sb.append(materialData.k());
        sb.append(",posId=");
        sb.append(this.f25818c);
        sb.append(",channelPkg=");
        sb.append(str != null ? str : com.igexin.push.core.b.l);
        sb.append(",trackContent=");
        sb.append(str2 != null ? str2 : com.igexin.push.core.b.l);
        sb.append(",trackReference=");
        String str4 = com.igexin.push.core.b.l;
        if (str3 != null) {
            str4 = str3;
        }
        sb.append(str4);
        com.opos.cmn.an.f.a.b("AdHandler", sb.toString());
        HashMap hashMap = new HashMap();
        if (map != null && map.size() > 0) {
            hashMap.putAll(map);
        }
        if (!com.opos.cmn.an.c.a.a(str)) {
            hashMap.put("dlChannel", str);
        }
        if (this.d.a(this.b, materialData.k(), this.f25818c, str, materialData.q(), str2, str3)) {
            a(adItemData, materialData, interfaceC0687b);
            hashMap.put("jumpRet", "1");
            aVar.a(a.b.MARKET).a("1");
            com.opos.cmn.an.f.a.a("AdHandler", "handleDLApkAndSTEvent pkgName" + materialData.k() + " = true");
            a(1, cVar);
        } else {
            hashMap.put("jumpRet", "0");
            aVar.a(a.b.MARKET).a("0");
            com.opos.cmn.an.f.a.a("AdHandler", "handleDLApkAndSTEvent pkgName=" + materialData.k() + " = false");
            a(1, -2, cVar);
        }
        com.opos.mobad.cmn.a.b.d.a(this.b, this.f25818c, adItemData, materialData, z, iArr, hashMap);
        aVar.a(this.b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AdItemData adItemData, MaterialData materialData, String str, boolean z, int[] iArr, Map<String, String> map, com.opos.mobad.service.g.a aVar, b.InterfaceC0687b interfaceC0687b, boolean z2, c cVar) {
        if (adItemData == null || materialData == null) {
            return;
        }
        com.opos.cmn.an.f.a.b("AdHandler", "handleDeeplinkDLApkAndSTEvent pkgName=" + materialData.k() + ",posId=" + this.f25818c + ",isSafeJump = " + z2);
        HashMap hashMap = new HashMap();
        if (map != null && map.size() > 0) {
            hashMap.putAll(map);
        }
        if (!com.opos.cmn.an.c.a.a(str)) {
            hashMap.put("dlChannel", str);
        }
        com.opos.mobad.cmn.a.d dVar = this.d;
        if (z2 ? dVar.e(this.b, materialData.M()) : dVar.d(this.b, materialData.M())) {
            a(adItemData, materialData, interfaceC0687b);
            hashMap.put("jumpRet", "1");
            aVar.a(a.b.MARKET).a("1");
            com.opos.cmn.an.f.a.b("AdHandler", "handleDeeplinkDLApkAndSTEvent pkgName" + materialData.k() + " = true");
            a(1, cVar);
        } else {
            hashMap.put("jumpRet", "0");
            aVar.a(a.b.MARKET).a("0");
            com.opos.cmn.an.f.a.b("AdHandler", "handleDeeplinkDLApkAndSTEvent pkgName=" + materialData.k() + " = false");
            a(1, -1, cVar);
        }
        com.opos.mobad.cmn.a.b.d.a(this.b, this.f25818c, adItemData, materialData, z, iArr, hashMap);
        aVar.a(this.b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AdItemData adItemData, MaterialData materialData, boolean z, int[] iArr, Map<String, String> map, com.opos.mobad.service.g.a aVar, b.InterfaceC0687b interfaceC0687b, com.opos.mobad.cmn.a.b bVar, c cVar) {
        int I = materialData.I();
        if (!(I != 1 ? I != 2 ? false : a(adItemData, materialData, z, iArr, map, aVar, bVar, cVar) : b(adItemData, materialData, z, iArr, map, aVar, bVar, cVar)) || interfaceC0687b == null) {
            return;
        }
        interfaceC0687b.b(adItemData, materialData.k());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final AdItemData adItemData, final MaterialData materialData, boolean z, int[] iArr, Map<String, String> map, com.opos.mobad.service.g.a aVar, boolean z2, final b.InterfaceC0687b interfaceC0687b, com.opos.mobad.cmn.a.b bVar, c cVar) {
        if (adItemData == null || materialData == null) {
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            if (map != null && map.size() > 0) {
                hashMap.putAll(map);
            }
            if (materialData.N() == null) {
                return;
            }
            String a2 = materialData.N().a();
            String c2 = materialData.N().c();
            String d2 = materialData.N().d();
            String b2 = materialData.N().b();
            com.opos.cmn.an.f.a.b("AdHandler", "handleDownloaderAndSTEvent pkgName=" + c2 + ",appName=" + d2 + ",md5=" + b2 + ",url=" + a2);
            if (!com.opos.cmn.an.c.a.a(materialData.t())) {
                hashMap.put("dlChannel", materialData.t());
            }
            if (z2 || TextUtils.isEmpty(a2) || TextUtils.isEmpty(c2)) {
                hashMap.put("jumpRet", "0");
                aVar.a(a.b.DOWNLOADER).a("0");
                com.opos.mobad.cmn.a.b.d.d(this.b, this.f25818c, adItemData, materialData, z, iArr, hashMap);
                a(7, -1, cVar);
            } else {
                a(adItemData, materialData, new b.InterfaceC0687b() { // from class: com.opos.mobad.cmn.a.a.4
                    @Override // com.opos.mobad.cmn.service.pkginstall.b.InterfaceC0687b
                    public void a(AdItemData adItemData2, String str) {
                        com.opos.cmn.an.f.a.b("AdHandler", "notifyInstallCompletedEvent pkgName = " + str);
                        b.InterfaceC0687b interfaceC0687b2 = interfaceC0687b;
                        if (interfaceC0687b2 != null) {
                            interfaceC0687b2.a(adItemData2, str);
                        }
                        if (materialData.Q() != null && materialData.Q().size() > 0) {
                            com.opos.mobad.service.g.b.a().a(materialData.Q()).a(a.this.b);
                        }
                        com.opos.mobad.cmn.service.a.a.a(a.this.b).c(str);
                    }

                    @Override // com.opos.mobad.cmn.service.pkginstall.b.InterfaceC0687b
                    public void b(AdItemData adItemData2, String str) {
                        b.InterfaceC0687b interfaceC0687b2 = interfaceC0687b;
                        if (interfaceC0687b2 != null) {
                            interfaceC0687b2.b(adItemData2, str);
                        }
                    }

                    @Override // com.opos.mobad.cmn.service.pkginstall.b.InterfaceC0687b
                    public void c(AdItemData adItemData2, String str) {
                        b.InterfaceC0687b interfaceC0687b2 = interfaceC0687b;
                        if (interfaceC0687b2 != null) {
                            interfaceC0687b2.c(adItemData2, str);
                        }
                    }

                    public boolean equals(Object obj) {
                        if (this != obj) {
                            if (obj == null || obj.hashCode() != hashCode()) {
                                return super.equals(obj);
                            }
                            return true;
                        }
                        return true;
                    }

                    public int hashCode() {
                        String aa = materialData.aa();
                        return TextUtils.isEmpty(aa) ? super.hashCode() : aa.hashCode();
                    }
                });
                com.opos.mobad.cmn.service.a.a.a(this.b).a(f.b().d(), f.b().e());
                com.opos.mobad.cmn.service.a.a.a(this.b).a(a2, c2, b2, d2, new com.opos.mobad.cmn.service.a.c() { // from class: com.opos.mobad.cmn.a.a.5
                    @Override // com.opos.mobad.cmn.service.a.c
                    public void a(int i, int i2, String str, String str2) {
                        if (adItemData.L()) {
                            return;
                        }
                        adItemData.f(true);
                        Context context = a.this.b;
                        AdItemData adItemData2 = adItemData;
                        com.opos.mobad.cmn.a.b.d.b(context, adItemData2, adItemData2.i().get(0));
                        if (materialData.O() == null || materialData.O().size() <= 0) {
                            return;
                        }
                        com.opos.mobad.service.g.b.a().a(materialData.O()).a(a.this.b);
                    }

                    @Override // com.opos.mobad.cmn.service.a.c
                    public void a(int i, int i2, String str, String str2, String str3) {
                        Context context = a.this.b;
                        AdItemData adItemData2 = adItemData;
                        com.opos.mobad.cmn.a.b.d.a(context, adItemData2, adItemData2.i().get(0), str3);
                    }

                    @Override // com.opos.mobad.cmn.service.a.c
                    public void b(int i, int i2, String str, String str2) {
                    }

                    @Override // com.opos.mobad.cmn.service.a.c
                    public void c(int i, int i2, String str, String str2) {
                    }

                    @Override // com.opos.mobad.cmn.service.a.c
                    public void d(int i, int i2, String str, String str2) {
                    }

                    @Override // com.opos.mobad.cmn.service.a.c
                    public void e(int i, int i2, String str, String str2) {
                    }

                    public boolean equals(Object obj) {
                        if (this != obj) {
                            if (obj == null || obj.hashCode() != hashCode()) {
                                return super.equals(obj);
                            }
                            return true;
                        }
                        return true;
                    }

                    @Override // com.opos.mobad.cmn.service.a.c
                    public void f(int i, int i2, String str, String str2) {
                        if (adItemData.M()) {
                            return;
                        }
                        adItemData.g(true);
                        Context context = a.this.b;
                        AdItemData adItemData2 = adItemData;
                        com.opos.mobad.cmn.a.b.d.c(context, adItemData2, adItemData2.i().get(0));
                        if (materialData.P() == null || materialData.P().size() <= 0) {
                            return;
                        }
                        com.opos.mobad.service.g.b.a().a(materialData.P()).a(a.this.b);
                    }

                    public int hashCode() {
                        String aa = materialData.aa();
                        return TextUtils.isEmpty(aa) ? super.hashCode() : aa.hashCode();
                    }
                });
                hashMap.put("jumpRet", "1");
                aVar.a(a.b.DOWNLOADER).a("1");
                com.opos.mobad.cmn.a.b.d.a(this.b, this.f25818c, adItemData, materialData, z, iArr, hashMap);
                a(7, cVar);
            }
            aVar.a(this.b);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("AdHandler", "", (Throwable) e);
        }
    }

    private void a(AdItemData adItemData, boolean z, int[] iArr, Map<String, String> map, com.opos.mobad.cmn.a.b.a aVar, com.opos.mobad.service.g.a aVar2, boolean z2, b.InterfaceC0687b interfaceC0687b, com.opos.mobad.cmn.a.b bVar, c cVar) {
        switch (AnonymousClass6.f25829a[aVar.ordinal()]) {
            case 1:
                d(adItemData, z, iArr, map, aVar2, z2, interfaceC0687b, bVar, cVar);
                return;
            case 2:
                b(adItemData, z, iArr, map, aVar2, z2, interfaceC0687b, bVar, cVar);
                return;
            case 3:
                c(adItemData, z, iArr, map, aVar2, z2, interfaceC0687b, bVar, cVar);
                return;
            case 4:
                e(adItemData, z, iArr, map, aVar2, z2, interfaceC0687b, bVar, cVar);
                return;
            case 5:
                f(adItemData, z, iArr, map, aVar2, z2, interfaceC0687b, bVar, cVar);
                return;
            case 6:
                a(adItemData, z, iArr, map, aVar2, z2, interfaceC0687b, bVar, cVar);
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AdItemData adItemData, boolean z, int[] iArr, Map<String, String> map, com.opos.mobad.cmn.a.b.a aVar, boolean z2, b.InterfaceC0687b interfaceC0687b, com.opos.mobad.cmn.a.b bVar, c cVar) {
        com.opos.mobad.service.g.a a2 = com.opos.mobad.service.g.b.a();
        if (adItemData != null) {
            try {
                MaterialData materialData = adItemData.i().get(0);
                if (materialData != null) {
                    if (materialData.p() != null && materialData.p().size() > 0) {
                        if (bVar != null && bVar.b) {
                            a2.a(bVar.f25833c);
                        } else if (map != null && map.size() > 0) {
                            String str = map.get("vPlyPos");
                            if (!TextUtils.isEmpty(str)) {
                                try {
                                    a2.a(Integer.parseInt(str));
                                } catch (NumberFormatException e) {
                                    com.opos.cmn.an.f.a.a("AdHandler", "", (Throwable) e);
                                }
                            }
                        }
                    }
                    a2.a(materialData.p());
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("AdHandler", "", (Throwable) e2);
            }
        }
        a(adItemData, z, iArr, map, aVar, a2, z2, interfaceC0687b, bVar, cVar);
    }

    private void a(AdItemData adItemData, boolean z, int[] iArr, Map<String, String> map, com.opos.mobad.service.g.a aVar, boolean z2, b.InterfaceC0687b interfaceC0687b, com.opos.mobad.cmn.a.b bVar, c cVar) {
        MaterialData materialData;
        com.opos.cmn.an.f.a.b("AdHandler", "handlePendantAdClickActionAndStEvent adItemData=", adItemData);
        if (adItemData == null || (materialData = adItemData.i().get(0)) == null) {
            return;
        }
        aVar.a(a.EnumC0736a.PENDANT).a(iArr);
        HashMap hashMap = new HashMap();
        if (map != null && !map.isEmpty()) {
            hashMap.putAll(map);
        }
        com.opos.mobad.cmn.a.b.d.a(hashMap, "6", String.valueOf(materialData.ab().b()));
        a(materialData.ab().b(), adItemData, materialData, z, iArr, hashMap, aVar, z2, interfaceC0687b, bVar, cVar);
    }

    private void a(String str, AdItemData adItemData, boolean z, b.InterfaceC0687b interfaceC0687b, EventDescription eventDescription) {
        if (com.opos.cmn.an.c.a.a(str) || adItemData == null || adItemData.i() == null || adItemData.i().size() <= 0) {
            return;
        }
        try {
            com.opos.cmn.an.f.a.b("AdHandler", "loadWebPage url=" + str);
            String a2 = -1 != com.opos.mobad.cmn.a.b.f.c(str) ? com.opos.mobad.cmn.a.b.f.a(adItemData, str, this.f25818c) : "";
            String a3 = com.opos.mobad.cmn.a.b.f.a(this.b, str, (int[]) null, 0L);
            if (interfaceC0687b != null) {
                com.opos.mobad.cmn.a.b.f.a(interfaceC0687b);
            }
            this.d.a(this.b, this.f25818c, a3, adItemData, a2, eventDescription);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("AdHandler", "", (Throwable) e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, AdItemData adItemData, boolean z, int[] iArr, com.opos.mobad.service.g.a aVar, b.InterfaceC0687b interfaceC0687b, com.opos.mobad.cmn.a.b bVar, c cVar) {
        if (com.opos.cmn.an.c.a.a(str) || adItemData == null || adItemData.i() == null || adItemData.i().size() <= 0) {
            return;
        }
        try {
            int a2 = a(adItemData.i().get(0));
            if (a2 == 0) {
                aVar.a(a.b.WEB_VIEW).a("1");
            } else if (a2 == 1) {
                aVar.a(a.b.BROWSER).a("1");
                a(str, aVar, cVar);
                aVar.a(this.b);
            } else {
                aVar.a(a.b.WEB_VIEW).a("1");
            }
            b(str, adItemData, z, iArr, aVar, interfaceC0687b, bVar, cVar);
            aVar.a(this.b);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("AdHandler", "", (Throwable) e);
        }
    }

    private void a(String str, com.opos.mobad.service.g.a aVar, c cVar) {
        if (com.opos.cmn.an.c.a.a(str)) {
            a(2, -1, cVar);
            return;
        }
        String a2 = com.opos.mobad.service.g.b.a(this.b, str, aVar);
        com.opos.cmn.an.f.a.b("AdHandler", "loadWebPageByBrowser url=" + a2);
        this.d.c(this.b, a2);
        a(2, cVar);
    }

    private void a(String str, String str2) {
        try {
            Intent intent = new Intent(str);
            intent.setPackage(str2);
            List<ResolveInfo> queryIntentServices = this.b.getPackageManager().queryIntentServices(intent, 128);
            if (queryIntentServices != null && queryIntentServices.size() == 1) {
                intent.putExtra("from", this.b.getPackageName());
                this.b.startService(intent);
                com.opos.mobad.cmn.a.b.d.a(this.b, this.f25818c, str2, 0);
                return;
            }
            com.opos.mobad.cmn.a.b.d.a(this.b, this.f25818c, str2, 6);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.b("AdHandler", "", e);
            com.opos.mobad.cmn.a.b.d.a(this.b, this.f25818c, str2, 7);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00af  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean a(com.opos.mobad.model.data.ActivatingData r7) {
        /*
            Method dump skipped, instructions count: 429
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.cmn.a.a.a(com.opos.mobad.model.data.ActivatingData):boolean");
    }

    private boolean a(AdItemData adItemData, MaterialData materialData, boolean z, int[] iArr, Map<String, String> map, com.opos.mobad.service.g.a aVar, com.opos.mobad.cmn.a.b bVar, c cVar) {
        String s;
        if (adItemData == null || materialData == null) {
            return false;
        }
        try {
            s = materialData.s();
        } catch (Exception e) {
            e = e;
            z = false;
        }
        try {
            if (com.opos.cmn.an.c.a.a(s) || !this.d.b(this.b, s)) {
                boolean b2 = b(adItemData, materialData, z, iArr, map, aVar, bVar, cVar);
                com.opos.cmn.an.f.a.b("AdHandler", "handleDeepLinkAndSTEvent open deeplink fail.open homepage");
                return b2;
            }
            com.opos.mobad.cmn.a.b.d.c(this.b, this.f25818c, adItemData, materialData, z, iArr, map);
            aVar.a(a.b.DEEP_LINK).a("1");
            aVar.a(this.b);
            StringBuilder sb = new StringBuilder();
            sb.append("handleDeepLinkAndSTEvent open deeplink success.extraUrl = ");
            sb.append(s);
            com.opos.cmn.an.f.a.b("AdHandler", sb.toString());
            a(5, cVar);
            return true;
        } catch (Exception e2) {
            e = e2;
            com.opos.cmn.an.f.a.a("AdHandler", "", (Throwable) e);
            return z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(AdItemData adItemData, MaterialData materialData, boolean z, int[] iArr, Map<String, String> map, com.opos.mobad.service.g.a aVar, b.InterfaceC0687b interfaceC0687b, com.opos.mobad.cmn.a.b bVar, c cVar) {
        if (adItemData == null || materialData == null) {
            return;
        }
        com.opos.cmn.an.f.a.b("AdHandler", "handleMiddlePageDLApkAndSTEvent");
        a(materialData.m(), adItemData, z, iArr, aVar, interfaceC0687b, bVar, cVar);
        HashMap hashMap = new HashMap();
        if (map != null && map.size() > 0) {
            hashMap.putAll(map);
        }
        if (!com.opos.cmn.an.c.a.a(materialData.t())) {
            hashMap.put("dlChannel", materialData.t());
        }
        com.opos.mobad.cmn.a.b.d.b(this.b, this.f25818c, adItemData, materialData, z, iArr, hashMap);
    }

    private void b(AdItemData adItemData, boolean z, int[] iArr, Map<String, String> map, com.opos.mobad.service.g.a aVar, boolean z2, b.InterfaceC0687b interfaceC0687b, com.opos.mobad.cmn.a.b bVar, c cVar) {
        MaterialData materialData;
        com.opos.cmn.an.f.a.b("AdHandler", "handleButtonAdClickActionAndSTEvent adItemData=", adItemData);
        if (adItemData == null || (materialData = adItemData.i().get(0)) == null) {
            return;
        }
        aVar.a(a.EnumC0736a.BUTTON).a(iArr);
        HashMap hashMap = new HashMap();
        if (map != null && !map.isEmpty()) {
            hashMap.putAll(map);
        }
        com.opos.mobad.cmn.a.b.d.a(hashMap, "1", String.valueOf(materialData.e()));
        a(materialData.e(), adItemData, materialData, z, iArr, hashMap, aVar, z2, interfaceC0687b, bVar, cVar);
    }

    private void b(String str, AdItemData adItemData, boolean z, int[] iArr, com.opos.mobad.service.g.a aVar, b.InterfaceC0687b interfaceC0687b, com.opos.mobad.cmn.a.b bVar, c cVar) {
        if (com.opos.cmn.an.c.a.a(str) || adItemData == null || adItemData.i() == null || adItemData.i().size() <= 0) {
            a(3, -1, cVar);
            return;
        }
        try {
            com.opos.cmn.an.f.a.b("AdHandler", "loadWebPage url=" + str);
            String a2 = -1 != com.opos.mobad.cmn.a.b.f.c(str) ? com.opos.mobad.cmn.a.b.f.a(adItemData, str, this.f25818c) : "";
            String a3 = com.opos.mobad.service.g.b.a(this.b, str, aVar);
            if (interfaceC0687b != null) {
                com.opos.mobad.cmn.a.b.f.a(interfaceC0687b);
            }
            if (bVar != null && adItemData.i().get(0).d() == 13) {
                this.d.a(this.b, this.f25818c, a3, adItemData, a2, bVar.f25832a, bVar.d);
            } else if (adItemData.R() == 1) {
                if (com.opos.mobad.o.e.b.a(adItemData.i().get(0).b())) {
                    a(8, cVar);
                    return;
                }
                this.d.a(this.b, this.f25818c, a3, adItemData, a2, (EventDescription) null);
                a(3, cVar);
                if (adItemData.V() == 2) {
                    com.opos.mobad.service.i.d.a().c().c(adItemData.i().get(0).aa(), 2);
                    return;
                }
                return;
            } else {
                this.d.a(this.b, this.f25818c, a3, adItemData, a2, (EventDescription) null);
            }
            a(3, cVar);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("AdHandler", "", (Throwable) e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(AdItemData adItemData, MaterialData materialData, boolean z, int[] iArr, Map<String, String> map, com.opos.mobad.service.g.a aVar, com.opos.mobad.cmn.a.b bVar, c cVar) {
        boolean z2 = false;
        boolean z3 = false;
        if (adItemData != null) {
            z3 = false;
            if (materialData != null) {
                z3 = false;
                try {
                    HashMap hashMap = new HashMap();
                    if (map != null && map.size() > 0) {
                        hashMap.putAll(map);
                    }
                    String k = materialData.k();
                    if (com.opos.cmn.an.c.a.a(k) || !this.d.a(this.b, k)) {
                        hashMap.put("jumpRet", "0");
                        aVar.a(a.b.APP_HOME).a("0");
                        StringBuilder sb = new StringBuilder();
                        sb.append("handleHomePageAndSTEvent pkgName=");
                        if (k == null) {
                            k = com.igexin.push.core.b.l;
                        }
                        sb.append(k);
                        sb.append(" fail.");
                        com.opos.cmn.an.f.a.b("AdHandler", sb.toString());
                        a(4, -1, cVar);
                    } else {
                        hashMap.put("jumpRet", "1");
                        aVar.a(a.b.APP_HOME).a("1");
                        try {
                            a(4, cVar);
                            com.opos.cmn.an.f.a.b("AdHandler", "handleHomePageAndSTEvent pkgName=" + k + " success.");
                            z2 = true;
                        } catch (Exception e) {
                            e = e;
                            z3 = true;
                            com.opos.cmn.an.f.a.a("AdHandler", "", (Throwable) e);
                            return z3;
                        }
                    }
                    boolean z4 = z2;
                    com.opos.mobad.cmn.a.b.d.a(this.b, adItemData, materialData, z, iArr, hashMap);
                    z3 = z2;
                    aVar.a(this.b);
                    return z2;
                } catch (Exception e2) {
                    e = e2;
                }
            }
        }
        return z3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(AdItemData adItemData, MaterialData materialData, boolean z, int[] iArr, Map<String, String> map, com.opos.mobad.service.g.a aVar, com.opos.mobad.cmn.a.b bVar, c cVar) {
        if (adItemData == null || materialData == null) {
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            if (map != null && map.size() > 0) {
                hashMap.putAll(map);
            }
            String m = materialData.m();
            if (com.opos.cmn.an.c.a.a(m) || !this.d.b(this.b, m)) {
                hashMap.put("jumpRet", "0");
                aVar.a(a.b.DEEP_LINK).a("0");
                StringBuilder sb = new StringBuilder();
                sb.append("handleDetailPageAndSTEvent targetUrl=");
                if (m == null) {
                    m = com.igexin.push.core.b.l;
                }
                sb.append(m);
                sb.append(" fail.");
                com.opos.cmn.an.f.a.b("AdHandler", sb.toString());
                a(5, -1, cVar);
            } else {
                aVar.a(a.b.DEEP_LINK).a("1");
                hashMap.put("jumpRet", "1");
                com.opos.cmn.an.f.a.b("AdHandler", "handleDetailPageAndSTEvent targetUrl=" + m + " success.");
                a(5, cVar);
            }
            com.opos.mobad.cmn.a.b.d.a(this.b, this.f25818c, adItemData, materialData, z, iArr, hashMap);
            aVar.a(this.b);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("AdHandler", "", (Throwable) e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final AdItemData adItemData, final MaterialData materialData, final boolean z, final int[] iArr, Map<String, String> map, final com.opos.mobad.service.g.a aVar, final b.InterfaceC0687b interfaceC0687b, final com.opos.mobad.cmn.a.b bVar, final c cVar) {
        if (adItemData == null || materialData == null) {
            return;
        }
        try {
            final HashMap hashMap = new HashMap();
            if (map != null && map.size() > 0) {
                hashMap.putAll(map);
            }
            if (!com.opos.cmn.an.c.a.a(materialData.s())) {
                this.d.a(this.b, adItemData.d(), adItemData.e(), materialData.s(), new d.a() { // from class: com.opos.mobad.cmn.a.a.3
                    @Override // com.opos.mobad.cmn.a.d.a
                    public void a() {
                        hashMap.put("jumpRet", "1");
                        com.opos.mobad.cmn.a.b.d.a(a.this.b, a.this.f25818c, adItemData, materialData, z, iArr, hashMap);
                        aVar.a(a.b.INSTANT).a("1");
                        aVar.a(a.this.b);
                        a.this.a(6, cVar);
                        com.opos.cmn.an.f.a.a("AdHandler", "handleInstantAndSTEvent open instant success.");
                    }

                    @Override // com.opos.mobad.cmn.a.d.a
                    public void a(int i, String str) {
                        a.this.a(materialData.m(), adItemData, z, iArr, aVar, interfaceC0687b, bVar, cVar);
                        Map map2 = hashMap;
                        map2.put("jumpRet", i + "");
                        com.opos.mobad.cmn.a.b.d.a(a.this.b, a.this.f25818c, adItemData, materialData, z, iArr, hashMap);
                        com.opos.cmn.an.f.a.a("AdHandler", "handleInstantAndSTEvent open instant fail.open web, code:" + i + ",msg:" + str);
                    }
                }, materialData.q());
                return;
            }
            a(materialData.m(), adItemData, z, iArr, aVar, interfaceC0687b, bVar, cVar);
            hashMap.put("jumpRet", "0");
            com.opos.mobad.cmn.a.b.d.a(this.b, this.f25818c, adItemData, materialData, z, iArr, hashMap);
            com.opos.cmn.an.f.a.b("AdHandler", "handleInstantAndSTEvent open instant fail.open web");
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("AdHandler", "", (Throwable) e);
        }
    }

    private void c(AdItemData adItemData, boolean z, int[] iArr, Map<String, String> map, com.opos.mobad.service.g.a aVar, boolean z2, b.InterfaceC0687b interfaceC0687b, com.opos.mobad.cmn.a.b bVar, c cVar) {
        MaterialData materialData;
        com.opos.cmn.an.f.a.b("AdHandler", "handleExtraAdClickActionAndStEvent adItemData=", adItemData);
        if (adItemData == null || (materialData = adItemData.i().get(0)) == null) {
            return;
        }
        aVar.a(a.EnumC0736a.EXTRA).a(iArr);
        HashMap hashMap = new HashMap();
        if (map != null && !map.isEmpty()) {
            hashMap.putAll(map);
        }
        com.opos.mobad.cmn.a.b.d.a(hashMap, "2", String.valueOf(materialData.J()));
        a(materialData.J(), adItemData, materialData, z, iArr, hashMap, aVar, z2, interfaceC0687b, bVar, cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(AdItemData adItemData, MaterialData materialData, boolean z, int[] iArr, Map<String, String> map, com.opos.mobad.service.g.a aVar, b.InterfaceC0687b interfaceC0687b, com.opos.mobad.cmn.a.b bVar, c cVar) {
        String str;
        if (adItemData == null || materialData == null) {
            return;
        }
        try {
            String s = materialData.s();
            if (com.opos.cmn.an.c.a.a(s) || !this.d.b(this.b, s)) {
                a(materialData.m(), adItemData, z, iArr, aVar, interfaceC0687b, bVar, cVar);
                com.opos.mobad.cmn.a.b.d.a(this.b, this.f25818c, adItemData, materialData, z, iArr, map);
                str = "handleDeepLinkAndSTEvent open deeplink fail.open web";
            } else {
                com.opos.mobad.cmn.a.b.d.c(this.b, this.f25818c, adItemData, materialData, z, iArr, map);
                aVar.a(a.b.DEEP_LINK).a("1");
                aVar.a(this.b);
                a(5, cVar);
                str = "handleDeepLinkAndSTEvent open deeplink success.extraUrl = " + s;
            }
            com.opos.cmn.an.f.a.b("AdHandler", str);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("AdHandler", "", (Throwable) e);
        }
    }

    private void d(AdItemData adItemData, boolean z, int[] iArr, Map<String, String> map, com.opos.mobad.service.g.a aVar, boolean z2, b.InterfaceC0687b interfaceC0687b, com.opos.mobad.cmn.a.b bVar, c cVar) {
        MaterialData materialData;
        com.opos.cmn.an.f.a.b("AdHandler", "handleVideoAdClickActionAndSTEvent adItemData=", adItemData);
        if (adItemData == null || (materialData = adItemData.i().get(0)) == null) {
            return;
        }
        aVar.a(a.EnumC0736a.VIDEO).a(iArr);
        HashMap hashMap = new HashMap();
        if (map != null && !map.isEmpty()) {
            hashMap.putAll(map);
        }
        com.opos.mobad.cmn.a.b.d.a(hashMap, "3", String.valueOf(materialData.K()));
        a(materialData.K(), adItemData, materialData, z, iArr, hashMap, aVar, z2, interfaceC0687b, bVar, cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(AdItemData adItemData, MaterialData materialData, boolean z, int[] iArr, Map<String, String> map, com.opos.mobad.service.g.a aVar, b.InterfaceC0687b interfaceC0687b, com.opos.mobad.cmn.a.b bVar, c cVar) {
        String str;
        if (adItemData == null || materialData == null) {
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            if (map != null && map.size() > 0) {
                hashMap.putAll(map);
            }
            if (TextUtils.isEmpty(adItemData.Z()) || TextUtils.isEmpty(materialData.ag())) {
                a(materialData.m(), adItemData, z, iArr, aVar, interfaceC0687b, bVar, cVar);
                hashMap.put("jumpRet", "0");
                com.opos.mobad.cmn.a.b.d.a(this.b, this.f25818c, adItemData, materialData, z, iArr, hashMap);
                com.opos.cmn.an.f.a.b("AdHandler", "handleMiniProgramAndSTEvent error param instant fail.open web");
                return;
            }
            if (this.d.a(this.b, adItemData.Z(), materialData.ag(), materialData.ah())) {
                hashMap.put("jumpRet", "1");
                com.opos.mobad.cmn.a.b.d.a(this.b, this.f25818c, adItemData, materialData, z, iArr, hashMap);
                aVar.a(a.b.MINI_PROGRAM).a("1");
                aVar.a(this.b);
                a(9, cVar);
                str = "handleMiniProgramAndSTEvent open success.";
            } else {
                a(materialData.m(), adItemData, z, iArr, aVar, interfaceC0687b, bVar, cVar);
                hashMap.put("jumpRet", "0");
                com.opos.mobad.cmn.a.b.d.a(this.b, this.f25818c, adItemData, materialData, z, iArr, hashMap);
                str = "handleMiniProgramAndSTEvent open fail.open web";
            }
            com.opos.cmn.an.f.a.a("AdHandler", str);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("AdHandler", "", (Throwable) e);
        }
    }

    private void e(AdItemData adItemData, boolean z, int[] iArr, Map<String, String> map, com.opos.mobad.service.g.a aVar, boolean z2, b.InterfaceC0687b interfaceC0687b, com.opos.mobad.cmn.a.b bVar, c cVar) {
        MaterialData materialData;
        com.opos.cmn.an.f.a.b("AdHandler", "handleFloatLayerAdClickActionAndStEvent adItemData=", adItemData);
        if (adItemData == null || (materialData = adItemData.i().get(0)) == null) {
            return;
        }
        aVar.a(a.EnumC0736a.FLOATLAYER_BUTTON).a(iArr);
        HashMap hashMap = new HashMap();
        if (map != null && !map.isEmpty()) {
            hashMap.putAll(map);
        }
        com.opos.mobad.cmn.a.b.d.a(hashMap, "4", String.valueOf(materialData.V()));
        a(materialData.V(), adItemData, materialData, z, iArr, hashMap, aVar, z2, interfaceC0687b, bVar, cVar);
    }

    private void f(AdItemData adItemData, boolean z, int[] iArr, Map<String, String> map, com.opos.mobad.service.g.a aVar, boolean z2, b.InterfaceC0687b interfaceC0687b, com.opos.mobad.cmn.a.b bVar, c cVar) {
        MaterialData materialData;
        com.opos.cmn.an.f.a.b("AdHandler", "handleFloatLayerExtraAdClickActionAndStEvent adItemData=", adItemData);
        if (adItemData == null || (materialData = adItemData.i().get(0)) == null) {
            return;
        }
        aVar.a(a.EnumC0736a.FLOATLAYER_EXTRA).a(iArr);
        HashMap hashMap = new HashMap();
        if (map != null && !map.isEmpty()) {
            hashMap.putAll(map);
        }
        com.opos.mobad.cmn.a.b.d.a(hashMap, "5", String.valueOf(materialData.W()));
        a(materialData.W(), adItemData, materialData, z, iArr, hashMap, aVar, z2, interfaceC0687b, bVar, cVar);
    }

    public void a() {
        this.e = null;
    }

    public void a(b bVar) {
        this.e = bVar;
    }

    public void a(AdItemData adItemData) {
        if (adItemData == null || adItemData.G() == null) {
            return;
        }
        ActivatingData G = adItemData.G();
        if (G == null || TextUtils.isEmpty(G.b) || TextUtils.isEmpty(G.f26456a)) {
            com.opos.mobad.cmn.a.b.d.a(this.b, this.f25818c, (String) null, 2);
        } else if (a(G)) {
            a(G.b, G.f26456a);
        }
    }

    public void a(AdItemData adItemData, boolean z, b.InterfaceC0687b interfaceC0687b, EventDescription eventDescription) {
        if (adItemData != null) {
            try {
                if (adItemData.i() == null || adItemData.i().size() <= 0) {
                    return;
                }
                a(adItemData.i().get(0).w(), adItemData, z, interfaceC0687b, eventDescription);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("AdHandler", "", (Throwable) e);
            }
        }
    }

    public void a(AdItemData adItemData, boolean z, int[] iArr, Map<String, String> map, com.opos.mobad.cmn.a.b.a aVar, View view, b.InterfaceC0687b interfaceC0687b, com.opos.mobad.cmn.a.b bVar) {
        a(adItemData, z, iArr, map, aVar, view, interfaceC0687b, bVar, (c) null);
    }

    public void a(final AdItemData adItemData, final boolean z, final int[] iArr, Map<String, String> map, final com.opos.mobad.cmn.a.b.a aVar, View view, final b.InterfaceC0687b interfaceC0687b, final com.opos.mobad.cmn.a.b bVar, final c cVar) {
        final HashMap hashMap = new HashMap();
        if (map != null && !map.isEmpty()) {
            hashMap.putAll(map);
        }
        com.opos.mobad.cmn.a.b.d.b(hashMap, o.a(this.b, view) ? "1" : "2");
        if (!com.opos.mobad.cmn.a.b.f.a(this.b, adItemData, aVar)) {
            a(adItemData, z, iArr, (Map<String, String>) hashMap, aVar, false, interfaceC0687b, bVar, cVar);
            return;
        }
        b bVar2 = this.e;
        if (bVar2 != null) {
            bVar2.a(new InterfaceC0679a() { // from class: com.opos.mobad.cmn.a.a.1
                @Override // com.opos.mobad.cmn.a.a.InterfaceC0679a
                public void a() {
                    com.opos.cmn.an.f.a.b("AdHandler", "download confirm");
                    com.opos.mobad.cmn.a.b.f.a(false);
                    a.this.a(adItemData, z, iArr, (Map<String, String>) hashMap, aVar, false, interfaceC0687b, bVar, cVar);
                }

                @Override // com.opos.mobad.cmn.a.a.InterfaceC0679a
                public void b() {
                    com.opos.cmn.an.f.a.b("AdHandler", "download cancel");
                    a.this.a(adItemData, z, iArr, (Map<String, String>) hashMap, aVar, true, interfaceC0687b, bVar, cVar);
                }
            });
        } else {
            a(adItemData, z, iArr, (Map<String, String>) hashMap, aVar, false, interfaceC0687b, bVar, cVar);
        }
    }

    public void b(AdItemData adItemData) {
        List<MaterialData> i;
        MaterialData materialData;
        if (adItemData == null || (i = adItemData.i()) == null || i.size() <= 0 || (materialData = i.get(0)) == null || materialData.e() != 6) {
            return;
        }
        this.d.a(this.b, adItemData.d(), adItemData.e(), materialData.s(), materialData.q());
    }
}
