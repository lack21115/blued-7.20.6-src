package com.blued.community.ui.comment.adapter;

import android.animation.ObjectAnimator;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.image.ImageWrapper;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.RegExpUtils;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.log.oldtrack.LogData;
import com.blued.android.module.common.login.model.UserBasicModel;
import com.blued.android.module.common.user.UserInfoHelper;
import com.blued.android.module.common.utils.AvatarUtils;
import com.blued.android.module.common.utils.DistanceUtils;
import com.blued.android.module.common.utils.TimeAndDateUtils;
import com.blued.android.module.common.utils.click.SingleClickProxy;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.blued.android.module.common.widget.menu.ActionSheet;
import com.blued.android.module.common.widget.menu.CommonShowBottomWindow;
import com.blued.community.R;
import com.blued.community.auto.CommunityServiceManager;
import com.blued.community.http.FeedHttpUtils;
import com.blued.community.manager.CommunityConstants;
import com.blued.community.model.BluedIngSelfFeed;
import com.blued.community.track.EventTrackFeed;
import com.blued.community.ui.comment.adapter.FeedDetailsCommentListAdapter;
import com.blued.community.ui.comment.fragment.CommentFragment;
import com.blued.community.ui.comment.fragment.HotCommentsFragment;
import com.blued.community.ui.comment.model.FeedComment;
import com.blued.community.ui.feed.manager.FeedMethods;
import com.blued.community.ui.feed.observer.CommentListDataObserver;
import com.blued.community.utils.StringUtils;
import com.blued.community.utils.UserInfoUtils;
import com.blued.community.view.CustomLinkMovementMethod;
import com.blued.das.client.feed.FeedProtos;
import com.blued.das.message.MessageProtos;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/comment/adapter/FeedDetailsCommentListAdapter.class */
public class FeedDetailsCommentListAdapter extends BaseMultiItemQuickAdapter<FeedComment, BaseViewHolder> implements CommentListDataObserver.ICommentDataObserver {
    public String a;
    private Context b;
    private IRequestHost c;
    private BluedIngSelfFeed d;
    private boolean e;
    private String f;
    private int g;
    private HashSet<String> h;
    private View i;
    private FeedCommentListener j;

    /* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/comment/adapter/FeedDetailsCommentListAdapter$CommentViewHolder.class */
    public class CommentViewHolder {
        private BaseViewHolder A;
        private int b;
        private View c;
        private ImageView d;
        private TextView e;
        private TextView f;
        private TextView g;
        private ImageView h;
        private ImageView i;
        private TextView j;
        private View k;
        private LinearLayout l;
        private TextView m;
        private ImageView n;
        private ImageView o;
        private ImageView p;
        private ShapeTextView q;
        private ConstraintLayout r;
        private ShapeLinearLayout s;
        private TextView t;
        private TextView u;
        private LinearLayout v;
        private TextView w;
        private TextView x;
        private View y;
        private View z;

