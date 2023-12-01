package com.tencent.mapsdk.internal;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.j256.ormlite.stmt.query.SimpleComparison;
import com.tencent.lbssearch.object.param.Geo2AddressParam;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static ClassLoader f37280a;
    private static boolean b = true;

    public static Object a(String str, boolean z, ClassLoader classLoader) throws b {
        Class<?> cls;
        if (str.equals("java.lang.Integer")) {
            return 0;
        }
        if (str.equals("java.lang.Boolean")) {
            return Boolean.FALSE;
        }
        if (str.equals("java.lang.Byte")) {
            return (byte) 0;
        }
        if (str.equals("java.lang.Double")) {
            return Double.valueOf(0.0d);
        }
        if (str.equals("java.lang.Float")) {
            return Float.valueOf(0.0f);
        }
        if (str.equals("java.lang.Long")) {
            return 0L;
        }
        if (str.equals("java.lang.Short")) {
            return (short) 0;
        }
        if (str.equals("java.lang.Character")) {
            throw new IllegalArgumentException("can not support java.lang.Character");
        }
        if (str.equals("java.lang.String")) {
            return "";
        }
        if (str.equals("java.util.List")) {
            return new ArrayList();
        }
        if (str.equals("java.util.Map")) {
            return new HashMap();
        }
        if (str.equals("Array")) {
            return "Array";
        }
        if (str.equals("?")) {
            return str;
        }
        try {
            if (classLoader != null) {
                cls = Class.forName(str, z, classLoader);
            } else {
                ClassLoader classLoader2 = f37280a;
                cls = classLoader2 != null ? Class.forName(str, b, classLoader2) : Class.forName(str);
            }
            return cls.getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception e) {
            e.printStackTrace();
            throw new b(e);
        }
    }

    public static String a(String str) {
        if (str.equals(IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL)) {
            return "Integer";
        }
        if (str.equals(TypedValues.Custom.S_BOOLEAN)) {
            return "Boolean";
        }
        if (str.equals("byte")) {
            return "Byte";
        }
        if (str.equals("double")) {
            return "Double";
        }
        if (str.equals(TypedValues.Custom.S_FLOAT)) {
            return "Float";
        }
        if (str.equals("long")) {
            return "Long";
        }
        if (str.equals(Geo2AddressParam.PoiOptions.ADDRESS_FORMAT_SHORT)) {
            return "Short";
        }
        String str2 = str;
        if (str.equals("char")) {
            str2 = "Character";
        }
        return str2;
    }

    public static String a(String str, String str2) {
        if (str2.equals(IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL)) {
            return str2 + " " + str + "=0 ;\n";
        } else if (str2.equals(TypedValues.Custom.S_BOOLEAN)) {
            return str2 + " " + str + "=false ;\n";
        } else if (str2.equals("byte")) {
            return str2 + " " + str + " ;\n";
        } else if (str2.equals("double")) {
            return str2 + " " + str + "=0 ;\n";
        } else if (str2.equals(TypedValues.Custom.S_FLOAT)) {
            return str2 + " " + str + "=0 ;\n";
        } else if (str2.equals("long")) {
            return str2 + " " + str + "=0 ;\n";
        } else if (str2.equals(Geo2AddressParam.PoiOptions.ADDRESS_FORMAT_SHORT)) {
            return str2 + " " + str + "=0 ;\n";
        } else if (str2.equals("char")) {
            return str2 + " " + str + " ;\n";
        } else {
            return str2 + " " + str + " = null ;\n";
        }
    }

    public static String a(ArrayList<String> arrayList) {
        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= arrayList.size()) {
                break;
            }
            arrayList.set(i2, d(arrayList.get(i2)));
            i = i2 + 1;
        }
        Collections.reverse(arrayList);
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= arrayList.size()) {
                break;
            }
            String str = arrayList.get(i4);
            if (str.equals("list")) {
                int i5 = i4 - 1;
                arrayList.set(i5, SimpleComparison.LESS_THAN_OPERATION + arrayList.get(i5));
                arrayList.set(0, arrayList.get(0) + SimpleComparison.GREATER_THAN_OPERATION);
            } else if (str.equals("map")) {
                int i6 = i4 - 1;
                arrayList.set(i6, SimpleComparison.LESS_THAN_OPERATION + arrayList.get(i6) + ",");
                StringBuilder sb = new StringBuilder();
                sb.append(arrayList.get(0));
                sb.append(SimpleComparison.GREATER_THAN_OPERATION);
                arrayList.set(0, sb.toString());
            } else if (str.equals("Array")) {
                int i7 = i4 - 1;
                arrayList.set(i7, SimpleComparison.LESS_THAN_OPERATION + arrayList.get(i7));
                arrayList.set(0, arrayList.get(0) + SimpleComparison.GREATER_THAN_OPERATION);
            }
            i3 = i4 + 1;
        }
        Collections.reverse(arrayList);
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            stringBuffer.append(it.next());
        }
        return stringBuffer.toString();
    }

    private static void a(ArrayList<String> arrayList, String str) {
        int i;
        int length = str.length();
        do {
            i = length;
            if (str.charAt(length - 1) != '>') {
                break;
            }
            i = length - 1;
            length = i;
        } while (i != 0);
        arrayList.add(0, e(str.substring(0, i)));
    }

    public static void a(boolean z, ClassLoader classLoader) {
        b = z;
        f37280a = classLoader;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0069, code lost:
        if (r4 == null) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00dd, code lost:
        if (r4 == null) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00e0, code lost:
        r4 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00e6, code lost:
        r11 = r4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.Object b(java.lang.String r4, boolean r5, java.lang.ClassLoader r6) throws com.tencent.mapsdk.internal.b {
        /*
            Method dump skipped, instructions count: 239
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mapsdk.internal.a.b(java.lang.String, boolean, java.lang.ClassLoader):java.lang.Object");
    }

    public static ArrayList<String> b(String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        int indexOf = str.indexOf(SimpleComparison.LESS_THAN_OPERATION);
        int i = 0;
        while (i < indexOf) {
            a(arrayList, str.substring(i, indexOf));
            int i2 = indexOf + 1;
            int indexOf2 = str.indexOf(SimpleComparison.LESS_THAN_OPERATION, i2);
            int indexOf3 = str.indexOf(",", i2);
            int i3 = indexOf2;
            if (indexOf2 == -1) {
                i3 = indexOf3;
            }
            indexOf = i3;
            i = i2;
            if (indexOf3 != -1) {
                indexOf = i3;
                i = i2;
                if (indexOf3 < i3) {
                    indexOf = indexOf3;
                    i = i2;
                }
            }
        }
        a(arrayList, str.substring(i, str.length()));
        return arrayList;
    }

    public static boolean c(String str) {
        return str.equals(IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL) || str.equals(TypedValues.Custom.S_BOOLEAN) || str.equals("byte") || str.equals("double") || str.equals(TypedValues.Custom.S_FLOAT) || str.equals("long") || str.equals(Geo2AddressParam.PoiOptions.ADDRESS_FORMAT_SHORT) || str.equals("char") || str.equals("Integer") || str.equals("Boolean") || str.equals("Byte") || str.equals("Double") || str.equals("Float") || str.equals("Long") || str.equals("Short") || str.equals("Char");
    }

    public static String d(String str) {
        if (str.equals("java.lang.Integer") || str.equals(IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL)) {
            return "int32";
        }
        if (str.equals("java.lang.Boolean") || str.equals(TypedValues.Custom.S_BOOLEAN)) {
            return "bool";
        }
        if (str.equals("java.lang.Byte") || str.equals("byte")) {
            return "char";
        }
        String str2 = "double";
        if (!str.equals("java.lang.Double")) {
            if (str.equals("double")) {
                return "double";
            }
            boolean equals = str.equals("java.lang.Float");
            str2 = TypedValues.Custom.S_FLOAT;
            if (!equals) {
                if (str.equals(TypedValues.Custom.S_FLOAT)) {
                    return TypedValues.Custom.S_FLOAT;
                }
                if (str.equals("java.lang.Long") || str.equals("long")) {
                    return "int64";
                }
                if (str.equals("java.lang.Short") || str.equals(Geo2AddressParam.PoiOptions.ADDRESS_FORMAT_SHORT)) {
                    return Geo2AddressParam.PoiOptions.ADDRESS_FORMAT_SHORT;
                }
                if (str.equals("java.lang.Character")) {
                    throw new IllegalArgumentException("can not support java.lang.Character");
                }
                if (str.equals("java.lang.String")) {
                    return "string";
                }
                if (str.equals("java.util.List")) {
                    return "list";
                }
                String str3 = str;
                if (str.equals("java.util.Map")) {
                    str3 = "map";
                }
                return str3;
            }
        }
        return str2;
    }

    public static String e(String str) {
        if (str.equals("int32")) {
            return "java.lang.Integer";
        }
        if (str.equals("bool")) {
            return "java.lang.Boolean";
        }
        if (str.equals("char")) {
            return "java.lang.Byte";
        }
        if (str.equals("double")) {
            return "java.lang.Double";
        }
        if (str.equals(TypedValues.Custom.S_FLOAT)) {
            return "java.lang.Float";
        }
        if (str.equals("int64")) {
            return "java.lang.Long";
        }
        if (str.equals(Geo2AddressParam.PoiOptions.ADDRESS_FORMAT_SHORT)) {
            return "java.lang.Short";
        }
        if (str.equals("string")) {
            return "java.lang.String";
        }
        if (str.equals("list")) {
            return "java.util.List";
        }
        String str2 = str;
        if (str.equals("map")) {
            str2 = "java.util.Map";
        }
        return str2;
    }
}
