package com.danlan.android.cognition.collector;

import android.content.ContentResolver;
import android.content.Context;
import android.net.wifi.WifiInfo;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import com.danlan.android.cognition.NativeLib;
import com.danlan.android.cognition.StringFog;
import com.danlan.android.cognition.collector.base.SubCollector;
import com.danlan.android.cognition.collector.util.SafeJSONObject;
import java.lang.reflect.Method;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7206380-dex2jar.jar:com/danlan/android/cognition/collector/RiskCollector.class */
public class RiskCollector extends SubCollector {
    private Context mcontext;

    public RiskCollector(Context context, SafeJSONObject safeJSONObject) {
        super(context, safeJSONObject);
        this.mcontext = context;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public int checkAmsProxy() {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public final SafeJSONObject checkApiNative() {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    public final JSONArray checkApiRisk() {
        JSONArray jSONArray = new JSONArray();
        try {
            String ac = NativeLib.checkLoadSo() ? NativeLib.ac(WifiInfo.class.getDeclaredMethod(StringFog.decrypt("RkZQbkBAZUVFUUFQUg=="), new Class[0])) : null;
            if (ac != null) {
                JSONObject jSONObject = new JSONObject(ac);
                jSONObject.put(StringFog.decrypt("T0JJRg=="), StringFog.decrypt("dkpCSmhNQk4MHUNGVW5FQmBHQFFEUFc="));
                jSONArray.put(jSONObject);
            }
        } catch (NoSuchMethodException | JSONException e) {
            e.printStackTrace();
        }
        try {
            String ac2 = NativeLib.checkLoadSo() ? NativeLib.ac(Settings.Secure.class.getDeclaredMethod(StringFog.decrypt("RkZQcFVRTU9G"), ContentResolver.class, String.class)) : null;
            if (ac2 != null) {
                JSONObject jSONObject2 = new JSONObject(ac2);
                jSONObject2.put(StringFog.decrypt("T0JJRg=="), StringFog.decrypt("ckZQV0hNQ1IFcEFAVFFBDB9EQVdyV1ZIT0Q="));
                jSONArray.put(jSONObject2);
            }
        } catch (NoSuchMethodException | JSONException e2) {
            e2.printStackTrace();
        }
        try {
            if (Build.VERSION.SDK_INT < 31) {
                Method declaredMethod = TelephonyManager.class.getDeclaredMethod(StringFog.decrypt("RkZQZ0RVTUJEakA="), new Class[0]);
                String str = null;
                if (NativeLib.checkLoadSo()) {
                    str = NativeLib.ac(declaredMethod);
                }
                if (str != null) {
                    JSONObject jSONObject3 = new JSONObject(str);
                    jSONObject3.put(StringFog.decrypt("T0JJRg=="), StringFog.decrypt("dUZIRlFLS09YbkVNQERBUwwdQ0ZVZ0FXSEBBakU="));
                    jSONArray.put(jSONObject3);
                    return jSONArray;
                }
            }
        } catch (NoSuchMethodException | JSONException e3) {
            e3.printStackTrace();
        }
        return jSONArray;
    }

    /* JADX WARN: Code restructure failed: missing block: B:101:0x028f, code lost:
        if (r0.contains(com.danlan.android.cognition.StringFog.decrypt("VVdybn5bHBc=")) != false) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x030c, code lost:
        if (r0.contains(com.danlan.android.cognition.StringFog.decrypt("RkZKRlNKRw5XQUtbGRVUDldBS1sZFVQ=")) != false) goto L116;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00f1, code lost:
        if (r0.contains(com.danlan.android.cognition.StringFog.decrypt("dUpFTVVKRU93bg==")) != false) goto L131;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x013f, code lost:
        if (r0.contains(com.danlan.android.cognition.StringFog.decrypt("YE1AWg==")) != false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x01c9, code lost:
        if (r0.contains(com.danlan.android.cognition.StringFog.decrypt("QFFNRlI=")) != false) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0246, code lost:
        if (r0.equals(com.danlan.android.cognition.StringFog.decrypt("YE1AUU5KQAFyZ28DQ1ZNTVUDQkxTA1wZFw==")) != false) goto L86;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean checkEmulator2() {
        /*
            Method dump skipped, instructions count: 896
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.danlan.android.cognition.collector.RiskCollector.checkEmulator2():boolean");
    }

    @Override // com.danlan.android.cognition.collector.base.SubCollector
    public void doCollectAutomatically() {
        SafeJSONObject safeJSONObject = new SafeJSONObject();
        safeJSONObject.put(StringFog.decrypt("U0xLV2dPRUY="), getRootFlag());
        safeJSONObject.put(StringFog.decrypt("RE5RT0BXS1NnT0VE"), getEmulatorFlag(this.mcontext));
        safeJSONObject.put(StringFog.decrypt("RE5RT0BXS1NnT0VEEw=="), checkEmulator2());
        safeJSONObject.put(StringFog.decrypt("SUxLSGdPRUY="), getHookFlag());
        safeJSONObject.put(StringFog.decrypt("U0pXSGBTTQ=="), checkApiRisk());
        safeJSONObject.put(StringFog.decrypt("QE5Xc1NMXFg="), checkAmsProxy());
        safeJSONObject.put(StringFog.decrypt("QFNNbUBXTVdE"), checkApiNative());
        put(StringFog.decrypt("U0pXSA=="), safeJSONObject);
        collectDone();
    }

    public final SafeJSONObject getEmulatorFlag(Context context) {
        SafeJSONObject safeJSONObject = new SafeJSONObject();
        String ce = NativeLib.checkLoadSo() ? NativeLib.ce(context) : null;
        if (ce != null) {
            safeJSONObject.put(StringFog.decrypt("R09FRA=="), 1);
            safeJSONObject.put(StringFog.decrypt("U0ZFUE5N"), ce);
            return safeJSONObject;
        }
        safeJSONObject.put(StringFog.decrypt("R09FRA=="), 0);
        safeJSONObject.put(StringFog.decrypt("U0ZFUE5N"), "");
        return safeJSONObject;
    }

    public final SafeJSONObject getHookFlag() {
        SafeJSONObject safeJSONObject = new SafeJSONObject();
        String ck = NativeLib.checkLoadSo() ? NativeLib.ck() : null;
        if (ck != null) {
            safeJSONObject.put(StringFog.decrypt("R09FRA=="), 1);
            safeJSONObject.put(StringFog.decrypt("U0ZFUE5N"), ck);
            return safeJSONObject;
        }
        safeJSONObject.put(StringFog.decrypt("R09FRA=="), 0);
        safeJSONObject.put(StringFog.decrypt("U0ZFUE5N"), "");
        return safeJSONObject;
    }

    public final SafeJSONObject getRootFlag() {
        SafeJSONObject safeJSONObject = new SafeJSONObject();
        String cr = NativeLib.checkLoadSo() ? NativeLib.cr() : null;
        if (cr != null) {
            safeJSONObject.put(StringFog.decrypt("R09FRA=="), 1);
            safeJSONObject.put(StringFog.decrypt("U0ZFUE5N"), cr);
            return safeJSONObject;
        }
        safeJSONObject.put(StringFog.decrypt("R09FRA=="), 0);
        safeJSONObject.put(StringFog.decrypt("U0ZFUE5N"), "");
        return safeJSONObject;
    }
}
