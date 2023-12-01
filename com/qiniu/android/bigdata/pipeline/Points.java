package com.qiniu.android.bigdata.pipeline;

import com.qiniu.android.utils.FastDatePrinter;
import com.qiniu.android.utils.Json;
import java.lang.reflect.Field;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/android/bigdata/pipeline/Points.class */
public final class Points {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/android/bigdata/pipeline/Points$LazyHolder.class */
    public static class LazyHolder {
        private static final FastDatePrinter INSTANCE = new FastDatePrinter("yyyy-MM-dd'T'HH:mm:ss.SSSXXX", Calendar.getInstance().getTimeZone(), Locale.getDefault());

        private LazyHolder() {
        }
    }

    private static String buildString(Object obj) {
        if (obj == null) {
            return null;
        }
        return ((obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Float) || (obj instanceof Double) || (obj instanceof Boolean)) ? obj.toString() : obj instanceof String ? ((String) obj).replace("\n", "\\n").replace("\t", "\\t") : obj instanceof Collection ? Json.encodeList((Collection) obj) : obj instanceof Map ? Json.encodeMap((Map) obj) : obj instanceof Date ? LazyHolder.INSTANCE.format((Date) obj) : obj.toString();
    }

    public static StringBuilder formatPoint(Object obj, StringBuilder sb) {
        Field[] declaredFields = obj.getClass().getDeclaredFields();
        new Points();
        HashMap hashMap = new HashMap();
        int length = declaredFields.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return formatPoint((Map) hashMap, sb);
            }
            Field field = declaredFields[i2];
            try {
                hashMap.put(field.getName(), field.get(obj));
            } catch (IllegalAccessException e) {
            }
            i = i2 + 1;
        }
    }

    public static <V> StringBuilder formatPoint(Map<String, V> map, StringBuilder sb) {
        for (Map.Entry<String, V> entry : map.entrySet()) {
            sb.append(entry.getKey());
            sb.append("=");
            sb.append(buildString(entry.getValue()));
            sb.append("\t");
        }
        sb.replace(sb.length() - 1, sb.length(), "\n");
        return sb;
    }

    public static <V> StringBuilder formatPoints(List<Map<String, V>> list) {
        StringBuilder sb = new StringBuilder();
        for (Map<String, V> map : list) {
            formatPoint((Map) map, sb);
        }
        return sb;
    }

    public static StringBuilder formatPoints(Object[] objArr) {
        StringBuilder sb = new StringBuilder();
        int length = objArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return sb;
            }
            formatPoint(objArr[i2], sb);
            i = i2 + 1;
        }
    }

    public static <V> StringBuilder formatPoints(Map<String, V>[] mapArr) {
        StringBuilder sb = new StringBuilder();
        int length = mapArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return sb;
            }
            formatPoint((Map) mapArr[i2], sb);
            i = i2 + 1;
        }
    }

    public static <V> StringBuilder formatPointsObjects(List<V> list) {
        StringBuilder sb = new StringBuilder();
        for (V v : list) {
            formatPoint(v, sb);
        }
        return sb;
    }
}
