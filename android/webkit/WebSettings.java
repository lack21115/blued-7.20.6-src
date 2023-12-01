package android.webkit;

import android.content.Context;

/* loaded from: source-4181928-dex2jar.jar:android/webkit/WebSettings.class */
public abstract class WebSettings {
    public static final int LOAD_CACHE_ELSE_NETWORK = 1;
    public static final int LOAD_CACHE_ONLY = 3;
    public static final int LOAD_DEFAULT = -1;
    @Deprecated
    public static final int LOAD_NORMAL = 0;
    public static final int LOAD_NO_CACHE = 2;
    public static final int MIXED_CONTENT_ALWAYS_ALLOW = 0;
    public static final int MIXED_CONTENT_COMPATIBILITY_MODE = 2;
    public static final int MIXED_CONTENT_NEVER_ALLOW = 1;

    /* loaded from: source-4181928-dex2jar.jar:android/webkit/WebSettings$LayoutAlgorithm.class */
    public enum LayoutAlgorithm {
        NORMAL,
        SINGLE_COLUMN,
        NARROW_COLUMNS,
        TEXT_AUTOSIZING
    }

    /* loaded from: source-4181928-dex2jar.jar:android/webkit/WebSettings$PluginState.class */
    public enum PluginState {
        ON,
        ON_DEMAND,
        OFF
    }

    /* loaded from: source-4181928-dex2jar.jar:android/webkit/WebSettings$RenderPriority.class */
    public enum RenderPriority {
        NORMAL,
        HIGH,
        LOW
    }

    /* loaded from: source-4181928-dex2jar.jar:android/webkit/WebSettings$TextSize.class */
    public enum TextSize {
        SMALLEST(50),
        SMALLER(75),
        NORMAL(100),
        LARGER(150),
        LARGEST(200);
        
        int value;

