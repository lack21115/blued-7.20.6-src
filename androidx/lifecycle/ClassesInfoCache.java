package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Deprecated
/* loaded from: source-8756600-dex2jar.jar:androidx/lifecycle/ClassesInfoCache.class */
final class ClassesInfoCache {
    private static final int CALL_TYPE_NO_ARG = 0;
    private static final int CALL_TYPE_PROVIDER = 1;
    private static final int CALL_TYPE_PROVIDER_WITH_EVENT = 2;
    static ClassesInfoCache sInstance = new ClassesInfoCache();
    private final Map<Class<?>, CallbackInfo> mCallbackMap = new HashMap();
    private final Map<Class<?>, Boolean> mHasLifecycleMethods = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    /* loaded from: source-8756600-dex2jar.jar:androidx/lifecycle/ClassesInfoCache$CallbackInfo.class */
    public static class CallbackInfo {
        final Map<Lifecycle.Event, List<MethodReference>> mEventToHandlers = new HashMap();
        final Map<MethodReference, Lifecycle.Event> mHandlerToEvent;

        CallbackInfo(Map<MethodReference, Lifecycle.Event> map) {
            this.mHandlerToEvent = map;
            for (Map.Entry<MethodReference, Lifecycle.Event> entry : map.entrySet()) {
                Lifecycle.Event value = entry.getValue();
                List<MethodReference> list = this.mEventToHandlers.get(value);
                ArrayList arrayList = list;
                if (list == null) {
                    arrayList = new ArrayList();
                    this.mEventToHandlers.put(value, arrayList);
                }
                arrayList.add(entry.getKey());
            }
        }

        private static void invokeMethodsForEvent(List<MethodReference> list, LifecycleOwner lifecycleOwner, Lifecycle.Event event, Object obj) {
            if (list == null) {
                return;
            }
            int size = list.size();
            while (true) {
                int i = size - 1;
                if (i < 0) {
                    return;
                }
                list.get(i).invokeCallback(lifecycleOwner, event, obj);
                size = i;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void invokeCallbacks(LifecycleOwner lifecycleOwner, Lifecycle.Event event, Object obj) {
            invokeMethodsForEvent(this.mEventToHandlers.get(event), lifecycleOwner, event, obj);
            invokeMethodsForEvent(this.mEventToHandlers.get(Lifecycle.Event.ON_ANY), lifecycleOwner, event, obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    /* loaded from: source-8756600-dex2jar.jar:androidx/lifecycle/ClassesInfoCache$MethodReference.class */
    public static final class MethodReference {
        final int mCallType;
        final Method mMethod;

        MethodReference(int i, Method method) {
            this.mCallType = i;
            this.mMethod = method;
            method.setAccessible(true);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof MethodReference) {
                MethodReference methodReference = (MethodReference) obj;
                return this.mCallType == methodReference.mCallType && this.mMethod.getName().equals(methodReference.mMethod.getName());
            }
            return false;
        }

        public int hashCode() {
            return (this.mCallType * 31) + this.mMethod.getName().hashCode();
        }

        void invokeCallback(LifecycleOwner lifecycleOwner, Lifecycle.Event event, Object obj) {
            try {
                int i = this.mCallType;
                if (i == 0) {
                    this.mMethod.invoke(obj, new Object[0]);
                } else if (i == 1) {
                    this.mMethod.invoke(obj, lifecycleOwner);
                } else if (i != 2) {
                } else {
                    this.mMethod.invoke(obj, lifecycleOwner, event);
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e2) {
                throw new RuntimeException("Failed to call observer method", e2.getCause());
            }
        }
    }

    ClassesInfoCache() {
    }

    private CallbackInfo createInfo(Class<?> cls, Method[] methodArr) {
        int i;
        CallbackInfo info;
        Class<? super Object> superclass = cls.getSuperclass();
        HashMap hashMap = new HashMap();
        if (superclass != null && (info = getInfo(superclass)) != null) {
            hashMap.putAll(info.mHandlerToEvent);
        }
        Class<?>[] interfaces = cls.getInterfaces();
        int length = interfaces.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                break;
            }
            for (Map.Entry<MethodReference, Lifecycle.Event> entry : getInfo(interfaces[i3]).mHandlerToEvent.entrySet()) {
                verifyAndPutHandler(hashMap, entry.getKey(), entry.getValue(), cls);
            }
            i2 = i3 + 1;
        }
        if (methodArr == null) {
            methodArr = getDeclaredMethods(cls);
        }
        boolean z = false;
        for (Method method : methodArr) {
            OnLifecycleEvent onLifecycleEvent = (OnLifecycleEvent) method.getAnnotation(OnLifecycleEvent.class);
            if (onLifecycleEvent != null) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    i = 0;
                } else if (!parameterTypes[0].isAssignableFrom(LifecycleOwner.class)) {
                    throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                } else {
                    i = 1;
                }
                Lifecycle.Event value = onLifecycleEvent.value();
                if (parameterTypes.length > 1) {
                    if (!parameterTypes[1].isAssignableFrom(Lifecycle.Event.class)) {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    }
                    if (value != Lifecycle.Event.ON_ANY) {
                        throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                    }
                    i = 2;
                }
                if (parameterTypes.length > 2) {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
                verifyAndPutHandler(hashMap, new MethodReference(i, method), value, cls);
                z = true;
            }
        }
        CallbackInfo callbackInfo = new CallbackInfo(hashMap);
        this.mCallbackMap.put(cls, callbackInfo);
        this.mHasLifecycleMethods.put(cls, Boolean.valueOf(z));
        return callbackInfo;
    }

    private Method[] getDeclaredMethods(Class<?> cls) {
        try {
            return cls.getDeclaredMethods();
        } catch (NoClassDefFoundError e) {
            throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e);
        }
    }

    private void verifyAndPutHandler(Map<MethodReference, Lifecycle.Event> map, MethodReference methodReference, Lifecycle.Event event, Class<?> cls) {
        Lifecycle.Event event2 = map.get(methodReference);
        if (event2 == null || event == event2) {
            if (event2 == null) {
                map.put(methodReference, event);
                return;
            }
            return;
        }
        Method method = methodReference.mMethod;
        throw new IllegalArgumentException("Method " + method.getName() + " in " + cls.getName() + " already declared with different @OnLifecycleEvent value: previous value " + event2 + ", new value " + event);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CallbackInfo getInfo(Class<?> cls) {
        CallbackInfo callbackInfo = this.mCallbackMap.get(cls);
        return callbackInfo != null ? callbackInfo : createInfo(cls, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean hasLifecycleMethods(Class<?> cls) {
        Boolean bool = this.mHasLifecycleMethods.get(cls);
        if (bool != null) {
            return bool.booleanValue();
        }
        Method[] declaredMethods = getDeclaredMethods(cls);
        int length = declaredMethods.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                this.mHasLifecycleMethods.put(cls, false);
                return false;
            } else if (((OnLifecycleEvent) declaredMethods[i2].getAnnotation(OnLifecycleEvent.class)) != null) {
                createInfo(cls, declaredMethods);
                return true;
            } else {
                i = i2 + 1;
            }
        }
    }
}
