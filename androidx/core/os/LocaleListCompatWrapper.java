package androidx.core.os;

import android.os.Build;
import com.anythink.expressad.video.dynview.a.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Locale;

/* loaded from: source-8756600-dex2jar.jar:androidx/core/os/LocaleListCompatWrapper.class */
final class LocaleListCompatWrapper implements LocaleListInterface {

    /* renamed from: c  reason: collision with root package name */
    private static final Locale[] f2511c = new Locale[0];
    private static final Locale d = new Locale("en", "XA");
    private static final Locale e = new Locale(a.aa, "XB");
    private static final Locale f = LocaleListCompat.a("en-Latn");

    /* renamed from: a  reason: collision with root package name */
    private final Locale[] f2512a;
    private final String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public LocaleListCompatWrapper(Locale... localeArr) {
        if (localeArr.length == 0) {
            this.f2512a = f2511c;
            this.b = "";
            return;
        }
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= localeArr.length) {
                this.f2512a = (Locale[]) arrayList.toArray(new Locale[arrayList.size()]);
                this.b = sb.toString();
                return;
            }
            Locale locale = localeArr[i2];
            if (locale == null) {
                throw new NullPointerException("list[" + i2 + "] is null");
            }
            if (!hashSet.contains(locale)) {
                Locale locale2 = (Locale) locale.clone();
                arrayList.add(locale2);
                a(sb, locale2);
                if (i2 < localeArr.length - 1) {
                    sb.append(',');
                }
                hashSet.add(locale2);
            }
            i = i2 + 1;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x002c, code lost:
        if (r6 < Integer.MAX_VALUE) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int a(java.util.Collection<java.lang.String> r4, boolean r5) {
        /*
            r3 = this;
            r0 = r3
            java.util.Locale[] r0 = r0.f2512a
            r8 = r0
            r0 = r8
            int r0 = r0.length
            r1 = 1
            if (r0 != r1) goto Lf
            r0 = 0
            return r0
        Lf:
            r0 = r8
            int r0 = r0.length
            if (r0 != 0) goto L17
            r0 = -1
            return r0
        L17:
            r0 = r5
            if (r0 == 0) goto L32
            r0 = r3
            java.util.Locale r1 = androidx.core.os.LocaleListCompatWrapper.f
            int r0 = r0.c(r1)
            r6 = r0
            r0 = r6
            if (r0 != 0) goto L29
            r0 = 0
            return r0
        L29:
            r0 = r6
            r1 = 2147483647(0x7fffffff, float:NaN)
            if (r0 >= r1) goto L32
            goto L35
        L32:
            r0 = 2147483647(0x7fffffff, float:NaN)
            r6 = r0
        L35:
            r0 = r4
            java.util.Iterator r0 = r0.iterator()
            r4 = r0
        L3c:
            r0 = r4
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L6a
            r0 = r3
            r1 = r4
            java.lang.Object r1 = r1.next()
            java.lang.String r1 = (java.lang.String) r1
            java.util.Locale r1 = androidx.core.os.LocaleListCompat.a(r1)
            int r0 = r0.c(r1)
            r7 = r0
            r0 = r7
            if (r0 != 0) goto L5e
            r0 = 0
            return r0
        L5e:
            r0 = r7
            r1 = r6
            if (r0 >= r1) goto L3c
            r0 = r7
            r6 = r0
            goto L3c
        L6a:
            r0 = r6
            r1 = 2147483647(0x7fffffff, float:NaN)
            if (r0 != r1) goto L72
            r0 = 0
            return r0
        L72:
            r0 = r6
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.os.LocaleListCompatWrapper.a(java.util.Collection, boolean):int");
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    private static int a(Locale locale, Locale locale2) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    private static String a(Locale locale) {
        if (Build.VERSION.SDK_INT >= 21) {
            String script = locale.getScript();
            return !script.isEmpty() ? script : "";
        }
        return "";
    }

    static void a(StringBuilder sb, Locale locale) {
        sb.append(locale.getLanguage());
        String country = locale.getCountry();
        if (country == null || country.isEmpty()) {
            return;
        }
        sb.append('-');
        sb.append(locale.getCountry());
    }

    private Locale b(Collection<String> collection, boolean z) {
        int a2 = a(collection, z);
        if (a2 == -1) {
            return null;
        }
        return this.f2512a[a2];
    }

    private static boolean b(Locale locale) {
        return d.equals(locale) || e.equals(locale);
    }

    private int c(Locale locale) {
        int i = 0;
        while (true) {
            int i2 = i;
            Locale[] localeArr = this.f2512a;
            if (i2 >= localeArr.length) {
                return Integer.MAX_VALUE;
            }
            if (a(locale, localeArr[i2]) > 0) {
                return i2;
            }
            i = i2 + 1;
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LocaleListCompatWrapper)) {
            return false;
        }
        Locale[] localeArr = ((LocaleListCompatWrapper) obj).f2512a;
        if (this.f2512a.length != localeArr.length) {
            return false;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            Locale[] localeArr2 = this.f2512a;
            if (i2 >= localeArr2.length) {
                return true;
            }
            if (!localeArr2[i2].equals(localeArr[i2])) {
                return false;
            }
            i = i2 + 1;
        }
    }

    @Override // androidx.core.os.LocaleListInterface
    public Locale get(int i) {
        if (i >= 0) {
            Locale[] localeArr = this.f2512a;
            if (i < localeArr.length) {
                return localeArr[i];
            }
            return null;
        }
        return null;
    }

    @Override // androidx.core.os.LocaleListInterface
    public Locale getFirstMatch(String[] strArr) {
        return b(Arrays.asList(strArr), false);
    }

    @Override // androidx.core.os.LocaleListInterface
    public Object getLocaleList() {
        return null;
    }

    public int hashCode() {
        int i = 1;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            Locale[] localeArr = this.f2512a;
            if (i3 >= localeArr.length) {
                return i;
            }
            i = (i * 31) + localeArr[i3].hashCode();
            i2 = i3 + 1;
        }
    }

    @Override // androidx.core.os.LocaleListInterface
    public int indexOf(Locale locale) {
        int i = 0;
        while (true) {
            int i2 = i;
            Locale[] localeArr = this.f2512a;
            if (i2 >= localeArr.length) {
                return -1;
            }
            if (localeArr[i2].equals(locale)) {
                return i2;
            }
            i = i2 + 1;
        }
    }

    @Override // androidx.core.os.LocaleListInterface
    public boolean isEmpty() {
        return this.f2512a.length == 0;
    }

    @Override // androidx.core.os.LocaleListInterface
    public int size() {
        return this.f2512a.length;
    }

    @Override // androidx.core.os.LocaleListInterface
    public String toLanguageTags() {
        return this.b;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        int i = 0;
        while (true) {
            int i2 = i;
            Locale[] localeArr = this.f2512a;
            if (i2 >= localeArr.length) {
                sb.append("]");
                return sb.toString();
            }
            sb.append(localeArr[i2]);
            if (i2 < this.f2512a.length - 1) {
                sb.append(',');
            }
            i = i2 + 1;
        }
    }
}
