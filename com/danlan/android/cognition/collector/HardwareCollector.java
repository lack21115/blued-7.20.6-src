package com.danlan.android.cognition.collector;

import android.content.Context;
import android.nfc.NfcAdapter;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.danlan.android.cognition.CacheDataManager;
import com.danlan.android.cognition.NativeLib;
import com.danlan.android.cognition.StringFog;
import com.danlan.android.cognition.collector.base.SubCollector;
import com.danlan.android.cognition.collector.util.PermissionUtil;
import com.danlan.android.cognition.collector.util.SafeJSONObject;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7206380-dex2jar.jar:com/danlan/android/cognition/collector/HardwareCollector.class */
public class HardwareCollector extends SubCollector {
    private Context mcontext;
    private final PermissionUtil permissionUtils;

    public HardwareCollector(Context context, SafeJSONObject safeJSONObject) {
        super(context, safeJSONObject);
        this.mcontext = context;
        this.permissionUtils = new PermissionUtil(context);
    }

    @Override // com.danlan.android.cognition.collector.base.SubCollector
    public void doCollectAutomatically() {
        SafeJSONObject safeJSONObject = new SafeJSONObject();
        safeJSONObject.put(StringFog.decrypt("TExARk0="), getModel());
        safeJSONObject.put(StringFog.decrypt("UVFLR1RAUA=="), getProduct());
        safeJSONObject.put(StringFog.decrypt("Q1FFTUU="), getBuildBrand());
        safeJSONObject.put(StringFog.decrypt("TEJKVkdCR1VUUUFR"), getManufacturer());
        safeJSONObject.put(StringFog.decrypt("SUJWR1ZCVkQ="), getHardware());
        safeJSONObject.put(StringFog.decrypt("U0JASk51QVNSSktN"), getRadioVer());
        safeJSONObject.put(StringFog.decrypt("Q0xFUUVzSEBVRUtRTA=="), getBoardPlatform());
        safeJSONObject.put(StringFog.decrypt("UkZWSkBP"), getSerial());
        safeJSONObject.put(StringFog.decrypt("RUpXU01CXXdEUVdKTk0="), getDisplayVersion());
        safeJSONObject.put(StringFog.decrypt("RUZSSkJG"), getDevice());
        safeJSONObject.put(StringFog.decrypt("SFBqRUJzVkRSRkpX"), isNfcPresent());
        safeJSONObject.put(StringFog.decrypt("SFBqRUJmSkBDT0FH"), isNfcEnabled());
        safeJSONObject.put(StringFog.decrypt("SFBiSk9EQVNyVlRTTlFQ"), isFingerSupport());
        safeJSONObject.put(StringFog.decrypt("SFBmT1RGUE5OV0xwVFNUTlNX"), isBluetoothSupport());
        safeJSONObject.put(StringFog.decrypt("SFB3V0RTZ05UTVBGU3BRUVFMVlc="), isStepCounterSupport());
        safeJSONObject.put(StringFog.decrypt("SFBrU0RNY21kcHdWUVNLU1U="), isOpenGLESSupport());
        safeJSONObject.put(StringFog.decrypt("TEJHak9FSw=="), getMacInfo2());
        safeJSONObject.put(StringFog.decrypt("SE5BSg=="), "");
        safeJSONObject.put(StringFog.decrypt("UUtLTUR3XVFE"), getPhoneType());
        safeJSONObject.put(StringFog.decrypt("VFBGcFVCUEQ="), getUsbState());
        safeJSONObject.put(StringFog.decrypt("Q0JXRkNCSkU="), getBaseband());
        safeJSONObject.put(StringFog.decrypt("RlBJcVNPckRTUE1MTw=="), getGsmRilVersion());
        safeJSONObject.put(StringFog.decrypt("SFB3VlFTS1NVd0FPRHNMTk9a"), isSupportTelePhony());
        put(StringFog.decrypt("SUJWR1ZCVkQ="), safeJSONObject);
        collectDone();
    }

