package com.kuaishou.weapon.p0;

import com.tencent.tinker.loader.shareutil.ShareConstants;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kuaishou/weapon/p0/z.class */
public class z {
    private Set<String> e = new HashSet();
    private Set<String> f = new HashSet();
    private Set<String> g = new HashSet();
    private Set<String> h = new HashSet();

    /* renamed from: a  reason: collision with root package name */
    private String f23901a = i.a("f118f1f9431de3a626df48d7302911", "0820");
    private String b = i.a("f118f1ef4616f3fc27d1", "0820");

    /* renamed from: c  reason: collision with root package name */
    private String f23902c = i.a("f118f1e84f0bf5ba3bd1579c6d35", "0820");
    private String d = i.a("fc03e7a44510", "0820");

    public int a() {
        try {
            if (this.f == null || this.f.size() <= 0) {
                return 0;
            }
            return this.f.size();
        } catch (Exception e) {
            return 0;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:152:0x031c  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01ac A[Catch: all -> 0x02d3, Exception -> 0x02ff, TRY_LEAVE, TryCatch #8 {Exception -> 0x02ff, all -> 0x02d3, blocks: (B:4:0x0015, B:5:0x0018, B:9:0x0084, B:11:0x00aa, B:13:0x00b2, B:15:0x00bb, B:17:0x00c4, B:19:0x00cd, B:21:0x00d6, B:26:0x00e6, B:28:0x00ef, B:30:0x00f8, B:32:0x0101, B:34:0x010c, B:36:0x011f, B:38:0x012b, B:41:0x013a, B:43:0x0146, B:45:0x0150, B:47:0x015a, B:49:0x0168, B:51:0x0170, B:53:0x017a, B:55:0x0184, B:57:0x018e, B:59:0x0198, B:62:0x01a4, B:64:0x01ac, B:65:0x01b8, B:67:0x01c2, B:69:0x01cc, B:71:0x01d6, B:73:0x01e0, B:75:0x01ea, B:77:0x01f4, B:79:0x01fe, B:82:0x020b, B:84:0x0215, B:86:0x021f, B:88:0x0229, B:91:0x0236, B:93:0x0240, B:96:0x024d, B:98:0x0261, B:100:0x026f, B:102:0x027d, B:105:0x028e, B:107:0x0294, B:108:0x029f, B:109:0x02a7, B:111:0x02b2, B:113:0x02bc), top: B:161:0x0015 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public org.json.JSONArray a(android.content.Context r7) {
        /*
            Method dump skipped, instructions count: 802
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.z.a(android.content.Context):org.json.JSONArray");
    }

    public Set<String> b() {
        try {
            if (this.g == null || this.g.size() <= 0) {
                return null;
            }
            return this.g;
        } catch (Exception e) {
            return null;
        }
    }

    public Set<String> c() {
        try {
            if (this.h == null || this.h.size() <= 0) {
                return null;
            }
            return this.h;
        } catch (Exception e) {
            return null;
        }
    }

    public JSONObject d() {
        String str;
        try {
            if (this.e == null || this.e.size() <= 0) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            for (String str2 : this.e) {
                if (str2.contains(this.f23901a)) {
                    str = "0";
                } else if (str2.contains(this.b)) {
                    str = "1";
                } else if (str2.contains(this.f23902c)) {
                    str = "2";
                }
                jSONObject.put(str, 1);
            }
            if (jSONObject.length() > 0) {
                return jSONObject;
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public Set e() {
        try {
            HashSet hashSet = new HashSet();
            if (this.e == null || this.e.size() <= 0) {
                return null;
            }
            for (String str : this.e) {
                if (str.endsWith(ShareConstants.DEX_PATH)) {
                    hashSet.add(str);
                }
                if (hashSet.size() > 5) {
                    break;
                }
            }
            if (hashSet.size() > 0) {
                return hashSet;
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }
}
