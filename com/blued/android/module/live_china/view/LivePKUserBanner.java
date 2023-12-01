package com.blued.android.module.live_china.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.module.common.adapter.CommonRecycleAdapter;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.model.LivePKPlayerModel;
import com.blued.android.module.live_china.model.LivePKProgressModel;
import com.blued.android.module.live_china.model.LivePkBannerItemModel;
import com.blued.android.module.live_china.model.LivePkBannerModel;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;
import com.bytedance.applog.tracker.Tracker;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.util.ArrayList;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LivePKUserBanner.class */
public class LivePKUserBanner extends FrameLayout implements View.OnClickListener {
    private View a;
    private View b;
    private View c;
    private View d;
    private ImageView e;
    private RecyclerView f;
    private RecyclerView g;
    private View h;
    private View i;
    private int j;
    private LivePKPlayerModel k;
    private String l;
    private String m;
    private LivePkAdapter n;
    private LivePkAdapter o;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LivePKUserBanner$LivePkAdapter.class */
    public class LivePkAdapter extends CommonRecycleAdapter<LivePkBannerItemModel> {
        private int b;

        public LivePkAdapter(Context context, int i) {
            super(context);
            this.b = i;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.blued.android.module.common.adapter.CommonRecycleAdapter
        /* renamed from: a */
        public void onBindViewHolderData(LivePkBannerItemModel livePkBannerItemModel, int i, CommonRecycleAdapter.CommonAdapterHolder commonAdapterHolder) {
            if (livePkBannerItemModel == null) {
                return;
            }
            commonAdapterHolder.a(R.id.fl_view).setPadding(this.b == 0 ? 0 : DensityUtils.a(LivePKUserBanner.this.getContext(), 11.0f), DensityUtils.a(LivePKUserBanner.this.getContext(), 5.0f), this.b == 0 ? DensityUtils.a(LivePKUserBanner.this.getContext(), 11.0f) : 0, DensityUtils.a(LivePKUserBanner.this.getContext(), 5.0f));
            ImageLoader.a((IRequestHost) null, livePkBannerItemModel.avatar).c().b(this.b == 0 ? R.drawable.live_pk_banner_item_default_left : R.drawable.live_pk_banner_item_default_right).a((ImageView) commonAdapterHolder.a(R.id.iv_avatar));
            if (this.b == 0) {
                commonAdapterHolder.c(R.id.view_dd_bg, R.drawable.live_pk_banner_item_avatar_blue_dd_bg);
                commonAdapterHolder.c(R.id.view_bg, R.drawable.live_pk_banner_item_avatar_blue_bg);
                commonAdapterHolder.c(R.id.tv_num, R.drawable.live_pk_banner_item_num_blue_bg);
            } else {
                commonAdapterHolder.c(R.id.view_dd_bg, R.drawable.live_pk_banner_item_avatar_red_dd_bg);
                commonAdapterHolder.c(R.id.view_bg, R.drawable.live_pk_banner_item_avatar_red_bg);
                commonAdapterHolder.c(R.id.tv_num, R.drawable.live_pk_banner_item_num_red_bg);
            }
            if (livePkBannerItemModel.index != 1) {
                if (livePkBannerItemModel.index == 2) {
                    commonAdapterHolder.b(R.id.iv_mvp, 8);
                    commonAdapterHolder.b(R.id.tv_num, 0);
                    int i2 = R.id.tv_num;
                    commonAdapterHolder.a(i2, "" + livePkBannerItemModel.index);
                } else if (livePkBannerItemModel.index == 3) {
                    commonAdapterHolder.b(R.id.iv_mvp, 8);
                    commonAdapterHolder.b(R.id.tv_num, 0);
                    int i3 = R.id.tv_num;
                    commonAdapterHolder.a(i3, "" + livePkBannerItemModel.index);
                }
            } else if (LivePKUserBanner.this.j == 0) {
                commonAdapterHolder.b(R.id.iv_mvp, 8);
                commonAdapterHolder.b(R.id.tv_num, 0);
                int i4 = R.id.tv_num;
                commonAdapterHolder.a(i4, "" + livePkBannerItemModel.index);
            } else if (LivePKUserBanner.this.j == 1) {
                if (this.b == 0) {
                    commonAdapterHolder.b(R.id.iv_mvp, 0);
                    commonAdapterHolder.b(R.id.tv_num, 8);
                    return;
                }
                commonAdapterHolder.b(R.id.iv_mvp, 8);
                commonAdapterHolder.b(R.id.tv_num, 0);
                int i5 = R.id.tv_num;
                commonAdapterHolder.a(i5, "" + livePkBannerItemModel.index);
            } else if (LivePKUserBanner.this.j == 2) {
                if (this.b != 0) {
                    commonAdapterHolder.b(R.id.iv_mvp, 0);
                    commonAdapterHolder.b(R.id.tv_num, 8);
                    return;
                }
                commonAdapterHolder.b(R.id.iv_mvp, 8);
                commonAdapterHolder.b(R.id.tv_num, 0);
                int i6 = R.id.tv_num;
                commonAdapterHolder.a(i6, "" + livePkBannerItemModel.index);
            }
        }

        @Override // com.blued.android.module.common.adapter.CommonRecycleAdapter
        public int getLayoutId(int i) {
            return R.layout.live_pk_user_banner_item;
        }
    }

