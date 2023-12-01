package android.speech.tts;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.provider.Settings;
import android.speech.tts.TextToSpeech;
import android.text.TextUtils;
import android.util.Log;
import android.util.Xml;
import com.android.internal.R;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: source-9557208-dex2jar.jar:android/speech/tts/TtsEngines.class */
public class TtsEngines {
    private static final boolean DBG = false;
    private static final String LOCALE_DELIMITER_NEW = "_";
    private static final String LOCALE_DELIMITER_OLD = "-";
    private static final String TAG = "TtsEngines";
    private static final String XML_TAG_NAME = "tts-engine";
    private static final Map<String, String> sNormalizeCountry;
    private static final Map<String, String> sNormalizeLanguage;
    private final Context mContext;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/speech/tts/TtsEngines$EngineInfoComparator.class */
    public static class EngineInfoComparator implements Comparator<TextToSpeech.EngineInfo> {
        static EngineInfoComparator INSTANCE = new EngineInfoComparator();

        private EngineInfoComparator() {
        }

        @Override // java.util.Comparator
        public int compare(TextToSpeech.EngineInfo engineInfo, TextToSpeech.EngineInfo engineInfo2) {
            if (!engineInfo.system || engineInfo2.system) {
                if (!engineInfo2.system || engineInfo.system) {
                    return engineInfo2.priority - engineInfo.priority;
                }
                return 1;
            }
            return -1;
        }
    }

