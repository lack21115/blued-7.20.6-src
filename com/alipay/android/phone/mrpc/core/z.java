package com.alipay.android.phone.mrpc.core;

import android.os.Looper;
import com.alipay.mobile.framework.service.annotation.OperationType;
import com.alipay.mobile.framework.service.annotation.ResetCookie;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-6737240-dex2jar.jar:com/alipay/android/phone/mrpc/core/z.class */
public final class z {

    /* renamed from: a  reason: collision with root package name */
    private static final ThreadLocal<Object> f4543a = new ThreadLocal<>();
    private static final ThreadLocal<Map<String, Object>> b = new ThreadLocal<>();

    /* renamed from: c  reason: collision with root package name */
    private byte f4544c = 0;
    private AtomicInteger d = new AtomicInteger();
    private x e;

    public z(x xVar) {
        this.e = xVar;
    }

    public final Object a(Method method, Object[] objArr) {
        if (Looper.myLooper() != null && Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalThreadStateException("can't in main thread call rpc .");
        }
        OperationType operationType = (OperationType) method.getAnnotation(OperationType.class);
        boolean z = method.getAnnotation(ResetCookie.class) != null;
        Type genericReturnType = method.getGenericReturnType();
        method.getAnnotations();
        f4543a.set(null);
        b.set(null);
        if (operationType != null) {
            String value = operationType.value();
            int incrementAndGet = this.d.incrementAndGet();
            try {
                if (this.f4544c == 0) {
                    com.alipay.android.phone.mrpc.core.a.e eVar = new com.alipay.android.phone.mrpc.core.a.e(incrementAndGet, value, objArr);
                    if (b.get() != null) {
                        eVar.a(b.get());
                    }
                    byte[] bArr = (byte[]) new j(this.e.a(), method, incrementAndGet, value, eVar.a(), z).a();
                    b.set(null);
                    Object a2 = new com.alipay.android.phone.mrpc.core.a.d(genericReturnType, bArr).a();
                    if (genericReturnType != Void.TYPE) {
                        f4543a.set(a2);
                    }
                }
                return f4543a.get();
            } catch (RpcException e) {
                e.setOperationType(value);
                throw e;
            }
        }
        throw new IllegalStateException("OperationType must be set.");
    }
}
