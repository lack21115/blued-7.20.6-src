package mtopsdk.mtop.util;

import java.io.Serializable;

/* loaded from: source-3503164-dex2jar.jar:mtopsdk/mtop/util/Result.class */
public class Result implements Serializable {
    private static final long serialVersionUID = 8852253200756618077L;

    /* renamed from: a  reason: collision with root package name */
    protected boolean f43794a;
    protected Object b;

    /* renamed from: c  reason: collision with root package name */
    protected String f43795c;
    protected String d;
    protected String e;

    public Result() {
        this.f43794a = true;
    }

    public Result(Object obj) {
        this.f43794a = true;
        this.b = obj;
    }

    public Result(boolean z, String str, String str2) {
        this(z, null, str, str2);
    }

    public Result(boolean z, String str, String str2, String str3) {
        this.f43794a = true;
        this.f43794a = z;
        this.f43795c = str;
        this.d = str2;
        this.e = str3;
    }

    public Object a() {
        return this.b;
    }

    public void a(Object obj) {
        this.b = obj;
    }

    public void a(boolean z) {
        this.f43794a = z;
    }

    public String b() {
        return this.d;
    }

    public String c() {
        return this.e;
    }

    public boolean d() {
        return this.f43794a;
    }
}
