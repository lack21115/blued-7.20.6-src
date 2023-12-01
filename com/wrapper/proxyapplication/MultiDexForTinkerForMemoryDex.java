package com.wrapper.proxyapplication;

import android.os.Build;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-63640-dex2jar.jar:com/wrapper/proxyapplication/MultiDexForTinkerForMemoryDex.class */
public class MultiDexForTinkerForMemoryDex {
    static final String TAG = "MultiDexForTinkerForMemoryDex";
    static int hasInjected;

    /* loaded from: source-63640-dex2jar.jar:com/wrapper/proxyapplication/MultiDexForTinkerForMemoryDex$V26.class */
    private static final class V26 {
        private V26() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void install(ClassLoader classLoader, Field field, ByteBuffer[] byteBufferArr) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, IOException {
            IOException[] iOExceptionArr;
            Object obj = field.get(classLoader);
            ArrayList arrayList = new ArrayList();
            Object[] makeDexElements = makeDexElements(obj, byteBufferArr, arrayList);
            if (makeDexElements.length != byteBufferArr.length) {
                throw new IOException("load dex failed");
            }
            MultiDexForTinkerForMemoryDex.expandFieldArray(obj, "dexElements", makeDexElements);
            if (arrayList.size() > 0) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    IOException iOException = (IOException) it.next();
                }
                Field findField = MultiDexForTinkerForMemoryDex.findField(obj, "dexElementsSuppressedExceptions");
                IOException[] iOExceptionArr2 = (IOException[]) findField.get(obj);
                if (iOExceptionArr2 == null) {
                    iOExceptionArr = (IOException[]) arrayList.toArray(new IOException[arrayList.size()]);
                } else {
                    iOExceptionArr = new IOException[arrayList.size() + iOExceptionArr2.length];
                    arrayList.toArray(iOExceptionArr);
                    System.arraycopy(iOExceptionArr2, 0, iOExceptionArr, arrayList.size(), iOExceptionArr2.length);
                }
                findField.set(obj, iOExceptionArr);
            }
            MultiDexForTinkerForMemoryDex.hasInjected = 1;
        }

        private static Object[] makeDexElements(Object obj, ByteBuffer[] byteBufferArr, ArrayList<IOException> arrayList) {
            try {
                try {
                    try {
                        try {
                            return (Object[]) MultiDexForTinkerForMemoryDex.findMethod(obj, "makeInMemoryDexElements", ByteBuffer[].class, List.class).invoke(obj, byteBufferArr, arrayList);
                        } catch (IllegalArgumentException e) {
                            e.printStackTrace();
                            return null;
                        } catch (RuntimeException e2) {
                            e2.printStackTrace();
                            return null;
                        }
                    } catch (IllegalAccessException e3) {
                        e3.printStackTrace();
                        return null;
                    }
                } catch (InvocationTargetException e4) {
                    e4.printStackTrace();
                    return null;
                }
            } catch (NoSuchMethodException e5) {
                e5.printStackTrace();
                return null;
            }
        }
    }

    private MultiDexForTinkerForMemoryDex() {
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

    private static String getprefixname(String str) {
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

    private static void installDexes(ClassLoader classLoader, ByteBuffer[] byteBufferArr) throws IOException {
        try {
            try {
                try {
                    try {
                        V26.install(classLoader, findField(classLoader, "pathList"), byteBufferArr);
                    } catch (IOException e) {
                        throw new IOException("v26,load dex fail");
                    } catch (IllegalArgumentException e2) {
                        e2.printStackTrace();
                    }
                } catch (IllegalAccessException e3) {
                    e3.printStackTrace();
                } catch (NoSuchMethodException e4) {
                    e4.printStackTrace();
                }
            } catch (InvocationTargetException e5) {
                e5.printStackTrace();
            }
        } catch (NoSuchFieldException e6) {
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
