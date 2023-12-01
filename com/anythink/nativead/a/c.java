package com.anythink.nativead.a;

import android.content.Context;
import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.api.AdError;
import com.anythink.core.common.e.ai;
import com.anythink.core.common.h;
import com.anythink.nativead.unitgroup.api.CustomNativeAdapter;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/nativead/a/c.class */
public final class c extends h {
    /* JADX INFO: Access modifiers changed from: protected */
    public c(Context context) {
        super(context);
    }

    public final void a(ATBaseAdAdapter aTBaseAdAdapter) {
        ai unitGroupInfo;
        if (aTBaseAdAdapter == null || (unitGroupInfo = aTBaseAdAdapter.getUnitGroupInfo()) == null || !(aTBaseAdAdapter instanceof CustomNativeAdapter)) {
            return;
        }
        ((CustomNativeAdapter) aTBaseAdAdapter).setRequestNum(unitGroupInfo.r());
    }

    public final void a(AdError adError) {
        super.a(adError);
    }

    public final void h() {
        super.h();
    }
}
