package com.blued.community.ui.comment.adapter;

import android.animation.ObjectAnimator;
import android.content.ClipData;
import android.content.DialogInterface;
import android.os.Build;
import android.text.ClipboardManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.AppUtils;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.Logger;
import com.blued.android.framework.utils.RegExpUtils;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.log.oldtrack.LogData;
import com.blued.android.module.common.login.model.UserBasicModel;
import com.blued.android.module.common.user.UserInfoHelper;
import com.blued.android.module.common.utils.AvatarUtils;
import com.blued.android.module.common.utils.DistanceUtils;
import com.blued.android.module.common.utils.ImageUtils;
import com.blued.android.module.common.utils.TimeAndDateUtils;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.blued.android.module.common.widget.menu.ActionSheet;
import com.blued.android.module.common.widget.menu.CommonShowBottomWindow;
import com.blued.community.R;
import com.blued.community.auto.CommunityServiceManager;
import com.blued.community.http.CircleHttpUtils;
import com.blued.community.http.FeedHttpUtils;
import com.blued.community.manager.CommunityConstants;
import com.blued.community.model.BluedIngSelfFeed;
import com.blued.community.track.EventTrackFeed;
import com.blued.community.ui.circle.manager.CircleMethods;
import com.blued.community.ui.circle.model.CircleAddPoints;
import com.blued.community.ui.comment.fragment.HotCommentsFragment;
import com.blued.community.ui.comment.model.FeedComment;
import com.blued.community.ui.feed.manager.FeedMethods;
import com.blued.community.ui.feed.observer.CommentListDataObserver;
import com.blued.community.utils.AtUserHelper;
import com.blued.community.utils.StringUtils;
import com.blued.community.utils.UserInfoUtils;
import com.blued.community.view.CustomLinkMovementMethod;
import com.blued.das.client.feed.FeedProtos;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/comment/adapter/CircleMainDetailCommentAdapter.class */
public class CircleMainDetailCommentAdapter extends BaseQuickAdapter<FeedComment, BaseViewHolder> implements CommentListDataObserver.ICommentDataObserver {
    public static final String a = CircleMainDetailCommentAdapter.class.getSimpleName();
    public String b;
    public IRequestHost c;
    public BluedIngSelfFeed d;
    public String e;
    public String f;
    private int g;
    private HashSet<String> h;
    private View i;
    private String j;

