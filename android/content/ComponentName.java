package android.content;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.PrintWriter;

/* loaded from: source-9557208-dex2jar.jar:android/content/ComponentName.class */
public final class ComponentName implements Parcelable, Cloneable, Comparable<ComponentName> {
    public static final Parcelable.Creator<ComponentName> CREATOR = new Parcelable.Creator<ComponentName>() { // from class: android.content.ComponentName.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ComponentName createFromParcel(Parcel parcel) {
            return new ComponentName(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ComponentName[] newArray(int i) {
            return new ComponentName[i];
        }
    };
    private final String mClass;
    private final String mPackage;

    public ComponentName(Context context, Class<?> cls) {
        this.mPackage = context.getPackageName();
        this.mClass = cls.getName();
    }

    public ComponentName(Context context, String str) {
        if (str == null) {
            throw new NullPointerException("class name is null");
        }
        this.mPackage = context.getPackageName();
        this.mClass = str;
    }

    public ComponentName(Parcel parcel) {
        this.mPackage = parcel.readString();
        if (this.mPackage == null) {
            throw new NullPointerException("package name is null");
        }
        this.mClass = parcel.readString();
        if (this.mClass == null) {
            throw new NullPointerException("class name is null");
        }
    }

    private ComponentName(String str, Parcel parcel) {
        this.mPackage = str;
        this.mClass = parcel.readString();
    }

    public ComponentName(String str, String str2) {
        if (str == null) {
            throw new NullPointerException("package name is null");
        }
        if (str2 == null) {
            throw new NullPointerException("class name is null");
        }
        this.mPackage = str;
        this.mClass = str2;
    }

    private static void appendShortClassName(StringBuilder sb, String str, String str2) {
        int length;
        int length2;
        if (str2.startsWith(str) && (length2 = str2.length()) > (length = str.length()) && str2.charAt(length) == '.') {
            sb.append((CharSequence) str2, length, length2);
        } else {
            sb.append(str2);
        }
    }

    public static void appendShortString(StringBuilder sb, String str, String str2) {
        sb.append(str).append('/');
        appendShortClassName(sb, str, str2);
    }

    private static void printShortClassName(PrintWriter printWriter, String str, String str2) {
        int length;
        int length2;
        if (str2.startsWith(str) && (length2 = str2.length()) > (length = str.length()) && str2.charAt(length) == '.') {
            printWriter.write(str2, length, length2 - length);
        } else {
            printWriter.print(str2);
        }
    }

    public static void printShortString(PrintWriter printWriter, String str, String str2) {
        printWriter.print(str);
        printWriter.print('/');
        printShortClassName(printWriter, str, str2);
    }

    public static ComponentName readFromParcel(Parcel parcel) {
        String readString = parcel.readString();
        if (readString != null) {
            return new ComponentName(readString, parcel);
        }
        return null;
    }

    public static ComponentName unflattenFromString(String str) {
        int indexOf = str.indexOf(47);
        if (indexOf < 0 || indexOf + 1 >= str.length()) {
            return null;
        }
        String substring = str.substring(0, indexOf);
        String substring2 = str.substring(indexOf + 1);
        String str2 = substring2;
        if (substring2.length() > 0) {
            str2 = substring2;
            if (substring2.charAt(0) == '.') {
                str2 = substring + substring2;
            }
        }
        return new ComponentName(substring, str2);
    }

    public static void writeToParcel(ComponentName componentName, Parcel parcel) {
        if (componentName != null) {
            componentName.writeToParcel(parcel, 0);
        } else {
            parcel.writeString(null);
        }
    }

    public void appendShortString(StringBuilder sb) {
        appendShortString(sb, this.mPackage, this.mClass);
    }

    /* renamed from: clone */
    public ComponentName m180clone() {
        return new ComponentName(this.mPackage, this.mClass);
    }

    @Override // java.lang.Comparable
    public int compareTo(ComponentName componentName) {
        int compareTo = this.mPackage.compareTo(componentName.mPackage);
        return compareTo != 0 ? compareTo : this.mClass.compareTo(componentName.mClass);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj != null) {
            try {
                ComponentName componentName = (ComponentName) obj;
                z = false;
                if (this.mPackage.equals(componentName.mPackage)) {
                    z = false;
                    if (this.mClass.equals(componentName.mClass)) {
                        z = true;
                    }
                }
            } catch (ClassCastException e) {
                return false;
            }
        }
        return z;
    }

    public String flattenToShortString() {
        StringBuilder sb = new StringBuilder(this.mPackage.length() + this.mClass.length());
        appendShortString(sb, this.mPackage, this.mClass);
        return sb.toString();
    }

    public String flattenToString() {
        return this.mPackage + "/" + this.mClass;
    }

    public String getClassName() {
        return this.mClass;
    }

    public String getPackageName() {
        return this.mPackage;
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x000e, code lost:
        r0 = r4.mPackage.length();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String getShortClassName() {
        /*
            r4 = this;
            r0 = r4
            java.lang.String r0 = r0.mClass
            r1 = r4
            java.lang.String r1 = r1.mPackage
            boolean r0 = r0.startsWith(r1)
            if (r0 == 0) goto L3a
            r0 = r4
            java.lang.String r0 = r0.mPackage
            int r0 = r0.length()
            r5 = r0
            r0 = r4
            java.lang.String r0 = r0.mClass
            int r0 = r0.length()
            r6 = r0
            r0 = r6
            r1 = r5
            if (r0 <= r1) goto L3a
            r0 = r4
            java.lang.String r0 = r0.mClass
            r1 = r5
            char r0 = r0.charAt(r1)
            r1 = 46
            if (r0 != r1) goto L3a
            r0 = r4
            java.lang.String r0 = r0.mClass
            r1 = r5
            r2 = r6
            java.lang.String r0 = r0.substring(r1, r2)
            return r0
        L3a:
            r0 = r4
            java.lang.String r0 = r0.mClass
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.content.ComponentName.getShortClassName():java.lang.String");
    }

    public int hashCode() {
        return this.mPackage.hashCode() + this.mClass.hashCode();
    }

    public String toShortString() {
        return "{" + this.mPackage + "/" + this.mClass + "}";
    }

    public String toString() {
        return "ComponentInfo{" + this.mPackage + "/" + this.mClass + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mPackage);
        parcel.writeString(this.mClass);
    }
}
