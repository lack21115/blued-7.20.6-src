package com.blued.community.ui.circle.fragment;

import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.anythink.expressad.foundation.h.i;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageFileLoader;
import com.blued.android.core.image.ImageLoadResult;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.custom.KeyboardListenLinearLayout;
import com.blued.android.framework.ui.custom.MvpKeyBoardFragment;
import com.blued.android.framework.ui.custom.SwitchPanelRelativeLayout;
import com.blued.android.framework.ui.markdown.MarkdownView;
import com.blued.android.framework.ui.markdown.atuser.OnClickAtUserListener;
import com.blued.android.framework.ui.markdown.image.OnClickImageListener;
import com.blued.android.framework.ui.markdown.link.OnClickLinkListener;
import com.blued.android.framework.ui.xpop.XPopup;
import com.blued.android.framework.ui.xpop.core.BasePopupView;
import com.blued.android.framework.ui.xpop.enums.PopupAnimation;
import com.blued.android.framework.utils.AppUtils;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.framework.utils.Logger;
import com.blued.android.framework.utils.RegExpUtils;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeRelativeLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.log.oldtrack.LogData;
import com.blued.android.module.common.login.model.UserBasicModel;
import com.blued.android.module.common.user.UserInfoHelper;
import com.blued.android.module.common.utils.AvatarUtils;
import com.blued.android.module.common.utils.DistanceUtils;
import com.blued.android.module.common.utils.TimeAndDateUtils;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.android.module.common.utils.click.SingleClickProxy;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.blued.android.module.common.widget.emoji.view.EmoticonsIndicatorView;
import com.blued.android.module.common.widget.emoticon.manager.EmotionManager;
import com.blued.android.module.common.widget.emoticon.model.EmoticonModel;
import com.blued.android.module.common.widget.emoticon.ui.EmoticonsPageView;
import com.blued.android.module.common.widget.emoticon.ui.EmoticonsToolBarView;
import com.blued.android.module.common.widget.emoticon.ui.Emotion;
import com.blued.android.module.common.widget.emoticon.ui.IViewStateListener;
import com.blued.android.module.common.widget.pop.BluedPopupWindow;
import com.blued.android.module.player.media.model.VideoPlayConfig;
import com.blued.android.module.player.media.view.PLVideoPageView;
import com.blued.community.R;
import com.blued.community.auto.CommunityServiceManager;
import com.blued.community.auto.ICommunityShowPageService;
import com.blued.community.http.FeedHttpUtils;
import com.blued.community.manager.ChildPhotoManager;
import com.blued.community.model.BluedIngSelfFeed;
import com.blued.community.track.EventTrackFeed;
import com.blued.community.ui.circle.dialog.CircleViewDialog;
import com.blued.community.ui.circle.manager.CircleConstants;
import com.blued.community.ui.circle.manager.CircleMethods;
import com.blued.community.ui.circle.pop.CircleMainMenuPop;
import com.blued.community.ui.circle.presenter.CirclePostDetailsPresenter;
import com.blued.community.ui.circle.view.CircleJoinView;
import com.blued.community.ui.comment.adapter.CircleMainDetailCommentAdapter;
import com.blued.community.ui.comment.fragment.CircleCommentFragment;
import com.blued.community.ui.comment.fragment.CommentFragment;
import com.blued.community.ui.comment.model.FeedComment;
import com.blued.community.ui.feed.manager.FeedMethods;
import com.blued.community.ui.feed.model.CircleListToDetailParams;
import com.blued.community.ui.send.manager.SelectPhotoManager;
import com.blued.community.ui.send.observer.FeedRefreshObserver;
import com.blued.community.utils.AtChooseUserHelper;
import com.blued.community.utils.CommunityPreferences;
import com.blued.community.utils.CommunityShareUtils;
import com.blued.community.utils.StringUtils;
import com.blued.community.utils.UserInfoUtils;
import com.blued.community.utils.ViewUtils;
import com.blued.community.widget.vote.text.model.CircleTextVote;
import com.blued.community.widget.vote.text.view.CircleTextVoteView;
import com.blued.das.client.feed.FeedProtos;
import com.blued.das.message.MessageProtos;
import com.bytedance.applog.tracker.Tracker;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/circle/fragment/CirclePostDetailsFragment.class */
public class CirclePostDetailsFragment extends MvpKeyBoardFragment<CirclePostDetailsPresenter> implements View.OnClickListener, FeedRefreshObserver.IFeedRefreshObserver {
    private static final Pattern ag = Pattern.compile("\n *\n");
    private static final Pattern ah = Pattern.compile("([^ \n]) *(\\!\\[[^\\]]*\\]\\([^\\)]*)");
    private ImageView A;
    private TextView B;
    private TextView C;
    private View D;
    private LinearLayout E;
    private ImageView F;
    private FrameLayout G;
    private CheckBox H;
    private ImageView I;
    private LinearLayout J;
    private EmoticonsPageView K;
    private EmoticonsIndicatorView L;
    private EmoticonsToolBarView M;
    private SwitchPanelRelativeLayout N;
    private View O;
    private ImageView P;
    private TextView Q;
    private RelativeLayout R;
    private View S;
    private View T;
    private View U;
    private View V;
    private CircleMainDetailCommentAdapter X;
    private NoDataAndLoadFailView Y;
    private HeaderHolder Z;
    private AtChooseUserHelper aa;
    private Emotion ab;
    private FeedComment ac;
    private int ad;
    private CircleListToDetailParams ae;
    private View af;
    private BasePopupView ai;
    MarkdownView.Builder k;
    private ConstraintLayout m;
    private SmartRefreshLayout n;
    private TextView o;
    private ImageView p;
    private CircleJoinView q;
    private RecyclerView r;
    private KeyboardListenLinearLayout s;
    private View t;
    private View u;
    private LinearLayout v;
    private EditText w;
    private ShapeTextView x;
    private ShapeRelativeLayout y;
    private ImageView z;
    private String W = "";
    View.OnAttachStateChangeListener l = new View.OnAttachStateChangeListener() { // from class: com.blued.community.ui.circle.fragment.CirclePostDetailsFragment.1
        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            String str;
            LogUtils.d("Markdown", "onViewAttachedToWindow ");
            LogUtils.d("Markdown", "markdownContent = " + CirclePostDetailsFragment.this.W);
            CirclePostDetailsFragment.this.Z.h.setTextColor(BluedSkinUtils.a(CirclePostDetailsFragment.this.getContext(), R.color.syc_h));
            MarkdownView markdownView = CirclePostDetailsFragment.this.Z.h;
            MarkdownView.Builder builder = CirclePostDetailsFragment.this.k;
            if (((CirclePostDetailsPresenter) CirclePostDetailsFragment.this.j()).n().is_essence == 1) {
                str = "精" + CirclePostDetailsFragment.this.W;
            } else {
                str = CirclePostDetailsFragment.this.W;
            }
            markdownView.a(builder, str);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    };
    private TextWatcher aj = new TextWatcher() { // from class: com.blued.community.ui.circle.fragment.CirclePostDetailsFragment.33
        private int b;

        /* renamed from: c  reason: collision with root package name */
        private int f19281c;
        private String d;
        private String e;

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            this.b = CirclePostDetailsFragment.this.w.getSelectionStart();
            this.f19281c = CirclePostDetailsFragment.this.w.getSelectionEnd();
            CirclePostDetailsFragment.this.w.removeTextChangedListener(this);
            if (!((CirclePostDetailsPresenter) CirclePostDetailsFragment.this.j()).n().isPrivateCircle() && !CirclePostDetailsFragment.this.aa.a(CirclePostDetailsFragment.this, this.d, this.e, editable, this.f19281c)) {
                CirclePostDetailsFragment.this.w.setSelection(this.b);
            }
            CirclePostDetailsFragment.this.w.addTextChangedListener(this);
            if (CommunityServiceManager.a().C()) {
                ToastUtils.b(R.string.account_invalid_to_send_feed_comment);
            }
            CirclePostDetailsFragment.this.F();
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.blued.community.ui.circle.fragment.CirclePostDetailsFragment$19  reason: invalid class name */
    /* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/circle/fragment/CirclePostDetailsFragment$19.class */
    public class AnonymousClass19 extends ImageLoadResult {
        AnonymousClass19(IRequestHost iRequestHost) {
            super(iRequestHost);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d() {
            if (CirclePostDetailsFragment.this.m == null || CirclePostDetailsFragment.this.getContext() == null) {
                return;
            }
            CirclePostDetailsFragment.this.m.setBackgroundColor(CirclePostDetailsFragment.this.getContext().getResources().getColor(R.color.syc_dark_circle_top_bg));
        }

        @Override // com.blued.android.core.image.ImageLoadResult
        public void a() {
            ImageFileLoader.a(CirclePostDetailsFragment.this.getFragmentActive()).b(AvatarUtils.a(((CirclePostDetailsPresenter) CirclePostDetailsFragment.this.j()).n().cover)).a(new ImageFileLoader.OnLoadFileListener() { // from class: com.blued.community.ui.circle.fragment.CirclePostDetailsFragment.19.1
                /* JADX WARN: Removed duplicated region for block: B:10:0x001c  */
                /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
                @Override // com.blued.android.core.image.ImageFileLoader.OnLoadFileListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public void onUIFinish(java.io.File r6, java.lang.Exception r7) {
                    /*
                        r5 = this;
                        r0 = r6
                        if (r0 == 0) goto L16
                        r0 = r6
                        boolean r0 = r0.exists()
                        if (r0 == 0) goto L16
                        r0 = r6
                        java.lang.String r0 = r0.getPath()     // Catch: java.lang.OutOfMemoryError -> L35
                        android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeFile(r0)     // Catch: java.lang.OutOfMemoryError -> L35
                        r6 = r0
                        goto L18
                    L16:
                        r0 = 0
                        r6 = r0
                    L18:
                        r0 = r6
                        if (r0 == 0) goto L2d
                        r0 = r6
                        androidx.palette.graphics.Palette$Builder r0 = androidx.palette.graphics.Palette.from(r0)
                        com.blued.community.ui.circle.fragment.CirclePostDetailsFragment$19$1$1 r1 = new com.blued.community.ui.circle.fragment.CirclePostDetailsFragment$19$1$1
                        r2 = r1
                        r3 = r5
                        r2.<init>()
                        android.os.AsyncTask r0 = r0.generate(r1)
                        return
                    L2d:
                        r0 = r5
                        com.blued.community.ui.circle.fragment.CirclePostDetailsFragment$19 r0 = com.blued.community.ui.circle.fragment.CirclePostDetailsFragment.AnonymousClass19.this
                        com.blued.community.ui.circle.fragment.CirclePostDetailsFragment.AnonymousClass19.a(r0)
                        return
                    L35:
                        r6 = move-exception
                        goto L16
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.blued.community.ui.circle.fragment.CirclePostDetailsFragment.AnonymousClass19.AnonymousClass1.onUIFinish(java.io.File, java.lang.Exception):void");
                }
            }).a();
        }

        @Override // com.blued.android.core.image.ImageLoadResult
        public void a(int i, Exception exc) {
            super.a(i, exc);
            d();
        }
    }

    /* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/circle/fragment/CirclePostDetailsFragment$HeaderHolder.class */
    public static class HeaderHolder {

        /* renamed from: a  reason: collision with root package name */
        ImageView f19290a;
        ImageView b;

        /* renamed from: c  reason: collision with root package name */
        ImageView f19291c;
        ImageView d;
        ImageView e;
        TextView f;
        TextView g;
        MarkdownView h;
        PLVideoPageView i;
        CardView j;
        CircleTextVoteView k;
        LinearLayout l;
        ImageView m;
        TextView n;
        TextView o;
        TextView p;
        RelativeLayout q;
        LinearLayout r;

        public HeaderHolder(View view) {
            this.d = (ImageView) view.findViewById(R.id.header_view);
            this.e = (ImageView) view.findViewById(R.id.img_verify);
            this.f = (TextView) view.findViewById(R.id.tv_name);
            this.f19290a = (ImageView) view.findViewById(R.id.iv_level);
            this.b = (ImageView) view.findViewById(R.id.iv_anonymous);
            this.f19291c = (ImageView) view.findViewById(R.id.img_blued_medal);
            this.g = (TextView) view.findViewById(R.id.tv_time);
            this.q = (RelativeLayout) view.findViewById(R.id.rl_content);
            this.h = (MarkdownView) view.findViewById(R.id.markdown_view);
            this.j = (CardView) view.findViewById(R.id.card_video);
            this.i = (PLVideoPageView) view.findViewById(R.id.video_view);
            this.k = (CircleTextVoteView) view.findViewById(R.id.circle_text_vote);
            this.l = (LinearLayout) view.findViewById(R.id.lay_circle_card);
            this.m = (ImageView) view.findViewById(R.id.iv_circle_header);
            this.n = (TextView) view.findViewById(R.id.tv_circle_name);
            this.o = (TextView) view.findViewById(R.id.tv_circle_num);
            this.p = (TextView) view.findViewById(R.id.tv_comment_cnt);
            this.r = (LinearLayout) view.findViewById(R.id.ll_refresh);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
        if (!((CirclePostDetailsPresenter) j()).n().isNotMember()) {
            this.ac = null;
            this.w.setText((CharSequence) null);
            this.w.setHint(FeedMethods.a(getContext()));
            KeyboardUtils.c(getActivity());
            this.w.requestFocus();
            return;
        }
        int i = ((CirclePostDetailsPresenter) j()).n().is_applied;
        if (i == 0) {
            CommonAlertDialog.a(getContext(), "", getString(R.string.circle_post_not_member_hint), getString(R.string.circle_post_detail_join), new DialogInterface.OnClickListener() { // from class: com.blued.community.ui.circle.fragment.CirclePostDetailsFragment.23
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    Tracker.onClick(dialogInterface, i2);
                    ((CirclePostDetailsPresenter) CirclePostDetailsFragment.this.j()).a(CirclePostDetailsFragment.this.getFragmentManager());
                }
            }, getString(R.string.circle_post_cancel_post), (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
        } else if (i == 1) {
            AppMethods.d(R.string.circle_comment_apply_tip);
        } else if (i != 2) {
            AppMethods.d(R.string.circle_apply_join_first);
        } else {
            AppMethods.d(R.string.circle_comment_denied_tip);
        }
    }

    private void B() {
        if (CommunityServiceManager.a().C()) {
            ToastUtils.b(R.string.account_invalid_to_send_feed_comment);
            return;
        }
        String obj = this.w.getText().toString();
        if (TextUtils.isEmpty(obj.trim())) {
            AppMethods.d(R.string.feed_null);
            return;
        }
        final String b = this.aa.b(obj);
        FeedHttpUtils.d(new BluedUIHttpResponse<BluedEntityA<String>>(getFragmentActive()) { // from class: com.blued.community.ui.circle.fragment.CirclePostDetailsFragment.24
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<String> bluedEntityA) {
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish(boolean z) {
                super.onUIFinish(z);
                if (z) {
                    ((CirclePostDetailsPresenter) CirclePostDetailsFragment.this.j()).a(CirclePostDetailsFragment.this.ac, b, CirclePostDetailsFragment.this.H.isChecked());
                } else {
                    ToastUtils.b(R.string.content_can_not_send_feed_in_circle);
                }
            }
        }, b, BaseWrapper.ENTER_ID_OAPS_ROAMING, getFragmentActive());
    }

    private void C() {
        postDelaySafeRunOnUiThread(new Runnable() { // from class: com.blued.community.ui.circle.fragment.CirclePostDetailsFragment.25
            @Override // java.lang.Runnable
            public void run() {
                if (!CirclePostDetailsFragment.this.w.isFocusable()) {
                    CirclePostDetailsFragment.this.w.requestFocus();
                }
                KeyboardUtils.c(CirclePostDetailsFragment.this.getActivity());
            }
        }, 300L);
    }

    private void D() {
        if (((CirclePostDetailsPresenter) j()).n() == null) {
            return;
        }
        this.ai = new CircleMainMenuPop(getContext(), (CirclePostDetailsPresenter) j());
        new XPopup.Builder(getContext()).a(this.ai).h();
    }

    private void E() {
        a(this.N, this.s, this.w, this.J);
        ShapeHelper.b(this.y, R.color.syc_x);
        this.aa = new AtChooseUserHelper(getContext());
        this.ab = new Emotion(getContext());
        ArrayList arrayList = new ArrayList();
        arrayList.add(EmotionManager.g());
        this.M.setModel(true);
        this.M.a(getFragmentActive(), arrayList);
        this.K.a(getFragmentActive(), arrayList);
        this.K.setOnIndicatorListener(new EmoticonsPageView.OnEmoticonsPageViewListener() { // from class: com.blued.community.ui.circle.fragment.CirclePostDetailsFragment.26
            @Override // com.blued.android.module.common.widget.emoticon.ui.EmoticonsPageView.OnEmoticonsPageViewListener
            public void a(int i) {
                CirclePostDetailsFragment.this.L.a(i);
            }

            @Override // com.blued.android.module.common.widget.emoticon.ui.EmoticonsPageView.OnEmoticonsPageViewListener
            public void a(int i, int i2) {
                CirclePostDetailsFragment.this.L.a(i, i2);
            }

            @Override // com.blued.android.module.common.widget.emoticon.ui.EmoticonsPageView.OnEmoticonsPageViewListener
            public void b(int i) {
                CirclePostDetailsFragment.this.L.setIndicatorCount(i);
            }

            @Override // com.blued.android.module.common.widget.emoticon.ui.EmoticonsPageView.OnEmoticonsPageViewListener
            public void c(int i) {
                CirclePostDetailsFragment.this.L.b(i);
            }
        });
        this.K.setIViewListener(new IViewStateListener() { // from class: com.blued.community.ui.circle.fragment.CirclePostDetailsFragment.27
            @Override // com.blued.android.module.common.widget.emoticon.ui.IViewStateListener
            public void a(int i) {
                CirclePostDetailsFragment.this.M.setToolBtnSelect(i);
            }

            @Override // com.blued.android.module.common.widget.emoticon.ui.IViewStateListener
            public void a(EmoticonModel emoticonModel) {
                if (CirclePostDetailsFragment.this.w != null) {
                    CirclePostDetailsFragment.this.w.setFocusable(true);
                    CirclePostDetailsFragment.this.w.setFocusableInTouchMode(true);
                    CirclePostDetailsFragment.this.w.requestFocus();
                    if (emoticonModel.eventType == 1) {
                        CirclePostDetailsFragment.this.w.onKeyDown(67, new KeyEvent(0, 67));
                    } else if (emoticonModel.eventType == 2) {
                    } else {
                        if (emoticonModel.emoji != null) {
                            CirclePostDetailsFragment.this.w.append(emoticonModel.emoji.a());
                            return;
                        }
                        CirclePostDetailsFragment.this.w.getText().insert(CirclePostDetailsFragment.this.w.getSelectionStart(), CirclePostDetailsFragment.this.ab.a(emoticonModel.code));
                    }
                }
            }
        });
        this.M.setOnToolBarItemClickListener(new EmoticonsToolBarView.OnToolBarItemClickListener() { // from class: com.blued.community.ui.circle.fragment.CirclePostDetailsFragment.28
            @Override // com.blued.android.module.common.widget.emoticon.ui.EmoticonsToolBarView.OnToolBarItemClickListener
            public void a(int i) {
                CirclePostDetailsFragment.this.K.setPageSelect(i);
            }
        });
        this.w.setHint(FeedMethods.a(getContext()));
        this.w.setFilters(new InputFilter[]{new InputFilter.LengthFilter(256)});
        this.w.addTextChangedListener(this.aj);
        this.O.setOnTouchListener(new View.OnTouchListener() { // from class: com.blued.community.ui.circle.fragment.CirclePostDetailsFragment.29
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Logger.e("source", "touchView===" + motionEvent.getAction());
                if (motionEvent.getAction() == 0) {
                    Logger.e("source", "touchView===ACTION_DOWN");
                    if (((CirclePostDetailsPresenter) CirclePostDetailsFragment.this.j()).n() == null) {
                        return false;
                    }
                    EventTrackFeed.a(FeedProtos.Event.CIRCLE_NOTE_COMMENT_GUIDE_CLICK, ((CirclePostDetailsPresenter) CirclePostDetailsFragment.this.j()).n().feed_id, FeedProtos.NoteSource.NOTE_DETAIL_BOTTOM);
                    return false;
                }
                return false;
            }
        });
        this.w.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.blued.community.ui.circle.fragment.CirclePostDetailsFragment.30
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                Tracker.onFocusChange(view, z);
            }
        });
        F();
        final String a2 = AvatarUtils.a(1, UserInfoUtils.e());
        ImageLoader.a(getFragmentActive(), a2).b(R.drawable.user_bg_round).d(R.drawable.user_bg_round).c().a(this.F);
        this.H.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.blued.community.ui.circle.fragment.CirclePostDetailsFragment.31
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                Tracker.onCheckedChanged(compoundButton, z);
                if (z) {
                    ImageLoader.a(CirclePostDetailsFragment.this.getFragmentActive(), ((CirclePostDetailsPresenter) CirclePostDetailsFragment.this.j()).n().anonym_avatar).b(CircleMethods.a(CirclePostDetailsFragment.this.getContext(), ((CirclePostDetailsPresenter) CirclePostDetailsFragment.this.j()).s())).d(CircleMethods.a(CirclePostDetailsFragment.this.getContext(), ((CirclePostDetailsPresenter) CirclePostDetailsFragment.this.j()).s())).c().a(CirclePostDetailsFragment.this.F);
                } else {
                    ImageLoader.a(CirclePostDetailsFragment.this.getFragmentActive(), a2).b(R.drawable.user_bg_round).d(R.drawable.user_bg_round).c().a(CirclePostDetailsFragment.this.F);
                }
            }
        });
        this.G.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.circle.fragment.CirclePostDetailsFragment.32
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                if (CirclePostDetailsFragment.this.H.isEnabled()) {
                    return;
                }
                if (((CirclePostDetailsPresenter) CirclePostDetailsFragment.this.j()).n().anonym_comment == 1) {
                    AppMethods.d(R.string.circle_anonymous_same_identity);
                } else {
                    AppMethods.d(R.string.circle_anonymous_not_anonymous_comment);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F() {
        if (CommunityServiceManager.a().C() || TextUtils.isEmpty(this.w.getText())) {
            this.x.setAlpha(0.3f);
        } else {
            this.x.setAlpha(1.0f);
        }
    }

    private void G() {
        this.D.setVisibility(0);
        this.E.setVisibility(8);
        this.F.setVisibility(8);
        ViewGroup.LayoutParams layoutParams = this.v.getLayoutParams();
        layoutParams.height = DensityUtils.a(getContext(), 50.0f);
        this.v.setLayoutParams(layoutParams);
        this.N.setVisibility(8);
        this.t.setVisibility(8);
        this.z.setVisibility(0);
        this.w.setText((CharSequence) null);
        this.w.setHint(FeedMethods.a(getContext()));
        this.w.clearFocus();
        KeyboardUtils.a(getActivity());
        this.ac = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H() {
        if (CommunityPreferences.a()) {
            return;
        }
        EventTrackFeed.a(FeedProtos.Event.CIRCLE_NOTE_COMMENT_GUIDE_SHOW, ((CirclePostDetailsPresenter) j()).n().feed_id, FeedProtos.NoteSource.NOTE_DETAIL_BOTTOM);
        View inflate = View.inflate(getContext(), R.layout.pop_circle_detail_input_guide, null);
        final BluedPopupWindow a2 = BluedPopupWindow.Builder.a(getActivity(), inflate).a();
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.circle.fragment.CirclePostDetailsFragment.35
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                a2.dismiss();
                EventTrackFeed.a(FeedProtos.Event.CIRCLE_NOTE_COMMENT_GUIDE_CLICK, ((CirclePostDetailsPresenter) CirclePostDetailsFragment.this.j()).n().feed_id, FeedProtos.NoteSource.NOTE_DETAIL_BOTTOM);
            }
        });
        a2.a(this.w, 1, 0, 0, 0);
        CommunityPreferences.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2) {
        int i3 = i2 - this.ad;
        if (i3 > 0) {
            this.r.smoothScrollBy(i, i3);
        }
    }

    public static void a(Context context, BluedIngSelfFeed bluedIngSelfFeed, CircleListToDetailParams circleListToDetailParams) {
        if (!CommunityServiceManager.a().z()) {
            AppMethods.d(R.string.common_circle_service_upgraded);
        } else if (bluedIngSelfFeed == null) {
        } else {
            Bundle bundle = new Bundle();
            bundle.putSerializable("feed_data", bluedIngSelfFeed);
            bundle.putSerializable("circle_from_page", circleListToDetailParams.getSource());
            bundle.putBoolean("show_circle_entry", circleListToDetailParams.getShowCircleEntry().booleanValue());
            bundle.putSerializable("circle_list_to_detail_params", circleListToDetailParams);
            TerminalActivity.a(bundle);
            TerminalActivity.d(context, CirclePostDetailsFragment.class, bundle);
        }
    }

    public static void a(Context context, BluedIngSelfFeed bluedIngSelfFeed, FeedProtos.NoteSource noteSource) {
        CircleListToDetailParams circleListToDetailParams = new CircleListToDetailParams();
        circleListToDetailParams.setSource(noteSource);
        circleListToDetailParams.setShowCircleEntry(false);
        a(context, bluedIngSelfFeed, circleListToDetailParams);
    }

    public static void a(Context context, String str, FeedProtos.NoteSource noteSource) {
        a(context, str, "", noteSource, false);
    }

    public static void a(Context context, String str, FeedProtos.NoteSource noteSource, boolean z) {
        a(context, str, "", noteSource, z);
    }

    public static void a(Context context, String str, String str2, FeedProtos.NoteSource noteSource, boolean z) {
        if (!CommunityServiceManager.a().z()) {
            AppMethods.d(R.string.common_circle_service_upgraded);
        } else if (TextUtils.isEmpty(str)) {
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("feed_id", str);
            bundle.putString("comment_id", str2);
            bundle.putSerializable("circle_from_page", noteSource);
            bundle.putBoolean("show_circle_entry", z);
            TerminalActivity.a(bundle);
            TerminalActivity.d(context, CirclePostDetailsFragment.class, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TextView textView) {
        String charSequence = textView.getText().toString();
        if (Build.VERSION.SDK_INT < 11 || Build.VERSION.SDK_INT == 18) {
            ((ClipboardManager) getContext().getSystemService(Context.CLIPBOARD_SERVICE)).setText(RegExpUtils.a(charSequence));
        } else {
            try {
                ((android.content.ClipboardManager) getContext().getSystemService(Context.CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("simple text", RegExpUtils.a(charSequence)));
            } catch (Exception e) {
            }
        }
        AppMethods.a((CharSequence) getContext().getResources().getString(R.string.copy));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        CircleDetailsFragment.a(getContext(), ((CirclePostDetailsPresenter) j()).n().circle_id, CircleConstants.CIRCLE_FROM_PAGE.NOTE_FIXED_JOIN);
        ((CirclePostDetailsPresenter) j()).a(false);
    }

    private void c(String str) {
        this.w.setText(StringUtils.a(StringUtils.a(str, (int) this.w.getTextSize(), 3), true, true, true, null, true, "", ""));
        EditText editText = this.w;
        editText.setSelection(editText.length());
    }

    private void d(final BluedIngSelfFeed bluedIngSelfFeed) {
        String str;
        this.X.e = bluedIngSelfFeed.circle_id;
        a(new Runnable() { // from class: com.blued.community.ui.circle.fragment.CirclePostDetailsFragment.7
            @Override // java.lang.Runnable
            public void run() {
                if (CirclePostDetailsFragment.this.k()) {
                    CirclePostDetailsFragment.this.H();
                }
            }
        }, 500L);
        this.p.setVisibility(0);
        UserInfoHelper.a(this.Z.e, bluedIngSelfFeed.vbadge, 3);
        ImageLoader.a(getFragmentActive(), bluedIngSelfFeed.user_avatar).c().b(R.drawable.user_bg_round).a(this.Z.d);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.blued.community.ui.circle.fragment.CirclePostDetailsFragment.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                if (bluedIngSelfFeed.is_anonym == 1) {
                    AppMethods.d(R.string.circle_anonymous_not_to_user_info);
                    return;
                }
                UserBasicModel b = FeedMethods.b(bluedIngSelfFeed);
                String a2 = CircleMethods.a(((CirclePostDetailsPresenter) CirclePostDetailsFragment.this.j()).r());
                MessageProtos.StrangerSource b2 = CircleMethods.b(((CirclePostDetailsPresenter) CirclePostDetailsFragment.this.j()).r());
                LogData logData = new LogData();
                logData.circle_id = bluedIngSelfFeed.circle_id;
                logData.feed_id = bluedIngSelfFeed.feed_id;
                logData.target_uid = bluedIngSelfFeed.feed_uid;
                logData.activity_id = bluedIngSelfFeed.activity_id;
                logData.listMode = CirclePostDetailsFragment.this.ae != null ? CirclePostDetailsFragment.this.ae.getMode() : "";
                logData.from = a2;
                logData.userFrom = a2;
                CommunityServiceManager.b().a(CirclePostDetailsFragment.this.getContext(), b, a2, false, (View) CirclePostDetailsFragment.this.Z.d, logData, b2);
            }
        };
        this.Z.d.setOnClickListener(onClickListener);
        if (TextUtils.isEmpty(bluedIngSelfFeed.user_name)) {
            this.Z.f.setText("");
        } else if (TextUtils.isEmpty(bluedIngSelfFeed.note)) {
            this.Z.f.setText(bluedIngSelfFeed.user_name.replace(":", ""));
        } else {
            this.Z.f.setText(StringUtils.a(bluedIngSelfFeed.note, bluedIngSelfFeed.user_name.replace(":", "")));
        }
        this.Z.f.setOnClickListener(onClickListener);
        if (TextUtils.isEmpty(bluedIngSelfFeed.feed_timestamp)) {
            this.Z.g.setText("");
        } else {
            this.Z.g.setText(TimeAndDateUtils.h(getContext(), TimeAndDateUtils.c(bluedIngSelfFeed.feed_timestamp)));
        }
        UserBasicModel userBasicModel = new UserBasicModel();
        userBasicModel.vip_grade = bluedIngSelfFeed.vip_grade;
        userBasicModel.is_vip_annual = bluedIngSelfFeed.is_vip_annual;
        userBasicModel.is_hide_vip_look = bluedIngSelfFeed.is_hide_vip_look;
        userBasicModel.vip_exp_lvl = bluedIngSelfFeed.vip_exp_lvl;
        UserInfoHelper.a(getContext(), this.Z.f, userBasicModel);
        CircleMethods.a(this.Z.f19290a, bluedIngSelfFeed.anchor_admin_level);
        this.Z.b.setVisibility(bluedIngSelfFeed.is_anonym == 1 ? 0 : 8);
        UserInfoHelper.a(this.Z.f19291c, userBasicModel);
        EventTrackFeed.a(FeedProtos.Event.CIRCLE_NOTE_COMMENT_GUIDE_SHOW, bluedIngSelfFeed.feed_id, FeedProtos.NoteSource.NOTE_DETAIL_COMMENT_LIST);
        if (!TextUtils.isEmpty(bluedIngSelfFeed.feed_origin_content)) {
            this.Z.h.setVisibility(0);
            if (!this.W.equals(bluedIngSelfFeed.feed_origin_content)) {
                this.W = bluedIngSelfFeed.feed_origin_content;
                if (this.k == null) {
                    Log.e("Markdown", "new MarkdownBuilder");
                    this.k = new MarkdownView.Builder().a(getFragmentActive()).a(BluedSkinUtils.a(getContext(), R.color.syc_x)).b(3).a("!original.png").a(new OnClickAtUserListener() { // from class: com.blued.community.ui.circle.fragment.CirclePostDetailsFragment.11
                        @Override // com.blued.android.framework.ui.markdown.atuser.OnClickAtUserListener
                        public void a(String str2, String str3) {
                            CommunityServiceManager.b().a(CirclePostDetailsFragment.this.getContext(), str3, "CIRCLE_NOTE_DETAIL", MessageProtos.StrangerSource.CIRCLE_NOTE_DETAIL);
                        }
                    }).a(new OnClickLinkListener() { // from class: com.blued.community.ui.circle.fragment.CirclePostDetailsFragment.10
                        @Override // com.blued.android.framework.ui.markdown.link.OnClickLinkListener
                        public void a(String str2) {
                            EventTrackFeed.d(FeedProtos.Event.NOTE_LINK_CLICK, ((CirclePostDetailsPresenter) CirclePostDetailsFragment.this.j()).o(), ((CirclePostDetailsPresenter) CirclePostDetailsFragment.this.j()).q());
                            CommunityServiceManager.b().a(CirclePostDetailsFragment.this.getContext(), str2);
                        }
                    }).a(new OnClickImageListener() { // from class: com.blued.community.ui.circle.fragment.CirclePostDetailsFragment.9
                        @Override // com.blued.android.framework.ui.markdown.image.OnClickImageListener
                        public void a(String[] strArr, int i) {
                            EventTrackFeed.a(FeedProtos.Event.NOTE_IMAGE_CLICK, ((CirclePostDetailsPresenter) CirclePostDetailsFragment.this.j()).n().circle_id, ((CirclePostDetailsPresenter) CirclePostDetailsFragment.this.j()).n().feed_id, FeedProtos.NoteSource.NOTE_DETAIL, "");
                            CommunityServiceManager.b().a(CirclePostDetailsFragment.this.getContext(), strArr, i, 0, (LoadOptions) null, ((CirclePostDetailsPresenter) CirclePostDetailsFragment.this.j()).n().user_name, (View) null, (String) null);
                        }
                    });
                }
                LogUtils.d("Markdown", "markdownContent = " + this.W);
                this.Z.h.setTextColor(BluedSkinUtils.a(getContext(), R.color.syc_h));
                MarkdownView markdownView = this.Z.h;
                MarkdownView.Builder builder = this.k;
                if (((CirclePostDetailsPresenter) j()).n().is_essence == 1) {
                    str = "精" + this.W;
                } else {
                    str = this.W;
                }
                markdownView.a(builder, str);
                this.Z.q.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.blued.community.ui.circle.fragment.CirclePostDetailsFragment.12
                    @Override // android.view.View.OnLongClickListener
                    public boolean onLongClick(View view) {
                        CirclePostDetailsFragment circlePostDetailsFragment = CirclePostDetailsFragment.this;
                        circlePostDetailsFragment.a((TextView) circlePostDetailsFragment.Z.h);
                        return true;
                    }
                });
            }
        } else if (((CirclePostDetailsPresenter) j()).n().is_essence == 1) {
            this.Z.h.setVisibility(0);
        } else {
            this.Z.h.setVisibility(8);
        }
        f(bluedIngSelfFeed);
        g(bluedIngSelfFeed);
        e(bluedIngSelfFeed);
        h(bluedIngSelfFeed);
        this.o.setText(bluedIngSelfFeed.circle_title);
        this.Z.h.setOnShowTextListener(new MarkdownView.OnShowTextListener() { // from class: com.blued.community.ui.circle.fragment.CirclePostDetailsFragment.13
            @Override // com.blued.android.framework.ui.markdown.MarkdownView.OnShowTextListener
            public Spanned a(CharSequence charSequence) {
                return CircleMethods.a(((CirclePostDetailsPresenter) CirclePostDetailsFragment.this.j()).n(), charSequence, true);
            }
        });
    }

