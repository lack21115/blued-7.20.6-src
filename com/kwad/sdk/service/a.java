package com.kwad.sdk.service;

import com.ksad.annotation.invoker.ForInvoker;
import com.kwad.components.ad.feed.FeedDownloadActivityProxy;
import com.kwad.components.ad.fullscreen.KsFullScreenLandScapeVideoActivityProxy;
import com.kwad.components.ad.fullscreen.KsFullScreenVideoActivityProxy;
import com.kwad.components.ad.reward.KSRewardLandScapeVideoActivityProxy;
import com.kwad.components.ad.reward.KSRewardVideoActivityProxy;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.components.core.internal.api.VideoPlayConfigImpl;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.page.AdWebViewVideoActivityProxy;
import com.kwad.components.core.page.d;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwai.filedownloader.services.FileDownloadServiceProxy;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/service/a.class */
public final class a {
    private static final Map<Class<?>, Class<?>> ayH = new HashMap();
    private static final Map<Class<?>, Class<?>> ayI = new HashMap();
    private static boolean ayJ = false;
    private static boolean ayK = false;

    private static void Cv() {
        synchronized (a.class) {
            try {
                if (ayJ) {
                    return;
                }
                Cw();
                ayJ = true;
            } finally {
            }
        }
    }

    @ForInvoker(methodId = "initComponentProxyForInvoker")
    private static void Cw() {
        com.ksad.download.b.a.register();
        FeedDownloadActivityProxy.register();
        KsFullScreenLandScapeVideoActivityProxy.register();
        KsFullScreenVideoActivityProxy.register();
        KSRewardLandScapeVideoActivityProxy.register();
        KSRewardVideoActivityProxy.register();
        com.kwad.components.core.page.a.register();
        AdWebViewActivityProxy.register();
        AdWebViewVideoActivityProxy.register();
        d.register();
        com.kwad.components.core.q.kwai.a.register();
        com.kwad.sdk.collector.a.a.register();
        FileDownloadServiceProxy.register();
    }

    private static void Cx() {
        synchronized (a.class) {
            try {
                if (ayK) {
                    return;
                }
                Cy();
                ayK = true;
            } finally {
            }
        }
    }

    @ForInvoker(methodId = "initModeImplForInvoker")
    private static void Cy() {
        KSAdVideoPlayConfigImpl.register();
        com.kwad.components.core.internal.api.d.register();
        VideoPlayConfigImpl.register();
        com.kwad.components.core.o.b.register();
        SceneImpl.register();
    }

    public static void a(Class<?> cls, Class<?> cls2) {
        ayH.put(cls, cls2);
    }

    public static void b(Class cls, Class cls2) {
        ayI.put(cls, cls2);
    }

    public static Class<?> g(Class<?> cls) {
        Cv();
        return ayH.get(cls);
    }

    public static Class<?> h(Class<?> cls) {
        Cx();
        return ayI.get(cls);
    }

    public static void init() {
        Cv();
        Cx();
    }
}
