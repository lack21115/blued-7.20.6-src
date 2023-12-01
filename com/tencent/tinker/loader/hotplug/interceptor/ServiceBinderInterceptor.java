package com.tencent.tinker.loader.hotplug.interceptor;

import android.app.IActivityManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.IInterface;
import com.tencent.tinker.loader.hotplug.interceptor.Interceptor;
import com.tencent.tinker.loader.shareutil.ShareReflectUtil;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/loader/hotplug/interceptor/ServiceBinderInterceptor.class */
public class ServiceBinderInterceptor extends Interceptor<IBinder> {
    private static final String TAG = "Tinker.SvcBndrIntrcptr";
    private static Method sGetServiceMethod;
    private static Field sSCacheField;
    private static Class<?> sServiceManagerClazz;
    private final Context mBaseContext;
    private final BinderInvocationHandler mBinderInvocationHandler;
    private final String mServiceName;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/loader/hotplug/interceptor/ServiceBinderInterceptor$BinderInvocationHandler.class */
    public interface BinderInvocationHandler {
        Object invoke(Object obj, Method method, Object[] objArr) throws Throwable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/loader/hotplug/interceptor/ServiceBinderInterceptor$FakeClientBinderHandler.class */
    public static class FakeClientBinderHandler implements InvocationHandler {
        private final BinderInvocationHandler mBinderInvocationHandler;
        private final IBinder mOriginalClientBinder;

        FakeClientBinderHandler(IBinder iBinder, BinderInvocationHandler binderInvocationHandler) {
            this.mOriginalClientBinder = iBinder;
            this.mBinderInvocationHandler = binderInvocationHandler;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            String str;
            if ("queryLocalInterface".equals(method.getName())) {
                String interfaceDescriptor = this.mOriginalClientBinder.getInterfaceDescriptor();
                if (interfaceDescriptor.equals(IActivityManager.descriptor)) {
                    str = "android.app.ActivityManagerNative";
                } else {
                    str = interfaceDescriptor + "$Stub";
                }
                IInterface iInterface = (IInterface) ShareReflectUtil.findMethod(Class.forName(str), "asInterface", (Class<?>[]) new Class[]{IBinder.class}).invoke(null, this.mOriginalClientBinder);
                return ServiceBinderInterceptor.createProxy(ServiceBinderInterceptor.getAllInterfacesThroughDeriveChain(iInterface.getClass()), new FakeInterfaceHandler(iInterface, (IBinder) obj, this.mBinderInvocationHandler));
            }
            return method.invoke(this.mOriginalClientBinder, objArr);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/loader/hotplug/interceptor/ServiceBinderInterceptor$FakeInterfaceHandler.class */
    static class FakeInterfaceHandler implements InvocationHandler {
        private final BinderInvocationHandler mBinderInvocationHandler;
        private final IBinder mOriginalClientBinder;
        private final IInterface mOriginalInterface;

        FakeInterfaceHandler(IInterface iInterface, IBinder iBinder, BinderInvocationHandler binderInvocationHandler) {
            this.mOriginalInterface = iInterface;
            this.mOriginalClientBinder = iBinder;
            this.mBinderInvocationHandler = binderInvocationHandler;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            return "asBinder".equals(method.getName()) ? this.mOriginalClientBinder : this.mBinderInvocationHandler.invoke(this.mOriginalInterface, method, objArr);
        }
    }

    static {
        synchronized (ServiceBinderInterceptor.class) {
            try {
                if (sServiceManagerClazz == null) {
                    Class<?> cls = Class.forName("android.os.ServiceManager");
                    sServiceManagerClazz = cls;
                    sSCacheField = ShareReflectUtil.findField(cls, "sCache");
                    sGetServiceMethod = ShareReflectUtil.findMethod(sServiceManagerClazz, "getService", (Class<?>[]) new Class[]{String.class});
                }
            } finally {
            }
        }
    }

    public ServiceBinderInterceptor(Context context, String str, BinderInvocationHandler binderInvocationHandler) {
        while (context != null && (context instanceof ContextWrapper)) {
            context = ((ContextWrapper) context).getBaseContext();
        }
        this.mBaseContext = context;
        this.mServiceName = str;
        this.mBinderInvocationHandler = binderInvocationHandler;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> T createProxy(Class<?>[] clsArr, InvocationHandler invocationHandler) {
        int length = clsArr.length + 1;
        Class[] clsArr2 = new Class[length];
        System.arraycopy(clsArr, 0, clsArr2, 0, clsArr.length);
        clsArr2[clsArr.length] = Interceptor.ITinkerHotplugProxy.class;
        try {
            return (T) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), clsArr2, invocationHandler);
        } catch (Throwable th) {
            final HashSet hashSet = new HashSet(4);
            for (int i = 0; i < length; i++) {
                hashSet.add(clsArr2[i].getClassLoader());
            }
            ClassLoader classLoader = hashSet.size() == 1 ? (ClassLoader) hashSet.iterator().next() : new ClassLoader() { // from class: com.tencent.tinker.loader.hotplug.interceptor.ServiceBinderInterceptor.1
                @Override // java.lang.ClassLoader
                protected Class<?> loadClass(String str, boolean z) throws ClassNotFoundException {
                    Class<?> cls;
                    Class<?> cls2 = null;
                    for (ClassLoader classLoader2 : hashSet) {
                        try {
                            cls = classLoader2.loadClass(str);
                        } catch (Throwable th2) {
                            cls = cls2;
                        }
                        cls2 = cls;
                        if (cls != null) {
                            return cls;
                        }
                    }
                    throw new ClassNotFoundException("cannot find class: " + str);
                }
            };
            try {
                return (T) Proxy.newProxyInstance(classLoader, clsArr2, invocationHandler);
            } catch (Throwable th2) {
                throw new RuntimeException("cl: " + classLoader, th);
            }
        }
    }

