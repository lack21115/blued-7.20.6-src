package com.yxcorp.kuaishou.addfp;

import android.content.Context;
import android.os.Build;
import com.yxcorp.kuaishou.addfp.android.a.c;
import com.yxcorp.kuaishou.addfp.android.b.f;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/yxcorp/kuaishou/addfp/a.class */
public class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ KWEGIDDFP f41849a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(KWEGIDDFP kwegiddfp) {
        this.f41849a = kwegiddfp;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        Context context2;
        String str;
        ResponseDfpCallback responseDfpCallback;
        ResponseDfpCallback responseDfpCallback2;
        Context unused;
        try {
            context = this.f41849a.mParamContext;
            if (context == null) {
                responseDfpCallback2 = this.f41849a.mCallBack;
                responseDfpCallback2.onFailed(-3, "parameter error");
                return;
            }
            unused = this.f41849a.mParamContext;
            int i = f.f41861c;
            if (Build.VERSION.SDK_INT >= 28) {
                f.a();
            }
            KWEGIDDFP kwegiddfp = this.f41849a;
            context2 = kwegiddfp.mParamContext;
            kwegiddfp.mPkgName = context2.getPackageName();
            c c2 = c.c();
            str = this.f41849a.mPkgName;
            c2.b(str);
            KWEGIDDFP kwegiddfp2 = this.f41849a;
            responseDfpCallback = kwegiddfp2.mCallBack;
            kwegiddfp2.getEGid(responseDfpCallback);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
