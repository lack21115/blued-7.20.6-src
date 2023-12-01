package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Build;
import android.webkit.WebSettings;
import com.tencent.smtt.export.external.interfaces.IX5WebSettings;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/sdk/WebSettings.class */
public class WebSettings {
    public static final int LOAD_CACHE_ELSE_NETWORK = 1;
    public static final int LOAD_CACHE_ONLY = 3;
    public static final int LOAD_DEFAULT = -1;
    public static final int LOAD_NORMAL = 0;
    public static final int LOAD_NO_CACHE = 2;

    /* renamed from: a  reason: collision with root package name */
    private IX5WebSettings f38801a;
    private android.webkit.WebSettings b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f38802c;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/sdk/WebSettings$LayoutAlgorithm.class */
    public enum LayoutAlgorithm {
        NORMAL,
        SINGLE_COLUMN,
        NARROW_COLUMNS
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/sdk/WebSettings$PluginState.class */
    public enum PluginState {
        ON,
        ON_DEMAND,
        OFF
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/sdk/WebSettings$RenderPriority.class */
    public enum RenderPriority {
        NORMAL,
        HIGH,
        LOW
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/sdk/WebSettings$TextSize.class */
    public enum TextSize {
        SMALLEST(50),
        SMALLER(75),
        NORMAL(100),
        LARGER(125),
        LARGEST(150);
        
        int value;

