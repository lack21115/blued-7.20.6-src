package com.oplus.quickgame.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.oplus.quickgame.sdk.engine.c.b;
import com.oplus.quickgame.sdk.engine.c.c;
import com.oplus.quickgame.sdk.engine.callback.Callback;
import com.oplus.quickgame.sdk.engine.utils.QgRouterManager;
import com.oplus.quickgame.sdk.engine.utils.i;
import com.oplus.quickgame.sdk.engine.utils.j;
import com.oplus.quickgame.sdk.engine.utils.n;
import com.oplus.quickgame.sdk.hall.GameHall;
import com.oplus.quickgame.sdk.hall.a.a;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/oplus/quickgame/sdk/QuickGame.class */
public class QuickGame {

    /* loaded from: source-8303388-dex2jar.jar:com/oplus/quickgame/sdk/QuickGame$Builder.class */
    public static abstract class Builder {
        public abstract Req build();

        public abstract Builder putDeepLink(String str, String str2);

        public abstract Builder putExtra(String str, String str2);

        public abstract Builder putPlatform(String str, String str2);

        public abstract Builder putStat(String str, String str2);

        public abstract Builder setCallback(Callback callback);

        public abstract Builder setExtra(String str);

        public abstract Builder setFrom(String str);

        public abstract Builder setPackage(String str);

        public abstract Builder setRequestUrl(String str);

        public abstract Builder signAsPlatform();
    }

    /* loaded from: source-8303388-dex2jar.jar:com/oplus/quickgame/sdk/QuickGame$FromBuilder.class */
    public static abstract class FromBuilder {
        public abstract String build();

        public abstract FromBuilder set(String str, String str2);

        public abstract FromBuilder setScene(String str);

        public abstract FromBuilder setTraceId(String str);
    }

    /* loaded from: source-8303388-dex2jar.jar:com/oplus/quickgame/sdk/QuickGame$GameHallRouterBuilder.class */
    public static abstract class GameHallRouterBuilder {
        public abstract String build();

        public abstract GameHallRouterBuilder setHost(String str);

        public abstract GameHallRouterBuilder setParams(Map<String, Object> map);

        public abstract GameHallRouterBuilder setPath(String str);

        public abstract GameHallRouterBuilder setScheme(String str);
    }

    /* loaded from: source-8303388-dex2jar.jar:com/oplus/quickgame/sdk/QuickGame$IStatisticsProvider.class */
    public interface IStatisticsProvider {
        void onStat(Map<String, String> map);
    }

    /* loaded from: source-8303388-dex2jar.jar:com/oplus/quickgame/sdk/QuickGame$OapsBuilder.class */
    public static abstract class OapsBuilder {
        public abstract String build();

        public abstract OapsBuilder setHost(String str);

        public abstract OapsBuilder setParams(Map<String, Object> map);

        public abstract OapsBuilder setPath(String str);

        public abstract OapsBuilder setScheme(String str);
    }

    /* loaded from: source-8303388-dex2jar.jar:com/oplus/quickgame/sdk/QuickGame$Req.class */
    public static abstract class Req {
        public abstract void preload(Context context);

        public abstract void reqCleanGameCache(Context context);

        public abstract void reqCleanOneGameCache(Context context, String str);

        public abstract void reqGameCacheSize(Context context);

        public abstract void reqGamePkgList(Context context);

        public abstract void reqReportErrorLog(Context context);

        public abstract void request(Context context);
    }

    public static Builder createBuilder(String str, String str2) {
        return new b(str, str2);
    }

    public static FromBuilder createFromBuilder() {
        return new c();
    }

    public static GameHallRouterBuilder createGameHallRouterBuilder() {
        return new a();
    }

    @Deprecated
    public static void enableLog() {
        i.a();
    }

    public static String getEngineShowVersion(Context context) {
        return n.c(context);
    }

    public static String getEngineVersion(Context context) {
        return n.f(context);
    }

    public static int getEngineVersionCode(Context context) {
        return n.d(context);
    }

    public static GameHall getHall() {
        return GameHall.getInstance();
    }

    public static int getSDKVersion() {
        return n.a();
    }

    public static boolean isEngineInstalled(Context context) {
        return n.g(context);
    }

    public static boolean isUriSupported(String str) {
        return j.a(str);
    }

    public static boolean isUseEngine(Context context) {
        return QgRouterManager.isUseEngine(context);
    }

    public static boolean isUseEngineConfig(Context context) {
        String requestEngineConfigIfNeed = QgRouterManager.requestEngineConfigIfNeed(context);
        if (TextUtils.isEmpty(requestEngineConfigIfNeed)) {
            return false;
        }
        return QgRouterManager.configDataCache(requestEngineConfigIfNeed);
    }

    public static boolean isXGameEngineWillUse(Context context) {
        return isEngineInstalled(context) && isUseEngineConfig(context) && isUseEngine(context);
    }

    public static boolean isXGameEngineWillUse(Context context, String str) {
        return isUriSupported(str) && isEngineInstalled(context) && isUseEngineConfig(context) && isUseEngine(context);
    }

    public static void setLoggable(boolean z) {
        if (z) {
            enableLog();
        } else {
            i.b();
        }
    }

    public static void setStatisticsProvider(IStatisticsProvider iStatisticsProvider) {
        com.oplus.quickgame.sdk.engine.d.a.b().a(iStatisticsProvider);
    }
}
