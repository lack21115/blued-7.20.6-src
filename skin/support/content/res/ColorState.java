package skin.support.content.res;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
import skin.support.exception.SkinCompatException;
import skin.support.utils.Slog;

/* loaded from: source-3503164-dex2jar.jar:skin/support/content/res/ColorState.class */
public final class ColorState {

    /* renamed from: a  reason: collision with root package name */
    boolean f44217a;
    String b;

    /* renamed from: c  reason: collision with root package name */
    String f44218c;
    String d;
    String e;
    String f;
    String g;
    String h;
    String i;
    String j;
    String k;
    String l;
    String m;
    String n;

    /* loaded from: source-3503164-dex2jar.jar:skin/support/content/res/ColorState$ColorBuilder.class */
    public static class ColorBuilder {

        /* renamed from: a  reason: collision with root package name */
        String f44219a;
        String b;

        /* renamed from: c  reason: collision with root package name */
        String f44220c;
        String d;
        String e;
        String f;
        String g;
        String h;
        String i;
        String j;
        String k;
        String l;

        public ColorBuilder a(String str) {
            if (ColorState.a("colorWindowFocused", str)) {
                this.f44219a = str;
            }
            return this;
        }

        public ColorState a() {
            if (TextUtils.isEmpty(this.l)) {
                throw new SkinCompatException("Default color can not empty!");
            }
            return new ColorState(this.f44219a, this.b, this.f44220c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l);
        }

        public ColorBuilder b(String str) {
            if (ColorState.a("colorSelected", str)) {
                this.b = str;
            }
            return this;
        }

        public ColorBuilder c(String str) {
            if (ColorState.a("colorFocused", str)) {
                this.f44220c = str;
            }
            return this;
        }

        public ColorBuilder d(String str) {
            if (ColorState.a("colorEnabled", str)) {
                this.d = str;
            }
            return this;
        }

        public ColorBuilder e(String str) {
            if (ColorState.a("colorChecked", str)) {
                this.f = str;
            }
            return this;
        }

        public ColorBuilder f(String str) {
            if (ColorState.a("colorPressed", str)) {
                this.e = str;
            }
            return this;
        }

        public ColorBuilder g(String str) {
            if (ColorState.a("colorActivated", str)) {
                this.g = str;
            }
            return this;
        }

        public ColorBuilder h(String str) {
            if (ColorState.a("colorAccelerated", str)) {
                this.h = str;
            }
            return this;
        }

        public ColorBuilder i(String str) {
            if (ColorState.a("colorHovered", str)) {
                this.i = str;
            }
            return this;
        }

        public ColorBuilder j(String str) {
            if (ColorState.a("colorDragCanAccept", str)) {
                this.j = str;
            }
            return this;
        }

        public ColorBuilder k(String str) {
            if (ColorState.a("colorDragHovered", str)) {
                this.k = str;
            }
            return this;
        }

        public ColorBuilder l(String str) {
            if (ColorState.a("colorDefault", str)) {
                this.l = str;
            }
            return this;
        }
    }

    ColorState(String str, String str2) {
        this.b = str;
        this.n = str2;
        this.f44217a = true;
        if (!str2.startsWith("#")) {
            throw new SkinCompatException("Default color cannot be a reference, when only default color is available!");
        }
    }

