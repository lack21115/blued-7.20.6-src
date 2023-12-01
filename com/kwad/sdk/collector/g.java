package com.kwad.sdk.collector;

import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/collector/g.class */
public final class g {
    public static int PERMISSION_DENIED = 2;
    public static int PERMISSION_GRANTED = 1;
    public static int abg;
    private String abf;
    private int state;

    public g(String str, int i) {
        this.state = abg;
        this.abf = str;
        this.state = i;
    }

    public static JSONArray k(List<g> list) {
        JSONArray jSONArray = new JSONArray();
        if (list == null) {
            return jSONArray;
        }
        for (g gVar : list) {
            jSONArray.put(gVar.toJson());
        }
        return jSONArray;
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0019, code lost:
        if (r4.abf.startsWith("android.permission") != false) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String tH() {
        /*
            r4 = this;
            r0 = r4
            java.lang.String r0 = r0.abf
            r7 = r0
            r0 = r7
            java.lang.String r1 = "com.android."
            boolean r0 = r0.startsWith(r1)
            if (r0 != 0) goto L1c
            r0 = r7
            r6 = r0
            r0 = r4
            java.lang.String r0 = r0.abf
            java.lang.String r1 = "android.permission"
            boolean r0 = r0.startsWith(r1)
            if (r0 == 0) goto L40
        L1c:
            r0 = r4
            java.lang.String r0 = r0.abf
            java.lang.String r1 = "."
            int r0 = r0.lastIndexOf(r1)
            r5 = r0
            r0 = r7
            r6 = r0
            r0 = r5
            r1 = r4
            java.lang.String r1 = r1.abf
            int r1 = r1.length()
            r2 = 1
            int r1 = r1 - r2
            if (r0 >= r1) goto L40
            r0 = r4
            java.lang.String r0 = r0.abf
            r1 = r5
            r2 = 1
            int r1 = r1 + r2
            java.lang.String r0 = r0.substring(r1)
            r6 = r0
        L40:
            r0 = r6
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.collector.g.tH():java.lang.String");
    }

    private JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", tH());
            jSONObject.put("state", this.state);
            return jSONObject;
        } catch (JSONException e) {
            com.kwad.sdk.core.d.b.printStackTrace(e);
            return jSONObject;
        }
    }
}
