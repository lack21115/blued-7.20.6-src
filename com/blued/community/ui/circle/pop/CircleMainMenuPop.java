package com.blued.community.ui.circle.pop;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.blued.android.core.AppMethods;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.ui.xpop.core.BottomPopupView;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.EncryptTool;
import com.blued.android.framework.view.shape.ShapeFrameLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.blued.community.R;
import com.blued.community.auto.CommunityServiceManager;
import com.blued.community.http.CircleHttpUtils;
import com.blued.community.manager.CommunityConstants;
import com.blued.community.track.EventTrackFeed;
import com.blued.community.ui.circle.dialog.CircleDeletePostReasonDialogFragment;
import com.blued.community.ui.circle.presenter.CirclePostDetailsPresenter;
import com.blued.community.utils.UserInfoUtils;
import com.blued.das.client.feed.FeedProtos;
import com.bytedance.applog.tracker.Tracker;
import com.jeremyliao.liveeventbus.LiveEventBus;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/circle/pop/CircleMainMenuPop.class */
public class CircleMainMenuPop extends BottomPopupView implements View.OnClickListener {
    public static final String b = CircleMainMenuPop.class.getSimpleName();
    private CirclePostDetailsPresenter c;
    private TextView d;
    private TextView e;
    private TextView f;
    private TextView g;
    private ShapeTextView h;
    private ShapeFrameLayout i;
    private TextView j;
    private TextView k;

