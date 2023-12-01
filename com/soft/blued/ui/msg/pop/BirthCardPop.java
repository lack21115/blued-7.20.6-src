package com.soft.blued.ui.msg.pop;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.ui.xpop.XPopup;
import com.blued.android.framework.ui.xpop.core.BasePopupView;
import com.blued.android.framework.ui.xpop.core.CenterPopupView;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.blued.das.message.MessageProtos;
import com.bytedance.applog.tracker.Tracker;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.scwang.smartrefresh.layout.util.DensityUtil;
import com.soft.blued.R;
import com.soft.blued.constant.EventBusConstant;
import com.soft.blued.log.track.EventTrackMessage;
import com.soft.blued.ui.msg.customview.BirthCardRelativeLayout;
import com.soft.blued.ui.user.model.GiftGivingOptionForJsonParse;
import com.soft.blued.utils.Logger;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/pop/BirthCardPop.class */
public class BirthCardPop extends CenterPopupView implements Observer<GiftGivingOptionForJsonParse.CardGift> {

    /* renamed from: c  reason: collision with root package name */
    public IRequestHost f32459c;
    private BirthCardRelativeLayout d;
    private GiftGivingOptionForJsonParse e;
    private boolean f;
    private TextView g;
    private TextView h;
    private TextView i;
    private boolean j;

    public BirthCardPop(Context context, GiftGivingOptionForJsonParse giftGivingOptionForJsonParse, boolean z, boolean z2) {
        super(context);
        this.e = giftGivingOptionForJsonParse;
        this.f = z;
        this.j = z2;
    }

    @Override // androidx.lifecycle.Observer
    /* renamed from: a */
    public void onChanged(GiftGivingOptionForJsonParse.CardGift cardGift) {
        GiftGivingOptionForJsonParse giftGivingOptionForJsonParse = this.e;
        if (giftGivingOptionForJsonParse == null || giftGivingOptionForJsonParse.extra_info == null) {
            return;
        }
        this.e.extra_info.from = cardGift.from;
        this.e.extra_info.to = cardGift.to;
        this.e.extra_info.text = cardGift.text;
        TextView textView = this.g;
        textView.setText("To: " + cardGift.to);
        TextView textView2 = this.h;
        textView2.setText("From:" + cardGift.from);
        this.i.setText(cardGift.text);
    }

