package com.bytedance.sdk.openadsdk.live;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.EventListener;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.android.live.base.api.ILiveHostContextParam;
import com.bytedance.android.live.base.api.ILiveInitCallback;
import com.bytedance.android.live.base.api.IOuterLiveRoomService;
import com.bytedance.android.live.base.api.MethodChannelService;
import com.bytedance.android.live.base.api.callback.Callback;
import com.bytedance.android.openliveplugin.LivePluginHelper;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdEvent;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import com.bytedance.sdk.openadsdk.TTPluginListener;
import com.bytedance.sdk.openadsdk.api.b;
import com.bytedance.sdk.openadsdk.api.plugin.u;
import com.bytedance.sdk.openadsdk.live.core.ITTLiveConfig;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/sdk/openadsdk/live/ox.class */
public final class ox extends com.bytedance.sdk.openadsdk.downloadnew.mb implements Bridge, Serializable {
    private ITTLiveTokenInjectionAuth lz;
    private static final ox ox = new ox();
    private static final AtomicBoolean b = new AtomicBoolean(false);
    private static final AtomicBoolean hj = new AtomicBoolean(false);
    private static final AtomicBoolean h = new AtomicBoolean(false);
    private static final AtomicBoolean u = new AtomicBoolean(false);
    public static mb mb = null;
    private ITTLiveConfig ko = null;
    private JSONObject ww = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/sdk/openadsdk/live/ox$mb.class */
    public static final class mb implements TTAdEvent {
        private TTAdEvent mb;
        private EventListener ox;

        private mb(EventListener eventListener) {
            this.ox = eventListener;
        }

        private mb(TTAdEvent tTAdEvent) {
            this.mb = tTAdEvent;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdEvent
        public void onEvent(int i, Bundle bundle) {
            TTAdEvent tTAdEvent = this.mb;
            if (tTAdEvent != null) {
                tTAdEvent.onEvent(i, bundle);
            }
            if (this.ox != null) {
                this.ox.onEvent(i, com.bytedance.sdk.openadsdk.api.ox.mb().mb(0).mb(true).mb(b.mb().mb(0, bundle).ox()).ox());
            }
        }
    }

    private ox() {
    }

