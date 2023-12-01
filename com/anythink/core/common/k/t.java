package com.anythink.core.common.k;

import com.anythink.core.common.e.ai;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/k/t.class */
public final class t {
    public static boolean a(ai aiVar) {
        return aiVar.c() == 15 && !aiVar.j();
    }

    public static boolean a(String str, ai aiVar) {
        if (aiVar == null) {
            return false;
        }
        if (com.anythink.core.common.a.a().a(str, aiVar) != null) {
            return true;
        }
        com.anythink.core.common.e.m a2 = com.anythink.core.b.f.a().a(aiVar);
        return (a2 == null || a2.a()) ? false : true;
    }

    public static boolean a(List<ai> list) {
        if (list == null) {
            return false;
        }
        int size = list.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return false;
            }
            ai aiVar = list.get(i2);
            if (aiVar != null && aiVar.aa()) {
                return true;
            }
            i = i2 + 1;
        }
    }

    private static boolean b(ai aiVar) {
        if (aiVar == null) {
            return false;
        }
        return aiVar.c() == 66 || aiVar.c() == 6;
    }
}
