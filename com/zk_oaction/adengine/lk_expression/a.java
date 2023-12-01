package com.zk_oaction.adengine.lk_expression;

import android.text.TextUtils;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.Stack;

/* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_expression/a.class */
public class a implements com.zk_oaction.adengine.lk_variable.f {
    private static final char[][] d = {new char[]{'>', '>', '<', '<', '<', '<', '>', '>'}, new char[]{'>', '>', '<', '<', '<', '<', '>', '>'}, new char[]{'>', '>', '>', '>', '>', '<', '>', '>'}, new char[]{'>', '>', '>', '>', '>', '<', '>', '>'}, new char[]{'>', '>', '>', '>', '>', '<', '>', '>'}, new char[]{'<', '<', '<', '<', '<', '<', '=', '!'}, new char[]{'>', '>', '>', '>', '>', '!', '>', '>'}, new char[]{'<', '<', '<', '<', '<', '<', '!', '='}};
    private static HashMap<String, com.zk_oaction.adengine.lk_sdk.interfaces.c<float[], Float>> e;

    /* renamed from: a  reason: collision with root package name */
    public String f41918a;
    public String b;

    /* renamed from: c  reason: collision with root package name */
    public HashSet<String> f41919c = new HashSet<>();
    private com.zk_oaction.adengine.lk_sdk.c f;
    private w g;
    private boolean h;
    private float i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.zk_oaction.adengine.lk_expression.a$a  reason: collision with other inner class name */
    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_expression/a$a.class */
    public static final class C1103a implements com.zk_oaction.adengine.lk_sdk.interfaces.c<float[], Float> {
        C1103a() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        public Float a(float[] fArr) {
            return Float.valueOf(Math.min(fArr[0], fArr[1]));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_expression/a$b.class */
    public static final class b implements com.zk_oaction.adengine.lk_sdk.interfaces.c<float[], Float> {
        b() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        public Float a(float[] fArr) {
            return Float.valueOf(Math.max(fArr[0], fArr[1]));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_expression/a$c.class */
    public static final class c implements com.zk_oaction.adengine.lk_sdk.interfaces.c<float[], Float> {
        c() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        public Float a(float[] fArr) {
            return Float.valueOf(Math.round(fArr[0]) * 1.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_expression/a$d.class */
    public static final class d implements com.zk_oaction.adengine.lk_sdk.interfaces.c<float[], Float> {
        d() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        public Float a(float[] fArr) {
            return Float.valueOf(((int) fArr[0]) * 1.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_expression/a$e.class */
    public static final class e implements com.zk_oaction.adengine.lk_sdk.interfaces.c<float[], Float> {
        e() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        public Float a(float[] fArr) {
            String str = ((int) fArr[0]) + "";
            return Float.valueOf((str.charAt(str.length() - ((int) fArr[1])) - '0') * 1.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_expression/a$f.class */
    public static final class f implements com.zk_oaction.adengine.lk_sdk.interfaces.c<float[], Float> {
        f() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        public Float a(float[] fArr) {
            return Float.valueOf(new Random().nextFloat());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_expression/a$g.class */
    public static final class g implements com.zk_oaction.adengine.lk_sdk.interfaces.c<float[], Float> {
        g() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        public Float a(float[] fArr) {
            return Float.valueOf((float) Math.sqrt(fArr[0]));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_expression/a$h.class */
    public static final class h implements com.zk_oaction.adengine.lk_sdk.interfaces.c<float[], Float> {
        h() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        public Float a(float[] fArr) {
            return Float.valueOf((float) Math.sin(fArr[0]));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_expression/a$i.class */
    public static final class i implements com.zk_oaction.adengine.lk_sdk.interfaces.c<float[], Float> {
        i() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        public Float a(float[] fArr) {
            return Float.valueOf((float) Math.cos(fArr[0]));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_expression/a$j.class */
    public static final class j implements com.zk_oaction.adengine.lk_sdk.interfaces.c<float[], Float> {
        j() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        public Float a(float[] fArr) {
            return Float.valueOf((float) Math.tan(fArr[0]));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_expression/a$k.class */
    public static final class k implements com.zk_oaction.adengine.lk_sdk.interfaces.c<float[], Float> {
        k() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        public Float a(float[] fArr) {
            return fArr[0] != 0.0f ? Float.valueOf(0.0f) : Float.valueOf(1.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_expression/a$l.class */
    public static final class l implements com.zk_oaction.adengine.lk_sdk.interfaces.c<float[], Float> {
        l() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        public Float a(float[] fArr) {
            return Float.valueOf((float) Math.asin(fArr[0]));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_expression/a$m.class */
    public static final class m implements com.zk_oaction.adengine.lk_sdk.interfaces.c<float[], Float> {
        m() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        public Float a(float[] fArr) {
            return Float.valueOf((float) Math.acos(fArr[0]));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_expression/a$n.class */
    public static final class n implements com.zk_oaction.adengine.lk_sdk.interfaces.c<float[], Float> {
        n() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        public Float a(float[] fArr) {
            return Float.valueOf((float) Math.atan(fArr[0]));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_expression/a$o.class */
    public static final class o implements com.zk_oaction.adengine.lk_sdk.interfaces.c<float[], Float> {
        o() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        public Float a(float[] fArr) {
            return Float.valueOf(Math.abs(fArr[0]));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_expression/a$p.class */
    public static final class p implements com.zk_oaction.adengine.lk_sdk.interfaces.c<float[], Float> {
        p() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        public Float a(float[] fArr) {
            return Float.valueOf(fArr[0] == fArr[1] ? 1.0f : 0.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_expression/a$q.class */
    public static final class q implements com.zk_oaction.adengine.lk_sdk.interfaces.c<float[], Float> {
        q() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        public Float a(float[] fArr) {
            return Float.valueOf(fArr[0] != fArr[1] ? 1.0f : 0.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_expression/a$r.class */
    public static final class r implements com.zk_oaction.adengine.lk_sdk.interfaces.c<float[], Float> {
        r() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        public Float a(float[] fArr) {
            return Float.valueOf(fArr[0] >= fArr[1] ? 1.0f : 0.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_expression/a$s.class */
    public static final class s implements com.zk_oaction.adengine.lk_sdk.interfaces.c<float[], Float> {
        s() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        public Float a(float[] fArr) {
            return Float.valueOf(fArr[0] > fArr[1] ? 1.0f : 0.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_expression/a$t.class */
    public static final class t implements com.zk_oaction.adengine.lk_sdk.interfaces.c<float[], Float> {
        t() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        public Float a(float[] fArr) {
            return Float.valueOf(fArr[0] <= fArr[1] ? 1.0f : 0.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_expression/a$u.class */
    public static final class u implements com.zk_oaction.adengine.lk_sdk.interfaces.c<float[], Float> {
        u() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        public Float a(float[] fArr) {
            return Float.valueOf(fArr[0] < fArr[1] ? 1.0f : 0.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_expression/a$v.class */
    public static final class v implements com.zk_oaction.adengine.lk_sdk.interfaces.c<float[], Float> {
        v() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        public Float a(float[] fArr) {
            float f;
            int length = fArr.length - 1;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    f = fArr[length];
                    break;
                } else if (fArr[i2] > 0.0f) {
                    f = fArr[i2 + 1];
                    break;
                } else {
                    i = i2 + 2;
                }
            }
            return Float.valueOf(f);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_expression/a$w.class */
    public interface w {
        void a(String str, float f);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [char[], char[][]] */
    static {
        b();
    }

    public a(com.zk_oaction.adengine.lk_sdk.c cVar, String str, String str2, float f2, w wVar, boolean z) {
        String str3;
        float f3;
        this.f = cVar;
        this.f41918a = str;
        this.g = wVar;
        if (str2 == null) {
            a(f2);
            return;
        }
        String replace = str2.replace(" ", "");
        this.b = replace;
        if (replace.equals("true")) {
            f3 = 1.0f;
        } else if (!this.b.equals("false")) {
            this.h = z;
            if (this.b.contains("#")) {
                String str4 = this.b + Constants.WAVE_SEPARATOR;
                int i2 = 0;
                int length = str4.length();
                String str5 = null;
                while (true) {
                    String str6 = str5;
                    if (i2 >= length) {
                        break;
                    }
                    char charAt = str4.charAt(i2);
                    if (a(charAt) || charAt == ',' || charAt == ')') {
                        str3 = str6;
                        if (str6 != null) {
                            this.f.a(str6, this);
                            this.f41919c.add(str6);
                            str3 = null;
                        }
                    } else if (charAt == '#') {
                        str3 = "";
                    } else {
                        str3 = str6;
                        if (str6 != null) {
                            str3 = str6 + charAt;
                        }
                    }
                    i2++;
                    str5 = str3;
                }
            }
            a((String) null, (String) null);
            return;
        } else {
            f3 = 0.0f;
        }
        a(f3);
    }

    private static char a(char c2, char c3) {
        return d[b(c2)][b(c3)];
    }

    private static float a(float f2, char c2, float f3) {
        if (c2 != '%') {
            if (c2 != '-') {
                if (c2 != '/') {
                    if (c2 != '*') {
                        if (c2 != '+') {
                            return 0.0f;
                        }
                        return f2 + f3;
                    }
                    return f2 * f3;
                }
                return f2 / f3;
            }
            return f2 - f3;
        }
        return f2 % f3;
    }

    public static float a(com.zk_oaction.adengine.lk_sdk.c cVar, String str) {
        float a2;
        if (str == null) {
            return 0.0f;
        }
        try {
            Stack stack = new Stack();
            Stack stack2 = new Stack();
            stack2.add('~');
            String str2 = str + '~';
            int i2 = 0;
            char charAt = str2.charAt(0);
            if (charAt == '-') {
                stack.push(Float.valueOf(0.0f));
            }
            String str3 = null;
            while (true) {
                if (charAt == '~' && ((Character) stack2.peek()).charValue() == '~') {
                    if (str3 != null) {
                        stack.push(Float.valueOf(a(cVar.n.b(str3), 0.0f)));
                    }
                    return ((Float) stack.peek()).floatValue();
                }
                if (a(str3, charAt)) {
                    StringBuffer stringBuffer = new StringBuffer();
                    while (!a(charAt)) {
                        stringBuffer.append(charAt);
                        i2++;
                        charAt = str2.charAt(i2);
                    }
                    a2 = Float.parseFloat(stringBuffer.toString());
                } else {
                    if (a(charAt)) {
                        String str4 = str3;
                        if (str3 != null) {
                            stack.push(Float.valueOf(a(cVar.n.b(str3), 0.0f)));
                            str4 = null;
                        }
                        char a3 = a(((Character) stack2.peek()).charValue(), charAt);
                        if (a3 != '!') {
                            switch (a3) {
                                case '<':
                                    stack2.push(Character.valueOf(charAt));
                                    i2++;
                                    str3 = str4;
                                    break;
                                case '=':
                                    stack2.pop();
                                    i2++;
                                    str3 = str4;
                                    break;
                                case '>':
                                    a2 = a(((Float) stack.pop()).floatValue(), ((Character) stack2.pop()).charValue(), ((Float) stack.pop()).floatValue());
                                    str3 = str4;
                                    break;
                                default:
                                    str3 = str4;
                                    break;
                            }
                        } else {
                            return -1.0f;
                        }
                    } else if (charAt == '#') {
                        StringBuffer stringBuffer2 = new StringBuffer();
                        stringBuffer2.append("");
                        while (true) {
                            i2++;
                            char charAt2 = str2.charAt(i2);
                            if (a(charAt2)) {
                                str3 = stringBuffer2.toString();
                            } else {
                                stringBuffer2.append(charAt2);
                            }
                        }
                    } else {
                        String a4 = a(str, i2);
                        stack.push(Float.valueOf(b(cVar, a4)));
                        i2 += a4.length();
                    }
                    charAt = str2.charAt(i2);
                }
                stack.push(Float.valueOf(a2));
                charAt = str2.charAt(i2);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0.0f;
        }
    }

    private static float a(String str, float f2) {
        try {
            return TextUtils.isEmpty(str) ? f2 : Float.parseFloat(str);
        } catch (Exception e2) {
            return f2;
        }
    }

    private static String a(String str, int i2) {
        boolean z;
        int i3;
        int length = str.length();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("");
        boolean z2 = false;
        int i4 = 0;
        int i5 = i2;
        while (!z2) {
            char charAt = str.charAt(i5);
            stringBuffer.append(charAt);
            if (charAt == '(') {
                i3 = i4 + 1;
                z = z2;
            } else {
                z = z2;
                i3 = i4;
                if (charAt == ')') {
                    int i6 = i4 - 1;
                    z = z2;
                    i3 = i6;
                    if (i6 == 0) {
                        z = true;
                        i3 = i6;
                    }
                }
            }
            int i7 = i5 + 1;
            z2 = z;
            i4 = i3;
            i5 = i7;
            if (i7 == length) {
                break;
            }
        }
        return stringBuffer.toString();
    }

    public static ArrayList<String> a(String str) {
        StringBuilder sb;
        String str2;
        ArrayList<String> arrayList = new ArrayList<>();
        int length = str.length();
        int i2 = 0;
        String str3 = "";
        int i3 = 0;
        while (i2 < length) {
            char charAt = str.charAt(i2);
            if (charAt == '(') {
                i3++;
                sb = new StringBuilder();
            } else if (charAt == ')') {
                i3--;
                sb = new StringBuilder();
            } else if (charAt == ',' && i3 == 0) {
                arrayList.add(str3);
                str2 = "";
                i2++;
                str3 = str2;
            } else {
                sb = new StringBuilder();
            }
            sb.append(str3);
            sb.append(charAt);
            str2 = sb.toString();
            i2++;
            str3 = str2;
        }
        if (!str3.equals("")) {
            arrayList.add(str3);
        }
        return arrayList;
    }

    public static boolean a(char c2) {
        return c2 == '+' || c2 == '-' || c2 == '*' || c2 == '/' || c2 == '%' || c2 == '(' || c2 == ')' || c2 == '~';
    }

    private static boolean a(String str, char c2) {
        return str == null && c2 >= '0' && c2 <= '9';
    }

    private static float b(com.zk_oaction.adengine.lk_sdk.c cVar, String str) {
        int indexOf = str.indexOf(40);
        float f2 = 0.0f;
        if (indexOf >= 0) {
            if (indexOf > str.length()) {
                return 0.0f;
            }
            String substring = str.substring(0, indexOf);
            String substring2 = str.substring(indexOf + 1, str.length() - 1);
            if (!substring.equals("isnull")) {
                ArrayList<String> a2 = a(substring2);
                float[] fArr = new float[a2.size()];
                for (int i2 = 0; i2 < a2.size(); i2++) {
                    fArr[i2] = a(cVar, a2.get(i2));
                }
                com.zk_oaction.adengine.lk_sdk.interfaces.c<float[], Float> cVar2 = e.get(substring);
                f2 = 0.0f;
                if (cVar2 != null) {
                    f2 = cVar2.a(fArr).floatValue();
                }
            } else if (cVar.n.a(substring2.substring(1)) == null) {
                return 1.0f;
            } else {
                f2 = 0.0f;
                if (cVar.n.a(substring2.substring(1)).b() == null) {
                    return 1.0f;
                }
            }
        }
        return f2;
    }

    private static int b(char c2) {
        if (c2 != '%') {
            if (c2 != '-') {
                if (c2 != '/') {
                    if (c2 != '~') {
                        switch (c2) {
                            case '(':
                                return 5;
                            case ')':
                                return 6;
                            case '*':
                                return 2;
                            case '+':
                                return 0;
                            default:
                                return -1;
                        }
                    }
                    return 7;
                }
                return 3;
            }
            return 1;
        }
        return 4;
    }

    private static void b() {
        HashMap<String, com.zk_oaction.adengine.lk_sdk.interfaces.c<float[], Float>> hashMap = new HashMap<>();
        e = hashMap;
        hashMap.put("not", new k());
        e.put("abs", new o());
        e.put("eq", new p());
        e.put("ne", new q());
        e.put("ge", new r());
        e.put("gt", new s());
        e.put("le", new t());
        e.put("lt", new u());
        e.put("ifelse", new v());
        e.put("min", new C1103a());
        e.put("max", new b());
        e.put("round", new c());
        e.put(IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL, new d());
        e.put("digit", new e());
        e.put("rand", new f());
        e.put("sqrt", new g());
        e.put("sin", new h());
        e.put("cos", new i());
        e.put("tan", new j());
        e.put("asin", new l());
        e.put("acos", new m());
        e.put("atan", new n());
    }

    public float a() {
        return this.i;
    }

    public void a(float f2) {
        this.i = f2;
        w wVar = this.g;
        if (wVar != null) {
            wVar.a(this.f41918a, f2);
        }
    }

    public void a(w wVar) {
        this.g = wVar;
        if (wVar != null) {
            wVar.a(this.f41918a, this.i);
        }
    }

    @Override // com.zk_oaction.adengine.lk_variable.f
    public void a(String str, String str2) {
        String str3 = this.b;
        if (str3 != null) {
            this.i = this.h ? a(this.f, str3) * this.f.t : a(this.f, str3);
            w wVar = this.g;
            if (wVar != null) {
                wVar.a(this.f41918a, this.i);
            }
        }
    }
}
