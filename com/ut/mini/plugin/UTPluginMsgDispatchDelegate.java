package com.ut.mini.plugin;

/* loaded from: source-8829756-dex2jar.jar:com/ut/mini/plugin/UTPluginMsgDispatchDelegate.class */
public abstract class UTPluginMsgDispatchDelegate {
    private Object f;

    public UTPluginMsgDispatchDelegate(Object obj) {
        this.f = null;
        this.f = obj;
    }

    public Object getDispatchObject(UTPlugin uTPlugin) {
        return this.f;
    }

    public final Object getMsgObj() {
        return this.f;
    }

    public boolean isMatchPlugin(UTPlugin uTPlugin) {
        return true;
    }
}
