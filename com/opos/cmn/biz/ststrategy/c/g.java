package com.opos.cmn.biz.ststrategy.c;

import android.content.Context;
import android.text.TextUtils;
import com.opos.cmn.biz.ststrategy.entity.STConfigEntity;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/biz/ststrategy/c/g.class */
public class g {
    public static STConfigEntity a(Context context) {
        if (context != null) {
            com.opos.cmn.an.f.a.b("WrapSTConfigUtil", "st config read form file");
            JSONObject b = e.b(context);
            if (b != null) {
                return a(b);
            }
            return null;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:286:0x06b4  */
    /* JADX WARN: Removed duplicated region for block: B:287:0x06bc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.opos.cmn.biz.ststrategy.entity.STConfigEntity a(org.json.JSONObject r4) {
        /*
            Method dump skipped, instructions count: 1759
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.cmn.biz.ststrategy.c.g.a(org.json.JSONObject):com.opos.cmn.biz.ststrategy.entity.STConfigEntity");
    }

    private static List<String> a(String str) {
        ArrayList arrayList;
        if (!f.a(str)) {
            ArrayList arrayList2 = new ArrayList();
            StringTokenizer stringTokenizer = new StringTokenizer(str, ",");
            while (true) {
                arrayList = arrayList2;
                if (!stringTokenizer.hasMoreTokens()) {
                    break;
                }
                arrayList2.add(stringTokenizer.nextToken().trim());
            }
        } else {
            arrayList = null;
        }
        return arrayList;
    }

    private static String b(String str) {
        String str2 = "";
        if (!TextUtils.isEmpty(str)) {
            try {
                str2 = com.opos.cmn.an.a.d.b(str);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("WrapSTConfigUtil", "", e);
                str2 = "";
            }
        }
        com.opos.cmn.an.f.a.b("WrapSTConfigUtil", "urlDecodeString before:" + str + ",after:" + str2);
        return str2;
    }
}
