package com.opos.mobad;

import android.content.Context;
import com.opos.mobad.activity.AdActivity;
import com.opos.mobad.ad.privacy.ComplianceInfo;
import com.opos.mobad.service.event.EventDescription;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/g.class */
public class g implements com.opos.mobad.cmn.b.c {
    @Override // com.opos.mobad.cmn.b.c
    public boolean a(Context context, ComplianceInfo complianceInfo, EventDescription eventDescription) {
        return AdActivity.b(context, complianceInfo, eventDescription);
    }

    @Override // com.opos.mobad.cmn.b.c
    public boolean b(Context context, ComplianceInfo complianceInfo, EventDescription eventDescription) {
        return AdActivity.a(context, complianceInfo, eventDescription);
    }
}
