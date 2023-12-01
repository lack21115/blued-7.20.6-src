package com.opos.cmn.an.b;

import java.util.Locale;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/an/b/b.class */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static Locale f24487a;

    public static String a() {
        String language = c().getLanguage();
        String str = language;
        if (language == null) {
            str = "";
        }
        return str;
    }

    public static String b() {
        String country = c().getCountry();
        String str = country;
        if (country == null) {
            str = "";
        }
        return str;
    }

    private static Locale c() {
        if (f24487a == null) {
            f24487a = Locale.getDefault();
        }
        return f24487a;
    }
}
