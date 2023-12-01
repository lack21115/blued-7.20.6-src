package mtopsdk.mtop.unit;

import java.io.Serializable;
import mtopsdk.mtop.domain.IMTOPDataObject;

/* loaded from: source-3503164-dex2jar.jar:mtopsdk/mtop/unit/ApiInfo.class */
public class ApiInfo implements Serializable, IMTOPDataObject {
    private static final long serialVersionUID = -1408374287101501181L;
    public String a;
    public String b;

    public ApiInfo() {
    }

    public ApiInfo(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            ApiInfo apiInfo = (ApiInfo) obj;
            String str = this.a;
            if (str == null) {
                if (apiInfo.a != null) {
                    return false;
                }
            } else if (!str.equalsIgnoreCase(apiInfo.a)) {
                return false;
            }
            String str2 = this.b;
            String str3 = apiInfo.b;
            return str2 == null ? str3 == null : str2.equalsIgnoreCase(str3);
        }
        return false;
    }

    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.b;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return ((hashCode + 31) * 31) + i;
    }

    public String toString() {
        return "ApiInfo [api=" + this.a + ", v=" + this.b + "]";
    }
}
