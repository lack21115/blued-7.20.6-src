package com.soft.blued.ui.live.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.R;
import com.soft.blued.ui.live.model.LiveJoinFansModel;
import com.soft.blued.ui.live.model.LiveJoinFansPrivilegeModel;
import com.soft.blued.ui.live.view.LineView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/live/adapter/LiveJoinFansAdapater.class */
public class LiveJoinFansAdapater extends BaseMultiItemQuickAdapter<LiveJoinFansModel, BaseViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    public EventCallBack f17390a;
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private IRequestHost f17391c;
    private List<LiveJoinFansModel> d;
    private TextView e;

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/live/adapter/LiveJoinFansAdapater$EventCallBack.class */
    public interface EventCallBack {
        void a();

        void a(String str, int i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/live/adapter/LiveJoinFansAdapater$PrivilegeAdapter.class */
    public class PrivilegeAdapter extends BaseQuickAdapter<LiveJoinFansPrivilegeModel, BaseViewHolder> {
        private IRequestHost b;

        public PrivilegeAdapter(IRequestHost iRequestHost, List<LiveJoinFansPrivilegeModel> list) {
            super((int) R.layout.live_join_fans_privilege_item_view);
            this.b = iRequestHost;
            setNewData(list);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.chad.library.adapter.base.BaseQuickAdapter
        /* renamed from: a */
        public void convert(BaseViewHolder baseViewHolder, LiveJoinFansPrivilegeModel liveJoinFansPrivilegeModel) {
            ImageLoader.a(this.b, !TextUtils.isEmpty(liveJoinFansPrivilegeModel.icon) ? liveJoinFansPrivilegeModel.icon : liveJoinFansPrivilegeModel.icon_gray).a(baseViewHolder.getView(R.id.auto_view));
            ((TextView) baseViewHolder.getView(2131372046)).setText(liveJoinFansPrivilegeModel.title);
        }
    }

    public LiveJoinFansAdapater(IRequestHost iRequestHost, Context context) {
        super(new ArrayList());
        this.b = context;
        this.f17391c = iRequestHost;
        this.d = new ArrayList();
        addItemType(1, R.layout.live_join_fans_item_title);
        addItemType(0, R.layout.live_join_fans_item_view);
        setNewData(this.d);
    }

    private void b(final BaseViewHolder baseViewHolder, final LiveJoinFansModel liveJoinFansModel) {
        long j;
        final View view = baseViewHolder.getView(2131367999);
        view.setVisibility(liveJoinFansModel.isOpen ? 0 : 8);
        ((TextView) baseViewHolder.getView(2131372046)).setText(String.format(this.mContext.getResources().getString(R.string.live_fans_owner), liveJoinFansModel.anchor_name));
        TextView textView = (TextView) baseViewHolder.getView(2131371801);
        textView.setText(liveJoinFansModel.level + "");
        View view2 = baseViewHolder.getView(2131367961);
        ImageView imageView = (ImageView) baseViewHolder.getView(2131365485);
        if (liveJoinFansModel.brand_status == 1) {
            textView.setTextColor(AppInfo.d().getResources().getColor(2131102063));
            view2.setBackgroundResource(2131234921);
            imageView.setImageResource(2131234925);
        } else {
            textView.setTextColor(AppInfo.d().getResources().getColor(2131101964));
            view2.setBackgroundResource(2131234922);
            imageView.setImageResource(2131234926);
        }
        TextView textView2 = (TextView) baseViewHolder.getView(2131371409);
        textView2.setText(liveJoinFansModel.name);
        textView2.getPaint().setFakeBoldText(true);
        textView.getPaint().setFakeBoldText(true);
        final TextView textView3 = (TextView) baseViewHolder.getView(R.id.tv_quit);
        textView3.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.live.adapter.LiveJoinFansAdapater.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view3) {
                Tracker.onClick(view3);
                CommonAlertDialog.a(LiveJoinFansAdapater.this.mContext, LiveJoinFansAdapater.this.mContext.getResources().getString(R.string.live_fans_quit_title), "", LiveJoinFansAdapater.this.mContext.getResources().getString(2131887281), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.live.adapter.LiveJoinFansAdapater.1.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Tracker.onClick(dialogInterface, i);
                        if (LiveJoinFansAdapater.this.f17390a != null) {
                            LiveJoinFansAdapater.this.f17390a.a(liveJoinFansModel.anchor, baseViewHolder.getLayoutPosition());
                        }
                    }
                }, LiveJoinFansAdapater.this.mContext.getResources().getString(R.string.live_fans_quit_cancel), (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
            }
        });
        final ImageView imageView2 = (ImageView) baseViewHolder.getView(R.id.iv_switch);
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.live.adapter.LiveJoinFansAdapater.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view3) {
                LiveJoinFansModel liveJoinFansModel2;
                Context context;
                int i;
                Tracker.onClick(view3);
                liveJoinFansModel.isOpen = !liveJoinFansModel2.isOpen;
                ImageView imageView3 = imageView2;
                if (liveJoinFansModel.isOpen) {
                    context = LiveJoinFansAdapater.this.b;
                    i = 2131234959;
                } else {
                    context = LiveJoinFansAdapater.this.b;
                    i = 2131234915;
                }
                imageView3.setImageDrawable(BluedSkinUtils.b(context, i));
                view.setVisibility(liveJoinFansModel.isOpen ? 0 : 8);
                textView3.setVisibility(liveJoinFansModel.isOpen ? 0 : 8);
            }
        });
        try {
            j = ((liveJoinFansModel.relation * 1.0f) * 100.0f) / liveJoinFansModel.next_level_relation;
        } catch (ArithmeticException e) {
            j = 0;
        }
        ((ProgressBar) baseViewHolder.getView(R.id.bar_fans)).setProgress((int) j);
        ((TextView) baseViewHolder.getView(R.id.tv_bar_tip)).setText(String.format(this.b.getResources().getString(R.string.live_fans_relation_next_level), Integer.valueOf(liveJoinFansModel.next_level_relation - liveJoinFansModel.relation)));
        RecyclerView recyclerView = (RecyclerView) baseViewHolder.getView(R.id.rv_function);
        recyclerView.setLayoutManager(new GridLayoutManager(this.mContext, 3));
        recyclerView.setAdapter(new PrivilegeAdapter(this.f17391c, liveJoinFansModel.privilege_list));
        ((TextView) baseViewHolder.getView(R.id.tv_today)).setText(this.b.getResources().getString(R.string.live_fans_relation_level) + liveJoinFansModel.relation_today);
        ((LineView) baseViewHolder.getView(R.id.line_view)).setData(liveJoinFansModel.relation_days);
    }

    public int a() {
        if (getData() != null) {
            return getData().size();
        }
        return 0;
    }

    public void a(int i) {
        remove(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, LiveJoinFansModel liveJoinFansModel) {
        if (baseViewHolder != null) {
            int itemViewType = baseViewHolder.getItemViewType();
            if (itemViewType == 0) {
                b(baseViewHolder, liveJoinFansModel);
            } else if (itemViewType != 1) {
            } else {
                TextView textView = (TextView) baseViewHolder.getView(R.id.tv_fans_num);
                this.e = textView;
                textView.setText(String.format(this.mContext.getString(R.string.live_fans_added), Integer.valueOf(a() - 1)));
            }
        }
    }

    public void a(EventCallBack eventCallBack) {
        this.f17390a = eventCallBack;
    }

    public void a(String str) {
        int i;
        EventCallBack eventCallBack;
        int i2 = 0;
        while (true) {
            i = i2;
            if (i >= getData().size()) {
                i = -1;
                break;
            } else if (TextUtils.equals(str, ((LiveJoinFansModel) getData().get(i)).anchor)) {
                break;
            } else {
                i2 = i + 1;
            }
        }
        if (i >= 0) {
            a(i);
            TextView textView = this.e;
            if (textView != null) {
                textView.setText(String.format(this.mContext.getString(R.string.live_fans_added), Integer.valueOf(a() - 1)));
            }
        }
        if (a() - 1 > 0 || (eventCallBack = this.f17390a) == null) {
            return;
        }
        eventCallBack.a();
    }

    public void a(List<LiveJoinFansModel> list) {
        if (list == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (list.size() > 0) {
            LiveJoinFansModel liveJoinFansModel = new LiveJoinFansModel();
            liveJoinFansModel.itemCusType = 1;
            arrayList.add(liveJoinFansModel);
            arrayList.addAll(list);
        }
        setNewData(arrayList);
    }
}
