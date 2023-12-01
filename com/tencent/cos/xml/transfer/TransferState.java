package com.tencent.cos.xml.transfer;

import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/transfer/TransferState.class */
public enum TransferState {
    CONSTRAINED,
    WAITING,
    IN_PROGRESS,
    PAUSED,
    RESUMED_WAITING,
    COMPLETED,
    CANCELED,
    FAILED,
    UNKNOWN;
    
    private static final Map<String, TransferState> MAP = new HashMap();

    static {
        TransferState[] values;
        for (TransferState transferState : values()) {
            MAP.put(transferState.toString(), transferState);
        }
    }

    public static TransferState getState(String str) {
        return MAP.containsKey(str) ? MAP.get(str) : UNKNOWN;
    }
}