    public CircleMainDetailCommentAdapter(String str) {
        super(R.layout.item_feed_details_comment_circle, (List) null);
        this.b = "";
        this.e = "";
        this.f = "";
        this.g = 1;
        this.h = new HashSet<>();
        this.j = "";
        this.j = str;
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

    private void a(View view, final FeedComment feedComment) {
        if (feedComment != null) {
            view.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.blued.community.ui.comment.adapter.CircleMainDetailCommentAdapter.9
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view2) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(CircleMainDetailCommentAdapter.this.mContext.getResources().getString(R.string.community_copy));
                    if (feedComment.user_allow_mute == CircleMainDetailCommentAdapter.this.g) {
                        arrayList.add(CircleMainDetailCommentAdapter.this.mContext.getResources().getString(feedComment.is_muted == 1 ? R.string.circle_comments_list_cancel_mute : R.string.circle_comments_list_mute));
                    }
                    if (!CircleMethods.a(feedComment.comment_uid)) {
                        arrayList.add(CircleMainDetailCommentAdapter.this.mContext.getResources().getString(R.string.report));
                    }
                    if ("1".equals(feedComment.comment_allow_delete)) {
                        arrayList.add(CircleMainDetailCommentAdapter.this.mContext.getResources().getString(R.string.delete));
                    }
                    CommonShowBottomWindow.a(CircleMainDetailCommentAdapter.this.mContext, (String[]) arrayList.toArray(new String[arrayList.size()]), new ActionSheet.ActionSheetListener() { // from class: com.blued.community.ui.comment.adapter.CircleMainDetailCommentAdapter.9.1
                        @Override // com.blued.android.module.common.widget.menu.ActionSheet.ActionSheetListener
                        public void a(ActionSheet actionSheet, int i) {
                            String a2 = actionSheet.a(i);
                            if (a2.equals(CircleMainDetailCommentAdapter.this.mContext.getResources().getString(R.string.community_copy))) {
                                CircleMainDetailCommentAdapter.this.a(feedComment);
                            } else if (a2.equals(CircleMainDetailCommentAdapter.this.mContext.getResources().getString(R.string.delete))) {
                                CircleMainDetailCommentAdapter.this.b(feedComment);
                            } else if (a2.equals(CircleMainDetailCommentAdapter.this.mContext.getResources().getString(R.string.report))) {
                                CommunityServiceManager.b().a(CircleMainDetailCommentAdapter.this.mContext, CommunityConstants.ReportType.CIRCLE_COMMENT, feedComment.user_name, feedComment.feed_id, feedComment.comment_id);
                            } else {
                                if (a2.equals(CircleMainDetailCommentAdapter.this.mContext.getResources().getString(feedComment.is_muted == 1 ? R.string.circle_comments_list_cancel_mute : R.string.circle_comments_list_mute))) {
                                    CircleMainDetailCommentAdapter.this.a(feedComment, CircleMainDetailCommentAdapter.this.c);
                                }
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
    public void a(FeedComment feedComment, ImageView imageView, TextView textView) {
        String str = feedComment.comment_id;
        String str2 = feedComment.feed_id;
        int i = feedComment.iliked == 1 ? 0 : 1;
        feedComment.iliked = i;
        if (feedComment.iliked == 1) {
            feedComment.liked_count++;
            imageView.setImageResource(R.drawable.icon_comment_liked);
            textView.setTextColor(this.mContext.getResources().getColor(R.color.feed_like));
        } else {
            feedComment.liked_count--;
            imageView.setImageResource(R.drawable.icon_comment_like);
            textView.setTextColor(BluedSkinUtils.a(this.mContext, R.color.syc_i));
        }
        if (feedComment.liked_count == 0) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
        textView.setText(DistanceUtils.a(this.mContext, feedComment.liked_count + ""));
        if (this.d != null) {
            EventTrackFeed.a(this.e, str2, str, i == 1, AtUserHelper.a(feedComment.comment_content), EventTrackFeed.a(feedComment), EventTrackFeed.c(this.d), this.d.is_anonym == 1, feedComment.is_anonym == 1, FeedProtos.NoteSource.NOTE_DETAIL, "");
        }
        FeedHttpUtils.a(str2, str, i, (BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntityA<CircleAddPoints>>(this.c) { // from class: com.blued.community.ui.comment.adapter.CircleMainDetailCommentAdapter.8
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<CircleAddPoints> bluedEntityA) {
                if (bluedEntityA == null || !bluedEntityA.hasData() || bluedEntityA.getSingleData().circle_active_liked_posting <= 0) {
                    return;
                }
                AppMethods.a((CharSequence) ("点赞成功，积分+" + bluedEntityA.getSingleData().circle_active_liked_posting));
            }
        }, this.c, false);
    }

    private void c(final FeedComment feedComment) {
        CommonAlertDialog.a(this.mContext, feedComment.mute_type == 0 ? this.mContext.getResources().getString(R.string.circle_mute_member_dialog_first_title) : feedComment.mute_type == 1 ? this.mContext.getResources().getString(R.string.circle_mute_member_dialog_second_title) : this.mContext.getResources().getString(R.string.circle_mute_member_dialog_third_title), this.mContext.getResources().getString(R.string.circle_mute_member_dialog_content), this.mContext.getResources().getString(R.string.circle_mute_member_dialog_btn), 0, new DialogInterface.OnClickListener() { // from class: com.blued.community.ui.comment.adapter.CircleMainDetailCommentAdapter.11
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Tracker.onClick(dialogInterface, i);
                CircleMainDetailCommentAdapter.this.d(feedComment);
            }
        }, this.mContext.getResources().getString(R.string.cancel), this.mContext.getResources().getColor(R.color.syc_A5A6B3), (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final FeedComment feedComment) {
        CircleHttpUtils.a(feedComment.circle_id, new BluedUIHttpResponse(this.c) { // from class: com.blued.community.ui.comment.adapter.CircleMainDetailCommentAdapter.12
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity bluedEntity) {
                feedComment.is_muted = 1;
                if (feedComment.mute_type == 0) {
                    feedComment.mute_type = 1;
                } else if (feedComment.mute_type == 1) {
                    feedComment.mute_type = 2;
                } else if (feedComment.mute_type == 2) {
                    feedComment.mute_type = 1009;
                } else {
                    feedComment.mute_type = 1009;
                }
                CircleMainDetailCommentAdapter.this.notifyDataSetChanged();
                AppMethods.a((CharSequence) AppUtils.a(R.string.circle_post_detail_menu_mute_success));
            }
        }, feedComment.comment_uid, feedComment.is_anonym, feedComment.user_name, feedComment.user_avatar, this.c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g() {
        return this.b.equals("feed_comment_floor");
    }

    public String a() {
        return this.f;
    }

    public void a(FeedComment feedComment) {
        String str = feedComment.comment_content;
        if (Build.VERSION.SDK_INT < 11 || Build.VERSION.SDK_INT == 18) {
            ((ClipboardManager) this.mContext.getSystemService("clipboard")).setText(RegExpUtils.a(str));
        } else {
            try {
                ((android.content.ClipboardManager) this.mContext.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("simple text", RegExpUtils.a(str)));
            } catch (Exception e) {
            }
        }
        AppMethods.a((CharSequence) this.mContext.getResources().getString(R.string.copy));
    }

    public void a(final FeedComment feedComment, IRequestHost iRequestHost) {
        if (feedComment.is_muted == 1) {
            CircleHttpUtils.a(feedComment.circle_id, new BluedUIHttpResponse(iRequestHost) { // from class: com.blued.community.ui.comment.adapter.CircleMainDetailCommentAdapter.10
                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                public void onUIUpdate(BluedEntity bluedEntity) {
                    feedComment.is_muted = 0;
                    CircleMainDetailCommentAdapter.this.notifyDataSetChanged();
                    AppMethods.a((CharSequence) AppUtils.a(R.string.circle_post_detail_menu_mute_canceled_success));
                    if (feedComment.mute_type == 1009 || feedComment.mute_type == 1010) {
                        feedComment.mute_type = 0;
                    }
                }
            }, feedComment.comment_uid, feedComment.is_anonym, iRequestHost);
        } else {
            c(feedComment);
        }
    }

    @Override // com.blued.community.ui.feed.observer.CommentListDataObserver.ICommentDataObserver
    public void a(FeedComment feedComment, String str) {
        int i;
        if (feedComment != null) {
            feedComment.vbadge = feedComment.user_vbadge;
            if (!TextUtils.isEmpty(str)) {
                int i2 = 0;
                while (true) {
                    i = i2;
                    if (i >= getData().size()) {
                        break;
                    }
                    FeedComment feedComment2 = (FeedComment) getData().get(i);
                    if (str.equals(feedComment2.comment_id)) {
                        if (feedComment2.comments == null) {
                            feedComment2.comments = new ArrayList();
                        }
                        feedComment2.comments_count++;
                        feedComment2.comments.add(0, feedComment);
                    } else {
                        i2 = i + 1;
                    }
                }
            }
            i = -1;
            if (i != -1) {
                notifyItemChanged(i + getHeaderLayoutCount());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void convert(final BaseViewHolder baseViewHolder, final FeedComment feedComment) {
        boolean z;
        ShapeHelper.b((ShapeLinearLayout) baseViewHolder.getView(R.id.ll_reply), R.color.syc_x);
        if (feedComment.iliked == 1) {
            baseViewHolder.setImageResource(R.id.img_comment_like, R.drawable.icon_comment_liked).setTextColor(R.id.tv_comment_like_count, this.mContext.getResources().getColor(R.color.feed_like));
        } else {
            baseViewHolder.setImageResource(R.id.img_comment_like, R.drawable.icon_comment_like).setTextColor(R.id.tv_comment_like_count, BluedSkinUtils.a(this.mContext, R.color.syc_i));
        }
        if (feedComment.liked_count > 0) {
            baseViewHolder.setText(R.id.tv_comment_like_count, DistanceUtils.a(this.mContext, feedComment.liked_count + "")).setGone(R.id.tv_comment_like_count, true);
        } else {
            baseViewHolder.setGone(R.id.tv_comment_like_count, false);
        }
        baseViewHolder.getView(R.id.img_comment_like).setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.comment.adapter.CircleMainDetailCommentAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                CircleMainDetailCommentAdapter.this.a(feedComment, (ImageView) baseViewHolder.getView(R.id.img_comment_like), (TextView) baseViewHolder.getView(R.id.tv_comment_like_count));
            }
        });
        baseViewHolder.getView(R.id.tv_comment_like_count).setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.comment.adapter.CircleMainDetailCommentAdapter.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                CircleMainDetailCommentAdapter.this.a(feedComment, (ImageView) baseViewHolder.getView(R.id.img_comment_like), (TextView) baseViewHolder.getView(R.id.tv_comment_like_count));
            }
        });
        if (feedComment.isLastHotComment) {
            baseViewHolder.setGone(R.id.ll_more_hot_comment, true);
            if (feedComment.isHasMoreHotComment) {
                baseViewHolder.setGone(R.id.img_arrow, true).setText(R.id.tv_more_hot_comment, this.mContext.getResources().getString(R.string.more_hot_comment));
                baseViewHolder.getView(R.id.ll_more_hot_comment).setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.comment.adapter.CircleMainDetailCommentAdapter.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Tracker.onClick(view);
                        HotCommentsFragment.a(CircleMainDetailCommentAdapter.this.mContext, CircleMainDetailCommentAdapter.this.d);
                    }
                });
            } else {
                baseViewHolder.setGone(R.id.img_arrow, false).setText(R.id.tv_more_hot_comment, this.mContext.getResources().getString(R.string.above_is_all_hot_comment));
                baseViewHolder.getView(R.id.ll_more_hot_comment).setOnClickListener(null);
            }
        } else {
            baseViewHolder.setGone(R.id.ll_more_hot_comment, false);
        }
        UserInfoHelper.a((ImageView) baseViewHolder.getView(R.id.img_verify), feedComment.vbadge, 3);
        ImageLoader.a(this.c, feedComment.user_avatar).b(R.drawable.user_bg_round).c().a((ImageView) baseViewHolder.getView(R.id.header_view));
        if (TextUtils.isEmpty(feedComment.comment_timestamp)) {
            baseViewHolder.setText(R.id.time_view, "");
        } else {
            baseViewHolder.setText(R.id.time_view, TimeAndDateUtils.h(this.mContext, TimeAndDateUtils.c(feedComment.comment_timestamp)));
        }
        if (TextUtils.isEmpty(feedComment.user_name)) {
            baseViewHolder.setText(R.id.name_view, "");
        } else if (TextUtils.isEmpty(feedComment.note)) {
            baseViewHolder.setText(R.id.name_view, feedComment.user_name.replace(":", ""));
        } else {
            baseViewHolder.setText(R.id.name_view, StringUtils.a(feedComment.note, feedComment.user_name.replace(":", "")));
        }
        UserBasicModel userBasicModel = new UserBasicModel();
        userBasicModel.vip_grade = feedComment.vip_grade;
        userBasicModel.is_vip_annual = feedComment.is_vip_annual;
        userBasicModel.is_hide_vip_look = feedComment.is_hide_vip_look;
        userBasicModel.vip_exp_lvl = feedComment.vip_exp_lvl;
        UserInfoHelper.a(this.mContext, (TextView) baseViewHolder.getView(R.id.name_view), userBasicModel);
        UserInfoHelper.a((ImageView) baseViewHolder.getView(R.id.img_vip_icon), userBasicModel);
        CircleMethods.a((ImageView) baseViewHolder.getView(R.id.iv_level), feedComment.admin_level, feedComment.is_author);
        baseViewHolder.setGone(R.id.iv_anonymous, feedComment.is_anonym == 1);
        if (TextUtils.isEmpty(feedComment.is_reply)) {
            baseViewHolder.setText(R.id.content_view, "");
        } else if ("1".equals(feedComment.is_reply)) {
            FeedMethods.a(this.mContext, (TextView) baseViewHolder.getView(R.id.content_view), feedComment, this.b, R.color.syc_a);
        } else if ("0".equals(feedComment.is_reply)) {
            FeedMethods.a((TextView) baseViewHolder.getView(R.id.content_view), feedComment, this.b);
        } else {
            baseViewHolder.setText(R.id.content_view, "");
        }
        if (feedComment.comments_count <= 0 || feedComment.comments == null || feedComment.comments.size() <= 0) {
            baseViewHolder.setGone(R.id.cl_reply, false);
        } else {
            final FeedComment feedComment2 = feedComment.comments.get(0);
            CharSequence a2 = (TextUtils.isEmpty(feedComment2.is_reply) || !"1".equals(feedComment2.is_reply)) ? FeedMethods.a(this.mContext, (int) ((TextView) baseViewHolder.getView(R.id.tv_reply_first)).getTextSize(), feedComment2, 13, R.color.syc_a) : FeedMethods.a(this.mContext, (int) ((TextView) baseViewHolder.getView(R.id.tv_reply_first)).getTextSize(), feedComment2, feedComment2.is_anonym, 13, R.color.syc_a);
            if (TextUtils.isEmpty(a2)) {
                baseViewHolder.setGone(R.id.ll_reply_first, false);
            } else {
                baseViewHolder.setText(R.id.tv_reply_first_name, !TextUtils.isEmpty(feedComment2.note) ? feedComment2.note : feedComment2.user_name);
                CircleMethods.a((ImageView) baseViewHolder.getView(R.id.iv_reply_first), feedComment2.admin_level, feedComment2.is_author);
                baseViewHolder.setGone(R.id.iv_anonymous_first, feedComment2.is_anonym == 1);
                baseViewHolder.getView(R.id.tv_reply_first_name).setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.comment.adapter.CircleMainDetailCommentAdapter.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Tracker.onClick(view);
                        if (feedComment2.is_anonym == 1) {
                            AppMethods.d(R.string.circle_anonymous_not_to_user_info);
                        } else {
                            CommunityServiceManager.b().a(CircleMainDetailCommentAdapter.this.mContext, feedComment2.comment_uid, "CIRCLE_NOTE_DETAIL");
                        }
                    }
                });
                StringUtils.a((TextView) baseViewHolder.getView(R.id.tv_reply_first), a2, 0, this.b);
                baseViewHolder.setGone(R.id.ll_reply_first, true);
            }
            if (feedComment.comments.size() > 1) {
                final FeedComment feedComment3 = feedComment.comments.get(1);
                CharSequence a3 = (TextUtils.isEmpty(feedComment3.is_reply) || !"1".equals(feedComment3.is_reply)) ? FeedMethods.a(this.mContext, (int) ((TextView) baseViewHolder.getView(R.id.tv_reply_second)).getTextSize(), feedComment3, 13, R.color.syc_a) : FeedMethods.a(this.mContext, (int) ((TextView) baseViewHolder.getView(R.id.tv_reply_second)).getTextSize(), feedComment3, feedComment3.is_anonym, 13, R.color.syc_a);
                if (TextUtils.isEmpty(a3)) {
                    baseViewHolder.setGone(R.id.ll_reply_second, false);
                } else {
                    baseViewHolder.setText(R.id.tv_reply_second_name, !TextUtils.isEmpty(feedComment3.note) ? feedComment3.note : feedComment3.user_name);
                    CircleMethods.a((ImageView) baseViewHolder.getView(R.id.iv_reply_second), feedComment3.admin_level, feedComment3.is_author);
                    baseViewHolder.setGone(R.id.iv_anonymous_second, feedComment3.is_anonym == 1);
                    baseViewHolder.getView(R.id.tv_reply_second_name).setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.comment.adapter.CircleMainDetailCommentAdapter.5
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            Tracker.onClick(view);
                            if (feedComment3.is_anonym == 1) {
                                AppMethods.d(R.string.circle_anonymous_not_to_user_info);
                            } else {
                                CommunityServiceManager.b().a(CircleMainDetailCommentAdapter.this.mContext, feedComment3.comment_uid, "CIRCLE_NOTE_DETAIL");
                            }
                        }
                    });
                    StringUtils.a((TextView) baseViewHolder.getView(R.id.tv_reply_second), a3, 0, this.b);
                    baseViewHolder.setGone(R.id.ll_reply_second, true);
                }
            } else {
                baseViewHolder.setGone(R.id.ll_reply_second, false);
            }
            if (feedComment.comments_count > 2) {
                baseViewHolder.setText(R.id.tv_reply_num, String.format(this.mContext.getResources().getString(R.string.reply_more), feedComment.comments_count + ""));
                baseViewHolder.setGone(R.id.ll_more_reply, true);
            } else {
                baseViewHolder.setGone(R.id.ll_more_reply, false);
            }
            ((TextView) baseViewHolder.getView(R.id.tv_reply_first)).setMovementMethod(CustomLinkMovementMethod.getInstance());
            ((TextView) baseViewHolder.getView(R.id.tv_reply_second)).setMovementMethod(CustomLinkMovementMethod.getInstance());
            baseViewHolder.setGone(R.id.cl_reply, true);
            baseViewHolder.addOnClickListener(R.id.ll_reply).addOnClickListener(R.id.tv_reply_first).addOnClickListener(R.id.tv_reply_second);
        }
        final ImageView imageView = (ImageView) baseViewHolder.getView(R.id.header_view);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.blued.community.ui.comment.adapter.CircleMainDetailCommentAdapter.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                if (feedComment.is_anonym == 1) {
                    AppMethods.d(R.string.circle_anonymous_not_to_user_info);
                } else if (feedComment.comment_uid.equals(UserInfoUtils.c())) {
                } else {
                    UserBasicModel userBasicModel2 = new UserBasicModel();
                    userBasicModel2.name = feedComment.user_name;
                    userBasicModel2.uid = feedComment.comment_uid;
                    userBasicModel2.avatar = feedComment.user_avatar;
                    LogData logData = new LogData();
                    logData.feed_id = feedComment.feed_id;
                    logData.target_uid = feedComment.comment_uid;
                    logData.circle_id = feedComment.circle_id;
                    logData.listMode = CircleMainDetailCommentAdapter.this.j;
                    logData.from = CircleMainDetailCommentAdapter.this.b;
                    logData.userFrom = CircleMainDetailCommentAdapter.this.b;
                    CommunityServiceManager.b().a(CircleMainDetailCommentAdapter.this.mContext, userBasicModel2, CircleMainDetailCommentAdapter.this.b, imageView);
                }
            }
        };
        baseViewHolder.getView(R.id.name_view).setOnClickListener(onClickListener);
        imageView.setOnClickListener(onClickListener);
        LinearLayout linearLayout = (LinearLayout) baseViewHolder.getView(R.id.ll_img);
        if (feedComment.comment_pics == null || feedComment.comment_pics.length <= 0) {
            linearLayout.setVisibility(8);
        } else {
            linearLayout.setVisibility(0);
            int i = this.mContext.getResources().getDisplayMetrics().widthPixels;
            final LoadOptions loadOptions = new LoadOptions();
            loadOptions.d = R.drawable.defaultpicture;
            loadOptions.b = R.drawable.defaultpicture;
            int i2 = i >> 1;
            loadOptions.a(i2, i2);
            int a4 = AppInfo.l - DensityUtils.a(AppInfo.d(), 74.0f);
            double d = a4;
            int i3 = (int) (d * 1.5d);
            int i4 = (int) (d * 0.73d);
            try {
                linearLayout.removeAllViews();
                int i5 = 0;
                while (true) {
                    final int i6 = i5;
                    if (i6 >= feedComment.comment_pics.length) {
                        break;
                    }
                    int[] a5 = ImageUtils.a(Integer.valueOf(feedComment.comment_pics_width[i6]).intValue(), Integer.valueOf(feedComment.comment_pics_height[i6]).intValue(), a4, i3, a4, i4);
                    View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.item_comment_pics, (ViewGroup) null);
                    ImageView imageView2 = (ImageView) inflate.findViewById(R.id.circle_image);
                    ShapeTextView shapeTextView = (ShapeTextView) inflate.findViewById(R.id.circle_big_icon);
                    if (feedComment.comment_pics_height == null || feedComment.comment_pics_height.length <= i6) {
                        shapeTextView.setVisibility(8);
                    } else if (StringUtils.b(feedComment.comment_pics_height[i6]) > AppInfo.m * 1.5d) {
                        shapeTextView.setVisibility(0);
                    } else {
                        shapeTextView.setVisibility(8);
                    }
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(a5[0], a5[1]);
                    if (i6 != feedComment.comment_pics.length - 1) {
                        layoutParams.bottomMargin = DensityUtils.a(this.mContext, 10.0f);
                    }
                    imageView2.setLayoutParams(layoutParams);
                    ImageLoader.a(this.c, AvatarUtils.a(feedComment.comment_pics[i6], a5[i6])).a(6.0f).a(imageView2);
                    linearLayout.addView(inflate);
                    imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.comment.adapter.CircleMainDetailCommentAdapter.7
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            Tracker.onClick(view);
                            FeedProtos.Event event = FeedProtos.Event.CIRCLE_NOTE_COMMENT_IMAGE_CLICK;
                            String str = feedComment.comment_id;
                            FeedProtos.NoteSource noteSource = FeedProtos.NoteSource.NOTE_DETAIL;
                            String str2 = feedComment.feed_id;
                            String str3 = CircleMainDetailCommentAdapter.this.e;
                            boolean a6 = AtUserHelper.a(feedComment.comment_content);
                            FeedProtos.NoteType c = EventTrackFeed.c(CircleMainDetailCommentAdapter.this.d);
                            boolean z2 = false;
                            boolean z3 = CircleMainDetailCommentAdapter.this.d.is_anonym == 1;
                            if (feedComment.is_anonym == 1) {
                                z2 = true;
                            }
                            EventTrackFeed.a(event, str, noteSource, str2, str3, a6, c, z3, z2);
                            CommunityServiceManager.b().a(CircleMainDetailCommentAdapter.this.mContext, feedComment.comment_pics, i6, 0, loadOptions, feedComment.user_name, baseViewHolder.getView(R.id.rl_comment), feedComment.comment_pics[i6]);
                        }
                    });
                    i5 = i6 + 1;
                }
            } catch (Throwable th) {
                Logger.e("图片越界", new Object[0]);
            }
        }
        a(baseViewHolder.getView(R.id.rl_comment), feedComment);
        baseViewHolder.addOnClickListener(R.id.rl_comment);
        View view = baseViewHolder.getView(R.id.comment_blue_mask);
        if (feedComment.anchor_point == 1) {
            view.setVisibility(0);
            this.i = view;
        } else {
            view.setVisibility(8);
        }
        View view2 = baseViewHolder.getView(R.id.reply_blue_mask);
        if (baseViewHolder.getView(R.id.cl_reply).getVisibility() == 0) {
            Iterator<FeedComment> it = feedComment.comments.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                FeedComment next = it.next();
                if (next.anchor_point == 1) {
                    this.f = next.comment_id;
                    z = true;
                    break;
                }
            }
            if (z) {
                view2.setVisibility(0);
                this.i = view2;
            } else {
                view2.setVisibility(8);
            }
        }
        if (feedComment.isShowUrlVisited) {
            return;
        }
        FeedProtos.Event event = FeedProtos.Event.CIRCLE_NOTE_COMMENT_DRAW;
        String str = feedComment.comment_id;
        FeedProtos.NoteSource noteSource = FeedProtos.NoteSource.NOTE_DETAIL;
        String str2 = feedComment.feed_id;
        String str3 = feedComment.circle_id;
        boolean a6 = AtUserHelper.a(feedComment.comment_content);
        FeedProtos.FeedClass a7 = EventTrackFeed.a(feedComment);
        FeedProtos.NoteType c = EventTrackFeed.c(this.d);
        BluedIngSelfFeed bluedIngSelfFeed = this.d;
        EventTrackFeed.a(event, str, noteSource, str2, str3, a6, a7, c, bluedIngSelfFeed != null && bluedIngSelfFeed.is_anonym == 1, feedComment.is_anonym == 1);
        feedComment.isShowUrlVisited = true;
    }

    @Override // com.blued.community.ui.feed.observer.CommentListDataObserver.ICommentDataObserver
    public void a(String str) {
        int i;
        Log.v("drb", "circle comment notifyCommentDeleted");
        if (TextUtils.isEmpty(str) || getData() == null || getData().size() <= 0) {
            return;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < getData().size()) {
                if (str.equals(((FeedComment) getData().get(i3)).comment_id) && ((FeedComment) getData().get(i3)).isLastHotComment && (i = i3 - 1) >= 0) {
                    ((FeedComment) getData().get(i)).isLastHotComment = ((FeedComment) getData().get(i3)).isLastHotComment;
                    ((FeedComment) getData().get(i)).isHasMoreHotComment = ((FeedComment) getData().get(i3)).isHasMoreHotComment;
                    break;
                }
                i2 = i3 + 1;
            } else {
                break;
            }
        }
        Iterator it = getData().iterator();
        while (it.hasNext()) {
            if (str.equals(((FeedComment) it.next()).comment_id)) {
                Log.v("drb", "circle comment iter.remove()");
                it.remove();
            }
        }
        notifyDataSetChanged();
    }

    @Override // com.blued.community.ui.feed.observer.CommentListDataObserver.ICommentDataObserver
    public void a(String str, int i) {
    }

    public void b() {
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

    public void b(final FeedComment feedComment) {
        StringBuilder sb;
        String str;
        String string = this.mContext.getString(R.string.hint);
        CharSequence a2 = StringUtils.a(feedComment.comment_content, false, true, false, "CIRCLE_NOTE_DETAIL");
        if (a2.length() > 14) {
            sb = new StringBuilder();
            sb.append((Object) a2.subSequence(0, 14));
            str = "...";
        } else {
            sb = new StringBuilder();
            sb.append((Object) a2);
            str = "";
        }
        sb.append(str);
        CommonAlertDialog.a(this.mContext, string, String.format(this.mContext.getResources().getString(R.string.delete_comment_confirm), sb.toString()), this.mContext.getResources().getString(R.string.delete), new DialogInterface.OnClickListener() { // from class: com.blued.community.ui.comment.adapter.CircleMainDetailCommentAdapter.13
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Tracker.onClick(dialogInterface, i);
                FeedHttpUtils.a((BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntityA<Object>>() { // from class: com.blued.community.ui.comment.adapter.CircleMainDetailCommentAdapter.13.1
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.blued.android.framework.http.BluedUIHttpResponse
                    /* renamed from: a */
                    public BluedEntityA<Object> parseData(String str2) {
                        return (BluedEntityA) super.parseData(str2);
                    }

                    @Override // com.blued.android.framework.http.BluedUIHttpResponse
                    /* renamed from: a */
                    public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
                        if (CircleMainDetailCommentAdapter.this.g()) {
                            CircleMainDetailCommentAdapter.this.a(feedComment.comment_id);
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
                }, false, feedComment.feed_id, feedComment.comment_id, CircleMainDetailCommentAdapter.this.d.is_ads, CircleMainDetailCommentAdapter.this.c);
            }
        }, this.mContext.getResources().getString(R.string.common_cancel), new DialogInterface.OnClickListener() { // from class: com.blued.community.ui.comment.adapter.CircleMainDetailCommentAdapter.14
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Tracker.onClick(dialogInterface, i);
            }
        }, (DialogInterface.OnDismissListener) null);
    }

    public void c() {
        View viewByPosition;
        if (getRecyclerView() == null || (viewByPosition = getViewByPosition(getHeaderLayoutCount(), R.id.comment_blue_mask)) == null) {
            return;
        }
        viewByPosition.setVisibility(0);
        viewByPosition.setAlpha(0.1f);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(viewByPosition, "alpha", 0.1f, 0.0f);
        ofFloat.setDuration(300L);
        ofFloat.setStartDelay(700L);
        ofFloat.start();
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
