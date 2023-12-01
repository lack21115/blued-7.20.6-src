package mtopsdk.mtop.util;

import com.alibaba.fastjson.JSON;
import com.alipay.sdk.util.i;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.domain.IMTOPDataObject;
import mtopsdk.mtop.domain.MtopRequest;

/* loaded from: source-3503164-dex2jar.jar:mtopsdk/mtop/util/ReflectUtil.class */
public class ReflectUtil {
    public static String a(Map map) {
        StringBuilder sb = new StringBuilder(64);
        sb.append("{");
        if (map != null && !map.isEmpty()) {
            for (Map.Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                String str2 = (String) entry.getValue();
                if (str != null && str2 != null) {
                    try {
                        sb.append(JSON.toJSONString(str));
                        sb.append(":");
                        sb.append(JSON.toJSONString(str2));
                        sb.append(",");
                    } catch (Throwable th) {
                        TBSdkLog.d("mtopsdk.ReflectUtil", "[converMapToDataStr] convert key=" + str + ",value=" + str2 + " to dataStr error ---" + th.toString());
                    }
                }
            }
            int length = sb.length();
            if (length > 1) {
                sb.deleteCharAt(length - 1);
            }
        }
        sb.append(i.d);
        return sb.toString();
    }

    public static MtopRequest a(Object obj) {
        MtopRequest mtopRequest = new MtopRequest();
        if (obj != null) {
            a(mtopRequest, obj);
        }
        return mtopRequest;
    }

    public static MtopRequest a(IMTOPDataObject iMTOPDataObject) {
        MtopRequest mtopRequest = new MtopRequest();
        if (iMTOPDataObject != null) {
            a(mtopRequest, iMTOPDataObject);
        }
        return mtopRequest;
    }

    private static void a(MtopRequest mtopRequest, Object obj) {
        try {
            HashMap hashMap = new HashMap();
            Class<?> cls = obj.getClass();
            HashSet hashSet = new HashSet();
            hashSet.addAll(Arrays.asList(cls.getFields()));
            hashSet.addAll(Arrays.asList(cls.getDeclaredFields()));
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                Field field = (Field) it.next();
                String name = field.getName();
                if (name.indexOf("$") == -1 && !name.equals("serialVersionUID") && !name.equals("ORIGINALJSON")) {
                    boolean z = true;
                    field.setAccessible(true);
                    if (name.equals("API_NAME")) {
                        Object obj2 = field.get(obj);
                        if (obj2 != null) {
                            mtopRequest.a(obj2.toString());
                        }
                    } else if (name.equals("VERSION")) {
                        Object obj3 = field.get(obj);
                        if (obj3 != null) {
                            mtopRequest.b(obj3.toString());
                        }
                    } else if (name.equals("NEED_ECODE")) {
                        Boolean valueOf = Boolean.valueOf(field.getBoolean(obj));
                        if (valueOf == null || !valueOf.booleanValue()) {
                            z = false;
                        }
                        mtopRequest.a(z);
                    } else if (name.equals("NEED_SESSION")) {
                        Boolean valueOf2 = Boolean.valueOf(field.getBoolean(obj));
                        mtopRequest.b(valueOf2 != null && valueOf2.booleanValue());
                    } else {
                        Object obj4 = field.get(obj);
                        if (obj4 != null) {
                            hashMap.put(name, obj4 instanceof String ? obj4.toString() : JSON.toJSONString(obj4));
                        }
                    }
                }
            }
            mtopRequest.f43745a = hashMap;
            mtopRequest.c(a((Map) hashMap));
        } catch (Exception e) {
            TBSdkLog.b("mtopsdk.ReflectUtil", "parseParams failed.", e);
        }
    }
}
