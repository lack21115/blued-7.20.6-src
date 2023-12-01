package com.soft.blued.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.fragment.app.Fragment;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.community.view.EditInputNumView;
import com.blued.das.profile.PersonalProfileProtos;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.log.track.EventTrackPersonalProfile;
import com.soft.blued.utils.AtChooseUserHelper;
import com.soft.blued.utils.StringUtils;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/fragment/CommonWriteTextFragment.class */
public class CommonWriteTextFragment extends BaseFragment implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public Context f15952a;
    public int b = 256;

    /* renamed from: c  reason: collision with root package name */
    protected View f15953c;
    public EditText d;
    protected EditInputNumView e;
    protected String f;
    protected String g;
    protected String h;
    protected int i;
    public CommonTopTitleNoTrans j;
    private String k;
    private String l;
    private AtChooseUserHelper m;
    private TextWatcher n;
    private TextWatcher o;
    private boolean p;

    public static void a(Fragment fragment, String str, String str2, String str3, String str4, int i) {
        Bundle bundle = new Bundle();
        bundle.putString(DownloadSettingKeys.RetryScheduleConfig.MAX_COUNT, str);
        bundle.putString("string_edit", str2);
        bundle.putString("string_edit_hint", str3);
        bundle.putString("string_center", str4);
        bundle.putInt("REQUEST_CODE_KEY", i);
        TerminalActivity.a(fragment, CommonWriteTextFragment.class, bundle, i);
    }

    private void b() {
        postDelaySafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.fragment.CommonWriteTextFragment.1
            @Override // java.lang.Runnable
            public void run() {
                if (!CommonWriteTextFragment.this.d.isFocusable()) {
                    CommonWriteTextFragment.this.d.setFocusable(true);
                    CommonWriteTextFragment.this.d.setFocusableInTouchMode(true);
                }
                CommonWriteTextFragment.this.d.requestFocus();
                CommonWriteTextFragment.this.d.setSelection(CommonWriteTextFragment.this.d.length());
                KeyboardUtils.c(CommonWriteTextFragment.this.getActivity());
            }
        }, 300L);
    }

    private void c() {
        this.n = new TextWatcher() { // from class: com.soft.blued.fragment.CommonWriteTextFragment.2
            private int b;

            /* renamed from: c  reason: collision with root package name */
            private int f15956c;
            private String d;
            private String e;

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                try {
                    this.b = CommonWriteTextFragment.this.d.getSelectionStart();
                    this.f15956c = CommonWriteTextFragment.this.d.getSelectionEnd();
                    if (!CommonWriteTextFragment.this.d()) {
                        CommonWriteTextFragment.this.d.setSelection(this.b);
                    } else if (!CommonWriteTextFragment.this.m.a(CommonWriteTextFragment.this, this.d, this.e, editable, this.f15956c)) {
                        CommonWriteTextFragment.this.d.setSelection(this.b);
                    }
                    if (CommonWriteTextFragment.this.o != null) {
                        CommonWriteTextFragment.this.o.afterTextChanged(editable);
                    }
                    if (CommonWriteTextFragment.this.e.isOutOfBounds()) {
                        CommonWriteTextFragment.this.j.getRightTextView().setTextColor(BluedSkinUtils.a(CommonWriteTextFragment.this.f15952a, 2131102260));
                        CommonWriteTextFragment.this.j.setRightClickListener((View.OnClickListener) null);
                        return;
                    }
                    CommonWriteTextFragment.this.j.getRightTextView().setTextColor(BluedSkinUtils.a(CommonWriteTextFragment.this.f15952a, 2131102254));
                    CommonWriteTextFragment.this.j.setRightClickListener(CommonWriteTextFragment.this);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                this.d = ((Object) charSequence) + "";
                if (CommonWriteTextFragment.this.o != null) {
                    CommonWriteTextFragment.this.o.beforeTextChanged(charSequence, i, i2, i3);
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                this.e = ((Object) charSequence) + "";
                if (CommonWriteTextFragment.this.o != null) {
                    CommonWriteTextFragment.this.o.onTextChanged(charSequence, i, i2, i3);
                }
            }
        };
        AppInfo.n().postDelayed(new Runnable() { // from class: com.soft.blued.fragment.CommonWriteTextFragment.3
            @Override // java.lang.Runnable
            public void run() {
                CommonWriteTextFragment.this.d.requestFocus();
                KeyboardUtils.a(CommonWriteTextFragment.this.d);
            }
        }, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d() {
        return this.i == 3;
    }

    public void a() {
        this.j.setCenterText(getString(R.string.about_blued));
        this.j.setLeftClickListener(this);
        this.j.setRightClickListener(this);
        if (StringUtils.d(this.f)) {
            this.j.setCenterText(getResources().getString(R.string.common_write_title));
        } else {
            this.j.setCenterText(this.f);
        }
        if (StringUtils.d(this.g)) {
            this.j.setRightText(getResources().getString(R.string.submit));
        } else {
            this.j.setRightText(this.g);
        }
    }

    public void a(int i) {
        String obj = this.d.getText().toString();
        String str = obj;
        if (d()) {
            str = this.m.b(obj);
        }
        if (a(i, str)) {
            Intent intent = new Intent();
            intent.putExtra("string_edit", str);
            intent.putExtra("feed_id", this.h);
            getActivity().setResult(i, intent);
            getActivity().finish();
        }
    }

    public void a(TextWatcher textWatcher) {
        this.o = textWatcher;
    }

    protected boolean a(int i, String str) {
        return true;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1 && i == 9090) {
            this.m.a(this.d, intent, this.n);
        }
        super.onActivityResult(i, i2, intent);
    }

    public boolean onBackPressed() {
        a(0);
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        int id = view.getId();
        if (id == 2131363120) {
            a(0);
        } else if (id != 2131363126) {
        } else {
            if (!this.e.isOutOfBounds()) {
                EventTrackPersonalProfile.a(PersonalProfileProtos.Event.EDIT_SIGNATURE_CONFIRM_CLICK);
                a(-1);
                return;
            }
            String string = this.f15952a.getResources().getString(R.string.max_input_limit);
            AppMethods.a(String.format(string, this.b + ""));
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f15952a = getActivity();
        getActivity().getWindow().setSoftInputMode(18);
        this.m = new AtChooseUserHelper(getActivity());
        View view = this.f15953c;
        if (view == null) {
            this.f15953c = layoutInflater.inflate(R.layout.fragment_common_write, viewGroup, false);
            if (getArguments() != null) {
                this.b = Integer.parseInt(getArguments().getString(DownloadSettingKeys.RetryScheduleConfig.MAX_COUNT));
                this.k = getArguments().getString("string_edit");
                this.l = getArguments().getString("string_edit_hint");
                this.f = getArguments().getString("string_center");
                this.g = getArguments().getString("string_right");
                this.h = getArguments().getString("feed_id");
                this.i = getArguments().getInt("REQUEST_CODE_KEY");
                this.p = getArguments().getBoolean("im_note");
            }
            this.j = this.f15953c.findViewById(R.id.top_title);
            a();
            c();
            this.d = (EditText) this.f15953c.findViewById(R.id.write_et);
            this.e = (EditInputNumView) this.f15953c.findViewById(R.id.inv_word_count);
            this.d.addTextChangedListener(this.n);
            this.e.init(this.d, this.b, this.p);
            if (!StringUtils.d(this.l)) {
                this.d.setHint(this.l);
            }
            if (!StringUtils.d(this.k)) {
                this.d.setText(this.k);
            }
            b();
        } else {
            ((ViewGroup) view.getParent()).removeView(this.f15953c);
        }
        return this.f15953c;
    }
}
