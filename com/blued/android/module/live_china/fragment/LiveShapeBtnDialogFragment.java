package com.blued.android.module.live_china.fragment;

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

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveShapeBtnDialogFragment.class */
public class LiveShapeBtnDialogFragment extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    public TextView f13261a;
    public TextView b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f13262c;
    private Context d;

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveShapeBtnDialogFragment$ConfirmClickCallback.class */
    interface ConfirmClickCallback {
    }

    public LiveShapeBtnDialogFragment(Context context, String str, String str2, String str3) {
        super(context, R.style.transparentFrameWindowStyleLive);
        this.d = context;
        a();
        b();
        a(str, str2, str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        dismiss();
    }

    private void a(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            this.f13261a.setVisibility(8);
        } else {
            this.f13261a.setText(str);
            this.f13261a.setVisibility(0);
        }
        if (TextUtils.isEmpty(str2)) {
            this.b.setVisibility(8);
        } else {
            this.b.setText(str2);
            this.b.setVisibility(0);
        }
        if (TextUtils.isEmpty(str3)) {
            this.f13262c.setVisibility(8);
            return;
        }
        this.f13262c.setText(str3);
        this.f13262c.setVisibility(0);
    }

    private void b() {
        this.f13261a = (TextView) findViewById(R.id.tv_title);
        this.b = (TextView) findViewById(R.id.tv_content);
        this.f13262c = (TextView) findViewById(R.id.tv_confirm);
        this.f13261a.getPaint().setFakeBoldText(true);
        this.f13262c.getPaint().setFakeBoldText(true);
        findViewById(R.id.iv_close).setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveShapeBtnDialogFragment$lfgnUCoEJ_WJIBRVDXG2ZiXSYUk
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveShapeBtnDialogFragment.this.b(view);
            }
        });
        this.f13262c.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveShapeBtnDialogFragment$tUFWjIX_AXXAxo28y_tBZatY-Zc
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveShapeBtnDialogFragment.this.a(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        dismiss();
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
        View inflate = ((LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.dialog_live_shape_btn, (ViewGroup) null);
        addContentView(inflate, new ViewGroup.LayoutParams(-1, -1));
        setContentView(inflate);
        getWindow().setLayout(-1, -1);
    }
}