    public final String getBaseband() {
        return NativeLib.checkLoadSo() ? NativeLib.pg(StringFog.decrypt("U0wKQUBQQUNATUA="), StringFog.decrypt("VE1PTU5USg==")) : StringFog.decrypt("VE1PTU5USg==");
    }

    public final String getBoardPlatform() {
        return NativeLib.checkLoadSo() ? NativeLib.pg(StringFog.decrypt("U0wKQU5CVkUPU0hCVUVLU0w="), StringFog.decrypt("VE1PTU5USg==")) : StringFog.decrypt("VE1PTU5USg==");
    }

    public final String getBuildBrand() {
        return NativeLib.checkLoadSo() ? NativeLib.pg(StringFog.decrypt("U0wKU1NMQFRCVwpBU0JKRQ=="), StringFog.decrypt("VE1PTU5USg==")) : StringFog.decrypt("VE1PTU5USg==");
    }

    public final String getDevice() {
        return NativeLib.checkLoadSo() ? NativeLib.pg(StringFog.decrypt("U0wKU1NMQFRCVwpHRFVNQkQ="), StringFog.decrypt("VE1PTU5USg==")) : StringFog.decrypt("VE1PTU5USg==");
    }

    public final String getDisplayVersion() {
        return NativeLib.checkLoadSo() ? NativeLib.pg(StringFog.decrypt("U0wKQVRKSEUPR01QUU9FWA9KQA=="), StringFog.decrypt("VE1PTU5USg==")) : StringFog.decrypt("VE1PTU5USg==");
    }

    public final String getGsmRilVersion() {
        return NativeLib.checkLoadSo() ? NativeLib.pg(StringFog.decrypt("RlBJDVdGVlJITEoNU0pIDEhOVE8="), StringFog.decrypt("VE1PTU5USg==")) : StringFog.decrypt("VE1PTU5USg==");
    }

    public final String getHardware() {
        return NativeLib.checkLoadSo() ? NativeLib.pg(StringFog.decrypt("U0wKS0BRQFZAUUE="), StringFog.decrypt("VE1PTU5USg==")) : StringFog.decrypt("VE1PTU5USg==");
    }

    public final String getIMEI() {
        TelephonyManager telephonyManager;
        if (!this.permissionUtils.isPermissionGranted(StringFog.decrypt("QE1AUU5KQA9RRlZOSFBXSE5NCnFkYmB+cWtrbWR8d3Vgd2E=")) || (telephonyManager = (TelephonyManager) this.mcontext.getSystemService(StringFog.decrypt("UUtLTUQ="))) == null) {
            return null;
        }
        try {
            return telephonyManager.getDeviceId();
        } catch (Exception e) {
            return "";
        }
    }

    public final JSONArray getMacInfo2() {
        JSONArray jSONArray = new JSONArray();
        try {
            JSONArray jSONArray2 = new JSONArray(NativeLib.checkLoadSo() ? NativeLib.gm() : "");
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= jSONArray2.length()) {
                    break;
                }
                JSONObject jSONObject = (JSONObject) jSONArray2.get(i2);
                if (jSONObject.has(StringFog.decrypt("Vk9FTRE="))) {
                    String string = jSONObject.getString(StringFog.decrypt("Vk9FTRE="));
                    int i3 = jSONObject.getInt(StringFog.decrypt("R09FRA=="));
                    String readCacheMac = CacheDataManager.readCacheMac(this.mcontext, StringFog.decrypt("QBI="));
                    if (!TextUtils.isEmpty(readCacheMac) && !readCacheMac.equals(StringFog.decrypt("RUZCQlRPUA=="))) {
                        jSONObject.put(StringFog.decrypt("Vk9FTRE="), readCacheMac);
                        jSONObject.put(StringFog.decrypt("R09FRA=="), 1);
                    } else if (readCacheMac.equals(StringFog.decrypt("RUZCQlRPUA==")) && !TextUtils.isEmpty(string) && i3 == 1) {
                        CacheDataManager.putCacheMac(this.mcontext, StringFog.decrypt("QBI="), string);
                    }
                }
                jSONArray.put(jSONObject);
                i = i2 + 1;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONArray;
    }

