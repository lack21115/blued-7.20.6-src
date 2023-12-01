package com.blued.android.module.live_china.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.utils.toast.ToastUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.BluedLiveTopCard;
import com.blued.android.module.live_china.model.LiveTaskListModel;
import com.blued.android.module.live_china.model.LiveTaskListModelExtra;
import com.blued.android.module.live_china.observer.LiveRefreshUIObserver;
import com.blued.android.module.live_china.observer.LiveSetDataObserver;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.bytedance.applog.tracker.Tracker;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveAnchorTaskView.class */
public class LiveAnchorTaskView extends FrameLayout implements View.OnClickListener {
    private LinearLayout a;
    private LinearLayout b;
    private CardView c;
    private PopupWindow d;
    private TaskDialogHolder e;
    private LayoutInflater f;
    private BaseFragment g;
    private String h;
    private boolean i;
    private long j;

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveAnchorTaskView$TaskDialogHolder.class */
    public class TaskDialogHolder {
        ShapeTextView a;
        TextView b;
        TextView c;
        ShapeTextView d;
        TextView e;
        TextView f;
        ShapeTextView g;
        TextView h;
        TextView i;
        ShapeTextView j;
        TextView k;
        TextView l;
        ImageView m;
        LinearLayout n;
        TextView o;
        TextView p;
        TextView q;
        TextView r;
        TextView s;

        public TaskDialogHolder(View view) {
            this.a = (ShapeTextView) view.findViewById(R.id.live_receive_fans);
            this.b = (TextView) view.findViewById(R.id.live_fans_count);
            this.c = (TextView) view.findViewById(R.id.live_fans_award);
            this.d = (ShapeTextView) view.findViewById(R.id.live_receive_coin);
            this.e = (TextView) view.findViewById(R.id.live_coin_count);
            this.f = (TextView) view.findViewById(R.id.live_coin_award);
            this.g = (ShapeTextView) view.findViewById(R.id.live_receive_time);
            this.h = (TextView) view.findViewById(R.id.live_time_count);
            this.i = (TextView) view.findViewById(R.id.live_time_award);
            this.j = (ShapeTextView) view.findViewById(R.id.live_receive_day);
            this.k = (TextView) view.findViewById(R.id.live_day_count);
            this.l = (TextView) view.findViewById(R.id.live_day_award);
            this.p = (TextView) view.findViewById(R.id.live_fans_index);
            this.q = (TextView) view.findViewById(R.id.live_coin_index);
            this.r = (TextView) view.findViewById(R.id.live_time_index);
            this.s = (TextView) view.findViewById(R.id.live_day_index);
            this.m = (ImageView) view.findViewById(R.id.live_task_logo);
            this.n = (LinearLayout) view.findViewById(R.id.live_task_info_layout);
            this.o = (TextView) view.findViewById(R.id.live_task_introduction);
            if (LiveAnchorTaskView.this.i) {
                return;
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.p.getLayoutParams();
            layoutParams.addRule(15);
            this.p.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.q.getLayoutParams();
            layoutParams2.addRule(15);
            this.q.setLayoutParams(layoutParams2);
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.r.getLayoutParams();
            layoutParams3.addRule(15);
            this.r.setLayoutParams(layoutParams3);
            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.s.getLayoutParams();
            layoutParams4.addRule(15);
            this.s.setLayoutParams(layoutParams4);
        }

        public void a() {
            this.d.setEnabled(true);
            ShapeHelper.a(this.d, R.color.syc_w_996AFB, R.color.syc_w_465CF2);
            this.d.setText(LiveAnchorTaskView.this.getResources().getString(R.string.live_ranking_tips));
        }

        public void a(int i) {
            String string;
            if (i == 0) {
                this.a.setEnabled(true);
                ShapeHelper.a(this.a, R.color.syc_w_996AFB, R.color.syc_w_465CF2);
                string = LiveAnchorTaskView.this.getResources().getString(R.string.live_reward_follow);
            } else {
                this.a.setEnabled(false);
                ShapeHelper.a(this.a, R.color.syc_dark_z, R.color.syc_dark_z);
                string = LiveAnchorTaskView.this.getResources().getString(R.string.live_chat_followed);
            }
            this.a.setText(string);
        }

        public void a(ShapeTextView shapeTextView, int i) {
            if (i == 0) {
                shapeTextView.setEnabled(false);
                ShapeHelper.a(shapeTextView, R.color.syc_dark_z, R.color.syc_dark_z);
                shapeTextView.setText(LiveAnchorTaskView.this.getContext().getResources().getString(R.string.live_box_receive));
            } else if (i == 1) {
                shapeTextView.setEnabled(true);
                ShapeHelper.a(shapeTextView, R.color.syc_w_996AFB, R.color.syc_w_465CF2);
                shapeTextView.setText(LiveAnchorTaskView.this.getContext().getResources().getString(R.string.live_box_receive));
            } else if (i != 2) {
            } else {
                shapeTextView.setEnabled(false);
                ShapeHelper.a(shapeTextView, R.color.syc_dark_z, R.color.syc_dark_z);
                shapeTextView.setText(LiveAnchorTaskView.this.getContext().getResources().getString(R.string.live_box_receive_ok));
            }
        }
    }

