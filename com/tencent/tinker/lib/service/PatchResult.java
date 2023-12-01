package com.tencent.tinker.lib.service;

import java.io.Serializable;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/lib/service/PatchResult.class */
public class PatchResult implements Serializable {
    public long costTime;
    public long dexoptTriggerTime;
    public Throwable e;
    public boolean isOatGenerated;
    public boolean isSuccess;
    public String patchVersion;
    public String rawPatchFilePath;

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("\nPatchResult: \n");
        stringBuffer.append("isSuccess:" + this.isSuccess + "\n");
        stringBuffer.append("rawPatchFilePath:" + this.rawPatchFilePath + "\n");
        stringBuffer.append("costTime:" + this.costTime + "\n");
        stringBuffer.append("dexoptTriggerTime:" + this.dexoptTriggerTime + "\n");
        stringBuffer.append("isOatGenerated:" + this.isOatGenerated + "\n");
        if (this.patchVersion != null) {
            stringBuffer.append("patchVersion:" + this.patchVersion + "\n");
        }
        if (this.e != null) {
            stringBuffer.append("Throwable:" + this.e.getMessage() + "\n");
        }
        return stringBuffer.toString();
    }
}
