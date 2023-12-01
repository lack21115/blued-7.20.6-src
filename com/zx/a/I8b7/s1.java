package com.zx.a.I8b7;

import android.content.Context;
import com.igexin.sdk.PushConsts;
import com.youzan.androidsdk.tool.AppSigning;
import com.zx.a.I8b7.c3;
import com.zx.module.base.Callback;
import com.zx.module.base.Listener;
import com.zx.module.base.ZXModule;
import com.zx.module.context.ContextHolder;
import com.zx.module.exception.ZXModuleInvokeException;
import com.zx.module.exception.ZXModuleOnCreateException;
import com.zx.module.exception.ZXModuleOnDestroyException;
import com.zx.module.exception.ZXModuleStartException;
import com.zx.sdk.common.utils.ZXTask;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/s1.class */
public class s1 implements ZXModule {

    /* renamed from: a  reason: collision with root package name */
    public v2 f42195a;
    public final q1 b = new q1();

    @Override // com.zx.module.base.ZXModule
    public String getModuleIdentifier() {
        return "core-n";
    }

    @Override // com.zx.module.base.ZXModule
    public String getModuleVersion() {
        return "3.2.0.16894";
    }

    @Override // com.zx.module.base.ZXModule
    public String invoke(String str, String str2) throws ZXModuleInvokeException {
        q1 q1Var = this.b;
        q1Var.getClass();
        try {
            String substring = k.a(str, AppSigning.SHA256).substring(0, 16);
            if (!((HashSet) q1.b).contains(substring)) {
                return q1Var.a(str + " not in invokableMethods", 3);
            }
            Method declaredMethod = q1.class.getDeclaredMethod("f" + substring, String.class);
            declaredMethod.setAccessible(true);
            return (String) declaredMethod.invoke(q1Var, str2);
        } catch (Exception e) {
            z1.a(e);
            throw new ZXModuleInvokeException("Cannot invoke " + str + ", nested exception is " + e.getMessage(), e);
        }
    }

    @Override // com.zx.module.base.ZXModule
    public String invokeAsync(String str, String str2, Callback callback) throws ZXModuleInvokeException {
        q1 q1Var = this.b;
        q1Var.getClass();
        try {
            String substring = k.a(str, AppSigning.SHA256).substring(0, 16);
            if (!((HashSet) q1.b).contains(substring)) {
                String a2 = q1Var.a(str + " not in invokableMethods", 3);
                callback.callback(a2);
                return a2;
            }
            z1.a("开始执行invokeAsync: method:" + str + "; " + str2 + ":cb");
            StringBuilder sb = new StringBuilder();
            sb.append("f");
            sb.append(substring);
            Method declaredMethod = q1.class.getDeclaredMethod(sb.toString(), String.class, Callback.class);
            declaredMethod.setAccessible(true);
            return (String) declaredMethod.invoke(q1Var, str2, callback);
        } catch (Exception e) {
            StringBuilder a3 = m2.a("开始执行invokeAsync");
            a3.append(e.getMessage());
            z1.b(a3.toString());
            throw new ZXModuleInvokeException("Cannot invokeAsync " + str + ", nested exception is " + e.getMessage(), e);
        }
    }

    @Override // com.zx.module.base.ZXModule
    public void onCreate(ContextHolder contextHolder) throws ZXModuleOnCreateException {
        a3 a3Var = new a3();
        this.f42195a = a3Var;
        Context context = (Context) contextHolder.getContext();
        try {
            if (!a3Var.b.getAndSet(true)) {
                AtomicInteger atomicInteger = c3.f42112c;
                c3.c.f42114a.b.execute(new z2(a3Var, context));
            }
        } catch (Throwable th) {
            n2.a(th, m2.a("ZXCore init failed: "));
            a3Var.b.set(false);
        }
        this.b.f42177a = this.f42195a;
    }

    @Override // com.zx.module.base.ZXModule
    public void onDestroy() throws ZXModuleOnDestroyException {
    }

    @Override // com.zx.module.base.ZXModule
    public void setMessageListener(Listener listener) {
        a3 a3Var = (a3) this.f42195a;
        a3Var.getClass();
        a3Var.f42101c = new w2(a3Var, listener);
    }

    @Override // com.zx.module.base.ZXModule
    public void start() throws ZXModuleStartException {
        a3 a3Var = (a3) this.f42195a;
        if (a3Var.f42100a.compareAndSet(false, true)) {
            try {
                ZXTask zXTask = new ZXTask(new x2(a3Var), new y2(a3Var));
                AtomicInteger atomicInteger = c3.f42112c;
                c3.c.f42114a.b.execute(zXTask);
            } catch (Throwable th) {
                a3Var.f42101c.onMessage("MESSAGE_ON_ZXID_RECEIVED", n1.a(PushConsts.GET_SDKONLINESTATE, th.getMessage()));
                StringBuilder sb = new StringBuilder();
                sb.append("ZXCore start failed: ");
                n2.a(th, sb);
            }
        }
    }
}
