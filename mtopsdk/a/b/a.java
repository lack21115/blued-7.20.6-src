package mtopsdk.a.b;

import java.io.Serializable;
import mtopsdk.common.util.StringUtils;

/* loaded from: source-3503164-dex2jar.jar:mtopsdk/a/b/a.class */
public final class a implements Serializable, Cloneable {
    public String a;

    public final String a() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("isRequestSuccess=false");
        sb.append(",host=");
        sb.append((String) null);
        sb.append(",ip_port=");
        sb.append((String) null);
        sb.append(",isSSL=false");
        sb.append(",connType=");
        sb.append((String) null);
        sb.append(",oneWayTime_ANet=0");
        sb.append(",postBodyTime=0");
        sb.append(",firstDataTime=0");
        sb.append(",recDataTime=0");
        sb.append(",serverRT=0");
        sb.append(",rtt=0");
        sb.append(",sendSize=0");
        sb.append(",totalSize=0");
        sb.append(",dataSpeed=0");
        sb.append(",retryTime=0");
        return sb.toString();
    }

    public final String toString() {
        if (StringUtils.b(this.a)) {
            this.a = a();
        }
        return "NetworkStats [" + this.a + "]";
    }
}