        TextSize(int i) {
            this.value = i;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/sdk/WebSettings$ZoomDensity.class */
    public enum ZoomDensity {
        FAR(150),
        MEDIUM(100),
        CLOSE(75);
        
        int value;

        ZoomDensity(int i) {
            this.value = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public WebSettings(android.webkit.WebSettings webSettings) {
        this.f38801a = null;
        this.b = null;
        this.f38802c = false;
        this.f38801a = null;
        this.b = webSettings;
        this.f38802c = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public WebSettings(IX5WebSettings iX5WebSettings) {
        this.f38801a = null;
        this.b = null;
        this.f38802c = false;
        this.f38801a = iX5WebSettings;
        this.b = null;
        this.f38802c = true;
    }

    public static String getDefaultUserAgent(Context context) {
        Object a2;
        if (w.a().b()) {
            return w.a().c().i(context);
        }
        if (Build.VERSION.SDK_INT >= 17 && (a2 = com.tencent.smtt.utils.i.a((Class<?>) android.webkit.WebSettings.class, "getDefaultUserAgent", (Class<?>[]) new Class[]{Context.class}, context)) != null) {
            return (String) a2;
        }
        return null;
    }

    @Deprecated
    public boolean enableSmoothTransition() {
        IX5WebSettings iX5WebSettings;
        if (!this.f38802c || (iX5WebSettings = this.f38801a) == null) {
            boolean z = false;
            if (!this.f38802c) {
                z = false;
                if (this.b != null) {
                    z = false;
                    if (Build.VERSION.SDK_INT >= 11) {
                        Object a2 = com.tencent.smtt.utils.i.a(this.b, "enableSmoothTransition");
                        if (a2 == null) {
                            return false;
                        }
                        z = ((Boolean) a2).booleanValue();
                    }
                }
            }
            return z;
        }
        return iX5WebSettings.enableSmoothTransition();
    }

    public boolean getAllowContentAccess() {
        IX5WebSettings iX5WebSettings;
        if (!this.f38802c || (iX5WebSettings = this.f38801a) == null) {
            boolean z = false;
            if (!this.f38802c) {
                z = false;
                if (this.b != null) {
                    z = false;
                    if (Build.VERSION.SDK_INT >= 11) {
                        Object a2 = com.tencent.smtt.utils.i.a(this.b, "getAllowContentAccess");
                        if (a2 == null) {
                            return false;
                        }
                        z = ((Boolean) a2).booleanValue();
                    }
                }
            }
            return z;
        }
        return iX5WebSettings.getAllowContentAccess();
    }

    public boolean getAllowFileAccess() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (!this.f38802c || (iX5WebSettings = this.f38801a) == null) {
            if (this.f38802c || (webSettings = this.b) == null) {
                return false;
            }
            return webSettings.getAllowFileAccess();
        }
        return iX5WebSettings.getAllowFileAccess();
    }

    public boolean getBlockNetworkImage() {
        synchronized (this) {
            if (this.f38802c && this.f38801a != null) {
                return this.f38801a.getBlockNetworkImage();
            } else if (this.f38802c || this.b == null) {
                return false;
            } else {
                return this.b.getBlockNetworkImage();
            }
        }
    }

    public boolean getBlockNetworkLoads() {
        synchronized (this) {
            if (this.f38802c && this.f38801a != null) {
                return this.f38801a.getBlockNetworkLoads();
            } else if (this.f38802c || this.b == null) {
                return false;
            } else {
                if (Build.VERSION.SDK_INT >= 8) {
                    return this.b.getBlockNetworkLoads();
                }
                return false;
            }
        }
    }

    public boolean getBuiltInZoomControls() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (!this.f38802c || (iX5WebSettings = this.f38801a) == null) {
            if (this.f38802c || (webSettings = this.b) == null) {
                return false;
            }
            return webSettings.getBuiltInZoomControls();
        }
        return iX5WebSettings.getBuiltInZoomControls();
    }

    public int getCacheMode() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (!this.f38802c || (iX5WebSettings = this.f38801a) == null) {
            if (this.f38802c || (webSettings = this.b) == null) {
                return 0;
            }
            return webSettings.getCacheMode();
        }
        return iX5WebSettings.getCacheMode();
    }

    public String getCursiveFontFamily() {
        synchronized (this) {
            if (this.f38802c && this.f38801a != null) {
                return this.f38801a.getCursiveFontFamily();
            } else if (this.f38802c || this.b == null) {
                return "";
            } else {
                return this.b.getCursiveFontFamily();
            }
        }
    }

    public boolean getDatabaseEnabled() {
        synchronized (this) {
            if (this.f38802c && this.f38801a != null) {
                return this.f38801a.getDatabaseEnabled();
            } else if (this.f38802c || this.b == null) {
                return false;
            } else {
                return this.b.getDatabaseEnabled();
            }
        }
    }

    @Deprecated
    public String getDatabasePath() {
        synchronized (this) {
            if (this.f38802c && this.f38801a != null) {
                return this.f38801a.getDatabasePath();
            } else if (this.f38802c || this.b == null) {
                return "";
            } else {
                return this.b.getDatabasePath();
            }
        }
    }

    public int getDefaultFixedFontSize() {
        synchronized (this) {
            if (this.f38802c && this.f38801a != null) {
                return this.f38801a.getDefaultFixedFontSize();
            } else if (this.f38802c || this.b == null) {
                return 0;
            } else {
                return this.b.getDefaultFixedFontSize();
            }
        }
    }

    public int getDefaultFontSize() {
        synchronized (this) {
            if (this.f38802c && this.f38801a != null) {
                return this.f38801a.getDefaultFontSize();
            } else if (this.f38802c || this.b == null) {
                return 0;
            } else {
                return this.b.getDefaultFontSize();
            }
        }
    }

    public String getDefaultTextEncodingName() {
        synchronized (this) {
            if (this.f38802c && this.f38801a != null) {
                return this.f38801a.getDefaultTextEncodingName();
            } else if (this.f38802c || this.b == null) {
                return "";
            } else {
                return this.b.getDefaultTextEncodingName();
            }
        }
    }

    @Deprecated
    public ZoomDensity getDefaultZoom() {
        android.webkit.WebSettings webSettings;
        String name;
        IX5WebSettings iX5WebSettings;
        if (this.f38802c && (iX5WebSettings = this.f38801a) != null) {
            name = iX5WebSettings.getDefaultZoom().name();
        } else if (this.f38802c || (webSettings = this.b) == null) {
            return null;
        } else {
            name = webSettings.getDefaultZoom().name();
        }
        return ZoomDensity.valueOf(name);
    }

    public boolean getDisplayZoomControls() {
        IX5WebSettings iX5WebSettings;
        if (!this.f38802c || (iX5WebSettings = this.f38801a) == null) {
            boolean z = false;
            if (!this.f38802c) {
                z = false;
                if (this.b != null) {
                    z = false;
                    if (Build.VERSION.SDK_INT >= 11) {
                        Object a2 = com.tencent.smtt.utils.i.a(this.b, "getDisplayZoomControls");
                        if (a2 == null) {
                            return false;
                        }
                        z = ((Boolean) a2).booleanValue();
                    }
                }
            }
            return z;
        }
        return iX5WebSettings.getDisplayZoomControls();
    }

    public boolean getDomStorageEnabled() {
        synchronized (this) {
            if (this.f38802c && this.f38801a != null) {
                return this.f38801a.getDomStorageEnabled();
            } else if (this.f38802c || this.b == null) {
                return false;
            } else {
                return this.b.getDomStorageEnabled();
            }
        }
    }

    public String getFantasyFontFamily() {
        synchronized (this) {
            if (this.f38802c && this.f38801a != null) {
                return this.f38801a.getFantasyFontFamily();
            } else if (this.f38802c || this.b == null) {
                return "";
            } else {
                return this.b.getFantasyFontFamily();
            }
        }
    }

    public String getFixedFontFamily() {
        synchronized (this) {
            if (this.f38802c && this.f38801a != null) {
                return this.f38801a.getFixedFontFamily();
            } else if (this.f38802c || this.b == null) {
                return "";
            } else {
                return this.b.getFixedFontFamily();
            }
        }
    }

    public boolean getJavaScriptCanOpenWindowsAutomatically() {
        synchronized (this) {
            if (this.f38802c && this.f38801a != null) {
                return this.f38801a.getJavaScriptCanOpenWindowsAutomatically();
            } else if (this.f38802c || this.b == null) {
                return false;
            } else {
                return this.b.getJavaScriptCanOpenWindowsAutomatically();
            }
        }
    }

    public boolean getJavaScriptEnabled() {
        synchronized (this) {
            if (this.f38802c && this.f38801a != null) {
                return this.f38801a.getJavaScriptEnabled();
            } else if (this.f38802c || this.b == null) {
                return false;
            } else {
                return this.b.getJavaScriptEnabled();
            }
        }
    }

    public LayoutAlgorithm getLayoutAlgorithm() {
        synchronized (this) {
            if (this.f38802c && this.f38801a != null) {
                return LayoutAlgorithm.valueOf(this.f38801a.getLayoutAlgorithm().name());
            } else if (this.f38802c || this.b == null) {
                return null;
            } else {
                return LayoutAlgorithm.valueOf(this.b.getLayoutAlgorithm().name());
            }
        }
    }

    @Deprecated
    public boolean getLightTouchEnabled() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (!this.f38802c || (iX5WebSettings = this.f38801a) == null) {
            if (this.f38802c || (webSettings = this.b) == null) {
                return false;
            }
            return webSettings.getLightTouchEnabled();
        }
        return iX5WebSettings.getLightTouchEnabled();
    }

