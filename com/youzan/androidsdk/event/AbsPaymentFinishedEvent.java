package com.youzan.androidsdk.event;

import android.content.Context;
import android.util.Log;
import com.google.gson.JsonSyntaxException;
import com.youzan.androidsdk.model.trade.TradePayFinishedModel;
import com.youzan.androidsdk.tool.JsonUtil;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/androidsdk/event/AbsPaymentFinishedEvent.class */
public abstract class AbsPaymentFinishedEvent implements Event {
    public static final String TAG = "AbsPaymentFinishedEvent";

    public abstract void call(Context context, TradePayFinishedModel tradePayFinishedModel);

    @Override // com.youzan.androidsdk.event.Event
    public void call(Context context, String str) {
        try {
            call(context, (TradePayFinishedModel) JsonUtil.fromJson(str, (Class<Object>) TradePayFinishedModel.class));
        } catch (JsonSyntaxException e) {
            Log.e(TAG, "Js Bridge数据解析异常");
        }
    }

    @Override // com.youzan.androidsdk.event.Event
    public String subscribe() {
        return EventAPI.EVENT_PAYMENT_FINISHED;
    }
}
