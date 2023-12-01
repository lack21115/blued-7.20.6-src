package com.xiaomi.clientreport.processor;

import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/clientreport/processor/IEventProcessor.class */
public interface IEventProcessor extends c, d {
    String bytesToString(byte[] bArr);

    void setEventMap(HashMap<String, ArrayList<com.xiaomi.clientreport.data.a>> hashMap);

    byte[] stringToBytes(String str);
}
