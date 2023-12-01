package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.anythink.core.api.ATAdConst;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.ClickUtils;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.SharedPreferencesUtils;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.utils.NinePatchUtils;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.fragment.YYPackGiftDialog;
import com.blued.android.module.yy_china.fragment.YYRoomPKFragmentNew;
import com.blued.android.module.yy_china.fragment.YYWebViewDialogFragment;
import com.blued.android.module.yy_china.manager.YYObserverManager;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.ToolMode;
import com.blued.android.module.yy_china.model.ToolkitItemMode;
import com.blued.android.module.yy_china.model.ToolkitMode;
import com.blued.android.module.yy_china.model.YYButtonConfigModel;
import com.blued.android.module.yy_china.model.YYExtoolBoxModel;
import com.blued.android.module.yy_china.model.YYExtraBubbleModel;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.model.YYUserInfo;
import com.blued.android.module.yy_china.observer.RoleStatusObserver;
import com.blued.android.module.yy_china.trtc_audio.manager.AudioChannelManager;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.blued.android.module.yy_china.utils.YYRoomPreferences;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.android.module.yy_china.view.YYToolBoxView;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.bytedance.applog.tracker.Tracker;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.scwang.smartrefresh.layout.util.DensityUtil;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYBottomView.class */
public class YYBottomView extends LinearLayout implements View.OnClickListener, RoleStatusObserver {
    private BaseYYStudioFragment a;
    private ShapeTextView b;
    private ImageView c;
    private ImageView d;
    private ImageView e;
    private ImageView f;
    private ImageView g;
    private ImageView h;
    private FrameLayout i;
    private ShapeTextView j;
    private ShapeTextView k;
    private YYMicrophoneView l;
    private FrameLayout m;
    private FrameLayout n;
    private FrameLayout o;
    private YYWaittingView p;
    private TextView q;
    private NinePatchTextView r;
    private NinePatchTextView s;
    private Observer<String> t;
    private ArrayList<String> u;
    private YYExtraBubbleModel v;
    private YYButtonConfigModel w;

    public YYBottomView(Context context) {
        super(context);
        this.t = new Observer<String>() { // from class: com.blued.android.module.yy_china.view.YYBottomView.1
            /* renamed from: a */
            public void onChanged(String str) {
                if (YYRoomInfoManager.e().b() != null) {
                    YYBottomView.this.n.removeAllViews();
                    YYBottomView.this.o.removeAllViews();
                    YYBottomView yYBottomView = YYBottomView.this;
                    yYBottomView.a(yYBottomView.a, false);
                }
            }
        };
        this.u = new ArrayList<>();
        this.v = null;
        this.w = null;
        c();
    }

