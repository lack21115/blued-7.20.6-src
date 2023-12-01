package com.soft.blued.ui.msg.util;

import android.view.View;
import com.blued.android.module.common.widget.pop.BluedPopupWindow;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/util/MsgBoxGuideUtils.class */
public class MsgBoxGuideUtils {

    /* renamed from: com.soft.blued.ui.msg.util.MsgBoxGuideUtils$1  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/util/MsgBoxGuideUtils$1.class */
    class AnonymousClass1 implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ BluedPopupWindow f32601a;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Tracker.onClick(view);
            this.f32601a.dismiss();
        }
    }
}
