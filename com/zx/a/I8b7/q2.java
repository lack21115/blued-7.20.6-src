package com.zx.a.I8b7;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.bytedance.applog.tracker.Tracker;
import com.zx.sdk.api.PermissionCallback;

/* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/q2.class */
public class q2 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Activity f28492a;
    public final /* synthetic */ PermissionCallback b;

    /* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/q2$a.class */
    public class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ s2 f28493a;

        public a(s2 s2Var) {
            this.f28493a = s2Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Tracker.onClick(view);
            this.f28493a.dismiss();
            q2.this.b.onAuthorized();
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/q2$b.class */
    public class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ s2 f28494a;

        public b(s2 s2Var) {
            this.f28494a = s2Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Tracker.onClick(view);
            this.f28494a.dismiss();
            q2.this.b.onUnauthorized();
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/q2$c.class */
    public class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ s2 f28495a;

        public c(s2 s2Var) {
            this.f28495a = s2Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Tracker.onClick(view);
            this.f28495a.dismiss();
            z1.a("用户点击了解更多");
            q2.this.f28492a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://aid.mobileservice.cn/")));
        }
    }

    public q2(r2 r2Var, Activity activity, PermissionCallback permissionCallback) {
        this.f28492a = activity;
        this.b = permissionCallback;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            s2 s2Var = new s2(this.f28492a);
            s2Var.b = new a(s2Var);
            s2Var.f28505a = new b(s2Var);
            s2Var.f28506c = new c(s2Var);
            s2Var.show();
        } catch (Throwable th) {
            n2.a(th, m2.a("卓信ID授权弹窗异常: "));
        }
    }
}
