package com.meizu.cloud.pushsdk.b.b;

import com.meizu.cloud.pushinternal.DebugLogger;
import java.lang.reflect.Constructor;

/* loaded from: source-7994992-dex2jar.jar:com/meizu/cloud/pushsdk/b/b/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private final a f10359a;
    private final Class<?>[] b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, Class<?>... clsArr) {
        this.f10359a = aVar;
        this.b = clsArr;
    }

    public <T> d<T> a(Object... objArr) {
        d<T> dVar = new d<>();
        try {
            Constructor<?> declaredConstructor = this.f10359a.a().getDeclaredConstructor(this.b);
            declaredConstructor.setAccessible(true);
            dVar.b = (T) declaredConstructor.newInstance(objArr);
            dVar.f10362a = true;
            return dVar;
        } catch (Exception e) {
            DebugLogger.e("ReflectConstructor", "newInstance", e);
            return dVar;
        }
    }
}
