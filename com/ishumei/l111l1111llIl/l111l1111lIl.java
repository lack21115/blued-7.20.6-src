package com.ishumei.l111l1111llIl;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Patterns;
import com.ishumei.l1111l111111Il.l111l1111llIl;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.net.HttpURLConnection;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/ishumei/l111l1111llIl/l111l1111lIl.class */
public final class l111l1111lIl {
    private static Object l1111l111111Il(Field field, Object obj) {
        try {
            Class<?> type = field.getType();
            if (type != Integer.class && type != Double.class && type != Float.class && type != Long.class) {
                return type == String.class ? obj == null ? "" : obj : type == Map.class ? obj == null ? new JSONObject() : new JSONObject((Map) obj) : (type == List.class || type == Set.class) ? obj == null ? new JSONArray() : new JSONArray((Collection) obj) : obj == null ? type.newInstance() : obj;
            } else if (obj == null) {
                return -1;
            } else {
                return obj;
            }
        } catch (Exception e) {
            return new Object();
        }
    }

    public static String l1111l111111Il(File file) {
        BufferedReader bufferedReader;
        if (file.exists()) {
            try {
                bufferedReader = new BufferedReader(new FileReader(file));
            } catch (Throwable th) {
                th = th;
                bufferedReader = null;
            }
            try {
                String readLine = bufferedReader.readLine();
                bufferedReader.close();
                return readLine;
            } catch (Throwable th2) {
                th = th2;
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                throw th;
            }
        }
        throw new IOException("not exist");
    }

