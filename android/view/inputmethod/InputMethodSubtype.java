package android.view.inputmethod;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Slog;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IllegalFormatException;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: source-4181928-dex2jar.jar:android/view/inputmethod/InputMethodSubtype.class */
public final class InputMethodSubtype implements Parcelable {
    private static final String EXTRA_KEY_UNTRANSLATABLE_STRING_IN_SUBTYPE_NAME = "UntranslatableReplacementStringInSubtypeName";
    private static final String EXTRA_VALUE_KEY_VALUE_SEPARATOR = "=";
    private static final String EXTRA_VALUE_PAIR_SEPARATOR = ",";
    private volatile HashMap<String, String> mExtraValueHashMapCache;
    private final boolean mIsAsciiCapable;
    private final boolean mIsAuxiliary;
    private final boolean mOverridesImplicitlyEnabledSubtype;
    private final String mSubtypeExtraValue;
    private final int mSubtypeHashCode;
    private final int mSubtypeIconResId;
    private final int mSubtypeId;
    private final String mSubtypeLocale;
    private final String mSubtypeMode;
    private final int mSubtypeNameResId;
    private static final String TAG = InputMethodSubtype.class.getSimpleName();
    public static final Parcelable.Creator<InputMethodSubtype> CREATOR = new Parcelable.Creator<InputMethodSubtype>() { // from class: android.view.inputmethod.InputMethodSubtype.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public InputMethodSubtype createFromParcel(Parcel parcel) {
            return new InputMethodSubtype(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public InputMethodSubtype[] newArray(int i) {
            return new InputMethodSubtype[i];
        }
    };

    /* loaded from: source-4181928-dex2jar.jar:android/view/inputmethod/InputMethodSubtype$InputMethodSubtypeBuilder.class */
    public static class InputMethodSubtypeBuilder {
        private boolean mIsAuxiliary = false;
        private boolean mOverridesImplicitlyEnabledSubtype = false;
        private boolean mIsAsciiCapable = false;
        private int mSubtypeIconResId = 0;
        private int mSubtypeNameResId = 0;
        private int mSubtypeId = 0;
        private String mSubtypeLocale = "";
        private String mSubtypeMode = "";
        private String mSubtypeExtraValue = "";

        public InputMethodSubtype build() {
            return new InputMethodSubtype(this);
        }

        public InputMethodSubtypeBuilder setIsAsciiCapable(boolean z) {
            this.mIsAsciiCapable = z;
            return this;
        }

        public InputMethodSubtypeBuilder setIsAuxiliary(boolean z) {
            this.mIsAuxiliary = z;
            return this;
        }

        public InputMethodSubtypeBuilder setOverridesImplicitlyEnabledSubtype(boolean z) {
            this.mOverridesImplicitlyEnabledSubtype = z;
            return this;
        }

        public InputMethodSubtypeBuilder setSubtypeExtraValue(String str) {
            String str2 = str;
            if (str == null) {
                str2 = "";
            }
            this.mSubtypeExtraValue = str2;
            return this;
        }

        public InputMethodSubtypeBuilder setSubtypeIconResId(int i) {
            this.mSubtypeIconResId = i;
            return this;
        }

        public InputMethodSubtypeBuilder setSubtypeId(int i) {
            this.mSubtypeId = i;
            return this;
        }

        public InputMethodSubtypeBuilder setSubtypeLocale(String str) {
            String str2 = str;
            if (str == null) {
                str2 = "";
            }
            this.mSubtypeLocale = str2;
            return this;
        }

        public InputMethodSubtypeBuilder setSubtypeMode(String str) {
            String str2 = str;
            if (str == null) {
                str2 = "";
            }
            this.mSubtypeMode = str2;
            return this;
        }

        public InputMethodSubtypeBuilder setSubtypeNameResId(int i) {
            this.mSubtypeNameResId = i;
            return this;
        }
    }

    public InputMethodSubtype(int i, int i2, String str, String str2, String str3, boolean z, boolean z2) {
        this(i, i2, str, str2, str3, z, z2, 0);
    }

    public InputMethodSubtype(int i, int i2, String str, String str2, String str3, boolean z, boolean z2, int i3) {
        this(getBuilder(i, i2, str, str2, str3, z, z2, i3, false));
    }

    InputMethodSubtype(Parcel parcel) {
        this.mSubtypeNameResId = parcel.readInt();
        this.mSubtypeIconResId = parcel.readInt();
        String readString = parcel.readString();
        this.mSubtypeLocale = readString == null ? "" : readString;
        String readString2 = parcel.readString();
        this.mSubtypeMode = readString2 == null ? "" : readString2;
        String readString3 = parcel.readString();
        this.mSubtypeExtraValue = readString3 == null ? "" : readString3;
        this.mIsAuxiliary = parcel.readInt() == 1;
        this.mOverridesImplicitlyEnabledSubtype = parcel.readInt() == 1;
        this.mSubtypeHashCode = parcel.readInt();
        this.mSubtypeId = parcel.readInt();
        this.mIsAsciiCapable = parcel.readInt() == 1;
    }

    private InputMethodSubtype(InputMethodSubtypeBuilder inputMethodSubtypeBuilder) {
        this.mSubtypeNameResId = inputMethodSubtypeBuilder.mSubtypeNameResId;
        this.mSubtypeIconResId = inputMethodSubtypeBuilder.mSubtypeIconResId;
        this.mSubtypeLocale = inputMethodSubtypeBuilder.mSubtypeLocale;
        this.mSubtypeMode = inputMethodSubtypeBuilder.mSubtypeMode;
        this.mSubtypeExtraValue = inputMethodSubtypeBuilder.mSubtypeExtraValue;
        this.mIsAuxiliary = inputMethodSubtypeBuilder.mIsAuxiliary;
        this.mOverridesImplicitlyEnabledSubtype = inputMethodSubtypeBuilder.mOverridesImplicitlyEnabledSubtype;
        this.mSubtypeId = inputMethodSubtypeBuilder.mSubtypeId;
        this.mIsAsciiCapable = inputMethodSubtypeBuilder.mIsAsciiCapable;
        this.mSubtypeHashCode = this.mSubtypeId != 0 ? this.mSubtypeId : hashCodeInternal(this.mSubtypeLocale, this.mSubtypeMode, this.mSubtypeExtraValue, this.mIsAuxiliary, this.mOverridesImplicitlyEnabledSubtype, this.mIsAsciiCapable);
    }

    private static Locale constructLocaleFromString(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split(BridgeUtil.UNDERLINE_STR, 3);
        if (split.length == 1) {
            return new Locale(split[0]);
        }
        if (split.length == 2) {
            return new Locale(split[0], split[1]);
        }
        if (split.length == 3) {
            return new Locale(split[0], split[1], split[2]);
        }
        return null;
    }

    private static InputMethodSubtypeBuilder getBuilder(int i, int i2, String str, String str2, String str3, boolean z, boolean z2, int i3, boolean z3) {
        InputMethodSubtypeBuilder inputMethodSubtypeBuilder = new InputMethodSubtypeBuilder();
        inputMethodSubtypeBuilder.mSubtypeNameResId = i;
        inputMethodSubtypeBuilder.mSubtypeIconResId = i2;
        inputMethodSubtypeBuilder.mSubtypeLocale = str;
        inputMethodSubtypeBuilder.mSubtypeMode = str2;
        inputMethodSubtypeBuilder.mSubtypeExtraValue = str3;
        inputMethodSubtypeBuilder.mIsAuxiliary = z;
        inputMethodSubtypeBuilder.mOverridesImplicitlyEnabledSubtype = z2;
        inputMethodSubtypeBuilder.mSubtypeId = i3;
        inputMethodSubtypeBuilder.mIsAsciiCapable = z3;
        return inputMethodSubtypeBuilder;
    }

    private HashMap<String, String> getExtraValueHashMap() {
        if (this.mExtraValueHashMapCache == null) {
            synchronized (this) {
                if (this.mExtraValueHashMapCache == null) {
                    this.mExtraValueHashMapCache = new HashMap<>();
                    String[] split = this.mSubtypeExtraValue.split(EXTRA_VALUE_PAIR_SEPARATOR);
                    int length = split.length;
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= length) {
                            break;
                        }
                        String[] split2 = split[i2].split(EXTRA_VALUE_KEY_VALUE_SEPARATOR);
                        if (split2.length == 1) {
                            this.mExtraValueHashMapCache.put(split2[0], null);
                        } else if (split2.length > 1) {
                            if (split2.length > 2) {
                                Slog.w(TAG, "ExtraValue has two or more '='s");
                            }
                            this.mExtraValueHashMapCache.put(split2[0], split2[1]);
                        }
                        i = i2 + 1;
                    }
                }
            }
        }
        return this.mExtraValueHashMapCache;
    }

    private static int hashCodeInternal(String str, String str2, String str3, boolean z, boolean z2, boolean z3) {
        return !z3 ? Arrays.hashCode(new Object[]{str, str2, str3, Boolean.valueOf(z), Boolean.valueOf(z2)}) : Arrays.hashCode(new Object[]{str, str2, str3, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)});
    }

    public static List<InputMethodSubtype> sort(Context context, int i, InputMethodInfo inputMethodInfo, List<InputMethodSubtype> list) {
        if (inputMethodInfo == null) {
            return list;
        }
        HashSet hashSet = new HashSet(list);
        ArrayList arrayList = new ArrayList();
        int subtypeCount = inputMethodInfo.getSubtypeCount();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= subtypeCount) {
                break;
            }
            InputMethodSubtype subtypeAt = inputMethodInfo.getSubtypeAt(i3);
            if (hashSet.contains(subtypeAt)) {
                arrayList.add(subtypeAt);
                hashSet.remove(subtypeAt);
            }
            i2 = i3 + 1;
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            arrayList.add((InputMethodSubtype) it.next());
        }
        return arrayList;
    }

    public boolean containsExtraValueKey(String str) {
        return getExtraValueHashMap().containsKey(str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj instanceof InputMethodSubtype) {
            InputMethodSubtype inputMethodSubtype = (InputMethodSubtype) obj;
            return (inputMethodSubtype.mSubtypeId == 0 && this.mSubtypeId == 0) ? inputMethodSubtype.hashCode() == hashCode() && inputMethodSubtype.getLocale().equals(getLocale()) && inputMethodSubtype.getMode().equals(getMode()) && inputMethodSubtype.getExtraValue().equals(getExtraValue()) && inputMethodSubtype.isAuxiliary() == isAuxiliary() && inputMethodSubtype.overridesImplicitlyEnabledSubtype() == overridesImplicitlyEnabledSubtype() && inputMethodSubtype.isAsciiCapable() == isAsciiCapable() : inputMethodSubtype.hashCode() == hashCode();
        }
        return false;
    }

    public CharSequence getDisplayName(Context context, String str, ApplicationInfo applicationInfo) {
        Locale constructLocaleFromString = constructLocaleFromString(this.mSubtypeLocale);
        String displayName = constructLocaleFromString != null ? constructLocaleFromString.getDisplayName() : this.mSubtypeLocale;
        if (this.mSubtypeNameResId != 0) {
            CharSequence text = context.getPackageManager().getText(str, this.mSubtypeNameResId, applicationInfo);
            if (!TextUtils.isEmpty(text)) {
                String extraValueOf = containsExtraValueKey(EXTRA_KEY_UNTRANSLATABLE_STRING_IN_SUBTYPE_NAME) ? getExtraValueOf(EXTRA_KEY_UNTRANSLATABLE_STRING_IN_SUBTYPE_NAME) : displayName;
                try {
                    String charSequence = text.toString();
                    if (extraValueOf == null) {
                        extraValueOf = "";
                    }
                    return String.format(charSequence, extraValueOf);
                } catch (IllegalFormatException e) {
                    Slog.w(TAG, "Found illegal format in subtype name(" + ((Object) text) + "): " + e);
                    return "";
                }
            }
        }
        return displayName;
    }

    public String getExtraValue() {
        return this.mSubtypeExtraValue;
    }

    public String getExtraValueOf(String str) {
        return getExtraValueHashMap().get(str);
    }

    public int getIconResId() {
        return this.mSubtypeIconResId;
    }

    public String getLocale() {
        return this.mSubtypeLocale;
    }

    public String getMode() {
        return this.mSubtypeMode;
    }

    public int getNameResId() {
        return this.mSubtypeNameResId;
    }

    public int hashCode() {
        return this.mSubtypeHashCode;
    }

    public boolean isAsciiCapable() {
        return this.mIsAsciiCapable;
    }

    public boolean isAuxiliary() {
        return this.mIsAuxiliary;
    }

    public boolean overridesImplicitlyEnabledSubtype() {
        return this.mOverridesImplicitlyEnabledSubtype;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mSubtypeNameResId);
        parcel.writeInt(this.mSubtypeIconResId);
        parcel.writeString(this.mSubtypeLocale);
        parcel.writeString(this.mSubtypeMode);
        parcel.writeString(this.mSubtypeExtraValue);
        parcel.writeInt(this.mIsAuxiliary ? 1 : 0);
        parcel.writeInt(this.mOverridesImplicitlyEnabledSubtype ? 1 : 0);
        parcel.writeInt(this.mSubtypeHashCode);
        parcel.writeInt(this.mSubtypeId);
        parcel.writeInt(this.mIsAsciiCapable ? 1 : 0);
    }
}
