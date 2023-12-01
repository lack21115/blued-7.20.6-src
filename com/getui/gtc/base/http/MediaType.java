package com.getui.gtc.base.http;

import java.nio.charset.Charset;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/base/http/MediaType.class */
public class MediaType {
    private static final String QUOTED = "\"([^\"]*)\"";
    private static final String TOKEN = "([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)";
    private final String charset;
    private final String mediaType;
    private final String subtype;
    private final String type;
    private static final Pattern TYPE_SUBTYPE = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");
    private static final Pattern PARAMETER = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");

    private MediaType(String str, String str2, String str3, String str4) {
        this.mediaType = str;
        this.type = str2;
        this.subtype = str3;
        this.charset = str4;
    }

    public static MediaType get(String str) {
        Matcher matcher = TYPE_SUBTYPE.matcher(str);
        if (!matcher.lookingAt()) {
            throw new IllegalArgumentException("No subtype found for: \"" + str + '\"');
        }
        String lowerCase = matcher.group(1).toLowerCase(Locale.US);
        String lowerCase2 = matcher.group(2).toLowerCase(Locale.US);
        String str2 = null;
        Matcher matcher2 = PARAMETER.matcher(str);
        int end = matcher.end();
        while (end < str.length()) {
            matcher2.region(end, str.length());
            if (!matcher2.lookingAt()) {
                throw new IllegalArgumentException("Parameter is not formatted correctly: \"" + str.substring(end) + "\" for: \"" + str + '\"');
            }
            String group = matcher2.group(1);
            String str3 = str2;
            if (group != null) {
                str3 = str2;
                if (group.equalsIgnoreCase("charset")) {
                    String group2 = matcher2.group(2);
                    if (group2 != null) {
                        str3 = group2;
                        if (group2.startsWith("'")) {
                            str3 = group2;
                            if (group2.endsWith("'")) {
                                str3 = group2;
                                if (group2.length() > 2) {
                                    str3 = group2.substring(1, group2.length() - 1);
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
                    continue;
                }
            }
            end = matcher2.end();
            str2 = str3;
        }
        return new MediaType(str, lowerCase, lowerCase2, str2);
    }

    public static MediaType parse(String str) {
        try {
            return get(str);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    public Charset charset() {
        return charset(Charset.defaultCharset());
    }

    public Charset charset(Charset charset) {
        Charset charset2 = charset;
        try {
            if (this.charset != null) {
                charset2 = Charset.forName(this.charset);
            }
            return charset2;
        } catch (IllegalArgumentException e) {
            return charset;
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof MediaType) && ((MediaType) obj).mediaType.equals(this.mediaType);
    }

    public int hashCode() {
        return this.mediaType.hashCode();
    }

    public String subtype() {
        return this.subtype;
    }

    public String toString() {
        return this.mediaType;
    }

    public String type() {
        return this.type;
    }
}
