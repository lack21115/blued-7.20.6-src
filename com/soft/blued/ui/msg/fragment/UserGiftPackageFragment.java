package com.soft.blued.ui.msg.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.ui.xpop.XPopup;
import com.blued.android.framework.ui.xpop.core.BasePopupView;
import com.blued.android.framework.ui.xpop.interfaces.SimpleCallback;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.das.profile.PersonalProfileProtos;
import com.bytedance.applog.tracker.Tracker;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.R;
import com.soft.blued.constant.EventBusConstant;
import com.soft.blued.customview.CirclePageIndicator;
import com.soft.blued.log.track.EventTrackPersonalProfile;
import com.soft.blued.ui.msg.adapter.UserGiftPackageAdapter;
import com.soft.blued.ui.msg.event.GiftHintEvent;
import com.soft.blued.ui.msg.model.UserGiftPackageModel;
import com.soft.blued.ui.msg.pop.BirthCardPop;
import com.soft.blued.ui.msg.pop.UserGiftDialogFragment;
import com.soft.blued.ui.msg.presenter.UserGiftPresenter;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.PopMenuUtils;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/fragment/UserGiftPackageFragment.class */
public class UserGiftPackageFragment extends BasePagerGridFragment<UserGiftPresenter, UserGiftPackageAdapter, UserGiftPackageModel> implements View.OnClickListener {
    public static final String g = UserGiftPackageFragment.class.getSimpleName();
    @BindView
    public CirclePageIndicator circlePageIndicator;
    @BindView
    public ViewPager gift_pager;
    private UserGiftDialogFragment k;
    private UserGiftDialogFragment.BuySucceedListener l;
    private String m;
    private String n;
    private String o;
    @BindView
    public TextView stv_buy;
    @BindView
    public TextView tv_empty;

    public UserGiftPackageFragment() {
    }

