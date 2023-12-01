package com.blued.android.module.live_china.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.anythink.expressad.d.a.b;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.view.pulltorefresh.PullToRefreshRecyclerView;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.fragment.RecordingOnliveFragment;
import com.blued.android.module.live_china.manager.RecordingOnliveManager;
import com.blued.android.module.live_china.model.LiveRecordLevelStickerModel;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.utils.LiveRoomPreferences;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.Collection;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/PopStickerView.class */
public class PopStickerView {

    /* renamed from: a  reason: collision with root package name */
    private LayoutInflater f15213a;
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private View f15214c;
    private View d;
    private MyPopupWindow e;
    private RecordingOnliveFragment f;
    private RecordingOnliveManager g;
    private PullToRefreshRecyclerView h;
    private View i;
    private RecyclerView j;
    private StickerAdapter k;
    private LiveRecordLevelStickerModel l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/PopStickerView$MyPopupWindow.class */
    public class MyPopupWindow extends PopupWindow {
        public MyPopupWindow(View view, int i, int i2, boolean z) {
            super(view, i, i2, z);
        }

        public void a() {
            super.dismiss();
        }

        @Override // android.widget.PopupWindow
        public void dismiss() {
            try {
                PopStickerView.this.c();
            } catch (Exception e) {
                a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/PopStickerView$StickerAdapter.class */
    public class StickerAdapter extends BaseQuickAdapter<LiveRecordLevelStickerModel, BaseViewHolder> {
        private ImageView b;

        /* renamed from: c  reason: collision with root package name */
        private ImageView f15222c;
        private ImageView d;
        private TextView e;

        public StickerAdapter() {
            super(R.layout.sticker_view_item, null);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.chad.library.adapter.base.BaseQuickAdapter
        /* renamed from: a */
        public void convert(BaseViewHolder baseViewHolder, final LiveRecordLevelStickerModel liveRecordLevelStickerModel) {
            if (baseViewHolder != null) {
                this.b = (ImageView) baseViewHolder.getView(R.id.sticker_image);
                this.e = (TextView) baseViewHolder.getView(R.id.sticker_time_text);
                this.f15222c = (ImageView) baseViewHolder.getView(R.id.sticker_image_bg);
                this.d = (ImageView) baseViewHolder.getView(R.id.sticker_from_source);
                ImageLoader.a((IRequestHost) null, liveRecordLevelStickerModel.status == 1 ? liveRecordLevelStickerModel.icon : liveRecordLevelStickerModel.icon_disable).a(this.b);
                if (liveRecordLevelStickerModel.isSelect) {
                    this.f15222c.setVisibility(0);
                } else {
                    this.f15222c.setVisibility(8);
                }
                if (liveRecordLevelStickerModel.is_from_mall == 1) {
                    this.d.setVisibility(0);
                } else {
                    this.d.setVisibility(8);
                }
                if (liveRecordLevelStickerModel.is_from_mall != 1 || liveRecordLevelStickerModel.rest_time <= 0) {
                    this.e.setVisibility(8);
                    this.e.setText("");
                } else {
                    this.e.setText(PopStickerView.this.a(liveRecordLevelStickerModel.rest_time));
                    this.e.setVisibility(0);
                }
                baseViewHolder.setOnClickListener(R.id.sticker_root_layout, new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.PopStickerView.StickerAdapter.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Tracker.onClick(view);
                        if (liveRecordLevelStickerModel.status == 1) {
                            if (liveRecordLevelStickerModel.isSelect) {
                                liveRecordLevelStickerModel.isSelect = false;
                                PopStickerView.this.f.b((LiveRecordLevelStickerModel) null);
                                LiveRoomPreferences.x("");
                                PopStickerView.this.l = null;
                            } else {
                                int i = 0;
                                while (true) {
                                    int i2 = i;
                                    if (i2 >= StickerAdapter.this.mData.size()) {
                                        break;
                                    }
                                    ((LiveRecordLevelStickerModel) StickerAdapter.this.mData.get(i2)).isSelect = false;
                                    i = i2 + 1;
                                }
                                liveRecordLevelStickerModel.isSelect = true;
                                PopStickerView.this.l = liveRecordLevelStickerModel;
                                PopStickerView.this.f.b(liveRecordLevelStickerModel);
                                if (liveRecordLevelStickerModel.is_from_mall == 1) {
                                    liveRecordLevelStickerModel.is_used = 1;
                                    PopStickerView.this.f.l(liveRecordLevelStickerModel.id);
                                }
                                LiveRoomPreferences.x(liveRecordLevelStickerModel.id);
                            }
                            StickerAdapter.this.notifyDataSetChanged();
                        } else {
                            AppMethods.a((CharSequence) liveRecordLevelStickerModel.lock_message);
                        }
                        PopStickerView.this.e.dismiss();
                    }
                });
            }
        }
    }

    public PopStickerView(RecordingOnliveFragment recordingOnliveFragment, RecordingOnliveManager recordingOnliveManager) {
        this.g = recordingOnliveManager;
        this.f = recordingOnliveFragment;
        this.b = recordingOnliveFragment.getContext();
        d();
        e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(long j) {
        long j2 = j / 86400;
        long j3 = (j % 86400) / b.P;
        return (j2 > 0 || j3 > 0) ? String.format(this.b.getResources().getString(R.string.live_sticker_times), Long.valueOf(j2), Long.valueOf(j3)) : String.format(this.b.getResources().getString(R.string.live_sticker_times_short), Long.valueOf(j / 60));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BluedEntityA<LiveRecordLevelStickerModel> bluedEntityA) {
        List<LiveRecordLevelStickerModel> list;
        StickerAdapter stickerAdapter;
        if (bluedEntityA == null || bluedEntityA.data == null || bluedEntityA.data.size() <= 0 || (list = bluedEntityA.data) == null || (stickerAdapter = this.k) == null) {
            return;
        }
        stickerAdapter.getData().clear();
        this.k.addData((Collection) list);
        String p = LiveRoomPreferences.p();
        Log.v("pk", "本地缓存code：" + p);
        if (TextUtils.isEmpty(p)) {
            return;
        }
        for (LiveRecordLevelStickerModel liveRecordLevelStickerModel : list) {
            Log.v("pk", "setDataToView " + liveRecordLevelStickerModel.id + "__" + p);
            if (TextUtils.equals(liveRecordLevelStickerModel.id, p)) {
                Log.v("pk", "设置选中");
                liveRecordLevelStickerModel.isSelect = true;
                this.k.notifyDataSetChanged();
                this.l = liveRecordLevelStickerModel;
                String[] split = LiveRoomPreferences.r().split(BridgeUtil.UNDERLINE_STR);
                if (split == null || split.length != 2) {
                    return;
                }
                int parseInt = Integer.parseInt(split[0]);
                int parseInt2 = Integer.parseInt(split[1]);
                this.f.cK.a(parseInt, parseInt2, liveRecordLevelStickerModel);
                this.f.cK.b(parseInt, parseInt2, liveRecordLevelStickerModel);
                return;
            }
        }
    }

    private void e() {
        LayoutInflater from = LayoutInflater.from(this.b);
        this.f15213a = from;
        View inflate = from.inflate(R.layout.pop_window_record_level_sticker, (ViewGroup) null);
        this.f15214c = inflate.findViewById(R.id.tv_bg);
        this.h = (PullToRefreshRecyclerView) inflate.findViewById(R.id.live_sticker_recycler_view);
        this.i = inflate.findViewById(R.id.ll_loading);
        this.j = this.h.getRefreshableView();
        this.j.setLayoutManager(new GridLayoutManager(this.b, 3));
        StickerAdapter stickerAdapter = new StickerAdapter();
        this.k = stickerAdapter;
        this.j.setAdapter(stickerAdapter);
        this.h.setRefreshEnabled(false);
        this.f15214c.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.PopStickerView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                PopStickerView.this.c();
            }
        });
        View findViewById = inflate.findViewById(R.id.ll_content);
        this.d = findViewById;
        findViewById.setVisibility(8);
        this.d.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.PopStickerView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
            }
        });
        MyPopupWindow myPopupWindow = new MyPopupWindow(inflate, -1, -1, true);
        this.e = myPopupWindow;
        myPopupWindow.setBackgroundDrawable(this.b.getResources().getDrawable(17170445));
        this.e.setTouchable(true);
        this.e.setOutsideTouchable(true);
        this.e.setFocusable(true);
        this.e.update();
    }

    public void a() {
        BluedUIHttpResponse<BluedEntityA<LiveRecordLevelStickerModel>> bluedUIHttpResponse = new BluedUIHttpResponse<BluedEntityA<LiveRecordLevelStickerModel>>("RecordLevelSticker", this.f.getFragmentActive()) { // from class: com.blued.android.module.live_china.view.PopStickerView.3
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUICache(BluedEntityA<LiveRecordLevelStickerModel> bluedEntityA) {
                PopStickerView.this.a(bluedEntityA);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: b */
            public void onUIUpdate(BluedEntityA<LiveRecordLevelStickerModel> bluedEntityA) {
                PopStickerView.this.a(bluedEntityA);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
                PopStickerView.this.i.setVisibility(8);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
                PopStickerView.this.i.setVisibility(0);
            }
        };
        LiveRoomHttpUtils.t(bluedUIHttpResponse, this.f.t + "");
    }

    public void a(LiveRecordLevelStickerModel liveRecordLevelStickerModel) {
        StickerAdapter stickerAdapter;
        List<LiveRecordLevelStickerModel> data;
        if (liveRecordLevelStickerModel == null || (stickerAdapter = this.k) == null || (data = stickerAdapter.getData()) == null) {
            return;
        }
        for (LiveRecordLevelStickerModel liveRecordLevelStickerModel2 : data) {
            Log.v("pk", "remove sticker " + liveRecordLevelStickerModel2.id + "__" + liveRecordLevelStickerModel.id);
            if (TextUtils.equals(liveRecordLevelStickerModel2.id, liveRecordLevelStickerModel.id)) {
                liveRecordLevelStickerModel2.isSelect = false;
                this.k.notifyDataSetChanged();
                LiveRoomPreferences.x("");
                return;
            }
        }
    }

    public void b() {
        RecordingOnliveFragment recordingOnliveFragment = this.f;
        if (recordingOnliveFragment != null) {
            recordingOnliveFragment.O();
        }
        this.f15214c.clearAnimation();
        this.d.clearAnimation();
        if (this.e.isShowing()) {
            this.e.a();
        }
        this.e.showAtLocation(this.d, 81, 0, 0);
        this.d.setVisibility(0);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.b, R.anim.push_bottom_in);
        this.d.startAnimation(loadAnimation);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.blued.android.module.live_china.view.PopStickerView.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                PopStickerView.this.a();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
    }

    public void c() {
        RecordingOnliveFragment recordingOnliveFragment = this.f;
        if (recordingOnliveFragment != null) {
            recordingOnliveFragment.P();
        }
        this.d.setVisibility(8);
        this.d.startAnimation(AnimationUtils.loadAnimation(this.b, R.anim.push_bottom_out));
        AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.module.live_china.view.PopStickerView.5
            @Override // java.lang.Runnable
            public void run() {
                PopStickerView.this.e.a();
            }
        }, 300L);
    }

    public void d() {
    }
}
