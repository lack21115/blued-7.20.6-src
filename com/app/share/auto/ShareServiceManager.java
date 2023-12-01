package com.app.share.auto;

import java.util.Iterator;
import java.util.ServiceLoader;

/* loaded from: source-8756600-dex2jar.jar:com/app/share/auto/ShareServiceManager.class */
public class ShareServiceManager {

    /* renamed from: a  reason: collision with root package name */
    private static IShareService f9214a;

    public static IShareService a() {
        IShareService iShareService;
        synchronized (ShareServiceManager.class) {
            try {
                if (f9214a != null && !(f9214a instanceof IShareService)) {
                    return f9214a;
                }
                Iterator it = ServiceLoader.load(IShareService.class).iterator();
                do {
                    if (!it.hasNext()) {
                        IShareService iShareService2 = (IShareService) Class.forName("com.soft.blued.ui.share.auto.ShareServiceConfigImpl").newInstance();
                        f9214a = iShareService2;
                        return iShareService2;
                    }
                    iShareService = (IShareService) it.next();
                } while (!"SHARE_MAIN".equals(iShareService.a()));
                f9214a = iShareService;
                return iShareService;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
