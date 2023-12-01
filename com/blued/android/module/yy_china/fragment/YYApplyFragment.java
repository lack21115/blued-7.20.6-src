package com.blued.android.module.yy_china.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.utils.toast.ToastUtils;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.framework.utils.AesCrypto;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.base.shortvideo.ShortVideoProxy;
import com.blued.android.module.live.base.manager.LiveDataManager;
import com.blued.android.module.yy_china.IYYRoomInfoCallback;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.listener.ITextWatcher;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYLiveState;
import com.blued.android.module.yy_china.presenter.YYApplyPresenter;
import com.blued.android.module.yy_china.utils.EnglishCharFilter;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYApplyFragment.class */
public class YYApplyFragment extends MvpFragment<YYApplyPresenter> implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    TextView f17096a;
    EditText b;

    /* renamed from: c  reason: collision with root package name */
    EditText f17097c;
    ImageView d;
    TextView e;
    ShapeTextView f;
    ImageView g;
    TextView k;
    private boolean l = false;
    private boolean m = false;

    public static void a(Context context) {
        TerminalActivity.d(context, YYApplyFragment.class, new Bundle());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        String trim = this.b.getText().toString().trim();
        String trim2 = this.f17097c.getText().toString().trim();
        boolean booleanValue = ((Boolean) this.d.getTag()).booleanValue();
        if (TextUtils.isEmpty(trim) || TextUtils.isEmpty(trim2) || !booleanValue) {
            this.f.setEnabled(false);
            this.f.setAlpha(0.5f);
            return;
        }
        this.f.setEnabled(true);
        this.f.setAlpha(1.0f);
    }

    private void d() {
        String b = j().b(R.string.blued_apply_host_agree);
        String b2 = j().b(R.string.blued_apply_host_agreement);
        String str = b + " " + b2;
        SpannableString spannableString = new SpannableString(str);
        this.e.setMovementMethod(LinkMovementMethod.getInstance());
        spannableString.setSpan(new ClickableSpan() { // from class: com.blued.android.module.yy_china.fragment.YYApplyFragment.3
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                IYYRoomInfoCallback c2 = YYRoomInfoManager.e().c();
                c2.a(YYApplyFragment.this.getActivity(), c2.h(), 7);
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(YYApplyFragment.this.j().a(R.color.syc_dark_a));
                textPaint.setUnderlineText(false);
            }
        }, str.indexOf(b2), (b + " " + b2).length(), 33);
        this.e.setText(spannableString);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public void a(Bundle bundle) {
        super.a(bundle);
        this.f17096a = (TextView) this.i.findViewById(R.id.tv_bind_phone);
        this.k = (TextView) this.i.findViewById(R.id.tv_title_text);
        this.g = (ImageView) this.i.findViewById(R.id.iv_back_img);
        this.d = (ImageView) this.i.findViewById(R.id.iv_terms);
        this.f = (ShapeTextView) this.i.findViewById(R.id.go_auth);
        this.b = (EditText) this.i.findViewById(R.id.tv_name);
        this.f17097c = (EditText) this.i.findViewById(R.id.tv_cardnum);
        this.e = (TextView) this.i.findViewById(R.id.live_agree);
        this.k.setText(getResources().getString(R.string.yy_apply_title));
        this.g.setOnClickListener(this);
        this.d.setOnClickListener(this);
        this.f.setOnClickListener(this);
        this.f17096a.setOnClickListener(this);
        this.d.setTag(true);
        this.d.setImageResource(R.drawable.icon_terms_read);
        this.b.setFilters(new InputFilter[]{new EnglishCharFilter(40)});
        this.b.addTextChangedListener(new ITextWatcher() { // from class: com.blued.android.module.yy_china.fragment.YYApplyFragment.1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                YYApplyFragment.this.c();
            }
        });
        this.f17097c.addTextChangedListener(new ITextWatcher() { // from class: com.blued.android.module.yy_china.fragment.YYApplyFragment.2
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                YYApplyFragment.this.c();
            }
        });
        d();
        j().e();
    }

    public void a(YYLiveState yYLiveState) {
        try {
            this.l = yYLiveState.chatroom_need_video == 0;
            this.b.setText(AesCrypto.e(yYLiveState.name));
            this.f17097c.setText(AesCrypto.e(yYLiveState.number));
        } catch (Exception e) {
        }
    }

    public void b() {
        if (this.l) {
            YYApplyFinishFragment.a(getContext(), 0);
            getActivity().finish();
            return;
        }
        LiveDataManager.a().a(1);
        ShortVideoProxy.e().a(this, 1, 100);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public int g() {
        return R.layout.fragment_yy_apply_layout;
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        Log.i("YYApplyFragment", "requestCode:" + i + "  :" + i2);
        if (i2 == 0 || i != 100 || intent == null) {
            return;
        }
        boolean booleanExtra = intent.getBooleanExtra("auth_upload_state", false);
        Log.i("YYApplyFragment", "success:" + booleanExtra);
        if (booleanExtra) {
            YYApplyFinishFragment.a(getContext(), 0);
            getActivity().finish();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        if (view.getId() == R.id.iv_terms) {
            boolean z = !((Boolean) this.d.getTag()).booleanValue();
            this.d.setImageResource(z ? R.drawable.icon_terms_read : R.drawable.icon_terms_unread);
            this.d.setTag(Boolean.valueOf(z));
            c();
        } else if (view.getId() != R.id.go_auth) {
            if (view.getId() != R.id.tv_bind_phone) {
                if (view.getId() == R.id.iv_back_img) {
                    t();
                }
            } else if (this.m) {
            } else {
                EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_PHONE_BIND_CLICK);
                YYRoomInfoManager.e().c().a(getContext());
            }
        } else if (!((Boolean) this.d.getTag()).booleanValue()) {
            ToastUtils.a("请先阅读相关条款及协议", 0);
        } else {
            String trim = this.b.getText().toString().trim();
            if (TextUtils.isEmpty(trim)) {
                ToastUtils.a("真实姓名不符合标准", 0);
                return;
            }
            String trim2 = this.f17097c.getText().toString().trim();
            if (TextUtils.isEmpty(trim2) || trim2.length() < 18) {
                ToastUtils.a("证件号码不符合标准", 0);
                return;
            }
            EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_ENTER_APPROVE_CLICK);
            j().a(YYRoomInfoManager.e().c().c(), trim, trim2);
        }
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (TextUtils.isEmpty(YYRoomInfoManager.e().c().j())) {
            this.m = false;
            this.f17096a.setText(getResources().getString(R.string.yy_bind_now));
            return;
        }
        this.m = true;
        this.f17096a.setText(getResources().getString(R.string.yy_binded));
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public boolean r() {
        return true;
    }
}
