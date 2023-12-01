package com.kwad.sdk.utils;

import android.content.Context;
import android.location.Location;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.InstalledAppInfoManager;
import com.kwad.sdk.utils.bp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/utils/au.class */
public final class au {
    public static String aAm = "";

    public static com.kwad.sdk.h.kwai.b Ci() {
        return com.kwad.sdk.h.kwai.b.Ci();
    }

    public static com.kwad.sdk.h.kwai.f Cj() {
        return com.kwad.sdk.h.kwai.f.Cj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String Ei() {
        com.kwad.sdk.h.kwai.f Cj = com.kwad.sdk.h.kwai.f.Cj();
        int i = Cj != null ? Cj.axK : -1;
        if (i >= 0) {
            return com.kwad.sdk.d.b.a(false, String.valueOf(i), 0);
        }
        boolean sx = ((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).sx();
        String valueOf = String.valueOf(i);
        return !sx ? com.kwad.sdk.d.b.a(false, valueOf, 1) : com.kwad.sdk.d.b.a(false, valueOf, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String Ej() {
        com.kwad.sdk.h.kwai.b Ci = com.kwad.sdk.h.kwai.b.Ci();
        return Ci != null ? com.kwad.sdk.d.b.a(false, Ci.toJson(), 0) : !((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).sz() ? com.kwad.sdk.d.b.a(false, "", 1) : com.kwad.sdk.d.b.a(false, "", 2);
    }

    public static List<com.kwad.sdk.h.kwai.e> Ek() {
        return ax.Ek();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String El() {
        return com.kwad.sdk.d.b.a(false, "1", 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String Em() {
        return com.kwad.sdk.d.b.a(false, String.valueOf(getSdkVersion()), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String En() {
        return com.kwad.sdk.d.b.a(false, String.valueOf(getAppId()), 0);
    }

    static /* synthetic */ String bA(boolean z) {
        return bx(true);
    }

    static /* synthetic */ String bB(boolean z) {
        return Ei();
    }

    static /* synthetic */ String bC(boolean z) {
        return Ej();
    }

    static /* synthetic */ String bD(boolean z) {
        return by(true);
    }

    static /* synthetic */ String bE(boolean z) {
        return bz(true);
    }

    static /* synthetic */ String bF(boolean z) {
        return El();
    }

    static /* synthetic */ String bG(boolean z) {
        return Em();
    }

    static /* synthetic */ String bH(boolean z) {
        return En();
    }

    public static Location bL(Context context) {
        return r.bL(context);
    }

    private static String bx(boolean z) {
        String bI = bd.bI(z);
        if (!z) {
            return TextUtils.isEmpty(bI) ? "" : bI;
        }
        boolean z2 = true;
        if (TextUtils.isEmpty(bI)) {
            return (at.Ec() || ((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).E(2048L)) ? com.kwad.sdk.d.b.a(false, bI, 1) : com.kwad.sdk.d.b.a(false, bI, 5);
        }
        if (!at.Ec() || TextUtils.isEmpty(at.Ed())) {
            z2 = false;
        }
        return com.kwad.sdk.d.b.a(z2, bI, 0);
    }

    private static String by(boolean z) {
        if (!com.kwad.b.kwai.a.bI.booleanValue() || TextUtils.isEmpty(be.getDeviceId())) {
            String deviceId = bd.getDeviceId();
            if (!z) {
                return TextUtils.isEmpty(deviceId) ? "" : deviceId;
            }
            boolean z2 = true;
            if (TextUtils.isEmpty(deviceId)) {
                return (at.DW() || !o.CU()) ? com.kwad.sdk.d.b.a(false, deviceId, 1) : com.kwad.sdk.d.b.a(false, deviceId, 5);
            }
            if (!at.DW() || TextUtils.isEmpty(at.DZ())) {
                z2 = false;
            }
            return com.kwad.sdk.d.b.a(z2, deviceId, 0);
        }
        return be.getDeviceId();
    }

    private static String bz(boolean z) {
        String ES = bd.ES();
        return !z ? TextUtils.isEmpty(ES) ? "" : ES : !TextUtils.isEmpty(ES) ? com.kwad.sdk.d.b.a(at.Ee(), ES, 0) : (at.Ee() || ((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).E(8L)) ? com.kwad.sdk.d.b.a(false, ES, 1) : com.kwad.sdk.d.b.a(false, ES, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String c(Context context, boolean z) {
        String u = bd.u(context, z);
        if (!z) {
            return TextUtils.isEmpty(u) ? "" : u;
        }
        int i = 1;
        boolean z2 = true;
        if (!TextUtils.isEmpty(u)) {
            if (!at.DW() || TextUtils.isEmpty(at.DX())) {
                z2 = false;
            }
            return com.kwad.sdk.d.b.a(z2, u, 0);
        } else if (Build.VERSION.SDK_INT >= 29) {
            return com.kwad.sdk.d.b.a(false, u, 4);
        } else {
            if (at.DW() || !o.CZ()) {
                return com.kwad.sdk.d.b.a(false, u, 1);
            }
            if (SystemUtil.cO(context)) {
                i = 3;
            }
            return com.kwad.sdk.d.b.a(false, u, i);
        }
    }

    public static String cl(Context context) {
        return c(context, false);
    }

    public static String cm(Context context) {
        return d(context, false);
    }

    public static String cn(Context context) {
        return e(context, false);
    }

    public static String co(Context context) {
        return f(context, false);
    }

    public static String cp(Context context) {
        return g(context, false);
    }

    public static String cq(Context context) {
        return h(context, false);
    }

    public static String cr(Context context) {
        return i(context, false);
    }

    public static int cs(Context context) {
        return bd.cV(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String ct(Context context) {
        int cV = bd.cV(context);
        if (cV > 0) {
            return com.kwad.sdk.d.b.a(false, String.valueOf(cV), 0);
        }
        int i = Build.VERSION.SDK_INT;
        String valueOf = String.valueOf(cV);
        return i < 23 ? com.kwad.sdk.d.b.a(false, valueOf, 1) : com.kwad.sdk.d.b.a(false, valueOf, 3);
    }

    public static int cu(Context context) {
        return bd.cW(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String cv(Context context) {
        List<bp.a> m = m(context, 15);
        if (m == null || m.size() <= 0) {
            int i = 1;
            if (at.Ee() || ((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).E(32L)) {
                return com.kwad.sdk.d.b.a(false, "", 1);
            }
            if (!bp.dd(context)) {
                i = 3;
            }
            return com.kwad.sdk.d.b.a(false, "", i);
        }
        return com.kwad.sdk.d.b.a(at.Ee(), t.C(m), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String cw(Context context) {
        Map<String, InstalledAppInfoManager.AppPackageInfo> bM = InstalledAppInfoManager.bM(context);
        int i = 1;
        boolean z = true;
        if (bM.size() > 0) {
            if (!at.Eg() || at.Eh() == null) {
                z = false;
            }
            return com.kwad.sdk.d.b.a(z, InstalledAppInfoManager.e(bM), 0);
        } else if (at.Eg() || !o.CX()) {
            return com.kwad.sdk.d.b.a(false, "", 1);
        } else {
            if (bd.dc(context)) {
                i = 3;
            }
            return com.kwad.sdk.d.b.a(false, "", i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String cx(Context context) {
        Location bL = r.bL(context);
        int i = 1;
        boolean z = true;
        if (bL == null) {
            if (at.DU() || ((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).E(64L)) {
                return com.kwad.sdk.d.b.a(false, "", 1);
            }
            if (ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_FINE_LOCATION") == 0) {
                i = 3;
            }
            return com.kwad.sdk.d.b.a(false, "", i);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("latitude", String.valueOf(bL.getLatitude()));
        hashMap.put("longitude", String.valueOf(bL.getLongitude()));
        if (!at.DU() || at.DV() == null) {
            z = false;
        }
        return com.kwad.sdk.d.b.a(z, t.parseMap2JSON(hashMap), 0);
    }

    private static com.kwad.sdk.d.c cy(final Context context) {
        return new com.kwad.sdk.d.c() { // from class: com.kwad.sdk.utils.au.1
            @Override // com.kwad.sdk.d.a
            public final String Al() {
                com.kwad.sdk.core.d.b.d("SDKPrivateSafetyDataUtil", "getIMEI:" + au.c(Context.this, true));
                return au.c(Context.this, true);
            }

            @Override // com.kwad.sdk.d.a
            public final String Am() {
                com.kwad.sdk.core.d.b.d("SDKPrivateSafetyDataUtil", "getAndroidID:" + au.d(Context.this, true));
                return au.d(Context.this, true);
            }

            @Override // com.kwad.sdk.d.a
            public final String An() {
                com.kwad.sdk.core.d.b.d("SDKPrivateSafetyDataUtil", "getMac:" + au.e(Context.this, true));
                return au.e(Context.this, true);
            }

            @Override // com.kwad.sdk.d.a
            public final String Ao() {
                com.kwad.sdk.core.d.b.d("SDKPrivateSafetyDataUtil", "getIMEI2:" + au.f(Context.this, true));
                return au.f(Context.this, true);
            }

            @Override // com.kwad.sdk.d.a
            public final String Ap() {
                String g = au.g(Context.this, true);
                com.kwad.sdk.core.d.b.d("SDKPrivateSafetyDataUtil", "getIMEI2:" + g);
                return g;
            }

            @Override // com.kwad.sdk.d.a
            public final String Aq() {
                com.kwad.sdk.core.d.b.d("SDKPrivateSafetyDataUtil", "getIMSI:" + au.h(Context.this, true));
                return au.h(Context.this, true);
            }

            @Override // com.kwad.sdk.d.a
            public final String Ar() {
                com.kwad.sdk.core.d.b.d("SDKPrivateSafetyDataUtil", "getSimCardPhoneCount:" + au.ct(Context.this));
                return au.ct(Context.this);
            }

            /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
                jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: com.kwad.sdk.utils.au.bB(boolean):java.lang.String
                	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:76)
                	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:51)
                Caused by: java.lang.IndexOutOfBoundsException: Index: 0
                	at java.base/java.util.Collections$EmptyList.get(Collections.java:4483)
                	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:104)
                	at jadx.core.dex.visitors.MarkMethodsForInline.isSyntheticAccessPattern(MarkMethodsForInline.java:117)
                	at jadx.core.dex.visitors.MarkMethodsForInline.inlineMth(MarkMethodsForInline.java:86)
                	at jadx.core.dex.visitors.MarkMethodsForInline.process(MarkMethodsForInline.java:53)
                	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:65)
                	... 1 more
                */
            @Override // com.kwad.sdk.d.a
            public final java.lang.String As() {
                /*
                    r4 = this;
                    r0 = 1
                    java.lang.String r0 = com.kwad.sdk.utils.au.bB(r0)
                    r5 = r0
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    r1 = r0
                    java.lang.String r2 = "getSimCardActivePhoneCount:"
                    r1.<init>(r2)
                    r6 = r0
                    r0 = r6
                    r1 = r5
                    java.lang.StringBuilder r0 = r0.append(r1)
                    java.lang.String r0 = "SDKPrivateSafetyDataUtil"
                    r1 = r6
                    java.lang.String r1 = r1.toString()
                    com.kwad.sdk.core.d.b.d(r0, r1)
                    r0 = r5
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.utils.au.AnonymousClass1.As():java.lang.String");
            }

            /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
                jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: com.kwad.sdk.utils.au.bC(boolean):java.lang.String
                	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:76)
                	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:51)
                Caused by: java.lang.IndexOutOfBoundsException: Index: 0
                	at java.base/java.util.Collections$EmptyList.get(Collections.java:4483)
                	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:104)
                	at jadx.core.dex.visitors.MarkMethodsForInline.isSyntheticAccessPattern(MarkMethodsForInline.java:117)
                	at jadx.core.dex.visitors.MarkMethodsForInline.inlineMth(MarkMethodsForInline.java:86)
                	at jadx.core.dex.visitors.MarkMethodsForInline.process(MarkMethodsForInline.java:53)
                	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:65)
                	... 1 more
                */
            @Override // com.kwad.sdk.d.a
            public final java.lang.String At() {
                /*
                    r4 = this;
                    r0 = 1
                    java.lang.String r0 = com.kwad.sdk.utils.au.bC(r0)
                    r5 = r0
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    r1 = r0
                    java.lang.String r2 = "getBaseStationInfo:"
                    r1.<init>(r2)
                    r6 = r0
                    r0 = r6
                    r1 = r5
                    java.lang.StringBuilder r0 = r0.append(r1)
                    java.lang.String r0 = "SDKPrivateSafetyDataUtil"
                    r1 = r6
                    java.lang.String r1 = r1.toString()
                    com.kwad.sdk.core.d.b.d(r0, r1)
                    r0 = r5
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.utils.au.AnonymousClass1.At():java.lang.String");
            }

            @Override // com.kwad.sdk.d.a
            public final String Au() {
                String cv = au.cv(Context.this);
                com.kwad.sdk.core.d.b.d("SDKPrivateSafetyDataUtil", "getWifiList:" + cv);
                return cv;
            }

            @Override // com.kwad.sdk.d.a
            public final String Av() {
                String cw = au.cw(Context.this);
                com.kwad.sdk.core.d.b.d("SDKPrivateSafetyDataUtil", "getAppList:" + cw);
                return cw;
            }

            /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
                jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: com.kwad.sdk.utils.au.bF(boolean):java.lang.String
                	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:76)
                	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:51)
                Caused by: java.lang.IndexOutOfBoundsException: Index: 0
                	at java.base/java.util.Collections$EmptyList.get(Collections.java:4483)
                	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:104)
                	at jadx.core.dex.visitors.MarkMethodsForInline.isSyntheticAccessPattern(MarkMethodsForInline.java:117)
                	at jadx.core.dex.visitors.MarkMethodsForInline.inlineMth(MarkMethodsForInline.java:86)
                	at jadx.core.dex.visitors.MarkMethodsForInline.process(MarkMethodsForInline.java:53)
                	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:65)
                	... 1 more
                */
            @Override // com.kwad.sdk.d.a
            public final java.lang.String Aw() {
                /*
                    r4 = this;
                    r0 = 1
                    java.lang.String r0 = com.kwad.sdk.utils.au.bF(r0)
                    r5 = r0
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    r1 = r0
                    java.lang.String r2 = "getSdkType:"
                    r1.<init>(r2)
                    r6 = r0
                    r0 = r6
                    r1 = r5
                    java.lang.StringBuilder r0 = r0.append(r1)
                    java.lang.String r0 = "SDKPrivateSafetyDataUtil"
                    r1 = r6
                    java.lang.String r1 = r1.toString()
                    com.kwad.sdk.core.d.b.d(r0, r1)
                    r0 = r5
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.utils.au.AnonymousClass1.Aw():java.lang.String");
            }

            /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
                jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: com.kwad.sdk.utils.au.bH(boolean):java.lang.String
                	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:76)
                	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:51)
                Caused by: java.lang.IndexOutOfBoundsException: Index: 0
                	at java.base/java.util.Collections$EmptyList.get(Collections.java:4483)
                	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:104)
                	at jadx.core.dex.visitors.MarkMethodsForInline.isSyntheticAccessPattern(MarkMethodsForInline.java:117)
                	at jadx.core.dex.visitors.MarkMethodsForInline.inlineMth(MarkMethodsForInline.java:86)
                	at jadx.core.dex.visitors.MarkMethodsForInline.process(MarkMethodsForInline.java:53)
                	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:65)
                	... 1 more
                */
            @Override // com.kwad.sdk.d.a
            public final java.lang.String getAppId() {
                /*
                    r4 = this;
                    r0 = 1
                    java.lang.String r0 = com.kwad.sdk.utils.au.bH(r0)
                    r5 = r0
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    r1 = r0
                    java.lang.String r2 = "getAppId:"
                    r1.<init>(r2)
                    r6 = r0
                    r0 = r6
                    r1 = r5
                    java.lang.StringBuilder r0 = r0.append(r1)
                    java.lang.String r0 = "SDKPrivateSafetyDataUtil"
                    r1 = r6
                    java.lang.String r1 = r1.toString()
                    com.kwad.sdk.core.d.b.d(r0, r1)
                    r0 = r5
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.utils.au.AnonymousClass1.getAppId():java.lang.String");
            }

            @Override // com.kwad.sdk.d.a
            public final String getDeviceId() {
                String bD = au.bD(true);
                com.kwad.sdk.core.d.b.d("SDKPrivateSafetyDataUtil", "getDeviceId:" + bD);
                return bD;
            }

            @Override // com.kwad.sdk.d.a
            public final String getIccId() {
                com.kwad.sdk.core.d.b.d("SDKPrivateSafetyDataUtil", "getIccId:" + au.i(Context.this, true));
                return au.i(Context.this, true);
            }

            @Override // com.kwad.sdk.d.a
            public final String getIp() {
                String bE = au.bE(true);
                com.kwad.sdk.core.d.b.d("SDKPrivateSafetyDataUtil", "getIp:" + bE);
                return bE;
            }

            @Override // com.kwad.sdk.d.a
            public final String getLocation() {
                String cx = au.cx(Context.this);
                com.kwad.sdk.core.d.b.d("SDKPrivateSafetyDataUtil", "getLocation:" + cx);
                return cx;
            }

            @Override // com.kwad.sdk.d.a
            public final String getOaid() {
                com.kwad.sdk.core.d.b.d("SDKPrivateSafetyDataUtil", "getOaid:" + au.bA(true));
                return au.bA(true);
            }

            /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
                jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: com.kwad.sdk.utils.au.bG(boolean):java.lang.String
                	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:76)
                	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:51)
                Caused by: java.lang.IndexOutOfBoundsException: Index: 0
                	at java.base/java.util.Collections$EmptyList.get(Collections.java:4483)
                	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:104)
                	at jadx.core.dex.visitors.MarkMethodsForInline.isSyntheticAccessPattern(MarkMethodsForInline.java:117)
                	at jadx.core.dex.visitors.MarkMethodsForInline.inlineMth(MarkMethodsForInline.java:86)
                	at jadx.core.dex.visitors.MarkMethodsForInline.process(MarkMethodsForInline.java:53)
                	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:65)
                	... 1 more
                */
            @Override // com.kwad.sdk.d.a
            public final java.lang.String getSdkVersion() {
                /*
                    r4 = this;
                    r0 = 1
                    java.lang.String r0 = com.kwad.sdk.utils.au.bG(r0)
                    r5 = r0
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    r1 = r0
                    java.lang.String r2 = "getSdkVersion:"
                    r1.<init>(r2)
                    r6 = r0
                    r0 = r6
                    r1 = r5
                    java.lang.StringBuilder r0 = r0.append(r1)
                    java.lang.String r0 = "SDKPrivateSafetyDataUtil"
                    r1 = r6
                    java.lang.String r1 = r1.toString()
                    com.kwad.sdk.core.d.b.d(r0, r1)
                    r0 = r5
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.utils.au.AnonymousClass1.getSdkVersion():java.lang.String");
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String d(Context context, boolean z) {
        String cm = bd.cm(context);
        if (!z) {
            String str = cm;
            if (TextUtils.isEmpty(cm)) {
                str = "";
            }
            return str;
        }
        boolean z2 = true;
        if (TextUtils.isEmpty(cm)) {
            return (at.DW() || !o.CU()) ? com.kwad.sdk.d.b.a(false, cm, 1) : com.kwad.sdk.d.b.a(false, cm, 5);
        }
        if (!at.DW() || TextUtils.isEmpty(at.DZ())) {
            z2 = false;
        }
        return com.kwad.sdk.d.b.a(z2, cm, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String e(Context context, boolean z) {
        String da = bd.da(context);
        if (!z) {
            return TextUtils.isEmpty(da) ? "" : da;
        }
        int i = 1;
        boolean z2 = true;
        if (!TextUtils.isEmpty(da)) {
            if (!at.Ea() || TextUtils.isEmpty(at.Eb())) {
                z2 = false;
            }
            return com.kwad.sdk.d.b.a(z2, da.toLowerCase(), 0);
        } else if (at.Ea() || !o.CV()) {
            return com.kwad.sdk.d.b.a(false, da, 0);
        } else {
            if (al.al(context, "android.permission.ACCESS_WIFI_STATE") == 0) {
                i = 3;
            }
            return com.kwad.sdk.d.b.a(false, da, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String f(Context context, boolean z) {
        String[] cU = bd.cU(context);
        String str = (cU == null || cU.length <= 0) ? null : cU[0];
        if (!z) {
            return TextUtils.isEmpty(str) ? "" : str;
        }
        int i = 1;
        boolean z2 = true;
        if (!TextUtils.isEmpty(str)) {
            if (!at.DW() || TextUtils.isEmpty(at.DX())) {
                z2 = false;
            }
            return com.kwad.sdk.d.b.a(z2, str, 0);
        } else if (Build.VERSION.SDK_INT >= 29) {
            return com.kwad.sdk.d.b.a(false, str, 4);
        } else {
            if (at.DW() || !o.CZ()) {
                return com.kwad.sdk.d.b.a(false, str, 1);
            }
            if (SystemUtil.cO(context)) {
                i = 3;
            }
            return com.kwad.sdk.d.b.a(false, str, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String g(Context context, boolean z) {
        String[] cU = bd.cU(context);
        int i = 1;
        String str = (cU == null || cU.length <= 1) ? null : cU[1];
        if (!z) {
            return TextUtils.isEmpty(str) ? "" : str;
        } else if (!TextUtils.isEmpty(str)) {
            return com.kwad.sdk.d.b.a(at.DW() && !TextUtils.isEmpty(at.DX()), str, 0);
        } else if (Build.VERSION.SDK_INT >= 29) {
            return com.kwad.sdk.d.b.a(false, str, 4);
        } else {
            if (at.DW() || !o.CZ()) {
                return com.kwad.sdk.d.b.a(false, str, 1);
            }
            if (SystemUtil.cO(context)) {
                i = 3;
            }
            return com.kwad.sdk.d.b.a(false, str, i);
        }
    }

    private static String getAppId() {
        return ((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).getAppId();
    }

    public static String getDeviceId() {
        return by(false);
    }

    public static String getOaid() {
        return bx(false);
    }

    private static String getSdkVersion() {
        return "3.3.40";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String h(Context context, boolean z) {
        String cq = bd.cq(context);
        if (!z) {
            return TextUtils.isEmpty(cq) ? "" : cq;
        } else if (TextUtils.isEmpty(cq)) {
            if (Build.VERSION.SDK_INT >= 29) {
                return com.kwad.sdk.d.b.a(false, cq, 4);
            }
            int i = 1;
            if (at.DW() || !o.Da()) {
                return com.kwad.sdk.d.b.a(false, cq, 1);
            }
            if (SystemUtil.cO(context)) {
                i = 3;
            }
            return com.kwad.sdk.d.b.a(false, cq, i);
        } else {
            return com.kwad.sdk.d.b.a(at.DW(), cq, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String i(Context context, boolean z) {
        String cX = bd.cX(context);
        if (!z) {
            return TextUtils.isEmpty(cX) ? "" : cX;
        } else if (TextUtils.isEmpty(cX)) {
            int i = 1;
            if (at.DW() || !o.Db()) {
                return com.kwad.sdk.d.b.a(false, cX, 1);
            }
            if (SystemUtil.cO(context)) {
                i = 3;
            }
            return com.kwad.sdk.d.b.a(false, cX, i);
        } else {
            return com.kwad.sdk.d.b.a(at.DW(), cX, 0);
        }
    }

    public static void init(Context context) {
        com.kwad.sdk.d.b.a(cy(context));
    }

    public static List<bp.a> m(Context context, int i) {
        return bp.m(context, 15);
    }
}
