package com.anythink.core.common.e.a;

import android.util.Log;
import com.anythink.core.api.ATAdAppInfo;
import com.anythink.core.common.b.n;
import com.anythink.core.common.e.i;
import com.anythink.core.common.e.k;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/e/a/b.class */
public class b extends i implements Serializable {
    final String a = b.class.getSimpleName();

    public b(e eVar) {
        n(eVar.getIconImageUrl());
        f(eVar.getStarRating().intValue());
        p(eVar.getMainImageUrl());
        l(eVar.getTitle());
        r(eVar.getCallToActionText());
        m(eVar.getDescriptionText());
        q(eVar.getAdChoiceIconUrl());
        a(eVar.getAdLogo());
        if (eVar.getAdAppInfo() != null) {
            if (n.a().A()) {
                String str = this.a;
                Log.i(str, "AdAppInfo:" + eVar.getAdAppInfo().toString());
            }
            ATAdAppInfo adAppInfo = eVar.getAdAppInfo();
            y(adAppInfo.getPublisher());
            z(adAppInfo.getAppVersion());
            A(adAppInfo.getAppPrivacyUrl());
            B(adAppInfo.getAppPermissonUrl());
        }
    }

    @Override // com.anythink.core.common.e.i
    public final boolean L() {
        return true;
    }

    @Override // com.anythink.core.common.e.i
    public final List<String> b(k kVar) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(u());
        return arrayList;
    }

    @Override // com.anythink.core.common.e.i
    public final int d() {
        return 10;
    }

    @Override // com.anythink.core.common.e.i
    public final String m() {
        return "";
    }
}