    public boolean getLoadWithOverviewMode() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (!this.f38802c || (iX5WebSettings = this.f38801a) == null) {
            if (this.f38802c || (webSettings = this.b) == null) {
                return false;
            }
            return webSettings.getLoadWithOverviewMode();
        }
        return iX5WebSettings.getLoadWithOverviewMode();
    }

    public boolean getLoadsImagesAutomatically() {
        synchronized (this) {
            if (this.f38802c && this.f38801a != null) {
                return this.f38801a.getLoadsImagesAutomatically();
            } else if (this.f38802c || this.b == null) {
                return false;
            } else {
                return this.b.getLoadsImagesAutomatically();
            }
        }
    }

    public boolean getMediaPlaybackRequiresUserGesture() {
        Object a2;
        IX5WebSettings iX5WebSettings;
        if (!this.f38802c || (iX5WebSettings = this.f38801a) == null) {
            boolean z = false;
            if (!this.f38802c) {
                z = false;
                if (this.b != null) {
                    if (Build.VERSION.SDK_INT < 17 || (a2 = com.tencent.smtt.utils.i.a(this.b, "getMediaPlaybackRequiresUserGesture")) == null) {
                        return false;
                    }
                    z = ((Boolean) a2).booleanValue();
                }
            }
            return z;
        }
        return iX5WebSettings.getMediaPlaybackRequiresUserGesture();
    }

    public int getMinimumFontSize() {
        synchronized (this) {
            if (this.f38802c && this.f38801a != null) {
                return this.f38801a.getMinimumFontSize();
            } else if (this.f38802c || this.b == null) {
                return 0;
            } else {
                return this.b.getMinimumFontSize();
            }
        }
    }

    public int getMinimumLogicalFontSize() {
        synchronized (this) {
            if (this.f38802c && this.f38801a != null) {
                return this.f38801a.getMinimumLogicalFontSize();
            } else if (this.f38802c || this.b == null) {
                return 0;
            } else {
                return this.b.getMinimumLogicalFontSize();
            }
        }
    }

    public int getMixedContentMode() {
        synchronized (this) {
            int i = -1;
            if (this.f38802c && this.f38801a != null) {
                return this.f38801a.getMixedContentMode();
            } else if (Build.VERSION.SDK_INT < 21) {
                return -1;
            } else {
                Object a2 = com.tencent.smtt.utils.i.a(this.b, "getMixedContentMode", new Class[0], new Object[0]);
                if (a2 != null) {
                    i = ((Integer) a2).intValue();
                }
                return i;
            }
        }
    }

    @Deprecated
    public boolean getNavDump() {
        IX5WebSettings iX5WebSettings;
        if (!this.f38802c || (iX5WebSettings = this.f38801a) == null) {
            boolean z = false;
            if (!this.f38802c) {
                android.webkit.WebSettings webSettings = this.b;
                z = false;
                if (webSettings != null) {
                    Object a2 = com.tencent.smtt.utils.i.a(webSettings, "getNavDump");
                    if (a2 == null) {
                        return false;
                    }
                    z = ((Boolean) a2).booleanValue();
                }
            }
            return z;
        }
        return iX5WebSettings.getNavDump();
    }

    @Deprecated
    public PluginState getPluginState() {
        synchronized (this) {
            if (this.f38802c && this.f38801a != null) {
                return PluginState.valueOf(this.f38801a.getPluginState().name());
            } else if (this.f38802c || this.b == null) {
                return null;
            } else {
                if (Build.VERSION.SDK_INT >= 8) {
                    Object a2 = com.tencent.smtt.utils.i.a(this.b, "getPluginState");
                    if (a2 == null) {
                        return null;
                    }
                    return PluginState.valueOf(((WebSettings.PluginState) a2).name());
                }
                return null;
            }
        }
    }

    @Deprecated
    public boolean getPluginsEnabled() {
        synchronized (this) {
            if (this.f38802c && this.f38801a != null) {
                return this.f38801a.getPluginsEnabled();
            }
            boolean z = false;
            if (this.f38802c || this.b == null) {
                return false;
            }
            if (Build.VERSION.SDK_INT <= 17) {
                Object a2 = com.tencent.smtt.utils.i.a(this.b, "getPluginsEnabled");
                if (a2 != null) {
                    z = ((Boolean) a2).booleanValue();
                }
                return z;
            } else if (Build.VERSION.SDK_INT == 18) {
                boolean z2 = false;
                if (WebSettings.PluginState.ON == this.b.getPluginState()) {
                    z2 = true;
                }
                return z2;
            } else {
                return false;
            }
        }
    }

