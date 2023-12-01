package com.soft.blued.ui.setting.fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import butterknife.BindView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.image.ImageOptions;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.framework.ui.mvp.MvpUtils;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.db.model.UserAccountsModel;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.CommonPreferences;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.bytedance.applog.tracker.Tracker;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.R;
import com.soft.blued.constant.EventBusConstant;
import com.soft.blued.ui.setting.Presenter.SwitchAccountPresenter;
import com.soft.blued.utils.BluedPreferences;
import com.youzan.androidsdk.tool.NetWorkUtil;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/fragment/SwitchAccountFragment.class */
public class SwitchAccountFragment extends MvpFragment<SwitchAccountPresenter> implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private int f19920a = 0;
    private boolean b = false;

    /* renamed from: c  reason: collision with root package name */
    private ImageOptions f19921c = new ImageOptions();
    private ImageOptions d = new ImageOptions();
    @BindView
    ImageView iv_account_icon_one;
    @BindView
    ImageView iv_account_icon_two;
    @BindView
    ImageView iv_delete_one;
    @BindView
    ImageView iv_delete_two;
    @BindView
    ImageView iv_online_state_one;
    @BindView
    ImageView iv_online_state_two;
    @BindView
    CommonTopTitleNoTrans top_title;
    @BindView
    TextView tv_account_nick_one;
    @BindView
    TextView tv_account_nick_two;
    @BindView
    TextView tv_add_account;
    @BindView
    ShapeTextView tv_has_unread;
    @BindView
    TextView tv_management;
    @BindView
    TextView tv_management_hint;
    @BindView
    TextView tv_online_hint_one;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<UserAccountsModel> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        if (list.size() == 2) {
            this.f19920a = 1;
        } else {
            this.f19920a = 0;
        }
        UserAccountsModel userAccountsModel = list.get(0);
        ImageLoader.a(getFragmentActive(), userAccountsModel.getBluedLoginResult().avatar).c().a(this.f19921c).a(this.iv_account_icon_one);
        this.tv_account_nick_one.setText(userAccountsModel.getBluedLoginResult().name);
        if (this.f19920a != 1) {
            this.iv_account_icon_two.setImageResource(2131233028);
            this.iv_online_state_two.setVisibility(8);
            this.tv_account_nick_two.setVisibility(8);
            this.tv_add_account.setVisibility(0);
            this.tv_management.setVisibility(8);
            this.tv_has_unread.setVisibility(8);
            return;
        }
        UserAccountsModel userAccountsModel2 = list.get(1);
        ImageLoader.a(getFragmentActive(), userAccountsModel2.getBluedLoginResult().avatar).c().a(this.d).a(this.iv_account_icon_two);
        this.iv_online_state_two.setVisibility(0);
        this.tv_account_nick_two.setVisibility(0);
        this.tv_account_nick_two.setText(userAccountsModel2.getBluedLoginResult().name);
        this.tv_add_account.setVisibility(8);
        this.tv_management.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (!this.b) {
            this.top_title.getLeftImg().setVisibility(0);
            this.top_title.getLeftTextView().setVisibility(8);
            this.iv_delete_one.setVisibility(8);
            this.iv_delete_two.setVisibility(8);
            this.tv_has_unread.setAlpha(1.0f);
            this.tv_management_hint.setVisibility(4);
            return;
        }
        this.top_title.getLeftImg().setVisibility(8);
        this.top_title.getLeftTextView().setVisibility(0);
        if (this.f19920a == 0) {
            this.iv_delete_one.setVisibility(0);
        } else {
            this.iv_delete_one.setVisibility(0);
            this.iv_delete_two.setVisibility(0);
        }
        this.tv_has_unread.setAlpha(0.5f);
        this.tv_management_hint.setVisibility(0);
    }

    private void b(final Runnable runnable) {
        CommonAlertDialog.a(getContext(), "", getResources().getString(R.string.delete_account), (String) null, new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.setting.fragment.SwitchAccountFragment.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Tracker.onClick(dialogInterface, i);
                runnable.run();
            }
        }, (String) null, (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        if (NetWorkUtil.isConnected(getContext())) {
            ((SwitchAccountPresenter) j()).a(z);
        } else {
            ToastUtils.a(getResources().getString(R.string.network_error));
        }
    }

    private void c() {
        if (NetWorkUtil.isConnected(getContext())) {
            ((SwitchAccountPresenter) j()).m();
        } else {
            ToastUtils.a(getResources().getString(R.string.network_error));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void a(Bundle bundle) {
        super.a(bundle);
        this.top_title.getRightImg().setVisibility(8);
        this.top_title.setCenterText(getString(R.string.switch_account));
        this.top_title.getLeftImg().setOnClickListener(this);
        this.top_title.getLeftTextView().setOnClickListener(this);
        this.top_title.getLeftTextView().setText(getResources().getString(2131886885));
        this.top_title.getLeftTextView().setTextColor(BluedSkinUtils.a(getContext(), 2131102254));
        this.top_title.getLeftTextView().setVisibility(8);
        this.iv_delete_one.setOnClickListener(this);
        this.iv_delete_two.setOnClickListener(this);
        this.iv_account_icon_one.setOnClickListener(this);
        this.iv_account_icon_two.setOnClickListener(this);
        this.tv_management.setOnClickListener(this);
        if (UserInfo.getInstance().getLoginUserInfo().vip_grade == 0) {
            this.f19921c.c = R.drawable.user_bg_round_border_white;
            this.f19921c.a = R.drawable.user_bg_round_border_white;
        } else {
            this.f19921c.c = R.drawable.user_bg_round_border_vip;
            this.f19921c.a = R.drawable.user_bg_round_border_vip;
        }
        this.d.c = R.drawable.user_bg_round_border_white;
        this.d.a = R.drawable.user_bg_round_border_white;
        LiveEventBus.get(EventBusConstant.KEY_EVENT_HIDE_LOGIN_BACK, Void.class).observe(this, new Observer<Void>() { // from class: com.soft.blued.ui.setting.fragment.SwitchAccountFragment.1
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(Void r4) {
                LiveEventBus.get(EventBusConstant.KEY_EVENT_FINISH_SETTING).post(null);
                SwitchAccountFragment.this.top_title.getLeftImg().setVisibility(8);
            }
        });
        if (CommonPreferences.m()) {
            this.tv_has_unread.setVisibility(0);
            int dH = BluedPreferences.dH();
            if (dH == 1) {
                this.tv_has_unread.setText((int) R.string.switch_account_unread);
            } else if (dH == 2) {
                this.tv_has_unread.setText((int) R.string.switch_account_unread_follower);
            } else if (dH != 3) {
            } else {
                this.tv_has_unread.setText((int) R.string.switch_account_unread_visitor);
            }
        }
    }

    public void a(String str, List list) {
        super.a(str, list);
        if (!str.equals("data_account") || list == null || list.size() <= 0) {
            return;
        }
        MvpUtils.a(list, UserAccountsModel.class, new MvpUtils.DataListHandler<UserAccountsModel>() { // from class: com.soft.blued.ui.setting.fragment.SwitchAccountFragment.2
            public void a() {
            }

            public void a(List<UserAccountsModel> list2) {
                SwitchAccountFragment.this.a(list2);
                SwitchAccountFragment.this.b = false;
                SwitchAccountFragment.this.b();
            }
        });
    }

    public int g() {
        return R.layout.fm_switch_account;
    }

    public boolean isActivitySwipeBackEnable() {
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        switch (view.getId()) {
            case 2131363120:
                if (this.b) {
                    this.b = false;
                    b();
                    return;
                }
                return;
            case 2131363123:
                getActivity().finish();
                return;
            case R.id.iv_account_icon_one /* 2131365017 */:
                if (this.b || UserInfo.getInstance().isLogin()) {
                    return;
                }
                c();
                return;
            case R.id.iv_account_icon_two /* 2131365018 */:
                if (this.b) {
                    return;
                }
                if (this.f19920a == 0) {
                    ((SwitchAccountPresenter) j()).n();
                    return;
                } else {
                    b(false);
                    return;
                }
            case R.id.iv_delete_one /* 2131365257 */:
                b(new Runnable() { // from class: com.soft.blued.ui.setting.fragment.SwitchAccountFragment.3
                    @Override // java.lang.Runnable
                    public void run() {
                        SwitchAccountFragment.this.b(true);
                    }
                });
                return;
            case R.id.iv_delete_two /* 2131365259 */:
                b(new Runnable() { // from class: com.soft.blued.ui.setting.fragment.SwitchAccountFragment.4
                    @Override // java.lang.Runnable
                    public void run() {
                        ((SwitchAccountPresenter) SwitchAccountFragment.this.j()).p();
                        ((SwitchAccountPresenter) SwitchAccountFragment.this.j()).o();
                        CommonPreferences.a(false);
                    }
                });
                return;
            case R.id.tv_management /* 2131371908 */:
                if (this.b) {
                    return;
                }
                this.b = true;
                b();
                return;
            default:
                return;
        }
    }
}
