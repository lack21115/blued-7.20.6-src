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
    public final /* synthetic */ Activity f42183a;
    public final /* synthetic */ PermissionCallback b;

    /* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/q2$a.class */
    public class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ s2 f42184a;

        public a(s2 s2Var) {
            this.f42184a = s2Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Tracker.onClick(view);
            this.f42184a.dismiss();
            q2.this.b.onAuthorized();
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/q2$b.class */
    public class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ s2 f42185a;

        public b(s2 s2Var) {
            this.f42185a = s2Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Tracker.onClick(view);
            this.f42185a.dismiss();
            q2.this.b.onUnauthorized();
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/q2$c.class */
    public class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ s2 f42186a;

        public c(s2 s2Var) {
            this.f42186a = s2Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Tracker.onClick(view);
            this.f42186a.dismiss();
            z1.a("用户点击了解更多");
            q2.this.f42183a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://aid.mobileservice.cn/")));
        }
    }

    public q2(r2 r2Var, Activity activity, PermissionCallback permissionCallback) {
        this.f42183a = activity;
        this.b = permissionCallback;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            s2 s2Var = new s2(this.f42183a);
            s2Var.b = new a(s2Var);
            s2Var.f42196a = new b(s2Var);
            s2Var.f42197c = new c(s2Var);
            s2Var.show();
        } catch (Throwable th) {
            n2.a(th, m2.a("卓信ID授权弹窗异常: "));
        }
    }
}
