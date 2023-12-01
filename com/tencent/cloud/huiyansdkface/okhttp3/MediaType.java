package com.tencent.cloud.huiyansdkface.okhttp3;

import android.content.ClipDescription;
import com.huawei.openalliance.ad.constant.ax;
import com.tencent.qcloud.core.http.HttpConstants;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/okhttp3/MediaType.class */
public final class MediaType {
    private final String m;
    private final String n;
    private final String o;
    private final String p;
    private static final Pattern k = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");
    private static final Pattern l = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");

    /* renamed from: a  reason: collision with root package name */
    public static final MediaType f35863a = parse(ax.Z);
    public static final MediaType b = parse(ax.I);

    /* renamed from: c  reason: collision with root package name */
    public static final MediaType f35864c = parse(ax.B);
    public static final MediaType d = parse("text/plain");
    public static final MediaType e = parse(ClipDescription.MIMETYPE_TEXT_HTML);
    public static final MediaType f = parse("text/xml");
    public static final MediaType g = parse("application/json");
    public static final MediaType h = parse("application/x-www-form-urlencoded");
    public static final MediaType i = parse(HttpConstants.ContentType.MULTIPART_FORM_DATA);
    public static final MediaType j = parse("application/octet-stream");

    private MediaType(String str, String str2, String str3, String str4) {
        this.m = str;
        this.n = str2;
        this.o = str3;
        this.p = str4;
    }

    public static MediaType get(String str) {
        Matcher matcher = k.matcher(str);
        if (!matcher.lookingAt()) {
            throw new IllegalArgumentException("No subtype found for: \"" + str + '\"');
        }
        String lowerCase = matcher.group(1).toLowerCase(Locale.US);
        String lowerCase2 = matcher.group(2).toLowerCase(Locale.US);
        String str2 = null;
        Matcher matcher2 = l.matcher(str);
        int end = matcher.end();
        while (end < str.length()) {
            matcher2.region(end, str.length());
            if (!matcher2.lookingAt()) {
                throw new IllegalArgumentException("Parameter is not formatted correctly: \"" + str.substring(end) + "\" for: \"" + str + '\"');
            }
            String group = matcher2.group(1);
            String str3 = str2;
            if (group != null) {
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
                    str3 = str2;
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
        } catch (IllegalArgumentException e2) {
            return null;
        }
    }

    public Charset charset() {
        return charset(null);
    }

    public Charset charset(Charset charset) {
        Charset charset2 = charset;
        try {
            if (this.p != null) {
                charset2 = Charset.forName(this.p);
            }
            return charset2;
        } catch (IllegalArgumentException e2) {
            return charset;
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof MediaType) && ((MediaType) obj).m.equals(this.m);
    }

    public int hashCode() {
        return this.m.hashCode();
    }

    public String subtype() {
        return this.o;
    }

    public String toString() {
        return this.m;
    }

    public String type() {
        return this.n;
    }
}
