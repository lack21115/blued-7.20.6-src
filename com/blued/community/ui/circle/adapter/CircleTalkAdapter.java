package com.blued.community.ui.circle.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.common.utils.TimeAndDateUtils;
import com.blued.community.R;
import com.blued.community.model.BluedIngSelfFeed;
import com.blued.community.track.EventTrackFeed;
import com.blued.community.ui.circle.manager.CircleMethods;
import com.blued.community.utils.MarkDownLinkHelper;
import com.blued.community.utils.StringUtils;
import com.blued.das.client.feed.FeedProtos;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/circle/adapter/CircleTalkAdapter.class */
public class CircleTalkAdapter extends BaseQuickAdapter<BluedIngSelfFeed, BaseViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    protected Context f19128a;
    protected IRequestHost b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f19129c;
    public Set<String> d;
    private HashSet<String> e;

    public CircleTalkAdapter(Context context, IRequestHost iRequestHost) {
        super(R.layout.item_circle_talk);
        this.e = new HashSet<>();
        this.f19129c = true;
        this.d = new HashSet();
        this.f19128a = context;
        this.b = iRequestHost;
    }

    private List<BluedIngSelfFeed> a(Collection<? extends BluedIngSelfFeed> collection) {
        ArrayList arrayList = new ArrayList();
        for (BluedIngSelfFeed bluedIngSelfFeed : collection) {
            if (!this.e.contains(bluedIngSelfFeed.feed_id)) {
                arrayList.add(bluedIngSelfFeed);
                this.e.add(bluedIngSelfFeed.feed_id);
            }
        }
        return arrayList;
    }

    protected void a(BluedIngSelfFeed bluedIngSelfFeed) {
        if (bluedIngSelfFeed.isShowUrlVisited) {
            return;
        }
        EventTrackFeed.b(FeedProtos.Event.CIRCLE_NOTE_DRAW, bluedIngSelfFeed, FeedProtos.NoteSource.NOTE_LIST);
        bluedIngSelfFeed.isShowUrlVisited = true;
    }

    protected void a(BaseViewHolder baseViewHolder) {
        baseViewHolder.addOnClickListener(R.id.new_base_header);
        baseViewHolder.addOnClickListener(R.id.new_base_name);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(BaseViewHolder baseViewHolder, BluedIngSelfFeed bluedIngSelfFeed) {
        if (baseViewHolder != null) {
            if (bluedIngSelfFeed.feed_comment > 999) {
                baseViewHolder.setText(R.id.new_base_comment_num, "999+");
            } else {
                baseViewHolder.setText(R.id.new_base_comment_num, Integer.toString(bluedIngSelfFeed.feed_comment));
            }
            if (!TextUtils.isEmpty(bluedIngSelfFeed.feed_content)) {
                TextView textView = (TextView) baseViewHolder.getView(R.id.new_base_content);
                CharSequence a2 = MarkDownLinkHelper.a(this.f19128a, StringUtils.a(bluedIngSelfFeed.feed_content.replaceAll("\r|\n", ""), (int) textView.getTextSize(), 1));
                textView.setLineSpacing(12.0f, 1.0f);
                if (bluedIngSelfFeed.is_posts_vote == 1) {
                    textView.setText(CircleMethods.b(bluedIngSelfFeed, CircleMethods.a(bluedIngSelfFeed, a2)));
                } else if (this.f19129c) {
                    textView.setText(CircleMethods.b(bluedIngSelfFeed, CircleMethods.a(bluedIngSelfFeed, a2, false)));
                } else {
                    textView.setText(CircleMethods.b(bluedIngSelfFeed, CircleMethods.a(bluedIngSelfFeed, a2)));
                }
            } else if (this.f19129c) {
                baseViewHolder.setText(R.id.new_base_content, CircleMethods.a(bluedIngSelfFeed, (CharSequence) this.f19128a.getResources().getString(R.string.circle_picture_talk), false));
            } else {
                baseViewHolder.setText(R.id.new_base_content, R.string.circle_picture_talk);
            }
            if (this.d.contains(bluedIngSelfFeed.feed_id)) {
                baseViewHolder.setTextColor(R.id.new_base_content, BluedSkinUtils.a(this.f19128a, R.color.syc_j));
            } else {
                baseViewHolder.setTextColor(R.id.new_base_content, BluedSkinUtils.a(this.f19128a, R.color.syc_h));
            }
            ImageLoader.a(this.b, bluedIngSelfFeed.cover).b(R.drawable.circle_header_default).a((ImageView) baseViewHolder.getView(R.id.new_base_header));
            baseViewHolder.setText(R.id.new_base_name, bluedIngSelfFeed.circle_title);
            int i = R.id.new_base_time;
            baseViewHolder.setText(i, TimeAndDateUtils.c(this.f19128a, TimeAndDateUtils.c(bluedIngSelfFeed.last_comment_time)) + this.f19128a.getString(R.string.circle_update));
            ImageView imageView = (ImageView) baseViewHolder.getView(R.id.new_base_image);
            if (bluedIngSelfFeed.is_video_posts != 1 || bluedIngSelfFeed.feed_videos == null || bluedIngSelfFeed.feed_videos.length <= 0) {
                baseViewHolder.setGone(R.id.iv_play, false);
                if (bluedIngSelfFeed.feed_pics == null || bluedIngSelfFeed.feed_pics.length <= 0) {
                    baseViewHolder.setGone(R.id.new_base_image_layout, false);
                } else {
                    ImageLoader.a(this.b, bluedIngSelfFeed.feed_pics[0]).a(imageView);
                    baseViewHolder.setGone(R.id.new_base_image_layout, true);
                }
            } else {
                baseViewHolder.setGone(R.id.iv_play, true);
                ImageLoader.a(this.b, bluedIngSelfFeed.feed_videos[0]).a(imageView);
                baseViewHolder.setGone(R.id.new_base_image_layout, true);
            }
            b(baseViewHolder);
            a(baseViewHolder);
            a(bluedIngSelfFeed);
        }
    }

    public void a(String str) {
        this.d.add(str);
    }

    public void a(boolean z) {
        this.f19129c = z;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void addData(Collection<? extends BluedIngSelfFeed> collection) {
        super.addData((Collection) a(collection));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(BaseViewHolder baseViewHolder) {
        final LinearLayout linearLayout = (LinearLayout) baseViewHolder.getView(R.id.new_base_layout);
        final CardView cardView = (CardView) baseViewHolder.getView(R.id.card_header);
        final TextView textView = (TextView) baseViewHolder.getView(R.id.new_base_name);
        final ImageView imageView = (ImageView) baseViewHolder.getView(R.id.iv_anonymous);
        final TextView textView2 = (TextView) baseViewHolder.getView(R.id.new_base_time);
        if (textView2.getText().toString().length() <= 10) {
            return;
        }
        final String charSequence = textView.getText().toString();
        textView.setText((CharSequence) null);
        linearLayout.post(new Runnable() { // from class: com.blued.community.ui.circle.adapter.CircleTalkAdapter.1
            @Override // java.lang.Runnable
            public void run() {
                TextView textView3 = textView;
                if (textView3 != null) {
                    textView3.setMaxWidth((((linearLayout.getWidth() - cardView.getWidth()) - imageView.getWidth()) - textView2.getWidth()) - DensityUtils.a(CircleTalkAdapter.this.f19128a, 25.0f));
                    textView.setText(charSequence);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: b */
    public void convert(BaseViewHolder baseViewHolder, BluedIngSelfFeed bluedIngSelfFeed) {
        if (baseViewHolder != null) {
            a(baseViewHolder, bluedIngSelfFeed);
        }
    }

    public void b(String str) {
        if (this.mData == null || TextUtils.isEmpty(str)) {
            return;
        }
        for (BluedIngSelfFeed bluedIngSelfFeed : this.mData) {
            if (str.equals(bluedIngSelfFeed.feed_id)) {
                this.mData.remove(bluedIngSelfFeed);
                notifyDataSetChanged();
                return;
            }
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void setNewData(List<BluedIngSelfFeed> list) {
        this.e.clear();
        if (list != null) {
            super.setNewData(a(list));
        } else {
            super.setNewData(null);
        }
    }
}