    ColorState(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12) {
        this.f44218c = str;
        this.d = str2;
        this.e = str3;
        this.f = str4;
        this.g = str5;
        this.h = str6;
        this.i = str7;
        this.j = str8;
        this.k = str9;
        this.l = str10;
        this.m = str11;
        this.n = str12;
        boolean z = TextUtils.isEmpty(str) && TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3) && TextUtils.isEmpty(str4) && TextUtils.isEmpty(str5) && TextUtils.isEmpty(str6) && TextUtils.isEmpty(str7) && TextUtils.isEmpty(str8) && TextUtils.isEmpty(str9) && TextUtils.isEmpty(str10) && TextUtils.isEmpty(str11);
        this.f44217a = z;
        if (z && !str12.startsWith("#")) {
            throw new SkinCompatException("Default color cannot be a reference, when only default color is available!");
        }
    }

    private String a(String str) {
        if (str.startsWith("#")) {
            return str;
        }
        ColorState b = SkinCompatUserThemeManager.b().b(str);
        if (b != null) {
            if (b.a()) {
                return b.n;
            }
            if (Slog.f44252a) {
                Slog.a("ColorState", str + " cannot reference " + b.b);
                return null;
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static JSONObject a(ColorState colorState) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (colorState.f44217a) {
            jSONObject.putOpt("colorName", colorState.b).putOpt("colorDefault", colorState.n).putOpt("onlyDefaultColor", Boolean.valueOf(colorState.f44217a));
            return jSONObject;
        }
        jSONObject.putOpt("colorName", colorState.b).putOpt("colorWindowFocused", colorState.f44218c).putOpt("colorSelected", colorState.d).putOpt("colorFocused", colorState.e).putOpt("colorEnabled", colorState.f).putOpt("colorPressed", colorState.g).putOpt("colorChecked", colorState.h).putOpt("colorActivated", colorState.i).putOpt("colorAccelerated", colorState.j).putOpt("colorHovered", colorState.k).putOpt("colorDragCanAccept", colorState.l).putOpt("colorDragHovered", colorState.m).putOpt("colorDefault", colorState.n).putOpt("onlyDefaultColor", Boolean.valueOf(colorState.f44217a));
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ColorState a(JSONObject jSONObject) {
        if (jSONObject.has("colorName") && jSONObject.has("colorDefault") && jSONObject.has("onlyDefaultColor")) {
            try {
                boolean z = jSONObject.getBoolean("onlyDefaultColor");
                String string = jSONObject.getString("colorName");
                String string2 = jSONObject.getString("colorDefault");
                if (z) {
                    return new ColorState(string, string2);
                }
                ColorBuilder colorBuilder = new ColorBuilder();
                colorBuilder.l(string2);
                if (jSONObject.has("colorWindowFocused")) {
                    colorBuilder.a(jSONObject.getString("colorWindowFocused"));
                }
                if (jSONObject.has("colorSelected")) {
                    colorBuilder.b(jSONObject.getString("colorSelected"));
                }
                if (jSONObject.has("colorFocused")) {
                    colorBuilder.c(jSONObject.getString("colorFocused"));
                }
                if (jSONObject.has("colorEnabled")) {
                    colorBuilder.d(jSONObject.getString("colorEnabled"));
                }
                if (jSONObject.has("colorPressed")) {
                    colorBuilder.f(jSONObject.getString("colorPressed"));
                }
                if (jSONObject.has("colorChecked")) {
                    colorBuilder.e(jSONObject.getString("colorChecked"));
                }
                if (jSONObject.has("colorActivated")) {
                    colorBuilder.g(jSONObject.getString("colorActivated"));
                }
                if (jSONObject.has("colorAccelerated")) {
                    colorBuilder.h(jSONObject.getString("colorAccelerated"));
                }
                if (jSONObject.has("colorHovered")) {
                    colorBuilder.i(jSONObject.getString("colorHovered"));
                }
                if (jSONObject.has("colorDragCanAccept")) {
                    colorBuilder.j(jSONObject.getString("colorDragCanAccept"));
                }
                if (jSONObject.has("colorDragHovered")) {
                    colorBuilder.k(jSONObject.getString("colorDragHovered"));
                }
                ColorState a2 = colorBuilder.a();
                a2.b = string;
                return a2;
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    static boolean a(String str, String str2) {
        boolean z = !TextUtils.isEmpty(str2) && (!str2.startsWith("#") || str2.length() == 7 || str2.length() == 9);
        if (Slog.f44252a && !z) {
            Slog.a("ColorState", "Invalid color -> " + str + ": " + str2);
        }
        return z;
    }

    /* JADX WARN: Removed duplicated region for block: B:132:0x00a8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0130 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01b8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0240 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0064 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:144:0x02c8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:146:0x00ec A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0174 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01fc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0284 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:156:0x036c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0311 A[Catch: Exception -> 0x03ff, TRY_LEAVE, TryCatch #1 {Exception -> 0x03ff, blocks: (B:89:0x02fd, B:91:0x0309, B:93:0x0311, B:95:0x0332, B:99:0x0344, B:101:0x036c), top: B:134:0x02fd }] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0344 A[Catch: Exception -> 0x03ff, TRY_ENTER, TRY_LEAVE, TryCatch #1 {Exception -> 0x03ff, blocks: (B:89:0x02fd, B:91:0x0309, B:93:0x0311, B:95:0x0332, B:99:0x0344, B:101:0x036c), top: B:134:0x02fd }] */
    /* JADX WARN: Type inference failed for: r0v213, types: [int[], int[][]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private android.content.res.ColorStateList c() {
        /*
            Method dump skipped, instructions count: 1028
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: skin.support.content.res.ColorState.c():android.content.res.ColorStateList");
    }

    public boolean a() {
        return this.f44217a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList b() {
        return this.f44217a ? ColorStateList.valueOf(Color.parseColor(this.n)) : c();
    }
}
