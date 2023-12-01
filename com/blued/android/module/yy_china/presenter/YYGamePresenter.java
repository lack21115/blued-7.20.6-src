package com.blued.android.module.yy_china.presenter;

import android.text.TextUtils;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYAudienceModel;
import com.blued.android.module.yy_china.model.YYImModel;
import com.blued.android.module.yy_china.model.YYMsgGameExtra;
import com.blued.android.module.yy_china.model.YYMsgUpdateMemberExtra;
import com.blued.android.module.yy_china.model.YYSeatMemberModel;
import com.blued.android.module.yy_china.view.YYPlayGameView;
import com.blued.android.module.yy_china.view.YYTeamMemberView;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.util.List;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/presenter/YYGamePresenter.class */
public class YYGamePresenter extends AbstractBasePresenter {
    public YYGamePresenter(BaseYYStudioFragment baseYYStudioFragment) {
        super(baseYYStudioFragment);
    }

    @Override // com.blued.android.module.yy_china.presenter.AbstractBasePresenter
    public void b(LifecycleOwner lifecycleOwner) {
        LiveEventBus.get("show_game_step", YYImModel.class).observe(lifecycleOwner, new Observer<YYImModel>() { // from class: com.blued.android.module.yy_china.presenter.YYGamePresenter.1
            /* renamed from: a */
            public void onChanged(YYImModel yYImModel) {
                YYMsgGameExtra yYMsgGameExtra;
                if (YYGamePresenter.this.a == null || YYGamePresenter.this.a.u == null || (yYMsgGameExtra = (YYMsgGameExtra) AppInfo.f().fromJson(yYImModel.getMsgExtra(), YYMsgGameExtra.class)) == null) {
                    return;
                }
                if (yYMsgGameExtra.step < 0) {
                    yYMsgGameExtra.step = 0;
                }
                YYAudienceModel yYAudienceModel = yYImModel.target_profile;
                YYRoomInfoManager.e().a(yYMsgGameExtra.time <= 0 ? 20L : yYMsgGameExtra.time, yYMsgGameExtra.step == 1 ? 2 : -1);
                YYGamePresenter.this.a.u.c(yYMsgGameExtra.step_title);
                YYGamePresenter.this.a.u.d(yYMsgGameExtra.active_left_value);
                YYGamePresenter.this.a.u.e(yYMsgGameExtra.active_right_value);
                YYGamePresenter.this.a.y();
                switch (yYMsgGameExtra.step) {
                    case 1:
                        YYGamePresenter.this.a.u.a(false);
                        return;
                    case 2:
                        YYGamePresenter.this.a.u.a(yYMsgGameExtra.member_left, yYMsgGameExtra.member_right);
                        return;
                    case 3:
                        YYGamePresenter.this.a.u.a(yYMsgGameExtra.member_left, yYMsgGameExtra.member_right);
                        if (yYAudienceModel == null || !TextUtils.equals(yYAudienceModel.getUid(), YYRoomInfoManager.e().k())) {
                            return;
                        }
                        YYTeamMemberView yYTeamMemberView = new YYTeamMemberView(YYGamePresenter.this.a.getContext());
                        yYTeamMemberView.a(YYGamePresenter.this.a, YYGamePresenter.this.a.getResources().getString(R.string.yy_game_choose_member), 1);
                        YYGamePresenter.this.a.a((View) yYTeamMemberView, -2, false);
                        return;
                    case 4:
                        YYGamePresenter.this.a.u.b();
                        return;
                    case 5:
                    case 10:
                        YYGamePresenter.this.a.u.a(yYMsgGameExtra.step_content);
                        return;
                    case 6:
                        YYGamePresenter.this.a.u.a(yYMsgGameExtra.step_content);
                        if (yYAudienceModel == null || !TextUtils.equals(yYAudienceModel.getUid(), YYRoomInfoManager.e().k())) {
                            return;
                        }
                        YYTeamMemberView yYTeamMemberView2 = new YYTeamMemberView(YYGamePresenter.this.a.getContext());
                        yYTeamMemberView2.a(YYGamePresenter.this.a, YYGamePresenter.this.a.getResources().getString(R.string.yy_game_battle_member), 2);
                        YYGamePresenter.this.a.a((View) yYTeamMemberView2, -2, false);
                        return;
                    case 7:
                        YYGamePresenter.this.a.u.a(yYMsgGameExtra.member_left, yYMsgGameExtra.member_right);
                        if (yYAudienceModel == null || !TextUtils.equals(yYAudienceModel.getUid(), YYRoomInfoManager.e().k())) {
                            return;
                        }
                        YYPlayGameView yYPlayGameView = new YYPlayGameView(YYGamePresenter.this.a.getContext());
                        yYPlayGameView.a(YYGamePresenter.this.a);
                        YYGamePresenter.this.a.a((View) yYPlayGameView, -2, false);
                        return;
                    case 8:
                        YYGamePresenter.this.a.u.a(yYMsgGameExtra.left_increase, yYMsgGameExtra.right_increase);
                        YYGamePresenter.this.a.u.a(yYMsgGameExtra.victory, yYMsgGameExtra.left_increase, yYMsgGameExtra.right_increase);
                        return;
                    case 9:
                        YYGamePresenter.this.a.u.a(yYMsgGameExtra.step_content);
                        if (yYAudienceModel == null || !TextUtils.equals(yYAudienceModel.getUid(), YYRoomInfoManager.e().k())) {
                            return;
                        }
                        YYGamePresenter.this.a.u.c();
                        return;
                    case 11:
                        YYGamePresenter.this.a.u.b(yYMsgGameExtra.step_content);
                        return;
                    case 12:
                        if (yYMsgGameExtra.victory == null) {
                            return;
                        }
                        int a = StringUtils.a(yYMsgGameExtra.victory.team_num, 0);
                        String str = a == 1 ? yYMsgGameExtra.active_left_value : "0";
                        if (a == 2) {
                            str = yYMsgGameExtra.active_right_value;
                        }
                        YYGamePresenter.this.a.u.a(yYMsgGameExtra.victory, a, str);
                        return;
                    default:
                        YYGamePresenter.this.a.u.a();
                        return;
                }
            }
        });
        LiveEventBus.get("show_game_team_active_value", YYMsgGameExtra.class).observe(lifecycleOwner, new Observer<YYMsgGameExtra>() { // from class: com.blued.android.module.yy_china.presenter.YYGamePresenter.2
            /* renamed from: a */
            public void onChanged(YYMsgGameExtra yYMsgGameExtra) {
                YYGamePresenter.this.a.u.e(yYMsgGameExtra.active_right_value);
                YYGamePresenter.this.a.u.d(yYMsgGameExtra.active_left_value);
            }
        });
        LiveEventBus.get("event_game_member_status", YYMsgUpdateMemberExtra.class).observe(lifecycleOwner, new Observer<YYMsgUpdateMemberExtra>() { // from class: com.blued.android.module.yy_china.presenter.YYGamePresenter.3
            /* renamed from: a */
            public void onChanged(YYMsgUpdateMemberExtra yYMsgUpdateMemberExtra) {
                List<YYSeatMemberModel> list;
                if (yYMsgUpdateMemberExtra == null || (list = yYMsgUpdateMemberExtra.seats) == null) {
                    return;
                }
                for (YYSeatMemberModel yYSeatMemberModel : list) {
                    if (yYSeatMemberModel != null) {
                        YYGamePresenter.this.a.E.a(yYSeatMemberModel);
                    }
                }
            }
        });
    }

    @Override // com.blued.android.module.yy_china.presenter.AbstractBasePresenter
    public void e() {
        super.e();
    }
}
