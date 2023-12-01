package android.content.res;

import android.hardware.Camera;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.security.KeyChain;
import android.text.TextUtils;
import com.android.internal.util.XmlUtils;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.blued.das.live.LiveProtos;
import com.kuaishou.weapon.p0.t;
import com.xiaomi.mipush.sdk.Constants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* loaded from: source-9557208-dex2jar.jar:android/content/res/Configuration.class */
public final class Configuration implements Parcelable, Comparable<Configuration> {
    public static final int DENSITY_DPI_ANY = 65534;
    public static final int DENSITY_DPI_NONE = 65535;
    public static final int DENSITY_DPI_UNDEFINED = 0;
    public static final int HARDKEYBOARDHIDDEN_NO = 1;
    public static final int HARDKEYBOARDHIDDEN_UNDEFINED = 0;
    public static final int HARDKEYBOARDHIDDEN_YES = 2;
    public static final int KEYBOARDHIDDEN_NO = 1;
    public static final int KEYBOARDHIDDEN_SOFT = 3;
    public static final int KEYBOARDHIDDEN_UNDEFINED = 0;
    public static final int KEYBOARDHIDDEN_YES = 2;
    public static final int KEYBOARD_12KEY = 3;
    public static final int KEYBOARD_NOKEYS = 1;
    public static final int KEYBOARD_QWERTY = 2;
    public static final int KEYBOARD_UNDEFINED = 0;
    public static final int MNC_ZERO = 65535;
    public static final int NATIVE_CONFIG_DENSITY = 256;
    public static final int NATIVE_CONFIG_KEYBOARD = 16;
    public static final int NATIVE_CONFIG_KEYBOARD_HIDDEN = 32;
    public static final int NATIVE_CONFIG_LAYOUTDIR = 16384;
    public static final int NATIVE_CONFIG_LOCALE = 4;
    public static final int NATIVE_CONFIG_MCC = 1;
    public static final int NATIVE_CONFIG_MNC = 2;
    public static final int NATIVE_CONFIG_NAVIGATION = 64;
    public static final int NATIVE_CONFIG_ORIENTATION = 128;
    public static final int NATIVE_CONFIG_SCREEN_LAYOUT = 2048;
    public static final int NATIVE_CONFIG_SCREEN_SIZE = 512;
    public static final int NATIVE_CONFIG_SMALLEST_SCREEN_SIZE = 8192;
    public static final int NATIVE_CONFIG_TOUCHSCREEN = 8;
    public static final int NATIVE_CONFIG_UI_MODE = 4096;
    public static final int NATIVE_CONFIG_VERSION = 1024;
    public static final int NAVIGATIONHIDDEN_NO = 1;
    public static final int NAVIGATIONHIDDEN_UNDEFINED = 0;
    public static final int NAVIGATIONHIDDEN_YES = 2;
    public static final int NAVIGATION_DPAD = 2;
    public static final int NAVIGATION_NONAV = 1;
    public static final int NAVIGATION_TRACKBALL = 3;
    public static final int NAVIGATION_UNDEFINED = 0;
    public static final int NAVIGATION_WHEEL = 4;
    public static final int ORIENTATION_LANDSCAPE = 2;
    public static final int ORIENTATION_PORTRAIT = 1;
    @Deprecated
    public static final int ORIENTATION_SQUARE = 3;
    public static final int ORIENTATION_UNDEFINED = 0;
    public static final int SCREENLAYOUT_COMPAT_NEEDED = 268435456;
    public static final int SCREENLAYOUT_LAYOUTDIR_LTR = 64;
    public static final int SCREENLAYOUT_LAYOUTDIR_MASK = 192;
    public static final int SCREENLAYOUT_LAYOUTDIR_RTL = 128;
    public static final int SCREENLAYOUT_LAYOUTDIR_SHIFT = 6;
    public static final int SCREENLAYOUT_LAYOUTDIR_UNDEFINED = 0;
    public static final int SCREENLAYOUT_LONG_MASK = 48;
    public static final int SCREENLAYOUT_LONG_NO = 16;
    public static final int SCREENLAYOUT_LONG_UNDEFINED = 0;
    public static final int SCREENLAYOUT_LONG_YES = 32;
    public static final int SCREENLAYOUT_SIZE_LARGE = 3;
    public static final int SCREENLAYOUT_SIZE_MASK = 15;
    public static final int SCREENLAYOUT_SIZE_NORMAL = 2;
    public static final int SCREENLAYOUT_SIZE_SMALL = 1;
    public static final int SCREENLAYOUT_SIZE_UNDEFINED = 0;
    public static final int SCREENLAYOUT_SIZE_XLARGE = 4;
    public static final int SCREENLAYOUT_UNDEFINED = 0;
    public static final int SCREEN_HEIGHT_DP_UNDEFINED = 0;
    public static final int SCREEN_WIDTH_DP_UNDEFINED = 0;
    public static final int SMALLEST_SCREEN_WIDTH_DP_UNDEFINED = 0;
    public static final String THEME_FONT_PACKAGE_NAME_PERSISTENCE_PROPERTY = "themeFontPackPkgName";
    public static final String THEME_ICONPACK_PACKAGE_NAME_PERSISTENCE_PROPERTY = "themeIconPackPkgName";
    public static final String THEME_PACKAGE_NAME_PERSISTENCE_PROPERTY = "persist.sys.themePackageName";
    public static final String THEME_PKG_CONFIGURATION_PERSISTENCE_PROPERTY = "themeConfig";
    public static final int TOUCHSCREEN_FINGER = 3;
    public static final int TOUCHSCREEN_NOTOUCH = 1;
    @Deprecated
    public static final int TOUCHSCREEN_STYLUS = 2;
    public static final int TOUCHSCREEN_UNDEFINED = 0;
    public static final int UI_MODE_NIGHT_MASK = 48;
    public static final int UI_MODE_NIGHT_NO = 16;
    public static final int UI_MODE_NIGHT_UNDEFINED = 0;
    public static final int UI_MODE_NIGHT_YES = 32;
    public static final int UI_MODE_TYPE_APPLIANCE = 5;
    public static final int UI_MODE_TYPE_CAR = 3;
    public static final int UI_MODE_TYPE_DESK = 2;
    public static final int UI_MODE_TYPE_MASK = 15;
    public static final int UI_MODE_TYPE_NORMAL = 1;
    public static final int UI_MODE_TYPE_TELEVISION = 4;
    public static final int UI_MODE_TYPE_UNDEFINED = 0;
    public static final int UI_MODE_TYPE_WATCH = 6;
    private static final String XML_ATTR_DENSITY = "density";
    private static final String XML_ATTR_FONT_SCALE = "fs";
    private static final String XML_ATTR_HARD_KEYBOARD_HIDDEN = "hardKeyHid";
    private static final String XML_ATTR_KEYBOARD = "key";
    private static final String XML_ATTR_KEYBOARD_HIDDEN = "keyHid";
    private static final String XML_ATTR_LOCALE = "locale";
    private static final String XML_ATTR_MCC = "mcc";
    private static final String XML_ATTR_MNC = "mnc";
    private static final String XML_ATTR_NAVIGATION = "nav";
    private static final String XML_ATTR_NAVIGATION_HIDDEN = "navHid";
    private static final String XML_ATTR_ORIENTATION = "ori";
    private static final String XML_ATTR_SCREEN_HEIGHT = "height";
    private static final String XML_ATTR_SCREEN_LAYOUT = "scrLay";
    private static final String XML_ATTR_SCREEN_WIDTH = "width";
    private static final String XML_ATTR_SMALLEST_WIDTH = "sw";
    private static final String XML_ATTR_TOUCHSCREEN = "touch";
    private static final String XML_ATTR_UI_MODE = "ui";
    public int compatScreenHeightDp;
    public int compatScreenWidthDp;
    public int compatSmallestScreenWidthDp;
    public int densityDpi;
    public float fontScale;
    public int hardKeyboardHidden;
    public int keyboard;
    public int keyboardHidden;
    public Locale locale;
    public int mcc;
    public int mnc;
    public int navigation;
    public int navigationHidden;
    public int orientation;
    public int screenHeightDp;
    public int screenLayout;
    public int screenWidthDp;
    public int seq;
    public int smallestScreenWidthDp;
    public ThemeConfig themeConfig;
    public int touchscreen;
    public int uiMode;
    public boolean userSetLocale;
    public static final Configuration EMPTY = new Configuration();
    public static final Parcelable.Creator<Configuration> CREATOR = new Parcelable.Creator<Configuration>() { // from class: android.content.res.Configuration.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Configuration createFromParcel(Parcel parcel) {
            return new Configuration(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Configuration[] newArray(int i) {
            return new Configuration[i];
        }
    };

    public Configuration() {
        setToDefaults();
    }

    public Configuration(Configuration configuration) {
        setTo(configuration);
    }

    private Configuration(Parcel parcel) {
        readFromParcel(parcel);
    }

    public static Configuration generateDelta(Configuration configuration, Configuration configuration2) {
        Configuration configuration3 = new Configuration();
        if (configuration.fontScale != configuration2.fontScale) {
            configuration3.fontScale = configuration2.fontScale;
        }
        if (configuration.mcc != configuration2.mcc) {
            configuration3.mcc = configuration2.mcc;
        }
        if (configuration.mnc != configuration2.mnc) {
            configuration3.mnc = configuration2.mnc;
        }
        if ((configuration.locale == null && configuration2.locale != null) || (configuration.locale != null && !configuration.locale.equals(configuration2.locale))) {
            configuration3.locale = configuration2.locale;
        }
        if (configuration.touchscreen != configuration2.touchscreen) {
            configuration3.touchscreen = configuration2.touchscreen;
        }
        if (configuration.keyboard != configuration2.keyboard) {
            configuration3.keyboard = configuration2.keyboard;
        }
        if (configuration.keyboardHidden != configuration2.keyboardHidden) {
            configuration3.keyboardHidden = configuration2.keyboardHidden;
        }
        if (configuration.navigation != configuration2.navigation) {
            configuration3.navigation = configuration2.navigation;
        }
        if (configuration.navigationHidden != configuration2.navigationHidden) {
            configuration3.navigationHidden = configuration2.navigationHidden;
        }
        if (configuration.orientation != configuration2.orientation) {
            configuration3.orientation = configuration2.orientation;
        }
        if ((configuration.screenLayout & 15) != (configuration2.screenLayout & 15)) {
            configuration3.screenLayout |= configuration2.screenLayout & 15;
        }
        if ((configuration.screenLayout & 192) != (configuration2.screenLayout & 192)) {
            configuration3.screenLayout |= configuration2.screenLayout & 192;
        }
        if ((configuration.screenLayout & 48) != (configuration2.screenLayout & 48)) {
            configuration3.screenLayout |= configuration2.screenLayout & 48;
        }
        if ((configuration.uiMode & 15) != (configuration2.uiMode & 15)) {
            configuration3.uiMode |= configuration2.uiMode & 15;
        }
        if ((configuration.uiMode & 48) != (configuration2.uiMode & 48)) {
            configuration3.uiMode |= configuration2.uiMode & 48;
        }
        if (configuration.screenWidthDp != configuration2.screenWidthDp) {
            configuration3.screenWidthDp = configuration2.screenWidthDp;
        }
        if (configuration.screenHeightDp != configuration2.screenHeightDp) {
            configuration3.screenHeightDp = configuration2.screenHeightDp;
        }
        if (configuration.smallestScreenWidthDp != configuration2.smallestScreenWidthDp) {
            configuration3.smallestScreenWidthDp = configuration2.smallestScreenWidthDp;
        }
        if (configuration.densityDpi != configuration2.densityDpi) {
            configuration3.densityDpi = configuration2.densityDpi;
        }
        return configuration3;
    }

    private static int getScreenLayoutNoDirection(int i) {
        return i & (-193);
    }

    public static String localeToResourceQualifier(Locale locale) {
        StringBuilder sb = new StringBuilder();
        boolean z = locale.getLanguage().length() != 0;
        boolean z2 = locale.getCountry().length() != 0;
        boolean z3 = locale.getScript().length() != 0;
        boolean z4 = locale.getVariant().length() != 0;
        if (z) {
            sb.append(locale.getLanguage());
            if (z2) {
                sb.append("-r").append(locale.getCountry());
                if (z3) {
                    sb.append("-s").append(locale.getScript());
                    if (z4) {
                        sb.append("-v").append(locale.getVariant());
                    }
                }
            }
        }
        return sb.toString();
    }

    public static boolean needNewResources(int i, int i2) {
        return (((1073741824 | i2) | 1048576) & i) != 0;
    }

    public static void readXmlAttrs(XmlPullParser xmlPullParser, Configuration configuration) throws XmlPullParserException, IOException {
        configuration.fontScale = Float.intBitsToFloat(XmlUtils.readIntAttribute(xmlPullParser, XML_ATTR_FONT_SCALE, 0));
        configuration.mcc = XmlUtils.readIntAttribute(xmlPullParser, "mcc", 0);
        configuration.mnc = XmlUtils.readIntAttribute(xmlPullParser, "mnc", 0);
        String readStringAttribute = XmlUtils.readStringAttribute(xmlPullParser, "locale");
        if (readStringAttribute != null) {
            configuration.locale = Locale.forLanguageTag(readStringAttribute);
        }
        configuration.touchscreen = XmlUtils.readIntAttribute(xmlPullParser, XML_ATTR_TOUCHSCREEN, 0);
        configuration.keyboard = XmlUtils.readIntAttribute(xmlPullParser, "key", 0);
        configuration.keyboardHidden = XmlUtils.readIntAttribute(xmlPullParser, XML_ATTR_KEYBOARD_HIDDEN, 0);
        configuration.hardKeyboardHidden = XmlUtils.readIntAttribute(xmlPullParser, XML_ATTR_HARD_KEYBOARD_HIDDEN, 0);
        configuration.navigation = XmlUtils.readIntAttribute(xmlPullParser, XML_ATTR_NAVIGATION, 0);
        configuration.navigationHidden = XmlUtils.readIntAttribute(xmlPullParser, XML_ATTR_NAVIGATION_HIDDEN, 0);
        configuration.orientation = XmlUtils.readIntAttribute(xmlPullParser, XML_ATTR_ORIENTATION, 0);
        configuration.screenLayout = XmlUtils.readIntAttribute(xmlPullParser, XML_ATTR_SCREEN_LAYOUT, 0);
        configuration.uiMode = XmlUtils.readIntAttribute(xmlPullParser, XML_ATTR_UI_MODE, 0);
        configuration.screenWidthDp = XmlUtils.readIntAttribute(xmlPullParser, "width", 0);
        configuration.screenHeightDp = XmlUtils.readIntAttribute(xmlPullParser, "height", 0);
        configuration.smallestScreenWidthDp = XmlUtils.readIntAttribute(xmlPullParser, XML_ATTR_SMALLEST_WIDTH, 0);
        configuration.densityDpi = XmlUtils.readIntAttribute(xmlPullParser, XML_ATTR_DENSITY, 0);
    }

    public static int reduceScreenLayout(int i, int i2, int i3) {
        int i4;
        boolean z;
        boolean z2;
        if (i2 < 470) {
            i4 = 1;
            z2 = false;
            z = false;
        } else {
            i4 = (i2 < 960 || i3 < 720) ? (i2 < 640 || i3 < 480) ? 2 : 3 : 4;
            z = i3 > 321 || i2 > 570;
            z2 = (i2 * 3) / 5 >= i3 - 1;
        }
        int i5 = i;
        if (!z2) {
            i5 = (i & (-49)) | 16;
        }
        int i6 = i5;
        if (z) {
            i6 = i5 | 268435456;
        }
        int i7 = i6;
        if (i4 < (i6 & 15)) {
            i7 = (i6 & (-16)) | i4;
        }
        return i7;
    }

    public static int resetScreenLayout(int i) {
        return ((-268435520) & i) | 36;
    }

    public static String resourceQualifierString(Configuration configuration) {
        ArrayList arrayList = new ArrayList();
        if (configuration.mcc != 0) {
            arrayList.add("mcc" + configuration.mcc);
            if (configuration.mnc != 0) {
                arrayList.add("mnc" + configuration.mnc);
            }
        }
        if (configuration.locale != null && !configuration.locale.getLanguage().isEmpty()) {
            arrayList.add(localeToResourceQualifier(configuration.locale));
        }
        switch (configuration.screenLayout & 192) {
            case 64:
                arrayList.add("ldltr");
                break;
            case 128:
                arrayList.add("ldrtl");
                break;
        }
        if (configuration.smallestScreenWidthDp != 0) {
            arrayList.add(XML_ATTR_SMALLEST_WIDTH + configuration.smallestScreenWidthDp + t.q);
        }
        if (configuration.screenWidthDp != 0) {
            arrayList.add(IAdInterListener.AdReqParam.WIDTH + configuration.screenWidthDp + t.q);
        }
        if (configuration.screenHeightDp != 0) {
            arrayList.add("h" + configuration.screenHeightDp + t.q);
        }
        switch (configuration.screenLayout & 15) {
            case 1:
                arrayList.add("small");
                break;
            case 2:
                arrayList.add("normal");
                break;
            case 3:
                arrayList.add("large");
                break;
            case 4:
                arrayList.add("xlarge");
                break;
        }
        switch (configuration.screenLayout & 48) {
            case 16:
                arrayList.add("notlong");
                break;
            case 32:
                arrayList.add("long");
                break;
        }
        switch (configuration.orientation) {
            case 1:
                arrayList.add(KeyChain.EXTRA_PORT);
                break;
            case 2:
                arrayList.add("land");
                break;
        }
        switch (configuration.uiMode & 15) {
            case 2:
                arrayList.add("desk");
                break;
            case 3:
                arrayList.add("car");
                break;
            case 4:
                arrayList.add("television");
                break;
            case 5:
                arrayList.add("appliance");
                break;
            case 6:
                arrayList.add("watch");
                break;
        }
        switch (configuration.uiMode & 48) {
            case 16:
                arrayList.add("notnight");
                break;
            case 32:
                arrayList.add(Camera.Parameters.SCENE_MODE_NIGHT);
                break;
        }
        switch (configuration.densityDpi) {
            case 0:
                break;
            case 120:
                arrayList.add("ldpi");
                break;
            case 160:
                arrayList.add("mdpi");
                break;
            case 213:
                arrayList.add("tvdpi");
                break;
            case 240:
                arrayList.add("hdpi");
                break;
            case 320:
                arrayList.add("xhdpi");
                break;
            case 480:
                arrayList.add("xxhdpi");
                break;
            case 640:
                arrayList.add("xxxhdpi");
                break;
            case DENSITY_DPI_ANY /* 65534 */:
                arrayList.add("anydpi");
                break;
            case 65535:
                arrayList.add("nodpi");
            default:
                arrayList.add(configuration.densityDpi + "dpi");
                break;
        }
        switch (configuration.touchscreen) {
            case 1:
                arrayList.add("notouch");
                break;
            case 3:
                arrayList.add("finger");
                break;
        }
        switch (configuration.keyboardHidden) {
            case 1:
                arrayList.add("keysexposed");
                break;
            case 2:
                arrayList.add("keyshidden");
                break;
            case 3:
                arrayList.add("keyssoft");
                break;
        }
        switch (configuration.keyboard) {
            case 1:
                arrayList.add("nokeys");
                break;
            case 2:
                arrayList.add("qwerty");
                break;
            case 3:
                arrayList.add("12key");
                break;
        }
        switch (configuration.navigationHidden) {
            case 1:
                arrayList.add("navexposed");
                break;
            case 2:
                arrayList.add("navhidden");
                break;
        }
        switch (configuration.navigation) {
            case 1:
                arrayList.add("nonav");
                break;
            case 2:
                arrayList.add("dpad");
                break;
            case 3:
                arrayList.add("trackball");
                break;
            case 4:
                arrayList.add("wheel");
                break;
        }
        arrayList.add("v" + Build.VERSION.RESOURCES_SDK_INT);
        return TextUtils.join(Constants.ACCEPT_TIME_SEPARATOR_SERVER, arrayList);
    }

    public static void writeXmlAttrs(XmlSerializer xmlSerializer, Configuration configuration) throws IOException {
        XmlUtils.writeIntAttribute(xmlSerializer, XML_ATTR_FONT_SCALE, Float.floatToIntBits(configuration.fontScale));
        if (configuration.mcc != 0) {
            XmlUtils.writeIntAttribute(xmlSerializer, "mcc", configuration.mcc);
        }
        if (configuration.mnc != 0) {
            XmlUtils.writeIntAttribute(xmlSerializer, "mnc", configuration.mnc);
        }
        if (configuration.locale != null) {
            XmlUtils.writeStringAttribute(xmlSerializer, "locale", configuration.locale.toLanguageTag());
        }
        if (configuration.touchscreen != 0) {
            XmlUtils.writeIntAttribute(xmlSerializer, XML_ATTR_TOUCHSCREEN, configuration.touchscreen);
        }
        if (configuration.keyboard != 0) {
            XmlUtils.writeIntAttribute(xmlSerializer, "key", configuration.keyboard);
        }
        if (configuration.keyboardHidden != 0) {
            XmlUtils.writeIntAttribute(xmlSerializer, XML_ATTR_KEYBOARD_HIDDEN, configuration.keyboardHidden);
        }
        if (configuration.hardKeyboardHidden != 0) {
            XmlUtils.writeIntAttribute(xmlSerializer, XML_ATTR_HARD_KEYBOARD_HIDDEN, configuration.hardKeyboardHidden);
        }
        if (configuration.navigation != 0) {
            XmlUtils.writeIntAttribute(xmlSerializer, XML_ATTR_NAVIGATION, configuration.navigation);
        }
        if (configuration.navigationHidden != 0) {
            XmlUtils.writeIntAttribute(xmlSerializer, XML_ATTR_NAVIGATION_HIDDEN, configuration.navigationHidden);
        }
        if (configuration.orientation != 0) {
            XmlUtils.writeIntAttribute(xmlSerializer, XML_ATTR_ORIENTATION, configuration.orientation);
        }
        if (configuration.screenLayout != 0) {
            XmlUtils.writeIntAttribute(xmlSerializer, XML_ATTR_SCREEN_LAYOUT, configuration.screenLayout);
        }
        if (configuration.uiMode != 0) {
            XmlUtils.writeIntAttribute(xmlSerializer, XML_ATTR_UI_MODE, configuration.uiMode);
        }
        if (configuration.screenWidthDp != 0) {
            XmlUtils.writeIntAttribute(xmlSerializer, "width", configuration.screenWidthDp);
        }
        if (configuration.screenHeightDp != 0) {
            XmlUtils.writeIntAttribute(xmlSerializer, "height", configuration.screenHeightDp);
        }
        if (configuration.smallestScreenWidthDp != 0) {
            XmlUtils.writeIntAttribute(xmlSerializer, XML_ATTR_SMALLEST_WIDTH, configuration.smallestScreenWidthDp);
        }
        if (configuration.densityDpi != 0) {
            XmlUtils.writeIntAttribute(xmlSerializer, XML_ATTR_DENSITY, configuration.densityDpi);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x00b0, code lost:
        if (r0 == 0) goto L19;
     */
    @Override // java.lang.Comparable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int compareTo(android.content.res.Configuration r4) {
        /*
            Method dump skipped, instructions count: 471
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.content.res.Configuration.compareTo(android.content.res.Configuration):int");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:105:0x0260, code lost:
        if (r0.equals(r4.themeConfig.getFontPkgName()) == false) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0077, code lost:
        if (r4.locale.equals(r5.locale) == false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0235, code lost:
        if (r4.themeConfig.equals(r5.themeConfig) == false) goto L99;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int diff(android.content.res.Configuration r5) {
        /*
            Method dump skipped, instructions count: 619
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.content.res.Configuration.diff(android.content.res.Configuration):int");
    }

    public boolean equals(Configuration configuration) {
        boolean z;
        if (configuration == null) {
            z = false;
        } else {
            z = true;
            if (configuration != this) {
                z = true;
                if (compareTo(configuration) != 0) {
                    return false;
                }
            }
        }
        return z;
    }

    public boolean equals(Object obj) {
        try {
            return equals((Configuration) obj);
        } catch (ClassCastException e) {
            return false;
        }
    }

    public int getLayoutDirection() {
        return (this.screenLayout & 192) == 128 ? 1 : 0;
    }

    public int hashCode() {
        int i = 0;
        int floatToIntBits = Float.floatToIntBits(this.fontScale);
        int i2 = this.mcc;
        int i3 = this.mnc;
        int hashCode = this.locale != null ? this.locale.hashCode() : 0;
        int i4 = this.touchscreen;
        int i5 = this.keyboard;
        int i6 = this.keyboardHidden;
        int i7 = this.hardKeyboardHidden;
        int i8 = this.navigation;
        int i9 = this.navigationHidden;
        int i10 = this.orientation;
        int i11 = this.screenLayout;
        int i12 = this.uiMode;
        int i13 = this.screenWidthDp;
        int i14 = this.screenHeightDp;
        int i15 = this.smallestScreenWidthDp;
        int i16 = this.densityDpi;
        if (this.themeConfig != null) {
            i = this.themeConfig.hashCode();
        }
        return ((((((((((((((((((((((((((((((((((floatToIntBits + LiveProtos.Event.LIVE_END_PAGE_CLOSE_CLICK_VALUE) * 31) + i2) * 31) + i3) * 31) + hashCode) * 31) + i4) * 31) + i5) * 31) + i6) * 31) + i7) * 31) + i8) * 31) + i9) * 31) + i10) * 31) + i11) * 31) + i12) * 31) + i13) * 31) + i14) * 31) + i15) * 31) + i16) * 31) + i;
    }

    public boolean isLayoutSizeAtLeast(int i) {
        int i2 = this.screenLayout & 15;
        return i2 != 0 && i2 >= i;
    }

    public boolean isOtherSeqNewer(Configuration configuration) {
        boolean z;
        if (configuration == null) {
            z = false;
        } else {
            z = true;
            if (configuration.seq != 0) {
                z = true;
                if (this.seq != 0) {
                    int i = configuration.seq - this.seq;
                    if (i > 65536) {
                        return false;
                    }
                    z = true;
                    if (i <= 0) {
                        return false;
                    }
                }
            }
        }
        return z;
    }

    @Deprecated
    public void makeDefault() {
        setToDefaults();
    }

    public void readFromParcel(Parcel parcel) {
        boolean z = true;
        this.fontScale = parcel.readFloat();
        this.mcc = parcel.readInt();
        this.mnc = parcel.readInt();
        if (parcel.readInt() != 0) {
            this.locale = new Locale(parcel.readString(), parcel.readString(), parcel.readString());
        }
        if (parcel.readInt() != 1) {
            z = false;
        }
        this.userSetLocale = z;
        this.touchscreen = parcel.readInt();
        this.keyboard = parcel.readInt();
        this.keyboardHidden = parcel.readInt();
        this.hardKeyboardHidden = parcel.readInt();
        this.navigation = parcel.readInt();
        this.navigationHidden = parcel.readInt();
        this.orientation = parcel.readInt();
        this.screenLayout = parcel.readInt();
        this.uiMode = parcel.readInt();
        this.screenWidthDp = parcel.readInt();
        this.screenHeightDp = parcel.readInt();
        this.smallestScreenWidthDp = parcel.readInt();
        this.densityDpi = parcel.readInt();
        this.compatScreenWidthDp = parcel.readInt();
        this.compatScreenHeightDp = parcel.readInt();
        this.compatSmallestScreenWidthDp = parcel.readInt();
        this.seq = parcel.readInt();
        this.themeConfig = (ThemeConfig) parcel.readParcelable(ThemeConfig.class.getClassLoader());
    }

    public void setLayoutDirection(Locale locale) {
        this.screenLayout = (this.screenLayout & (-193)) | ((TextUtils.getLayoutDirectionFromLocale(locale) + 1) << 6);
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
        this.userSetLocale = true;
        setLayoutDirection(this.locale);
    }

    public void setTo(Configuration configuration) {
        this.fontScale = configuration.fontScale;
        this.mcc = configuration.mcc;
        this.mnc = configuration.mnc;
        if (configuration.locale != null) {
            this.locale = (Locale) configuration.locale.clone();
        }
        this.userSetLocale = configuration.userSetLocale;
        this.touchscreen = configuration.touchscreen;
        this.keyboard = configuration.keyboard;
        this.keyboardHidden = configuration.keyboardHidden;
        this.hardKeyboardHidden = configuration.hardKeyboardHidden;
        this.navigation = configuration.navigation;
        this.navigationHidden = configuration.navigationHidden;
        this.orientation = configuration.orientation;
        this.screenLayout = configuration.screenLayout;
        this.uiMode = configuration.uiMode;
        this.screenWidthDp = configuration.screenWidthDp;
        this.screenHeightDp = configuration.screenHeightDp;
        this.smallestScreenWidthDp = configuration.smallestScreenWidthDp;
        this.densityDpi = configuration.densityDpi;
        this.compatScreenWidthDp = configuration.compatScreenWidthDp;
        this.compatScreenHeightDp = configuration.compatScreenHeightDp;
        this.compatSmallestScreenWidthDp = configuration.compatSmallestScreenWidthDp;
        this.seq = configuration.seq;
        if (configuration.themeConfig != null) {
            this.themeConfig = (ThemeConfig) configuration.themeConfig.clone();
        }
    }

    public void setToDefaults() {
        this.fontScale = 1.0f;
        this.mnc = 0;
        this.mcc = 0;
        this.locale = null;
        this.userSetLocale = false;
        this.touchscreen = 0;
        this.keyboard = 0;
        this.keyboardHidden = 0;
        this.hardKeyboardHidden = 0;
        this.navigation = 0;
        this.navigationHidden = 0;
        this.orientation = 0;
        this.screenLayout = 0;
        this.uiMode = 0;
        this.compatScreenWidthDp = 0;
        this.screenWidthDp = 0;
        this.compatScreenHeightDp = 0;
        this.screenHeightDp = 0;
        this.compatSmallestScreenWidthDp = 0;
        this.smallestScreenWidthDp = 0;
        this.densityDpi = 0;
        this.seq = 0;
        this.themeConfig = null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("{");
        sb.append(this.fontScale);
        sb.append(" ");
        if (this.mcc != 0) {
            sb.append(this.mcc);
            sb.append("mcc");
        } else {
            sb.append("?mcc");
        }
        if (this.mnc != 0) {
            sb.append(this.mnc);
            sb.append("mnc");
        } else {
            sb.append("?mnc");
        }
        if (this.locale != null) {
            sb.append(" ");
            sb.append(this.locale);
        } else {
            sb.append(" ?locale");
        }
        int i = this.screenLayout & 192;
        switch (i) {
            case 0:
                sb.append(" ?layoutDir");
                break;
            case 64:
                sb.append(" ldltr");
                break;
            case 128:
                sb.append(" ldrtl");
                break;
            default:
                sb.append(" layoutDir=");
                sb.append(i >> 6);
                break;
        }
        if (this.smallestScreenWidthDp != 0) {
            sb.append(" sw");
            sb.append(this.smallestScreenWidthDp);
            sb.append(t.q);
        } else {
            sb.append(" ?swdp");
        }
        if (this.screenWidthDp != 0) {
            sb.append(" w");
            sb.append(this.screenWidthDp);
            sb.append(t.q);
        } else {
            sb.append(" ?wdp");
        }
        if (this.screenHeightDp != 0) {
            sb.append(" h");
            sb.append(this.screenHeightDp);
            sb.append(t.q);
        } else {
            sb.append(" ?hdp");
        }
        if (this.densityDpi != 0) {
            sb.append(" ");
            sb.append(this.densityDpi);
            sb.append("dpi");
        } else {
            sb.append(" ?density");
        }
        switch (this.screenLayout & 15) {
            case 0:
                sb.append(" ?lsize");
                break;
            case 1:
                sb.append(" smll");
                break;
            case 2:
                sb.append(" nrml");
                break;
            case 3:
                sb.append(" lrg");
                break;
            case 4:
                sb.append(" xlrg");
                break;
            default:
                sb.append(" layoutSize=");
                sb.append(this.screenLayout & 15);
                break;
        }
        switch (this.screenLayout & 48) {
            case 0:
                sb.append(" ?long");
                break;
            case 16:
                break;
            case 32:
                sb.append(" long");
                break;
            default:
                sb.append(" layoutLong=");
                sb.append(this.screenLayout & 48);
                break;
        }
        switch (this.orientation) {
            case 0:
                sb.append(" ?orien");
                break;
            case 1:
                sb.append(" port");
                break;
            case 2:
                sb.append(" land");
                break;
            default:
                sb.append(" orien=");
                sb.append(this.orientation);
                break;
        }
        switch (this.uiMode & 15) {
            case 0:
                sb.append(" ?uimode");
                break;
            case 1:
                break;
            case 2:
                sb.append(" desk");
                break;
            case 3:
                sb.append(" car");
                break;
            case 4:
                sb.append(" television");
                break;
            case 5:
                sb.append(" appliance");
                break;
            case 6:
                sb.append(" watch");
                break;
            default:
                sb.append(" uimode=");
                sb.append(this.uiMode & 15);
                break;
        }
        switch (this.uiMode & 48) {
            case 0:
                sb.append(" ?night");
                break;
            case 16:
                break;
            case 32:
                sb.append(" night");
                break;
            default:
                sb.append(" night=");
                sb.append(this.uiMode & 48);
                break;
        }
        switch (this.touchscreen) {
            case 0:
                sb.append(" ?touch");
                break;
            case 1:
                sb.append(" -touch");
                break;
            case 2:
                sb.append(" stylus");
                break;
            case 3:
                sb.append(" finger");
                break;
            default:
                sb.append(" touch=");
                sb.append(this.touchscreen);
                break;
        }
        switch (this.keyboard) {
            case 0:
                sb.append(" ?keyb");
                break;
            case 1:
                sb.append(" -keyb");
                break;
            case 2:
                sb.append(" qwerty");
                break;
            case 3:
                sb.append(" 12key");
                break;
            default:
                sb.append(" keys=");
                sb.append(this.keyboard);
                break;
        }
        switch (this.keyboardHidden) {
            case 0:
                sb.append("/?");
                break;
            case 1:
                sb.append("/v");
                break;
            case 2:
                sb.append("/h");
                break;
            case 3:
                sb.append("/s");
                break;
            default:
                sb.append("/");
                sb.append(this.keyboardHidden);
                break;
        }
        switch (this.hardKeyboardHidden) {
            case 0:
                sb.append("/?");
                break;
            case 1:
                sb.append("/v");
                break;
            case 2:
                sb.append("/h");
                break;
            default:
                sb.append("/");
                sb.append(this.hardKeyboardHidden);
                break;
        }
        switch (this.navigation) {
            case 0:
                sb.append(" ?nav");
                break;
            case 1:
                sb.append(" -nav");
                break;
            case 2:
                sb.append(" dpad");
                break;
            case 3:
                sb.append(" tball");
                break;
            case 4:
                sb.append(" wheel");
                break;
            default:
                sb.append(" nav=");
                sb.append(this.navigation);
                break;
        }
        switch (this.navigationHidden) {
            case 0:
                sb.append("/?");
                break;
            case 1:
                sb.append("/v");
                break;
            case 2:
                sb.append("/h");
                break;
            default:
                sb.append("/");
                sb.append(this.navigationHidden);
                break;
        }
        if (this.seq != 0) {
            sb.append(" s.");
            sb.append(this.seq);
        }
        sb.append(" themeResource=");
        sb.append(this.themeConfig);
        sb.append('}');
        return sb.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:128:0x0392, code lost:
        if (r5.themeConfig.equals(r6.themeConfig) == false) goto L130;
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x03c0, code lost:
        if (r0.equals(r5.themeConfig.getFontPkgName()) == false) goto L137;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x008f, code lost:
        if (r5.locale.equals(r6.locale) == false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0106, code lost:
        if ((r8 & 4) != 0) goto L38;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int updateFrom(android.content.res.Configuration r6) {
        /*
            Method dump skipped, instructions count: 1004
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.content.res.Configuration.updateFrom(android.content.res.Configuration):int");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(this.fontScale);
        parcel.writeInt(this.mcc);
        parcel.writeInt(this.mnc);
        if (this.locale == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeString(this.locale.getLanguage());
            parcel.writeString(this.locale.getCountry());
            parcel.writeString(this.locale.getVariant());
        }
        if (this.userSetLocale) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeInt(this.touchscreen);
        parcel.writeInt(this.keyboard);
        parcel.writeInt(this.keyboardHidden);
        parcel.writeInt(this.hardKeyboardHidden);
        parcel.writeInt(this.navigation);
        parcel.writeInt(this.navigationHidden);
        parcel.writeInt(this.orientation);
        parcel.writeInt(this.screenLayout);
        parcel.writeInt(this.uiMode);
        parcel.writeInt(this.screenWidthDp);
        parcel.writeInt(this.screenHeightDp);
        parcel.writeInt(this.smallestScreenWidthDp);
        parcel.writeInt(this.densityDpi);
        parcel.writeInt(this.compatScreenWidthDp);
        parcel.writeInt(this.compatScreenHeightDp);
        parcel.writeInt(this.compatSmallestScreenWidthDp);
        parcel.writeInt(this.seq);
        parcel.writeParcelable(this.themeConfig, i);
    }
}
