package org.commonmark.internal.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: source-3503164-dex2jar.jar:org/commonmark/internal/util/Html5Entities.class */
public class Html5Entities {

    /* renamed from: a  reason: collision with root package name */
    private static final Map<String, String> f44048a = a();
    private static final Pattern b = Pattern.compile("^&#[Xx]?");

    public static String a(String str) {
        Matcher matcher = b.matcher(str);
        if (!matcher.find()) {
            String str2 = f44048a.get(str.substring(1, str.length() - 1));
            return str2 != null ? str2 : str;
        }
        try {
            int parseInt = Integer.parseInt(str.substring(matcher.end(), str.length() - 1), matcher.end() == 2 ? 10 : 16);
            return parseInt == 0 ? "�" : new String(Character.toChars(parseInt));
        } catch (IllegalArgumentException e) {
            return "�";
        }
    }

    private static Map<String, String> a() {
        HashMap hashMap = new HashMap();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Html5Entities.class.getResourceAsStream("/org/commonmark/internal/util/entities.properties"), Charset.forName("UTF-8")));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    bufferedReader.close();
                    hashMap.put("NewLine", "\n");
                    return hashMap;
                } else if (readLine.length() != 0) {
                    int indexOf = readLine.indexOf("=");
                    hashMap.put(readLine.substring(0, indexOf), readLine.substring(indexOf + 1));
                }
            }
        } catch (IOException e) {
            throw new IllegalStateException("Failed reading data for HTML named character references", e);
        }
    }
}
