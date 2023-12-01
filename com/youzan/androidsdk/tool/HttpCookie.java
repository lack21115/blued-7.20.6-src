package com.youzan.androidsdk.tool;

import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/androidsdk/tool/HttpCookie.class */
public final class HttpCookie {

    /* renamed from: ˊ  reason: contains not printable characters */
    private static final TimeZone f1118 = TimeZone.getTimeZone("GMT");

    /* renamed from: ˋ  reason: contains not printable characters */
    private static final ThreadLocal<DateFormat> f1119 = new ThreadLocal<DateFormat>() { // from class: com.youzan.androidsdk.tool.HttpCookie.1
        @Override // java.lang.ThreadLocal
        protected final /* synthetic */ DateFormat initialValue() {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
            simpleDateFormat.setLenient(false);
            simpleDateFormat.setTimeZone(HttpCookie.f1118);
            return simpleDateFormat;
        }
    };

    /* renamed from: ʻ  reason: contains not printable characters */
    private final String f1120;

    /* renamed from: ʼ  reason: contains not printable characters */
    private final String f1121;

    /* renamed from: ʽ  reason: contains not printable characters */
    private final boolean f1122;

    /* renamed from: ʾ  reason: contains not printable characters */
    private final boolean f1123;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final String f1124;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final String f1125;

    /* renamed from: ͺ  reason: contains not printable characters */
    private final boolean f1126;

    /* renamed from: ι  reason: contains not printable characters */
    private final boolean f1127;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private final long f1128;

    /* loaded from: source-8829756-dex2jar.jar:com/youzan/androidsdk/tool/HttpCookie$Builder.class */
    public static final class Builder {

        /* renamed from: ʻ  reason: contains not printable characters */
        boolean f1129;

        /* renamed from: ʼ  reason: contains not printable characters */
        boolean f1130;

        /* renamed from: ʽ  reason: contains not printable characters */
        boolean f1131;

        /* renamed from: ˊ  reason: contains not printable characters */
        String f1132;

        /* renamed from: ˋ  reason: contains not printable characters */
        String f1133;

        /* renamed from: ˏ  reason: contains not printable characters */
        String f1135;

        /* renamed from: ͺ  reason: contains not printable characters */
        boolean f1136;

        /* renamed from: ˎ  reason: contains not printable characters */
        long f1134 = 253402300799999L;

        /* renamed from: ᐝ  reason: contains not printable characters */
        String f1137 = BridgeUtil.SPLIT_MARK;

        /* renamed from: ˊ  reason: contains not printable characters */
        private Builder m12243(String str, boolean z) {
            this.f1135 = str;
            this.f1136 = z;
            return this;
        }

        public final HttpCookie build() {
            return new HttpCookie(this, (byte) 0);
        }

        public final Builder domain(String str) {
            return m12243(str, false);
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
            this.f1134 = j3;
            this.f1131 = true;
            return this;
        }

        public final Builder hostOnlyDomain(String str) {
            return m12243(str, true);
        }

        public final Builder httpOnly() {
            this.f1130 = true;
            return this;
        }

        public final Builder name(String str) {
            this.f1132 = str;
            return this;
        }

        public final Builder path(String str) {
            this.f1137 = str;
            return this;
        }

        public final Builder secure() {
            this.f1129 = true;
            return this;
        }

        public final Builder value(String str) {
            this.f1133 = str != null ? str.trim() : null;
            return this;
        }
    }

    private HttpCookie(Builder builder) {
        this.f1124 = builder.f1132;
        this.f1125 = builder.f1133;
        this.f1128 = builder.f1134;
        this.f1120 = builder.f1135;
        this.f1121 = builder.f1137;
        this.f1122 = builder.f1129;
        this.f1126 = builder.f1130;
        this.f1127 = builder.f1131;
        this.f1123 = builder.f1136;
    }

    /* synthetic */ HttpCookie(Builder builder, byte b) {
        this(builder);
    }

    public final String domain() {
        return this.f1120;
    }

    public final long expiresAt() {
        return this.f1128;
    }

    public final boolean hostOnly() {
        return this.f1123;
    }

    public final boolean httpOnly() {
        return this.f1126;
    }

    public final String name() {
        return this.f1124;
    }

    public final String path() {
        return this.f1121;
    }

    public final boolean persistent() {
        return this.f1127;
    }

    public final boolean secure() {
        return this.f1122;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f1124);
        sb.append('=');
        sb.append(this.f1125);
        if (this.f1127) {
            if (this.f1128 == Long.MIN_VALUE) {
                sb.append("; max-age=0");
            } else {
                sb.append("; expires=");
                sb.append(f1119.get().format(new Date(this.f1128)));
            }
        }
        if (!this.f1123) {
            sb.append("; domain=");
            sb.append(this.f1120);
        }
        sb.append("; path=");
        sb.append(this.f1121);
        if (this.f1122) {
            sb.append("; secure");
        }
        if (this.f1126) {
            sb.append("; httponly");
        }
        return sb.toString();
    }

    public final String value() {
        return this.f1125;
    }
}
