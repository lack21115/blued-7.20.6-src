package com.youzan.androidsdk.event;

import android.content.Context;
import com.youzan.androidsdk.model.goods.GoodsShareModel;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/androidsdk/event/AbsShareEvent.class */
public abstract class AbsShareEvent implements Event {
    public abstract void call(Context context, GoodsShareModel goodsShareModel);

    @Override // com.youzan.androidsdk.event.Event
    public final void call(Context context, String str) {
        try {
            call(context, new GoodsShareModel(new JSONObject(str)));
        } catch (JSONException e) {
        }
    }

    @Override // com.youzan.androidsdk.event.Event
    public String subscribe() {
        return "returnShareData";
    }
}
