package com.opos.mobad.model.d;

import android.content.Context;
import android.text.TextUtils;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.cdo.oaps.ad.OapsWrapper;
import com.opos.cmn.biz.web.a.b.a;
import com.opos.cmn.biz.web.a.b.b;
import com.opos.cmn.func.b.b.d;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/model/d/u.class */
public class u {
    private static final void a(final Context context, final String str) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.model.d.u.1
            @Override // java.lang.Runnable
            public void run() {
                URI create;
                try {
                    String str2 = create.getScheme() + "://" + create.getHost();
                    String str3 = str2;
                    if (URI.create(String.this).getPort() > 0) {
                        str3 = str2 + ":" + create.getPort();
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("Route-Data", com.opos.cmn.biz.a.e.a(context));
                    com.opos.cmn.func.b.b.e a2 = com.opos.cmn.func.b.b.b.a().a(context, new d.a().a(hashMap).a("GET").b(String.this).a());
                    com.opos.cmn.an.f.a.b("WebPrepare", "get code:" + a2.f24862a);
                    if (a2 == null || 200 != a2.f24862a) {
                        return;
                    }
                    String a3 = com.opos.mobad.model.e.c.a(a2.f24863c);
                    com.opos.cmn.an.f.a.b("WebPrepare", "get data:" + a3);
                    JSONArray jSONArray = new JSONArray(a3);
                    if (jSONArray.length() <= 0) {
                        return;
                    }
                    ArrayList arrayList = new ArrayList(jSONArray.length());
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= jSONArray.length()) {
                            u.b(arrayList);
                            return;
                        }
                        JSONObject jSONObject = jSONArray.getJSONObject(i2);
                        arrayList.add(new a.C0633a().a(u.b(jSONObject.getString(OapsWrapper.KEY_PATH), str3)).b(jSONObject.getString("md5")).a());
                        i = i2 + 1;
                    }
                } catch (Throwable th) {
                    com.opos.cmn.an.f.a.b("WebPrepare", "get resouce fail:", th);
                }
            }
        });
    }

    public static final void a(Context context, String str, List<String> list) {
        ArrayList arrayList;
        com.opos.cmn.biz.web.a.b.c.a().a(context, new b.a().a());
        if (list != null && list.size() > 0) {
            ArrayList arrayList2 = new ArrayList(list.size());
            Iterator<String> it = list.iterator();
            while (true) {
                arrayList = arrayList2;
                if (!it.hasNext()) {
                    break;
                }
                arrayList2.add(new a.C0633a().a(it.next()).a());
            }
        } else {
            arrayList = null;
        }
        b(arrayList);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        a(context, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String b(String str, String str2) {
        String str3 = str;
        if (!str.startsWith("http")) {
            if (str.startsWith("https")) {
                return str;
            }
            str3 = str2 + BridgeUtil.SPLIT_MARK + str;
        }
        return str3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(List<com.opos.cmn.biz.web.a.b.a> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        com.opos.cmn.an.f.a.b("WebPrepare", "cache size:" + list.size());
        com.opos.cmn.biz.web.a.b.c.a().a(list);
    }
}