    public final String getManufacturer() {
        return NativeLib.checkLoadSo() ? NativeLib.pg(StringFog.decrypt("U0wKU1NMQFRCVwpOQE1RR0BAUFZTRlY="), StringFog.decrypt("VE1PTU5USg==")) : StringFog.decrypt("VE1PTU5USg==");
    }

    public final String getModel() {
        return NativeLib.checkLoadSo() ? NativeLib.pg(StringFog.decrypt("U0wKU1NMQFRCVwpOTkdBTQ=="), StringFog.decrypt("VE1PTU5USg==")) : StringFog.decrypt("VE1PTU5USg==");
    }

    public final String getPhoneType() {
        TelephonyManager telephonyManager = (TelephonyManager) this.mcontext.getSystemService(StringFog.decrypt("UUtLTUQ="));
        int phoneType = telephonyManager != null ? telephonyManager.getPhoneType() : 0;
        return StringFog.decrypt(phoneType != 1 ? phoneType != 2 ? "VE1PTU5USg==" : "QkdJQg==" : "RlBJ");
    }

    public final String getProduct() {
        return NativeLib.checkLoadSo() ? NativeLib.pg(StringFog.decrypt("U0wKU1NMQFRCVwpNQE5B"), StringFog.decrypt("VE1PTU5USg==")) : StringFog.decrypt("VE1PTU5USg==");
    }

    public final String getRadioVer() {
        return NativeLib.checkLoadSo() ? NativeLib.pg(StringFog.decrypt("RlBJDVdGVlJITEoNQ0JXRENCSkc="), StringFog.decrypt("VE1PTU5USg==")) : StringFog.decrypt("VE1PTU5USg==");
    }

    public final String getSerial() {
        return this.permissionUtils.isPermissionGranted(StringFog.decrypt("QE1AUU5KQA9RRlZOSFBXSE5NCnFkYmB+cWtrbWR8d3Vgd2E=")) ? StringFog.decrypt("VE1PTU5USg==") : StringFog.decrypt("VE1PTU5USg==");
    }

    public final String getUsbState() {
        return NativeLib.checkLoadSo() ? NativeLib.pg(StringFog.decrypt("UlpXDVRQRg9SV0VXRA=="), StringFog.decrypt("VE1PTU5USg==")) : StringFog.decrypt("VE1PTU5USg==");
    }

    public final boolean isBluetoothSupport() {
        try {
            return this.mcontext.getPackageManager().hasSystemFeature(StringFog.decrypt("QE1AUU5KQA9JQlZHVkJWRA9BSFZEV0tOVUs="));
        } catch (Exception e) {
            return false;
        }
    }

    public final boolean isFingerSupport() {
        return this.mcontext.getPackageManager().hasSystemFeature(StringFog.decrypt("QE1AUU5KQA9JQlZHVkJWRA9NQkA="));
    }

    public final Boolean isNfcEnabled() {
        if (Build.VERSION.SDK_INT < 10) {
            return Boolean.FALSE;
        }
        NfcAdapter defaultAdapter = NfcAdapter.getDefaultAdapter(this.mcontext);
        return Boolean.valueOf(defaultAdapter != null && defaultAdapter.isEnabled());
    }

    public final Boolean isNfcPresent() {
        if (Build.VERSION.SDK_INT < 10) {
            return Boolean.FALSE;
        }
        return Boolean.valueOf(NfcAdapter.getDefaultAdapter(this.mcontext) != null);
    }

    public final boolean isOpenGLESSupport() {
        return this.mcontext.getPackageManager().hasSystemFeature(StringFog.decrypt("QE1AUU5KQA9JQlZHVkJWRA9MVEZPREhEUg1FRlE="));
    }

    public final boolean isStepCounterSupport() {
        return this.mcontext.getPackageManager().hasSystemFeature(StringFog.decrypt("QE1AUU5KQA9JQlZHVkJWRA9QQU1STFYPUldBU0JMUU9VRlY="));
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public int isSupportTelePhony() {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
}
