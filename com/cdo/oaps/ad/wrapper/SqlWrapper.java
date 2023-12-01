package com.cdo.oaps.ad.wrapper;

import com.cdo.oaps.ad.ag;
import java.util.Map;

/* loaded from: source-7206380-dex2jar.jar:com/cdo/oaps/ad/wrapper/SqlWrapper.class */
public class SqlWrapper extends BaseWrapper {
    public static final String KEY_DATA = "bkd";

    /* renamed from: a  reason: collision with root package name */
    private static final String f7938a = "bkd_md5";

    /* renamed from: c  reason: collision with root package name */
    private static final String f7939c = "sql_rs";

    public SqlWrapper(Map<String, Object> map) {
        super(map);
    }

    public static SqlWrapper wrapper(Map<String, Object> map) {
        return new SqlWrapper(map);
    }

    public byte[] getData() {
        try {
            return (byte[]) get(KEY_DATA);
        } catch (ag e) {
            return null;
        }
    }

    public String getDataMd5() {
        try {
            return (String) get(f7938a);
        } catch (ag e) {
            return "";
        }
    }

    public String getResult() {
        try {
            return (String) get(f7939c);
        } catch (ag e) {
            return "";
        }
    }

    public SqlWrapper setData(byte[] bArr) {
        return (SqlWrapper) set(KEY_DATA, bArr);
    }

    public SqlWrapper setDataMd5(String str) {
        return (SqlWrapper) set(f7938a, str);
    }

    public SqlWrapper setResult(String str) {
        return (SqlWrapper) set(f7939c, str);
    }
}
