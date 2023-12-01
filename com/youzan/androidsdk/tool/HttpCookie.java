package com.youzan.androidsdk.tool;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/androidsdk/tool/HttpCookie.class */
public final class HttpCookie {

    /* renamed from: ˊ  reason: contains not printable characters */
    private static final TimeZone f1071 = TimeZone.getTimeZone("GMT");

    /* renamed from: ˋ  reason: contains not printable characters */
    private static final ThreadLocal<DateFormat> f1072 = new ThreadLocal<DateFormat>() { // from class: com.youzan.androidsdk.tool.HttpCookie.1
        @Override // java.lang.ThreadLocal
        protected final /* synthetic */ DateFormat initialValue() {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
            simpleDateFormat.setLenient(false);
            simpleDateFormat.setTimeZone(HttpCookie.f1071);
            return simpleDateFormat;
        }
    };

    /* renamed from: ʻ  reason: contains not printable characters */
    private final String f1073;

    /* renamed from: ʼ  reason: contains not printable characters */
    private final String f1074;

    /* renamed from: ʽ  reason: contains not printable characters */
    private final boolean f1075;

    /* renamed from: ʾ  reason: contains not printable characters */
    private final boolean f1076;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final String f1077;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final String f1078;

    /* renamed from: ͺ  reason: contains not printable characters */
    private final boolean f1079;

    /* renamed from: ι  reason: contains not printable characters */
    private final boolean f1080;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private final long f1081;

    /* loaded from: source-8829756-dex2jar.jar:com/youzan/androidsdk/tool/HttpCookie$Builder.class */
    public static final class Builder {

        /* renamed from: ʻ  reason: contains not printable characters */
        boolean f1082;

        /* renamed from: ʼ  reason: contains not printable characters */
        boolean f1083;

        /* renamed from: ʽ  reason: contains not printable characters */
        boolean f1084;

        /* renamed from: ˊ  reason: contains not printable characters */
        String f1085;

        /* renamed from: ˋ  reason: contains not printable characters */
        String f1086;

        /* renamed from: ˏ  reason: contains not printable characters */
        String f1088;

        /* renamed from: ͺ  reason: contains not printable characters */
        boolean f1089;

        /* renamed from: ˎ  reason: contains not printable characters */
        long f1087 = 253402300799999L;

        /* renamed from: ᐝ  reason: contains not printable characters */
        String f1090 = "/";

        /* renamed from: ˊ  reason: contains not printable characters */
        private Builder m9193(String str, boolean z) {
            this.f1088 = str;
            this.f1089 = z;
            return this;
        }

        public final HttpCookie build() {
            return new HttpCookie(this, (byte) 0);
        }

        public final Builder domain(String str) {
            return m9193(str, false);
        }

        public final Builder expiresAt(long j) {
            long j2 = j;
            if (j <= 0) {
                j2 = Long.MIN_VALUE;
            }
            long j3 = j2;
            if (j2 > 253402300799999L) {
                j3 = 253402300799999L;
            }
            this.f1087 = j3;
            this.f1084 = true;
            return this;
        }

        public final Builder hostOnlyDomain(String str) {
            return m9193(str, true);
        }

        public final Builder httpOnly() {
            this.f1083 = true;
            return this;
        }

        public final Builder name(String str) {
            this.f1085 = str;
            return this;
        }

        public final Builder path(String str) {
            this.f1090 = str;
            return this;
        }

        public final Builder secure() {
            this.f1082 = true;
            return this;
        }

        public final Builder value(String str) {
            this.f1086 = str != null ? str.trim() : null;
            return this;
        }
    }

    private HttpCookie(Builder builder) {
        this.f1077 = builder.f1085;
        this.f1078 = builder.f1086;
        this.f1081 = builder.f1087;
        this.f1073 = builder.f1088;
        this.f1074 = builder.f1090;
        this.f1075 = builder.f1082;
        this.f1079 = builder.f1083;
        this.f1080 = builder.f1084;
        this.f1076 = builder.f1089;
    }

    /* synthetic */ HttpCookie(Builder builder, byte b) {
        this(builder);
    }

    public final String domain() {
        return this.f1073;
    }

    public final long expiresAt() {
        return this.f1081;
    }

    public final boolean hostOnly() {
        return this.f1076;
    }

    public final boolean httpOnly() {
        return this.f1079;
    }

    public final String name() {
        return this.f1077;
    }

    public final String path() {
        return this.f1074;
    }

    public final boolean persistent() {
        return this.f1080;
    }

    public final boolean secure() {
        return this.f1075;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f1077);
        sb.append('=');
        sb.append(this.f1078);
        if (this.f1080) {
            if (this.f1081 == Long.MIN_VALUE) {
                sb.append("; max-age=0");
            } else {
                sb.append("; expires=");
                sb.append(f1072.get().format(new Date(this.f1081)));
            }
        }
        if (!this.f1076) {
            sb.append("; domain=");
            sb.append(this.f1073);
        }
        sb.append("; path=");
        sb.append(this.f1074);
        if (this.f1075) {
            sb.append("; secure");
        }
        if (this.f1079) {
            sb.append("; httponly");
        }
        return sb.toString();
    }

    public final String value() {
        return this.f1078;
    }
}
