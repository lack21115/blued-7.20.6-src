package com.tencent.smtt.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.tbs.video.interfaces.IUserStateChangedListener;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/sdk/r.class */
class r {
    private static r e;

    /* renamed from: a  reason: collision with root package name */
    t f25185a;
    Context b;

    /* renamed from: c  reason: collision with root package name */
    com.tencent.tbs.video.interfaces.a f25186c;
    IUserStateChangedListener d;

    private r(Context context) {
        this.f25185a = null;
        this.b = context.getApplicationContext();
        this.f25185a = new t(this.b);
    }

    public static r a(Context context) {
        r rVar;
        synchronized (r.class) {
            try {
                if (e == null) {
                    e = new r(context);
                }
                rVar = e;
            } catch (Throwable th) {
                throw th;
            }
        }
        return rVar;
    }

    public void a(int i, int i2, Intent intent) {
        com.tencent.tbs.video.interfaces.a aVar = this.f25186c;
        if (aVar != null) {
            aVar.a(i, i2, intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Activity activity, int i) {
        this.f25185a.a(activity, i);
    }

    public boolean a() {
        this.f25185a.a();
        return this.f25185a.b();
    }

    public boolean a(String str, Bundle bundle, com.tencent.tbs.video.interfaces.a aVar) {
        Bundle bundle2 = bundle;
        if (bundle == null) {
            bundle2 = new Bundle();
        }
        if (!TextUtils.isEmpty(str)) {
            bundle2.putString("videoUrl", str);
        }
        if (aVar != null) {
            this.f25185a.a();
            if (!this.f25185a.b()) {
                return false;
            }
            this.f25186c = aVar;
            IUserStateChangedListener iUserStateChangedListener = new IUserStateChangedListener() { // from class: com.tencent.smtt.sdk.r.1
                @Override // com.tencent.tbs.video.interfaces.IUserStateChangedListener
                public void onUserStateChanged() {
                    r.this.f25185a.c();
                }
            };
            this.d = iUserStateChangedListener;
            this.f25186c.a(iUserStateChangedListener);
            bundle2.putInt("callMode", 3);
        } else {
            bundle2.putInt("callMode", 1);
        }
        this.f25185a.a(bundle2, aVar == null ? null : this);
        return true;
    }
}
