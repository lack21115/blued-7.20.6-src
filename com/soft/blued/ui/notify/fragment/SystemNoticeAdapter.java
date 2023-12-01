package com.soft.blued.ui.notify.fragment;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.image.ImageWrapper;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.module.common.log.oldtrack.LogData;
import com.blued.android.module.common.login.model.UserBasicModel;
import com.blued.android.module.common.user.UserInfoHelper;
import com.blued.android.module.common.utils.AvatarUtils;
import com.blued.android.module.common.utils.CommonStringUtils;
import com.blued.android.module.common.utils.TimeAndDateUtils;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.community.auto.CommunityServiceManager;
import com.blued.community.model.BluedIngSelfFeed;
import com.blued.community.model.FeedNotice;
import com.blued.community.track.EventTrackFeed;
import com.blued.community.ui.circle.fragment.CirclePostDetailsFragment;
import com.blued.community.ui.circle.manager.CircleMethods;
import com.blued.community.ui.circle.model.CircleJoinState;
import com.blued.community.ui.feed.fragment.FeedDetailsFragment;
import com.blued.community.ui.feed.fragment.SignFeedListFragment;
import com.blued.community.ui.feed.manager.FeedMethods;
import com.blued.community.ui.feed.model.FeedDetailParams;
import com.blued.das.client.feed.FeedProtos;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.R;
import com.soft.blued.ui.feed.fragment.ReplyCommentFragment;
import com.soft.blued.ui.msg.controller.tools.ChatHelperV4;
import com.soft.blued.ui.msg.model.ChatBundleExtra;
import com.soft.blued.ui.msg.model.MsgSourceEntity;
import com.soft.blued.ui.notify.manager.NotifyMethods;
import com.soft.blued.ui.user.fragment.UserInfoFragmentNew;
import com.soft.blued.utils.AtChooseUserHelper;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.TypefaceUtils;
import com.soft.blued.utils.UserRelationshipUtils;
import java.util.ArrayList;
import java.util.Collections;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/notify/fragment/SystemNoticeAdapter.class */
public class SystemNoticeAdapter extends BaseMultiItemQuickAdapter<FeedNotice, BaseViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    private boolean f19211a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private IRequestHost f19212c;
    private FragmentManager d;
    private Context e;
    private OnReadListener f;

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/notify/fragment/SystemNoticeAdapter$NoticeHolder.class */
    public static class NoticeHolder {

        /* renamed from: a  reason: collision with root package name */
        public ImageView f19228a;
        public ImageView b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f19229c;
        public TextView d;
        public TextView e;
        public TextView f;
        public TextView g;
        public TextView h;
        public ImageView i;
        public View j;
        public TextView k;
        public TextView l;
        public ImageView m;
        public ImageView n;
        private View o;

        public NoticeHolder(View view) {
            this.o = view;
            this.f19228a = (ImageView) view.findViewById(2131364232);
            this.b = (ImageView) view.findViewById(R.id.photo_view);
            this.f19229c = (ImageView) view.findViewById(R.id.video_flag);
            this.d = (TextView) view.findViewById(R.id.time_view);
            this.e = (TextView) view.findViewById(R.id.name_view);
            this.f = (TextView) view.findViewById(R.id.news_view);
            this.g = (TextView) view.findViewById(R.id.zan_view);
            this.h = (TextView) view.findViewById(2131363075);
            this.i = (ImageView) view.findViewById(R.id.img_verify);
            this.j = view.findViewById(2131367715);
            this.k = (TextView) view.findViewById(R.id.tv_from_feed);
            this.l = (TextView) view.findViewById(R.id.tv_feed_notice_reply);
            this.m = (ImageView) view.findViewById(2131364726);
            this.n = (ImageView) view.findViewById(R.id.iv_anonymous);
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/notify/fragment/SystemNoticeAdapter$OnReadListener.class */
    public interface OnReadListener {
        void a();
    }

    public SystemNoticeAdapter(Context context, IRequestHost iRequestHost, FragmentManager fragmentManager, boolean z) {
        super(null);
        this.b = 0;
        this.f19211a = z;
        this.f19212c = iRequestHost;
        this.d = fragmentManager;
        this.e = context;
        addItemType(0, R.layout.item_system_notice);
        addItemType(1, R.layout.item_system_notice);
    }

    private void a(final ImageView imageView, final FeedNotice feedNotice) {
        ImageWrapper c2 = ImageLoader.a(this.f19212c, feedNotice.avatar).b(2131237310).c();
        if (feedNotice.is_user_anonym == 1) {
            c2.d();
        }
        c2.a(imageView);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.notify.fragment.SystemNoticeAdapter.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                EventTrackFeed.a(FeedProtos.Event.MSG_NOTICE_COMMENT_USER_CLICK, feedNotice);
                if (12 == feedNotice.type) {
                    BluedIngSelfFeed bluedIngSelfFeed = new BluedIngSelfFeed();
                    bluedIngSelfFeed.feed_id = feedNotice.feed_id;
                    bluedIngSelfFeed.feed_content = feedNotice.feed_content;
                    bluedIngSelfFeed.feed_uid = feedNotice.uid;
                    bluedIngSelfFeed.feed_timestamp = feedNotice.timestamp;
                    bluedIngSelfFeed.is_bubble_ticktock = 1;
                    FeedMethods.a(view.getContext(), bluedIngSelfFeed, 22);
                } else if (feedNotice.is_user_anonym == 1) {
                } else {
                    if (feedNotice.is_anonym == 1) {
                        AppMethods.d((int) R.string.circle_anonymous_not_to_user_info);
                        return;
                    }
                    feedNotice.has_read = 1;
                    if (SystemNoticeAdapter.this.f != null) {
                        SystemNoticeAdapter.this.f.a();
                    }
                    SystemNoticeAdapter.this.notifyDataSetChanged();
                    Context context = SystemNoticeAdapter.this.e;
                    FeedNotice feedNotice2 = feedNotice;
                    UserInfoFragmentNew.a(context, (UserBasicModel) feedNotice2, NotifyMethods.a(feedNotice2), "", (View) imageView);
                }
            }
        });
    }

    private void a(TextView textView, ImageView imageView, ImageView imageView2, FeedNotice feedNotice) {
        if (feedNotice.feed_pics != null && feedNotice.feed_pics.length > 0) {
            textView.setVisibility(8);
            imageView2.setVisibility(0);
            imageView.setVisibility(8);
            ImageLoader.a(this.f19212c, feedNotice.feed_pics[0]).b(2131231620).a(imageView2);
        } else if ("1".equals(feedNotice.is_videos) && feedNotice.feed_videos != null && feedNotice.feed_videos.length > 0) {
            textView.setVisibility(8);
            imageView2.setVisibility(0);
            imageView.setVisibility(0);
            ImageLoader.a(this.f19212c, feedNotice.feed_videos[0]).b(2131231620).a(imageView2);
        } else {
            textView.setVisibility(0);
            imageView2.setVisibility(8);
            imageView.setVisibility(8);
            if (TextUtils.isEmpty(feedNotice.feed_content)) {
                textView.setText("");
            } else {
                textView.setText(StringUtils.a(StringUtils.a(feedNotice.feed_content, (int) textView.getTextSize(), 1), false, true, false, ""));
            }
        }
    }

    private void a(TextView textView, TextView textView2, FeedNotice feedNotice) {
        if (feedNotice.type != 0 && feedNotice.type != 1 && feedNotice.type != 6 && feedNotice.type != 9 && feedNotice.type != 12) {
            textView2.setVisibility(8);
            textView.setVisibility(0);
            if (feedNotice.from == 1) {
                textView.setText(R.string.circle_like);
                return;
            } else if (feedNotice.is_comments_liked == 1) {
                textView.setText(this.e.getResources().getString(R.string.like_your_feed_comment));
                return;
            } else {
                textView.setText(this.e.getResources().getString(R.string.like_your_feed));
                return;
            }
        }
        textView2.setVisibility(0);
        textView.setVisibility(8);
        if (feedNotice.comment_deleted == 1) {
            textView2.setTextColor(BluedSkinUtils.a(this.e, 2131102263));
            if (feedNotice.type == 12) {
                textView2.setText(2131892244);
            } else {
                textView2.setText(R.string.comment_delete);
            }
        } else if (feedNotice.is_negative_comment == 1) {
            textView2.setTextColor(BluedSkinUtils.a(this.e, 2131102263));
            textView2.setText(R.string.view_point_negative_feed);
        } else {
            textView2.setTextColor(BluedSkinUtils.a(this.e, 2131102254));
            if (feedNotice.type == 12) {
                textView2.setText(R.string.sign_notice_type_str);
            } else if (TextUtils.isEmpty(feedNotice.content)) {
                textView2.setText("");
            } else {
                TypefaceUtils.a(textView2, feedNotice.content, 1, "");
            }
        }
    }

    private void a(TextView textView, FeedNotice feedNotice) {
        if (TextUtils.isEmpty(feedNotice.note)) {
            textView.setText(feedNotice.name);
        } else {
            textView.setText(feedNotice.note);
        }
        UserRelationshipUtils.a(this.e, textView, (UserBasicModel) feedNotice);
    }

    private void b(TextView textView, FeedNotice feedNotice) {
        if (TextUtils.isEmpty(feedNotice.timestamp)) {
            textView.setText("");
        } else {
            textView.setText(TimeAndDateUtils.a(this.e, TimeAndDateUtils.c(feedNotice.timestamp)));
        }
    }

    private void b(BaseViewHolder baseViewHolder, final FeedNotice feedNotice) {
        View view = baseViewHolder.getView(2131369470);
        if (feedNotice.has_read == 0) {
            view.setBackgroundColor(BluedSkinUtils.a(this.e, 2131102360));
        } else {
            view.setBackground(BluedSkinUtils.b(this.e, (int) R.drawable.selector_item_msg));
        }
        baseViewHolder.setGone(R.id.tv_feed_notice_reply, false).setGone(R.id.tv_from_feed, false);
        UserInfoHelper.a((ImageView) baseViewHolder.getView(R.id.img_verify), feedNotice.vbadge, 3);
        final ImageView imageView = (ImageView) baseViewHolder.getView(2131364232);
        ImageWrapper c2 = ImageLoader.a(this.f19212c, AvatarUtils.a(0, feedNotice.avatar)).b(2131237310).c();
        if (feedNotice.is_user_anonym == 1) {
            c2.d();
        }
        c2.a(imageView);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.notify.fragment.SystemNoticeAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Tracker.onClick(view2);
                if (feedNotice.is_user_anonym == 1) {
                    return;
                }
                feedNotice.has_read = 1;
                SystemNoticeAdapter.this.notifyDataSetChanged();
                Context context = SystemNoticeAdapter.this.e;
                FeedNotice feedNotice2 = feedNotice;
                UserInfoFragmentNew.a(context, (UserBasicModel) feedNotice2, NotifyMethods.a(feedNotice2), "", (View) imageView);
                EventTrackFeed.a(FeedProtos.Event.MSG_NOTICE_COMMENT_USER_CLICK, feedNotice);
            }
        });
        if (TextUtils.isEmpty(feedNotice.note)) {
            baseViewHolder.setText(R.id.name_view, feedNotice.name);
        } else {
            baseViewHolder.setText(R.id.name_view, feedNotice.note);
        }
        UserRelationshipUtils.a(this.e, (TextView) baseViewHolder.getView(R.id.name_view), (UserBasicModel) feedNotice);
        UserRelationshipUtils.a((ImageView) baseViewHolder.getView(2131364726), (UserBasicModel) feedNotice);
        baseViewHolder.setGone(R.id.iv_anonymous, feedNotice.is_user_anonym == 1);
        TextView textView = (TextView) baseViewHolder.getView(R.id.news_view);
        textView.setVisibility(0);
        ((TextView) baseViewHolder.getView(R.id.zan_view)).setVisibility(8);
        int i = feedNotice.type;
        if (i == 7) {
            textView.setText(this.e.getString(R.string.vote_A));
        } else if (i == 8) {
            textView.setText(this.e.getString(R.string.vote_B));
        } else if (i == 10) {
            textView.setText(R.string.circle_text_vote_has_voted);
        }
        TextView textView2 = (TextView) baseViewHolder.getView(R.id.time_view);
        if (TextUtils.isEmpty(feedNotice.timestamp)) {
            textView2.setText("");
        } else {
            textView2.setText(TimeAndDateUtils.a(this.e, TimeAndDateUtils.c(feedNotice.timestamp)));
        }
        TextView textView3 = (TextView) baseViewHolder.getView(2131363075);
        ImageView imageView2 = (ImageView) baseViewHolder.getView(R.id.photo_view);
        if (feedNotice.feed_pics == null || feedNotice.feed_pics.length <= 0) {
            textView3.setVisibility(0);
            imageView2.setVisibility(8);
            if (TextUtils.isEmpty(feedNotice.feed_content)) {
                textView3.setText("");
            } else {
                textView3.setText(((Object) StringUtils.a(feedNotice.feed_content, false, true, false, "")) + "");
            }
        } else {
            textView3.setVisibility(8);
            imageView2.setVisibility(0);
            ImageLoader.a(this.f19212c, feedNotice.feed_pics[0]).a(12.0f).d(2131231620).b(2131231620).a(imageView2);
        }
        final View view2 = baseViewHolder.getView(2131367715);
        view2.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.notify.fragment.SystemNoticeAdapter.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view3) {
                Tracker.onClick(view3);
                feedNotice.has_read = 1;
                SystemNoticeAdapter.this.notifyDataSetChanged();
                BluedIngSelfFeed bluedIngSelfFeed = new BluedIngSelfFeed();
                bluedIngSelfFeed.feed_id = feedNotice.feed_id;
                bluedIngSelfFeed.aid = feedNotice.aid;
                bluedIngSelfFeed.is_ads = feedNotice.is_ads;
                bluedIngSelfFeed.is_vote = 1;
                if (10 == feedNotice.type) {
                    CirclePostDetailsFragment.a(SystemNoticeAdapter.this.e, feedNotice.feed_id, FeedProtos.NoteSource.UNKNOWN_NOTE_SOURCE);
                } else {
                    FeedDetailsFragment.a(SystemNoticeAdapter.this.e, bluedIngSelfFeed, -1, new FeedDetailParams(0));
                }
            }
        });
        view.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.notify.fragment.SystemNoticeAdapter.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view3) {
                Tracker.onClick(view3);
                feedNotice.has_read = 1;
                SystemNoticeAdapter.this.notifyDataSetChanged();
                view2.callOnClick();
            }
        });
        baseViewHolder.getView(R.id.tv_feed_notice_reply).setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.notify.fragment.SystemNoticeAdapter.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view3) {
                Tracker.onClick(view3);
                feedNotice.has_read = 1;
                SystemNoticeAdapter.this.notifyDataSetChanged();
                ReplyCommentFragment.a(SystemNoticeAdapter.this.e, feedNotice);
            }
        });
    }

    private void c(BaseViewHolder baseViewHolder, final FeedNotice feedNotice) {
        final NoticeHolder noticeHolder = new NoticeHolder(baseViewHolder.getConvertView());
        if (this.f19211a) {
            noticeHolder.l.setVisibility(0);
        } else {
            noticeHolder.l.setVisibility(8);
        }
        if (feedNotice.has_read == 0) {
            noticeHolder.o.setBackgroundColor(BluedSkinUtils.a(this.e, 2131102360));
        } else {
            noticeHolder.o.setBackground(BluedSkinUtils.b(this.e, (int) R.drawable.selector_item_msg));
        }
        a(noticeHolder.e, feedNotice);
        a(noticeHolder.f19228a, feedNotice);
        UserInfoHelper.a(noticeHolder.i, feedNotice.vbadge, 3);
        UserRelationshipUtils.a(noticeHolder.m, (UserBasicModel) feedNotice);
        noticeHolder.n.setVisibility((feedNotice.is_anonym == 1 || feedNotice.is_user_anonym == 1) ? 0 : 8);
        a(noticeHolder.g, noticeHolder.f, feedNotice);
        b(noticeHolder.d, feedNotice);
        a(noticeHolder.h, noticeHolder.f19229c, noticeHolder.b, feedNotice);
        noticeHolder.h.setTextColor(BluedSkinUtils.a(this.e, 2131102254));
        noticeHolder.b.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.notify.fragment.SystemNoticeAdapter.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                noticeHolder.j.callOnClick();
            }
        });
        if (feedNotice.from_top == 1) {
            noticeHolder.l.setText(R.string.circle_view);
        } else {
            noticeHolder.l.setText(R.string.notice_reply);
        }
        if (feedNotice.from == 1) {
            noticeHolder.k.setText(R.string.from_circle);
        } else if (feedNotice.is_feed_anonym == 1) {
            noticeHolder.k.setText(R.string.super_topic_from_anonymous);
        } else {
            noticeHolder.k.setText(R.string.from_feed);
        }
        if (feedNotice.type == 12) {
            noticeHolder.k.setText(R.string.sign_notice_from_str);
            noticeHolder.l.setText(this.e.getString(R.string.notice_come_back));
        }
        if (this.b == 1) {
            noticeHolder.k.setVisibility(8);
        } else {
            noticeHolder.k.setVisibility(0);
        }
        final boolean c2 = AtChooseUserHelper.c(feedNotice.content);
        noticeHolder.j.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.notify.fragment.SystemNoticeAdapter.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                FeedProtos.Event event = FeedProtos.Event.MSG_NOTICE_COMMENT_CLICK;
                String str = feedNotice.comment_id;
                String str2 = feedNotice.circle_id;
                String str3 = feedNotice.feed_id;
                EventTrackFeed.a(event, str, str2, str3, feedNotice.id + "", feedNotice.must_anonym_reply == 1);
                feedNotice.has_read = 1;
                if (SystemNoticeAdapter.this.f != null) {
                    SystemNoticeAdapter.this.f.a();
                }
                SystemNoticeAdapter.this.notifyDataSetChanged();
                String str4 = feedNotice.comment_deleted != 1 ? feedNotice.comment_id : "";
                if (12 == feedNotice.type) {
                    if (feedNotice.comment_deleted == 1) {
                        ToastUtils.a(2131892244);
                    } else {
                        SignFeedListFragment.b.a(SystemNoticeAdapter.this.e, feedNotice.feed_id, 8, (BluedIngSelfFeed) null);
                    }
                } else if (feedNotice.from == 1) {
                    if (CommunityServiceManager.a().C()) {
                        ToastUtils.b((int) R.string.account_invalid_to_send_feed_comment);
                    } else {
                        CirclePostDetailsFragment.a(SystemNoticeAdapter.this.e, feedNotice.feed_id, str4, c2 ? FeedProtos.NoteSource.NOTICE_COMMENT_AT : FeedProtos.NoteSource.NOTICE_COMMENT_ENTER, false);
                    }
                } else {
                    BluedIngSelfFeed bluedIngSelfFeed = new BluedIngSelfFeed();
                    bluedIngSelfFeed.feed_id = feedNotice.feed_id;
                    bluedIngSelfFeed.aid = feedNotice.aid;
                    bluedIngSelfFeed.is_ads = feedNotice.is_ads;
                    FeedDetailParams feedDetailParams = new FeedDetailParams(0);
                    feedDetailParams.commentID = str4;
                    FeedDetailsFragment.a(SystemNoticeAdapter.this.e, bluedIngSelfFeed, 22, feedDetailParams);
                }
            }
        });
        noticeHolder.h.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.notify.fragment.SystemNoticeAdapter.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                noticeHolder.j.callOnClick();
            }
        });
        noticeHolder.l.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.notify.fragment.SystemNoticeAdapter.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                EventTrackFeed.a(FeedProtos.Event.MSG_NOTICE_COMMENT_REPLY, feedNotice.comment_id, feedNotice.circle_id, feedNotice.feed_id, feedNotice.uid + "", feedNotice.type + "");
                feedNotice.has_read = 1;
                if (SystemNoticeAdapter.this.f != null) {
                    SystemNoticeAdapter.this.f.a();
                }
                SystemNoticeAdapter.this.notifyDataSetChanged();
                if (feedNotice.from_top == 1) {
                    CirclePostDetailsFragment.a(SystemNoticeAdapter.this.e, feedNotice.feed_id, c2 ? FeedProtos.NoteSource.NOTICE_COMMENT_AT : FeedProtos.NoteSource.NOTICE_COMMENT_ENTER);
                } else if (feedNotice.type != 12 || TextUtils.isEmpty(feedNotice.uid)) {
                    if (feedNotice.admin_level == 3) {
                        CircleMethods.a(SystemNoticeAdapter.this.e, new CircleMethods.JoinViewChangeListener() { // from class: com.soft.blued.ui.notify.fragment.SystemNoticeAdapter.8.1
                            public void joinViewChange(CircleJoinState circleJoinState) {
                                feedNotice.setJoinState(circleJoinState);
                                SystemNoticeAdapter.this.notifyDataSetChanged();
                            }
                        }, feedNotice.getJoinState(), SystemNoticeAdapter.this.f19212c, SystemNoticeAdapter.this.d, false, true);
                    } else {
                        ReplyCommentFragment.a(SystemNoticeAdapter.this.e, feedNotice);
                    }
                } else {
                    ChatBundleExtra chatBundleExtra = new ChatBundleExtra();
                    BluedIngSelfFeed bluedIngSelfFeed = new BluedIngSelfFeed();
                    bluedIngSelfFeed.feed_id = feedNotice.feed_id;
                    bluedIngSelfFeed.feed_uid = feedNotice.uid;
                    bluedIngSelfFeed.user_name = feedNotice.name;
                    bluedIngSelfFeed.feed_content = feedNotice.feed_content;
                    bluedIngSelfFeed.is_bubble_ticktock = 1;
                    chatBundleExtra.feed = bluedIngSelfFeed;
                    ChatHelperV4.a().a(SystemNoticeAdapter.this.e, CommonStringUtils.c(feedNotice.uid), feedNotice.name, feedNotice.avatar, feedNotice.vbadge, feedNotice.vip_grade, feedNotice.is_vip_annual, feedNotice.vip_exp_lvl, "", false, 0, feedNotice.is_hide_vip_look, (LogData) null, (MsgSourceEntity) null, chatBundleExtra);
                    EventTrackFeed.c(FeedProtos.Event.MSG_NOTICE_PUNCH_FEED_HI_CLICK, feedNotice.feed_id, feedNotice.uid, feedNotice.notification_id + "");
                }
            }
        });
        if (12 == feedNotice.type) {
            EventTrackFeed.a(FeedProtos.Event.MSG_NOTICE_COMMENT_SHOW, "", "", feedNotice.feed_id, feedNotice.uid + "", feedNotice.type + "");
        } else if (feedNotice.isShowUrlVisited) {
        } else {
            EventTrackFeed.a(FeedProtos.Event.MSG_NOTICE_COMMENT_SHOW, feedNotice.comment_id, feedNotice.circle_id, feedNotice.feed_id, feedNotice.uid + "", feedNotice.type + "");
            feedNotice.isShowUrlVisited = true;
        }
    }

    public long a() {
        ArrayList arrayList = new ArrayList();
        getData();
        if (getData().isEmpty()) {
            return 0L;
        }
        for (T t : getData()) {
            arrayList.add(Long.valueOf(t.notification_id));
        }
        return ((Long) Collections.max(arrayList)).longValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, FeedNotice feedNotice) {
        if (baseViewHolder.getItemViewType() != 1) {
            c(baseViewHolder, feedNotice);
        } else {
            b(baseViewHolder, feedNotice);
        }
    }

    public void a(OnReadListener onReadListener) {
        this.f = onReadListener;
    }

    public int b() {
        int i = 0;
        for (T t : getData()) {
            if (t.has_read == 0) {
                i++;
            }
        }
        return i;
    }

    public void c() {
        for (T t : getData()) {
            t.has_read = 1;
        }
        notifyDataSetChanged();
    }
}
