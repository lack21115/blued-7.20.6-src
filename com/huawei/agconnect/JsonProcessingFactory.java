package com.huawei.agconnect;

import java.util.HashMap;
import java.util.Map;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/agconnect/JsonProcessingFactory.class */
public final class JsonProcessingFactory {
    private static final Map<String, JsonProcessor> PROCESSOR_MAP = new HashMap();

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/agconnect/JsonProcessingFactory$JsonProcessor.class */
    public interface JsonProcessor {
        String processOption(AGConnectOptions aGConnectOptions);
    }

    public static Map<String, JsonProcessor> getProcessors() {
        return PROCESSOR_MAP;
    }

    public static void registerProcessor(String str, JsonProcessor jsonProcessor) {
        PROCESSOR_MAP.put(str, jsonProcessor);
    }
}
