package com.anythink.basead;

import android.text.TextUtils;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.common.e.aa;
import com.anythink.core.common.e.i;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/b.class */
public final class b {
    public static Map<String, Object> a(com.anythink.basead.d.b bVar) {
        if (bVar != null) {
            return a(bVar.d());
        }
        return null;
    }

    public static Map<String, Object> a(com.anythink.basead.f.c cVar) {
        if (cVar != null) {
            return a(cVar.e());
        }
        return null;
    }

    public static Map<String, Object> a(i iVar) {
        if (iVar != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("offer_id", iVar.p());
            hashMap.put("creative_id", iVar.q());
            hashMap.put(ATAdConst.NETWORK_CUSTOM_KEY.IS_DEEPLINK_OFFER, Integer.valueOf((TextUtils.isEmpty(iVar.o()) && TextUtils.isEmpty(iVar.z())) ? 0 : 1));
            if (iVar instanceof aa) {
                hashMap.put("dsp_id", ((aa) iVar).T());
            }
            return hashMap;
        }
        return null;
    }
}
