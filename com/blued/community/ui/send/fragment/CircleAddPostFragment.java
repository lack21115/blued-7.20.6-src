package com.blued.community.ui.send.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.alipay.sdk.util.i;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.module.common.db.NewFeedDao;
import com.blued.android.module.common.db.model.NewFeedModel;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.community.R;
import com.blued.community.auto.CommunityServiceManager;
import com.blued.community.http.FeedHttpUtils;
import com.blued.community.manager.CommunityManager;
import com.blued.community.track.EventTrackFeed;
import com.blued.community.ui.circle.fragment.CircleTextVoteEditFragment;
import com.blued.community.ui.circle.manager.CircleMethods;
import com.blued.community.ui.circle.model.CircleBubble;
import com.blued.community.ui.send.dialog.AnonymousHelpDialogFragment;
import com.blued.community.ui.send.manager.FeedSendManager;
import com.blued.community.utils.MarkDownLinkHelper;
import com.blued.community.widget.vote.text.model.CircleTextVote;
import com.blued.community.widget.vote.text.view.CircleTextVoteView;
import com.blued.das.client.feed.FeedProtos;
import com.bytedance.applog.tracker.Tracker;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/send/fragment/CircleAddPostFragment.class */
public class CircleAddPostFragment extends FeedAddPostBaseFragment {
    private TextView aO;
    private FrameLayout aP;
    private CircleTextVoteView aQ;
    private ImageView aR;
    private ConstraintLayout aS;
    private CheckBox aT;
    private ImageView aU;
    private TextView aV;
    private CheckBox aW;
    private String aY;
    private String aZ;
    private ImageView b;
    private String ba;
    private String bc;
    private List<CircleTextVote> bd;
    private int aX = -1;
    private boolean bb = false;