    public LivePKUserBanner(Context context) {
        this(context, null);
    }

    public LivePKUserBanner(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.j = 0;
        this.l = "";
        e();
        a();
    }

    private void e() {
        LayoutInflater.from(getContext()).inflate(R.layout.live_pk_user_banner, this);
        this.e = (ImageView) findViewById(R.id.iv_vs);
        this.c = findViewById(R.id.fl_left);
        this.d = findViewById(R.id.fl_right);
        this.f = findViewById(R.id.rv_pk_left);
        this.g = findViewById(R.id.rv_pk_right);
        this.h = findViewById(R.id.fl_left_fail);
        this.i = findViewById(R.id.fl_right_fail);
        this.f.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        this.g.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        this.n = new LivePkAdapter(getContext(), 0);
        this.o = new LivePkAdapter(getContext(), 1);
        this.f.setAdapter(this.n);
        this.g.setAdapter(this.o);
        this.a = findViewById(R.id.view_left);
        this.b = findViewById(R.id.view_right);
        this.c.setOnClickListener(this);
        this.d.setOnClickListener(this);
        this.a.setOnClickListener(this);
        this.b.setOnClickListener(this);
    }

    public void a() {
        this.m = "0";
        this.j = 0;
        a(0, (LivePKPlayerModel) null);
        setData(null);
    }

    public void a(int i, LivePKPlayerModel livePKPlayerModel) {
        this.j = i;
        this.k = livePKPlayerModel;
        if (livePKPlayerModel != null) {
            this.l = livePKPlayerModel.avatar;
        }
        int i2 = this.j;
        if (i2 == 0) {
            this.h.setVisibility(8);
            this.i.setVisibility(8);
            this.f.setAlpha(1.0f);
            this.g.setAlpha(1.0f);
        } else if (i2 == 1) {
            this.h.setVisibility(8);
            this.i.setVisibility(0);
            this.f.setAlpha(1.0f);
            this.g.setAlpha(0.5f);
        } else if (i2 == 2) {
            this.h.setVisibility(0);
            this.i.setVisibility(8);
            this.f.setAlpha(0.5f);
            this.g.setAlpha(1.0f);
        }
        this.n.notifyDataSetChanged();
        this.o.notifyDataSetChanged();
    }

    public void a(String str, int i, LivePKProgressModel livePKProgressModel, LivePKPlayerModel livePKPlayerModel) {
        this.m = str;
        this.j = i;
        this.k = livePKPlayerModel;
        if (livePKPlayerModel != null) {
            this.l = livePKPlayerModel.avatar;
        }
        a(this.j, livePKPlayerModel);
        setData(livePKProgressModel);
    }