    private static void fixAMSBinderCache(IBinder iBinder) throws Throwable {
        Object obj;
        try {
            obj = ShareReflectUtil.findField(Class.forName("android.app.ActivityManagerNative"), "gDefault").get(null);
        } catch (Throwable th) {
            obj = ShareReflectUtil.findField(Class.forName("android.app.ActivityManager"), "IActivityManagerSingleton").get(null);
        }
        Field findField = ShareReflectUtil.findField(obj, "mInstance");
        IInterface iInterface = (IInterface) findField.get(obj);
        if (iInterface == null || Interceptor.ITinkerHotplugProxy.class.isAssignableFrom(iInterface.getClass())) {
            return;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface(iBinder.getInterfaceDescriptor());
        if (queryLocalInterface != null && Interceptor.ITinkerHotplugProxy.class.isAssignableFrom(queryLocalInterface.getClass())) {
            findField.set(obj, queryLocalInterface);
            return;
        }
        throw new IllegalStateException("fakeBinder does not return fakeInterface, binder: " + iBinder + ", itf: " + queryLocalInterface);
    }

    private static void fixPMSBinderCache(Context context, IBinder iBinder) throws Throwable {
        Field findField = ShareReflectUtil.findField(Class.forName("android.app.ActivityThread"), "sPackageManager");
        IInterface iInterface = (IInterface) findField.get(null);
        if (iInterface != null && !Interceptor.ITinkerHotplugProxy.class.isAssignableFrom(iInterface.getClass())) {
            IInterface queryLocalInterface = iBinder.queryLocalInterface(iBinder.getInterfaceDescriptor());
            if (queryLocalInterface == null || !Interceptor.ITinkerHotplugProxy.class.isAssignableFrom(queryLocalInterface.getClass())) {
                throw new IllegalStateException("fakeBinder does not return fakeInterface, binder: " + iBinder + ", itf: " + queryLocalInterface);
            }
            findField.set(null, queryLocalInterface);
        }
        Field findField2 = ShareReflectUtil.findField(Class.forName("android.app.ApplicationPackageManager"), "mPM");
        PackageManager packageManager = context.getPackageManager();
        IInterface iInterface2 = (IInterface) findField2.get(packageManager);
        if (iInterface2 == null || Interceptor.ITinkerHotplugProxy.class.isAssignableFrom(iInterface2.getClass())) {
            return;
        }
        IInterface queryLocalInterface2 = iBinder.queryLocalInterface(iBinder.getInterfaceDescriptor());
        if (queryLocalInterface2 != null && Interceptor.ITinkerHotplugProxy.class.isAssignableFrom(queryLocalInterface2.getClass())) {
            findField2.set(packageManager, queryLocalInterface2);
            return;
        }
        throw new IllegalStateException("fakeBinder does not return fakeInterface, binder: " + iBinder + ", itf: " + queryLocalInterface2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Class<?>[] getAllInterfacesThroughDeriveChain(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        HashSet hashSet = new HashSet(10);
        while (!Object.class.equals(cls)) {
            hashSet.addAll(Arrays.asList(cls.getInterfaces()));
            cls = cls.getSuperclass();
        }
        return (Class[]) hashSet.toArray(new Class[hashSet.size()]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.tinker.loader.hotplug.interceptor.Interceptor
    public IBinder decorate(IBinder iBinder) throws Throwable {
        if (iBinder != null) {
            return Interceptor.ITinkerHotplugProxy.class.isAssignableFrom(iBinder.getClass()) ? iBinder : (IBinder) createProxy(getAllInterfacesThroughDeriveChain(iBinder.getClass()), new FakeClientBinderHandler(iBinder, this.mBinderInvocationHandler));
        }
        throw new IllegalStateException("target is null.");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.tinker.loader.hotplug.interceptor.Interceptor
    public IBinder fetchTarget() throws Throwable {
        return (IBinder) sGetServiceMethod.invoke(null, this.mServiceName);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.tinker.loader.hotplug.interceptor.Interceptor
    public void inject(IBinder iBinder) throws Throwable {
        ((Map) sSCacheField.get(null)).put(this.mServiceName, iBinder);
        if ("activity".equals(this.mServiceName)) {
            fixAMSBinderCache(iBinder);
        } else if ("package".equals(this.mServiceName)) {
            fixPMSBinderCache(this.mBaseContext, iBinder);
        }
    }
}
