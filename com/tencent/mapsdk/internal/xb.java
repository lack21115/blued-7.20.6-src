package com.tencent.mapsdk.internal;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.map.tools.Util;
import com.tencent.map.tools.net.NetMethod;
import com.tencent.map.tools.net.NetRequest;
import com.tencent.map.tools.net.processor.RequestProcessor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/xb.class */
public class xb implements RequestProcessor {
    public static final /* synthetic */ boolean b = !xb.class.desiredAssertionStatus();

    /* renamed from: a  reason: collision with root package name */
    private final String f38109a;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/xb$a.class */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f38110a;

        static {
            NetMethod.values();
            int[] iArr = new int[4];
            f38110a = iArr;
            try {
                NetMethod netMethod = NetMethod.GET;
                iArr[1] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                int[] iArr2 = f38110a;
                NetMethod netMethod2 = NetMethod.POST;
                iArr2[0] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    private xb(String str) {
        this.f38109a = str;
    }

    public static xb a(String str) {
        return new xb(str);
    }

    public void a(NetRequest netRequest, String str) {
        if (netRequest == null || TextUtils.isEmpty(str)) {
            return;
        }
        Uri parse = Uri.parse(netRequest.url);
        HashMap hashMap = new HashMap();
        int ordinal = netRequest.mNetMethod.ordinal();
        if (ordinal == 0) {
            byte[] bArr = netRequest.postData;
            if (bArr == null || bArr.length > 0) {
                try {
                    JSONObject jSONObject = new JSONObject(new String(netRequest.postData));
                    JSONArray names = jSONObject.names();
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= names.length()) {
                            break;
                        }
                        String optString = names.optString(i2);
                        hashMap.put(optString, jSONObject.opt(optString));
                        i = i2 + 1;
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        } else if (ordinal == 1) {
            String query = parse.getQuery();
            if (!TextUtils.isEmpty(query)) {
                if (!b && query == null) {
                    throw new AssertionError();
                }
                String[] split = query.split("&");
                int length = split.length;
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= length) {
                        break;
                    }
                    String str2 = split[i4];
                    String[] split2 = str2.split("=");
                    split2[1] = str2.substring(split2[0].length() + 1);
                    hashMap.put(split2[0], split2[1]);
                    i3 = i4 + 1;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(parse.getPath());
        sb.append("?");
        if (!hashMap.isEmpty()) {
            ArrayList arrayList = new ArrayList(hashMap.keySet());
            Collections.sort(arrayList);
            int i5 = 0;
            while (true) {
                int i6 = i5;
                if (i6 >= arrayList.size()) {
                    break;
                }
                String str3 = (String) arrayList.get(i6);
                Object obj = hashMap.get(str3);
                if (obj != null) {
                    if (i6 == arrayList.size() - 1) {
                        sb.append(str3);
                        sb.append("=");
                        sb.append(obj.toString());
                    } else {
                        sb.append(str3);
                        sb.append("=");
                        sb.append(obj.toString());
                        sb.append("&");
                    }
                }
                i5 = i6 + 1;
            }
        }
        sb.append(str);
        netRequest.url = parse.buildUpon().appendQueryParameter("sig", Util.getMD5String(sb.toString())).build().toString();
    }

    @Override // com.tencent.map.tools.net.processor.RequestProcessor
    public void onRequest(NetRequest netRequest) {
        a(netRequest, this.f38109a);
    }
}