    static {
        HashMap hashMap = new HashMap();
        String[] iSOLanguages = Locale.getISOLanguages();
        int length = iSOLanguages.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                break;
            }
            String str = iSOLanguages[i2];
            try {
                hashMap.put(new Locale(str).getISO3Language(), str);
            } catch (MissingResourceException e) {
            }
            i = i2 + 1;
        }
        sNormalizeLanguage = Collections.unmodifiableMap(hashMap);
        HashMap hashMap2 = new HashMap();
        String[] iSOCountries = Locale.getISOCountries();
        int length2 = iSOCountries.length;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= length2) {
                sNormalizeCountry = Collections.unmodifiableMap(hashMap2);
                return;
            }
            String str2 = iSOCountries[i4];
            try {
                hashMap2.put(new Locale("", str2).getISO3Country(), str2);
            } catch (MissingResourceException e2) {
            }
            i3 = i4 + 1;
        }
    }

    public TtsEngines(Context context) {
        this.mContext = context;
    }

    private TextToSpeech.EngineInfo getEngineInfo(ResolveInfo resolveInfo, PackageManager packageManager) {
        ServiceInfo serviceInfo = resolveInfo.serviceInfo;
        if (serviceInfo != null) {
            TextToSpeech.EngineInfo engineInfo = new TextToSpeech.EngineInfo();
            engineInfo.name = serviceInfo.packageName;
            CharSequence loadLabel = serviceInfo.loadLabel(packageManager);
            engineInfo.label = TextUtils.isEmpty(loadLabel) ? engineInfo.name : loadLabel.toString();
            engineInfo.icon = serviceInfo.getIconResource();
            engineInfo.priority = resolveInfo.priority;
            engineInfo.system = isSystemEngine(serviceInfo);
            return engineInfo;
        }
        return null;
    }

    private boolean isSystemEngine(ServiceInfo serviceInfo) {
        ApplicationInfo applicationInfo = serviceInfo.applicationInfo;
        return (applicationInfo == null || (applicationInfo.flags & 1) == 0) ? false : true;
    }

    public static Locale normalizeTTSLocale(Locale locale) {
        String language = locale.getLanguage();
        String str = language;
        if (!TextUtils.isEmpty(language)) {
            String str2 = sNormalizeLanguage.get(language);
            str = language;
            if (str2 != null) {
                str = str2;
            }
        }
        String country = locale.getCountry();
        String str3 = country;
        if (!TextUtils.isEmpty(country)) {
            String str4 = sNormalizeCountry.get(country);
            str3 = country;
            if (str4 != null) {
                str3 = str4;
            }
        }
        return new Locale(str, str3, locale.getVariant());
    }

    private static String parseEnginePrefFromList(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split(",");
        int length = split.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return null;
            }
            String str3 = split[i2];
            int indexOf = str3.indexOf(58);
            if (indexOf > 0 && str2.equals(str3.substring(0, indexOf))) {
                return str3.substring(indexOf + 1);
            }
            i = i2 + 1;
        }
    }

    private String settingsActivityFromServiceInfo(ServiceInfo serviceInfo, PackageManager packageManager) {
        int next;
        String str;
        XmlResourceParser xmlResourceParser = null;
        XmlResourceParser xmlResourceParser2 = null;
        XmlResourceParser xmlResourceParser3 = null;
        XmlResourceParser xmlResourceParser4 = null;
        try {
            try {
                try {
                    try {
                        XmlResourceParser loadXmlMetaData = serviceInfo.loadXmlMetaData(packageManager, TextToSpeech.Engine.SERVICE_META_DATA);
                        if (loadXmlMetaData == null) {
                            Log.w(TAG, "No meta-data found for :" + serviceInfo);
                            if (loadXmlMetaData != null) {
                                loadXmlMetaData.close();
                            }
                            str = null;
                        } else {
                            Resources resourcesForApplication = packageManager.getResourcesForApplication(serviceInfo.applicationInfo);
                            do {
                                next = loadXmlMetaData.next();
                                if (next == 1) {
                                    if (loadXmlMetaData != null) {
                                        loadXmlMetaData.close();
                                        return null;
                                    }
                                    return null;
                                }
                            } while (next != 2);
                            if (!XML_TAG_NAME.equals(loadXmlMetaData.getName())) {
                                Log.w(TAG, "Package " + serviceInfo + " uses unknown tag :" + loadXmlMetaData.getName());
                                if (loadXmlMetaData != null) {
                                    loadXmlMetaData.close();
                                    return null;
                                }
                                return null;
                            }
                            TypedArray obtainAttributes = resourcesForApplication.obtainAttributes(Xml.asAttributeSet(loadXmlMetaData), R.styleable.TextToSpeechEngine);
                            String string = obtainAttributes.getString(0);
                            obtainAttributes.recycle();
                            str = string;
                            if (loadXmlMetaData != null) {
                                loadXmlMetaData.close();
                                return string;
                            }
                        }
                        return str;
                    } catch (PackageManager.NameNotFoundException e) {
                        Log.w(TAG, "Could not load resources for : " + serviceInfo);
                        if (0 != 0) {
                            xmlResourceParser4.close();
                            return null;
                        }
                        return null;
                    }
                } catch (XmlPullParserException e2) {
                    Log.w(TAG, "Error parsing metadata for " + serviceInfo + ":" + e2);
                    if (0 != 0) {
                        xmlResourceParser.close();
                        return null;
                    }
                    return null;
                }
            } catch (IOException e3) {
                Log.w(TAG, "Error parsing metadata for " + serviceInfo + ":" + e3);
                if (0 != 0) {
                    xmlResourceParser2.close();
                    return null;
                }
                return null;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                xmlResourceParser3.close();
            }
            throw th;
        }
    }

    public static String[] toOldLocaleStringFormat(Locale locale) {
        String[] strArr = {"", "", ""};
        try {
            strArr[0] = locale.getISO3Language();
            strArr[1] = locale.getISO3Country();
            strArr[2] = locale.getVariant();
            return strArr;
        } catch (MissingResourceException e) {
            return new String[]{"eng", "USA", ""};
        }
    }

    private String updateValueInCommaSeparatedList(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        if (TextUtils.isEmpty(str)) {
            sb.append(str2).append(':').append(str3);
        } else {
            String[] split = str.split(",");
            boolean z = true;
            boolean z2 = false;
            int length = split.length;
            int i = 0;
            while (i < length) {
                String str4 = split[i];
                int indexOf = str4.indexOf(58);
                boolean z3 = z;
                boolean z4 = z2;
                if (indexOf > 0) {
                    if (str2.equals(str4.substring(0, indexOf))) {
                        if (z) {
                            z = false;
                        } else {
                            sb.append(',');
                        }
                        z4 = true;
                        sb.append(str2).append(':').append(str3);
                        z3 = z;
                    } else {
                        if (z) {
                            z = false;
                        } else {
                            sb.append(',');
                        }
                        sb.append(str4);
                        z3 = z;
                        z4 = z2;
                    }
                }
                i++;
                z = z3;
                z2 = z4;
            }
            if (!z2) {
                sb.append(',');
                sb.append(str2).append(':').append(str3);
            }
        }
        return sb.toString();
    }

    public String getDefaultEngine() {
        String string = Settings.Secure.getString(this.mContext.getContentResolver(), Settings.Secure.TTS_DEFAULT_SYNTH);
        return isEngineInstalled(string) ? string : getHighestRankedEngineName();
    }

    public TextToSpeech.EngineInfo getEngineInfo(String str) {
        PackageManager packageManager = this.mContext.getPackageManager();
        Intent intent = new Intent(TextToSpeech.Engine.INTENT_ACTION_TTS_SERVICE);
        intent.setPackage(str);
        List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 65536);
        if (queryIntentServices == null || queryIntentServices.size() != 1) {
            return null;
        }
        return getEngineInfo(queryIntentServices.get(0), packageManager);
    }

    public List<TextToSpeech.EngineInfo> getEngines() {
        PackageManager packageManager = this.mContext.getPackageManager();
        List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(new Intent(TextToSpeech.Engine.INTENT_ACTION_TTS_SERVICE), 65536);
        if (queryIntentServices == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(queryIntentServices.size());
        for (ResolveInfo resolveInfo : queryIntentServices) {
            TextToSpeech.EngineInfo engineInfo = getEngineInfo(resolveInfo, packageManager);
            if (engineInfo != null) {
                arrayList.add(engineInfo);
            }
        }
        Collections.sort(arrayList, EngineInfoComparator.INSTANCE);
        return arrayList;
    }

    public String getHighestRankedEngineName() {
        List<TextToSpeech.EngineInfo> engines = getEngines();
        if (engines.size() <= 0 || !engines.get(0).system) {
            return null;
        }
        return engines.get(0).name;
    }

    public Locale getLocalePrefForEngine(String str) {
        return getLocalePrefForEngine(str, Settings.Secure.getString(this.mContext.getContentResolver(), Settings.Secure.TTS_DEFAULT_LOCALE));
    }

    public Locale getLocalePrefForEngine(String str, String str2) {
        Locale locale;
        String parseEnginePrefFromList = parseEnginePrefFromList(str2, str);
        if (TextUtils.isEmpty(parseEnginePrefFromList)) {
            locale = Locale.getDefault();
        } else {
            Locale parseLocaleString = parseLocaleString(parseEnginePrefFromList);
            locale = parseLocaleString;
            if (parseLocaleString == null) {
                Log.w(TAG, "Failed to parse locale " + parseEnginePrefFromList + ", returning en_US instead");
                return Locale.US;
            }
        }
        return locale;
    }

    public Intent getSettingsIntent(String str) {
        ServiceInfo serviceInfo;
        String str2;
        PackageManager packageManager = this.mContext.getPackageManager();
        Intent intent = new Intent(TextToSpeech.Engine.INTENT_ACTION_TTS_SERVICE);
        intent.setPackage(str);
        List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 65664);
        if (queryIntentServices == null || queryIntentServices.size() != 1 || (serviceInfo = queryIntentServices.get(0).serviceInfo) == null || (str2 = settingsActivityFromServiceInfo(serviceInfo, packageManager)) == null) {
            return null;
        }
        Intent intent2 = new Intent();
        intent2.setClassName(str, str2);
        return intent2;
    }

    public boolean isEngineInstalled(String str) {
        return (str == null || getEngineInfo(str) == null) ? false : true;
    }

    public boolean isLocaleSetToDefaultForEngine(String str) {
        return TextUtils.isEmpty(parseEnginePrefFromList(Settings.Secure.getString(this.mContext.getContentResolver(), Settings.Secure.TTS_DEFAULT_LOCALE), str));
    }

    public Locale parseLocaleString(String str) {
        String str2;
        String str3 = "";
        str2 = "";
        String str4 = str2;
        String str5 = "";
        if (!TextUtils.isEmpty(str)) {
            String[] split = str.split("[-_]");
            String lowerCase = split[0].toLowerCase();
            if (split.length == 0) {
                Log.w(TAG, "Failed to convert " + str + " to a valid Locale object. Only separators");
                return null;
            } else if (split.length > 3) {
                Log.w(TAG, "Failed to convert " + str + " to a valid Locale object. Too many separators");
                return null;
            } else {
                str2 = split.length >= 2 ? split[1].toUpperCase() : "";
                str4 = str2;
                str3 = lowerCase;
                str5 = "";
                if (split.length >= 3) {
                    str5 = split[2];
                    str3 = lowerCase;
                    str4 = str2;
                }
            }
        }
        String str6 = sNormalizeLanguage.get(str3);
        if (str6 != null) {
            str3 = str6;
        }
        String str7 = sNormalizeCountry.get(str4);
        if (str7 != null) {
            str4 = str7;
        }
        Locale locale = new Locale(str3, str4, str5);
        try {
            locale.getISO3Language();
            locale.getISO3Country();
            return locale;
        } catch (MissingResourceException e) {
            Log.w(TAG, "Failed to convert " + str + " to a valid Locale object.");
            return null;
        }
    }

    public void updateLocalePrefForEngine(String str, Locale locale) {
        synchronized (this) {
            Settings.Secure.putString(this.mContext.getContentResolver(), Settings.Secure.TTS_DEFAULT_LOCALE, updateValueInCommaSeparatedList(Settings.Secure.getString(this.mContext.getContentResolver(), Settings.Secure.TTS_DEFAULT_LOCALE), str, locale != null ? locale.toString() : "").toString());
        }
    }
}