    @Override // com.blued.android.framework.ui.xpop.core.CenterPopupView, com.blued.android.framework.ui.xpop.core.BasePopupView
    public void b() {
        super.b();
        this.d = (BirthCardRelativeLayout) findViewById(2131369264);
        GiftGivingOptionForJsonParse giftGivingOptionForJsonParse = this.e;
        if (giftGivingOptionForJsonParse == null || giftGivingOptionForJsonParse.extra_info == null) {
            return;
        }
        if (TextUtils.isEmpty(this.e.extra_info.text_background_color)) {
            this.d.setShadeColor(0);
        } else {
            try {
                this.d.setShadeColor(Color.parseColor(this.e.extra_info.text_background_color));
            } catch (Throwable th) {
            }
        }
        this.g = (TextView) findViewById(R.id.tv_to);
        this.h = (TextView) findViewById(R.id.tv_from);
        TextView textView = this.g;
        textView.setText("To: " + this.e.extra_info.to);
        TextView textView2 = this.h;
        textView2.setText("From: " + this.e.extra_info.from);
        TextView textView3 = (TextView) findViewById(2131371186);
        this.i = textView3;
        textView3.setTextColor(Color.parseColor(this.e.extra_info.text_color));
        this.i.addTextChangedListener(new TextWatcher() { // from class: com.soft.blued.ui.msg.pop.BirthCardPop.1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                BirthCardPop.this.i.postDelayed(new Runnable() { // from class: com.soft.blued.ui.msg.pop.BirthCardPop.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) BirthCardPop.this.h.getLayoutParams();
                        Logger.c("BirthCardPop", "lineCnt===" + BirthCardPop.this.i.getLineCount());
                        if (BirthCardPop.this.i.getLineCount() < 3) {
                            layoutParams.topMargin = DensityUtil.a(30.0f);
                        } else {
                            layoutParams.topMargin = DensityUtil.a(10.0f);
                        }
                        BirthCardPop.this.h.setLayoutParams(layoutParams);
                    }
                }, 50L);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
        String str = this.e.extra_info.text;
        if (TextUtils.isEmpty(this.e.extra_info.text)) {
            str = BlueAppLocal.d() ? "CN".equals(BlueAppLocal.c().getCountry().toUpperCase()) ? this.e.extra_info.text_zh_cn : this.e.extra_info.text_zh_tw : this.e.extra_info.text_en_us;
        }
        this.i.setText(str);
        this.e.extra_info.text = str;
        ImageLoader.a(this.f32459c, this.e.extra_info.background_image).a((ImageView) findViewById(2131365126));
        ImageLoader.a(this.f32459c, this.e.extra_info.after_effects).f().g(-1).a((ImageView) findViewById(R.id.iv_pre));
        TextView textView4 = (TextView) findViewById(2131372555);
        if (this.f) {
            textView4.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.pop.BirthCardPop.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    EventTrackMessage.a(MessageProtos.Event.GIFT_CARD_PAGE_SEND_CLICK, BirthCardPop.this.e.gift_id, BirthCardPop.this.j);
                    BirthCardPop.this.p();
                    LiveEventBus.get(BirthCardPop.this.j ? EventBusConstant.KEY_EVENT_GO_ON_SEND_GIFT_PACKAGE : EventBusConstant.KEY_EVENT_GO_ON_SEND_GIFT).post(null);
                }
            });
        } else {
            textView4.setVisibility(8);
        }
        TextView textView5 = (TextView) findViewById(2131371131);
        textView5.setText(getResources().getString(this.f ? 2131886885 : 2131887220));
        textView5.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.pop.BirthCardPop.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                if (BirthCardPop.this.f) {
                    EventTrackMessage.a(MessageProtos.Event.GIFT_CARD_PAGE_CANCEL_CLICK, BirthCardPop.this.e.gift_id, new boolean[0]);
                }
                BirthCardPop.this.c();
            }
        });
        TextView textView6 = (TextView) findViewById(2131371310);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) getContext()).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        if (displayMetrics.density == 2.75f) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) textView5.getLayoutParams();
            marginLayoutParams.bottomMargin = DensityUtil.a(30.0f);
            textView5.setLayoutParams(marginLayoutParams);
        }
        if (this.f) {
            textView6.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.pop.BirthCardPop.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    new XPopup.Builder(BirthCardPop.this.getContext()).e(true).a((BasePopupView) new GiftCardEditPop(BirthCardPop.this.getContext(), BirthCardPop.this.e.extra_info)).h();
                }
            });
        } else {
            textView6.setVisibility(8);
        }
    }

    public void c() {
        if (this.f) {
            CommonAlertDialog.a(getContext(), "", getResources().getString(R.string.msg_card_gift_close_hint), (String) null, new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.msg.pop.BirthCardPop.5
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    Tracker.onClick(dialogInterface, i);
                    if (BirthCardPop.this.e != null && BirthCardPop.this.e.extra_info != null) {
                        BirthCardPop.this.e.extra_info.text = null;
                    }
                    EventTrackMessage.a(MessageProtos.Event.GIFT_CARD_PAGE_CANCEL_POP_CONFIRM_CLICK, BirthCardPop.this.e.gift_id, new boolean[0]);
                    BirthCardPop.this.p();
                }
            }, (String) null, new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.msg.pop.BirthCardPop.6
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    Tracker.onClick(dialogInterface, i);
                    dialogInterface.dismiss();
                    EventTrackMessage.a(MessageProtos.Event.GIFT_CARD_PAGE_CANCEL_POP_CANCEL_CLICK, BirthCardPop.this.e.gift_id, new boolean[0]);
                }
            }, (DialogInterface.OnDismissListener) null);
        } else {
            p();
        }
    }

    @Override // com.blued.android.framework.ui.xpop.core.CenterPopupView, com.blued.android.framework.ui.xpop.core.BasePopupView
    public int getImplLayoutId() {
        return R.layout.pop_birth_card;
    }

    @Override // com.blued.android.framework.ui.xpop.core.BasePopupView
    public void u() {
        super.u();
        LiveEventBus.get(EventBusConstant.KEY_EVENT_CARD_EDIT, GiftGivingOptionForJsonParse.CardGift.class).removeObserver(this);
    }

    @Override // com.blued.android.framework.ui.xpop.core.BasePopupView
    public void w() {
        super.w();
        this.d.a();
        LiveEventBus.get(EventBusConstant.KEY_EVENT_CARD_EDIT, GiftGivingOptionForJsonParse.CardGift.class).observeForever(this);
        if (this.f) {
            return;
        }
        EventTrackMessage.a(MessageProtos.Event.GIFT_CARD_PAGE_SHOW, this.e.gift_id, new boolean[0]);
    }
}
