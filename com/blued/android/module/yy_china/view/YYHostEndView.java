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
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.framework.utils.Logger;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.live.base.utils.LiveAlterDialog;
import com.blued.android.module.live.base.utils.LiveLogUtils;
import com.blued.android.module.yy_china.IYYRoomInfoCallback;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.fragment.YYShareAchievementDialog;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYEndInfoModel;
import com.blued.android.module.yy_china.model.YYUserInfo;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.bytedance.applog.tracker.Tracker;
import java.util.List;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYHostEndView.class */
public class YYHostEndView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private TextView f18241a;
    private TextView b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f18242c;
    private TextView d;
    private MvpFragment e;
    private ImageView f;
    private RelativeLayout g;
    private RankingView h;
    private ShapeTextView i;
    private String j;

    public YYHostEndView(Context context) {
        super(context);
        this.j = "";
        a();
    }

    public YYHostEndView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.j = "";
        a();
    }

    public YYHostEndView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.j = "";
        a();
    }

    private void a() {
        LayoutInflater.from(getContext()).inflate(R.layout.view_yy_end_layout, (ViewGroup) this, true);
        this.f = (ImageView) findViewById(R.id.iv_end_close);
        this.g = (RelativeLayout) findViewById(R.id.yy_end_title);
        this.h = (RankingView) findViewById(R.id.ranking_view);
        this.f18241a = (TextView) findViewById(R.id.tv_total_beans);
        this.b = (TextView) findViewById(R.id.tv_total_person);
        this.f18242c = (TextView) findViewById(R.id.tv_my_beans);
        this.d = (TextView) findViewById(R.id.tv_living_time);
        this.i = (ShapeTextView) findViewById(R.id.btn_to_activity_details);
        if (StatusBarHelper.a()) {
            ((LinearLayout.LayoutParams) this.g.getLayoutParams()).topMargin = StatusBarHelper.a(getContext());
        }
        this.f.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.YYHostEndView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                YYHostEndView.this.e.getActivity().finish();
            }
        });
        this.i.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.YYHostEndView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                EventTrackYY.a(ChatRoomProtos.Event.YY_CELEBRATION_ENTER_CLICK);
                YYHostEndView.this.b();
            }
        });
    }

    private void a(View view, View.OnClickListener onClickListener) {
        LiveAlterDialog.a(getContext(), view, (View.OnClickListener) null, onClickListener, true, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, String str3) {
        View dialogView = getDialogView();
        TextView textView = (TextView) dialogView.findViewById(R.id.tv_title);
        TextView textView2 = (TextView) dialogView.findViewById(R.id.tv_des);
        textView.setText(str);
        textView2.setText(str2);
        ((TextView) dialogView.findViewById(R.id.tv_ok)).setText(str3);
        a(dialogView, new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.YYHostEndView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                IYYRoomInfoCallback c2 = YYRoomInfoManager.e().c();
                if (c2 != null) {
                    c2.a(YYHostEndView.this.getContext(), c2.i(), 7);
                }
            }
        });
    }

    private void a(String str, final boolean z) {
        YYRoomHttpUtils.n(str, (BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntityA<YYEndInfoModel>>(this.e.getFragmentActive()) { // from class: com.blued.android.module.yy_china.view.YYHostEndView.3
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<YYEndInfoModel> bluedEntityA) {
                YYEndInfoModel singleData = bluedEntityA.getSingleData();
                if (singleData == null) {
                    return;
                }
                YYHostEndView.this.f18241a.setText(singleData.total_beans);
                YYHostEndView.this.f18242c.setText(singleData.received_beans);
                YYHostEndView.this.b.setText(singleData.total_user);
                YYHostEndView.this.d.setText(singleData.live_duration);
                if (z) {
                    if (TextUtils.equals("1", singleData.need_improved)) {
                        YYHostEndView.this.c();
                    } else if (TextUtils.equals("2", singleData.is_sign)) {
                        YYHostEndView yYHostEndView = YYHostEndView.this;
                        yYHostEndView.a(yYHostEndView.getResources().getString(R.string.yy_constract_invalid), YYHostEndView.this.getResources().getString(R.string.yy_constract_resign), YYHostEndView.this.getResources().getString(R.string.yy_go_sign));
                    } else if (TextUtils.equals("0", singleData.is_sign)) {
                        YYHostEndView yYHostEndView2 = YYHostEndView.this;
                        yYHostEndView2.a(yYHostEndView2.getResources().getString(R.string.yy_additional_information), YYHostEndView.this.getResources().getString(R.string.yy_additional_description), YYHostEndView.this.getResources().getString(R.string.yy_go_additional));
                    }
                }
                if (singleData.has_custom_activity == 1) {
                    EventTrackYY.a(ChatRoomProtos.Event.YY_CELEBRATION_ENTER_SHOW);
                    YYHostEndView.this.i.setVisibility(0);
                    YYHostEndView.this.b();
                } else {
                    YYHostEndView.this.i.setVisibility(8);
                }
                List<YYUserInfo> list = singleData.rank_list;
                if (list == null || list.isEmpty()) {
                    return;
                }
                if (list.size() > 0) {
                    YYHostEndView.this.h.a(list.get(0));
                }
                if (list.size() > 1) {
                    YYHostEndView.this.h.b(list.get(1));
                }
                if (list.size() > 2) {
                    YYHostEndView.this.h.c(list.get(2));
                }
            }
        }, (IRequestHost) this.e.getFragmentActive());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        YYShareAchievementDialog yYShareAchievementDialog = new YYShareAchievementDialog();
        yYShareAchievementDialog.a(this.j);
        yYShareAchievementDialog.show(this.e.getChildFragmentManager(), "share_achievement_dialog");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        View dialogView = getDialogView();
        TextView textView = (TextView) dialogView.findViewById(R.id.tv_title);
        TextView textView2 = (TextView) dialogView.findViewById(R.id.tv_des);
        textView.setText(getResources().getString(R.string.yy_additional_information));
        textView2.setText(getResources().getString(R.string.yy_additional_description));
        ((TextView) dialogView.findViewById(R.id.tv_ok)).setText(getResources().getString(R.string.yy_go_additional));
        a(dialogView, new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.YYHostEndView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                IYYRoomInfoCallback c2 = YYRoomInfoManager.e().c();
                if (c2 != null) {
                    c2.b(YYHostEndView.this.getContext());
                }
            }
        });
    }

    private View getDialogView() {
        return LayoutInflater.from(getContext()).inflate(R.layout.dialog_sign_up, (ViewGroup) null);
    }

    public void a(MvpFragment mvpFragment, String str, boolean z) {
        this.e = mvpFragment;
        this.j = str;
        setVisibility(0);
        if (TextUtils.isEmpty(str)) {
            Logger.e("end", "room_id: " + str);
            return;
        }
        LiveLogUtils.a("YYHostEndView --> leaveRoom --> 主播端 --> 显示关播页面 room_id：" + str);
        RankingView rankingView = this.h;
        if (rankingView != null) {
            rankingView.a(mvpFragment, str, true);
        }
        a(str, z);
        YYRoomInfoManager.e().x();
    }
}
