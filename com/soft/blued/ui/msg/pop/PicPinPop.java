package com.soft.blued.ui.msg.pop;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.blued.android.framework.ui.xpop.core.AttachPopupView;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/pop/PicPinPop.class */
public final class PicPinPop extends AttachPopupView {
    private boolean t;
    private final OperateListener u;

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/pop/PicPinPop$OperateListener.class */
    public interface OperateListener {
        void a();

        void b();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PicPinPop(Context context, boolean z, OperateListener operateListener) {
        super(context);
        Intrinsics.e(context, "context");
        Intrinsics.e(operateListener, "listener");
        this.t = z;
        this.u = operateListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(PicPinPop picPinPop, View view) {
        Tracker.onClick(view);
        Intrinsics.e(picPinPop, "this$0");
        picPinPop.u.b();
        picPinPop.p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(PicPinPop picPinPop, View view) {
        Tracker.onClick(view);
        Intrinsics.e(picPinPop, "this$0");
        picPinPop.u.a();
        picPinPop.p();
    }

    public void b() {
        super.b();
        TextView textView = (TextView) findViewById(R.id.tv_pin);
        TextView textView2 = (TextView) findViewById(R.id.tv_remove);
        textView.setText(getContext().getString(this.t ? 2131890827 : 2131890823));
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.pop.-$$Lambda$PicPinPop$9uJlJgllQytmEGg_kKLRIKZZ9lg
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PicPinPop.a(PicPinPop.this, view);
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.pop.-$$Lambda$PicPinPop$KsFOnuTPKyi471wU4hWrujsjqsw
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PicPinPop.b(PicPinPop.this, view);
            }
        });
    }

    public int getImplLayoutId() {
        return R.layout.pop_msg_recent_pic_top;
    }

    public final OperateListener getListener() {
        return this.u;
    }

    public final void setSelect(boolean z) {
        this.t = z;
    }
}
