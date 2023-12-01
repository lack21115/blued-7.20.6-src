package com.soft.blued.utils.password;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.common.user.model.UserInfo;
import com.soft.blued.R;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.password.PasswordCheckUtils;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/utils/password/PasswordStatusView.class */
public class PasswordStatusView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private View f21137a;
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private ImageView f21138c;
    private TextView d;

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/utils/password/PasswordStatusView$OnCheckResult.class */
    public interface OnCheckResult {
        void onResult(boolean z);
    }

    public PasswordStatusView(Context context) {
        super(context);
        this.b = context;
        a();
    }

    public PasswordStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = context;
        a();
    }

    public PasswordStatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = context;
        a();
    }

    private void a() {
        View inflate = LayoutInflater.from(this.b).inflate(R.layout.layout_pwd_check_result_view, this);
        this.f21137a = inflate;
        ImageView imageView = (ImageView) inflate.findViewById(R.id.img_pwd_status);
        this.f21138c = imageView;
        imageView.setVisibility(8);
        this.d = (TextView) this.f21137a.findViewById(R.id.tv_pwd_str);
    }

    public void a(final EditText editText, final EditText editText2, final String str, final PasswordCheckUtils.PWD_CHECK_PAGE pwd_check_page, IRequestHost iRequestHost, final OnCheckResult onCheckResult) {
        if (editText == null || editText2 == null) {
            return;
        }
        PasswordCheckUtils.a().a(new PasswordCheckUtils.CheckCallBackListener() { // from class: com.soft.blued.utils.password.PasswordStatusView.4
            @Override // com.soft.blued.utils.password.PasswordCheckUtils.CheckCallBackListener
            public void a() {
                PasswordStatusView.this.setVisibility(0);
                PasswordStatusView.this.f21138c.setImageResource(R.drawable.icon_pwd_checking);
                PasswordStatusView.this.d.setText(PasswordStatusView.this.b.getResources().getString(R.string.pwd_checking));
                Animation loadAnimation = AnimationUtils.loadAnimation(PasswordStatusView.this.b, R.anim.anim_rotate);
                if (loadAnimation != null) {
                    PasswordStatusView.this.f21138c.setAnimation(loadAnimation);
                    PasswordStatusView.this.f21138c.startAnimation(loadAnimation);
                }
            }

            @Override // com.soft.blued.utils.password.PasswordCheckUtils.CheckCallBackListener
            public void a(int i, String str2) {
                PasswordStatusView.this.d.setText(str2);
                PasswordStatusView.this.f21138c.clearAnimation();
                if (i == 0) {
                    PasswordStatusView.this.f21138c.setImageResource(R.drawable.icon_pwd_forbidden);
                } else {
                    PasswordStatusView.this.f21138c.setImageResource(R.drawable.icon_pwd_ok);
                }
                OnCheckResult onCheckResult2 = onCheckResult;
                if (onCheckResult2 != null) {
                    onCheckResult2.onResult(i == 0);
                }
            }
        }, iRequestHost);
        editText.addTextChangedListener(new TextWatcher() { // from class: com.soft.blued.utils.password.PasswordStatusView.5
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                PasswordCheckUtils.a().a(PasswordStatusView.this.b, editText2.getText().toString(), "");
                PasswordCheckUtils.a().a(editText.getText().toString(), str, pwd_check_page);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
    }

    public void a(final EditText editText, final EditText editText2, String str, String str2, final PasswordCheckUtils.PWD_CHECK_PAGE pwd_check_page, IRequestHost iRequestHost, final OnCheckResult onCheckResult) {
        if (editText == null || editText2 == null) {
            return;
        }
        PasswordCheckUtils.a().a(this.b, str, str2);
        PasswordCheckUtils.a().a(new PasswordCheckUtils.CheckCallBackListener() { // from class: com.soft.blued.utils.password.PasswordStatusView.1
            @Override // com.soft.blued.utils.password.PasswordCheckUtils.CheckCallBackListener
            public void a() {
                PasswordStatusView.this.setVisibility(0);
                PasswordStatusView.this.f21138c.setImageResource(R.drawable.icon_pwd_checking);
                PasswordStatusView.this.d.setText(PasswordStatusView.this.b.getResources().getString(R.string.pwd_checking));
                Animation loadAnimation = AnimationUtils.loadAnimation(PasswordStatusView.this.b, R.anim.anim_rotate);
                if (loadAnimation != null) {
                    PasswordStatusView.this.f21138c.setAnimation(loadAnimation);
                    PasswordStatusView.this.f21138c.startAnimation(loadAnimation);
                }
            }

            @Override // com.soft.blued.utils.password.PasswordCheckUtils.CheckCallBackListener
            public void a(int i, String str3) {
                PasswordStatusView.this.d.setText(str3);
                PasswordStatusView.this.f21138c.clearAnimation();
                if (i == 0) {
                    PasswordStatusView.this.f21138c.setImageResource(R.drawable.icon_pwd_forbidden);
                } else {
                    PasswordStatusView.this.f21138c.setImageResource(R.drawable.icon_pwd_ok);
                }
                OnCheckResult onCheckResult2 = onCheckResult;
                if (onCheckResult2 != null) {
                    onCheckResult2.onResult(i == 0);
                }
            }
        }, iRequestHost);
        editText.addTextChangedListener(new TextWatcher() { // from class: com.soft.blued.utils.password.PasswordStatusView.2
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (StringUtils.d(editText.getText().toString()) || StringUtils.d(editText2.getText().toString())) {
                    PasswordStatusView.this.d.setText(PasswordStatusView.this.b.getResources().getString(2131890457));
                    PasswordStatusView.this.f21138c.setVisibility(8);
                    OnCheckResult onCheckResult2 = onCheckResult;
                    if (onCheckResult2 != null) {
                        onCheckResult2.onResult(true);
                        return;
                    }
                    return;
                }
                PasswordStatusView.this.f21138c.setVisibility(0);
                if (editText.getText().toString().equals(editText2.getText().toString())) {
                    PasswordCheckUtils.a().a(editText.getText().toString(), UserInfo.getInstance().getAccessToken(), pwd_check_page);
                    return;
                }
                PasswordStatusView.this.setVisibility(0);
                PasswordStatusView.this.f21138c.clearAnimation();
                PasswordStatusView.this.f21138c.setImageResource(R.drawable.icon_pwd_forbidden);
                PasswordStatusView.this.d.setText(PasswordStatusView.this.b.getResources().getString(R.string.pwd_check_2_times_same_fail));
                OnCheckResult onCheckResult3 = onCheckResult;
                if (onCheckResult3 != null) {
                    onCheckResult3.onResult(true);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
        editText2.addTextChangedListener(new TextWatcher() { // from class: com.soft.blued.utils.password.PasswordStatusView.3
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (StringUtils.d(editText.getText().toString()) || StringUtils.d(editText2.getText().toString())) {
                    PasswordStatusView.this.d.setText(PasswordStatusView.this.b.getResources().getString(2131890457));
                    PasswordStatusView.this.f21138c.setVisibility(8);
                    OnCheckResult onCheckResult2 = onCheckResult;
                    if (onCheckResult2 != null) {
                        onCheckResult2.onResult(true);
                        return;
                    }
                    return;
                }
                PasswordStatusView.this.f21138c.setVisibility(0);
                if (editText.getText().toString().equals(editText2.getText().toString())) {
                    PasswordCheckUtils.a().a(editText.getText().toString(), UserInfo.getInstance().getAccessToken(), pwd_check_page);
                    return;
                }
                PasswordStatusView.this.setVisibility(0);
                PasswordStatusView.this.f21138c.clearAnimation();
                PasswordStatusView.this.f21138c.setImageResource(R.drawable.icon_pwd_forbidden);
                PasswordStatusView.this.d.setText(PasswordStatusView.this.b.getResources().getString(R.string.pwd_check_2_times_same_fail));
                OnCheckResult onCheckResult3 = onCheckResult;
                if (onCheckResult3 != null) {
                    onCheckResult3.onResult(true);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
    }
}
