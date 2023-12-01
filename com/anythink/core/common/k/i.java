package com.anythink.core.common.k;

import android.util.Log;
import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.common.e.ai;
import java.lang.reflect.Constructor;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/k/i.class */
public final class i {
    protected static i a = new i();

    public static ATBaseAdAdapter a(ai aiVar) {
        try {
            return a(aiVar.h());
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private static ATBaseAdAdapter a(Class<? extends com.anythink.core.common.b.d> cls) {
        if (cls == null) {
            Log.w(com.anythink.core.common.b.g.n, "can not find adapter");
        }
        Constructor<? extends com.anythink.core.common.b.d> declaredConstructor = cls.getDeclaredConstructor(null);
        declaredConstructor.setAccessible(true);
        return (ATBaseAdAdapter) declaredConstructor.newInstance(new Object[0]);
    }

    public static ATBaseAdAdapter a(String str) {
        if (str != null) {
            Class<? extends U> asSubclass = Class.forName(str).asSubclass(ATBaseAdAdapter.class);
            if (asSubclass == 0) {
                Log.w(com.anythink.core.common.b.g.n, "can not find adapter");
            }
            Constructor declaredConstructor = asSubclass.getDeclaredConstructor(null);
            declaredConstructor.setAccessible(true);
            return (ATBaseAdAdapter) declaredConstructor.newInstance(new Object[0]);
        }
        return null;
    }
}
