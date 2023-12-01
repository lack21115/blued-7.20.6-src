package com.blued.android.module.live_china.view;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.android.internal.content.NativeLibraryHelper;
import com.blued.android.core.AppInfo;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.framework.utils.TypeUtils;
import com.blued.android.framework.view.badgeview.DisplayUtil;
import com.blued.android.module.common.adapter.CommonAdapter;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.fragment.PlayingOnliveFullModeFragment;
import com.blued.android.module.live_china.fragment.RecordingOnliveFragment;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.DefinedRankInfo;
import com.blued.android.module.live_china.model.LiveDefinedRankModel;
import com.blued.android.module.live_china.msg.LiveEventBusUtil;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.android.module.live_china.view.LiveDefinedRankView;
import com.blued.das.live.LiveProtos;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveDefinedRankView.class */
public class LiveDefinedRankView extends FrameLayout {
    protected View a;
    protected ImageView b;
    protected ListView c;
    protected CommonAdapter<LiveDefinedRankModel> d;
    protected TextView e;
    private ImageView f;
    private ImageView g;
    private int h;
    private DefinedRankInfo i;
    private BaseFragment j;
    private MyHandler k;
    private final int l;
    private final int m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.blued.android.module.live_china.view.LiveDefinedRankView$1  reason: invalid class name */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveDefinedRankView$1.class */
    public class AnonymousClass1 extends CommonAdapter<LiveDefinedRankModel> {
        AnonymousClass1(int i) {
            super(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(boolean z, LiveDefinedRankModel liveDefinedRankModel, View view) {
            if (z) {
                LiveRoomManager.a().b((String) null);
            } else {
                LiveRoomManager.a().b(liveDefinedRankModel.title);
            }
            notifyDataSetChanged();
        }

        @Override // com.blued.android.module.common.adapter.CommonAdapter
        public void a(CommonAdapter.ViewHolder viewHolder, final LiveDefinedRankModel liveDefinedRankModel, int i) {
            boolean endsWith = TextUtils.isEmpty(LiveRoomManager.a().O()) ? false : LiveRoomManager.a().O().endsWith(liveDefinedRankModel.title);
            ImageView imageView = (ImageView) viewHolder.a(R.id.item_live_defined_rank_index_iv);
            if (liveDefinedRankModel.score <= 0) {
                imageView.setVisibility(8);
                viewHolder.b(R.id.item_live_defined_rank_index_tv, 0);
            } else if (liveDefinedRankModel.index < 4) {
                imageView.setVisibility(0);
                viewHolder.b(R.id.item_live_defined_rank_index_tv, 8);
                if (liveDefinedRankModel.index == 1) {
                    imageView.setImageResource(R.drawable.item_live_defined_rank_index_1);
                } else if (liveDefinedRankModel.index == 2) {
                    imageView.setImageResource(R.drawable.item_live_defined_rank_index_2);
                } else if (liveDefinedRankModel.index == 3) {
                    imageView.setImageResource(R.drawable.item_live_defined_rank_index_3);
                }
            } else {
                imageView.setVisibility(8);
                viewHolder.b(R.id.item_live_defined_rank_index_tv, 0);
            }
            final boolean z = endsWith;
            viewHolder.a(R.id.item_live_defined_rank_index_tv, liveDefinedRankModel.score > 0 ? String.valueOf(liveDefinedRankModel.index) : NativeLibraryHelper.CLEAR_ABI_OVERRIDE).a(R.id.item_live_defined_rank_avatar, liveDefinedRankModel.image, 6).a(R.id.item_live_defined_rank_name, liveDefinedRankModel.title).a(R.id.item_live_defined_rank_count, String.valueOf(liveDefinedRankModel.score)).c(R.id.item_live_defined_rank_content_layout, endsWith ? R.drawable.item_live_defined_rank_selected_bg : R.color.transparent).b(R.id.item_live_defined_rank_bottom, i == this.b.size() - 1 ? 0 : 8).a().setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LiveDefinedRankView$1$9EYbQ4W_hZ6osGkgcmHu8PeSn1w
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LiveDefinedRankView.AnonymousClass1.this.a(z, liveDefinedRankModel, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveDefinedRankView$MyHandler.class */
    public class MyHandler extends Handler {
        private MyHandler() {
        }

        /* synthetic */ MyHandler(LiveDefinedRankView liveDefinedRankView, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            boolean z = false;
            if (message.what == 1) {
                LiveDefinedRankView liveDefinedRankView = LiveDefinedRankView.this;
                if (liveDefinedRankView.c.getVisibility() == 0) {
                    z = true;
                }
                liveDefinedRankView.setViewLayout(z);
                LiveEventBusUtil.a((DefinedRankInfo) null);
                LogUtils.c("rank end");
            } else if (message.what == 2) {
                LiveDefinedRankView liveDefinedRankView2 = LiveDefinedRankView.this;
                boolean z2 = false;
                if (liveDefinedRankView2.c.getVisibility() == 0) {
                    z2 = true;
                }
                liveDefinedRankView2.setViewLayout(z2);
                LiveEventBusUtil.a(LiveDefinedRankView.this.i);
                LogUtils.c("rank start, show View");
            }
        }
    }

    public LiveDefinedRankView(Context context) {
        super(context);
        this.h = R.layout.live_defined_rank_layout;
        this.k = new MyHandler(this, null);
        this.l = 1;
        this.m = 2;
        a();
    }

    public LiveDefinedRankView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.h = R.layout.live_defined_rank_layout;
        this.k = new MyHandler(this, null);
        this.l = 1;
        this.m = 2;
        a();
    }

    public LiveDefinedRankView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.h = R.layout.live_defined_rank_layout;
        this.k = new MyHandler(this, null);
        this.l = 1;
        this.m = 2;
        a();
    }

    private void a() {
        View inflate = LayoutInflater.from(AppInfo.d()).inflate(this.h, (ViewGroup) null);
        this.a = inflate.findViewById(R.id.live_defined_rank_title_layout);
        this.f = (ImageView) inflate.findViewById(R.id.live_defined_rank_title_iv);
        this.b = (ImageView) inflate.findViewById(R.id.live_defined_rank_arrow_iv);
        this.c = (ListView) inflate.findViewById(R.id.live_defined_rank_lv);
        this.g = (ImageView) inflate.findViewById(R.id.live_defined_rank_host_state_iv);
        this.e = (TextView) inflate.findViewById(R.id.live_defined_rank_send_btn);
        this.g.setVisibility(8);
        this.e.setVisibility(8);
        this.b.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LiveDefinedRankView$hkujFfk3Q6zv4dTL7w1YT63I-FE
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveDefinedRankView.this.c(view);
            }
        });
        this.f.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LiveDefinedRankView$Dx9bAAva2H0uasSaeRdE7diQ2oA
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveDefinedRankView.this.b(view);
            }
        });
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(R.layout.item_live_defined_rank);
        this.d = anonymousClass1;
        this.c.setAdapter((ListAdapter) anonymousClass1);
        this.e.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LiveDefinedRankView$aV45eeGF_-TiIeOiXi6I8EHraLs
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveDefinedRankView.this.a(view);
            }
        });
        addView(inflate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        b();
    }

    private void b() {
        if (this.i == null || this.j == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis >= this.i.end_time * 1000 || currentTimeMillis < this.i.start_time * 1000) {
            return;
        }
        BaseFragment baseFragment = this.j;
        if (baseFragment instanceof PlayingOnliveFullModeFragment) {
            ((PlayingOnliveFullModeFragment) baseFragment).ad().aH();
        }
        EventTrackLive.a(LiveProtos.Event.LIVE_RANK_LIST_SEND_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        setViewLayout(this.c.getVisibility() == 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        setViewLayout(this.c.getVisibility() == 8);
    }

    private boolean c() {
        return this.j instanceof RecordingOnliveFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setViewLayout(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.a.getLayoutParams();
        layoutParams.width = DisplayUtil.a(this.a.getContext(), z ? 124.0f : 58.0f);
        layoutParams.height = DisplayUtil.a(this.a.getContext(), z ? 38.0f : 32.0f);
        this.a.setLayoutParams(layoutParams);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.f.getLayoutParams();
        layoutParams2.leftMargin = DisplayUtil.a(AppInfo.d(), z ? 43.0f : 6.0f);
        this.f.setLayoutParams(layoutParams2);
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.b.getLayoutParams();
        layoutParams3.rightMargin = DisplayUtil.a(AppInfo.d(), z ? 9.0f : 0.0f);
        this.b.setLayoutParams(layoutParams3);
        if (!z) {
            this.b.setImageResource(R.drawable.live_defined_rank_arrow);
            this.c.setVisibility(8);
            this.e.setVisibility(8);
            this.g.setVisibility(8);
            EventTrackLive.a(LiveProtos.Event.LIVE_RANK_LIST_CLOSE, LiveRoomManager.a().e(), LiveRoomManager.a().g());
            return;
        }
        this.c.setVisibility(0);
        this.b.setImageResource(R.drawable.live_defined_rank_arrow_up);
        if (this.i == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (c()) {
            this.e.setVisibility(8);
            this.g.setVisibility(0);
            if (currentTimeMillis < this.i.start_time * 1000) {
                this.g.setImageResource(R.drawable.live_defined_rank_host_not_start);
                LiveRoomManager.a().b((String) null);
            } else if (currentTimeMillis >= this.i.end_time * 1000) {
                this.g.setImageResource(R.drawable.live_defined_rank_host_finished);
                LiveRoomManager.a().b((String) null);
            } else {
                this.g.setImageResource(R.drawable.live_defined_rank_host_started);
            }
        } else {
            this.e.setVisibility(0);
            this.g.setVisibility(8);
            if (currentTimeMillis < this.i.start_time * 1000) {
                this.e.setText("未开始");
                this.e.setTextColor(Color.parseColor("#9F9F9F"));
                this.e.setBackgroundResource(R.drawable.live_defined_rank_invalid_btn_bg);
                this.e.setEnabled(false);
                LiveRoomManager.a().b((String) null);
            } else if (currentTimeMillis >= this.i.end_time * 1000) {
                this.e.setText("已结束");
                this.e.setTextColor(Color.parseColor("#9F9F9F"));
                this.e.setBackgroundResource(R.drawable.live_defined_rank_invalid_btn_bg);
                this.e.setEnabled(false);
                LiveRoomManager.a().b((String) null);
            } else {
                this.e.setText("送礼");
                this.e.setTextColor(-1);
                this.e.setBackgroundResource(R.drawable.gradient_922cee_ff3aaa);
                this.e.setEnabled(true);
            }
        }
        this.d.notifyDataSetChanged();
        EventTrackLive.a(LiveProtos.Event.LIVE_RANK_LIST_OPEN, LiveRoomManager.a().e(), LiveRoomManager.a().g());
    }

    public void a(String str) {
        this.d.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.k.removeMessages(1);
        this.k.removeMessages(2);
    }

    public void setData(DefinedRankInfo definedRankInfo) {
        if (LiveRoomManager.a().W()) {
            this.i = definedRankInfo;
            if (definedRankInfo == null || TypeUtils.a((List<?>) definedRankInfo.rank_info)) {
                setVisibility(8);
                LiveRoomManager.a().b((String) null);
                LiveEventBusUtil.a(this.i);
                return;
            }
            int i = 0;
            setVisibility(0);
            while (i < this.i.rank_info.size()) {
                LiveDefinedRankModel liveDefinedRankModel = this.i.rank_info.get(i);
                i++;
                liveDefinedRankModel.index = i;
            }
            this.d.a(this.i.rank_info);
            setViewLayout(true);
            LogUtils.c(AppInfo.f().toJson(this.i));
            this.k.removeMessages(1);
            this.k.removeMessages(2);
            long j = this.i.end_time * 1000;
            if (j > System.currentTimeMillis()) {
                this.k.sendEmptyMessageDelayed(1, j - System.currentTimeMillis());
                LogUtils.c("rank stop after " + (j - System.currentTimeMillis()));
            }
            if (this.i.start_time * 1000 > System.currentTimeMillis()) {
                this.k.sendEmptyMessageDelayed(2, (this.i.start_time * 1000) - System.currentTimeMillis());
                LogUtils.c("rank start after " + ((this.i.start_time * 1000) - System.currentTimeMillis()));
            }
        }
    }

    public void setFragment(BaseFragment baseFragment) {
        this.j = baseFragment;
    }
}
