package com.tramini.plugin.a.e;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.j256.ormlite.stmt.query.SimpleComparison;
import com.tramini.plugin.a.c.a;
import com.tramini.plugin.a.e.f;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/tramini/plugin/a/e/a.class */
public final class a extends f {

    /* renamed from: a  reason: collision with root package name */
    private static final String f26822a = JSONObject.class.getName();

    private static com.tramini.plugin.a.c.a a(Object obj, String str, String[] strArr, JSONObject jSONObject, JSONArray jSONArray, String str2) {
        JSONObject jSONObject2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        JSONObject jSONObject3 = new JSONObject();
        if (obj != null) {
            try {
                jSONArray.put(jSONArray.length(), "pkg");
                HashSet hashSet = new HashSet();
                boolean z = true;
                if (str2.hashCode() == 48 && str2.equals("0")) {
                    z = false;
                }
                if (z) {
                    JSONObject a2 = a(obj, hashSet, strArr[0], str);
                    jSONObject2 = a2;
                    if (a2 != null) {
                        String optString = a2.optString(strArr[0]);
                        jSONObject2 = a2;
                        if (!TextUtils.isEmpty(optString)) {
                            String str12 = "html_unknow";
                            if (optString.contains("div id=\"mys-wrapper\" class=\"mys-wrapper\">")) {
                                if (!optString.contains("https://rr") && !optString.contains(".mp4")) {
                                    str12 = "html_background";
                                }
                                str12 = com.baidu.mobads.sdk.internal.a.f;
                            } else if (optString.contains("html5AdData") && optString.contains("google_template_data")) {
                                str12 = "html_play";
                            } else if (optString.contains("<link") && optString.contains("type=\"text/css")) {
                                str12 = "html_css";
                            } else if (optString.contains("new videoInterstitial") && optString.contains("x3c")) {
                                str12 = "html_x3d";
                            } else if (optString.contains("<!doctype html>")) {
                                str12 = optString.contains("doc.write") ? "html_doctype_write" : "html_doctype";
                            }
                            String d = d(optString, str12);
                            String str13 = "";
                            String str14 = str13;
                            String str15 = str14;
                            int i = 0;
                            while (true) {
                                jSONObject2 = a2;
                                str3 = str13;
                                str4 = str14;
                                str5 = str15;
                                if (i >= jSONArray.length()) {
                                    break;
                                }
                                String str16 = str14;
                                try {
                                    String optString2 = jSONArray.optString(i);
                                    String str17 = str14;
                                    String optString3 = jSONObject.optString(optString2);
                                    String str18 = str14;
                                    if (TextUtils.equals(optString3, "pkg")) {
                                        str9 = optString2;
                                        str10 = str14;
                                        str11 = str15;
                                    } else if (TextUtils.equals(optString3, "all")) {
                                        str9 = str13;
                                        str10 = str14;
                                        str11 = optString2;
                                    } else {
                                        str9 = str13;
                                        str10 = str14;
                                        str11 = str15;
                                        if (!TextUtils.isEmpty(optString3)) {
                                            String str19 = str14;
                                            String a3 = a(d, str12, optString2, jSONObject);
                                            String str20 = str14;
                                            if (TextUtils.equals(optString2, "i_lr")) {
                                                str20 = a3;
                                            }
                                            str9 = str13;
                                            str10 = str20;
                                            str11 = str15;
                                            if (!TextUtils.isEmpty(a3)) {
                                                String str21 = str20;
                                                if (optString2.equals("pkg")) {
                                                    String str22 = str20;
                                                    if (!TextUtils.isEmpty(str13)) {
                                                        String str23 = str20;
                                                        jSONObject3.put(str13, a3);
                                                    }
                                                }
                                                String str24 = str20;
                                                jSONObject3.put(optString2, a3);
                                                str11 = str15;
                                                str10 = str20;
                                                str9 = str13;
                                            }
                                        }
                                    }
                                } catch (Throwable th) {
                                    str9 = str13;
                                    str10 = str16;
                                    str11 = str15;
                                }
                                i++;
                                str13 = str9;
                                str14 = str10;
                                str15 = str11;
                            }
                        }
                    }
                    str3 = "";
                    str4 = str3;
                    str5 = str4;
                } else {
                    JSONObject a4 = a(obj, hashSet, strArr[1], str);
                    String jSONObject4 = a4.toString();
                    jSONObject2 = a4;
                    if (!TextUtils.isEmpty(jSONObject4)) {
                        String d2 = d(jSONObject4, "naitve");
                        String str25 = "";
                        String str26 = str25;
                        String str27 = str26;
                        int i2 = 0;
                        while (true) {
                            jSONObject2 = a4;
                            str3 = str25;
                            str4 = str26;
                            str5 = str27;
                            if (i2 >= jSONArray.length()) {
                                break;
                            }
                            String str28 = str26;
                            try {
                                String optString4 = jSONArray.optString(i2);
                                String str29 = str26;
                                String optString5 = jSONObject.optString(optString4);
                                String str30 = str26;
                                if (TextUtils.equals(optString5, "pkg")) {
                                    str6 = optString4;
                                    str7 = str26;
                                    str8 = str27;
                                } else if (TextUtils.equals(optString5, "all")) {
                                    str6 = str25;
                                    str7 = str26;
                                    str8 = optString4;
                                } else {
                                    str6 = str25;
                                    str7 = str26;
                                    str8 = str27;
                                    if (!TextUtils.isEmpty(optString5)) {
                                        String str31 = str26;
                                        String a5 = a(d2, "naitve", optString4, jSONObject);
                                        String str32 = str26;
                                        if (TextUtils.equals(optString4, "i_lr")) {
                                            str32 = a5;
                                        }
                                        str6 = str25;
                                        str7 = str32;
                                        str8 = str27;
                                        if (!TextUtils.isEmpty(a5)) {
                                            String str33 = str32;
                                            if (optString4.equals("pkg")) {
                                                String str34 = str32;
                                                if (!TextUtils.isEmpty(str25)) {
                                                    String str35 = str32;
                                                    jSONObject3.put(str25, a5);
                                                }
                                            }
                                            String str36 = str32;
                                            jSONObject3.put(optString4, a5);
                                            str8 = str27;
                                            str7 = str32;
                                            str6 = str25;
                                        }
                                    }
                                }
                            } catch (Throwable th2) {
                                str6 = str25;
                                str7 = str28;
                                str8 = str27;
                            }
                            i2++;
                            str25 = str6;
                            str26 = str7;
                            str27 = str8;
                        }
                    }
                    str3 = "";
                    str4 = str3;
                    str5 = str4;
                }
                com.tramini.plugin.a.c.a aVar = new com.tramini.plugin.a.c.a();
                if (jSONObject3.length() <= 0) {
                    if (jSONObject2 == null) {
                        aVar.b = new a.C0898a("1", "");
                        return aVar;
                    }
                    aVar.b = new a.C0898a("2", jSONObject2.toString());
                    return aVar;
                }
                if (!TextUtils.isEmpty(str3) && TextUtils.isEmpty(jSONObject3.optString(str3, "")) && !TextUtils.isEmpty(str4)) {
                    String b = b(str4);
                    if (TextUtils.isEmpty(b)) {
                        String a6 = a(str4);
                        if (!TextUtils.isEmpty(a6)) {
                            jSONObject3.put(str3, a6);
                        }
                    } else {
                        jSONObject3.put(str3, b);
                    }
                }
                if (jSONObject2 != null && !TextUtils.isEmpty(str5)) {
                    jSONObject3.put(str5, com.tramini.plugin.a.g.c.a(jSONObject2.toString().getBytes()));
                }
                aVar.f26807a = jSONObject3;
                return aVar;
            } catch (Throwable th3) {
                return null;
            }
        }
        return null;
    }

