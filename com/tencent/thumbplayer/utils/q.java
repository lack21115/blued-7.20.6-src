package com.tencent.thumbplayer.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.baidu.mobads.sdk.api.IAdInterListener;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/utils/q.class */
public class q {

    /* renamed from: a  reason: collision with root package name */
    private String f25757a;
    private a b;

    /* renamed from: c  reason: collision with root package name */
    private Looper f25758c;
    private m d = new m();
    private Object e;
    private Class<?> f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/utils/q$a.class */
    public class a extends Handler {
        private a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            q.this.a(message);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/utils/q$b.class */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        Object f25760a;
        e b;

        private b() {
        }
    }

    public q(String str, Looper looper, Object obj) {
        this.f25757a = str;
        this.f25758c = looper;
        this.b = new a(this.f25758c);
        this.e = obj;
        Class<?> cls = obj.getClass();
        this.f = cls;
        if (n.a(cls, 0)) {
            return;
        }
        String str2 = this.f25757a;
        TPLogUtil.e(str2, "Register " + this.f.getName() + " @ThreadSwitch method failed, version: 2.31.0.127");
        throw new RuntimeException("register @ThreadSwitch method failed, player can not work");
    }

    private Object a(int i, int i2, int i3, Object obj, boolean z, boolean z2, long j) {
        e eVar = new e();
        b bVar = new b();
        bVar.f25760a = obj;
        bVar.b = eVar;
        b(i, i2, i3, bVar, z, z2, j);
        return eVar.a(500L);
    }

    private Object a(String str, Object obj, Object obj2) {
        if (obj != null) {
            return obj;
        }
        String name = n.a(this.f, str, a(obj2)).getReturnType().getName();
        if (name.equals(TypedValues.Custom.S_BOOLEAN)) {
            return Boolean.FALSE;
        }
        if (name.equals(IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL)) {
            return 0;
        }
        if (name.equals("long")) {
            return 0L;
        }
        if (name.equals(TypedValues.Custom.S_FLOAT)) {
            return Float.valueOf(0.0f);
        }
        return null;
    }

    private String a(int i) {
        String b2 = n.b(this.f, i);
        if (TextUtils.isEmpty(b2) || b2.equals("unknown")) {
            return i + " not find";
        }
        return b2;
    }

    private void a(int i, Object obj) {
        e eVar = obj instanceof b ? ((b) obj).b : null;
        Method f = n.f(this.f, i);
        if (f == null) {
            TPLogUtil.e(this.f25757a, "invokeMethod, handle method name is empty, msg:".concat(String.valueOf(i)));
            if (eVar != null) {
                eVar.a((Throwable) new RuntimeException("invokeMethod, handle method name is empty"));
                return;
            }
            return;
        }
        try {
            Object invoke = f.getParameterTypes().length == 0 ? f.invoke(this.e, new Object[0]) : f.invoke(this.e, a(obj));
            if (eVar != null) {
                eVar.a(invoke);
            }
        } catch (InvocationTargetException e) {
            String str = this.f25757a;
            TPLogUtil.e(str, "invokeMethod " + f.getName() + " has excecption: " + e.getTargetException().toString());
            if (eVar == null) {
                return;
            }
            if (e.getTargetException() instanceof IllegalArgumentException) {
                eVar.a((Throwable) new IllegalArgumentException("invokeMethod " + f.getName() + " failed, params invalid", e.getCause()));
            } else if (!(e.getTargetException() instanceof IllegalStateException)) {
                eVar.a(e.getTargetException());
            } else {
                eVar.a((Throwable) new IllegalStateException("invokeMethod " + f.getName() + " failed, state invalid", e.getCause()));
            }
        } catch (Exception e2) {
            String str2 = this.f25757a;
            TPLogUtil.e(str2, "invokeMethod " + f.getName() + " has excecption: " + e2.toString());
            if (eVar != null) {
                eVar.a((Throwable) e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Message message) {
        if (this.e == null) {
            TPLogUtil.e(this.f25757a, "handle listener is null, return");
        } else {
            a(message.what, message.obj);
        }
    }

    private boolean a() {
        return Looper.myLooper() == this.f25758c;
    }

    private Object[] a(Object obj) {
        if (obj == null) {
            return null;
        }
        Object obj2 = obj;
        if (obj instanceof b) {
            Object obj3 = ((b) obj).f25760a;
            obj2 = obj3;
            if (obj3 == null) {
                return null;
            }
        }
        return (Object[]) obj2;
    }

    private boolean b(int i, int i2, int i3, Object obj, boolean z, boolean z2, long j) {
        String str;
        StringBuilder sb;
        String str2;
        if (this.b == null) {
            str = this.f25757a;
            sb = new StringBuilder();
            sb.append(a(i));
            str2 = " , send failed , handler null";
        } else if (z && obj == null) {
            str = this.f25757a;
            sb = new StringBuilder();
            sb.append(a(i));
            str2 = ", send failed , params null";
        } else if (this.f25758c.getThread().isAlive()) {
            if (!a()) {
                this.d.readLock().lock();
            }
            if (z2) {
                this.b.removeMessages(i);
            }
            Message obtainMessage = this.b.obtainMessage();
            obtainMessage.what = i;
            obtainMessage.arg1 = i2;
            obtainMessage.arg2 = i3;
            obtainMessage.obj = obj;
            if (a()) {
                a(obtainMessage);
                return true;
            }
            this.b.sendMessageDelayed(obtainMessage, j);
            this.d.readLock().unlock();
            return true;
        } else {
            str = this.f25757a;
            sb = new StringBuilder();
            sb.append(a(i));
            str2 = ", send failed , thread had dead";
        }
        sb.append(str2);
        TPLogUtil.e(str, sb.toString());
        return false;
    }

    public Object a(String str, Object obj) {
        return a(str, b(str, obj), obj);
    }

    public Object b(String str, Object obj) {
        if (TextUtils.isEmpty(str)) {
            TPLogUtil.e(this.f25757a, "dealThreadSwitch failed , methodName is null");
            throw new RuntimeException("dealThreadSwitch failed , methodName is null");
        }
        int b2 = n.b(this.f, str, a(obj));
        if (b2 < 0) {
            TPLogUtil.e(this.f25757a, "dealThreadSwitch failed , not match method:".concat(String.valueOf(str)));
            throw new RuntimeException("dealThreadSwitch failed , not match method:".concat(String.valueOf(str)));
        }
        boolean d = n.d(this.f, b2);
        boolean e = n.e(this.f, b2);
        if (n.c(this.f, b2)) {
            return a(b2, 0, 0, obj, e, d, 0L);
        }
        b(b2, 0, 0, obj, e, d, 0L);
        return null;
    }
}
