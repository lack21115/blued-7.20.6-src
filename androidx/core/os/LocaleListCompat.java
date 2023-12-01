package androidx.core.os;

import android.os.Build;
import android.os.LocaleList;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.util.Locale;

/* loaded from: source-8756600-dex2jar.jar:androidx/core/os/LocaleListCompat.class */
public final class LocaleListCompat {

    /* renamed from: a  reason: collision with root package name */
    private static final LocaleListCompat f2510a = create(new Locale[0]);
    private LocaleListInterface b;

    private LocaleListCompat(LocaleListInterface localeListInterface) {
        this.b = localeListInterface;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Locale a(String str) {
        if (str.contains("-")) {
            String[] split = str.split("-", -1);
            if (split.length > 2) {
                return new Locale(split[0], split[1], split[2]);
            }
            if (split.length > 1) {
                return new Locale(split[0], split[1]);
            }
            if (split.length == 1) {
                return new Locale(split[0]);
            }
        } else if (!str.contains(BridgeUtil.UNDERLINE_STR)) {
            return new Locale(str);
        } else {
            String[] split2 = str.split(BridgeUtil.UNDERLINE_STR, -1);
            if (split2.length > 2) {
                return new Locale(split2[0], split2[1], split2[2]);
            }
            if (split2.length > 1) {
                return new Locale(split2[0], split2[1]);
            }
            if (split2.length == 1) {
                return new Locale(split2[0]);
            }
        }
        throw new IllegalArgumentException("Can not parse language tag: [" + str + "]");
    }

    public static LocaleListCompat create(Locale... localeArr) {
        return Build.VERSION.SDK_INT >= 24 ? wrap(new LocaleList(localeArr)) : new LocaleListCompat(new LocaleListCompatWrapper(localeArr));
    }

    public static LocaleListCompat forLanguageTags(String str) {
        if (str == null || str.isEmpty()) {
            return getEmptyLocaleList();
        }
        String[] split = str.split(",", -1);
        int length = split.length;
        Locale[] localeArr = new Locale[length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return create(localeArr);
            }
            localeArr[i2] = Build.VERSION.SDK_INT >= 21 ? Locale.forLanguageTag(split[i2]) : a(split[i2]);
            i = i2 + 1;
        }
    }

    public static LocaleListCompat getAdjustedDefault() {
        return Build.VERSION.SDK_INT >= 24 ? wrap(LocaleList.getAdjustedDefault()) : create(Locale.getDefault());
    }

    public static LocaleListCompat getDefault() {
        return Build.VERSION.SDK_INT >= 24 ? wrap(LocaleList.getDefault()) : create(Locale.getDefault());
    }

    public static LocaleListCompat getEmptyLocaleList() {
        return f2510a;
    }

    public static LocaleListCompat wrap(LocaleList localeList) {
        return new LocaleListCompat(new LocaleListPlatformWrapper(localeList));
    }

    @Deprecated
    public static LocaleListCompat wrap(Object obj) {
        return wrap((LocaleList) obj);
    }

    public boolean equals(Object obj) {
        return (obj instanceof LocaleListCompat) && this.b.equals(((LocaleListCompat) obj).b);
    }

    public Locale get(int i) {
        return this.b.get(i);
    }

    public Locale getFirstMatch(String[] strArr) {
        return this.b.getFirstMatch(strArr);
    }

    public int hashCode() {
        return this.b.hashCode();
    }

    public int indexOf(Locale locale) {
        return this.b.indexOf(locale);
    }

    public boolean isEmpty() {
        return this.b.isEmpty();
    }

    public int size() {
        return this.b.size();
    }

    public String toLanguageTags() {
        return this.b.toLanguageTags();
    }

    public String toString() {
        return this.b.toString();
    }

    public Object unwrap() {
        return this.b.getLocaleList();
    }
}
