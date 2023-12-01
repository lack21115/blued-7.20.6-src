package com.anythink.network.baidu;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/network/baidu/BaiduATCustomController.class */
public abstract class BaiduATCustomController {
    public boolean getPermissionAppList() {
        return false;
    }

    public boolean getPermissionAppUpdate() {
        return true;
    }

    public boolean getPermissionDeviceInfo() {
        return true;
    }

    public boolean getPermissionLocation() {
        return false;
    }

    public boolean getPermissionOAID() {
        return true;
    }

    public boolean getPermissionReadDeviceID() {
        return true;
    }

    public boolean getPermissionRunningApp() {
        return true;
    }

    public boolean getPermissionStorage() {
        return false;
    }
}
