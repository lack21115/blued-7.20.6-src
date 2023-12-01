package com.wrapper.proxyapplication;

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

/* loaded from: source-63640-dex2jar.jar:com/wrapper/proxyapplication/MultiDexForTinker.class */
public class MultiDexForTinker {
    static final String TAG = "MultiDexForTinker";
    static int hasInjected = 0;
    static int injectDexBeginIndex = 0;
    static Object[] injectPathListObj = null;
    static Object[] injectPathsObj = null;
    static Object[] injectFilesObj = null;
    static Object[] injectZipsObj = null;
    static Object[] injectDexsObj = null;
    static IOException[] dexElementsSuppressedExceptions = null;

    /* loaded from: source-63640-dex2jar.jar:com/wrapper/proxyapplication/MultiDexForTinker$V19.class */
    private static final class V19 {
        private V19() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static ArrayList<Object> install(ClassLoader classLoader, Field field, List<File> list, File file) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, IOException {
            IOException[] iOExceptionArr;
            Object obj = field.get(classLoader);
            ArrayList arrayList = new ArrayList();
            Object[] makeDexElements = makeDexElements(obj, new ArrayList(list), file, arrayList);
            if (makeDexElements.length != list.size()) {
                throw new IOException("load dex failed");
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
                Object obj3 = MultiDexForTinker.findField(obj2, "dexFile").get(obj2);
                Field findField = MultiDexForTinker.findField(obj3, "mCookie");
                if (findField.getType().getName().equals("int")) {
                    arrayList2.add(Integer.valueOf(findField.getInt(obj3)));
                } else if (findField.getType().getName().equals("long")) {
                    arrayList2.add(Long.valueOf(findField.getLong(obj3)));
                } else {
                    arrayList2.add(obj3);
                }
                i = i2 + 1;
            }
            MultiDexForTinker.expandFieldArray(obj, "dexElements", makeDexElements);
            if (arrayList.size() > 0) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    IOException iOException = (IOException) it.next();
                }
                Field findField2 = MultiDexForTinker.findField(obj, "dexElementsSuppressedExceptions");
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
            MultiDexForTinker.hasInjected = 1;
            return arrayList2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static ArrayList<Object> install(ClassLoader classLoader, Field field, List<File> list, File file, int i) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, IOException {
            Object obj = field.get(classLoader);
            ArrayList arrayList = new ArrayList();
            Object[] makeDexElements = makeDexElements(obj, new ArrayList(list), file, arrayList);
            if (makeDexElements.length != list.size()) {
                throw new IOException("load dex failed");
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
                Object obj3 = MultiDexForTinker.findField(obj2, "dexFile").get(obj2);
                Field findField = MultiDexForTinker.findField(obj3, "mCookie");
                if (findField.getType().getName().equals("int")) {
                    arrayList2.add(Integer.valueOf(findField.getInt(obj3)));
                } else if (findField.getType().getName().equals("long")) {
                    arrayList2.add(Long.valueOf(findField.getLong(obj3)));
                } else {
                    arrayList2.add(obj3);
                }
                i2 = i3 + 1;
            }
            MultiDexForTinker.expandFieldArray(obj, "dexElements", makeDexElements, i);
            if (arrayList.size() > 0) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    IOException iOException = (IOException) it.next();
                }
                MultiDexForTinker.dexElementsSuppressedExceptions = (IOException[]) MultiDexForTinker.findField(obj, "dexElementsSuppressedExceptions").get(obj);
                if (MultiDexForTinker.dexElementsSuppressedExceptions == null) {
                    MultiDexForTinker.dexElementsSuppressedExceptions = (IOException[]) arrayList.toArray(new IOException[arrayList.size()]);
                } else {
                    IOException[] iOExceptionArr = new IOException[arrayList.size() + MultiDexForTinker.dexElementsSuppressedExceptions.length];
                    arrayList.toArray(iOExceptionArr);
                    System.arraycopy(MultiDexForTinker.dexElementsSuppressedExceptions, 0, iOExceptionArr, arrayList.size(), MultiDexForTinker.dexElementsSuppressedExceptions.length);
                    MultiDexForTinker.dexElementsSuppressedExceptions = iOExceptionArr;
                }
            }
            MultiDexForTinker.hasInjected = 1;
            return arrayList2;
        }

        private static Object[] makeDexElements(Object obj, ArrayList<File> arrayList, File file, ArrayList<IOException> arrayList2) {
            try {
                try {
                    try {
                        return (Object[]) MultiDexForTinker.findMethod(obj, "makeDexElements", ArrayList.class, File.class).invoke(obj, arrayList, file);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                        return null;
                    } catch (RuntimeException e2) {
                        e2.printStackTrace();
                        return null;
                    }
                } catch (IllegalArgumentException e3) {
                    e3.printStackTrace();
                    return null;
                } catch (InvocationTargetException e4) {
                    e4.printStackTrace();
                    return null;
                }
            } catch (NoSuchMethodException e5) {
                try {
                    try {
                        try {
                            return (Object[]) MultiDexForTinker.findMethod(obj, "makeDexElements", ArrayList.class, File.class, ArrayList.class).invoke(obj, arrayList, file, arrayList2);
                        } catch (IllegalAccessException e6) {
                            e6.printStackTrace();
                            e5.printStackTrace();
                            return null;
                        } catch (IllegalArgumentException e7) {
                            e7.printStackTrace();
                            e5.printStackTrace();
                            return null;
                        }
                    } catch (RuntimeException e8) {
                        e8.printStackTrace();
                        e5.printStackTrace();
                        return null;
                    } catch (InvocationTargetException e9) {
                        e9.printStackTrace();
                        e5.printStackTrace();
                        return null;
                    }
                } catch (NoSuchMethodException e10) {
                    try {
                        try {
                            try {
                                return (Object[]) MultiDexForTinker.findMethod(obj, "makePathElements", List.class, File.class, List.class).invoke(obj, arrayList, file, arrayList2);
                            } catch (IllegalAccessException e11) {
                                e11.printStackTrace();
                                e10.printStackTrace();
                                e5.printStackTrace();
                                return null;
                            } catch (InvocationTargetException e12) {
                                e12.printStackTrace();
                                e10.printStackTrace();
                                e5.printStackTrace();
                                return null;
                            }
                        } catch (IllegalArgumentException e13) {
                            e13.printStackTrace();
                            e10.printStackTrace();
                            e5.printStackTrace();
                            return null;
                        }
                    } catch (NoSuchMethodException e14) {
                        e14.printStackTrace();
                    }
                }
            }
        }
    }

    /* loaded from: source-63640-dex2jar.jar:com/wrapper/proxyapplication/MultiDexForTinker$V4.class */
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
            if (dexFileArr.length != size) {
                throw new IOException("load dex failed");
            }
            ArrayList<Object> arrayList = new ArrayList<>();
            ListIterator<File> listIterator = list.listIterator();
            while (listIterator.hasNext()) {
                File next = listIterator.next();
                String absolutePath = next.getAbsolutePath();
                String absolutePath2 = file.getAbsolutePath();
                String str = MultiDexForTinker.getprefixname(absolutePath);
                sb.append(':').append(absolutePath);
                int previousIndex = listIterator.previousIndex();
                strArr[previousIndex] = absolutePath;
                fileArr[previousIndex] = next;
                zipFileArr[previousIndex] = new ZipFile(next);
                dexFileArr[previousIndex] = DexFile.loadDex(absolutePath, String.valueOf(absolutePath2) + BridgeUtil.SPLIT_MARK + str + ".dex", 0);
                arrayList.add(Integer.valueOf(MultiDexForTinker.findField(dexFileArr[previousIndex], "mCookie").getInt(dexFileArr[previousIndex])));
            }
            field.set(classLoader, sb.toString());
            MultiDexForTinker.expandFieldArray(classLoader, "mPaths", strArr);
            MultiDexForTinker.expandFieldArray(classLoader, "mFiles", fileArr);
            MultiDexForTinker.expandFieldArray(classLoader, "mZips", zipFileArr);
            MultiDexForTinker.expandFieldArray(classLoader, "mDexs", dexFileArr);
            MultiDexForTinker.hasInjected = 1;
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
            if (dexFileArr.length != size) {
                throw new IOException("load dex failed");
            }
            ArrayList<Object> arrayList = new ArrayList<>();
            ListIterator<File> listIterator = list.listIterator();
            while (listIterator.hasNext()) {
                File next = listIterator.next();
                String absolutePath = next.getAbsolutePath();
                String absolutePath2 = file.getAbsolutePath();
                String str = MultiDexForTinker.getprefixname(absolutePath);
                sb.append(':').append(absolutePath);
                int previousIndex = listIterator.previousIndex();
                strArr[previousIndex] = absolutePath;
                fileArr[previousIndex] = next;
                zipFileArr[previousIndex] = new ZipFile(next);
                dexFileArr[previousIndex] = DexFile.loadDex(absolutePath, String.valueOf(absolutePath2) + BridgeUtil.SPLIT_MARK + str + ".dex", 0);
                arrayList.add(Integer.valueOf(MultiDexForTinker.findField(dexFileArr[previousIndex], "mCookie").getInt(dexFileArr[previousIndex])));
            }
            field.set(classLoader, sb.toString());
            MultiDexForTinker.expandFieldArray(classLoader, "mPaths", strArr, i);
            MultiDexForTinker.expandFieldArray(classLoader, "mFiles", fileArr, i);
            MultiDexForTinker.expandFieldArray(classLoader, "mZips", zipFileArr, i);
            MultiDexForTinker.expandFieldArray(classLoader, "mDexs", dexFileArr, i);
            MultiDexForTinker.hasInjected = 1;
            ArrayList<Object> arrayList2 = arrayList;
            if (arrayList.size() == 0) {
                arrayList2 = null;
            }
            return arrayList2;
        }
    }

    private MultiDexForTinker() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void expandFieldArray(Object obj, String str, Object[] objArr) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        Field findField = findField(obj, str);
        Object[] objArr2 = (Object[]) findField.get(obj);
        Object[] objArr3 = (Object[]) Array.newInstance(objArr2.getClass().getComponentType(), objArr2.length + objArr.length);
        System.arraycopy(objArr2, 0, objArr3, 0, objArr2.length);
        System.arraycopy(objArr, 0, objArr3, objArr2.length, objArr.length);
        findField.set(obj, objArr3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void expandFieldArray(Object obj, String str, Object[] objArr, int i) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        findField(obj, str);
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
                findField(obj, "dexElements").set(obj, injectPathListObj);
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
        if (lastIndexOf >= 0) {
            str = str.substring(lastIndexOf + 1);
        }
        int lastIndexOf2 = str.lastIndexOf(".");
        return lastIndexOf2 >= 0 ? str.substring(0, lastIndexOf2) : str;
    }

    private static ArrayList<Object> installDexes(ClassLoader classLoader, String str, String str2) throws IOException {
        ArrayList<File> splitPaths = splitPaths(str);
        File file = new File(str2);
        try {
            try {
                try {
                    try {
                        return V19.install(classLoader, findField(classLoader, "pathList"), splitPaths, file);
                    } catch (IOException e) {
                        throw new IOException("v19,load dex fail");
                    } catch (InvocationTargetException e2) {
                        e2.printStackTrace();
                        return null;
                    }
                } catch (IllegalArgumentException e3) {
                    e3.printStackTrace();
                    return null;
                } catch (NoSuchMethodException e4) {
                    e4.printStackTrace();
                    return null;
                }
            } catch (IllegalAccessException e5) {
                e5.printStackTrace();
                return null;
            }
        } catch (NoSuchFieldException e6) {
            try {
                try {
                    return V4.install(classLoader, findField(classLoader, "path"), splitPaths, file);
                } catch (IOException e7) {
                    throw new IOException("v4, load dex fail");
                } catch (IllegalAccessException e8) {
                    e8.printStackTrace();
                    return null;
                } catch (IllegalArgumentException e9) {
                    e9.printStackTrace();
                    return null;
                }
            } catch (NoSuchFieldException e10) {
                return null;
            }
        }
    }

    private static ArrayList<Object> installDexes(ClassLoader classLoader, String str, String str2, int i) throws IOException {
        ArrayList<File> splitPaths = splitPaths(str);
        File file = new File(str2);
        try {
            try {
                try {
                    try {
                        try {
                            return V19.install(classLoader, findField(classLoader, "pathList"), splitPaths, file, i);
                        } catch (IllegalArgumentException e) {
                            e.printStackTrace();
                            return null;
                        } catch (NoSuchMethodException e2) {
                            e2.printStackTrace();
                            return null;
                        }
                    } catch (InvocationTargetException e3) {
                        e3.printStackTrace();
                        return null;
                    }
                } catch (IllegalAccessException e4) {
                    e4.printStackTrace();
                    return null;
                }
            } catch (IOException e5) {
                throw new IOException("v19,load dex fail");
            }
        } catch (NoSuchFieldException e6) {
            try {
                try {
                    try {
                        return V4.install(classLoader, findField(classLoader, "path"), splitPaths, file, i);
                    } catch (IOException e7) {
                        throw new IOException("v4, load dex fail");
                    } catch (IllegalArgumentException e8) {
                        e8.printStackTrace();
                        return null;
                    }
                } catch (IllegalAccessException e9) {
                    e9.printStackTrace();
                    return null;
                }
            } catch (NoSuchFieldException e10) {
                return null;
            }
        }
    }

    private static ArrayList<Object> openallDexes(ClassLoader classLoader, String str, String str2) {
        ArrayList<Object> arrayList;
        NoSuchMethodException e;
        ArrayList<File> splitPaths = splitPaths(str);
        File file = new File(str2);
        ArrayList<Object> arrayList2 = null;
        try {
            ArrayList<Object> arrayList3 = null;
            ArrayList<Object> arrayList4 = null;
            try {
                Object obj = findField(classLoader, "pathList").get(classLoader);
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
                        } catch (IllegalAccessException e2) {
                            arrayList3 = arrayList;
                            e = e2;
                            e.printStackTrace();
                            return arrayList3;
                        } catch (IllegalArgumentException e3) {
                            arrayList4 = arrayList;
                            e = e3;
                            e.printStackTrace();
                            return arrayList4;
                        } catch (NoSuchFieldException e4) {
                            arrayList2 = arrayList;
                            e = e4;
                            e.printStackTrace();
                            return arrayList2;
                        } catch (NoSuchMethodException e5) {
                            e = e5;
                            e.printStackTrace();
                            return arrayList;
                        } catch (InvocationTargetException e6) {
                            e = e6;
                            e.printStackTrace();
                            return arrayList;
                        }
                    } catch (InvocationTargetException e7) {
                        e = e7;
                        arrayList = null;
                    }
                } catch (NoSuchMethodException e8) {
                    arrayList = null;
                    e = e8;
                }
            } catch (IllegalAccessException e9) {
                e = e9;
            } catch (IllegalArgumentException e10) {
                e = e10;
            }
        } catch (NoSuchFieldException e11) {
            e = e11;
        }
    }

    private static void prepareexpandFieldArray(Object obj, String str, int i) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        Object[] objArr = (Object[]) findField(obj, str).get(obj);
        Object[] objArr2 = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), objArr.length + i);
        System.arraycopy(objArr, 0, objArr2, 0, objArr.length);
        injectDexBeginIndex = objArr.length;
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

    private static void preparetoinstallDexes(ClassLoader classLoader, int i) throws IOException {
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
