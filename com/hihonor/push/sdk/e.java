package com.hihonor.push.sdk;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.hihonor.push.framework.aidl.entity.BooleanResult;
import com.hihonor.push.framework.aidl.entity.PushTokenResult;
import com.hihonor.push.sdk.common.data.ApiException;
import com.hihonor.push.sdk.common.data.DownMsgType;
import com.hihonor.push.sdk.common.data.UpMsgType;
import com.hihonor.push.sdk.internal.HonorPushErrorEnum;
import java.util.List;
import java.util.concurrent.Callable;

/* loaded from: source-7994992-dex2jar.jar:com/hihonor/push/sdk/e.class */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public final Context f22288a;
    public k b = new k();

    public e(Context context) {
        this.f22288a = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(boolean z) throws Exception {
        this.b.getClass();
        try {
            o0 o0Var = new o0(UpMsgType.REQUEST_PUSH_TOKEN, null);
            o0Var.e = a.a();
            String pushToken = ((PushTokenResult) a.a(j.f22302c.a(o0Var))).getPushToken();
            if (z && !TextUtils.isEmpty(pushToken)) {
                Bundle bundle = new Bundle();
                bundle.putString("event_type", DownMsgType.RECEIVE_TOKEN);
                bundle.putString("push_token", pushToken);
                q qVar = new q();
                Context context = this.f22288a;
                Log.i("MessengerSrvConnection", "start bind service.");
                try {
                    Intent intent = new Intent();
                    intent.setPackage(context.getPackageName());
                    intent.setAction("com.hihonor.push.action.MESSAGING_EVENT");
                    Context applicationContext = context.getApplicationContext();
                    qVar.f22321c = applicationContext;
                    qVar.b = bundle;
                    if (applicationContext.bindService(intent, qVar, 1)) {
                        Log.i("MessengerSrvConnection", "bind service succeeded.");
                        return pushToken;
                    }
                } catch (Exception e) {
                    new StringBuilder("bind service failed.").append(e.getMessage());
                }
            }
            return pushToken;
        } catch (Exception e2) {
            throw a.a(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Void a() throws Exception {
        k kVar = this.b;
        Context context = this.f22288a;
        kVar.getClass();
        try {
            n0 n0Var = new n0(UpMsgType.UNREGISTER_PUSH_TOKEN, null);
            n0Var.e = a.a();
            a.a(j.f22302c.a(n0Var));
            c.b.a(context, null);
            return null;
        } catch (Exception e) {
            throw a.a(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(HonorPushCallback honorPushCallback, j0 j0Var) {
        if (j0Var.e()) {
            a((HonorPushCallback<HonorPushCallback>) honorPushCallback, (HonorPushCallback) ((List) j0Var.c()));
        } else {
            a(honorPushCallback, -1, j0Var.b().toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Void b() throws Exception {
        this.b.a(false);
        return null;
    }

    public static /* synthetic */ void b(HonorPushCallback honorPushCallback, int i, String str) {
        if (honorPushCallback != null) {
            honorPushCallback.onFailure(i, str);
        }
    }

    public static /* synthetic */ void b(HonorPushCallback honorPushCallback, Object obj) {
        if (honorPushCallback != null) {
            honorPushCallback.onSuccess(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(Callable callable, HonorPushCallback honorPushCallback) {
        try {
            a((HonorPushCallback<HonorPushCallback>) honorPushCallback, (HonorPushCallback) callable.call());
        } catch (ApiException e) {
            a(honorPushCallback, e.getErrorCode(), e.getMessage());
        } catch (Exception e2) {
            HonorPushErrorEnum honorPushErrorEnum = HonorPushErrorEnum.ERROR_INTERNAL_ERROR;
            a(honorPushCallback, honorPushErrorEnum.getErrorCode(), honorPushErrorEnum.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Void c() throws Exception {
        this.b.a(true);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Boolean d() throws Exception {
        this.b.getClass();
        try {
            m0 m0Var = new m0(UpMsgType.QUERY_PUSH_STATUS, null);
            m0Var.e = a.a();
            return Boolean.valueOf(((BooleanResult) a.a(j.f22302c.a(m0Var))).getStatus());
        } catch (Exception e) {
            throw a.a(e);
        }
    }

    public void a(HonorPushCallback<Void> honorPushCallback) {
        a(new Callable() { // from class: com.hihonor.push.sdk.-$$Lambda$e$yGu6f47i8FnZ5ML1DwZ3zSSy52g
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Void a2;
                a2 = e.this.a();
                return a2;
            }
        }, honorPushCallback);
    }

    public final void a(final HonorPushCallback<?> honorPushCallback, final int i, final String str) {
        k0.a(new Runnable() { // from class: com.hihonor.push.sdk.-$$Lambda$tbAJ-r3ih48qTR1-8VpCXaOnINQ
            @Override // java.lang.Runnable
            public final void run() {
                e.b(HonorPushCallback.this, i, str);
            }
        });
    }

    public final <T> void a(final HonorPushCallback<T> honorPushCallback, final T t) {
        k0.a(new Runnable() { // from class: com.hihonor.push.sdk.-$$Lambda$qLsaD54Tx6esepyqbSaviLsMDcQ
            @Override // java.lang.Runnable
            public final void run() {
                e.b(HonorPushCallback.this, t);
            }
        });
    }

    public void a(HonorPushCallback<String> honorPushCallback, final boolean z) {
        a(new Callable() { // from class: com.hihonor.push.sdk.-$$Lambda$e$cTFLSvDMdeXjzZJMTueSvjS9JG4
            @Override // java.util.concurrent.Callable
            public final Object call() {
                String a2;
                a2 = e.this.a(z);
                return a2;
            }
        }, honorPushCallback);
    }

    public final <T> void a(final Callable<T> callable, final HonorPushCallback<T> honorPushCallback) {
        Runnable runnable = new Runnable() { // from class: com.hihonor.push.sdk.-$$Lambda$e$X-H2gqWX5_EdtG6PLHidG-jn_60
            @Override // java.lang.Runnable
            public final void run() {
                e.this.b(callable, honorPushCallback);
            }
        };
        k0 k0Var = k0.f;
        if (k0Var.d == null) {
            synchronized (k0Var.e) {
                if (k0Var.d == null) {
                    k0Var.d = k0Var.b();
                }
            }
        }
        k0Var.d.execute(runnable);
    }

    public void b(HonorPushCallback<Void> honorPushCallback) {
        a(new Callable() { // from class: com.hihonor.push.sdk.-$$Lambda$e$2wFMXwLW5IHoBn1C69DWm0GwER4
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Void b;
                b = e.this.b();
                return b;
            }
        }, honorPushCallback);
    }

    public void c(HonorPushCallback<Void> honorPushCallback) {
        a(new Callable() { // from class: com.hihonor.push.sdk.-$$Lambda$e$HlqLv_3z-I5MqJEhRyDDLKxHJP0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Void c2;
                c2 = e.this.c();
                return c2;
            }
        }, honorPushCallback);
    }

    public void d(final HonorPushCallback<List<HonorPushDataMsg>> honorPushCallback) {
        if (honorPushCallback == null) {
            return;
        }
        j0 a2 = a.a(new z(this.f22288a));
        u uVar = new u() { // from class: com.hihonor.push.sdk.-$$Lambda$e$EX1SHELaUI8UBxA8bVHcgv37dLw
            @Override // com.hihonor.push.sdk.u
            public final void a(j0 j0Var) {
                e.this.a(honorPushCallback, j0Var);
            }
        };
        a2.getClass();
        a2.a(new d0(y.f22325c.f22326a, uVar));
    }

    public void e(HonorPushCallback<Boolean> honorPushCallback) {
        a(new Callable() { // from class: com.hihonor.push.sdk.-$$Lambda$e$glgyozqVNzC6gJGc81ZjEpXjdyk
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Boolean d;
                d = e.this.d();
                return d;
            }
        }, honorPushCallback);
    }
}
