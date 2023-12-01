package com.heytap.msp.mobad.api;

import android.content.Context;
import com.heytap.msp.mobad.api.listener.IInitListener;
import com.opos.mobad.ad.d;
import com.opos.mobad.ad.e;

/* loaded from: source-7994992-dex2jar.jar:com/heytap/msp/mobad/api/MobAdManager.class */
public final class MobAdManager {
    private static volatile MobAdManager sMobAdManager;

    private MobAdManager() {
    }

    private int getCVer() {
        return -1;
    }

    public static MobAdManager getInstance() {
        MobAdManager mobAdManager;
        MobAdManager mobAdManager2 = sMobAdManager;
        if (mobAdManager2 == null) {
            synchronized (MobAdManager.class) {
                try {
                    MobAdManager mobAdManager3 = sMobAdManager;
                    mobAdManager = mobAdManager3;
                    if (mobAdManager3 == null) {
                        mobAdManager = new MobAdManager();
                        sMobAdManager = mobAdManager;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return mobAdManager;
        }
        return mobAdManager2;
    }

    public void exit(Context context) {
        a.a().a(context);
    }

    public int getSdkVerCode() {
        return 481004;
    }

    public String getSdkVerName() {
        return "4.8.1";
    }

    public void init(Context context, String str) throws NullPointerException {
        a.a().a(context, str, getCVer());
    }

    public void init(Context context, String str, final InitParams initParams) throws NullPointerException {
        a.a().a(context, str, initParams != null ? initParams.debug : false, initParams != null ? initParams.appOUIDStatus : true, getCVer(), initParams != null && initParams.touristMode, initParams != null ? initParams.advanceMode : 0, (initParams == null || initParams.classifyByAgeProvider == null) ? null : new d() { // from class: com.heytap.msp.mobad.api.MobAdManager.2
            @Override // com.opos.mobad.ad.d
            public String a() {
                return initParams.classifyByAgeProvider.getClassifyByAge();
            }
        });
    }

    public void init(Context context, String str, final InitParams initParams, final IInitListener iInitListener) throws NullPointerException {
        a.a().a(context, str, initParams != null ? initParams.debug : false, initParams != null ? initParams.appOUIDStatus : true, getCVer(), new e() { // from class: com.heytap.msp.mobad.api.MobAdManager.4
            @Override // com.opos.mobad.ad.e
            public void a() {
                IInitListener iInitListener2 = iInitListener;
                if (iInitListener2 != null) {
                    iInitListener2.onSuccess();
                }
            }

            @Override // com.opos.mobad.ad.e
            public void a(String str2) {
                IInitListener iInitListener2 = iInitListener;
                if (iInitListener2 != null) {
                    iInitListener2.onFailed(str2);
                }
            }
        }, initParams != null && initParams.touristMode, initParams != null ? initParams.advanceMode : 0, (initParams == null || initParams.classifyByAgeProvider == null) ? null : new d() { // from class: com.heytap.msp.mobad.api.MobAdManager.3
            @Override // com.opos.mobad.ad.d
            public String a() {
                return initParams.classifyByAgeProvider.getClassifyByAge();
            }
        });
    }

    public void init(Context context, String str, final IInitListener iInitListener) throws NullPointerException {
        a.a().a(context, str, getCVer(), new e() { // from class: com.heytap.msp.mobad.api.MobAdManager.1
            @Override // com.opos.mobad.ad.e
            public void a() {
                IInitListener iInitListener2 = iInitListener;
                if (iInitListener2 != null) {
                    iInitListener2.onSuccess();
                }
            }

            @Override // com.opos.mobad.ad.e
            public void a(String str2) {
                IInitListener iInitListener2 = iInitListener;
                if (iInitListener2 != null) {
                    iInitListener2.onFailed(str2);
                }
            }
        });
    }

    public boolean isSupportedMobile() {
        return a.a().a();
    }
}
