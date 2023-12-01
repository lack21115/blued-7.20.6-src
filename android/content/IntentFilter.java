package android.content;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.PatternMatcher;
import android.util.AndroidException;
import android.util.Log;
import android.util.Printer;
import com.android.internal.util.XmlUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* loaded from: source-9557208-dex2jar.jar:android/content/IntentFilter.class */
public class IntentFilter implements Parcelable {
    private static final String ACTION_STR = "action";
    private static final String AUTH_STR = "auth";
    private static final String CAT_STR = "cat";
    public static final Parcelable.Creator<IntentFilter> CREATOR = new Parcelable.Creator<IntentFilter>() { // from class: android.content.IntentFilter.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public IntentFilter createFromParcel(Parcel parcel) {
            return new IntentFilter(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public IntentFilter[] newArray(int i) {
            return new IntentFilter[i];
        }
    };
    private static final String HOST_STR = "host";
    private static final String LITERAL_STR = "literal";
    public static final int MATCH_ADJUSTMENT_MASK = 65535;
    public static final int MATCH_ADJUSTMENT_NORMAL = 32768;
    public static final int MATCH_CATEGORY_EMPTY = 1048576;
    public static final int MATCH_CATEGORY_HOST = 3145728;
    public static final int MATCH_CATEGORY_MASK = 268369920;
    public static final int MATCH_CATEGORY_PATH = 5242880;
    public static final int MATCH_CATEGORY_PORT = 4194304;
    public static final int MATCH_CATEGORY_SCHEME = 2097152;
    public static final int MATCH_CATEGORY_SCHEME_SPECIFIC_PART = 5767168;
    public static final int MATCH_CATEGORY_TYPE = 6291456;
    private static final String NAME_STR = "name";
    public static final int NO_MATCH_ACTION = -3;
    public static final int NO_MATCH_CATEGORY = -4;
    public static final int NO_MATCH_DATA = -2;
    public static final int NO_MATCH_TYPE = -1;
    private static final String PATH_STR = "path";
    private static final String PORT_STR = "port";
    private static final String PREFIX_STR = "prefix";
    private static final String SCHEME_STR = "scheme";
    private static final String SGLOB_STR = "sglob";
    private static final String SSP_STR = "ssp";
    public static final int SYSTEM_HIGH_PRIORITY = 1000;
    public static final int SYSTEM_LOW_PRIORITY = -1000;
    private static final String TYPE_STR = "type";
    private final ArrayList<String> mActions;
    private ArrayList<String> mCategories;
    private ArrayList<AuthorityEntry> mDataAuthorities;
    private ArrayList<PatternMatcher> mDataPaths;
    private ArrayList<PatternMatcher> mDataSchemeSpecificParts;
    private ArrayList<String> mDataSchemes;
    private ArrayList<String> mDataTypes;
    private boolean mHasPartialTypes;
    private int mPriority;

    /* loaded from: source-9557208-dex2jar.jar:android/content/IntentFilter$AuthorityEntry.class */
    public static final class AuthorityEntry {
        private final String mHost;
        private final String mOrigHost;
        private final int mPort;
        private final boolean mWild;

        AuthorityEntry(Parcel parcel) {
            this.mOrigHost = parcel.readString();
            this.mHost = parcel.readString();
            this.mWild = parcel.readInt() != 0;
            this.mPort = parcel.readInt();
        }

        public AuthorityEntry(String str, String str2) {
            this.mOrigHost = str;
            boolean z = false;
            if (str.length() > 0) {
                z = false;
                if (str.charAt(0) == '*') {
                    z = true;
                }
            }
            this.mWild = z;
            this.mHost = this.mWild ? str.substring(1).intern() : str;
            this.mPort = str2 != null ? Integer.parseInt(str2) : -1;
        }

        public String getHost() {
            return this.mOrigHost;
        }

        public int getPort() {
            return this.mPort;
        }

        public int match(Uri uri) {
            String host = uri.getHost();
            if (host == null) {
                return -2;
            }
            String str = host;
            if (this.mWild) {
                if (host.length() < this.mHost.length()) {
                    return -2;
                }
                str = host.substring(host.length() - this.mHost.length());
            }
            if (str.compareToIgnoreCase(this.mHost) == 0) {
                return this.mPort >= 0 ? this.mPort == uri.getPort() ? 4194304 : -2 : IntentFilter.MATCH_CATEGORY_HOST;
            }
            return -2;
        }

        public boolean match(AuthorityEntry authorityEntry) {
            return this.mWild == authorityEntry.mWild && this.mHost.equals(authorityEntry.mHost) && this.mPort == authorityEntry.mPort;
        }

        void writeToParcel(Parcel parcel) {
            parcel.writeString(this.mOrigHost);
            parcel.writeString(this.mHost);
            parcel.writeInt(this.mWild ? 1 : 0);
            parcel.writeInt(this.mPort);
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/content/IntentFilter$MalformedMimeTypeException.class */
    public static class MalformedMimeTypeException extends AndroidException {
        public MalformedMimeTypeException() {
        }

        public MalformedMimeTypeException(String str) {
            super(str);
        }
    }

    public IntentFilter() {
        this.mCategories = null;
        this.mDataSchemes = null;
        this.mDataSchemeSpecificParts = null;
        this.mDataAuthorities = null;
        this.mDataPaths = null;
        this.mDataTypes = null;
        this.mHasPartialTypes = false;
        this.mPriority = 0;
        this.mActions = new ArrayList<>();
    }

    public IntentFilter(IntentFilter intentFilter) {
        this.mCategories = null;
        this.mDataSchemes = null;
        this.mDataSchemeSpecificParts = null;
        this.mDataAuthorities = null;
        this.mDataPaths = null;
        this.mDataTypes = null;
        this.mHasPartialTypes = false;
        this.mPriority = intentFilter.mPriority;
        this.mActions = new ArrayList<>(intentFilter.mActions);
        if (intentFilter.mCategories != null) {
            this.mCategories = new ArrayList<>(intentFilter.mCategories);
        }
        if (intentFilter.mDataTypes != null) {
            this.mDataTypes = new ArrayList<>(intentFilter.mDataTypes);
        }
        if (intentFilter.mDataSchemes != null) {
            this.mDataSchemes = new ArrayList<>(intentFilter.mDataSchemes);
        }
        if (intentFilter.mDataSchemeSpecificParts != null) {
            this.mDataSchemeSpecificParts = new ArrayList<>(intentFilter.mDataSchemeSpecificParts);
        }
        if (intentFilter.mDataAuthorities != null) {
            this.mDataAuthorities = new ArrayList<>(intentFilter.mDataAuthorities);
        }
        if (intentFilter.mDataPaths != null) {
            this.mDataPaths = new ArrayList<>(intentFilter.mDataPaths);
        }
        this.mHasPartialTypes = intentFilter.mHasPartialTypes;
    }

    private IntentFilter(Parcel parcel) {
        boolean z = false;
        this.mCategories = null;
        this.mDataSchemes = null;
        this.mDataSchemeSpecificParts = null;
        this.mDataAuthorities = null;
        this.mDataPaths = null;
        this.mDataTypes = null;
        this.mHasPartialTypes = false;
        this.mActions = new ArrayList<>();
        parcel.readStringList(this.mActions);
        if (parcel.readInt() != 0) {
            this.mCategories = new ArrayList<>();
            parcel.readStringList(this.mCategories);
        }
        if (parcel.readInt() != 0) {
            this.mDataSchemes = new ArrayList<>();
            parcel.readStringList(this.mDataSchemes);
        }
        if (parcel.readInt() != 0) {
            this.mDataTypes = new ArrayList<>();
            parcel.readStringList(this.mDataTypes);
        }
        int readInt = parcel.readInt();
        if (readInt > 0) {
            this.mDataSchemeSpecificParts = new ArrayList<>(readInt);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= readInt) {
                    break;
                }
                this.mDataSchemeSpecificParts.add(new PatternMatcher(parcel));
                i = i2 + 1;
            }
        }
        int readInt2 = parcel.readInt();
        if (readInt2 > 0) {
            this.mDataAuthorities = new ArrayList<>(readInt2);
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= readInt2) {
                    break;
                }
                this.mDataAuthorities.add(new AuthorityEntry(parcel));
                i3 = i4 + 1;
            }
        }
        int readInt3 = parcel.readInt();
        if (readInt3 > 0) {
            this.mDataPaths = new ArrayList<>(readInt3);
            int i5 = 0;
            while (true) {
                int i6 = i5;
                if (i6 >= readInt3) {
                    break;
                }
                this.mDataPaths.add(new PatternMatcher(parcel));
                i5 = i6 + 1;
            }
        }
        this.mPriority = parcel.readInt();
        this.mHasPartialTypes = parcel.readInt() > 0 ? true : z;
    }

    public IntentFilter(String str) {
        this.mCategories = null;
        this.mDataSchemes = null;
        this.mDataSchemeSpecificParts = null;
        this.mDataAuthorities = null;
        this.mDataPaths = null;
        this.mDataTypes = null;
        this.mHasPartialTypes = false;
        this.mPriority = 0;
        this.mActions = new ArrayList<>();
        addAction(str);
    }

    public IntentFilter(String str, String str2) throws MalformedMimeTypeException {
        this.mCategories = null;
        this.mDataSchemes = null;
        this.mDataSchemeSpecificParts = null;
        this.mDataAuthorities = null;
        this.mDataPaths = null;
        this.mDataTypes = null;
        this.mHasPartialTypes = false;
        this.mPriority = 0;
        this.mActions = new ArrayList<>();
        addAction(str);
        addDataType(str2);
    }

    private static String[] addStringToSet(String[] strArr, String str, int[] iArr, int i) {
        if (findStringInSet(strArr, str, iArr, i) >= 0) {
            return strArr;
        }
        if (strArr == null) {
            String[] strArr2 = new String[2];
            strArr2[0] = str;
            iArr[i] = 1;
            return strArr2;
        }
        int i2 = iArr[i];
        if (i2 < strArr.length) {
            strArr[i2] = str;
            iArr[i] = i2 + 1;
            return strArr;
        }
        String[] strArr3 = new String[((i2 * 3) / 2) + 2];
        System.arraycopy(strArr, 0, strArr3, 0, i2);
        strArr3[i2] = str;
        iArr[i] = i2 + 1;
        return strArr3;
    }

    public static IntentFilter create(String str, String str2) {
        try {
            return new IntentFilter(str, str2);
        } catch (MalformedMimeTypeException e) {
            throw new RuntimeException("Bad MIME type", e);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0053, code lost:
        if (r0.contains("*") == false) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0077, code lost:
        if (r0.contains(r8.substring(0, r0)) == false) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean findMimeType(java.lang.String r8) {
        /*
            Method dump skipped, instructions count: 190
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.content.IntentFilter.findMimeType(java.lang.String):boolean");
    }

    private static int findStringInSet(String[] strArr, String str, int[] iArr, int i) {
        int i2;
        if (strArr == null) {
            i2 = -1;
        } else {
            int i3 = iArr[i];
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 >= i3) {
                    return -1;
                }
                i2 = i5;
                if (strArr[i5].equals(str)) {
                    break;
                }
                i4 = i5 + 1;
            }
        }
        return i2;
    }

    private static String[] removeStringFromSet(String[] strArr, String str, int[] iArr, int i) {
        int findStringInSet = findStringInSet(strArr, str, iArr, i);
        if (findStringInSet < 0) {
            return strArr;
        }
        int i2 = iArr[i];
        if (i2 > strArr.length / 4) {
            int i3 = i2 - (findStringInSet + 1);
            if (i3 > 0) {
                System.arraycopy(strArr, findStringInSet + 1, strArr, findStringInSet, i3);
            }
            strArr[i2 - 1] = null;
            iArr[i] = i2 - 1;
            return strArr;
        }
        String[] strArr2 = new String[strArr.length / 3];
        if (findStringInSet > 0) {
            System.arraycopy(strArr, 0, strArr2, 0, findStringInSet);
        }
        if (findStringInSet + 1 < i2) {
            System.arraycopy(strArr, findStringInSet + 1, strArr2, findStringInSet, i2 - (findStringInSet + 1));
        }
        return strArr2;
    }

    public final Iterator<String> actionsIterator() {
        if (this.mActions != null) {
            return this.mActions.iterator();
        }
        return null;
    }

    public final void addAction(String str) {
        if (this.mActions.contains(str)) {
            return;
        }
        this.mActions.add(str.intern());
    }

    public final void addCategory(String str) {
        if (this.mCategories == null) {
            this.mCategories = new ArrayList<>();
        }
        if (this.mCategories.contains(str)) {
            return;
        }
        this.mCategories.add(str.intern());
    }

    public final void addDataAuthority(AuthorityEntry authorityEntry) {
        if (this.mDataAuthorities == null) {
            this.mDataAuthorities = new ArrayList<>();
        }
        this.mDataAuthorities.add(authorityEntry);
    }

    public final void addDataAuthority(String str, String str2) {
        String str3 = str2;
        if (str2 != null) {
            str3 = str2.intern();
        }
        addDataAuthority(new AuthorityEntry(str.intern(), str3));
    }

    public final void addDataPath(PatternMatcher patternMatcher) {
        if (this.mDataPaths == null) {
            this.mDataPaths = new ArrayList<>();
        }
        this.mDataPaths.add(patternMatcher);
    }

    public final void addDataPath(String str, int i) {
        addDataPath(new PatternMatcher(str.intern(), i));
    }

    public final void addDataScheme(String str) {
        if (this.mDataSchemes == null) {
            this.mDataSchemes = new ArrayList<>();
        }
        if (this.mDataSchemes.contains(str)) {
            return;
        }
        this.mDataSchemes.add(str.intern());
    }

    public final void addDataSchemeSpecificPart(PatternMatcher patternMatcher) {
        if (this.mDataSchemeSpecificParts == null) {
            this.mDataSchemeSpecificParts = new ArrayList<>();
        }
        this.mDataSchemeSpecificParts.add(patternMatcher);
    }

    public final void addDataSchemeSpecificPart(String str, int i) {
        addDataSchemeSpecificPart(new PatternMatcher(str, i));
    }

    public final void addDataType(String str) throws MalformedMimeTypeException {
        int indexOf = str.indexOf(47);
        int length = str.length();
        if (indexOf <= 0 || length < indexOf + 2) {
            throw new MalformedMimeTypeException(str);
        }
        if (this.mDataTypes == null) {
            this.mDataTypes = new ArrayList<>();
        }
        if (length != indexOf + 2 || str.charAt(indexOf + 1) != '*') {
            if (this.mDataTypes.contains(str)) {
                return;
            }
            this.mDataTypes.add(str.intern());
            return;
        }
        String substring = str.substring(0, indexOf);
        if (!this.mDataTypes.contains(substring)) {
            this.mDataTypes.add(substring.intern());
        }
        this.mHasPartialTypes = true;
    }

    public final Iterator<AuthorityEntry> authoritiesIterator() {
        if (this.mDataAuthorities != null) {
            return this.mDataAuthorities.iterator();
        }
        return null;
    }

    public final Iterator<String> categoriesIterator() {
        if (this.mCategories != null) {
            return this.mCategories.iterator();
        }
        return null;
    }

    public final int countActions() {
        return this.mActions.size();
    }

    public final int countCategories() {
        if (this.mCategories != null) {
            return this.mCategories.size();
        }
        return 0;
    }

    public final int countDataAuthorities() {
        if (this.mDataAuthorities != null) {
            return this.mDataAuthorities.size();
        }
        return 0;
    }

    public final int countDataPaths() {
        if (this.mDataPaths != null) {
            return this.mDataPaths.size();
        }
        return 0;
    }

    public final int countDataSchemeSpecificParts() {
        if (this.mDataSchemeSpecificParts != null) {
            return this.mDataSchemeSpecificParts.size();
        }
        return 0;
    }

    public final int countDataSchemes() {
        if (this.mDataSchemes != null) {
            return this.mDataSchemes.size();
        }
        return 0;
    }

    public final int countDataTypes() {
        if (this.mDataTypes != null) {
            return this.mDataTypes.size();
        }
        return 0;
    }

    public boolean debugCheck() {
        return true;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public void dump(Printer printer, String str) {
        StringBuilder sb = new StringBuilder(256);
        if (this.mActions.size() > 0) {
            Iterator<String> it = this.mActions.iterator();
            while (it.hasNext()) {
                sb.setLength(0);
                sb.append(str);
                sb.append("Action: \"");
                sb.append(it.next());
                sb.append("\"");
                printer.println(sb.toString());
            }
        }
        if (this.mCategories != null) {
            Iterator<String> it2 = this.mCategories.iterator();
            while (it2.hasNext()) {
                sb.setLength(0);
                sb.append(str);
                sb.append("Category: \"");
                sb.append(it2.next());
                sb.append("\"");
                printer.println(sb.toString());
            }
        }
        if (this.mDataSchemes != null) {
            Iterator<String> it3 = this.mDataSchemes.iterator();
            while (it3.hasNext()) {
                sb.setLength(0);
                sb.append(str);
                sb.append("Scheme: \"");
                sb.append(it3.next());
                sb.append("\"");
                printer.println(sb.toString());
            }
        }
        if (this.mDataSchemeSpecificParts != null) {
            Iterator<PatternMatcher> it4 = this.mDataSchemeSpecificParts.iterator();
            while (it4.hasNext()) {
                sb.setLength(0);
                sb.append(str);
                sb.append("Ssp: \"");
                sb.append(it4.next());
                sb.append("\"");
                printer.println(sb.toString());
            }
        }
        if (this.mDataAuthorities != null) {
            Iterator<AuthorityEntry> it5 = this.mDataAuthorities.iterator();
            while (it5.hasNext()) {
                AuthorityEntry next = it5.next();
                sb.setLength(0);
                sb.append(str);
                sb.append("Authority: \"");
                sb.append(next.mHost);
                sb.append("\": ");
                sb.append(next.mPort);
                if (next.mWild) {
                    sb.append(" WILD");
                }
                printer.println(sb.toString());
            }
        }
        if (this.mDataPaths != null) {
            Iterator<PatternMatcher> it6 = this.mDataPaths.iterator();
            while (it6.hasNext()) {
                sb.setLength(0);
                sb.append(str);
                sb.append("Path: \"");
                sb.append(it6.next());
                sb.append("\"");
                printer.println(sb.toString());
            }
        }
        if (this.mDataTypes != null) {
            Iterator<String> it7 = this.mDataTypes.iterator();
            while (it7.hasNext()) {
                sb.setLength(0);
                sb.append(str);
                sb.append("Type: \"");
                sb.append(it7.next());
                sb.append("\"");
                printer.println(sb.toString());
            }
        }
        if (this.mPriority != 0 || this.mHasPartialTypes) {
            sb.setLength(0);
            sb.append(str);
            sb.append("mPriority=");
            sb.append(this.mPriority);
            sb.append(", mHasPartialTypes=");
            sb.append(this.mHasPartialTypes);
            printer.println(sb.toString());
        }
    }

    public final String getAction(int i) {
        return this.mActions.get(i);
    }

    public final String getCategory(int i) {
        return this.mCategories.get(i);
    }

    public final AuthorityEntry getDataAuthority(int i) {
        return this.mDataAuthorities.get(i);
    }

    public final PatternMatcher getDataPath(int i) {
        return this.mDataPaths.get(i);
    }

    public final String getDataScheme(int i) {
        return this.mDataSchemes.get(i);
    }

    public final PatternMatcher getDataSchemeSpecificPart(int i) {
        return this.mDataSchemeSpecificParts.get(i);
    }

    public final String getDataType(int i) {
        return this.mDataTypes.get(i);
    }

    public final int getPriority() {
        return this.mPriority;
    }

    public final boolean hasAction(String str) {
        return str != null && this.mActions.contains(str);
    }

    public final boolean hasCategory(String str) {
        return this.mCategories != null && this.mCategories.contains(str);
    }

    public final boolean hasDataAuthority(AuthorityEntry authorityEntry) {
        if (this.mDataAuthorities == null) {
            return false;
        }
        int size = this.mDataAuthorities.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return false;
            }
            if (this.mDataAuthorities.get(i2).match(authorityEntry)) {
                return true;
            }
            i = i2 + 1;
        }
    }

    public final boolean hasDataAuthority(Uri uri) {
        return matchDataAuthority(uri) >= 0;
    }

    public final boolean hasDataPath(PatternMatcher patternMatcher) {
        if (this.mDataPaths == null) {
            return false;
        }
        int size = this.mDataPaths.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return false;
            }
            PatternMatcher patternMatcher2 = this.mDataPaths.get(i2);
            if (patternMatcher2.getType() == patternMatcher.getType() && patternMatcher2.getPath().equals(patternMatcher.getPath())) {
                return true;
            }
            i = i2 + 1;
        }
    }

    public final boolean hasDataPath(String str) {
        if (this.mDataPaths == null) {
            return false;
        }
        int size = this.mDataPaths.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return false;
            }
            if (this.mDataPaths.get(i2).match(str)) {
                return true;
            }
            i = i2 + 1;
        }
    }

    public final boolean hasDataScheme(String str) {
        return this.mDataSchemes != null && this.mDataSchemes.contains(str);
    }

    public final boolean hasDataSchemeSpecificPart(PatternMatcher patternMatcher) {
        if (this.mDataSchemeSpecificParts == null) {
            return false;
        }
        int size = this.mDataSchemeSpecificParts.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return false;
            }
            PatternMatcher patternMatcher2 = this.mDataSchemeSpecificParts.get(i2);
            if (patternMatcher2.getType() == patternMatcher.getType() && patternMatcher2.getPath().equals(patternMatcher.getPath())) {
                return true;
            }
            i = i2 + 1;
        }
    }

    public final boolean hasDataSchemeSpecificPart(String str) {
        if (this.mDataSchemeSpecificParts == null) {
            return false;
        }
        int size = this.mDataSchemeSpecificParts.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return false;
            }
            if (this.mDataSchemeSpecificParts.get(i2).match(str)) {
                return true;
            }
            i = i2 + 1;
        }
    }

    public final boolean hasDataType(String str) {
        return this.mDataTypes != null && findMimeType(str);
    }

    public final boolean hasExactDataType(String str) {
        return this.mDataTypes != null && this.mDataTypes.contains(str);
    }

    public final int match(ContentResolver contentResolver, Intent intent, boolean z, String str) {
        return match(intent.getAction(), z ? intent.resolveType(contentResolver) : intent.getType(), intent.getScheme(), intent.getData(), intent.getCategories(), str);
    }

    public final int match(String str, String str2, String str3, Uri uri, Set<String> set, String str4) {
        int i;
        if (str == null || matchAction(str)) {
            int matchData = matchData(str2, str3, uri);
            i = matchData;
            if (matchData >= 0) {
                i = matchData;
                if (matchCategories(set) != null) {
                    return -4;
                }
            }
        } else {
            i = -3;
        }
        return i;
    }

    public final boolean matchAction(String str) {
        return hasAction(str);
    }

    public final String matchCategories(Set<String> set) {
        if (set == null) {
            return null;
        }
        Iterator<String> it = set.iterator();
        if (this.mCategories == null) {
            if (it.hasNext()) {
                return it.next();
            }
            return null;
        }
        while (it.hasNext()) {
            String next = it.next();
            if (!this.mCategories.contains(next)) {
                return next;
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x009b, code lost:
        if (r7 != (-2)) goto L38;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int matchData(java.lang.String r4, java.lang.String r5, android.net.Uri r6) {
        /*
            Method dump skipped, instructions count: 278
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.content.IntentFilter.matchData(java.lang.String, java.lang.String, android.net.Uri):int");
    }

    public final int matchDataAuthority(Uri uri) {
        int i;
        if (this.mDataAuthorities == null) {
            i = -2;
        } else {
            int size = this.mDataAuthorities.size();
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= size) {
                    return -2;
                }
                int match = this.mDataAuthorities.get(i3).match(uri);
                i = match;
                if (match >= 0) {
                    break;
                }
                i2 = i3 + 1;
            }
        }
        return i;
    }

    public int onCompareTie(IntentFilter intentFilter) {
        return 0;
    }

    public final Iterator<PatternMatcher> pathsIterator() {
        if (this.mDataPaths != null) {
            return this.mDataPaths.iterator();
        }
        return null;
    }

    public void readFromXml(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int depth = xmlPullParser.getDepth();
        while (true) {
            int next = xmlPullParser.next();
            if (next == 1) {
                return;
            }
            if (next == 3 && xmlPullParser.getDepth() <= depth) {
                return;
            }
            if (next != 3 && next != 4) {
                String name = xmlPullParser.getName();
                if (name.equals("action")) {
                    String attributeValue = xmlPullParser.getAttributeValue(null, "name");
                    if (attributeValue != null) {
                        addAction(attributeValue);
                    }
                } else if (name.equals(CAT_STR)) {
                    String attributeValue2 = xmlPullParser.getAttributeValue(null, "name");
                    if (attributeValue2 != null) {
                        addCategory(attributeValue2);
                    }
                } else if (name.equals("type")) {
                    String attributeValue3 = xmlPullParser.getAttributeValue(null, "name");
                    if (attributeValue3 != null) {
                        try {
                            addDataType(attributeValue3);
                        } catch (MalformedMimeTypeException e) {
                        }
                    }
                } else if (name.equals("scheme")) {
                    String attributeValue4 = xmlPullParser.getAttributeValue(null, "name");
                    if (attributeValue4 != null) {
                        addDataScheme(attributeValue4);
                    }
                } else if (name.equals(SSP_STR)) {
                    String attributeValue5 = xmlPullParser.getAttributeValue(null, "literal");
                    if (attributeValue5 != null) {
                        addDataSchemeSpecificPart(attributeValue5, 0);
                    } else {
                        String attributeValue6 = xmlPullParser.getAttributeValue(null, PREFIX_STR);
                        if (attributeValue6 != null) {
                            addDataSchemeSpecificPart(attributeValue6, 1);
                        } else {
                            String attributeValue7 = xmlPullParser.getAttributeValue(null, SGLOB_STR);
                            if (attributeValue7 != null) {
                                addDataSchemeSpecificPart(attributeValue7, 2);
                            }
                        }
                    }
                } else if (name.equals(AUTH_STR)) {
                    String attributeValue8 = xmlPullParser.getAttributeValue(null, "host");
                    String attributeValue9 = xmlPullParser.getAttributeValue(null, "port");
                    if (attributeValue8 != null) {
                        addDataAuthority(attributeValue8, attributeValue9);
                    }
                } else if (name.equals("path")) {
                    String attributeValue10 = xmlPullParser.getAttributeValue(null, "literal");
                    if (attributeValue10 != null) {
                        addDataPath(attributeValue10, 0);
                    } else {
                        String attributeValue11 = xmlPullParser.getAttributeValue(null, PREFIX_STR);
                        if (attributeValue11 != null) {
                            addDataPath(attributeValue11, 1);
                        } else {
                            String attributeValue12 = xmlPullParser.getAttributeValue(null, SGLOB_STR);
                            if (attributeValue12 != null) {
                                addDataPath(attributeValue12, 2);
                            }
                        }
                    }
                } else {
                    Log.w("IntentFilter", "Unknown tag parsing IntentFilter: " + name);
                }
                XmlUtils.skipCurrentTag(xmlPullParser);
            }
        }
    }

    public final Iterator<PatternMatcher> schemeSpecificPartsIterator() {
        if (this.mDataSchemeSpecificParts != null) {
            return this.mDataSchemeSpecificParts.iterator();
        }
        return null;
    }

    public final Iterator<String> schemesIterator() {
        if (this.mDataSchemes != null) {
            return this.mDataSchemes.iterator();
        }
        return null;
    }

    public final void setPriority(int i) {
        this.mPriority = i;
    }

    public final Iterator<String> typesIterator() {
        if (this.mDataTypes != null) {
            return this.mDataTypes.iterator();
        }
        return null;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeStringList(this.mActions);
        if (this.mCategories != null) {
            parcel.writeInt(1);
            parcel.writeStringList(this.mCategories);
        } else {
            parcel.writeInt(0);
        }
        if (this.mDataSchemes != null) {
            parcel.writeInt(1);
            parcel.writeStringList(this.mDataSchemes);
        } else {
            parcel.writeInt(0);
        }
        if (this.mDataTypes != null) {
            parcel.writeInt(1);
            parcel.writeStringList(this.mDataTypes);
        } else {
            parcel.writeInt(0);
        }
        if (this.mDataSchemeSpecificParts != null) {
            int size = this.mDataSchemeSpecificParts.size();
            parcel.writeInt(size);
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= size) {
                    break;
                }
                this.mDataSchemeSpecificParts.get(i3).writeToParcel(parcel, i);
                i2 = i3 + 1;
            }
        } else {
            parcel.writeInt(0);
        }
        if (this.mDataAuthorities != null) {
            int size2 = this.mDataAuthorities.size();
            parcel.writeInt(size2);
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 >= size2) {
                    break;
                }
                this.mDataAuthorities.get(i5).writeToParcel(parcel);
                i4 = i5 + 1;
            }
        } else {
            parcel.writeInt(0);
        }
        if (this.mDataPaths != null) {
            int size3 = this.mDataPaths.size();
            parcel.writeInt(size3);
            int i6 = 0;
            while (true) {
                int i7 = i6;
                if (i7 >= size3) {
                    break;
                }
                this.mDataPaths.get(i7).writeToParcel(parcel, i);
                i6 = i7 + 1;
            }
        } else {
            parcel.writeInt(0);
        }
        parcel.writeInt(this.mPriority);
        parcel.writeInt(this.mHasPartialTypes ? 1 : 0);
    }

    public void writeToXml(XmlSerializer xmlSerializer) throws IOException {
        int countActions = countActions();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= countActions) {
                break;
            }
            xmlSerializer.startTag(null, "action");
            xmlSerializer.attribute(null, "name", this.mActions.get(i2));
            xmlSerializer.endTag(null, "action");
            i = i2 + 1;
        }
        int countCategories = countCategories();
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= countCategories) {
                break;
            }
            xmlSerializer.startTag(null, CAT_STR);
            xmlSerializer.attribute(null, "name", this.mCategories.get(i4));
            xmlSerializer.endTag(null, CAT_STR);
            i3 = i4 + 1;
        }
        int countDataTypes = countDataTypes();
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= countDataTypes) {
                break;
            }
            xmlSerializer.startTag(null, "type");
            String str = this.mDataTypes.get(i6);
            String str2 = str;
            if (str.indexOf(47) < 0) {
                str2 = str + "/*";
            }
            xmlSerializer.attribute(null, "name", str2);
            xmlSerializer.endTag(null, "type");
            i5 = i6 + 1;
        }
        int countDataSchemes = countDataSchemes();
        int i7 = 0;
        while (true) {
            int i8 = i7;
            if (i8 >= countDataSchemes) {
                break;
            }
            xmlSerializer.startTag(null, "scheme");
            xmlSerializer.attribute(null, "name", this.mDataSchemes.get(i8));
            xmlSerializer.endTag(null, "scheme");
            i7 = i8 + 1;
        }
        int countDataSchemeSpecificParts = countDataSchemeSpecificParts();
        int i9 = 0;
        while (true) {
            int i10 = i9;
            if (i10 < countDataSchemeSpecificParts) {
                xmlSerializer.startTag(null, SSP_STR);
                PatternMatcher patternMatcher = this.mDataSchemeSpecificParts.get(i10);
                switch (patternMatcher.getType()) {
                    case 0:
                        xmlSerializer.attribute(null, "literal", patternMatcher.getPath());
                        break;
                    case 1:
                        xmlSerializer.attribute(null, PREFIX_STR, patternMatcher.getPath());
                        break;
                    case 2:
                        xmlSerializer.attribute(null, SGLOB_STR, patternMatcher.getPath());
                        break;
                }
                xmlSerializer.endTag(null, SSP_STR);
                i9 = i10 + 1;
            } else {
                int countDataAuthorities = countDataAuthorities();
                int i11 = 0;
                while (true) {
                    int i12 = i11;
                    if (i12 < countDataAuthorities) {
                        xmlSerializer.startTag(null, AUTH_STR);
                        AuthorityEntry authorityEntry = this.mDataAuthorities.get(i12);
                        xmlSerializer.attribute(null, "host", authorityEntry.getHost());
                        if (authorityEntry.getPort() >= 0) {
                            xmlSerializer.attribute(null, "port", Integer.toString(authorityEntry.getPort()));
                        }
                        xmlSerializer.endTag(null, AUTH_STR);
                        i11 = i12 + 1;
                    } else {
                        int countDataPaths = countDataPaths();
                        int i13 = 0;
                        while (true) {
                            int i14 = i13;
                            if (i14 >= countDataPaths) {
                                return;
                            }
                            xmlSerializer.startTag(null, "path");
                            PatternMatcher patternMatcher2 = this.mDataPaths.get(i14);
                            switch (patternMatcher2.getType()) {
                                case 0:
                                    xmlSerializer.attribute(null, "literal", patternMatcher2.getPath());
                                    break;
                                case 1:
                                    xmlSerializer.attribute(null, PREFIX_STR, patternMatcher2.getPath());
                                    break;
                                case 2:
                                    xmlSerializer.attribute(null, SGLOB_STR, patternMatcher2.getPath());
                                    break;
                            }
                            xmlSerializer.endTag(null, "path");
                            i13 = i14 + 1;
                        }
                    }
                }
            }
        }
    }
}
