package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.Logger;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.utils.click.SingleClickProxy;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.fragment.YYBaseFansDialog;
import com.blued.android.module.yy_china.fragment.YYFansClubAudienceViewDialog;
import com.blued.android.module.yy_china.fragment.YYFansClubHostViewDialog;
import com.blued.android.module.yy_china.fragment.YYFansWelfareDialog;
import com.blued.android.module.yy_china.manager.YYObserverManager;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYReportModel;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.model.YYUserInfo;
import com.blued.android.module.yy_china.observer.FollowStatusObserver;
import com.blued.android.module.yy_china.utils.UserRelationshipUtils;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.bytedance.applog.tracker.Tracker;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.tencent.trtc.TRTCCloudDef;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYStudioTitleView.class */
public class YYStudioTitleView extends RelativeLayout implements View.OnClickListener, FollowStatusObserver {
    protected ShapeTextView a;
    private ImageView b;
    private ImageView c;
    private ImageView d;
    private ShapeTextView e;
    private ImageView f;
    private TextView g;
    private TextView h;
    private TextView i;
    private RelativeLayout j;
    private YYAudienceListView k;
    private YYIncomeView l;
    private BaseYYStudioFragment m;

    public YYStudioTitleView(Context context) {
        super(context);
        b();
    }

    public YYStudioTitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b();
    }

    public YYStudioTitleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b();
    }

    private boolean a(YYRoomModel yYRoomModel) {
        return (yYRoomModel == null || yYRoomModel.fans_group == null || yYRoomModel.fans_group.has_fans_group != 1) ? false : true;
    }

    private boolean a(String str) {
        return TextUtils.equals(str, "1") || TextUtils.equals(str, "3");
    }

    private void b() {
        LayoutInflater.from(getContext()).inflate(R.layout.layout_yy_studio_title, (ViewGroup) this, true);
        this.j = (RelativeLayout) findViewById(R.id.title_root_layout);
        this.a = (ShapeTextView) findViewById(R.id.tv_report);
        this.c = (ImageView) findViewById(R.id.iv_owner_pic);
        this.b = (ImageView) findViewById(R.id.iv_more);
        this.d = (ImageView) findViewById(R.id.iv_net);
        this.h = (TextView) findViewById(R.id.tv_net);
        this.g = (TextView) findViewById(R.id.tv_owner_name);
        this.e = (ShapeTextView) findViewById(R.id.tv_follow);
        this.f = (ImageView) findViewById(R.id.tv_fans_entrance);
        this.k = (YYAudienceListView) findViewById(R.id.ll_audience_layout);
        this.l = (YYIncomeView) findViewById(R.id.income_view);
        this.i = (TextView) findViewById(R.id.tv_room_id);
        ((RelativeLayout.LayoutParams) this.j.getLayoutParams()).topMargin = StatusBarHelper.a(getContext()) + DensityUtils.a(getContext(), 12.0f);
        this.g.setOnClickListener(this);
        this.b.setOnClickListener(new SingleClickProxy(this, 500L, null));
        this.e.setOnClickListener(this);
        this.c.setOnClickListener(this);
        this.a.setOnClickListener(this);
        this.f.setOnClickListener(new SingleClickProxy(this, 500L, null));
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (YYRoomInfoManager.e().y()) {
            this.a.setVisibility(8);
            this.l.setVisibility(0);
            if (TextUtils.equals(b.chat_type, "9")) {
                this.b.setImageResource(R.drawable.icon_yy_3_point);
            } else {
                this.b.setImageResource(R.drawable.icon_yy_offline);
            }
        } else {
            this.b.setImageResource(R.drawable.icon_yy_3_point);
            this.a.setVisibility(0);
            this.l.setVisibility(8);
        }
        b(b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(YYRoomModel yYRoomModel) {
        if (yYRoomModel == null) {
            return;
        }
        int i = 0;
        if (YYRoomInfoManager.e().y()) {
            this.e.setVisibility(8);
            ImageView imageView = this.f;
            if (!a(yYRoomModel)) {
                i = 8;
            }
            imageView.setVisibility(i);
        } else if (a(yYRoomModel.relationship)) {
            this.e.setVisibility(8);
            this.f.setVisibility(a(yYRoomModel) ? 0 : 8);
        } else {
            this.f.setVisibility(8);
            this.e.setVisibility(0);
            this.e.setText(UserRelationshipUtils.a(getContext(), yYRoomModel.relationship));
        }
    }

    private void c() {
        final YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null || TextUtils.equals(b.uid, YYRoomInfoManager.e().k())) {
            return;
        }
        YYRoomHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<YYUserInfo>>(this.m.getFragmentActive()) { // from class: com.blued.android.module.yy_china.view.YYStudioTitleView.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<YYUserInfo> bluedEntityA) {
                YYUserInfo yYUserInfo = bluedEntityA.data.get(0);
                b.relationship = yYUserInfo.relationship;
                YYStudioTitleView.this.b(b);
            }
        }, b.room_id, b.uid, this.m.getFragmentActive());
    }

    private boolean c(YYRoomModel yYRoomModel) {
        return (yYRoomModel == null || yYRoomModel.fans_group == null || yYRoomModel.fans_group.is_fans != 1) ? false : true;
    }

    public void a() {
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null) {
            return;
        }
        ImageLoader.a(this.m.getFragmentActive(), b.avatar).b(R.drawable.user_bg_round).a(this.c);
        b(b);
        this.e.setText(UserRelationshipUtils.a(getContext(), b.relationship));
        this.g.setText(b.room_name);
        if (TextUtils.isEmpty(b.hall_id)) {
            this.i.setVisibility(8);
        } else {
            this.i.setVisibility(0);
            TextView textView = this.i;
            textView.setText("ID：" + b.hall_id);
        }
        this.g.post(new Runnable() { // from class: com.blued.android.module.yy_china.view.YYStudioTitleView.3
            @Override // java.lang.Runnable
            public void run() {
                YYStudioTitleView.this.g.measure(0, 0);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) YYStudioTitleView.this.g.getLayoutParams();
                int measuredWidth = YYStudioTitleView.this.g.getMeasuredWidth();
                Logger.e("YYStudioTitleView", "width = " + measuredWidth);
                int a = DensityUtils.a(YYStudioTitleView.this.getContext(), 80.0f);
                Logger.e("YYStudioTitleView", "100dp = " + a);
                if (measuredWidth > a) {
                    layoutParams.width = a;
                } else {
                    layoutParams.width = measuredWidth;
                }
                YYStudioTitleView.this.g.setLayoutParams(layoutParams);
                YYStudioTitleView.this.g.setEllipsize(TextUtils.TruncateAt.MARQUEE);
                YYStudioTitleView.this.g.setMarqueeRepeatLimit(-1);
                YYStudioTitleView.this.g.setSingleLine(true);
                YYStudioTitleView.this.g.setSelected(true);
                YYStudioTitleView.this.g.setFocusable(true);
                YYStudioTitleView.this.g.setFocusableInTouchMode(true);
            }
        });
    }

    public void a(int i) {
        TextView textView = this.h;
        if (textView == null) {
            return;
        }
        textView.setText(i + "");
    }

    public void a(BaseYYStudioFragment baseYYStudioFragment) {
        this.m = baseYYStudioFragment;
        this.k.a(baseYYStudioFragment);
        this.l.a(this.m);
        LiveEventBus.get("notify_room_rename", String.class).observe(baseYYStudioFragment, new Observer<String>() { // from class: com.blued.android.module.yy_china.view.YYStudioTitleView.1
            /* renamed from: a */
            public void onChanged(String str) {
                Logger.e("YYStudioTitleView", "rename ... " + str);
                YYStudioTitleView.this.a();
            }
        });
        LiveEventBus.get("has_fans_group", String.class).observe(baseYYStudioFragment, new Observer<String>() { // from class: com.blued.android.module.yy_china.view.YYStudioTitleView.2
            /* renamed from: a */
            public void onChanged(String str) {
                Logger.e("YYStudioTitleView", "has fans ticket ... " + str);
                YYStudioTitleView.this.b(YYRoomInfoManager.e().b());
            }
        });
        a();
        c();
    }

    public void a(TRTCCloudDef.TRTCQuality tRTCQuality) {
        if (this.h == null || this.d == null) {
            return;
        }
        if (tRTCQuality.quality > 0) {
            this.h.setVisibility(0);
            this.d.setVisibility(0);
        } else {
            this.h.setVisibility(8);
            this.d.setVisibility(8);
        }
        switch (tRTCQuality.quality) {
            case 1:
            case 2:
                this.d.setImageResource(R.drawable.icon_yy_net_good);
                this.h.setTextColor(getResources().getColor(R.color.syc_12d611));
                return;
            case 3:
            case 4:
                this.d.setImageResource(R.drawable.icon_yy_net_normer);
                this.h.setTextColor(getResources().getColor(R.color.syc_ffb40e));
                return;
            case 5:
            case 6:
                this.d.setImageResource(R.drawable.icon_yy_net_bad);
                this.h.setTextColor(getResources().getColor(R.color.syc_ff5d0e));
                return;
            default:
                return;
        }
    }

    public void a(boolean z) {
        this.g.setEnabled(z);
    }

    @Override // com.blued.android.module.yy_china.observer.FollowStatusObserver
    public void a_(String str, String str2) {
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null || !TextUtils.equals(str, b.uid)) {
            return;
        }
        b.relationship = str2;
        b(b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Logger.e("observer", "YYAnchorView onAttachedToWindow ... ");
        YYObserverManager.a().a(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ChatRoomProtos.UserType userType;
        YYBaseFansDialog yYFansWelfareDialog;
        Tracker.onClick(view);
        if (view.getId() == R.id.iv_more) {
            this.m.B();
        } else if (view.getId() == R.id.tv_owner_name) {
            YYRoomModel b = YYRoomInfoManager.e().b();
            if (b != null) {
                EventTrackYY.d(ChatRoomProtos.Event.CHAT_ROOM_NAME_CHANGE_CLICK, b.room_id, b.uid);
            }
            this.m.k();
        } else if (view.getId() == R.id.tv_follow) {
            YYRoomModel b2 = YYRoomInfoManager.e().b();
            if (b2 == null) {
                return;
            }
            EventTrackYY.d(ChatRoomProtos.Event.CHAT_ROOM_FOLLOW_CLICK, b2.room_id, b2.uid);
            YYRoomInfoManager.e().b(this.m.getContext(), b2.uid, "", this.m.getFragmentActive());
        } else if (view.getId() == R.id.iv_owner_pic) {
            YYRoomModel b3 = YYRoomInfoManager.e().b();
            if (b3 == null) {
                return;
            }
            if (TextUtils.equals(b3.chat_type, "9") && YYRoomInfoManager.e().y()) {
                new YYRoomSettingDialog(this.m).show(this.m.getParentFragmentManager(), "show_setting_dialog");
                return;
            }
            BaseYYStudioFragment baseYYStudioFragment = this.m;
            String str = b3.uid;
            String str2 = b3.name;
            String str3 = b3.avatar;
            baseYYStudioFragment.a(str, str2, str3, YYRoomInfoManager.e().a.chat_anchor + "", true);
        } else if (view.getId() == R.id.tv_report) {
            YYRoomModel b4 = YYRoomInfoManager.e().b();
            if (b4 != null) {
                EventTrackYY.d(ChatRoomProtos.Event.CHAT_ROOM_REPORT_ROOM_CLICK, b4.room_id, b4.uid);
            }
            YYReportModel yYReportModel = new YYReportModel();
            yYReportModel.reportType = 1;
            LiveEventBus.get("common_report_user").post(yYReportModel);
        } else if (view.getId() == R.id.tv_fans_entrance) {
            YYRoomModel b5 = YYRoomInfoManager.e().b();
            YYUserInfo yYUserInfo = new YYUserInfo();
            if (b5 == null) {
                return;
            }
            yYUserInfo.setAvatar(b5.avatar);
            yYUserInfo.setUid(b5.uid);
            yYUserInfo.setName(b5.name);
            if (YYRoomInfoManager.e().y()) {
                userType = ChatRoomProtos.UserType.ANCHOR;
                new YYFansClubHostViewDialog(this.m, yYUserInfo).show(this.m.getParentFragmentManager(), "fans_club_dialog");
            } else if (b5 == null) {
                return;
            } else {
                if (c(b5)) {
                    userType = ChatRoomProtos.UserType.FANS_USER;
                    yYFansWelfareDialog = new YYFansClubAudienceViewDialog(this.m, yYUserInfo);
                } else {
                    userType = ChatRoomProtos.UserType.NOT_FANS;
                    yYFansWelfareDialog = new YYFansWelfareDialog(this.m, yYUserInfo);
                }
                yYFansWelfareDialog.show(this.m.getParentFragmentManager(), "fans_club_dialog");
            }
            if (b5 != null) {
                EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_FANS_ENTER_CLICK, b5.room_id, b5.uid, b5.uid, userType);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Logger.e("observer", "YYAnchorView onDetachedFromWindow ... ");
        YYObserverManager.a().b(this);
    }
}
