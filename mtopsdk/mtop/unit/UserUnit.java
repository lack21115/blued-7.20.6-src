package mtopsdk.mtop.unit;

import java.io.Serializable;
import mtopsdk.mtop.domain.IMTOPDataObject;

/* loaded from: source-3503164-dex2jar.jar:mtopsdk/mtop/unit/UserUnit.class */
public class UserUnit implements Serializable, IMTOPDataObject {
    private static final long serialVersionUID = 2326301535071107548L;
    public String a;
    public UnitType b;
    public String c;

    /* loaded from: source-3503164-dex2jar.jar:mtopsdk/mtop/unit/UserUnit$UnitType.class */
    public enum UnitType {
        CENTER("center"),
        UNIT("unit");
        
        private String c;

        UnitType(String str) {
            this.c = str;
        }

        public final String a() {
            return this.c;
        }
    }

    public UserUnit() {
        this.b = UnitType.CENTER;
    }

    public UserUnit(String str, UnitType unitType, String str2) {
        this.b = UnitType.CENTER;
        this.a = str;
        if (unitType != null) {
            this.b = unitType;
        }
        this.c = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            UserUnit userUnit = (UserUnit) obj;
            String str = this.c;
            if (str == null) {
                if (userUnit.c != null) {
                    return false;
                }
            } else if (!str.equals(userUnit.c)) {
                return false;
            }
            if (this.b != userUnit.b) {
                return false;
            }
            String str2 = this.a;
            String str3 = userUnit.a;
            return str2 == null ? str3 == null : str2.equals(str3);
        }
        return false;
    }

    public int hashCode() {
        String str = this.c;
        int i = 0;
        int hashCode = str == null ? 0 : str.hashCode();
        UnitType unitType = this.b;
        int hashCode2 = unitType == null ? 0 : unitType.hashCode();
        String str2 = this.a;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return ((((hashCode + 31) * 31) + hashCode2) * 31) + i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(48);
        sb.append("UserUnit [userId=");
        sb.append(this.a);
        sb.append(",unitType=");
        sb.append(this.b);
        sb.append(",unitPrefix=");
        sb.append(this.c);
        sb.append("]");
        return sb.toString();
    }
}
