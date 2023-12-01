package com.meizu.cloud.pushsdk.c.c;

import java.nio.charset.Charset;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: source-7994992-dex2jar.jar:com/meizu/cloud/pushsdk/c/c/g.class */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f10420a = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");
    private static final Pattern b = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");

    /* renamed from: c  reason: collision with root package name */
    private final String f10421c;
    private final String d;
    private final String e;
    private final String f;

    private g(String str, String str2, String str3, String str4) {
        this.f10421c = str;
        this.d = str2;
        this.e = str3;
        this.f = str4;
    }

    public static g a(String str) {
        String group;
        Matcher matcher = f10420a.matcher(str);
        if (!matcher.lookingAt()) {
            return null;
        }
        String lowerCase = matcher.group(1).toLowerCase(Locale.US);
        String lowerCase2 = matcher.group(2).toLowerCase(Locale.US);
        Matcher matcher2 = b.matcher(str);
        int end = matcher.end();
        String str2 = null;
        while (true) {
            String str3 = str2;
            if (end >= str.length()) {
                return new g(str, lowerCase, lowerCase2, str3);
            }
            matcher2.region(end, str.length());
            if (!matcher2.lookingAt()) {
                return null;
            }
            if ("charset".equalsIgnoreCase(matcher2.group(1))) {
                group = matcher2.group(2) != null ? matcher2.group(2) : matcher2.group(3);
                if (str3 != null && !group.equalsIgnoreCase(str3)) {
                    throw new IllegalArgumentException("Multiple different charsets: " + str);
                }
            } else {
                group = str3;
            }
            end = matcher2.end();
            str2 = group;
        }
    }

    public String a() {
        return this.d;
    }

    public Charset b() {
        String str = this.f;
        if (str != null) {
            return Charset.forName(str);
        }
        return null;
    }

    public boolean equals(Object obj) {
        return (obj instanceof g) && ((g) obj).f10421c.equals(this.f10421c);
    }

    public int hashCode() {
        return this.f10421c.hashCode();
    }

    public String toString() {
        return this.f10421c;
    }
}
