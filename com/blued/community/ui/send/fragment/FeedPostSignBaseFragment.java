package com.blued.community.ui.send.fragment;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.activity.BroadcastFragment;
import com.blued.android.framework.activity.keyboardpage.KeyboardListenLinearLayout;
import com.blued.android.framework.utils.EncryptTool;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.module.common.db.model.NewFeedModel;
import com.blued.android.module.common.utils.CommonStringUtils;
import com.blued.android.module.common.widget.emoji.manager.Emoji;
import com.blued.android.module.common.widget.emoji.view.EmojiKeyboardLayout;
import com.blued.android.module.common.widget.emoticon.ui.Emotion;
import com.blued.community.R;
import com.blued.community.auto.CommunityServiceManager;
import com.blued.community.manager.ChildPhotoManager;
import com.blued.community.model.BluedIngSelfFeed;
import com.blued.community.track.EventTrackFeed;
import com.blued.community.ui.send.manager.FeedSendManager;
import com.blued.community.ui.send.manager.SelectPhotoManager;
import com.blued.community.ui.send.model.FeedPostSignStateItem;
import com.blued.community.ui.send.view.FeedPostAuthView;
import com.blued.community.utils.AtUserHelper;
import com.blued.community.utils.MarkDownLinkHelper;
import com.blued.community.utils.UserInfoUtils;
import com.blued.community.view.EditInputNumView;
import com.blued.community.view.SelectionEditText;
import com.blued.das.client.feed.FeedProtos;
import com.jeremyliao.liveeventbus.LiveEventBus;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/send/fragment/FeedPostSignBaseFragment.class */
public class FeedPostSignBaseFragment extends BroadcastFragment {
    protected Context b;
    protected View c;
    protected KeyboardListenLinearLayout j;
    protected ImageView k;
    protected TextView l;
    protected FeedPostAuthView m;
    protected SelectionEditText n;
    protected EditInputNumView o;
    protected ImageView p;
    protected EmojiKeyboardLayout q;
    protected boolean r;
    protected boolean s;
    protected Emotion t;
    private ImageView u;
    private TextView v;
    private FeedPostSignStateItem z;
    private int w = 0;
    private FeedProtos.SourcePage x = FeedProtos.SourcePage.UNKNOWN_SOURCE_PAGE;
    private boolean y = false;
    private TextWatcher A = new TextWatcher() { // from class: com.blued.community.ui.send.fragment.FeedPostSignBaseFragment.3
        private int b;
        private int c;
        private SpannableStringBuilder d;
        private SpannableStringBuilder e;

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            try {
                FeedPostSignBaseFragment.this.n.removeTextChangedListener(FeedPostSignBaseFragment.this.A);
                MarkDownLinkHelper.a(FeedPostSignBaseFragment.this.n, this.d, this.e, editable, this.b, this.c);
                AtUserHelper.a(FeedPostSignBaseFragment.this.n, this.d, this.e, editable, this.b, this.c);
                FeedPostSignBaseFragment.this.n.addTextChangedListener(FeedPostSignBaseFragment.this.A);
            } catch (Exception e) {
                e.printStackTrace();
            }
            FeedPostSignBaseFragment.this.x();
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.d = new SpannableStringBuilder(charSequence);
            this.b = FeedPostSignBaseFragment.this.n.getSelectionStart();
            this.c = FeedPostSignBaseFragment.this.n.getSelectionEnd();
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.e = new SpannableStringBuilder(charSequence);
        }
    };

    private void A() {
        getActivity().finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B() {
        if (!this.n.isFocusable()) {
            this.n.setFocusable(true);
            this.n.setFocusableInTouchMode(true);
        }
        this.n.requestFocus();
    }

    private void C() {
        B();
        this.q.setVisibility(0);
        ValueAnimator ofInt = ValueAnimator.ofInt(0 - D(), 0);
        ofInt.setTarget(this.q);
        ofInt.setInterpolator(new AccelerateInterpolator());
        ofInt.setDuration(200L).start();
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.community.ui.send.fragment.FeedPostSignBaseFragment.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                Log.d("onAnimationUpdate", "values = " + intValue);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) FeedPostSignBaseFragment.this.q.getLayoutParams();
                marginLayoutParams.bottomMargin = intValue;
                FeedPostSignBaseFragment.this.q.setLayoutParams(marginLayoutParams);
            }
        });
        this.p.setImageDrawable(BluedSkinUtils.b(this.b, R.drawable.feed_post_keyboard));
    }

    private int D() {
        return this.q.getMeasuredHeight() > 0 ? this.q.getMeasuredHeight() : KeyboardUtils.a();
    }

    public static void a(Context context, Bundle bundle) {
        TerminalActivity.d(context, FeedPostSignBaseFragment.class, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(FeedPostSignStateItem feedPostSignStateItem) {
        if (feedPostSignStateItem != null) {
            this.z = feedPostSignStateItem;
            y();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(View view) {
        z();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(View view) {
        j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(View view) {
        r();
    }

    private void p() {
        if (getArguments() != null) {
            int i = getArguments().getInt("page_from");
            this.w = i;
            if (i == 2) {
                this.x = FeedProtos.SourcePage.GUIDE_POP;
            } else if (i == 1) {
                this.x = FeedProtos.SourcePage.PUNCH_FEED_ALL_PUBLISH;
            } else if (i == 3) {
                this.x = FeedProtos.SourcePage.FEED_PERSONAL_FEED;
            } else if (i == 9) {
                this.x = FeedProtos.SourcePage.GUIDE_PUNCH;
            }
            this.z = (FeedPostSignStateItem) getArguments().getSerializable("selected_model");
        }
    }

    private void q() {
        KeyboardUtils.a((Activity) getActivity());
        Bundle bundle = new Bundle();
        bundle.putSerializable("selected_model", this.z);
        FeedPostSignStateFragment.a.a(getActivity(), bundle, this.w);
    }

    private void r() {
        if (getActivity() != null) {
            getActivity().finish();
        }
    }

    private void s() {
        this.n = this.c.findViewById(R.id.feed_post_content_et);
        this.o = this.c.findViewById(R.id.feed_post_content_num_tv);
        this.t = new Emotion(this.b);
        this.n.setOnTouchListener(new View.OnTouchListener() { // from class: com.blued.community.ui.send.fragment.FeedPostSignBaseFragment.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (view.getId() == R.id.feed_post_content_et) {
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                    if (motionEvent.getAction() == 1) {
                        view.getParent().requestDisallowInterceptTouchEvent(false);
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        MarkDownLinkHelper.a(this.n);
        AtUserHelper.a(this.n);
        this.n.setFilters(new InputFilter[]{new InputFilter.LengthFilter(o())});
        this.o.init(this.n, o());
        this.n.addTextChangedListener(this.A);
        t();
    }

    private void t() {
        FeedPostSignStateItem feedPostSignStateItem = this.z;
        if (feedPostSignStateItem == null || TextUtils.isEmpty(feedPostSignStateItem.getLeading_words())) {
            this.n.setHint(R.string.feed_post_sign_et_hint);
        } else {
            this.n.setHint(this.z.getLeading_words());
        }
    }

    private void u() {
        EmojiKeyboardLayout emojiKeyboardLayout = (EmojiKeyboardLayout) this.c.findViewById(R.id.emoticon_layout);
        this.q = emojiKeyboardLayout;
        emojiKeyboardLayout.setKeyboardColor(2);
        this.q.setFragmentManager(getChildFragmentManager());
        ViewGroup.LayoutParams layoutParams = this.q.getLayoutParams();
        layoutParams.height = KeyboardUtils.a();
        this.q.setLayoutParams(layoutParams);
        this.q.setEmojiCallback(new EmojiKeyboardLayout.EmojiCallback() { // from class: com.blued.community.ui.send.fragment.FeedPostSignBaseFragment.2
            @Override // com.blued.android.module.common.widget.emoji.view.EmojiKeyboardLayout.EmojiCallback
            public void a() {
                FeedPostSignBaseFragment.this.n.onKeyDown(67, new KeyEvent(0, 67));
            }

            @Override // com.blued.android.module.common.widget.emoji.view.EmojiKeyboardLayout.EmojiCallback
            public void a(Emoji emoji) {
                SpannableString spannableString = new SpannableString(emoji.a());
                if (FeedPostSignBaseFragment.this.f.getText().length() + spannableString.length() <= FeedPostSignBaseFragment.this.o()) {
                    FeedPostSignBaseFragment.this.n.getText().insert(FeedPostSignBaseFragment.this.n.getSelectionStart(), spannableString);
                }
            }
        });
    }

    private void v() {
        KeyboardListenLinearLayout keyboardListenLinearLayout = (KeyboardListenLinearLayout) this.c.findViewById(R.id.keyboardLinearLayout);
        this.j = keyboardListenLinearLayout;
        keyboardListenLinearLayout.setBackgroundColor(BluedSkinUtils.a(this.b, R.color.syc_b));
        super.a(this.q, this.j, this.n);
    }

    private boolean w() {
        return !TextUtils.isEmpty(this.n.getText().toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        if (w()) {
            this.l.setAlpha(1.0f);
            this.l.setTextColor(-1);
            return;
        }
        this.l.setAlpha(0.3f);
        this.l.setTextColor(Color.parseColor("#99ffffff"));
    }

    private void y() {
        if (this.z != null) {
            ImageLoader.a(getFragmentActive(), this.z.getIcon()).a(this.u);
            this.v.setText(this.z.getName());
            t();
        }
    }

    private void z() {
        if (this.q.getVisibility() == 0) {
            KeyboardUtils.c(getActivity());
        } else if (!this.r) {
            C();
        } else {
            this.s = true;
            KeyboardUtils.a((Activity) getActivity());
        }
    }

    protected void h() {
        i();
        s();
        u();
        v();
        x();
        n();
    }

    public void i() {
        ImageView imageView = (ImageView) this.c.findViewById(R.id.feed_post_title_close);
        this.k = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.send.fragment.-$$Lambda$FeedPostSignBaseFragment$fo2zJXhFhf_LKsHx2vLOifBlwLc
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedPostSignBaseFragment.this.f(view);
            }
        });
        TextView textView = (TextView) this.c.findViewById(R.id.feed_post_title_send_btn);
        this.l = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.send.fragment.-$$Lambda$FeedPostSignBaseFragment$VXDGA1n12225hrvm2_iSRwItCUY
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedPostSignBaseFragment.this.e(view);
            }
        });
        ImageView imageView2 = (ImageView) this.c.findViewById(R.id.iv_emoji);
        this.p = imageView2;
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.send.fragment.-$$Lambda$FeedPostSignBaseFragment$XR8a1ftzpTLADnUYdpqH-GWXO3w
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedPostSignBaseFragment.this.d(view);
            }
        });
        FeedPostAuthView feedPostAuthView = (FeedPostAuthView) this.c.findViewById(R.id.feed_post_auth_view);
        this.m = feedPostAuthView;
        feedPostAuthView.setOwnFragment(this);
        this.m.setAnonymousTopic(false);
        this.m.setShowType(1);
        this.u = (ImageView) this.c.findViewById(R.id.feed_post_sign_state_iv);
        this.v = (TextView) this.c.findViewById(R.id.feed_post_sign_state_tv);
        this.c.findViewById(R.id.feed_post_sign_state_layout).setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.send.fragment.-$$Lambda$FeedPostSignBaseFragment$NbD672HymB5UYn7sV4irPTXo_pA
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedPostSignBaseFragment.this.a(view);
            }
        });
    }

    protected void j() {
        NewFeedModel l = l();
        if (l == null) {
            return;
        }
        CommunityServiceManager.e().a(this.y);
        FeedSendManager.a().a(l);
        m();
        KeyboardUtils.a((Activity) getActivity());
        Intent intent = new Intent();
        intent.putExtra("close_page", true);
        getActivity().setResult(-1, intent);
        A();
        FeedProtos.Event event = FeedProtos.Event.PUNCH_FEED_EDIT_PAGE_PUBLISH_SHOW;
        FeedPostSignStateItem feedPostSignStateItem = this.z;
        EventTrackFeed.a(event, feedPostSignStateItem != null ? feedPostSignStateItem.getBubble_state_id() : "", this.x, EventTrackFeed.a());
    }

    @Override // com.blued.android.framework.activity.keyboardpage.KeyBoardFragment
    public void j_(int i) {
        if (i == -3) {
            this.r = true;
            this.q.setVisibility(8);
            this.n.setCursorVisible(true);
            this.p.setImageDrawable(BluedSkinUtils.b(this.b, R.drawable.feed_post_emoji));
        } else if (i != -2) {
        } else {
            this.r = false;
            if (this.s) {
                this.q.setVisibility(0);
                this.p.setImageDrawable(BluedSkinUtils.b(this.b, R.drawable.feed_post_keyboard));
            } else {
                this.p.setImageDrawable(BluedSkinUtils.b(this.b, R.drawable.feed_post_emoji));
            }
            this.s = false;
            if (this.q.getVisibility() != 0) {
                this.n.setCursorVisible(false);
            }
        }
    }

    protected Editable k() {
        return AtUserHelper.a(MarkDownLinkHelper.a(Editable.Factory.getInstance().newEditable(this.n.getText())));
    }

    protected NewFeedModel l() {
        String obj = k().toString();
        if (TextUtils.isEmpty(obj)) {
            return null;
        }
        NewFeedModel newFeedModel = new NewFeedModel();
        newFeedModel.setContent(obj);
        newFeedModel.setLoadName(CommonStringUtils.c(UserInfoUtils.c()));
        newFeedModel.reading_scope = this.m.getAuthValue() != null ? this.m.getAuthValue().intValue() : 0;
        newFeedModel.allow_comments = this.m.getCommentValue() != null ? this.m.getCommentValue().intValue() : 0;
        newFeedModel.setState(1);
        newFeedModel.setTime(System.currentTimeMillis());
        if (getArguments() != null) {
            newFeedModel.bubbleClassifyId = getArguments().getString("classify_id");
        }
        FeedPostSignStateItem feedPostSignStateItem = this.z;
        if (feedPostSignStateItem != null) {
            newFeedModel.sign_state_id = feedPostSignStateItem.getBubble_state_id();
            newFeedModel.state_types = this.z.getState_types();
            newFeedModel.allow_comments = this.m.getCommentValue() != null ? this.m.getCommentValue().intValue() : 0;
            BluedIngSelfFeed bluedIngSelfFeed = new BluedIngSelfFeed();
            bluedIngSelfFeed.feed_uid = UserInfoUtils.c();
            bluedIngSelfFeed.user_avatar = UserInfoUtils.e();
            bluedIngSelfFeed.user_name = UserInfoUtils.d();
            bluedIngSelfFeed.weight = CommonStringUtils.a(UserInfoUtils.b().weight);
            bluedIngSelfFeed.height = CommonStringUtils.a(UserInfoUtils.b().height);
            bluedIngSelfFeed.age = CommonStringUtils.a(UserInfoUtils.b().age);
            bluedIngSelfFeed.online_state = 1;
            bluedIngSelfFeed.distance = "0m";
            bluedIngSelfFeed.feed_timestamp = String.valueOf(newFeedModel.getTime() / 1000);
            bluedIngSelfFeed.feed_content = newFeedModel.getContent();
            bluedIngSelfFeed.is_bubble_ticktock = 1;
            bluedIngSelfFeed.can_promotion = 0;
            bluedIngSelfFeed.in_promotion = 0;
            bluedIngSelfFeed.promotion_status = 0;
            int i = 0;
            if (this.m.getAuthValue() != null) {
                i = this.m.getAuthValue().intValue();
            }
            bluedIngSelfFeed.reading_scope = i;
            bluedIngSelfFeed.bubble_state_name = this.z.getName();
            bluedIngSelfFeed.bubble_state_id = this.z.getBubble_state_id();
            bluedIngSelfFeed.bubble_state_icon = this.z.getIcon();
            LiveEventBus.get("feed_post_sign_data").post(bluedIngSelfFeed);
        }
        return newFeedModel;
    }

    protected void m() {
        SelectPhotoManager.a().d();
        ChildPhotoManager.a().d();
    }

    protected void n() {
        postDelaySafeRunOnUiThread(new Runnable() { // from class: com.blued.community.ui.send.fragment.FeedPostSignBaseFragment.4
            @Override // java.lang.Runnable
            public void run() {
                if (FeedPostSignBaseFragment.this.getFragmentActive().isActive()) {
                    FeedPostSignBaseFragment.this.B();
                    KeyboardUtils.c(FeedPostSignBaseFragment.this.getActivity());
                }
            }
        }, 150L);
    }

    public int o() {
        return 20;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 9090) {
            String stringExtra = intent.getStringExtra("UID");
            AtUserHelper.a(this.n, intent.getStringExtra("USER_NAME"), EncryptTool.b(stringExtra), this.A, BluedSkinUtils.a(this.b, R.color.syc_m));
        }
        if (i == 9090) {
            n();
        }
        super.onActivityResult(i, i2, intent);
    }

    @Override // com.blued.android.core.ui.BaseFragment, com.blued.android.core.ui.BaseFragmentActivity.IOnBackPressedListener
    public boolean onBackPressed() {
        if (this.q.getVisibility() != 0) {
            A();
            return true;
        }
        this.q.setVisibility(8);
        this.p.setImageDrawable(BluedSkinUtils.b(this.b, R.drawable.feed_post_emoji));
        return true;
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.b = getActivity();
        View view = this.c;
        if (view == null) {
            this.c = layoutInflater.inflate(R.layout.fragment_feed_post_sign_new, viewGroup, false);
            getActivity().getWindow().setSoftInputMode(18);
        } else if (view.getParent() != null) {
            ((ViewGroup) this.c.getParent()).removeView(this.c);
        }
        return this.c;
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public void onDestroy() {
        super.onDestroy();
        m();
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public void onResume() {
        super.onResume();
        B();
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public void onStart() {
        super.onStart();
        y();
    }

    @Override // com.blued.android.framework.activity.HomeTabFragment, com.blued.android.core.ui.BaseFragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        p();
        h();
        LiveEventBus.get("EVENT_BUBBLE_STATE_SELECTED_MODEL", FeedPostSignStateItem.class).observe(this, new Observer() { // from class: com.blued.community.ui.send.fragment.-$$Lambda$FeedPostSignBaseFragment$wuK6kNnEfERLx1rsMFEWhV9ZRn8
            public final void onChanged(Object obj) {
                FeedPostSignBaseFragment.this.a((FeedPostSignStateItem) obj);
            }
        });
    }
}