        TextSize(int i) {
            this.value = i;
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:android/webkit/WebSettings$ZoomDensity.class */
    public enum ZoomDensity {
        FAR(150),
        MEDIUM(100),
        CLOSE(75);
        
        int value;

        ZoomDensity(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }
    }

    public static String getDefaultUserAgent(Context context) {
        return WebViewFactory.getProvider().getStatics().getDefaultUserAgent(context);
    }

    @Deprecated
    public abstract boolean enableSmoothTransition();

    public abstract boolean getAcceptThirdPartyCookies();

    public abstract boolean getAllowContentAccess();

    public abstract boolean getAllowFileAccess();

    public abstract boolean getAllowFileAccessFromFileURLs();

    public abstract boolean getAllowUniversalAccessFromFileURLs();

    public abstract boolean getBlockNetworkImage();

    public abstract boolean getBlockNetworkLoads();

    public abstract boolean getBuiltInZoomControls();

    public abstract int getCacheMode();

    public abstract String getCursiveFontFamily();

    public abstract boolean getDatabaseEnabled();

    @Deprecated
    public abstract String getDatabasePath();

    public abstract int getDefaultFixedFontSize();

    public abstract int getDefaultFontSize();

    public abstract String getDefaultTextEncodingName();

    public abstract ZoomDensity getDefaultZoom();

    public abstract boolean getDisplayZoomControls();

    public abstract boolean getDomStorageEnabled();

    public abstract String getFantasyFontFamily();

    public abstract String getFixedFontFamily();

    public abstract boolean getJavaScriptCanOpenWindowsAutomatically();

    public abstract boolean getJavaScriptEnabled();

    public abstract LayoutAlgorithm getLayoutAlgorithm();

    @Deprecated
    public abstract boolean getLightTouchEnabled();

    public abstract boolean getLoadWithOverviewMode();

    public abstract boolean getLoadsImagesAutomatically();

    public abstract boolean getMediaPlaybackRequiresUserGesture();

    public abstract int getMinimumFontSize();

    public abstract int getMinimumLogicalFontSize();

    public abstract int getMixedContentMode();

    @Deprecated
    public abstract boolean getNavDump();

    @Deprecated
    public abstract PluginState getPluginState();

    @Deprecated
    public abstract boolean getPluginsEnabled();

    @Deprecated
    public String getPluginsPath() {
        return "";
    }

    public abstract String getSansSerifFontFamily();

    public abstract boolean getSaveFormData();

    @Deprecated
    public abstract boolean getSavePassword();

    public abstract String getSerifFontFamily();

    public abstract String getStandardFontFamily();

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0057, code lost:
        if (r10 == null) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x005a, code lost:
        r11 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0061, code lost:
        r10 = android.webkit.WebSettings.TextSize.NORMAL;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.webkit.WebSettings.TextSize getTextSize() {
        /*
            r3 = this;
            r0 = r3
            monitor-enter(r0)
            r0 = 0
            r10 = r0
            r0 = 2147483647(0x7fffffff, float:NaN)
            r5 = r0
            r0 = r3
            int r0 = r0.getTextZoom()     // Catch: java.lang.Throwable -> L69
            r8 = r0
            android.webkit.WebSettings$TextSize[] r0 = android.webkit.WebSettings.TextSize.values()     // Catch: java.lang.Throwable -> L69
            r12 = r0
            r0 = r12
            int r0 = r0.length     // Catch: java.lang.Throwable -> L69
            r9 = r0
            r0 = 0
            r4 = r0
        L1a:
            r0 = r4
            r1 = r9
            if (r0 >= r1) goto L55
            r0 = r12
            r1 = r4
            r0 = r0[r1]
            r11 = r0
            r0 = r8
            r1 = r11
            int r1 = r1.value     // Catch: java.lang.Throwable -> L69
            int r0 = r0 - r1
            int r0 = java.lang.Math.abs(r0)     // Catch: java.lang.Throwable -> L69
            r7 = r0
            r0 = r7
            if (r0 != 0) goto L3d
        L38:
            r0 = r3
            monitor-exit(r0)
            r0 = r11
            return r0
        L3d:
            r0 = r5
            r6 = r0
            r0 = r7
            r1 = r5
            if (r0 >= r1) goto L4c
            r0 = r7
            r6 = r0
            r0 = r11
            r10 = r0
        L4c:
            r0 = r4
            r1 = 1
            int r0 = r0 + r1
            r4 = r0
            r0 = r6
            r5 = r0
            goto L1a
        L55:
            r0 = r10
            if (r0 == 0) goto L61
        L5a:
            r0 = r10
            r11 = r0
            goto L38
        L61:
            android.webkit.WebSettings$TextSize r0 = android.webkit.WebSettings.TextSize.NORMAL     // Catch: java.lang.Throwable -> L69
            r10 = r0
            goto L5a
        L69:
            r10 = move-exception
            r0 = r3
            monitor-exit(r0)
            r0 = r10
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.webkit.WebSettings.getTextSize():android.webkit.WebSettings$TextSize");
    }

    public abstract int getTextZoom();

    @Deprecated
    public boolean getUseDoubleTree() {
        return false;
    }

    @Deprecated
    public abstract boolean getUseWebViewBackgroundForOverscrollBackground();

    public abstract boolean getUseWideViewPort();

    @Deprecated
    public abstract int getUserAgent();

    public abstract String getUserAgentString();

    public abstract boolean getVideoOverlayForEmbeddedEncryptedVideoEnabled();

    public abstract void setAcceptThirdPartyCookies(boolean z);

    public abstract void setAllowContentAccess(boolean z);

    public abstract void setAllowFileAccess(boolean z);

    public abstract void setAllowFileAccessFromFileURLs(boolean z);

    public abstract void setAllowUniversalAccessFromFileURLs(boolean z);

    public abstract void setAppCacheEnabled(boolean z);

    @Deprecated
    public abstract void setAppCacheMaxSize(long j);

    public abstract void setAppCachePath(String str);

    public abstract void setBlockNetworkImage(boolean z);

    public abstract void setBlockNetworkLoads(boolean z);

    public abstract void setBuiltInZoomControls(boolean z);

    public abstract void setCacheMode(int i);

    public abstract void setCursiveFontFamily(String str);

    public abstract void setDatabaseEnabled(boolean z);

    @Deprecated
    public abstract void setDatabasePath(String str);

    public abstract void setDefaultFixedFontSize(int i);

    public abstract void setDefaultFontSize(int i);

    public abstract void setDefaultTextEncodingName(String str);

    @Deprecated
    public abstract void setDefaultZoom(ZoomDensity zoomDensity);

    public abstract void setDisplayZoomControls(boolean z);

    public abstract void setDomStorageEnabled(boolean z);

    @Deprecated
    public abstract void setEnableSmoothTransition(boolean z);

    public abstract void setFantasyFontFamily(String str);

    public abstract void setFixedFontFamily(String str);

    public abstract void setGeolocationDatabasePath(String str);

    public abstract void setGeolocationEnabled(boolean z);

    public abstract void setJavaScriptCanOpenWindowsAutomatically(boolean z);

    public abstract void setJavaScriptEnabled(boolean z);

    public abstract void setLayoutAlgorithm(LayoutAlgorithm layoutAlgorithm);

    @Deprecated
    public abstract void setLightTouchEnabled(boolean z);

    public abstract void setLoadWithOverviewMode(boolean z);

    public abstract void setLoadsImagesAutomatically(boolean z);

    public abstract void setMediaPlaybackRequiresUserGesture(boolean z);

    public abstract void setMinimumFontSize(int i);

    public abstract void setMinimumLogicalFontSize(int i);

    public abstract void setMixedContentMode(int i);

    @Deprecated
    public abstract void setNavDump(boolean z);

    public abstract void setNeedInitialFocus(boolean z);

    @Deprecated
    public abstract void setPluginState(PluginState pluginState);

    @Deprecated
    public abstract void setPluginsEnabled(boolean z);

    @Deprecated
    public void setPluginsPath(String str) {
    }

    @Deprecated
    public abstract void setRenderPriority(RenderPriority renderPriority);

    public abstract void setSansSerifFontFamily(String str);

    public abstract void setSaveFormData(boolean z);

    @Deprecated
    public abstract void setSavePassword(boolean z);

    public abstract void setSerifFontFamily(String str);

    public abstract void setStandardFontFamily(String str);

    public abstract void setSupportMultipleWindows(boolean z);

    public abstract void setSupportZoom(boolean z);

    public void setTextSize(TextSize textSize) {
        synchronized (this) {
            setTextZoom(textSize.value);
        }
    }

    public abstract void setTextZoom(int i);

    @Deprecated
    public void setUseDoubleTree(boolean z) {
    }

    @Deprecated
    public abstract void setUseWebViewBackgroundForOverscrollBackground(boolean z);

    public abstract void setUseWideViewPort(boolean z);

    @Deprecated
    public abstract void setUserAgent(int i);

    public abstract void setUserAgentString(String str);

    public abstract void setVideoOverlayForEmbeddedEncryptedVideoEnabled(boolean z);

    public abstract boolean supportMultipleWindows();

    public abstract boolean supportZoom();
}
