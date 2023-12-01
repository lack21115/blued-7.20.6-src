package com.blued.track.auth;

import java.util.Iterator;
import java.util.ServiceLoader;

/* loaded from: source-7206380-dex2jar.jar:com/blued/track/auth/TrackServiceManager.class */
public class TrackServiceManager {

    /* renamed from: a  reason: collision with root package name */
    private static ITrackConfigService f7015a;

    public static ITrackConfigService a() {
        ITrackConfigService iTrackConfigService;
        synchronized (TrackServiceManager.class) {
            try {
                if (f7015a != null && !(f7015a instanceof TrackServiceDefaultImpl)) {
                    return f7015a;
                }
                Iterator it = ServiceLoader.load(ITrackConfigService.class).iterator();
                do {
                    if (!it.hasNext()) {
                        ITrackConfigService iTrackConfigService2 = (ITrackConfigService) Class.forName("com.soft.blued.log.auto.TrackConfigServiceImpl").newInstance();
                        f7015a = iTrackConfigService2;
                        return iTrackConfigService2;
                    }
                    iTrackConfigService = (ITrackConfigService) it.next();
                } while (!"MAIN".equals(iTrackConfigService.a()));
                f7015a = iTrackConfigService;
                return iTrackConfigService;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
