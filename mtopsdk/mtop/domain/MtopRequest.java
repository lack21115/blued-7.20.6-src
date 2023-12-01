package mtopsdk.mtop.domain;

import java.io.Serializable;
import java.util.Map;
import mtopsdk.common.util.StringUtils;

/* loaded from: source-3503164-dex2jar.jar:mtopsdk/mtop/domain/MtopRequest.class */
public class MtopRequest implements Serializable, IMTOPDataObject {
    private static final long serialVersionUID = -439476282014493612L;

    /* renamed from: a  reason: collision with root package name */
    public Map f43745a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private String f43746c;
    private String d = "{}";
    private boolean e;
    private boolean f;

    public String a() {
        return this.b;
    }

    public void a(String str) {
        this.b = str;
    }

    public void a(boolean z) {
        this.e = z;
    }

    public String b() {
        return this.f43746c;
    }

    public void b(String str) {
        this.f43746c = str;
    }

    public void b(boolean z) {
        this.f = z;
    }

    public String c() {
        return this.d;
    }

    public void c(String str) {
        this.d = str;
    }

    public boolean d() {
        return this.e;
    }

    public boolean e() {
        return StringUtils.a(this.b) && StringUtils.a(this.f43746c) && StringUtils.a(this.d);
    }

    public String f() {
        if (StringUtils.b(this.b) || StringUtils.b(this.f43746c)) {
            return null;
        }
        return StringUtils.a(this.b, this.f43746c);
    }

    public String toString() {
        return "MtopRequest [ apiName=" + this.b + ", version=" + this.f43746c + ", data=" + this.d + ", needEcode=" + this.e + ", needSession=" + this.f + "]";
    }
}
