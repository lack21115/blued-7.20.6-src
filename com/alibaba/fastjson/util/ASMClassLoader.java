package com.alibaba.fastjson.util;

import com.alibaba.fastjson.JSON;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.ProtectionDomain;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/fastjson/util/ASMClassLoader.class */
public class ASMClassLoader extends ClassLoader {
    private static ProtectionDomain DOMAIN = (ProtectionDomain) AccessController.doPrivileged(new PrivilegedAction<Object>() { // from class: com.alibaba.fastjson.util.ASMClassLoader.1
        @Override // java.security.PrivilegedAction
        public Object run() {
            return ASMClassLoader.class.getProtectionDomain();
        }
    });

    public ASMClassLoader() {
        super(getParentClassLoader());
    }

    public ASMClassLoader(ClassLoader classLoader) {
        super(classLoader);
    }

    static ClassLoader getParentClassLoader() {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        if (contextClassLoader != null) {
            try {
                contextClassLoader.loadClass(JSON.class.getName());
                return contextClassLoader;
            } catch (ClassNotFoundException e) {
            }
        }
        return JSON.class.getClassLoader();
    }

    public Class<?> defineClassPublic(String str, byte[] bArr, int i, int i2) throws ClassFormatError {
        return defineClass(str, bArr, i, i2, DOMAIN);
    }

    public boolean isExternalClass(Class<?> cls) {
        ClassLoader classLoader = cls.getClassLoader();
        if (classLoader == null) {
            return false;
        }
        ClassLoader classLoader2 = this;
        while (true) {
            ClassLoader classLoader3 = classLoader2;
            if (classLoader3 == null) {
                return true;
            }
            if (classLoader3 == classLoader) {
                return false;
            }
            classLoader2 = classLoader3.getParent();
        }
    }
}
