package com.soft.blued.ui.live.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.framework.utils.AesCrypto;
import com.blued.android.module.base.shortvideo.ShortVideoProxy;
import com.blued.android.module.common.user.UserInfoHelper;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.live.base.manager.LiveDataManager;
import com.blued.android.module.live_china.model.BluedLiveState;
import com.blued.das.live.LiveProtos;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.log.track.EventTrackLive;
import com.soft.blued.ui.live.presenter.LiveApplySimplePresenter;
import com.soft.blued.ui.login_register.LinkMobileFragment;
import com.soft.blued.ui.login_register.LoginRegisterTools;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.utils.StringUtils;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/live/fragment/LiveApplySimpleFragment.class */
public class LiveApplySimpleFragment extends MvpFragment<LiveApplySimplePresenter> implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private Context f17445a;
    private boolean b;

    /* renamed from: c  reason: collision with root package name */
    private Dialog f17446c;
    private BluedLiveState d;
    @BindView
    View fl_error_page;
    @BindView
    ImageView header_view;
    @BindView
    ImageView img_verify;
    @BindView
    ImageView iv_phone_binded;
    @BindView
    TextView live_agree;
    @BindView
    ImageView live_clause;
    @BindView
    View ll_main;
    @BindView
    CommonTopTitleNoTrans top_title;
    @BindView
    TextView tv_binding_cellphone;
    @BindView
    TextView tv_binding_cellphone_status;
    @BindView
    EditText tv_id;
    @BindView
    TextView tv_identify;
    @BindView
    EditText tv_name;
    @BindView
    TextView tv_other;
    @BindView
    View tv_reload;
    @BindView
    TextView tv_tip_one;
    @BindView
    TextView tv_tip_two;
    private boolean e = true;
    private TextWatcher f = new TextWatcher() { // from class: com.soft.blued.ui.live.fragment.LiveApplySimpleFragment.2
        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            LiveApplySimpleFragment.this.tv_name.removeTextChangedListener(LiveApplySimpleFragment.this.f);
            LiveApplySimpleFragment.this.e();
            LiveApplySimpleFragment.this.tv_name.addTextChangedListener(LiveApplySimpleFragment.this.f);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    };
    private TextWatcher g = new TextWatcher() { // from class: com.soft.blued.ui.live.fragment.LiveApplySimpleFragment.3
        private int b;

        /* renamed from: c  reason: collision with root package name */
        private int f17450c;

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            this.b = LiveApplySimpleFragment.this.tv_id.getSelectionStart();
            this.f17450c = LiveApplySimpleFragment.this.tv_id.getSelectionEnd();
            LiveApplySimpleFragment.this.tv_id.removeTextChangedListener(LiveApplySimpleFragment.this.g);
            while (editable.length() > 18) {
                editable.delete(this.b - 1, this.f17450c);
                this.b--;
                this.f17450c--;
            }
            LiveApplySimpleFragment.this.tv_id.setSelection(this.b);
            LiveApplySimpleFragment.this.e();
            LiveApplySimpleFragment.this.tv_id.addTextChangedListener(LiveApplySimpleFragment.this.g);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    };

    public static void a(Context context, BluedLiveState bluedLiveState) {
        Bundle bundle = new Bundle();
        if (bluedLiveState != null) {
            bundle.putSerializable("applyState", bluedLiveState);
        }
        TerminalActivity.d(context, LiveApplySimpleFragment.class, bundle);
    }

    private void b(boolean z) {
        int i = 8;
        if (this.d == null) {
            this.ll_main.setVisibility(8);
            View view = this.fl_error_page;
            if (!z) {
                i = 0;
            }
            view.setVisibility(i);
            this.tv_reload.setOnClickListener(this);
            if (z) {
                ((LiveApplySimplePresenter) j()).m();
                return;
            }
            return;
        }
        this.ll_main.setVisibility(0);
        this.fl_error_page.setVisibility(8);
        this.tv_name.setFilters(new InputFilter[]{StringUtils.a()});
        this.tv_name.addTextChangedListener(this.f);
        this.tv_id.addTextChangedListener(this.g);
        ImageLoader.a(getFragmentActive(), UserInfo.getInstance().getLoginUserInfo().getAvatar()).b(2131237310).c().a(this.header_view);
        UserInfoHelper.a(this.img_verify, UserInfo.getInstance().getLoginUserInfo().getVBadge(), 3);
        if (this.img_verify.getVisibility() == 8 || this.img_verify.getVisibility() == 4) {
            this.img_verify.setImageResource(2131237327);
            this.img_verify.setVisibility(0);
        }
        this.tv_other.setOnClickListener(this);
        this.live_clause.setOnClickListener(this);
        this.tv_binding_cellphone.setOnClickListener(this);
        try {
            if (this.d != null) {
                this.tv_name.setText(AesCrypto.e(this.d.name));
                this.tv_id.setText(AesCrypto.e(this.d.number));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        d();
        e();
        b();
    }

    private void c() {
        this.f17446c = DialogUtils.a(this.f17445a);
        this.top_title.f();
        this.top_title.a();
        this.top_title.setLeftImgDrawable(BluedSkinUtils.b(this.f17445a, 2131233902));
        this.top_title.setCenterText(getString(R.string.Live_applyHost_title));
        this.top_title.setLeftClickListener(this);
        b(true);
        EventTrackLive.a(LiveProtos.Event.LIVE_APPLY_ANCHOR_PAGE_SHOW);
    }

    private void d() {
        String string = this.f17445a.getString(R.string.Live_applyHost_agree);
        String string2 = this.f17445a.getString(R.string.Live_applyHost_bluedAgreement);
        String str = string + " " + string2;
        SpannableString spannableString = new SpannableString(str);
        this.live_agree.setMovementMethod(LinkMovementMethod.getInstance());
        spannableString.setSpan(new ClickableSpan() { // from class: com.soft.blued.ui.live.fragment.LiveApplySimpleFragment.1
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                WebViewShowInfoFragment.show(LiveApplySimpleFragment.this.getActivity(), "https://www.blued.cn/live/agreement", 7);
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(BluedSkinUtils.a(LiveApplySimpleFragment.this.f17445a, 2131101766));
                textPaint.setUnderlineText(false);
            }
        }, str.indexOf(string2), (string + " " + string2).length(), 33);
        this.live_agree.setText(spannableString);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (TextUtils.isEmpty(LoginRegisterTools.b()) || TextUtils.isEmpty(this.tv_id.getText()) || TextUtils.isEmpty(this.tv_name.getText()) || !this.e) {
            this.tv_identify.setOnClickListener(null);
            this.tv_identify.setBackgroundColor(getResources().getColor(2131102355));
            return;
        }
        this.tv_identify.setOnClickListener(this);
        this.tv_identify.setBackgroundColor(BluedSkinUtils.a(this.f17445a, 2131101766));
    }

    public void a(Bundle bundle) {
        super.a(bundle);
        c();
    }

    public void a(String str, List list) {
        boolean z;
        super.a(str, list);
        int hashCode = str.hashCode();
        if (hashCode != -1696975301) {
            if (hashCode == 492423017 && str.equals("LIVE_SIMPLE__APPLY")) {
                z = false;
            }
            z = true;
        } else {
            if (str.equals("LIVE_APPLY")) {
                z = true;
            }
            z = true;
        }
        if (z) {
            if (z && list != null && list.size() > 0) {
                this.d = (BluedLiveState) list.get(0);
                return;
            }
            return;
        }
        BluedLiveState bluedLiveState = this.d;
        if (bluedLiveState == null || bluedLiveState.vbadge != 4) {
            LiveDataManager.a().a(0);
            ShortVideoProxy.e().a(this, 1, 1);
            return;
        }
        this.d.is_easy_way = 1;
        LiveApplyVerifyFragment.a(this.f17445a, this.d);
        getActivity().finish();
    }

    public void a(String str, boolean z) {
        super.a(str, z);
        DialogUtils.b(this.f17446c);
        if (str == "LIVE_APPLY") {
            b(false);
        }
    }

    public void b() {
        try {
            if (this.d == null || this.d.vbadge != 4) {
                this.tv_identify.setText(getString(R.string.Live_applyHost_simple_into_identify));
                this.tv_tip_one.setText(getString(R.string.Live_applyHost_simple_tip_1));
                this.tv_tip_two.setText(getString(R.string.Live_applyHost_simple_tip_2));
            } else {
                this.tv_identify.setText(getString(R.string.Live_applyHost_confirm));
                this.tv_tip_one.setText(getString(R.string.Live_applyHost_simple_tip_3));
                this.tv_tip_two.setText(getString(R.string.Live_applyHost_simple_tip_4));
            }
            if (TextUtils.isEmpty(LoginRegisterTools.b())) {
                this.b = false;
                this.tv_binding_cellphone_status.setVisibility(8);
                this.tv_binding_cellphone.setVisibility(0);
                this.iv_phone_binded.setVisibility(8);
                return;
            }
            this.b = true;
            this.tv_binding_cellphone_status.setVisibility(0);
            this.tv_binding_cellphone_status.setText(getResources().getString(R.string.Live_applyHost_beBindinged));
            this.tv_binding_cellphone.setVisibility(8);
            this.iv_phone_binded.setVisibility(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int g() {
        return R.layout.fragment_live_apply_simple;
    }

    public void g_(String str) {
        super.g_(str);
        DialogUtils.a(this.f17446c);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        Log.i("LiveApplySimpleFragment", "requestCode:" + i + "  :" + i2);
        if (i2 == 0 || i != 1 || intent == null) {
            return;
        }
        boolean booleanExtra = intent.getBooleanExtra("auth_upload_state", false);
        Log.i("LiveApplySimpleFragment", "success:" + booleanExtra);
        if (booleanExtra) {
            BluedLiveState bluedLiveState = this.d;
            if (bluedLiveState != null) {
                bluedLiveState.is_easy_way = 1;
            }
            LiveApplyVerifyFragment.a(this.f17445a, this.d);
            getActivity().finish();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        switch (view.getId()) {
            case 2131363120:
                getActivity().finish();
                return;
            case R.id.live_clause /* 2131366997 */:
                if (this.e) {
                    this.e = false;
                    this.live_clause.setImageResource(R.drawable.live_clause_default);
                } else {
                    this.e = true;
                    this.live_clause.setImageResource(R.drawable.live_clause_selected);
                }
                e();
                return;
            case R.id.tv_binding_cellphone /* 2131370981 */:
                String b = LoginRegisterTools.b();
                if (TextUtils.isEmpty(b)) {
                    TerminalActivity.d(getActivity(), LinkMobileFragment.class, (Bundle) null);
                    return;
                }
                String[] g = LoginRegisterTools.g(b);
                LoginRegisterTools.a(getActivity(), g[0], g[1]);
                return;
            case 2131371709:
                ((LiveApplySimplePresenter) j()).a(this.tv_name.getText().toString(), this.tv_id.getText().toString());
                return;
            case 2131372200:
                TerminalActivity.d(this.f17445a, LiveApplyFragment.class, (Bundle) null);
                return;
            case 2131372414:
                ((LiveApplySimplePresenter) j()).m();
                return;
            default:
                return;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f17445a = getContext();
        if (getArguments() == null || getArguments().getSerializable("applyState") == null) {
            return;
        }
        this.d = getArguments().getSerializable("applyState");
    }

    public void onDestroy() {
        super.onDestroy();
        DialogUtils.b(this.f17446c);
    }

    public void onResume() {
        super.onResume();
        b();
    }
}
