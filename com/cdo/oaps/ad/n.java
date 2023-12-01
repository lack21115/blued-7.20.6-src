package com.cdo.oaps.ad;

import android.content.Context;
import java.util.Map;

/* loaded from: source-7206380-dex2jar.jar:com/cdo/oaps/ad/n.class */
public class n implements l {
    @Override // com.cdo.oaps.ad.l
    public boolean a(Context context, Map<String, Object> map) {
        return (!"mk".equals(OapsWrapper.wrapper(map).getHost()) || p.b(context) >= 5100) ? new j().a(context, map) : ad.a(context, map);
    }

    @Override // com.cdo.oaps.ad.l
    public boolean b(Context context, Map<String, Object> map) {
        return (!"mk".equals(OapsWrapper.wrapper(map).getHost()) || p.b(context) >= 5100) ? new j().b(context, map) : ad.b(context, map);
    }
}
