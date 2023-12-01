package com.bytedance.bdtracker;

import android.webkit.WebView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.applog.IAppLogInstance;
import com.bytedance.bdtracker.l1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/m1.class */
public class m1 {
    public static int f;
    public static Map<String, Double> g = new HashMap();

    /* renamed from: a  reason: collision with root package name */
    public double f21258a;
    public WebView b;

    /* renamed from: c  reason: collision with root package name */
    public int[] f21259c = new int[2];
    public final boolean d;
    public final IAppLogInstance e;

    public m1(IAppLogInstance iAppLogInstance, WebView webView, boolean z) {
        this.e = iAppLogInstance;
        this.b = webView;
        this.d = z;
    }

    public final l1.b a(JSONObject jSONObject) {
        String optString = jSONObject.optString("nodeName");
        JSONObject optJSONObject = jSONObject.optJSONObject(TypedValues.AttributesType.S_FRAME);
        l1.a aVar = new l1.a((int) ((optJSONObject.optInt("x") * this.f21258a) + (this.d ? 0 : this.f21259c[0])), (int) ((optJSONObject.optInt("y") * this.f21258a) + (this.d ? 0 : this.f21259c[1])), (int) (optJSONObject.optInt("width") * this.f21258a), (int) (optJSONObject.optInt("height") * this.f21258a));
        String optString2 = jSONObject.optString("_element_path");
        String optString3 = jSONObject.optString("element_path");
        JSONArray optJSONArray = jSONObject.optJSONArray("positions");
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= optJSONArray.length()) {
                break;
            }
            arrayList.add(optJSONArray.optString(i2));
            i = i2 + 1;
        }
        int optInt = jSONObject.optInt("zIndex");
        JSONArray optJSONArray2 = jSONObject.optJSONArray("texts");
        ArrayList arrayList2 = new ArrayList();
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= optJSONArray2.length()) {
                break;
            }
            arrayList2.add(optJSONArray2.optString(i4));
            i3 = i4 + 1;
        }
        String optString4 = jSONObject.optString("href");
        boolean optBoolean = jSONObject.optBoolean("_checkList");
        JSONArray optJSONArray3 = jSONObject.optJSONArray("fuzzy_positions");
        ArrayList arrayList3 = new ArrayList();
        if (optJSONArray3 != null) {
            int i5 = 0;
            while (true) {
                int i6 = i5;
                if (i6 >= optJSONArray3.length()) {
                    break;
                }
                arrayList3.add(optJSONArray3.optString(i6));
                i5 = i6 + 1;
            }
        }
        JSONArray optJSONArray4 = jSONObject.optJSONArray("children");
        ArrayList arrayList4 = new ArrayList();
        if (optJSONArray4 != null && optJSONArray4.length() > 0) {
            int i7 = 0;
            while (true) {
                int i8 = i7;
                if (i8 >= optJSONArray4.length()) {
                    break;
                }
                arrayList4.add(a(optJSONArray4.optJSONObject(i8)));
                i7 = i8 + 1;
            }
        }
        return new l1.b(optString, aVar, optString2, optString3, arrayList, optInt, arrayList2, arrayList4, optString4, optBoolean, arrayList3);
    }
}
