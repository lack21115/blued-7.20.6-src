package org.xml.sax.helpers;

import java.lang.reflect.InvocationTargetException;

/* loaded from: source-2895416-dex2jar.jar:org/xml/sax/helpers/NewInstance.class */
class NewInstance {
    NewInstance() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ClassLoader getClassLoader() {
        try {
            try {
                return (ClassLoader) Thread.class.getMethod("getContextClassLoader", new Class[0]).invoke(Thread.currentThread(), new Object[0]);
            } catch (IllegalAccessException e) {
                throw new UnknownError(e.getMessage());
            } catch (InvocationTargetException e2) {
                throw new UnknownError(e2.getMessage());
            }
        } catch (NoSuchMethodException e3) {
            return NewInstance.class.getClassLoader();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object newInstance(ClassLoader classLoader, String str) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        return (classLoader == null ? Class.forName(str) : classLoader.loadClass(str)).newInstance();
    }
}
