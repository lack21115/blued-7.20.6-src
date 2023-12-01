package cn.com.chinatelecom.account.api.e;

import android.content.Context;
import cn.com.chinatelecom.account.api.Helper;

/* loaded from: source-8756600-dex2jar.jar:cn/com/chinatelecom/account/api/e/k.class */
public class k implements i {
    @Override // cn.com.chinatelecom.account.api.e.i
    public String a(Context context, long j, String str) {
        return Helper.dnprecobjs(context, j, str);
    }

    @Override // cn.com.chinatelecom.account.api.e.i
    public String a(Context context, String str, String str2, String str3, long j, boolean z, String str4) {
        return Helper.dnepah(context, str, str2, str3, j, false, z, str4);
    }

    @Override // cn.com.chinatelecom.account.api.e.i
    public String a(String str, String str2) {
        try {
            return new String(Helper.dnepmret(cn.com.chinatelecom.account.api.a.c.a(str), str2));
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    @Override // cn.com.chinatelecom.account.api.e.i
    public String a(boolean z) {
        return Helper.cepahsul(z);
    }
}
