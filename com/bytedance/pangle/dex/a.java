package com.bytedance.pangle.dex;

import com.bytedance.pangle.d.c;
import com.bytedance.pangle.e.b;
import com.bytedance.pangle.e.g;
import com.bytedance.pangle.util.FieldUtils;
import dalvik.system.DexFile;
import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayList;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/pangle/dex/a.class */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static volatile int f7771a;
    private static volatile Constructor<?> b;

    /* JADX WARN: Removed duplicated region for block: B:28:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0097 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0062 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0026 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00cc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.Object a(java.io.File r6, java.lang.Object r7) {
        /*
            Method dump skipped, instructions count: 359
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.dex.a.a(java.io.File, java.lang.Object):java.lang.Object");
    }

    private static Object a(Constructor<?> constructor, Object... objArr) {
        try {
            return constructor.newInstance(objArr);
        } catch (Exception e) {
            return null;
        }
    }

    public static void a(ClassLoader classLoader, String str, int i) {
        Object obj = FieldUtils.getField(classLoader.getClass(), "pathList").get(classLoader);
        ArrayList arrayList = new ArrayList();
        String[] split = g.a(str, i).split(":");
        String c2 = c.c(str, i);
        int length = split.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                Object[] array = arrayList.toArray();
                Field field = FieldUtils.getField(obj.getClass(), "dexElements");
                Object[] objArr = (Object[]) field.get(obj);
                Object[] objArr2 = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), objArr.length + array.length);
                System.arraycopy(objArr, 0, objArr2, 0, objArr.length);
                System.arraycopy(array, 0, objArr2, objArr.length, array.length);
                field.set(obj, objArr2);
                return;
            }
            String str2 = split[i3];
            Object native_load_direct_dex = DirectDex.native_load_direct_dex(str2);
            DexFile dexFile = native_load_direct_dex;
            if (native_load_direct_dex == null) {
                dexFile = DexFile.loadDex(str2, c2 + File.separator + b.a(str2), 0);
            }
            arrayList.add(a(new File(str2), dexFile));
            i2 = i3 + 1;
        }
    }
}
