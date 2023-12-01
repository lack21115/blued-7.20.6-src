package com.bytedance.bdtracker;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.applog.ISensitiveInfoProvider;
import com.bytedance.applog.util.SensitiveUtils;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/w0.class */
public class w0 extends i0 {
    public final ISensitiveInfoProvider e;
    public final Context f;
    public final m0 g;
    public final n0 h;

    public w0(Context context, m0 m0Var, n0 n0Var, ISensitiveInfoProvider iSensitiveInfoProvider) {
        super(true, false);
        this.e = iSensitiveInfoProvider;
        this.f = context;
        this.g = m0Var;
        this.h = n0Var;
    }

    @Override // com.bytedance.bdtracker.i0
    public boolean a(JSONObject jSONObject) {
        String[] e;
        jSONObject.put(SensitiveUtils.KEY_BUILD_SERIAL, SensitiveUtils.getSerialNumber(this.f));
        n0.a(jSONObject, SensitiveUtils.KEY_ALIYUN_UUID, this.g.b.getAliyunUdid());
        if (this.g.b.isMacEnable()) {
            String macAddress = SensitiveUtils.getMacAddress(this.e, this.f);
            SharedPreferences sharedPreferences = this.g.e;
            String string = sharedPreferences.getString(SensitiveUtils.KEY_MAC, null);
            if (!TextUtils.isEmpty(macAddress)) {
                if (!TextUtils.equals(string, macAddress)) {
                    a.a(sharedPreferences, SensitiveUtils.KEY_MAC, macAddress);
                }
                jSONObject.put("mc", macAddress);
            } else if (!TextUtils.isEmpty(string)) {
                jSONObject.put("mc", string);
            }
        }
        n0.a(jSONObject, "udid", ((n2) this.h.g).f());
        JSONArray g = ((n2) this.h.g).g();
        if (SensitiveUtils.validMultiImei(g)) {
            jSONObject.put("udid_list", g);
        }
        n0.a(jSONObject, "serial_number", ((n2) this.h.g).d());
        if (!this.h.p() || (e = ((n2) this.h.g).e()) == null) {
            return true;
        }
        JSONArray jSONArray = new JSONArray();
        int length = e.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                jSONObject.put("sim_serial_number", jSONArray);
                return true;
            }
            jSONArray.put(new JSONObject().put("sim_serial_number", e[i2]));
            i = i2 + 1;
        }
    }
}
