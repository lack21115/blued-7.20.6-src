package com.huawei.agconnect.config.impl;

import android.content.Context;
import android.util.Log;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/agconnect/config/impl/k.class */
class k extends j {

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, String> f8731a;
    private final Object b;

    /* renamed from: c  reason: collision with root package name */
    private g f8732c;
    private boolean d;
    private final String e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(Context context, String str) {
        super(context, str);
        this.f8731a = new HashMap();
        this.b = new Object();
        this.d = true;
        this.e = str;
        try {
            String a2 = a("/AD91D45E3E72DB6989DDCB13287E75061FABCB933D886E6C6ABEF0939B577138");
            String a3 = a("/B314B3BF013DF5AC4134E880AF3D2B7C9FFBE8F0305EAC1C898145E2BCF1F21C");
            String a4 = a("/C767BD8FDF53E53D059BE95B09E2A71056F5F180AECC62836B287ACA5793421B");
            String a5 = a("/DCB3E6D4C2CF80F30D89CDBC412C964DA8381BB84668769391FBCC3E329AD0FD");
            if (a2 == null || a3 == null || a4 == null || a5 == null) {
                this.d = false;
            } else {
                this.f8732c = new f(a2, a3, a4, a5);
            }
        } catch (IllegalArgumentException | NoSuchAlgorithmException | InvalidKeySpecException e) {
            Log.e("SecurityResourcesReader", "Exception when reading the 'K&I' for 'Config'.");
            this.f8732c = null;
        }
    }

    private String a(String str) {
        return super.a(str, null);
    }

    @Override // com.huawei.agconnect.config.impl.j, com.huawei.agconnect.config.impl.d
    public String a(String str, String str2) {
        if (!this.d) {
            String a2 = a(str);
            if (a2 != null) {
                str2 = a2;
            }
            return str2;
        } else if (this.f8732c == null) {
            Log.e("SecurityResourcesReader", "KEY is null return def directly");
            return str2;
        } else {
            synchronized (this.b) {
                String str3 = this.f8731a.get(str);
                if (str3 != null) {
                    return str3;
                }
                String a3 = a(str);
                if (a3 == null) {
                    return str2;
                }
                String a4 = this.f8732c.a(a3, str2);
                this.f8731a.put(str, a4);
                return a4;
            }
        }
    }

    public String toString() {
        return "SecurityResourcesReader{mKey=, encrypt=" + this.d + '}';
    }
}
