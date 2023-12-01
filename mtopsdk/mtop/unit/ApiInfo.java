package mtopsdk.mtop.unit;

import java.io.Serializable;
import mtopsdk.mtop.domain.IMTOPDataObject;

/* loaded from: source-3503164-dex2jar.jar:mtopsdk/mtop/unit/ApiInfo.class */
public class ApiInfo implements Serializable, IMTOPDataObject {
    private static final long serialVersionUID = -1408374287101501181L;

    /* renamed from: a  reason: collision with root package name */
    public String f43774a;
    public String b;

    public ApiInfo() {
    }

    public ApiInfo(String str, String str2) {
        this.f43774a = str;
        this.b = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            ApiInfo apiInfo = (ApiInfo) obj;
            String str = this.f43774a;
            if (str == null) {
                if (apiInfo.f43774a != null) {
                    return false;
                }
            } else if (!str.equalsIgnoreCase(apiInfo.f43774a)) {
                return false;
            }
            String str2 = this.b;
            String str3 = apiInfo.b;
            return str2 == null ? str3 == null : str2.equalsIgnoreCase(str3);
        }
        return false;
    }

    public int hashCode() {
        String str = this.f43774a;
        int i = 0;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.b;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return ((hashCode + 31) * 31) + i;
    }

    public String toString() {
        return "ApiInfo [api=" + this.f43774a + ", v=" + this.b + "]";
    }
}
