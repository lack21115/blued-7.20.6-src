package mtopsdk.mtop.antiattack;

import com.android.internal.util.cm.NavigationRingConstants;
import java.io.Serializable;
import java.util.Map;
import mtopsdk.common.util.StringUtils;
import mtopsdk.mtop.domain.IMTOPDataObject;

/* loaded from: source-3503164-dex2jar.jar:mtopsdk/mtop/antiattack/CheckCodeDO.class */
public class CheckCodeDO implements Serializable, IMTOPDataObject {
    private static final long serialVersionUID = 1095959954944984636L;
    public String a;
    public String b;
    public Map c;

    /* loaded from: source-3503164-dex2jar.jar:mtopsdk/mtop/antiattack/CheckCodeDO$CheckCodeFieldEnum.class */
    public enum CheckCodeFieldEnum {
        APPLY(NavigationRingConstants.ACTION_APP),
        BACK("back"),
        HOW("how"),
        IP("ip"),
        RAND("rand"),
        SESSION("session"),
        V("v"),
        W("w"),
        NATIVE("native");
        
        private String j;

        CheckCodeFieldEnum(String str) {
            this.j = str;
        }

        public final String a() {
            return this.j;
        }
    }

    public boolean a() {
        return (StringUtils.b(this.a) || StringUtils.b(this.b) || this.c == null) ? false : true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        sb.append("CheckCodeDO [imageUrl=");
        sb.append(this.a);
        sb.append(", checkPath=");
        sb.append(this.b);
        sb.append(", checkParams=");
        sb.append(this.c);
        sb.append("]");
        return sb.toString();
    }
}
