package com.igexin.push.extension.mod;

import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/push/extension/mod/PushMessageInterface.class */
public interface PushMessageInterface {

    /* loaded from: source-7994992-dex2jar.jar:com/igexin/push/extension/mod/PushMessageInterface$ActionPrepareState.class */
    public enum ActionPrepareState {
        success,
        wait,
        stop
    }

    boolean executeAction(PushTaskBean pushTaskBean, BaseActionBean baseActionBean);

    BaseActionBean parseAction(JSONObject jSONObject);

    ActionPrepareState prepareExecuteAction(PushTaskBean pushTaskBean, BaseActionBean baseActionBean);
}