    private void A() {
        CircleBubble circleBubble;
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.aY = arguments.getString("circle_id");
            this.ba = arguments.getString("circle_name");
            this.aZ = arguments.getString("circle_header");
        }
        if (this.ah != null) {
            this.aY = this.ah.circle_id;
            this.ba = this.ah.circle_title;
            this.aZ = this.ah.circle_header;
            this.aT.setChecked(this.ah.is_anonym == 1);
            this.aW.setChecked(this.ah.anonym_comment == 1);
            this.aX = this.ah.anonym_avatar;
            if (this.ah.is_posts_vote == 1) {
                this.bb = true;
                this.bc = this.ah.posts_vote_title;
                this.bd = new ArrayList();
                String[] split = this.ah.option.split(i.b);
                int length = split.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= length) {
                        break;
                    }
                    this.bd.add(new CircleTextVote(split[i2]));
                    i = i2 + 1;
                }
                this.aP.setVisibility(0);
                this.aQ.setOptionTitle(this.bc);
                this.aQ.setOptionList(this.bd);
            }
        }
        this.aO.setText(this.ba);
        if (TextUtils.isEmpty(this.aZ)) {
            this.b.setVisibility(8);
        } else {
            this.b.setVisibility(0);
            ImageLoader.a(getFragmentActive(), this.aZ).a(3.0f).a(this.b);
        }
        if (this.aX < 0) {
            this.aX = CircleMethods.a(this.c);
        }
        this.aU.setImageResource(CircleMethods.a(this.c, this.aX));
        if (arguments == null || (circleBubble = (CircleBubble) arguments.getSerializable("circle_bubble")) == null) {
            return;
        }
        c(circleBubble.getMarkDownLink());
    }

    private void B() {
        this.b = (ImageView) this.j.findViewById(R.id.iv_icon);
        this.aO = (TextView) this.j.findViewById(R.id.tv_title);
        this.J.setVisibility(8);
        this.K.setVisibility(8);
        this.aP = (FrameLayout) this.j.findViewById(R.id.layout_text_vote);
        this.aQ = this.j.findViewById(R.id.circle_text_vote);
        this.aR = (ImageView) this.j.findViewById(R.id.iv_text_vote_delete);
        this.aQ.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.send.fragment.CircleAddPostFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                CircleAddPostFragment circleAddPostFragment = CircleAddPostFragment.this;
                CircleTextVoteEditFragment.a(circleAddPostFragment, 111, circleAddPostFragment.bc, CircleAddPostFragment.this.bd);
            }
        });
        this.aR.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.send.fragment.CircleAddPostFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                CircleAddPostFragment.this.bb = false;
                CircleAddPostFragment.this.bc = null;
                CircleAddPostFragment.this.bd = null;
                CircleAddPostFragment.this.aP.setVisibility(8);
                CircleAddPostFragment.this.R();
            }
        });
        this.aS = this.j.findViewById(R.id.cl_anonymous);
        this.aT = (CheckBox) this.j.findViewById(R.id.cb_anonymous_post);
        this.aU = (ImageView) this.j.findViewById(R.id.iv_anonymous);
        this.aV = (TextView) this.j.findViewById(R.id.tv_anonymous_tip);
        this.aW = (CheckBox) this.j.findViewById(R.id.cb_anonymous_comment);
        this.aS.setVisibility(0);
        this.aT.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.blued.community.ui.send.fragment.CircleAddPostFragment.3
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                Tracker.onCheckedChanged(compoundButton, z);
                CircleAddPostFragment.this.aU.setVisibility(z ? 0 : 8);
            }
        });
        this.aV.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.send.fragment.CircleAddPostFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                AnonymousHelpDialogFragment.a(CircleAddPostFragment.this.getFragmentManager());
            }
        });
    }

    public static Bundle a(String str, String str2, String str3) {
        Bundle bundle = new Bundle();
        bundle.putString("circle_id", str);
        bundle.putString("circle_name", str2);
        bundle.putString("circle_header", str3);
        return bundle;
    }

    public static void a(Context context, NewFeedModel newFeedModel) {
        if (CommunityServiceManager.a().b(context)) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putSerializable("feed_send_data", newFeedModel);
        TerminalActivity.d(context, CircleAddPostFragment.class, bundle);
    }

    public static void a(Context context, String str, String str2, String str3) {
        if (CommunityServiceManager.a().b(context) || TextUtils.isEmpty(str) || a(context, str)) {
            return;
        }
        TerminalActivity.d(context, CircleAddPostFragment.class, a(str, str2, str3));
    }

    public static void a(Context context, String str, String str2, String str3, CircleBubble circleBubble) {
        if (CommunityServiceManager.a().b(context) || TextUtils.isEmpty(str)) {
            return;
        }
        if (circleBubble == null) {
            a(context, str, str2, str3);
            return;
        }
        Bundle a = a(str, str2, str3);
        a.putSerializable("circle_bubble", circleBubble);
        TerminalActivity.d(context, CircleAddPostFragment.class, a);
    }

    public static boolean a(Context context, String str) {
        NewFeedModel newFeedModel = null;
        for (NewFeedModel newFeedModel2 : NewFeedDao.a().c()) {
            if (TextUtils.equals(newFeedModel2.circle_id, str) && newFeedModel2.is_draft == 1) {
                NewFeedDao.a().d(newFeedModel2);
                newFeedModel = newFeedModel2;
            }
        }
        if (newFeedModel != null) {
            a(context, newFeedModel);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(NewFeedModel newFeedModel) {
        if (newFeedModel == null) {
            return;
        }
        CommunityServiceManager.e().a(false);
        NewFeedDao.a().a(newFeedModel);
        FeedSendManager.a().a(newFeedModel);
        ac();
        KeyboardUtils.a((Activity) getActivity());
        if (getActivity() != null) {
            getActivity().finish();
        }
    }

    @Override // com.blued.community.ui.send.fragment.FeedAddPostBaseFragment
    protected boolean a(boolean z) {
        if (this.q.isOutOfBounds()) {
            if (z) {
                String string = this.c.getResources().getString(R.string.community_max_input_limit);
                AppMethods.a((CharSequence) String.format(string, this.q.getEditMaxLength() + ""));
                return false;
            }
            return false;
        } else if (TextUtils.isEmpty(this.o.getText().toString().trim())) {
            if (this.bb) {
                if (z) {
                    AppMethods.a((CharSequence) getString(R.string.send_feed_all_null));
                    return false;
                }
                return false;
            } else if (this.ac.d()) {
                return true;
            } else {
                if (!this.av || this.aw == null) {
                    if (z) {
                        AppMethods.a((CharSequence) getString(R.string.send_feed_all_null));
                        return false;
                    }
                    return false;
                }
                return true;
            }
        } else {
            return true;
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
    protected void h() {
        this.V.setVisibility(0);
        B();
        A();
    }

    @Override // com.blued.community.ui.send.fragment.FeedAddPostBaseFragment
    protected void i() {
        this.aI = 0;
        af();
    }

    @Override // com.blued.community.ui.send.fragment.FeedAddPostBaseFragment
    protected void j() {
        if (this.ac.f() > 0 || this.av || this.ap || this.ao || this.bb) {
            AppMethods.d(R.string.feed_post_is_image_not_vote);
        } else {
            k();
        }
    }

    protected void k() {
        EventTrackFeed.b(FeedProtos.Event.CIRCLE_NOTE_VOTE_ICON_CLICK);
        CircleTextVoteEditFragment.a(this, 111, this.bc, this.bd);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    @Override // com.blued.community.ui.send.fragment.FeedAddPostBaseFragment
    protected NewFeedModel l() {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    @Override // com.blued.community.ui.send.fragment.FeedAddPostBaseFragment
    public void m() {
        final NewFeedModel Z = Z();
        if (Z == null) {
            return;
        }
        FeedHttpUtils.d(new BluedUIHttpResponse<BluedEntityA<String>>(getFragmentActive()) { // from class: com.blued.community.ui.send.fragment.CircleAddPostFragment.5
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<String> bluedEntityA) {
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish(boolean z) {
                super.onUIFinish(z);
                if (z) {
                    CircleAddPostFragment.this.c(Z);
                } else {
                    ToastUtils.b(R.string.content_can_not_send_feed_in_circle);
                }
            }
        }, Y().toString(), "31", getFragmentActive());
        EventTrackFeed.a(FeedProtos.Event.CIRCLE_PUBLISH_BTN_CLICK, Z.circle_id, Z.is_posts_vote == 1 ? FeedProtos.NoteType.VOTE_TEXT : Z.isVideo == 1 ? FeedProtos.NoteType.NOTE_VIDEO : FeedProtos.NoteType.NOTE_COMMON, this.aT.isChecked(), this.aW.isChecked(), MarkDownLinkHelper.b(Z.getContent()));
    }

    @Override // com.blued.community.ui.send.fragment.FeedAddPostBaseFragment
    protected void n() {
        NewFeedModel Z = Z();
        if (Z == null) {
            return;
        }
        Z.is_draft = 1;
        NewFeedDao.a().b(Z);
    }

    @Override // com.blued.community.ui.send.fragment.FeedAddPostBaseFragment
    protected boolean o() {
        if (super.o()) {
            return true;
        }
        return (this.av && this.aw != null) || this.bb;
    }

    @Override // com.blued.community.ui.send.fragment.FeedAddPostBaseFragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 111 && intent != null) {
            String stringExtra = intent.getStringExtra("circle_vote_title");
            List<CircleTextVote> list = (List) intent.getSerializableExtra("circle_vote_content");
            if (TextUtils.isEmpty(stringExtra) || list == null) {
                return;
            }
            this.bb = true;
            this.bc = stringExtra;
            this.bd = list;
            this.aP.setVisibility(0);
            this.aQ.setOptionTitle(this.bc);
            this.aQ.setOptionList(this.bd);
            AppMethods.d(R.string.circle_text_vote_click_edit);
        }
    }

    @Override // com.blued.community.ui.send.fragment.FeedAddPostBaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
    }

    @Override // com.blued.community.ui.send.fragment.FeedAddPostBaseFragment
    protected boolean p() {
        return super.p();
    }

    @Override // com.blued.community.ui.send.fragment.FeedAddPostBaseFragment
    protected boolean q() {
        if (this.bb) {
            AppMethods.d(R.string.circle_text_vote_not_pic);
            return true;
        }
        return super.q();
    }

    @Override // com.blued.community.ui.send.fragment.FeedAddPostBaseFragment
    protected boolean r() {
        return super.r() || this.bb;
    }

    @Override // com.blued.community.ui.send.fragment.FeedAddPostBaseFragment
    public int s() {
        return 2000;
    }

    @Override // com.blued.community.ui.send.fragment.FeedAddPostBaseFragment
    protected boolean t() {
        return super.t();
    }

    @Override // com.blued.community.ui.send.fragment.FeedAddPostBaseFragment
    protected FeedProtos.FeedType u() {
        return FeedProtos.FeedType.CIRCLE_NOTE;
    }

    @Override // com.blued.community.ui.send.fragment.FeedAddPostBaseFragment
    protected String v() {
        return "circle_note";
    }

    @Override // com.blued.community.ui.send.fragment.FeedAddPostBaseFragment
    protected boolean w() {
        return false;
    }
}
