package mtopsdk.mtop.transform;

import android.os.Handler;
import java.util.Map;
import mtopsdk.mtop.MtopProxy;
import mtopsdk.mtop.common.ApiID;
import mtopsdk.mtop.domain.MtopResponse;

/* loaded from: source-3503164-dex2jar.jar:mtopsdk/mtop/transform/MtopTransform.class */
public interface MtopTransform {
    ApiID a(MtopProxy mtopProxy, Map map, Handler handler);

    MtopResponse a(MtopProxy mtopProxy, Map map);
}
