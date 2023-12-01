package com.youzan.androidsdk.event;

import android.content.Context;
import android.util.Log;
import com.google.gson.JsonSyntaxException;
import com.youzan.androidsdk.model.goods.GoodsOfCartModel;
import com.youzan.androidsdk.tool.JsonUtil;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/androidsdk/event/AbsAddToCartEvent.class */
public abstract class AbsAddToCartEvent implements Event {
    public static final String TAG = "AbsAddToCartEvent";

    public abstract void call(Context context, GoodsOfCartModel goodsOfCartModel);

    @Override // com.youzan.androidsdk.event.Event
    public void call(Context context, String str) {
        try {
            call(context, (GoodsOfCartModel) JsonUtil.fromJson(str, (Class<Object>) GoodsOfCartModel.class));
        } catch (JsonSyntaxException e) {
            Log.e(TAG, "Js Bridge数据解析异常");
        }
    }

    @Override // com.youzan.androidsdk.event.Event
    public String subscribe() {
        return EventAPI.EVENT_ADD_TO_CART;
    }
}
