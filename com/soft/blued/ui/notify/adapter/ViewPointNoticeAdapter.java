package com.soft.blued.ui.notify.adapter;

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
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.image.ImageWrapper;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.module.common.login.model.UserBasicModel;
import com.blued.android.module.common.user.UserInfoHelper;
import com.blued.android.module.common.utils.AvatarUtils;
import com.blued.android.module.common.utils.TimeAndDateUtils;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.community.model.BluedIngSelfFeed;
import com.blued.community.model.FeedNotice;
import com.blued.community.ui.circle.fragment.CirclePostDetailsFragment;
import com.blued.community.ui.feed.fragment.FeedDetailsFragment;
import com.blued.community.ui.feed.manager.FeedMethods;
import com.blued.community.ui.feed.model.FeedDetailParams;
import com.blued.das.client.feed.FeedProtos;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.ui.feed.fragment.ReplyCommentFragment;
import com.soft.blued.ui.notify.manager.NotifyMethods;
import com.soft.blued.ui.user.fragment.UserInfoFragmentNew;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.TypefaceUtils;
import com.soft.blued.utils.UserRelationshipUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/notify/adapter/ViewPointNoticeAdapter.class */
public class ViewPointNoticeAdapter extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private Context f19194a;
    private LayoutInflater b;

    /* renamed from: c  reason: collision with root package name */
    private List<FeedNotice> f19195c;
    private int d;
    private int e = 0;
    private LoadOptions f;
    private boolean g;
    private IRequestHost h;

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/notify/adapter/ViewPointNoticeAdapter$USED_IN_PAGE.class */
    public interface USED_IN_PAGE {
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/notify/adapter/ViewPointNoticeAdapter$ViewHolder.class */
    public class ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public View f19202a;
        public ImageView b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f19203c;
        public ImageView d;
        public TextView e;
        public TextView f;
        public TextView g;
        public View h;
        public TextView i;
        public TextView j;
        public ImageView k;
        public ImageView l;
        public View m;
        public TextView n;
        public TextView o;
        public ImageView p;

        public ViewHolder() {
        }
    }

    public ViewPointNoticeAdapter(Context context, IRequestHost iRequestHost, boolean z) {
        this.f19194a = context;
        this.h = iRequestHost;
        this.g = z;
        this.b = LayoutInflater.from(context);
        LoadOptions loadOptions = new LoadOptions();
        this.f = loadOptions;
        loadOptions.d = 2131101298;
        this.f.b = 2131101298;
        this.f19195c = new ArrayList();
        this.d = this.f19194a.getResources().getDisplayMetrics().widthPixels;
    }

    private String c(int i) {
        String[] stringArray = this.f19194a.getResources().getStringArray(R.array.feed_interact_str);
        int i2 = i - 1;
        return (i2 < 0 || i2 >= stringArray.length) ? "" : stringArray[i2];
    }

    public long a() {
        ArrayList arrayList = new ArrayList();
        List<FeedNotice> list = this.f19195c;
        if (list == null || list.size() <= 0) {
            return 0L;
        }
        for (FeedNotice feedNotice : this.f19195c) {
            arrayList.add(Long.valueOf(feedNotice.notification_id));
        }
        return ((Long) Collections.max(arrayList)).longValue();
    }

    public void a(int i) {
        this.e = i;
    }

    public void a(final ViewHolder viewHolder, final FeedNotice feedNotice, View view, int i) {
        viewHolder.f19202a.setVisibility(0);
        if (feedNotice.has_read == 0) {
            viewHolder.f19202a.setBackgroundColor(BluedSkinUtils.a(this.f19194a, 2131102360));
        } else {
            viewHolder.f19202a.setBackgroundColor(BluedSkinUtils.a(this.f19194a, 2131101780));
        }
        UserInfoHelper.a(viewHolder.k, feedNotice.vbadge, 3);
        ImageWrapper c2 = ImageLoader.a(this.h, AvatarUtils.a(0, feedNotice.avatar)).b(2131237310).c();
        if (feedNotice.is_user_anonym == 1) {
            c2.d();
        }
        c2.a(viewHolder.b);
        viewHolder.b.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.notify.adapter.ViewPointNoticeAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Tracker.onClick(view2);
                if (feedNotice.is_user_anonym == 1) {
                    return;
                }
                feedNotice.has_read = 1;
                ViewPointNoticeAdapter.this.notifyDataSetChanged();
                Context context = ViewPointNoticeAdapter.this.f19194a;
                FeedNotice feedNotice2 = feedNotice;
                UserInfoFragmentNew.a(context, (UserBasicModel) feedNotice2, NotifyMethods.a(feedNotice2), "notice_like", (View) viewHolder.b);
            }
        });
        if (TextUtils.isEmpty(feedNotice.note)) {
            viewHolder.f.setText(feedNotice.name);
        } else {
            viewHolder.f.setText(feedNotice.note);
        }
        UserRelationshipUtils.a(this.f19194a, viewHolder.f, (UserBasicModel) feedNotice);
        UserRelationshipUtils.a(viewHolder.p, (UserBasicModel) feedNotice);
        viewHolder.l.setVisibility(feedNotice.is_user_anonym == 1 ? 0 : 8);
        if (feedNotice.type == 0) {
            viewHolder.g.setVisibility(0);
            viewHolder.h.setVisibility(8);
            if (TextUtils.isEmpty(feedNotice.content)) {
                viewHolder.g.setText("");
            } else {
                TypefaceUtils.a(viewHolder.g, feedNotice.content, 1, "");
            }
        } else {
            viewHolder.g.setVisibility(8);
            viewHolder.h.setVisibility(0);
            if (feedNotice.from != 1) {
                if (feedNotice.is_comments_liked == 1) {
                    viewHolder.i.setText(this.f19194a.getResources().getString(R.string.like_your_feed_comment));
                } else if (feedNotice.is_negative_comment == 1) {
                    viewHolder.i.setText(R.string.view_point_negative_feed);
                } else {
                    int i2 = feedNotice.expression_id;
                    int i3 = i2;
                    if (i2 == 0) {
                        i3 = 1;
                    }
                    String str = feedNotice.is_feed_anonym == 1 ? "在你的匿名动态下表示：" : "在你的动态下表示：";
                    String c3 = c(i3);
                    String str2 = str + c3;
                    String str3 = str2;
                    if (!TextUtils.isEmpty(c3)) {
                        str3 = str2 + "expression_emotion";
                    }
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str3);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.f19194a.getResources().getColor(2131102263)), 0, str.length(), 33);
                    if (!TextUtils.isEmpty(c3)) {
                        FeedMethods.a(spannableStringBuilder, str3, "expression_emotion", FeedMethods.f(feedNotice.expression_id), 18, 18);
                    }
                    viewHolder.i.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
                }
            } else if (feedNotice.is_comment_type == 1) {
                viewHolder.i.setText(R.string.circle_comment_like);
            } else {
                viewHolder.i.setText(R.string.circle_like);
            }
        }
        if (TextUtils.isEmpty(feedNotice.timestamp)) {
            viewHolder.e.setText("");
        } else {
            viewHolder.e.setText(TimeAndDateUtils.a(this.f19194a, TimeAndDateUtils.c(feedNotice.timestamp)));
        }
        if (feedNotice.feed_pics != null && feedNotice.feed_pics.length > 0) {
            viewHolder.j.setVisibility(8);
            viewHolder.f19203c.setVisibility(0);
            viewHolder.d.setVisibility(8);
            ImageLoader.a(this.h, feedNotice.feed_pics[0]).b(2131231620).a(viewHolder.f19203c);
        } else if (!"1".equals(feedNotice.is_videos) || feedNotice.feed_videos == null || feedNotice.feed_videos.length <= 0) {
            viewHolder.j.setVisibility(0);
            viewHolder.f19203c.setVisibility(8);
            viewHolder.d.setVisibility(8);
            if (TextUtils.isEmpty(feedNotice.feed_content)) {
                viewHolder.j.setText("");
            } else {
                viewHolder.j.setText(((Object) StringUtils.a(feedNotice.feed_content, false, true, false, "")) + "");
            }
        } else {
            viewHolder.j.setVisibility(8);
            viewHolder.f19203c.setVisibility(0);
            viewHolder.d.setVisibility(0);
            ImageLoader.a(this.h, feedNotice.feed_videos[0]).b(2131231620).a(viewHolder.f19203c);
        }
        if (feedNotice.from == 1) {
            viewHolder.n.setText(R.string.from_circle);
        } else {
            viewHolder.n.setText(R.string.from_feed);
        }
        if (feedNotice.from_top == 1) {
            viewHolder.o.setText(R.string.circle_view);
        } else {
            viewHolder.o.setText(R.string.notice_reply);
        }
        viewHolder.m.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.notify.adapter.ViewPointNoticeAdapter.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Tracker.onClick(view2);
                feedNotice.has_read = 1;
                ViewPointNoticeAdapter.this.notifyDataSetChanged();
                if (feedNotice.from == 1) {
                    if (BluedConfig.a().K()) {
                        CirclePostDetailsFragment.a(ViewPointNoticeAdapter.this.f19194a, feedNotice.feed_id, FeedProtos.NoteSource.NOTICE_LIKE_ENTER);
                        return;
                    } else {
                        ToastUtils.a(ViewPointNoticeAdapter.this.f19194a.getString(2131887260));
                        return;
                    }
                }
                BluedIngSelfFeed bluedIngSelfFeed = new BluedIngSelfFeed();
                bluedIngSelfFeed.feed_id = feedNotice.feed_id;
                bluedIngSelfFeed.aid = feedNotice.aid;
                bluedIngSelfFeed.is_ads = feedNotice.is_ads;
                FeedDetailsFragment.a(ViewPointNoticeAdapter.this.f19194a, bluedIngSelfFeed, -1, new FeedDetailParams(0));
            }
        });
        view.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.notify.adapter.ViewPointNoticeAdapter.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Tracker.onClick(view2);
                feedNotice.has_read = 1;
                ViewPointNoticeAdapter.this.notifyDataSetChanged();
                viewHolder.m.callOnClick();
            }
        });
        viewHolder.o.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.notify.adapter.ViewPointNoticeAdapter.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Tracker.onClick(view2);
                feedNotice.has_read = 1;
                ViewPointNoticeAdapter.this.notifyDataSetChanged();
                if (feedNotice.from_top == 1) {
                    CirclePostDetailsFragment.a(ViewPointNoticeAdapter.this.f19194a, feedNotice.feed_id, FeedProtos.NoteSource.NOTICE_LIKE_ENTER);
                } else {
                    ReplyCommentFragment.a(ViewPointNoticeAdapter.this.f19194a, feedNotice);
                }
            }
        });
    }

    public void a(List<FeedNotice> list) {
        if (this.f19195c == null) {
            this.f19195c = new ArrayList();
        }
        this.f19195c.clear();
        if (list != null) {
            this.f19195c.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    /* renamed from: b */
    public FeedNotice getItem(int i) {
        return this.f19195c.get(i);
    }

    public void b() {
        List<FeedNotice> list = this.f19195c;
        if (list != null) {
            list.clear();
        }
        notifyDataSetChanged();
    }

    public void b(List<FeedNotice> list) {
        if (this.f19195c == null) {
            this.f19195c = new ArrayList();
        }
        if (list != null) {
            this.f19195c.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<FeedNotice> list = this.f19195c;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        View view2 = view;
        if (view != null) {
            if (view.getTag() instanceof ViewHolder) {
                viewHolder = (ViewHolder) view.getTag();
                view2 = view;
            } else {
                view2 = null;
                viewHolder = null;
            }
        }
        View view3 = view2;
        if (view2 == null) {
            viewHolder = new ViewHolder();
            view3 = this.b.inflate(R.layout.item_system_notice, viewGroup, false);
            viewHolder.f19202a = view3;
            viewHolder.b = (ImageView) viewHolder.f19202a.findViewById(2131364232);
            viewHolder.g = (TextView) viewHolder.f19202a.findViewById(R.id.news_view);
            viewHolder.f = (TextView) viewHolder.f19202a.findViewById(R.id.name_view);
            viewHolder.h = viewHolder.f19202a.findViewById(R.id.zan_view_layout);
            viewHolder.i = (TextView) viewHolder.f19202a.findViewById(R.id.zan_view);
            viewHolder.j = (TextView) viewHolder.f19202a.findViewById(2131363075);
            viewHolder.f19203c = (ImageView) viewHolder.f19202a.findViewById(R.id.photo_view);
            viewHolder.d = (ImageView) viewHolder.f19202a.findViewById(R.id.video_flag);
            viewHolder.e = (TextView) viewHolder.f19202a.findViewById(R.id.time_view);
            viewHolder.k = (ImageView) viewHolder.f19202a.findViewById(R.id.img_verify);
            viewHolder.l = (ImageView) viewHolder.f19202a.findViewById(R.id.iv_anonymous);
            viewHolder.m = viewHolder.f19202a.findViewById(2131367715);
            viewHolder.n = (TextView) viewHolder.f19202a.findViewById(R.id.tv_from_feed);
            viewHolder.o = (TextView) viewHolder.f19202a.findViewById(R.id.tv_feed_notice_reply);
            viewHolder.p = (ImageView) viewHolder.f19202a.findViewById(2131364726);
            view3.setTag(viewHolder);
        }
        FeedNotice feedNotice = this.f19195c.get(i);
        if (this.g) {
            viewHolder.o.setVisibility(0);
        } else {
            viewHolder.o.setVisibility(8);
        }
        if (feedNotice != null) {
            viewHolder.f19202a.setVisibility(8);
            a(viewHolder, feedNotice, view3, i);
            if (this.e == 1) {
                viewHolder.n.setVisibility(8);
                return view3;
            }
            viewHolder.n.setVisibility(0);
        }
        return view3;
    }
}
