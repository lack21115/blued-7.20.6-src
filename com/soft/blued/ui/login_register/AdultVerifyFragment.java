package com.soft.blued.ui.login_register;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.trace.EventTrackSettings;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.blued.das.settings.SettingsProtos;
import com.blued.login.auto.LoginServiceManager;
import com.blued.login.face.AVConfig;
import com.blued.login.fragment.AdultIdentifyFragment;
import com.blued.login.fragment.FinishProfile1Fragment;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.constant.CameraContents;
import com.soft.blued.log.InstantLog;
import com.soft.blued.ui.home.HomeArgumentHelper;
import com.soft.blued.ui.login_register.model.AdultVerifyModel;
import com.soft.blued.ui.photo.camera.fragment.CameraFragment;
import com.soft.blued.utils.UserRelationshipUtils;
import com.soft.blued.utils.third.BaiduFaceDetectUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/login_register/AdultVerifyFragment.class */
public class AdultVerifyFragment extends MvpFragment {

    /* renamed from: a  reason: collision with root package name */
    public Context f31336a;
    @BindView
    ShapeTextView btnSolid;
    @BindView
    ShapeTextView btnStroke;
    @BindView
    FrameLayout flCover;
    @BindView
    ImageView imgBtmIcon;
    @BindView
    ImageView imgCover;
    @BindView
    CommonTopTitleNoTrans title;
    @BindView
    TextView tvConfirmToSubmit;
    @BindView
    TextView tvContent;
    @BindView
    TextView tvTitle;
    @BindView
    TextView tvUpIdFront;
    public int b = 0;

    /* renamed from: c  reason: collision with root package name */
    private String f31337c = "";
    private int d = 0;
    private int e = 0;
    private String f = "";
    private String g = "";

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/login_register/AdultVerifyFragment$AV_START_PAGE.class */
    public enum AV_START_PAGE {
        REGISTER,
        OTHER
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/login_register/AdultVerifyFragment$VERIFY_RESULT.class */
    public interface VERIFY_RESULT {
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/login_register/AdultVerifyFragment$VERIFY_STAGE.class */
    public interface VERIFY_STAGE {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/login_register/AdultVerifyFragment$VerifyStage.class */
    public @interface VerifyStage {
    }

    public static void a(Context context) {
        a(context, AV_START_PAGE.OTHER);
    }

    public static void a(Context context, int i, AdultVerifyModel adultVerifyModel, String str) {
        TerminalActivity.d(context, AdultIdentifyFragment.class, null);
    }

