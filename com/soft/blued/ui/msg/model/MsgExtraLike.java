package com.soft.blued.ui.msg.model;

import android.text.TextUtils;
import java.io.Serializable;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/model/MsgExtraLike.class */
public class MsgExtraLike implements Serializable {
    public String content;
    public String identical;

    public boolean isEmpty() {
        return TextUtils.isEmpty(this.content) || TextUtils.isEmpty(this.identical);
    }
}