    public LiveAnchorTaskView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.j = 0L;
        a();
    }

    public LiveAnchorTaskView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.j = 0L;
        a();
    }

    private void a() {
        LayoutInflater from = LayoutInflater.from(getContext());
        this.f = from;
        from.inflate(R.layout.live_anchor_task_layout, (ViewGroup) this, true);
        this.c = findViewById(R.id.live_task_root_view);
        this.a = (LinearLayout) findViewById(R.id.live_anchor_layout);
        this.b = (LinearLayout) findViewById(R.id.live_task_list);
        this.a.setOnClickListener(this);
    }

    private void a(TextView textView, int i, Object... objArr) {
        textView.setText(String.format(getContext().getResources().getString(i), objArr));
    }

    private void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        LiveRoomHttpUtils.a(LiveRoomManager.a().d(), str, new BluedUIHttpResponse<BluedEntityA<BluedLiveTopCard>>(this.g.getFragmentActive()) { // from class: com.blued.android.module.live_china.view.LiveAnchorTaskView.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<BluedLiveTopCard> bluedEntityA) {
                if (bluedEntityA == null || bluedEntityA.data == null || bluedEntityA.data.isEmpty()) {
                    return;
                }
                ToastUtils.a("领取成功", 0);
                LiveAnchorTaskView.this.getTaskList();
            }
        }, this.g.getFragmentActive());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<LiveTaskListModel> list, LiveTaskListModelExtra liveTaskListModelExtra) {
        View inflate = this.f.inflate(R.layout.live_pop_anchor_task, (ViewGroup) null);
        this.e = new TaskDialogHolder(inflate);
        b(list, liveTaskListModelExtra);
        this.e.a.setOnClickListener(this);
        this.e.d.setOnClickListener(this);
        this.e.g.setOnClickListener(this);
        this.e.j.setOnClickListener(this);
        if (this.i) {
            this.e.g.setVisibility(0);
            this.e.j.setVisibility(0);
            this.e.n.setVisibility(0);
            this.e.c.setVisibility(0);
            this.e.f.setVisibility(0);
            this.e.i.setVisibility(0);
            this.e.l.setVisibility(0);
        } else {
            this.e.g.setVisibility(4);
            this.e.j.setVisibility(4);
            this.e.n.setVisibility(8);
            this.e.c.setVisibility(8);
            this.e.f.setVisibility(8);
            this.e.i.setVisibility(8);
            this.e.l.setVisibility(8);
        }
        int a = AppInfo.l - (DensityUtils.a(getContext(), 38.0f) * 2);
        int i = (int) (a * 0.3d);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.e.m.getLayoutParams();
        layoutParams.width = a;
        layoutParams.height = i;
        this.e.m.setLayoutParams(layoutParams);
        PopupWindow popupWindow = new PopupWindow(inflate, a, -2);
        this.d = popupWindow;
        popupWindow.setBackgroundDrawable(new ColorDrawable(0));
        this.d.setOutsideTouchable(true);
        this.d.setFocusable(true);
        this.d.update();
        this.d.showAtLocation(((Activity) getContext()).getWindow().getDecorView(), 17, 0, 0);
        this.j = System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(List<LiveTaskListModel> list, LiveTaskListModelExtra liveTaskListModelExtra) {
        if (list == null || list.isEmpty() || this.e == null) {
            return;
        }
        for (LiveTaskListModel liveTaskListModel : list) {
            int i = liveTaskListModel.task_type;
            if (i == 1) {
                this.e.g.setTag(liveTaskListModel.task_id);
                this.e.h.setText(liveTaskListModel.task_text);
                this.e.i.setText(liveTaskListModel.task_reward_text);
                TaskDialogHolder taskDialogHolder = this.e;
                taskDialogHolder.a(taskDialogHolder.g, liveTaskListModel.task_status);
            } else if (i == 2) {
                this.e.d.setTag(liveTaskListModel.task_id);
                this.e.e.setText(liveTaskListModel.task_text);
                this.e.f.setText(liveTaskListModel.task_reward_text);
                if (this.i) {
                    TaskDialogHolder taskDialogHolder2 = this.e;
                    taskDialogHolder2.a(taskDialogHolder2.d, liveTaskListModel.task_status);
                } else {
                    this.e.a();
                }
            } else if (i == 3) {
                this.e.a.setTag(liveTaskListModel.task_id);
                this.e.b.setText(liveTaskListModel.task_text);
                this.e.c.setText(liveTaskListModel.task_reward_text);
                if (this.i) {
                    TaskDialogHolder taskDialogHolder3 = this.e;
                    taskDialogHolder3.a(taskDialogHolder3.a, liveTaskListModel.task_status);
                } else {
                    this.e.a(liveTaskListModelExtra.is_follow);
                }
            } else if (i == 4) {
                this.e.j.setTag(liveTaskListModel.task_id);
                this.e.k.setText(liveTaskListModel.task_text);
                this.e.l.setText(liveTaskListModel.task_reward_text);
                TaskDialogHolder taskDialogHolder4 = this.e;
                taskDialogHolder4.a(taskDialogHolder4.j, liveTaskListModel.task_status);
            }
        }
        if (liveTaskListModelExtra != null) {
            a(this.e.o, R.string.live_task_award_introduction, Integer.valueOf(liveTaskListModelExtra.duration), Integer.valueOf(liveTaskListModelExtra.duration), Integer.valueOf(liveTaskListModelExtra.current_time));
        }
    }

    public void getTaskList() {
        LiveRoomHttpUtils.i(this.h, new BluedUIHttpResponse<BluedEntity<LiveTaskListModel, LiveTaskListModelExtra>>(this.g.getFragmentActive()) { // from class: com.blued.android.module.live_china.view.LiveAnchorTaskView.2
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<LiveTaskListModel, LiveTaskListModelExtra> bluedEntity) {
                if (bluedEntity == null || bluedEntity.data == null || bluedEntity.data.isEmpty()) {
                    LiveAnchorTaskView.this.a.setVisibility(8);
                } else if (LiveAnchorTaskView.this.d == null || !LiveAnchorTaskView.this.d.isShowing()) {
                    LiveAnchorTaskView.this.a.setVisibility(0);
                    LiveAnchorTaskView.this.a(bluedEntity.data, bluedEntity.extra);
                } else {
                    LiveAnchorTaskView.this.b(bluedEntity.data, bluedEntity.extra);
                    LiveAnchorTaskView.this.d.update();
                }
            }
        }, this.g.getFragmentActive());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        if (view.getId() == R.id.live_anchor_layout) {
            PopupWindow popupWindow = this.d;
            if (popupWindow == null || !popupWindow.isShowing()) {
                getTaskList();
            } else if (System.currentTimeMillis() - this.j < 800) {
            } else {
                this.d.dismiss();
            }
        } else if (view.getId() == R.id.live_receive_fans) {
            String str = (String) view.getTag();
            if (this.i) {
                a(str);
                return;
            }
            LiveSetDataObserver.a().l();
            getTaskList();
        } else if (view.getId() != R.id.live_receive_coin) {
            if (view.getId() == R.id.live_receive_time) {
                a((String) view.getTag());
            } else if (view.getId() == R.id.live_receive_day) {
                a((String) view.getTag());
            }
        } else {
            String str2 = (String) view.getTag();
            if (this.i) {
                a(str2);
                return;
            }
            PopupWindow popupWindow2 = this.d;
            if (popupWindow2 != null) {
                popupWindow2.dismiss();
            }
            LiveRefreshUIObserver.a().j();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
    }
}
