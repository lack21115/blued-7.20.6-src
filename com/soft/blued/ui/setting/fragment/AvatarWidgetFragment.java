package com.soft.blued.ui.setting.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.utils.ImageUtils;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.AvatarUtils;
import com.blued.android.module.common.utils.DialogUtils;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.StringUtils;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/fragment/AvatarWidgetFragment.class */
public class AvatarWidgetFragment extends BaseFragment implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private View f33322a;
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private View f33323c;
    private View d;
    private View e;
    private View f;
    private ImageView g;
    private Dialog h;
    private String i;
    private String j;
    private String k;
    private TextView l;
    private int m;
    private ImageView n;

    private Bitmap a(View view) {
        Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        view.draw(new Canvas(createBitmap));
        return createBitmap;
    }

    private void a() {
        getActivity().setResult(-1, new Intent());
        getActivity().finish();
    }

    private void b() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.i = arguments.getString("user_avatar");
            this.j = arguments.getString("UID");
            this.k = arguments.getString("avatar_widget");
            this.m = arguments.getInt("KEY_VIP_GRADE");
        }
    }

    private void c() {
        this.h = DialogUtils.a(this.b);
        this.f33323c = this.f33322a.findViewById(R.id.btn_avatar_delete);
        this.d = this.f33322a.findViewById(R.id.btn_avatar_save);
        this.e = this.f33322a.findViewById(R.id.btn_avatar_modify);
        this.f = this.f33322a.findViewById(R.id.btn_avatar_cancel);
        this.g = (ImageView) this.f33322a.findViewById(2131365082);
        this.l = (TextView) this.f33322a.findViewById(R.id.tv_avatar_modify);
        this.n = (ImageView) this.f33322a.findViewById(R.id.avatar_red_point);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.g.getLayoutParams();
        layoutParams.height = AppInfo.l;
        this.g.setLayoutParams(layoutParams);
        this.f33323c.setOnClickListener(this);
        this.d.setOnClickListener(this);
        this.e.setOnClickListener(this);
        this.f.setOnClickListener(this);
        if (TextUtils.equals(UserInfo.getInstance().getLoginUserInfo().uid, this.j)) {
            this.l.setText(2131887375);
            if (!BluedPreferences.cR()) {
                this.n.setVisibility(0);
            }
        } else if (TextUtils.isEmpty(this.k)) {
            this.l.setVisibility(8);
        } else {
            this.l.setText(2131892575);
        }
        ImageLoader.a(getFragmentActive(), AvatarUtils.a(3, this.i)).b(2131237314).d(2131237314).a(this.g);
    }

    private void d() {
        ImageUtils.a(a(this.g));
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1 && i == 178 && intent != null) {
            StringUtils.d(intent.getStringExtra("photo_path"));
        }
        super.onActivityResult(i, i2, intent);
    }

    @Override // com.blued.android.core.ui.BaseFragment, com.blued.android.core.ui.BaseFragmentActivity.IOnBackPressedListener
    public boolean onBackPressed() {
        a();
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        switch (view.getId()) {
            case R.id.btn_avatar_cancel /* 2131362537 */:
                a();
                return;
            case R.id.btn_avatar_delete /* 2131362538 */:
            default:
                return;
            case R.id.btn_avatar_modify /* 2131362539 */:
                BluedPreferences.cS();
                this.n.setVisibility(8);
                return;
            case R.id.btn_avatar_save /* 2131362540 */:
                d();
                return;
        }
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.b = getActivity();
        View view = this.f33322a;
        if (view == null) {
            this.f33322a = layoutInflater.inflate(R.layout.fragment_avatar_widget, viewGroup, false);
            b();
            c();
        } else if (view.getParent() != null) {
            ((ViewGroup) this.f33322a.getParent()).removeView(this.f33322a);
        }
        return this.f33322a;
    }
}