    public void a(String str, LivePKPlayerModel livePKPlayerModel) {
        if (TextUtils.equals(str, this.m)) {
            return;
        }
        this.m = str;
        this.k = livePKPlayerModel;
        if (livePKPlayerModel != null) {
            this.l = livePKPlayerModel.avatar;
        }
        this.j = 0;
        a(0, livePKPlayerModel);
        setData(null);
    }

    public void b() {
        this.j = 0;
        this.l = "";
        a(0, this.k);
        setData(null);
    }

    public void c() {
        EventTrackLive.a(LiveProtos.Event.LIVE_PK_AUDIENCE_SEAT_CLICK, false);
        LivePkBannerModel livePkBannerModel = new LivePkBannerModel();
        livePkBannerModel.lid = this.m;
        livePkBannerModel.type = 0;
        livePkBannerModel.pk_state = this.j;
        LiveEventBus.get("live_pk_dialog").post(livePkBannerModel);
    }

    public void d() {
        EventTrackLive.a(LiveProtos.Event.LIVE_PK_AUDIENCE_SEAT_CLICK, true);
        LivePkBannerModel livePkBannerModel = new LivePkBannerModel();
        livePkBannerModel.lid = this.m;
        livePkBannerModel.type = 1;
        livePkBannerModel.pk_state = this.j;
        LiveEventBus.get("live_pk_dialog").post(livePkBannerModel);
    }

    public String getAvatar() {
        return this.l;
    }

    public long getOtherLid() {
        return StringUtils.a(this.m, 0L);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        if (view.getId() == R.id.view_left) {
            c();
        } else if (view.getId() == R.id.view_right) {
            d();
        }
    }

    public void setData(LivePKProgressModel livePKProgressModel) {
        LivePKProgressModel livePKProgressModel2 = livePKProgressModel;
        if (livePKProgressModel == null) {
            livePKProgressModel2 = new LivePKProgressModel();
        }
        ArrayList arrayList = new ArrayList();
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i >= 3) {
                break;
            }
            LivePkBannerItemModel livePkBannerItemModel = new LivePkBannerItemModel();
            i++;
            livePkBannerItemModel.index = i;
            int i4 = i3;
            if (livePKProgressModel2.top != null) {
                i4 = i3;
                if (i3 < livePKProgressModel2.top.size()) {
                    livePkBannerItemModel.uid = livePKProgressModel2.top.get(i3).uid;
                    livePkBannerItemModel.avatar = livePKProgressModel2.top.get(i3).avatar;
                    i4 = i3 + 1;
                }
            }
            arrayList.add(livePkBannerItemModel);
            i2 = i4;
        }
        ArrayList arrayList2 = new ArrayList();
        int i5 = 0;
        int i6 = 0;
        while (i6 < 3) {
            LivePkBannerItemModel livePkBannerItemModel2 = new LivePkBannerItemModel();
            i6++;
            livePkBannerItemModel2.index = i6;
            int i7 = i5;
            if (livePKProgressModel2.target_top != null) {
                i7 = i5;
                if (i5 < livePKProgressModel2.target_top.size()) {
                    livePkBannerItemModel2.uid = livePKProgressModel2.target_top.get(i5).uid;
                    livePkBannerItemModel2.avatar = livePKProgressModel2.target_top.get(i5).avatar;
                    i7 = i5 + 1;
                }
            }
            arrayList2.add(livePkBannerItemModel2);
            i5 = i7;
        }
        ArrayList arrayList3 = new ArrayList();
        int size = arrayList.size();
        while (true) {
            int i8 = size - 1;
            if (i8 < 0) {
                this.n.setDataAndNotify(arrayList3);
                this.o.setDataAndNotify(arrayList2);
                return;
            }
            arrayList3.add((LivePkBannerItemModel) arrayList.get(i8));
            size = i8;
        }
    }

    public void setVsVisable(boolean z) {
        this.e.setVisibility(z ? 0 : 8);
    }
}
