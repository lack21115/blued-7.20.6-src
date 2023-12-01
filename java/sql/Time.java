package java.sql;

/* loaded from: source-2895416-dex2jar.jar:java/sql/Time.class */
public class Time extends java.util.Date {
    private static final String PADDING = "00";
    private static final long serialVersionUID = 8397324403548013681L;

    @Deprecated
    public Time(int i, int i2, int i3) {
        super(70, 0, 1, i, i2, i3);
    }

    public Time(long j) {
        super(j);
    }

    private void format(int i, int i2, StringBuilder sb) {
        String valueOf = String.valueOf(i);
        if (i2 - valueOf.length() > 0) {
            sb.append(PADDING.substring(0, i2 - valueOf.length()));
        }
        sb.append(valueOf);
    }

    public static Time valueOf(String str) {
        if (str == null) {
            throw new IllegalArgumentException("timeString == null");
        }
        int indexOf = str.indexOf(58);
        int indexOf2 = str.indexOf(58, indexOf + 1);
        if (indexOf2 == -1 || indexOf == 0 || indexOf2 + 1 == str.length()) {
            throw new IllegalArgumentException();
        }
        return new Time(Integer.parseInt(str.substring(0, indexOf)), Integer.parseInt(str.substring(indexOf + 1, indexOf2)), Integer.parseInt(str.substring(indexOf2 + 1, str.length())));
    }

    @Override // java.util.Date
    @Deprecated
    public int getDate() {
        throw new IllegalArgumentException("unimplemented");
    }

    @Override // java.util.Date
    @Deprecated
    public int getDay() {
        throw new IllegalArgumentException("unimplemented");
    }

    @Override // java.util.Date
    @Deprecated
    public int getMonth() {
        throw new IllegalArgumentException("unimplemented");
    }

    @Override // java.util.Date
    @Deprecated
    public int getYear() {
        throw new IllegalArgumentException("unimplemented");
    }

    @Override // java.util.Date
    @Deprecated
    public void setDate(int i) {
        throw new IllegalArgumentException("unimplemented");
    }

    @Override // java.util.Date
    @Deprecated
    public void setMonth(int i) {
        throw new IllegalArgumentException("unimplemented");
    }

    @Override // java.util.Date
    public void setTime(long j) {
        super.setTime(j);
    }

    @Override // java.util.Date
    @Deprecated
    public void setYear(int i) {
        throw new IllegalArgumentException("unimplemented");
    }

    @Override // java.util.Date
    public String toString() {
        StringBuilder sb = new StringBuilder(8);
        format(getHours(), 2, sb);
        sb.append(':');
        format(getMinutes(), 2, sb);
        sb.append(':');
        format(getSeconds(), 2, sb);
        return sb.toString();
    }
}
