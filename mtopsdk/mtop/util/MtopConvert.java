package mtopsdk.mtop.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.domain.BaseOutDo;
import mtopsdk.mtop.domain.IMTOPDataObject;
import mtopsdk.mtop.domain.MtopRequest;
import mtopsdk.mtop.domain.MtopResponse;

/* loaded from: source-3503164-dex2jar.jar:mtopsdk/mtop/util/MtopConvert.class */
public class MtopConvert {
    public static BaseOutDo a(MtopResponse mtopResponse, Class cls) {
        if (cls == null || mtopResponse == null) {
            TBSdkLog.d("mtopsdk.MtopConvert", "outClass is null or response is null");
            return null;
        }
        return a(mtopResponse.d(), cls);
    }

    public static BaseOutDo a(byte[] bArr, Class cls) {
        if (cls == null || bArr == null || bArr.length == 0) {
            TBSdkLog.d("mtopsdk.MtopConvert", "[jsonToOutputDO]outClass is null or jsondata is blank");
            return null;
        }
        try {
            return (BaseOutDo) JSON.parseObject(bArr, cls, new Feature[0]);
        } catch (Throwable th) {
            TBSdkLog.b("mtopsdk.MtopConvert", "[jsonToOutputDO]invoke JSON.parseObject error ---Class=" + cls.getName(), th);
            return null;
        }
    }

    public static MtopRequest a(Object obj) {
        if (obj == null) {
            return null;
        }
        return ReflectUtil.a(obj);
    }

    public static MtopRequest a(IMTOPDataObject iMTOPDataObject) {
        if (iMTOPDataObject == null) {
            return null;
        }
        return ReflectUtil.a(iMTOPDataObject);
    }
}
