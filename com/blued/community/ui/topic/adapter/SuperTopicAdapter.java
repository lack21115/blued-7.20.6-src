package com.blued.community.ui.topic.adapter;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.common.utils.AvatarUtils;
import com.blued.android.module.common.utils.CommonStringUtils;
import com.blued.community.R;
import com.blued.community.auto.CommunityServiceManager;
import com.blued.community.ui.topic.manager.TopicMethods;
import com.blued.community.ui.topic.model.BluedTopic;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/community/ui/topic/adapter/SuperTopicAdapter.class */
public class SuperTopicAdapter extends BaseQuickAdapter<BluedTopic, BaseViewHolder> {
    private Context a;
    private IRequestHost b;
    private int c;
    private String d;
    private boolean e;
    private boolean f;
    private OnShowListener g;

    /* loaded from: source-5961304-dex2jar.jar:com/blued/community/ui/topic/adapter/SuperTopicAdapter$OnShowListener.class */
    public interface OnShowListener {
        void a(BluedTopic bluedTopic);

        void b(BluedTopic bluedTopic);
    }

    public SuperTopicAdapter(Context context, IRequestHost iRequestHost) {
        super(R.layout.item_super_topic, (List) null);
        this.f = true;
        this.a = context;
        this.b = iRequestHost;
        this.c = context.getResources().getDisplayMetrics().widthPixels;
    }

    public SuperTopicAdapter(Context context, IRequestHost iRequestHost, int i) {
        super(i, (List) null);
        this.f = true;
        this.a = context;
        this.b = iRequestHost;
        this.c = context.getResources().getDisplayMetrics().widthPixels;
    }

    public void a(OnShowListener onShowListener) {
        this.g = onShowListener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // 
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, BluedTopic bluedTopic) {
        int indexOf;
        ImageView imageView = (ImageView) baseViewHolder.getView(R.id.header_view);
        TextView textView = (TextView) baseViewHolder.getView(R.id.tv_topic_name);
        TextView textView2 = (TextView) baseViewHolder.getView(R.id.tv_visit);
        TextView textView3 = (TextView) baseViewHolder.getView(R.id.tv_create_topic);
        TextView textView4 = (TextView) baseViewHolder.getView(R.id.tv_members_in);
        View view = baseViewHolder.getView(R.id.layout_no);
        ImageView imageView2 = (ImageView) baseViewHolder.getView(R.id.iv_no);
        View view2 = baseViewHolder.getView(R.id.layout_no4);
        TextView textView5 = (TextView) baseViewHolder.getView(R.id.tv_no4);
        ImageView imageView3 = (ImageView) baseViewHolder.getView(R.id.img_chosen);
        OnShowListener onShowListener = this.g;
        if (onShowListener != null) {
            onShowListener.b(bluedTopic);
        }
        if (!bluedTopic.isShowUrlVisited) {
            OnShowListener onShowListener2 = this.g;
            if (onShowListener2 != null) {
                onShowListener2.a(bluedTopic);
            }
            CommunityServiceManager.d().a("topic_list_item_show", bluedTopic.super_did);
            bluedTopic.isShowUrlVisited = true;
        }
        int i = 0;
        if (bluedTopic.is_chosen) {
            imageView3.setVisibility(0);
        } else {
            imageView3.setVisibility(8);
        }
        if (bluedTopic.is_local_2b_created) {
            textView2.setVisibility(8);
            textView4.setVisibility(8);
            textView3.setVisibility(0);
        } else {
            textView2.setVisibility(0);
            textView4.setVisibility(0);
            textView3.setVisibility(8);
        }
        int adapterPosition = (baseViewHolder.getAdapterPosition() - getHeaderLayoutCount()) + 1;
        if (!this.e || adapterPosition < 1 || adapterPosition > 15) {
            view.setVisibility(8);
            view2.setVisibility(8);
        } else if (adapterPosition == 1) {
            view.setVisibility(0);
            view2.setVisibility(8);
            imageView2.setImageResource(R.drawable.super_topic_no1);
        } else if (adapterPosition == 2) {
            view.setVisibility(0);
            view2.setVisibility(8);
            imageView2.setImageResource(R.drawable.super_topic_no2);
        } else if (adapterPosition != 3) {
            view.setVisibility(8);
            view2.setVisibility(0);
            textView5.setText("NO." + adapterPosition);
        } else {
            view.setVisibility(0);
            view2.setVisibility(8);
            imageView2.setImageResource(R.drawable.super_topic_no3);
        }
        if (bluedTopic.is_anonym == 1) {
            ImageLoader.a(this.b, bluedTopic.avatar).b(R.drawable.topic_anonymous_default_header_list).d(R.drawable.topic_anonymous_default_header_list).a(imageView);
        } else {
            int i2 = R.drawable.defaultpicture;
            ImageLoader.a(this.b, AvatarUtils.a(0, bluedTopic.avatar)).b(i2).d(i2).a(6.0f).a(imageView);
        }
        if (TextUtils.isEmpty(bluedTopic.name)) {
            textView.setText("");
        } else {
            textView.setText(TopicMethods.a(bluedTopic, bluedTopic.name, false));
        }
        String str = bluedTopic.name;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.d) && !bluedTopic.is_local_2b_created && str.contains(this.d)) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            while (i < str.length() && (indexOf = str.indexOf(this.d, i)) >= 0) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(ContextCompat.getColor(this.a, R.color.nafio_a)), indexOf, this.d.length() + indexOf, 33);
                i = Math.max(i + 1, indexOf);
            }
            textView.setText(TopicMethods.a(bluedTopic, spannableStringBuilder));
        }
        textView2.setText(CommonStringUtils.b(bluedTopic.ticktocks_total) + this.a.getString(R.string.subject_feed_count));
        textView4.setText(CommonStringUtils.b((long) bluedTopic.visited_total) + this.a.getString(R.string.subject_visit_count));
    }

    public void a(String str) {
        this.d = str;
    }

    public void a(boolean z) {
        this.e = z;
    }

    public void b(boolean z) {
        this.f = z;
    }

    public void setNewData(List<BluedTopic> list) {
        if (list == null) {
            super.setNewData((List) null);
        } else {
            super.setNewData(TopicMethods.a(list, this.f));
        }
    }
}
