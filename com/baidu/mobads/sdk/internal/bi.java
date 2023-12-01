package com.baidu.mobads.sdk.internal;

import android.text.TextUtils;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.internal.bf;
import java.util.HashMap;

/* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/internal/bi.class */
class bi implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ IOAdEvent f6500a;
    final /* synthetic */ bf.a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(bf.a aVar, IOAdEvent iOAdEvent) {
        this.b = aVar;
        this.f6500a = iOAdEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        IOAdEvent iOAdEvent = this.f6500a;
        if (iOAdEvent == null || TextUtils.isEmpty(iOAdEvent.getType())) {
            return;
        }
        String type = this.f6500a.getType();
        if (w.J.equals(type)) {
            bf.this.a(this.f6500a);
        } else if (w.M.equals(type)) {
            bf.this.n = this.f6500a.getMessage();
            bf.this.q();
        } else if (w.N.equals(type)) {
            bf.this.e(this.f6500a);
        } else if (w.O.equals(type)) {
            bf.this.f(this.f6500a);
        } else if (w.W.equals(type)) {
            bf.this.g(this.f6500a);
        } else {
            String str = "";
            boolean z = false;
            int i = 0;
            if (w.r.equals(type)) {
                HashMap hashMap = (HashMap) this.f6500a.getData();
                if (hashMap != null) {
                    String str2 = (String) hashMap.get("error_message");
                    Object obj = hashMap.get("error_code");
                    Integer num = obj;
                    if (obj == null) {
                        num = 0;
                    }
                    i = ((Integer) num).intValue();
                    str = str2;
                }
                bf.this.b(str, i);
            } else if (w.L.equals(type)) {
                HashMap hashMap2 = (HashMap) this.f6500a.getData();
                int i2 = 0;
                if (hashMap2 != null) {
                    String str3 = (String) hashMap2.get("error_message");
                    Object obj2 = hashMap2.get("error_code");
                    Integer num2 = obj2;
                    if (obj2 == null) {
                        num2 = 0;
                    }
                    i2 = ((Integer) num2).intValue();
                    str = str3;
                }
                bf.this.a(i2, str);
            } else if (w.H.equals(type)) {
                bf.this.h(this.f6500a);
            } else if (w.X.equals(type)) {
                bf.this.d();
            } else if (w.Y.equals(type)) {
                bf.this.d(this.f6500a);
            } else if (w.aa.equals(type)) {
                bf.this.s();
            } else if (w.ab.equals(type)) {
                IOAdEvent iOAdEvent2 = this.f6500a;
                boolean z2 = false;
                if (iOAdEvent2 != null) {
                    HashMap hashMap3 = (HashMap) iOAdEvent2.getData();
                    z2 = false;
                    if (hashMap3 != null) {
                        z2 = "1".equals((String) hashMap3.get("serverVerify"));
                    }
                }
                bf.this.b(z2);
            } else if (w.ac.equals(type)) {
                bf.this.b_();
            } else if (w.ad.equals(type)) {
                bf.this.c_();
            } else if (w.K.equals(type)) {
                bf.this.b(this.f6500a);
            } else if (w.ae.equals(type)) {
                bf bfVar = bf.this;
                String message = this.f6500a.getMessage();
                if (1 == this.f6500a.getCode()) {
                    z = true;
                }
                bfVar.a(message, z);
            } else if (w.af.equals(type)) {
                bf.this.e(this.f6500a.getMessage());
            } else if (w.ag.equals(type)) {
                bf.this.d(this.f6500a.getMessage());
            } else if (w.D.equals(type)) {
                bf.this.f(this.f6500a.getMessage());
            } else if (w.Z.equals(type)) {
                bf.this.t();
            } else if (w.ah.equals(type)) {
                bf bfVar2 = bf.this;
                String message2 = this.f6500a.getMessage();
                boolean z3 = false;
                if (1 == this.f6500a.getCode()) {
                    z3 = true;
                }
                bfVar2.b(message2, z3);
            } else if (w.aj.equals(type)) {
                bf.this.c(this.f6500a);
            } else if (w.ai.equals(type)) {
                bf.this.u();
            } else if (w.al.equals(type)) {
                bf.this.i(this.f6500a);
            } else if (w.am.equals(type)) {
                bf.this.j(this.f6500a);
            } else if (w.ak.equals(type)) {
                bf.this.k(this.f6500a);
            }
        }
    }
}
