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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.view.pulltorefresh.PullToRefreshRecyclerView;
import com.blued.android.module.external_sense_library.contract.ISetStickerListener;
import com.blued.android.module.external_sense_library.manager.StickerDataManager;
import com.blued.android.module.external_sense_library.model.ErrorCode;
import com.blued.android.module.external_sense_library.model.StickerBaseModel;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.fragment.RecordingOnliveFragment;
import com.blued.android.module.live_china.manager.RecordingOnliveManager;
import com.blued.android.module.live_china.model.LiveGiftModel;
import com.blued.android.module.live_china.model.LiveRecordLevelGestureModel;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.utils.LiveRoomPreferences;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/PopGestureView.class */
public class PopGestureView {

    /* renamed from: a  reason: collision with root package name */
    private LayoutInflater f15021a;
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private View f15022c;
    private View d;
    private MyPopupWindow e;
    private RecordingOnliveFragment f;
    private RecordingOnliveManager g;
    private PullToRefreshRecyclerView h;
    private View i;
    private RecyclerView j;
    private GestureAdapter k;
    private ImageView l;
    private LiveRecordLevelGestureModel m;
    private GestureTip n = new GestureTip();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/PopGestureView$GestureAdapter.class */
    public class GestureAdapter extends BaseQuickAdapter<LiveRecordLevelGestureModel, BaseViewHolder> {
        private ImageView b;

        /* renamed from: c  reason: collision with root package name */
        private ImageView f15032c;
        private TextView d;