    @Deprecated
    public String getPluginsPath() {
        synchronized (this) {
            if (this.f38802c && this.f38801a != null) {
                return this.f38801a.getPluginsPath();
            } else if (this.f38802c || this.b == null) {
                return "";
            } else {
                if (Build.VERSION.SDK_INT <= 17) {
                    Object a2 = com.tencent.smtt.utils.i.a(this.b, "getPluginsPath");
                    return a2 == null ? null : (String) a2;
                }
                return "";
            }
        }
    }

    public boolean getSafeBrowsingEnabled() {
        IX5WebSettings iX5WebSettings;
        if (!this.f38802c && this.b != null) {
            if (Build.VERSION.SDK_INT >= 26) {
                return this.b.getSafeBrowsingEnabled();
            }
            return false;
        } else if (!this.f38802c || (iX5WebSettings = this.f38801a) == null) {
            return false;
        } else {
            try {
                return iX5WebSettings.getSafeBrowsingEnabled();
            } catch (Throwable th) {
                th.printStackTrace();
                return false;
            }
        }
    }

    public String getSansSerifFontFamily() {
        synchronized (this) {
            if (this.f38802c && this.f38801a != null) {
                return this.f38801a.getSansSerifFontFamily();
            } else if (this.f38802c || this.b == null) {
                return "";
            } else {
                return this.b.getSansSerifFontFamily();
            }
        }
    }

    @Deprecated
    public boolean getSaveFormData() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (!this.f38802c || (iX5WebSettings = this.f38801a) == null) {
            if (this.f38802c || (webSettings = this.b) == null) {
                return false;
            }
            return webSettings.getSaveFormData();
        }
        return iX5WebSettings.getSaveFormData();
    }

    @Deprecated
    public boolean getSavePassword() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (!this.f38802c || (iX5WebSettings = this.f38801a) == null) {
            if (this.f38802c || (webSettings = this.b) == null) {
                return false;
            }
            return webSettings.getSavePassword();
        }
        return iX5WebSettings.getSavePassword();
    }

    public String getSerifFontFamily() {
        synchronized (this) {
            if (this.f38802c && this.f38801a != null) {
                return this.f38801a.getSerifFontFamily();
            } else if (this.f38802c || this.b == null) {
                return "";
            } else {
                return this.b.getSerifFontFamily();
            }
        }
    }

    public String getStandardFontFamily() {
        synchronized (this) {
            if (this.f38802c && this.f38801a != null) {
                return this.f38801a.getStandardFontFamily();
            } else if (this.f38802c || this.b == null) {
                return "";
            } else {
                return this.b.getStandardFontFamily();
            }
        }
    }

    @Deprecated
    public TextSize getTextSize() {
        android.webkit.WebSettings webSettings;
        String name;
        IX5WebSettings iX5WebSettings;
        if (this.f38802c && (iX5WebSettings = this.f38801a) != null) {
            name = iX5WebSettings.getTextSize().name();
        } else if (this.f38802c || (webSettings = this.b) == null) {
            return null;
        } else {
            name = webSettings.getTextSize().name();
        }
        return TextSize.valueOf(name);
    }

    public int getTextZoom() {
        synchronized (this) {
            if (this.f38802c && this.f38801a != null) {
                return this.f38801a.getTextZoom();
            }
            int i = 0;
            if (this.f38802c || this.b == null) {
                return 0;
            }
            if (Build.VERSION.SDK_INT < 14) {
                return 0;
            }
            try {
                return this.b.getTextZoom();
            } catch (Exception e) {
                Object a2 = com.tencent.smtt.utils.i.a(this.b, "getTextZoom");
                if (a2 != null) {
                    i = ((Integer) a2).intValue();
                }
                return i;
            }
        }
    }

    @Deprecated
    public boolean getUseWebViewBackgroundForOverscrollBackground() {
        IX5WebSettings iX5WebSettings;
        if (!this.f38802c || (iX5WebSettings = this.f38801a) == null) {
            boolean z = false;
            if (!this.f38802c) {
                android.webkit.WebSettings webSettings = this.b;
                z = false;
                if (webSettings != null) {
                    Object a2 = com.tencent.smtt.utils.i.a(webSettings, "getUseWebViewBackgroundForOverscrollBackground");
                    if (a2 == null) {
                        return false;
                    }
                    z = ((Boolean) a2).booleanValue();
                }
            }
            return z;
        }
        return iX5WebSettings.getUseWebViewBackgroundForOverscrollBackground();
    }

    public boolean getUseWideViewPort() {
        synchronized (this) {
            if (this.f38802c && this.f38801a != null) {
                return this.f38801a.getUseWideViewPort();
            } else if (this.f38802c || this.b == null) {
                return false;
            } else {
                return this.b.getUseWideViewPort();
            }
        }
    }

    public String getUserAgentString() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        return (!this.f38802c || (iX5WebSettings = this.f38801a) == null) ? (this.f38802c || (webSettings = this.b) == null) ? "" : webSettings.getUserAgentString() : iX5WebSettings.getUserAgentString();
    }

