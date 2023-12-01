package com.youzan.androidsdk.event;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.youzan.androidsdk.model.goods.GoodsOfSettleModel;
import com.youzan.androidsdk.tool.JsonUtil;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/androidsdk/event/AbsAddUpEvent.class */
public abstract class AbsAddUpEvent implements Event {
    public static final String TAG = "AbsAddUpEvent";

    @Override // com.youzan.androidsdk.event.Event
    public void call(Context context, String str) {
        try {
            String optString = new JSONObject(str).optString("goodsList");
            if (TextUtils.isEmpty(optString)) {
                Log.e(TAG, "JsBridge数据解析异常,无商品数据字段");
            } else {
                call(context, JsonUtil.getObjectListFromStr(optString, GoodsOfSettleModel.class));
            }
        } catch (JSONException e) {
            Log.e(TAG, "Js Bridge数据解析异常");
        }
    }

    public abstract void call(Context context, List<GoodsOfSettleModel> list);

    @Override // com.youzan.androidsdk.event.Event
    public String subscribe() {
        return EventAPI.EVENT_ADD_UP;
    }
}