        public GestureAdapter() {
            super(R.layout.gesture_view_item, null);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.chad.library.adapter.base.BaseQuickAdapter
        /* renamed from: a */
        public void convert(BaseViewHolder baseViewHolder, final LiveRecordLevelGestureModel liveRecordLevelGestureModel) {
            if (baseViewHolder != null) {
                this.b = (ImageView) baseViewHolder.getView(R.id.guest_image);
                this.f15032c = (ImageView) baseViewHolder.getView(R.id.guest_image_bg);
                this.d = (TextView) baseViewHolder.getView(R.id.guest_text);
                if (liveRecordLevelGestureModel.status == 1) {
                    ImageLoader.a((IRequestHost) null, liveRecordLevelGestureModel.icon).a(this.b);
                } else {
                    ImageLoader.a((IRequestHost) null, liveRecordLevelGestureModel.icon_disable).a(this.b);
                }
                baseViewHolder.setText(R.id.guest_text, liveRecordLevelGestureModel.title);
                if (liveRecordLevelGestureModel.isSelect) {
                    this.f15032c.setVisibility(0);
                } else {
                    this.f15032c.setVisibility(8);
                }
                baseViewHolder.setOnClickListener(R.id.guest_root_layout, new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.PopGestureView.GestureAdapter.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Tracker.onClick(view);
                        if (liveRecordLevelGestureModel.status != 1) {
                            AppMethods.a((CharSequence) liveRecordLevelGestureModel.lock_message);
                            return;
                        }
                        if (liveRecordLevelGestureModel.isSelect) {
                            liveRecordLevelGestureModel.isSelect = false;
                            PopGestureView.this.g.a((LiveGiftModel) null, (ISetStickerListener) null);
                            PopGestureView.this.m = null;
                            LiveRoomPreferences.y("");
                        } else {
                            PopGestureView.this.m = liveRecordLevelGestureModel;
                            int i = 0;
                            while (true) {
                                int i2 = i;
                                if (i2 >= GestureAdapter.this.mData.size()) {
                                    break;
                                }
                                ((LiveRecordLevelGestureModel) GestureAdapter.this.mData.get(i2)).isSelect = false;
                                i = i2 + 1;
                            }
                            liveRecordLevelGestureModel.isSelect = true;
                            LiveRoomPreferences.y(liveRecordLevelGestureModel.code);
                            if (!PopGestureView.this.f.ab) {
                                LiveGiftModel liveGiftModel = new LiveGiftModel();
                                liveGiftModel.anim_code = liveRecordLevelGestureModel.code;
                                liveGiftModel.resource_url = liveRecordLevelGestureModel.resource;
                                PopGestureView.this.g.a(liveGiftModel, new ISetStickerListener() { // from class: com.blued.android.module.live_china.view.PopGestureView.GestureAdapter.1.1
                                    @Override // com.blued.android.module.external_sense_library.contract.ISetStickerListener
                                    public void onFailed(ErrorCode.PlayStickerCode playStickerCode, String str) {
                                        Log.v("pk", "onFailed:" + playStickerCode + " -- " + str);
                                    }

                                    @Override // com.blued.android.module.external_sense_library.contract.ISetStickerListener
                                    public void onSetSticker() {
                                        Log.v("pk", "onSetSticker");
                                    }
                                });
                                PopGestureView.this.a(liveRecordLevelGestureModel.tips_url);
                            }
                        }
                        GestureAdapter.this.notifyDataSetChanged();
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/PopGestureView$GestureTip.class */
    public class GestureTip implements Runnable {
        GestureTip() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PopGestureView.this.l.setVisibility(8);
            PopGestureView.this.l.startAnimation(AnimationUtils.loadAnimation(PopGestureView.this.b, R.anim.push_center_out));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/PopGestureView$MyPopupWindow.class */
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
                PopGestureView.this.c();
            } catch (Exception e) {
                a();
            }
        }
    }

    public PopGestureView(RecordingOnliveFragment recordingOnliveFragment, RecordingOnliveManager recordingOnliveManager) {
        this.g = recordingOnliveManager;
        this.f = recordingOnliveFragment;
        this.b = recordingOnliveFragment.getContext();
        g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BluedEntityA<LiveRecordLevelGestureModel> bluedEntityA) {
        List<LiveRecordLevelGestureModel> list;
        GestureAdapter gestureAdapter;
        if (bluedEntityA == null || bluedEntityA.data == null || bluedEntityA.data.size() <= 0 || (list = bluedEntityA.data) == null || (gestureAdapter = this.k) == null) {
            return;
        }
        gestureAdapter.getData().clear();
        this.k.addData((Collection) list);
        ArrayList arrayList = new ArrayList();
        for (LiveRecordLevelGestureModel liveRecordLevelGestureModel : list) {
            StickerBaseModel stickerBaseModel = new StickerBaseModel();
            stickerBaseModel.name = liveRecordLevelGestureModel.code;
            stickerBaseModel.path = liveRecordLevelGestureModel.resource;
            arrayList.add(stickerBaseModel);
        }
        StickerDataManager.init(arrayList, null);
        String q = LiveRoomPreferences.q();
        Log.v("pk", "setDataToView code:" + q);
        if (TextUtils.isEmpty(q) || list == null) {
            return;
        }
        for (LiveRecordLevelGestureModel liveRecordLevelGestureModel2 : list) {
            if (TextUtils.equals(q, liveRecordLevelGestureModel2.code)) {
                this.m = liveRecordLevelGestureModel2;
                liveRecordLevelGestureModel2.isSelect = true;
                if (this.g != null) {
                    LiveGiftModel liveGiftModel = new LiveGiftModel();
                    liveGiftModel.anim_code = liveRecordLevelGestureModel2.code;
                    liveGiftModel.resource_url = liveRecordLevelGestureModel2.resource;
                    this.g.a(liveGiftModel, new ISetStickerListener() { // from class: com.blued.android.module.live_china.view.PopGestureView.4
                        @Override // com.blued.android.module.external_sense_library.contract.ISetStickerListener
                        public void onFailed(ErrorCode.PlayStickerCode playStickerCode, String str) {
                            Log.v("pk", "setDataToView onFailed:" + playStickerCode + " -- " + str);
                        }

                        @Override // com.blued.android.module.external_sense_library.contract.ISetStickerListener
                        public void onSetSticker() {
                            Log.v("pk", "setDataToView onSetSticker");
                        }
                    });
                    return;
                }
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        this.l.setVisibility(0);
        ImageLoader.a(this.f.getFragmentActive(), str).a(this.l);
        AppInfo.n().removeCallbacks(this.n);
        AppInfo.n().postDelayed(this.n, 5000L);
    }

    private void g() {
        LayoutInflater from = LayoutInflater.from(this.b);
        this.f15021a = from;
        View inflate = from.inflate(R.layout.pop_window_record_level_gesture, (ViewGroup) null);
        this.f15022c = inflate.findViewById(R.id.tv_bg);
        this.h = (PullToRefreshRecyclerView) inflate.findViewById(R.id.live_gesture_recycler_view);
        this.l = (ImageView) inflate.findViewById(R.id.live_gesture_tip_view);
        this.i = inflate.findViewById(R.id.ll_loading);
        this.j = this.h.getRefreshableView();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.b);
        linearLayoutManager.setOrientation(0);
        this.j.setLayoutManager(linearLayoutManager);
        GestureAdapter gestureAdapter = new GestureAdapter();
        this.k = gestureAdapter;
        this.j.setAdapter(gestureAdapter);
        this.f15022c.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.PopGestureView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                PopGestureView.this.c();
            }
        });
        View findViewById = inflate.findViewById(R.id.ll_content);
        this.d = findViewById;
        findViewById.setVisibility(8);
        this.d.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.PopGestureView.2
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
        BluedUIHttpResponse<BluedEntityA<LiveRecordLevelGestureModel>> bluedUIHttpResponse = new BluedUIHttpResponse<BluedEntityA<LiveRecordLevelGestureModel>>("RecordLevelGesture", this.f.getFragmentActive()) { // from class: com.blued.android.module.live_china.view.PopGestureView.3
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUICache(BluedEntityA<LiveRecordLevelGestureModel> bluedEntityA) {
                PopGestureView.this.a(bluedEntityA);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: b */
            public void onUIUpdate(BluedEntityA<LiveRecordLevelGestureModel> bluedEntityA) {
                PopGestureView.this.a(bluedEntityA);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str) {
                return super.onUIFailure(i, str);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
                PopGestureView.this.i.setVisibility(8);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
                PopGestureView.this.i.setVisibility(0);
            }
        };
        LiveRoomHttpUtils.u(bluedUIHttpResponse, this.f.t + "");
    }

    public void b() {
        RecordingOnliveFragment recordingOnliveFragment = this.f;
        if (recordingOnliveFragment != null) {
            recordingOnliveFragment.O();
        }
        this.f15022c.clearAnimation();
        this.d.clearAnimation();
        if (this.e.isShowing()) {
            this.e.a();
        }
        this.e.showAtLocation(this.d, 81, 0, 0);
        this.d.setVisibility(0);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.b, R.anim.push_bottom_in);
        this.d.startAnimation(loadAnimation);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.blued.android.module.live_china.view.PopGestureView.5
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                PopGestureView.this.a();
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
        AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.module.live_china.view.PopGestureView.6
            @Override // java.lang.Runnable
            public void run() {
                PopGestureView.this.e.a();
            }
        }, 300L);
    }

    public void d() {
        GestureAdapter gestureAdapter;
        String q = LiveRoomPreferences.q();
        Log.v("pk", "initData code:" + q);
        if (TextUtils.isEmpty(q) || (gestureAdapter = this.k) == null || gestureAdapter.getData() == null) {
            return;
        }
        for (LiveRecordLevelGestureModel liveRecordLevelGestureModel : this.k.getData()) {
            if (TextUtils.equals(q, liveRecordLevelGestureModel.code)) {
                liveRecordLevelGestureModel.isSelect = true;
                LiveGiftModel liveGiftModel = new LiveGiftModel();
                liveGiftModel.anim_code = liveRecordLevelGestureModel.code;
                liveGiftModel.resource_url = liveRecordLevelGestureModel.resource;
                this.g.a(liveGiftModel, new ISetStickerListener() { // from class: com.blued.android.module.live_china.view.PopGestureView.7
                    @Override // com.blued.android.module.external_sense_library.contract.ISetStickerListener
                    public void onFailed(ErrorCode.PlayStickerCode playStickerCode, String str) {
                        Log.v("pk", "initData onFailed:" + playStickerCode + " -- " + str);
                    }

                    @Override // com.blued.android.module.external_sense_library.contract.ISetStickerListener
                    public void onSetSticker() {
                        Log.v("pk", "initData onSetSticker");
                    }
                });
                return;
            }
        }
    }

    public void e() {
        if (this.m != null) {
            this.g.a((LiveGiftModel) null, (ISetStickerListener) null);
        }
    }

    public void f() {
        if (this.m != null) {
            LiveGiftModel liveGiftModel = new LiveGiftModel();
            liveGiftModel.anim_code = this.m.code;
            liveGiftModel.resource_url = this.m.resource;
            this.g.a(liveGiftModel, new ISetStickerListener() { // from class: com.blued.android.module.live_china.view.PopGestureView.8
                @Override // com.blued.android.module.external_sense_library.contract.ISetStickerListener
                public void onFailed(ErrorCode.PlayStickerCode playStickerCode, String str) {
                    Log.v("pk", "start onFailed:" + playStickerCode + " -- " + str);
                }

                @Override // com.blued.android.module.external_sense_library.contract.ISetStickerListener
                public void onSetSticker() {
                    Log.v("pk", "start onSetSticker");
                }
            });
        }
    }
}
