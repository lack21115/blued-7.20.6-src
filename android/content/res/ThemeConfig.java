package android.content.res;

import android.content.ContentResolver;
import android.content.res.ThemeChangeRequest;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.UserHandle;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.JsonReader;
import android.util.JsonToken;
import android.util.JsonWriter;
import android.util.Log;
import com.blued.das.live.LiveProtos;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/* loaded from: source-9557208-dex2jar.jar:android/content/res/ThemeConfig.class */
public class ThemeConfig implements Cloneable, Parcelable, Comparable<ThemeConfig> {
    private static final String KEY_DEFAULT_PKG = "default";
    public static final String SYSTEMUI_NAVBAR_PKG = "com.android.systemui.navbar";
    public static final String SYSTEMUI_STATUS_BAR_PKG = "com.android.systemui";
    public static final String SYSTEM_DEFAULT = "system";
    public static final String TAG = ThemeConfig.class.getCanonicalName();
    private static final SystemConfig mSystemConfig = new SystemConfig();
    private static final SystemAppTheme mSystemAppTheme = new SystemAppTheme();
    public static final Parcelable.Creator<ThemeConfig> CREATOR = new Parcelable.Creator<ThemeConfig>() { // from class: android.content.res.ThemeConfig.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ThemeConfig createFromParcel(Parcel parcel) {
            ThemeConfig fromJson = JsonSerializer.fromJson(parcel.readString());
            fromJson.mLastThemeChangeRequestType = ThemeChangeRequest.RequestType.values()[parcel.readInt()];
            return fromJson;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ThemeConfig[] newArray(int i) {
            return new ThemeConfig[i];
        }
    };
    protected final Map<String, AppTheme> mThemes = new HashMap();
    private ThemeChangeRequest.RequestType mLastThemeChangeRequestType = ThemeChangeRequest.RequestType.USER_REQUEST;

    /* loaded from: source-9557208-dex2jar.jar:android/content/res/ThemeConfig$AppTheme.class */
    public static class AppTheme implements Cloneable, Comparable<AppTheme> {
        String mFontPkgName;
        String mIconPkgName;
        String mOverlayPkgName;

        public AppTheme(String str, String str2, String str3) {
            this.mOverlayPkgName = str;
            this.mIconPkgName = str2;
            this.mFontPkgName = str3;
        }

        @Override // java.lang.Comparable
        public int compareTo(AppTheme appTheme) {
            int i;
            if (appTheme == null) {
                i = -1;
            } else {
                int compareTo = this.mIconPkgName.compareTo(appTheme.mIconPkgName);
                i = compareTo;
                if (compareTo == 0) {
                    int compareTo2 = this.mFontPkgName.compareTo(appTheme.mFontPkgName);
                    i = compareTo2;
                    if (compareTo2 == 0) {
                        return this.mOverlayPkgName.equals(appTheme.mOverlayPkgName) ? 0 : 1;
                    }
                }
            }
            return i;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof AppTheme) {
                AppTheme appTheme = (AppTheme) obj;
                return (this.mIconPkgName == null ? "" : this.mIconPkgName).equals(appTheme.mIconPkgName == null ? "" : appTheme.mIconPkgName) && (this.mFontPkgName == null ? "" : this.mFontPkgName).equals(appTheme.mFontPkgName == null ? "" : appTheme.mFontPkgName) && (this.mOverlayPkgName == null ? "" : this.mOverlayPkgName).equals(appTheme.mOverlayPkgName == null ? "" : appTheme.mOverlayPkgName);
            }
            return false;
        }

        public String getFontPackPkgName() {
            return this.mFontPkgName;
        }

        public String getIconPackPkgName() {
            return this.mIconPkgName;
        }

