package com.efs.sdk.base.protocol;

import com.efs.sdk.base.core.config.a;

/* loaded from: source-5961304-dex2jar.jar:com/efs/sdk/base/protocol/ILogProtocol.class */
public interface ILogProtocol {
    public static final String KEY_PREFIX_NUM = "wl_";
    public static final String KEY_PREFIX_STRING = "wk_";
    public static final String KEY_PREFIX_TIMESTAMP = "wd_";
    public static final int LOG_BODY_TYPE_BYTE_ARRAY = 0;
    public static final int LOG_BODY_TYPE_FILE_PATH = 1;
    public static final String LOG_KEY_TYPE = "type";
    public static final byte LOG_PROTOCOL_FILE = 2;
    public static final byte LOG_PROTOCOL_MIXED = 3;
    public static final byte LOG_PROTOCOL_NONE = 0;
    public static final byte LOG_PROTOCOL_RECORD = 1;

    byte[] generate();

    String generateString();

    int getBodyType();

    String getFilePath();

    String getLinkId();

    String getLinkKey();

    byte getLogProtocol();

    String getLogType();

    void insertGlobal(a aVar);
}
