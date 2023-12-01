package com.tencent.turingcam;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.BatteryManager;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/turingcam/d5HOq.class */
public final class d5HOq {

    /* renamed from: a  reason: collision with root package name */
    private static final d5HOq f26129a = new d5HOq();
    private final List<wmqhz> b;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/turingcam/d5HOq$ShGzN.class */
    public static class ShGzN implements wmqhz {
        @Override // com.tencent.turingcam.d5HOq.wmqhz
        public void a(Context context, JSONObject jSONObject) throws JSONException {
            int i;
            try {
                Intent registerReceiver = context.registerReceiver(null, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
                if (registerReceiver == null || !TextUtils.equals(registerReceiver.getAction(), Intent.ACTION_BATTERY_CHANGED)) {
                    return;
                }
                int intExtra = registerReceiver.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);
                int intExtra2 = registerReceiver.getIntExtra(BatteryManager.EXTRA_SCALE, 100);
                int intExtra3 = registerReceiver.getIntExtra("status", -1);
                int intExtra4 = registerReceiver.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1);
                boolean z = intExtra3 == 2 || intExtra3 == 5;
                if (z && intExtra4 == 2) {
                    jSONObject.put("chargeState", 1);
                } else if (z && intExtra4 == 1) {
                    jSONObject.put("chargeState", 2);
                } else {
                    jSONObject.put("chargeState", 0);
                }
                if (intExtra2 != 0) {
                    i = (intExtra * 100) / intExtra2;
                    if (i < 0) {
                        i = 0;
                    }
                    if (i > 100) {
                        i = 100;
                    }
                } else {
                    i = -1;
                }
                jSONObject.put("batterLevel", i);
            } catch (Throwable th) {
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/turingcam/d5HOq$SkEpO.class */
    public static class SkEpO implements wmqhz {
        @Override // com.tencent.turingcam.d5HOq.wmqhz
        public void a(Context context, JSONObject jSONObject) throws JSONException {
            Ringtone ringtone;
            Object property = System.getProperty("ro.config.ringtone");
            if (property != null) {
                jSONObject.put("defaultRingTone", property);
            }
            Uri uriFor = Settings.System.getUriFor("DEFAULT_RINGTONE_URI");
            if (uriFor == null || (ringtone = RingtoneManager.getRingtone(context, uriFor)) == null) {
                return;
            }
            String title = ringtone.getTitle(context);
            if (TextUtils.isEmpty(title)) {
                return;
            }
            jSONObject.put("defaultRingTone", title);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/turingcam/d5HOq$spXPg.class */
    public static class spXPg implements wmqhz {
        @Override // com.tencent.turingcam.d5HOq.wmqhz
        public void a(Context context, JSONObject jSONObject) throws JSONException {
            jSONObject.put("bootTime", System.currentTimeMillis() - SystemClock.elapsedRealtime());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/turingcam/d5HOq$wmqhz.class */
    public interface wmqhz {
        void a(Context context, JSONObject jSONObject) throws JSONException;
    }

    private d5HOq() {
        ArrayList arrayList = new ArrayList();
        this.b = arrayList;
        arrayList.add(new ShGzN());
        arrayList.add(new spXPg());
        arrayList.add(new SkEpO());
    }

    public static d5HOq a() {
        return f26129a;
    }

    public JSONObject a(Context context) {
        if (context == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        for (wmqhz wmqhzVar : this.b) {
            try {
                wmqhzVar.a(context, jSONObject);
            } catch (Exception e) {
            }
        }
        return jSONObject;
    }
}
