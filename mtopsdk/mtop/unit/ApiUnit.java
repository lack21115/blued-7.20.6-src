package mtopsdk.mtop.unit;

import java.io.Serializable;
import java.util.HashSet;
import mtopsdk.mtop.domain.IMTOPDataObject;

/* loaded from: source-3503164-dex2jar.jar:mtopsdk/mtop/unit/ApiUnit.class */
public class ApiUnit implements Serializable, IMTOPDataObject {
    private static final long serialVersionUID = -1592946625198742908L;

    /* renamed from: a  reason: collision with root package name */
    public String f43775a;
    public HashSet b;

    public String toString() {
        return "ApiUnit [version=" + this.f43775a + ", apilist=" + this.b + "]";
    }
}
