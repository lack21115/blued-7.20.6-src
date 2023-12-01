package com.blued.android.module.yy_china.fragment;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import com.anythink.core.api.ErrorCode;
import com.blued.android.core.ui.BaseDialogFragment;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.module.common.utils.CommonStringUtils;
import com.blued.android.module.live.base.constants.LiveEventBusConstant;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.listener.ITextWatcher;
import com.bytedance.applog.tracker.Tracker;
import com.jeremyliao.liveeventbus.LiveEventBus;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYGiftCountInputDlg.class */
public class YYGiftCountInputDlg extends BaseDialogFragment {
    private EditText a;
    private TextView b;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        d();
    }

    private void d() {
        int a = CommonStringUtils.a(this.a.getText().toString());
        if (a <= 0) {
            return;
        }
        LiveEventBus.get(LiveEventBusConstant.a).post(Integer.valueOf(a));
        a(new Runnable() { // from class: com.blued.android.module.yy_china.fragment.YYGiftCountInputDlg.3
            @Override // java.lang.Runnable
            public void run() {
                KeyboardUtils.b(YYGiftCountInputDlg.this.getActivity(), YYGiftCountInputDlg.this.a);
                YYGiftCountInputDlg.this.dismissAllowingStateLoss();
            }
        }, 100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e() {
        this.a.setFocusableInTouchMode(true);
        this.a.setFocusable(true);
        this.a.requestFocus();
        ((InputMethodManager) getActivity().getSystemService("input_method")).showSoftInput(this.a, 0);
    }

    protected void a(View view) {
        view.findViewById(R.id.conver_view).setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.YYGiftCountInputDlg.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Tracker.onClick(view2);
                KeyboardUtils.b(YYGiftCountInputDlg.this.getActivity(), YYGiftCountInputDlg.this.a);
                YYGiftCountInputDlg.this.dismissAllowingStateLoss();
            }
        });
        this.a = (EditText) view.findViewById(R.id.live_gift_count_input_et);
        TextView textView = (TextView) view.findViewById(R.id.live_gift_count_input_btn);
        this.b = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYGiftCountInputDlg$q44vhYga22sX3r8cdycOi6NkqzY
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                YYGiftCountInputDlg.this.b(view2);
            }
        });
        a(new Runnable() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYGiftCountInputDlg$bvXSCwNAYmf1rMX6J6Q1Him985w
            @Override // java.lang.Runnable
            public final void run() {
                YYGiftCountInputDlg.this.e();
            }
        }, 200L);
        this.a.addTextChangedListener(new ITextWatcher() { // from class: com.blued.android.module.yy_china.fragment.YYGiftCountInputDlg.2
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (StringUtils.a(YYGiftCountInputDlg.this.a.getText().toString().trim(), 0) > 9999) {
                    YYGiftCountInputDlg.this.a.setText(ErrorCode.exception);
                    YYGiftCountInputDlg.this.a.setSelection(4);
                    YYGiftCountInputDlg.this.a.requestFocus();
                }
            }
        });
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, com.android.internal.R.style.Theme_Holo_Light_DialogWhenLarge_NoActionBar);
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.dialog_yy_gift_count_input, (ViewGroup) null);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        getDialog().getWindow().setSoftInputMode(16);
        a(inflate);
        return inflate;
    }
}
