package com.huawei.agconnect.core;

import com.huawei.agconnect.annotation.AutoCreated;
import com.huawei.agconnect.annotation.SharedInstance;
import com.huawei.agconnect.annotation.Singleton;
import java.lang.reflect.Modifier;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/agconnect/core/Service.class */
public class Service {

    /* renamed from: a  reason: collision with root package name */
    private final Class<?> f8733a;
    private final Class<?> b;

    /* renamed from: c  reason: collision with root package name */
    private final Object f8734c;
    private boolean d;
    private boolean e;
    private boolean f;

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/agconnect/core/Service$Builder.class */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        Class<?> f8735a;
        Class<?> b;

        /* renamed from: c  reason: collision with root package name */
        Object f8736c;
        private boolean d;
        private boolean e;
        private boolean f;

        public Service build() {
            Class<?> cls = this.f8735a;
            if (cls != null) {
                Class<?> cls2 = this.b;
                if (cls2 == null) {
                    Object obj = this.f8736c;
                    if (obj != null) {
                        Service service = new Service(cls, obj);
                        service.d = this.d;
                        return service;
                    }
                    throw new IllegalArgumentException("the clazz or object parameter must set one");
                } else if (cls2.isInterface() || !Modifier.isPublic(this.b.getModifiers())) {
                    throw new IllegalArgumentException("the clazz parameter cant be interface type or not public");
                } else {
                    Service service2 = new Service((Class) this.f8735a, (Class) this.b);
                    service2.d = this.d;
                    service2.e = this.e;
                    service2.f = this.f;
                    return service2;
                }
            }
            throw new IllegalArgumentException("the interface parameter cannot be NULL");
        }

        public Builder isAutoCreated(boolean z) {
            this.f = z;
            return this;
        }

        public Builder isSharedInstance(boolean z) {
            this.e = z;
            return this;
        }

        public Builder isSingleton(boolean z) {
            this.d = z;
            return this;
        }

        public Builder setClass(Class<?> cls) {
            this.b = cls;
            return this;
        }

        public Builder setInterface(Class<?> cls) {
            this.f8735a = cls;
            return this;
        }

        public Builder setObject(Object obj) {
            this.f8736c = obj;
            return this;
        }
    }

    private Service(Class<?> cls, Class<?> cls2) {
        this.f8733a = cls;
        this.b = cls2;
        this.f8734c = null;
    }

    private Service(Class<?> cls, Object obj) {
        this.f8733a = cls;
        this.b = null;
        this.f8734c = obj;
    }

    public static Builder builder(Class<?> cls) {
        return new Builder().setInterface(cls).setClass(cls).isSingleton(cls.isAnnotationPresent(Singleton.class)).isSharedInstance(cls.isAnnotationPresent(SharedInstance.class)).isAutoCreated(cls.isAnnotationPresent(AutoCreated.class));
    }

    public static Builder builder(Class<?> cls, Class<?> cls2) {
        return new Builder().setInterface(cls).setClass(cls2).isSingleton(cls2.isAnnotationPresent(Singleton.class)).isSharedInstance(cls2.isAnnotationPresent(SharedInstance.class)).isAutoCreated(cls2.isAnnotationPresent(AutoCreated.class));
    }

    public static Builder builder(Class<?> cls, Object obj) {
        return new Builder().setInterface(cls).setObject(obj).isSingleton(true).isSharedInstance(cls.isAnnotationPresent(SharedInstance.class)).isAutoCreated(cls.isAnnotationPresent(AutoCreated.class));
    }

    public Object getInstance() {
        return this.f8734c;
    }

    public Class<?> getInterface() {
        return this.f8733a;
    }

    public Class<?> getType() {
        return this.b;
    }

    public boolean isAutoCreated() {
        return this.f;
    }

    public boolean isSharedInstance() {
        return this.e;
    }

    public boolean isSingleton() {
        return this.d;
    }
}
