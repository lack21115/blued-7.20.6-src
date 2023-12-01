package com.huawei.hms.framework.network.grs.g.j;

import android.content.Context;
import android.text.TextUtils;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.network.grs.GrsApp;
import com.huawei.hms.framework.network.grs.g.k.d;
import com.huawei.hms.framework.network.grs.h.c;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/framework/network/grs/g/j/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f22715a = "a";
    private static d b;

    public static d a(Context context) {
        synchronized (a.class) {
            try {
                d dVar = b;
                if (dVar != null) {
                    return dVar;
                }
                String a2 = c.a(GrsApp.getInstance().getBrand(BridgeUtil.SPLIT_MARK) + "grs_sdk_server_config.json", context);
                if (TextUtils.isEmpty(a2)) {
                    return null;
                }
                try {
                    JSONObject jSONObject = new JSONObject(a2).getJSONObject("grs_server");
                    JSONArray jSONArray = jSONObject.getJSONArray("grs_base_url");
                    ArrayList arrayList = null;
                    if (jSONArray != null) {
                        arrayList = null;
                        if (jSONArray.length() > 0) {
                            ArrayList arrayList2 = new ArrayList();
                            int i = 0;
                            while (true) {
                                int i2 = i;
                                arrayList = arrayList2;
                                if (i2 >= jSONArray.length()) {
                                    break;
                                }
                                arrayList2.add(jSONArray.get(i2).toString());
                                i = i2 + 1;
                            }
                        }
                    }
                    d dVar2 = new d();
                    b = dVar2;
                    dVar2.a(arrayList);
                    b.b(jSONObject.getString("grs_query_endpoint_1.0"));
                    b.a(jSONObject.getString("grs_query_endpoint_2.0"));
                    b.a(jSONObject.getInt("grs_query_timeout"));
                } catch (JSONException e) {
                    Logger.w(f22715a, "getGrsServerBean catch JSONException: %s", StringUtils.anonymizeMessage(e.getMessage()));
                }
                return b;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
