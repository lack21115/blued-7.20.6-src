package com.igexin.sdk.router.boatman;

import com.igexin.sdk.router.boatman.receive.Site;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/sdk/router/boatman/IShips.class */
public interface IShips {
    boolean isRegistered(Site site);

    void register(Site site);

    void unRegister(Site site);
}
