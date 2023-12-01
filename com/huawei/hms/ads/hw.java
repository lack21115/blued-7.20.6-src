package com.huawei.hms.ads;

import android.content.Context;
import android.view.View;
import com.huawei.openalliance.ad.beans.metadata.Om;
import com.iab.omid.library.huawei.Omid;
import com.iab.omid.library.huawei.adsession.AdSession;
import com.iab.omid.library.huawei.adsession.AdSessionConfiguration;
import com.iab.omid.library.huawei.adsession.AdSessionContext;
import com.iab.omid.library.huawei.publisher.AdSessionStatePublisher;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/hw.class */
public class hw implements ie, is {
    public static final String Code = "1.2.4";
    private static boolean I = ii.Code(ii.f);
    private static final String V = "AdsessionAgent";
    private Context B;
    private final List<AdSession> Z = new ArrayList();

    private static AdSessionStatePublisher Code(AdSession adSession) {
        if (adSession != null) {
            return adSession.getAdSessionStatePublisher();
        }
        return null;
    }

    private void Code(im imVar, iw iwVar) {
        String str;
        if (iwVar == null) {
            str = "init AdSessionContext failed";
        } else if (!in.Code()) {
            return;
        } else {
            AdSessionContext Code2 = new in(this.B).Code(iwVar, null);
            if (Code2 != null) {
                Code(Code2, imVar);
                return;
            }
            str = "adSessionContext is null";
        }
        ge.V(V, str);
    }

    private void Code(AdSessionContext adSessionContext, im imVar) {
        try {
            if (!im.Code() || imVar == null) {
                ge.V(V, "init AdSession failed");
                return;
            }
            AdSessionConfiguration V2 = imVar.V();
            if (V2 == null) {
                ge.V(V, "adSessionConfiguration is null");
                return;
            }
            ge.V(V, "initAdSession");
            AdSession createAdSession = Code(this.B) ? AdSession.createAdSession(V2, adSessionContext) : null;
            if (createAdSession == null) {
                ge.V(V, "adSession is null");
            } else if (createAdSession != null) {
                this.Z.add(createAdSession);
            }
        } catch (Throwable th) {
            ge.I(V, "initAdSession error");
        }
    }

    private void Code(List<Om> list, im imVar) {
        if (!iw.Code()) {
            ge.V(V, "init VerficationScriptResourceWrapper failed");
            return;
        }
        for (Om om : list) {
            ge.V(V, "Init Verfication Script");
            iw iwVar = new iw();
            iwVar.Code(om);
            Code(imVar, iwVar);
        }
    }

    public static boolean Code() {
        return I;
    }

    private static boolean Code(Context context) {
        Omid.activate(context);
        return true;
    }

    private static String V(AdSession adSession) {
        if (adSession != null) {
            return adSession.getAdSessionId();
        }
        return null;
    }

    @Override // com.huawei.hms.ads.is
    public void B() {
        if (!this.Z.isEmpty()) {
            try {
                for (AdSession adSession : this.Z) {
                    adSession.finish();
                    ge.Code(V, " adSession finish");
                }
            } catch (Throwable th) {
                ge.V(V, "finish, fail");
            }
        }
        this.Z.clear();
    }

    @Override // com.huawei.hms.ads.is
    public void C() {
        if (this.Z.isEmpty()) {
            return;
        }
        try {
            for (AdSession adSession : this.Z) {
                adSession.removeAllFriendlyObstructions();
            }
        } catch (Throwable th) {
            ge.V(V, "removeAllFriendlyObstructions, fail");
        }
    }

    public void Code(Context context, List<Om> list, im imVar) {
        if (!Code() || context == null || list == null) {
            ge.V(V, "not available, not init");
        } else if (list.isEmpty() || imVar == null) {
            ge.V(V, "oms is empty or sessionWrapper is null, not init");
        } else {
            ge.V(V, "init");
            this.B = context;
            Code(list, imVar);
        }
    }

    @Override // com.huawei.hms.ads.is
    public void Code(View view) {
        if (this.Z.isEmpty()) {
            return;
        }
        try {
            for (AdSession adSession : this.Z) {
                adSession.registerAdView(view);
            }
        } catch (Throwable th) {
            ge.V(V, "registerAdView, fail");
        }
    }

    @Override // com.huawei.hms.ads.is
    public void Code(View view, ir irVar, String str) {
        if (this.Z.isEmpty() || irVar == null || !ir.Code()) {
            return;
        }
        try {
            for (AdSession adSession : this.Z) {
                adSession.addFriendlyObstruction(view, ir.Code(irVar), str);
            }
        } catch (Throwable th) {
            ge.V(V, "addFriendlyObstruction-f, fail");
        }
    }

    @Override // com.huawei.hms.ads.is
    public void Code(iq iqVar, String str) {
        if (this.Z.isEmpty() || iqVar == null || !iq.Code()) {
            return;
        }
        try {
            for (AdSession adSession : this.Z) {
                adSession.error(iq.Code(iqVar), str);
            }
        } catch (Throwable th) {
            ge.V(V, "error, fail");
        }
    }

    @Override // com.huawei.hms.ads.is
    public String F() {
        if (this.Z.isEmpty()) {
            return null;
        }
        return V(this.Z.get(0));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Context I() {
        return this.B;
    }

    @Override // com.huawei.hms.ads.is
    public void I(View view) {
        if (this.Z.isEmpty()) {
            return;
        }
        try {
            for (AdSession adSession : this.Z) {
                adSession.removeFriendlyObstruction(view);
            }
        } catch (Throwable th) {
            ge.V(V, "addFriendlyObstruction, fail");
        }
    }

    @Override // com.huawei.hms.ads.is
    public io S() {
        if (this.Z.isEmpty() || !io.Code()) {
            return null;
        }
        return new io(Code(this.Z.get(0)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<AdSession> V() {
        return this.Z;
    }

    @Override // com.huawei.hms.ads.is
    public void V(View view) {
    }

    @Override // com.huawei.hms.ads.is
    public void Z() {
        if (this.Z.isEmpty()) {
            return;
        }
        try {
            for (AdSession adSession : this.Z) {
                ge.Code(V, "adsession start");
                adSession.start();
            }
        } catch (Throwable th) {
            ge.V(V, "start, fail");
        }
    }
}
