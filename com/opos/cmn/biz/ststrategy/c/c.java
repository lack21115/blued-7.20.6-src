package com.opos.cmn.biz.ststrategy.c;

import android.content.Context;
import android.text.TextUtils;
import com.opos.acs.st.STManager;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/biz/ststrategy/c/c.class */
public class c {
    private static HashSet<String> a(JSONArray jSONArray) {
        HashSet<String> hashSet = new HashSet<>();
        if (jSONArray.length() > 0) {
            int i = 0;
            while (true) {
                try {
                    int i2 = i;
                    if (i2 >= jSONArray.length()) {
                        break;
                    }
                    JSONObject jSONObject = jSONArray.getJSONObject(i2);
                    if (jSONObject != null && jSONObject.has(STManager.KEY_DATA_TYPE) && !jSONObject.isNull(STManager.KEY_DATA_TYPE)) {
                        String string = jSONObject.getString(STManager.KEY_DATA_TYPE);
                        if (!TextUtils.isEmpty(string)) {
                            hashSet.add(string);
                        }
                    }
                    i = i2 + 1;
                } catch (JSONException e) {
                    com.opos.cmn.an.f.a.c("MergeSTConfigUtil", "", e);
                }
            }
        }
        return hashSet;
    }

    public static JSONArray a(Context context, JSONObject jSONObject) {
        if (context == null || jSONObject == null) {
            return null;
        }
        com.opos.cmn.an.f.a.b("MergeSTConfigUtil", "getMetaListArray=" + jSONObject.toString());
        try {
            if (!jSONObject.has("data") || jSONObject.isNull("data")) {
                return null;
            }
            JSONObject jSONObject2 = jSONObject.getJSONObject("data");
            if (!jSONObject2.has("metaList") || jSONObject2.isNull("metaList")) {
                return null;
            }
            return jSONObject2.getJSONArray("metaList");
        } catch (JSONException e) {
            com.opos.cmn.an.f.a.c("MergeSTConfigUtil", "", e);
            return null;
        }
    }

    public static boolean a(JSONArray jSONArray, JSONArray jSONArray2, HashSet hashSet) {
        boolean z = false;
        if (jSONArray != null) {
            z = false;
            if (jSONArray.length() > 0) {
                z = false;
                if (jSONArray2 != null) {
                    z = false;
                    if (jSONArray2.length() > 0) {
                        int length = jSONArray2.length();
                        int i = 0;
                        while (true) {
                            try {
                                int i2 = i;
                                if (i2 >= jSONArray.length()) {
                                    break;
                                }
                                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                                if (jSONObject != null && jSONObject.has(STManager.KEY_DATA_TYPE) && !jSONObject.isNull(STManager.KEY_DATA_TYPE)) {
                                    String string = jSONObject.getString(STManager.KEY_DATA_TYPE);
                                    if (!TextUtils.isEmpty(string) && hashSet != null && !hashSet.contains(string)) {
                                        jSONArray2.put(jSONObject);
                                    }
                                }
                                i = i2 + 1;
                            } catch (Exception e) {
                                com.opos.cmn.an.f.a.c("MergeSTConfigUtil", "", e);
                                z = false;
                            }
                        }
                        z = false;
                        if (jSONArray2.length() >= length) {
                            com.opos.cmn.an.f.a.b("MergeSTConfigUtil", "onlineJsonArray length:" + jSONArray2.length() + ",originLength:" + length);
                            z = true;
                        }
                    }
                }
            }
        }
        com.opos.cmn.an.f.a.b("MergeSTConfigUtil", "mergeMetaFromLocalJson mergeResult:" + z);
        return z;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.HashSet<java.lang.String> b(android.content.Context r4, org.json.JSONObject r5) {
        /*
            r0 = r4
            if (r0 == 0) goto L52
            r0 = r5
            if (r0 == 0) goto L52
            r0 = r5
            java.lang.String r1 = "data"
            boolean r0 = r0.has(r1)     // Catch: org.json.JSONException -> L49
            if (r0 == 0) goto L52
            r0 = r5
            java.lang.String r1 = "data"
            boolean r0 = r0.isNull(r1)     // Catch: org.json.JSONException -> L49
            if (r0 != 0) goto L52
            r0 = r5
            java.lang.String r1 = "data"
            org.json.JSONObject r0 = r0.getJSONObject(r1)     // Catch: org.json.JSONException -> L49
            r4 = r0
            r0 = r4
            java.lang.String r1 = "metaList"
            boolean r0 = r0.has(r1)     // Catch: org.json.JSONException -> L49
            if (r0 == 0) goto L52
            r0 = r4
            java.lang.String r1 = "metaList"
            boolean r0 = r0.isNull(r1)     // Catch: org.json.JSONException -> L49
            if (r0 != 0) goto L52
            r0 = r4
            java.lang.String r1 = "metaList"
            org.json.JSONArray r0 = r0.getJSONArray(r1)     // Catch: org.json.JSONException -> L49
            r4 = r0
            r0 = r4
            int r0 = r0.length()     // Catch: org.json.JSONException -> L49
            if (r0 <= 0) goto L52
            r0 = r4
            java.util.HashSet r0 = a(r0)     // Catch: org.json.JSONException -> L49
            r4 = r0
            goto L54
        L49:
            r4 = move-exception
            java.lang.String r0 = "MergeSTConfigUtil"
            java.lang.String r1 = ""
            r2 = r4
            com.opos.cmn.an.f.a.c(r0, r1, r2)
        L52:
            r0 = 0
            r4 = r0
        L54:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r6 = r0
            r0 = r6
            java.lang.String r1 = "getOnlineDataTypeSet="
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r4
            if (r0 == 0) goto L6c
            r0 = r4
            r5 = r0
            goto L6f
        L6c:
            java.lang.String r0 = "false"
            r5 = r0
        L6f:
            r0 = r6
            r1 = r5
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = "MergeSTConfigUtil"
            r1 = r6
            java.lang.String r1 = r1.toString()
            com.opos.cmn.an.f.a.b(r0, r1)
            r0 = r4
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.cmn.biz.ststrategy.c.c.b(android.content.Context, org.json.JSONObject):java.util.HashSet");
    }
}
