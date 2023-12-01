package com.blued.android.module.live_china.mine;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import com.anythink.core.api.ErrorCode;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.module.common.fragment.LiveBaseDialogFragment;
import com.blued.android.module.common.utils.CommonStringUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.fragment.PlayingOnliveFragment;
import com.blued.android.module.live_china.msg.LiveEventBusUtil;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/mine/LiveGiftCountInputDlg.class */
public class LiveGiftCountInputDlg extends LiveBaseDialogFragment {
    private EditText j;
    private TextView k;
    private TextView l;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        j();
    }

    private void k() {
        int a = CommonStringUtils.a(this.k.getText().toString());
        if (a <= 0) {
            return;
        }
        LiveEventBusUtil.c(a);
        a(new Runnable() { // from class: com.blued.android.module.live_china.mine.LiveGiftCountInputDlg.2
            @Override // java.lang.Runnable
            public void run() {
                KeyboardUtils.b(LiveGiftCountInputDlg.this.getActivity(), LiveGiftCountInputDlg.this.j);
                LiveGiftCountInputDlg.this.j();
            }
        }, 100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l() {
        this.j.setFocusableInTouchMode(true);
        this.j.setFocusable(true);
        this.j.requestFocus();
        ((InputMethodManager) getActivity().getSystemService("input_method")).showSoftInput(this.j, 0);
    }

    @Override // com.blued.android.module.common.fragment.LiveBaseDialogFragment
    public int d() {
        return R.layout.fragment_live_gift_count_input;
    }

    @Override // com.blued.android.module.common.fragment.LiveBaseDialogFragment
    public void e() {
        PlayingOnliveFragment.cv = false;
        this.b.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.mine.-$$Lambda$LiveGiftCountInputDlg$iKQ8OEvXjx315Z7VrD9SsAOHf68
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveGiftCountInputDlg.this.b(view);
            }
        });
        this.j = (EditText) this.b.findViewById(R.id.live_gift_count_input_et);
        this.k = (TextView) this.b.findViewById(R.id.live_gift_count_input_tv);
        TextView textView = (TextView) this.b.findViewById(R.id.live_gift_count_input_btn);
        this.l = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.mine.-$$Lambda$LiveGiftCountInputDlg$R7z9Fd8bIfz5mr8P_BsLmi-G7pg
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveGiftCountInputDlg.this.a(view);
            }
        });
        a(new Runnable() { // from class: com.blued.android.module.live_china.mine.-$$Lambda$LiveGiftCountInputDlg$hbcS4h4ZFru4jmxBxtTl7As07Uw
            @Override // java.lang.Runnable
            public final void run() {
                LiveGiftCountInputDlg.this.l();
            }
        }, 200L);
        this.j.addTextChangedListener(new TextWatcher() { // from class: com.blued.android.module.live_china.mine.LiveGiftCountInputDlg.1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = LiveGiftCountInputDlg.this.j.getText().toString();
                String str = obj;
                if (obj.length() == 5) {
                    str = ErrorCode.exception;
                    LiveGiftCountInputDlg.this.j.setText(ErrorCode.exception);
                    LiveGiftCountInputDlg.this.j.setSelection(4);
                    LiveGiftCountInputDlg.this.j.requestFocus();
                }
                LiveGiftCountInputDlg.this.k.setText(str);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.blued.android.module.common.fragment.LiveBaseDialogFragment, com.blued.android.core.ui.BaseDialogFragment
    public void onDestroy() {
        super.onDestroy();
        PlayingOnliveFragment.cv = true;
    }
}
