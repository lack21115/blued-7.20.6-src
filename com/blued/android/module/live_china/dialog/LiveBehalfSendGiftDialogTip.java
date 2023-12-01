package com.blued.android.module.live_china.dialog;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.blued.android.module.live_china.R;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/dialog/LiveBehalfSendGiftDialogTip.class */
public class LiveBehalfSendGiftDialogTip extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    public IEventCallback f12516a;
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private String f12517c;
    private String d;

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/dialog/LiveBehalfSendGiftDialogTip$IEventCallback.class */
    public interface IEventCallback {
        void a();
    }

    public LiveBehalfSendGiftDialogTip(Context context, String str, String str2, IEventCallback iEventCallback) {
        super(context, R.style.transparentFrameWindowStyleLive);
        this.b = context;
        this.f12517c = str;
        this.d = str2;
        this.f12516a = iEventCallback;
        a();
        c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        b();
    }

    private void c() {
        findViewById(R.id.iv_close).setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.dialog.LiveBehalfSendGiftDialogTip.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                LiveBehalfSendGiftDialogTip.this.dismiss();
            }
        });
        findViewById(R.id.tv_btn).setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.dialog.-$$Lambda$LiveBehalfSendGiftDialogTip$D9wAIWJ6-uGQ38r0vScJQpxPW1g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveBehalfSendGiftDialogTip.this.a(view);
            }
        });
        if (TextUtils.isEmpty(this.d)) {
            this.d = "小蓝用户";
        }
        TextView textView = (TextView) findViewById(R.id.tv_content);
        textView.setText("确认在本场直播送礼时使用" + this.d + "的身份与主播沟通吗？");
    }

    public void a() {
        Window window = getWindow();
        window.requestFeature(1);
        window.getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -1;
        attributes.verticalMargin = 0.0f;
        attributes.horizontalMargin = 0.0f;
        window.setAttributes(attributes);
        window.getDecorView().setMinimumWidth(getContext().getResources().getDisplayMetrics().widthPixels);
        window.getDecorView().setMinimumHeight(getContext().getResources().getDisplayMetrics().heightPixels);
        window.getDecorView().setBackgroundColor(0);
        window.setDimAmount(0.0f);
        window.setWindowAnimations(R.style.alpha_menu_animstyle);
        View inflate = ((LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.dialog_live_behalf_gift_tip, (ViewGroup) null);
        addContentView(inflate, new ViewGroup.LayoutParams(-1, -1));
        setContentView(inflate);
        getWindow().setLayout(-1, -1);
    }

    public void b() {
        IEventCallback iEventCallback = this.f12516a;
        if (iEventCallback != null) {
            iEventCallback.a();
        }
        dismiss();
    }
}