    public YYBottomView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.t = new Observer<String>() { // from class: com.blued.android.module.yy_china.view.YYBottomView.1
            /* renamed from: a */
            public void onChanged(String str) {
                if (YYRoomInfoManager.e().b() != null) {
                    YYBottomView.this.n.removeAllViews();
                    YYBottomView.this.o.removeAllViews();
                    YYBottomView yYBottomView = YYBottomView.this;
                    yYBottomView.a(yYBottomView.a, false);
                }
            }
        };
        this.u = new ArrayList<>();
        this.v = null;
        this.w = null;
        c();
    }

    public YYBottomView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.t = new Observer<String>() { // from class: com.blued.android.module.yy_china.view.YYBottomView.1
            /* renamed from: a */
            public void onChanged(String str) {
                if (YYRoomInfoManager.e().b() != null) {
                    YYBottomView.this.n.removeAllViews();
                    YYBottomView.this.o.removeAllViews();
                    YYBottomView yYBottomView = YYBottomView.this;
                    yYBottomView.a(yYBottomView.a, false);
                }
            }
        };
        this.u = new ArrayList<>();
        this.v = null;
        this.w = null;
        c();
    }

    private void a(View view) {
        if (view == null || view.getParent() == null || !(view.getParent() instanceof ViewGroup)) {
            return;
        }
        ((ViewGroup) view.getParent()).removeView(view);
    }

    private void a(final View view, final View view2, final ViewGroup viewGroup, final float f) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        view.measure(makeMeasureSpec, makeMeasureSpec2);
        view2.measure(makeMeasureSpec, makeMeasureSpec2);
        final int measuredWidth = view.getMeasuredWidth();
        final int measuredWidth2 = view2.getMeasuredWidth();
        post(new Runnable() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYBottomView$k5ZaU4drGbfBc7oLVlBBn2fuFQ8
            @Override // java.lang.Runnable
            public final void run() {
                YYBottomView.this.a(viewGroup, view2, measuredWidth2, measuredWidth, f, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(ViewGroup viewGroup, View view, int i, int i2, float f, View view2) {
        int[] iArr = new int[2];
        if (this.l == null || viewGroup == null) {
            return;
        }
        view.getLocationOnScreen(iArr);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = DensityUtil.a(50.0f);
        layoutParams.leftMargin = (int) (iArr[0] + ((i - i2) * f));
        layoutParams.gravity = 80;
        viewGroup.addView(view2, layoutParams);
    }

    private void a(FrameLayout frameLayout, boolean z, int i, String str) {
        YYRoomModel b;
        if (z || (b = YYRoomInfoManager.e().b()) == null || !TextUtils.equals(b.chat_type, ATAdConst.ATDevFrameworkType.FLUTTER)) {
            return;
        }
        if (YYRoomInfoManager.e().j() || YYRoomInfoManager.e().y()) {
            YYRoomPreferences.a(false);
            this.m = frameLayout;
            NinePatchTextView ninePatchTextView = new NinePatchTextView(getContext());
            this.s = ninePatchTextView;
            ninePatchTextView.setText(str);
            this.s.setTextSize(14.0f);
            this.s.setGravity(1);
            this.s.setPadding(DensityUtils.a(getContext(), 15.0f), DensityUtils.a(getContext(), 8.0f), DensityUtils.a(getContext(), 15.0f), 0);
            this.s.setTextColor(getResources().getColor(R.color.syc_EAEAEA));
            this.s.a(R.drawable.guide_blue_bubble_down, NinePatchUtils.GuideArrowPosition.CENTER);
            a((View) this.s, this.f, (ViewGroup) frameLayout, 0.5f);
            postDelayed(new Runnable() { // from class: com.blued.android.module.yy_china.view.YYBottomView.4
                @Override // java.lang.Runnable
                public void run() {
                    YYBottomView.this.j();
                }
            }, 5000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(ToolMode toolMode) {
        if (toolMode.getRed_dot() > 0) {
            SharedPreferences b = SharedPreferencesUtils.b();
            StringBuilder sb = new StringBuilder();
            sb.append("TOOL_BOX_ITEM_RED");
            sb.append(toolMode.getName());
            sb.append(toolMode.getType());
            sb.append(YYRoomInfoManager.e().k());
            return b.getInt(sb.toString(), 0) <= 0;
        }
        return false;
    }

    private void b(int i) {
        YYRoomModel b;
        if (this.a == null || (b = YYRoomInfoManager.e().b()) == null) {
            return;
        }
        YYRoomHttpUtils.d(b.room_id, (BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntity<ToolkitMode, YYExtoolBoxModel>>(this.a.getFragmentActive()) { // from class: com.blued.android.module.yy_china.view.YYBottomView.3
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<ToolkitMode, YYExtoolBoxModel> bluedEntity) {
                if (bluedEntity == null || !bluedEntity.hasData()) {
                    return;
                }
                ToolkitMode singleData = bluedEntity.getSingleData();
                ToolkitItemMode fun_modes = singleData.getFun_modes();
                if (fun_modes != null && fun_modes.getItems() != null) {
                    Iterator<ToolMode> it = singleData.getFun_modes().getItems().iterator();
                    while (it.hasNext()) {
                        ToolMode next = it.next();
                        if (YYBottomView.this.a(next)) {
                            YYBottomView.this.u.add(next.getType());
                        }
                    }
                }
                ToolkitItemMode tools = singleData.getTools();
                if (tools != null && tools.getItems() != null) {
                    Iterator<ToolMode> it2 = singleData.getTools().getItems().iterator();
                    while (it2.hasNext()) {
                        ToolMode next2 = it2.next();
                        if (YYBottomView.this.a(next2)) {
                            YYBottomView.this.u.add(next2.getType());
                        }
                    }
                }
                YYExtoolBoxModel yYExtoolBoxModel = bluedEntity.extra;
                if (yYExtoolBoxModel != null && !YYBottomView.this.a.F) {
                    YYBottomView.this.v = yYExtoolBoxModel.getBubble_message();
                }
                YYBottomView.this.i();
            }
        }, (IRequestHost) this.a.getFragmentActive());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(ToolMode toolMode) {
        if (this.u.contains(toolMode.getType())) {
            this.u.remove(toolMode.getType());
        }
        if (TextUtils.equals(toolMode.getType(), "14") && this.v != null) {
            SharedPreferences.Editor edit = SharedPreferencesUtils.b().edit();
            edit.putInt("IS_kTV_STAGE_BUBBLE_" + YYRoomInfoManager.e().k(), this.v.id).apply();
        }
        i();
    }

    private void c() {
        LayoutInflater.from(getContext()).inflate(R.layout.view_yy_bottom_menu_layout, (ViewGroup) this, true);
        this.b = (ShapeTextView) findViewById(R.id.tv_chat);
        this.c = (ImageView) findViewById(R.id.iv_pulbic_message);
        this.d = (ImageView) findViewById(R.id.iv_gift);
        this.e = (ImageView) findViewById(R.id.iv_recharge);
        this.f = (ImageView) findViewById(R.id.iv_tool_box);
        this.n = (FrameLayout) findViewById(R.id.fl_last_view);
        this.o = (FrameLayout) findViewById(R.id.fl_first_view);
        this.q = (TextView) findViewById(R.id.img_red_dot);
        this.k = (ShapeTextView) findViewById(R.id.tv_gift_time);
        this.h = (ImageView) findViewById(R.id.iv_room_pk);
        this.i = (FrameLayout) findViewById(R.id.ll_room_pk);
        this.j = (ShapeTextView) findViewById(R.id.img_pk_dot);
        this.l = new YYMicrophoneView(getContext());
        this.b.setOnClickListener(this);
        this.c.setOnClickListener(this);
        this.d.setOnClickListener(this);
        this.e.setOnClickListener(this);
        this.f.setOnClickListener(this);
        this.i.setOnClickListener(this);
    }

    private void d() {
        this.n.addView(this.p);
        this.n.setVisibility(0);
        this.o.setVisibility(0);
        this.c.setVisibility(0);
        this.b.setVisibility(8);
        this.o.addView(this.l);
    }

    private void e() {
        this.o.setVisibility(8);
        this.c.setVisibility(8);
        this.b.setVisibility(0);
        this.n.addView(this.l);
    }

    private void f() {
        int action_type = this.w.getAction_type();
        if (action_type != 1) {
            if (action_type != 2) {
                YYRoomInfoManager.e().c().a(getContext(), this.w.getLink_url(), 0);
            } else {
                YYRoomPKFragmentNew.b.a().show(this.a.getParentFragmentManager(), "pk_dialog");
            }
        } else if (YYRoomInfoManager.e().b() == null) {
        } else {
            YYWebViewDialogFragment yYWebViewDialogFragment = new YYWebViewDialogFragment();
            yYWebViewDialogFragment.a(this.a, this.w.getLink_url());
            yYWebViewDialogFragment.show(this.a.getParentFragmentManager(), "inner_web_dialog");
        }
    }

    private void g() {
        this.q.setVisibility(8);
        YYToolBoxView yYToolBoxView = new YYToolBoxView(getContext());
        yYToolBoxView.a(this.a, new YYToolBoxView.OnItemCLickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYBottomView$DKsz-GDfwcrUG0KE5Z0RfwSrrkA
            @Override // com.blued.android.module.yy_china.view.YYToolBoxView.OnItemCLickListener
            public final void onItemClick(ToolMode toolMode) {
                YYBottomView.this.b(toolMode);
            }
        });
        this.a.a(yYToolBoxView, -2);
    }

    private void getButtonConfig() {
        final YYRoomModel b;
        if (this.a == null || (b = YYRoomInfoManager.e().b()) == null) {
            return;
        }
        YYRoomHttpUtils.x(b.room_id, (BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntityA<YYButtonConfigModel>>(this.a.getFragmentActive()) { // from class: com.blued.android.module.yy_china.view.YYBottomView.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<YYButtonConfigModel> bluedEntityA) {
                int i = 8;
                if (bluedEntityA == null || !bluedEntityA.hasData()) {
                    YYBottomView.this.i.setVisibility(8);
                    return;
                }
                YYBottomView.this.w = bluedEntityA.getSingleData();
                if (YYBottomView.this.w.getStatus() == 1) {
                    YYBottomView.this.i.setVisibility(0);
                    EventTrackYY.j(ChatRoomProtos.Event.YY_RES_SHOW, b.room_id, b.uid, YYBottomView.this.w.getAction_type() + "", YYBottomView.this.w.getLink_url());
                } else {
                    YYBottomView.this.i.setVisibility(8);
                }
                ImageLoader.a(YYBottomView.this.a.getFragmentActive(), YYBottomView.this.w.getIcon()).b(R.drawable.icon_exploration_entrance).a(YYBottomView.this.h);
                boolean z = SharedPreferencesUtils.b().getBoolean(YYBottomView.this.w.getIcon(), false);
                ShapeTextView shapeTextView = YYBottomView.this.j;
                if (!z) {
                    i = 0;
                }
                shapeTextView.setVisibility(i);
            }
        }, this.a.getFragmentActive());
    }

    private void h() {
        a(this.g);
        this.g = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        int i = 0;
        int i2 = SharedPreferencesUtils.b().getInt("IS_kTV_STAGE_BUBBLE_" + YYRoomInfoManager.e().k(), 0);
        YYExtraBubbleModel yYExtraBubbleModel = this.v;
        if (yYExtraBubbleModel != null && yYExtraBubbleModel.id != i2 && !this.v.showed) {
            this.q.setVisibility(8);
            a((FrameLayout) this.a.c.findViewById(R.id.fra_add_view_layout), this.a.F, this.v.id, this.v.contents);
            return;
        }
        TextView textView = this.q;
        if (this.u.isEmpty()) {
            i = 8;
        }
        textView.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        YYExtraBubbleModel yYExtraBubbleModel = this.v;
        if (yYExtraBubbleModel != null) {
            if (this.u.contains(Integer.valueOf(yYExtraBubbleModel.id))) {
                this.u.remove(this.v.id);
            }
            this.v.showed = true;
        }
        a((View) this.s);
        this.s = null;
        i();
    }

    public void a() {
        this.k.setVisibility(8);
        this.d.setImageResource(R.drawable.icon_yy_recharge_gift);
    }

    @Override // com.blued.android.module.yy_china.observer.RoleStatusObserver
    public void a(int i) {
        YYMicrophoneView yYMicrophoneView = this.l;
        if (yYMicrophoneView != null) {
            yYMicrophoneView.b(i);
        }
    }

    public void a(long j) {
        ShapeTextView shapeTextView = this.k;
        if (shapeTextView == null) {
            return;
        }
        if (j < 0) {
            shapeTextView.setVisibility(8);
            return;
        }
        this.d.setImageResource(R.drawable.icon_gift);
        this.k.setVisibility(0);
        ShapeTextView shapeTextView2 = this.k;
        shapeTextView2.setText(j + "s");
    }

    public void a(FrameLayout frameLayout, boolean z) {
        if (this.e == null || frameLayout == null || this.s != null || YYRoomInfoManager.e().b() == null || this.r != null || YYRoomInfoManager.e().b().yyPerFirstGiftModel == null || YYRoomInfoManager.e().b().yyPerFirstGiftModel.getType() == 0 || YYRoomInfoManager.e().b().yyPerFirstGiftModel.isClick) {
            return;
        }
        long type = YYRoomInfoManager.e().b().yyPerFirstGiftModel.getType();
        int i = (type > 1L ? 1 : (type == 1L ? 0 : -1));
        if (i != 0 && type == 2 && new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Long.valueOf(System.currentTimeMillis())).equals(SharedPreferencesUtils.b().getString("yy_FirstRechargeNotie", ""))) {
            return;
        }
        this.m = frameLayout;
        ImageView imageView = new ImageView(getContext());
        this.g = imageView;
        imageView.setImageResource(i == 0 ? R.drawable.notic_yy_first_recharge : R.drawable.notic_yy_back_recharge);
        a(this.g, this.e, frameLayout, 0.5f);
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null || z) {
            return;
        }
        EventTrackYY.d(ChatRoomProtos.Event.SINGLE_ROOM_FIRST_PAY_POP_SHOW, b.room_id, b.uid);
    }

    public void a(BaseYYStudioFragment baseYYStudioFragment, boolean z) {
        YYRoomModel b;
        this.a = baseYYStudioFragment;
        YYUserInfo yYUserInfo = YYRoomInfoManager.e().a;
        if (yYUserInfo == null || (b = YYRoomInfoManager.e().b()) == null) {
            return;
        }
        if (this.l == null) {
            YYMicrophoneView yYMicrophoneView = new YYMicrophoneView(getContext());
            this.l = yYMicrophoneView;
            yYMicrophoneView.setFragmentActive(baseYYStudioFragment.getFragmentActive());
        }
        if (TextUtils.equals(b.chat_type, "9")) {
            if (YYRoomInfoManager.e().y() || YYRoomInfoManager.e().j()) {
                if (this.p == null) {
                    YYWaittingView yYWaittingView = new YYWaittingView(getContext());
                    this.p = yYWaittingView;
                    yYWaittingView.a(baseYYStudioFragment);
                }
                d();
            } else {
                e();
            }
        } else if (YYRoomInfoManager.e().y()) {
            YYWaittingView yYWaittingView2 = new YYWaittingView(getContext());
            this.p = yYWaittingView2;
            yYWaittingView2.a(baseYYStudioFragment);
            d();
        } else {
            e();
        }
        a(yYUserInfo.is_open_mic);
        b(0);
        getButtonConfig();
    }

    @Override // com.blued.android.module.yy_china.observer.RoleStatusObserver
    public void a(String str) {
        if (TextUtils.equals("2", str) || TextUtils.equals("0", str)) {
            AudioChannelManager.j().d();
            AudioChannelManager.j().a(21);
            a(true);
            this.a.M();
        } else if (!TextUtils.equals("1", str)) {
            a(true);
        } else {
            if (YYRoomInfoManager.e().b() != null) {
                EventTrackYY.d(ChatRoomProtos.Event.CHAT_ROOM_MIKE_SUCCESS_SHOW, YYRoomInfoManager.e().b().room_id, YYRoomInfoManager.e().b().uid);
            }
            AudioChannelManager.j().a(20);
            this.a.e(YYRoomInfoManager.e().a.push_url);
            a(false);
        }
    }

    public void a(boolean z) {
        YYMicrophoneView yYMicrophoneView = this.l;
        if (yYMicrophoneView != null) {
            yYMicrophoneView.a(z);
        }
        ImageView imageView = this.g;
        if (imageView == null || this.m == null || imageView.getParent() == null) {
            return;
        }
        ((ViewGroup) this.g.getParent()).removeView(this.g);
        a(this.m, true);
    }

    public void b() {
        this.k.setVisibility(8);
        this.d.setImageResource(R.drawable.icon_gift);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        YYObserverManager.a().a(this);
        LiveEventBus.get("update_anchor_UI", String.class).observeForever(this.t);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        YYRoomModel b;
        Tracker.onClick(view);
        int id = view.getId();
        if (ClickUtils.a(id) || this.a == null || (b = YYRoomInfoManager.e().b()) == null) {
            return;
        }
        if (id == R.id.tv_chat || id == R.id.iv_pulbic_message) {
            EventTrackYY.d(ChatRoomProtos.Event.CHAT_ROOM_SEND_MSG_CLICK, b.room_id, b.uid);
            this.a.a("", "");
        } else if (id == R.id.iv_gift) {
            EventTrackYY.d(ChatRoomProtos.Event.CHAT_ROOM_GIFT_CLICK, b.room_id, b.uid);
            String str = "";
            if (!b.getNormalKtv().booleanValue()) {
                str = "";
                if (b.music != null) {
                    str = b.music.uid;
                }
            }
            this.a.a(true, "gift_icon", str);
            if (YYRoomInfoManager.e().b().round_end_time != 0) {
                new YYPackGiftDialog().show(this.a.getChildFragmentManager(), "YYPackGiftDialog");
            }
        } else if (id == R.id.iv_recharge) {
            h();
            if (YYRoomInfoManager.e().b() != null && YYRoomInfoManager.e().b().yyPerFirstGiftModel != null && !YYRoomInfoManager.e().b().yyPerFirstGiftModel.isClick) {
                YYRoomInfoManager.e().b().yyPerFirstGiftModel.isClick = true;
                if (YYRoomInfoManager.e().b().yyPerFirstGiftModel.getType() == 2) {
                    SharedPreferencesUtils.b().edit().putString("yy_FirstRechargeNotie", new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Long.valueOf(System.currentTimeMillis()))).apply();
                }
            }
            this.a.t();
            if (b != null) {
                EventTrackYY.d(ChatRoomProtos.Event.SINGLE_ROOM_PAY_ICON_CLICK, b.room_id, b.uid);
            }
        } else if (view.getId() == R.id.iv_tool_box) {
            EventTrackYY.d(ChatRoomProtos.Event.CHAT_ROOM_TOOLBOX_CLICK, b.room_id, b.uid);
            g();
            j();
        } else if (view.getId() != R.id.ll_room_pk || this.w == null) {
        } else {
            if (b != null) {
                ChatRoomProtos.Event event = ChatRoomProtos.Event.YY_RES_CLICK;
                String str2 = b.room_id;
                String str3 = b.uid;
                EventTrackYY.j(event, str2, str3, this.w.getAction_type() + "", this.w.getLink_url());
            }
            this.j.setVisibility(8);
            SharedPreferencesUtils.b().edit().putBoolean(this.w.getIcon(), true).commit();
            this.a.y();
            f();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        YYObserverManager.a().b(this);
        LiveEventBus.get("update_anchor_UI", String.class).removeObserver(this.t);
    }
}
