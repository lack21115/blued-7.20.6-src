package android.hardware.soundtrigger;

import android.Manifest;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.text.TextUtils;
import android.util.ArraySet;
import android.util.AttributeSet;
import android.util.Slog;
import android.util.Xml;
import com.android.internal.R;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/soundtrigger/KeyphraseEnrollmentInfo.class */
public class KeyphraseEnrollmentInfo {
    public static final String ACTION_MANAGE_VOICE_KEYPHRASES = "com.android.intent.action.MANAGE_VOICE_KEYPHRASES";
    public static final String EXTRA_VOICE_KEYPHRASE_ACTION = "com.android.intent.extra.VOICE_KEYPHRASE_ACTION";
    public static final String EXTRA_VOICE_KEYPHRASE_HINT_TEXT = "com.android.intent.extra.VOICE_KEYPHRASE_HINT_TEXT";
    public static final String EXTRA_VOICE_KEYPHRASE_LOCALE = "com.android.intent.extra.VOICE_KEYPHRASE_LOCALE";
    private static final String TAG = "KeyphraseEnrollmentInfo";
    private static final String VOICE_KEYPHRASE_META_DATA = "android.voice_enrollment";
    private String mEnrollmentPackage;
    private KeyphraseMetadata[] mKeyphrases;
    private String mParseError;

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:76:0x0268 -> B:103:0x002a). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:84:0x029e -> B:103:0x002a). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:92:0x02d4 -> B:103:0x002a). Please submit an issue!!! */
    public KeyphraseEnrollmentInfo(PackageManager packageManager) {
        ApplicationInfo applicationInfo;
        boolean z;
        int next;
        List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(new Intent(ACTION_MANAGE_VOICE_KEYPHRASES), 65536);
        if (queryIntentActivities == null || queryIntentActivities.isEmpty()) {
            this.mParseError = "No enrollment application found";
            return;
        }
        ApplicationInfo applicationInfo2 = null;
        Iterator<ResolveInfo> it = queryIntentActivities.iterator();
        while (true) {
            applicationInfo = applicationInfo2;
            z = false;
            if (!it.hasNext()) {
                break;
            }
            ApplicationInfo applicationInfo3 = applicationInfo2;
            try {
                applicationInfo2 = packageManager.getApplicationInfo(it.next().activityInfo.packageName, 128);
                if ((applicationInfo2.flags & 1073741824) != 0) {
                    if (Manifest.permission.MANAGE_VOICE_KEYPHRASES.equals(applicationInfo2.permission)) {
                        applicationInfo3 = applicationInfo2;
                        this.mEnrollmentPackage = applicationInfo2.packageName;
                        z = true;
                        applicationInfo = applicationInfo2;
                        break;
                    }
                    Slog.w(TAG, applicationInfo2.packageName + " does not require MANAGE_VOICE_KEYPHRASES");
                } else {
                    Slog.w(TAG, applicationInfo2.packageName + "is not a privileged system app");
                }
            } catch (PackageManager.NameNotFoundException e) {
                Slog.w(TAG, "error parsing voice enrollment meta-data", e);
                applicationInfo2 = applicationInfo3;
            }
        }
        if (!z) {
            this.mKeyphrases = null;
            this.mParseError = "No suitable enrollment application found";
            return;
        }
        XmlResourceParser xmlResourceParser = null;
        XmlResourceParser xmlResourceParser2 = null;
        XmlResourceParser xmlResourceParser3 = null;
        XmlResourceParser xmlResourceParser4 = null;
        try {
            try {
                XmlResourceParser loadXmlMetaData = applicationInfo.loadXmlMetaData(packageManager, VOICE_KEYPHRASE_META_DATA);
                if (loadXmlMetaData == null) {
                    xmlResourceParser4 = loadXmlMetaData;
                    xmlResourceParser = loadXmlMetaData;
                    xmlResourceParser2 = loadXmlMetaData;
                    xmlResourceParser3 = loadXmlMetaData;
                    this.mParseError = "No android.voice_enrollment meta-data for " + applicationInfo.packageName;
                    if (loadXmlMetaData != null) {
                        loadXmlMetaData.close();
                    }
                } else {
                    Resources resourcesForApplication = packageManager.getResourcesForApplication(applicationInfo);
                    AttributeSet asAttributeSet = Xml.asAttributeSet(loadXmlMetaData);
                    do {
                        next = loadXmlMetaData.next();
                        if (next == 1) {
                            break;
                        }
                    } while (next != 2);
                    if ("voice-enrollment-application".equals(loadXmlMetaData.getName())) {
                        TypedArray obtainAttributes = resourcesForApplication.obtainAttributes(asAttributeSet, R.styleable.VoiceEnrollmentApplication);
                        initializeKeyphrasesFromTypedArray(obtainAttributes);
                        xmlResourceParser4 = loadXmlMetaData;
                        xmlResourceParser = loadXmlMetaData;
                        xmlResourceParser2 = loadXmlMetaData;
                        xmlResourceParser3 = loadXmlMetaData;
                        obtainAttributes.recycle();
                        if (loadXmlMetaData != null) {
                            loadXmlMetaData.close();
                        }
                    } else {
                        xmlResourceParser4 = loadXmlMetaData;
                        xmlResourceParser = loadXmlMetaData;
                        xmlResourceParser2 = loadXmlMetaData;
                        xmlResourceParser3 = loadXmlMetaData;
                        this.mParseError = "Meta-data does not start with voice-enrollment-application tag";
                        if (loadXmlMetaData != null) {
                            loadXmlMetaData.close();
                        }
                    }
                }
            } catch (PackageManager.NameNotFoundException e2) {
                this.mParseError = "Error parsing keyphrase enrollment meta-data: " + e2;
                xmlResourceParser3 = xmlResourceParser2;
                Slog.w(TAG, "error parsing keyphrase enrollment meta-data", e2);
                if (xmlResourceParser2 != null) {
                    xmlResourceParser2.close();
                }
            } catch (IOException e3) {
                this.mParseError = "Error parsing keyphrase enrollment meta-data: " + e3;
                xmlResourceParser3 = xmlResourceParser;
                Slog.w(TAG, "error parsing keyphrase enrollment meta-data", e3);
                if (xmlResourceParser != null) {
                    xmlResourceParser.close();
                }
            } catch (XmlPullParserException e4) {
                this.mParseError = "Error parsing keyphrase enrollment meta-data: " + e4;
                xmlResourceParser3 = xmlResourceParser4;
                Slog.w(TAG, "error parsing keyphrase enrollment meta-data", e4);
                if (xmlResourceParser4 != null) {
                    xmlResourceParser4.close();
                }
            }
        } catch (Throwable th) {
            if (xmlResourceParser3 != null) {
                xmlResourceParser3.close();
            }
            throw th;
        }
    }

    private void initializeKeyphrasesFromTypedArray(TypedArray typedArray) {
        int i = typedArray.getInt(0, -1);
        if (i <= 0) {
            this.mParseError = "No valid searchKeyphraseId specified in meta-data";
            Slog.w(TAG, this.mParseError);
            return;
        }
        String string = typedArray.getString(1);
        if (string == null) {
            this.mParseError = "No valid searchKeyphrase specified in meta-data";
            Slog.w(TAG, this.mParseError);
            return;
        }
        String string2 = typedArray.getString(2);
        if (string2 == null) {
            this.mParseError = "No valid searchKeyphraseSupportedLocales specified in meta-data";
            Slog.w(TAG, this.mParseError);
            return;
        }
        ArraySet arraySet = new ArraySet();
        if (!TextUtils.isEmpty(string2)) {
            try {
                String[] split = string2.split(",");
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= split.length) {
                        break;
                    }
                    arraySet.add(Locale.forLanguageTag(split[i3]));
                    i2 = i3 + 1;
                }
            } catch (Exception e) {
                this.mParseError = "Error reading searchKeyphraseSupportedLocales from meta-data";
                Slog.w(TAG, this.mParseError, e);
                return;
            }
        }
        int i4 = typedArray.getInt(3, -1);
        if (i4 < 0) {
            this.mParseError = "No valid searchKeyphraseRecognitionFlags specified in meta-data";
            Slog.w(TAG, this.mParseError);
            return;
        }
        this.mKeyphrases = new KeyphraseMetadata[1];
        this.mKeyphrases[0] = new KeyphraseMetadata(i, string, arraySet, i4);
    }

    public KeyphraseMetadata getKeyphraseMetadata(String str, Locale locale) {
        KeyphraseMetadata keyphraseMetadata;
        if (this.mKeyphrases == null || this.mKeyphrases.length == 0) {
            Slog.w(TAG, "Enrollment application doesn't support keyphrases");
            keyphraseMetadata = null;
        } else {
            KeyphraseMetadata[] keyphraseMetadataArr = this.mKeyphrases;
            int length = keyphraseMetadataArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    Slog.w(TAG, "Enrollment application doesn't support the given keyphrase/locale");
                    return null;
                }
                KeyphraseMetadata keyphraseMetadata2 = keyphraseMetadataArr[i2];
                if (keyphraseMetadata2.supportsPhrase(str)) {
                    keyphraseMetadata = keyphraseMetadata2;
                    if (keyphraseMetadata2.supportsLocale(locale)) {
                        break;
                    }
                }
                i = i2 + 1;
            }
        }
        return keyphraseMetadata;
    }

    public Intent getManageKeyphraseIntent(int i, String str, Locale locale) {
        if (this.mEnrollmentPackage == null || this.mEnrollmentPackage.isEmpty()) {
            Slog.w(TAG, "No enrollment application exists");
            return null;
        } else if (getKeyphraseMetadata(str, locale) != null) {
            return new Intent(ACTION_MANAGE_VOICE_KEYPHRASES).setPackage(this.mEnrollmentPackage).putExtra(EXTRA_VOICE_KEYPHRASE_HINT_TEXT, str).putExtra(EXTRA_VOICE_KEYPHRASE_LOCALE, locale.toLanguageTag()).putExtra(EXTRA_VOICE_KEYPHRASE_ACTION, i);
        } else {
            return null;
        }
    }

    public String getParseError() {
        return this.mParseError;
    }

    public KeyphraseMetadata[] listKeyphraseMetadata() {
        return this.mKeyphrases;
    }

    public String toString() {
        return "KeyphraseEnrollmentInfo [Keyphrases=" + Arrays.toString(this.mKeyphrases) + ", EnrollmentPackage=" + this.mEnrollmentPackage + ", ParseError=" + this.mParseError + "]";
    }
}
