package com.kwad.sdk.core.e;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.oaid.OADIDSDKHelper;
import com.kwad.sdk.oaid.OADIDSDKHelper25;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.kwai.f;
import com.kwad.sdk.utils.at;
import com.kwad.sdk.utils.aw;
import com.kwad.sdk.utils.g;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/e/a.class */
public final class a {
    private static String ahA = "";
    private static boolean ahB = false;
    private static boolean sGetOaidFail = false;

    public static String aR(Context context) {
        if (!at.Ec() || TextUtils.isEmpty(at.Ed())) {
            if (TextUtils.isEmpty(ahA)) {
                if (at.Ec() || ((f) ServiceProvider.get(f.class)).E(2048L)) {
                    return ahA;
                }
                initAsync(context);
                return ahA;
            }
            return ahA;
        }
        return at.Ed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:93:0x025a A[Catch: all -> 0x0263, TryCatch #0 {all -> 0x0263, blocks: (B:14:0x0025, B:16:0x002e, B:17:0x0032, B:19:0x00b5, B:23:0x00c2, B:27:0x00d1, B:31:0x00e0, B:35:0x00ef, B:39:0x00fe, B:43:0x010c, B:47:0x011b, B:51:0x0129, B:55:0x0138, B:59:0x0147, B:63:0x0155, B:67:0x0163, B:71:0x0171, B:75:0x0180, B:79:0x018f, B:81:0x019c, B:82:0x01a2, B:83:0x01b1, B:84:0x01c0, B:85:0x01cf, B:86:0x01de, B:87:0x01ed, B:88:0x01fc, B:89:0x020b, B:90:0x021a, B:91:0x0229, B:93:0x025a, B:95:0x025f), top: B:103:0x0025 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void aS(android.content.Context r4) {
        /*
            Method dump skipped, instructions count: 695
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.e.a.aS(android.content.Context):void");
    }

    public static void initAsync(final Context context) {
        if (!TextUtils.isEmpty(ahA) || context == null) {
            return;
        }
        g.execute(new aw() { // from class: com.kwad.sdk.core.e.a.1
            @Override // com.kwad.sdk.utils.aw
            public final void doTask() {
                a.aS(Context.this);
                if (OADIDSDKHelper.isSupport()) {
                    OADIDSDKHelper.getOAId(Context.this, new OADIDSDKHelper.a() { // from class: com.kwad.sdk.core.e.a.1.1
                        @Override // com.kwad.sdk.oaid.OADIDSDKHelper.a
                        public final void cw(String str) {
                            String unused = a.ahA = str;
                            a.mz();
                        }
                    });
                } else if (OADIDSDKHelper25.isSupport()) {
                    OADIDSDKHelper25.getOAId(Context.this, new OADIDSDKHelper25.a() { // from class: com.kwad.sdk.core.e.a.1.2
                        @Override // com.kwad.sdk.oaid.OADIDSDKHelper25.a
                        public final void cw(String str) {
                            String unused = a.ahA = str;
                            a.mz();
                        }
                    });
                }
            }
        });
    }

    static /* synthetic */ void mz() {
    }
}
