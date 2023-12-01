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
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.live.base.utils.LiveLogUtils;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.manager.YYObserverManager;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYEndInfoModel;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.model.YYUserInfo;
import com.blued.android.module.yy_china.observer.FollowStatusObserver;
import com.blued.android.module.yy_china.utils.UserRelationshipUtils;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.bytedance.applog.tracker.Tracker;
import java.util.List;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYOtherEndView.class */
public class YYOtherEndView extends LinearLayout implements FollowStatusObserver {

    /* renamed from: a  reason: collision with root package name */
    private MvpFragment f18347a;
    private ImageView b;

    /* renamed from: c  reason: collision with root package name */
    private RelativeLayout f18348c;
    private RankingView d;
    private ImageView e;
    private TextView f;
    private ShapeTextView g;
    private YYUserInfo h;
    private String i;
    private String j;

    public YYOtherEndView(Context context) {
        super(context);
        a();
    }

    public YYOtherEndView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public YYOtherEndView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    private void a() {
        LayoutInflater.from(getContext()).inflate(R.layout.view_yy_other_end_layout, (ViewGroup) this, true);
        this.b = (ImageView) findViewById(R.id.iv_end_close);
        this.f18348c = (RelativeLayout) findViewById(R.id.yy_end_title);
        this.d = (RankingView) findViewById(R.id.ranking_view);
        this.e = (ImageView) findViewById(R.id.img_view);
        this.f = (TextView) findViewById(R.id.tv_name_view);
        this.g = (ShapeTextView) findViewById(R.id.tv_follow_view);
        if (StatusBarHelper.a()) {
            ((LinearLayout.LayoutParams) this.f18348c.getLayoutParams()).topMargin = StatusBarHelper.a(getContext());
        }
        this.b.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.YYOtherEndView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                YYRoomInfoManager.e().x();
                YYOtherEndView.this.f18347a.getActivity().finish();
            }
        });
        this.g.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.YYOtherEndView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                if (YYOtherEndView.this.h == null) {
                    return;
                }
                if (!YYObserverManager.a().c(YYOtherEndView.this)) {
                    YYObserverManager.a().a(YYOtherEndView.this);
                }
                YYRoomInfoManager.e().b(YYOtherEndView.this.getContext(), YYOtherEndView.this.h.getUid(), "", YYOtherEndView.this.f18347a.getFragmentActive());
            }
        });
        this.e.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.YYOtherEndView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                if (YYOtherEndView.this.h == null) {
                    return;
                }
                YYRoomInfoManager.e().x();
                YYRoomInfoManager.e().c().a(YYOtherEndView.this.e.getContext(), YYOtherEndView.this.h.getUid(), YYOtherEndView.this.h.getName(), YYOtherEndView.this.h.getAvatar(), YYOtherEndView.this.h.vbadge, 2);
            }
        });
    }

    private void a(String str) {
        YYRoomHttpUtils.n(str, (BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntityA<YYEndInfoModel>>(this.f18347a.getFragmentActive()) { // from class: com.blued.android.module.yy_china.view.YYOtherEndView.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<YYEndInfoModel> bluedEntityA) {
                YYOtherEndView.this.h = bluedEntityA.getSingleData().anchor;
                if (YYOtherEndView.this.h != null) {
                    ImageLoader.a(YYOtherEndView.this.f18347a.getFragmentActive(), YYOtherEndView.this.h.getAvatar()).b(R.drawable.user_bg_round).a(YYOtherEndView.this.e);
                    YYOtherEndView.this.f.setText(YYOtherEndView.this.h.getName());
                    YYOtherEndView.this.g.setText(UserRelationshipUtils.a(YYOtherEndView.this.getContext(), YYOtherEndView.this.h.relationship));
                }
                List<YYUserInfo> list = bluedEntityA.getSingleData().rank_list;
                if (list == null || list.isEmpty()) {
                    return;
                }
                if (list.size() > 0) {
                    YYOtherEndView.this.d.a(list.get(0));
                }
                if (list.size() > 1) {
                    YYOtherEndView.this.d.b(list.get(1));
                }
                if (list.size() > 2) {
                    YYOtherEndView.this.d.c(list.get(2));
                }
            }
        }, (IRequestHost) this.f18347a.getFragmentActive());
    }

    public void a(MvpFragment mvpFragment) {
        this.f18347a = mvpFragment;
        KeyboardUtils.a(mvpFragment.getActivity());
        setVisibility(0);
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null) {
            return;
        }
        LiveLogUtils.a("YYOtherEndView --> leaveRoom --> 观众端 --> 显示关播页面 room_id：" + b.room_id);
        this.i = b.uid;
        this.j = b.room_id;
        ImageLoader.a(mvpFragment.getFragmentActive(), b.avatar).b(R.drawable.user_bg_round).a(this.e);
        this.f.setText(b.name);
        if (TextUtils.equals(b.relationship, "1") || TextUtils.equals(b.relationship, "3")) {
            this.g.setVisibility(4);
            this.g.setClickable(false);
        } else {
            this.g.setVisibility(0);
            this.g.setClickable(true);
            this.g.setText(UserRelationshipUtils.a(getContext(), b.relationship));
        }
        RankingView rankingView = this.d;
        if (rankingView != null) {
            rankingView.a(mvpFragment, b.room_id, false);
        }
        a(b.room_id);
        YYRoomInfoManager.e().x();
    }

    @Override // com.blued.android.module.yy_china.observer.FollowStatusObserver
    public void a_(String str, String str2) {
        if (TextUtils.equals(str, this.i)) {
            if (TextUtils.equals(str2, "1") || TextUtils.equals(str2, "3")) {
                this.g.setVisibility(4);
                this.g.setClickable(false);
                return;
            }
            this.g.setVisibility(0);
            this.g.setClickable(true);
            this.g.setText(UserRelationshipUtils.a(getContext(), str2));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        YYObserverManager.a().a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        YYObserverManager.a().b(this);
    }
}
