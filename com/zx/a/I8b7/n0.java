package com.zx.a.I8b7;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/n0.class */
public class n0 {

    /* renamed from: c  reason: collision with root package name */
    public static final Pattern f28459c = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");
    public static final Pattern d = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");

    /* renamed from: a  reason: collision with root package name */
    public final String f28460a;
    public final String b;

    public n0(String str, String str2, String str3, String str4) {
        this.f28460a = str;
        this.b = str4;
    }

    public static n0 a(String str) {
        Matcher matcher = f28459c.matcher(str);
        if (!matcher.lookingAt()) {
            throw new IllegalArgumentException("No subtype found for: \"" + str + '\"');
        }
        String group = matcher.group(1);
        Locale locale = Locale.US;
        String lowerCase = group.toLowerCase(locale);
        String lowerCase2 = matcher.group(2).toLowerCase(locale);
        String str2 = null;
        Matcher matcher2 = d.matcher(str);
        int end = matcher.end();
        while (end < str.length()) {
            matcher2.region(end, str.length());
            if (!matcher2.lookingAt()) {
                StringBuilder a2 = m2.a("Parameter is not formatted correctly: \"");
                a2.append(str.substring(end));
                a2.append("\" for: \"");
                a2.append(str);
                a2.append('\"');
                throw new IllegalArgumentException(a2.toString());
            }
            String group2 = matcher2.group(1);
            String str3 = str2;
            if (group2 != null) {
                if (group2.equalsIgnoreCase("charset")) {
                    String group3 = matcher2.group(2);
                    if (group3 != null) {
                        str3 = group3;
                        if (group3.startsWith("'")) {
                            str3 = group3;
                            if (group3.endsWith("'")) {
                                str3 = group3;
                                if (group3.length() > 2) {
                                    str3 = group3.substring(1, group3.length() - 1);
                                }
                            }
                        }
                    } else {
                        str3 = matcher2.group(3);
                    }
                    if (str2 != null && !str3.equalsIgnoreCase(str2)) {
                        throw new IllegalArgumentException("Multiple charsets defined: \"" + str2 + "\" and: \"" + str3 + "\" for: \"" + str + '\"');
                    }
                } else {
                    str3 = str2;
                }
            }
            end = matcher2.end();
            str2 = str3;
        }
        return new n0(str, lowerCase, lowerCase2, str2);
    }

    public static n0 b(String str) {
        try {
            return a(str);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    public Charset a() {
        Charset charset = StandardCharsets.UTF_8;
        try {
            String str = this.b;
            Charset charset2 = charset;
            if (str != null) {
                charset2 = Charset.forName(str);
            }
            return charset2;
        } catch (IllegalArgumentException e) {
            return charset;
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof n0) && ((n0) obj).f28460a.equals(this.f28460a);
    }

    public int hashCode() {
        return this.f28460a.hashCode();
    }

    public String toString() {
        return this.f28460a;
    }
}
