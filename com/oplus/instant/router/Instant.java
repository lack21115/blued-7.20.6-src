package com.oplus.instant.router;

import android.content.Context;
import com.oplus.instant.router.callback.Callback;
import com.oplus.instant.router.d.b;
import com.oplus.instant.router.d.c;
import com.oplus.instant.router.g.d;
import com.oplus.instant.router.g.e;
import com.oplus.instant.router.g.h;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/oplus/instant/router/Instant.class */
public class Instant {
    public static final String HOST_INSTANT = "instant";
    public static final String PATH_APP = "/app";
    public static final String SCHEME_OAPS = "oaps";

    /* loaded from: source-8303388-dex2jar.jar:com/oplus/instant/router/Instant$Builder.class */
    public static abstract class Builder {
        public abstract Req build();

        public abstract Builder putExtra(String str, String str2);

        public abstract Builder putParams(String str, String str2);

        public abstract Builder putStat(String str, String str2);

        public abstract Builder setCallback(Callback callback);

        public abstract Builder setExtra(String str);

        public abstract Builder setFrom(String str);

        @Deprecated
        public abstract Builder setPackage(String str);

        @Deprecated
        public abstract Builder setPage(String str);

        @Deprecated
        public abstract Builder setPath(String str);

        public abstract Builder setRequestUrl(String str);

        public abstract Builder signAsPlatform();
    }

    /* loaded from: source-8303388-dex2jar.jar:com/oplus/instant/router/Instant$FromBuilder.class */
    public static abstract class FromBuilder {
        public abstract String build();

        public abstract FromBuilder set(String str, String str2);

        public abstract FromBuilder setScene(String str);

        public abstract FromBuilder setTraceId(String str);
    }

    /* loaded from: source-8303388-dex2jar.jar:com/oplus/instant/router/Instant$IStatisticsProvider.class */
    public interface IStatisticsProvider {
        void onStat(Map<String, String> map);
    }

    /* loaded from: source-8303388-dex2jar.jar:com/oplus/instant/router/Instant$Req.class */
    public static abstract class Req {
        public abstract void preload(Context context);

        public abstract void request(Context context);
    }

    public static Builder createBuilder(String str, String str2) {
        return new b(str, str2);
    }

    public static FromBuilder createFromBuilder() {
        return new c();
    }

    public static void enableLog() {
        d.a();
    }

    public static String getSDKVersion() {
        return h.a();
    }

    public static String getVersion(Context context) {
        return h.a(context);
    }

    @Deprecated
    public static boolean isFitPltVersion(Context context, String str) {
        return h.b(context, str);
    }

    @Deprecated
    public static boolean isFitPltVersionStrict(Context context, String str) {
        return h.a(context, str);
    }

    @Deprecated
    public static boolean isInstantOapsUri(String str) {
        return e.a(str);
    }

    public static boolean isInstantPlatformInstalled(Context context) {
        return h.b(context);
    }

    public static void setStatisticsProvider(IStatisticsProvider iStatisticsProvider) {
        com.oplus.instant.router.f.a.a().a(iStatisticsProvider);
    }
}
