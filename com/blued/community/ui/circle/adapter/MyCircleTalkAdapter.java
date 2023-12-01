package com.blued.community.ui.circle.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.common.utils.TimeAndDateUtils;
import com.blued.community.R;
import com.blued.community.ui.circle.fragment.CircleDetailsFragment;
import com.blued.community.ui.circle.fragment.CirclePostDetailsFragment;
import com.blued.community.ui.circle.manager.CircleConstants;
import com.blued.community.ui.circle.manager.CircleMethods;
import com.blued.community.ui.circle.model.MyCircleTalkModel;
import com.blued.community.utils.MarkDownLinkHelper;
import com.blued.das.client.feed.FeedProtos;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.List;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/circle/adapter/MyCircleTalkAdapter.class */
public class MyCircleTalkAdapter extends BaseQuickAdapter<MyCircleTalkModel, BaseViewHolder> {
    private Context a;
    private IRequestHost b;

    public MyCircleTalkAdapter(Context context, IRequestHost iRequestHost) {
        super(R.layout.item_circle_talk, (List) null);
        this.a = context;
        this.b = iRequestHost;
    }

    private void b(BaseViewHolder baseViewHolder, final MyCircleTalkModel myCircleTalkModel) {
        if (baseViewHolder != null) {
            if (myCircleTalkModel.feed_comment > 999) {
                baseViewHolder.setText(R.id.new_base_comment_num, "999+");
            } else {
                baseViewHolder.setText(R.id.new_base_comment_num, Integer.toString(myCircleTalkModel.feed_comment));
            }
            if (TextUtils.isEmpty(myCircleTalkModel.feed_content)) {
                baseViewHolder.setText(R.id.new_base_content, R.string.circle_picture_talk);
            } else {
                baseViewHolder.setText(R.id.new_base_content, CircleMethods.a(myCircleTalkModel, MarkDownLinkHelper.a(this.a, myCircleTalkModel.feed_content.replaceAll("\r|\n", ""))));
            }
            ImageLoader.a(this.b, myCircleTalkModel.cover).b(R.drawable.circle_header_default).a((ImageView) baseViewHolder.getView(R.id.new_base_header));
            baseViewHolder.setText(R.id.new_base_name, myCircleTalkModel.title);
            baseViewHolder.setText(R.id.new_base_time, TimeAndDateUtils.c(this.a, TimeAndDateUtils.c(myCircleTalkModel.last_comment_time)));
            ImageView imageView = (ImageView) baseViewHolder.getView(R.id.new_base_image);
            if (myCircleTalkModel.is_video_posts != 1 || myCircleTalkModel.feed_videos == null || myCircleTalkModel.feed_videos.length <= 0) {
                baseViewHolder.setGone(R.id.iv_play, false);
                if (myCircleTalkModel.feed_pics == null || myCircleTalkModel.feed_pics.length <= 0) {
                    baseViewHolder.setGone(R.id.new_base_image_layout, false);
                } else {
                    ImageLoader.a(this.b, myCircleTalkModel.feed_pics[0]).a(imageView);
                    baseViewHolder.setGone(R.id.new_base_image_layout, true);
                }
            } else {
                baseViewHolder.setGone(R.id.iv_play, true);
                ImageLoader.a(this.b, myCircleTalkModel.feed_videos[0]).a(imageView);
                baseViewHolder.setGone(R.id.new_base_image_layout, true);
            }
            baseViewHolder.setOnClickListener(R.id.new_base_layout, new View.OnClickListener() { // from class: com.blued.community.ui.circle.adapter.MyCircleTalkAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    CircleDetailsFragment.a(MyCircleTalkAdapter.this.a, myCircleTalkModel, CircleConstants.CIRCLE_FROM_PAGE.RECOMMEND_CIRCLE);
                }
            });
            baseViewHolder.setOnClickListener(R.id.new_base_root_layout, new View.OnClickListener() { // from class: com.blued.community.ui.circle.adapter.MyCircleTalkAdapter.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    Context context = MyCircleTalkAdapter.this.a;
                    CirclePostDetailsFragment.a(context, myCircleTalkModel.feed_id + "", FeedProtos.NoteSource.NOTE_LIST);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, MyCircleTalkModel myCircleTalkModel) {
        if (baseViewHolder != null) {
            b(baseViewHolder, myCircleTalkModel);
        }
    }
}
