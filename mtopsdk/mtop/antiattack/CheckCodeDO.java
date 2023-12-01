package mtopsdk.mtop.antiattack;

import com.anythink.expressad.foundation.g.a.f;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.tencent.tendinsv.a.b;
import com.umeng.analytics.pro.d;
import java.io.Serializable;
import java.util.Map;
import mtopsdk.common.util.StringUtils;
import mtopsdk.mtop.domain.IMTOPDataObject;

/* loaded from: source-3503164-dex2jar.jar:mtopsdk/mtop/antiattack/CheckCodeDO.class */
public class CheckCodeDO implements Serializable, IMTOPDataObject {
    private static final long serialVersionUID = 1095959954944984636L;

    /* renamed from: a  reason: collision with root package name */
    public String f43700a;
    public String b;

    /* renamed from: c  reason: collision with root package name */
    public Map f43701c;

    /* loaded from: source-3503164-dex2jar.jar:mtopsdk/mtop/antiattack/CheckCodeDO$CheckCodeFieldEnum.class */
    public enum CheckCodeFieldEnum {
        APPLY("app"),
        BACK("back"),
        HOW("how"),
        IP(b.a.q),
        RAND("rand"),
        SESSION(d.aw),
        V("v"),
        W(IAdInterListener.AdReqParam.WIDTH),
        NATIVE(f.f7832a);
        
        private String j;

        CheckCodeFieldEnum(String str) {
            this.j = str;
        }

        public final String a() {
            return this.j;
        }
    }

    public boolean a() {
        return (StringUtils.b(this.f43700a) || StringUtils.b(this.b) || this.f43701c == null) ? false : true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        sb.append("CheckCodeDO [imageUrl=");
        sb.append(this.f43700a);
        sb.append(", checkPath=");
        sb.append(this.b);
        sb.append(", checkParams=");
        sb.append(this.f43701c);
        sb.append("]");
        return sb.toString();
    }
}
