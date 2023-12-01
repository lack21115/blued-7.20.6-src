package com.blued.android.chat.utils;

import android.text.TextUtils;
import androidx.collection.ArrayMap;
import com.blued.android.chat.ChatManager;
import com.blued.android.chat.core.utils.Log;
import com.igexin.push.core.b;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.msgpack.core.MessageBufferPacker;
import org.msgpack.core.MessagePack;
import org.msgpack.core.MessagePacker;
import org.msgpack.core.MessageUnpacker;
import org.msgpack.value.ArrayValue;
import org.msgpack.value.MapValue;
import org.msgpack.value.Value;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/utils/MsgPackHelper.class */
public class MsgPackHelper {
    private static final String TAG = "Chat_MsgPackHelper";

    public static boolean getBooleanValue(Map<String, Object> map, String str) {
        return getBooleanValue(map, str, false);
    }

    public static boolean getBooleanValue(Map<String, Object> map, String str, boolean z) {
        return ((Boolean) getMapValue(map, str, Boolean.class, Boolean.valueOf(z))).booleanValue();
    }

    public static double getDoubleValue(Map<String, Object> map, String str) {
        return getDoubleValue(map, str, 0.0d);
    }

    public static double getDoubleValue(Map<String, Object> map, String str, double d) {
        return ((Double) getMapValue(map, str, Double.class, Double.valueOf(d))).doubleValue();
    }

    public static float getFloatValue(Map<String, Object> map, String str) {
        return getFloatValue(map, str, 0.0f);
    }

    public static float getFloatValue(Map<String, Object> map, String str, float f) {
        return ((Double) getMapValue(map, str, Double.class, Double.valueOf(f))).floatValue();
    }

    public static int getIntValue(Map<String, Object> map, String str) {
        return getIntValue(map, str, 0);
    }

    public static int getIntValue(Map<String, Object> map, String str, int i) {
        return ((Long) getMapValue(map, str, Long.class, Long.valueOf(i))).intValue();
    }

    public static List getListValue(Map<String, Object> map, String str) {
        return (List) getMapValue(map, str, List.class);
    }

    public static long getLongValue(Map<String, Object> map, String str) {
        return getLongValue(map, str, 0L);
    }

    public static long getLongValue(Map<String, Object> map, String str, long j) {
        return ((Long) getMapValue(map, str, Long.class, Long.valueOf(j))).longValue();
    }

    private static <T> T getMapValue(Map<String, Object> map, String str, Class<T> cls) {
        return (T) getMapValue(map, str, cls, null);
    }

    private static <T> T getMapValue(Map<String, Object> map, String str, Class<T> cls, T t) {
        if (map == null) {
            return t;
        }
        T t2 = (T) map.get(str);
        if (t2 != null) {
            if (cls.isAssignableFrom(t2.getClass())) {
                return t2;
            }
            if (cls.isAssignableFrom(Double.class) && (t2 instanceof Long)) {
                return (T) Double.valueOf(((Long) t2).doubleValue());
            }
            try {
            } catch (Exception e) {
                e = e;
            }
            if (cls.isAssignableFrom(Long.class) && (t2 instanceof String)) {
                return (T) Long.valueOf((String) t2);
            }
            if (cls.isAssignableFrom(Double.class) && (t2 instanceof String)) {
                return (T) new Double((String) t2);
            }
            if (cls.isAssignableFrom(String.class) && ((t2 instanceof Long) || (t2 instanceof Double))) {
                return (T) String.valueOf(t2);
            }
            e = null;
            if (cls.isAssignableFrom(Long.class)) {
                e = null;
                if (t2 instanceof Boolean) {
                    return ((Boolean) t2).booleanValue() ? (T) new Long(1L) : (T) new Long(0L);
                }
            }
            String str2 = "'" + str + "' need type:" + cls + ", unknown type:" + t2.getClass().getName() + ", value:" + t2;
            String str3 = str2;
            if (e != null) {
                str3 = str2 + ", castException:" + e;
            }
            if (ChatManager.debug) {
                Log.e(TAG, str3);
            }
            DataUtils.imMsgFieldTypeError(str3);
        }
        return t;
    }

    public static Map getMapValue(Map<String, Object> map, String str) {
        return (Map) getMapValue(map, str, Map.class);
    }

    public static short getShortValue(Map<String, Object> map, String str) {
        return getShortValue(map, str, (short) 0);
    }

    public static short getShortValue(Map<String, Object> map, String str, short s) {
        return ((Long) getMapValue(map, str, Long.class, Long.valueOf(s))).shortValue();
    }

    public static String getStringValue(Map<String, Object> map, String str) {
        return getStringValue(map, str, null);
    }

    public static String getStringValue(Map<String, Object> map, String str, String str2) {
        return (String) getMapValue(map, str, String.class, str2);
    }

