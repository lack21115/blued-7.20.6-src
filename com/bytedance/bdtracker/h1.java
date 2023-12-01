package com.bytedance.bdtracker;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/h1.class */
public class h1 extends v1 {
    public int[] F;
    public int G;
    public int H;
    public int I;
    public boolean J;
    public List<h1> K;

    public h1(v1 v1Var) {
        String str = v1Var.s;
        String str2 = v1Var.t;
        String str3 = v1Var.u;
        String str4 = v1Var.v;
        String str5 = v1Var.w;
        int i = v1Var.z;
        int i2 = v1Var.A;
        int i3 = v1Var.B;
        int i4 = v1Var.C;
        ArrayList<String> arrayList = v1Var.x;
        ArrayList<String> arrayList2 = v1Var.y;
        ArrayList<String> arrayList3 = v1Var.E;
        this.s = str;
        this.t = str2;
        this.u = str3;
        this.v = str4;
        this.w = str5;
        this.x = arrayList;
        this.y = arrayList2;
        this.z = i;
        this.A = i2;
        this.B = i3;
        this.C = i4;
        this.E = arrayList3;
        this.K = new ArrayList();
        this.s = v1Var.s;
        this.u = v1Var.u;
        this.y = v1Var.y;
        this.x = v1Var.x;
    }

    public JSONObject m() {
        try {
            JSONObject jSONObject = new JSONObject();
            if (this.F != null && this.F.length > 1) {
                jSONObject.put("x", this.F[0]);
                jSONObject.put("y", this.F[1]);
            }
            jSONObject.put("width", this.G);
            jSONObject.put("height", this.H);
            return jSONObject;
        } catch (JSONException e) {
            z2.a(e);
            return null;
        }
    }
}
