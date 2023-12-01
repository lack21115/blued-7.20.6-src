package com.blued.community.auto;

import java.util.Iterator;
import java.util.ServiceLoader;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/auto/CommunityServiceManager.class */
public class CommunityServiceManager {

    /* renamed from: a  reason: collision with root package name */
    private static ICommunityConfigService f18780a;
    private static ICommunityShowPageService b;

    /* renamed from: c  reason: collision with root package name */
    private static ICommunityLocationService f18781c;
    private static ICommunityTrackService d;
    private static ICommunityOtherService e;

    public static ICommunityConfigService a() {
        ICommunityConfigService iCommunityConfigService;
        synchronized (CommunityServiceManager.class) {
            try {
                if (f18780a != null && !(f18780a instanceof CommunityServiceDefaultImpl)) {
                    return f18780a;
                }
                Iterator it = ServiceLoader.load(ICommunityConfigService.class).iterator();
                do {
                    if (!it.hasNext()) {
                        ICommunityConfigService iCommunityConfigService2 = (ICommunityConfigService) Class.forName("com.soft.blued.ui.community.auto.CommunityConfigServiceImpl").newInstance();
                        f18780a = iCommunityConfigService2;
                        return iCommunityConfigService2;
                    }
                    iCommunityConfigService = (ICommunityConfigService) it.next();
                } while (!"MAIN".equals(iCommunityConfigService.a()));
                f18780a = iCommunityConfigService;
                return iCommunityConfigService;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static ICommunityShowPageService b() {
        ICommunityShowPageService iCommunityShowPageService;
        synchronized (CommunityServiceManager.class) {
            try {
                if (b != null && !(b instanceof CommunityServiceDefaultImpl)) {
                    return b;
                }
                Iterator it = ServiceLoader.load(ICommunityShowPageService.class).iterator();
                do {
                    if (!it.hasNext()) {
                        ICommunityShowPageService iCommunityShowPageService2 = (ICommunityShowPageService) Class.forName("com.soft.blued.ui.community.auto.CommunityShowPageServiceImpl").newInstance();
                        b = iCommunityShowPageService2;
                        return iCommunityShowPageService2;
                    }
                    iCommunityShowPageService = (ICommunityShowPageService) it.next();
                } while (!"MAIN".equals(iCommunityShowPageService.a()));
                b = iCommunityShowPageService;
                return iCommunityShowPageService;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static ICommunityLocationService c() {
        ICommunityLocationService iCommunityLocationService;
        synchronized (CommunityServiceManager.class) {
            try {
                if (f18781c != null && !(f18781c instanceof CommunityServiceDefaultImpl)) {
                    return f18781c;
                }
                Iterator it = ServiceLoader.load(ICommunityLocationService.class).iterator();
                do {
                    if (!it.hasNext()) {
                        ICommunityLocationService iCommunityLocationService2 = (ICommunityLocationService) Class.forName("com.soft.blued.ui.community.auto.CommunityLocationServiceImpl").newInstance();
                        f18781c = iCommunityLocationService2;
                        return iCommunityLocationService2;
                    }
                    iCommunityLocationService = (ICommunityLocationService) it.next();
                } while (!"MAIN".equals(iCommunityLocationService.a()));
                f18781c = iCommunityLocationService;
                return iCommunityLocationService;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static ICommunityTrackService d() {
        ICommunityTrackService iCommunityTrackService;
        synchronized (CommunityServiceManager.class) {
            try {
                if (d != null && !(d instanceof CommunityServiceDefaultImpl)) {
                    return d;
                }
                Iterator it = ServiceLoader.load(ICommunityTrackService.class).iterator();
                do {
                    if (!it.hasNext()) {
                        ICommunityTrackService iCommunityTrackService2 = (ICommunityTrackService) Class.forName("com.soft.blued.ui.community.auto.CommunityTrackServiceImpl").newInstance();
                        d = iCommunityTrackService2;
                        return iCommunityTrackService2;
                    }
                    iCommunityTrackService = (ICommunityTrackService) it.next();
                } while (!"MAIN".equals(iCommunityTrackService.a()));
                d = iCommunityTrackService;
                return iCommunityTrackService;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static ICommunityOtherService e() {
        ICommunityOtherService iCommunityOtherService;
        synchronized (CommunityServiceManager.class) {
            try {
                if (e != null && !(e instanceof CommunityServiceDefaultImpl)) {
                    return e;
                }
                Iterator it = ServiceLoader.load(ICommunityOtherService.class).iterator();
                do {
                    if (!it.hasNext()) {
                        ICommunityOtherService iCommunityOtherService2 = (ICommunityOtherService) Class.forName("com.soft.blued.ui.community.auto.CommunityOtherServiceImpl").newInstance();
                        e = iCommunityOtherService2;
                        return iCommunityOtherService2;
                    }
                    iCommunityOtherService = (ICommunityOtherService) it.next();
                } while (!"MAIN".equals(iCommunityOtherService.a()));
                e = iCommunityOtherService;
                return iCommunityOtherService;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