    public static String l1111l111111Il(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        int length = bArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return stringBuffer.toString();
            }
            byte b = bArr[i2];
            if (stringBuffer.length() > 0) {
                stringBuffer.append(":");
            }
            String hexString = Integer.toHexString(b & 255);
            String str = hexString;
            if (hexString.length() == 1) {
                str = "0" + hexString;
            }
            stringBuffer.append(str);
            i = i2 + 1;
        }
    }

    private static List<String> l1111l111111Il(File file, Set<String> set, int i) {
        ArrayList arrayList = new ArrayList();
        if (!file.exists() || !file.canRead() || !file.isFile() || set == null) {
            return arrayList;
        }
        if (set.size() == 0) {
            return arrayList;
        }
        HashSet hashSet = new HashSet(set);
        BufferedReader bufferedReader = null;
        try {
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file));
                while (true) {
                    try {
                        String readLine = bufferedReader2.readLine();
                        if (readLine == null) {
                            l1111l111111Il((Closeable) bufferedReader2);
                            return arrayList;
                        } else if (!l111l1111lI1l.l1111l111111Il(readLine)) {
                            Iterator it = hashSet.iterator();
                            if (i == 0) {
                                while (it.hasNext()) {
                                    String str = (String) it.next();
                                    if (readLine.contains(str)) {
                                        arrayList.add(str);
                                        it.remove();
                                    }
                                }
                            } else if (i == 1) {
                                String lowerCase = readLine.toLowerCase();
                                while (it.hasNext()) {
                                    String str2 = (String) it.next();
                                    if (lowerCase.contains(str2.toLowerCase())) {
                                        arrayList.add(str2);
                                        it.remove();
                                    }
                                }
                            } else if (i == 2) {
                                while (it.hasNext()) {
                                    Matcher matcher = Pattern.compile((String) it.next()).matcher(readLine);
                                    while (matcher.find()) {
                                        arrayList.add(matcher.group(0));
                                    }
                                }
                            }
                        }
                    } catch (Exception e) {
                        bufferedReader = bufferedReader2;
                        e = e;
                        throw new IOException(e);
                    } catch (Throwable th) {
                        bufferedReader = bufferedReader2;
                        th = th;
                        l1111l111111Il((Closeable) bufferedReader);
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e2) {
            e = e2;
            bufferedReader = null;
        }
    }

    private static List<String> l1111l111111Il(String str, Set<String> set, int i) {
        return l1111l111111Il(new File(str), set, i);
    }

    private static List<Object> l1111l111111Il(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray == null) {
            return arrayList;
        }
        int length = jSONArray.length();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return arrayList;
            }
            Object opt = jSONArray.opt(i2);
            if (opt != null) {
                arrayList.add(l111l11111Il(opt));
            }
            i = i2 + 1;
        }
    }

    private static Map<String, Object> l1111l111111Il(JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        if (jSONObject == null) {
            return hashMap;
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Object opt = jSONObject.opt(next);
            if (opt != null) {
                hashMap.put(next, l111l11111Il(opt));
            }
        }
        return hashMap;
    }

    private static JSONArray l1111l111111Il(Collection collection) {
        JSONArray jSONArray = new JSONArray();
        if (collection != null) {
            for (Object obj : collection) {
                jSONArray.put(l111l11111I1l(obj));
            }
        }
        return jSONArray;
    }

    public static JSONObject l1111l111111Il(Object obj) {
        JSONObject jSONObject = new JSONObject();
        if (obj == null) {
            return jSONObject;
        }
        Field[] declaredFields = obj.getClass().getDeclaredFields();
        int length = declaredFields.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return jSONObject;
            }
            Field field = declaredFields[i2];
            try {
                if (!field.getName().equals("serialVersionUID")) {
                    field.setAccessible(true);
                    Object obj2 = field.get(obj);
                    com.ishumei.l1111l111111Il.l111l11111Il l111l11111il = (com.ishumei.l1111l111111Il.l111l11111Il) field.getAnnotation(com.ishumei.l1111l111111Il.l111l11111Il.class);
                    if (l111l11111il == null) {
                        jSONObject.put(field.getName(), obj2);
                    } else {
                        boolean l111l11111I1l = l111l11111il.l111l11111I1l();
                        if (obj2 != null || l111l11111I1l) {
                            jSONObject.put(l111l11111il.l1111l111111Il(), l111l11111il.l111l11111lIl() ? l1111l111111Il(obj2) : l1111l111111Il(field, obj2));
                        }
                    }
                }
            } catch (Exception e) {
            }
            i = i2 + 1;
        }
    }

    public static JSONObject l1111l111111Il(Map<?, ?> map) {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<?, ?> entry : map.entrySet()) {
                String str = (String) entry.getKey();
                if (str == null) {
                    throw new NullPointerException("key == null");
                }
                try {
                    jSONObject.put(str, l111l11111I1l(entry.getValue()));
                } catch (JSONException e) {
                }
            }
            return jSONObject;
        } catch (Exception e2) {
            return jSONObject;
        }
    }

    public static void l1111l111111Il(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e) {
            }
        }
    }

    public static void l1111l111111Il(File file, String str) {
        FileWriter fileWriter;
        if (l111l1111lI1l.l1111l111111Il(str)) {
            throw new IOException("file or bytes empty");
        }
        try {
            fileWriter = new FileWriter(file);
            try {
                fileWriter.write(str);
                fileWriter.close();
            } catch (Throwable th) {
                th = th;
                if (fileWriter != null) {
                    fileWriter.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            fileWriter = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00d4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void l1111l111111Il(java.io.File r4, byte[] r5) {
        /*
            Method dump skipped, instructions count: 233
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ishumei.l111l1111llIl.l111l1111lIl.l1111l111111Il(java.io.File, byte[]):void");
    }

    private static void l1111l111111Il(String str, String str2) {
        if (l111l1111lI1l.l1111l111111Il(str) || l111l1111lI1l.l1111l111111Il(str2)) {
            throw new IOException("file or bytes empty");
        }
        byte[] bytes = str2.getBytes("utf-8");
        if (l111l1111lI1l.l1111l111111Il(str) || bytes == null) {
            throw new IOException("filename or byes empty");
        }
        try {
            l1111l111111Il(new File(str), bytes);
        } catch (Exception e) {
            throw new IOException(e);
        }
    }

    private static void l1111l111111Il(String str, byte[] bArr) {
        if (l111l1111lI1l.l1111l111111Il(str) || bArr == null) {
            throw new IOException("filename or byes empty");
        }
        try {
            l1111l111111Il(new File(str), bArr);
        } catch (Exception e) {
            throw new IOException(e);
        }
    }

    public static void l1111l111111Il(HttpURLConnection httpURLConnection) {
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e) {
            }
        }
    }

    public static boolean l1111l111111Il(String str) {
        try {
            return new File(Environment.getExternalStorageDirectory() + "/" + str).exists();
        } catch (Exception e) {
            return false;
        }
    }

    private static byte[] l1111l111111Il(FileChannel fileChannel) {
        int i;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            try {
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                try {
                    ByteBuffer allocate = ByteBuffer.allocate(100);
                    int i2 = 0;
                    int i3 = 0;
                    while (true) {
                        i = i3;
                        int read = fileChannel.read(allocate, i2);
                        if (read <= 0) {
                            break;
                        }
                        i2 += read;
                        i3 = i + read;
                    }
                    byte[] array = allocate.array();
                    if (i >= 4 && (array[0] & 255) == 0 && (array[1] & 255) == 0 && (array[2] & 255) == 0 && (array[3] & 255) == 0) {
                        throw new IOException("read bytes not utf-8");
                    }
                    byteArrayOutputStream2.write(array, 0, i);
                    byte[] byteArray = byteArrayOutputStream2.toByteArray();
                    l1111l111111Il((Closeable) byteArrayOutputStream2);
                    return byteArray;
                } catch (Exception e) {
                    e = e;
                    byteArrayOutputStream = byteArrayOutputStream2;
                    throw new IOException(e);
                } catch (Throwable th) {
                    th = th;
                    byteArrayOutputStream = byteArrayOutputStream2;
                    l1111l111111Il((Closeable) byteArrayOutputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e2) {
            e = e2;
            byteArrayOutputStream = null;
        }
    }

    private static Object l111l11111I1l(Object obj) {
        if (obj == null) {
            return null;
        }
        if (!(obj instanceof JSONArray) && !(obj instanceof JSONObject)) {
            try {
                if (obj instanceof Collection) {
                    Collection<Object> collection = (Collection) obj;
                    JSONArray jSONArray = new JSONArray();
                    if (collection != null) {
                        for (Object obj2 : collection) {
                            jSONArray.put(l111l11111I1l(obj2));
                        }
                    }
                    return jSONArray;
                } else if (obj.getClass().isArray()) {
                    return l111l11111lIl(obj);
                } else {
                    if (obj instanceof Map) {
                        return l1111l111111Il((Map<?, ?>) obj);
                    }
                    String str = obj;
                    if (!(obj instanceof Boolean)) {
                        str = obj;
                        if (!(obj instanceof Byte)) {
                            str = obj;
                            if (!(obj instanceof Character)) {
                                str = obj;
                                if (!(obj instanceof Double)) {
                                    str = obj;
                                    if (!(obj instanceof Float)) {
                                        str = obj;
                                        if (!(obj instanceof Integer)) {
                                            str = obj;
                                            if (!(obj instanceof Long)) {
                                                str = obj;
                                                if (!(obj instanceof Short)) {
                                                    if (obj instanceof String) {
                                                        return obj;
                                                    }
                                                    if (!obj.getClass().getPackage().getName().startsWith("java.")) {
                                                        return null;
                                                    }
                                                    str = obj.toString();
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    return str;
                }
            } catch (Exception e) {
                return null;
            }
        }
        return obj;
    }

    private static String l111l11111I1l(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        try {
            byte[] digest = MessageDigest.getInstance("MD5").digest(bArr);
            StringBuilder sb = new StringBuilder(digest.length << 1);
            int length = digest.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return sb.toString();
                }
                int i3 = digest[i2] & 255;
                if (i3 < 16) {
                    sb.append("0");
                }
                sb.append(Integer.toHexString(i3));
                i = i2 + 1;
            }
        } catch (NoSuchAlgorithmException e) {
            throw new IOException("fail to md5 data");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.io.Closeable] */
    public static List<String> l111l11111I1l(String str) {
        File file;
        Throwable th;
        ArrayList arrayList = new ArrayList();
        File file2 = new File(str);
        try {
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file2));
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            l1111l111111Il((Closeable) bufferedReader);
                            return arrayList;
                        } else if (!l111l1111lI1l.l1111l111111Il(readLine)) {
                            arrayList.add(readLine);
                        }
                    } catch (Exception e) {
                        e = e;
                        throw new IOException(e);
                    }
                }
            } catch (Exception e2) {
                e = e2;
            } catch (Throwable th2) {
                file = null;
                th = th2;
                l1111l111111Il((Closeable) file);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            file = file2;
            l1111l111111Il((Closeable) file);
            throw th;
        }
    }

    private static Object l111l11111Il(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof JSONObject) {
            return l1111l111111Il((JSONObject) obj);
        }
        List<Object> list = obj;
        if (obj instanceof JSONArray) {
            list = l1111l111111Il((JSONArray) obj);
        }
        return list;
    }

    public static String l111l11111Il(String str) {
        return (str == null || str.isEmpty()) ? "" : str.replaceAll(":", "").toLowerCase();
    }

    public static String l111l11111lIl(byte[] bArr) {
        try {
            return Base64.encodeToString(bArr, 2);
        } catch (Exception e) {
            throw new IOException(e);
        }
    }

    private static List<String> l111l11111lIl(File file, Set<String> set, int i) {
        ArrayList arrayList = new ArrayList();
        if (file.isDirectory() && set != null) {
            if (set.size() == 0) {
                return arrayList;
            }
            String[] list = file.list();
            if (list != null) {
                if (list.length != 0) {
                    HashSet hashSet = new HashSet(set);
                    int length = list.length;
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 >= length) {
                            break;
                        }
                        String str = list[i3];
                        Iterator it = hashSet.iterator();
                        if (i == 0) {
                            while (it.hasNext()) {
                                String str2 = (String) it.next();
                                if (str.contains(str2)) {
                                    arrayList.add(str2);
                                }
                            }
                        } else if (i == 1) {
                            String lowerCase = str.toLowerCase();
                            while (it.hasNext()) {
                                String str3 = (String) it.next();
                                if (lowerCase.contains(str3.toLowerCase())) {
                                    arrayList.add(str3);
                                }
                            }
                        } else if (i == 2) {
                            while (it.hasNext()) {
                                if (Pattern.compile((String) it.next()).matcher(str).find()) {
                                    arrayList.add(str);
                                }
                            }
                        }
                        i2 = i3 + 1;
                    }
                } else {
                    return arrayList;
                }
            }
        }
        return arrayList;
    }

    private static List<String> l111l11111lIl(String str, Set<String> set, int i) {
        return TextUtils.isEmpty(str) ? Collections.emptyList() : l111l11111lIl(new File(str), set, i);
    }

    private static JSONArray l111l11111lIl(Object obj) {
        if (!obj.getClass().isArray()) {
            throw new JSONException("Not a primitive data: " + obj.getClass());
        }
        int length = Array.getLength(obj);
        JSONArray jSONArray = new JSONArray();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return jSONArray;
            }
            jSONArray.put(l111l11111I1l(Array.get(obj, i2)));
            i = i2 + 1;
        }
    }

    public static boolean l111l11111lIl(String str) {
        try {
            return new File(str).exists();
        } catch (Exception e) {
            return false;
        }
    }

    public static String l111l1111l1Il(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return l111l11111I1l(str.getBytes("utf-8"));
        } catch (Exception e) {
            return "";
        }
    }

    public static String l111l1111lI1l(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Matcher matcher = Patterns.DOMAIN_NAME.matcher(str);
        if (matcher.find()) {
            return matcher.group(0);
        }
        return null;
    }

    public static boolean l111l1111lIl(String str) {
        if (str == null) {
            return false;
        }
        return Patterns.IP_ADDRESS.matcher(str).matches();
    }

    public static byte[] l111l1111llIl(String str) {
        try {
            return Base64.decode(str.getBytes("utf-8"), 0);
        } catch (Exception e) {
            throw new IOException(e);
        }
    }

    private static String l11l1111I11l(String str) {
        try {
            return l1111l111111Il(new File(str));
        } catch (Exception e) {
            throw new IOException(e);
        }
    }

    private static String l11l1111I1l(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (Exception e) {
            return "";
        }
    }

    public static boolean l11l1111lIIl(String str) {
        Context context = l111l1111llIl.l1111l111111Il.l111l11111Il;
        if (context == null) {
            return false;
        }
        return Build.VERSION.SDK_INT < 23 || context.checkSelfPermission(str) == 0;
    }
}
