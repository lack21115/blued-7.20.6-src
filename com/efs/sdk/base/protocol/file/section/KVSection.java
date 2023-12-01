package com.efs.sdk.base.protocol.file.section;

import java.util.HashMap;
import java.util.Map;

/* loaded from: source-7206380-dex2jar.jar:com/efs/sdk/base/protocol/file/section/KVSection.class */
public class KVSection extends AbsSection {
    private Map<String, Object> dataMap;

    public KVSection(String str) {
        super("kv");
        this.dataMap = new HashMap();
        this.name = str;
        this.sep = AbsSection.SEP_LINE_BREAK;
    }

    @Override // com.efs.sdk.base.protocol.file.section.AbsSection
    public String changeToStr() {
        StringBuilder sb = new StringBuilder(getDeclarationLine());
        sb.append("\n");
        for (Map.Entry<String, Object> entry : this.dataMap.entrySet()) {
            sb.append(entry.getKey());
            sb.append(":");
            sb.append(entry.getValue());
            sb.append("\n");
        }
        return sb.toString();
    }

    public Map<String, Object> getDataMap() {
        return this.dataMap;
    }

    public KVSection put(String str, Object obj) {
        this.dataMap.put(str, String.valueOf(obj));
        return this;
    }

    public KVSection putMap(Map<String, Object> map) {
        this.dataMap.putAll(map);
        return this;
    }

    public KVSection putNum(String str, long j) {
        this.dataMap.put("wl_".concat(String.valueOf(str)), Long.valueOf(j));
        return this;
    }

    public KVSection putString(String str, String str2) {
        this.dataMap.put("wk_".concat(String.valueOf(str)), str2);
        return this;
    }

    public KVSection putTimestamp(String str, long j) {
        this.dataMap.put("wd_".concat(String.valueOf(str)), Long.valueOf(j));
        return this;
    }
}
