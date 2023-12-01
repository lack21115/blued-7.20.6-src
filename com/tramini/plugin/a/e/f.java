package com.tramini.plugin.a.e;

import android.net.Uri;
import android.text.TextUtils;
import com.j256.ormlite.stmt.query.SimpleComparison;
import java.io.IOException;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: source-8829756-dex2jar.jar:com/tramini/plugin/a/e/f.class */
public class f {

    /* loaded from: source-8829756-dex2jar.jar:com/tramini/plugin/a/e/f$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public int f26830a;
        public Object b;

        public static a a() {
            a aVar = new a();
            aVar.f26830a = 0;
            return aVar;
        }

        public static a a(Object obj) {
            a aVar = new a();
            aVar.f26830a = 1;
            aVar.b = obj;
            return aVar;
        }

        public static a b(Object obj) {
            a aVar = new a();
            aVar.f26830a = -1;
            aVar.b = obj;
            return aVar;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tramini/plugin/a/e/f$b.class */
    public static final class b {
        public static String a(String str, String str2) {
            String[] split = str2.split(",");
            int length = split.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                str = f.b(str, split[i2].replaceAll("#01;", ","), 1);
                i = i2 + 1;
            }
            return !TextUtils.isEmpty(str) ? str : "";
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tramini/plugin/a/e/f$c.class */
    public interface c {
        boolean a(Object obj);

        a b(Object obj);
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tramini/plugin/a/e/f$d.class */
    public static final class d {
        public static String a(String str, String str2) {
            String b;
            String[] split = str2.split(",");
            int length = split.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                String str3 = split[i2];
                if (str3.contains("#")) {
                    String[] split2 = str3.split("#");
                    String str4 = split2[0];
                    String str5 = split2[1];
                    b = f.b(str, ".*<" + str4 + ".*?>(.*?" + str5 + ".*?)</" + str4 + SimpleComparison.GREATER_THAN_OPERATION, 1);
                } else {
                    b = f.b(str, SimpleComparison.LESS_THAN_OPERATION + str3 + ".*?>(.*?)</" + str3 + SimpleComparison.GREATER_THAN_OPERATION, 1);
                }
                str = b;
                i = i2 + 1;
            }
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            String b2 = f.b(str, "<!\\[CDATA\\[(.*?)\\]\\]>", 1);
            return !TextUtils.isEmpty(b2) ? b2 : str;
        }

