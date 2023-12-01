package com.google.common.base;

import com.igexin.push.core.b;
import com.j256.ormlite.stmt.query.SimpleComparison;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* loaded from: source-8110460-dex2jar.jar:com/google/common/base/Strings.class */
public final class Strings {
    private Strings() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x004f, code lost:
        if (validSurrogatePairAt(r5, r0) != false) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String commonPrefix(java.lang.CharSequence r4, java.lang.CharSequence r5) {
        /*
            r0 = r4
            java.lang.Object r0 = com.google.common.base.Preconditions.checkNotNull(r0)
            r0 = r5
            java.lang.Object r0 = com.google.common.base.Preconditions.checkNotNull(r0)
            r0 = r4
            int r0 = r0.length()
            r1 = r5
            int r1 = r1.length()
            int r0 = java.lang.Math.min(r0, r1)
            r7 = r0
            r0 = 0
            r6 = r0
        L1c:
            r0 = r6
            r1 = r7
            if (r0 >= r1) goto L39
            r0 = r4
            r1 = r6
            char r0 = r0.charAt(r1)
            r1 = r5
            r2 = r6
            char r1 = r1.charAt(r2)
            if (r0 != r1) goto L39
            r0 = r6
            r1 = 1
            int r0 = r0 + r1
            r6 = r0
            goto L1c
        L39:
            r0 = r6
            r1 = 1
            int r0 = r0 - r1
            r8 = r0
            r0 = r4
            r1 = r8
            boolean r0 = validSurrogatePairAt(r0, r1)
            if (r0 != 0) goto L52
            r0 = r6
            r7 = r0
            r0 = r5
            r1 = r8
            boolean r0 = validSurrogatePairAt(r0, r1)
            if (r0 == 0) goto L56
        L52:
            r0 = r6
            r1 = 1
            int r0 = r0 - r1
            r7 = r0
        L56:
            r0 = r4
            r1 = 0
            r2 = r7
            java.lang.CharSequence r0 = r0.subSequence(r1, r2)
            java.lang.String r0 = r0.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.base.Strings.commonPrefix(java.lang.CharSequence, java.lang.CharSequence):java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x006c, code lost:
        if (validSurrogatePairAt(r6, (r6.length() - r7) - 1) != false) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String commonSuffix(java.lang.CharSequence r5, java.lang.CharSequence r6) {
        /*
            r0 = r5
            java.lang.Object r0 = com.google.common.base.Preconditions.checkNotNull(r0)
            r0 = r6
            java.lang.Object r0 = com.google.common.base.Preconditions.checkNotNull(r0)
            r0 = r5
            int r0 = r0.length()
            r1 = r6
            int r1 = r1.length()
            int r0 = java.lang.Math.min(r0, r1)
            r8 = r0
            r0 = 0
            r7 = r0
        L1c:
            r0 = r7
            r1 = r8
            if (r0 >= r1) goto L4b
            r0 = r5
            r1 = r5
            int r1 = r1.length()
            r2 = r7
            int r1 = r1 - r2
            r2 = 1
            int r1 = r1 - r2
            char r0 = r0.charAt(r1)
            r1 = r6
            r2 = r6
            int r2 = r2.length()
            r3 = r7
            int r2 = r2 - r3
            r3 = 1
            int r2 = r2 - r3
            char r1 = r1.charAt(r2)
            if (r0 != r1) goto L4b
            r0 = r7
            r1 = 1
            int r0 = r0 + r1
            r7 = r0
            goto L1c
        L4b:
            r0 = r5
            r1 = r5
            int r1 = r1.length()
            r2 = r7
            int r1 = r1 - r2
            r2 = 1
            int r1 = r1 - r2
            boolean r0 = validSurrogatePairAt(r0, r1)
            if (r0 != 0) goto L6f
            r0 = r7
            r8 = r0
            r0 = r6
            r1 = r6
            int r1 = r1.length()
            r2 = r7
            int r1 = r1 - r2
            r2 = 1
            int r1 = r1 - r2
            boolean r0 = validSurrogatePairAt(r0, r1)
            if (r0 == 0) goto L73
        L6f:
            r0 = r7
            r1 = 1
            int r0 = r0 - r1
            r8 = r0
        L73:
            r0 = r5
            r1 = r5
            int r1 = r1.length()
            r2 = r8
            int r1 = r1 - r2
            r2 = r5
            int r2 = r2.length()
            java.lang.CharSequence r0 = r0.subSequence(r1, r2)
            java.lang.String r0 = r0.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.base.Strings.commonSuffix(java.lang.CharSequence, java.lang.CharSequence):java.lang.String");
    }

    @NullableDecl
    public static String emptyToNull(@NullableDecl String str) {
        return Platform.emptyToNull(str);
    }

    public static boolean isNullOrEmpty(@NullableDecl String str) {
        return Platform.stringIsNullOrEmpty(str);
    }

    public static String lenientFormat(@NullableDecl String str, @NullableDecl Object... objArr) {
        Object[] objArr2;
        int i;
        int indexOf;
        String valueOf = String.valueOf(str);
        if (objArr != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                objArr2 = objArr;
                if (i3 >= objArr.length) {
                    break;
                }
                objArr[i3] = lenientToString(objArr[i3]);
                i2 = i3 + 1;
            }
        } else {
            objArr2 = new Object[]{"(Object[])null"};
        }
        StringBuilder sb = new StringBuilder(valueOf.length() + (objArr2.length * 16));
        int i4 = 0;
        int i5 = 0;
        while (true) {
            i = i5;
            if (i >= objArr2.length || (indexOf = valueOf.indexOf("%s", i4)) == -1) {
                break;
            }
            sb.append((CharSequence) valueOf, i4, indexOf);
            sb.append(objArr2[i]);
            i4 = indexOf + 2;
            i5 = i + 1;
        }
        sb.append((CharSequence) valueOf, i4, valueOf.length());
        if (i < objArr2.length) {
            sb.append(" [");
            sb.append(objArr2[i]);
            int i6 = i + 1;
            while (true) {
                int i7 = i6;
                if (i7 >= objArr2.length) {
                    break;
                }
                sb.append(", ");
                sb.append(objArr2[i7]);
                i6 = i7 + 1;
            }
            sb.append(']');
        }
        return sb.toString();
    }

    private static String lenientToString(@NullableDecl Object obj) {
        if (obj == null) {
            return b.l;
        }
        try {
            return obj.toString();
        } catch (Exception e) {
            String str = obj.getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(obj));
            Logger.getLogger("com.google.common.base.Strings").log(Level.WARNING, "Exception during lenientFormat for " + str, (Throwable) e);
            return SimpleComparison.LESS_THAN_OPERATION + str + " threw " + e.getClass().getName() + SimpleComparison.GREATER_THAN_OPERATION;
        }
    }

    public static String nullToEmpty(@NullableDecl String str) {
        return Platform.nullToEmpty(str);
    }

    public static String padEnd(String str, int i, char c2) {
        Preconditions.checkNotNull(str);
        if (str.length() >= i) {
            return str;
        }
        StringBuilder sb = new StringBuilder(i);
        sb.append(str);
        int length = str.length();
        while (true) {
            int i2 = length;
            if (i2 >= i) {
                return sb.toString();
            }
            sb.append(c2);
            length = i2 + 1;
        }
    }

    public static String padStart(String str, int i, char c2) {
        Preconditions.checkNotNull(str);
        if (str.length() >= i) {
            return str;
        }
        StringBuilder sb = new StringBuilder(i);
        int length = str.length();
        while (true) {
            int i2 = length;
            if (i2 >= i) {
                sb.append(str);
                return sb.toString();
            }
            sb.append(c2);
            length = i2 + 1;
        }
    }

    public static String repeat(String str, int i) {
        Preconditions.checkNotNull(str);
        boolean z = true;
        if (i <= 1) {
            if (i < 0) {
                z = false;
            }
            Preconditions.checkArgument(z, "invalid count: %s", i);
            if (i == 0) {
                str = "";
            }
            return str;
        }
        int length = str.length();
        long j = length * i;
        int i2 = (int) j;
        if (i2 != j) {
            throw new ArrayIndexOutOfBoundsException("Required array size too large: " + j);
        }
        char[] cArr = new char[i2];
        str.getChars(0, length, cArr, 0);
        int i3 = length;
        while (true) {
            int i4 = i3;
            int i5 = i2 - i4;
            if (i4 >= i5) {
                System.arraycopy((Object) cArr, 0, (Object) cArr, i4, i5);
                return new String(cArr);
            }
            System.arraycopy((Object) cArr, 0, (Object) cArr, i4, i4);
            i3 = i4 << 1;
        }
    }

    static boolean validSurrogatePairAt(CharSequence charSequence, int i) {
        return i >= 0 && i <= charSequence.length() - 2 && Character.isHighSurrogate(charSequence.charAt(i)) && Character.isLowSurrogate(charSequence.charAt(i + 1));
    }
}
