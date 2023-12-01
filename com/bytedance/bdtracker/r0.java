package com.bytedance.bdtracker;

import android.content.Context;
import android.media.TtmlUtils;
import com.ss.android.download.api.constant.BaseConstants;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONObject;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/r0.class */
public class r0 extends i0 {
    public final Context e;

    public r0(Context context) {
        super(true, true);
        this.e = context;
    }

    @Override // com.bytedance.bdtracker.i0
    public boolean a(JSONObject jSONObject) {
        n0.a(jSONObject, "language", this.e.getResources().getConfiguration().locale.getLanguage());
        int rawOffset = TimeZone.getDefault().getRawOffset() / BaseConstants.Time.HOUR;
        int i = rawOffset;
        if (rawOffset < -12) {
            i = -12;
        }
        int i2 = i;
        if (i > 12) {
            i2 = 12;
        }
        jSONObject.put("timezone", i2);
        n0.a(jSONObject, TtmlUtils.TAG_REGION, Locale.getDefault().getCountry());
        TimeZone timeZone = Calendar.getInstance().getTimeZone();
        n0.a(jSONObject, "tz_name", timeZone.getID());
        jSONObject.put("tz_offset", timeZone.getOffset(System.currentTimeMillis()) / 1000);
        return true;
    }
}
