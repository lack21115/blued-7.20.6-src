package com.kuaishou.weapon.p0;

import android.content.Context;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kuaishou/weapon/p0/bv.class */
public class bv {
    private static final byte[] d = new byte[0];

    /* renamed from: a  reason: collision with root package name */
    private Context f10154a;
    private boolean b;

    /* renamed from: c  reason: collision with root package name */
    private int f10155c;

    public bv(Context context, int i, boolean z) {
        this.f10154a = context;
        this.b = z;
        this.f10155c = i;
    }

    public String a(String str) {
        try {
            synchronized (d) {
                JSONObject a2 = new cl(str, cj.j).a(this.f10154a);
                if (a2 == null) {
                    return null;
                }
                JSONObject a3 = a();
                if (a3 == null) {
                    return null;
                }
                a2.put("module_section", a3);
                return a2.toString();
            }
        } catch (Throwable th) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:183:0x074e A[Catch: all -> 0x0875, TRY_ENTER, TryCatch #2 {all -> 0x0875, blocks: (B:123:0x04d3, B:125:0x04e1, B:126:0x04ec, B:126:0x04ec, B:129:0x04f6, B:131:0x050e, B:134:0x0522, B:136:0x0536, B:139:0x054a, B:141:0x055e, B:144:0x0572, B:146:0x0586, B:149:0x059a, B:151:0x05ae, B:154:0x05c2, B:156:0x05d6, B:159:0x05ea, B:161:0x05fe, B:164:0x0612, B:166:0x0626, B:169:0x063a, B:171:0x064e, B:174:0x0662, B:176:0x0676, B:179:0x068a, B:181:0x0705, B:183:0x074e, B:185:0x0766, B:186:0x0773, B:188:0x0789, B:189:0x0796, B:191:0x07ac, B:192:0x07b9, B:194:0x07c8, B:196:0x07d3, B:198:0x07df, B:199:0x07eb, B:177:0x0683, B:172:0x065b, B:167:0x0633, B:162:0x060b, B:157:0x05e3, B:152:0x05bb, B:147:0x0593, B:142:0x056b, B:137:0x0543, B:132:0x051b, B:180:0x0696), top: B:227:0x04d3 }] */
    /* JADX WARN: Removed duplicated region for block: B:228:0x07eb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public org.json.JSONObject a() {
        /*
            Method dump skipped, instructions count: 2205
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.bv.a():org.json.JSONObject");
    }
}
