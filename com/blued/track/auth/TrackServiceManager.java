package com.blued.track.auth;

import java.util.Iterator;
import java.util.ServiceLoader;

/* loaded from: source-7206380-dex2jar.jar:com/blued/track/auth/TrackServiceManager.class */
public class TrackServiceManager {

    /* renamed from: a  reason: collision with root package name */
    private static ITrackConfigService f20621a;

    public static ITrackConfigService a() {
        ITrackConfigService iTrackConfigService;
        synchronized (TrackServiceManager.class) {
            try {
                if (f20621a != null && !(f20621a instanceof TrackServiceDefaultImpl)) {
                    return f20621a;
                }
                Iterator it = ServiceLoader.load(ITrackConfigService.class).iterator();
                do {
                    if (!it.hasNext()) {
                        ITrackConfigService iTrackConfigService2 = (ITrackConfigService) Class.forName("com.soft.blued.log.auto.TrackConfigServiceImpl").newInstance();
                        f20621a = iTrackConfigService2;
                        return iTrackConfigService2;
                    }
                    iTrackConfigService = (ITrackConfigService) it.next();
                } while (!"MAIN".equals(iTrackConfigService.a()));
                f20621a = iTrackConfigService;
                return iTrackConfigService;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
