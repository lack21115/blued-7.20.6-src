package com.tramini.plugin.a.e;

import android.text.TextUtils;
import com.j256.ormlite.stmt.query.SimpleComparison;
import com.tramini.plugin.a.e.f;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/tramini/plugin/a/e/h.class */
public final class h extends f {
    private static com.tramini.plugin.a.c.a a(Object obj, String str, final String str2, final String str3, final String str4, final String str5, final String str6, String str7, String str8, JSONObject jSONObject, JSONArray jSONArray) {
        try {
            Object a2 = a(obj, str, new StringBuffer(), new f.c() { // from class: com.tramini.plugin.a.e.h.1
                @Override // com.tramini.plugin.a.e.f.c
                public final boolean a(Object obj2) {
                    return obj2 instanceof Map;
                }

                @Override // com.tramini.plugin.a.e.f.c
                public final f.a b(Object obj2) {
                    Object obj3;
                    Map map = (Map) obj2;
                    if (map == null || map.size() == 0) {
                        return f.a.a();
                    }
                    if (map.containsKey(str5) && (obj3 = map.get(str5)) != null) {
                        return obj3.getClass().getName().contains(str2) ? f.a.a(obj3) : f.a.b(obj3);
                    }
                    return f.a.a();
                }
            });
            Object a3 = a2 == null ? null : a(a2, str, new StringBuffer(), new f.c() { // from class: com.tramini.plugin.a.e.h.2
                @Override // com.tramini.plugin.a.e.f.c
                public final boolean a(Object obj2) {
                    return obj2 instanceof Map;
                }

                @Override // com.tramini.plugin.a.e.f.c
                public final f.a b(Object obj2) {
                    Object value;
                    Map map = (Map) obj2;
                    if (map == null || map.size() == 0) {
                        return f.a.a();
                    }
                    Iterator it = map.entrySet().iterator();
                    if (it.hasNext() && (value = ((Map.Entry) it.next()).getValue()) != null) {
                        return value.getClass().getSimpleName().contains(str3) ? f.a.a(value) : f.a.b(value);
                    }
                    return f.a.a();
                }
            });
            if (a3 == null) {
                return null;
            }
            final StringBuffer stringBuffer = new StringBuffer();
            Object a4 = a(a3, str4, stringBuffer, new f.c() { // from class: com.tramini.plugin.a.e.h.3
                @Override // com.tramini.plugin.a.e.f.c
                public final boolean a(Object obj2) {
                    return obj2.getClass().getName().startsWith(str4);
                }

                @Override // com.tramini.plugin.a.e.f.c
                public final f.a b(Object obj2) {
                    try {
                        return (str6 == null || !str6.contains(obj2.getClass().getName())) ? f.a.b(obj2) : f.a.a(obj2);
                    } catch (Throwable th) {
                        return f.a.a();
                    }
                }
            });
            Object a5 = a4 != null ? a4 : a(a3, str4, new StringBuffer(), new f.c() { // from class: com.tramini.plugin.a.e.h.4
                @Override // com.tramini.plugin.a.e.f.c
                public final boolean a(Object obj2) {
                    return obj2 instanceof Map;
                }

                @Override // com.tramini.plugin.a.e.f.c
                public final f.a b(Object obj2) {
                    Map map;
                    Object obj3;
                    try {
                        map = (Map) obj2;
                    } catch (Throwable th) {
                    }
                    if (map != null && map.size() > 0) {
                        if (map.containsKey(str5) && (obj3 = map.get(str5)) != null) {
                            Object a6 = f.a(obj3, str4, stringBuffer, new f.c() { // from class: com.tramini.plugin.a.e.h.4.1
                                @Override // com.tramini.plugin.a.e.f.c
                                public final boolean a(Object obj4) {
                                    return obj4.getClass().getName().startsWith(str4);
                                }

                                @Override // com.tramini.plugin.a.e.f.c
                                public final f.a b(Object obj4) {
                                    return (str6 == null || !str6.contains(obj4.getClass().getName())) ? f.a.b(obj4) : f.a.a(obj4);
                                }
                            });
                            if (a6 != null) {
                                return f.a.a(a6);
                            }
                            return f.a.a();
                        }
                        return f.a.a();
                    }
                    return f.a.a();
                }
            });
            if (a5 == null) {
                return null;
            }
            return a(a5, str7, str8, jSONObject, jSONArray);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private static com.tramini.plugin.a.c.a a(Object obj, String str, String str2, JSONObject jSONObject, JSONArray jSONArray) {
        Object obj2;
        Object obj3;
        try {
            String[] split = str2.split(":");
            if (split.length != 2) {
                return null;
            }
            try {
                List list = (List) b(obj, str);
                Object obj4 = null;
                int i = 0;
                while (true) {
                    obj2 = obj4;
                    try {
                        if (i >= list.size()) {
                            break;
                        }
                        Object obj5 = list.get(i);
                        obj2 = obj5;
                        if (obj5 != null) {
                            break;
                        }
                        i++;
                        obj4 = obj5;
                    } catch (Exception e) {
                        obj2 = obj4;
                    }
                }
            } catch (Exception e2) {
                obj2 = null;
            }
            Object a2 = a(b(obj2, split[0]), split[1]);
            JSONObject jSONObject2 = new JSONObject();
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= jSONArray.length()) {
                    break;
                }
                String optString = jSONArray.optString(i3);
                String optString2 = jSONObject.optString(optString);
                if (!TextUtils.isEmpty(optString2)) {
                    Object obj6 = a2;
                    try {
                        String str3 = (String) b(obj, optString2);
                        Object obj7 = a2;
                        if (TextUtils.isEmpty(str3)) {
                            String str4 = (String) b(obj2, optString2);
                            Object obj8 = a2;
                            if (TextUtils.isEmpty(str4)) {
                                obj3 = a2;
                                if (a2 instanceof String) {
                                    Object obj9 = a2;
                                    String obj10 = a2.toString();
                                    Object obj11 = a2;
                                    JSONArray jSONArray2 = new JSONArray(optString2);
                                    int i4 = 0;
                                    boolean z = false;
                                    while (true) {
                                        obj3 = a2;
                                        if (i4 >= jSONArray2.length()) {
                                            break;
                                        }
                                        Object obj12 = a2;
                                        Matcher matcher = Pattern.compile(jSONArray2.optString(i4)).matcher(obj10);
                                        while (true) {
                                            Object obj13 = a2;
                                            if (!matcher.find()) {
                                                break;
                                            }
                                            Object obj14 = a2;
                                            String group = matcher.group();
                                            Object obj15 = a2;
                                            int indexOf = group.indexOf(SimpleComparison.GREATER_THAN_OPERATION);
                                            Object obj16 = a2;
                                            int indexOf2 = group.indexOf(SimpleComparison.LESS_THAN_OPERATION);
                                            Object obj17 = a2;
                                            if (indexOf != -1 && indexOf2 != -1) {
                                                try {
                                                    String substring = group.substring(indexOf + 1, indexOf2);
                                                    if (!TextUtils.isEmpty(substring)) {
                                                        jSONObject2.put(optString, substring);
                                                        z = true;
                                                        break;
                                                    }
                                                } catch (Throwable th) {
                                                    a2 = obj17;
                                                }
                                            }
                                            a2 = obj17;
                                        }
                                        Object obj18 = a2;
                                        a2 = obj18;
                                        if (!z) {
                                            i4++;
                                            a2 = obj18;
                                        }
                                    }
                                }
                            } else {
                                Object obj19 = a2;
                                jSONObject2.put(optString, str4);
                                obj3 = a2;
                            }
                        } else {
                            Object obj20 = a2;
                            jSONObject2.put(optString, str3);
                            obj3 = a2;
                        }
                    } catch (Throwable th2) {
                        obj3 = obj6;
                    }
                    a2 = obj3;
                    i2 = i3 + 1;
                }
                obj3 = a2;
                a2 = obj3;
                i2 = i3 + 1;
            }
            if (jSONObject2.length() > 0) {
                com.tramini.plugin.a.c.a aVar = new com.tramini.plugin.a.c.a();
                aVar.f26807a = jSONObject2;
                return aVar;
            }
            return null;
        } catch (Throwable th3) {
            return null;
        }
    }

