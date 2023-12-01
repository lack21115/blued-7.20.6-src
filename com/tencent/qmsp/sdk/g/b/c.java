package com.tencent.qmsp.sdk.g.b;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.qmsp.sdk.base.IVendorCallback;
import com.tencent.qmsp.sdk.base.f;
import com.tencent.qmsp.sdk.g.b.a;
import java.security.MessageDigest;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qmsp/sdk/g/b/c.class */
public class c implements com.tencent.qmsp.sdk.base.b {

    /* renamed from: a  reason: collision with root package name */
    private Context f24925a;
    private IVendorCallback b;

    /* renamed from: c  reason: collision with root package name */
    private String f24926c = null;
    private boolean d = false;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/qmsp/sdk/g/b/c$a.class */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                a.C0823a a2 = com.tencent.qmsp.sdk.g.b.a.a(c.this.f24925a);
                c.this.f24926c = a2.a();
                a2.b();
                if (!TextUtils.isEmpty(c.this.f24926c)) {
                    c.this.d = true;
                }
                if (c.this.b != null) {
                    c.this.b.onResult(c.this.d, c.this.a(f.a(c.this.f24925a)), c.this.f24926c);
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (TextUtils.isEmpty(c.this.f24926c)) {
                    c.this.d = false;
                }
                if (c.this.b != null) {
                    IVendorCallback iVendorCallback = c.this.b;
                    boolean z = c.this.d;
                    c cVar = c.this;
                    iVendorCallback.onResult(z, cVar.a(f.a(cVar.f24925a)), c.this.f24926c);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            sb.append("0x1008611");
            sb.append(str);
            sb.append("0xdzfdweiwu");
            return b(sb.toString());
        } catch (Exception e) {
            return "";
        }
    }

    private String b(String str) {
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
                    StringBuilder sb = new StringBuilder();
                    sb.append("0");
                    sb.append(hexString);
                    str3 = sb.toString();
                }
                str2 = str2 + str3;
            }
            return str2;
        } catch (Exception e) {
            return "";
        }
    }

    @Override // com.tencent.qmsp.sdk.base.b
    public String a() {
        return this.f24926c;
    }

    @Override // com.tencent.qmsp.sdk.base.b
    public void a(Context context, IVendorCallback iVendorCallback) {
        this.f24925a = context;
        this.b = iVendorCallback;
    }

    @Override // com.tencent.qmsp.sdk.base.b
    public String b() {
        return a(f.a(this.f24925a));
    }

    @Override // com.tencent.qmsp.sdk.base.b
    public void c() {
        new Thread(new a()).start();
    }

    @Override // com.tencent.qmsp.sdk.base.b
    public boolean d() {
        return false;
    }

    @Override // com.tencent.qmsp.sdk.base.b
    public boolean e() {
        return false;
    }

    @Override // com.tencent.qmsp.sdk.base.b
    public void f() {
    }
}