    public static com.tramini.plugin.a.c.a a(JSONObject jSONObject, com.tramini.plugin.a.c.c cVar, String str, String str2) {
        return a(a(jSONObject.optString("in_na"), str), jSONObject.optString("pre"), a(jSONObject.optJSONArray("p_key")), jSONObject, cVar.e, str2);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static String a(String str, String str2, String str3, JSONObject jSONObject) {
        boolean z;
        switch (str2.hashCode()) {
            case -1852354744:
                if (str2.equals("html_play")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case -1851164744:
                if (str2.equals("html_unknow")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case -1747666366:
                if (str2.equals("html_background")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case -1052935859:
                if (str2.equals("naitve")) {
                    z = false;
                    break;
                }
                z = true;
                break;
            case -336860305:
                if (str2.equals("html_css")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case -336842123:
                if (str2.equals("html_x3d")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 3213227:
                if (str2.equals(com.baidu.mobads.sdk.internal.a.f)) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 45377598:
                if (str2.equals("html_doctype_write")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 562203614:
                if (str2.equals("html_doctype")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            default:
                z = true;
                break;
        }
        switch (z) {
            case false:
                return e(jSONObject.optJSONObject(str3).optString("0"), str);
            case true:
                return e(jSONObject.optJSONObject(str3).optString("1"), str);
            case true:
                return e(jSONObject.optJSONObject(str3).optString("2"), str);
            case true:
                return e(jSONObject.optJSONObject(str3).optString("5"), str);
            case true:
                return e(jSONObject.optJSONObject(str3).optString("7"), str);
            case true:
                String optString = jSONObject.optString("3");
                String optString2 = jSONObject.optString("4");
                String a2 = f.b.a(str, optString);
                if (TextUtils.isEmpty(a2)) {
                    return e(jSONObject.optJSONObject(str3).optString("4"), f.b.a(str, optString2));
                }
                return e(jSONObject.optJSONObject(str3).optString("3"), d(a2));
            case true:
                String a3 = f.b.a(str, jSONObject.optString("6"));
                if (TextUtils.isEmpty(a3)) {
                    return "";
                }
                return e(jSONObject.optJSONObject(str3).optString("3"), d(a3));
            case true:
                return e(jSONObject.optJSONObject(str3).optString("2"), f.b.a(str, jSONObject.optString("8")));
            default:
                return e(jSONObject.optJSONObject(str3).optString("9"), str);
        }
    }

    private static JSONObject a(Object obj, Set<Object> set, String str, String str2) {
        Class<? super Object> superclass;
        if (obj == null || set.contains(obj)) {
            return null;
        }
        set.add(obj);
        Class<?> cls = obj.getClass();
        ArrayList<Field> arrayList = new ArrayList();
        do {
            arrayList.addAll(Arrays.asList(cls.getDeclaredFields()));
            superclass = cls.getSuperclass();
            cls = superclass;
        } while (superclass.getName().startsWith(str2));
        for (Field field : arrayList) {
            field.setAccessible(true);
            try {
                Object obj2 = field.get(obj);
                if (obj2 != null) {
                    if (!field.getType().getName().equals("interface") && !obj2.getClass().getName().startsWith(str2)) {
                        if (field.getType().getName().equals(f26822a)) {
                            JSONObject jSONObject = (JSONObject) obj2;
                            if (jSONObject.has(str)) {
                                return jSONObject;
                            }
                        } else {
                            continue;
                        }
                    }
                    JSONObject a2 = a(obj2, set, str, str2);
                    if (a2 != null) {
                        return a2;
                    }
                }
            } catch (Throwable th) {
                return null;
            }
        }
        return null;
    }

    private static String[] a(JSONArray jSONArray) {
        String[] strArr;
        try {
            int length = jSONArray.length();
            String[] strArr2 = new String[length];
            int i = 0;
            while (true) {
                int i2 = i;
                strArr = strArr2;
                if (i2 >= length) {
                    break;
                }
                try {
                    strArr2[i2] = jSONArray.getString(i2);
                    i = i2 + 1;
                } catch (JSONException e) {
                    return strArr2;
                }
            }
        } catch (JSONException e2) {
            strArr = null;
        }
        return strArr;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static String d(String str, String str2) {
        boolean z;
        switch (str2.hashCode()) {
            case -1852354744:
                if (str2.equals("html_play")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case -1052935859:
                if (str2.equals("naitve")) {
                    z = false;
                    break;
                }
                z = true;
                break;
            case -336842123:
                if (str2.equals("html_x3d")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 45377598:
                if (str2.equals("html_doctype_write")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            default:
                z = true;
                break;
        }
        return z ? (z || z) ? e(c(str.replace("\\\\\\\\x", "%").replaceAll("\\\\x", "%").replaceAll("\\\\n", ""))) : !z ? e(c(str)) : e(c(str.replace("x22", "\"").replace("x26", ContainerUtils.FIELD_DELIMITER).replace("x27", "'").replace("x3c", SimpleComparison.LESS_THAN_OPERATION).replace("x3d", "=").replace("x3e", SimpleComparison.GREATER_THAN_OPERATION))) : str.replace("\\/", "/");
    }

    private static String e(String str) {
        return str.replaceAll("&amp;", ContainerUtils.FIELD_DELIMITER).replaceAll("&quot;", "\"");
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x00d0 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00d2 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String e(java.lang.String r4, java.lang.String r5) {
        /*
            Method dump skipped, instructions count: 227
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tramini.plugin.a.e.a.e(java.lang.String, java.lang.String):java.lang.String");
    }
}