    public CircleMainMenuPop(Context context, CirclePostDetailsPresenter circlePostDetailsPresenter) {
        super(context);
        this.c = circlePostDetailsPresenter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
        CircleHttpUtils.a(this.c.n().circle_id, new BluedUIHttpResponse(this.c.g()) { // from class: com.blued.community.ui.circle.pop.CircleMainMenuPop.5
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity bluedEntity) {
                CircleMainMenuPop.this.c.n().is_muted = 1;
                if (CircleMainMenuPop.this.c.n().mute_type == 0) {
                    CircleMainMenuPop.this.c.n().mute_type = 1;
                } else if (CircleMainMenuPop.this.c.n().mute_type == 1) {
                    CircleMainMenuPop.this.c.n().mute_type = 2;
                } else if (CircleMainMenuPop.this.c.n().mute_type == 2) {
                    CircleMainMenuPop.this.c.n().mute_type = 1009;
                } else {
                    CircleMainMenuPop.this.c.n().mute_type = 1009;
                }
                AppMethods.a((CharSequence) CircleMainMenuPop.this.getResources().getString(R.string.circle_post_detail_menu_mute_success), true);
                EventTrackFeed.a(FeedProtos.Event.CIRCLE_NOTE_MANAGE_BTN_CLICK, CircleMainMenuPop.this.c.n().circle_id, CircleMainMenuPop.this.c.n().feed_id, CircleMainMenuPop.this.c.n().feed_uid, FeedProtos.OptType.OPT_FORB, EventTrackFeed.c(CircleMainMenuPop.this.c.n()), CircleMainMenuPop.this.c.n().is_anonym == 1);
            }
        }, this.c.n().feed_uid, this.c.n().is_anonym, this.c.n().user_name, this.c.n().user_avatar, this.c.g());
    }

    private void B() {
        if (this.c.n().is_top == 0) {
            CircleHttpUtils.a(new BluedUIHttpResponse(this.c.g()) { // from class: com.blued.community.ui.circle.pop.CircleMainMenuPop.6
                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                public void onUIUpdate(BluedEntity bluedEntity) {
                    CircleMainMenuPop.this.c.n().is_top = 1;
                    AppMethods.a((CharSequence) CircleMainMenuPop.this.getResources().getString(R.string.circle_post_detail_menu_top_success), true);
                    EventTrackFeed.a(FeedProtos.Event.CIRCLE_NOTE_MANAGE_BTN_CLICK, CircleMainMenuPop.this.c.n().circle_id, CircleMainMenuPop.this.c.n().feed_id, CircleMainMenuPop.this.c.n().feed_uid, FeedProtos.OptType.OPT_TOP, EventTrackFeed.c(CircleMainMenuPop.this.c.n()), CircleMainMenuPop.this.c.n().is_anonym == 1);
                }
            }, this.c.n().feed_id, this.c.g());
        } else {
            CircleHttpUtils.b(new BluedUIHttpResponse(this.c.g()) { // from class: com.blued.community.ui.circle.pop.CircleMainMenuPop.7
                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                public void onUIUpdate(BluedEntity bluedEntity) {
                    CircleMainMenuPop.this.c.n().is_top = 0;
                }
            }, this.c.n().feed_id, this.c.g());
        }
    }

    private void C() {
        p();
        CommunityServiceManager.b().a(getContext(), CommunityConstants.ReportType.CIRCLE, this.c.n().user_name, this.c.n().feed_id, (String) null);
        EventTrackFeed.a(FeedProtos.Event.CIRCLE_NOTE_MANAGE_BTN_CLICK, this.c.n().circle_id, this.c.n().feed_id, this.c.n().feed_uid, FeedProtos.OptType.OPT_REPORT, EventTrackFeed.c(this.c.n()), this.c.n().is_anonym == 1);
    }

    private boolean c() {
        return this.c.n().posting_allow_delete == 1;
    }

    private void d() {
        if (this.c.n().is_essence == 0) {
            CircleHttpUtils.c(new BluedUIHttpResponse(this.c.g()) { // from class: com.blued.community.ui.circle.pop.CircleMainMenuPop.1
                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                public void onUIUpdate(BluedEntity bluedEntity) {
                    AppMethods.a(CircleMainMenuPop.this.getResources().getText(R.string.circle_post_detail_menu_essence_success));
                    CircleMainMenuPop.this.c.n().is_essence = 1;
                    CircleMainMenuPop.this.c.e();
                }
            }, this.c.q(), this.c.g());
        } else {
            CircleHttpUtils.d(new BluedUIHttpResponse(this.c.g()) { // from class: com.blued.community.ui.circle.pop.CircleMainMenuPop.2
                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                public void onUIUpdate(BluedEntity bluedEntity) {
                    AppMethods.a(CircleMainMenuPop.this.getResources().getText(R.string.circle_post_detail_menu_set_essence_cancel));
                    CircleMainMenuPop.this.c.n().is_essence = 0;
                    CircleMainMenuPop.this.c.e();
                }
            }, this.c.q(), this.c.g());
        }
    }

    private void delete() {
        EventTrackFeed.a(FeedProtos.Event.CIRCLE_NOTE_MANAGE_BTN_CLICK, this.c.n().circle_id, this.c.n().feed_id, this.c.n().feed_uid, FeedProtos.OptType.OPT_DELETE, EventTrackFeed.c(this.c.n()), this.c.n().is_anonym == 1);
        if (TextUtils.equals(this.c.n().feed_uid, UserInfoUtils.c()) || TextUtils.equals(this.c.n().feed_uid, EncryptTool.b(UserInfoUtils.c()))) {
            CommonAlertDialog.a(getContext(), "", getResources().getString(R.string.circle_post_detail_menu_delete_hint), getResources().getString(R.string.delete), new DialogInterface.OnClickListener() { // from class: com.blued.community.ui.circle.pop.CircleMainMenuPop.8
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    Tracker.onClick(dialogInterface, i);
                    dialogInterface.dismiss();
                    CircleHttpUtils.a(CircleMainMenuPop.this.getContext(), new BluedUIHttpResponse(CircleMainMenuPop.this.c.g()) { // from class: com.blued.community.ui.circle.pop.CircleMainMenuPop.8.1
                        @Override // com.blued.android.framework.http.BluedUIHttpResponse
                        public void onUIUpdate(BluedEntity bluedEntity) {
                            CircleMainMenuPop.this.p();
                            LiveEventBus.get("circle_delete_feed").post(CircleMainMenuPop.this.c.n().feed_id);
                            AppMethods.a(R.string.circle_post_detail_menu_delete_success, true);
                        }
                    }, CircleMainMenuPop.this.c.n().feed_id, "", CircleMainMenuPop.this.c.g());
                }
            }, (String) null, (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
        } else {
            CircleDeletePostReasonDialogFragment.a.a(getContext(), this.c.n().feed_id);
        }
    }

    private void e() {
        if (this.c.n().is_muted == 1) {
            CircleHttpUtils.a(this.c.n().circle_id, new BluedUIHttpResponse(this.c.g()) { // from class: com.blued.community.ui.circle.pop.CircleMainMenuPop.3
                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                public void onUIUpdate(BluedEntity bluedEntity) {
                    CircleMainMenuPop.this.c.n().is_muted = 0;
                    if (CircleMainMenuPop.this.c.n().mute_type == 1009 || CircleMainMenuPop.this.c.n().mute_type == 1010) {
                        CircleMainMenuPop.this.c.n().mute_type = 0;
                    }
                    AppMethods.a((CharSequence) CircleMainMenuPop.this.getResources().getString(R.string.circle_post_detail_menu_mute_canceled_success));
                }
            }, this.c.n().feed_uid, this.c.n().is_anonym, this.c.g());
        } else {
            z();
        }
    }

    private void z() {
        CommonAlertDialog.a(getContext(), this.c.n().mute_type == 0 ? getResources().getString(R.string.circle_mute_member_dialog_first_title) : this.c.n().mute_type == 1 ? getResources().getString(R.string.circle_mute_member_dialog_second_title) : getResources().getString(R.string.circle_mute_member_dialog_third_title), getContext().getResources().getString(R.string.circle_mute_member_dialog_content), getContext().getResources().getString(R.string.circle_mute_member_dialog_btn), 0, new DialogInterface.OnClickListener() { // from class: com.blued.community.ui.circle.pop.CircleMainMenuPop.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Tracker.onClick(dialogInterface, i);
                CircleMainMenuPop.this.A();
            }
        }, getContext().getResources().getString(R.string.cancel), getContext().getResources().getColor(R.color.syc_A5A6B3), (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
    }

    @Override // com.blued.android.framework.ui.xpop.core.BottomPopupView, com.blued.android.framework.ui.xpop.core.BasePopupView
    public void b() {
        super.b();
        if (this.c.n() == null) {
            p();
            return;
        }
        this.d = (TextView) findViewById(R.id.tv_top);
        this.e = (TextView) findViewById(R.id.tv_mute);
        this.f = (TextView) findViewById(R.id.tv_delete);
        this.g = (TextView) findViewById(R.id.tv_report);
        this.h = (ShapeTextView) findViewById(R.id.tv_report_bottom);
        this.i = (ShapeFrameLayout) findViewById(R.id.fm_manager);
        this.j = (TextView) findViewById(R.id.tv_cancel);
        this.k = (TextView) findViewById(R.id.tv_essence);
        this.d.setOnClickListener(this);
        this.e.setOnClickListener(this);
        this.f.setOnClickListener(this);
        this.g.setOnClickListener(this);
        this.h.setOnClickListener(this);
        this.j.setOnClickListener(this);
        this.k.setOnClickListener(this);
        if (this.c.n().is_top == 1) {
            this.d.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getResources().getDrawable(R.drawable.icon_circle_menu_top2), (Drawable) null, (Drawable) null);
            this.d.setCompoundDrawablePadding(DensityUtils.a(getContext(), 11.5f));
            this.d.setText(getResources().getString(R.string.circle_post_detail_menu_top_cancel));
        }
        if (this.c.n().is_muted == 1) {
            this.e.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getResources().getDrawable(R.drawable.icon_circle_menu_muted), (Drawable) null, (Drawable) null);
            this.e.setCompoundDrawablePadding(DensityUtils.a(getContext(), 11.5f));
            this.e.setText(getResources().getString(R.string.circle_post_detail_menu_mute_cancel));
        }
        if (this.c.n().is_essence == 1) {
            this.k.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getResources().getDrawable(R.drawable.icon_circle_menu_essence2), (Drawable) null, (Drawable) null);
            this.k.setCompoundDrawablePadding(DensityUtils.a(getContext(), 11.5f));
            this.k.setText(getResources().getString(R.string.circle_post_detail_menu_set_essence_cancel));
        }
        if (this.c.n().isOwner() || this.c.n().isManager()) {
            this.h.setVisibility(8);
            this.i.setVisibility(0);
            if (!this.c.n().isManager() || c()) {
                return;
            }
            this.f.setVisibility(8);
            return;
        }
        this.h.setVisibility(0);
        this.i.setVisibility(8);
        if (c()) {
            this.h.setText(getResources().getString(R.string.delete));
        } else {
            this.h.setText(getResources().getString(R.string.report));
        }
    }

    @Override // com.blued.android.framework.ui.xpop.core.BottomPopupView, com.blued.android.framework.ui.xpop.core.BasePopupView
    public int getImplLayoutId() {
        return R.layout.pop_circle_main_menu;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        int id = view.getId();
        if (id == R.id.tv_top) {
            p();
            B();
        } else if (id == R.id.tv_mute) {
            p();
            e();
        } else if (id == R.id.tv_cancel) {
            p();
            EventTrackFeed.a(FeedProtos.Event.CIRCLE_NOTE_MANAGE_BTN_CLICK, this.c.n().circle_id, this.c.n().feed_id, this.c.n().feed_uid, FeedProtos.OptType.OPT_CANCEL, EventTrackFeed.c(this.c.n()), this.c.n().is_anonym == 1);
        } else if (id == R.id.tv_report || id == R.id.tv_report_bottom) {
            if (this.c.n().isOwner() || this.c.n().isManager() || !c()) {
                C();
            } else {
                delete();
            }
        } else if (id == R.id.tv_delete) {
            delete();
        } else if (id == R.id.tv_essence) {
            d();
            p();
        }
    }

    @Override // com.blued.android.framework.ui.xpop.core.BasePopupView
    public void w() {
        super.w();
        EventTrackFeed.g(FeedProtos.Event.CIRCLE_NOTE_MANAGE_SHOW, this.c.n().circle_id, this.c.n().feed_id);
    }
}
