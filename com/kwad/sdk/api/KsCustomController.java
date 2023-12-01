package com.kwad.sdk.api;

import android.location.Location;
import com.kwad.sdk.api.core.KsAdSdkApi;
import java.util.List;

@KsAdSdkApi
/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/api/KsCustomController.class */
public abstract class KsCustomController {
    @KsAdSdkApi
    public boolean canReadInstalledPackages() {
        return true;
    }

    @KsAdSdkApi
    public boolean canReadLocation() {
        return true;
    }

    @KsAdSdkApi
    public boolean canUseMacAddress() {
        return true;
    }

    @KsAdSdkApi
    public boolean canUseNetworkState() {
        return true;
    }

    @KsAdSdkApi
    public boolean canUseOaid() {
        return true;
    }

    @KsAdSdkApi
    public boolean canUsePhoneState() {
        return true;
    }

    @KsAdSdkApi
    public boolean canUseStoragePermission() {
        return true;
    }

    @KsAdSdkApi
    public String getAndroidId() {
        return "";
    }

    @KsAdSdkApi
    public String getImei() {
        return "";
    }

    @KsAdSdkApi
    public String[] getImeis() {
        return null;
    }

    @KsAdSdkApi
    public List<String> getInstalledPackages() {
        return null;
    }

    @KsAdSdkApi
    public Location getLocation() {
        return null;
    }

    @KsAdSdkApi
    public String getMacAddress() {
        return "";
    }

    @KsAdSdkApi
    public String getOaid() {
        return "";
    }
}
