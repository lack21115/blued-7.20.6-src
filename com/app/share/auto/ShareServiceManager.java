package com.app.share.auto;

import java.util.Iterator;
import java.util.ServiceLoader;

/* loaded from: source-8756600-dex2jar.jar:com/app/share/auto/ShareServiceManager.class */
public class ShareServiceManager {

    /* renamed from: a  reason: collision with root package name */
    private static IShareService f6374a;

    public static IShareService a() {
        IShareService iShareService;
        synchronized (ShareServiceManager.class) {
            try {
                if (f6374a != null && !(f6374a instanceof IShareService)) {
                    return f6374a;
                }
                Iterator it = ServiceLoader.load(IShareService.class).iterator();
                do {
                    if (!it.hasNext()) {
                        IShareService iShareService2 = (IShareService) Class.forName("com.soft.blued.ui.share.auto.ShareServiceConfigImpl").newInstance();
                        f6374a = iShareService2;
                        return iShareService2;
                    }
                    iShareService = (IShareService) it.next();
                } while (!"SHARE_MAIN".equals(iShareService.a()));
                f6374a = iShareService;
                return iShareService;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