    private static void packListValue(MessagePacker messagePacker, List list) throws IOException {
        messagePacker.packArrayHeader(list.size());
        for (Object obj : list) {
            packValue(messagePacker, obj);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static byte[] packMap(Map<String, Object> map) {
        if (map == 0 || map.size() == 0) {
            return null;
        }
        MessageBufferPacker newDefaultBufferPacker = MessagePack.newDefaultBufferPacker();
        try {
            try {
                try {
                    packMapValue(newDefaultBufferPacker, map);
                    newDefaultBufferPacker.flush();
                    byte[] byteArray = newDefaultBufferPacker.toByteArray();
                    newDefaultBufferPacker.close();
                    return byteArray;
                } catch (IOException e) {
                    e.printStackTrace();
                    newDefaultBufferPacker.close();
                    return null;
                }
            } catch (Throwable th) {
                try {
                    newDefaultBufferPacker.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                throw th;
            }
        } catch (IOException e3) {
            e3.printStackTrace();
            return map;
        }
    }

    private static void packMapValue(MessagePacker messagePacker, Map<String, Object> map) throws IOException {
        messagePacker.packMapHeader(map.size());
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            messagePacker.packString(entry.getKey());
            packValue(messagePacker, entry.getValue());
        }
    }

    private static void packValue(MessagePacker messagePacker, Object obj) throws IOException {
        if (obj instanceof Map) {
            packMapValue(messagePacker, (Map) obj);
        } else if (obj instanceof List) {
            packListValue(messagePacker, (List) obj);
        } else if (obj instanceof String) {
            messagePacker.packString((String) obj);
        } else if (obj instanceof Boolean) {
            messagePacker.packBoolean(((Boolean) obj).booleanValue());
        } else if (obj instanceof Short) {
            messagePacker.packShort(((Short) obj).shortValue());
        } else if (obj instanceof Integer) {
            messagePacker.packInt(((Integer) obj).intValue());
        } else if (obj instanceof Long) {
            messagePacker.packLong(((Long) obj).longValue());
        } else if (obj instanceof Float) {
            messagePacker.packFloat(((Float) obj).floatValue());
        } else if (obj instanceof Double) {
            messagePacker.packDouble(((Double) obj).doubleValue());
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("pack failed, invalid value type:");
            sb.append(obj == null ? b.l : obj.getClass().getSimpleName());
            Log.e(TAG, sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Invalid value type:");
            sb2.append(obj == null ? b.l : obj.getClass().getSimpleName());
            messagePacker.packString(sb2.toString());
        }
    }

    public static void putMapValue(Map<String, Object> map, String str, double d) {
        if (map == null || TextUtils.isEmpty(str)) {
            return;
        }
        map.put(str, Double.valueOf(d));
    }

    public static void putMapValue(Map<String, Object> map, String str, long j) {
        if (map == null || TextUtils.isEmpty(str)) {
            return;
        }
        map.put(str, Long.valueOf(j));
    }

    public static void putMapValue(Map<String, Object> map, String str, String str2) {
        if (map == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        map.put(str, str2);
    }

    private static List<Object> unpackArrayValue(ArrayValue arrayValue) {
        ArrayList arrayList = new ArrayList();
        Iterator<Value> it = arrayValue.iterator();
        while (it.hasNext()) {
            arrayList.add(unpackValue(it.next()));
        }
        return arrayList;
    }

    public static Map<String, Object> unpackMap(byte[] bArr, int i, int i2) {
        ArrayMap arrayMap;
        if (i2 <= i) {
            if (ChatManager.debug) {
                Log.e(TAG, "unpackMap failed, data length is invalid, offset:" + i + ", length:" + i2);
                return null;
            }
            return null;
        }
        MessageUnpacker newDefaultUnpacker = MessagePack.newDefaultUnpacker(bArr, i, i2 - i);
        try {
            try {
                int unpackMapHeader = newDefaultUnpacker.unpackMapHeader();
                arrayMap = new ArrayMap();
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= unpackMapHeader) {
                        try {
                            newDefaultUnpacker.close();
                            return arrayMap;
                        } catch (IOException e) {
                            e.printStackTrace();
                            return arrayMap;
                        }
                    }
                    try {
                        arrayMap.put(newDefaultUnpacker.unpackString(), unpackValue(newDefaultUnpacker.unpackValue()));
                        i3 = i4 + 1;
                    } catch (IOException e2) {
                        e = e2;
                        e.printStackTrace();
                        try {
                            newDefaultUnpacker.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                        return arrayMap;
                    }
                }
            } catch (IOException e4) {
                e = e4;
                arrayMap = null;
            }
        } catch (Throwable th) {
            try {
                newDefaultUnpacker.close();
            } catch (IOException e5) {
                e5.printStackTrace();
            }
            throw th;
        }
    }

    private static Map<String, Object> unpackMapValue(MapValue mapValue) {
        ArrayMap arrayMap = new ArrayMap();
        for (Map.Entry<Value, Value> entry : mapValue.entrySet()) {
            if (entry.getKey().isRawValue()) {
                String asString = entry.getKey().asRawValue().asString();
                Object unpackValue = unpackValue(entry.getValue());
                if (!TextUtils.isEmpty(asString) && unpackValue != null) {
                    arrayMap.put(asString, unpackValue);
                }
            }
        }
        return arrayMap;
    }

    private static Object unpackValue(Value value) {
        if (value.isBooleanValue()) {
            return Boolean.valueOf(value.asBooleanValue().getBoolean());
        }
        if (value.isIntegerValue()) {
            return Long.valueOf(value.asIntegerValue().asLong());
        }
        if (value.isFloatValue()) {
            return Double.valueOf(value.asFloatValue().toDouble());
        }
        if (value.isRawValue()) {
            return value.asRawValue().asString();
        }
        if (value.isMapValue()) {
            return unpackMapValue(value.asMapValue());
        }
        if (value.isArrayValue()) {
            return unpackArrayValue(value.asArrayValue());
        }
        return null;
    }

    public void test() {
    }
}
