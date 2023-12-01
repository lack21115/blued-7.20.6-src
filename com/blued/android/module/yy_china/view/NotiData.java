package com.blued.android.module.yy_china.view;

import android.text.SpannableStringBuilder;
import com.blued.android.module.yy_china.model.YYGlobalMsgMarqueeModel;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/NotiData.class */
class NotiData {
    SpannableStringBuilder a;
    public String b;
    public String c;
    public String d;
    public String e;

    public NotiData(SpannableStringBuilder spannableStringBuilder, String str) {
        this.a = spannableStringBuilder;
        this.d = str;
    }

    public NotiData(YYGlobalMsgMarqueeModel yYGlobalMsgMarqueeModel) {
        this.a = new SpannableStringBuilder(yYGlobalMsgMarqueeModel.content);
        this.b = yYGlobalMsgMarqueeModel.background;
        this.c = yYGlobalMsgMarqueeModel.forward_image;
        this.d = yYGlobalMsgMarqueeModel.after_image;
        this.e = yYGlobalMsgMarqueeModel.link;
    }
}
