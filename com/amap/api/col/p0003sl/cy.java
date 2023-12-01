package com.amap.api.col.p0003sl;

import android.graphics.Color;
import android.text.TextUtils;
import com.android.internal.content.NativeLibraryHelper;
import com.autonavi.base.ae.gmap.style.StyleElement;
import com.autonavi.base.ae.gmap.style.StyleItem;
import com.autonavi.base.amap.mapcore.Convert;
import com.autonavi.base.amap.mapcore.FileUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.amap.api.col.3sl.cy  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/cy.class */
public final class cy {
    private static final int[] d = {1};
    private int b = 0;
    private int c = -1;
    List<cu> a = null;

    public static int a(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        String str2 = str;
        try {
            if (!str.startsWith("#")) {
                str2 = "#".concat(String.valueOf(str));
            }
            return Color.parseColor(str2);
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    public static cv a(byte[] bArr) {
        cv cvVar;
        cv cvVar2;
        try {
            cvVar2 = new cv();
        } catch (Throwable th) {
            th = th;
            cvVar = null;
        }
        try {
            byte[] bytes = "l".getBytes("utf-8");
            int length = bArr.length;
            int length2 = bytes.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    cvVar2.a(Convert.getString(bArr, 0, 4));
                    cvVar2.b(Convert.getString(bArr, 4, 32));
                    cvVar2.c(Convert.getString(bArr, 36, 10));
                    cvVar2.d(a(Convert.getSubBytes(bArr, 78, length - 78), Convert.getSubBytes(bArr, 46, 16), Convert.getSubBytes(bArr, 62, 16)));
                    return cvVar2;
                }
                bArr[i2] = (byte) (bytes[i2 % length2] ^ bArr[i2]);
                i = i2 + 1;
            }
        } catch (Throwable th2) {
            cvVar = cvVar2;
            th = th2;
            th.printStackTrace();
            return cvVar;
        }
    }

    private static StyleElement a(Map<Integer, StyleItem> map, int i, int i2, cu cuVar) {
        StyleItem styleItem = map.get(Integer.valueOf(i));
        StyleItem styleItem2 = styleItem;
        if (styleItem == null) {
            styleItem2 = new StyleItem(cuVar.c);
            styleItem2.mainKey = cuVar.a;
            styleItem2.subKey = cuVar.b;
            map.put(Integer.valueOf(i), styleItem2);
        }
        StyleElement styleElement = styleItem2.get(i2);
        StyleElement styleElement2 = styleElement;
        if (styleElement == null) {
            styleElement2 = new StyleElement();
            styleElement2.styleElementType = i2;
            styleItem2.put(i2, styleElement2);
        }
        return styleElement2;
    }

