package com.opos.mobad.model.a.a;

import android.content.Context;
import android.content.pm.Signature;
import com.opos.cmn.i.k;
import com.opos.mobad.b.a.ad;
import com.opos.mobad.b.a.e;
import com.opos.mobad.b.a.z;
import com.opos.mobad.model.b.d;
import com.tencent.qcloud.core.auth.AuthConstants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/model/a/a/b.class */
public class b implements com.opos.mobad.model.a.b {

    /* renamed from: a  reason: collision with root package name */
    private List<e> f12688a;
    private Context b;

    public b(Context context) {
        if (context == null) {
            return;
        }
        this.b = context.getApplicationContext();
        if (com.opos.mobad.cmn.a.f12128a.booleanValue()) {
            com.opos.cmn.an.i.e.a(new Runnable() { // from class: com.opos.mobad.model.a.a.b.1
                @Override // java.lang.Runnable
                public void run() {
                    b bVar = b.this;
                    bVar.f12688a = bVar.a(bVar.b);
                }
            });
        }
    }

    private z.b a(int i) {
        z.b bVar = z.b.UNKNOWN;
        switch (i) {
            case 1:
                return z.b.BANNER;
            case 2:
                return z.b.POP_WINDOW;
            case 3:
            case 6:
                return z.b.SPLASH_SCREEN;
            case 4:
                return z.b.RAW;
            case 5:
                return z.b.REWARD_VIDEO;
            default:
                return bVar;
        }
    }

    private List<e> a() {
        List<e> list = this.f12688a;
        if (list == null || list.size() <= 0) {
            this.f12688a = a(this.b);
        }
        return this.f12688a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<e> a(Context context) {
        ArrayList arrayList;
        Signature[] a2;
        String str;
        if (context != null && (a2 = k.a(context)) != null && a2.length > 0) {
            ArrayList arrayList2 = new ArrayList(a2.length);
            int length = a2.length;
            int i = 0;
            while (true) {
                int i2 = i;
                arrayList = arrayList2;
                if (i2 >= length) {
                    break;
                }
                try {
                    str = k.a(AuthConstants.SHA1, a2[i2]);
                } catch (Exception e) {
                    str = "";
                }
                com.opos.cmn.an.f.a.a("", "md5Sign=,sha1Sign=" + str + ",sha256Sign=");
                arrayList2.add(new e("", str, ""));
                i = i2 + 1;
            }
        } else {
            arrayList = null;
        }
        return arrayList;
    }

    private ad b(int i) {
        return i == 3 ? ad.SPLASH : i == 6 ? ad.HOT_SPLASH : ad.UNKNOWN;
    }

    @Override // com.opos.mobad.model.a.b
    public d a(byte[] bArr) throws IOException {
        com.opos.mobad.b.a.d a2 = com.opos.mobad.b.a.d.f12034c.a(bArr);
        if (a2 != null) {
            com.opos.cmn.an.f.a.a("", "parseResponse = ", a2);
            return new d(a2);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00d2  */
    @Override // com.opos.mobad.model.a.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public byte[] a(com.opos.mobad.model.b.c r7) {
        /*
            Method dump skipped, instructions count: 366
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.model.a.a.b.a(com.opos.mobad.model.b.c):byte[]");
    }
}
