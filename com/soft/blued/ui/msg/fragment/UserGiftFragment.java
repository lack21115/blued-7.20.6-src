package com.soft.blued.ui.msg.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.xpop.XPopup;
import com.blued.android.framework.ui.xpop.core.BasePopupView;
import com.blued.android.framework.ui.xpop.interfaces.SimpleCallback;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeRelativeLayout;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.blued.das.profile.PersonalProfileProtos;
import com.bytedance.applog.tracker.Tracker;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.R;
import com.soft.blued.constant.EventBusConstant;
import com.soft.blued.customview.CirclePageIndicator;
import com.soft.blued.http.ChatHttpUtils;
import com.soft.blued.http.UserHttpUtils;
import com.soft.blued.log.track.EventTrackPersonalProfile;
import com.soft.blued.ui.msg.adapter.UserGiftAdapterNew;
import com.soft.blued.ui.msg.event.GiftHintEvent;
import com.soft.blued.ui.msg.event.UpdateVoucherEvent;
import com.soft.blued.ui.msg.model.GiftVoucherModel;
import com.soft.blued.ui.msg.pop.BirthCardPop;
import com.soft.blued.ui.msg.pop.GiftVoucherPop;
import com.soft.blued.ui.msg.pop.NormalPayTypeChoosePop;
import com.soft.blued.ui.msg.pop.UserGiftDialogFragment;
import com.soft.blued.ui.msg.presenter.UserGiftPresenter;
import com.soft.blued.ui.user.fragment.PayPreOrderFragment;
import com.soft.blued.ui.user.model.GiftGivingOptionForJsonParse;
import com.soft.blued.ui.user.model.GoodsOptionBasic;
import com.soft.blued.ui.user.observer.VIPBuyResultObserver;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.PopMenuUtils;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/fragment/UserGiftFragment.class */
public class UserGiftFragment extends BasePagerGridFragment<UserGiftPresenter, UserGiftAdapterNew, GiftGivingOptionForJsonParse> implements View.OnClickListener, VIPBuyResultObserver.IVIPBuyResultObserver {
    public static final String g = UserGiftFragment.class.getSimpleName();
    public static String k;
    @BindView
    public CirclePageIndicator circlePageIndicator;
    @BindView
    public ViewPager gift_pager;
    private UserGiftDialogFragment l;
    @BindView
    public LinearLayout ll_stock_tip;
    private String m;
    private UserGiftDialogFragment.BuySucceedListener n;
    private String o;
    private String p;
    private int q;
    private boolean r;
    @BindView
    public ShapeRelativeLayout rl_pay_type;
    @BindView
    public ShapeRelativeLayout rl_voucher;
    private boolean s;
    @BindView
    public TextView stv_buy;
    private List<GiftVoucherModel> t;
    @BindView
    public TextView tv_pay_title;
    @BindView
    public TextView tv_pay_type;
    @BindView
    public TextView tv_voucher;
    @BindView
    public TextView tv_voucher_title;
    private VoucherComparator u;
    @BindView
    public View voucher_line;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/fragment/UserGiftFragment$VoucherComparator.class */
    public static class VoucherComparator implements Comparator<GiftVoucherModel> {

        /* renamed from: a  reason: collision with root package name */
        public GiftGivingOptionForJsonParse f18696a;

        private VoucherComparator() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(GiftVoucherModel giftVoucherModel, GiftVoucherModel giftVoucherModel2) {
            if (giftVoucherModel == null && giftVoucherModel2 == null) {
                return 0;
            }
            if (giftVoucherModel == null) {
                return -1;
            }
            if (giftVoucherModel2 == null) {
                return 1;
            }
            if (!giftVoucherModel.isExpire || giftVoucherModel2.isExpire) {
                if (giftVoucherModel.isExpire || !giftVoucherModel2.isExpire) {
                    if (this.f18696a != null) {
                        if (giftVoucherModel.money >= this.f18696a.money && giftVoucherModel2.money < this.f18696a.money) {
                            return -1;
                        }
                        if (giftVoucherModel.money < this.f18696a.money && giftVoucherModel2.money >= this.f18696a.money) {
                            return 1;
                        }
                    }
                    if (giftVoucherModel.money > giftVoucherModel2.money) {
                        return 1;
                    }
                    if (giftVoucherModel.money < giftVoucherModel2.money) {
                        return -1;
                    }
                    if (giftVoucherModel.start_timestamp > giftVoucherModel2.start_timestamp) {
                        return 1;
                    }
                    return giftVoucherModel.start_timestamp < giftVoucherModel2.start_timestamp ? -1 : 0;
                }
                return -1;
            }
            return 1;
        }
    }

