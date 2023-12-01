package com.cdo.oaps.ad;

import android.content.Context;
import com.cdo.oaps.ad.Launcher;
import java.util.Map;

/* loaded from: source-7206380-dex2jar.jar:com/cdo/oaps/ad/o.class */
public class o implements l {
    @Override // com.cdo.oaps.ad.l
    public boolean a(Context context, Map<String, Object> map) {
        return (!Launcher.Host.MK_OP.equals(OapsWrapper.wrapper(map).getHost()) || p.a(context, a.a()) >= 2000000) ? new j().a(context, map) : s.a(context, map);
    }

    @Override // com.cdo.oaps.ad.l
    public boolean b(Context context, Map<String, Object> map) {
        if (!Launcher.Host.MK_OP.equals(OapsWrapper.wrapper(map).getHost()) || p.a(context, a.a()) >= 2000000) {
            return new j().b(context, map);
        }
        return false;
    }
}
