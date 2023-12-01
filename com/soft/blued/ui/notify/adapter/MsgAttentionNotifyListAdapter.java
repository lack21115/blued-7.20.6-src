package com.soft.blued.ui.notify.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.module.common.user.UserInfoHelper;
import com.blued.android.module.common.utils.AvatarUtils;
import com.blued.android.module.common.utils.TimeAndDateUtils;
import com.blued.community.model.FeedNotice;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.ui.msg.controller.tools.MsgCommonUtils;
import com.soft.blued.ui.user.fragment.UserInfoFragmentNew;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.UserRelationshipUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/notify/adapter/MsgAttentionNotifyListAdapter.class */
public class MsgAttentionNotifyListAdapter extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private LayoutInflater f32879a;
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private List<FeedNotice> f32880c = new ArrayList();
    private IRequestHost d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/notify/adapter/MsgAttentionNotifyListAdapter$ViewHolder.class */
    public class ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        TextView f32883a;
        TextView b;

        /* renamed from: c  reason: collision with root package name */
        TextView f32884c;
        ImageView d;
        ImageView e;
        ImageView f;

        private ViewHolder() {
        }
    }

    public MsgAttentionNotifyListAdapter(IRequestHost iRequestHost, Context context) {
        this.b = context;
        this.d = iRequestHost;
        this.f32879a = LayoutInflater.from(this.b);
    }

    private void a(View view, FeedNotice feedNotice) {
        if (feedNotice.has_read == 0) {
            view.setBackgroundColor(BluedSkinUtils.a(this.b, 2131102360));
        } else {
            view.setBackgroundColor(BluedSkinUtils.a(this.b, 2131101780));
        }
    }

    private void a(FeedNotice feedNotice, TextView textView) {
        if (!TextUtils.isEmpty(feedNotice.note)) {
            textView.setText(feedNotice.note);
        } else if (!TextUtils.isEmpty(feedNotice.name)) {
            textView.setText(feedNotice.name);
        }
        UserRelationshipUtils.a(this.b, textView, feedNotice);
    }

    private void a(FeedNotice feedNotice, ViewHolder viewHolder) {
        if (feedNotice == null) {
            return;
        }
        viewHolder.f32884c.setText(MsgCommonUtils.a(this.b, TimeAndDateUtils.c(feedNotice.timestamp)));
    }

    public List<FeedNotice> a() {
        return this.f32880c;
    }

    public void a(List<FeedNotice> list, int i) {
        ArrayList arrayList = list;
        if (list == null) {
            arrayList = new ArrayList();
        }
        this.f32880c = arrayList;
        notifyDataSetChanged();
    }

    public long b() {
        List<FeedNotice> list = this.f32880c;
        if (list == null || list.isEmpty()) {
            return 0L;
        }
        ArrayList arrayList = new ArrayList();
        for (FeedNotice feedNotice : this.f32880c) {
            arrayList.add(Long.valueOf(StringUtils.a(feedNotice.timestamp, 0L)));
        }
        return ((Long) Collections.max(arrayList)).longValue();
    }

    public void c() {
        List<FeedNotice> list = this.f32880c;
        if (list == null || list.isEmpty()) {
            return;
        }
        this.f32880c.clear();
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<FeedNotice> list = this.f32880c;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f32880c.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = this.f32879a.inflate(R.layout.item_msg_attention_notify_list, viewGroup, false);
            viewHolder = new ViewHolder();
            viewHolder.d = (ImageView) view.findViewById(R.id.msg_friend_item_avatar);
            viewHolder.e = (ImageView) view.findViewById(R.id.msg_item_avatar_v);
            viewHolder.f32883a = (TextView) view.findViewById(R.id.msg_friend_item_name);
            viewHolder.b = (TextView) view.findViewById(R.id.msg_friend_item_content);
            viewHolder.f32884c = (TextView) view.findViewById(R.id.msg_friend_item_time);
            viewHolder.f = (ImageView) view.findViewById(2131364726);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        final FeedNotice feedNotice = this.f32880c.get(i);
        ImageLoader.a(this.d, AvatarUtils.a(0, feedNotice.avatar)).b(2131237310).c().a(viewHolder.d);
        UserInfoHelper.a(viewHolder.e, feedNotice.vbadge, 3);
        UserRelationshipUtils.a(viewHolder.f, feedNotice);
        a(feedNotice, viewHolder.f32883a);
        a(feedNotice, viewHolder);
        a(view, feedNotice);
        final ViewHolder viewHolder2 = viewHolder;
        view.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.notify.adapter.MsgAttentionNotifyListAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Tracker.onClick(view2);
                feedNotice.has_read = 1;
                MsgAttentionNotifyListAdapter.this.notifyDataSetChanged();
                UserInfoFragmentNew.a(MsgAttentionNotifyListAdapter.this.b, feedNotice, "attention_notify", viewHolder2.d);
            }
        });
        return view;
    }
}