    public UserGiftFragment() {
        this.m = "";
        this.q = 2;
        this.u = new VoucherComparator();
    }

    public UserGiftFragment(List<GiftGivingOptionForJsonParse> list, String str, String str2, int i, String str3, UserGiftDialogFragment.BuySucceedListener buySucceedListener, UserGiftDialogFragment userGiftDialogFragment) {
        this.m = "";
        this.q = 2;
        this.u = new VoucherComparator();
        this.f18641a = list;
        this.o = str;
        this.p = str2;
        this.n = buySucceedListener;
        this.l = userGiftDialogFragment;
        this.q = i;
        this.m = str3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
        this.rl_voucher.setVisibility(0);
        this.voucher_line.setVisibility(0);
    }

    private void B() {
        if (this.f == 0) {
            return;
        }
        try {
            ((GiftGivingOptionForJsonParse) this.f).id = Integer.valueOf(((GiftGivingOptionForJsonParse) this.f).gift_id).intValue();
        } catch (Throwable th) {
        }
        NormalPayTypeChoosePop.a(getContext(), new NormalPayTypeChoosePop.iChoosePayResultListener() { // from class: com.soft.blued.ui.msg.fragment.UserGiftFragment.4
            @Override // com.soft.blued.ui.msg.pop.NormalPayTypeChoosePop.iChoosePayResultListener
            public void a() {
            }

            @Override // com.soft.blued.ui.msg.pop.NormalPayTypeChoosePop.iChoosePayResultListener
            public void a(int i, boolean z) {
                UserGiftFragment.this.q = i;
                UserGiftFragment.this.b(true);
            }
        }, this.q, ((GiftGivingOptionForJsonParse) this.f).id, getFragmentActive());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C() {
        if (this.f == 0) {
            return;
        }
        try {
            ((GiftGivingOptionForJsonParse) this.f).id = Integer.valueOf(((GiftGivingOptionForJsonParse) this.f).gift_id).intValue();
        } catch (Throwable th) {
        }
        if (((GiftGivingOptionForJsonParse) this.f).type == 3 && ((GiftGivingOptionForJsonParse) this.f).extra_info != null && TextUtils.isEmpty(((GiftGivingOptionForJsonParse) this.f).extra_info.text)) {
            ((GiftGivingOptionForJsonParse) this.f).extra_info.to = this.m;
            ((GiftGivingOptionForJsonParse) this.f).extra_info.from = UserInfo.getInstance().getLoginUserInfo().name;
            final BirthCardPop birthCardPop = new BirthCardPop(getContext(), (GiftGivingOptionForJsonParse) this.f, true, false);
            birthCardPop.f18768c = getFragmentActive();
            new XPopup.Builder(getContext()).f(false).a(new SimpleCallback() { // from class: com.soft.blued.ui.msg.fragment.UserGiftFragment.5
                public boolean f(BasePopupView basePopupView) {
                    birthCardPop.c();
                    return true;
                }
            }).a(birthCardPop).h();
        } else if (((GiftGivingOptionForJsonParse) this.f).is_stock == 1) {
            D();
        } else if (((GiftGivingOptionForJsonParse) this.f).is_free == 2 || ((GiftGivingOptionForJsonParse) this.f).currentVoucher != null) {
            E();
        } else {
            if (((GiftGivingOptionForJsonParse) this.f).type == -1) {
                k = ((GiftGivingOptionForJsonParse) this.f).icon;
            }
            PayPreOrderFragment.a(getContext(), (GoodsOptionBasic) this.f, null, this.o, null, null, this.p, this.q, 0, getFragmentActive());
        }
    }

    private void D() {
        UserHttpUtils.b(new BluedUIHttpResponse(getFragmentActive()) { // from class: com.soft.blued.ui.msg.fragment.UserGiftFragment.6
            public boolean onUIFailure(int i, String str) {
                return super.onUIFailure(i, str);
            }

            public void onUIFinish(boolean z) {
                super.onUIFinish(z);
                if (z) {
                    ((GiftGivingOptionForJsonParse) UserGiftFragment.this.f).is_stock = 0;
                    UserGiftFragment userGiftFragment = UserGiftFragment.this;
                    userGiftFragment.a((UserGiftFragment) ((GiftGivingOptionForJsonParse) userGiftFragment.f));
                    UserGiftFragment.this.z();
                    if (UserGiftFragment.this.n != null) {
                        if (UserGiftFragment.this.getContext() != null) {
                            ToastUtils.a(UserGiftFragment.this.getContext().getString(R.string.given_gift_buy_success));
                        }
                        UserGiftFragment.this.n.a(UserGiftFragment.this.l, (GiftGivingOptionForJsonParse) UserGiftFragment.this.f);
                    }
                }
            }

            public void onUIUpdate(BluedEntity bluedEntity) {
            }
        }, this.o, ((GiftGivingOptionForJsonParse) this.f).gift_id, this.p, (String) null, (IRequestHost) getFragmentActive());
    }

    private void E() {
        UserHttpUtils.a(new BluedUIHttpResponse(getFragmentActive()) { // from class: com.soft.blued.ui.msg.fragment.UserGiftFragment.7
            public boolean onUIFailure(int i, String str) {
                return super.onUIFailure(i, str);
            }

            public void onUIFinish(boolean z) {
                super.onUIFinish(z);
                if (z) {
                    if (((GiftGivingOptionForJsonParse) UserGiftFragment.this.f).is_free == 2) {
                        ((GiftGivingOptionForJsonParse) UserGiftFragment.this.f).is_free = 1;
                        UserGiftFragment userGiftFragment = UserGiftFragment.this;
                        userGiftFragment.a((UserGiftFragment) ((GiftGivingOptionForJsonParse) userGiftFragment.f));
                    }
                    if (((GiftGivingOptionForJsonParse) UserGiftFragment.this.f).currentVoucher != null) {
                        if (UserGiftFragment.this.t != null) {
                            UserGiftFragment.this.t.remove(((GiftGivingOptionForJsonParse) UserGiftFragment.this.f).currentVoucher);
                        }
                        ((GiftGivingOptionForJsonParse) UserGiftFragment.this.f).currentVoucher = null;
                        if (UserGiftFragment.this.t != null && UserGiftFragment.this.t.size() > 0) {
                            UserGiftFragment.this.y();
                        }
                    }
                    if (UserGiftFragment.this.n != null) {
                        if (UserGiftFragment.this.getContext() != null) {
                            ToastUtils.a(UserGiftFragment.this.getContext().getString(R.string.given_gift_buy_success));
                        }
                        UserGiftFragment.this.n.a(UserGiftFragment.this.l, (GiftGivingOptionForJsonParse) UserGiftFragment.this.f);
                    }
                }
            }

            public void onUIUpdate(BluedEntity bluedEntity) {
            }
        }, this.o, ((GiftGivingOptionForJsonParse) this.f).gift_id, this.p, ((GiftGivingOptionForJsonParse) this.f).is_free == 2 ? null : ((GiftGivingOptionForJsonParse) this.f).currentVoucher, (IRequestHost) getFragmentActive());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        if (getContext() == null) {
            return;
        }
        int i = this.q;
        if (i == 1) {
            this.tv_pay_type.setText(getContext().getString(2131886386));
        } else if (i == 2) {
            this.tv_pay_type.setText(getContext().getString(R.string.pay_type_wechat));
        } else if (i == 3) {
            this.tv_pay_type.setText(getContext().getString(R.string.pay_type_beans));
        } else if (i == 4) {
            this.tv_pay_type.setText(getContext().getString(R.string.pay_platform_huabei));
        }
        for (A a2 : this.f18642c) {
            a2.f18506a = this.q;
            if (z) {
                a2.notifyDataSetChanged();
            }
        }
        if (z) {
            BluedPreferences.r(this.q);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void v() {
        LiveEventBus.get(EventBusConstant.KEY_EVENT_UPDATE_VOUCHER, UpdateVoucherEvent.class).observe(this, new Observer<UpdateVoucherEvent>() { // from class: com.soft.blued.ui.msg.fragment.UserGiftFragment.1
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(UpdateVoucherEvent updateVoucherEvent) {
                UserGiftFragment.this.a(updateVoucherEvent.f18640a, updateVoucherEvent.b);
            }
        });
        LiveEventBus.get(EventBusConstant.KEY_EVENT_GO_ON_SEND_GIFT, Void.class).observe(this, new Observer<Void>() { // from class: com.soft.blued.ui.msg.fragment.UserGiftFragment.2
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(Void r3) {
                if (UserGiftFragment.this.f == 0 || ((GiftGivingOptionForJsonParse) UserGiftFragment.this.f).extra_info == null || TextUtils.isEmpty(((GiftGivingOptionForJsonParse) UserGiftFragment.this.f).extra_info.text)) {
                    return;
                }
                UserGiftFragment.this.C();
            }
        });
    }

    private void w() {
        ChatHttpUtils.c(new BluedUIHttpResponse<BluedEntityA<GiftVoucherModel>>(getFragmentActive()) { // from class: com.soft.blued.ui.msg.fragment.UserGiftFragment.3
            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<GiftVoucherModel> bluedEntityA) {
                int i;
                if (bluedEntityA.hasData()) {
                    UserGiftFragment.this.t = bluedEntityA.data;
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 >= UserGiftFragment.this.t.size()) {
                            break;
                        }
                        if (((GiftVoucherModel) UserGiftFragment.this.t.get(i3)).status == 1) {
                            UserGiftFragment.this.t.remove(i3);
                        } else {
                            i = i3;
                            if (((GiftVoucherModel) UserGiftFragment.this.t.get(i3)).end_timestamp * 1000 < System.currentTimeMillis()) {
                                ((GiftVoucherModel) UserGiftFragment.this.t.get(i3)).isExpire = true;
                                i = i3;
                                if (System.currentTimeMillis() - (((GiftVoucherModel) UserGiftFragment.this.t.get(i3)).end_timestamp * 1000) > 259200000) {
                                    UserGiftFragment.this.t.remove(i3);
                                }
                            }
                            i2 = i + 1;
                        }
                        i = i3 - 1;
                        i2 = i + 1;
                    }
                    if (UserGiftFragment.this.t.size() > 0) {
                        UserGiftFragment.this.A();
                        if (BluedPreferences.da() == 0 || BluedPreferences.da() == 3) {
                            UserGiftFragment.this.q = 1;
                        } else {
                            UserGiftFragment.this.q = BluedPreferences.da();
                        }
                        UserGiftFragment.this.b(true);
                    }
                }
            }

            public void onUIFinish(boolean z) {
                boolean z2;
                super.onUIFinish(z);
                if (UserGiftFragment.this.f18641a == null || UserGiftFragment.this.f18641a.size() <= 0) {
                    return;
                }
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= UserGiftFragment.this.f18641a.size()) {
                        z2 = false;
                        break;
                    } else if (((GiftGivingOptionForJsonParse) UserGiftFragment.this.f18641a.get(i2)).is_default == 1) {
                        UserGiftFragment userGiftFragment = UserGiftFragment.this;
                        userGiftFragment.b((GiftGivingOptionForJsonParse) userGiftFragment.f18641a.get(i2));
                        z2 = true;
                        break;
                    } else {
                        i = i2 + 1;
                    }
                }
                if (!z2) {
                    UserGiftFragment userGiftFragment2 = UserGiftFragment.this;
                    userGiftFragment2.b((GiftGivingOptionForJsonParse) userGiftFragment2.f18641a.get(0));
                }
                UserGiftFragment.this.z();
                UserGiftFragment userGiftFragment3 = UserGiftFragment.this;
                userGiftFragment3.a((UserGiftFragment) ((GiftGivingOptionForJsonParse) userGiftFragment3.f));
            }
        }, getFragmentActive());
    }

    private boolean x() {
        List<GiftVoucherModel> list;
        if (this.f == 0 || (list = this.t) == null || list.size() == 0) {
            return false;
        }
        for (GiftVoucherModel giftVoucherModel : this.t) {
            if (giftVoucherModel.status == 0) {
                this.s = true;
            }
            giftVoucherModel.isChecked = false;
        }
        return this.s;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        int i = 2131891124;
        if (this.f == 0 || ((GiftGivingOptionForJsonParse) this.f).currentVoucher == null) {
            if (!this.s || this.r || this.t.size() <= 0) {
                this.tv_voucher.setText(getContext().getString(R.string.not_available));
                this.tv_voucher.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, BluedSkinUtils.b(getContext(), (int) R.drawable.icon_pop_gift_arrow_right_gray), (Drawable) null);
                this.tv_voucher.setTextColor(BluedSkinUtils.a(getContext(), 2131102204));
                this.tv_voucher_title.setTextColor(BluedSkinUtils.a(getContext(), 2131102204));
            } else {
                boolean z = true;
                if (!this.t.get(0).isExpire) {
                    z = this.t.get(0).money < ((double) ((GiftGivingOptionForJsonParse) this.f).money);
                }
                TextView textView = this.tv_voucher;
                Context context = getContext();
                if (z) {
                    i = 2131891120;
                }
                textView.setText(context.getString(i));
                this.tv_voucher.setTextColor(BluedSkinUtils.a(getContext(), 2131102203));
                this.tv_voucher_title.setTextColor(BluedSkinUtils.a(getContext(), 2131102203));
                this.tv_voucher.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, BluedSkinUtils.b(getContext(), (int) R.drawable.icon_user_gift_arrow), (Drawable) null);
            }
            this.tv_pay_type.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, BluedSkinUtils.b(getContext(), (int) R.drawable.icon_user_gift_arrow), (Drawable) null);
            this.tv_pay_title.setTextColor(BluedSkinUtils.a(getContext(), 2131102203));
            this.tv_pay_type.setTextColor(BluedSkinUtils.a(getContext(), 2131102203));
            this.stv_buy.setText(getContext().getString(R.string.give_it_now));
        } else {
            if (this.r) {
                this.tv_voucher.setText(getContext().getString(R.string.not_selected));
                this.tv_voucher.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, BluedSkinUtils.b(getContext(), (int) R.drawable.icon_pop_gift_arrow_right_gray), (Drawable) null);
                this.tv_voucher.setTextColor(BluedSkinUtils.a(getContext(), 2131102204));
                this.tv_voucher_title.setTextColor(BluedSkinUtils.a(getContext(), 2131102204));
            } else {
                this.tv_voucher.setText(String.format(getContext().getString(R.string.voucher_selected), ((GiftGivingOptionForJsonParse) this.f).currentVoucher.title));
                this.tv_voucher.setTextColor(BluedSkinUtils.a(getContext(), 2131102203));
                this.tv_voucher_title.setTextColor(BluedSkinUtils.a(getContext(), 2131102203));
                this.tv_voucher.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, BluedSkinUtils.b(getContext(), (int) R.drawable.icon_user_gift_arrow), (Drawable) null);
                this.stv_buy.setText(getContext().getString(R.string.exchange_send));
            }
            this.tv_pay_type.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, BluedSkinUtils.b(getContext(), (int) R.drawable.icon_pop_gift_arrow_right_gray), (Drawable) null);
            this.tv_pay_title.setTextColor(BluedSkinUtils.a(getContext(), 2131102204));
            this.tv_pay_type.setTextColor(BluedSkinUtils.a(getContext(), 2131102204));
        }
        this.tv_voucher.setCompoundDrawablePadding(DensityUtils.a(getContext(), 5.0f));
        this.tv_pay_type.setCompoundDrawablePadding(DensityUtils.a(getContext(), 5.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        if (this.f18641a == null) {
            return;
        }
        this.ll_stock_tip.setVisibility(8);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f18641a.size()) {
                return;
            }
            if (((GiftGivingOptionForJsonParse) this.f18641a.get(i2)).is_stock == 1) {
                this.ll_stock_tip.setVisibility(0);
                return;
            }
            i = i2 + 1;
        }
    }

    @Override // com.soft.blued.ui.user.observer.VIPBuyResultObserver.IVIPBuyResultObserver
    public void a(int i, boolean z) {
        if (i == 1 && z) {
            postDelaySafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.msg.fragment.UserGiftFragment.8
                @Override // java.lang.Runnable
                public void run() {
                    if (UserGiftFragment.this.getFragmentActive().isActive()) {
                        CommonAlertDialog.a(UserGiftFragment.this.getContext(), "", UserGiftFragment.this.getContext().getString(R.string.msg_gift_resend), UserGiftFragment.this.getContext().getString(R.string.yes), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.msg.fragment.UserGiftFragment.8.1
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i2) {
                                Tracker.onClick(dialogInterface, i2);
                                dialogInterface.dismiss();
                                UserGiftFragment.this.C();
                            }
                        }, UserGiftFragment.this.getContext().getString(R.string.common_cancel), (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
                    }
                }
            }, 200L);
        } else if (z) {
            postDelaySafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.msg.fragment.UserGiftFragment.9
                @Override // java.lang.Runnable
                public void run() {
                    if (UserGiftFragment.this.n != null) {
                        if (UserGiftFragment.this.getContext() != null) {
                            ToastUtils.a(UserGiftFragment.this.getContext().getString(R.string.given_gift_buy_success));
                        }
                        UserGiftFragment.this.n.a(UserGiftFragment.this.l, (GiftGivingOptionForJsonParse) UserGiftFragment.this.f);
                    }
                }
            }, 300L);
        }
    }

    public void a(Bundle bundle) {
        super.a(bundle);
        if (this.f18641a != null) {
            this.circlePageIndicator.setInterval(DensityUtils.a(getContext(), 5.0f));
            this.circlePageIndicator.setPageColor(BluedSkinUtils.a(getContext(), 2131102205));
            this.circlePageIndicator.setFillColor(BluedSkinUtils.a(getContext(), 2131101304));
            a(this.gift_pager, this.circlePageIndicator);
            if (this.f18641a.size() <= b()) {
                this.circlePageIndicator.setVisibility(8);
            }
            ShapeHelper.b(this.rl_pay_type, 2131102170);
            this.rl_pay_type.setOnClickListener(this);
            this.stv_buy.setOnClickListener(this);
            this.rl_voucher.setOnClickListener(this);
            b(false);
            v();
            VIPBuyResultObserver.a().a(this);
            w();
            UserGiftDialogFragment userGiftDialogFragment = this.l;
            if (userGiftDialogFragment == null || userGiftDialogFragment.h() == null) {
                return;
            }
            this.l.h().a(this.i, 0);
        }
    }

    public void a(GiftVoucherModel giftVoucherModel, boolean z) {
        if (z) {
            ((GiftGivingOptionForJsonParse) this.f).currentVoucher = giftVoucherModel;
            y();
        } else if (((GiftGivingOptionForJsonParse) this.f).currentVoucher == null && giftVoucherModel != null) {
            giftVoucherModel.isChecked = false;
        } else if (((GiftGivingOptionForJsonParse) this.f).currentVoucher != null && giftVoucherModel == null) {
            ((GiftGivingOptionForJsonParse) this.f).currentVoucher.isChecked = true;
        } else if (((GiftGivingOptionForJsonParse) this.f).currentVoucher == null || giftVoucherModel == null || ((GiftGivingOptionForJsonParse) this.f).currentVoucher.equals(giftVoucherModel)) {
        } else {
            ((GiftGivingOptionForJsonParse) this.f).currentVoucher.isChecked = true;
            giftVoucherModel.isChecked = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.soft.blued.ui.msg.fragment.BasePagerGridFragment
    /* renamed from: a */
    public void b(GiftGivingOptionForJsonParse giftGivingOptionForJsonParse) {
        List<GiftVoucherModel> list;
        GiftHintEvent giftHintEvent = new GiftHintEvent();
        if (giftGivingOptionForJsonParse == null) {
            giftHintEvent.d = false;
            LiveEventBus.get(EventBusConstant.KEY_EVENT_GIFT_HINT).post(giftHintEvent);
            return;
        }
        super.b((UserGiftFragment) giftGivingOptionForJsonParse);
        giftHintEvent.f18635a = giftGivingOptionForJsonParse.type;
        giftHintEvent.e = giftGivingOptionForJsonParse.icon;
        if (giftGivingOptionForJsonParse.type != 1) {
            if (giftGivingOptionForJsonParse.type == 2) {
                giftHintEvent.d = true;
                int i = giftGivingOptionForJsonParse.seconds / 3600;
                String string = getContext().getString(R.string.user_gift_top_hint);
                giftHintEvent.b = String.format(string, i + "");
            } else if (giftGivingOptionForJsonParse.type == 3) {
                giftHintEvent.d = true;
                giftHintEvent.b = getString(R.string.msg_gift_card_hint);
            } else if (giftGivingOptionForJsonParse.type == -1) {
                giftHintEvent.d = true;
                if (giftGivingOptionForJsonParse.rules != null && giftGivingOptionForJsonParse.rules.size() > 0) {
                    StringBuilder sb = new StringBuilder();
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 >= giftGivingOptionForJsonParse.rules.size()) {
                            break;
                        }
                        sb.append(giftGivingOptionForJsonParse.rules.get(i3) + "\n");
                        i2 = i3 + 1;
                    }
                    giftHintEvent.b = sb.toString();
                    giftHintEvent.f18636c = giftGivingOptionForJsonParse.rules_title;
                }
            }
        }
        UserGiftDialogFragment userGiftDialogFragment = this.l;
        if (userGiftDialogFragment != null && userGiftDialogFragment.j() == 0) {
            LiveEventBus.get(EventBusConstant.KEY_EVENT_GIFT_HINT).post(giftHintEvent);
        }
        if (giftGivingOptionForJsonParse.is_free == 2 || giftGivingOptionForJsonParse.is_stock == 1) {
            this.r = true;
        } else {
            this.r = false;
        }
        this.s = false;
        if (giftGivingOptionForJsonParse.type != -1 && (list = this.t) != null && list.size() > 0) {
            this.u.f18696a = giftGivingOptionForJsonParse;
            Collections.sort(this.t, this.u);
            if (!x() || this.t.get(0).money < giftGivingOptionForJsonParse.money) {
                giftGivingOptionForJsonParse.currentVoucher = null;
            } else {
                giftGivingOptionForJsonParse.currentVoucher = this.t.get(0);
                if (giftGivingOptionForJsonParse.currentVoucher.isExpire) {
                    giftGivingOptionForJsonParse.currentVoucher = null;
                } else {
                    giftGivingOptionForJsonParse.currentVoucher.isChecked = true;
                }
            }
        }
        y();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.soft.blued.ui.msg.fragment.BasePagerGridFragment
    /* renamed from: b */
    public UserGiftAdapterNew a(List list) {
        return new UserGiftAdapterNew(getFragmentActive(), list);
    }

    public int g() {
        return R.layout.fm_user_gift;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        int id = view.getId();
        if (id == 2131369368) {
            if (this.f == 0 || ((GiftGivingOptionForJsonParse) this.f).currentVoucher == null) {
                B();
            }
        } else if (id == 2131369438) {
            if (this.f == 0 || !this.s || this.r) {
                return;
            }
            GiftVoucherPop giftVoucherPop = new GiftVoucherPop(getContext());
            giftVoucherPop.f18793c = this.t;
            giftVoucherPop.d = ((GiftGivingOptionForJsonParse) this.f).money;
            giftVoucherPop.e = ((GiftGivingOptionForJsonParse) this.f).currentVoucher;
            new XPopup.Builder(getContext()).a(giftVoucherPop).h();
        } else if (id == 2131370354 && this.f != 0) {
            EventTrackPersonalProfile.a(PersonalProfileProtos.Event.GIFT_BUY_PAGE_BUY_BTN_CLICK, this.o, this.p.equals("user_page_gift") ? PersonalProfileProtos.GiftFrom.PERSONAL_PAGE : PersonalProfileProtos.GiftFrom.MESSAGE_PAGE, ((GiftGivingOptionForJsonParse) this.f).gift_id, false);
            if (PopMenuUtils.a(getContext())) {
                UserGiftDialogFragment userGiftDialogFragment = this.l;
                if (userGiftDialogFragment != null) {
                    userGiftDialogFragment.dismiss();
                    return;
                }
                return;
            }
            UserGiftDialogFragment userGiftDialogFragment2 = this.l;
            if (userGiftDialogFragment2 == null || !("8".equals(userGiftDialogFragment2.i()) || "4".equals(this.l.i()) || "12".equals(this.l.i()))) {
                C();
            } else {
                ToastUtils.a(getResources().getString(R.string.msg_gift_been_blacked));
            }
        }
    }

    public void onDestroy() {
        super.onDestroy();
        VIPBuyResultObserver.a().b(this);
    }
}