    public static com.tramini.plugin.a.c.a a(JSONObject jSONObject, com.tramini.plugin.a.c.c cVar, String str) {
        com.tramini.plugin.a.c.a a2;
        String optString = jSONObject.optString("pre1");
        String optString2 = jSONObject.optString("pre2");
        String optString3 = jSONObject.optString("clna");
        String optString4 = jSONObject.optString("mena");
        String optString5 = jSONObject.optString("adaptna");
        String optString6 = jSONObject.optString("ctrlna");
        String optString7 = jSONObject.optString("in_na");
        String optString8 = jSONObject.optString("objna_arr");
        String optString9 = jSONObject.optString("obj2na");
        String optString10 = jSONObject.optString(com.baidu.mobads.sdk.internal.a.f);
        Object d = d(optString7, str);
        String str2 = d instanceof String ? (String) d : null;
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        String[] split = optString3.split(",");
        int length = split.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return null;
            }
            Object b = b(split[i2], optString4);
            if (b != null && (a2 = a(b, optString, optString6, optString5, optString2, str2, optString8, optString9, optString10, jSONObject, cVar.e)) != null) {
                return a2;
            }
            i = i2 + 1;
        }
    }

    private static Object d(String str, String str2) {
        Map map;
        try {
            Object invoke = Class.forName(str).getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
            Field[] declaredFields = invoke.getClass().getDeclaredFields();
            if (declaredFields != null) {
                for (Field field : declaredFields) {
                    field.setAccessible(true);
                    if ((field.get(invoke) instanceof Map) && (map = (Map) field.get(invoke)) != null && map.containsKey(str2)) {
                        return map.get(str2);
                    }
                }
                return null;
            }
            return null;
        } catch (Throwable th) {
            return null;
        }
    }
}
