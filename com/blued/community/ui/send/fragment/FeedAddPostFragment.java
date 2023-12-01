package com.blued.community.ui.send.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.Editable;
import android.text.StaticLayout;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alipay.sdk.sys.a;
import com.alipay.sdk.util.i;
import com.app.share.model.ShareEntity;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.xpop.interfaces.SimpleCallback;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.module.base.shortvideo.StvResultModel;
import com.blued.android.module.common.db.NewFeedDao;
import com.blued.android.module.common.db.model.NewFeedModel;
import com.blued.android.module.common.utils.NinePatchUtils;
import com.blued.android.module.common.utils.TimeAndDateUtils;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.android.module.common.utils.click.SingleClickProxy;
import com.blued.android.module.common.view.FlowLayout;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.blued.android.module.media.selector.model.AlbumSelectInfo;
import com.blued.community.R;
import com.blued.community.auto.CommunityServiceManager;
import com.blued.community.http.FeedHttpUtils;
import com.blued.community.manager.CommunityManager;
import com.blued.community.model.AttentionFeedPostGuideModel;
import com.blued.community.model.BluedIngSelfFeed;
import com.blued.community.model.FeedAddPostGuideAuditExtra;
import com.blued.community.track.EventTrackFeed;
import com.blued.community.track.EventTrackVote;
import com.blued.community.ui.circle.model.MyCircleModel;
import com.blued.community.ui.event.model.EventDetailsModel;
import com.blued.community.ui.feed.manager.FeedMethods;
import com.blued.community.ui.send.adapter.FeedPostTopicAdapter;
import com.blued.community.ui.send.dialog.AlbumSelectDialogFragment;
import com.blued.community.ui.send.dialog.SelectTopicDialogFragment;
import com.blued.community.ui.send.fragment.FeedAddPostFragment;
import com.blued.community.ui.send.manager.SelectPhotoManager;
import com.blued.community.ui.send.model.ChildImageInfo;
import com.blued.community.ui.send.model.FeedIntroduceExtra;
import com.blued.community.ui.send.model.FeedIntroduceModel;
import com.blued.community.ui.send.model.FeedTemplateExtra;
import com.blued.community.ui.send.model.FeedTemplateModel;
import com.blued.community.ui.send.model.FeedTemplateTitleModel;
import com.blued.community.ui.send.view.FeedPostVoteView;
import com.blued.community.ui.send.vm.SelectTopicViewModel;
import com.blued.community.ui.topic.manager.TopicMethods;
import com.blued.community.ui.topic.model.BluedTopic;
import com.blued.community.ui.topic.model.BluedTopicOuterExtra;
import com.blued.community.utils.CommBundleBuilder;
import com.blued.community.utils.CommunityPreferences;
import com.blued.community.utils.ViewUtils;
import com.blued.community.view.CommonMultiItemAdapter;
import com.blued.community.view.CommonViewHolder;
import com.blued.community.widget.FeedGuidePop;
import com.blued.das.client.feed.FeedProtos;
import com.blued.das.client.vote.VoteProtos;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/send/fragment/FeedAddPostFragment.class */
public class FeedAddPostFragment extends FeedAddPostBaseFragment {
    public static final List<BluedTopic> aU = new ArrayList();
    protected ShapeLinearLayout aO;
    protected ImageView aP;
    protected TextView aQ;
    protected RecyclerView aR;
    protected FeedPostTopicAdapter aS;
    protected FlowLayout aT;
    protected LinearLayout aV;
    protected View aW;
    protected View aX;
    protected ImageView aY;
    protected View aZ;
    protected LinearLayout b;
    private FeedTemplateModel bA;
    private FeedTemplateTitleModel bB;
    private BluedTopic bG;
    private FeedIntroduceModel bH;
    private BluedTopic bI;
    private FeedGuidePop bJ;
    protected TextView ba;
    protected View bb;
    protected String bc;
    private FeedPostVoteView bd;
    private ImageView be;
    private View bf;
    private View bg;
    private ImageView bh;
    private View bi;
    private ImageView bj;
    private View bk;
    private ImageView bl;
    private TextView bm;
    private View bn;
    private ImageView bo;
    private View bp;
    private ImageView bq;
    private TextView br;
    private CardView bs;
    private RecyclerView bt;
    private CommonMultiItemAdapter<FeedTemplateModel> bu;
    private View bv;
    private BluedTopic bw;
    private SelectTopicViewModel bx;
    private List<FeedTemplateModel> by = new ArrayList();
    private List<FeedTemplateTitleModel> bz = new ArrayList();
    private BluedTopic bC = null;
    private boolean bD = false;
    private int bE = 0;
    private List<FeedIntroduceModel> bF = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.blued.community.ui.send.fragment.FeedAddPostFragment$1  reason: invalid class name */
    /* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/send/fragment/FeedAddPostFragment$1.class */
    public class AnonymousClass1 extends CommonMultiItemAdapter<FeedTemplateModel> {
        AnonymousClass1() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(FeedTemplateModel feedTemplateModel, View view) {
            if (feedTemplateModel.isSelected()) {
                return;
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= getData().size()) {
                    feedTemplateModel.setSelected(true);
                    FeedAddPostFragment.this.bu.notifyDataSetChanged();
                    FeedAddPostFragment.this.bA = feedTemplateModel;
                    FeedAddPostFragment.this.at();
                    return;
                }
                ((FeedTemplateModel) getData().get(i2)).setSelected(false);
                i = i2 + 1;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: a */
        public void onConvert(CommonViewHolder commonViewHolder, final FeedTemplateModel feedTemplateModel, int i) {
            commonViewHolder.setImageUrl(R.id.item_feed_add_template_img, feedTemplateModel.getBackground_img(), 6.0f);
            commonViewHolder.setVisibility(R.id.item_feed_add_template_select, feedTemplateModel.isSelected() ? 0 : 8);
            commonViewHolder.setConvertViewOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.send.fragment.-$$Lambda$FeedAddPostFragment$1$5W_HfyowVTJEE6IcB8Dgw4CrgK4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FeedAddPostFragment.AnonymousClass1.this.a(feedTemplateModel, view);
                }
            });
            if (feedTemplateModel.isShowed()) {
                return;
            }
            EventTrackFeed.k(FeedProtos.Event.FEED_PUBLISH_PIC_TEMP_SHOW, "", feedTemplateModel.getP_id());
            feedTemplateModel.setShowed(true);
        }

        public void onAddItemType() {
            addItemType(0, R.layout.item_feed_add_template_layout);
        }
    }

    private void E() {
        this.aT = (FlowLayout) this.j.findViewById(R.id.flow_super_topic);
        FeedPostVoteView feedPostVoteView = (FeedPostVoteView) this.j.findViewById(R.id.feed_post_vote_view_id);
        this.bd = feedPostVoteView;
        feedPostVoteView.setOwnFragment(this);
        LinearLayout linearLayout = (LinearLayout) this.j.findViewById(R.id.layout_super_topic);
        this.b = linearLayout;
        linearLayout.setVisibility(0);
        this.aO = (ShapeLinearLayout) this.j.findViewById(R.id.layout_select_super_topic);
        this.aP = (ImageView) this.j.findViewById(R.id.iv_super_topic);
        this.aQ = (TextView) this.j.findViewById(R.id.tv_super_topic);
        if (CommunityServiceManager.a().D() == 1) {
            if (CommunityManager.a.a().s()) {
                this.aP.setImageResource(R.drawable.feed_post_subject_icon);
            } else {
                this.aP.setImageResource(R.drawable.feed_post_subject_icon_dark);
            }
            this.aQ.setText("添加主题");
        } else {
            this.aP.setImageResource(R.drawable.feed_post_super_topic);
            this.aQ.setText(R.string.feed_post_super_topic);
        }
        this.b.setOnClickListener(new SingleClickProxy(new View.OnClickListener() { // from class: com.blued.community.ui.send.fragment.-$$Lambda$FeedAddPostFragment$wN2GzELnrLAut3dFiqtM-THDPSQ
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedAddPostFragment.this.g(view);
            }
        }));
        this.aO.setOnClickListener(new SingleClickProxy(new View.OnClickListener() { // from class: com.blued.community.ui.send.fragment.-$$Lambda$FeedAddPostFragment$S-WzF6adjnBnTrRTVwFyGFsY0XE
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedAddPostFragment.this.f(view);
            }
        }));
        RecyclerView findViewById = this.j.findViewById(R.id.rv_topic);
        this.aR = findViewById;
        findViewById.setLayoutManager(new LinearLayoutManager(this.c, 0, false));
        FeedPostTopicAdapter feedPostTopicAdapter = new FeedPostTopicAdapter(this.aL);
        this.aS = feedPostTopicAdapter;
        feedPostTopicAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() { // from class: com.blued.community.ui.send.fragment.-$$Lambda$FeedAddPostFragment$6pA9sH_r7lpvNquPWDxafD0aWdw
            public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                FeedAddPostFragment.this.a(baseQuickAdapter, view, i);
            }
        });
        this.aR.setAdapter(this.aS);
        this.aT.setVisibility(this.bD ? 0 : 8);
        this.b.setVisibility(this.bD ? 0 : 8);
    }

    private void F() {
        this.bn = this.j.findViewById(R.id.feed_add_post_template_bg_layout);
        this.bo = (ImageView) this.j.findViewById(R.id.feed_add_post_template_bg);
        this.bp = this.j.findViewById(R.id.feed_add_post_template_title_layout_id);
        ImageView imageView = (ImageView) this.j.findViewById(R.id.feed_add_post_template_close);
        this.bq = imageView;
        imageView.setOnClickListener(new SingleClickProxy(new View.OnClickListener() { // from class: com.blued.community.ui.send.fragment.-$$Lambda$FeedAddPostFragment$elb0v-_HK1kEm9QTujhbF--PVE0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedAddPostFragment.this.e(view);
            }
        }));
        this.br = (TextView) this.j.findViewById(R.id.feed_add_post_template_title_tv);
        CardView findViewById = this.j.findViewById(R.id.feed_add_post_template_change);
        this.bs = findViewById;
        findViewById.setOnClickListener(new SingleClickProxy(new View.OnClickListener() { // from class: com.blued.community.ui.send.fragment.-$$Lambda$FeedAddPostFragment$ysS3au2oG2mcZxJJbJ9QO0mTW94
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedAddPostFragment.this.d(view);
            }
        }));
        RecyclerView findViewById2 = this.j.findViewById(R.id.feed_add_post_template_rv);
        this.bt = findViewById2;
        findViewById2.setLayoutManager(new LinearLayoutManager(this.c, 0, false));
        AnonymousClass1 anonymousClass1 = new AnonymousClass1();
        this.bu = anonymousClass1;
        this.bt.setAdapter(anonymousClass1);
    }

    public static void a(Context context) {
        a(context, false);
    }

    public static void a(Context context, ShareEntity shareEntity) {
        a(context, shareEntity, (String) null, (String) null);
    }

    public static void a(Context context, ShareEntity shareEntity, String str, String str2) {
        a(context, shareEntity, str, str2, false, 0);
    }

    public static void a(Context context, ShareEntity shareEntity, String str, String str2, boolean z, int i) {
        a(context, shareEntity, str, str2, z, i, false, false);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public static void a(Context context, ShareEntity shareEntity, String str, String str2, boolean z, int i, boolean z2, boolean z3) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    public static void a(Context context, StvResultModel stvResultModel) {
        if (CommunityServiceManager.a().b(context)) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putSerializable("music_video_data", stvResultModel);
        TerminalActivity.d(context, FeedAddPostFragment.class, bundle);
    }

    public static void a(Context context, NewFeedModel newFeedModel) {
        if (CommunityServiceManager.a().b(context)) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putSerializable("feed_send_data", newFeedModel);
        TerminalActivity.d(context, FeedAddPostFragment.class, bundle);
    }

    public static void a(Context context, BluedIngSelfFeed bluedIngSelfFeed) {
        if (CommunityServiceManager.a().b(context)) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putSerializable("feed_data", bluedIngSelfFeed);
        TerminalActivity.d(context, FeedAddPostFragment.class, bundle);
    }

    public static void a(Context context, MyCircleModel myCircleModel) {
        if (CommunityServiceManager.a().b(context) || myCircleModel == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putSerializable("share_circle_key", myCircleModel);
        TerminalActivity.d(context, FeedAddPostFragment.class, bundle);
    }

    public static void a(Context context, EventDetailsModel eventDetailsModel) {
        if (CommunityServiceManager.a().b(context) || eventDetailsModel == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putSerializable("share_event_key", eventDetailsModel);
        TerminalActivity.d(context, FeedAddPostFragment.class, bundle);
    }

    public static void a(Context context, BluedTopic bluedTopic) {
        if (CommunityServiceManager.a().b(context) || bluedTopic == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putSerializable("super_topic_param", bluedTopic);
        NewFeedModel newFeedModel = null;
        for (NewFeedModel newFeedModel2 : NewFeedDao.a().c()) {
            if (TextUtils.isEmpty(newFeedModel2.circle_id) && newFeedModel2.is_draft == 1) {
                newFeedModel = newFeedModel2;
            }
        }
        if (newFeedModel != null) {
            bundle.putSerializable("feed_send_data", newFeedModel);
        }
        TerminalActivity.d(context, FeedAddPostFragment.class, bundle);
    }

    public static void a(Context context, CommBundleBuilder commBundleBuilder) {
        if (CommunityServiceManager.a().b(context) || FeedMethods.b(context)) {
            return;
        }
        Bundle bundle = new Bundle();
        if (commBundleBuilder != null) {
            bundle.putAll(commBundleBuilder.a());
        }
        TerminalActivity.d(context, FeedAddPostFragment.class, bundle);
    }

    public static void a(Context context, boolean z) {
        if (CommunityServiceManager.a().b(context) || FeedMethods.b(context)) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_attention_show_dot", z);
        TerminalActivity.d(context, FeedAddPostFragment.class, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(DialogInterface dialogInterface, int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.ac.getData().size()) {
                this.ac.a();
                this.o.setText("");
                this.bd.a();
                aq();
                ah();
                au();
                return;
            }
            SelectPhotoManager.a().b((ChildImageInfo) this.ac.getData().get(i3));
            AlbumSelectInfo albumSelectInfo = (AlbumSelectInfo) this.az.f().getValue();
            if (albumSelectInfo != null) {
                albumSelectInfo.a(((ChildImageInfo) this.ac.getData().get(i3)).mImagePath);
                this.az.h().setValue(((ChildImageInfo) this.ac.getData().get(i3)).mImagePath);
            }
            i2 = i3 + 1;
        }
    }

    public static void a(Fragment fragment, String str, String str2, int i) {
        if (CommunityServiceManager.a().b(fragment.getContext())) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("super_topic_avatar", str);
        bundle.putString("super_topic_name", str2);
        bundle.putBoolean("is_back", true);
        TerminalActivity.a(fragment, FeedAddPostFragment.class, bundle, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AttentionFeedPostGuideModel attentionFeedPostGuideModel) {
        LogUtils.c("个人主页进入发布引导--> showGuideModelForUserPage");
        if (attentionFeedPostGuideModel == null) {
            return;
        }
        FeedTemplateTitleModel a = FeedMethods.a(attentionFeedPostGuideModel.getQuestionnaire_data(), "个人主页进入发布引导");
        BluedTopic bluedTopic = null;
        if (a == null) {
            BluedTopic b = FeedMethods.b(attentionFeedPostGuideModel.getAdmin_topic_data(), "个人主页进入发布引导");
            bluedTopic = b;
            if (a != null) {
                EventTrackFeed.a(FeedProtos.Event.FEED_PUBLISH_TOPIC_SHOW, b.super_did, this.aL);
                bluedTopic = b;
            }
        }
        if (this.bE != 0 && this.bd.getVisibility() != 0) {
            LogUtils.c("个人主页进入发布引导--> templateFeedType: " + this.bE);
        } else if (a != null) {
            au();
            this.bB = a;
            this.br.setText(a.getText());
            CommunityPreferences.a("FeedAddPostUserPageGuideShow", TimeAndDateUtils.b());
        }
        if (bluedTopic == null || aU.size() >= 3) {
            return;
        }
        b(bluedTopic);
        CommunityPreferences.a("FeedAddPostUserPageGuideShow", TimeAndDateUtils.b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(BaseQuickAdapter baseQuickAdapter, View view, int i) {
        if (view.getId() == R.id.root_layout) {
            BluedTopic bluedTopic = (BluedTopic) this.aS.getData().get(i);
            d(bluedTopic);
            this.aS.notifyDataSetChanged();
            EventTrackFeed.f(FeedProtos.Event.FEED_PUBLISH_TOPIC_CLICK, bluedTopic.super_did);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Boolean bool) {
        aF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(boolean z, DialogInterface dialogInterface) {
        c(z);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x024e  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x029f A[ADDED_TO_REGION, ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String aA() {
        /*
            Method dump skipped, instructions count: 686
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.community.ui.send.fragment.FeedAddPostFragment.aA():java.lang.String");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aB */
    public void aK() {
        if (CommunityPreferences.aa() == 0) {
            int[] iArr = new int[2];
            this.Q.getLocationInWindow(iArr);
            if (iArr[1] > AppInfo.m - FeedMethods.c(100)) {
                return;
            }
            FeedGuidePop feedGuidePop = new FeedGuidePop(this.c, getString(R.string.feed_post_introduce_guide_text), NinePatchUtils.GuideArrowPosition.RIGHT, false, 0, (String) null, 0, 0, 0);
            this.bJ = feedGuidePop;
            feedGuidePop.setTopPadding(FeedMethods.a(9.5f));
            this.bJ.setBottomPadding(FeedMethods.a(8.5f));
            this.bJ.setOffsetX(FeedMethods.c(10));
            this.bJ.setOffsetY(FeedMethods.c(-10));
            FeedGuidePop.t.b(this.bJ, new SimpleCallback(), this.be, 0L);
            CommunityPreferences.Z();
        } else if (CommunityPreferences.aa() == 1) {
            this.aZ.setVisibility(0);
            this.ba.setText(R.string.feed_post_template_note);
            CommunityPreferences.Z();
        } else if (CommunityPreferences.aa() == 2) {
            this.aZ.setVisibility(0);
            this.ba.setText(R.string.feed_post_self_introduce);
            CommunityPreferences.Z();
        } else if (CommunityPreferences.aa() == 3) {
            this.aZ.setVisibility(0);
            this.ba.setText(R.string.feed_post_vote);
            CommunityPreferences.Z();
        }
    }

    private void aC() {
        this.aZ.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aD */
    public void aI() {
        this.bb.setVisibility(8);
        af();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aE() {
        LogUtils.c("过审率低发布引导--> showGuideForUserPageAudit: ");
        this.ac.a(true);
        this.bv.setVisibility(0);
    }

    private void aF() {
        this.ac.a(false);
        this.bv.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void aH() {
        c(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void aJ() {
        this.o.setFocusableInTouchMode(true);
        this.o.setFocusable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ai() {
        return this.aK == 8 || this.aK == 10 || this.aK == 11 || this.aK == 12 || this.aK == 16;
    }

    private void aj() {
        if (CommunityServiceManager.a().D() == 1) {
            if (CommunityManager.a.a().s()) {
                this.aP.setImageResource(R.drawable.feed_post_subject_icon);
            } else {
                this.aP.setImageResource(R.drawable.feed_post_subject_icon_dark);
            }
            this.aQ.setText("添加主题");
        } else {
            this.aP.setImageResource(R.drawable.feed_post_super_topic);
            this.aQ.setText(R.string.feed_post_super_topic);
        }
        ShapeHelper.b(this.aO, R.color.syc_x);
        this.ad = false;
        ViewUtils.a(this.c, aU, this.aT, false, new ViewUtils.ITopicListener() { // from class: com.blued.community.ui.send.fragment.FeedAddPostFragment.2
            public void a(View view) {
            }

            public void a(BluedTopic bluedTopic) {
                FeedAddPostFragment.this.a(bluedTopic.super_did, bluedTopic.name);
            }
        }, false);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= aU.size()) {
                break;
            }
            if (aU.get(i2).is_anonym == 1) {
                this.ad = true;
            }
            i = i2 + 1;
        }
        List data = this.aS.getData();
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= data.size()) {
                break;
            }
            if (a((BluedTopic) data.get(i4)) >= 0) {
                ((BluedTopic) data.get(i4)).is_chosen = true;
            } else {
                ((BluedTopic) data.get(i4)).is_chosen = false;
            }
            i3 = i4 + 1;
        }
        this.aS.notifyDataSetChanged();
        if (this.ad && this.aa != null && this.aa.getDialog() != null && this.aa.getDialog().isShowing()) {
            this.aa.dismissAllowingStateLoss();
        }
        am();
    }

    private void ak() {
        if (this.ag == null || this.ag.repost == null || this.ag.repost.is_vote != 1) {
            b(this.bw);
            this.R.setAlpha(0.3f);
            this.S.setAlpha(0.3f);
            this.V.setAlpha(0.3f);
            ag();
            this.bd.setVisibility(0);
            SelectPhotoManager.a().d();
            this.ab.setVisibility(8);
            d("showVoteWidget");
            this.o.setCursorVisible(false);
            this.o.clearFocus();
            this.o.setFocusableInTouchMode(false);
            this.o.setFocusable(false);
            if (TextUtils.isEmpty(this.o.getText().toString().trim())) {
                this.o.setText(R.string.feed_vote_content_default);
            }
            if (this.aa != null && this.aa.getDialog() != null && this.aa.getDialog().isShowing()) {
                this.aa.dismissAllowingStateLoss();
            }
            postDelaySafeRunOnUiThread(new Runnable() { // from class: com.blued.community.ui.send.fragment.-$$Lambda$FeedAddPostFragment$RXC3l2TJ5xHyXLKJNbIXSLkvN38
                @Override // java.lang.Runnable
                public final void run() {
                    FeedAddPostFragment.this.aJ();
                }
            }, 100L);
        }
    }

    private void al() {
        if (V() || W()) {
            return;
        }
        final boolean z = this.ae;
        d("onClickSelectSuperTopic");
        this.W.setVisibility(8);
        EventTrackFeed.a(FeedProtos.Event.SUPER_TOPIC_SEARCH_SHOW);
        EventTrackFeed.a(FeedProtos.Event.FEED_PUBLISH_ADD_TOPIC_CLICK);
        SelectTopicDialogFragment a = SelectTopicDialogFragment.a.a(getFragmentManager(), this.bd.getVisibility() == 0, this.bE);
        a.a(new DialogInterface.OnDismissListener() { // from class: com.blued.community.ui.send.fragment.-$$Lambda$FeedAddPostFragment$k-lbMKynBnI2LdKCvDDW41ZREnA
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                FeedAddPostFragment.this.a(z, dialogInterface);
            }
        });
        a.a(new SelectTopicDialogFragment.OnTopicListener() { // from class: com.blued.community.ui.send.fragment.-$$Lambda$FeedAddPostFragment$w9kRqdBTpHIPU8_drKnnajbZOnE
            @Override // com.blued.community.ui.send.dialog.SelectTopicDialogFragment.OnTopicListener
            public final boolean chooseTopic(BluedTopic bluedTopic) {
                boolean d;
                d = FeedAddPostFragment.this.d(bluedTopic);
                return d;
            }
        });
    }

    private void am() {
        int i = 8;
        if (this.ad) {
            this.Y.setVisibility(8);
            this.T.setImageDrawable(BluedSkinUtils.b(this.c, R.drawable.feed_post_not_at));
            this.T.setOnClickListener(new SingleClickProxy(new View.OnClickListener() { // from class: com.blued.community.ui.send.fragment.FeedAddPostFragment.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    AppMethods.d(R.string.feed_post_anonymous_at_toast);
                }
            }));
        } else {
            CheckBox checkBox = this.Y;
            if (this.ap) {
                i = 0;
            }
            checkBox.setVisibility(i);
            if (CommunityManager.a.a().s()) {
                this.T.setImageResource(R.drawable.feed_post_tools_at_dark);
            } else {
                this.T.setImageResource(R.drawable.feed_post_tools_at);
            }
            this.T.setOnClickListener(new SingleClickProxy(this));
        }
        this.o.setHint(G());
        R();
    }

    private boolean an() {
        FeedPostVoteView feedPostVoteView = this.bd;
        return feedPostVoteView != null && feedPostVoteView.getVisibility() == 0;
    }

    private boolean ao() {
        return (this.bH == null || this.o.getText().toString().equals(this.bH.getDescribe())) ? false : true;
    }

    private void ap() {
        if (getString(R.string.feed_post_self_introduce_change).equalsIgnoreCase(this.bm.getText().toString())) {
            this.bE = 2;
            if (ao()) {
                CommonAlertDialog.a(this.c, getString(R.string.feed_post_introduce_change_title), getString(R.string.feed_post_introduce_change_des), getString(R.string.common_change), getResources().getColor(R.color.syc_g), new DialogInterface.OnClickListener() { // from class: com.blued.community.ui.send.fragment.-$$Lambda$FeedAddPostFragment$yS4kGppB40cE_FDHJJ9_poKNvwc
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        FeedAddPostFragment.this.c(dialogInterface, i);
                    }
                }, getString(R.string.common_cancel), BluedSkinUtils.a(this.c, R.color.syc_h), (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
            } else {
                ar();
            }
        } else if (!TextUtils.isEmpty(this.o.getText().toString()) || this.bd.getVisibility() == 0 || this.bE == 1) {
            CommonAlertDialog.a(this.c, (String) null, getString(R.string.feed_post_template_confirm_tips), getString(R.string.common_drop), getResources().getColor(R.color.syc_g), new DialogInterface.OnClickListener() { // from class: com.blued.community.ui.send.fragment.-$$Lambda$FeedAddPostFragment$MtUafxWkx4XtCR6cWY0yyKxYC4c
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    FeedAddPostFragment.this.b(dialogInterface, i);
                }
            }, getString(R.string.common_cancel), BluedSkinUtils.a(this.c, R.color.syc_h), (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
        } else {
            ar();
        }
    }

    private void aq() {
        this.bE = 0;
        this.o.setText("");
        this.bH = null;
        this.bm.setText(R.string.feed_post_self_introduce);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ar() {
        int i;
        this.bE = 2;
        this.bm.setText(R.string.feed_post_self_introduce_change);
        int af = CommunityPreferences.af();
        if (this.bF.size() > 0) {
            if (this.bF.size() != 1) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                int size = this.bF.size();
                while (true) {
                    int i2 = (int) (elapsedRealtime % size);
                    i = i2;
                    if (this.bF.get(i2).getId() != af) {
                        break;
                    }
                    elapsedRealtime = SystemClock.elapsedRealtime();
                    size = this.bF.size();
                }
            } else {
                i = 0;
            }
            FeedIntroduceModel feedIntroduceModel = this.bF.get(i);
            this.bH = feedIntroduceModel;
            this.aD = String.valueOf(feedIntroduceModel.getId());
            CommunityPreferences.h(this.bH.getId());
            this.o.setText(this.bH.getDescribe());
            b(this.bG);
            this.o.setSelection(0);
        } else if (!TextUtils.isEmpty(this.o.getText().toString())) {
            this.o.setText("");
        }
        if (CommunityPreferences.ab()) {
            CommunityPreferences.ac();
            ToastUtils.a(R.string.feed_post_introduce_click_to_change);
        }
        if (this.bH != null) {
            EventTrackFeed.m(FeedProtos.Event.FEED_PUBLISH_DESC_TEMP_SHOW, String.valueOf(this.bH.getId()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void as() {
        int i;
        if (ai() && !TextUtils.isEmpty(this.bc)) {
            this.br.setText(this.bc);
        } else if (this.bz.size() > 0) {
            int Y = CommunityPreferences.Y();
            int i2 = 0;
            while (true) {
                int i3 = i2;
                i = -1;
                if (i3 >= this.bz.size()) {
                    break;
                } else if (this.bz.get(i3).getP_id() == Y) {
                    i = i3;
                    break;
                } else {
                    i2 = i3 + 1;
                }
            }
            int i4 = 0;
            if (i >= 0) {
                i4 = i + 1;
                if (i4 >= this.bz.size()) {
                    i4 = 0;
                }
            }
            FeedTemplateTitleModel feedTemplateTitleModel = this.bz.get(i4);
            this.bB = feedTemplateTitleModel;
            this.br.setText(feedTemplateTitleModel.getText());
            CommunityPreferences.g(this.bB.getP_id());
            this.aB = String.valueOf(this.bB.getP_id());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void at() {
        if (this.bA == null && this.by.size() > 0) {
            this.by.get(0).setSelected(true);
            this.bA = this.by.get(0);
        }
        if (this.bA == null) {
            this.bo.setImageResource(R.drawable.feed_photo_default);
            return;
        }
        ImageLoader.a(getFragmentActive(), this.bA.getBackground_img()).d(R.drawable.feed_photo_default).a(this.bo);
        this.aC = this.bA.getP_id();
    }

    private void au() {
        if (U()) {
            AppMethods.a((CharSequence) "转发动态，该功能不可使用");
        } else if (this.bE != 1) {
            if (!TextUtils.isEmpty(this.o.getText().toString()) || SelectPhotoManager.a().b() > 0 || this.bd.getVisibility() == 0 || (this.bE == 2 && ao())) {
                String str = null;
                String string = getString(R.string.feed_post_template_confirm_tips);
                if (this.bE == 2) {
                    if (!ao()) {
                        for (int i = 0; i < this.ac.getData().size(); i++) {
                            SelectPhotoManager.a().b((ChildImageInfo) this.ac.getData().get(i));
                            AlbumSelectInfo albumSelectInfo = (AlbumSelectInfo) this.az.f().getValue();
                            if (albumSelectInfo != null) {
                                albumSelectInfo.a(((ChildImageInfo) this.ac.getData().get(i)).mImagePath);
                                this.az.h().setValue(((ChildImageInfo) this.ac.getData().get(i)).mImagePath);
                            }
                        }
                        this.ac.a();
                        this.o.setText("");
                        this.bd.a();
                        aq();
                        ah();
                        au();
                        return;
                    }
                    str = getString(R.string.feed_post_introduce_drop_title);
                    string = getString(R.string.feed_post_introduce_drop_des);
                }
                CommonAlertDialog.a(this.c, str, string, getString(R.string.common_drop), getResources().getColor(R.color.syc_g), new DialogInterface.OnClickListener() { // from class: com.blued.community.ui.send.fragment.-$$Lambda$FeedAddPostFragment$EuyW4cBoBMDfjvNdMpKuzVsGaCw
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        FeedAddPostFragment.this.a(dialogInterface, i2);
                    }
                }, getString(R.string.common_cancel), BluedSkinUtils.a(this.c, R.color.syc_h), (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
                return;
            }
            this.bE = 1;
            ag();
            this.bn.setVisibility(0);
            at();
            this.bp.setVisibility(0);
            this.p.setVisibility(8);
            this.bt.setVisibility(0);
            this.o.setPadding(FeedMethods.c(24), FeedMethods.c(10), FeedMethods.c(24), 0);
            this.o.setText("");
            this.o.setHintTextColor(Color.parseColor("#66FFFFFF"));
            this.o.setHint(G());
            this.o.setTextColor(-1);
            as();
            this.ab.setVisibility(8);
            this.aV.setOrientation(0);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.bn.getLayoutParams();
            marginLayoutParams.height = AppInfo.l - FeedMethods.c(30);
            this.bn.setLayoutParams(marginLayoutParams);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.K.getLayoutParams();
            if (this.bD) {
                ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) this.b.getLayoutParams();
                marginLayoutParams3.width = -2;
                this.b.setLayoutParams(marginLayoutParams3);
                this.aR.setVisibility(8);
                marginLayoutParams2.leftMargin = 0;
            } else {
                marginLayoutParams2.leftMargin = FeedMethods.c(15);
            }
            marginLayoutParams2.width = -2;
            ViewGroup.MarginLayoutParams marginLayoutParams4 = (ViewGroup.MarginLayoutParams) this.L.getLayoutParams();
            marginLayoutParams4.width = FeedMethods.c(91);
            this.L.setLayoutParams(marginLayoutParams4);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.N.getLayoutParams();
            layoutParams.width = 0;
            layoutParams.weight = 1.0f;
            this.N.setLayoutParams(layoutParams);
            this.P.setWidthParam(FeedMethods.c(91));
            this.P.setContentTextLpType(1);
            this.K.setLayoutParams(marginLayoutParams2);
            this.J.setVisibility(8);
            this.aW.setVisibility(8);
            this.aX.setVisibility(0);
            this.aY.setVisibility(0);
            this.Q.setVisibility(8);
            this.q.setEditMaxLength(126);
            b(this.bC);
            if (this.aa != null && this.aa.isAdded() && this.aa.getDialog() != null && this.aa.getDialog().isShowing()) {
                this.aa.dismissAllowingStateLoss();
            }
            postDelaySafeRunOnUiThread(new Runnable() { // from class: com.blued.community.ui.send.fragment.-$$Lambda$FeedAddPostFragment$pvLgcewcXngg_fTMwvHEBR0f8_8
                @Override // java.lang.Runnable
                public final void run() {
                    FeedAddPostFragment.this.aH();
                }
            }, 100L);
            if (this.bB != null) {
                EventTrackFeed.b(FeedProtos.Event.FEED_PUBLISH_QA_SHOW, String.valueOf(this.bB.getP_id()), "", this.aL);
            }
        }
    }

    private void av() {
        this.bE = 0;
        ag();
        this.bA = null;
        this.bn.setVisibility(8);
        this.bp.setVisibility(8);
        this.p.setVisibility(0);
        this.bt.setVisibility(8);
        this.o.setText("");
        this.o.setPadding(0, FeedMethods.c(10), 0, 0);
        this.o.setHint(R.string.feed_post_hint);
        this.o.setHintTextColor(BluedSkinUtils.a(this.c, R.color.syc_i));
        this.o.setTextColor(BluedSkinUtils.a(this.c, R.color.syc_h));
        this.o.setMaxLines(Integer.MAX_VALUE);
        this.ab.setVisibility(0);
        this.aV.setOrientation(1);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.K.getLayoutParams();
        marginLayoutParams.leftMargin = FeedMethods.c(15);
        marginLayoutParams.width = -1;
        this.K.setLayoutParams(marginLayoutParams);
        if (this.bD) {
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.b.getLayoutParams();
            marginLayoutParams2.width = -1;
            this.b.setLayoutParams(marginLayoutParams2);
            this.aR.setVisibility(0);
        }
        ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) this.L.getLayoutParams();
        marginLayoutParams3.width = -2;
        this.L.setLayoutParams(marginLayoutParams3);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.N.getLayoutParams();
        layoutParams.width = -2;
        layoutParams.weight = 1.0f;
        this.N.setLayoutParams(layoutParams);
        this.P.setWidthParam(-2);
        this.P.setContentTextLpType(0);
        this.J.setVisibility(0);
        this.aW.setVisibility(0);
        this.aX.setVisibility(8);
        this.aY.setVisibility(8);
        this.Q.setVisibility(0);
        this.q.setEditMaxLength(s());
        this.aB = "";
        this.aC = "";
    }

    private void aw() {
        ToastUtils.a(R.string.feed_post_template_is_added);
    }

    private void ax() {
        if (ai()) {
            this.bc = null;
        }
        as();
        this.o.setText("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ay() {
        if (this.aZ.getVisibility() == 0) {
            aC();
        }
        if (this.aI == 3) {
            KeyboardUtils.c(getActivity());
            return;
        }
        LogUtils.c("onClickFuncMore: " + this.ae);
        if (this.ae) {
            this.aJ = 3;
            d("onClickFuncMore");
            return;
        }
        ae();
        c(3);
    }

    private void az() {
        if (CommunityManager.a.a().s()) {
            this.be.setImageResource(R.drawable.feed_post_tools_func_icon_dark);
        } else {
            this.be.setImageResource(R.drawable.feed_post_tools_func_icon);
        }
    }

    public static void b(Context context, BluedTopic bluedTopic) {
        if (CommunityServiceManager.a().b(context) || bluedTopic == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putSerializable("super_topic_key", bluedTopic);
        TerminalActivity.d(context, FeedAddPostFragment.class, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(DialogInterface dialogInterface, int i) {
        this.bE = 2;
        this.bd.a();
        ah();
        av();
        ar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(DialogInterface dialogInterface, int i) {
        ar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public boolean d(BluedTopic bluedTopic) {
        if (a(bluedTopic) >= 0) {
            a(bluedTopic.super_did, bluedTopic.name);
            bluedTopic.is_chosen = false;
            return false;
        } else if (this.bE == 2 && (bluedTopic.is_support_vote == 1 || bluedTopic.is_questionnaire_topics == 1)) {
            ToastUtils.a(R.string.feed_post_introduce_can_not_use_this_topic);
            return false;
        } else if (this.bd.getVisibility() == 0 && (bluedTopic.is_questionnaire_topics == 1 || bluedTopic.back_topics_type == 3)) {
            ToastUtils.a("该主题在使用「投票」功能时，不可添加");
            return false;
        } else if (this.bE == 1 && (bluedTopic.is_support_vote == 1 || bluedTopic.back_topics_type == 3)) {
            ToastUtils.a("该主题在使用「便签」功能时，不可添加");
            return false;
        } else {
            boolean b = b(bluedTopic);
            if (b) {
                if (bluedTopic.back_topics_type == 3 && this.bd.getVisibility() != 0 && this.bE == 0) {
                    ar();
                }
                if (!U()) {
                    if (bluedTopic.is_support_vote == 1 && this.bd.getVisibility() != 0 && this.bE == 0) {
                        ak();
                    }
                    if (bluedTopic.is_questionnaire_topics == 1 && this.bd.getVisibility() != 0 && this.bE == 0) {
                        au();
                    }
                }
            }
            return b;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(DialogInterface dialogInterface, int i) {
        aq();
        j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(View view) {
        ax();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(View view) {
        av();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(View view) {
        al();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(View view) {
        al();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h(View view) {
        aI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i(View view) {
        aw();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j(View view) {
        ap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k(View view) {
        j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l(View view) {
        au();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m(View view) {
        ay();
    }

    public void A() {
        SelectPhotoManager.a().d();
        AlbumSelectInfo albumSelectInfo = (AlbumSelectInfo) this.az.f().getValue();
        if (albumSelectInfo != null) {
            albumSelectInfo.a();
        }
        this.o.setCursorVisible(true);
        this.o.setFocusableInTouchMode(true);
        this.o.setFocusable(true);
        this.R.setAlpha(1.0f);
        this.S.setAlpha(1.0f);
        this.V.setAlpha(1.0f);
    }

    public void B() {
        if (!an()) {
            this.ab.setVisibility(0);
            af();
        }
        S();
    }

    public void C() {
        NewFeedModel newFeedModel = null;
        for (NewFeedModel newFeedModel2 : NewFeedDao.a().c()) {
            if (TextUtils.isEmpty(newFeedModel2.circle_id) && newFeedModel2.is_draft == 1) {
                newFeedModel = newFeedModel2;
            }
        }
        if (newFeedModel != null) {
            Bundle bundle = new Bundle();
            bundle.putSerializable("feed_send_data", newFeedModel);
            setArguments(bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: D */
    public void aG() {
        FeedHttpUtils.a(new BluedUIHttpResponse<BluedEntity<BluedTopic, BluedTopicOuterExtra>>(getFragmentActive()) { // from class: com.blued.community.ui.send.fragment.FeedAddPostFragment.4
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<BluedTopic, BluedTopicOuterExtra> bluedEntity) {
                if (bluedEntity != null && bluedEntity.getSingleData() != null) {
                    List<BluedTopic> a = TopicMethods.a(bluedEntity.data, FeedAddPostFragment.this.bx.e());
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= a.size()) {
                            break;
                        }
                        int i3 = 0;
                        while (true) {
                            int i4 = i3;
                            if (i4 < FeedAddPostFragment.aU.size()) {
                                if (a.get(i2).name.equals(FeedAddPostFragment.aU.get(i4).name)) {
                                    a.get(i2).is_chosen = true;
                                    FeedAddPostFragment.aU.set(i4, a.get(i2));
                                }
                                i3 = i4 + 1;
                            }
                        }
                        i = i2 + 1;
                    }
                    FeedAddPostFragment.this.aS.setNewData(a);
                }
                if (bluedEntity.extra != null) {
                    FeedAddPostFragment.this.bw = bluedEntity.extra.getBack_topics_id();
                }
                if (FeedAddPostFragment.this.bw == null || FeedAddPostFragment.this.bd.getVisibility() != 0) {
                    return;
                }
                FeedAddPostFragment feedAddPostFragment = FeedAddPostFragment.this;
                feedAddPostFragment.b(feedAddPostFragment.bw);
            }
        }, getFragmentActive());
        FeedHttpUtils.b(new BluedUIHttpResponse<BluedEntityA<FeedTemplateTitleModel>>("feed_template_title", getFragmentActive()) { // from class: com.blued.community.ui.send.fragment.FeedAddPostFragment.5
            private void a(BluedEntityA<FeedTemplateTitleModel> bluedEntityA, boolean z) {
                if (bluedEntityA == null || !bluedEntityA.hasData()) {
                    return;
                }
                FeedAddPostFragment.this.bz.clear();
                FeedAddPostFragment.this.bz.addAll(bluedEntityA.data);
                if (FeedAddPostFragment.this.ai() && !TextUtils.isEmpty(FeedAddPostFragment.this.bc) && FeedAddPostFragment.this.bB == null) {
                    Iterator it = FeedAddPostFragment.this.bz.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        FeedTemplateTitleModel feedTemplateTitleModel = (FeedTemplateTitleModel) it.next();
                        if (FeedAddPostFragment.this.bc.equalsIgnoreCase(feedTemplateTitleModel.getText())) {
                            FeedAddPostFragment.this.bB = feedTemplateTitleModel;
                            EventTrackFeed.b(FeedProtos.Event.FEED_PUBLISH_QA_SHOW, String.valueOf(FeedAddPostFragment.this.bB.getP_id()), "", FeedAddPostFragment.this.aL);
                            break;
                        }
                    }
                }
                if (FeedAddPostFragment.this.bE == 1 && TextUtils.isEmpty(FeedAddPostFragment.this.br.getText().toString())) {
                    FeedAddPostFragment.this.as();
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUICache(BluedEntityA<FeedTemplateTitleModel> bluedEntityA) {
                super.onUICache(bluedEntityA);
                a(bluedEntityA, true);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: b */
            public void onUIUpdate(BluedEntityA<FeedTemplateTitleModel> bluedEntityA) {
                a(bluedEntityA, false);
            }
        });
        FeedHttpUtils.c(new BluedUIHttpResponse<BluedEntity<FeedTemplateModel, FeedTemplateExtra>>("feed_template_img", getFragmentActive()) { // from class: com.blued.community.ui.send.fragment.FeedAddPostFragment.6
            private void a(BluedEntity<FeedTemplateModel, FeedTemplateExtra> bluedEntity, boolean z) {
                if (bluedEntity != null && bluedEntity.hasData()) {
                    FeedAddPostFragment.this.by.clear();
                    FeedAddPostFragment.this.by.addAll(bluedEntity.data);
                    if (FeedAddPostFragment.this.bE == 1 && FeedAddPostFragment.this.bA == null) {
                        FeedAddPostFragment feedAddPostFragment = FeedAddPostFragment.this;
                        feedAddPostFragment.bA = (FeedTemplateModel) feedAddPostFragment.by.get(0);
                        ((FeedTemplateModel) FeedAddPostFragment.this.by.get(0)).setSelected(true);
                        FeedAddPostFragment.this.at();
                    }
                    FeedAddPostFragment.this.bu.setDataAndNotify(FeedAddPostFragment.this.by);
                }
                if (bluedEntity == null || bluedEntity.extra == null) {
                    return;
                }
                FeedAddPostFragment.this.bC = bluedEntity.extra.getQuestionnaire_topics();
                if (FeedAddPostFragment.this.bE == 1) {
                    FeedAddPostFragment feedAddPostFragment2 = FeedAddPostFragment.this;
                    feedAddPostFragment2.b(feedAddPostFragment2.bC);
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUICache(BluedEntity<FeedTemplateModel, FeedTemplateExtra> bluedEntity) {
                super.onUICache(bluedEntity);
                a(bluedEntity, true);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<FeedTemplateModel, FeedTemplateExtra> bluedEntity) {
                a(bluedEntity, false);
            }
        });
        FeedHttpUtils.d(new BluedUIHttpResponse<BluedEntity<FeedIntroduceModel, FeedIntroduceExtra>>("feed_introduce_text", getFragmentActive()) { // from class: com.blued.community.ui.send.fragment.FeedAddPostFragment.7
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<FeedIntroduceModel, FeedIntroduceExtra> bluedEntity) {
                if (bluedEntity != null && bluedEntity.hasData()) {
                    FeedAddPostFragment.this.bF.clear();
                    FeedAddPostFragment.this.bF.addAll(bluedEntity.data);
                    if (FeedAddPostFragment.this.bE == 2 || ((FeedAddPostFragment.this.bE == 0 && FeedAddPostFragment.this.bI != null && FeedAddPostFragment.this.bI.back_topics_type == 3) || FeedAddPostFragment.this.aK == 9 || FeedAddPostFragment.this.aK == 13)) {
                        FeedAddPostFragment.this.ar();
                    }
                }
                if (bluedEntity == null || bluedEntity.extra == null) {
                    return;
                }
                FeedAddPostFragment.this.bG = bluedEntity.extra.getOneself_topics();
                if (FeedAddPostFragment.this.bE == 2) {
                    FeedAddPostFragment feedAddPostFragment = FeedAddPostFragment.this;
                    feedAddPostFragment.b(feedAddPostFragment.bG);
                }
            }
        });
        long b = TimeAndDateUtils.b();
        LogUtils.c("个人主页进入发布引导 --> pageFrom=" + this.aL);
        if (this.aL == 11) {
            long t = CommunityPreferences.t("FeedAddPostUserPageGuideShow");
            LogUtils.c("个人主页进入发布引导 --> curWeek=" + b + ", lastShowWeek=" + t);
            if (b > t) {
                int v = CommunityPreferences.v("FeedAddPostUserPageGuideEnterCountDay");
                int v2 = CommunityPreferences.v("FeedAddPostUserPageGuideWeekEnterCount");
                LogUtils.c("个人主页进入发布引导 --> dayCount=" + v + ", weekCount=" + v2);
                if (v == 2 || v2 == 4) {
                    FeedHttpUtils.h(new BluedUIHttpResponse<BluedEntityA<AttentionFeedPostGuideModel>>(getFragmentActive()) { // from class: com.blued.community.ui.send.fragment.FeedAddPostFragment.8
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.blued.android.framework.http.BluedUIHttpResponse
                        /* renamed from: a */
                        public void onUIUpdate(BluedEntityA<AttentionFeedPostGuideModel> bluedEntityA) {
                            if (bluedEntityA == null || !bluedEntityA.hasData()) {
                                return;
                            }
                            LogUtils.c("个人主页进入发布引导 --> " + AppInfo.f().toJson(bluedEntityA));
                            FeedAddPostFragment.this.a(bluedEntityA.getSingleData());
                        }
                    }, getFragmentActive());
                }
            }
        }
        FeedHttpUtils.i(new BluedUIHttpResponse<BluedEntity<Object, FeedAddPostGuideAuditExtra>>(getFragmentActive()) { // from class: com.blued.community.ui.send.fragment.FeedAddPostFragment.9
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish(boolean z) {
                super.onUIFinish(z);
                if (z) {
                    CommunityPreferences.c("SendFeedFirstTime", false);
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<Object, FeedAddPostGuideAuditExtra> bluedEntity) {
                if (bluedEntity == null || bluedEntity.extra == null || bluedEntity.extra.getConform() != 1) {
                    return;
                }
                FeedAddPostFragment.this.aE();
            }
        }, getFragmentActive());
    }

    @Override // com.blued.community.ui.send.fragment.FeedAddPostBaseFragment
    protected String G() {
        return this.bE == 1 ? getString(R.string.feed_post_template_edit_hit) : this.ad ? getString(R.string.feed_post_anonym_hint) : super.G();
    }

    @Override // com.blued.community.ui.send.fragment.FeedAddPostBaseFragment
    protected int H() {
        return R.layout.fragment_feed_post_subject;
    }

    @Override // com.blued.community.ui.send.fragment.FeedAddPostBaseFragment
    protected void I() {
        super.ay();
        this.bx.a(this.j.getHeight());
    }

    @Override // com.blued.community.ui.send.fragment.FeedAddPostBaseFragment
    protected void K() {
        super.K();
        this.bx = (SelectTopicViewModel) new ViewModelProvider(getActivity().getViewModelStore(), new ViewModelProvider.AndroidViewModelFactory(getActivity().getApplication())).get(SelectTopicViewModel.class);
        LiveEventBus.get("never_show_audit_guide", Boolean.class).observe(this, new Observer() { // from class: com.blued.community.ui.send.fragment.-$$Lambda$FeedAddPostFragment$CslUVNHhlr03hv9dnIUsgS8hoEg
            public final void onChanged(Object obj) {
                FeedAddPostFragment.this.a((Boolean) obj);
            }
        });
    }

    @Override // com.blued.community.ui.send.fragment.FeedAddPostBaseFragment
    protected void L() {
        super.L();
        if (this.ar) {
            this.aR.setVisibility(8);
        } else {
            this.aR.setVisibility(0);
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    @Override // com.blued.community.ui.send.fragment.FeedAddPostBaseFragment
    protected void M() {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    @Override // com.blued.community.ui.send.fragment.FeedAddPostBaseFragment
    protected void N() {
        super.N();
        if (this.ah == null) {
            return;
        }
        String pics = this.ah.getPics();
        if (TextUtils.isEmpty(pics)) {
            return;
        }
        String[] split = pics.split(i.b);
        if (this.ah.is_vote == 1) {
            this.bd.setVisibility(0);
            if (split.length > 0) {
                this.bd.setPics(split);
            }
        }
    }

    @Override // com.blued.community.ui.send.fragment.FeedAddPostBaseFragment
    protected void P() {
        super.P();
        this.bx.c(!U());
    }

    @Override // com.blued.community.ui.send.fragment.FeedAddPostBaseFragment
    public void Q() {
        super.Q();
        E();
        ImageView imageView = (ImageView) this.j.findViewById(R.id.feed_post_tools_func);
        this.be = imageView;
        imageView.setVisibility(0);
        this.be.setOnClickListener(new SingleClickProxy(new View.OnClickListener() { // from class: com.blued.community.ui.send.fragment.-$$Lambda$FeedAddPostFragment$V4NEccsjUpje42hYJDU8G4qPiNo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedAddPostFragment.this.m(view);
            }
        }));
        this.V.setVisibility(8);
        this.bf = this.j.findViewById(R.id.feed_func_more_layout_id);
        View findViewById = this.j.findViewById(R.id.feed_func_more_template_id);
        this.bg = findViewById;
        findViewById.setOnClickListener(new SingleClickProxy(new View.OnClickListener() { // from class: com.blued.community.ui.send.fragment.-$$Lambda$FeedAddPostFragment$FvJyGc9o5ykb1bp-2Ih4B0Ohtd8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedAddPostFragment.this.l(view);
            }
        }));
        this.bh = (ImageView) this.j.findViewById(R.id.feed_func_more_template_iv);
        View findViewById2 = this.j.findViewById(R.id.feed_func_more_vote_id);
        this.bi = findViewById2;
        findViewById2.setOnClickListener(new SingleClickProxy(new View.OnClickListener() { // from class: com.blued.community.ui.send.fragment.-$$Lambda$FeedAddPostFragment$ZaQWqedsJYHmouB8xeQ0XSvzaws
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedAddPostFragment.this.k(view);
            }
        }));
        this.bj = (ImageView) this.j.findViewById(R.id.feed_func_more_vote_iv);
        View findViewById3 = this.j.findViewById(R.id.feed_func_more_introduce_id);
        this.bk = findViewById3;
        findViewById3.setOnClickListener(new SingleClickProxy(new View.OnClickListener() { // from class: com.blued.community.ui.send.fragment.-$$Lambda$FeedAddPostFragment$-B25HrOiGoP0H3Um7Ge8KaQ50Tc
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedAddPostFragment.this.j(view);
            }
        }));
        this.bl = (ImageView) this.j.findViewById(R.id.feed_func_more_introduce_iv);
        this.bm = (TextView) this.j.findViewById(R.id.feed_func_more_introduce_tv);
        this.aV = (LinearLayout) this.j.findViewById(R.id.layout_topic_location_and_auth);
        F();
        this.aW = this.j.findViewById(R.id.view_location_auth);
        this.aX = this.j.findViewById(R.id.view_auth_func_tools);
        ImageView imageView2 = (ImageView) this.j.findViewById(R.id.feed_post_tools_func_btn_gray_id);
        this.aY = imageView2;
        imageView2.setOnClickListener(new SingleClickProxy(new View.OnClickListener() { // from class: com.blued.community.ui.send.fragment.-$$Lambda$FeedAddPostFragment$Z2RgjUpP6JOT3YIvzUL6s1FJ3AQ
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedAddPostFragment.this.i(view);
            }
        }));
        this.aZ = this.j.findViewById(R.id.feed_post_tools_fun_guide_layout);
        this.ba = (TextView) this.j.findViewById(R.id.feed_post_tools_fun_guide_tv);
        View findViewById4 = this.j.findViewById(R.id.feed_add_introduce_guide_layout_id);
        this.bb = findViewById4;
        findViewById4.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.send.fragment.-$$Lambda$FeedAddPostFragment$hlecQfpo-ViDnraRh0TBsOrOFjI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedAddPostFragment.this.h(view);
            }
        });
        this.bv = this.j.findViewById(R.id.feed_post_guide_tips);
    }

    @Override // com.blued.community.ui.send.fragment.FeedAddPostBaseFragment
    protected void R() {
        if (!an()) {
            super.R();
            return;
        }
        this.ab.setVisibility(8);
        this.bd.c();
    }

    @Override // com.blued.community.ui.send.fragment.FeedAddPostBaseFragment
    protected boolean T() {
        if (this.bE == 2) {
            return ao();
        }
        if (this.bd.getVisibility() == 0 && this.bd.b()) {
            return true;
        }
        return super.T();
    }

    protected int a(BluedTopic bluedTopic) {
        int i;
        while (true) {
            int i2 = i;
            if (i2 < aU.size()) {
                BluedTopic bluedTopic2 = aU.get(i2);
                i = (StringUtils.a(bluedTopic.super_did, bluedTopic2.super_did) || StringUtils.a(bluedTopic.name, bluedTopic2.name)) ? 0 : i2 + 1;
                return i2;
            }
            return -1;
        }
    }

    @Override // com.blued.community.ui.send.fragment.FeedAddPostBaseFragment
    protected View a(MotionEvent motionEvent) {
        View a = super.a(motionEvent);
        if (a != null && a.getId() == this.aO.getId()) {
            a.setTag(102);
        }
        return a;
    }

    @Override // com.blued.community.ui.send.fragment.FeedAddPostBaseFragment
    protected NewFeedModel a(NewFeedModel newFeedModel) {
        if (newFeedModel != null) {
            if (this.bE == 1 && this.bA != null && this.bo.getDrawable() != null) {
                String aA = aA();
                if (TextUtils.isEmpty(aA)) {
                    super.a(newFeedModel);
                    return newFeedModel;
                }
                newFeedModel.is_questionnaire = 1;
                newFeedModel.localPath = aA;
                newFeedModel.setPics(aA);
                newFeedModel.setSize(1);
                newFeedModel.setContent("");
                return newFeedModel;
            } else if (an() && this.bd.b()) {
                newFeedModel.is_vote = 1;
                newFeedModel.localPath = this.bd.getLeftPicLocalPath();
                newFeedModel.setPics(this.bd.getPicPaths());
                newFeedModel.setSize(2);
                return newFeedModel;
            } else {
                super.a(newFeedModel);
            }
        }
        return newFeedModel;
    }

    @Override // com.blued.community.ui.send.fragment.FeedAddPostBaseFragment
    protected void a(Editable editable) {
        aF();
        if (this.bE == 2 && TextUtils.isEmpty(editable.toString())) {
            aq();
        }
        if (this.bE == 1 && editable.toString().length() > 126) {
            ToastUtils.a(R.string.feed_post_template_max_126_words);
            String substring = editable.toString().substring(0, 126);
            this.o.setText(substring);
            this.o.setSelection(substring.length());
            return;
        }
        StaticLayout a = FeedMethods.a(editable.toString(), this.o.getPaint(), AppInfo.l - FeedMethods.c(78), 1.0f, 1.1f);
        if (this.bE != 1 || a.getLineCount() <= 7) {
            super.a(editable);
            return;
        }
        ToastUtils.a(R.string.feed_post_template_max_7_lines);
        int lineEnd = a.getLineEnd(6) - 1;
        if (lineEnd > 0) {
            String substring2 = editable.toString().substring(0, lineEnd);
            this.o.setText(substring2);
            this.o.setSelection(substring2.length());
        }
    }

    @Override // com.blued.community.ui.send.fragment.FeedAddPostBaseFragment
    protected void a(View view) {
        if (view == null) {
            if (this.bd.getVisibility() != 0) {
                af();
            }
        } else if (view.getId() == this.aO.getId()) {
            view.callOnClick();
        } else if (view.getId() == this.be.getId()) {
            postDelaySafeRunOnUiThread(new Runnable() { // from class: com.blued.community.ui.send.fragment.-$$Lambda$FeedAddPostFragment$zVeM7KTNP5TL8p3afVkxtT7sY3A
                @Override // java.lang.Runnable
                public final void run() {
                    FeedAddPostFragment.this.ay();
                }
            }, 300L);
        } else {
            super.a(view);
        }
    }

    @Override // com.blued.community.ui.send.fragment.FeedAddPostBaseFragment
    protected void a(View view, MotionEvent motionEvent) {
        super.a(view, motionEvent);
        if (motionEvent.getAction() == 1 && this.bE == 2 && CommunityPreferences.ad()) {
            CommunityPreferences.ae();
            this.bb.setVisibility(0);
            postDelaySafeRunOnUiThread(new Runnable() { // from class: com.blued.community.ui.send.fragment.-$$Lambda$FeedAddPostFragment$Z6MTR7yW9c7FNjvMM_4yKzzN6aY
                @Override // java.lang.Runnable
                public final void run() {
                    FeedAddPostFragment.this.aI();
                }
            }, 2000L);
        }
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        SelectPhotoManager.a().a(str);
        AlbumSelectInfo albumSelectInfo = (AlbumSelectInfo) this.az.f().getValue();
        if (albumSelectInfo != null) {
            albumSelectInfo.a(str);
        }
    }

    protected void a(String str, String str2) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return;
        }
        ListIterator<BluedTopic> listIterator = aU.listIterator();
        while (listIterator.hasNext()) {
            BluedTopic next = listIterator.next();
            if (StringUtils.a(str, next.super_did) || StringUtils.a(str2, next.name)) {
                listIterator.remove();
            }
        }
        aj();
    }

    @Override // com.blued.community.ui.send.fragment.FeedAddPostBaseFragment
    protected boolean a(boolean z) {
        if (this.bd.b()) {
            return super.a(z);
        }
        return false;
    }

    @Override // com.blued.community.ui.send.fragment.FeedAddPostBaseFragment
    protected void aa() {
        super.aa();
        FeedTemplateTitleModel feedTemplateTitleModel = this.bB;
        if (feedTemplateTitleModel != null) {
            this.aB = String.valueOf(feedTemplateTitleModel.getP_id());
        }
        FeedTemplateModel feedTemplateModel = this.bA;
        if (feedTemplateModel != null) {
            this.aC = String.valueOf(feedTemplateModel.getP_id());
        }
        FeedIntroduceModel feedIntroduceModel = this.bH;
        if (feedIntroduceModel != null) {
            this.aD = String.valueOf(feedIntroduceModel.getId());
        }
    }

    @Override // com.blued.community.ui.send.fragment.FeedAddPostBaseFragment
    protected void aa_() {
        super.aa_();
        if (this.ac.c() > 0) {
            this.V.setAlpha(0.3f);
        } else {
            this.V.setAlpha(1.0f);
        }
    }

    @Override // com.blued.community.ui.send.fragment.FeedAddPostBaseFragment
    protected void ab_() {
        super.ab_();
        if (CommunityManager.a.a().s()) {
            this.V.setImageResource(R.drawable.feed_post_tools_vote_dark);
        } else {
            this.V.setImageResource(R.drawable.feed_post_tools_vote);
        }
    }

    @Override // com.blued.community.ui.send.fragment.FeedAddPostBaseFragment
    protected void ag() {
        super.ag();
        az();
    }

    @Override // com.blued.community.ui.send.fragment.FeedAddPostBaseFragment
    public void b(NewFeedModel newFeedModel) {
        super.b(newFeedModel);
        if (newFeedModel != null) {
            if (newFeedModel.is_vote == 1) {
                EventTrackVote.a(VoteProtos.Event.VOTE_PUBLISH_BTN_CLICK, VoteProtos.FeedType.VOTE);
            } else {
                EventTrackVote.a(VoteProtos.Event.VOTE_PUBLISH_BTN_CLICK, VoteProtos.FeedType.COMMON);
            }
        }
    }

    @Override // com.blued.community.ui.send.fragment.FeedAddPostBaseFragment
    protected void b(boolean z) {
        super.b(z);
        FeedGuidePop feedGuidePop = this.bJ;
        if (feedGuidePop == null || feedGuidePop.r == null || !this.bJ.r.isShowing()) {
            return;
        }
        this.bJ.p();
    }

    protected boolean b(BluedTopic bluedTopic) {
        if (bluedTopic == null) {
            return false;
        }
        if (a(bluedTopic) >= 0) {
            bluedTopic.is_chosen = true;
            return true;
        } else if (aU.size() < 3) {
            bluedTopic.is_chosen = true;
            aU.add(bluedTopic);
            aj();
            return true;
        } else {
            if (CommunityServiceManager.a().D() == 1) {
                AppMethods.a((CharSequence) "最多可以选择3个主题");
            } else {
                AppMethods.d(R.string.no_more_than_3_topics);
            }
            bluedTopic.is_chosen = false;
            return false;
        }
    }

    @Override // com.blued.community.ui.send.fragment.FeedAddPostBaseFragment
    protected void c(int i) {
        this.aI = i;
        az();
        super.c(i);
        if (i != 3) {
            this.bf.setVisibility(8);
            return;
        }
        this.be.setImageDrawable(BluedSkinUtils.b(this.c, R.drawable.feed_post_keyboard));
        this.bf.setVisibility(0);
        if (CommunityManager.a.a().s()) {
            this.bh.setImageResource(R.drawable.feed_post_tools_template_icon_dark);
            this.bj.setImageResource(R.drawable.feed_post_tools_vote_icon_dark);
            this.bl.setImageResource(R.drawable.feed_post_tools_introduce_icon_dark);
            return;
        }
        this.bh.setImageResource(R.drawable.feed_post_tools_template_icon);
        this.bj.setImageResource(R.drawable.feed_post_tools_vote_icon);
        this.bl.setImageResource(R.drawable.feed_post_tools_introduce_icon);
    }

    @Override // com.blued.community.ui.send.fragment.FeedAddPostBaseFragment
    protected void i() {
        BluedTopic bluedTopic = this.bI;
        if ((bluedTopic != null && bluedTopic.back_topics_type == 3) || this.aK == 9 || this.aK == 13) {
            ar();
            af();
            return;
        }
        BluedTopic bluedTopic2 = this.bI;
        if ((bluedTopic2 != null && bluedTopic2.is_questionnaire_topics == 1) || (ai() && !TextUtils.isEmpty(this.bc))) {
            au();
            return;
        }
        BluedTopic bluedTopic3 = this.bI;
        if (bluedTopic3 != null && bluedTopic3.is_support_vote == 1) {
            ak();
            return;
        }
        super.ax();
        postDelaySafeRunOnUiThread(new Runnable() { // from class: com.blued.community.ui.send.fragment.-$$Lambda$FeedAddPostFragment$KGFnLW6Rlts9Y5k76aNHjz-yHNk
            @Override // java.lang.Runnable
            public final void run() {
                FeedAddPostFragment.this.aK();
            }
        }, 500L);
    }

    @Override // com.blued.community.ui.send.fragment.FeedAddPostBaseFragment
    protected void j() {
        if (an()) {
            AppMethods.d(R.string.feed_post_can_not_vote_again);
        } else if (this.ac.f() > 0 || this.av || this.ap || this.ao) {
            AppMethods.d(R.string.feed_post_is_image_not_vote);
        } else if (q() || X()) {
        } else {
            if (this.ag == null || this.ag.repost == null || this.ag.repost.is_vote != 1) {
                if (this.bE == 2 && ao()) {
                    CommonAlertDialog.a(this.c, getString(R.string.feed_post_introduce_drop_title), getString(R.string.feed_post_introduce_drop_des), getString(R.string.common_drop), getResources().getColor(R.color.syc_g), new DialogInterface.OnClickListener() { // from class: com.blued.community.ui.send.fragment.-$$Lambda$FeedAddPostFragment$ass3tpoCzH_ysHtGOJ0QWgD4InI
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            FeedAddPostFragment.this.d(dialogInterface, i);
                        }
                    }, getString(R.string.common_cancel), BluedSkinUtils.a(this.c, R.color.syc_h), (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
                    return;
                }
                aq();
                ak();
                EventTrackVote.a(VoteProtos.Event.VOTE_BTN_CLICK);
            }
        }
    }

    public void k() {
        this.W.setVisibility(8);
        this.aa = AlbumSelectDialogFragment.a.a(getActivity(), 4, 1, 2, 109, false);
        this.Z = false;
        this.aa.a((DialogInterface.OnDismissListener) null);
    }

    @Override // com.blued.community.ui.send.fragment.FeedAddPostBaseFragment
    protected NewFeedModel l() {
        NewFeedModel l = super.l();
        if (l == null) {
            return null;
        }
        if (this.bE == 2) {
            l.tt_type = 3;
        }
        if (aU.size() > 0) {
            l.is_super_topics = 1;
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            List<BluedTopic> list = aU;
            if (list != null && list.size() > 0) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= aU.size()) {
                        break;
                    }
                    BluedTopic bluedTopic = aU.get(i2);
                    if (!TextUtils.isEmpty(bluedTopic.name)) {
                        if (bluedTopic.topicType == 1) {
                            l.h5_topic_id = TextUtils.isEmpty(bluedTopic.super_did) ? "0" : bluedTopic.super_did;
                            l.h5_topic_name = bluedTopic.name;
                        } else {
                            bluedTopic.super_did = TextUtils.isEmpty(bluedTopic.super_did) ? "0" : bluedTopic.super_did;
                            sb.append(bluedTopic.super_did);
                            if (bluedTopic.is_anonym == 1) {
                                sb.append(a.b);
                            }
                            sb.append(",");
                            sb2.append(bluedTopic.name);
                            sb2.append(",");
                        }
                    }
                    i = i2 + 1;
                }
            }
            l.super_did = sb.toString();
            l.super_topics_name = sb2.toString();
        }
        if (!com.blued.community.utils.StringUtils.d(l.super_did)) {
            l.super_did = l.super_did.replace(a.b, "");
        }
        return l;
    }

    @Override // com.blued.community.ui.send.fragment.FeedAddPostBaseFragment
    protected boolean o() {
        if ((TextUtils.isEmpty(this.o.getText().toString().trim()) && !this.ac.d() && ((!this.av || this.aw == null) && (!an() || !this.bd.b()))) || this.ao || this.ap || this.ar || this.as || this.au || this.at || this.ag != null) {
            return false;
        }
        return (this.ah == null || this.ah.is_draft == 1) && this.ai == null && this.aj == null && this.al == null;
    }

    @Override // com.blued.community.ui.send.fragment.FeedAddPostBaseFragment, com.blued.android.core.ui.BaseFragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.bD = CommunityServiceManager.a().A();
        aU.clear();
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // com.blued.community.ui.send.fragment.FeedAddPostBaseFragment, com.blued.android.core.ui.BaseFragment
    public void onDestroy() {
        super.onDestroy();
        aU.clear();
    }

    @Override // com.blued.community.ui.send.fragment.FeedAddPostBaseFragment, com.blued.android.framework.activity.HomeTabFragment, com.blued.android.core.ui.BaseFragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        postDelaySafeRunOnUiThread(new Runnable() { // from class: com.blued.community.ui.send.fragment.-$$Lambda$FeedAddPostFragment$0rxC43g51kuBG7BHiiI4Yl40Aic
            @Override // java.lang.Runnable
            public final void run() {
                FeedAddPostFragment.this.aG();
            }
        }, 400L);
        if (this.aL == 11) {
            long a = TimeAndDateUtils.a();
            long b = TimeAndDateUtils.b();
            long u = CommunityPreferences.u("FeedAddPostUserPageGuideEnterDate");
            long t = CommunityPreferences.t("FeedAddPostUserPageGuideEnterWeek");
            LogUtils.c("个人主页进入发布引导 --> lastEnterDate=" + u);
            LogUtils.c("个人主页进入发布引导 --> lastEnterWeek=" + t);
            CommunityPreferences.b("FeedAddPostUserPageGuideEnterDate", a);
            CommunityPreferences.a("FeedAddPostUserPageGuideEnterWeek", b);
            if (a > u) {
                CommunityPreferences.a("FeedAddPostUserPageGuideEnterCountDay", 0);
            }
            int v = CommunityPreferences.v("FeedAddPostUserPageGuideEnterCountDay") + 1;
            CommunityPreferences.a("FeedAddPostUserPageGuideEnterCountDay", v);
            LogUtils.c("个人主页进入发布引导 --> 当日enterCount=" + v);
            if (b > t) {
                CommunityPreferences.a("FeedAddPostUserPageGuideWeekEnterCount", 0);
            }
            int v2 = CommunityPreferences.v("FeedAddPostUserPageGuideWeekEnterCount") + 1;
            CommunityPreferences.a("FeedAddPostUserPageGuideWeekEnterCount", v2);
            LogUtils.c("个人主页进入发布引导 --> 当周 weekEnterCount=" + v2);
        }
    }

    @Override // com.blued.community.ui.send.fragment.FeedAddPostBaseFragment
    protected boolean q() {
        if (super.q()) {
            return true;
        }
        if (an()) {
            AppMethods.d(R.string.feed_post_is_image_vote);
            return true;
        }
        return false;
    }

    @Override // com.blued.community.ui.send.fragment.FeedAddPostBaseFragment
    protected boolean r() {
        boolean z = true;
        if (!super.r()) {
            z = true;
            if (!an()) {
                if (this.bE == 1) {
                    return true;
                }
                z = false;
            }
        }
        return z;
    }

    @Override // com.blued.community.ui.send.fragment.FeedAddPostBaseFragment
    protected FeedProtos.FeedType u() {
        return aU.size() > 0 ? FeedProtos.FeedType.SUPER_TOPIC : super.u();
    }
}
