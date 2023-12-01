package com.kwad.sdk.d;

import android.accounts.AccountManager;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/d/b.class */
public class b implements a {
    private static volatile b ati;
    private static c atj;

    private b() {
    }

    public static b Ax() {
        b bVar;
        synchronized (b.class) {
            try {
                if (ati == null) {
                    synchronized (b.class) {
                        if (ati == null) {
                            ati = new b();
                        }
                    }
                }
                bVar = ati;
            } catch (Throwable th) {
                throw th;
            }
        }
        return bVar;
    }

    private static String Ay() {
        return a(false, "", 2);
    }

    public static String a(boolean z, Object obj, int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("userSet", String.valueOf(z));
        hashMap.put("value", obj);
        hashMap.put(AccountManager.KEY_ERROR_CODE, String.valueOf(i));
        return new JSONObject(hashMap).toString();
    }

    public static void a(c cVar) {
        atj = cVar;
    }

    @Override // com.kwad.sdk.d.a
    public final String Al() {
        c cVar = atj;
        return cVar != null ? cVar.Al() : Ay();
    }

    @Override // com.kwad.sdk.d.a
    public final String Am() {
        c cVar = atj;
        return cVar != null ? cVar.Am() : Ay();
    }

    @Override // com.kwad.sdk.d.a
    public final String An() {
        c cVar = atj;
        return cVar != null ? cVar.An() : Ay();
    }

    @Override // com.kwad.sdk.d.a
    public final String Ao() {
        c cVar = atj;
        return cVar != null ? cVar.Ao() : Ay();
    }

    @Override // com.kwad.sdk.d.a
    public final String Ap() {
        c cVar = atj;
        return cVar != null ? cVar.Ap() : Ay();
    }

    @Override // com.kwad.sdk.d.a
    public final String Aq() {
        c cVar = atj;
        return cVar != null ? cVar.Aq() : Ay();
    }

    @Override // com.kwad.sdk.d.a
    public final String Ar() {
        c cVar = atj;
        return cVar != null ? cVar.Ar() : Ay();
    }

    @Override // com.kwad.sdk.d.a
    public final String As() {
        c cVar = atj;
        return cVar != null ? cVar.As() : Ay();
    }

    @Override // com.kwad.sdk.d.a
    public final String At() {
        c cVar = atj;
        return cVar != null ? cVar.At() : Ay();
    }

    @Override // com.kwad.sdk.d.a
    public final String Au() {
        c cVar = atj;
        return cVar != null ? cVar.Au() : Ay();
    }

    @Override // com.kwad.sdk.d.a
    public final String Av() {
        c cVar = atj;
        return cVar != null ? cVar.Av() : Ay();
    }

    @Override // com.kwad.sdk.d.a
    public final String Aw() {
        c cVar = atj;
        return cVar != null ? cVar.Aw() : Ay();
    }

    @Override // com.kwad.sdk.d.a
    public final String getAppId() {
        c cVar = atj;
        return cVar != null ? cVar.getAppId() : Ay();
    }

    @Override // com.kwad.sdk.d.a
    public final String getDeviceId() {
        c cVar = atj;
        return cVar != null ? cVar.getDeviceId() : Ay();
    }

    @Override // com.kwad.sdk.d.a
    public final String getIccId() {
        c cVar = atj;
        return cVar != null ? cVar.getIccId() : Ay();
    }

    @Override // com.kwad.sdk.d.a
    public final String getIp() {
        c cVar = atj;
        return cVar != null ? cVar.getIp() : Ay();
    }

    @Override // com.kwad.sdk.d.a
    public final String getLocation() {
        c cVar = atj;
        return cVar != null ? cVar.getLocation() : Ay();
    }

    @Override // com.kwad.sdk.d.a
    public final String getOaid() {
        c cVar = atj;
        return cVar != null ? cVar.getOaid() : Ay();
    }

    @Override // com.kwad.sdk.d.a
    public final String getSdkVersion() {
        c cVar = atj;
        return cVar != null ? cVar.getSdkVersion() : Ay();
    }
}
