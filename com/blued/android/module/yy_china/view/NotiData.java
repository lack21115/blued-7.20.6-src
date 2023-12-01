package com.blued.android.module.yy_china.view;

import android.text.SpannableStringBuilder;
import com.blued.android.module.yy_china.model.YYGlobalMsgMarqueeModel;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/NotiData.class */
class NotiData {

    /* renamed from: a  reason: collision with root package name */
    SpannableStringBuilder f17962a;
    public String b;

    /* renamed from: c  reason: collision with root package name */
    public String f17963c;
    public String d;
    public String e;

    public NotiData(SpannableStringBuilder spannableStringBuilder, String str) {
        this.f17962a = spannableStringBuilder;
        this.d = str;
    }

    public NotiData(YYGlobalMsgMarqueeModel yYGlobalMsgMarqueeModel) {
        this.f17962a = new SpannableStringBuilder(yYGlobalMsgMarqueeModel.content);
        this.b = yYGlobalMsgMarqueeModel.background;
        this.f17963c = yYGlobalMsgMarqueeModel.forward_image;
        this.d = yYGlobalMsgMarqueeModel.after_image;
        this.e = yYGlobalMsgMarqueeModel.link;
    }
}
