package com.blued.android.module.common.web.jsbridge;

import java.util.List;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/web/jsbridge/BridgeWhiteListManager.class */
public class BridgeWhiteListManager {
    private static volatile BridgeWhiteListManager instance;
    private List<String> whiteList;

    public static BridgeWhiteListManager getInstance() {
        BridgeWhiteListManager bridgeWhiteListManager;
        synchronized (BridgeWhiteListManager.class) {
            try {
                if (instance == null) {
                    instance = new BridgeWhiteListManager();
                }
                bridgeWhiteListManager = instance;
            } catch (Throwable th) {
                throw th;
            }
        }
        return bridgeWhiteListManager;
    }

    public List<String> getData() {
        return this.whiteList;
    }

    public void setData(List<String> list) {
        this.whiteList = list;
    }
}