        public CommentViewHolder(BaseViewHolder baseViewHolder, View view) {
            this.A = baseViewHolder;
            this.c = view.findViewById(R.id.rl_comment);
            this.d = (ImageView) view.findViewById(R.id.header_view);
            this.g = (TextView) view.findViewById(R.id.content_view);
            this.f = (TextView) view.findViewById(R.id.name_view);
            this.e = (TextView) view.findViewById(R.id.time_view);
            this.h = (ImageView) view.findViewById(R.id.img_verify);
            this.i = (ImageView) view.findViewById(R.id.img_comment_like);
            this.j = (TextView) view.findViewById(R.id.tv_comment_like_count);
            this.k = view.findViewById(R.id.comment_line);
            this.l = (LinearLayout) view.findViewById(R.id.ll_more_hot_comment);
            this.m = (TextView) view.findViewById(R.id.tv_more_hot_comment);
            this.n = (ImageView) view.findViewById(R.id.img_arrow);
            this.o = (ImageView) view.findViewById(R.id.img_vip_icon);
            this.p = (ImageView) view.findViewById(R.id.iv_level);
            this.q = (ShapeTextView) view.findViewById(R.id.item_comment_anchor_liked);
            this.r = view.findViewById(R.id.cl_reply);
            ShapeLinearLayout shapeLinearLayout = (ShapeLinearLayout) view.findViewById(R.id.ll_reply);
            this.s = shapeLinearLayout;
            ShapeHelper.b(shapeLinearLayout, R.color.syc_x);
            this.t = (TextView) view.findViewById(R.id.feed_comment_replay_first_tv);
            this.u = (TextView) view.findViewById(R.id.feed_comment_replay_second_tv);
            this.v = (LinearLayout) view.findViewById(R.id.ll_more_reply);
            this.w = (TextView) view.findViewById(R.id.tv_reply_num_pre);
            this.x = (TextView) view.findViewById(R.id.tv_reply_num);
            this.y = view.findViewById(R.id.comment_blue_mask);
            this.z = view.findViewById(R.id.reply_blue_mask);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(FeedComment feedComment, View view) {
            if (CommunityServiceManager.a().b(FeedDetailsCommentListAdapter.this.b) || FeedDetailsCommentListAdapter.this.j == null) {
                return;
            }
            FeedDetailsCommentListAdapter.this.j.a(feedComment);
        }

        public void a(final FeedComment feedComment, int i) {
            boolean z;
            this.b = i;
            if (feedComment.iliked == 1) {
                this.i.setImageResource(R.drawable.icon_comment_liked);
                this.j.setTextColor(FeedDetailsCommentListAdapter.this.b.getResources().getColor(R.color.feed_like));
            } else {
                this.i.setImageResource(R.drawable.icon_comment_like);
                this.j.setTextColor(BluedSkinUtils.a(FeedDetailsCommentListAdapter.this.b, R.color.syc_i));
            }
            if (feedComment.is_author_likeds == 1) {
                this.q.setVisibility(0);
            } else {
                this.q.setVisibility(8);
            }
            if (feedComment.liked_count > 0) {
                this.j.setText(DistanceUtils.a(FeedDetailsCommentListAdapter.this.b, feedComment.liked_count + ""));
                this.j.setVisibility(0);
            } else {
                this.j.setVisibility(8);
            }
            this.i.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.comment.adapter.FeedDetailsCommentListAdapter.CommentViewHolder.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    FeedDetailsCommentListAdapter.this.a(feedComment, CommentViewHolder.this.i, CommentViewHolder.this.j);
                }
            });
            this.j.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.comment.adapter.FeedDetailsCommentListAdapter.CommentViewHolder.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    FeedDetailsCommentListAdapter.this.a(feedComment, CommentViewHolder.this.i, CommentViewHolder.this.j);
                }
            });
            if (feedComment.isLastHotComment) {
                this.k.setVisibility(8);
                this.l.setVisibility(TextUtils.equals(FeedDetailsCommentListAdapter.this.f, "feed_detail") ? 0 : 8);
                if (feedComment.isHasMoreHotComment) {
                    this.n.setVisibility(0);
                    this.m.setText(FeedDetailsCommentListAdapter.this.b.getResources().getString(R.string.more_hot_comment));
                    this.l.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.comment.adapter.FeedDetailsCommentListAdapter.CommentViewHolder.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            Tracker.onClick(view);
                            HotCommentsFragment.a(FeedDetailsCommentListAdapter.this.b, FeedDetailsCommentListAdapter.this.d);
                        }
                    });
                } else {
                    this.m.setText(FeedDetailsCommentListAdapter.this.b.getResources().getString(R.string.above_is_all_hot_comment));
                    this.n.setVisibility(8);
                    this.l.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.comment.adapter.FeedDetailsCommentListAdapter.CommentViewHolder.4
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            Tracker.onClick(view);
                        }
                    });
                }
            } else {
                if (i == FeedDetailsCommentListAdapter.this.mData.size() - 1) {
                    this.k.setVisibility(8);
                } else {
                    this.k.setVisibility(0);
                }
                this.l.setVisibility(8);
            }
            UserInfoHelper.a(this.h, feedComment.vbadge, 3);
            ImageWrapper c = ImageLoader.a(FeedDetailsCommentListAdapter.this.c, AvatarUtils.a(1, feedComment.user_avatar)).b(R.drawable.user_bg_round).c();
            if (feedComment.is_comment_anonym == 1) {
                c.d();
            }
            c.a(this.d);
            if (TextUtils.isEmpty(feedComment.comment_timestamp)) {
                this.e.setText("");
            } else {
                this.e.setText(TimeAndDateUtils.h(FeedDetailsCommentListAdapter.this.b, TimeAndDateUtils.c(feedComment.comment_timestamp)));
            }
            if (TextUtils.isEmpty(feedComment.user_name)) {
                this.f.setText("");
            } else if (TextUtils.isEmpty(feedComment.note)) {
                this.f.setText(feedComment.user_name.replace(":", ""));
            } else {
                this.f.setText(StringUtils.a(feedComment.note, feedComment.user_name.replace(":", "")));
            }
            FeedMethods.a(this.f, feedComment.comment_uid, feedComment.is_comment_anonym == 1);
            UserBasicModel userBasicModel = new UserBasicModel();
            userBasicModel.vip_grade = feedComment.vip_grade;
            userBasicModel.is_vip_annual = feedComment.is_vip_annual;
            userBasicModel.is_hide_vip_look = feedComment.is_hide_vip_look;
            userBasicModel.vip_exp_lvl = feedComment.vip_exp_lvl;
            UserInfoHelper.a(FeedDetailsCommentListAdapter.this.b, this.f, userBasicModel);
            UserInfoHelper.a(this.o, userBasicModel);
            FeedMethods.a(this.p, feedComment.is_author);
            if (TextUtils.isEmpty(feedComment.is_reply)) {
                this.g.setText("");
            } else if ("1".equals(feedComment.is_reply)) {
                FeedMethods.a(FeedDetailsCommentListAdapter.this.b, this.g, feedComment, FeedDetailsCommentListAdapter.this.f, R.color.syc_a);
            } else if ("0".equals(feedComment.is_reply)) {
                FeedMethods.a(this.g, feedComment, FeedDetailsCommentListAdapter.this.f);
            } else {
                this.g.setText("");
            }
            if (feedComment.comments_count <= 0 || feedComment.comments == null || feedComment.comments.size() <= 0) {
                this.r.setVisibility(8);
            } else {
                FeedDetailsCommentListAdapter.this.a(this.t, feedComment.comments.get(0));
                if (feedComment.comments.size() > 1) {
                    FeedDetailsCommentListAdapter.this.a(this.u, feedComment.comments.get(1));
                } else {
                    this.u.setVisibility(8);
                }
                if (feedComment.comments_count > 2) {
                    String format = String.format(FeedDetailsCommentListAdapter.this.b.getResources().getString(R.string.reply_more), feedComment.comments_count + "");
                    if (feedComment.is_author_comment == 1) {
                        this.w.setText(R.string.anchor_and_others);
                        this.w.setVisibility(0);
                    } else {
                        this.w.setVisibility(8);
                    }
                    this.x.setText(format);
                    this.v.setVisibility(0);
                } else {
                    this.v.setVisibility(8);
                    this.w.setVisibility(8);
                }
                this.t.setMovementMethod(CustomLinkMovementMethod.getInstance());
                this.u.setMovementMethod(CustomLinkMovementMethod.getInstance());
                this.r.setVisibility(0);
                SingleClickProxy singleClickProxy = new SingleClickProxy(new View.OnClickListener() { // from class: com.blued.community.ui.comment.adapter.FeedDetailsCommentListAdapter.CommentViewHolder.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Tracker.onClick(view);
                        EventTrackFeed.e(FeedProtos.Event.FEED_DETAIL_PAGE_SHOW, feedComment.feed_id);
                        String string = FeedDetailsCommentListAdapter.this.b.getResources().getString(R.string.reply_title);
                        CommentFragment.a(FeedDetailsCommentListAdapter.this.b, String.format(string, feedComment.comments_count + ""), feedComment, FeedDetailsCommentListAdapter.this.d, FeedDetailsCommentListAdapter.this.a, FeedDetailsCommentListAdapter.this.g);
                    }
                });
                this.s.setOnClickListener(singleClickProxy);
                this.t.setOnClickListener(singleClickProxy);
                this.u.setOnClickListener(singleClickProxy);
            }
            final ImageView imageView = this.d;
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.blued.community.ui.comment.adapter.FeedDetailsCommentListAdapter.CommentViewHolder.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    if (feedComment.is_comment_anonym == 1 || feedComment.comment_uid.equals(UserInfoUtils.c())) {
                        return;
                    }
                    UserBasicModel userBasicModel2 = new UserBasicModel();
                    userBasicModel2.name = feedComment.user_name;
                    userBasicModel2.uid = feedComment.comment_uid;
                    userBasicModel2.avatar = feedComment.user_avatar;
                    LogData logData = new LogData();
                    logData.feed_id = feedComment.feed_id;
                    CommunityServiceManager.b().a(FeedDetailsCommentListAdapter.this.b, userBasicModel2, FeedDetailsCommentListAdapter.this.d, FeedDetailsCommentListAdapter.this.f, false, (View) imageView, logData, (MessageProtos.StrangerSource) null);
                }
            };
            this.f.setOnClickListener(onClickListener);
            this.d.setOnClickListener(onClickListener);
            FeedDetailsCommentListAdapter.this.a(this.c, feedComment);
            this.c.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.comment.adapter.-$$Lambda$FeedDetailsCommentListAdapter$CommentViewHolder$cnw-uxciv0PIbBFtNt9Q9n3uXkw
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FeedDetailsCommentListAdapter.CommentViewHolder.this.a(feedComment, view);
                }
            });
            if (feedComment.anchor_point == 1) {
                this.y.setVisibility(0);
                FeedDetailsCommentListAdapter.this.i = this.y;
            } else {
                this.y.setVisibility(8);
            }
            if (this.r.getVisibility() == 0) {
                Iterator<FeedComment> it = feedComment.comments.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    FeedComment next = it.next();
                    if (next.anchor_point == 1) {
                        FeedDetailsCommentListAdapter.this.a = next.comment_id;
                        z = true;
                        break;
                    }
                }
                if (z) {
                    this.z.setVisibility(0);
                    FeedDetailsCommentListAdapter.this.i = this.z;
                } else {
                    this.z.setVisibility(8);
                }
            }
            if (!feedComment.isShowUrlVisited) {
                EventTrackFeed.a(FeedProtos.Event.FEED_DETAIL_COMMENT_DRAW, feedComment.feed_id, feedComment.feed_uid, feedComment.comment_id);
                feedComment.isShowUrlVisited = true;
            }
            this.A.setGone(R.id.item_comment_ip_location_tv, !TextUtils.isEmpty(feedComment.ip_location)).setText(R.id.item_comment_ip_location_tv, String.format(FeedDetailsCommentListAdapter.this.b.getString(R.string.feed_comment_ip_location), feedComment.ip_location));
        }
    }

    /* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/comment/adapter/FeedDetailsCommentListAdapter$FeedCommentListener.class */
    public interface FeedCommentListener {
        void a(FeedComment feedComment);
    }

    public FeedDetailsCommentListAdapter(Context context, IRequestHost iRequestHost, String str) {
        super((List) null);
        this.e = true;
        this.a = "";
        this.g = -1;
        this.h = new HashSet<>();
        this.b = context;
        this.c = iRequestHost;
        this.f = str;
        addItemType(0, R.layout.item_feed_details_comment);
        addItemType(1, R.layout.item_feed_details_comment_header);
    }

    private List<FeedComment> a(List<FeedComment> list) {
        ArrayList arrayList = new ArrayList();
        for (FeedComment feedComment : list) {
            if (!this.h.contains(feedComment.comment_id)) {
                arrayList.add(feedComment);
                this.h.add(feedComment.comment_id);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, final FeedComment feedComment) {
        if (feedComment != null) {
            view.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.blued.community.ui.comment.adapter.FeedDetailsCommentListAdapter.1
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view2) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(FeedDetailsCommentListAdapter.this.b.getResources().getString(R.string.community_copy));
                    if (!feedComment.comment_uid.equals(UserInfoUtils.c())) {
                        arrayList.add(FeedDetailsCommentListAdapter.this.b.getResources().getString(R.string.report));
                    }
                    if ("1".equals(feedComment.comment_allow_delete)) {
                        arrayList.add(FeedDetailsCommentListAdapter.this.b.getResources().getString(R.string.delete));
                    }
                    CommonShowBottomWindow.a(FeedDetailsCommentListAdapter.this.b, (String[]) arrayList.toArray(new String[arrayList.size()]), new ActionSheet.ActionSheetListener() { // from class: com.blued.community.ui.comment.adapter.FeedDetailsCommentListAdapter.1.1
                        @Override // com.blued.android.module.common.widget.menu.ActionSheet.ActionSheetListener
                        public void a(ActionSheet actionSheet, int i) {
                            String a = actionSheet.a(i);
                            if (a.equals(FeedDetailsCommentListAdapter.this.b.getResources().getString(R.string.community_copy))) {
                                FeedDetailsCommentListAdapter.this.a(feedComment);
                            } else if (a.equals(FeedDetailsCommentListAdapter.this.b.getResources().getString(R.string.delete))) {
                                FeedDetailsCommentListAdapter.this.b(feedComment);
                            } else if (a.equals(FeedDetailsCommentListAdapter.this.b.getResources().getString(R.string.report))) {
                                CommunityServiceManager.b().a(FeedDetailsCommentListAdapter.this.b, CommunityConstants.ReportType.FEED_COMMENT, feedComment.user_name, feedComment.feed_id, feedComment.comment_id);
                            }
                        }

                        @Override // com.blued.android.module.common.widget.menu.ActionSheet.ActionSheetListener
                        public void a(ActionSheet actionSheet, boolean z) {
                        }
                    });
                    return true;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TextView textView, FeedComment feedComment) {
        String str;
        String str2;
        if (TextUtils.isEmpty(feedComment.comment_id)) {
            textView.setVisibility(8);
            return;
        }
        textView.setVisibility(0);
        int textSize = (int) textView.getTextSize();
        String a = FeedMethods.a(2, 0);
        String str3 = !TextUtils.isEmpty(feedComment.note) ? feedComment.note : feedComment.user_name;
        String str4 = str3 == null ? "" : str3;
        String str5 = feedComment.is_author == 1 ? " is_author_flag" : "";
        String str6 = feedComment.comment_content;
        if ("1".equals(feedComment.is_reply)) {
            str2 = feedComment.reply_name != null ? feedComment.reply_name.replace(":", "") : "";
            str = this.b.getResources().getString(R.string.reply) + " ";
        } else {
            str = "";
            str2 = str;
        }
        String str7 = "" + str4;
        String str8 = str7;
        if (!TextUtils.isEmpty(str4)) {
            str8 = str7 + " ";
        }
        String str9 = str8 + str5;
        String str10 = str9;
        if (!TextUtils.isEmpty(str5)) {
            str10 = str9 + " ";
        }
        String str11 = str10 + str + str2 + "：" + str6;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str11);
        if (!TextUtils.isEmpty(str4)) {
            spannableStringBuilder.setSpan(new FeedMethods.UserNameClickSpan(this.b, str4, feedComment.comment_uid, str4, feedComment.avatar, a, R.color.syc_a), str11.indexOf(str4), str11.indexOf(str4) + str4.length(), 17);
        }
        if (!TextUtils.isEmpty(str5)) {
            Drawable drawable = this.b.getResources().getDrawable(R.drawable.feed_author_icon);
            drawable.setBounds(0, 0, AppMethods.a(30), AppMethods.a(15));
            spannableStringBuilder.setSpan(new ImageSpan(drawable, 2), str11.indexOf(str5), str11.indexOf(str5) + str5.length(), 33);
        }
        if (!TextUtils.isEmpty(str2)) {
            spannableStringBuilder.setSpan(new FeedMethods.UserNameClickSpan(this.b, str2, feedComment.reply_uid, str2, feedComment.reply_avatar, a, R.color.syc_a), str11.indexOf(str2), str11.indexOf(str2) + str2.length(), 17);
        }
        StringUtils.a(spannableStringBuilder, textSize, 1);
        StringUtils.a(spannableStringBuilder, true, true, false, (StringUtils.ClickAtLinkListener) null, true, "", a);
        StringUtils.a(textView, StringUtils.a(spannableStringBuilder, true, new boolean[0]), 0, this.f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(FeedComment feedComment, ImageView imageView, TextView textView) {
        if (g()) {
            EventTrackFeed.a(FeedProtos.Event.FEED_INTERACTIVE, feedComment.feed_id, feedComment.iliked == 1 ? FeedProtos.InteractiveType.NO_LIKE : FeedProtos.InteractiveType.LIKE, FeedProtos.Location.COMMENT_DETAIL, feedComment.comment_id, feedComment.feed_uid);
        } else {
            EventTrackFeed.a(FeedProtos.Event.FEED_INTERACTIVE, feedComment.feed_id, feedComment.iliked == 1 ? FeedProtos.InteractiveType.NO_LIKE : FeedProtos.InteractiveType.LIKE, FeedProtos.Location.FEED_DETAIL, feedComment.comment_id, feedComment.feed_uid);
        }
        String str = feedComment.comment_id;
        String str2 = feedComment.feed_id;
        int i = feedComment.iliked == 0 ? 1 : 0;
        if (g()) {
            a(str, i);
        } else {
            CommentListDataObserver.a().a(str, i);
        }
        FeedHttpUtils.a(str2, str, i, (BluedUIHttpResponse) null, this.c, true);
    }

    private void b(BaseViewHolder baseViewHolder, FeedComment feedComment) {
        TextView textView = (TextView) baseViewHolder.getView(R.id.item_feed_detail_comment_header_tv);
        if (textView != null) {
            textView.setText(String.format(this.b.getString(R.string.feed_been_filtered), String.valueOf(feedComment.tick_negative_comment)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g() {
        return this.f.equals("feed_comment_floor");
    }

    public void a() {
        View view = this.i;
        if (view != null) {
            view.setVisibility(0);
            this.i.setAlpha(0.1f);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.i, "alpha", 0.1f, 0.0f);
            ofFloat.setDuration(3000L);
            ofFloat.setStartDelay(3000L);
            ofFloat.start();
        }
    }

    public void a(int i) {
        this.g = i;
    }

    public void a(BluedIngSelfFeed bluedIngSelfFeed) {
        this.d = bluedIngSelfFeed;
    }

    public void a(FeedCommentListener feedCommentListener) {
        this.j = feedCommentListener;
    }

    public void a(FeedComment feedComment) {
        String str = feedComment.comment_content;
        if (Build.VERSION.SDK_INT != 18) {
            try {
                ((ClipboardManager) this.b.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("simple text", RegExpUtils.a(str)));
            } catch (Exception e) {
            }
        } else {
            ((android.text.ClipboardManager) this.b.getSystemService("clipboard")).setText(RegExpUtils.a(str));
        }
        AppMethods.a((CharSequence) this.b.getResources().getString(R.string.copy));
    }

    @Override // com.blued.community.ui.feed.observer.CommentListDataObserver.ICommentDataObserver
    public void a(FeedComment feedComment, String str) {
        int i;
        int i2;
        if (feedComment != null && this.e && this.d != null && feedComment.feed_id.equals(this.d.feed_id)) {
            feedComment.vbadge = feedComment.user_vbadge;
            if (g()) {
                int i3 = 0;
                while (true) {
                    i2 = i3;
                    if (i2 >= this.mData.size()) {
                        i2 = -1;
                        break;
                    } else if (((FeedComment) this.mData.get(i2)).isLastHotComment) {
                        break;
                    } else {
                        i3 = i2 + 1;
                    }
                }
                if (i2 == -1) {
                    this.mData.add(0, feedComment);
                } else {
                    this.mData.add(i2 + 1, feedComment);
                }
            } else if (!TextUtils.isEmpty(str)) {
                Iterator it = this.mData.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    FeedComment feedComment2 = (FeedComment) it.next();
                    if (str.equals(feedComment2.comment_id)) {
                        if (feedComment2.comments == null) {
                            feedComment2.comments = new ArrayList();
                        }
                        feedComment2.comments_count++;
                        feedComment2.comments.add(0, feedComment);
                    }
                }
            } else {
                int i4 = 0;
                while (true) {
                    i = i4;
                    if (i >= this.mData.size()) {
                        i = -1;
                        break;
                    } else if (((FeedComment) this.mData.get(i)).isLastHotComment) {
                        break;
                    } else {
                        i4 = i + 1;
                    }
                }
                if (i != -1) {
                    this.mData.add(i + 1, feedComment);
                } else if (this.mData.size() <= 0 || ((FeedComment) this.mData.get(0)).itemViewType != 1) {
                    this.mData.add(0, feedComment);
                } else {
                    this.mData.add(1, feedComment);
                }
            }
            notifyDataSetChanged();
        }
        if (feedComment == null || !this.e) {
            return;
        }
        feedComment.vbadge = feedComment.user_vbadge;
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, FeedComment feedComment) {
        if (baseViewHolder != null) {
            int adapterPosition = baseViewHolder.getAdapterPosition();
            int headerLayoutCount = getHeaderLayoutCount();
            if (baseViewHolder.getItemViewType() != 1) {
                new CommentViewHolder(baseViewHolder, baseViewHolder.getConvertView()).a(feedComment, adapterPosition - headerLayoutCount);
            } else {
                b(baseViewHolder, feedComment);
            }
        }
    }

    @Override // com.blued.community.ui.feed.observer.CommentListDataObserver.ICommentDataObserver
    public void a(String str) {
        int i;
        if (TextUtils.isEmpty(str) || this.mData == null || this.mData.size() <= 0) {
            return;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.mData.size()) {
                if (str.equals(((FeedComment) this.mData.get(i3)).comment_id) && ((FeedComment) this.mData.get(i3)).isLastHotComment && (i = i3 - 1) >= 0) {
                    ((FeedComment) this.mData.get(i)).isLastHotComment = ((FeedComment) this.mData.get(i3)).isLastHotComment;
                    ((FeedComment) this.mData.get(i)).isHasMoreHotComment = ((FeedComment) this.mData.get(i3)).isHasMoreHotComment;
                    break;
                }
                i2 = i3 + 1;
            } else {
                break;
            }
        }
        Iterator it = this.mData.iterator();
        while (it.hasNext()) {
            if (str.equals(((FeedComment) it.next()).comment_id)) {
                it.remove();
            }
        }
        notifyDataSetChanged();
    }

    @Override // com.blued.community.ui.feed.observer.CommentListDataObserver.ICommentDataObserver
    public void a(String str, int i) {
        if (TextUtils.isEmpty(str) || this.mData == null || this.mData.size() <= 0) {
            return;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.mData.size()) {
                notifyDataSetChanged();
                return;
            }
            if (str.equals(((FeedComment) this.mData.get(i3)).comment_id)) {
                ((FeedComment) this.mData.get(i3)).iliked = i;
                if (i == 1) {
                    ((FeedComment) this.mData.get(i3)).liked_count++;
                } else {
                    ((FeedComment) this.mData.get(i3)).liked_count--;
                }
            }
            i2 = i3 + 1;
        }
    }

    public void b() {
        View viewByPosition;
        if (getRecyclerView() == null || (viewByPosition = getViewByPosition(c() + getHeaderLayoutCount(), R.id.comment_blue_mask)) == null) {
            return;
        }
        viewByPosition.setVisibility(0);
        viewByPosition.setAlpha(0.1f);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(viewByPosition, "alpha", 0.1f, 0.0f);
        ofFloat.setDuration(300L);
        ofFloat.setStartDelay(700L);
        ofFloat.start();
    }

    public void b(final FeedComment feedComment) {
        StringBuilder sb;
        String str;
        String string = this.b.getString(R.string.hint);
        CharSequence a = StringUtils.a(feedComment.comment_content, false, true, false, "feed_detail");
        if (a.length() > 14) {
            sb = new StringBuilder();
            sb.append((Object) a.subSequence(0, 14));
            str = "...";
        } else {
            sb = new StringBuilder();
            sb.append((Object) a);
            str = "";
        }
        sb.append(str);
        String format = String.format(this.b.getResources().getString(R.string.delete_comment_confirm), sb.toString());
        Context context = this.b;
        CommonAlertDialog.a(context, string, format, context.getResources().getString(R.string.delete), new DialogInterface.OnClickListener() { // from class: com.blued.community.ui.comment.adapter.FeedDetailsCommentListAdapter.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Tracker.onClick(dialogInterface, i);
                FeedHttpUtils.a((BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntityA<Object>>() { // from class: com.blued.community.ui.comment.adapter.FeedDetailsCommentListAdapter.2.1
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.blued.android.framework.http.BluedUIHttpResponse
                    /* renamed from: a */
                    public BluedEntityA<Object> parseData(String str2) {
                        return (BluedEntityA) super.parseData(str2);
                    }

                    @Override // com.blued.android.framework.http.BluedUIHttpResponse
                    /* renamed from: a */
                    public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
                        if (FeedDetailsCommentListAdapter.this.g()) {
                            FeedDetailsCommentListAdapter.this.a(feedComment.comment_id);
                        } else {
                            CommentListDataObserver.a().a(feedComment.comment_id);
                            LiveEventBus.get("feed_delete_comment").post(feedComment);
                        }
                        AppMethods.a((CharSequence) AppInfo.d().getResources().getString(R.string.del_success));
                    }

                    @Override // com.blued.android.framework.http.BluedUIHttpResponse, com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
                    public void onFailure(Throwable th, int i2, String str2) {
                        AppMethods.a((CharSequence) AppInfo.d().getResources().getString(R.string.common_net_error));
                        super.onFailure(th, i2, str2);
                    }
                }, true, feedComment.feed_id, feedComment.comment_id, FeedDetailsCommentListAdapter.this.d.is_ads, FeedDetailsCommentListAdapter.this.c);
            }
        }, this.b.getResources().getString(R.string.cancel), (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
    }

    public int c() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= getData().size()) {
                return 0;
            }
            if (((FeedComment) getData().get(i2)).isLastHotComment) {
                return i2 + 1;
            }
            i = i2 + 1;
        }
    }

    public void d() {
        View view = this.i;
        if (view != null) {
            view.setVisibility(8);
            this.i.clearAnimation();
        }
    }

    public void e() {
        CommentListDataObserver.a().a(this);
    }

    public void f() {
        CommentListDataObserver.a().b(this);
    }

    public void setNewData(List<FeedComment> list) {
        this.h.clear();
        if (this.mData == null || this.mData.size() <= 0) {
            this.mData = new ArrayList();
        } else {
            this.mData.clear();
        }
        if (list != null) {
            this.mData.addAll(a(list));
        }
        notifyDataSetChanged();
    }
}
