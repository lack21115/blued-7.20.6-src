package com.blued.login.auto;

import java.util.Iterator;
import java.util.ServiceLoader;

/* loaded from: source-7206380-dex2jar.jar:com/blued/login/auto/LoginServiceManager.class */
public class LoginServiceManager {

    /* renamed from: a  reason: collision with root package name */
    private static ILoginService f20503a;

    public static ILoginService a() {
        ILoginService iLoginService;
        ILoginService iLoginService2;
        synchronized (LoginServiceManager.class) {
            try {
                if (f20503a != null && !(f20503a instanceof LonginServiceDefaultImpl)) {
                    return f20503a;
                }
                ServiceLoader load = ServiceLoader.load(ILoginService.class);
                Iterator it = load.iterator();
                do {
                    if (!it.hasNext()) {
                        Iterator it2 = load.iterator();
                        do {
                            if (!it2.hasNext()) {
                                ILoginService iLoginService3 = (ILoginService) Class.forName("com.soft.blued.ui.login_register.auto.LoginServiceImpl").newInstance();
                                f20503a = iLoginService3;
                                return iLoginService3;
                            }
                            iLoginService = (ILoginService) it2.next();
                            if ("COMMUNITY".equals(iLoginService.a()) || "yy".equals(iLoginService.a()) || "LIVE".equals(iLoginService.a())) {
                                break;
                            }
                        } while (!"CHATROOM".equals(iLoginService.a()));
                        f20503a = iLoginService;
                        return iLoginService;
                    }
                    iLoginService2 = (ILoginService) it.next();
                } while (!"MAIN".equals(iLoginService2.a()));
                f20503a = iLoginService2;
                return iLoginService2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
