package com.blued.community.ui.video.adapter;

import android.content.ClipData;
import android.content.Context;
import android.content.DialogInterface;
import android.database.DataSetObserver;
import android.os.Build;
import android.text.ClipboardManager;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.Logger;
import com.blued.android.framework.utils.RegExpUtils;
import com.blued.android.module.common.login.model.UserBasicModel;
import com.blued.android.module.common.user.UserInfoHelper;
import com.blued.android.module.common.utils.AvatarUtils;
import com.blued.android.module.common.utils.DistanceUtils;
import com.blued.android.module.common.utils.TimeAndDateUtils;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.blued.android.module.common.widget.menu.ActionSheet;
import com.blued.android.module.common.widget.menu.CommonShowBottomWindow;
import com.blued.community.R;
import com.blued.community.auto.CommunityServiceManager;
import com.blued.community.http.FeedHttpUtils;
import com.blued.community.manager.CommunityConstants;
import com.blued.community.model.BluedIngSelfFeed;
import com.blued.community.ui.comment.fragment.HotCommentsFragment;
import com.blued.community.ui.comment.model.FeedComment;
import com.blued.community.ui.feed.observer.CommentListDataObserver;
import com.blued.community.utils.StringUtils;
import com.blued.community.utils.UserInfoUtils;
import com.bytedance.applog.tracker.Tracker;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-7206380-dex2jar.jar:com/blued/community/ui/video/adapter/VideoCommentAdapter.class */
public class VideoCommentAdapter extends BaseAdapter implements CommentListDataObserver.ICommentDataObserver {

    /* renamed from: a  reason: collision with root package name */
    LoadOptions f6701a;
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private LayoutInflater f6702c;
    private int e;
    private IRequestHost f;
    private BluedIngSelfFeed g;
    private FeedCommentListner h;
    private boolean i;
    private List<FeedComment> d = new ArrayList();
    private boolean j = true;
    private String k = "shine_video_detail";

    /* loaded from: source-7206380-dex2jar.jar:com/blued/community/ui/video/adapter/VideoCommentAdapter$FeedCommentListner.class */
    public interface FeedCommentListner {
        void a(FeedComment feedComment);
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/community/ui/video/adapter/VideoCommentAdapter$LIKED.class */
    interface LIKED {
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/community/ui/video/adapter/VideoCommentAdapter$RevoClickSpan.class */
    public class RevoClickSpan extends ClickableSpan {

        /* renamed from: a  reason: collision with root package name */
        Context f6714a;
        String b;

        /* renamed from: c  reason: collision with root package name */
        String f6715c;
        String d;
        String e;

        public RevoClickSpan(Context context, String str, String str2, String str3, String str4) {
            this.f6714a = context;
            this.b = str;
            this.f6715c = str2;
            this.d = str3;
            this.e = str4;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            Selection.removeSelection((Spannable) ((TextView) view).getText());
            if (TextUtils.isEmpty(this.f6715c)) {
                CommunityServiceManager.b().b(this.f6714a, this.d, "");
            } else {
                CommunityServiceManager.b().a(this.f6714a, this.f6715c, "");
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(this.f6714a.getResources().getColor(R.color.nafio_v));
            textPaint.setUnderlineText(false);
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/community/ui/video/adapter/VideoCommentAdapter$ViewHolder.class */
    class ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public ImageView f6716a;
        public TextView b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f6717c;
        public TextView d;
        public ImageView e;
        public View f;
        public ImageView g;
        public TextView h;
        public TextView i;
        public LinearLayout j;
        public TextView k;
        public ImageView l;
        public ImageView m;

        private ViewHolder() {
        }
    }

    public VideoCommentAdapter(Context context, IRequestHost iRequestHost, BluedIngSelfFeed bluedIngSelfFeed, FeedCommentListner feedCommentListner, boolean z) {
        this.i = true;
        this.b = context;
        this.h = feedCommentListner;
        this.g = bluedIngSelfFeed;
        this.f = iRequestHost;
        this.i = z;
        LoadOptions loadOptions = new LoadOptions();
        this.f6701a = loadOptions;
        loadOptions.d = R.drawable.user_bg_round;
        this.f6701a.b = R.drawable.user_bg_round;
        LoadOptions loadOptions2 = this.f6701a;
        int i = this.e;
        loadOptions2.a(i >> 1, i >> 1);
        this.f6702c = LayoutInflater.from(context);
        this.e = context.getResources().getDisplayMetrics().widthPixels;
    }

    private void a(View view, final FeedComment feedComment) {
        if (feedComment != null) {
            view.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.blued.community.ui.video.adapter.VideoCommentAdapter.6
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view2) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(VideoCommentAdapter.this.b.getResources().getString(R.string.community_copy));
                    if (!feedComment.comment_uid.equals(UserInfoUtils.c())) {
                        arrayList.add(VideoCommentAdapter.this.b.getResources().getString(R.string.report));
                    }
                    if ("1".equals(feedComment.comment_allow_delete)) {
                        arrayList.add(VideoCommentAdapter.this.b.getResources().getString(R.string.delete));
                    }
                    CommonShowBottomWindow.a((FragmentActivity) VideoCommentAdapter.this.b, (String[]) arrayList.toArray(new String[arrayList.size()]), new ActionSheet.ActionSheetListener() { // from class: com.blued.community.ui.video.adapter.VideoCommentAdapter.6.1
                        public void a(ActionSheet actionSheet, int i) {
                            String a2 = actionSheet.a(i);
                            if (a2.equals(VideoCommentAdapter.this.b.getResources().getString(R.string.community_copy))) {
                                VideoCommentAdapter.this.a(feedComment);
                            } else if (a2.equals(VideoCommentAdapter.this.b.getResources().getString(R.string.delete))) {
                                VideoCommentAdapter.this.b(feedComment);
                            } else if (a2.equals(VideoCommentAdapter.this.b.getResources().getString(R.string.report))) {
                                CommunityServiceManager.b().a(VideoCommentAdapter.this.b, CommunityConstants.ReportType.c, feedComment.user_name, feedComment.feed_id, feedComment.comment_id);
                            }
                        }

                        public void a(ActionSheet actionSheet, boolean z) {
                        }
                    });
                    return true;
                }
            });
        }
    }

