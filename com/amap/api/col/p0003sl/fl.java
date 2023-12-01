package com.amap.api.col.p0003sl;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.help.InputtipsQuery;
import com.amap.api.services.help.Tip;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.amap.api.col.3sl.fl  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/fl.class */
public final class fl extends ex<InputtipsQuery, ArrayList<Tip>> {
    public fl(Context context, InputtipsQuery inputtipsQuery) {
        super(context, inputtipsQuery);
    }

    private static ArrayList<Tip> c(String str) throws AMapException {
        try {
            return fm.h(new JSONObject(str));
        } catch (JSONException e) {
            fe.a(e, "InputtipsHandler", "paseJSON");
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.col.p0003sl.ex, com.amap.api.col.p0003sl.ew
    public final /* synthetic */ Object a(String str) throws AMapException {
        return c(str);
    }

    @Override // com.amap.api.col.p0003sl.ex, com.amap.api.col.p0003sl.ew
    protected final String c() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("output=json");
        String b = b(((InputtipsQuery) this.b).getKeyword());
        if (!TextUtils.isEmpty(b)) {
            stringBuffer.append("&keywords=");
            stringBuffer.append(b);
        }
        String city = ((InputtipsQuery) this.b).getCity();
        if (!fm.g(city)) {
            String b2 = b(city);
            stringBuffer.append("&city=");
            stringBuffer.append(b2);
        }
        String type = ((InputtipsQuery) this.b).getType();
        if (!fm.g(type)) {
            String b3 = b(type);
            stringBuffer.append("&type=");
            stringBuffer.append(b3);
        }
        if (((InputtipsQuery) this.b).getCityLimit()) {
            stringBuffer.append("&citylimit=true");
        } else {
            stringBuffer.append("&citylimit=false");
        }
        LatLonPoint location = ((InputtipsQuery) this.b).getLocation();
        if (location != null) {
            stringBuffer.append("&location=");
            stringBuffer.append(location.getLongitude());
            stringBuffer.append(",");
            stringBuffer.append(location.getLatitude());
        }
        stringBuffer.append("&key=");
        stringBuffer.append(ho.f(this.i));
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.p0003sl.kb
    public final String getURL() {
        return fd.a() + "/assistant/inputtips?";
    }
}
