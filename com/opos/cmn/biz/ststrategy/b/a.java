package com.opos.cmn.biz.ststrategy.b;

import com.opos.cmn.biz.ststrategy.UpdateParams;
import com.opos.cmn.biz.ststrategy.entity.STConfigEntity;
import com.opos.cmn.biz.ststrategy.listener.UpdateSTConfigListener;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/biz/ststrategy/b/a.class */
public interface a {
    STConfigEntity a();

    void a(UpdateParams updateParams, UpdateSTConfigListener updateSTConfigListener);

    void a(String str, UpdateSTConfigListener updateSTConfigListener);
}
