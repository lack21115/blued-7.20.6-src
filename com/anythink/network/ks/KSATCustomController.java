package com.anythink.network.ks;

import com.kwad.sdk.api.KsCustomController;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/network/ks/KSATCustomController.class */
public abstract class KSATCustomController {
    public boolean getCanReadICCID() {
        return true;
    }

    public boolean getCanReadMacAddress() {
        return true;
    }

    public boolean getCanReadNearbyWifiList() {
        return true;
    }

    public KsCustomController getKsCustomeController() {
        return null;
    }
}
