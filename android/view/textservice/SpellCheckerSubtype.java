package android.view.textservice;

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
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: source-4181928-dex2jar.jar:android/view/textservice/SpellCheckerSubtype.class */
public final class SpellCheckerSubtype implements Parcelable {
    private static final String EXTRA_VALUE_KEY_VALUE_SEPARATOR = "=";
    private static final String EXTRA_VALUE_PAIR_SEPARATOR = ",";
    private HashMap<String, String> mExtraValueHashMapCache;
    private final String mSubtypeExtraValue;
    private final int mSubtypeHashCode;
    private final String mSubtypeLocale;
    private final int mSubtypeNameResId;
    private static final String TAG = SpellCheckerSubtype.class.getSimpleName();
    public static final Parcelable.Creator<SpellCheckerSubtype> CREATOR = new Parcelable.Creator<SpellCheckerSubtype>() { // from class: android.view.textservice.SpellCheckerSubtype.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SpellCheckerSubtype createFromParcel(Parcel parcel) {
            return new SpellCheckerSubtype(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SpellCheckerSubtype[] newArray(int i) {
            return new SpellCheckerSubtype[i];
        }
    };

    public SpellCheckerSubtype(int i, String str, String str2) {
        this.mSubtypeNameResId = i;
        this.mSubtypeLocale = str == null ? "" : str;
        this.mSubtypeExtraValue = str2 == null ? "" : str2;
        this.mSubtypeHashCode = hashCodeInternal(this.mSubtypeLocale, this.mSubtypeExtraValue);
    }

    SpellCheckerSubtype(Parcel parcel) {
        this.mSubtypeNameResId = parcel.readInt();
        String readString = parcel.readString();
        this.mSubtypeLocale = readString == null ? "" : readString;
        String readString2 = parcel.readString();
        this.mSubtypeExtraValue = readString2 == null ? "" : readString2;
        this.mSubtypeHashCode = hashCodeInternal(this.mSubtypeLocale, this.mSubtypeExtraValue);
    }

    public static Locale constructLocaleFromString(String str) {
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

    private HashMap<String, String> getExtraValueHashMap() {
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
        return this.mExtraValueHashMapCache;
    }

    private static int hashCodeInternal(String str, String str2) {
        return Arrays.hashCode(new Object[]{str, str2});
    }

    public static List<SpellCheckerSubtype> sort(Context context, int i, SpellCheckerInfo spellCheckerInfo, List<SpellCheckerSubtype> list) {
        if (spellCheckerInfo == null) {
            return list;
        }
        HashSet hashSet = new HashSet(list);
        ArrayList arrayList = new ArrayList();
        int subtypeCount = spellCheckerInfo.getSubtypeCount();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= subtypeCount) {
                break;
            }
            SpellCheckerSubtype subtypeAt = spellCheckerInfo.getSubtypeAt(i3);
            if (hashSet.contains(subtypeAt)) {
                arrayList.add(subtypeAt);
                hashSet.remove(subtypeAt);
            }
            i2 = i3 + 1;
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            arrayList.add((SpellCheckerSubtype) it.next());
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
        boolean z = false;
        if (obj instanceof SpellCheckerSubtype) {
            SpellCheckerSubtype spellCheckerSubtype = (SpellCheckerSubtype) obj;
            z = false;
            if (spellCheckerSubtype.hashCode() == hashCode()) {
                z = false;
                if (spellCheckerSubtype.getNameResId() == getNameResId()) {
                    z = false;
                    if (spellCheckerSubtype.getLocale().equals(getLocale())) {
                        z = false;
                        if (spellCheckerSubtype.getExtraValue().equals(getExtraValue())) {
                            z = true;
                        }
                    }
                }
            }
        }
        return z;
    }

    public CharSequence getDisplayName(Context context, String str, ApplicationInfo applicationInfo) {
        Locale constructLocaleFromString = constructLocaleFromString(this.mSubtypeLocale);
        String displayName = constructLocaleFromString != null ? constructLocaleFromString.getDisplayName() : this.mSubtypeLocale;
        if (this.mSubtypeNameResId != 0) {
            CharSequence text = context.getPackageManager().getText(str, this.mSubtypeNameResId, applicationInfo);
            if (!TextUtils.isEmpty(text)) {
                return String.format(text.toString(), displayName);
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

    public String getLocale() {
        return this.mSubtypeLocale;
    }

    public int getNameResId() {
        return this.mSubtypeNameResId;
    }

    public int hashCode() {
        return this.mSubtypeHashCode;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mSubtypeNameResId);
        parcel.writeString(this.mSubtypeLocale);
        parcel.writeString(this.mSubtypeExtraValue);
    }
}
