package com.igexin.sdk.router;

import com.igexin.sdk.router.boatman.Boater;
import com.igexin.sdk.router.boatman.ShipsManager;
import com.igexin.sdk.router.site.BridgeMessageSite;
import com.igexin.sdk.router.site.InitSite;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/sdk/router/GTBoater.class */
public class GTBoater extends Boater {
    private static GTBoater instance;

    public static GTBoater getInstance() {
        if (instance == null) {
            synchronized (GTBoater.class) {
                try {
                    if (instance == null) {
                        instance = new GTBoater();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return instance;
    }

    @Override // com.igexin.sdk.router.boatman.Boater
    public String getTag() {
        return "tag_gt";
    }

    public void initialize() {
        ShipsManager.get().register(new BridgeMessageSite());
        ShipsManager.get().register(new InitSite());
    }

    @Override // com.igexin.sdk.router.boatman.Boater
    public Object postSync(Object obj) {
        return super.postSync(obj);
    }

    @Override // com.igexin.sdk.router.boatman.Boater
    public boolean removeSticky(Object obj) {
        return super.removeSticky(obj);
    }
}
