package com.blued.android.module.live_china.fragment;

import android.app.Dialog;
import android.content.Context;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.blued.android.module.live_china.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LivePlaySettingDialogFragment.class */
public class LivePlaySettingDialogFragment extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    private Context f13146a;
    private int b;

    public LivePlaySettingDialogFragment(Context context, int i) {
        super(context, R.style.transparentFrameWindowStyleLive);
        this.f13146a = context;
        this.b = i;
        a();
        b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        dismiss();
    }

    private void b() {
        findViewById(R.id.rl_content).setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LivePlaySettingDialogFragment$BOXmtPsZaj9sxu2g87dR9OhS6b0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LivePlaySettingDialogFragment.this.c(view);
            }
        });
        findViewById(R.id.iv_close).setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LivePlaySettingDialogFragment$8Cdq8CwGdDbZ_sMo-3HEvUPdvWY
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LivePlaySettingDialogFragment.this.b(view);
            }
        });
        findViewById(R.id.tv_btn).setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LivePlaySettingDialogFragment$oR8pMiZ9FPJRXV7HZfQS_Pfx_ns
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LivePlaySettingDialogFragment.this.a(view);
            }
        });
        ((TextView) findViewById(R.id.tv_title)).setText(this.b == 1 ? R.string.live_setting_dialog_background_title : R.string.live_setting_dialog_float_title);
        String string = this.f13146a.getString(this.b == 1 ? R.string.live_setting_dialog_background_content : R.string.live_setting_dialog_float_content);
        SpannableString spannableString = new SpannableString(string);
        int length = string.length() - 15;
        int length2 = string.length() - 5;
        spannableString.setSpan(new ForegroundColorSpan(ContextCompat.getColor(getContext(), R.color.syc_dark_2A2A2E)), length, length2, 33);
        spannableString.setSpan(new StyleSpan(1), length, length2, 33);
        ((TextView) findViewById(R.id.tv_content)).setText(spannableString);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
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
        View inflate = ((LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.dialog_live_play_setting, (ViewGroup) null);
        addContentView(inflate, new ViewGroup.LayoutParams(-1, -1));
        setContentView(inflate);
        getWindow().setLayout(-1, -1);
    }
}