        public static String b(String str, String str2) {
            try {
                String b = f.b(str, SimpleComparison.LESS_THAN_OPERATION + str2 + ">(.*?)</" + str2 + SimpleComparison.GREATER_THAN_OPERATION, 1);
                if (TextUtils.isEmpty(b)) {
                    return "";
                }
                String[] split = b.split(":");
                return String.valueOf(Integer.parseInt(split[2].substring(0, 2)) + (Integer.parseInt(split[1].substring(0, 2)) * 60) + (Integer.parseInt(split[0].substring(0, 2)) * 60 * 60));
            } catch (Throwable th) {
                return "";
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Object a(Object obj, String str) {
        try {
            return obj.getClass().getMethod(str, new Class[0]).invoke(obj, new Object[0]);
        } catch (Throwable th) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Object a(Object obj, String str, StringBuffer stringBuffer, c cVar) {
        Object obj2;
        Object a2;
        Object a3;
        if (cVar == null || obj == null || !obj.getClass().getName().startsWith(str)) {
            return null;
        }
        stringBuffer.append(obj.getClass().getName() + ",");
        try {
            ArrayList<Field> arrayList = new ArrayList();
            for (Class<? super Object> cls = obj.getClass(); cls != null; cls = cls.getSuperclass()) {
                arrayList.addAll(Arrays.asList(cls.getDeclaredFields()));
            }
            if (arrayList.size() != 0) {
                for (Field field : arrayList) {
                    field.setAccessible(true);
                    Object obj3 = field.get(obj);
                    if (obj3 != null) {
                        if (cVar.a(obj3)) {
                            a b2 = cVar.b(obj3);
                            int i = b2.f26830a;
                            if (i == 0) {
                                continue;
                            } else if (i == 1) {
                                return b2.b;
                            } else {
                                if (i == -1 && (obj2 = b2.b) != null && !stringBuffer.toString().contains(obj2.getClass().getName()) && (a2 = a(obj2, str, stringBuffer, cVar)) != null) {
                                    return a2;
                                }
                            }
                        } else if (!stringBuffer.toString().contains(obj3.getClass().getName()) && (a3 = a(obj3, str, stringBuffer, cVar)) != null) {
                            return a3;
                        }
                    }
                }
                return null;
            }
            return null;
        } catch (Throwable th) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Object a(String str, String str2) {
        try {
            Object invoke = Class.forName(str).getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
            Field[] declaredFields = invoke.getClass().getDeclaredFields();
            if (declaredFields != null) {
                for (Field field : declaredFields) {
                    field.setAccessible(true);
                    if (field.get(invoke) instanceof Map) {
                        Map map = (Map) field.get(invoke);
                        if (map == null) {
                            return null;
                        }
                        Object obj = map.get(str2);
                        return obj instanceof WeakReference ? ((WeakReference) obj).get() : map.get(str2);
                    }
                }
                return null;
            }
            return null;
        } catch (Throwable th) {
            return null;
        }
    }

    public static String a(String str) {
        try {
            return TextUtils.isEmpty(str) ? "" : Uri.parse(str).getQueryParameter("id");
        } catch (Throwable th) {
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void a(Class cls, List<Field> list) {
        if (cls != null) {
            try {
                if (cls.getName().equals(Object.class.getName())) {
                    return;
                }
                Field[] declaredFields = cls.getDeclaredFields();
                if (declaredFields != null && declaredFields.length > 0) {
                    list.addAll(Arrays.asList(declaredFields));
                }
                a(cls.getSuperclass(), list);
            } catch (Throwable th) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Object b(Object obj, String str) {
        try {
            Field declaredField = obj.getClass().getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField.get(obj);
        } catch (Throwable th) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Object b(String str, String str2) {
        try {
            return Class.forName(str).getMethod(str2, new Class[0]).invoke(null, new Object[0]);
        } catch (Throwable th) {
            return null;
        }
    }

    public static String b(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            String queryParameter = Uri.parse(str).getQueryParameter("adurl");
            return TextUtils.isEmpty(queryParameter) ? "" : a(queryParameter);
        } catch (Throwable th) {
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(final String str, final String str2, final int i) {
        final ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(2);
        final String[] strArr = new String[1];
        newFixedThreadPool.submit(new Runnable() { // from class: com.tramini.plugin.a.e.f.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    Matcher matcher = Pattern.compile(str2, 34).matcher(new com.tramini.plugin.a.g.a.a(str));
                    if (matcher.find()) {
                        strArr[0] = matcher.group(i);
                    }
                } catch (Throwable th) {
                }
                try {
                    synchronized (newFixedThreadPool) {
                        newFixedThreadPool.notifyAll();
                    }
                } catch (Throwable th2) {
                }
            }
        });
        try {
            synchronized (newFixedThreadPool) {
                newFixedThreadPool.wait(500L);
            }
            newFixedThreadPool.shutdown();
            return strArr[0] != null ? strArr[0] : "";
        } catch (Exception e) {
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void b(Class cls, List<Method> list) {
        if (cls != null) {
            try {
                if (cls.getName().equals(Object.class.getName())) {
                    return;
                }
                Method[] declaredMethods = cls.getDeclaredMethods();
                if (declaredMethods != null && declaredMethods.length > 0) {
                    list.addAll(Arrays.asList(declaredMethods));
                }
                b(cls.getSuperclass(), list);
            } catch (Throwable th) {
            }
        }
    }

    public static String c(String str) {
        Properties properties = new Properties();
        try {
            properties.load(new StringReader("unicodedString=".concat(String.valueOf(str))));
        } catch (IOException e) {
        }
        return properties.getProperty("unicodedString");
    }

    public static String d(String str) {
        try {
            return URLDecoder.decode(str.replaceAll("%(?![0-9a-fA-F]{2})", "%25"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return str;
        }
    }
}
