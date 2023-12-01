package com.wrapper.proxyapplication;

import android.os.Build;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import dalvik.system.DexFile;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.zip.ZipFile;

/* loaded from: source-63640-dex2jar.jar:com/wrapper/proxyapplication/MultiDex.class */
public final class MultiDex {
    static final String TAG = "MultiDex";
    static Object baseApkDexFile;
    static IOException[] dexElementsSuppressedExceptions;
    static int hasInjected;
    static int injectDexBeginIndex;
    static Object[] injectDexsObj;
    static Object[] injectFilesObj;
    static Object[] injectPathListObj;
    static Object[] injectPathsObj;
    static Object[] injectZipsObj;

    /* loaded from: source-63640-dex2jar.jar:com/wrapper/proxyapplication/MultiDex$V19.class */
    private static final class V19 {
        private V19() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static ArrayList<Object> install(ClassLoader classLoader, Field field, List<File> list, File file, int i, boolean z, boolean z2) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException {
            Object obj = field.get(classLoader);
            ArrayList arrayList = new ArrayList();
            Object[] makeDexElements = makeDexElements(obj, new ArrayList(list), file, arrayList);
            if (makeDexElements == null || makeDexElements.length != list.size()) {
                return null;
            }
            ArrayList<Object> arrayList2 = new ArrayList<>();
            int length = makeDexElements.length;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= length) {
                    break;
                }
                Object obj2 = makeDexElements[i3];
                Object obj3 = MultiDex.findField(obj2, "dexFile").get(obj2);
                Field findField = MultiDex.findField(obj3, "mCookie");
                if (findField.getType().getName().equals("int")) {
                    arrayList2.add(Integer.valueOf(findField.getInt(obj3)));
                } else if (findField.getType().getName().equals("long")) {
                    arrayList2.add(Long.valueOf(findField.getLong(obj3)));
                } else {
                    if (z2) {
                        arrayList2.add(obj3);
                    }
                    arrayList2.add(findField.get(obj3));
                }
                i2 = i3 + 1;
            }
            MultiDex.expandFieldArray(obj, "dexElements", makeDexElements, i);
            if (arrayList.size() > 0) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    IOException iOException = (IOException) it.next();
                }
                MultiDex.dexElementsSuppressedExceptions = (IOException[]) MultiDex.findField(obj, "dexElementsSuppressedExceptions").get(obj);
                if (MultiDex.dexElementsSuppressedExceptions == null) {
                    MultiDex.dexElementsSuppressedExceptions = (IOException[]) arrayList.toArray(new IOException[arrayList.size()]);
                    return arrayList2;
                }
                IOException[] iOExceptionArr = new IOException[arrayList.size() + MultiDex.dexElementsSuppressedExceptions.length];
                arrayList.toArray(iOExceptionArr);
                System.arraycopy(MultiDex.dexElementsSuppressedExceptions, 0, iOExceptionArr, arrayList.size(), MultiDex.dexElementsSuppressedExceptions.length);
                MultiDex.dexElementsSuppressedExceptions = iOExceptionArr;
            }
            return arrayList2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static ArrayList<Object> install(ClassLoader classLoader, Field field, List<File> list, File file, boolean z, boolean z2) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException {
            IOException[] iOExceptionArr;
            Object obj = field.get(classLoader);
            ArrayList arrayList = new ArrayList();
            Object[] makeDexElements = makeDexElements(obj, new ArrayList(list), file, arrayList);
            if (makeDexElements == null || makeDexElements.length != list.size()) {
                return null;
            }
            ArrayList<Object> arrayList2 = new ArrayList<>();
            int length = makeDexElements.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                Object obj2 = makeDexElements[i2];
                Object obj3 = MultiDex.findField(obj2, "dexFile").get(obj2);
                Field findField = MultiDex.findField(obj3, "mCookie");
                if (findField.getType().getName().equals("int")) {
                    arrayList2.add(Integer.valueOf(findField.getInt(obj3)));
                } else if (findField.getType().getName().equals("long")) {
                    arrayList2.add(Long.valueOf(findField.getLong(obj3)));
                    if (z) {
                        findField.setLong(obj3, 0L);
                    }
                } else {
                    if (z2) {
                        arrayList2.add(obj3);
                    }
                    arrayList2.add(findField.get(obj3));
                    if (z) {
                        findField.set(obj3, null);
                    }
                }
                i = i2 + 1;
            }
            MultiDex.expandFieldArray(obj, "dexElements", makeDexElements);
            if (arrayList.size() > 0) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    IOException iOException = (IOException) it.next();
                }
                Field findField2 = MultiDex.findField(obj, "dexElementsSuppressedExceptions");
                IOException[] iOExceptionArr2 = (IOException[]) findField2.get(obj);
                if (iOExceptionArr2 == null) {
                    iOExceptionArr = (IOException[]) arrayList.toArray(new IOException[arrayList.size()]);
                } else {
                    iOExceptionArr = new IOException[arrayList.size() + iOExceptionArr2.length];
                    arrayList.toArray(iOExceptionArr);
                    System.arraycopy(iOExceptionArr2, 0, iOExceptionArr, arrayList.size(), iOExceptionArr2.length);
                }
                findField2.set(obj, iOExceptionArr);
            }
            MultiDex.hasInjected = 1;
            return arrayList2;
        }

        private static Object[] makeDexElements(Object obj, ArrayList<File> arrayList, File file, ArrayList<IOException> arrayList2) {
            try {
                try {
                    try {
                        try {
                            try {
                                return (Object[]) MultiDex.findMethod(obj, "makeDexElements", ArrayList.class, File.class).invoke(obj, arrayList, file);
                            } catch (IllegalArgumentException e) {
                                e.printStackTrace();
                                return null;
                            }
                        } catch (IllegalAccessException e2) {
                            e2.printStackTrace();
                            return null;
                        }
                    } catch (InvocationTargetException e3) {
                        e3.printStackTrace();
                        return null;
                    }
                } catch (RuntimeException e4) {
                    e4.printStackTrace();
                    return null;
                }
            } catch (NoSuchMethodException e5) {
                try {
                    try {
                        try {
                            try {
                                return (Object[]) MultiDex.findMethod(obj, "makeDexElements", ArrayList.class, File.class, ArrayList.class).invoke(obj, arrayList, file, arrayList2);
                            } catch (IllegalAccessException e6) {
                                e6.printStackTrace();
                                e5.printStackTrace();
                                return null;
                            } catch (InvocationTargetException e7) {
                                e7.printStackTrace();
                                e5.printStackTrace();
                                return null;
                            }
                        } catch (RuntimeException e8) {
                            e8.printStackTrace();
                            e5.printStackTrace();
                            return null;
                        }
                    } catch (IllegalArgumentException e9) {
                        e9.printStackTrace();
                        e5.printStackTrace();
                        return null;
                    }
                } catch (NoSuchMethodException e10) {
                    try {
                        try {
                            return (Object[]) MultiDex.findMethod(obj, "makePathElements", List.class, File.class, List.class).invoke(obj, arrayList, file, arrayList2);
                        } catch (IllegalAccessException e11) {
                            e11.printStackTrace();
                            e10.printStackTrace();
                            e5.printStackTrace();
                            return null;
                        } catch (IllegalArgumentException e12) {
                            e12.printStackTrace();
                            e10.printStackTrace();
                            e5.printStackTrace();
                            return null;
                        } catch (InvocationTargetException e13) {
                            e13.printStackTrace();
                            e10.printStackTrace();
                            e5.printStackTrace();
                            return null;
                        }
                    } catch (NoSuchMethodException e14) {
                        e14.printStackTrace();
                    } catch (RuntimeException e15) {
                        e15.printStackTrace();
                    }
                }
            }
        }
    }

    /* loaded from: source-63640-dex2jar.jar:com/wrapper/proxyapplication/MultiDex$V4.class */
    private static final class V4 {
        private V4() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static ArrayList<Object> install(ClassLoader classLoader, Field field, List<File> list, File file) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, IOException {
            int size = list.size();
            StringBuilder sb = new StringBuilder((String) field.get(classLoader));
            String[] strArr = new String[size];
            File[] fileArr = new File[size];
            ZipFile[] zipFileArr = new ZipFile[size];
            DexFile[] dexFileArr = new DexFile[size];
            ArrayList<Object> arrayList = new ArrayList<>();
            ListIterator<File> listIterator = list.listIterator();
            while (listIterator.hasNext()) {
                File next = listIterator.next();
                String absolutePath = next.getAbsolutePath();
                String absolutePath2 = file.getAbsolutePath();
                String str = MultiDex.getprefixname(absolutePath);
                sb.append(':');
                sb.append(absolutePath);
                int previousIndex = listIterator.previousIndex();
                strArr[previousIndex] = absolutePath;
                fileArr[previousIndex] = next;
                zipFileArr[previousIndex] = new ZipFile(next);
                dexFileArr[previousIndex] = DexFile.loadDex(absolutePath, absolutePath2 + BridgeUtil.SPLIT_MARK + str + ".dex", 0);
                arrayList.add(Integer.valueOf(MultiDex.findField(dexFileArr[previousIndex], "mCookie").getInt(dexFileArr[previousIndex])));
            }
            field.set(classLoader, sb.toString());
            MultiDex.expandFieldArray(classLoader, "mPaths", strArr);
            MultiDex.expandFieldArray(classLoader, "mFiles", fileArr);
            MultiDex.expandFieldArray(classLoader, "mZips", zipFileArr);
            MultiDex.expandFieldArray(classLoader, "mDexs", dexFileArr);
            if (arrayList.size() == 0) {
                return null;
            }
            MultiDex.hasInjected = 1;
            return arrayList;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static ArrayList<Object> install(ClassLoader classLoader, Field field, List<File> list, File file, int i) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, IOException {
            int size = list.size();
            StringBuilder sb = new StringBuilder((String) field.get(classLoader));
            String[] strArr = new String[size];
            File[] fileArr = new File[size];
            ZipFile[] zipFileArr = new ZipFile[size];
            DexFile[] dexFileArr = new DexFile[size];
            ArrayList<Object> arrayList = new ArrayList<>();
            ListIterator<File> listIterator = list.listIterator();
            while (listIterator.hasNext()) {
                File next = listIterator.next();
                String absolutePath = next.getAbsolutePath();
                String absolutePath2 = file.getAbsolutePath();
                String str = MultiDex.getprefixname(absolutePath);
                sb.append(':');
                sb.append(absolutePath);
                int previousIndex = listIterator.previousIndex();
                strArr[previousIndex] = absolutePath;
                fileArr[previousIndex] = next;
                zipFileArr[previousIndex] = new ZipFile(next);
                dexFileArr[previousIndex] = DexFile.loadDex(absolutePath, absolutePath2 + BridgeUtil.SPLIT_MARK + str + ".dex", 0);
                arrayList.add(Integer.valueOf(MultiDex.findField(dexFileArr[previousIndex], "mCookie").getInt(dexFileArr[previousIndex])));
            }
            field.set(classLoader, sb.toString());
            MultiDex.expandFieldArray(classLoader, "mPaths", strArr, i);
            MultiDex.expandFieldArray(classLoader, "mFiles", fileArr, i);
            MultiDex.expandFieldArray(classLoader, "mZips", zipFileArr, i);
            MultiDex.expandFieldArray(classLoader, "mDexs", dexFileArr, i);
            if (arrayList.size() == 0) {
                return null;
            }
            return arrayList;
        }
    }

    private MultiDex() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void expandFieldArray(Object obj, String str, Object[] objArr) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        Field findField = findField(obj, str);
        Object[] objArr2 = (Object[]) findField.get(obj);
        Object[] objArr3 = (Object[]) Array.newInstance(objArr2.getClass().getComponentType(), objArr2.length + objArr.length);
        if (Build.VERSION.SDK_INT == 28 && hasInjected == 0 && objArr2.length > 1) {
            System.arraycopy(objArr2, 0, objArr3, 0, objArr2.length - 1);
            System.arraycopy(objArr, 0, objArr3, objArr2.length - 1, objArr.length);
            System.arraycopy(objArr2, objArr2.length - 1, objArr3, (objArr.length + objArr2.length) - 1, 1);
        } else {
            System.arraycopy(objArr, 0, objArr3, 0, objArr.length);
            System.arraycopy(objArr2, 0, objArr3, objArr.length, objArr2.length);
        }
        findField.set(obj, objArr3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void expandFieldArray(Object obj, String str, Object[] objArr, int i) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        if (str.equals("dexElements")) {
            System.arraycopy(objArr, 0, injectPathListObj, injectDexBeginIndex + i, objArr.length);
        } else if (str.equals("mPaths")) {
            System.arraycopy(objArr, 0, injectPathsObj, injectDexBeginIndex + i, objArr.length);
        } else if (str.equals("mFiles")) {
            System.arraycopy(objArr, 0, injectFilesObj, injectDexBeginIndex + i, objArr.length);
        } else if (str.equals("mDexs")) {
            System.arraycopy(objArr, 0, injectDexsObj, injectDexBeginIndex + i, objArr.length);
        } else if (str.equals("mZips")) {
            System.arraycopy(objArr, 0, injectZipsObj, injectDexBeginIndex + i, objArr.length);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Field findField(Object obj, String str) throws NoSuchFieldException {
        Field declaredField;
        Class<?> cls = obj.getClass();
        while (true) {
            Class<?> cls2 = cls;
            if (cls2 == null) {
                throw new NoSuchFieldException("Field " + str + " not found in " + obj.getClass());
            }
            try {
                declaredField = cls2.getDeclaredField(str);
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                    break;
                }
                break;
            } catch (NoSuchFieldException e) {
                cls = cls2.getSuperclass();
            }
        }
        return declaredField;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Method findMethod(Object obj, String str, Class<?>... clsArr) throws NoSuchMethodException {
        Method declaredMethod;
        Class<?> cls = obj.getClass();
        while (true) {
            Class<?> cls2 = cls;
            if (cls2 == null) {
                throw new NoSuchMethodException("Method " + str + " with parameters " + Arrays.asList(clsArr) + " not found in " + obj.getClass());
            }
            try {
                declaredMethod = cls2.getDeclaredMethod(str, clsArr);
                if (!declaredMethod.isAccessible()) {
                    declaredMethod.setAccessible(true);
                    break;
                }
                break;
            } catch (NoSuchMethodException e) {
                cls = cls2.getSuperclass();
            }
        }
        return declaredMethod;
    }

    private static Method findMethodinClazz(Class<?> cls, String str, Class<?>... clsArr) throws NoSuchMethodException {
        while (cls != null) {
            try {
                Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
                if (!declaredMethod.isAccessible()) {
                    declaredMethod.setAccessible(true);
                }
                return declaredMethod;
            } catch (NoSuchMethodException e) {
                cls = cls.getSuperclass();
            }
        }
        throw new NoSuchMethodException("Method " + str + " with parameters " + Arrays.asList(clsArr) + " not found in " + cls);
    }

    private static void finishinstallDexes(ClassLoader classLoader) {
        try {
            try {
                Object obj = findField(classLoader, "pathList").get(classLoader);
                Field findField = findField(obj, "dexElements");
                hasInjected = 1;
                findField.set(obj, injectPathListObj);
                if (dexElementsSuppressedExceptions != null) {
                    findField(obj, "dexElementsSuppressedExceptions").set(obj, dexElementsSuppressedExceptions);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (IllegalArgumentException e2) {
                e2.printStackTrace();
            }
        } catch (NoSuchFieldException e3) {
            try {
                try {
                    Object obj2 = findField(classLoader, "path").get(classLoader);
                    findField(obj2, "mPaths").set(obj2, injectPathsObj);
                    findField(obj2, "mFiles").set(obj2, injectFilesObj);
                    findField(obj2, "mZips").set(obj2, injectZipsObj);
                    findField(obj2, "mDexs").set(obj2, injectDexsObj);
                    hasInjected = 1;
                } catch (IllegalAccessException e4) {
                    e4.printStackTrace();
                } catch (IllegalArgumentException e5) {
                    e5.printStackTrace();
                }
            } catch (NoSuchFieldException e6) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getprefixname(String str) {
        int lastIndexOf = str.lastIndexOf(BridgeUtil.SPLIT_MARK);
        String str2 = str;
        if (lastIndexOf >= 0) {
            str2 = str.substring(lastIndexOf + 1);
        }
        int lastIndexOf2 = str2.lastIndexOf(".");
        String str3 = str2;
        if (lastIndexOf2 >= 0) {
            str3 = str2.substring(0, lastIndexOf2);
        }
        return str3;
    }

    private static ArrayList<Object> installDexes(ClassLoader classLoader, String str, String str2, int i, boolean z, boolean z2) {
        ArrayList<File> splitPaths = splitPaths(str);
        File file = new File(str2);
        try {
            try {
                try {
                    try {
                        return V19.install(classLoader, findField(classLoader, "pathList"), splitPaths, file, i, z, z2);
                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                        return null;
                    } catch (InvocationTargetException e2) {
                        e2.printStackTrace();
                        return null;
                    }
                } catch (IllegalArgumentException e3) {
                    e3.printStackTrace();
                    return null;
                }
            } catch (IllegalAccessException e4) {
                e4.printStackTrace();
                return null;
            }
        } catch (NoSuchFieldException e5) {
            try {
                try {
                    return V4.install(classLoader, findField(classLoader, "path"), splitPaths, file, i);
                } catch (IOException e6) {
                    e6.printStackTrace();
                    return null;
                } catch (IllegalAccessException e7) {
                    e7.printStackTrace();
                    return null;
                } catch (IllegalArgumentException e8) {
                    e8.printStackTrace();
                    return null;
                }
            } catch (NoSuchFieldException e9) {
                return null;
            }
        }
    }

    private static ArrayList<Object> installDexes(ClassLoader classLoader, String str, String str2, boolean z, boolean z2) {
        ArrayList<File> splitPaths = splitPaths(str);
        File file = new File(str2);
        try {
            try {
                try {
                    try {
                        return V19.install(classLoader, findField(classLoader, "pathList"), splitPaths, file, z, z2);
                    } catch (IllegalArgumentException e) {
                        e.printStackTrace();
                        return null;
                    } catch (InvocationTargetException e2) {
                        e2.printStackTrace();
                        return null;
                    }
                } catch (NoSuchMethodException e3) {
                    e3.printStackTrace();
                    return null;
                }
            } catch (IllegalAccessException e4) {
                e4.printStackTrace();
                return null;
            }
        } catch (NoSuchFieldException e5) {
            try {
                try {
                    try {
                        try {
                            return V4.install(classLoader, findField(classLoader, "path"), splitPaths, file);
                        } catch (IllegalAccessException e6) {
                            e6.printStackTrace();
                            return null;
                        }
                    } catch (IOException e7) {
                        e7.printStackTrace();
                        return null;
                    }
                } catch (IllegalArgumentException e8) {
                    e8.printStackTrace();
                    return null;
                }
            } catch (NoSuchFieldException e9) {
                return null;
            }
        }
    }

    private static ArrayList<Object> openallDexes(ClassLoader classLoader, String str, String str2) {
        ArrayList<Object> arrayList;
        NoSuchFieldException e;
        NoSuchMethodException e2;
        InvocationTargetException e3;
        ArrayList<File> splitPaths = splitPaths(str);
        File file = new File(str2);
        try {
            ArrayList<Object> arrayList2 = null;
            ArrayList<Object> arrayList3 = null;
            try {
                Object obj = findField(classLoader, "pathList").get(classLoader);
                ArrayList<Object> arrayList4 = null;
                try {
                    Method findMethod = findMethod(obj, "loadDexFile", File.class, File.class);
                    try {
                        arrayList = new ArrayList<>();
                        try {
                            Iterator<File> it = splitPaths.iterator();
                            while (it.hasNext()) {
                                arrayList.add(findMethod.invoke(obj, it.next(), file));
                            }
                            return arrayList;
                        } catch (IllegalAccessException e4) {
                            arrayList3 = arrayList;
                            e = e4;
                            e.printStackTrace();
                            return arrayList3;
                        } catch (IllegalArgumentException e5) {
                            arrayList2 = arrayList;
                            e = e5;
                            e.printStackTrace();
                            return arrayList2;
                        } catch (NoSuchFieldException e6) {
                            e = e6;
                            e.printStackTrace();
                            return arrayList;
                        } catch (NoSuchMethodException e7) {
                            e2 = e7;
                            arrayList2 = arrayList;
                            arrayList3 = arrayList;
                            e2.printStackTrace();
                            return arrayList;
                        } catch (InvocationTargetException e8) {
                            e3 = e8;
                            arrayList4 = arrayList;
                            e3.printStackTrace();
                            return arrayList;
                        }
                    } catch (InvocationTargetException e9) {
                        arrayList = null;
                        e3 = e9;
                    }
                } catch (NoSuchMethodException e10) {
                    arrayList = arrayList4;
                    e2 = e10;
                }
            } catch (IllegalAccessException e11) {
                e = e11;
            } catch (IllegalArgumentException e12) {
                e = e12;
            }
        } catch (NoSuchFieldException e13) {
            arrayList = null;
            e = e13;
        }
    }

    private static void prepareexpandFieldArray(Object obj, String str, int i) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        Object[] objArr = (Object[]) findField(obj, str).get(obj);
        Object[] objArr2 = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), objArr.length + i);
        baseApkDexFile = objArr[objArr.length - 1];
        if (Build.VERSION.SDK_INT == 28 && hasInjected == 0 && objArr.length > 1) {
            System.arraycopy(objArr, 0, objArr2, 0, objArr.length - 1);
            injectDexBeginIndex = objArr.length - 1;
            System.arraycopy(objArr, objArr.length - 1, objArr2, (i + objArr.length) - 1, 1);
        } else {
            System.arraycopy(objArr, 0, objArr2, i, objArr.length);
        }
        if (str.equals("dexElements")) {
            injectPathListObj = objArr2;
        } else if (str.equals("mPaths")) {
            injectPathsObj = objArr2;
        } else if (str.equals("mFiles")) {
            injectFilesObj = objArr2;
        } else if (str.equals("mZips")) {
            injectZipsObj = objArr2;
        } else if (str.equals("mDexs")) {
            injectDexsObj = objArr2;
        }
    }

    private static void preparetoinstallDexes(ClassLoader classLoader, int i) {
        try {
            try {
                prepareexpandFieldArray(findField(classLoader, "pathList").get(classLoader), "dexElements", i);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (IllegalArgumentException e2) {
                e2.printStackTrace();
            }
        } catch (NoSuchFieldException e3) {
            try {
                findField(classLoader, "path");
                try {
                    prepareexpandFieldArray(classLoader, "mPaths", i);
                    prepareexpandFieldArray(classLoader, "mFiles", i);
                    prepareexpandFieldArray(classLoader, "mZips", i);
                    prepareexpandFieldArray(classLoader, "mDexs", i);
                } catch (IllegalAccessException e4) {
                    e4.printStackTrace();
                } catch (IllegalArgumentException e5) {
                    e5.printStackTrace();
                }
            } catch (NoSuchFieldException e6) {
            }
        }
    }

    private static ArrayList<File> splitPaths(String str) {
        ArrayList<File> arrayList = new ArrayList<>();
        if (str != null) {
            String[] split = str.split(File.pathSeparator);
            int length = split.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                arrayList.add(new File(split[i2]));
                i = i2 + 1;
            }
        }
        return arrayList;
    }
}