    private Context getContext(Object obj) {
        if (obj instanceof Context) {
            return (Context) obj;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        String str;
        ITTLiveConfig iTTLiveConfig;
        Plugin plugin;
        com.bytedance.sdk.openadsdk.api.mb.b("TTLiveSDkBridge", "hasLiveSDKInited：" + u.get() + ", hasLiveInstalled：" + hj.get());
        if (this.ko != null) {
            str = "GeneralAppId：" + this.ko.getGeneralAppId() + "，isValid：" + this.ko.isValid();
        } else {
            str = null;
        }
        com.bytedance.sdk.openadsdk.api.mb.b("TTLiveSDkBridge", str);
        if (u.get() || !hj.get() || (iTTLiveConfig = this.ko) == null || !iTTLiveConfig.isValid() || (plugin = Zeus.getPlugin("com.byted.live.lite")) == null || h.get()) {
            return;
        }
        h.set(true);
        if (!com.bytedance.sdk.openadsdk.live.mb.b(plugin.getVersion())) {
            com.bytedance.sdk.openadsdk.api.mb.ox("TTLiveSDkBridge", "live sdk init crash more than consecutive 5 times , live plugin had uninstalled ! App cold start will request new live plugin ！");
            com.bytedance.sdk.openadsdk.live.mb.hj(plugin.getVersion());
            h.set(false);
            return;
        }
        ILiveHostContextParam.Builder hostActionParam = new ILiveHostContextParam.Builder().setAppName(this.ko.getAppName()).setChannel(this.ko.getChannel()).setIsDebug(this.ko.isDebug()).setECHostAppId(this.ko.getECHostAppId()).setPartner(this.ko.getPartner()).provideMethodChannel(new MethodChannelService() { // from class: com.bytedance.sdk.openadsdk.live.ox.2
            @Override // com.bytedance.android.live.base.api.MethodChannelService
            public String identity() {
                return "pangle";
            }

            @Override // com.bytedance.android.live.base.api.MethodChannelService
            public Object invokeMethod(String str2, Object... objArr) {
                if (TextUtils.isEmpty(str2)) {
                    return null;
                }
                boolean z = true;
                if (str2.hashCode() == -955478604 && str2.equals("getBiddingToken")) {
                    z = false;
                }
                if (z) {
                    return null;
                }
                return ox.this.mb(objArr);
            }
        }).setPartnerSecret(this.ko.getPartnerSecret()).setHostPermission(this.ko.getHostPermission()).setHostActionParam(new com.bytedance.sdk.openadsdk.live.core.mb(this.ko.getLiveHostAction()));
        ITTLiveTokenInjectionAuth iTTLiveTokenInjectionAuth = this.lz;
        if (iTTLiveTokenInjectionAuth != null) {
            hostActionParam.setInjectionAuth(new com.bytedance.sdk.openadsdk.live.core.ox(iTTLiveTokenInjectionAuth));
        }
        ILiveInitCallback iLiveInitCallback = new ILiveInitCallback() { // from class: com.bytedance.sdk.openadsdk.live.ox.3
            @Override // com.bytedance.android.live.base.api.ILiveInitCallback
            public final void onLiveInitFinish() {
                com.bytedance.sdk.openadsdk.api.mb.ox("TTLiveSDkBridge", "onLiveInitFinish - live sdk init succeed！");
                com.bytedance.sdk.openadsdk.api.mb.ox("TTLiveSDkBridge", "execute commerce initLiveCommerce method start");
                boolean mb2 = com.bytedance.sdk.openadsdk.live.mb.mb();
                com.bytedance.sdk.openadsdk.api.mb.ox("TTLiveSDkBridge", "execute commerce initLiveCommerce end , result: " + mb2);
                ox.u.set(true);
                ox.this.ww();
                if (ox.mb != null) {
                    Bundle bundle = new Bundle();
                    bundle.putBoolean(TTLiveConstants.PARAMS_LIVE_SDK_INIT_STATUS, ox.u.get());
                    ox.mb.onEvent(2, bundle);
                }
            }
        };
        if (TTAppContextHolder.getContext() instanceof Application) {
            hostActionParam.setContext((Application) TTAppContextHolder.getContext());
        }
        com.bytedance.sdk.openadsdk.live.mb.mb(plugin.getVersion());
        StringBuilder sb = new StringBuilder();
        sb.append("execute live sdk initLive method start, GeneralAppId:");
        ITTLiveConfig iTTLiveConfig2 = this.ko;
        sb.append(iTTLiveConfig2 != null ? iTTLiveConfig2.getGeneralAppId() : null);
        com.bytedance.sdk.openadsdk.api.mb.ox("TTLiveSDkBridge", sb.toString());
        Context context = TTAppContextHolder.getContext();
        ITTLiveConfig iTTLiveConfig3 = this.ko;
        String str2 = null;
        if (iTTLiveConfig3 != null) {
            str2 = iTTLiveConfig3.getGeneralAppId();
        }
        com.bytedance.sdk.openadsdk.api.mb.ox("TTLiveSDkBridge", "execute live sdk initLive method end, (方法顺利执行结果)result: " + com.bytedance.sdk.openadsdk.live.mb.mb(context, str2, hostActionParam, iLiveInitCallback));
        h.set(false);
        com.bytedance.sdk.openadsdk.live.mb.ox((long) plugin.getVersion());
    }

    private void ko() {
        try {
            LivePluginHelper.getLiveRoomService().callExpandMethod("warmingUpBeforeEnter", new Object[0]);
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.api.mb.mb("TTLiveSDkBridge", th);
        }
    }

    private Bundle mb(Object obj) {
        if (obj instanceof Bundle) {
            return (Bundle) obj;
        }
        return null;
    }

    public static ox mb() {
        return ox;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object mb(Object... objArr) {
        if (objArr == null || objArr.length == 0) {
            return null;
        }
        try {
            Integer num = (Integer) objArr[0];
            TTAdManager adManager = TTAdSdk.getAdManager();
            if (adManager != null) {
                return adManager.getBiddingToken(new AdSlot.Builder().setAdType(num.intValue()).build());
            }
            return null;
        } catch (Throwable th) {
            return null;
        }
    }

    private void mb(Map<String, Object> map) {
        try {
            long longValue = ((Long) map.get(TTLiveConstants.ROOMID_KEY)).longValue();
            Object obj = map.get("event");
            mb mbVar = obj instanceof TTAdEvent ? new mb((TTAdEvent) obj) : new mb((EventListener) obj);
            IOuterLiveRoomService liveRoomService = LivePluginHelper.getLiveRoomService();
            System.currentTimeMillis();
            final mb mbVar2 = mbVar;
            Object callExpandMethod = liveRoomService.callExpandMethod("checkRoomAlive", new Callback<Boolean>() { // from class: com.bytedance.sdk.openadsdk.live.ox.4
                @Override // com.bytedance.android.live.base.api.callback.Callback
                /* renamed from: mb */
                public void invoke(Boolean bool) {
                    if (mbVar2 != null) {
                        Bundle bundle = new Bundle();
                        bundle.putBoolean(TTLiveConstants.PARAMS_LIVE_ROOM_STATUS, bool.booleanValue());
                        mbVar2.onEvent(0, bundle);
                    }
                }
            }, Long.valueOf(longValue), 300);
            if (callExpandMethod == null) {
                synchronized (mbVar) {
                    try {
                        mbVar.notifyAll();
                    } catch (Throwable th) {
                    }
                }
            }
            com.bytedance.sdk.openadsdk.api.mb.ox("TTLiveSDkBridge", "has checkRoomAlive :" + callExpandMethod);
        } catch (Throwable th2) {
            com.bytedance.sdk.openadsdk.api.mb.mb("TTLiveSDkBridge", "getRoomState: exception:", th2);
        }
    }

    private Boolean u() {
        try {
            Object callExpandMethod = LivePluginHelper.getLiveRoomService().callExpandMethod("hasAuthenticated", new Object[0]);
            if (callExpandMethod != null && (callExpandMethod instanceof Boolean)) {
                return (Boolean) callExpandMethod;
            }
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.api.mb.mb("TTLiveSDkBridge", th);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ww() {
        if (mb != null) {
            try {
                Bundle bundle = new Bundle();
                bundle.putBoolean("live_plugin_installed", hj.get());
                bundle.putBoolean("live_plugin_inited", u.get());
                mb.onEvent(3, bundle);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        if (i == 5) {
            init((Bundle) valueSet.objectValue(0, Bundle.class));
            return null;
        } else if (i != 6) {
            return (T) callMethod(cls, i, (Map) valueSet.objectValue(0, Map.class));
        } else {
            Object objectValue = valueSet.objectValue(0, Object.class);
            if (objectValue instanceof TTAdEvent) {
                subscribe((TTAdEvent) valueSet.objectValue(0, TTAdEvent.class));
                return null;
            } else if (objectValue instanceof EventListener) {
                mb = new mb((EventListener) objectValue);
                ww();
                return null;
            } else {
                return null;
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.mb, com.bytedance.sdk.openadsdk.TTAdBridge
    public <T> T callMethod(Class<T> cls, int i, Map<String, Object> map) {
        if (i == 0) {
            return !u.get() ? (T) 1 : !com.bytedance.sdk.openadsdk.live.mb.mb(getContext(map.get("context")), mb(map.get(TTLiveConstants.BUNDLE_KEY))) ? (T) 2 : (T) 0;
        } else if (i != 1) {
            if (i == 2) {
                mb(map);
                return null;
            } else if (i != 3) {
                return i != 4 ? (T) super.callMethod(cls, i, map) : (T) u();
            } else {
                ko();
                return null;
            }
        } else {
            return (T) u;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.mb, com.bytedance.sdk.openadsdk.TTAdBridge
    public <T> T getObj(Class<T> cls, int i, Map<String, Object> map) {
        return (T) super.getObj(cls, i, map);
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.mb, com.bytedance.sdk.openadsdk.TTAdBridge
    public void init(Bundle bundle) {
        super.init(bundle);
        ITTLiveConfig iTTLiveConfig = this.ko;
        if (iTTLiveConfig != null && iTTLiveConfig.isValid() && !TextUtils.isEmpty(this.ko.getGeneralAppId()) && !TextUtils.isEmpty(this.ko.getPartner()) && !TextUtils.isEmpty(this.ko.getPartnerSecret())) {
            com.bytedance.sdk.openadsdk.api.mb.ox("TTLiveSDkBridge", "The configuration has been obtained. Do not repeat initialization");
            return;
        }
        Serializable serializable = bundle.getSerializable(TTLiveConstants.LIVE_INIT_CONFIG_KEY);
        if (serializable instanceof ITTLiveConfig) {
            this.ko = (ITTLiveConfig) serializable;
        }
        try {
            this.ww = new JSONObject(bundle.getString(TTLiveConstants.LIVE_INIT_EXTRA_KEY));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        h();
    }

    public void mb(u uVar, Bundle bundle) {
        if (b.get()) {
            com.bytedance.sdk.openadsdk.api.mb.ox("TTLiveSDkBridge", "live PL is loading...just wait");
        } else if (hj.get()) {
            com.bytedance.sdk.openadsdk.api.mb.ox("TTLiveSDkBridge", "live PL already loaded, dont load again");
        } else {
            TTPluginListener tTPluginListener = new TTPluginListener() { // from class: com.bytedance.sdk.openadsdk.live.ox.1
                @Override // com.bytedance.sdk.openadsdk.TTPluginListener
                public Bundle config() {
                    return null;
                }

                @Override // com.bytedance.sdk.openadsdk.TTPluginListener
                public void onPluginListener(int i, ClassLoader classLoader, Resources resources, Bundle bundle2) {
                    if (1000 == i) {
                        com.bytedance.sdk.openadsdk.api.mb.ox("TTLiveSDkBridge", "live PL install success ， try to init live sdk");
                        ox.hj.set(true);
                        ox.b.set(false);
                        ox.this.h();
                    } else if (1001 == i) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("live PL install failed, errorCode: ");
                        sb.append(bundle2 == null ? null : bundle2.get("code"));
                        com.bytedance.sdk.openadsdk.api.mb.ox("TTLiveSDkBridge", sb.toString());
                        ox.hj.set(false);
                        ox.b.set(false);
                    }
                    ox.this.ww();
                }

                @Override // com.bytedance.sdk.openadsdk.TTPluginListener
                public String packageName() {
                    return null;
                }
            };
            b.set(true);
            hj.set(false);
            com.bytedance.sdk.openadsdk.live.mb.mb(uVar, bundle, tTPluginListener);
        }
    }

    public void mb(ITTLiveTokenInjectionAuth iTTLiveTokenInjectionAuth) {
        this.lz = iTTLiveTokenInjectionAuth;
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.mb, com.bytedance.sdk.openadsdk.TTAdBridge
    public void subscribe(TTAdEvent tTAdEvent) {
        mb = new mb(tTAdEvent);
        ww();
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return null;
    }
}
