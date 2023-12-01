package com.blued.android.module.live_china.adapter;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.common.utils.AvatarUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.model.LiveFriendModel;
import com.blued.android.module.live_china.model.LiveRoomUserModel;
import com.bytedance.applog.tracker.Tracker;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/adapter/LiveMakeFriendAdapter.class */
public class LiveMakeFriendAdapter extends BaseAdapter {
    public Context a;
    public List<LiveFriendModel> b = new ArrayList();
    public LoadOptions c;
    public LayoutInflater d;
    public LiveJoinListener e;
    public int f;
    public ListView g;

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/adapter/LiveMakeFriendAdapter$LiveJoinListener.class */
    public interface LiveJoinListener {
        void a(LiveFriendModel liveFriendModel, int i);

        void a(LiveFriendModel liveFriendModel, int i, TextView textView);

        void b(LiveFriendModel liveFriendModel, int i, TextView textView);
    }

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/adapter/LiveMakeFriendAdapter$ViewHolder.class */
    class ViewHolder {
        private ImageView b;
        private ImageView c;
        private TextView d;
        private ImageView e;
        private TextView f;
        private TextView g;
        private TextView h;

        private ViewHolder() {
        }
    }

    public LiveMakeFriendAdapter(Context context, LiveJoinListener liveJoinListener, int i, ListView listView) {
        this.a = context;
        this.e = liveJoinListener;
        this.d = LayoutInflater.from(context);
        this.f = i;
        this.g = listView;
        LoadOptions loadOptions = new LoadOptions();
        this.c = loadOptions;
        loadOptions.d = R.drawable.user_bg_round;
        this.c.b = R.drawable.user_bg_round;
    }

    public void a(LiveFriendModel liveFriendModel) {
        List<LiveFriendModel> list = this.b;
        if (list == null || list.size() <= 0) {
            return;
        }
        this.b.remove(liveFriendModel);
        notifyDataSetChanged();
    }

    public void a(List<LiveFriendModel> list) {
        this.b.clear();
        b(list);
    }

    public void b(List<LiveFriendModel> list) {
        int i;
        this.b.addAll(list);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            i = 0;
            if (i3 >= list.size()) {
                break;
            }
            LiveFriendModel liveFriendModel = list.get(i3);
            if (TextUtils.equals(LiveRoomInfo.a().f(), liveFriendModel.uid)) {
                liveFriendModel.isMyself = 1;
                i = i3;
                break;
            }
            i2 = i3 + 1;
        }
        notifyDataSetChanged();
        if (i != 0) {
            final int i4 = i;
            AppInfo.n().post(new Runnable() { // from class: com.blued.android.module.live_china.adapter.LiveMakeFriendAdapter.1
                @Override // java.lang.Runnable
                public void run() {
                    LiveMakeFriendAdapter.this.g.smoothScrollToPositionFromTop(i4, DensityUtils.a(LiveMakeFriendAdapter.this.a, 120.0f));
                }
            });
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.b.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.b.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        View view2;
        ViewHolder viewHolder;
        if (view == null) {
            viewHolder = new ViewHolder();
            view2 = this.d.inflate(R.layout.item_live_make_friend_list, viewGroup, false);
            viewHolder.b = (ImageView) view2.findViewById(R.id.img_header);
            viewHolder.c = (ImageView) view2.findViewById(R.id.img_verify);
            viewHolder.d = (TextView) view2.findViewById(R.id.tv_name);
            viewHolder.e = (ImageView) view2.findViewById(R.id.img_vip_icon);
            viewHolder.f = (TextView) view2.findViewById(R.id.tv_join);
            viewHolder.g = (TextView) view2.findViewById(R.id.tv_ignore);
            viewHolder.h = (TextView) view2.findViewById(R.id.tv_number);
            view2.setTag(viewHolder);
        } else {
            view2 = view;
            viewHolder = (ViewHolder) view.getTag();
        }
        final LiveFriendModel liveFriendModel = this.b.get(i);
        LiveRoomInfo.a().a(viewHolder.c, liveFriendModel.vbadge);
        ImageLoader.a((IRequestHost) null, AvatarUtils.a(0, liveFriendModel.avatar)).b(R.drawable.user_bg_round).c().a(viewHolder.b);
        LiveRoomUserModel liveRoomUserModel = new LiveRoomUserModel();
        liveRoomUserModel.vip_grade = liveFriendModel.vip_grade;
        liveRoomUserModel.is_vip_annual = liveFriendModel.is_vip_annual;
        liveRoomUserModel.is_hide_vip_look = liveFriendModel.is_hide_vip_look;
        LiveRoomInfo.a().a(viewHolder.e, liveRoomUserModel);
        if (!TextUtils.isEmpty(liveFriendModel.note)) {
            viewHolder.d.setText(liveFriendModel.note);
        } else if (TextUtils.isEmpty(liveFriendModel.name)) {
            viewHolder.d.setText("");
        } else {
            viewHolder.d.setText(liveFriendModel.name);
        }
        LiveRoomInfo.a().a(this.a, viewHolder.d, liveRoomUserModel, R.color.syc_dark_h);
        viewHolder.b.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.adapter.LiveMakeFriendAdapter.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view3) {
                Tracker.onClick(view3);
                if (LiveMakeFriendAdapter.this.e != null) {
                    LiveMakeFriendAdapter.this.e.a(liveFriendModel, i);
                }
            }
        });
        viewHolder.d.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.adapter.LiveMakeFriendAdapter.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view3) {
                Tracker.onClick(view3);
                if (LiveMakeFriendAdapter.this.e != null) {
                    LiveMakeFriendAdapter.this.e.a(liveFriendModel, i);
                }
            }
        });
        final ViewHolder viewHolder2 = viewHolder;
        viewHolder.f.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.adapter.LiveMakeFriendAdapter.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view3) {
                Tracker.onClick(view3);
                if (LiveMakeFriendAdapter.this.e != null) {
                    viewHolder2.f.setEnabled(false);
                    LiveMakeFriendAdapter.this.e.a(liveFriendModel, i, viewHolder2.f);
                }
            }
        });
        final ViewHolder viewHolder3 = viewHolder;
        viewHolder.g.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.adapter.LiveMakeFriendAdapter.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view3) {
                Tracker.onClick(view3);
                if (LiveMakeFriendAdapter.this.e != null) {
                    viewHolder3.g.setEnabled(false);
                    LiveMakeFriendAdapter.this.e.b(liveFriendModel, i, viewHolder3.g);
                }
            }
        });
        TextView textView = viewHolder.h;
        textView.setText((i + 1) + "");
        if (this.f == 0) {
            viewHolder.f.setVisibility(0);
            viewHolder.g.setVisibility(0);
        } else {
            viewHolder.f.setVisibility(8);
            viewHolder.g.setVisibility(8);
        }
        if (liveFriendModel.isMyself == 1) {
            view2.setBackgroundColor(Color.parseColor("#33996afb"));
            return view2;
        }
        view2.setBackgroundResource(R.color.transparent);
        return view2;
    }
}
