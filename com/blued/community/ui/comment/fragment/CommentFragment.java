package com.blued.community.ui.comment.fragment;

import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Space;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.image.ImageWrapper;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.ui.custom.KeyboardListenLinearLayout;
import com.blued.android.framework.ui.custom.MvpKeyBoardFragment;
import com.blued.android.framework.ui.custom.SwitchPanelRelativeLayout;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.framework.utils.Logger;
import com.blued.android.framework.utils.RegExpUtils;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.login.model.UserBasicModel;
import com.blued.android.module.common.user.UserInfoHelper;
import com.blued.android.module.common.utils.AvatarUtils;
import com.blued.android.module.common.utils.DistanceUtils;
import com.blued.android.module.common.utils.ImageUtils;
import com.blued.android.module.common.utils.TimeAndDateUtils;
import com.blued.android.module.common.utils.click.SingleClickProxy;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.blued.android.module.common.widget.emoji.view.EmoticonsIndicatorView;
import com.blued.android.module.common.widget.emoticon.manager.EmotionManager;
import com.blued.android.module.common.widget.emoticon.model.EmoticonModel;
import com.blued.android.module.common.widget.emoticon.ui.EmoticonsPageView;
import com.blued.android.module.common.widget.emoticon.ui.EmoticonsToolBarView;
import com.blued.android.module.common.widget.emoticon.ui.Emotion;
import com.blued.android.module.common.widget.emoticon.ui.IViewStateListener;
import com.blued.android.module.common.widget.menu.ActionSheet;
import com.blued.android.module.common.widget.menu.CommonShowBottomWindow;
import com.blued.community.R;
import com.blued.community.auto.CommunityServiceManager;
import com.blued.community.manager.CommunityConstants;
import com.blued.community.model.BluedIngSelfFeed;
import com.blued.community.track.EventTrackFeed;
import com.blued.community.ui.circle.manager.CircleMethods;
import com.blued.community.ui.comment.adapter.CommentListAdapter;
import com.blued.community.ui.comment.model.FeedComment;
import com.blued.community.ui.comment.presenter.CommentPresenter;
import com.blued.community.ui.feed.manager.FeedMethods;
import com.blued.community.utils.AtChooseUserHelper;
import com.blued.community.utils.AtUserHelper;
import com.blued.community.utils.StringUtils;
import com.blued.community.utils.UserInfoUtils;
import com.blued.das.client.feed.FeedProtos;
import com.bytedance.applog.tracker.Tracker;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/comment/fragment/CommentFragment.class */
public class CommentFragment extends MvpKeyBoardFragment<CommentPresenter> implements View.OnClickListener {
    private EmoticonsToolBarView A;
    private SwitchPanelRelativeLayout B;
    private FrameLayout C;
    private CheckBox D;
    private HeaderViewHolder E;
    private BluedIngSelfFeed F;
    private CommentListAdapter G;
    private Context H;
    private AtChooseUserHelper I;
    private Emotion J;
    private TextWatcher K = new TextWatcher() { // from class: com.blued.community.ui.comment.fragment.CommentFragment.10
        private int b;
        private int c;
        private String d;
        private String e;

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            this.b = CommentFragment.this.q.getSelectionStart();
            this.c = CommentFragment.this.q.getSelectionEnd();
            CommentFragment.this.q.removeTextChangedListener(this);
            if (((CommentPresenter) CommentFragment.this.j()).C() && !CommentFragment.this.I.a(CommentFragment.this, this.d, this.e, editable, this.c)) {
                CommentFragment.this.q.setSelection(this.b);
            }
            CommentFragment.this.q.addTextChangedListener(this);
            CommentFragment.this.D();
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.d = ((Object) charSequence) + "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.e = ((Object) charSequence) + "";
        }
    };
    private KeyboardListenLinearLayout k;
    private View l;
    private CommonTopTitleNoTrans m;
    private ListView n;
    private View o;
    private SmartRefreshLayout p;
    private EditText q;
    private ShapeTextView r;
    private LinearLayout s;
    private LinearLayout t;
    private ImageView u;
    private Space v;
    private LinearLayout w;
    private View x;
    private EmoticonsPageView y;
    private EmoticonsIndicatorView z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/comment/fragment/CommentFragment$HeaderViewHolder.class */
    public class HeaderViewHolder {
        View a;
        ImageView b;
        TextView c;
        TextView d;
        TextView e;
        ImageView f;
        ImageView g;
        TextView h;
        ImageView i;
        ImageView j;
        NoDataAndLoadFailView k;
        LinearLayout l;
        ImageView m;
        TextView n;

        public HeaderViewHolder(View view) {
            this.a = view.findViewById(R.id.rl_comment);
            this.b = (ImageView) view.findViewById(R.id.header_view);
            this.c = (TextView) view.findViewById(R.id.time_view);
            this.d = (TextView) view.findViewById(R.id.name_view);
            this.e = (TextView) view.findViewById(R.id.content_view);
            this.f = (ImageView) view.findViewById(R.id.img_verify);
            this.g = (ImageView) view.findViewById(R.id.img_comment_like);
            this.h = (TextView) view.findViewById(R.id.tv_comment_like_count);
            this.i = (ImageView) view.findViewById(R.id.iv_level);
            this.j = (ImageView) view.findViewById(R.id.img_vip_icon);
            this.k = (NoDataAndLoadFailView) view.findViewById(R.id.no_data_view);
            this.l = (LinearLayout) view.findViewById(R.id.ll_img);
            this.m = (ImageView) view.findViewById(R.id.iv_anonymous);
            this.n = (TextView) view.findViewById(R.id.item_comment_ip_location_tv);
        }
    }

    private void A() {
        final View inflate = LayoutInflater.from(this.H).inflate(R.layout.layout_comment_header, (ViewGroup) null);
        HeaderViewHolder headerViewHolder = new HeaderViewHolder(inflate);
        this.E = headerViewHolder;
        headerViewHolder.b.setOnClickListener(this);
        this.E.d.setOnClickListener(this);
        this.E.g.setOnClickListener(this);
        this.E.h.setOnClickListener(this);
        inflate.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.blued.community.ui.comment.fragment.CommentFragment.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                KeyboardUtils.b(CommentFragment.this.H, inflate);
                CommentFragment.this.E();
                return true;
            }
        });
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.comment.fragment.CommentFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                ((CommentPresenter) CommentFragment.this.j()).w();
                CommentFragment.this.B();
            }
        });
        this.E.k.setBackgroundColorRes(R.color.syc_x);
        this.E.k.setNoDataImg(R.drawable.icon_no_data_comment);
        this.E.k.d();
        inflate.setBackgroundColor(BluedSkinUtils.a(this.H, R.color.syc_b));
        this.E.a.setVisibility(8);
        this.n.addHeaderView(inflate);
        this.n.setHeaderDividersEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B() {
        String string = this.H.getResources().getString(R.string.reply);
        EditText editText = this.q;
        editText.setHint(string + ((CommentPresenter) j()).v() + ":");
        this.q.requestFocus();
        KeyboardUtils.c(getActivity());
    }

    private void C() {
        a(this.B, this.k, this.q, this.w);
        this.I = new AtChooseUserHelper(this.H);
        this.J = new Emotion(this.H);
        ArrayList arrayList = new ArrayList();
        arrayList.add(EmotionManager.g());
        this.A.setModel(true);
        this.A.a(getFragmentActive(), arrayList);
        this.y.a(getFragmentActive(), arrayList);
        this.y.setOnIndicatorListener(new EmoticonsPageView.OnEmoticonsPageViewListener() { // from class: com.blued.community.ui.comment.fragment.CommentFragment.4
            @Override // com.blued.android.module.common.widget.emoticon.ui.EmoticonsPageView.OnEmoticonsPageViewListener
            public void a(int i) {
                CommentFragment.this.z.a(i);
            }

            @Override // com.blued.android.module.common.widget.emoticon.ui.EmoticonsPageView.OnEmoticonsPageViewListener
            public void a(int i, int i2) {
                CommentFragment.this.z.a(i, i2);
            }

            @Override // com.blued.android.module.common.widget.emoticon.ui.EmoticonsPageView.OnEmoticonsPageViewListener
            public void b(int i) {
                CommentFragment.this.z.setIndicatorCount(i);
            }

            @Override // com.blued.android.module.common.widget.emoticon.ui.EmoticonsPageView.OnEmoticonsPageViewListener
            public void c(int i) {
                CommentFragment.this.z.b(i);
            }
        });
        this.y.setIViewListener(new IViewStateListener() { // from class: com.blued.community.ui.comment.fragment.CommentFragment.5
            @Override // com.blued.android.module.common.widget.emoticon.ui.IViewStateListener
            public void a(int i) {
                CommentFragment.this.A.setToolBtnSelect(i);
            }

            @Override // com.blued.android.module.common.widget.emoticon.ui.IViewStateListener
            public void a(EmoticonModel emoticonModel) {
                if (CommentFragment.this.q != null) {
                    CommentFragment.this.q.setFocusable(true);
                    CommentFragment.this.q.setFocusableInTouchMode(true);
                    CommentFragment.this.q.requestFocus();
                    if (emoticonModel.eventType == 1) {
                        CommentFragment.this.q.onKeyDown(67, new KeyEvent(0, 67));
                    } else if (emoticonModel.eventType == 2) {
                    } else {
                        if (emoticonModel.emoji != null) {
                            CommentFragment.this.q.append(emoticonModel.emoji.a());
                            return;
                        }
                        CommentFragment.this.q.getText().insert(CommentFragment.this.q.getSelectionStart(), CommentFragment.this.J.a(emoticonModel.code));
                    }
                }
            }
        });
        this.A.setOnToolBarItemClickListener(new EmoticonsToolBarView.OnToolBarItemClickListener() { // from class: com.blued.community.ui.comment.fragment.CommentFragment.6
            @Override // com.blued.android.module.common.widget.emoticon.ui.EmoticonsToolBarView.OnToolBarItemClickListener
            public void a(int i) {
                CommentFragment.this.y.setPageSelect(i);
            }
        });
        this.q.setHint(FeedMethods.a(this.H));
        this.q.setFilters(new InputFilter[]{new InputFilter.LengthFilter(256)});
        this.q.addTextChangedListener(this.K);
        this.q.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.blued.community.ui.comment.fragment.CommentFragment.7
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                Tracker.onFocusChange(view, z);
                if (z) {
                    EventTrackFeed.a(FeedProtos.Event.FEED_COMMENT_BOX_CLICK, ((CommentPresenter) CommentFragment.this.j()).r(), FeedProtos.Location.COMMENT_DETAIL);
                }
            }
        });
        D();
        if (((CommentPresenter) j()).B()) {
            final String a = AvatarUtils.a(1, UserInfoUtils.e());
            ImageLoader.a(getFragmentActive(), a).b(R.drawable.user_bg_round).d(R.drawable.user_bg_round).c().a(this.u);
            this.D.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.blued.community.ui.comment.fragment.CommentFragment.8
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    Tracker.onCheckedChanged(compoundButton, z);
                    if (z) {
                        ImageLoader.a(CommentFragment.this.getFragmentActive(), ((CommentPresenter) CommentFragment.this.j()).m().anonym_avatar).b(CircleMethods.a(CommentFragment.this.getContext(), ((CommentPresenter) CommentFragment.this.j()).y())).d(CircleMethods.a(CommentFragment.this.getContext(), ((CommentPresenter) CommentFragment.this.j()).y())).a(CommentFragment.this.u);
                    } else {
                        ImageLoader.a(CommentFragment.this.getFragmentActive(), a).b(R.drawable.user_bg_round).d(R.drawable.user_bg_round).c().a(CommentFragment.this.u);
                    }
                }
            });
            this.C.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.comment.fragment.CommentFragment.9
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    if (CommentFragment.this.D.isEnabled()) {
                        return;
                    }
                    if (((CommentPresenter) CommentFragment.this.j()).m().anonym_comment == 1) {
                        AppMethods.d(R.string.circle_anonymous_same_identity);
                    } else {
                        AppMethods.d(R.string.circle_anonymous_not_anonymous_comment);
                    }
                }
            });
            v();
            this.D.setVisibility(0);
        } else {
            this.D.setVisibility(8);
        }
        this.u.setVisibility(8);
        this.v.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        if (TextUtils.isEmpty(this.q.getText())) {
            this.r.setAlpha(0.3f);
        } else {
            this.r.setAlpha(1.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E() {
        final FeedComment q = ((CommentPresenter) j()).q();
        if (q == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.H.getResources().getString(R.string.community_copy));
        if (!((CommentPresenter) j()).s()) {
            arrayList.add(this.H.getResources().getString(R.string.report));
        }
        CommonShowBottomWindow.a(this.H, (String[]) arrayList.toArray(new String[arrayList.size()]), new ActionSheet.ActionSheetListener() { // from class: com.blued.community.ui.comment.fragment.CommentFragment.11
            @Override // com.blued.android.module.common.widget.menu.ActionSheet.ActionSheetListener
            public void a(ActionSheet actionSheet, int i) {
                String a = actionSheet.a(i);
                if (a.equals(CommentFragment.this.H.getResources().getString(R.string.community_copy))) {
                    CommentFragment.this.c(q.comment_content);
                } else if (a.equals(CommentFragment.this.H.getResources().getString(R.string.report))) {
                    if (((CommentPresenter) CommentFragment.this.j()).B()) {
                        CommunityServiceManager.b().a(CommentFragment.this.H, CommunityConstants.ReportType.CIRCLE_COMMENT, q.user_name, q.feed_id, ((CommentPresenter) CommentFragment.this.j()).q().comment_id);
                    } else {
                        CommunityServiceManager.b().a(CommentFragment.this.H, CommunityConstants.ReportType.FEED_COMMENT, q.user_name, q.feed_id, ((CommentPresenter) CommentFragment.this.j()).q().comment_id);
                    }
                }
            }

            @Override // com.blued.android.module.common.widget.menu.ActionSheet.ActionSheetListener
            public void a(ActionSheet actionSheet, boolean z) {
            }
        });
    }

    private void F() {
        postDelaySafeRunOnUiThread(new Runnable() { // from class: com.blued.community.ui.comment.fragment.CommentFragment.14
            @Override // java.lang.Runnable
            public void run() {
                if (!CommentFragment.this.q.isFocusable()) {
                    CommentFragment.this.q.requestFocus();
                }
                KeyboardUtils.c(CommentFragment.this.getActivity());
            }
        }, 300L);
    }

    private void G() {
        if (((CommentPresenter) j()).B()) {
            Intent intent = new Intent();
            intent.putExtra("comment_state", ((CommentPresenter) j()).x());
            getActivity().setResult(-1, intent);
        }
        getActivity().finish();
    }

    public static void a(Context context, String str, FeedComment feedComment, BluedIngSelfFeed bluedIngSelfFeed, String str2, int i) {
        Bundle bundle = new Bundle();
        bundle.putString("title", str);
        bundle.putString("feed_id", feedComment.feed_id);
        bundle.putString("comment_id", feedComment.comment_id);
        bundle.putSerializable("feed_data", bluedIngSelfFeed);
        bundle.putInt("from", i);
        TerminalActivity.a(bundle);
        TerminalActivity.d(context, CommentFragment.class, bundle);
    }

    public static void a(Context context, String str, FeedComment feedComment, BluedIngSelfFeed bluedIngSelfFeed, String str2, int i, int i2, int i3) {
        Bundle bundle = new Bundle();
        bundle.putString("title", str);
        bundle.putString("feed_id", feedComment.feed_id);
        bundle.putString("comment_id", feedComment.comment_id);
        bundle.putString("circle_id", bluedIngSelfFeed.circle_id);
        bundle.putSerializable("feed_data", bluedIngSelfFeed);
        bundle.putInt("from", i2);
        bundle.putInt("anonymous_header_number", i);
        bundle.putBoolean("can_at", !bluedIngSelfFeed.isPrivateCircle());
        TerminalActivity.a(bundle);
        TerminalActivity.a(context, CommentFragment.class, bundle, i3);
    }

    private void b(boolean z) {
        this.p.g();
        this.p.h();
        c(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        E();
    }

    private void c(final FeedComment feedComment) {
        this.E.a.setVisibility(0);
        UserInfoHelper.a(this.E.f, feedComment.vbadge, 3);
        ImageWrapper c = ImageLoader.a(getFragmentActive(), feedComment.user_avatar).b(R.drawable.user_bg_round).c();
        if (feedComment.is_comment_anonym == 1) {
            c.d();
        }
        c.a(this.E.b);
        if (TextUtils.isEmpty(feedComment.comment_timestamp)) {
            this.E.c.setText("");
        } else {
            this.E.c.setText(TimeAndDateUtils.h(this.H, TimeAndDateUtils.c(feedComment.comment_timestamp)));
        }
        if (TextUtils.isEmpty(feedComment.user_name)) {
            this.E.d.setText("");
        } else if (TextUtils.isEmpty(feedComment.note)) {
            this.E.d.setText(feedComment.user_name.replace(":", ""));
        } else {
            this.E.d.setText(StringUtils.a(feedComment.note, feedComment.user_name.replace(":", "")));
        }
        FeedMethods.a(this.E.d, feedComment.comment_uid, feedComment.is_comment_anonym == 1);
        UserBasicModel userBasicModel = new UserBasicModel();
        userBasicModel.vip_grade = feedComment.vip_grade;
        userBasicModel.is_vip_annual = feedComment.is_vip_annual;
        userBasicModel.is_hide_vip_look = feedComment.is_hide_vip_look;
        userBasicModel.vip_exp_lvl = feedComment.vip_exp_lvl;
        UserInfoHelper.a(this.H, this.E.d, userBasicModel);
        UserInfoHelper.a(this.E.j, userBasicModel);
        if (((CommentPresenter) j()).A()) {
            FeedMethods.a(this.E.i, feedComment.is_author);
        } else {
            CircleMethods.a(this.E.i, feedComment.admin_level, feedComment.is_author);
        }
        if (TextUtils.isEmpty(feedComment.ip_location)) {
            this.E.n.setVisibility(8);
        } else {
            this.E.n.setText(String.format(this.H.getString(R.string.feed_comment_ip_location), feedComment.ip_location));
            this.E.n.setVisibility(0);
        }
        if (TextUtils.isEmpty(feedComment.is_reply)) {
            this.E.e.setText("");
        } else if ("1".equals(feedComment.is_reply)) {
            FeedMethods.a(this.H, this.E.e, feedComment, ((CommentPresenter) j()).p(), R.color.syc_a);
        } else if ("0".equals(feedComment.is_reply)) {
            FeedMethods.a(this.E.e, feedComment, ((CommentPresenter) j()).p());
        } else {
            this.E.e.setText("");
        }
        if (feedComment.comment_pics == null || feedComment.comment_pics.length <= 0) {
            this.E.l.setVisibility(8);
            return;
        }
        this.E.l.setVisibility(0);
        int i = this.H.getResources().getDisplayMetrics().widthPixels;
        final LoadOptions loadOptions = new LoadOptions();
        loadOptions.d = R.drawable.defaultpicture;
        loadOptions.b = R.drawable.defaultpicture;
        int i2 = i >> 1;
        loadOptions.a(i2, i2);
        int a = AppInfo.l - DensityUtils.a(AppInfo.d(), 74.0f);
        double d = a;
        int i3 = (int) (d * 1.5d);
        int i4 = (int) (d * 0.73d);
        try {
            this.E.l.removeAllViews();
            int i5 = 0;
            while (true) {
                final int i6 = i5;
                if (i6 >= feedComment.comment_pics.length) {
                    return;
                }
                int[] a2 = ImageUtils.a(Integer.valueOf(feedComment.comment_pics_width[i6]).intValue(), Integer.valueOf(feedComment.comment_pics_height[i6]).intValue(), a, i3, a, i4);
                View inflate = LayoutInflater.from(this.H).inflate(R.layout.item_comment_pics, (ViewGroup) null);
                ImageView imageView = (ImageView) inflate.findViewById(R.id.circle_image);
                ShapeTextView shapeTextView = (ShapeTextView) inflate.findViewById(R.id.circle_big_icon);
                if (feedComment.comment_pics_height == null || feedComment.comment_pics_height.length <= i6) {
                    shapeTextView.setVisibility(8);
                } else if (StringUtils.b(feedComment.comment_pics_height[i6]) > AppInfo.m * 1.5d) {
                    shapeTextView.setVisibility(0);
                } else {
                    shapeTextView.setVisibility(8);
                }
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(a2[0], a2[1]);
                if (i6 != feedComment.comment_pics.length - 1) {
                    layoutParams.bottomMargin = DensityUtils.a(this.H, 10.0f);
                }
                imageView.setLayoutParams(layoutParams);
                ImageLoader.a(getFragmentActive(), AvatarUtils.a(feedComment.comment_pics[i6], a2[i6])).a(6.0f).a(imageView);
                this.E.l.addView(inflate);
                imageView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.comment.fragment.CommentFragment.12
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Tracker.onClick(view);
                        FeedProtos.Event event = FeedProtos.Event.CIRCLE_NOTE_COMMENT_IMAGE_CLICK;
                        String str = feedComment.comment_id;
                        FeedProtos.NoteSource noteSource = FeedProtos.NoteSource.NOTE_DETAIL;
                        String str2 = feedComment.feed_id;
                        String n = ((CommentPresenter) CommentFragment.this.j()).n();
                        boolean a3 = AtUserHelper.a(feedComment.comment_content);
                        FeedProtos.NoteType c2 = EventTrackFeed.c(((CommentPresenter) CommentFragment.this.j()).m());
                        boolean z = false;
                        boolean z2 = ((CommentPresenter) CommentFragment.this.j()).m().is_anonym == 1;
                        if (feedComment.is_anonym == 1) {
                            z = true;
                        }
                        EventTrackFeed.a(event, str, noteSource, str2, n, a3, c2, z2, z);
                        CommunityServiceManager.b().a(CommentFragment.this.H, feedComment.comment_pics, i6, 0, loadOptions, feedComment.user_name, CommentFragment.this.E.a, feedComment.comment_pics[i6]);
                    }
                });
                i5 = i6 + 1;
            }
        } catch (Throwable th) {
            Logger.e("图片越界", new Object[0]);
        }
    }

    private void c(boolean z) {
        if (this.G.getCount() > 0) {
            this.E.k.d();
        } else if (z) {
            this.E.k.a();
        } else {
            this.E.k.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(View view) {
        G();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(FeedComment feedComment) {
        ((CommentPresenter) j()).d(feedComment.comment_id);
        ((CommentPresenter) j()).e(feedComment.user_name);
        B();
    }

    private void x() {
        this.k = (KeyboardListenLinearLayout) this.i.findViewById(R.id.keyboard_layout);
        this.l = this.i.findViewById(R.id.top_bar);
        this.m = (CommonTopTitleNoTrans) this.i.findViewById(R.id.top_title);
        this.n = (ListView) this.i.findViewById(R.id.list_view);
        this.o = this.i.findViewById(R.id.keyboard_view);
        this.p = this.i.findViewById(R.id.refresh_layout);
        this.q = (EditText) this.i.findViewById(R.id.edit_view);
        ShapeTextView shapeTextView = (ShapeTextView) this.i.findViewById(R.id.send_btn);
        this.r = shapeTextView;
        shapeTextView.setOnClickListener(new SingleClickProxy(this));
        View findViewById = this.i.findViewById(R.id.icon_emoji);
        this.x = findViewById;
        findViewById.setOnClickListener(this);
        this.s = (LinearLayout) this.i.findViewById(R.id.layout_comment_all);
        this.t = (LinearLayout) this.i.findViewById(R.id.layout_album);
        this.u = (ImageView) this.i.findViewById(R.id.iv_comment_header);
        this.v = (Space) this.i.findViewById(R.id.space_with_header);
        this.w = (LinearLayout) this.i.findViewById(R.id.emoticon_layout);
        this.y = (EmoticonsPageView) this.i.findViewById(R.id.view_epv);
        this.z = (EmoticonsIndicatorView) this.i.findViewById(R.id.view_eiv);
        this.A = (EmoticonsToolBarView) this.i.findViewById(R.id.view_etv);
        this.B = (SwitchPanelRelativeLayout) this.i.findViewById(R.id.emoticon_layout_root);
        this.C = (FrameLayout) this.i.findViewById(R.id.fl_anonymous_comment);
        this.D = (CheckBox) this.i.findViewById(R.id.cb_anonymous_comment);
    }

    private void y() {
        ViewGroup.LayoutParams layoutParams = this.l.getLayoutParams();
        layoutParams.height = StatusBarHelper.a(getContext());
        this.l.setLayoutParams(layoutParams);
        this.m.setLeftClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.comment.fragment.-$$Lambda$CommentFragment$RjVg_AETGCB9LL1jmLh_Z4j9BVc
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CommentFragment.this.d(view);
            }
        });
        this.m.setCenterText(((CommentPresenter) j()).o());
        this.m.setCenterTextColor(R.color.syc_h);
        this.m.setRightImg(R.drawable.icon_title_more);
        this.m.setRightClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.comment.fragment.-$$Lambda$CommentFragment$kwL7UrMdsOlTSLi6YkvAnkkXXf0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CommentFragment.this.c(view);
            }
        });
    }

    private void z() {
        this.p.setBackgroundColor(BluedSkinUtils.a(this.H, R.color.syc_b));
        this.n.setBackgroundColor(BluedSkinUtils.a(this.H, R.color.syc_x));
        CommentListAdapter commentListAdapter = new CommentListAdapter(this.H, getFragmentActive(), this.F, new CommentListAdapter.FeedCommentListner() { // from class: com.blued.community.ui.comment.fragment.-$$Lambda$CommentFragment$8XzNDmagOiF1zbCE163iNESlNuc
            @Override // com.blued.community.ui.comment.adapter.CommentListAdapter.FeedCommentListner
            public final void contentClick(FeedComment feedComment) {
                CommentFragment.this.d(feedComment);
            }
        }, ((CommentPresenter) j()).p(), ((CommentPresenter) j()).n());
        this.G = commentListAdapter;
        commentListAdapter.a(((CommentPresenter) j()).z());
        this.n.setAdapter((ListAdapter) this.G);
        this.p.a(new OnRefreshLoadMoreListener() { // from class: com.blued.community.ui.comment.fragment.CommentFragment.1
            public void onLoadMore(RefreshLayout refreshLayout) {
                ((CommentPresenter) CommentFragment.this.j()).f();
            }

            public void onRefresh(RefreshLayout refreshLayout) {
                ((CommentPresenter) CommentFragment.this.j()).e();
            }
        });
    }

    @Override // com.blued.android.framework.ui.custom.MvpKeyBoardFragment
    public void a(int i) {
        if (i == -4 || i == -3) {
            this.t.setVisibility(0);
            if (((CommentPresenter) j()).B()) {
                this.u.setVisibility(0);
                this.v.setVisibility(0);
            }
            ViewGroup.LayoutParams layoutParams = this.s.getLayoutParams();
            layoutParams.height = DensityUtils.a(getContext(), 100.0f);
            this.s.setLayoutParams(layoutParams);
            this.o.setVisibility(0);
            this.o.setOnTouchListener(new View.OnTouchListener() { // from class: com.blued.community.ui.comment.fragment.CommentFragment.13
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    CommentFragment.this.w();
                    return true;
                }
            });
            this.q.setFocusable(true);
            this.q.setFocusableInTouchMode(true);
            this.q.requestFocus();
        } else if (i != -2) {
        } else {
            if (this.B.getVisibility() == 0) {
                if (this.q.isFocusable()) {
                    return;
                }
                this.o.setVisibility(8);
                return;
            }
            this.t.setVisibility(0);
            if (((CommentPresenter) j()).B()) {
                this.u.setVisibility(0);
                this.v.setVisibility(0);
            }
            ViewGroup.LayoutParams layoutParams2 = this.s.getLayoutParams();
            layoutParams2.height = DensityUtils.a(getContext(), 100.0f);
            this.s.setLayoutParams(layoutParams2);
        }
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public void a(Bundle bundle) {
        super.a(bundle);
        this.F = (BluedIngSelfFeed) getArguments().getSerializable("feed_data");
        this.H = getActivity();
        x();
        y();
        z();
        A();
        C();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(FeedComment feedComment) {
        c(feedComment);
        b(feedComment);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void a(String str, boolean z) {
        super.a(str, z);
        if (str == null) {
            return;
        }
        boolean z2 = true;
        int hashCode = str.hashCode();
        if (hashCode != -1290256561) {
            if (hashCode == 623698297 && str.equals("_load_type_loadmore_")) {
                z2 = true;
            }
        } else if (str.equals("_load_type_refresh_")) {
            z2 = false;
        }
        if (!z2 || z2) {
            b(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(List<FeedComment> list) {
        this.G.a(list);
    }

    @Override // com.blued.android.framework.ui.custom.MvpKeyBoardFragment, com.blued.android.framework.ui.mvp.MvpFragment
    public void af_() {
        super.af_();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(FeedComment feedComment) {
        if (feedComment.iliked == 1) {
            this.E.g.setImageResource(R.drawable.icon_comment_liked);
            this.E.h.setTextColor(this.H.getResources().getColor(R.color.syc_a));
        } else {
            this.E.g.setImageResource(R.drawable.icon_comment_like);
            this.E.h.setTextColor(this.H.getResources().getColor(R.color.syc_i));
        }
        if (feedComment.liked_count > 0) {
            TextView textView = this.E.h;
            Context context = this.H;
            textView.setText(DistanceUtils.a(context, feedComment.liked_count + ""));
            this.E.h.setVisibility(0);
        } else {
            this.E.h.setVisibility(8);
        }
        this.G.a(feedComment.comment_id, feedComment.iliked);
    }

    public void c(String str) {
        if (Build.VERSION.SDK_INT < 11 || Build.VERSION.SDK_INT == 18) {
            ((ClipboardManager) this.H.getSystemService("clipboard")).setText(RegExpUtils.a(str));
        } else {
            try {
                ((android.content.ClipboardManager) this.H.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("simple text", RegExpUtils.a(str)));
            } catch (Exception e) {
            }
        }
        AppMethods.a((CharSequence) this.H.getResources().getString(R.string.copy));
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public void f() {
        super.f();
        getActivity().getWindow().setSoftInputMode(16);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public int g() {
        return R.layout.fragment_comment;
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void g_(String str) {
        super.g_(str);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void o() {
        super.o();
        this.p.b(true);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            if (i == 9090) {
                this.I.a(this.q, intent, this.K);
                F();
            }
        } else if (i == 9090) {
            F();
        }
        super.onActivityResult(i, i2, intent);
    }

    @Override // com.blued.android.core.ui.BaseFragment, com.blued.android.core.ui.BaseFragmentActivity.IOnBackPressedListener
    public boolean onBackPressed() {
        if (this.B.getVisibility() == 0) {
            w();
            return true;
        }
        G();
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        int id = view.getId();
        if (id == R.id.header_view || id == R.id.name_view) {
            if (((CommentPresenter) j()).q().is_comment_anonym == 1) {
                return;
            }
            if (((CommentPresenter) j()).q().is_anonym == 1) {
                AppMethods.d(R.string.circle_anonymous_not_to_user_info);
            } else if (((CommentPresenter) j()).t() != null) {
                CommunityServiceManager.b().a(this.H, ((CommentPresenter) j()).t(), ((CommentPresenter) j()).p(), this.E.b);
            }
        } else if (id == R.id.img_comment_like || id == R.id.tv_comment_like_count) {
            EventTrackFeed.a(FeedProtos.Event.FEED_INTERACTIVE, ((CommentPresenter) j()).r(), ((CommentPresenter) j()).q().iliked == 1 ? FeedProtos.InteractiveType.NO_LIKE : FeedProtos.InteractiveType.LIKE, FeedProtos.Location.COMMENT_DETAIL, ((CommentPresenter) j()).q().comment_id, ((CommentPresenter) j()).q().feed_uid);
            ((CommentPresenter) j()).u();
        } else if (id == R.id.icon_emoji) {
            e();
        } else if (id == R.id.send_btn) {
            String obj = this.q.getText().toString();
            if (TextUtils.isEmpty(obj.trim())) {
                AppMethods.d(R.string.feed_null);
                return;
            }
            EventTrackFeed.a(FeedProtos.Event.FEED_INTERACTIVE, ((CommentPresenter) j()).r(), FeedProtos.InteractiveType.COMMENT, FeedProtos.Location.COMMENT_DETAIL, ((CommentPresenter) j()).q().comment_id, ((CommentPresenter) j()).q().feed_uid);
            String b = this.I.b(obj);
            this.r.setClickable(false);
            ((CommentPresenter) j()).c(b, this.D.isChecked());
        }
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void p() {
        super.p();
        this.p.b(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void v() {
        int x = ((CommentPresenter) j()).x();
        if (x == 0) {
            this.D.setEnabled(true);
            this.D.setClickable(true);
            this.D.setTextColor(BluedSkinUtils.a(getContext(), R.color.syc_h));
        } else if (x == 1) {
            this.D.setEnabled(false);
            this.D.setClickable(false);
            this.D.setTextColor(BluedSkinUtils.a(getContext(), R.color.syc_i));
            this.D.setChecked(true);
        } else if (x != 2) {
        } else {
            this.D.setEnabled(false);
            this.D.setClickable(false);
            this.D.setTextColor(BluedSkinUtils.a(getContext(), R.color.syc_i));
            this.D.setChecked(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void w() {
        this.t.setVisibility(8);
        this.u.setVisibility(8);
        this.v.setVisibility(8);
        ViewGroup.LayoutParams layoutParams = this.s.getLayoutParams();
        layoutParams.height = DensityUtils.a(getContext(), 50.0f);
        this.s.setLayoutParams(layoutParams);
        this.r.setClickable(true);
        this.B.setVisibility(8);
        this.o.setVisibility(8);
        KeyboardUtils.a((Activity) getActivity());
        this.q.setText((CharSequence) null);
        this.q.setHint(FeedMethods.a(this.H));
        this.q.clearFocus();
        this.n.setSelection(0);
        ((CommentPresenter) j()).w();
        c(true);
    }
}