        public String getOverlayPkgName() {
            return this.mOverlayPkgName;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2;
            int i = 0;
            synchronized (this) {
                hashCode = this.mOverlayPkgName == null ? 0 : this.mOverlayPkgName.hashCode();
                hashCode2 = this.mIconPkgName == null ? 0 : this.mIconPkgName.hashCode();
                if (this.mFontPkgName != null) {
                    i = this.mFontPkgName.hashCode();
                }
            }
            return ((((hashCode + LiveProtos.Event.LIVE_END_PAGE_CLOSE_CLICK_VALUE) * 31) + hashCode2) * 31) + i;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (this.mOverlayPkgName != null) {
                sb.append("overlay:");
                sb.append(this.mOverlayPkgName);
            }
            if (!TextUtils.isEmpty(this.mIconPkgName)) {
                sb.append(", iconPack:");
                sb.append(this.mIconPkgName);
            }
            if (!TextUtils.isEmpty(this.mFontPkgName)) {
                sb.append(", fontPkg:");
                sb.append(this.mFontPkgName);
            }
            return sb.toString();
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/content/res/ThemeConfig$Builder.class */
    public static class Builder {
        private HashMap<String, String> mFonts;
        private HashMap<String, String> mIcons;
        private ThemeChangeRequest.RequestType mLastThemeChangeRequestType;
        private HashMap<String, String> mOverlays;

        public Builder() {
            this.mOverlays = new HashMap<>();
            this.mIcons = new HashMap<>();
            this.mFonts = new HashMap<>();
            this.mLastThemeChangeRequestType = ThemeChangeRequest.RequestType.USER_REQUEST;
        }

        public Builder(ThemeConfig themeConfig) {
            this.mOverlays = new HashMap<>();
            this.mIcons = new HashMap<>();
            this.mFonts = new HashMap<>();
            this.mLastThemeChangeRequestType = ThemeChangeRequest.RequestType.USER_REQUEST;
            for (Map.Entry<String, AppTheme> entry : themeConfig.mThemes.entrySet()) {
                String key = entry.getKey();
                AppTheme value = entry.getValue();
                this.mFonts.put(key, value.getFontPackPkgName());
                this.mIcons.put(key, value.getIconPackPkgName());
                this.mOverlays.put(key, value.getOverlayPkgName());
            }
            this.mLastThemeChangeRequestType = themeConfig.mLastThemeChangeRequestType;
        }

        public ThemeConfig build() {
            HashSet hashSet = new HashSet();
            hashSet.addAll(this.mOverlays.keySet());
            hashSet.addAll(this.mIcons.keySet());
            hashSet.addAll(this.mFonts.keySet());
            HashMap hashMap = new HashMap();
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                String str2 = this.mIcons.get(str);
                String str3 = this.mOverlays.get(str);
                String str4 = this.mFonts.get(str);
                if (str3 != null || str2 != null || str4 != null) {
                    hashMap.put(str, new AppTheme(str3, str2, str4));
                } else if (hashMap.containsKey(str)) {
                    hashMap.remove(str);
                }
            }
            ThemeConfig themeConfig = new ThemeConfig(hashMap);
            themeConfig.mLastThemeChangeRequestType = this.mLastThemeChangeRequestType;
            return themeConfig;
        }

        public Builder defaultFont(String str) {
            if (str != null) {
                this.mFonts.put("default", str);
                return this;
            }
            this.mFonts.remove("default");
            return this;
        }

        public Builder defaultIcon(String str) {
            if (str != null) {
                this.mIcons.put("default", str);
                return this;
            }
            this.mIcons.remove("default");
            return this;
        }

        public Builder defaultOverlay(String str) {
            if (str != null) {
                this.mOverlays.put("default", str);
                return this;
            }
            this.mOverlays.remove("default");
            return this;
        }

        public Builder font(String str, String str2) {
            if (str2 != null) {
                this.mFonts.put(str, str2);
                return this;
            }
            this.mFonts.remove(str);
            return this;
        }

        public Builder icon(String str, String str2) {
            if (str2 != null) {
                this.mIcons.put(str, str2);
                return this;
            }
            this.mIcons.remove(str);
            return this;
        }

        public Builder overlay(String str, String str2) {
            if (str2 != null) {
                this.mOverlays.put(str, str2);
                return this;
            }
            this.mOverlays.remove(str);
            return this;
        }

        public Builder setLastThemeChangeRequestType(ThemeChangeRequest.RequestType requestType) {
            this.mLastThemeChangeRequestType = requestType;
            return this;
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/content/res/ThemeConfig$JsonSerializer.class */
    public static class JsonSerializer {
        private static final String NAME_FONT_PKG = "mFontPkgName";
        private static final String NAME_ICON_PKG = "mIconPkgName";
        private static final String NAME_OVERLAY_PKG = "mOverlayPkgName";

        private static void closeQuietly(JsonReader jsonReader) {
            if (jsonReader != null) {
                try {
                    jsonReader.close();
                } catch (IOException e) {
                }
            }
        }

        private static void closeQuietly(JsonWriter jsonWriter) {
            if (jsonWriter != null) {
                try {
                    jsonWriter.close();
                } catch (IOException e) {
                }
            }
        }

        private static void closeQuietly(Reader reader) {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                }
            }
        }

        private static void closeQuietly(Writer writer) {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                }
            }
        }

        public static ThemeConfig fromJson(String str) {
            StringReader stringReader;
            if (str == null) {
                return null;
            }
            HashMap hashMap = new HashMap();
            StringReader stringReader2 = null;
            JsonReader jsonReader = null;
            JsonReader jsonReader2 = null;
            try {
                try {
                    stringReader = new StringReader(str);
                    try {
                        jsonReader = new JsonReader(stringReader);
                    } catch (Exception e) {
                        e = e;
                    } catch (Throwable th) {
                        th = th;
                        jsonReader = null;
                        stringReader2 = stringReader;
                    }
                    try {
                        jsonReader.beginObject();
                        while (jsonReader.hasNext()) {
                            hashMap.put(jsonReader.nextName(), readAppTheme(jsonReader));
                        }
                        jsonReader.endObject();
                        closeQuietly(stringReader);
                        closeQuietly(jsonReader);
                    } catch (Exception e2) {
                        e = e2;
                        jsonReader2 = jsonReader;
                        jsonReader = jsonReader2;
                        stringReader2 = stringReader;
                        Log.e(ThemeConfig.TAG, "Could not parse ThemeConfig from: " + str, e);
                        closeQuietly(stringReader);
                        closeQuietly(jsonReader2);
                        return new ThemeConfig(hashMap);
                    } catch (Throwable th2) {
                        th = th2;
                        stringReader2 = stringReader;
                        closeQuietly(stringReader2);
                        closeQuietly(jsonReader);
                        throw th;
                    }
                } catch (Exception e3) {
                    e = e3;
                    stringReader = null;
                }
                return new ThemeConfig(hashMap);
            } catch (Throwable th3) {
                th = th3;
            }
        }

        private static AppTheme readAppTheme(JsonReader jsonReader) throws IOException {
            String str = null;
            String str2 = null;
            String str3 = null;
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if (NAME_OVERLAY_PKG.equals(nextName) && jsonReader.peek() != JsonToken.NULL) {
                    str = jsonReader.nextString();
                } else if (NAME_ICON_PKG.equals(nextName) && jsonReader.peek() != JsonToken.NULL) {
                    str2 = jsonReader.nextString();
                } else if (!NAME_FONT_PKG.equals(nextName) || jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                } else {
                    str3 = jsonReader.nextString();
                }
            }
            jsonReader.endObject();
            return new AppTheme(str, str2, str3);
        }

        public static String toJson(ThemeConfig themeConfig) {
            StringWriter stringWriter;
            StringWriter stringWriter2 = null;
            JsonWriter jsonWriter = null;
            JsonWriter jsonWriter2 = null;
            try {
                try {
                    StringWriter stringWriter3 = new StringWriter();
                    try {
                        jsonWriter = new JsonWriter(stringWriter3);
                        try {
                            writeTheme(jsonWriter, themeConfig);
                            String obj = stringWriter3.toString();
                            closeQuietly(stringWriter3);
                            closeQuietly(jsonWriter);
                            return obj;
                        } catch (IOException e) {
                            stringWriter = stringWriter3;
                            e = e;
                            jsonWriter2 = jsonWriter;
                            Log.e(ThemeConfig.TAG, "Could not write theme mapping", e);
                            closeQuietly(stringWriter);
                            closeQuietly(jsonWriter2);
                            return null;
                        } catch (Throwable th) {
                            th = th;
                            stringWriter2 = stringWriter3;
                            closeQuietly(stringWriter2);
                            closeQuietly(jsonWriter);
                            throw th;
                        }
                    } catch (IOException e2) {
                        stringWriter = stringWriter3;
                        e = e2;
                    } catch (Throwable th2) {
                        th = th2;
                        jsonWriter = null;
                        stringWriter2 = stringWriter3;
                    }
                } catch (IOException e3) {
                    e = e3;
                    stringWriter = null;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }

        private static void writeAppTheme(JsonWriter jsonWriter, AppTheme appTheme) throws IOException {
            jsonWriter.beginObject();
            jsonWriter.name(NAME_OVERLAY_PKG).value(appTheme.mOverlayPkgName);
            jsonWriter.name(NAME_ICON_PKG).value(appTheme.mIconPkgName);
            jsonWriter.name(NAME_FONT_PKG).value(appTheme.mFontPkgName);
            jsonWriter.endObject();
        }

        private static void writeTheme(JsonWriter jsonWriter, ThemeConfig themeConfig) throws IOException {
            jsonWriter.beginObject();
            for (Map.Entry<String, AppTheme> entry : themeConfig.mThemes.entrySet()) {
                jsonWriter.name(entry.getKey());
                writeAppTheme(jsonWriter, entry.getValue());
            }
            jsonWriter.endObject();
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/content/res/ThemeConfig$SystemAppTheme.class */
    public static class SystemAppTheme extends AppTheme {
        public SystemAppTheme() {
            super("system", "system", "system");
        }

        @Override // android.content.res.ThemeConfig.AppTheme
        public String toString() {
            return "No Theme Applied (Holo)";
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/content/res/ThemeConfig$SystemConfig.class */
    public static class SystemConfig extends ThemeConfig {
        public SystemConfig() {
            super(new HashMap());
        }

        @Override // android.content.res.ThemeConfig, java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(ThemeConfig themeConfig) {
            return super.compareTo(themeConfig);
        }
    }

    public ThemeConfig(Map<String, AppTheme> map) {
        this.mThemes.putAll(map);
    }

    public static ThemeConfig fromJson(String str) {
        return JsonSerializer.fromJson(str);
    }

    public static ThemeConfig getBootTheme(ContentResolver contentResolver) {
        return getBootThemeForUser(contentResolver, UserHandle.getCallingUserId());
    }

    public static ThemeConfig getBootThemeForUser(ContentResolver contentResolver, int i) {
        SystemConfig systemConfig = mSystemConfig;
        try {
            ThemeConfig fromJson = fromJson(Settings.Secure.getStringForUser(contentResolver, Configuration.THEME_PKG_CONFIGURATION_PERSISTENCE_PROPERTY, i));
            ThemeConfig themeConfig = fromJson;
            if (fromJson == null) {
                String stringForUser = Settings.Secure.getStringForUser(contentResolver, Configuration.THEME_PACKAGE_NAME_PERSISTENCE_PROPERTY, i);
                String stringForUser2 = Settings.Secure.getStringForUser(contentResolver, Configuration.THEME_ICONPACK_PACKAGE_NAME_PERSISTENCE_PROPERTY, i);
                String stringForUser3 = Settings.Secure.getStringForUser(contentResolver, Configuration.THEME_FONT_PACKAGE_NAME_PERSISTENCE_PROPERTY, i);
                Builder builder = new Builder();
                builder.defaultOverlay(stringForUser);
                builder.defaultIcon(stringForUser2);
                builder.defaultFont(stringForUser3);
                systemConfig = fromJson;
                themeConfig = builder.build();
            }
            return themeConfig;
        } catch (SecurityException e) {
            Log.w(TAG, "Could not get boot theme", e);
            return systemConfig;
        }
    }

    private AppTheme getDefaultTheme() {
        AppTheme appTheme = this.mThemes.get("default");
        SystemAppTheme systemAppTheme = appTheme;
        if (appTheme == null) {
            systemAppTheme = mSystemAppTheme;
        }
        return systemAppTheme;
    }

    public static ThemeConfig getSystemTheme() {
        return mSystemConfig;
    }

    private AppTheme getThemeFor(String str) {
        AppTheme appTheme = this.mThemes.get(str);
        AppTheme appTheme2 = appTheme;
        if (appTheme == null) {
            appTheme2 = getDefaultTheme();
        }
        return appTheme2;
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            Log.d(TAG, "clone not supported", e);
            return null;
        }
    }

    @Override // java.lang.Comparable
    public int compareTo(ThemeConfig themeConfig) {
        if (themeConfig == null) {
            return -1;
        }
        return this.mThemes.equals(themeConfig.mThemes) ? 0 : 1;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ThemeConfig) {
            ThemeConfig themeConfig = (ThemeConfig) obj;
            return (this.mThemes == null ? new HashMap() : this.mThemes).equals(themeConfig.mThemes == null ? new HashMap() : themeConfig.mThemes) && this.mLastThemeChangeRequestType == themeConfig.mLastThemeChangeRequestType;
        }
        return false;
    }

    public Map<String, AppTheme> getAppThemes() {
        return Collections.unmodifiableMap(this.mThemes);
    }

    public String getFontPkgName() {
        return getDefaultTheme().mFontPkgName;
    }

    public String getFontPkgNameForApp(String str) {
        return getThemeFor(str).mFontPkgName;
    }

    public String getIconPackPkgName() {
        return getDefaultTheme().mIconPkgName;
    }

    public String getIconPackPkgNameForApp(String str) {
        return getThemeFor(str).mIconPkgName;
    }

    public ThemeChangeRequest.RequestType getLastThemeChangeRequestType() {
        return this.mLastThemeChangeRequestType;
    }

    public String getOverlayForNavBar() {
        return getOverlayPkgNameForApp(SYSTEMUI_NAVBAR_PKG);
    }

    public String getOverlayForStatusBar() {
        return getOverlayPkgNameForApp(SYSTEMUI_STATUS_BAR_PKG);
    }

    public String getOverlayPkgName() {
        return getDefaultTheme().mOverlayPkgName;
    }

    public String getOverlayPkgNameForApp(String str) {
        return getThemeFor(str).mOverlayPkgName;
    }

    public int hashCode() {
        return ((this.mThemes.hashCode() + LiveProtos.Event.LIVE_END_PAGE_CLOSE_CLICK_VALUE) * 31) + (this.mLastThemeChangeRequestType == null ? 0 : this.mLastThemeChangeRequestType.ordinal());
    }

    public String toJson() {
        return JsonSerializer.toJson(this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.mThemes != null) {
            sb.append("themes:");
            sb.append(this.mThemes);
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(JsonSerializer.toJson(this));
        parcel.writeInt(this.mLastThemeChangeRequestType.ordinal());
    }
}