    private static String a(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        try {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr3);
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            cipher.init(2, secretKeySpec, ivParameterSpec);
            return new String(cipher.doFinal(bArr), "utf-8");
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private List<cu> a(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        for (cu cuVar : this.a) {
            if (cuVar != null) {
                if (cuVar.e != null && cuVar.e.equals(str2)) {
                    arrayList.add(cuVar);
                } else if (cuVar.e != null && cuVar.e.equals(str) && cuVar.f != null && cuVar.f.contains(str2)) {
                    arrayList.add(cuVar);
                }
            }
        }
        return arrayList;
    }

    private void a(cz czVar) {
        if (this.c != -1) {
            Map<Integer, StyleItem> a = czVar.a();
            for (cu cuVar : a("roads", "trafficRoadBackgroundColor")) {
                a(a, cuVar.d, cw.a("fillColor"), cuVar).value = this.c;
                a(a, cuVar.d, cw.a("strokeColor"), cuVar).value = this.c;
            }
        }
    }

    private void a(cz czVar, byte[] bArr, boolean z) {
        cv a = a(bArr);
        if (a == null || a.a() == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(a.a());
            JSONArray names = jSONObject.names();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= names.length()) {
                    return;
                }
                String string = names.getString(i2);
                if (string == null || !string.trim().equals("sdkTextures")) {
                    if (string == null || !string.trim().equals("background")) {
                        JSONObject optJSONObject = jSONObject.optJSONObject(string);
                        if (optJSONObject != null) {
                            a(string, czVar.a(), optJSONObject, z);
                        }
                    } else {
                        this.b = a("#".concat(String.valueOf(jSONObject.optString("background"))));
                    }
                }
                i = i2 + 1;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void a(String str, String str2, Map<Integer, StyleItem> map, JSONObject jSONObject, boolean z) throws JSONException {
        if (jSONObject == null) {
            return;
        }
        if (this.a == null) {
            this.a = b();
        }
        List<cu> a = a(str, str2);
        for (cu cuVar : a) {
            if (cuVar == null || cuVar.c == -1000) {
                return;
            }
            int i = cuVar.d;
            if (jSONObject.optBoolean("visible", true)) {
                if (!jSONObject.optBoolean("showIcon", true)) {
                    a(map, i, cw.a("textFillColor"), cuVar).textureId = -1;
                }
                if (!jSONObject.optBoolean("showLabel", true)) {
                    a(map, i, cw.a("textFillColor"), cuVar).opacity = 0.0f;
                    StyleElement a2 = a(map, i, cw.a("textStrokeColor"), cuVar);
                    a2.opacity = 0.0f;
                    a2.visible = 0;
                    a2.textureId = -1;
                }
                a(map, jSONObject, "color", "opacity", i, cuVar);
                a(map, jSONObject, "fillColor", "fillOpacity", i, cuVar);
                a(map, jSONObject, "strokeColor", "strokeOpacity", i, cuVar);
                a(map, jSONObject, "textFillColor", "textFillOpacity", i, cuVar);
                a(map, jSONObject, "textStrokeColor", "textStrokeOpacity", i, cuVar);
                a(map, jSONObject, "backgroundColor", "backgroundOpacity", i, cuVar);
                if (z) {
                    a(map, jSONObject, "textureName", i, cuVar);
                }
            } else {
                StyleElement a3 = a(map, i, cw.a("visible"), cuVar);
                a3.textureId = -1;
                a3.visible = 0;
            }
        }
        a.clear();
    }

    private void a(String str, Map<Integer, StyleItem> map, JSONObject jSONObject, boolean z) throws JSONException {
        if (jSONObject == null) {
            return;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("subType");
        if (optJSONObject == null) {
            a(str, str, map, jSONObject, z);
            return;
        }
        JSONArray names = optJSONObject.names();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= names.length()) {
                return;
            }
            String optString = names.optString(i2);
            JSONObject optJSONObject2 = optJSONObject.optJSONObject(optString);
            if (optJSONObject2.has("detailedType")) {
                JSONObject optJSONObject3 = optJSONObject2.optJSONObject("detailedType");
                if (optJSONObject3 != null) {
                    JSONArray names2 = optJSONObject3.names();
                    int i3 = 0;
                    while (true) {
                        int i4 = i3;
                        if (i4 < names2.length()) {
                            String optString2 = names2.optString(i4);
                            JSONObject optJSONObject4 = optJSONObject3.optJSONObject(optString2);
                            if (optJSONObject4 != null) {
                                a(str, optString2, map, optJSONObject4, z);
                            }
                            i3 = i4 + 1;
                        }
                    }
                }
            } else {
                a(str, optString, map, optJSONObject2, z);
            }
            i = i2 + 1;
        }
    }

    private static void a(Map<Integer, StyleItem> map, JSONObject jSONObject, int i, int i2, cu cuVar) throws JSONException {
        int a;
        StyleElement a2 = a(map, i, i2, cuVar);
        JSONObject optJSONObject = jSONObject.optJSONObject("stylers");
        if (optJSONObject == null || (a = a(optJSONObject.optString("color"))) == 0) {
            return;
        }
        a2.value = a;
        a2.textureId = optJSONObject.optInt("textureName", 0);
        a2.lineWidth = optJSONObject.optInt("lineWidth", 0);
        if (i >= 30 && i <= 38) {
            a(map, i, 4, cuVar).opacity = 0.1f;
        } else if (cuVar.e != null && cuVar.e.equals("water") && i2 == 3) {
            a(map, i, 2, cuVar).value = a;
        }
    }

    private static void a(Map<Integer, StyleItem> map, JSONObject jSONObject, String str, int i, cu cuVar) {
        try {
            int optInt = jSONObject.optInt(str, 0);
            if (optInt == 0) {
                return;
            }
            a(map, i, cw.a(str), cuVar).textureId = optInt;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private static void a(Map<Integer, StyleItem> map, JSONObject jSONObject, String str, String str2, int i, cu cuVar) {
        try {
            String optString = jSONObject.optString(str, null);
            float f = 1.0f;
            int i2 = 0;
            if (TextUtils.isEmpty(optString)) {
                f = (float) jSONObject.optDouble(str2, 1.0d);
            } else {
                i2 = a("#".concat(String.valueOf(optString)));
            }
            if (i2 == 0 && f == 1.0d) {
                return;
            }
            int a = cw.a(str);
            StyleElement a2 = a(map, i, a, cuVar);
            a2.value = i2;
            a2.opacity = f;
            if (cuVar.f != null && cuVar.f.equals("China")) {
                a(map, i, a, cuVar).opacity = 0.0f;
            } else if (cuVar.e != null && cuVar.e.equals("water") && a == 3) {
                StyleElement a3 = a(map, i, 2, cuVar);
                a3.value = i2;
                a3.opacity = f;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void a(Map<Integer, StyleItem> map, JSONObject jSONObject, String str, String[] strArr, int i) throws JSONException {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= strArr.length) {
                return;
            }
            String str2 = strArr[i3];
            if (this.a == null) {
                this.a = b();
            }
            for (cu cuVar : a(str, str2)) {
                a(map, jSONObject, cuVar.d, i, cuVar);
            }
            i2 = i3 + 1;
        }
    }

    private static void a(JSONArray jSONArray, String str, String str2, String str3, List<cu> list) {
        int[] iArr;
        if (jSONArray == null) {
            return;
        }
        int length = jSONArray.length();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            JSONObject optJSONObject = jSONArray.optJSONObject(i2);
            if (optJSONObject != null) {
                int optInt = optJSONObject.optInt("mainkey");
                JSONArray optJSONArray = optJSONObject.optJSONArray("subkey");
                if (optJSONArray != null) {
                    int length2 = optJSONArray.length();
                    iArr = new int[length2];
                    int i3 = 0;
                    while (true) {
                        int i4 = i3;
                        if (i4 >= length2) {
                            break;
                        }
                        iArr[i4] = optJSONArray.optInt(i4);
                        i3 = i4 + 1;
                    }
                } else {
                    iArr = new int[0];
                }
                list.add(new cu(optInt, iArr, str, str2, str3));
            }
            i = i2 + 1;
        }
    }

    private boolean a(Map<Integer, StyleItem> map, byte[] bArr) {
        String[] a;
        int a2;
        try {
            JSONArray jSONArray = new JSONArray(new String(bArr, "UTF-8"));
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= jSONArray.length()) {
                    return true;
                }
                JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                String optString = optJSONObject.optString("featureType");
                if (!TextUtils.isEmpty(optString)) {
                    if ("background".equals(optString)) {
                        JSONObject optJSONObject2 = optJSONObject.optJSONObject("stylers");
                        if (optJSONObject2 != null && (a2 = a(optJSONObject2.optString("color"))) != 0) {
                            this.b = a2;
                        }
                    } else {
                        String b = cx.b(optString);
                        if (b != null && (a = cx.a(optString)) != null && a.length != 0) {
                            String optString2 = optJSONObject.optString("elementType");
                            if (!TextUtils.isEmpty(optString2)) {
                                int a3 = cw.a(optString2);
                                if (a3 != -1) {
                                    a(map, optJSONObject, b, a, a3);
                                }
                            }
                        }
                    }
                }
                i = i2 + 1;
            }
        } catch (JSONException e) {
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    private cz b(String str, boolean z) {
        try {
            return b(FileUtil.readFileContents(str), z);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private cz b(byte[] bArr, boolean z) {
        cz czVar = new cz();
        try {
            if (!a(czVar.a(), bArr)) {
                a(czVar, bArr, z);
            }
            a(czVar);
            czVar.b();
            return czVar;
        } catch (Throwable th) {
            th.printStackTrace();
            return czVar;
        }
    }

    private List<cu> b() {
        JSONArray jSONArray;
        JSONArray jSONArray2;
        JSONObject jSONObject;
        String str;
        String str2;
        JSONObject jSONObject2;
        JSONArray jSONArray3;
        int i;
        JSONObject optJSONObject;
        String str3 = "name";
        String str4 = "subType";
        this.a = new ArrayList();
        try {
            jSONArray = new JSONArray("[{\n\t\"regions\": {\n\t\t\"name\": \"区域面\",\n\t\t\"subType\": {\n\t\t\t\"land\": {\n\t\t\t\t\"name\": \"陆地\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 30001,\n\t\t\t\t\t\"subkey\": [1, 4, 5]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"green\": {\n\t\t\t\t\"name\": \"绿地\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 30001,\n\t\t\t\t\t\"subkey\": [3, 7, 8, 9, 10, 12]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"edu\": {\n\t\t\t\t\"name\": \"教育体育\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 30002,\n\t\t\t\t\t\"subkey\": [3, 31]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"public\": {\n\t\t\t\t\"name\": \"公共设施\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 30002,\n\t\t\t\t\t\"subkey\": [4, 12, 22, 32]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"traffic\": {\n\t\t\t\t\"name\": \"交通枢纽\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 30002,\n\t\t\t\t\t\"subkey\": [6, 14, 40]\n\t\t\t\t}, {\n\t\t\t\t\t\"mainkey\": 30004\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"scenicSpot\": {\n\t\t\t\t\"name\": \"景区\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 30002,\n\t\t\t\t\t\"subkey\": [5, 33]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"culture\": {\n\t\t\t\t\"name\": \"文化\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 30002,\n\t\t\t\t\t\"subkey\": [7, 35]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"health\": {\n\t\t\t\t\"name\": \"医疗卫生\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 30002,\n\t\t\t\t\t\"subkey\": [8, 36]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"sports\": {\n\t\t\t\t\"name\": \"运动场所\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 30002,\n\t\t\t\t\t\"subkey\": [9, 10, 13, 19, 20, 21, 34, 37, 39]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"business\": {\n\t\t\t\t\"name\": \"商业场所\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 30002,\n\t\t\t\t\t\"subkey\": [11, 23, 24, 25, 26, 27, 28, 29, 30, 38]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"parkingLot\": {\n\t\t\t\t\"name\": \"停车场\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 30002,\n\t\t\t\t\t\"subkey\": [1]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"subway\": {\n\t\t\t\t\"name\": \"地铁设施\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 30003\n\t\t\t\t}]\n\t\t\t}\n\t\t}\n\t},\n\t\"water\": {\n\t\t\"name\": \"水系\",\n\t\t\"styleMap\": [{\n\t\t\t\"mainkey\": 30001,\n\t\t\t\"subkey\": [2, 6, 11, 13]\n\t\t}, {\n\t\t\t\"mainkey\": 20014\n\t\t}, {\n\t\t\t\"mainkey\": 10002,\n\t\t\t\"subkey\": [13]\n\t\t}]\n\t},\n\t\"buildings\": {\n\t\t\"name\": \"建筑物\",\n\t\t\"styleMap\": [{\n\t\t\t\"mainkey\": 50001\n\t\t}, {\n\t\t\t\"mainkey\": 50002\n\t\t}, {\n\t\t\t\"mainkey\": 50003\n\t\t}, {\n\t\t\t\"mainkey\": 50004\n\t\t}, {\n\t\t\t\"mainkey\": 30002,\n\t\t\t\"subkey\": [2, 15, 16, 17, 18]\n\t\t}]\n\t},\n\t\"roads\": {\n\t\t\"name\": \"道路\",\n\t\t\"subType\": {\n\t\t\t\"highWay\": {\n\t\t\t\t\"name\": \"高速公路\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20001\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"ringRoad\": {\n\t\t\t\t\"name\": \"城市环线\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20002\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"nationalRoad\": {\n\t\t\t\t\"name\": \"国道\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20003\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"provincialRoad\": {\n\t\t\t\t\"name\": \"省道\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20004\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"secondaryRoad\": {\n\t\t\t\t\"name\": \"二级公路\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20007\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"levelThreeRoad\": {\n\t\t\t\t\"name\": \"三级公路\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20008\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"levelFourRoad\": {\n\t\t\t\t\"name\": \"四级道路\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20009\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"roadsBeingBuilt\": {\n\t\t\t\t\"name\": \"在建道路\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20018\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"railway\": {\n\t\t\t\t\"name\": \"铁路\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20010,\n\t\t\t\t\t\"subkey\": [1]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"highSpeedRailway\": {\n\t\t\t\t\"name\": \"高铁\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20010,\n\t\t\t\t\t\"subkey\": [2]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"subway\": {\n\t\t\t\t\"name\": \"地铁\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20015\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"subwayBeingBuilt\": {\n\t\t\t\t\"name\": \"在建地铁\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20015,\n\t\t\t\t\t\"subkey\": [1, 2]\n\t\t\t\t}, {\n\t\t\t\t\t\"mainkey\": 20019\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"overPass\": {\n\t\t\t\t\"name\": \"天桥\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20012\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"underPass\": {\n\t\t\t\t\"name\": \"地道\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20013\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"other\": {\n\t\t\t\t\"name\": \"其他线条\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20011\n\t\t\t\t}, {\n\t\t\t\t\t\"mainkey\": 20017\n\t\t\t\t}, {\n\t\t\t\t\t\"mainkey\": 20020\n\t\t\t\t}, {\n\t\t\t\t\t\"mainkey\": 20024\n\t\t\t\t}, {\n\t\t\t\t\t\"mainkey\": 20028\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"guideBoards\": {\n\t\t\t\t\"name\": \"道路路牌\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 40001\n\t\t\t\t}]\n\t\t\t}\n\t\t}\n\t},\n\t\"labels\": {\n\t\t\"name\": \"标注\",\n\t\t\"subType\": {\n\t\t\t\"pois\": {\n\t\t\t\t\"name\": \"兴趣点\",\n\t\t\t\t\"subType\": {\n\t\t\t\t\t\"hotel\": {\n\t\t\t\t\t\t\"name\": \"住宿\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 0,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [9, 133, 134, 135, 136, 155, 156, 157, 158, 159, 160, 161, 162, 186]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10007,\n\t\t\t\t\t\t\t\"subkey\": [31, 32, 33, 34, 35, 36, 37, 38, 39, 164, 165]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"restaurant\": {\n\t\t\t\t\t\t\"name\": \"餐饮\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 1,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [19, 20, 21, 22, 114, 115, 116, 117, 118, 119, 183, 187]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10007,\n\t\t\t\t\t\t\t\"subkey\": [1, 2, 3, 4, 166, 167, 168, 179, 180, 181, 203, 205, 206, 215]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"shop\": {\n\t\t\t\t\t\t\"name\": \"购物\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 2,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [7, 8, 68, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10007,\n\t\t\t\t\t\t\t\"subkey\": [5, 6, 7, 8, 9, 10, 11, 12, 13, 175, 200, 201, 202, 204]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"scenicSpot\": {\n\t\t\t\t\t\t\"name\": \"风景名胜\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 3,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [4, 12, 14, 38, 69, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 120, 167, 171, 188, 189, 190, 191, 192]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10008\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10007,\n\t\t\t\t\t\t\t\"subkey\": [48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123, 124, 125, 126, 127, 128, 129, 130, 131, 132, 133, 134, 135, 136, 137, 138, 139, 140, 141, 142, 143, 144, 145, 146, 147, 148, 149, 150, 151, 152, 153, 154, 155, 156, 157, 158, 159, 160, 161, 162, 163, 187, 188, 190, 192, 193, 194, 195, 196, 198, 216, 217, 218, 219, 220, 221, 223, 224, 225]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"traffic\": {\n\t\t\t\t\t\t\"name\": \"交通设施\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 4,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [23, 24, 25, 26, 31, 36, 148, 154, 168, 172, 175, 176, 177, 178]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10002,\n\t\t\t\t\t\t\t\"subkey\": [11, 16]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10009\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"bank\": {\n\t\t\t\t\t\t\"name\": \"金融保险\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 5,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [42, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 144, 145, 146, 147]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10007,\n\t\t\t\t\t\t\t\"subkey\": [14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"edu\": {\n\t\t\t\t\t\t\"name\": \"科教文化\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 6,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [10, 11, 13, 35, 138, 139, 140, 141, 142, 143, 163, 164, 165, 166, 170]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10007,\n\t\t\t\t\t\t\t\"subkey\": [43, 44, 45, 46, 47, 176, 177]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"live\": {\n\t\t\t\t\t\t\"name\": \"生活服务\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 7,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [58, 63, 64, 65, 66, 67, 121, 122, 123]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10007,\n\t\t\t\t\t\t\t\"subkey\": [28, 29, 30]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"hospital\": {\n\t\t\t\t\t\t\"name\": \"医疗保健\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 8,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [32, 33, 57, 70, 131, 132, 169, 193, 206, 207, 208, 209, 210]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10007,\n\t\t\t\t\t\t\t\"subkey\": [170, 209]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"pe\": {\n\t\t\t\t\t\t\"name\": \"休闲体育\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 9,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [15, 16, 17, 37, 60, 61, 62, 73, 124, 125, 126, 127, 128, 129, 130, 180, 181, 182, 184, 185, 194, 195, 196, 197, 198, 199, 200, 201, 202, 203, 204, 205, 213, 214]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10007,\n\t\t\t\t\t\t\t\"subkey\": [169, 171, 172, 173, 174, 178, 197, 207]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"public\": {\n\t\t\t\t\t\t\"name\": \"公共设施\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 10,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [59, 173, 215]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"buidling\": {\n\t\t\t\t\t\t\"name\": \"商务住宅\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 11,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [5, 6, 74, 75, 76, 77, 78, 79, 80, 81, 179]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10007,\n\t\t\t\t\t\t\t\"subkey\": [189, 191]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"gov\": {\n\t\t\t\t\t\t\"name\": \"政府机构及社会团体\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 12,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [3, 34, 43, 137]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"moto\": {\n\t\t\t\t\t\t\"name\": \"摩托车服务\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 13,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [113]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"vehicle\": {\n\t\t\t\t\t\t\"name\": \"汽车服务\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 14,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [39, 40, 41, 71, 72, 151, 152, 153]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10007,\n\t\t\t\t\t\t\t\"subkey\": [40, 41, 42, 182, 183, 184, 185, 186]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"pass\": {\n\t\t\t\t\t\t\"name\": \"通行设施\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 15,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [27, 28, 149, 150, 174]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10002,\n\t\t\t\t\t\t\t\"subkey\": [21]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"subway\": {\n\t\t\t\t\t\t\"name\": \"地铁站\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 16,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10005\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10006\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"roadFacilities\": {\n\t\t\t\t\t\t\"name\": \"道路附属设施\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 17,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [2, 29, 30]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10017\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"address\": {\n\t\t\t\t\t\t\"name\": \"地名\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 18,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [18]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10002,\n\t\t\t\t\t\t\t\"subkey\": [10, 12, 14, 15, 23, 36]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"other\": {\n\t\t\t\t\t\t\"name\": \"其他\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 19,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [1, 211, 212]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10002,\n\t\t\t\t\t\t\t\"subkey\": [28]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10007,\n\t\t\t\t\t\t\t\"subkey\": [208, 210, 211, 212, 213, 214]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10010\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10011\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10012\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10013\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10014\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10015\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10016\n\t\t\t\t\t\t}]\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t},\n\t\t\t\"aois\": {\n\t\t\t\t\"name\": \"区域标注\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 10004\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"continent\": {\n\t\t\t\t\"name\": \"大洲\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 10002,\n\t\t\t\t\t\"subkey\": [20]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"country\": {\n\t\t\t\t\"name\": \"国家\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 10002,\n\t\t\t\t\t\"subkey\": [18, 19, 29]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"province\": {\n\t\t\t\t\"name\": \"省/直辖市/自治区/特别行政区\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 10002,\n\t\t\t\t\t\"subkey\": [22, 26, 33]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"city\": {\n\t\t\t\t\"name\": \"城市\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 10002,\n\t\t\t\t\t\"subkey\": [1, 2, 3, 4, 5, 7, 24, 25, 27, 30, 31, 32, 34, 35]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"district\": {\n\t\t\t\t\"name\": \"区县\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 10002,\n\t\t\t\t\t\"subkey\": [6, 8, 37]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"town\": {\n\t\t\t\t\"name\": \"乡镇\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 10002,\n\t\t\t\t\t\"subkey\": [9]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"village\": {\n\t\t\t\t\"name\": \"村庄\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 10002,\n\t\t\t\t\t\"subkey\": [17]\n\t\t\t\t}]\n\t\t\t}\n\t\t}\n\t},\n\t\"borders\": {\n\t\t\"name\": \"行政区边界\",\n\t\t\"subType\": {\n\t\t\t\"China\": {\n\t\t\t\t\"name\": \"中国国界\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20016,\n\t\t\t\t\t\"subkey\": [1, 2, 9]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"foreign\": {\n\t\t\t\t\"name\": \"外国国界/停火线/主张线\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20016,\n\t\t\t\t\t\"subkey\": [3, 4, 8, 10, 11]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"provincial\": {\n\t\t\t\t\"name\": \"省界线\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20016,\n\t\t\t\t\t\"subkey\": [5, 6, 7, 12]\n\t\t\t\t}]\n\t\t\t}\n\t\t}\n\t}\n}]");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (jSONArray.length() == 0) {
            return this.a;
        }
        JSONObject optJSONObject2 = jSONArray.optJSONObject(0);
        if (optJSONObject2 == null) {
            return this.a;
        }
        JSONArray names = optJSONObject2.names();
        int length = names.length();
        int i2 = 0;
        while (i2 < length) {
            String optString = names.optString(i2);
            JSONObject optJSONObject3 = optJSONObject2.optJSONObject(optString);
            if (optJSONObject3 != null) {
                String optString2 = optJSONObject3.optString(str3);
                if (optJSONObject3.has("styleMap")) {
                    a(optJSONObject3.optJSONArray("styleMap"), optString, (String) null, optString2, this.a);
                    str = str3;
                    str2 = str4;
                    jSONObject2 = optJSONObject2;
                    jSONArray3 = names;
                    i = length;
                } else {
                    str = str3;
                    str2 = str4;
                    jSONObject2 = optJSONObject2;
                    jSONArray3 = names;
                    i = length;
                    if (optJSONObject3.has(str4)) {
                        JSONObject optJSONObject4 = optJSONObject3.optJSONObject(str4);
                        if (optJSONObject4 != null) {
                            JSONArray names2 = optJSONObject4.names();
                            int length2 = names2.length();
                            int i3 = 0;
                            while (true) {
                                int i4 = i3;
                                str = str3;
                                str2 = str4;
                                jSONObject2 = optJSONObject2;
                                jSONArray3 = names;
                                i = length;
                                if (i4 >= length2) {
                                    break;
                                }
                                String optString3 = names2.optString(i4);
                                JSONObject optJSONObject5 = optJSONObject4.optJSONObject(optString3);
                                if (optJSONObject5 != null) {
                                    String optString4 = optJSONObject5.optString(str3);
                                    if (optJSONObject5.has("styleMap")) {
                                        a(optJSONObject5.optJSONArray("styleMap"), optString, optString3, optString2 + NativeLibraryHelper.CLEAR_ABI_OVERRIDE + optString4, this.a);
                                    } else if (optJSONObject5.has(str4) && (optJSONObject = optJSONObject5.optJSONObject(str4)) != null) {
                                        JSONArray names3 = optJSONObject.names();
                                        int length3 = names3.length();
                                        int i5 = 0;
                                        while (true) {
                                            int i6 = i5;
                                            if (i6 < length3) {
                                                String optString5 = names3.optString(i6);
                                                JSONObject optJSONObject6 = optJSONObject.optJSONObject(optString5);
                                                if (optJSONObject6 != null) {
                                                    String optString6 = optJSONObject6.optString(str3);
                                                    if (optJSONObject6.has("styleMap")) {
                                                        a(optJSONObject6.optJSONArray("styleMap"), optString, optString3 + NativeLibraryHelper.CLEAR_ABI_OVERRIDE + optString5, optString2 + NativeLibraryHelper.CLEAR_ABI_OVERRIDE + optString4 + NativeLibraryHelper.CLEAR_ABI_OVERRIDE + optString6, this.a);
                                                    }
                                                }
                                                i5 = i6 + 1;
                                            }
                                        }
                                    }
                                }
                                i3 = i4 + 1;
                            }
                        }
                    }
                }
                str3 = str;
                str4 = str2;
                jSONObject = jSONObject2;
                jSONArray2 = jSONArray3;
                length = i;
                this.a.add(new cu(20021, d, "roads", "trafficRoadBackgroundColor", null));
                i2++;
                JSONArray jSONArray4 = jSONArray2;
                optJSONObject2 = jSONObject;
                names = jSONArray4;
            }
            JSONObject jSONObject3 = optJSONObject2;
            jSONArray2 = names;
            jSONObject = jSONObject3;
            i2++;
            JSONArray jSONArray42 = jSONArray2;
            optJSONObject2 = jSONObject;
            names = jSONArray42;
        }
        return this.a;
    }

    public final int a() {
        return this.b;
    }

    public final cz a(String str, boolean z) {
        if (str == null || "".equals(str)) {
            return null;
        }
        return b(str, z);
    }

    public final cz a(byte[] bArr, boolean z) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        return b(bArr, z);
    }

    public final void a(int i) {
        this.c = i;
    }
}
