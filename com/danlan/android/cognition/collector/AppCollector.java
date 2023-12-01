package com.danlan.android.cognition.collector;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.danlan.android.cognition.NativeLib;
import com.danlan.android.cognition.StringFog;
import com.danlan.android.cognition.collector.base.SubCollector;
import com.danlan.android.cognition.collector.util.CMDUtil;
import com.danlan.android.cognition.collector.util.PermissionUtil;
import com.danlan.android.cognition.collector.util.SafeJSONObject;
import com.danlan.android.cognition.common.HashUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7206380-dex2jar.jar:com/danlan/android/cognition/collector/AppCollector.class */
public class AppCollector extends SubCollector {
    private Context mcontext;
    private PackageManager packageManager;
    private final PermissionUtil permissionUtils;
    private static final String[] list = {StringFog.decrypt("QkxJDVVGSkJETVANTE4="), StringFog.decrypt("QkxJDVJQCkBPR1ZMSEcKVEZACkJWRklE"), StringFog.decrypt("QkxJDVJOTU1EDUNKR05FSkRR"), StringFog.decrypt("QkxJDVVGSkJETVANTExGSE1GVVI="), StringFog.decrypt("QkxJDVlWSkxETUMNUUpKRVRMQFZO"), StringFog.decrypt("QkxJDURECkBPR1ZMSEcKYE1KVEJYZFRJTk1B"), StringFog.decrypt("QkxJDVJQCkBPR1ZMSEcKQFNXTUBNRgpPRFRX")};
    private static final String[] multi_open_app_list = {StringFog.decrypt("QkxJDVBKTE5ODUlCRkpH"), StringFog.decrypt("QkxJDUNPXQ9FSFRPQFc="), StringFog.decrypt("QkxJDUVRS0gPQkBMQkhBUw9TVkw="), StringFog.decrypt("QkxJDUlaCkJNTEpG"), StringFog.decrypt("QkxJDVJLQURREQpbWEVX"), StringFog.decrypt("QkxJDUNMSFgPVFxOVE9QTlFGSg=="), StringFog.decrypt("Qk0KQElWR0gPQkpHD1RPR0RNV0tETQ=="), StringFog.decrypt("QkxJDUdGSEhZDUdPTk1BRURP"), StringFog.decrypt("QkxJDVlWSlNUSgpEQE5BUkBEQ1FEREVVTlE="), StringFog.decrypt("QkxJDUdGSEhZDUlWTVdBTUc="), StringFog.decrypt("QkxJDUlWTVNWDUBIR1A="), StringFog.decrypt("QkxJDU1aSEwPR09ZUg=="), StringFog.decrypt("QkxJDVlaXg9XQUtb"), StringFog.decrypt("QkxJDU1BQQ9RQlZCTU9BTQ=="), StringFog.decrypt("QkxJDVNGQEdITUNGUw1FUVE="), StringFog.decrypt("QkxJDVdOS1IPQlRT"), StringFog.decrypt("QkxJDUcSVE1AWkFR"), StringFog.decrypt("QkxJDVdTTE5PRkNCRkIKVUhXRU0="), StringFog.decrypt("QkxJDVkbXlIPUEVNRUFLWQ=="), StringFog.decrypt("QkxJDVhKVUhATUMNWU5FUlVGVg=="), StringFog.decrypt("QkxJDVdOS1IPU1ZM"), StringFog.decrypt("RUhUT1RETU8PV0VMD05UQg=="), StringFog.decrypt("SEwKVUhRUFRAT0VTUQ==")};
    private static final String[] hack_tools_app_list = {StringFog.decrypt("QkxJDVVMVEtOS0pUVA1JQEZKV0g="), StringFog.decrypt("TlFDDUxGS1ZCQlANREdcUU5QQUcPTkVPQERBUQ=="), StringFog.decrypt("RUYKUU5BUg9ATUBRTkpAD1lTS1BERwpIT1BQQk1PQVM="), StringFog.decrypt("TEYKVERKV0lUDUFbUQ=="), StringFog.decrypt("SEwKVUANQVlRTFdGRQ==")};
    private static final String[] auto_tools_app_list = {StringFog.decrypt("TlFDDU5TQU9QQgpQRE9BT0hWSQ1ATUBTTkpADUBTVA=="), StringFog.decrypt("SEwKUERPQU9FUUtKRQ1QRFJXRVNR")};

    public AppCollector(Context context, SafeJSONObject safeJSONObject) {
        super(context, safeJSONObject);
        this.permissionUtils = new PermissionUtil(context);
        this.mcontext = context;
        this.packageManager = context.getPackageManager();
    }

