package com.ishumei.l111l11111Il;

import android.Manifest;
import android.app.ActivityManager;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.os.Build;
import android.os.IBinder;
import android.os.Parcel;
import android.text.TextUtils;
import android.util.ArraySet;
import android.util.Base64;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodManager;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.amap.api.col.p0003sl.iu;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.ishumei.l1111l111111Il.l111l1111llIl;
import com.tencent.lbssearch.object.param.Geo2AddressParam;
import dalvik.system.BaseDexClassLoader;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/* loaded from: source-7994992-dex2jar.jar:com/ishumei/l111l11111Il/l1111l111111Il.class */
public class l1111l111111Il {
    private static final String l1111l111111Il = "eJy1Wt9P5DYQ/l9WPPQktBHcG1SVDriiVYFbEdpKoHtwkiHrrmOnsbPAnfq/d5xNgpM4u9k4vOyheH5883k8Htv39HO2hrfZ2QwYJMDV7HgWMvLjB36JCNvQtSffpILEu4LXJVGrGyrV0ddaNgG1EhEKK+GrjPIYv0ka44dfPt38QzbEY4TH3nbsHAdTkpFkdvb0/Xim3lKYnZ38d1xBoFwu17GBgPAoEzTySJp6X9KU0ZAoKviShGsSwy3h+JuZKGJQCy4VYQyiUkq+I1qUkHJFmacDMQGhdzWzoZIpWj2xoBLS8wtulplIIVO08GVieXfd5WI3PTM9ONeD85LXGtppC9rp5NDcwR4PxA/hFkobf5qJDY0g83xQCrXlkQ9hnkEriHbK3VT6oeAKE9S73P57D1KwDWSHR1YanJcG5y2DQwONYGPLIIWLLl0J/uY9VH/Zk/oKNjSEReSyuhCDLVUcMCz2kNe3ojiu4g0YWN6tZPDMIFTerYjoM21ioPKuUqxIeLTF3OA9yG0FBdfHVTlkmC8+YeA4yRxBQHSAp5iJgLCh2XxdSHcql3JL5cUHZG6Wc4TfV5NDnA+qehLmPucczWLhxioUgpRmLd5Vim05gzgUkWsXIA+o77wbIA4JmV4JLlD8rQlnNOiQ8ufe6Rm4ZRpyi6213q0BYbYTM028loF9e0NfNOk6niCacnBcJIby2Ciwi0G4U3UxhoJztsArhNaqi1mpaNLYXUvZQe1LubwH9i/mhKdRsanQyIAVisSrKMNIIOOEGbvUEn8BPb6+fcAeGcvkcESo5F37twWwD8CUyjwYSZOfB+UymBoUZgt16mgWaMAVgFM70wQwtpUJVEJCC4yA5aCEUCvvovrrS0RS1a29UZTh2nGhIgTGmLChGEzGJZq4EdsyY0LpGjIlhwALVxiIba9sp6oiCnQlA95EJ7jp8rIwZ6TuPoif/rI1RbXwvBG5LQgUdUr0G8rh5C5PgmJk9CSjP6d0t8IYm/U0DGnkxIpPE+yBKGHuzBRgnLjpBTP6gIMrPnXi5w7Ui8jW3/DwTpRw4qcA48RPLxgnfjhJYEqO7kgCzjxpUFNy1QQ1li9JE8d8whSfIpcKIK5rbbo8KuA455EByTWHakBTcTRN/tBEunVr2EjKMKNYHF3bRunWtdmBjOUlXYUi57Yrm8GAiublsrRS8bLYQ8OLvWnECuS90Gfq/Y0/lsb9loQTtItSNs4RQ537/uLKxW2Gfke4vd+qDWUWzY2Krizbjeze5ysYyeSFK5XooPhmd12F0nX8sFU6gEs8eo7y5Nd6w51RfVxw23ppvAqEZlB39c0LoEPvGwkeXRzxfGHMHYcMCc/6JqDOsp5iibr3IHOmHC5etQ+pD2fjMOgRv1QfXB711T8nARvjk0o98LVQ33uBb179gGLEthWw8nToGQfkxskKP6o8MgO8GuCrsHOwL8HjQ50xItWaixduvyPouOw5P6KVP7SV7jWB7XKw1/qIS8Ly9USOB780TJSgH3feoAZCMCD2C4EApNKYxsO5QAsVJMtNRm3lMqNKn0vPH/f0N9W1RqU5rzRnu155zGoXRYyOJRiVr1OpF3kujRuc3rBq4aNK+ryxOrvhdDWsUcSp1JVq/MTUfgbBt6X5++CwgPpmgydAxk/HHWoPmYlvXEveYkOJRoZOhlXpA+LI4N8cF0ol8Wca4S6yc2Yq0fut5nm/RB1rLSIkDur/K/H+Sb/XLIFHuGgWxQNRz2VizUzLP8r2ihizU8kIOd8iML4hhHkDgv2K8rVZ2vXTAAqH+k0rISlJqVe+We4r8sL2CjiwmtuQPVPWOJsXVYwK73fKGk8lv1JO1W87t5QG9f1F7XPT+ekkzg+Gs6vsfm5sbUFOWdShyHxWu9ASzalqI36ahK8KTYezA9G0N1YLFD0414MmkO//A9zgF+k=";

