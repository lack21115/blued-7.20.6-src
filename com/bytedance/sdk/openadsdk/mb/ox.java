package com.bytedance.sdk.openadsdk.mb;

import android.app.Application;
import android.os.Bundle;
import android.text.TextUtils;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.EventListener;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.pangle.Zeus;
import com.bytedance.sdk.openadsdk.TTAdBridge;
import com.bytedance.sdk.openadsdk.TTAdEvent;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import com.bytedance.sdk.openadsdk.api.plugin.u;
import com.bytedance.sdk.openadsdk.mb.mb;
import java.util.Map;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/sdk/openadsdk/mb/ox.class */
public final class ox implements Bridge, TTAdBridge {
    private static volatile ox mb;
    private mb ox = new mb();

    private ox() {
    }

    public static final ox mb() {
        if (mb == null) {
            synchronized (ox.class) {
                try {
                    if (mb == null) {
                        mb = new ox();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return mb;
    }

    private void mb(final EventListener eventListener) {
        this.ox.mb(new mb.InterfaceC0326mb() { // from class: com.bytedance.sdk.openadsdk.mb.ox.2
            @Override // com.bytedance.sdk.openadsdk.mb.mb.InterfaceC0326mb
            public void mb() {
                eventListener.onEvent(0, null);
            }

            @Override // com.bytedance.sdk.openadsdk.mb.mb.InterfaceC0326mb
            public void ox() {
                eventListener.onEvent(1, null);
            }
        });
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        switch (i) {
            case 2:
                return (T) this.ox.mb();
            case 3:
                return (T) TTAppContextHolder.getContext();
            case 4:
                return (T) Zeus.getPlugin(valueSet.stringValue(0)).mClassLoader;
            case 5:
                return (T) Boolean.valueOf(Zeus.loadPlugin(valueSet.stringValue(0)));
            case 6:
                return (T) Boolean.valueOf(Zeus.isPluginInstalled(valueSet.stringValue(0)));
            case 7:
                return (T) Boolean.valueOf(Zeus.isPluginLoaded(valueSet.stringValue(0)));
            case 8:
                String mb2 = u.mb(valueSet.stringValue(0));
                String str = mb2;
                if (TextUtils.isEmpty(mb2)) {
                    str = "0.0.0.0";
                }
                return (T) str;
            case 9:
                Object objectValue = valueSet.objectValue(0, Object.class);
                if (objectValue instanceof TTAdEvent) {
                    subscribe((TTAdEvent) objectValue);
                    return null;
                } else if (objectValue instanceof EventListener) {
                    mb((EventListener) objectValue);
                    return null;
                } else {
                    return null;
                }
            default:
                return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdBridge
    public String call(int i, Bundle bundle) {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdBridge
    public <T> T callMethod(Class<T> cls, int i, Map<String, Object> map) {
        switch (i) {
            case 2:
                return (T) this.ox.mb();
            case 3:
                return (T) TTAppContextHolder.getContext();
            case 4:
                return (T) Zeus.getPlugin("com.byted.csj.ext").mClassLoader;
            case 5:
                return (T) Boolean.valueOf(Zeus.loadPlugin("com.byted.csj.ext"));
            case 6:
                return (T) Boolean.valueOf(Zeus.isPluginInstalled("com.byted.csj.ext"));
            case 7:
                return (T) Boolean.valueOf(Zeus.isPluginLoaded("com.byted.csj.ext"));
            case 8:
                String mb2 = u.mb("com.byted.csj.ext");
                String str = mb2;
                if (TextUtils.isEmpty(mb2)) {
                    str = "0.0.0.0";
                }
                return (T) str;
            default:
                return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdBridge
    public <T> T getObj(Class<T> cls) {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdBridge
    public <T> T getObj(Class<T> cls, int i, Map<String, Object> map) {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdBridge
    public void init(Bundle bundle) {
    }

    public Application.ActivityLifecycleCallbacks ox() {
        return this.ox;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdBridge
    public void removeObj(Object obj) {
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdBridge
    public void setObj(Object obj) {
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdBridge
    public void subscribe(final TTAdEvent tTAdEvent) {
        this.ox.mb(new mb.InterfaceC0326mb() { // from class: com.bytedance.sdk.openadsdk.mb.ox.1
            @Override // com.bytedance.sdk.openadsdk.mb.mb.InterfaceC0326mb
            public void mb() {
                tTAdEvent.onEvent(0, null);
            }

            @Override // com.bytedance.sdk.openadsdk.mb.mb.InterfaceC0326mb
            public void ox() {
                tTAdEvent.onEvent(1, null);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdBridge
    public void unsubscribe(TTAdEvent tTAdEvent) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return null;
    }
}
