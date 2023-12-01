package com.huawei.openalliance.ad.inter;

import com.huawei.hms.ads.RequestOptions;
import com.huawei.openalliance.ad.inter.listeners.AppDownloadListener;
import com.huawei.openalliance.ad.inter.listeners.ExtensionActionListener;
import com.huawei.openalliance.ad.inter.listeners.IAppDownloadManager;
import com.huawei.openalliance.ad.media.IMultiMediaPlayingManager;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/inter/IHiAd.class */
public interface IHiAd {
    void enableSharePd(boolean z);

    void enableUserInfo(boolean z);

    int getAppActivateStyle();

    IAppDownloadManager getAppDownloadManager();

    ExtensionActionListener getExtensionActionListener();

    RequestOptions getRequestConfiguration();

    void informReady();

    void initGrs(String str);

    void initGrs(String str, String str2);

    void initLog(boolean z, int i);

    void initLog(boolean z, int i, String str);

    boolean isAppAutoOpenForbidden();

    boolean isAppInstalledNotify();

    boolean isEnableUserInfo();

    boolean isNewProcess();

    void onBackground();

    void onForeground();

    void setAppActivateStyle(int i);

    void setAppAutoOpenForbidden(boolean z);

    void setAppDownloadListener(AppDownloadListener appDownloadListener);

    void setAppInstalledNotify(boolean z);

    void setAppMuted(boolean z);

    void setAppVolume(float f);

    void setApplicationCode(String str);

    void setBrand(int i);

    void setConsent(String str);

    void setCountryCode(String str);

    void setExtensionActionListener(ExtensionActionListener extensionActionListener);

    void setMultiMediaPlayingManager(IMultiMediaPlayingManager iMultiMediaPlayingManager);

    void setRequestConfiguration(RequestOptions requestOptions);
}
