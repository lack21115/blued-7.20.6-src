package c.t.m.g;

import java.util.regex.Pattern;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/c6.class */
public class c6 {

    /* renamed from: a  reason: collision with root package name */
    public static final Pattern f3731a;
    public static final Pattern b;

    /* renamed from: c  reason: collision with root package name */
    public static final Pattern f3732c;

    static {
        Pattern compile = Pattern.compile("[0-9a-zA-Z+-]*");
        f3731a = compile;
        b = compile;
        f3732c = Pattern.compile("[A-Z0-9]{12}");
    }

    public static String a(String str, Pattern pattern) {
        return (str != null && pattern.matcher(str).matches()) ? str : "";
    }
}
