package com.bun.miitmdid.core;

import android.content.Context;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: source-7206380-dex2jar.jar:com/bun/miitmdid/core/JLibrary.class */
public class JLibrary {
    public static ClassLoader classLoader;
    public static Context context;
    public static String o00o0a0odod;
    public static String o00o0a0odou;
    public static final String TAG = JLibrary.class.getSimpleName();
    public static String ASSET = "assets/";
    public static String xdata = ".00000000000";
    public static String ydata = ".11111111111";
    public static String SeriailizationString = "stub_liu_0_dex_so:39285EFA@com/jdog;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;";

    /* loaded from: source-7206380-dex2jar.jar:com/bun/miitmdid/core/JLibrary$ReturnStatus.class */
    enum ReturnStatus {
        RETURN_OK,
        RETURN_ERR;

        /* renamed from: values  reason: to resolve conflict with enum method */
        public static ReturnStatus[] valuesCustom() {
            ReturnStatus[] valuesCustom = values();
            int length = valuesCustom.length;
            ReturnStatus[] returnStatusArr = new ReturnStatus[length];
            System.arraycopy(valuesCustom, 0, returnStatusArr, 0, length);
            return returnStatusArr;
        }
    }

    public static ReturnStatus InitEntry(Context context2) throws Exception {
        if (context2 != null) {
            context = context2;
            classLoader = JLibrary.class.getClassLoader();
            String str = SeriailizationString;
            System.loadLibrary(str.substring(str.lastIndexOf(58) + 1, SeriailizationString.indexOf(64)));
            a();
            return ReturnStatus.RETURN_OK;
        }
        throw new ExceptionInInitializerError("pass InitEntry arg(context) is null");
    }

    public static ByteBuffer ReadByteBuffer(String str) {
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            ByteBuffer allocate = ByteBuffer.allocate(fileInputStream.available());
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= fileInputStream.available()) {
                    fileInputStream.close();
                    return allocate;
                }
                i = i2 + fileInputStream.read(allocate.array(), i2, fileInputStream.available() - i2);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static native boolean a();

    public static Object[] o0o0o0o0o0(Object obj, String str, String str2, List<IOException> list) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException {
        String[] split = str.split(";");
        ArrayList arrayList = new ArrayList();
        int length = split.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return (Object[]) o0o0o0o0o0o0(obj, str2, ByteBuffer[].class, List.class).invoke(obj, arrayList.toArray(new ByteBuffer[arrayList.size()]), list);
            }
            arrayList.add(ReadByteBuffer(split[i2]));
            i = i2 + 1;
        }
    }

    private static Method o0o0o0o0o0o0(Object obj, String str, Class<?>... clsArr) throws NoSuchMethodException {
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

    public static void o0oo0o0(Context context2, String str) throws Exception {
        int i;
        try {
            InputStream open = context2.getAssets().open(str);
            o00o0a0odod = Utils.getXdataDir(context2, "");
            o00o0a0odou = Utils.getYdataDir(context2, "");
            File file = new File(o00o0a0odod);
            File file2 = new File(o00o0a0odou);
            int i2 = 3;
            if (!file.exists()) {
                int i3 = 3;
                while (true) {
                    int i4 = i3;
                    int i5 = i4 - 1;
                    if (i4 > 0) {
                        i = i5;
                        if (file.mkdir()) {
                            break;
                        }
                        i3 = i5;
                    } else {
                        i = i5;
                        break;
                    }
                }
            } else {
                i = 3;
            }
            if (i == -1) {
                throw new IllegalStateException("User dir cannot be created: " + file.getAbsolutePath());
            }
            int i6 = 3;
            if (!file2.exists()) {
                while (true) {
                    i6 = i2 - 1;
                    if (i2 <= 0 || file2.mkdir()) {
                        break;
                    }
                    i2 = i6;
                }
            }
            if (i6 == -1) {
                throw new IllegalStateException("User dir cannot be created: " + file2.getAbsolutePath());
            }
            if (!Utils.update(context2)) {
                if (new File(String.valueOf(o00o0a0odod) + str).exists()) {
                    return;
                }
            }
            Utils.x0xooXdata(open, String.valueOf(o00o0a0odod) + str, context2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
