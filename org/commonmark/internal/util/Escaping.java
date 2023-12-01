package org.commonmark.internal.util;

import java.nio.charset.Charset;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: source-3503164-dex2jar.jar:org/commonmark/internal/util/Escaping.class */
public class Escaping {
    private static final Pattern a = Pattern.compile("[\\\\&]");
    private static final Pattern b = Pattern.compile("\\\\[!\"#$%&'()*+,./:;<=>?@\\[\\\\\\]^_`{|}~-]|&(?:#x[a-f0-9]{1,6}|#[0-9]{1,7}|[a-z][a-z0-9]{1,31});", 2);
    private static final Pattern c = Pattern.compile("(%[a-fA-F0-9]{0,2}|[^:/?#@!$&'()*+,;=a-zA-Z0-9\\-._~])");
    private static final char[] d = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private static final Pattern e = Pattern.compile("[ \t\r\n]+");
    private static final Replacer f = new Replacer() { // from class: org.commonmark.internal.util.Escaping.1
        @Override // org.commonmark.internal.util.Escaping.Replacer
        public void a(String str, StringBuilder sb) {
            if (str.charAt(0) == '\\') {
                sb.append((CharSequence) str, 1, str.length());
            } else {
                sb.append(Html5Entities.a(str));
            }
        }
    };
    private static final Replacer g = new Replacer() { // from class: org.commonmark.internal.util.Escaping.2
        @Override // org.commonmark.internal.util.Escaping.Replacer
        public void a(String str, StringBuilder sb) {
            if (str.startsWith("%")) {
                if (str.length() == 3) {
                    sb.append(str);
                    return;
                }
                sb.append("%25");
                sb.append((CharSequence) str, 1, str.length());
                return;
            }
            byte[] bytes = str.getBytes(Charset.forName("UTF-8"));
            int length = bytes.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return;
                }
                byte b2 = bytes[i2];
                sb.append('%');
                sb.append(Escaping.d[(b2 >> 4) & 15]);
                sb.append(Escaping.d[b2 & 15]);
                i = i2 + 1;
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-3503164-dex2jar.jar:org/commonmark/internal/util/Escaping$Replacer.class */
    public interface Replacer {
        void a(String str, StringBuilder sb);
    }

    public static String a(String str) {
        String str2;
        StringBuilder sb;
        StringBuilder sb2 = null;
        int i = 0;
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (charAt == '\"') {
                str2 = "&quot;";
            } else if (charAt == '&') {
                str2 = "&amp;";
            } else if (charAt == '<') {
                str2 = "&lt;";
            } else if (charAt != '>') {
                sb = sb2;
                if (sb2 != null) {
                    sb2.append(charAt);
                    sb = sb2;
                }
                i++;
                sb2 = sb;
            } else {
                str2 = "&gt;";
            }
            sb = sb2;
            if (sb2 == null) {
                sb = new StringBuilder();
                sb.append((CharSequence) str, 0, i);
            }
            sb.append(str2);
            i++;
            sb2 = sb;
        }
        if (sb2 != null) {
            str = sb2.toString();
        }
        return str;
    }

    private static String a(Pattern pattern, String str, Replacer replacer) {
        int end;
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            StringBuilder sb = new StringBuilder(str.length() + 16);
            int i = 0;
            do {
                sb.append((CharSequence) str, i, matcher.start());
                replacer.a(matcher.group(), sb);
                end = matcher.end();
                i = end;
            } while (matcher.find());
            if (end != str.length()) {
                sb.append((CharSequence) str, end, str.length());
            }
            return sb.toString();
        }
        return str;
    }

    public static String b(String str) {
        String str2 = str;
        if (a.matcher(str).find()) {
            str2 = a(b, str, f);
        }
        return str2;
    }

    public static String c(String str) {
        return a(c, str, g);
    }

    public static String d(String str) {
        return e(str.substring(1, str.length() - 1));
    }

    public static String e(String str) {
        return e.matcher(str.trim().toLowerCase(Locale.ROOT)).replaceAll(" ");
    }
}
