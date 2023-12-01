package com.danlan.android.cognition.collector;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.danlan.android.cognition.StringFog;
import com.danlan.android.cognition.collector.base.SubCollector;
import com.danlan.android.cognition.collector.util.SafeJSONObject;

/* loaded from: source-7206380-dex2jar.jar:com/danlan/android/cognition/collector/BatteryCollector.class */
public class BatteryCollector extends SubCollector {
    private static final String UNKNOWN = StringFog.decrypt("VE1PTU5USg==");
    private Context mcontext;

    public BatteryCollector(Context context, SafeJSONObject safeJSONObject) {
        super(context, safeJSONObject);
        this.mcontext = context;
    }

    private Intent getBatteryStatusIntent() {
        try {
            return this.mcontext.registerReceiver(null, new IntentFilter(StringFog.decrypt("QE1AUU5KQA9ITVBGT1cKQEJXTUxPDWZgdXdhcXh8Z2lgbWNmZQ==")));
        } catch (Exception e) {
            return null;
        }
    }

    @Override // com.danlan.android.cognition.collector.base.SubCollector
    public void doCollectAutomatically() {
        SafeJSONObject safeJSONObject = new SafeJSONObject();
        safeJSONObject.put(StringFog.decrypt("Q0JQV0RRXXFEUUdGT1c="), getBatteryPercent());
        safeJSONObject.put(StringFog.decrypt("Q0JQV0RRXWlEQkhXSQ=="), getBatteryHealth());
        safeJSONObject.put(StringFog.decrypt("Q0JQV0RRXXVEQExNTk9LRlg="), getBatteryTechnology());
        safeJSONObject.put(StringFog.decrypt("Q0JQV0RRXXVETlRGU0JQVFNG"), getBatteryTemperature());
        safeJSONObject.put(StringFog.decrypt("Q0JQV0RRXXdOT1BCRkY="), getBatteryVoltage());
        safeJSONObject.put(StringFog.decrypt("QktFUUZKSkZyTFFRQkY="), getChargingSource());
        safeJSONObject.put(StringFog.decrypt("SFB0S05NQWJJQlZESE1D"), isPhoneCharging());
        safeJSONObject.put(StringFog.decrypt("SFBmQlVXQVNYc1ZGUkZKVQ=="), isBatteryPresent());
        put(StringFog.decrypt("Q0JQV0RRXQ=="), safeJSONObject);
        collectDone();
    }

    public final String getBatteryHealth() {
        String str;
        Intent batteryStatusIntent = getBatteryStatusIntent();
        if (batteryStatusIntent == null) {
            return UNKNOWN;
        }
        switch (batteryStatusIntent.getIntExtra(StringFog.decrypt("SUZFT1VL"), 0)) {
            case 2:
                str = "RkxLRw==";
                break;
            case 3:
                str = "TlVBUX5LQUBV";
                break;
            case 4:
                str = "RUZFRw==";
                break;
            case 5:
                str = "TlVBUX5VS01VQkNG";
                break;
            case 6:
                str = "VE1XU0RATUdIRkB8R0JNTVRRQQ==";
                break;
            case 7:
                str = "QkxIRw==";
                break;
            default:
                return UNKNOWN;
        }
        return StringFog.decrypt(str);
    }

    public final int getBatteryPercent() {
        Intent batteryStatusIntent = getBatteryStatusIntent();
        if (batteryStatusIntent != null) {
            int intExtra = batteryStatusIntent.getIntExtra(StringFog.decrypt("TUZSRk0="), -1);
            int intExtra2 = batteryStatusIntent.getIntExtra(StringFog.decrypt("UkBFT0Q="), -1);
            if (intExtra < 0 || intExtra2 <= 0) {
                return -1;
            }
            return (intExtra * 100) / intExtra2;
        }
        return -1;
    }

    public final String getBatteryTechnology() {
        Intent batteryStatusIntent = getBatteryStatusIntent();
        return batteryStatusIntent != null ? batteryStatusIntent.getStringExtra(StringFog.decrypt("VUZHS09MSE5GWg==")) : UNKNOWN;
    }

    public final float getBatteryTemperature() {
        Intent batteryStatusIntent = getBatteryStatusIntent();
        if (batteryStatusIntent != null) {
            return (float) (batteryStatusIntent.getIntExtra(StringFog.decrypt("VUZJU0RRRVVUUUE="), 0) / 10.0d);
        }
        return -1.0f;
    }

    public final int getBatteryVoltage() {
        if (getBatteryStatusIntent() != null) {
            return getBatteryStatusIntent().getIntExtra(StringFog.decrypt("V0xIV0BEQQ=="), 0);
        }
        return -1;
    }

    public final String getChargingSource() {
        String str;
        Intent batteryStatusIntent = getBatteryStatusIntent();
        if (batteryStatusIntent == null) {
            return UNKNOWN;
        }
        int intExtra = batteryStatusIntent.getIntExtra(StringFog.decrypt("UU9RREZGQA=="), 0);
        if (intExtra == 1) {
            str = "QEA=";
        } else if (intExtra == 2) {
            str = "VFBG";
        } else if (intExtra != 4) {
            return UNKNOWN;
        } else {
            str = "VkpWRk1GV1I=";
        }
        return StringFog.decrypt(str);
    }

    public final boolean isBatteryPresent() {
        Intent batteryStatusIntent = getBatteryStatusIntent();
        if (batteryStatusIntent != null) {
            return batteryStatusIntent.getBooleanExtra(StringFog.decrypt("UVFBUERNUA=="), false);
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0029, code lost:
        if (r0 == 4) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean isPhoneCharging() {
        /*
            r4 = this;
            r0 = r4
            android.content.Intent r0 = r0.getBatteryStatusIntent()
            r8 = r0
            r0 = 0
            r7 = r0
            r0 = r7
            r6 = r0
            r0 = r8
            if (r0 == 0) goto L2e
            r0 = r8
            java.lang.String r1 = "UU9RREZGQA=="
            java.lang.String r1 = com.danlan.android.cognition.StringFog.decrypt(r1)
            r2 = 0
            int r0 = r0.getIntExtra(r1, r2)
            r5 = r0
            r0 = r5
            r1 = 1
            if (r0 == r1) goto L2c
            r0 = r5
            r1 = 2
            if (r0 == r1) goto L2c
            r0 = r7
            r6 = r0
            r0 = r5
            r1 = 4
            if (r0 != r1) goto L2e
        L2c:
            r0 = 1
            r6 = r0
        L2e:
            r0 = r6
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.danlan.android.cognition.collector.BatteryCollector.isPhoneCharging():boolean");
    }
}
