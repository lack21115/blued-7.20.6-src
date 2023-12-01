package com.youzan.androidsdk.event;

import android.content.Context;
import android.util.Log;
import com.google.gson.JsonSyntaxException;
import com.youzan.androidsdk.model.cashier.GoCashierModel;
import com.youzan.androidsdk.tool.JsonUtil;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/androidsdk/event/AbsGoCashierEvent.class */
public abstract class AbsGoCashierEvent implements Event {
    @Override // com.youzan.androidsdk.event.Event
    public final void call(Context context, String str) {
        try {
            try {
                call((GoCashierModel) JsonUtil.fromJson(str, (Class<Object>) GoCashierModel.class));
            } catch (JsonSyntaxException e) {
                Log.e("AbsGoCashierEvent", "Js Bridge数据解析异常");
                call(null);
            }
        } catch (Throwable th) {
            call(null);
            throw th;
        }
    }

    public abstract void call(GoCashierModel goCashierModel);

    @Override // com.youzan.androidsdk.event.Event
    public final String subscribe() {
        return EventAPI.EVENT_INVOKE_GO_CASHIER;
    }
}
