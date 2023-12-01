package com.blued.android.module.live_china.model;

import com.blued.android.chat.model.ChattingModel;
import com.blued.android.module.common.utils.ReflectionUtils;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/LiveChattingModel.class */
public class LiveChattingModel extends ChattingModel {
    public LiveNobleModel nobleModel;
    private Object objExtra;
    public String vip_frame = "";
    public int vip_level;

    public LiveChattingModel() {
    }

    public LiveChattingModel(ChattingModel chattingModel) {
        ReflectionUtils.a(chattingModel, this);
    }

    public static LiveChattingModel copy(ChattingModel chattingModel) {
        return new LiveChattingModel(chattingModel);
    }

    public Object getObjExtra() {
        return this.objExtra;
    }

    public void setObjExtra(Object obj) {
        this.objExtra = obj;
    }
}