    private String getAppInstallTime(String str) {
        String str2 = "";
        if (new File(str).exists()) {
            Iterator<String> it = CMDUtil.executeCMD(new String[]{StringFog.decrypt("UldFVwE=") + str}, 1).iterator();
            String str3 = "";
            while (true) {
                str2 = str3;
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                if (next.contains(StringFog.decrypt("YEBHRlJQHg=="))) {
                    String trim = next.split(StringFog.decrypt("YEBHRlJQHg=="))[1].trim();
                    if (!trim.startsWith(StringFog.decrypt("CQ=="))) {
                        str3 = trim;
                    }
                }
            }
        }
        return str2;
    }

    private List<String> getTargetSystemPkgList(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        try {
            int length = strArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return arrayList;
                }
                arrayList.add(strArr[i2]);
                i = i2 + 1;
            }
        } catch (Throwable th) {
            return arrayList;
        }
    }

    public final boolean checkAutoTools() {
        String[] strArr = auto_tools_app_list;
        int length = strArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return false;
            }
            try {
                this.packageManager.getPackageInfo(strArr[i2], 0);
                return true;
            } catch (Throwable th) {
                i = i2 + 1;
            }
        }
    }

    public final SafeJSONObject checkCommonApp(Context context) {
        SafeJSONObject safeJSONObject = new SafeJSONObject();
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(getTargetSystemPkgList(list));
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                PackageInfo packageInfo = null;
                try {
                    packageInfo = this.packageManager.getPackageInfo(str, 0);
                } catch (Throwable th) {
                }
                if (packageInfo != null) {
                    try {
                        if ((packageInfo.applicationInfo.flags & 1) == 0) {
                            SafeJSONObject safeJSONObject2 = new SafeJSONObject();
                            safeJSONObject2.put(StringFog.decrypt("R09FRA=="), 1);
                            safeJSONObject2.put(StringFog.decrypt("V0ZWUEhMSg=="), packageInfo.versionName);
                            String str2 = packageInfo.applicationInfo.sourceDir;
                            String str3 = "";
                            if (!TextUtils.isEmpty(str2)) {
                                str3 = "";
                                try {
                                    if (NativeLib.checkLoadSo()) {
                                        str3 = new JSONObject(NativeLib.ft(str2)).getString(StringFog.decrypt("QldNTkQ="));
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                    str3 = "";
                                }
                            }
                            safeJSONObject2.put(StringFog.decrypt("SE1XV0BPSHVITkE="), str3);
                            safeJSONObject.put(str, safeJSONObject2);
                        }
                    } catch (Exception e2) {
                    }
                }
            }
            return safeJSONObject;
        } catch (Throwable th2) {
            return safeJSONObject;
        }
    }

    public final SafeJSONObject checkHackTools() {
        SafeJSONObject safeJSONObject = new SafeJSONObject();
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(getTargetSystemPkgList(hack_tools_app_list));
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                PackageInfo packageInfo = this.packageManager.getPackageInfo(str, 0);
                if (packageInfo != null) {
                    try {
                        if ((packageInfo.applicationInfo.flags & 1) == 0) {
                            SafeJSONObject safeJSONObject2 = new SafeJSONObject();
                            safeJSONObject2.put(StringFog.decrypt("V0ZWUEhMSg=="), packageInfo.versionName);
                            String str2 = packageInfo.applicationInfo.sourceDir;
                            String str3 = "";
                            if (!TextUtils.isEmpty(str2)) {
                                str3 = "";
                                try {
                                    if (NativeLib.checkLoadSo()) {
                                        str3 = new JSONObject(NativeLib.ft(str2)).getString(StringFog.decrypt("QldNTkQ="));
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                    str3 = "";
                                }
                            }
                            safeJSONObject2.put(StringFog.decrypt("SE1XV0BPSHVITkE="), str3);
                            safeJSONObject.put(str, safeJSONObject2);
                        }
                    } catch (Exception e2) {
                    }
                }
            }
            return safeJSONObject;
        } catch (Throwable th) {
            return safeJSONObject;
        }
    }

    public final SafeJSONObject checkMultiOpenApp(Context context) {
        SafeJSONObject safeJSONObject = new SafeJSONObject();
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(getTargetSystemPkgList(multi_open_app_list));
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                PackageInfo packageInfo = null;
                try {
                    packageInfo = this.packageManager.getPackageInfo(str, 0);
                } catch (Throwable th) {
                }
                if (packageInfo != null) {
                    try {
                        if ((packageInfo.applicationInfo.flags & 1) == 0) {
                            SafeJSONObject safeJSONObject2 = new SafeJSONObject();
                            safeJSONObject2.put(StringFog.decrypt("V0ZWUEhMSg=="), packageInfo.versionName);
                            String str2 = packageInfo.applicationInfo.sourceDir;
                            String str3 = "";
                            if (!TextUtils.isEmpty(str2)) {
                                str3 = "";
                                try {
                                    if (NativeLib.checkLoadSo()) {
                                        str3 = new JSONObject(NativeLib.ft(str2)).getString(StringFog.decrypt("QldNTkQ="));
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                    str3 = "";
                                }
                            }
                            safeJSONObject2.put(StringFog.decrypt("SE1XV0BPSHVITkE="), str3);
                            safeJSONObject.put(str, safeJSONObject2);
                        }
                    } catch (Exception e2) {
                    }
                }
            }
            return safeJSONObject;
        } catch (Throwable th2) {
            return safeJSONObject;
        }
    }

    @Override // com.danlan.android.cognition.collector.base.SubCollector
    public void doCollectAutomatically() {
        SafeJSONObject safeJSONObject = new SafeJSONObject();
        safeJSONObject.put(StringFog.decrypt("QFNUbUBOQQ=="), getAppName());
        safeJSONObject.put(StringFog.decrypt("QFNUdURRV0hOTWdMRUY="), getVersionCode());
        safeJSONObject.put(StringFog.decrypt("QFNUdURRV0hOTWpCTEY="), getVersionName());
        safeJSONObject.put(StringFog.decrypt("QFNUcEhESkBVVlZGbGcR"), getAppSignatureMD5());
        safeJSONObject.put(StringFog.decrypt("QFNPak9QUEBNT3RCVUs="), getApkInstallPath());
        safeJSONObject.put(StringFog.decrypt("QFNPc0BAT0BGRmpCTEY="), getAppPackageName());
        safeJSONObject.put(StringFog.decrypt("UUZWTkhQV0hOTWhKUlc="), getPermissionState());
        safeJSONObject.put(StringFog.decrypt("R0pWUFVqSlJVQkhPdUpJRA=="), getInstallAppTime());
        safeJSONObject.put(StringFog.decrypt("TUJXV3RTQEBVRnBKTEY="), getLastUpdateTime());
        safeJSONObject.put(StringFog.decrypt("RUJQQnFCUEk="), getDataPath());
        safeJSONObject.put(StringFog.decrypt("QkxJTk5OZVFR"), checkCommonApp(this.mcontext));
        safeJSONObject.put(StringFog.decrypt("UVFLQERQV2hPRUs="), getProcessInfo());
        safeJSONObject.put(StringFog.decrypt("TFZIV0hsVERPYlRT"), checkMultiOpenApp(this.mcontext));
        safeJSONObject.put(StringFog.decrypt("SUJHSHVMS01SYlRT"), checkHackTools());
        safeJSONObject.put(StringFog.decrypt("SUJXYlRXS3VOTEhQYFNU"), checkAutoTools());
        put(StringFog.decrypt("QFNUT0hARVVITEo="), safeJSONObject);
        collectDone();
    }

    public final String getApkInstallPath() {
        try {
            return this.mcontext.getApplicationContext().getPackageCodePath();
        } catch (Exception e) {
            return null;
        }
    }

    public final String getAppName() {
        ApplicationInfo applicationInfo;
        String str = null;
        try {
            applicationInfo = this.packageManager.getApplicationInfo(this.mcontext.getApplicationInfo().packageName, 0);
        } catch (Exception e) {
            applicationInfo = null;
        }
        if (applicationInfo != null) {
            str = this.packageManager.getApplicationLabel(applicationInfo);
        }
        return str;
    }

    public final String getAppPackageName() {
        return this.mcontext.getApplicationInfo().packageName;
    }

    public final String getAppSignatureMD5() {
        try {
            return HashUtil.md5(this.packageManager.getPackageInfo(this.mcontext.getPackageName(), 64).signatures[0].toByteArray());
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }

    public final String getDataPath() {
        return this.mcontext.getApplicationInfo().dataDir;
    }

    public final long getInstallAppTime() {
        try {
            PackageInfo packageInfo = this.packageManager.getPackageInfo(this.mcontext.getPackageName(), 0);
            if (packageInfo == null || packageInfo.applicationInfo == null) {
                return 0L;
            }
            return packageInfo.firstInstallTime / 1000;
        } catch (Exception e) {
            return 0L;
        }
    }

    public final long getLastUpdateTime() {
        try {
            PackageInfo packageInfo = this.packageManager.getPackageInfo(this.mcontext.getPackageName(), 0);
            if (packageInfo == null || packageInfo.applicationInfo == null) {
                return 0L;
            }
            return packageInfo.lastUpdateTime / 1000;
        } catch (Exception e) {
            return 0L;
        }
    }

    public final SafeJSONObject getPermissionState() {
        SafeJSONObject safeJSONObject = new SafeJSONObject();
        if (this.permissionUtils.isPermissionGranted(StringFog.decrypt("QE1AUU5KQA9RRlZOSFBXSE5NCnFkYmB+cWtrbWR8d3Vgd2E="))) {
            safeJSONObject.put(StringFog.decrypt("c2ZlZ35zbG5vZntwdWJwZA=="), true);
        } else {
            safeJSONObject.put(StringFog.decrypt("c2ZlZ35zbG5vZntwdWJwZA=="), false);
        }
        if (this.permissionUtils.isPermissionGranted(StringFog.decrypt("QE1AUU5KQA9RRlZOSFBXSE5NCnRzanBkfmZ8d2RxamBtfHd3bnFlZmQ="))) {
            safeJSONObject.put(StringFog.decrypt("dnFtd2R8YXl1ZnZtYG97cnVsdmJmZg=="), true);
        } else {
            safeJSONObject.put(StringFog.decrypt("dnFtd2R8YXl1ZnZtYG97cnVsdmJmZg=="), false);
        }
        if (this.permissionUtils.isPermissionGranted(StringFog.decrypt("QE1AUU5KQA9RRlZOSFBXSE5NCnFkYmB+ZHtwZnNtZW1+cHBsc2JjZA=="))) {
            safeJSONObject.put(StringFog.decrypt("c2ZlZ35mfHVkcWpibXx3dW5xZWRk"), true);
        } else {
            safeJSONObject.put(StringFog.decrypt("c2ZlZ35mfHVkcWpibXx3dW5xZWRk"), false);
        }
        if (this.permissionUtils.isPermissionGranted(StringFog.decrypt("QE1AUU5KQA9RRlZOSFBXSE5NCmJiYGFycnxiam9me21uYGV3aGxq"))) {
            safeJSONObject.put(StringFog.decrypt("YGBnZnJwe2dobWF8bWxnYHVqa20="), true);
        } else {
            safeJSONObject.put(StringFog.decrypt("YGBnZnJwe2dobWF8bWxnYHVqa20="), false);
        }
        if (this.permissionUtils.isPermissionGranted(StringFog.decrypt("QE1AUU5KQA9RRlZOSFBXSE5NCmJiYGFycnxnbGBxd2R+b2tgYHdtbm8="))) {
            safeJSONObject.put(StringFog.decrypt("YGBnZnJwe2JuYnZwZHxobmJicGpubQ=="), true);
        } else {
            safeJSONObject.put(StringFog.decrypt("YGBnZnJwe2JuYnZwZHxobmJicGpubQ=="), false);
        }
        if (this.permissionUtils.isPermissionGranted(StringFog.decrypt("QE1AUU5KQA9RRlZOSFBXSE5NCmJiYGFycnxzamdqe3J1YnBm"))) {
            safeJSONObject.put(StringFog.decrypt("YGBnZnJwe3ZoZW18cndldWQ="), true);
        } else {
            safeJSONObject.put(StringFog.decrypt("YGBnZnJwe3ZoZW18cndldWQ="), false);
        }
        if (this.permissionUtils.isPermissionGranted(StringFog.decrypt("QE1AUU5KQA9RRlZOSFBXSE5NCmJiYGFycnxqZnV0a3NqfHd3YHdh"))) {
            safeJSONObject.put(StringFog.decrypt("YGBnZnJwe29kd3Nsc2h7cnVicGY="), true);
            return safeJSONObject;
        }
        safeJSONObject.put(StringFog.decrypt("YGBnZnJwe29kd3Nsc2h7cnVicGY="), false);
        return safeJSONObject;
    }

    public final SafeJSONObject getProcessInfo() {
        SafeJSONObject safeJSONObject = new SafeJSONObject();
        try {
            if (NativeLib.checkLoadSo()) {
                JSONObject jSONObject = new JSONObject(NativeLib.pi());
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    try {
                        safeJSONObject.put(next, next.equalsIgnoreCase(StringFog.decrypt("UldFV1RQakBMRg==")) ? ((String) jSONObject.get(next)).trim() : jSONObject.get(next));
                    } catch (JSONException e) {
                    }
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return safeJSONObject;
    }

    public final Integer getVersionCode() {
        try {
            return Integer.valueOf(this.packageManager.getPackageInfo(this.mcontext.getPackageName(), 0).versionCode);
        } catch (Exception e) {
            return null;
        }
    }

    public final String getVersionName() {
        try {
            return this.packageManager.getPackageInfo(this.mcontext.getPackageName(), 0).versionName;
        } catch (Exception e) {
            return null;
        }
    }
}
