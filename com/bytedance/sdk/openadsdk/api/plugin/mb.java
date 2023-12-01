package com.bytedance.sdk.openadsdk.api.plugin;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.CSJAdError;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import com.bytedance.sdk.openadsdk.TTPluginListener;
import com.bytedance.sdk.openadsdk.common.CommonListener;
import com.bytedance.sdk.openadsdk.downloadnew.core.ExitInstallListener;
import java.lang.ref.WeakReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-7206380-dex2jar.jar:com/bytedance/sdk/openadsdk/api/plugin/mb.class */
public final class mb implements TTAdManager {
    static final mb mb = new mb();
    private volatile TTAdManager ox;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bytedance.sdk.openadsdk.api.plugin.mb$1  reason: invalid class name */
    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/sdk/openadsdk/api/plugin/mb$1.class */
    public class AnonymousClass1 implements ox<TTAdNative> {
        TTAdNative mb;
        final /* synthetic */ WeakReference ox;

        AnonymousClass1(WeakReference weakReference) {
            this.ox = weakReference;
        }

        @Override // com.bytedance.sdk.openadsdk.api.plugin.mb.ox
        public void mb(final InterfaceC0324mb<TTAdNative> interfaceC0324mb) {
            TTAdNative tTAdNative = this.mb;
            if (tTAdNative != null) {
                interfaceC0324mb.mb(tTAdNative);
            } else {
                mb.this.call(new InterfaceC0324mb<TTAdManager>() { // from class: com.bytedance.sdk.openadsdk.api.plugin.mb.1.1
                    @Override // com.bytedance.sdk.openadsdk.api.plugin.mb.InterfaceC0324mb
                    public void mb(TTAdManager tTAdManager) {
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        anonymousClass1.mb = tTAdManager.createAdNative((Context) anonymousClass1.ox.get());
                        interfaceC0324mb.mb(AnonymousClass1.this.mb);
                    }
                });
            }
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/sdk/openadsdk/api/plugin/mb$b.class */
    interface b<T> extends InterfaceC0324mb<T> {
        void mb();
    }

    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/sdk/openadsdk/api/plugin/mb$hj.class */
    static final class hj implements TTAdNative {
        private ox<TTAdNative> mb;

        public hj(ox<TTAdNative> oxVar) {
            this.mb = oxVar;
        }

        private final void mb(TTAdNative.CSJSplashAdListener cSJSplashAdListener, InterfaceC0324mb<TTAdNative> interfaceC0324mb) {
            try {
                this.mb.mb(interfaceC0324mb);
            } catch (Throwable th) {
                if (cSJSplashAdListener != null) {
                    cSJSplashAdListener.onSplashLoadFail(new CSJAdError(4202, "Load ad failed: " + th.getMessage()));
                }
            }
        }

        private final void mb(CommonListener commonListener, InterfaceC0324mb<TTAdNative> interfaceC0324mb) {
            try {
                this.mb.mb(interfaceC0324mb);
            } catch (Throwable th) {
                if (commonListener != null) {
                    commonListener.onError(4202, "Load ad failed: " + th.getMessage());
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadBannerExpressAd(final AdSlot adSlot, final TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
            mb(nativeExpressAdListener, new InterfaceC0324mb<TTAdNative>() { // from class: com.bytedance.sdk.openadsdk.api.plugin.mb.hj.4
                @Override // com.bytedance.sdk.openadsdk.api.plugin.mb.InterfaceC0324mb
                public void mb(TTAdNative tTAdNative) {
                    tTAdNative.loadBannerExpressAd(adSlot, nativeExpressAdListener);
                }
            });
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadDrawFeedAd(final AdSlot adSlot, final TTAdNative.DrawFeedAdListener drawFeedAdListener) {
            mb(drawFeedAdListener, new InterfaceC0324mb<TTAdNative>() { // from class: com.bytedance.sdk.openadsdk.api.plugin.mb.hj.6
                @Override // com.bytedance.sdk.openadsdk.api.plugin.mb.InterfaceC0324mb
                public void mb(TTAdNative tTAdNative) {
                    tTAdNative.loadDrawFeedAd(adSlot, drawFeedAdListener);
                }
            });
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadExpressDrawFeedAd(final AdSlot adSlot, final TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
            mb(nativeExpressAdListener, new InterfaceC0324mb<TTAdNative>() { // from class: com.bytedance.sdk.openadsdk.api.plugin.mb.hj.3
                @Override // com.bytedance.sdk.openadsdk.api.plugin.mb.InterfaceC0324mb
                public void mb(TTAdNative tTAdNative) {
                    tTAdNative.loadExpressDrawFeedAd(adSlot, nativeExpressAdListener);
                }
            });
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadFeedAd(final AdSlot adSlot, final TTAdNative.FeedAdListener feedAdListener) {
            mb(feedAdListener, new InterfaceC0324mb<TTAdNative>() { // from class: com.bytedance.sdk.openadsdk.api.plugin.mb.hj.1
                @Override // com.bytedance.sdk.openadsdk.api.plugin.mb.InterfaceC0324mb
                public void mb(TTAdNative tTAdNative) {
                    tTAdNative.loadFeedAd(adSlot, feedAdListener);
                }
            });
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadFullScreenVideoAd(final AdSlot adSlot, final TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener) {
            mb(fullScreenVideoAdListener, new InterfaceC0324mb<TTAdNative>() { // from class: com.bytedance.sdk.openadsdk.api.plugin.mb.hj.12
                @Override // com.bytedance.sdk.openadsdk.api.plugin.mb.InterfaceC0324mb
                public void mb(TTAdNative tTAdNative) {
                    tTAdNative.loadFullScreenVideoAd(adSlot, fullScreenVideoAdListener);
                }
            });
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadInteractionExpressAd(AdSlot adSlot, TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadNativeAd(final AdSlot adSlot, final TTAdNative.NativeAdListener nativeAdListener) {
            mb(nativeAdListener, new InterfaceC0324mb<TTAdNative>() { // from class: com.bytedance.sdk.openadsdk.api.plugin.mb.hj.7
                @Override // com.bytedance.sdk.openadsdk.api.plugin.mb.InterfaceC0324mb
                public void mb(TTAdNative tTAdNative) {
                    tTAdNative.loadNativeAd(adSlot, nativeAdListener);
                }
            });
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadNativeExpressAd(final AdSlot adSlot, final TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
            mb(nativeExpressAdListener, new InterfaceC0324mb<TTAdNative>() { // from class: com.bytedance.sdk.openadsdk.api.plugin.mb.hj.2
                @Override // com.bytedance.sdk.openadsdk.api.plugin.mb.InterfaceC0324mb
                public void mb(TTAdNative tTAdNative) {
                    tTAdNative.loadNativeExpressAd(adSlot, nativeExpressAdListener);
                }
            });
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadRewardVideoAd(final AdSlot adSlot, final TTAdNative.RewardVideoAdListener rewardVideoAdListener) {
            mb(rewardVideoAdListener, new InterfaceC0324mb<TTAdNative>() { // from class: com.bytedance.sdk.openadsdk.api.plugin.mb.hj.11
                @Override // com.bytedance.sdk.openadsdk.api.plugin.mb.InterfaceC0324mb
                public void mb(TTAdNative tTAdNative) {
                    tTAdNative.loadRewardVideoAd(adSlot, rewardVideoAdListener);
                }
            });
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadSplashAd(final AdSlot adSlot, final TTAdNative.CSJSplashAdListener cSJSplashAdListener, final int i) {
            mb(cSJSplashAdListener, new InterfaceC0324mb<TTAdNative>() { // from class: com.bytedance.sdk.openadsdk.api.plugin.mb.hj.9
                @Override // com.bytedance.sdk.openadsdk.api.plugin.mb.InterfaceC0324mb
                public void mb(TTAdNative tTAdNative) {
                    tTAdNative.loadSplashAd(adSlot, cSJSplashAdListener, i);
                }
            });
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadSplashAd(final AdSlot adSlot, final TTAdNative.SplashAdListener splashAdListener) {
            mb(splashAdListener, new InterfaceC0324mb<TTAdNative>() { // from class: com.bytedance.sdk.openadsdk.api.plugin.mb.hj.10
                @Override // com.bytedance.sdk.openadsdk.api.plugin.mb.InterfaceC0324mb
                public void mb(TTAdNative tTAdNative) {
                    tTAdNative.loadSplashAd(adSlot, splashAdListener);
                }
            });
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadSplashAd(final AdSlot adSlot, final TTAdNative.SplashAdListener splashAdListener, final int i) {
            mb(splashAdListener, new InterfaceC0324mb<TTAdNative>() { // from class: com.bytedance.sdk.openadsdk.api.plugin.mb.hj.8
                @Override // com.bytedance.sdk.openadsdk.api.plugin.mb.InterfaceC0324mb
                public void mb(TTAdNative tTAdNative) {
                    tTAdNative.loadSplashAd(adSlot, splashAdListener, i);
                }
            });
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadStream(final AdSlot adSlot, final TTAdNative.FeedAdListener feedAdListener) {
            mb(feedAdListener, new InterfaceC0324mb<TTAdNative>() { // from class: com.bytedance.sdk.openadsdk.api.plugin.mb.hj.5
                @Override // com.bytedance.sdk.openadsdk.api.plugin.mb.InterfaceC0324mb
                public void mb(TTAdNative tTAdNative) {
                    tTAdNative.loadStream(adSlot, feedAdListener);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bytedance.sdk.openadsdk.api.plugin.mb$mb  reason: collision with other inner class name */
    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/sdk/openadsdk/api/plugin/mb$mb.class */
    public interface InterfaceC0324mb<T> {
        void mb(T t);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/sdk/openadsdk/api/plugin/mb$ox.class */
    public interface ox<T> {
        void mb(InterfaceC0324mb<T> interfaceC0324mb);
    }

    mb() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void call(final InterfaceC0324mb<TTAdManager> interfaceC0324mb) {
        if (this.ox == null) {
            if (ko.mb != null) {
                ko.mb.submit(new Runnable() { // from class: com.bytedance.sdk.openadsdk.api.plugin.mb.8
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            if (mb.this.ox != null) {
                                interfaceC0324mb.mb(mb.this.ox);
                                return;
                            }
                            if (interfaceC0324mb instanceof b) {
                                ((b) interfaceC0324mb).mb();
                            }
                            com.bytedance.sdk.openadsdk.api.mb.hj("PluginDefaultAdManager", "Not ready, no manager");
                        } catch (Throwable th) {
                            com.bytedance.sdk.openadsdk.api.mb.hj("PluginDefaultAdManager", "Unexpected manager call error: " + th.getMessage());
                            u.mb(th);
                        }
                    }
                });
                return;
            } else {
                com.bytedance.sdk.openadsdk.api.mb.hj("PluginDefaultAdManager", "Not ready, no executor");
                return;
            }
        }
        try {
            interfaceC0324mb.mb(this.ox);
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.api.mb.hj("PluginDefaultAdManager", "Unexpected manager call error: " + th.getMessage());
            u.mb(th);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public TTAdNative createAdNative(Context context) {
        return new hj(new AnonymousClass1(new WeakReference(context)));
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public String getBiddingToken(AdSlot adSlot) {
        if (this.ox != null) {
            return this.ox.getBiddingToken(adSlot);
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public String getBiddingToken(AdSlot adSlot, boolean z, int i) {
        if (this.ox != null) {
            return this.ox.getBiddingToken(adSlot, z, i);
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public <T> T getExtra(final Class<T> cls, final Bundle bundle) {
        if (this.ox != null) {
            return (T) this.ox.getExtra(cls, bundle);
        }
        if (cls == Bundle.class && bundle != null && bundle.getInt("action", 0) == 1) {
            call(new b<TTAdManager>() { // from class: com.bytedance.sdk.openadsdk.api.plugin.mb.4
                @Override // com.bytedance.sdk.openadsdk.api.plugin.mb.b
                public void mb() {
                    com.bytedance.sdk.openadsdk.api.plugin.hj.mb(bundle);
                }

                @Override // com.bytedance.sdk.openadsdk.api.plugin.mb.InterfaceC0324mb
                public void mb(TTAdManager tTAdManager) {
                    tTAdManager.getExtra(cls, bundle);
                }
            });
            return null;
        }
        call(new InterfaceC0324mb<TTAdManager>() { // from class: com.bytedance.sdk.openadsdk.api.plugin.mb.5
            @Override // com.bytedance.sdk.openadsdk.api.plugin.mb.InterfaceC0324mb
            public void mb(TTAdManager tTAdManager) {
                tTAdManager.getExtra(cls, bundle);
            }
        });
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public String getPluginVersion() {
        return this.ox != null ? this.ox.getPluginVersion() : "";
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public String getSDKVersion() {
        return "5.1.0.2";
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public int getThemeStatus() {
        if (this.ox != null) {
            return this.ox.getThemeStatus();
        }
        return 0;
    }

    public void mb(TTAdManager tTAdManager) {
        this.ox = tTAdManager;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public void register(final Object obj) {
        Bundle bundle;
        if (obj instanceof TTPluginListener) {
            TTPluginListener tTPluginListener = (TTPluginListener) obj;
            bundle = u.mb(TTAppContextHolder.getContext()).mb(tTPluginListener.packageName(), tTPluginListener.config());
        } else {
            bundle = obj;
        }
        final Object obj2 = bundle;
        call(new InterfaceC0324mb<TTAdManager>() { // from class: com.bytedance.sdk.openadsdk.api.plugin.mb.2
            @Override // com.bytedance.sdk.openadsdk.api.plugin.mb.InterfaceC0324mb
            public void mb(TTAdManager tTAdManager) {
                tTAdManager.register(obj2);
                if (obj instanceof TTPluginListener) {
                    u.mb(TTAppContextHolder.getContext()).mb((TTPluginListener) obj);
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public void requestPermissionIfNecessary(final Context context) {
        call(new InterfaceC0324mb<TTAdManager>() { // from class: com.bytedance.sdk.openadsdk.api.plugin.mb.6
            @Override // com.bytedance.sdk.openadsdk.api.plugin.mb.InterfaceC0324mb
            public void mb(TTAdManager tTAdManager) {
                tTAdManager.requestPermissionIfNecessary(context);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public void setThemeStatus(final int i) {
        call(new InterfaceC0324mb<TTAdManager>() { // from class: com.bytedance.sdk.openadsdk.api.plugin.mb.7
            @Override // com.bytedance.sdk.openadsdk.api.plugin.mb.InterfaceC0324mb
            public void mb(TTAdManager tTAdManager) {
                mb.this.ox.setThemeStatus(i);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public boolean tryShowInstallDialogWhenExit(Activity activity, ExitInstallListener exitInstallListener) {
        return this.ox != null && this.ox.tryShowInstallDialogWhenExit(activity, exitInstallListener);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public void unregister(final Object obj) {
        call(new InterfaceC0324mb<TTAdManager>() { // from class: com.bytedance.sdk.openadsdk.api.plugin.mb.3
            @Override // com.bytedance.sdk.openadsdk.api.plugin.mb.InterfaceC0324mb
            public void mb(TTAdManager tTAdManager) {
                tTAdManager.unregister(obj);
            }
        });
    }
}
