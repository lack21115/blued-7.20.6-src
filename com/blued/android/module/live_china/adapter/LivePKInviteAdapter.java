package com.blued.android.module.live_china.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.common.utils.AvatarUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.model.LiveFriendModel;
import com.blued.android.module.live_china.model.LiveRoomUserModel;
import com.bytedance.applog.tracker.Tracker;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/adapter/LivePKInviteAdapter.class */
public class LivePKInviteAdapter extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    public Context f11673a;
    public List<LiveFriendModel> b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public LoadOptions f11674c;
    public LayoutInflater d;
    public LiveInviteListener e;
    public int f;

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/adapter/LivePKInviteAdapter$LiveInviteListener.class */
    public interface LiveInviteListener {
        void a(LiveFriendModel liveFriendModel, int i);
    }

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/adapter/LivePKInviteAdapter$ViewHolder.class */
    class ViewHolder {
        private ImageView b;

        /* renamed from: c  reason: collision with root package name */
        private ImageView f11678c;
        private TextView d;
        private ImageView e;
        private TextView f;

        private ViewHolder() {
        }
    }

    public LivePKInviteAdapter(Context context, LiveInviteListener liveInviteListener) {
        this.f11673a = context;
        this.e = liveInviteListener;
        this.d = LayoutInflater.from(context);
        int i = this.f11673a.getResources().getDisplayMetrics().widthPixels;
        LoadOptions loadOptions = new LoadOptions();
        this.f11674c = loadOptions;
        loadOptions.d = R.drawable.user_bg_round;
        this.f11674c.b = R.drawable.user_bg_round;
        int i2 = i >> 1;
        this.f11674c.a(i2, i2);
    }

    public void a(int i) {
        this.f = i;
    }

    public void a(List<LiveFriendModel> list) {
        this.b.clear();
        b(list);
        notifyDataSetChanged();
    }

    public void b(List<LiveFriendModel> list) {
        this.b.addAll(list);
        notifyDataSetChanged();
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
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        View view2;
        ViewHolder viewHolder;
        if (view == null) {
            viewHolder = new ViewHolder();
            view2 = this.d.inflate(R.layout.item_live_pk_friend_list, viewGroup, false);
            viewHolder.b = (ImageView) view2.findViewById(R.id.img_header);
            viewHolder.f11678c = (ImageView) view2.findViewById(R.id.img_verify);
            viewHolder.d = (TextView) view2.findViewById(R.id.tv_name);
            viewHolder.e = (ImageView) view2.findViewById(R.id.img_vip_icon);
            viewHolder.f = (TextView) view2.findViewById(R.id.invite_btn);
            view2.setTag(viewHolder);
        } else {
            view2 = view;
            viewHolder = (ViewHolder) view.getTag();
        }
        final LiveFriendModel liveFriendModel = this.b.get(i);
        LiveRoomInfo.a().a(viewHolder.f11678c, liveFriendModel.vbadge);
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
        LiveRoomInfo.a().a(this.f11673a, viewHolder.d, liveRoomUserModel, R.color.syc_dark_222222);
        if (this.f == 0) {
            viewHolder.f.setText(R.string.live_pk_invite);
        } else {
            viewHolder.f.setText(R.string.live_connection_invite);
        }
        viewHolder.f.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.adapter.LivePKInviteAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view3) {
                Tracker.onClick(view3);
                if (LivePKInviteAdapter.this.e != null) {
                    LivePKInviteAdapter.this.e.a(liveFriendModel, i);
                }
            }
        });
        return view2;
    }
}
