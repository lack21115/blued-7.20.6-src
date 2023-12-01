package com.opos.mobad.e.a.a.b;

import android.content.Context;
import com.opos.acs.st.InitParams;
import com.opos.acs.st.STManager;
import com.opos.mobad.e.a.j;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/e/a/a/b/b.class */
public final class b implements j {
    @Override // com.opos.mobad.e.a.j
    public final void a(Context context, String str, String str2, String str3) {
        try {
            STManager.getInstance().init(context, str, str2, new InitParams.Builder().setPkgName(str3).setIsLoganInit(false).build());
        } catch (Throwable th) {
            com.opos.cmn.an.f.a.d("MatReporter", "st init!", th);
        }
    }

    @Override // com.opos.mobad.e.a.j
    public final void a(Context context, Map<String, String> map) {
        try {
            STManager.getInstance().onEvent(context, map);
        } catch (Throwable th) {
            com.opos.cmn.an.f.a.d("MatReporter", "st report failed!", th);
        }
    }
}