    public void setAllowContentAccess(boolean z) {
        IX5WebSettings iX5WebSettings;
        if (this.f38802c && (iX5WebSettings = this.f38801a) != null) {
            iX5WebSettings.setAllowContentAccess(z);
        } else if (this.f38802c || this.b == null || Build.VERSION.SDK_INT < 11) {
        } else {
            com.tencent.smtt.utils.i.a(this.b, "setAllowContentAccess", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
        }
    }

    public void setAllowFileAccess(boolean z) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.f38802c && (iX5WebSettings = this.f38801a) != null) {
            iX5WebSettings.setAllowFileAccess(z);
        } else if (this.f38802c || (webSettings = this.b) == null) {
        } else {
            webSettings.setAllowFileAccess(z);
        }
    }

    public void setAllowFileAccessFromFileURLs(boolean z) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.f38802c && (iX5WebSettings = this.f38801a) != null) {
            iX5WebSettings.setAllowFileAccessFromFileURLs(z);
        } else if (this.f38802c || (webSettings = this.b) == null) {
        } else {
            com.tencent.smtt.utils.i.a(webSettings, "setAllowFileAccessFromFileURLs", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
        }
    }

    public void setAllowUniversalAccessFromFileURLs(boolean z) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.f38802c && (iX5WebSettings = this.f38801a) != null) {
            iX5WebSettings.setAllowUniversalAccessFromFileURLs(z);
        } else if (this.f38802c || (webSettings = this.b) == null) {
        } else {
            com.tencent.smtt.utils.i.a(webSettings, "setAllowUniversalAccessFromFileURLs", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
        }
    }

    public void setAppCacheEnabled(boolean z) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.f38802c && (iX5WebSettings = this.f38801a) != null) {
            iX5WebSettings.setAppCacheEnabled(z);
        } else if (this.f38802c || (webSettings = this.b) == null) {
        } else {
            webSettings.setAppCacheEnabled(z);
        }
    }

    @Deprecated
    public void setAppCacheMaxSize(long j) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.f38802c && (iX5WebSettings = this.f38801a) != null) {
            iX5WebSettings.setAppCacheMaxSize(j);
        } else if (this.f38802c || (webSettings = this.b) == null) {
        } else {
            webSettings.setAppCacheMaxSize(j);
        }
    }

    public void setAppCachePath(String str) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.f38802c && (iX5WebSettings = this.f38801a) != null) {
            iX5WebSettings.setAppCachePath(str);
        } else if (this.f38802c || (webSettings = this.b) == null) {
        } else {
            webSettings.setAppCachePath(str);
        }
    }

    public void setBlockNetworkImage(boolean z) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.f38802c && (iX5WebSettings = this.f38801a) != null) {
            iX5WebSettings.setBlockNetworkImage(z);
        } else if (this.f38802c || (webSettings = this.b) == null) {
        } else {
            webSettings.setBlockNetworkImage(z);
        }
    }

    public void setBlockNetworkLoads(boolean z) {
        synchronized (this) {
            if (this.f38802c && this.f38801a != null) {
                this.f38801a.setBlockNetworkLoads(z);
            } else if (this.f38802c || this.b == null) {
            } else {
                if (Build.VERSION.SDK_INT >= 8) {
                    this.b.setBlockNetworkLoads(z);
                }
            }
        }
    }

    public void setBuiltInZoomControls(boolean z) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.f38802c && (iX5WebSettings = this.f38801a) != null) {
            iX5WebSettings.setBuiltInZoomControls(z);
        } else if (this.f38802c || (webSettings = this.b) == null) {
        } else {
            webSettings.setBuiltInZoomControls(z);
        }
    }

    public void setCacheMode(int i) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.f38802c && (iX5WebSettings = this.f38801a) != null) {
            iX5WebSettings.setCacheMode(i);
        } else if (this.f38802c || (webSettings = this.b) == null) {
        } else {
            webSettings.setCacheMode(i);
        }
    }

    public void setCursiveFontFamily(String str) {
        synchronized (this) {
            if (this.f38802c && this.f38801a != null) {
                this.f38801a.setCursiveFontFamily(str);
            } else if (this.f38802c || this.b == null) {
            } else {
                this.b.setCursiveFontFamily(str);
            }
        }
    }

    public void setDatabaseEnabled(boolean z) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.f38802c && (iX5WebSettings = this.f38801a) != null) {
            iX5WebSettings.setDatabaseEnabled(z);
        } else if (this.f38802c || (webSettings = this.b) == null) {
        } else {
            webSettings.setDatabaseEnabled(z);
        }
    }

    @Deprecated
    public void setDatabasePath(String str) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.f38802c && (iX5WebSettings = this.f38801a) != null) {
            iX5WebSettings.setDatabasePath(str);
        } else if (this.f38802c || (webSettings = this.b) == null) {
        } else {
            com.tencent.smtt.utils.i.a(webSettings, "setDatabasePath", new Class[]{String.class}, str);
        }
    }

    public void setDefaultFixedFontSize(int i) {
        synchronized (this) {
            if (this.f38802c && this.f38801a != null) {
                this.f38801a.setDefaultFixedFontSize(i);
            } else if (this.f38802c || this.b == null) {
            } else {
                this.b.setDefaultFixedFontSize(i);
            }
        }
    }

    public void setDefaultFontSize(int i) {
        synchronized (this) {
            if (this.f38802c && this.f38801a != null) {
                this.f38801a.setDefaultFontSize(i);
            } else if (this.f38802c || this.b == null) {
            } else {
                this.b.setDefaultFontSize(i);
            }
        }
    }

    public void setDefaultTextEncodingName(String str) {
        synchronized (this) {
            if (this.f38802c && this.f38801a != null) {
                this.f38801a.setDefaultTextEncodingName(str);
            } else if (this.f38802c || this.b == null) {
            } else {
                this.b.setDefaultTextEncodingName(str);
            }
        }
    }

    @Deprecated
    public void setDefaultZoom(ZoomDensity zoomDensity) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.f38802c && (iX5WebSettings = this.f38801a) != null) {
            iX5WebSettings.setDefaultZoom(IX5WebSettings.ZoomDensity.valueOf(zoomDensity.name()));
        } else if (this.f38802c || (webSettings = this.b) == null) {
        } else {
            webSettings.setDefaultZoom(WebSettings.ZoomDensity.valueOf(zoomDensity.name()));
        }
    }

    public void setDisplayZoomControls(boolean z) {
        IX5WebSettings iX5WebSettings;
        if (this.f38802c && (iX5WebSettings = this.f38801a) != null) {
            iX5WebSettings.setDisplayZoomControls(z);
        } else if (this.f38802c || this.b == null || Build.VERSION.SDK_INT < 11) {
        } else {
            com.tencent.smtt.utils.i.a(this.b, "setDisplayZoomControls", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
        }
    }

    public void setDomStorageEnabled(boolean z) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.f38802c && (iX5WebSettings = this.f38801a) != null) {
            iX5WebSettings.setDomStorageEnabled(z);
        } else if (this.f38802c || (webSettings = this.b) == null) {
        } else {
            webSettings.setDomStorageEnabled(z);
        }
    }

    @Deprecated
    public void setEnableSmoothTransition(boolean z) {
        IX5WebSettings iX5WebSettings;
        if (this.f38802c && (iX5WebSettings = this.f38801a) != null) {
            iX5WebSettings.setEnableSmoothTransition(z);
        } else if (this.f38802c || this.b == null || Build.VERSION.SDK_INT < 11) {
        } else {
            com.tencent.smtt.utils.i.a(this.b, "setEnableSmoothTransition", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
        }
    }

    public void setFantasyFontFamily(String str) {
        synchronized (this) {
            if (this.f38802c && this.f38801a != null) {
                this.f38801a.setFantasyFontFamily(str);
            } else if (this.f38802c || this.b == null) {
            } else {
                this.b.setFantasyFontFamily(str);
            }
        }
    }

    public void setFixedFontFamily(String str) {
        synchronized (this) {
            if (this.f38802c && this.f38801a != null) {
                this.f38801a.setFixedFontFamily(str);
            } else if (this.f38802c || this.b == null) {
            } else {
                this.b.setFixedFontFamily(str);
            }
        }
    }

    @Deprecated
    public void setGeolocationDatabasePath(String str) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.f38802c && (iX5WebSettings = this.f38801a) != null) {
            iX5WebSettings.setGeolocationDatabasePath(str);
        } else if (this.f38802c || (webSettings = this.b) == null) {
        } else {
            webSettings.setGeolocationDatabasePath(str);
        }
    }

    public void setGeolocationEnabled(boolean z) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.f38802c && (iX5WebSettings = this.f38801a) != null) {
            iX5WebSettings.setGeolocationEnabled(z);
        } else if (this.f38802c || (webSettings = this.b) == null) {
        } else {
            webSettings.setGeolocationEnabled(z);
        }
    }

    public void setJavaScriptCanOpenWindowsAutomatically(boolean z) {
        synchronized (this) {
            if (this.f38802c && this.f38801a != null) {
                this.f38801a.setJavaScriptCanOpenWindowsAutomatically(z);
            } else if (this.f38802c || this.b == null) {
            } else {
                this.b.setJavaScriptCanOpenWindowsAutomatically(z);
            }
        }
    }

    @Deprecated
    public void setJavaScriptEnabled(boolean z) {
        try {
            if (this.f38802c && this.f38801a != null) {
                this.f38801a.setJavaScriptEnabled(z);
            } else if (this.f38802c || this.b == null) {
            } else {
                this.b.setJavaScriptEnabled(z);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setLayoutAlgorithm(LayoutAlgorithm layoutAlgorithm) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.f38802c && (iX5WebSettings = this.f38801a) != null) {
            iX5WebSettings.setLayoutAlgorithm(IX5WebSettings.LayoutAlgorithm.valueOf(layoutAlgorithm.name()));
        } else if (this.f38802c || (webSettings = this.b) == null) {
        } else {
            webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.valueOf(layoutAlgorithm.name()));
        }
    }

    @Deprecated
    public void setLightTouchEnabled(boolean z) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.f38802c && (iX5WebSettings = this.f38801a) != null) {
            iX5WebSettings.setLightTouchEnabled(z);
        } else if (this.f38802c || (webSettings = this.b) == null) {
        } else {
            webSettings.setLightTouchEnabled(z);
        }
    }

    public void setLoadWithOverviewMode(boolean z) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.f38802c && (iX5WebSettings = this.f38801a) != null) {
            iX5WebSettings.setLoadWithOverviewMode(z);
        } else if (this.f38802c || (webSettings = this.b) == null) {
        } else {
            webSettings.setLoadWithOverviewMode(z);
        }
    }

    public void setLoadsImagesAutomatically(boolean z) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.f38802c && (iX5WebSettings = this.f38801a) != null) {
            iX5WebSettings.setLoadsImagesAutomatically(z);
        } else if (this.f38802c || (webSettings = this.b) == null) {
        } else {
            webSettings.setLoadsImagesAutomatically(z);
        }
    }

    public void setMediaPlaybackRequiresUserGesture(boolean z) {
        IX5WebSettings iX5WebSettings;
        if (this.f38802c && (iX5WebSettings = this.f38801a) != null) {
            iX5WebSettings.setMediaPlaybackRequiresUserGesture(z);
        } else if (this.f38802c || this.b == null || Build.VERSION.SDK_INT < 17) {
        } else {
            com.tencent.smtt.utils.i.a(this.b, "setMediaPlaybackRequiresUserGesture", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
        }
    }

    public void setMinimumFontSize(int i) {
        synchronized (this) {
            if (this.f38802c && this.f38801a != null) {
                this.f38801a.setMinimumFontSize(i);
            } else if (this.f38802c || this.b == null) {
            } else {
                this.b.setMinimumFontSize(i);
            }
        }
    }

    public void setMinimumLogicalFontSize(int i) {
        synchronized (this) {
            if (this.f38802c && this.f38801a != null) {
                this.f38801a.setMinimumLogicalFontSize(i);
            } else if (this.f38802c || this.b == null) {
            } else {
                this.b.setMinimumLogicalFontSize(i);
            }
        }
    }

    public void setMixedContentMode(int i) {
        if ((!this.f38802c || this.f38801a == null) && !this.f38802c && this.b != null && Build.VERSION.SDK_INT >= 21) {
            com.tencent.smtt.utils.i.a(this.b, "setMixedContentMode", new Class[]{Integer.TYPE}, Integer.valueOf(i));
        }
    }

    @Deprecated
    public void setNavDump(boolean z) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.f38802c && (iX5WebSettings = this.f38801a) != null) {
            iX5WebSettings.setNavDump(z);
        } else if (this.f38802c || (webSettings = this.b) == null) {
        } else {
            com.tencent.smtt.utils.i.a(webSettings, "setNavDump", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
        }
    }

    public void setNeedInitialFocus(boolean z) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.f38802c && (iX5WebSettings = this.f38801a) != null) {
            iX5WebSettings.setNeedInitialFocus(z);
        } else if (this.f38802c || (webSettings = this.b) == null) {
        } else {
            webSettings.setNeedInitialFocus(z);
        }
    }

    @Deprecated
    public void setPluginState(PluginState pluginState) {
        synchronized (this) {
            if (this.f38802c && this.f38801a != null) {
                this.f38801a.setPluginState(IX5WebSettings.PluginState.valueOf(pluginState.name()));
            } else if (this.f38802c || this.b == null) {
            } else {
                if (Build.VERSION.SDK_INT >= 8) {
                    com.tencent.smtt.utils.i.a(this.b, "setPluginState", new Class[]{WebSettings.PluginState.class}, WebSettings.PluginState.valueOf(pluginState.name()));
                }
            }
        }
    }

    @Deprecated
    public void setPluginsEnabled(boolean z) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.f38802c && (iX5WebSettings = this.f38801a) != null) {
            iX5WebSettings.setPluginsEnabled(z);
        } else if (this.f38802c || (webSettings = this.b) == null) {
        } else {
            com.tencent.smtt.utils.i.a(webSettings, "setPluginsEnabled", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
        }
    }

    @Deprecated
    public void setPluginsPath(String str) {
        synchronized (this) {
            if (this.f38802c && this.f38801a != null) {
                this.f38801a.setPluginsPath(str);
            } else if (this.f38802c || this.b == null) {
            } else {
                com.tencent.smtt.utils.i.a(this.b, "setPluginsPath", new Class[]{String.class}, str);
            }
        }
    }

    @Deprecated
    public void setRenderPriority(RenderPriority renderPriority) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.f38802c && (iX5WebSettings = this.f38801a) != null) {
            iX5WebSettings.setRenderPriority(IX5WebSettings.RenderPriority.valueOf(renderPriority.name()));
        } else if (this.f38802c || (webSettings = this.b) == null) {
        } else {
            webSettings.setRenderPriority(WebSettings.RenderPriority.valueOf(renderPriority.name()));
        }
    }

    public void setSafeBrowsingEnabled(boolean z) {
        IX5WebSettings iX5WebSettings;
        if (!this.f38802c && this.b != null) {
            if (Build.VERSION.SDK_INT >= 26) {
                this.b.setSafeBrowsingEnabled(z);
            }
        } else if (!this.f38802c || (iX5WebSettings = this.f38801a) == null) {
        } else {
            try {
                iX5WebSettings.setSafeBrowsingEnabled(z);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void setSansSerifFontFamily(String str) {
        synchronized (this) {
            if (this.f38802c && this.f38801a != null) {
                this.f38801a.setSansSerifFontFamily(str);
            } else if (this.f38802c || this.b == null) {
            } else {
                this.b.setSansSerifFontFamily(str);
            }
        }
    }

    @Deprecated
    public void setSaveFormData(boolean z) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.f38802c && (iX5WebSettings = this.f38801a) != null) {
            iX5WebSettings.setSaveFormData(z);
        } else if (this.f38802c || (webSettings = this.b) == null) {
        } else {
            webSettings.setSaveFormData(z);
        }
    }

    @Deprecated
    public void setSavePassword(boolean z) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.f38802c && (iX5WebSettings = this.f38801a) != null) {
            iX5WebSettings.setSavePassword(z);
        } else if (this.f38802c || (webSettings = this.b) == null) {
        } else {
            webSettings.setSavePassword(z);
        }
    }

    public void setSerifFontFamily(String str) {
        synchronized (this) {
            if (this.f38802c && this.f38801a != null) {
                this.f38801a.setSerifFontFamily(str);
            } else if (this.f38802c || this.b == null) {
            } else {
                this.b.setSerifFontFamily(str);
            }
        }
    }

    public void setStandardFontFamily(String str) {
        synchronized (this) {
            if (this.f38802c && this.f38801a != null) {
                this.f38801a.setStandardFontFamily(str);
            } else if (this.f38802c || this.b == null) {
            } else {
                this.b.setStandardFontFamily(str);
            }
        }
    }

    public void setSupportMultipleWindows(boolean z) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.f38802c && (iX5WebSettings = this.f38801a) != null) {
            iX5WebSettings.setSupportMultipleWindows(z);
        } else if (this.f38802c || (webSettings = this.b) == null) {
        } else {
            webSettings.setSupportMultipleWindows(z);
        }
    }

    public void setSupportZoom(boolean z) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.f38802c && (iX5WebSettings = this.f38801a) != null) {
            iX5WebSettings.setSupportZoom(z);
        } else if (this.f38802c || (webSettings = this.b) == null) {
        } else {
            webSettings.setSupportZoom(z);
        }
    }

    @Deprecated
    public void setTextSize(TextSize textSize) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.f38802c && (iX5WebSettings = this.f38801a) != null) {
            iX5WebSettings.setTextSize(IX5WebSettings.TextSize.valueOf(textSize.name()));
        } else if (this.f38802c || (webSettings = this.b) == null) {
        } else {
            webSettings.setTextSize(WebSettings.TextSize.valueOf(textSize.name()));
        }
    }

    public void setTextZoom(int i) {
        synchronized (this) {
            if (this.f38802c && this.f38801a != null) {
                this.f38801a.setTextZoom(i);
            } else if (!this.f38802c && this.b != null) {
                if (Build.VERSION.SDK_INT < 14) {
                    return;
                }
                try {
                    this.b.setTextZoom(i);
                } catch (Exception e) {
                    com.tencent.smtt.utils.i.a(this.b, "setTextZoom", new Class[]{Integer.TYPE}, Integer.valueOf(i));
                }
            }
        }
    }

    @Deprecated
    public void setUseWebViewBackgroundForOverscrollBackground(boolean z) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.f38802c && (iX5WebSettings = this.f38801a) != null) {
            iX5WebSettings.setUseWebViewBackgroundForOverscrollBackground(z);
        } else if (this.f38802c || (webSettings = this.b) == null) {
        } else {
            com.tencent.smtt.utils.i.a(webSettings, "setUseWebViewBackgroundForOverscrollBackground", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
        }
    }

    public void setUseWideViewPort(boolean z) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.f38802c && (iX5WebSettings = this.f38801a) != null) {
            iX5WebSettings.setUseWideViewPort(z);
        } else if (this.f38802c || (webSettings = this.b) == null) {
        } else {
            webSettings.setUseWideViewPort(z);
        }
    }

    public void setUserAgent(String str) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.f38802c && (iX5WebSettings = this.f38801a) != null) {
            iX5WebSettings.setUserAgent(str);
        } else if (this.f38802c || (webSettings = this.b) == null) {
        } else {
            webSettings.setUserAgentString(str);
        }
    }

    public void setUserAgentString(String str) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.f38802c && (iX5WebSettings = this.f38801a) != null) {
            iX5WebSettings.setUserAgentString(str);
        } else if (this.f38802c || (webSettings = this.b) == null) {
        } else {
            webSettings.setUserAgentString(str);
        }
    }

    public boolean supportMultipleWindows() {
        synchronized (this) {
            if (this.f38802c && this.f38801a != null) {
                return this.f38801a.supportMultipleWindows();
            } else if (this.f38802c || this.b == null) {
                return false;
            } else {
                return this.b.supportMultipleWindows();
            }
        }
    }

    public boolean supportZoom() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (!this.f38802c || (iX5WebSettings = this.f38801a) == null) {
            if (this.f38802c || (webSettings = this.b) == null) {
                return false;
            }
            return webSettings.supportZoom();
        }
        return iX5WebSettings.supportZoom();
    }
}