    private void e(BluedIngSelfFeed bluedIngSelfFeed) {
        if (!((CirclePostDetailsPresenter) j()).u() || bluedIngSelfFeed == null) {
            return;
        }
        this.Z.l.setVisibility(0);
        this.Z.l.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.circle.fragment.-$$Lambda$CirclePostDetailsFragment$6PwME5bRQL69LGPQ-7X7NemErXI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CirclePostDetailsFragment.this.c(view);
            }
        });
        ImageLoader.a(getFragmentActive(), AvatarUtils.a(0, bluedIngSelfFeed.cover)).b(R.drawable.circle_header_default).d(R.drawable.circle_header_default).a(6.0f).a(this.Z.m);
        this.Z.n.setText(bluedIngSelfFeed.circle_title);
        this.Z.o.setText(String.format(getContext().getString(R.string.circle_join_num_talk), Integer.valueOf(bluedIngSelfFeed.members_num)));
    }

    private void f(final BluedIngSelfFeed bluedIngSelfFeed) {
        if (bluedIngSelfFeed == null || bluedIngSelfFeed.is_video_posts != 1 || bluedIngSelfFeed.feed_videos.length < 2) {
            this.Z.j.setVisibility(8);
            return;
        }
        this.Z.j.setVisibility(0);
        if (bluedIngSelfFeed.feed_videos_width == null || bluedIngSelfFeed.feed_videos_height == null) {
            bluedIngSelfFeed.feed_videos_width = new String[]{"480"};
            bluedIngSelfFeed.feed_videos_height = new String[]{"480"};
        }
        if (bluedIngSelfFeed.feed_videos_width.length == 0 || bluedIngSelfFeed.feed_videos_height.length == 0) {
            bluedIngSelfFeed.feed_videos_width = new String[]{"480"};
            bluedIngSelfFeed.feed_videos_height = new String[]{"480"};
        }
        if (bluedIngSelfFeed.feed_videos_width.length == 0 || bluedIngSelfFeed.feed_videos_height.length == 0) {
            bluedIngSelfFeed.feed_videos_width = new String[]{"480"};
            bluedIngSelfFeed.feed_videos_height = new String[]{"480"};
        }
        int a2 = StringUtils.a(bluedIngSelfFeed.feed_videos_width[0], 480);
        int a3 = StringUtils.a(bluedIngSelfFeed.feed_videos_height[0], 480);
        if (a2 == 0 || a3 == 0) {
            a2 = 480;
            a3 = 480;
        }
        int a4 = AppInfo.l - AppMethods.a(18);
        int i = (int) (a4 / (a2 / a3));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(a4, i);
        layoutParams.gravity = 1;
        this.Z.i.setLayoutParams(layoutParams);
        final String[] strArr = bluedIngSelfFeed.feed_videos;
        final String str = bluedIngSelfFeed.feed_video_size;
        VideoPlayConfig videoPlayConfig = new VideoPlayConfig();
        videoPlayConfig.f15652a = bluedIngSelfFeed.feed_videos[0];
        videoPlayConfig.b = bluedIngSelfFeed.feed_videos[1];
        videoPlayConfig.e = a4;
        videoPlayConfig.f = i;
        videoPlayConfig.a(a2);
        videoPlayConfig.b(a3);
        try {
            videoPlayConfig.f15653c = Integer.parseInt(bluedIngSelfFeed.feed_video_size);
        } catch (Exception e) {
            Logger.b(CirclePostDetailsFragment.class.getSimpleName(), "setCircleVideo() Integer.parseInt(feed.feed_video_size) Exception");
        }
        final int i2 = a2;
        final int i3 = a3;
        videoPlayConfig.g = new View.OnClickListener() { // from class: com.blued.community.ui.circle.fragment.CirclePostDetailsFragment.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String[] strArr2;
                Tracker.onClick(view);
                EventTrackFeed.a(FeedProtos.Event.NOTE_VIDEO_CLICK, ((CirclePostDetailsPresenter) CirclePostDetailsFragment.this.j()).n().circle_id, ((CirclePostDetailsPresenter) CirclePostDetailsFragment.this.j()).n().feed_id, FeedProtos.NoteSource.NOTE_DETAIL, "");
                if (CommunityServiceManager.a().k() || (strArr2 = strArr) == null || strArr2.length < 2) {
                    return;
                }
                float f = 0.0f;
                if (!TextUtils.isEmpty(str)) {
                    try {
                        f = Float.parseFloat(str);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        f = 0.0f;
                    }
                }
                ICommunityShowPageService b = CommunityServiceManager.b();
                Context context = CirclePostDetailsFragment.this.getContext();
                String[] strArr3 = strArr;
                b.a(context, strArr3[0], strArr3[1], bluedIngSelfFeed.feed_id, 7, i2, i3, f);
            }
        };
        this.Z.i.b(videoPlayConfig);
        a(new Runnable() { // from class: com.blued.community.ui.circle.fragment.CirclePostDetailsFragment.15
            @Override // java.lang.Runnable
            public void run() {
                if (CirclePostDetailsFragment.this.Z == null || CirclePostDetailsFragment.this.Z.i == null) {
                    return;
                }
                CirclePostDetailsFragment.this.Z.i.c();
            }
        });
    }

    private void g(BluedIngSelfFeed bluedIngSelfFeed) {
        if (bluedIngSelfFeed == null || bluedIngSelfFeed.is_posts_vote != 1) {
            this.Z.k.setVisibility(8);
            return;
        }
        this.Z.k.setOptionTitle(bluedIngSelfFeed.posts_vote_title);
        this.Z.k.setOptionList(bluedIngSelfFeed.option_count);
        this.Z.k.a(bluedIngSelfFeed.vote_count, bluedIngSelfFeed.ivoted);
        this.Z.k.setOnVoteListener(new CircleTextVoteView.OnVoteListener() { // from class: com.blued.community.ui.circle.fragment.CirclePostDetailsFragment.16
            @Override // com.blued.community.widget.vote.text.view.CircleTextVoteView.OnVoteListener
            public void a(CircleTextVote circleTextVote, int i) {
                ((CirclePostDetailsPresenter) CirclePostDetailsFragment.this.j()).a(i + 1);
            }
        });
        this.Z.k.setVisibility(0);
        a(new Runnable() { // from class: com.blued.community.ui.circle.fragment.CirclePostDetailsFragment.17
            @Override // java.lang.Runnable
            public void run() {
                CirclePostDetailsFragment.this.r.scrollToPosition(0);
            }
        });
    }

    private void h(BluedIngSelfFeed bluedIngSelfFeed) {
        TextView textView = this.Z.p;
        String string = getString(R.string.circle_post_detail_total_comment);
        Context context = getContext();
        textView.setText(String.format(string, DistanceUtils.a(context, bluedIngSelfFeed.feed_comment + "")));
    }

    private void i(BluedIngSelfFeed bluedIngSelfFeed) {
        TextView textView = this.Q;
        textView.setText(bluedIngSelfFeed.members_num + getString(R.string.members_count));
        ImageLoader.a(getFragmentActive(), AvatarUtils.a(((CirclePostDetailsPresenter) j()).n().cover)).b(R.drawable.circle_header_default).a(5.0f).a(new AnonymousClass19(getFragmentActive())).a(this.P);
    }

    private void y() {
        this.m = (ConstraintLayout) this.i.findViewById(R.id.cl_title_bar);
        this.n = (SmartRefreshLayout) this.i.findViewById(R.id.refresh_layout);
        this.o = (TextView) this.i.findViewById(R.id.tv_circle_name);
        this.p = (ImageView) this.i.findViewById(R.id.iv_menu);
        this.q = (CircleJoinView) this.i.findViewById(R.id.cjv_join);
        this.r = (RecyclerView) this.i.findViewById(R.id.comment_list);
        this.s = (KeyboardListenLinearLayout) this.i.findViewById(R.id.keyboard_layout);
        this.t = this.i.findViewById(R.id.keyboard_view);
        this.u = this.i.findViewById(R.id.input_layout_up);
        this.v = (LinearLayout) this.i.findViewById(R.id.layout_comment_all);
        this.w = (EditText) this.i.findViewById(R.id.edit_view);
        this.x = (ShapeTextView) this.i.findViewById(R.id.send_btn);
        this.y = (ShapeRelativeLayout) this.i.findViewById(R.id.edit_layout);
        this.z = (ImageView) this.i.findViewById(R.id.icon_album);
        this.A = (ImageView) this.i.findViewById(R.id.icon_share);
        this.S = this.i.findViewById(R.id.icon_comment);
        this.T = this.i.findViewById(R.id.icon_emoji);
        this.B = (TextView) this.i.findViewById(R.id.tv_comment_cnt_bottom);
        this.C = (TextView) this.i.findViewById(R.id.tv_praise_cnt_bottom);
        this.D = this.i.findViewById(R.id.layout_like_comment);
        this.E = (LinearLayout) this.i.findViewById(R.id.layout_album);
        this.F = (ImageView) this.i.findViewById(R.id.iv_comment_header);
        this.G = (FrameLayout) this.i.findViewById(R.id.fl_anonymous_comment);
        this.H = (CheckBox) this.i.findViewById(R.id.cb_anonymous_comment);
        this.I = (ImageView) this.i.findViewById(R.id.icon_like);
        this.J = (LinearLayout) this.i.findViewById(R.id.emoticon_layout);
        this.K = (EmoticonsPageView) this.i.findViewById(R.id.view_epv);
        this.L = (EmoticonsIndicatorView) this.i.findViewById(R.id.view_eiv);
        this.M = (EmoticonsToolBarView) this.i.findViewById(R.id.view_etv);
        this.N = (SwitchPanelRelativeLayout) this.i.findViewById(R.id.emoticon_layout_root);
        this.O = this.i.findViewById(R.id.touchView);
        this.P = (ImageView) this.i.findViewById(R.id.iv_cover);
        this.Q = (TextView) this.i.findViewById(R.id.tv_member_num);
        this.R = (RelativeLayout) this.i.findViewById(R.id.rl_title_bar);
        this.U = this.i.findViewById(R.id.iv_back);
        this.V = this.i.findViewById(R.id.view_bottom);
        this.x.setOnClickListener(new SingleClickProxy(this));
        this.S.setOnClickListener(new SingleClickProxy(this));
        this.I.setOnClickListener(new SingleClickProxy(this));
        this.p.setOnClickListener(new SingleClickProxy(this));
        this.U.setOnClickListener(new SingleClickProxy(this));
        this.q.setOnClickListener(new SingleClickProxy(this));
        this.o.setOnClickListener(new SingleClickProxy(this));
        this.z.setOnClickListener(new SingleClickProxy(this));
        this.T.setOnClickListener(new SingleClickProxy(this));
        this.A.setOnClickListener(new SingleClickProxy(this));
        this.P.setOnClickListener(new SingleClickProxy(this));
    }

    private void z() {
        if (((CirclePostDetailsPresenter) j()).u()) {
            new XPopup.Builder(getContext()).d((Boolean) false).d(true).a((Boolean) false).b((Boolean) false).c(true).a(this.V).c(-DensityUtils.a(getContext(), 10.0f)).a(PopupAnimation.TranslateFromBottom).c((Boolean) false).a((BasePopupView) new CircleViewDialog(getContext(), ((CirclePostDetailsPresenter) j()).n())).h().a(6000L);
        }
    }

    @Override // com.blued.android.framework.ui.custom.MvpKeyBoardFragment
    public void a(int i) {
        if (i == -4 || i == -3) {
            Logger.e("Circle", "======键盘显示==" + this.N.getVisibility());
            this.E.setVisibility(0);
            this.F.setVisibility(0);
            ViewGroup.LayoutParams layoutParams = this.v.getLayoutParams();
            layoutParams.height = DensityUtils.a(getContext(), 100.0f);
            this.v.setLayoutParams(layoutParams);
            this.D.setVisibility(8);
            this.t.setVisibility(0);
            this.t.setOnTouchListener(new View.OnTouchListener() { // from class: com.blued.community.ui.circle.fragment.CirclePostDetailsFragment.34
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    KeyboardUtils.a(CirclePostDetailsFragment.this.getActivity());
                    if (CirclePostDetailsFragment.this.getFragmentActive().isActive() && CirclePostDetailsFragment.this.k()) {
                        CirclePostDetailsFragment.this.D.setVisibility(0);
                        CirclePostDetailsFragment.this.E.setVisibility(8);
                        CirclePostDetailsFragment.this.F.setVisibility(8);
                        ViewGroup.LayoutParams layoutParams2 = CirclePostDetailsFragment.this.v.getLayoutParams();
                        layoutParams2.height = DensityUtils.a(CirclePostDetailsFragment.this.getContext(), 50.0f);
                        CirclePostDetailsFragment.this.v.setLayoutParams(layoutParams2);
                        CirclePostDetailsFragment.this.N.setVisibility(8);
                        CirclePostDetailsFragment.this.t.setVisibility(8);
                        CirclePostDetailsFragment.this.z.setVisibility(0);
                        CirclePostDetailsFragment.this.w.clearFocus();
                        return true;
                    }
                    return true;
                }
            });
            this.w.setFocusable(true);
            this.w.setFocusableInTouchMode(true);
            this.w.requestFocus();
        } else if (i != -2) {
        } else {
            if (this.N.getVisibility() != 0) {
                this.E.setVisibility(0);
                this.F.setVisibility(0);
                ViewGroup.LayoutParams layoutParams2 = this.v.getLayoutParams();
                layoutParams2.height = DensityUtils.a(getContext(), 100.0f);
                this.v.setLayoutParams(layoutParams2);
                this.D.setVisibility(8);
            } else if (!this.w.isFocusable()) {
                this.t.setVisibility(8);
            }
            Logger.e("Circle", "======键盘隐藏==" + this.N.getVisibility());
        }
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public void a(Bundle bundle) {
        super.a(bundle);
        y();
        if (getArguments() != null) {
            this.ae = (CircleListToDetailParams) getArguments().getSerializable("circle_list_to_detail_params");
        }
        StatusBarHelper.a((Activity) getActivity(), false);
        ViewGroup.LayoutParams layoutParams = this.R.getLayoutParams();
        layoutParams.height = StatusBarHelper.a(getContext());
        this.R.setLayoutParams(layoutParams);
        this.r.setLayoutManager(new LinearLayoutManager(getContext()) { // from class: com.blued.community.ui.circle.fragment.CirclePostDetailsFragment.2
            @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
            public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
                try {
                    super.onLayoutChildren(recycler, state);
                } catch (IndexOutOfBoundsException e) {
                }
            }
        });
        View inflate = View.inflate(getContext(), R.layout.header_circle_base_main, null);
        this.af = inflate;
        HeaderHolder headerHolder = new HeaderHolder(inflate);
        this.Z = headerHolder;
        headerHolder.h.addOnAttachStateChangeListener(this.l);
        if (this.X == null) {
            CircleListToDetailParams circleListToDetailParams = this.ae;
            CircleMainDetailCommentAdapter circleMainDetailCommentAdapter = new CircleMainDetailCommentAdapter(circleListToDetailParams != null ? circleListToDetailParams.getMode() : "");
            this.X = circleMainDetailCommentAdapter;
            circleMainDetailCommentAdapter.addHeaderView(this.af);
            NoDataAndLoadFailView noDataAndLoadFailView = new NoDataAndLoadFailView(getContext());
            this.Y = noDataAndLoadFailView;
            noDataAndLoadFailView.setNoDataImg(R.drawable.icon_no_data_comment);
            this.X.setEmptyView(this.Y);
            this.X.setHeaderAndEmpty(true);
            this.X.setEnableLoadMore(false);
            ((CirclePostDetailsPresenter) j()).a(this.X);
            this.X.bindToRecyclerView(this.r);
        }
        this.X.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() { // from class: com.blued.community.ui.circle.fragment.CirclePostDetailsFragment.3
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemChildClickListener
            public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                FeedComment feedComment = (FeedComment) baseQuickAdapter.getItem(i);
                int id = view.getId();
                if (id == R.id.ll_reply || id == R.id.tv_reply_first || id == R.id.tv_reply_second) {
                    if (feedComment != null) {
                        String a2 = AppUtils.a(R.string.reply_title);
                        String format = String.format(a2, feedComment.comments_count + "");
                        if (CirclePostDetailsFragment.this.X != null) {
                            CirclePostDetailsFragment.this.X.a();
                        }
                        CommentFragment.a(CirclePostDetailsFragment.this.getContext(), format, feedComment, ((CirclePostDetailsPresenter) CirclePostDetailsFragment.this.j()).n(), CirclePostDetailsFragment.this.X.a(), ((CirclePostDetailsPresenter) CirclePostDetailsFragment.this.j()).s(), 13, 101);
                    }
                } else if (id != R.id.rl_comment || CommunityServiceManager.a().b(CirclePostDetailsFragment.this.getContext())) {
                } else {
                    CirclePostDetailsFragment.this.ac = feedComment;
                    String string = CirclePostDetailsFragment.this.getContext().getResources().getString(R.string.reply);
                    CirclePostDetailsFragment.this.w.setText("");
                    EditText editText = CirclePostDetailsFragment.this.w;
                    editText.setHint(string + feedComment.user_name + ":");
                    CirclePostDetailsFragment.this.w.requestFocus();
                    CirclePostDetailsFragment.this.z.setVisibility(8);
                    KeyboardUtils.c(CirclePostDetailsFragment.this.getActivity());
                }
            }
        });
        this.r.setAdapter(this.X);
        ViewUtils.b(this.r);
        this.n.l(true);
        this.n.a(new OnRefreshLoadMoreListener() { // from class: com.blued.community.ui.circle.fragment.CirclePostDetailsFragment.4
            @Override // com.scwang.smartrefresh.layout.listener.OnLoadMoreListener
            public void onLoadMore(RefreshLayout refreshLayout) {
                ((CirclePostDetailsPresenter) CirclePostDetailsFragment.this.j()).f();
            }

            @Override // com.scwang.smartrefresh.layout.listener.OnRefreshListener
            public void onRefresh(RefreshLayout refreshLayout) {
                ((CirclePostDetailsPresenter) CirclePostDetailsFragment.this.j()).e();
            }
        });
        E();
        this.w.setOnTouchListener(new View.OnTouchListener() { // from class: com.blued.community.ui.circle.fragment.CirclePostDetailsFragment.5
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (((CirclePostDetailsPresenter) CirclePostDetailsFragment.this.j()).n().user_is_muted != 1) {
                    if (motionEvent.getAction() == 1 && ((CirclePostDetailsPresenter) CirclePostDetailsFragment.this.j()).n() != null && ((CirclePostDetailsPresenter) CirclePostDetailsFragment.this.j()).n().isNotMember()) {
                        CirclePostDetailsFragment.this.A();
                        return true;
                    }
                    return false;
                } else if (((CirclePostDetailsPresenter) CirclePostDetailsFragment.this.j()).n().user_mute_type != 1 && ((CirclePostDetailsPresenter) CirclePostDetailsFragment.this.j()).n().user_mute_type != 2) {
                    if (((CirclePostDetailsPresenter) CirclePostDetailsFragment.this.j()).n().user_mute_type == 1009) {
                        AppMethods.a((CharSequence) CirclePostDetailsFragment.this.getResources().getString(R.string.toast_current_circle_mute));
                        return false;
                    }
                    AppMethods.a((CharSequence) CirclePostDetailsFragment.this.getResources().getString(R.string.toast_all_circle_mute));
                    return false;
                } else {
                    String c2 = TimeAndDateUtils.c(TimeAndDateUtils.c(((CirclePostDetailsPresenter) CirclePostDetailsFragment.this.j()).n().mute_time + ""));
                    AppMethods.a((CharSequence) ("你已经被禁言， " + c2 + "自动解禁"));
                    return false;
                }
            }
        });
        this.r.setOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.blued.community.ui.circle.fragment.CirclePostDetailsFragment.6
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                CirclePostDetailsFragment.this.ad += i2;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(final BluedIngSelfFeed bluedIngSelfFeed) {
        String str;
        String str2;
        String str3;
        i(bluedIngSelfFeed);
        d(bluedIngSelfFeed);
        c(bluedIngSelfFeed);
        this.X.d = bluedIngSelfFeed;
        b(bluedIngSelfFeed);
        if (bluedIngSelfFeed.iliked == 0) {
            this.I.setTag(null);
            this.I.setImageDrawable(BluedSkinUtils.b(getContext(), R.drawable.icon_feed_like));
        } else if (bluedIngSelfFeed.isPlayLikeAnim) {
            this.I.setTag(i.f);
            ImageLoader.c(getFragmentActive(), FeedMethods.e()).f().a(new ImageLoader.OnAnimationStateListener() { // from class: com.blued.community.ui.circle.fragment.CirclePostDetailsFragment.18
                @Override // com.blued.android.core.image.ImageLoader.OnAnimationStateListener
                public void a() {
                }

                @Override // com.blued.android.core.image.ImageLoader.OnAnimationStateListener
                public void b() {
                    bluedIngSelfFeed.isPlayLikeAnim = false;
                    if (CirclePostDetailsFragment.this.I == null || CirclePostDetailsFragment.this.I.getTag() == null) {
                        return;
                    }
                    ImageLoader.a(CirclePostDetailsFragment.this.getFragmentActive(), R.drawable.icon_feed_liked).a(CirclePostDetailsFragment.this.I);
                }
            }).a(this.I);
        } else {
            this.I.setTag(null);
            ImageLoader.a(getFragmentActive(), R.drawable.icon_feed_liked).a(this.I);
        }
        if (200 == bluedIngSelfFeed.feed_status && bluedIngSelfFeed.is_disclosure == 1) {
            this.A.setImageDrawable(BluedSkinUtils.b(getContext(), R.drawable.icon_feed_share));
        } else {
            this.A.setImageDrawable(BluedSkinUtils.b(getContext(), R.drawable.icon_feed_unshare));
        }
        TextView textView = this.C;
        if (bluedIngSelfFeed.feed_dig > 999) {
            str = "999+";
        } else {
            str = bluedIngSelfFeed.feed_dig + "";
        }
        textView.setText(str);
        TextView textView2 = this.B;
        if (bluedIngSelfFeed.feed_comment > 999) {
            str2 = "999+";
        } else {
            str2 = bluedIngSelfFeed.feed_comment + "";
        }
        textView2.setText(str2);
        this.C.setTextColor(BluedSkinUtils.a(getContext(), bluedIngSelfFeed.iliked == 1 ? R.color.feed_like : R.color.syc_h));
        this.B.setVisibility(bluedIngSelfFeed.feed_comment == 0 ? 8 : 0);
        this.C.setVisibility(bluedIngSelfFeed.feed_dig == 0 ? 8 : 0);
        this.Z.h.setTextColor(BluedSkinUtils.a(getContext(), R.color.syc_h));
        if (((CirclePostDetailsPresenter) j()).n().is_essence == 1) {
            str3 = "精" + this.W;
        } else {
            str3 = this.W;
        }
        this.Z.h.a(this.k, str3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(FeedComment feedComment) {
        KeyboardUtils.a(getActivity());
        this.X.getData().add(0, feedComment);
        CircleMainDetailCommentAdapter circleMainDetailCommentAdapter = this.X;
        circleMainDetailCommentAdapter.notifyItemInserted(circleMainDetailCommentAdapter.getHeaderLayoutCount());
        ViewUtils.a(this.r, this.X.getHeaderLayoutCount(), this.Z.p.getHeight());
        a(new Runnable() { // from class: com.blued.community.ui.circle.fragment.CirclePostDetailsFragment.21
            @Override // java.lang.Runnable
            public void run() {
                CirclePostDetailsFragment.this.X.c();
            }
        });
        G();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(final Boolean bool) {
        a(new Runnable() { // from class: com.blued.community.ui.circle.fragment.CirclePostDetailsFragment.22
            @Override // java.lang.Runnable
            public void run() {
                if (bool.booleanValue()) {
                    int height = CirclePostDetailsFragment.this.Z.r.getVisibility() == 0 ? CirclePostDetailsFragment.this.Z.r.getHeight() : 0;
                    CirclePostDetailsFragment circlePostDetailsFragment = CirclePostDetailsFragment.this;
                    circlePostDetailsFragment.a(0, (circlePostDetailsFragment.X.getHeaderLayout().getHeight() - CirclePostDetailsFragment.this.Z.p.getHeight()) - height);
                } else {
                    CirclePostDetailsFragment circlePostDetailsFragment2 = CirclePostDetailsFragment.this;
                    circlePostDetailsFragment2.a(0, circlePostDetailsFragment2.X.getHeaderLayout().getHeight() - (CirclePostDetailsFragment.this.r.getHeight() / 2));
                }
                CirclePostDetailsFragment.this.a(new Runnable() { // from class: com.blued.community.ui.circle.fragment.CirclePostDetailsFragment.22.1
                    @Override // java.lang.Runnable
                    public void run() {
                        CirclePostDetailsFragment.this.X.b();
                    }
                }, 100L);
            }
        }, 1000L);
    }

    @Override // com.blued.community.ui.send.observer.FeedRefreshObserver.IFeedRefreshObserver
    public void a(Object obj, int i) {
        if (i == 2 && (obj instanceof FeedComment)) {
            this.X.getData().add(0, (FeedComment) obj);
            CircleMainDetailCommentAdapter circleMainDetailCommentAdapter = this.X;
            circleMainDetailCommentAdapter.notifyItemInserted(circleMainDetailCommentAdapter.getHeaderLayoutCount());
            this.r.scrollToPosition(this.X.getHeaderLayoutCount());
        }
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void a(String str, boolean z) {
        boolean z2;
        super.a(str, z);
        int hashCode = str.hashCode();
        if (hashCode != -1290256561) {
            if (hashCode == 623698297 && str.equals("_load_type_loadmore_")) {
                z2 = false;
            }
            z2 = true;
        } else {
            if (str.equals("_load_type_refresh_")) {
                z2 = true;
            }
            z2 = true;
        }
        if (!z2) {
            this.n.j(z);
        } else if (!z2) {
        } else {
            this.Z.r.setVisibility(8);
            this.n.j();
            if (!z) {
                this.Y.b();
            } else if (this.X.getData().size() == 0) {
                this.Y.a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(List<FeedComment> list) {
        this.X.setNewData(list);
    }

    @Override // com.blued.android.framework.ui.custom.MvpKeyBoardFragment, com.blued.android.framework.ui.mvp.MvpFragment
    public void af_() {
        super.af_();
        HeaderHolder headerHolder = this.Z;
        if (headerHolder == null || headerHolder.h == null) {
            return;
        }
        this.Z.h.removeOnAttachStateChangeListener(this.l);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(BluedIngSelfFeed bluedIngSelfFeed) {
        this.q.setStyle(1);
        if (bluedIngSelfFeed.isNotMember()) {
            this.q.setVisibility(0);
            if (((CirclePostDetailsPresenter) j()).t()) {
                this.q.b();
            } else {
                this.q.setJoinStatus(bluedIngSelfFeed.getJoinState());
            }
        } else if (!((CirclePostDetailsPresenter) j()).t()) {
            v();
        } else {
            this.q.setVisibility(0);
            this.q.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(FeedComment feedComment) {
        KeyboardUtils.a(getActivity());
        FeedComment feedComment2 = this.ac;
        if (feedComment2 != null) {
            this.X.a(feedComment, feedComment2.comment_id);
        }
        G();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(BluedIngSelfFeed bluedIngSelfFeed) {
        int i = bluedIngSelfFeed.must_anonym_reply;
        if (i == 0) {
            this.H.setEnabled(true);
            this.H.setClickable(true);
            this.H.setTextColor(BluedSkinUtils.a(getContext(), R.color.syc_h));
        } else if (i == 1) {
            this.H.setEnabled(false);
            this.H.setClickable(false);
            this.H.setTextColor(BluedSkinUtils.a(getContext(), R.color.syc_i));
            this.H.setChecked(true);
            ImageLoader.a(getFragmentActive(), ((CirclePostDetailsPresenter) j()).n().anonym_avatar).b(CircleMethods.a(getContext(), ((CirclePostDetailsPresenter) j()).s())).d(CircleMethods.a(getContext(), ((CirclePostDetailsPresenter) j()).s())).a(this.F);
        } else if (i != 2) {
        } else {
            this.H.setEnabled(false);
            this.H.setClickable(false);
            this.H.setTextColor(BluedSkinUtils.a(getContext(), R.color.syc_i));
            this.H.setChecked(false);
        }
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public void f() {
        super.f();
        getActivity().getWindow().setSoftInputMode(16);
        FeedRefreshObserver.a().a(this);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public int g() {
        return R.layout.fragment_circle_post_details;
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void o() {
        super.o();
        this.n.l(true);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            if (i != 100) {
                if (i != 101) {
                    if (i == 9090) {
                        this.aa.a(this.w, intent, this.aj);
                        C();
                    }
                } else if (intent != null) {
                    ((CirclePostDetailsPresenter) j()).n().must_anonym_reply = intent.getIntExtra("comment_state", 0);
                    c(((CirclePostDetailsPresenter) j()).n());
                }
            } else if (intent != null) {
                String stringExtra = intent.getStringExtra("comment_content");
                boolean booleanExtra = intent.getBooleanExtra("is_can_change_anonymous", true);
                boolean booleanExtra2 = intent.getBooleanExtra("is_anonymous", false);
                if (TextUtils.isEmpty(stringExtra)) {
                    this.w.setText("");
                } else {
                    c(stringExtra);
                }
                this.H.setEnabled(booleanExtra);
                this.H.setClickable(booleanExtra);
                this.H.setChecked(booleanExtra2);
            }
        } else if (i == 9090) {
            C();
        }
        super.onActivityResult(i, i2, intent);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        int id = view.getId();
        if (id == R.id.iv_back) {
            t();
        } else if (id == R.id.icon_comment) {
            a(0, (this.X.getHeaderLayout().getHeight() - this.Z.p.getHeight()) - (this.Z.r.getVisibility() == 0 ? this.Z.r.getHeight() : 0));
        } else if (id == R.id.icon_like) {
            ((CirclePostDetailsPresenter) j()).m();
        } else if (id == R.id.iv_menu) {
            EventTrackFeed.a(FeedProtos.Event.NOTE_MORE_BTN_CLICK, ((CirclePostDetailsPresenter) j()).n().circle_id, ((CirclePostDetailsPresenter) j()).n().feed_id, FeedProtos.NoteSource.NOTE_DETAIL, "");
            D();
        } else if (id == R.id.cjv_join) {
            if (!this.q.d()) {
                EventTrackFeed.a(FeedProtos.Event.CIRCLE_JOIN_BTN_CLICK, ((CirclePostDetailsPresenter) j()).n(), FeedProtos.CircleSource.CIRCLE_NOTE_DETAIL_NAME);
                ((CirclePostDetailsPresenter) j()).a(getFragmentManager());
                z();
            } else if (((CirclePostDetailsPresenter) j()).t()) {
                CircleDetailsFragment.a(getContext(), ((CirclePostDetailsPresenter) j()).n().circle_id, CircleConstants.CIRCLE_FROM_PAGE.NOTE_TOP_JOIN);
            } else {
                CircleDetailsFragment.a(getContext(), ((CirclePostDetailsPresenter) j()).n().circle_id, CircleConstants.CIRCLE_FROM_PAGE.CIRCLE_POST_DETAILS);
            }
            ((CirclePostDetailsPresenter) j()).a(false);
        } else if (id == R.id.iv_cover || id == R.id.tv_circle_name) {
            if (((CirclePostDetailsPresenter) j()).n() == null) {
                return;
            }
            CircleDetailsFragment.a(getContext(), ((CirclePostDetailsPresenter) j()).n().circle_id, CircleConstants.CIRCLE_FROM_PAGE.CIRCLE_POST_DETAILS);
            ((CirclePostDetailsPresenter) j()).a(false);
        } else if (id == R.id.icon_album) {
            CircleCommentFragment.a(this, ((CirclePostDetailsPresenter) j()).n(), this.w.getText().toString(), this.H.isEnabled(), this.H.isChecked(), ((CirclePostDetailsPresenter) j()).n().anonym_comment == 1, ((CirclePostDetailsPresenter) j()).s(), ((CirclePostDetailsPresenter) j()).n().anonym_avatar, 100, ((CirclePostDetailsPresenter) j()).r());
        } else if (id == R.id.icon_emoji) {
            e();
        } else if (id == R.id.send_btn) {
            B();
        } else if (id == R.id.icon_share && 200 == ((CirclePostDetailsPresenter) j()).n().feed_status && ((CirclePostDetailsPresenter) j()).n().is_disclosure == 1) {
            w();
        }
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        x();
        FeedRefreshObserver.a().b(this);
        HeaderHolder headerHolder = this.Z;
        if (headerHolder == null || headerHolder.h == null) {
            return;
        }
        this.Z.h.removeOnAttachStateChangeListener(this.l);
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        HeaderHolder headerHolder = this.Z;
        if (headerHolder != null && headerHolder.i != null) {
            this.Z.i.g();
        }
        this.X.d();
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        HeaderHolder headerHolder = this.Z;
        if (headerHolder == null || headerHolder.i == null) {
            return;
        }
        this.Z.i.f();
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void p() {
        super.p();
        this.n.l(false);
    }

    protected void v() {
        if (this.q.getVisibility() == 0) {
            this.q.setJoinStatus(((CirclePostDetailsPresenter) j()).n().getJoinState());
            a(new Runnable() { // from class: com.blued.community.ui.circle.fragment.CirclePostDetailsFragment.20
                @Override // java.lang.Runnable
                public void run() {
                    CirclePostDetailsFragment.this.q.setVisibility(8);
                }
            }, 1000L);
        }
    }

    protected void w() {
        BluedIngSelfFeed n = ((CirclePostDetailsPresenter) j()).n();
        if (UserInfoHelper.a(n.relationship)) {
            return;
        }
        CommunityShareUtils.b().a(getContext(), n, 15);
    }

    protected void x() {
        SelectPhotoManager.a().d();
        ChildPhotoManager.a().d();
    }
}