    private void a(TextView textView, FeedComment feedComment) {
        String str = feedComment.reply_name;
        String str2 = feedComment.comment_content;
        String str3 = feedComment.reply_uid;
        String str4 = feedComment.reply_avatar;
        String string = this.b.getResources().getString(R.string.reply);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string + str + ": " + str2);
        spannableStringBuilder.setSpan(new RevoClickSpan(this.b, spannableStringBuilder.toString().substring(spannableStringBuilder.toString().indexOf(string) + string.length(), spannableStringBuilder.toString().indexOf(":")), str3, str, str4), spannableStringBuilder.toString().indexOf(string) + string.length(), spannableStringBuilder.toString().indexOf(":"), 17);
        StringUtils.a(textView, spannableStringBuilder, 1, "");
    }

    private void b(TextView textView, FeedComment feedComment) {
        StringUtils.a(textView, feedComment.comment_content, 1, "");
    }

    public void a(BluedIngSelfFeed bluedIngSelfFeed) {
        this.j = true;
        this.g = bluedIngSelfFeed;
        this.d.clear();
        notifyDataSetChanged();
    }

    public void a(FeedComment feedComment) {
        String str = feedComment.comment_content;
        if (Build.VERSION.SDK_INT < 11 || Build.VERSION.SDK_INT == 18) {
            ((ClipboardManager) this.b.getSystemService(Context.CLIPBOARD_SERVICE)).setText(RegExpUtils.a(str));
        } else {
            try {
                ((android.content.ClipboardManager) this.b.getSystemService(Context.CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("simple text", RegExpUtils.a(str)));
            } catch (Exception e) {
            }
        }
        AppMethods.a(this.b.getResources().getString(R.string.copy));
    }

    public void a(FeedComment feedComment, ImageView imageView, TextView textView) {
        CommunityServiceManager.d().a("shine_video_comment_like_btn_click");
        String str = feedComment.comment_id;
        String str2 = feedComment.feed_id;
        int i = feedComment.iliked == 0 ? 1 : 0;
        CommentListDataObserver.a().a(str, i);
        FeedHttpUtils.a(str2, str, i, (BluedUIHttpResponse) null, this.f, true);
    }

    public void a(FeedComment feedComment, String str) {
        int i;
        if (feedComment == null || !this.i) {
            return;
        }
        feedComment.vbadge = feedComment.user_vbadge;
        int i2 = 0;
        while (true) {
            i = i2;
            if (i >= this.d.size()) {
                i = -1;
                break;
            } else if (this.d.get(i).isLastHotComment) {
                break;
            } else {
                i2 = i + 1;
            }
        }
        if (i == -1) {
            this.d.add(0, feedComment);
        } else {
            this.d.add(i + 1, feedComment);
        }
        notifyDataSetChanged();
    }

    public void a(String str) {
        List<FeedComment> list;
        int i;
        if (TextUtils.isEmpty(str) || (list = this.d) == null || list.size() <= 0) {
            return;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.d.size()) {
                if (str.equals(this.d.get(i3).comment_id) && this.d.get(i3).isLastHotComment && (i = i3 - 1) >= 0) {
                    this.d.get(i).isLastHotComment = this.d.get(i3).isLastHotComment;
                    this.d.get(i).isHasMoreHotComment = this.d.get(i3).isHasMoreHotComment;
                    break;
                }
                i2 = i3 + 1;
            } else {
                break;
            }
        }
        Iterator<FeedComment> it = this.d.iterator();
        while (it.hasNext()) {
            if (str.equals(it.next().comment_id)) {
                it.remove();
            }
        }
        notifyDataSetChanged();
    }

    public void a(String str, int i) {
        List<FeedComment> list;
        if (TextUtils.isEmpty(str) || (list = this.d) == null || list.size() <= 0) {
            return;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.d.size()) {
                notifyDataSetChanged();
                return;
            }
            if (str.equals(this.d.get(i3).comment_id)) {
                this.d.get(i3).iliked = i;
                if (i == 1) {
                    this.d.get(i3).liked_count++;
                } else {
                    this.d.get(i3).liked_count--;
                }
            }
            i2 = i3 + 1;
        }
    }

    public void a(List<FeedComment> list) {
        this.d.clear();
        if (list != null && list.size() > 0) {
            this.d.addAll(list);
        }
        notifyDataSetChanged();
    }

    public boolean a() {
        return this.j;
    }

    public void b() {
        this.j = false;
    }

    public void b(final FeedComment feedComment) {
        CharSequence a2;
        String str;
        String string = this.b.getString(R.string.hint);
        if (StringUtils.a(feedComment.comment_content, false, true, false, "").length() > 14) {
            str = ((Object) a2.subSequence(0, 14)) + "...";
        } else {
            str = ((Object) a2) + "";
        }
        String format = String.format(this.b.getResources().getString(R.string.delete_comment_confirm), str);
        Context context = this.b;
        CommonAlertDialog.a(context, string, format, context.getResources().getString(R.string.delete), new DialogInterface.OnClickListener() { // from class: com.blued.community.ui.video.adapter.VideoCommentAdapter.7
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Tracker.onClick(dialogInterface, i);
                FeedHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<Object>>() { // from class: com.blued.community.ui.video.adapter.VideoCommentAdapter.7.1
                    /* JADX INFO: Access modifiers changed from: protected */
                    /* renamed from: a */
                    public BluedEntityA<Object> parseData(String str2) {
                        return super.parseData(str2);
                    }

                    /* renamed from: a */
                    public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
                        CommentListDataObserver.a().a(feedComment.comment_id);
                        LiveEventBus.get("feed_delete_comment").post(feedComment);
                        AppMethods.a(AppInfo.d().getResources().getString(R.string.del_success));
                    }

                    public void onFailure(Throwable th, int i2, String str2) {
                        AppMethods.a(AppInfo.d().getResources().getString(R.string.common_net_error));
                        super.onFailure(th, i2, str2);
                    }
                }, true, feedComment.feed_id, feedComment.comment_id, VideoCommentAdapter.this.g.is_ads, VideoCommentAdapter.this.f);
            }
        }, (String) null, (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
    }

    public void b(List<FeedComment> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        Logger.b("VideoCommentAdapter", new Object[]{"addFeedItems:", Integer.valueOf(list.size())});
        this.d.addAll(list);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.d.size();
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
            view2 = this.f6702c.inflate(R.layout.show_video_comment_item, viewGroup, false);
            viewHolder.f6716a = (ImageView) view2.findViewById(R.id.header_view);
            viewHolder.d = (TextView) view2.findViewById(R.id.content_view);
            viewHolder.f6717c = (TextView) view2.findViewById(R.id.name_view);
            viewHolder.b = (TextView) view2.findViewById(R.id.time_view);
            viewHolder.e = (ImageView) view2.findViewById(R.id.img_verify);
            viewHolder.g = (ImageView) view2.findViewById(R.id.img_comment_like);
            viewHolder.f = view2.findViewById(R.id.lay_like);
            viewHolder.h = (TextView) view2.findViewById(R.id.tv_comment_like_count);
            viewHolder.i = (TextView) view2.findViewById(R.id.tv_bottom_cutter);
            viewHolder.j = (LinearLayout) view2.findViewById(R.id.ll_more_hot_comment);
            viewHolder.k = (TextView) view2.findViewById(R.id.tv_more_hot_comment);
            viewHolder.l = (ImageView) view2.findViewById(R.id.img_arrow);
            viewHolder.m = (ImageView) view2.findViewById(R.id.img_vip_icon);
            view2.setTag(viewHolder);
        } else {
            view2 = view;
            viewHolder = (ViewHolder) view.getTag();
        }
        final FeedComment feedComment = this.d.get(i);
        if (feedComment.iliked == 1) {
            viewHolder.g.setImageResource(R.drawable.show_video_comment_liked);
            viewHolder.h.setTextColor(this.b.getResources().getColor(R.color.video_like_color));
        } else {
            viewHolder.g.setImageResource(R.drawable.show_video_comment_unlike);
            viewHolder.h.setTextColor(this.b.getResources().getColor(R.color.video_un_like_color));
        }
        if (feedComment.liked_count > 0) {
            TextView textView = viewHolder.h;
            Context context = this.b;
            textView.setText(DistanceUtils.a(context, feedComment.liked_count + ""));
        } else {
            viewHolder.h.setText(DistanceUtils.a(this.b, "0"));
        }
        final ImageView imageView = viewHolder.g;
        final TextView textView2 = viewHolder.h;
        viewHolder.f.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.video.adapter.VideoCommentAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view3) {
                Tracker.onClick(view3);
                VideoCommentAdapter.this.a(feedComment, imageView, textView2);
            }
        });
        if (feedComment.isLastHotComment) {
            viewHolder.i.setVisibility(8);
            viewHolder.j.setVisibility(0);
            if (feedComment.isHasMoreHotComment) {
                viewHolder.l.setVisibility(0);
                viewHolder.k.setText(this.b.getResources().getString(R.string.more_hot_comment));
                viewHolder.j.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.video.adapter.VideoCommentAdapter.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view3) {
                        Tracker.onClick(view3);
                        HotCommentsFragment.a(VideoCommentAdapter.this.b, VideoCommentAdapter.this.g);
                    }
                });
            } else {
                viewHolder.k.setText(this.b.getResources().getString(R.string.above_is_all_hot_comment));
                viewHolder.l.setVisibility(8);
                viewHolder.j.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.video.adapter.VideoCommentAdapter.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view3) {
                        Tracker.onClick(view3);
                    }
                });
            }
        } else {
            viewHolder.j.setVisibility(8);
            viewHolder.i.setVisibility(0);
        }
        UserInfoHelper.a(viewHolder.e, feedComment.vbadge, 3);
        ImageLoader.a(this.f, AvatarUtils.a(1, feedComment.user_avatar)).b(R.drawable.user_bg_round).c().a(viewHolder.f6716a);
        if (TextUtils.isEmpty(feedComment.comment_timestamp)) {
            viewHolder.b.setText("");
        } else {
            viewHolder.b.setText(TimeAndDateUtils.h(this.b, TimeAndDateUtils.c(feedComment.comment_timestamp)));
        }
        if (TextUtils.isEmpty(feedComment.user_name)) {
            viewHolder.f6717c.setText("");
        } else if (TextUtils.isEmpty(feedComment.note)) {
            viewHolder.f6717c.setText(feedComment.user_name.replace(":", ""));
        } else {
            viewHolder.f6717c.setText(StringUtils.a(feedComment.note, feedComment.user_name.replace(":", "")));
        }
        UserInfoHelper.a(this.b, viewHolder.f6717c, feedComment, R.color.syc_dark_k);
        UserInfoHelper.a(viewHolder.m, feedComment);
        if (TextUtils.isEmpty(feedComment.is_reply)) {
            viewHolder.d.setText("");
        } else if ("1".equals(feedComment.is_reply)) {
            a(viewHolder.d, feedComment);
        } else if ("0".equals(feedComment.is_reply)) {
            b(viewHolder.d, feedComment);
        } else {
            viewHolder.d.setText("");
        }
        final ImageView imageView2 = viewHolder.f6716a;
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.blued.community.ui.video.adapter.VideoCommentAdapter.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view3) {
                Tracker.onClick(view3);
                if (feedComment.comment_uid.equals(UserInfoUtils.c())) {
                    return;
                }
                UserBasicModel userBasicModel = new UserBasicModel();
                userBasicModel.name = feedComment.user_name;
                userBasicModel.uid = feedComment.comment_uid;
                userBasicModel.avatar = feedComment.user_avatar;
                CommunityServiceManager.b().a(VideoCommentAdapter.this.b, userBasicModel, VideoCommentAdapter.this.k, imageView2);
            }
        };
        viewHolder.f6717c.setOnClickListener(onClickListener);
        viewHolder.f6716a.setOnClickListener(onClickListener);
        a(view2, feedComment);
        view2.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.video.adapter.VideoCommentAdapter.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view3) {
                Tracker.onClick(view3);
                if (CommunityServiceManager.a().b(VideoCommentAdapter.this.b)) {
                    return;
                }
                VideoCommentAdapter.this.h.a(feedComment);
            }
        });
        return view2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        super.registerDataSetObserver(dataSetObserver);
        CommentListDataObserver.a().a(this);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        super.unregisterDataSetObserver(dataSetObserver);
        CommentListDataObserver.a().b(this);
    }
}
