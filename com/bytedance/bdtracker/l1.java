package com.bytedance.bdtracker;

import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/l1.class */
public class l1 {

    /* renamed from: a  reason: collision with root package name */
    public String f7640a;
    public List<b> b;

    /* renamed from: c  reason: collision with root package name */
    public a f7641c;
    public String d;

    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/l1$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f7642a;
        public int b;

        /* renamed from: c  reason: collision with root package name */
        public int f7643c;
        public int d;

        public a(int i, int i2, int i3, int i4) {
            this.f7642a = i;
            this.b = i2;
            this.f7643c = i3;
            this.d = i4;
        }

        public JSONObject a() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("x", this.f7642a);
                jSONObject.put("y", this.b);
                jSONObject.put("width", this.f7643c);
                jSONObject.put("height", this.d);
                return jSONObject;
            } catch (JSONException e) {
                z2.a(e);
                return null;
            }
        }

        public String toString() {
            StringBuilder a2 = com.bytedance.bdtracker.a.a("FrameModel{x=");
            a2.append(this.f7642a);
            a2.append(", y=");
            a2.append(this.b);
            a2.append(", width=");
            a2.append(this.f7643c);
            a2.append(", height=");
            a2.append(this.d);
            a2.append('}');
            return a2.toString();
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/l1$b.class */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public String f7644a;
        public a b;

        /* renamed from: c  reason: collision with root package name */
        public String f7645c;
        public String d;
        public List<String> e;
        public int f;
        public List<String> g;
        public List<b> h;
        public String i;
        public boolean j;
        public List<String> k;

        public b(String str, a aVar, String str2, String str3, List<String> list, int i, List<String> list2, List<b> list3, String str4, boolean z, List<String> list4) {
            this.f7644a = str;
            this.b = aVar;
            this.f7645c = str2;
            this.d = str3;
            this.e = list;
            this.f = i;
            this.g = list2;
            this.h = list3;
            this.i = str4;
            this.j = z;
            this.k = list4;
        }

        public String toString() {
            StringBuilder a2 = com.bytedance.bdtracker.a.a("InfoModel{nodeName='");
            a2.append(this.f7644a);
            a2.append('\'');
            a2.append(", frameModel=");
            a2.append(this.b);
            a2.append(", elementPath='");
            a2.append(this.f7645c);
            a2.append('\'');
            a2.append(", elementPathV2='");
            a2.append(this.d);
            a2.append('\'');
            a2.append(", positions=");
            a2.append(this.e);
            a2.append(", zIndex=");
            a2.append(this.f);
            a2.append(", texts=");
            a2.append(this.g);
            a2.append(", children=");
            a2.append(this.h);
            a2.append(", href='");
            a2.append(this.i);
            a2.append('\'');
            a2.append(", checkList=");
            a2.append(this.j);
            a2.append(", fuzzyPositions=");
            a2.append(this.k);
            a2.append('}');
            return a2.toString();
        }
    }

    public String toString() {
        StringBuilder a2 = com.bytedance.bdtracker.a.a("WebInfoModel{page='");
        a2.append(this.f7640a);
        a2.append('\'');
        a2.append(", info=");
        a2.append(this.b);
        a2.append('}');
        return a2.toString();
    }
}
