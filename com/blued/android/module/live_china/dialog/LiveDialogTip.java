package com.blued.android.module.live_china.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.blued.android.module.live_china.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/dialog/LiveDialogTip.class */
public class LiveDialogTip extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    public IEventCallback f12519a;
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private String f12520c;
    private String d;

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/dialog/LiveDialogTip$IEventCallback.class */
    public interface IEventCallback {
        void a();
    }

    public LiveDialogTip(Context context, String str, String str2, IEventCallback iEventCallback) {
        super(context, R.style.transparentFrameWindowStyleLive);
        this.b = context;
        this.f12520c = str;
        this.d = str2;
        this.f12519a = iEventCallback;
        a();
        c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        b();
    }

    private void c() {
        findViewById(R.id.iv_close).setVisibility(8);
        findViewById(R.id.tv_btn).setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.dialog.-$$Lambda$LiveDialogTip$3i6K_73AvA5Hit-ittBwx65VKEc
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveDialogTip.this.a(view);
            }
        });
        ((TextView) findViewById(R.id.tv_title)).setText(this.f12520c);
        ((TextView) findViewById(R.id.tv_content)).setText(this.d);
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
        View inflate = ((LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.dialog_live_tip, (ViewGroup) null);
        addContentView(inflate, new ViewGroup.LayoutParams(-1, -1));
        setContentView(inflate);
        getWindow().setLayout(-1, -1);
    }

    public void b() {
        IEventCallback iEventCallback = this.f12519a;
        if (iEventCallback != null) {
            iEventCallback.a();
        }
        dismiss();
    }
}