    public UserGiftPackageFragment(String str, String str2, String str3, UserGiftDialogFragment.BuySucceedListener buySucceedListener, UserGiftDialogFragment userGiftDialogFragment) {
        this.k = userGiftDialogFragment;
        this.l = buySucceedListener;
        this.m = str;
        this.n = str2;
        this.o = str3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void a(Bundle bundle) {
        super.a(bundle);
        this.stv_buy.setOnClickListener(this);
        this.circlePageIndicator.setInterval(DensityUtils.a(getContext(), 5.0f));
        this.circlePageIndicator.setPageColor(BluedSkinUtils.a(getContext(), 2131102205));
        this.circlePageIndicator.setFillColor(BluedSkinUtils.a(getContext(), 2131101304));
        UserGiftDialogFragment userGiftDialogFragment = this.k;
        if (userGiftDialogFragment != null && userGiftDialogFragment.h() != null) {
            this.k.h().a(this.i, 1);
        }
        LiveEventBus.get(EventBusConstant.KEY_EVENT_GO_ON_SEND_GIFT_PACKAGE, Void.class).observe(this, new Observer<Void>() { // from class: com.soft.blued.ui.msg.fragment.UserGiftPackageFragment.1
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(Void r3) {
                UserGiftPackageFragment.this.stv_buy.performClick();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.soft.blued.ui.msg.fragment.BasePagerGridFragment
    /* renamed from: a */
    public void b(UserGiftPackageModel userGiftPackageModel) {
        GiftHintEvent giftHintEvent = new GiftHintEvent();
        if (userGiftPackageModel == null || userGiftPackageModel.gift_detail == null) {
            LiveEventBus.get(EventBusConstant.KEY_EVENT_GIFT_HINT).post(giftHintEvent);
            return;
        }
        super.b((UserGiftPackageFragment) userGiftPackageModel);
        UserGiftDialogFragment userGiftDialogFragment = this.k;
        if (userGiftDialogFragment == null || userGiftDialogFragment.j() != 1) {
            return;
        }
        giftHintEvent.f18635a = userGiftPackageModel.gift_detail.type;
        giftHintEvent.e = userGiftPackageModel.gift_detail.icon;
        if (userGiftPackageModel.gift_detail.type == 1) {
            giftHintEvent.b = getContext().getString(R.string.give_it_now_tip);
        } else if (userGiftPackageModel.gift_detail.type == 2) {
            giftHintEvent.d = true;
            int i = userGiftPackageModel.gift_detail.seconds / 3600;
            String string = getContext().getString(R.string.user_gift_top_hint);
            giftHintEvent.b = String.format(string, i + "");
        } else if (userGiftPackageModel.gift_detail.type == 3) {
            giftHintEvent.d = true;
            giftHintEvent.b = getString(R.string.msg_gift_card_hint);
        }
        LiveEventBus.get(EventBusConstant.KEY_EVENT_GIFT_HINT).post(giftHintEvent);
    }

    @Override // com.soft.blued.ui.msg.fragment.BasePagerGridFragment
    /* renamed from: b */
    public UserGiftPackageAdapter a(List<UserGiftPackageModel> list) {
        return new UserGiftPackageAdapter(getFragmentActive(), list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(List<UserGiftPackageModel> list) {
        String str = g;
        Logger.c(str, "DATA_PACKAGE===" + list.size());
        this.f18641a = list;
        a(this.gift_pager, this.circlePageIndicator);
        if (list == null || list.size() <= 0) {
            return;
        }
        if (list.size() > b()) {
            this.circlePageIndicator.setVisibility(0);
        }
        this.tv_empty.setVisibility(4);
        b(list.get(0));
    }

    public int g() {
        return R.layout.fm_user_gift_package;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        if (view.getId() != 2131370354 || this.f == 0 || ((UserGiftPackageModel) this.f).gift_detail == null) {
            return;
        }
        EventTrackPersonalProfile.a(PersonalProfileProtos.Event.GIFT_BUY_PAGE_BUY_BTN_CLICK, this.m, this.n.equals("user_page_gift") ? PersonalProfileProtos.GiftFrom.PERSONAL_PAGE : PersonalProfileProtos.GiftFrom.MESSAGE_PAGE, ((UserGiftPackageModel) this.f).gift_detail.gift_id, true);
        if (PopMenuUtils.a(getContext())) {
            UserGiftDialogFragment userGiftDialogFragment = this.k;
            if (userGiftDialogFragment != null) {
                userGiftDialogFragment.dismiss();
                return;
            }
            return;
        }
        UserGiftDialogFragment userGiftDialogFragment2 = this.k;
        if (userGiftDialogFragment2 != null && ("8".equals(userGiftDialogFragment2.i()) || "4".equals(this.k.i()) || "12".equals(this.k.i()))) {
            ToastUtils.a(getResources().getString(R.string.msg_gift_been_blacked));
        } else if (((UserGiftPackageModel) this.f).gift_detail.type == 3 && ((UserGiftPackageModel) this.f).gift_detail.extra_info != null && TextUtils.isEmpty(((UserGiftPackageModel) this.f).gift_detail.extra_info.text)) {
            ((UserGiftPackageModel) this.f).gift_detail.extra_info.to = this.o;
            ((UserGiftPackageModel) this.f).gift_detail.extra_info.from = UserInfo.getInstance().getLoginUserInfo().name;
            final BirthCardPop birthCardPop = new BirthCardPop(getContext(), ((UserGiftPackageModel) this.f).gift_detail, true, true);
            birthCardPop.f18768c = getFragmentActive();
            new XPopup.Builder(getContext()).f(false).a(new SimpleCallback() { // from class: com.soft.blued.ui.msg.fragment.UserGiftPackageFragment.2
                public boolean f(BasePopupView basePopupView) {
                    birthCardPop.c();
                    return true;
                }
            }).a(birthCardPop).h();
        } else {
            UserGiftPresenter userGiftPresenter = (UserGiftPresenter) this.h;
            String str = this.m;
            String str2 = this.n;
            userGiftPresenter.a(str, str2, null, ((UserGiftPackageModel) this.f).id + "");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void v() {
        if (getContext() != null) {
            ToastUtils.a(getContext().getString(R.string.msg_gift_bag_success));
        }
        UserGiftDialogFragment.BuySucceedListener buySucceedListener = this.l;
        if (buySucceedListener != null) {
            buySucceedListener.a(this.k, ((UserGiftPackageModel) this.f).gift_detail);
        }
    }
}
