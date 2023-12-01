package com.danlan.android.cognition.collector;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.danlan.android.cognition.NativeLib;
import com.danlan.android.cognition.StringFog;
import com.danlan.android.cognition.collector.base.SubCollector;
import com.danlan.android.cognition.collector.util.CMDUtil;
import com.danlan.android.cognition.collector.util.SafeJSONObject;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;

/* loaded from: source-7206380-dex2jar.jar:com/danlan/android/cognition/collector/SystemCollector.class */
public class SystemCollector extends SubCollector {
    private static final String FLASH_LOCK_UNLOCKED = StringFog.decrypt("EQ==");
    private Context mcontext;

    public SystemCollector(Context context, SafeJSONObject safeJSONObject) {
        super(context, safeJSONObject);
        this.mcontext = context;
    }

    public static String checkAdbRoot() {
        return NativeLib.checkLoadSo() ? NativeLib.pg(StringFog.decrypt("UkZWVUhAQQ9AR0YNU0xLVQ=="), StringFog.decrypt("DBI=")) : StringFog.decrypt("DBI=");
    }

    public static String checkRoDebug() {
        return NativeLib.checkLoadSo() ? NativeLib.pg(StringFog.decrypt("U0wKR0RBUUZGQkZPRA=="), StringFog.decrypt("DBI=")) : StringFog.decrypt("DBI=");
    }

    public static String checkRoKernelQemu() {
        return NativeLib.checkLoadSo() ? NativeLib.pg(StringFog.decrypt("U0wKSERRSkRNDVVGTFY="), StringFog.decrypt("DBI=")) : StringFog.decrypt("DBI=");
    }

    public static String checkRoSecure() {
        return NativeLib.checkLoadSo() ? NativeLib.pg(StringFog.decrypt("U0wKUERAUVNE"), StringFog.decrypt("DBI=")) : StringFog.decrypt("DBI=");
    }

    public static String getAdbSecure() {
        return NativeLib.checkLoadSo() ? NativeLib.pg(StringFog.decrypt("U0wKQkVBClJEQFFRRA=="), StringFog.decrypt("DBI=")) : StringFog.decrypt("DBI=");
    }

    public static String getAdbdState() {
        return NativeLib.checkLoadSo() ? NativeLib.pg(StringFog.decrypt("SE1NVw9QUkIPQkBBRQ=="), StringFog.decrypt("VE1PTU5USg==")) : StringFog.decrypt("VE1PTU5USg==");
    }

    public static String getDescription() {
        return NativeLib.checkLoadSo() ? NativeLib.pg(StringFog.decrypt("U0wKQVRKSEUPR0FQQlFNUVVKS00="), StringFog.decrypt("DBI=")) : StringFog.decrypt("DBI=");
    }

    public static String getVbmetaDigest() {
        return NativeLib.checkLoadSo() ? NativeLib.pg(StringFog.decrypt("U0wKQU5MUA9XQUlGVUIKRUhEQVBV"), StringFog.decrypt("DBI=")) : StringFog.decrypt("DBI=");
    }

