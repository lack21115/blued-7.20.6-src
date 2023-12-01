package com.bytedance.pangle;

import android.os.Build;
import dalvik.system.BaseDexClassLoader;
import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/pangle/PluginClassLoader.class */
public class PluginClassLoader extends BaseDexClassLoader {
    private static final String TAG = "PluginClassLoader";
    private HashSet<String> allPluginClasses;
    private final ClassLoader hostClassLoader;
    private final List<ClassLoader> otherPluginClassLoader;

    public PluginClassLoader(String str, File file, String str2, List<ClassLoader> list) {
        super(str, file, str2, getSystemClassLoader().getParent());
        this.hostClassLoader = PluginClassLoader.class.getClassLoader();
        this.otherPluginClassLoader = list;
    }

    private ClassNotFoundException handleException(StringBuilder sb, ClassNotFoundException classNotFoundException, ClassNotFoundException classNotFoundException2) {
        if (classNotFoundException == null) {
            return classNotFoundException2;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            classNotFoundException.addSuppressed(classNotFoundException2);
            return classNotFoundException;
        }
        sb.append(classNotFoundException2.getCause());
        sb.append("\n");
        return new ClassNotFoundException(sb.toString(), classNotFoundException2);
    }

    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    protected Class<?> findClass(String str) {
        HashSet<String> hashSet = this.allPluginClasses;
        Class<?> cls = null;
        if (hashSet == null || hashSet.contains(str)) {
            try {
                cls = super.findClass(str);
                e = null;
            } catch (ClassNotFoundException e) {
                e = e;
            }
        } else {
            e = null;
        }
        StringBuilder sb = new StringBuilder("loadClass from :\n");
        ClassNotFoundException classNotFoundException = e;
        Class<?> cls2 = cls;
        if (cls == null) {
            List<ClassLoader> list = this.otherPluginClassLoader;
            classNotFoundException = e;
            cls2 = cls;
            if (list != null) {
                Iterator<ClassLoader> it = list.iterator();
                while (true) {
                    classNotFoundException = e;
                    cls2 = cls;
                    if (!it.hasNext()) {
                        break;
                    }
                    try {
                        cls = it.next().loadClass(str);
                    } catch (ClassNotFoundException e2) {
                        e = handleException(sb, e, e2);
                    }
                }
            }
        }
        ClassNotFoundException classNotFoundException2 = classNotFoundException;
        Class<?> cls3 = cls2;
        if (cls2 == null) {
            try {
                cls3 = this.hostClassLoader.loadClass(str);
                classNotFoundException2 = classNotFoundException;
            } catch (ClassNotFoundException e3) {
                classNotFoundException2 = handleException(sb, classNotFoundException, e3);
                cls3 = cls2;
            }
        }
        if (cls3 == null) {
            ClassNotFoundException classNotFoundException3 = classNotFoundException2;
            if (classNotFoundException2 == null) {
                classNotFoundException3 = new ClassNotFoundException(str + " class not found in PluginClassLoader");
            }
            throw classNotFoundException3;
        }
        return cls3;
    }

    public void setAllPluginClasses(HashSet<String> hashSet) {
        this.allPluginClasses = hashSet;
    }
}
