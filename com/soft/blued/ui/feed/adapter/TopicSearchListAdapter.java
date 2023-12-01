package com.soft.blued.ui.feed.adapter;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.common.utils.AvatarUtils;
import com.blued.community.ui.topic.model.BluedTopic;
import com.soft.blued.R;
import com.soft.blued.utils.StringUtils;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/feed/adapter/TopicSearchListAdapter.class */
public class TopicSearchListAdapter extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private Context f16183a;
    private LayoutInflater b;

    /* renamed from: c  reason: collision with root package name */
    private List<BluedTopic> f16184c;
    private IRequestHost d;
    private String e;

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/feed/adapter/TopicSearchListAdapter$ViewHolder.class */
    class ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public ImageView f16185a;
        public TextView b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f16186c;
        public TextView d;

        private ViewHolder() {
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f16184c.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f16184c.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        int indexOf;
        if (view == null) {
            viewHolder = new ViewHolder();
            view = this.b.inflate(R.layout.item_topic_search, (ViewGroup) null);
            viewHolder.f16185a = (ImageView) view.findViewById(R.id.iv_topic_pic);
            viewHolder.b = (TextView) view.findViewById(R.id.tv_topic_name);
            viewHolder.f16186c = (ImageView) view.findViewById(R.id.iv_topic_join_icon);
            viewHolder.d = (TextView) view.findViewById(R.id.tv_topic_join_count);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        BluedTopic bluedTopic = this.f16184c.get(i);
        ImageLoader.a(this.d, AvatarUtils.a(0, bluedTopic.avatar)).b((int) R.drawable.topic_default_header).c().a(viewHolder.f16185a);
        if (TextUtils.isEmpty(bluedTopic.name)) {
            viewHolder.b.setText("");
        } else {
            viewHolder.b.setText(bluedTopic.name);
        }
        String str = bluedTopic.name;
        if (StringUtils.d(str) || StringUtils.d(this.e)) {
            viewHolder.b.setText(str);
        } else if (str.contains(this.e)) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= str.length() || (indexOf = str.indexOf(this.e, i3)) < 0) {
                    break;
                }
                spannableStringBuilder.setSpan(new ForegroundColorSpan(ContextCompat.getColor(this.f16183a, 2131101190)), indexOf, this.e.length() + indexOf, 33);
                i2 = Math.max(i3 + 1, indexOf);
            }
            viewHolder.b.setText(spannableStringBuilder);
        } else {
            viewHolder.b.setText(str);
        }
        long j = 0;
        if (!TextUtils.isEmpty(bluedTopic.join_total)) {
            j = StringUtils.a(bluedTopic.join_total, 0);
        }
        viewHolder.d.setText(j + " " + this.f16183a.getResources().getString(R.string.live_share_viewersCount));
        return view;
    }
}
