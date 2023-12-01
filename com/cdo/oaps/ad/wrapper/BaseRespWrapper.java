package com.cdo.oaps.ad.wrapper;

import com.cdo.oaps.ad.OapsKey;
import com.cdo.oaps.ad.ag;
import com.cdo.oaps.ad.ai;
import java.util.Map;

/* loaded from: source-7206380-dex2jar.jar:com/cdo/oaps/ad/wrapper/BaseRespWrapper.class */
public class BaseRespWrapper extends ai {
    protected BaseRespWrapper(Map<String, Object> map) {
        super(map);
    }

    public static BaseRespWrapper wrapper(Map<String, Object> map) {
        return new BaseRespWrapper(map);
    }

    public final int getCode() {
        try {
            return getInt("code");
        } catch (ag e) {
            return -1;
        }
    }

    public final Object getContent() {
        try {
            return get("content");
        } catch (ag e) {
            return null;
        }
    }

    public byte[] getData() {
        try {
            return (byte[]) get(OapsKey.KEY_BYTE_DATA);
        } catch (ag e) {
            return null;
        }
    }

    public String getDataMd5() {
        try {
            return (String) get(OapsKey.KEY_BYTE_DATA_MD5);
        } catch (ag e) {
            return "";
        }
    }

    public final BaseRespWrapper setCode(int i) {
        return (BaseRespWrapper) super.set("code", Integer.valueOf(i));
    }

    public final BaseRespWrapper setContent(Object obj) {
        return (BaseRespWrapper) super.set("content", obj);
    }

    public BaseRespWrapper setData(byte[] bArr) {
        return (BaseRespWrapper) set(OapsKey.KEY_BYTE_DATA, bArr);
    }

    public BaseRespWrapper setDataMd5(String str) {
        return (BaseRespWrapper) set(OapsKey.KEY_BYTE_DATA_MD5, str);
    }
}