    public static boolean isOpenDevelopmentSetting(Context context) {
        boolean z = false;
        try {
            if (Settings.Secure.getInt(context.getContentResolver(), StringFog.decrypt("RUZSRk1MVExETVB8UkZQVUhNQ1B+RkpAQ09BRw=="), 0) != 0) {
                z = true;
            }
            return z;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isUSBDebugSetting(Context context) {
        boolean z = false;
        try {
            if (Settings.Secure.getInt(context.getContentResolver(), StringFog.decrypt("QEdGfERNRUNNRkA="), 0) != 0) {
                z = true;
            }
            return z;
        } catch (Exception e) {
            return false;
        }
    }

    @Override // com.danlan.android.cognition.collector.base.SubCollector
    public void doCollectAutomatically() {
        SafeJSONObject safeJSONObject = new SafeJSONObject();
        safeJSONObject.put(StringFog.decrypt("TlByRlNQTU5P"), getOSVersion());
        safeJSONObject.put(StringFog.decrypt("Q1ZNT0V3TUxE"), getBuildTime());
        safeJSONObject.put(StringFog.decrypt("Q1ZNT0V2V0RT"), getBuildUser());
        safeJSONObject.put(StringFog.decrypt("Q1ZNT0V3XVFE"), getBuildType());
        safeJSONObject.put(StringFog.decrypt("UkdPdURRV0hOTQ=="), getSdkVersion());
        safeJSONObject.put(StringFog.decrypt("TUJKRFRCQ0Q="), getLanguage());
        safeJSONObject.put(StringFog.decrypt("VFBBUWBEQU9V"), getUserAgent());
        safeJSONObject.put(StringFog.decrypt("VFNQSkxG"), getSystemStartupTime());
        safeJSONObject.put(StringFog.decrypt("U1ZKV0hOQQ=="), getSystemRunTime());
        safeJSONObject.put(StringFog.decrypt("VUpJRltMSkQ="), getTimezone());
        safeJSONObject.put(StringFog.decrypt("TlFNRk9XRVVITEo="), getOrientation());
        safeJSONObject.put(StringFog.decrypt("QE1AUU5KQH5IRw=="), getAndroidId());
        safeJSONObject.put(StringFog.decrypt("U0pKRFVMSkQ="), getRingtoneConfig());
        safeJSONObject.put(StringFog.decrypt("SE1HUUROQU9VQkh8V0ZWUkhMSg=="), getIncrementalVersion());
        safeJSONObject.put(StringFog.decrypt("R0pWUFV8RVFIfEhGV0ZI"), getFirstApiLevel());
        safeJSONObject.put(StringFog.decrypt("UkZHVlNKUFh+U0VXQkt7V0RRV0pOTQ=="), getSecurityPatchVersion());
        safeJSONObject.put(StringFog.decrypt("U0pIfERAR01IUFA="), getRilEcclistInfo());
        safeJSONObject.put(StringFog.decrypt("QktFUUBAUERTSldXSEBX"), getCharacteristics());
        safeJSONObject.put(StringFog.decrypt("Q0xLV0hORUZEfEZWSE9AfkVCUEY="), getBootImageBuildDate());
        safeJSONObject.put(StringFog.decrypt("SFBrU0RNYERXcEFXVUpKRg=="), isOpenDevelopmentSetting(this.mcontext));
        safeJSONObject.put(StringFog.decrypt("SFBxUENnQUNURHdGVVdNT0Y="), isUSBDebugSetting(this.mcontext));
        safeJSONObject.put(StringFog.decrypt("SFBgRldKR0R0TUhMQkhBRQ=="), isDeviceOemUnlocked());
        safeJSONObject.put(StringFog.decrypt("SFBgRldKR0R0TUhMQkhBRWRNRUFNRg=="), isDeviceOemUnlockEnabled());
        safeJSONObject.put(StringFog.decrypt("SFBlQEJGV1JIQU1PSFddckRXUEpPRA=="), isAccessibilityEnabled());
        safeJSONObject.put(StringFog.decrypt("RE1FQU1GQGBCQEFQUkpGSE1KUFo="), getEnabledAccessibilityService());
        safeJSONObject.put(StringFog.decrypt("QEdGc05RUA=="), getAdbPort());
        safeJSONObject.put(StringFog.decrypt("QEdGR3JXRVVE"), getAdbdState());
        safeJSONObject.put(StringFog.decrypt("QEdGcERAUVNE"), getAdbSecure());
        safeJSONObject.put(StringFog.decrypt("SUJXZkxWSEBVTFZlSE9BUg=="), isHaveEmulatorFiles());
        safeJSONObject.put(StringFog.decrypt("UkZWVUhAQWhPRUs="), getServiceListInfo());
        safeJSONObject.put(StringFog.decrypt("U0x7R0RBUUY="), checkRoDebug());
        safeJSONObject.put(StringFog.decrypt("U0x7SERRSkRNfFVGTFY="), checkRoKernelQemu());
        safeJSONObject.put(StringFog.decrypt("U0x7QkVBe1NOTFA="), checkAdbRoot());
        safeJSONObject.put(StringFog.decrypt("U0x7UERAUVNE"), checkRoSecure());
        safeJSONObject.put(StringFog.decrypt("U0x7R0RQR1NIU1BKTk0="), getDescription());
        safeJSONObject.put(StringFog.decrypt("V0F7R0hEQVJV"), getVbmetaDigest());
        put(StringFog.decrypt("UlpXV0RO"), safeJSONObject);
        collectDone();
    }

    public String getAdbPort() {
        return NativeLib.checkLoadSo() ? NativeLib.pg(StringFog.decrypt("QE1AUU5KQA9JTFdXD0JAQw9TS1FV"), "") : "";
    }

    public String getAndroidId() {
        try {
            String string = Settings.Secure.getString(this.mcontext.getContentResolver(), StringFog.decrypt("QE1AUU5KQH5IRw=="));
            String str = "";
            if (string != null) {
                str = "";
                if (!string.equals(StringFog.decrypt("GBQTF0UWEkUXGxZGFBcdQg=="))) {
                    if (string.length() < 15) {
                        return "";
                    }
                    str = string;
                }
            }
            return str;
        } catch (Exception e) {
            return "";
        }
    }

    public String getBootImageBuildDate() {
        return NativeLib.checkLoadSo() ? NativeLib.pg(StringFog.decrypt("U0wKQU5MUEhMQkNGD0FRSE1HCkdAV0E="), StringFog.decrypt("VE1PTU5USg==")) : StringFog.decrypt("VE1PTU5USg==");
    }

    public final String getBuildTime() {
        return NativeLib.checkLoadSo() ? NativeLib.pg(StringFog.decrypt("U0wKQVRKSEUPR0VXRA1RVUI="), StringFog.decrypt("VE1PTU5USg==")) : StringFog.decrypt("VE1PTU5USg==");
    }

    public final String getBuildType() {
        return NativeLib.checkLoadSo() ? NativeLib.pg(StringFog.decrypt("U0wKQVRKSEUPV11TRA=="), StringFog.decrypt("VE1PTU5USg==")) : StringFog.decrypt("VE1PTU5USg==");
    }

    public final String getBuildUser() {
        return NativeLib.checkLoadSo() ? NativeLib.pg(StringFog.decrypt("U0wKQVRKSEUPVldGUw=="), StringFog.decrypt("VE1PTU5USg==")) : StringFog.decrypt("VE1PTU5USg==");
    }

    public String getCharacteristics() {
        return NativeLib.checkLoadSo() ? NativeLib.pg(StringFog.decrypt("U0wKQVRKSEUPQExCU0JHVURRTVBVSkdS"), StringFog.decrypt("VE1PTU5USg==")) : StringFog.decrypt("VE1PTU5USg==");
    }

    public SafeJSONObject getEnabledAccessibilityService() {
        HashSet hashSet;
        SafeJSONObject safeJSONObject = new SafeJSONObject();
        try {
            List<AccessibilityServiceInfo> enabledAccessibilityServiceList = ((AccessibilityManager) this.mcontext.getSystemService(StringFog.decrypt("QEBHRlJQTUNIT01XWA=="))).getEnabledAccessibilityServiceList(-1);
            if (enabledAccessibilityServiceList != null && enabledAccessibilityServiceList.size() > 0) {
                for (AccessibilityServiceInfo accessibilityServiceInfo : enabledAccessibilityServiceList) {
                    String id = accessibilityServiceInfo.getId();
                    if (!TextUtils.isEmpty(id)) {
                        boolean z = false;
                        String str = id;
                        if (id.contains(StringFog.decrypt("Dg=="))) {
                            str = id.split(StringFog.decrypt("Dg=="))[0];
                        }
                        if (safeJSONObject.has(str)) {
                            hashSet = (HashSet) safeJSONObject.get(str);
                            z = true;
                        } else {
                            hashSet = new HashSet();
                        }
                        try {
                            int capabilities = accessibilityServiceInfo.getCapabilities();
                            if ((capabilities & 1) != 0) {
                                hashSet.add(1);
                            }
                            if ((capabilities & 128) != 0) {
                                hashSet.add(128);
                            }
                            if ((capabilities & 32) != 0) {
                                hashSet.add(32);
                            }
                        } catch (Exception e) {
                        }
                        if (!z) {
                            safeJSONObject.put(str, hashSet);
                        }
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return safeJSONObject;
    }

    public String getFirstApiLevel() {
        return NativeLib.checkLoadSo() ? NativeLib.pg(StringFog.decrypt("U0wKU1NMQFRCVwpFSFFXVX5CVEp+T0FXRE8="), StringFog.decrypt("VE1PTU5USg==")) : StringFog.decrypt("VE1PTU5USg==");
    }

    public final String getGSFId() {
        try {
            Cursor query = this.mcontext.getContentResolver().query(Uri.parse(StringFog.decrypt("QkxKV0RNUBsODEdMTA1DTk5ESEYPQkpFU0xNRw9EV0cPRFdGU1VNQkRQ")), null, null, new String[]{StringFog.decrypt("QE1AUU5KQH5IRw==")}, null);
            if (query == null) {
                return null;
            }
            if (query.moveToFirst() && query.getColumnCount() >= 2) {
                String hexString = Long.toHexString(Long.parseLong(query.getString(1)));
                query.close();
                return hexString.toUpperCase().trim();
            }
            query.close();
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public String getIncrementalVersion() {
        return NativeLib.checkLoadSo() ? NativeLib.pg(StringFog.decrypt("U0wKQVRKSEUPVUFRUkpLTw9KSkBTRklET1dFTw=="), StringFog.decrypt("VE1PTU5USg==")) : StringFog.decrypt("VE1PTU5USg==");
    }

    public final String getLanguage() {
        return Locale.getDefault().getLanguage();
    }

    public final String getOSVersion() {
        return NativeLib.checkLoadSo() ? NativeLib.pg(StringFog.decrypt("U0wKQVRKSEUPVUFRUkpLTw9RQU9EQldE"), StringFog.decrypt("VE1PTU5USg==")) : StringFog.decrypt("VE1PTU5USg==");
    }

    public final String getOrientation() {
        String str;
        int i = this.mcontext.getResources().getConfiguration().orientation;
        if (i == 2) {
            str = "TUJKR1JARVFE";
        } else if (i != 1) {
            return null;
        } else {
            str = "UUxWV1NCTVU=";
        }
        return StringFog.decrypt(str);
    }

    public String getRilEcclistInfo() {
        return NativeLib.checkLoadSo() ? NativeLib.pg(StringFog.decrypt("U0wKUUhPCkRCQEhKUlc="), StringFog.decrypt("VE1PTU5USg==")) : StringFog.decrypt("VE1PTU5USg==");
    }

    public String getRingtoneConfig() {
        return NativeLib.checkLoadSo() ? NativeLib.pg(StringFog.decrypt("U0wKQE5NQkhGDVZKT0RQTk9G"), StringFog.decrypt("VE1PTU5USg==")) : StringFog.decrypt("VE1PTU5USg==");
    }

    public final int getSdkVersion() {
        return Build.VERSION.SDK_INT;
    }

    public String getSecurityPatchVersion() {
        return NativeLib.checkLoadSo() ? NativeLib.pg(StringFog.decrypt("U0wKQVRKSEUPVUFRUkpLTw9QQUBUUU1VWHxUQlVATA=="), StringFog.decrypt("VE1PTU5USg==")) : StringFog.decrypt("VE1PTU5USg==");
    }

    public SafeJSONObject getServiceListInfo() {
        String decrypt = StringFog.decrypt("VUtBUUxCSFJEUVJKQkY=");
        String decrypt2 = StringFog.decrypt("R0pKRERRVFNITVA=");
        String decrypt3 = StringFog.decrypt("T0VH");
        String decrypt4 = StringFog.decrypt("TEpASg==");
        String decrypt5 = StringFog.decrypt("UVFNTVU=");
        SafeJSONObject safeJSONObject = new SafeJSONObject();
        ArrayList arrayList = new ArrayList();
        List<String> executeCMD = CMDUtil.executeCMD(new String[]{StringFog.decrypt("UkZWVUhAQQFNSldX")}, 1);
        int size = executeCMD.size();
        if (size != 0) {
            safeJSONObject.put(StringFog.decrypt("T1ZJ"), size - 1);
            for (String str : executeCMD) {
                if (!TextUtils.isEmpty(str)) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < 5) {
                            String str2 = new String[]{decrypt, decrypt2, decrypt3, decrypt4, decrypt5}[i2];
                            if (str.contains("\t" + str2 + StringFog.decrypt("Gw=="))) {
                                arrayList.add(str2);
                                break;
                            }
                            i = i2 + 1;
                        }
                    }
                }
            }
        } else {
            safeJSONObject.put(StringFog.decrypt("T1ZJ"), 0);
        }
        safeJSONObject.put(StringFog.decrypt("UlNBQEhCSH5SRlZVSEBB"), arrayList);
        return safeJSONObject;
    }

    public final long getSystemRunTime() {
        try {
            return SystemClock.elapsedRealtime() / 1000;
        } catch (Exception e) {
            return 0L;
        }
    }

    public final long getSystemStartupTime() {
        try {
            return (System.currentTimeMillis() - SystemClock.elapsedRealtime()) / 1000;
        } catch (Exception e) {
            return 0L;
        }
    }

    public final String getTimezone() {
        return NativeLib.checkLoadSo() ? NativeLib.pg(StringFog.decrypt("UUZWUEhQUA9SWlcNVUpJRFtMSkY="), StringFog.decrypt("VE1PTU5USg==")) : StringFog.decrypt("VE1PTU5USg==");
    }

    public final String getUserAgent() {
        String property = System.getProperty(StringFog.decrypt("SVdQUw9CQ0RPVw=="));
        try {
            return WebSettings.getDefaultUserAgent(this.mcontext) + StringFog.decrypt("fnw=") + property;
        } catch (Exception e) {
            try {
                return new WebView(this.mcontext).getSettings().getUserAgentString() + StringFog.decrypt("fnw=") + property;
            } catch (Exception e2) {
                e2.printStackTrace();
                return "";
            }
        }
    }

    public final boolean isAccessibilityEnabled() {
        try {
            return ((AccessibilityManager) this.mcontext.getSystemService(StringFog.decrypt("QEBHRlJQTUNIT01XWA=="))).isEnabled();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public final boolean isDeviceOemUnlockEnabled() {
        if (NativeLib.checkLoadSo()) {
            try {
                String pg = NativeLib.pg(StringFog.decrypt("UlpXDU5GSX5UTUhMQkh7QE1PS1RERw=="), StringFog.decrypt("VE1PTU5USg=="));
                boolean z = true;
                if (pg.hashCode() == 49) {
                    if (pg.equals(StringFog.decrypt("EA=="))) {
                        z = false;
                    }
                }
                return !z;
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }

    public final boolean isDeviceOemUnlocked() {
        if (NativeLib.checkLoadSo()) {
            try {
                String pg = NativeLib.pg(StringFog.decrypt("U0wKQU5MUA9HT0VQSQ1ITkJIQUc="), StringFog.decrypt("VE1PTU5USg=="));
                boolean z = true;
                if (pg.hashCode() == 48) {
                    if (pg.equals(FLASH_LOCK_UNLOCKED)) {
                        z = false;
                    }
                }
                return !z;
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }

    public boolean isHaveEmulatorFiles() {
        String decrypt = StringFog.decrypt("DlBdUA5HQVdIQEFQDm9qeXJ6d3dsGRQR");
        String decrypt2 = StringFog.decrypt("DlBdUA5HQVdIQEFQDlNIQFVFS1FMDFRNQFdCTFNOCUdTQklGQ1ZCR0RRChM=");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 2) {
                return false;
            }
            String str = new String[]{decrypt, decrypt2}[i2];
            if (NativeLib.checkLoadSo() && NativeLib.cf(str) == 1) {
                return true;
            }
            i = i2 + 1;
        }
    }
}
