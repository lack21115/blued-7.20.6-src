package com.soft.blued.ui.setting.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
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
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.permission.PermissionCallbacks;
import com.blued.android.framework.utils.CommonTools;
import com.blued.android.framework.utils.ImageUtils;
import com.blued.android.framework.utils.upload.QiniuUploadTools;
import com.blued.android.module.common.user.model.BluedAlbum;
import com.blued.android.module.common.utils.AvatarUtils;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.common.utils.PermissionUtils;
import com.blued.android.module.common.utils.third.QiniuUploadUtils;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.http.LoginRegisterHttpUtils;
import com.soft.blued.http.MineHttpUtils;
import com.soft.blued.http.UserHttpUtils;
import com.soft.blued.ui.feed.fragment.PhotoSelectFragment;
import com.soft.blued.utils.StringUtils;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/fragment/ModifyVipBgFragment.class */
public class ModifyVipBgFragment extends BaseFragment implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private View f33507a;
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private View f33508c;
    private View d;
    private View e;
    private View f;
    private ImageView g;
    private TextView h;
    private View i;
    private String j;
    private int k;
    private Dialog l;

    private Bitmap a(View view) {
        Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        view.draw(new Canvas(createBitmap));
        return createBitmap;
    }

    private void a() {
        Intent intent = new Intent();
        intent.putExtra("background_photo", this.j);
        intent.putExtra("background_photo_auditing", this.k);
        getActivity().setResult(-1, intent);
        getActivity().finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(DialogInterface dialogInterface, int i) {
        f();
    }

    public static void a(BaseFragment baseFragment, int i, String str, int i2) {
        Bundle bundle = new Bundle();
        bundle.putString("background_photo", str);
        bundle.putInt("background_photo_auditing", i);
        TerminalActivity.a(baseFragment, ModifyVipBgFragment.class, bundle, i2);
    }

    private void a(final String str) {
        LoginRegisterHttpUtils.a(this.b, new BluedUIHttpResponse<BluedEntityA<BluedAlbum>>(getFragmentActive()) { // from class: com.soft.blued.ui.setting.fragment.ModifyVipBgFragment.3
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<BluedAlbum> bluedEntityA) {
                if (bluedEntityA.data == null || bluedEntityA.data.size() <= 0) {
                    return;
                }
                ModifyVipBgFragment.this.a(str, bluedEntityA.data.get(0));
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str2) {
                return super.onUIFailure(i, str2);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
                DialogUtils.b(ModifyVipBgFragment.this.l);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
                DialogUtils.a(ModifyVipBgFragment.this.l);
            }
        }, getFragmentActive());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, BluedAlbum bluedAlbum) {
        QiniuUploadUtils.a(str, bluedAlbum, new QiniuUploadTools.QiNiuListener() { // from class: com.soft.blued.ui.setting.fragment.ModifyVipBgFragment.4
            @Override // com.blued.android.framework.utils.upload.QiniuUploadTools.QiNiuListener
            public void a(String str2) {
                if (CommonTools.a(ModifyVipBgFragment.this)) {
                    DialogUtils.b(ModifyVipBgFragment.this.l);
                }
            }

            @Override // com.blued.android.framework.utils.upload.QiniuUploadTools.QiNiuListener
            public void a(String str2, double d) {
            }

            @Override // com.blued.android.framework.utils.upload.QiniuUploadTools.QiNiuListener
            public void a(String str2, String str3) {
                ModifyVipBgFragment.this.b(str2);
            }

            @Override // com.blued.android.framework.utils.upload.QiniuUploadTools.QiNiuListener
            public boolean a() {
                return false;
            }
        });
    }

    private void b() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.j = arguments.getString("background_photo");
            this.k = arguments.getInt("background_photo_auditing");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final String str) {
        MineHttpUtils.d(this.b, new BluedUIHttpResponse<BluedEntityA<BluedAlbum>>(getFragmentActive()) { // from class: com.soft.blued.ui.setting.fragment.ModifyVipBgFragment.5
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<BluedAlbum> bluedEntityA) {
                ModifyVipBgFragment.this.h.setVisibility(0);
                ModifyVipBgFragment.this.i.setVisibility(0);
                ModifyVipBgFragment.this.k = 1;
                ModifyVipBgFragment.this.j = str;
                ImageLoader.a(ModifyVipBgFragment.this.getFragmentActive(), AvatarUtils.a(3, ModifyVipBgFragment.this.j)).b(R.drawable.bg_vip_bg_default).d(R.drawable.bg_vip_bg_default).a(ModifyVipBgFragment.this.g);
                ModifyVipBgFragment.this.f33508c.setVisibility(0);
                ModifyVipBgFragment.this.d.setVisibility(0);
                AppMethods.d((int) R.string.profile_background_upload_success);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str2) {
                return super.onUIFailure(i, str2);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
                DialogUtils.b(ModifyVipBgFragment.this.l);
            }
        }, str, getFragmentActive());
    }

    private void c() {
        this.l = DialogUtils.a(this.b);
        this.f33508c = this.f33507a.findViewById(R.id.btn_vip_bg_delete);
        this.d = this.f33507a.findViewById(R.id.btn_vip_bg_save);
        this.e = this.f33507a.findViewById(R.id.btn_vip_bg_modify);
        this.f = this.f33507a.findViewById(R.id.btn_vip_bg_cancel);
        this.g = (ImageView) this.f33507a.findViewById(2131366044);
        this.h = (TextView) this.f33507a.findViewById(R.id.tv_vip_bg_under_reviewing);
        this.i = this.f33507a.findViewById(R.id.iv_vip_bg_ground);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.g.getLayoutParams();
        layoutParams.height = AppInfo.l;
        this.g.setLayoutParams(layoutParams);
        this.f33508c.setOnClickListener(this);
        this.d.setOnClickListener(this);
        this.e.setOnClickListener(this);
        this.f.setOnClickListener(this);
        if (TextUtils.isEmpty(this.j)) {
            return;
        }
        if (this.k == 1) {
            this.h.setVisibility(0);
            this.i.setVisibility(0);
        } else {
            this.h.setVisibility(8);
            this.i.setVisibility(8);
        }
        ImageLoader.a(getFragmentActive(), AvatarUtils.a(3, this.j)).b(R.drawable.bg_vip_bg_default).d(R.drawable.bg_vip_bg_default).a(this.g);
    }

    private void d() {
        PermissionUtils.f(new PermissionCallbacks() { // from class: com.soft.blued.ui.setting.fragment.ModifyVipBgFragment.1
            @Override // com.blued.android.framework.permission.PermissionCallbacks
            public void U_() {
                PhotoSelectFragment.a(ModifyVipBgFragment.this, 14, 178);
            }

            @Override // com.blued.android.framework.permission.PermissionCallbacks
            public void a(String[] strArr) {
            }
        });
    }

    private void e() {
        ImageUtils.a(a(this.g));
    }

    private void f() {
        UserHttpUtils.c(new BluedUIHttpResponse<BluedEntityA>(getFragmentActive()) { // from class: com.soft.blued.ui.setting.fragment.ModifyVipBgFragment.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA bluedEntityA) {
                AppMethods.d(2131887470);
                ModifyVipBgFragment.this.j = "";
                ModifyVipBgFragment.this.k = 0;
                ImageLoader.a(ModifyVipBgFragment.this.getFragmentActive(), ModifyVipBgFragment.this.j).b(R.drawable.bg_vip_bg_default).d(R.drawable.bg_vip_bg_default).a(ModifyVipBgFragment.this.g);
                ModifyVipBgFragment.this.h.setVisibility(8);
                ModifyVipBgFragment.this.i.setVisibility(8);
                ModifyVipBgFragment.this.f33508c.setVisibility(8);
                ModifyVipBgFragment.this.d.setVisibility(8);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
                DialogUtils.b(ModifyVipBgFragment.this.l);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
                DialogUtils.a(ModifyVipBgFragment.this.l);
            }
        }, getFragmentActive());
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1 && i == 178 && intent != null) {
            String stringExtra = intent.getStringExtra("photo_path");
            if (!StringUtils.d(stringExtra)) {
                a(stringExtra);
            }
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
            case R.id.btn_vip_bg_cancel /* 2131362667 */:
                a();
                return;
            case R.id.btn_vip_bg_delete /* 2131362668 */:
                Context context = this.b;
                CommonAlertDialog.a(context, context.getResources().getString(R.string.profile_background_del), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.setting.fragment.-$$Lambda$ModifyVipBgFragment$oBVM005qt1C3IjV4o5cWf3OYJtg
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        ModifyVipBgFragment.this.a(dialogInterface, i);
                    }
                });
                return;
            case R.id.btn_vip_bg_modify /* 2131362669 */:
                d();
                return;
            case R.id.btn_vip_bg_save /* 2131362670 */:
                e();
                return;
            default:
                return;
        }
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.b = getActivity();
        View view = this.f33507a;
        if (view == null) {
            this.f33507a = layoutInflater.inflate(R.layout.fragment_modify_vip_bg, viewGroup, false);
            b();
            c();
        } else if (view.getParent() != null) {
            ((ViewGroup) this.f33507a.getParent()).removeView(this.f33507a);
        }
        return this.f33507a;
    }
}
