package com.kwad.sdk.collector;

import android.content.Context;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.aj;
import com.kwad.sdk.utils.al;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/collector/f.class */
public final class f {
    private static g ay(Context context) {
        boolean ch = al.ch(context);
        com.kwad.sdk.core.d.b.d("InfoCollector", "queryAccessibilityServicePermission result: " + ch);
        return new g("android.permission.BIND_ACCESSIBILITY_SERVICE", ch ? g.PERMISSION_GRANTED : g.PERMISSION_DENIED);
    }

    private static List<g> az(Context context) {
        ArrayList arrayList = new ArrayList();
        if (context == null) {
            return arrayList;
        }
        String[] cg = aj.cg(context);
        if (cg != null) {
            int length = cg.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                String str = cg[i2];
                int al = al.al(context, str);
                arrayList.add(new g(str, al == 0 ? g.PERMISSION_GRANTED : al == -1 ? g.PERMISSION_DENIED : g.abg));
                i = i2 + 1;
            }
        }
        return arrayList;
    }

    public static JSONArray tG() {
        Context context = ServiceProvider.getContext();
        List<g> az = az(context);
        az.add(ay(context));
        return g.k(az);
    }
}
