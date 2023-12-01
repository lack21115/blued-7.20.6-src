package java.sql;

import com.amap.api.services.core.AMapException;
import com.android.internal.content.NativeLibraryHelper;

@FindBugsSuppressWarnings({"NM_SAME_SIMPLE_NAME_AS_SUPERCLASS"})
/* loaded from: source-2895416-dex2jar.jar:java/sql/Date.class */
public class Date extends java.util.Date {
    private static final String PADDING = "0000";
    private static final long serialVersionUID = 1511598038487230103L;

    @Deprecated
    public Date(int i, int i2, int i3) {
        super(i, i2, i3);
    }

    public Date(long j) {
        super(normalizeTime(j));
    }

    private void format(int i, int i2, StringBuilder sb) {
        String valueOf = String.valueOf(i);
        if (i2 - valueOf.length() > 0) {
            sb.append(PADDING.substring(0, i2 - valueOf.length()));
        }
        sb.append(valueOf);
    }

    private static long normalizeTime(long j) {
        return j;
    }

    public static Date valueOf(String str) {
        if (str == null) {
            throw new IllegalArgumentException("dateString == null");
        }
        if (str.length() > 10) {
            throw new IllegalArgumentException();
        }
        String[] split = str.split(NativeLibraryHelper.CLEAR_ABI_OVERRIDE);
        if (split.length != 3) {
            throw new IllegalArgumentException();
        }
        return new Date(Integer.parsePositiveInt(split[0]) - AMapException.CODE_AMAP_CLIENT_UNKNOWN_ERROR, Integer.parsePositiveInt(split[1]) - 1, Integer.parsePositiveInt(split[2]));
    }

    @Override // java.util.Date
    @Deprecated
    public int getHours() {
        throw new IllegalArgumentException("unimplemented");
    }

    @Override // java.util.Date
    @Deprecated
    public int getMinutes() {
        throw new IllegalArgumentException("unimplemented");
    }

    @Override // java.util.Date
    @Deprecated
    public int getSeconds() {
        throw new IllegalArgumentException("unimplemented");
    }

    @Override // java.util.Date
    @Deprecated
    public void setHours(int i) {
        throw new IllegalArgumentException("unimplemented");
    }

    @Override // java.util.Date
    @Deprecated
    public void setMinutes(int i) {
        throw new IllegalArgumentException("unimplemented");
    }

    @Override // java.util.Date
    @Deprecated
    public void setSeconds(int i) {
        throw new IllegalArgumentException("unimplemented");
    }

    @Override // java.util.Date
    public void setTime(long j) {
        super.setTime(normalizeTime(j));
    }

    @Override // java.util.Date
    public String toString() {
        StringBuilder sb = new StringBuilder(10);
        format(getYear() + AMapException.CODE_AMAP_CLIENT_UNKNOWN_ERROR, 4, sb);
        sb.append('-');
        format(getMonth() + 1, 2, sb);
        sb.append('-');
        format(getDate(), 2, sb);
        return sb.toString();
    }
}
