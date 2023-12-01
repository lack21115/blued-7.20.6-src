package com.blued.android.module.live_china.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.anythink.core.common.g.g;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.model.TaskModel;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.constant.EventBusConstant;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/PopTaskView.class */
public class PopTaskView {

    /* renamed from: a  reason: collision with root package name */
    private LayoutInflater f15224a;
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private View f15225c;
    private View d;
    private MyPopupWindow e;
    private View f;
    private RecyclerView g;
    private MyAdapter h;
    private String i;
    private String j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/PopTaskView$MyAdapter.class */
    public class MyAdapter extends BaseQuickAdapter<TaskModel, BaseViewHolder> {
        public MyAdapter() {
            super(R.layout.item_live_task, null);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.chad.library.adapter.base.BaseQuickAdapter
        /* renamed from: a */
        public void convert(BaseViewHolder baseViewHolder, final TaskModel taskModel) {
            ImageView imageView = (ImageView) baseViewHolder.getView(R.id.iv_icon);
            TextView textView = (TextView) baseViewHolder.getView(R.id.tv_name);
            TextView textView2 = (TextView) baseViewHolder.getView(R.id.tv_prize);
            ShapeTextView shapeTextView = (ShapeTextView) baseViewHolder.getView(R.id.tv_status);
            ImageLoader.a((IRequestHost) null, taskModel.task_icon).a(imageView);
            textView.setText(taskModel.task_name);
            textView2.setText(taskModel.task_prize);
            int i = taskModel.status;
            if (i == 0) {
                ShapeHelper.a(shapeTextView, R.color.syc_E2E2E2, R.color.syc_E2E2E2);
                shapeTextView.setText(this.mContext.getString(R.string.live_daily_task_unfinished));
                shapeTextView.setTextColor(this.mContext.getResources().getColor(R.color.syc_b));
            } else if (i == 1) {
                ShapeHelper.a(shapeTextView, R.color.syc_w_996AFB, R.color.syc_w_465CF2);
                shapeTextView.setText(this.mContext.getString(R.string.live_daily_task_receive));
                shapeTextView.setTextColor(this.mContext.getResources().getColor(R.color.syc_b));
            } else if (i == 2) {
                ShapeHelper.a(shapeTextView, R.color.syc_dark_b, R.color.syc_dark_b);
                shapeTextView.setText(this.mContext.getString(R.string.live_daily_task_completed));
                shapeTextView.setTextColor(this.mContext.getResources().getColor(R.color.syc_w));
            }
            shapeTextView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.PopTaskView.MyAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    if (taskModel.status == 1) {
                        PopTaskView.this.a(taskModel);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/PopTaskView$MyPopupWindow.class */
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
                PopTaskView.this.a();
            } catch (Exception e) {
                a();
            }
        }
    }

    public PopTaskView(Context context) {
        this.b = context;
        b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final TaskModel taskModel) {
        if (!TextUtils.isEmpty(this.i)) {
            EventTrackLive.a(LiveProtos.Event.LIVE_TASK_AWARD_CLICK, this.i, this.j, EventTrackLive.a(taskModel.task_id));
        }
        LiveRoomHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<TaskModel>>() { // from class: com.blued.android.module.live_china.view.PopTaskView.5
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<TaskModel> bluedEntityA) {
                if (bluedEntityA.getSingleData() == null) {
                    return;
                }
                taskModel.status = 2;
                PopTaskView.this.h.notifyDataSetChanged();
                if (!TextUtils.isEmpty(bluedEntityA.getSingleData().copywriting)) {
                    AppMethods.a((CharSequence) bluedEntityA.getSingleData().copywriting);
                }
                if (taskModel.task_id == 1) {
                    LiveEventBus.get("live_msg_daily_task_complete").post(-10000);
                }
                if (taskModel.task_id == 2) {
                    LiveEventBus.get("live_msg_daily_task_complete").post(Integer.valueOf((int) g.j));
                }
                LiveEventBus.get(EventBusConstant.KEY_EVENT_LIVE_REFRESH_GIFT_LIST).post(true);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str, String str2) {
                return super.onUIFailure(i, str, str2);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                PopTaskView.this.h.notifyDataSetChanged();
            }
        }, LiveRoomInfo.a().f(), String.valueOf(taskModel.task_id));
    }

    private void b() {
        LayoutInflater from = LayoutInflater.from(this.b);
        this.f15224a = from;
        View inflate = from.inflate(R.layout.pop_window_live_task, (ViewGroup) null);
        View findViewById = inflate.findViewById(R.id.tv_bg);
        this.f15225c = findViewById;
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.PopTaskView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                PopTaskView.this.a();
            }
        });
        View findViewById2 = inflate.findViewById(R.id.content);
        this.d = findViewById2;
        findViewById2.setVisibility(8);
        this.d.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.PopTaskView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
            }
        });
        this.d.findViewById(R.id.iv_close).setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.PopTaskView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                PopTaskView.this.a();
            }
        });
        this.f = this.d.findViewById(R.id.loading);
        RecyclerView recyclerView = (RecyclerView) this.d.findViewById(R.id.recycler_view);
        this.g = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this.b));
        MyAdapter myAdapter = new MyAdapter();
        this.h = myAdapter;
        this.g.setAdapter(myAdapter);
        MyPopupWindow myPopupWindow = new MyPopupWindow(inflate, -1, -1, true);
        this.e = myPopupWindow;
        myPopupWindow.setBackgroundDrawable(this.b.getResources().getDrawable(17170445));
        this.e.setTouchable(true);
        this.e.setOutsideTouchable(true);
        this.e.setFocusable(true);
        this.e.update();
    }

    private void c() {
        LiveRoomHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<TaskModel>>() { // from class: com.blued.android.module.live_china.view.PopTaskView.4
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<TaskModel> bluedEntityA) {
                if (bluedEntityA.hasData()) {
                    PopTaskView.this.g.setVisibility(0);
                    PopTaskView.this.h.setNewData(bluedEntityA.data);
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str, String str2) {
                return super.onUIFailure(i, str, str2);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                PopTaskView.this.f.setVisibility(4);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
                PopTaskView.this.f.setVisibility(0);
                PopTaskView.this.g.setVisibility(8);
            }
        });
    }

    public void a() {
        LiveEventBus.get(EventBusConstant.KEY_EVENT_LIVE_SHOW_DIALOG).post(false);
        this.d.setVisibility(8);
        this.d.startAnimation(AnimationUtils.loadAnimation(this.b, R.anim.push_bottom_out));
        AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.module.live_china.view.PopTaskView.6
            @Override // java.lang.Runnable
            public void run() {
                PopTaskView.this.e.a();
            }
        }, 300L);
    }

    public void a(long j, String str) {
        if (j == 0) {
            return;
        }
        this.i = String.valueOf(j);
        this.j = str;
        EventTrackLive.a(LiveProtos.Event.LIVE_TASK_BTN_CLICK, this.i, this.j);
        LiveEventBus.get(EventBusConstant.KEY_EVENT_LIVE_SHOW_DIALOG).post(true);
        this.f15225c.clearAnimation();
        this.d.clearAnimation();
        if (this.e.isShowing()) {
            this.e.a();
        }
        this.e.showAtLocation(this.d, 81, 0, 0);
        this.d.setVisibility(0);
        this.d.startAnimation(AnimationUtils.loadAnimation(this.b, R.anim.push_bottom_in));
        c();
    }
}