    private static int l1111l111111Il(boolean z) {
        return z ? 1 : 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:69:0x0142 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0197 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00d8 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00d8 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.Map<java.lang.String, java.lang.Object> l1111l111111Il() {
        /*
            Method dump skipped, instructions count: 449
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ishumei.l111l11111Il.l1111l111111Il.l1111l111111Il():java.util.Map");
    }

    private static void l1111l111111Il(Class<?> cls, String str, Set<Object> set) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            set.addAll(((Map) declaredField.get(null)).keySet());
        } catch (Throwable th) {
        }
    }

    private static boolean l1111l111111Il(ClassLoader classLoader, String str) {
        if (classLoader == null || !(classLoader instanceof BaseDexClassLoader)) {
            return false;
        }
        try {
            Class<?> cls = Class.forName(com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("9b9e93899694d18c868c8b9a92d1bb9a87af9e8b97b3968c8b"));
            Method method = Class.forName(com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("9b9e93899694d18c868c8b9a92d1bb9a87af9e8b97b3968c8bdbba939a929a918b")).getMethod(com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("8b90ac8b8d969198"), null);
            Field declaredField = cls.getDeclaredField(com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("9b9a87ba939a929a918b8c"));
            declaredField.setAccessible(true);
            Field declaredField2 = BaseDexClassLoader.class.getDeclaredField(com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("8f9e8b97b3968c8b"));
            declaredField2.setAccessible(true);
            Object[] objArr = (Object[]) declaredField.get(declaredField2.get(classLoader));
            int length = objArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return false;
                }
                String str2 = (String) method.invoke(objArr[i2], null);
                if (str2 != null && str2.contains(str)) {
                    return true;
                }
                i = i2 + 1;
            }
        } catch (Throwable th) {
            return false;
        }
    }

    private static boolean l1111l111111Il(String str) {
        try {
            ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
            if (l1111l111111Il(systemClassLoader, str) || l1111l111111Il(systemClassLoader.getParent(), str)) {
                return true;
            }
            ClassLoader classLoader = l1111l111111Il.class.getClassLoader();
            if (l1111l111111Il(classLoader, str)) {
                return true;
            }
            return l1111l111111Il(classLoader.getParent(), str);
        } catch (Exception e) {
            return false;
        }
    }

    private static Class[] l1111l111111Il(List<String> list) {
        GenericDeclaration genericDeclaration;
        if (list == null || list.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            boolean z = true;
            switch (str.hashCode()) {
                case -1325958191:
                    if (str.equals("double")) {
                        z = true;
                        break;
                    }
                    break;
                case 104431:
                    if (str.equals(IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL)) {
                        z = false;
                        break;
                    }
                    break;
                case 3039496:
                    if (str.equals("byte")) {
                        z = true;
                        break;
                    }
                    break;
                case 3052374:
                    if (str.equals("char")) {
                        z = true;
                        break;
                    }
                    break;
                case 3327612:
                    if (str.equals("long")) {
                        z = true;
                        break;
                    }
                    break;
                case 64711720:
                    if (str.equals(TypedValues.Custom.S_BOOLEAN)) {
                        z = true;
                        break;
                    }
                    break;
                case 97526364:
                    if (str.equals(TypedValues.Custom.S_FLOAT)) {
                        z = true;
                        break;
                    }
                    break;
                case 109413500:
                    if (str.equals(Geo2AddressParam.PoiOptions.ADDRESS_FORMAT_SHORT)) {
                        z = true;
                        break;
                    }
                    break;
            }
            switch (z) {
                case false:
                    genericDeclaration = Integer.TYPE;
                    break;
                case true:
                    genericDeclaration = Long.TYPE;
                    break;
                case true:
                    genericDeclaration = Boolean.TYPE;
                    break;
                case true:
                    genericDeclaration = Double.TYPE;
                    break;
                case true:
                    genericDeclaration = Float.TYPE;
                    break;
                case true:
                    genericDeclaration = Byte.TYPE;
                    break;
                case true:
                    genericDeclaration = Character.TYPE;
                    break;
                case true:
                    genericDeclaration = Short.TYPE;
                    break;
                default:
                    genericDeclaration = Class.forName(str);
                    break;
            }
            arrayList.add(genericDeclaration);
        }
        Class[] clsArr = new Class[arrayList.size()];
        arrayList.toArray(clsArr);
        return clsArr;
    }

    public static boolean l111l11111I1l() {
        try {
            return l1111l111111Il(com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("a78f908c9a9bbd8d969b989ad1959e8d"));
        } catch (Exception e) {
            return false;
        }
    }

    public static Set<Object> l111l11111Il() {
        HashSet hashSet = new HashSet();
        try {
            Class<?> loadClass = ClassLoader.getSystemClassLoader().loadClass(com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("9b9ad18d909d89d19e919b8d90969bd1878f908c9a9bd1a78f908c9a9bb79a938f9a8d8c"));
            l1111l111111Il(loadClass, com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("99969a939bbc9e9c979a"), hashSet);
            l1111l111111Il(loadClass, com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("929a8b97909bbc9e9c979a"), hashSet);
            l1111l111111Il(loadClass, com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("9c90918c8b8d8a9c8b908dbc9e9c979a"), hashSet);
            return hashSet;
        } catch (Throwable th) {
            return hashSet;
        }
    }

    public static List<String> l111l11111lIl() {
        InputMethodManager inputMethodManager;
        List<InputMethodInfo> inputMethodList;
        ArrayList arrayList = new ArrayList();
        try {
            Context context = l111l1111llIl.l1111l111111Il.l111l11111Il;
            if (context != null && (inputMethodManager = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE)) != null && (inputMethodList = inputMethodManager.getInputMethodList()) != null) {
                for (InputMethodInfo inputMethodInfo : inputMethodList) {
                    arrayList.add(inputMethodInfo.toString());
                }
                return arrayList;
            }
            return arrayList;
        } catch (Exception e) {
            return arrayList;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x0152, code lost:
        r4 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.Map<java.lang.String, java.lang.Object> l111l1111l1Il() {
        /*
            Method dump skipped, instructions count: 360
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ishumei.l111l11111Il.l1111l111111Il.l111l1111l1Il():java.util.Map");
    }

    public static String l111l1111lI1l() {
        Context context = l111l1111llIl.l1111l111111Il.l111l11111Il;
        if (context == null) {
            return "";
        }
        if (Build.VERSION.SDK_INT >= 23) {
            return String.format(Locale.CHINA, "%d%d%d%d%d%d%d", Integer.valueOf(l1111l111111Il(context.checkSelfPermission("android.permission.READ_PHONE_STATE") == 0)), Integer.valueOf(l1111l111111Il(context.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0)), Integer.valueOf(l1111l111111Il(context.checkSelfPermission(Manifest.permission.WRITE_SETTINGS) == 0)), Integer.valueOf(l1111l111111Il(context.checkSelfPermission("android.permission.ACCESS_WIFI_STATE") == 0)), Integer.valueOf(l1111l111111Il(context.checkSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0)), Integer.valueOf(l1111l111111Il(context.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0)), Integer.valueOf(l1111l111111Il(context.checkSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0)));
        }
        return "1111111";
    }

    public static String l111l1111lIl() {
        if (Build.VERSION.SDK_INT < 23 || Build.VERSION.SDK_INT > 29) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        try {
            Class<?> cls = Class.forName(com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("959e899ed18a8b9693d1aaaab6bb"));
            Class<?> cls2 = Class.forName(com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("9e919b8d90969bd1929a9b969ed1b29a9b969ebb8d92"));
            Constructor<?> constructor = cls.getConstructor(Long.TYPE, Long.TYPE);
            Constructor<?> constructor2 = cls2.getConstructor(cls);
            Method method = cls2.getMethod(com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("989a8baf8d908f9a8d8b86bd868b9abe8d8d9e86"), String.class);
            Object newInstance = constructor2.newInstance(constructor.newInstance(-1301668207276963122L, -6645017420763422227L));
            sb.append(Base64.encodeToString((byte[]) method.invoke(newInstance, com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("9b9a89969c9aaa91968e8a9ab69b")), 2));
            sb.append("__");
            sb.append(BridgeUtil.UNDERLINE_STR);
            cls2.getMethod(com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("9c93908c9a"), new Class[0]).invoke(newInstance, new Object[0]);
        } catch (Throwable th) {
        }
        return sb.toString();
    }

    public static Map<String, Object> l111l1111llIl() {
        HashMap hashMap = new HashMap();
        try {
            Object invoke = Class.forName(com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("9e919b8d90969bd19c90918b9a918bd1bc90918b9a878b")).getDeclaredMethod(com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("989a8bac868c8b9a92ac9a8d89969c9a"), String.class).invoke(l111l1111llIl.l1111l111111Il.l111l11111Il, com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("9e9c9c9a8c8c969d9693968b86"));
            Method declaredMethod = invoke.getClass().getDeclaredMethod(com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("968cba919e9d939a9b"), new Class[0]);
            Method declaredMethod2 = invoke.getClass().getDeclaredMethod(com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("989a8bba919e9d939a9bbe9c9c9a8c8c969d9693968b86ac9a8d89969c9ab3968c8b"), Integer.TYPE);
            Object invoke2 = declaredMethod.invoke(invoke, new Object[0]);
            List list = (List) declaredMethod2.invoke(invoke, -1);
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                Object invoke3 = obj.getClass().getDeclaredMethod(com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("989a8bb69b"), new Class[0]).invoke(obj, new Object[0]);
                if (invoke3 == null) {
                    Object invoke4 = obj.getClass().getDeclaredMethod(com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("989a8bad9a8c9093899ab6919990"), new Class[0]).invoke(obj, new Object[0]);
                    arrayList.add(invoke4 == null ? obj.toString() : invoke4.toString());
                } else {
                    arrayList.add((String) invoke3);
                }
            }
            hashMap.put("enable", ((Boolean) invoke2).booleanValue() ? "1" : "0");
            hashMap.put("service", arrayList);
            hashMap.put("suc", "1");
            return hashMap;
        } catch (Throwable th) {
            hashMap.put(iu.h, th.getMessage());
            hashMap.put("suc", "-1");
            return hashMap;
        }
    }

    public static String l11l1111I11l() {
        ArrayList arrayList = new ArrayList();
        try {
            Field declaredField = Class.forName(com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("9b9ad18d909d89d19e919b8d90969bd1878f908c9a9bd1a78f908c9a9bb691968b")).getDeclaredField(com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("93909e9b9a9baf9e9c949e989a8cb691af8d909c9a8c8c"));
            declaredField.setAccessible(true);
            arrayList.addAll((Set) declaredField.get(null));
        } catch (Throwable th) {
        }
        return TextUtils.join("|", arrayList);
    }

    public static String l11l1111I1l() {
        if (Build.VERSION.SDK_INT < 23) {
            return "";
        }
        ArrayList arrayList = new ArrayList();
        try {
            Field declaredField = Class.forName(com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("9b9ad18d909d89d19e919b8d90969bd1878f908c9a9bd1a78f908c9a9bb691968b")).getDeclaredField(com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("93909e9b9a9bb2909b8a939a8c"));
            declaredField.setAccessible(true);
            Iterator it = ((ArraySet) declaredField.get(null)).iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().toString());
            }
        } catch (Throwable th) {
        }
        return TextUtils.join("|", arrayList);
    }

    public static String l11l1111I1ll() {
        if (Build.VERSION.SDK_INT >= 28) {
            return "";
        }
        String l111l11111Il = com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("9c9092d19a939b9a8d9b8d96899a8d8cd18d968d8ad19a9b878fd19c9091999698d1ba9ba78fbc9091999698b893909d9e93");
        ArrayList arrayList = new ArrayList();
        try {
            Class<?> cls = Class.forName(com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("9e919b8d90969bd19e8f8fd1be8f8f93969c9e8b969091b3909e9b9a8d8c"));
            Field declaredField = cls.getDeclaredField(com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("98be8f8f93969c9e8b969091b3909e9b9a8d8c"));
            declaredField.setAccessible(true);
            Object obj = declaredField.get(null);
            Field declaredField2 = cls.getDeclaredField(com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("92b3909e9b9a8d8c"));
            declaredField2.setAccessible(true);
            for (Map.Entry entry : ((Map) declaredField2.get(obj)).entrySet()) {
                String str = (String) entry.getKey();
                try {
                    Class.forName(l111l11111Il, false, (ClassLoader) entry.getValue());
                    arrayList.add(str);
                } catch (ClassNotFoundException e) {
                }
            }
        } catch (Throwable th) {
        }
        return TextUtils.join("|", arrayList);
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00f8 A[Catch: Exception -> 0x01a2, TryCatch #8 {Exception -> 0x01a2, blocks: (B:38:0x00c9, B:40:0x00f0, B:42:0x00f8), top: B:84:0x00c9 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.List<java.lang.String> l11l1111Il() {
        /*
            Method dump skipped, instructions count: 426
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ishumei.l111l11111Il.l1111l111111Il.l11l1111Il():java.util.List");
    }

    public static Map<String, Object> l11l1111Il1l() {
        ActivityManager activityManager;
        Context context = l111l1111llIl.l1111l111111Il.l111l11111Il;
        if (context == null || (activityManager = (ActivityManager) context.getSystemService("activity")) == null) {
            return null;
        }
        HashSet hashSet = new HashSet();
        HashMap hashMap = new HashMap(3);
        hashSet.add(com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("8a8c9a8dd1858f908c9a9bd19e8f8f"));
        hashSet.add(com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("8a8c9a8dd1858f908c9a9bd18c868c8b9a92"));
        for (ActivityManager.RunningServiceInfo runningServiceInfo : activityManager.getRunningServices(Integer.MAX_VALUE)) {
            if (hashSet.contains(runningServiceInfo.process)) {
                hashMap.put(runningServiceInfo.process, 1);
            }
        }
        return hashMap;
    }

    public static int l11l1111Ill() {
        Context context = l111l1111llIl.l1111l111111Il.l111l11111Il;
        if (context == null) {
            return 0;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(context.getFilesDir());
        sb.append(File.separator);
        sb.append(com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("9a878fa09d9e8c9ad19e8f94"));
        return new File(sb.toString()).exists() ? 1 : 0;
    }

    public static String l11l1111lIIl() {
        StringBuilder sb = new StringBuilder();
        try {
            Method method = Class.forName(com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("9e919b8d90969bd1908cd1ac9a8d89969c9ab29e919e989a8d")).getMethod(com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("989a8bac9a8d89969c9a"), String.class);
            method.setAccessible(true);
            Object invoke = method.invoke(null, "location");
            Object invoke2 = method.invoke(null, "phone");
            sb.append("locateServiceName:");
            sb.append(invoke.getClass().getName());
            sb.append("|");
            sb.append("phoneServiceName:");
            sb.append(invoke2.getClass().getName());
        } catch (Throwable th) {
        }
        return sb.toString();
    }

    private static String l11l111l11Il() {
        try {
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            Field declaredField = Class.forName(com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("9e919b8d90969bd19d938a9a8b90908b97d1bd938a9a8b90908b97be9b9e8f8b9a8d")).getDeclaredField(com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("92ac9a8d89969c9a"));
            declaredField.setAccessible(true);
            Object obj = declaredField.get(defaultAdapter);
            if (obj != null) {
                Object invoke = Class.forName(com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("9e919b8d90969bd19d938a9a8b90908b97d1b6bd938a9a8b90908b97dbac8b8a9ddbaf8d908786")).getMethod(com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("989a8bbe9b9b8d9a8c8c"), null).invoke(obj, null);
                if (invoke == null || !(invoke instanceof String)) {
                    throw new Exception();
                }
                return (String) invoke;
            }
            throw new Exception();
        } catch (Exception e) {
            try {
                Class<?> cls = Class.forName(com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("9e919b8d90969bd1908cd1ac9a8d89969c9ab29e919e989a8d"));
                Class.forName(com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("9e919b8d90969bd19d938a9a8b90908b97d1b6bd938a9a8b90908b97b29e919e989a8ddbac8b8a9d")).getField(com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("b9b6adacaba0bcbeb3b3a0abadbeb1acbebcabb6b0b1"));
                IBinder iBinder = (IBinder) cls.getMethod(com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("989a8bac9a8d89969c9a"), String.class).invoke(null, com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("9d938a9a8b90908b97a0929e919e989a8d"));
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                obtain.writeInterfaceToken(com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("9e919b8d90969bd19d938a9a8b90908b97d1b6bd938a9a8b90908b97b29e919e989a8d"));
                if (Build.VERSION.SDK_INT >= 21) {
                    iBinder.transact(5, obtain, obtain2, 0);
                } else {
                    iBinder.transact(10, obtain, obtain2, 0);
                }
                obtain2.readException();
                String readString = obtain2.readString();
                obtain2.recycle();
                obtain.recycle();
                return readString == null ? "" : readString;
            } catch (Exception e2) {
                return "";
            }
        }
    }

    private static String l11l111l1lll() {
        try {
            String l111l11111Il = com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("8c8a9d8c8b8d9e8b9a");
            String l111l11111Il2 = com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("a78f908c9a9b");
            for (String str : com.ishumei.l111l1111llIl.l111l1111lIl.l111l11111I1l(com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("d08f8d909cd08c9a9399d0929e8f8c"))) {
                if (!TextUtils.isEmpty(str)) {
                    if (str.contains(l111l11111Il)) {
                        return l111l11111Il;
                    }
                    if (str.contains(l111l11111Il2)) {
                        return l111l11111Il2;
                    }
                }
            }
            return "";
        } catch (Exception e) {
            return "";
        }
    }

    private static String l11l11IlIIll() {
        try {
            return new String(com.ishumei.l111l1111llIl.l11l1111lIIl.l1111l111111Il(Base64.decode(l1111l111111Il, 0)));
        } catch (Exception e) {
            return "";
        }
    }
}
