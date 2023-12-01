package android.os;

import android.os.Parcelable;

/* loaded from: source-9557208-dex2jar.jar:android/os/PatternMatcher.class */
public class PatternMatcher implements Parcelable {
    public static final Parcelable.Creator<PatternMatcher> CREATOR = new Parcelable.Creator<PatternMatcher>() { // from class: android.os.PatternMatcher.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PatternMatcher createFromParcel(Parcel parcel) {
            return new PatternMatcher(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PatternMatcher[] newArray(int i) {
            return new PatternMatcher[i];
        }
    };
    public static final int PATTERN_LITERAL = 0;
    public static final int PATTERN_PREFIX = 1;
    public static final int PATTERN_SIMPLE_GLOB = 2;
    private final String mPattern;
    private final int mType;

    public PatternMatcher(Parcel parcel) {
        this.mPattern = parcel.readString();
        this.mType = parcel.readInt();
    }

    public PatternMatcher(String str, int i) {
        this.mPattern = str;
        this.mType = i;
    }

    static boolean matchPattern(String str, String str2, int i) {
        int i2;
        boolean z = true;
        if (str2 == null) {
            return false;
        }
        if (i == 0) {
            return str.equals(str2);
        }
        if (i == 1) {
            return str2.startsWith(str);
        }
        if (i == 2) {
            int length = str.length();
            if (length <= 0) {
                if (str2.length() > 0) {
                    z = false;
                }
                return z;
            }
            int length2 = str2.length();
            int i3 = 0;
            int i4 = 0;
            char charAt = str.charAt(0);
            while (i3 < length && i4 < length2) {
                int i5 = i3 + 1;
                char charAt2 = i5 < length ? str.charAt(i5) : (char) 0;
                boolean z2 = charAt == '\\';
                char c2 = charAt;
                int i6 = i5;
                charAt = charAt2;
                if (z2) {
                    i6 = i5 + 1;
                    if (i6 < length) {
                        charAt = str.charAt(i6);
                        c2 = charAt2;
                    } else {
                        charAt = 0;
                        c2 = charAt2;
                    }
                }
                if (charAt == '*') {
                    int i7 = i4;
                    if (!z2) {
                        i7 = i4;
                        if (c2 == '.') {
                            if (i6 >= length - 1) {
                                return true;
                            }
                            int i8 = i6 + 1;
                            char charAt3 = str.charAt(i8);
                            int i9 = i4;
                            int i10 = i8;
                            char c3 = charAt3;
                            if (charAt3 == '\\') {
                                i10 = i8 + 1;
                                if (i10 < length) {
                                    c3 = str.charAt(i10);
                                    i9 = i4;
                                } else {
                                    c3 = 0;
                                    i9 = i4;
                                }
                            }
                            while (true) {
                                if (str2.charAt(i9) != c3) {
                                    i2 = i9 + 1;
                                    i9 = i2;
                                    if (i2 >= length2) {
                                        break;
                                    }
                                } else {
                                    i2 = i9;
                                    break;
                                }
                            }
                            if (i2 == length2) {
                                return false;
                            }
                            i3 = i10 + 1;
                            charAt = i3 < length ? str.charAt(i3) : (char) 0;
                            i4 = i2 + 1;
                        }
                    }
                    while (true) {
                        if (str2.charAt(i7) == c2) {
                            i4 = i7 + 1;
                            i7 = i4;
                            if (i4 >= length2) {
                                break;
                            }
                        } else {
                            i4 = i7;
                            break;
                        }
                    }
                    i3 = i6 + 1;
                    charAt = i3 < length ? str.charAt(i3) : (char) 0;
                } else if (c2 != '.' && str2.charAt(i4) != c2) {
                    return false;
                } else {
                    i4++;
                    i3 = i6;
                }
            }
            if (i3 < length || i4 < length2) {
                return i3 == length - 2 && str.charAt(i3) == '.' && str.charAt(i3 + 1) == '*';
            }
            return true;
        }
        return false;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final String getPath() {
        return this.mPattern;
    }

    public final int getType() {
        return this.mType;
    }

    public boolean match(String str) {
        return matchPattern(this.mPattern, str, this.mType);
    }

    public String toString() {
        String str = "? ";
        switch (this.mType) {
            case 0:
                str = "LITERAL: ";
                break;
            case 1:
                str = "PREFIX: ";
                break;
            case 2:
                str = "GLOB: ";
                break;
        }
        return "PatternMatcher{" + str + this.mPattern + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mPattern);
        parcel.writeInt(this.mType);
    }
}