    public static void a(Context context, AV_START_PAGE av_start_page) {
        if (context == null) {
            return;
        }
        TerminalActivity.d(context, AdultIdentifyFragment.class, null);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public void a(Bundle bundle) {
        BaiduFaceDetectUtils.a(AppInfo.d());
        this.f31336a = getActivity();
        super.a(bundle);
        b();
    }

    public void b() {
        if (getArguments() != null) {
            this.b = getArguments().getInt("KEY_STAGE");
            this.f31337c = getArguments().getString("KEY_FILE_PATH");
            if (this.b == 0) {
                CameraContents.e = (AV_START_PAGE) getArguments().getSerializable("KEY_START_PAGE");
            }
            AdultVerifyModel adultVerifyModel = (AdultVerifyModel) getArguments().getSerializable("KEY_AV_MODEL");
            if (adultVerifyModel != null) {
                this.e = adultVerifyModel.times;
                this.d = adultVerifyModel.is_success;
                this.f = adultVerifyModel.tip;
                this.g = adultVerifyModel.tip_title;
            }
        }
        c();
    }

    public void c() {
        ShapeHelper.b(this.btnSolid, 2131101190, 2131101190, 2131101298);
        int i = this.b;
        if (i == 1) {
            d();
        } else if (i == 2) {
            v();
        } else if (i != 3) {
            FaceDetectFragment.a(this, 101);
        } else {
            e();
        }
    }

    public void d() {
        InstantLog.a("av_face_result_show");
        EventTrackSettings.a(SettingsProtos.Event.AV_FACE_RESULT_SHOW);
        this.title.setCenterText(AVConfig.a().b().face_title);
        this.title.setLeftImg(2131233902);
        this.title.setLeftClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.login_register.AdultVerifyFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                CommonAlertDialog.a(AdultVerifyFragment.this.getActivity(), (String) null, AdultVerifyFragment.this.getResources().getString(R.string.av_confirm_quit_verify), AdultVerifyFragment.this.getResources().getString(2131887281), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.login_register.AdultVerifyFragment.1.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Tracker.onClick(dialogInterface, i);
                        UserRelationshipUtils.a("", new int[0]);
                    }
                }, (String) null, (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
            }
        });
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.flCover.getLayoutParams();
        layoutParams.leftMargin = DensityUtils.a(this.f31336a, 30.0f);
        layoutParams.rightMargin = DensityUtils.a(this.f31336a, 30.0f);
        layoutParams.topMargin = DensityUtils.a(this.f31336a, 10.0f);
        this.flCover.setLayoutParams(layoutParams);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.imgCover.getLayoutParams();
        layoutParams2.height = AppInfo.l - DensityUtils.a(this.f31336a, 60.0f);
        this.imgCover.setLayoutParams(layoutParams2);
        ImageLoader.d(getFragmentActive(), this.f31337c).b(R.drawable.camera_default_face_bg).a(this.imgCover);
        this.tvTitle.setVisibility(0);
        this.imgBtmIcon.setVisibility(0);
        int i = this.d;
        if (i == 0) {
            UserInfo.getInstance().getLoginUserInfo().setNeedAdultVerify(1);
            this.imgBtmIcon.setImageResource(R.drawable.icon_av_fail);
            this.tvTitle.setText(this.g);
            this.tvContent.setTextColor(this.f31336a.getResources().getColor(2131101204));
            this.tvContent.setText(this.f);
            this.tvConfirmToSubmit.setVisibility(0);
            this.btnStroke.setVisibility(8);
            if (this.e <= 0) {
                this.btnSolid.setText(this.f31336a.getResources().getString(R.string.av_take_photo_no_time));
                this.btnSolid.setEnabled(false);
                return;
            }
            String string = this.f31336a.getResources().getString(R.string.av_take_photo_again);
            this.btnSolid.setText(String.format(string, this.e + ""));
            this.btnSolid.setEnabled(true);
            this.btnSolid.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.login_register.AdultVerifyFragment.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                }
            });
        } else if (i != 1) {
            if (i != 2) {
                return;
            }
            UserInfo.getInstance().getLoginUserInfo().setNeedAdultVerify(1);
            this.imgBtmIcon.setImageResource(R.drawable.icon_av_fail);
            this.tvTitle.setText(this.f);
            this.tvContent.setVisibility(8);
            this.tvConfirmToSubmit.setVisibility(8);
            this.btnStroke.setVisibility(8);
            this.btnSolid.setText(R.string.av_verify_id_card);
            this.btnSolid.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.login_register.AdultVerifyFragment.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    AdultVerifyFragment.a(AdultVerifyFragment.this.f31336a, 2, null, "");
                }
            });
        } else {
            UserInfo.getInstance().getLoginUserInfo().setNeedAdultVerify(0);
            UserRelationshipUtils.b();
            if (AVConfig.a().f20536a) {
                if (UserInfo.getInstance().isBindPhone()) {
                    FinishProfile1Fragment.f20540a.a(this.f31336a);
                    return;
                } else {
                    LoginServiceManager.a().c(this.f31336a);
                    return;
                }
            }
            getActivity().setResult(-1);
            Bundle bundle = new Bundle();
            bundle.putString("from_tag_page", "from_tag_register");
            HomeArgumentHelper.a(getActivity(), (Bundle) null, bundle);
        }
    }

    public void e() {
        InstantLog.a("av_idcard_result_show");
        EventTrackSettings.a(SettingsProtos.Event.AV_IDCARD_RESULT_SHOW);
        this.title.setCenterText(R.string.av_result);
        this.title.setLeftImg(2131233902);
        this.title.setLeftClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.login_register.AdultVerifyFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                CommonAlertDialog.a(AdultVerifyFragment.this.getActivity(), (String) null, AdultVerifyFragment.this.getResources().getString(R.string.av_confirm_quit_verify), AdultVerifyFragment.this.getResources().getString(2131887281), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.login_register.AdultVerifyFragment.4.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Tracker.onClick(dialogInterface, i);
                        UserRelationshipUtils.a("", new int[0]);
                    }
                }, (String) null, (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
            }
        });
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.flCover.getLayoutParams();
        layoutParams.leftMargin = DensityUtils.a(this.f31336a, 30.0f);
        layoutParams.rightMargin = DensityUtils.a(this.f31336a, 30.0f);
        layoutParams.topMargin = DensityUtils.a(this.f31336a, 10.0f);
        this.flCover.setLayoutParams(layoutParams);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.imgCover.getLayoutParams();
        layoutParams2.height = AppInfo.l - DensityUtils.a(this.f31336a, 60.0f);
        this.imgCover.setLayoutParams(layoutParams2);
        ImageLoader.d(getFragmentActive(), this.f31337c).b(R.drawable.cover_id_card).a(this.imgCover);
        this.tvTitle.setVisibility(0);
        this.imgBtmIcon.setVisibility(0);
        int i = this.d;
        if (i == 0) {
            UserInfo.getInstance().getLoginUserInfo().setNeedAdultVerify(1);
            this.imgBtmIcon.setImageResource(R.drawable.icon_av_fail);
            this.tvTitle.setText(R.string.av_take_idcard_error);
            this.tvContent.setText(this.f);
            this.tvContent.setTextColor(this.f31336a.getResources().getColor(2131101204));
            this.tvConfirmToSubmit.setVisibility(0);
            this.btnStroke.setVisibility(8);
            if (this.e <= 0) {
                this.btnSolid.setText(this.f31336a.getResources().getString(R.string.av_take_photo_no_time));
                this.btnSolid.setEnabled(false);
                return;
            }
            String string = this.f31336a.getResources().getString(R.string.av_take_photo_again);
            this.btnSolid.setText(String.format(string, this.e + ""));
            this.btnSolid.setEnabled(true);
            this.btnSolid.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.login_register.AdultVerifyFragment.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    CameraFragment.a(AdultVerifyFragment.this, 2, 102);
                }
            });
        } else if (i == 1) {
            UserInfo.getInstance().getLoginUserInfo().setNeedAdultVerify(0);
            UserRelationshipUtils.b();
            this.title.d();
            this.imgBtmIcon.setImageResource(R.drawable.icon_av_success);
            this.tvTitle.setText(R.string.av_success);
            this.tvContent.setTextColor(this.f31336a.getResources().getColor(2131101204));
            this.tvContent.setText(this.f);
            this.tvConfirmToSubmit.setVisibility(8);
            this.btnSolid.setText(2131887320);
            this.btnStroke.setVisibility(8);
            this.btnSolid.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.login_register.AdultVerifyFragment.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    if (AVConfig.a().f20536a) {
                        FinishProfile1Fragment.f20540a.a(AdultVerifyFragment.this.f31336a);
                        return;
                    }
                    AdultVerifyFragment.this.getActivity().setResult(-1);
                    Bundle bundle = new Bundle();
                    bundle.putString("from_tag_page", "from_tag_register");
                    HomeArgumentHelper.a(AdultVerifyFragment.this.getActivity(), (Bundle) null, bundle);
                }
            });
        } else if (i != 2) {
        } else {
            UserInfo.getInstance().getLoginUserInfo().setNeedAdultVerify(1);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.flCover.getLayoutParams();
            layoutParams3.leftMargin = DensityUtils.a(this.f31336a, 0.0f);
            layoutParams3.rightMargin = DensityUtils.a(this.f31336a, 0.0f);
            layoutParams3.topMargin = DensityUtils.a(this.f31336a, 0.0f);
            this.flCover.setLayoutParams(layoutParams);
            this.imgCover.setImageResource(R.drawable.cover_non_adult);
            FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) this.imgCover.getLayoutParams();
            layoutParams4.height = -2;
            this.imgCover.setLayoutParams(layoutParams4);
            this.imgBtmIcon.setImageResource(R.drawable.icon_av_fail);
            this.tvTitle.setText(this.f);
            this.tvContent.setVisibility(8);
            this.tvConfirmToSubmit.setVisibility(8);
            this.btnSolid.setVisibility(8);
            this.btnStroke.setVisibility(8);
        }
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public int g() {
        return R.layout.adult_verify_fragment;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 != -1 || intent == null) {
            return;
        }
        AdultVerifyModel adultVerifyModel = (AdultVerifyModel) intent.getSerializableExtra("KEY_AV_MODEL");
        String stringExtra = intent.getStringExtra("KEY_FILE_PATH");
        if (i == 101) {
            a(this.f31336a, 1, adultVerifyModel, stringExtra);
        } else if (i != 102) {
        } else {
            a(this.f31336a, 3, adultVerifyModel, stringExtra);
        }
    }

    @Override // com.blued.android.core.ui.BaseFragment, com.blued.android.core.ui.BaseFragmentActivity.IOnBackPressedListener
    public boolean onBackPressed() {
        this.title.getLeftImg().callOnClick();
        return true;
    }

    public void v() {
        InstantLog.a("av_idcard_start_show");
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.flCover.getLayoutParams();
        layoutParams.leftMargin = DensityUtils.a(this.f31336a, 30.0f);
        layoutParams.rightMargin = DensityUtils.a(this.f31336a, 30.0f);
        layoutParams.topMargin = DensityUtils.a(this.f31336a, 10.0f);
        this.flCover.setLayoutParams(layoutParams);
        this.title.setLeftImg(2131233902);
        this.title.setLeftClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.login_register.AdultVerifyFragment.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                CommonAlertDialog.a(AdultVerifyFragment.this.getActivity(), (String) null, AdultVerifyFragment.this.getResources().getString(R.string.av_confirm_quit_verify), AdultVerifyFragment.this.getResources().getString(2131887281), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.login_register.AdultVerifyFragment.7.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Tracker.onClick(dialogInterface, i);
                        UserRelationshipUtils.a("", new int[0]);
                    }
                }, (String) null, (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
            }
        });
        this.tvUpIdFront.setVisibility(0);
        this.title.setCenterText(R.string.av_verify_id_card);
        this.imgCover.setImageResource(R.drawable.cover_id_card);
        this.imgCover.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.login_register.AdultVerifyFragment.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                AdultVerifyFragment.this.btnSolid.callOnClick();
            }
        });
        this.imgBtmIcon.setVisibility(0);
        this.imgBtmIcon.setImageResource(R.drawable.icon_upload_id_card);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.imgBtmIcon.getLayoutParams();
        layoutParams2.gravity = 17;
        this.imgBtmIcon.setLayoutParams(layoutParams2);
        this.tvTitle.setVisibility(0);
        this.tvTitle.setText(R.string.av_idcard_start_hint);
        this.tvTitle.setTextColor(this.f31336a.getResources().getColor(2131101204));
        this.tvTitle.setTextSize(14.0f);
        this.tvContent.setVisibility(8);
        this.tvConfirmToSubmit.setVisibility(8);
        this.btnStroke.setVisibility(8);
        this.btnSolid.setText(R.string.av_start_photo);
        this.btnSolid.setTextColor(this.f31336a.getResources().getColor(2131101191));
        this.btnSolid.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.login_register.AdultVerifyFragment.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                CameraFragment.a(AdultVerifyFragment.this, 2, 102);
            }
        });
    }
}
