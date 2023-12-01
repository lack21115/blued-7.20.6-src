package com.sdk.tencent.mobile.manager.oauth.cucc;

import android.content.Context;
import com.sdk.tencent.a.d;
import com.sdk.tencent.base.api.CallBack;
import com.sdk.tencent.base.framework.bean.DataInfo;
import com.sdk.tencent.base.module.manager.SDKManager;
import com.sdk.tencent.n.b;
import com.sdk.tencent.v.a;
import com.sdk.tencent.v.c;

/* loaded from: source-8303388-dex2jar.jar:com/sdk/tencent/mobile/manager/oauth/cucc/OauthManager.class */
public class OauthManager extends SDKManager {
    private static volatile OauthManager manager;
    private Context mContext;

    private OauthManager(Context context) {
        this.mContext = context;
    }

    public static OauthManager getInstance(Context context) {
        if (manager == null) {
            synchronized (OauthManager.class) {
                try {
                    if (manager == null) {
                        manager = new OauthManager(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return manager;
    }

    public <T> void getAuthoriseCode(int i, CallBack<T> callBack) {
        new a(this.mContext, i, callBack).a(1);
    }

    public <T> void getMobileForCode(String str, int i, CallBack<T> callBack) {
        DataInfo dataInfo;
        String str2;
        com.sdk.tencent.g.a aVar;
        d.b bVar;
        String str3;
        if (b.a(str).booleanValue()) {
            SDKManager.toFailed(callBack, 101001, "授权码不能为空");
            return;
        }
        a aVar2 = new a(this.mContext, i, callBack);
        Context context = aVar2.b;
        b.b(com.sdk.tencent.b.a.f14328a, "cache clear", com.sdk.tencent.b.a.b);
        com.sdk.tencent.j.a.a(context, "accessCode");
        com.sdk.tencent.x.a aVar3 = new com.sdk.tencent.x.a(aVar2.b, new c(aVar2));
        if (b.a(null).booleanValue()) {
            dataInfo = new DataInfo();
            dataInfo.putData("accessCode", str);
            str2 = aVar3.g;
            aVar = new com.sdk.tencent.g.a(aVar3);
            bVar = d.b.POST;
            str3 = "/api/netm/v1.0/qhbt";
        } else {
            dataInfo = new DataInfo();
            dataInfo.putData("accessCode", str);
            dataInfo.putData("mobile", null);
            str2 = aVar3.g;
            aVar = new com.sdk.tencent.g.a(aVar3);
            bVar = d.b.POST;
            str3 = "/api/netm/v1.0/qhbv";
        }
        aVar2.d = aVar3.a(str2, str3, dataInfo, aVar, 0, bVar);
    }

    public <T> void getMobileForCode(String str, String str2, int i, CallBack<T> callBack) {
        DataInfo dataInfo;
        String str3;
        com.sdk.tencent.g.a aVar;
        d.b bVar;
        String str4;
        int i2;
        String str5;
        if (b.a(str).booleanValue()) {
            i2 = 101001;
            str5 = "授权码不能为空";
        } else if (!b.a(str2).booleanValue()) {
            a aVar2 = new a(this.mContext, i, callBack);
            Context context = aVar2.b;
            b.b(com.sdk.tencent.b.a.f14328a, "oauth cache clear", com.sdk.tencent.b.a.b);
            com.sdk.tencent.j.a.a(context, "accessCode1");
            com.sdk.tencent.x.a aVar3 = new com.sdk.tencent.x.a(aVar2.b, new com.sdk.tencent.v.b(aVar2));
            if (b.a(str2).booleanValue()) {
                dataInfo = new DataInfo();
                dataInfo.putData("accessCode", str);
                str3 = aVar3.g;
                aVar = new com.sdk.tencent.g.a(aVar3);
                bVar = d.b.POST;
                str4 = "/api/netm/v1.0/qhbt";
            } else {
                dataInfo = new DataInfo();
                dataInfo.putData("accessCode", str);
                dataInfo.putData("mobile", str2);
                str3 = aVar3.g;
                aVar = new com.sdk.tencent.g.a(aVar3);
                bVar = d.b.POST;
                str4 = "/api/netm/v1.0/qhbv";
            }
            aVar2.d = aVar3.a(str3, str4, dataInfo, aVar, 0, bVar);
            return;
        } else {
            i2 = 101002;
            str5 = "认证的手机号不能为空";
        }
        SDKManager.toFailed(callBack, i2, str5);
    }
}
