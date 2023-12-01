package com.tencent.tmsqmsp.oaid2;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.tmsqmsp.oaid2.j;
import java.security.MessageDigest;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsqmsp/oaid2/l.class */
public class l implements b {

    /* renamed from: a  reason: collision with root package name */
    public Context f39646a;
    public IVendorCallback b;

    /* renamed from: c  reason: collision with root package name */
    public String f39647c = null;
    public boolean d = false;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsqmsp/oaid2/l$a.class */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                j.a a2 = j.a(l.this.f39646a);
                l.this.f39647c = a2.a();
                a2.b();
                if (!TextUtils.isEmpty(l.this.f39647c)) {
                    l.this.d = true;
                }
                if (l.this.b != null) {
                    IVendorCallback iVendorCallback = l.this.b;
                    boolean z = l.this.d;
                    l lVar = l.this;
                    iVendorCallback.onResult(z, lVar.a(e.a(lVar.f39646a)), l.this.f39647c);
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (TextUtils.isEmpty(l.this.f39647c)) {
                    l.this.d = false;
                }
                if (l.this.b != null) {
                    IVendorCallback iVendorCallback2 = l.this.b;
                    boolean z2 = l.this.d;
                    l lVar2 = l.this;
                    iVendorCallback2.onResult(z2, lVar2.a(e.a(lVar2.f39646a)), l.this.f39647c);
                }
            }
        }
    }

    @Override // com.tencent.tmsqmsp.oaid2.b
    public String a() {
        return this.f39647c;
    }

    public final String a(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            return b("0x1008611" + str + "0xdzfdweiwu");
        } catch (Exception e) {
            return "";
        }
    }

    @Override // com.tencent.tmsqmsp.oaid2.b
    public void a(Context context, IVendorCallback iVendorCallback) {
        this.f39646a = context;
        this.b = iVendorCallback;
    }

    public final String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            byte[] digest = MessageDigest.getInstance("MD5").digest(str.getBytes());
            String str2 = "";
            for (byte b : digest) {
                String hexString = Integer.toHexString(b & 255);
                String str3 = hexString;
                if (hexString.length() == 1) {
                    str3 = "0" + hexString;
                }
                str2 = str2 + str3;
            }
            return str2;
        } catch (Exception e) {
            return "";
        }
    }

    @Override // com.tencent.tmsqmsp.oaid2.b
    public String d() {
        return a(e.a(this.f39646a));
    }

    @Override // com.tencent.tmsqmsp.oaid2.b
    public boolean e() {
        return false;
    }

    @Override // com.tencent.tmsqmsp.oaid2.b
    public void j() {
        new Thread(new a()).start();
    }

    @Override // com.tencent.tmsqmsp.oaid2.b
    public boolean k() {
        return false;
    }

    @Override // com.tencent.tmsqmsp.oaid2.b
    public void l() {
    }
}
