package com.blued.android.module.live_china.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.module.common.utils.CommonStringUtils;
import com.blued.android.module.live.base.utils.LiveTimeAndDateUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.fragment.PlayingOnliveBaseModeFragment;
import com.blued.android.module.live_china.fragment.RecordingOnliveFragment;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.model.LiveRewardListModel;
import com.blued.android.module.live_china.observer.LiveSetDataObserver;
import com.blued.android.module.live_china.view.PopRewardListView;
import com.bytedance.applog.tracker.Tracker;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/adapter/RewardListAdapter.class */
public class RewardListAdapter extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private Context f11711a;
    private LayoutInflater b;

    /* renamed from: c  reason: collision with root package name */
    private LoadOptions f11712c;
    private BaseFragment d;
    private PopRewardListView e;
    private List<LiveRewardListModel> f = new ArrayList();
    private long g;

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/adapter/RewardListAdapter$ViewHolder.class */
    class ViewHolder {
        private ImageView b;

        /* renamed from: c  reason: collision with root package name */
        private ImageView f11715c;
        private TextView d;
        private TextView e;
        private TextView f;
        private ImageView g;
        private LinearLayout h;

        private ViewHolder() {
        }
    }

    public RewardListAdapter(BaseFragment baseFragment, PopRewardListView popRewardListView) {
        Context context = baseFragment.getContext();
        this.f11711a = context;
        this.d = baseFragment;
        this.e = popRewardListView;
        this.b = LayoutInflater.from(context);
        LoadOptions loadOptions = new LoadOptions();
        this.f11712c = loadOptions;
        loadOptions.b = R.drawable.user_bg_round;
        this.f11712c.d = R.drawable.user_bg_round;
    }

    public void a(long j) {
        this.g = j;
    }

    public void a(List<LiveRewardListModel> list) {
        this.f.clear();
        Iterator<LiveRewardListModel> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            LiveRewardListModel next = it.next();
            if (next.uid == this.g) {
                next.is_best = true;
                break;
            }
        }
        this.f.addAll(list);
        notifyDataSetChanged();
    }

    public void b(List<LiveRewardListModel> list) {
        Iterator<LiveRewardListModel> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            LiveRewardListModel next = it.next();
            if (next.uid == this.g) {
                next.is_best = true;
                break;
            }
        }
        this.f.addAll(list);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return Integer.valueOf(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        ViewHolder viewHolder;
        if (view == null) {
            viewHolder = new ViewHolder();
            view2 = this.b.inflate(R.layout.live_reward_list_item, viewGroup, false);
            viewHolder.b = (ImageView) view2.findViewById(R.id.header_view);
            viewHolder.f11715c = (ImageView) view2.findViewById(R.id.img_verify);
            viewHolder.d = (TextView) view2.findViewById(R.id.reward_name);
            viewHolder.e = (TextView) view2.findViewById(R.id.reward_time);
            viewHolder.f = (TextView) view2.findViewById(R.id.reward_beans);
            viewHolder.g = (ImageView) view2.findViewById(R.id.iv_beans);
            viewHolder.h = (LinearLayout) view2.findViewById(R.id.beast_layout);
            view2.setTag(viewHolder);
        } else {
            view2 = view;
            viewHolder = (ViewHolder) view.getTag();
        }
        final LiveRewardListModel liveRewardListModel = this.f.get(i);
        ImageLoader.a((IRequestHost) null, liveRewardListModel.avatar).b(R.drawable.user_bg_round).c().a(viewHolder.b);
        LiveRoomInfo.a().a(viewHolder.f11715c, liveRewardListModel.vbadge);
        if (TextUtils.isEmpty(liveRewardListModel.name)) {
            viewHolder.d.setText("");
        } else {
            viewHolder.d.setText(liveRewardListModel.name);
        }
        viewHolder.e.setText(LiveTimeAndDateUtils.b(String.valueOf(liveRewardListModel.time)));
        if (liveRewardListModel.is_prize == 1) {
            viewHolder.f.setText("1");
            viewHolder.g.setImageResource(R.drawable.live_reward_list_header_gift_icon);
        } else {
            viewHolder.f.setText(CommonStringUtils.d(Double.toString(liveRewardListModel.beans)));
            viewHolder.g.setImageResource(R.drawable.live_reward_list_header_bean_icon);
        }
        if (liveRewardListModel.is_best) {
            viewHolder.h.setVisibility(0);
        } else {
            viewHolder.h.setVisibility(4);
        }
        viewHolder.b.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.adapter.RewardListAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view3) {
                Tracker.onClick(view3);
                if (RewardListAdapter.this.d instanceof RecordingOnliveFragment) {
                    ((RecordingOnliveFragment) RewardListAdapter.this.d).dd.b(liveRewardListModel.name);
                } else if (RewardListAdapter.this.d instanceof PlayingOnliveBaseModeFragment) {
                    LiveSetDataObserver.a().d(liveRewardListModel.name);
                }
            }
        });
        return view2;
    }
}
