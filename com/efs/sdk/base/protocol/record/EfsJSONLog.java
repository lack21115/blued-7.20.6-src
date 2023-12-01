package com.efs.sdk.base.protocol.record;

import com.efs.sdk.base.core.config.a;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.util.Log;
import org.json.JSONObject;

/* loaded from: source-7206380-dex2jar.jar:com/efs/sdk/base/protocol/record/EfsJSONLog.class */
public class EfsJSONLog extends AbsRecordLog {
    public EfsJSONLog(String str) {
        super(str);
        put("type", str);
    }

    public byte[] generate() {
        String generateString = generateString();
        if (ControllerCenter.getGlobalEnvStruct().isPrintLogDetail()) {
            Log.i("efs.base", generateString);
        }
        return generateString.getBytes();
    }

    public String generateString() {
        return new JSONObject(this.dataMap).toString();
    }

    public String getLinkId() {
        if (this.dataMap.containsKey("w_frmid")) {
            return String.valueOf(this.dataMap.get("w_frmid"));
        }
        return null;
    }

    public String getLinkKey() {
        if (this.dataMap.containsKey("w_linkKey")) {
            return String.valueOf(this.dataMap.get("w_linkKey"));
        }
        return null;
    }

    public void insertGlobal(a aVar) {
        this.dataMap.putAll(aVar.a());
        this.dataMap.putAll(ControllerCenter.getGlobalEnvStruct().getPublicParamMap());
    }
}
