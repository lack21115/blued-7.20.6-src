package com.cdo.oaps.ad;

import android.content.Context;
import com.cdo.oaps.ad.wrapper.ResourceWrapper;
import com.cdo.oaps.ad.wrapper.SearchWrapper;
import java.util.Map;

/* loaded from: source-7206380-dex2jar.jar:com/cdo/oaps/ad/s.class */
public class s {
    private static int a(String str) {
        if ("4".equals(str)) {
            return 1607;
        }
        if ("6".equals(str)) {
            return 1609;
        }
        if ("8".equals(str)) {
            return 1611;
        }
        if ("7".equals(str)) {
            return 1610;
        }
        return "5".equals(str) ? 1608 : 1607;
    }

    public static boolean a(Context context, String str) {
        boolean z;
        if (!u.a(context, a.b(a.f7907a), 2000000)) {
            z = false;
            if (u.a(context, a.b(a.f7907a), 1)) {
                String[] strArr = u.f7929c;
                int length = strArr.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    z = false;
                    if (i2 < length) {
                        if (strArr[i2].equals(str)) {
                            break;
                        }
                        i = i2 + 1;
                    } else {
                        break;
                    }
                }
            }
            return z;
        }
        z = true;
        return z;
    }

    public static boolean a(Context context, Map<String, Object> map) {
        return b(context, map);
    }

    private static boolean b(Context context, Map<String, Object> map) {
        OapsWrapper wrapper = OapsWrapper.wrapper(map);
        if (wrapper.getPath().equals("/dt")) {
            ResourceWrapper wrapper2 = ResourceWrapper.wrapper(wrapper.getParams());
            if (u.a(context, a.b(a.f7907a), 1)) {
                long id = wrapper2.getId();
                String pkgName = wrapper2.getPkgName();
                boolean autoDown = wrapper2.getAutoDown();
                boolean equals = "1".equals(wrapper2.getGoBack());
                int a2 = a(wrapper2.getEnterId());
                if (id > 0) {
                    return q.a(context, id, autoDown, equals, a2);
                }
                if (!r.a(pkgName)) {
                    return q.a(context, pkgName, autoDown, equals, a2);
                }
            }
        }
        if (wrapper.getPath().equals("/search")) {
            SearchWrapper wrapper3 = SearchWrapper.wrapper(wrapper.getParams());
            if (u.a(context, a.b(a.f7907a), 1)) {
                return q.a(context, wrapper3.getKeyword(), wrapper3.getPkgName(), a(wrapper3.getEnterId()));
            }
        }
        if (wrapper.getPath().equals("/home") && u.a(context, a.b(a.f7907a), 1)) {
            return q.a(context);
        }
        return false;
    }
}
