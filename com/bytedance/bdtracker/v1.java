package com.bytedance.bdtracker;

import com.baidu.mobads.sdk.api.ArticleInfo;
import java.util.ArrayList;
import java.util.Collection;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/v1.class */
public class v1 extends z1 {
    public int A;
    public int B;
    public int C;
    public boolean D;
    public ArrayList<String> E;
    public String s;
    public String t;
    public String u;
    public String v;
    public String w;
    public ArrayList<String> x;
    public ArrayList<String> y;
    public int z;

    public v1() {
        super(null, "bav2b_click", true, null);
    }

    public v1(String str, String str2, String str3, String str4, String str5, int i, int i2, int i3, int i4, ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        super(null, "bav2b_click", true, null);
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
    }

    @Override // com.bytedance.bdtracker.z1
    public void l() {
        if (this.p == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("element_path", this.u);
            jSONObject.put("page_key", this.s);
            ArrayList<String> arrayList = this.y;
            if (arrayList != null && arrayList.size() > 0) {
                jSONObject.put("positions", new JSONArray((Collection) this.y));
            }
            ArrayList<String> arrayList2 = this.x;
            if (arrayList2 != null && arrayList2.size() > 0) {
                jSONObject.put("texts", new JSONArray((Collection) this.x));
            }
            jSONObject.put("element_width", this.z);
            jSONObject.put("element_height", this.A);
            jSONObject.put("touch_x", this.B);
            jSONObject.put("touch_y", this.C);
            jSONObject.put(ArticleInfo.PAGE_TITLE, this.t);
            jSONObject.put("element_id", this.v);
            jSONObject.put("element_type", this.w);
            this.p = jSONObject.toString();
        }
    }
}
