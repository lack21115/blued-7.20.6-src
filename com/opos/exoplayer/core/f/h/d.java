package com.opos.exoplayer.core.f.h;

import android.provider.BrowserContract;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.AlignmentSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import com.opos.exoplayer.core.f.h.c;
import com.opos.exoplayer.core.i.m;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/f/h/d.class */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final Pattern f25398a = Pattern.compile("^(\\S+)\\s+-->\\s+(\\S+)(.*)?$");
    private static final Pattern b = Pattern.compile("(\\S+?):(\\S+)");

    /* renamed from: c  reason: collision with root package name */
    private final StringBuilder f25399c = new StringBuilder();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/f/h/d$a.class */
    public static final class a {
        private static final String[] e = new String[0];

        /* renamed from: a  reason: collision with root package name */
        public final String f25400a;
        public final int b;

        /* renamed from: c  reason: collision with root package name */
        public final String f25401c;
        public final String[] d;

        private a(String str, int i, String str2, String[] strArr) {
            this.b = i;
            this.f25400a = str;
            this.f25401c = str2;
            this.d = strArr;
        }

        public static a a() {
            return new a("", 0, "", new String[0]);
        }

        public static a a(String str, int i) {
            String trim;
            String trim2 = str.trim();
            if (trim2.isEmpty()) {
                return null;
            }
            int indexOf = trim2.indexOf(" ");
            if (indexOf == -1) {
                trim = "";
            } else {
                trim = trim2.substring(indexOf).trim();
                trim2 = trim2.substring(0, indexOf);
            }
            String[] split = trim2.split("\\.");
            return new a(split[0], i, trim, split.length > 1 ? (String[]) Arrays.copyOfRange(split, 1, split.length) : e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/f/h/d$b.class */
    public static final class b implements Comparable<b> {

        /* renamed from: a  reason: collision with root package name */
        public final int f25402a;
        public final com.opos.exoplayer.core.f.h.b b;

        public b(int i, com.opos.exoplayer.core.f.h.b bVar) {
            this.f25402a = i;
            this.b = bVar;
        }

        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(b bVar) {
            return this.f25402a - bVar.f25402a;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static int a(String str) {
        boolean z;
        int i = 0;
        switch (str.hashCode()) {
            case -1364013995:
                if (str.equals("center")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case -1074341483:
                if (str.equals("middle")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 100571:
                if (str.equals("end")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 109757538:
                if (str.equals("start")) {
                    z = false;
                    break;
                }
                z = true;
                break;
            default:
                z = true;
                break;
        }
        if (z) {
            if (!z && !z) {
                if (!z) {
                    com.opos.cmn.an.f.a.c("WebvttCueParser", "Invalid anchor value: " + str);
                    return Integer.MIN_VALUE;
                }
                return 2;
            }
            i = 1;
        }
        return i;
    }

    private static int a(String str, int i) {
        int indexOf = str.indexOf(62, i);
        return indexOf == -1 ? str.length() : indexOf + 1;
    }

    private static void a(SpannableStringBuilder spannableStringBuilder, com.opos.exoplayer.core.f.h.b bVar, int i, int i2) {
        RelativeSizeSpan absoluteSizeSpan;
        if (bVar == null) {
            return;
        }
        if (bVar.b() != -1) {
            spannableStringBuilder.setSpan(new StyleSpan(bVar.b()), i, i2, 33);
        }
        if (bVar.c()) {
            spannableStringBuilder.setSpan(new StrikethroughSpan(), i, i2, 33);
        }
        if (bVar.d()) {
            spannableStringBuilder.setSpan(new UnderlineSpan(), i, i2, 33);
        }
        if (bVar.g()) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(bVar.f()), i, i2, 33);
        }
        if (bVar.i()) {
            spannableStringBuilder.setSpan(new BackgroundColorSpan(bVar.h()), i, i2, 33);
        }
        if (bVar.e() != null) {
            spannableStringBuilder.setSpan(new TypefaceSpan(bVar.e()), i, i2, 33);
        }
        if (bVar.j() != null) {
            spannableStringBuilder.setSpan(new AlignmentSpan.Standard(bVar.j()), i, i2, 33);
        }
        int k = bVar.k();
        if (k == 1) {
            absoluteSizeSpan = new AbsoluteSizeSpan((int) bVar.l(), true);
        } else if (k == 2) {
            absoluteSizeSpan = new RelativeSizeSpan(bVar.l());
        } else if (k != 3) {
            return;
        } else {
            absoluteSizeSpan = new RelativeSizeSpan(bVar.l() / 100.0f);
        }
        spannableStringBuilder.setSpan(absoluteSizeSpan, i, i2, 33);
    }

    private static void a(String str, SpannableStringBuilder spannableStringBuilder) {
        boolean z;
        char c2;
        int hashCode = str.hashCode();
        if (hashCode == 3309) {
            if (str.equals("gt")) {
                z = true;
            }
            z = true;
        } else if (hashCode == 3464) {
            if (str.equals("lt")) {
                z = false;
            }
            z = true;
        } else if (hashCode != 96708) {
            if (hashCode == 3374865 && str.equals("nbsp")) {
                z = true;
            }
            z = true;
        } else {
            if (str.equals("amp")) {
                z = true;
            }
            z = true;
        }
        if (!z) {
            c2 = '<';
        } else if (z) {
            c2 = '>';
        } else if (z) {
            c2 = ' ';
        } else if (!z) {
            com.opos.cmn.an.f.a.c("WebvttCueParser", "ignoring unsupported entity: '&" + str + ";'");
            return;
        } else {
            c2 = '&';
        }
        spannableStringBuilder.append(c2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(String str, c.a aVar) {
        Matcher matcher = b.matcher(str);
        while (matcher.find()) {
            String group = matcher.group(1);
            String group2 = matcher.group(2);
            try {
                if ("line".equals(group)) {
                    b(group2, aVar);
                } else if ("align".equals(group)) {
                    aVar.a(b(group2));
                } else if (BrowserContract.Bookmarks.POSITION.equals(group)) {
                    c(group2, aVar);
                } else if ("size".equals(group)) {
                    aVar.c(f.b(group2));
                } else {
                    com.opos.cmn.an.f.a.c("WebvttCueParser", "Unknown cue setting " + group + ":" + group2);
                }
            } catch (NumberFormatException e) {
                com.opos.cmn.an.f.a.c("WebvttCueParser", "Skipping bad cue setting: " + matcher.group());
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x0143 A[LOOP:0: B:47:0x013c->B:49:0x0143, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0163 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(java.lang.String r6, com.opos.exoplayer.core.f.h.d.a r7, android.text.SpannableStringBuilder r8, java.util.List<com.opos.exoplayer.core.f.h.b> r9, java.util.List<com.opos.exoplayer.core.f.h.d.b> r10) {
        /*
            Method dump skipped, instructions count: 356
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.exoplayer.core.f.h.d.a(java.lang.String, com.opos.exoplayer.core.f.h.d$a, android.text.SpannableStringBuilder, java.util.List, java.util.List):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(String str, String str2, c.a aVar, List<com.opos.exoplayer.core.f.h.b> list) {
        int i;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        Stack stack = new Stack();
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (i2 < str2.length()) {
            char charAt = str2.charAt(i2);
            if (charAt == '&') {
                int i3 = i2 + 1;
                int indexOf = str2.indexOf(59, i3);
                int indexOf2 = str2.indexOf(32, i3);
                if (indexOf == -1) {
                    i = indexOf2;
                } else {
                    i = indexOf;
                    if (indexOf2 != -1) {
                        i = Math.min(indexOf, indexOf2);
                    }
                }
                if (i != -1) {
                    a(str2.substring(i3, i), spannableStringBuilder);
                    if (i == indexOf2) {
                        spannableStringBuilder.append(" ");
                    }
                    i2 = i + 1;
                } else {
                    spannableStringBuilder.append(charAt);
                    i2 = i3;
                }
            } else if (charAt != '<') {
                spannableStringBuilder.append(charAt);
                i2++;
            } else {
                int i4 = i2 + 1;
                if (i4 >= str2.length()) {
                    i2 = i4;
                } else {
                    int i5 = 1;
                    boolean z = str2.charAt(i4) == '/';
                    int a2 = a(str2, i4);
                    int i6 = a2 - 2;
                    boolean z2 = str2.charAt(i6) == '/';
                    if (z) {
                        i5 = 2;
                    }
                    if (!z2) {
                        i6 = a2 - 1;
                    }
                    String substring = str2.substring(i5 + i2, i6);
                    String d = d(substring);
                    i2 = a2;
                    if (d != null) {
                        if (!c(d)) {
                            i2 = a2;
                        } else if (z) {
                            while (true) {
                                if (!stack.isEmpty()) {
                                    a aVar2 = (a) stack.pop();
                                    a(str, aVar2, spannableStringBuilder, list, arrayList);
                                    if (aVar2.f25400a.equals(d)) {
                                        i2 = a2;
                                        break;
                                    }
                                } else {
                                    i2 = a2;
                                    break;
                                }
                            }
                        } else {
                            i2 = a2;
                            if (!z2) {
                                stack.push(a.a(substring, spannableStringBuilder.length()));
                                i2 = a2;
                            }
                        }
                    }
                }
            }
        }
        while (!stack.isEmpty()) {
            a(str, (a) stack.pop(), spannableStringBuilder, list, arrayList);
        }
        a(str, a.a(), spannableStringBuilder, list, arrayList);
        aVar.a(spannableStringBuilder);
    }

    private static void a(List<com.opos.exoplayer.core.f.h.b> list, String str, a aVar, List<b> list2) {
        int size = list.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                Collections.sort(list2);
                return;
            }
            com.opos.exoplayer.core.f.h.b bVar = list.get(i2);
            int a2 = bVar.a(str, aVar.f25400a, aVar.d, aVar.f25401c);
            if (a2 > 0) {
                list2.add(new b(a2, bVar));
            }
            i = i2 + 1;
        }
    }

    private static boolean a(String str, Matcher matcher, m mVar, c.a aVar, StringBuilder sb, List<com.opos.exoplayer.core.f.h.b> list) {
        try {
            aVar.a(f.a(matcher.group(1))).b(f.a(matcher.group(2)));
            a(matcher.group(3), aVar);
            sb.setLength(0);
            while (true) {
                String z = mVar.z();
                if (TextUtils.isEmpty(z)) {
                    a(str, sb.toString(), aVar, list);
                    return true;
                }
                if (sb.length() > 0) {
                    sb.append("\n");
                }
                sb.append(z.trim());
            }
        } catch (NumberFormatException e) {
            com.opos.cmn.an.f.a.c("WebvttCueParser", "Skipping cue with bad header: " + matcher.group());
            return false;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static Layout.Alignment b(String str) {
        boolean z;
        switch (str.hashCode()) {
            case -1364013995:
                if (str.equals("center")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case -1074341483:
                if (str.equals("middle")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 100571:
                if (str.equals("end")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 3317767:
                if (str.equals("left")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 108511772:
                if (str.equals("right")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 109757538:
                if (str.equals("start")) {
                    z = false;
                    break;
                }
                z = true;
                break;
            default:
                z = true;
                break;
        }
        if (!z || z) {
            return Layout.Alignment.ALIGN_NORMAL;
        }
        if (z || z) {
            return Layout.Alignment.ALIGN_CENTER;
        }
        if (z || z) {
            return Layout.Alignment.ALIGN_OPPOSITE;
        }
        com.opos.cmn.an.f.a.c("WebvttCueParser", "Invalid alignment value: " + str);
        return null;
    }

    private static void b(String str, c.a aVar) {
        int indexOf = str.indexOf(44);
        if (indexOf != -1) {
            aVar.b(a(str.substring(indexOf + 1)));
            str = str.substring(0, indexOf);
        } else {
            aVar.b(Integer.MIN_VALUE);
        }
        if (str.endsWith("%")) {
            aVar.a(f.b(str)).a(0);
            return;
        }
        int parseInt = Integer.parseInt(str);
        int i = parseInt;
        if (parseInt < 0) {
            i = parseInt - 1;
        }
        aVar.a(i).a(1);
    }

    private static void c(String str, c.a aVar) {
        int indexOf = str.indexOf(44);
        if (indexOf != -1) {
            aVar.c(a(str.substring(indexOf + 1)));
            str = str.substring(0, indexOf);
        } else {
            aVar.c(Integer.MIN_VALUE);
        }
        aVar.b(f.b(str));
    }

    private static boolean c(String str) {
        boolean z;
        int hashCode = str.hashCode();
        if (hashCode == 98) {
            if (str.equals("b")) {
                z = false;
            }
            z = true;
        } else if (hashCode == 99) {
            if (str.equals("c")) {
                z = true;
            }
            z = true;
        } else if (hashCode == 105) {
            if (str.equals("i")) {
                z = true;
            }
            z = true;
        } else if (hashCode == 3314158) {
            if (str.equals("lang")) {
                z = true;
            }
            z = true;
        } else if (hashCode != 117) {
            if (hashCode == 118 && str.equals("v")) {
                z = true;
            }
            z = true;
        } else {
            if (str.equals("u")) {
                z = true;
            }
            z = true;
        }
        return !z || z || z || z || z || z;
    }

    private static String d(String str) {
        String trim = str.trim();
        if (trim.isEmpty()) {
            return null;
        }
        return trim.split("[ \\.]")[0];
    }

    public boolean a(m mVar, c.a aVar, List<com.opos.exoplayer.core.f.h.b> list) {
        String z = mVar.z();
        if (z == null) {
            return false;
        }
        Matcher matcher = f25398a.matcher(z);
        if (matcher.matches()) {
            return a(null, matcher, mVar, aVar, this.f25399c, list);
        }
        String z2 = mVar.z();
        if (z2 != null) {
            Matcher matcher2 = f25398a.matcher(z2);
            if (matcher2.matches()) {
                return a(z.trim(), matcher2, mVar, aVar, this.f25399c, list);
            }
            return false;
        }
        return false;
    }
}
