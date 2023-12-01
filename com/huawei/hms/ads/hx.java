package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.beans.metadata.Om;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/hx.class */
public class hx {
    private static final String Code = "AdSessionAgentFactory";

    public static is Code(Context context, AdContentData adContentData, hr hrVar, boolean z) {
        ip ipVar;
        iu iuVar;
        iv ivVar;
        iv ivVar2;
        if (adContentData == null || context == null) {
            return new ia();
        }
        if (z && (hrVar == null || hrVar.getOpenMeasureView() == null)) {
            ge.V(Code, "MeasureView is null");
            return new ia();
        } else if (hw.Code()) {
            ge.Code(Code, "AdSessionAgent is avalible");
            hw hwVar = new hw();
            List<Om> ae = adContentData.ae();
            if (ae == null) {
                ge.V(Code, "Oms is null");
                return hwVar;
            }
            if (adContentData.p() != null || (adContentData.q() != null && "video/mp4".equals(adContentData.q().Code()))) {
                ge.V(Code, "Video adsession");
                ipVar = ip.VIDEO;
                iuVar = iu.VIEWABLE;
                ivVar = iv.NATIVE;
                ivVar2 = iv.NATIVE;
            } else {
                ipVar = ip.NATIVE_DISPLAY;
                iuVar = iu.VIEWABLE;
                ivVar = iv.NATIVE;
                ivVar2 = iv.NONE;
            }
            im Code2 = im.Code(ipVar, iuVar, ivVar, ivVar2, false);
            if (Code2 == null) {
                return hwVar;
            }
            if (hwVar instanceof hw) {
                ge.V(Code, "init adSessionAgent");
                hwVar.Code(context, ae, Code2);
            }
            if (z) {
                hwVar.Code(hrVar.getOpenMeasureView());
            }
            return hwVar;
        } else {
            return new ia();
        }
    }
}
