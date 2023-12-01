package com.blued.community.ui.comment.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
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
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.activity.keyboardpage.KeyBoardFragment;
import com.blued.android.framework.activity.keyboardpage.KeyboardListenLinearLayout;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.utils.ActivityChangeAnimationUtils;
import com.blued.android.module.common.widget.emoji.manager.Emoji;
import com.blued.android.module.common.widget.emoji.view.EmojiKeyboardLayout;
import com.blued.community.R;
import com.blued.community.auto.CommunityServiceManager;
import com.blued.community.manager.ChildPhotoManager;
import com.blued.community.model.BluedIngSelfFeed;
import com.blued.community.ui.circle.manager.CircleMethods;
import com.blued.community.ui.send.adapter.AddPostImageAdapter;
import com.blued.community.ui.send.fragment.AlbumSelectFragment;
import com.blued.community.ui.send.manager.SelectPhotoManager;
import com.blued.community.utils.AtChooseUserHelper;
import com.blued.community.utils.StringUtils;
import com.blued.community.view.EditInputNumView;
import com.blued.das.client.feed.FeedProtos;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.callback.ItemDragAndSwipeCallback;
import com.chad.library.adapter.base.listener.OnItemDragListener;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/comment/fragment/CircleCommentFragment.class */
public class CircleCommentFragment extends KeyBoardFragment implements View.OnClickListener {
    private FeedProtos.NoteSource A;
    private String B;
    private boolean C;
    private boolean D;
    private boolean E;
    private boolean F;
    private boolean G;
    private Context b;
    private View c;
    private KeyboardListenLinearLayout j;
    private AtChooseUserHelper k;
    private ImageView l;
    private ImageView m;
    private EditText n;
    private EditInputNumView o;
    private ImageView p;
    private ShapeTextView q;
    private EmojiKeyboardLayout r;
    private RecyclerView s;
    private AddPostImageAdapter t;
    private FrameLayout u;
    private CheckBox v;
    private ImageView w;
    private String x;
    private BluedIngSelfFeed z;
    private int y = -1;
    private TextWatcher H = new TextWatcher() { // from class: com.blued.community.ui.comment.fragment.CircleCommentFragment.8
        private int b;
        private int c;
        private String d;
        private String e;

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            try {
                this.b = CircleCommentFragment.this.n.getSelectionStart();
                this.c = CircleCommentFragment.this.n.getSelectionEnd();
                CircleCommentFragment.this.n.removeTextChangedListener(CircleCommentFragment.this.H);
                if (!CircleCommentFragment.this.k.a(CircleCommentFragment.this, this.d, this.e, editable, this.c)) {
                    CircleCommentFragment.this.n.setSelection(Math.max(CircleCommentFragment.this.n.getSelectionStart(), 0));
                }
                CircleCommentFragment.this.n.addTextChangedListener(CircleCommentFragment.this.H);
            } catch (Exception e) {
                e.printStackTrace();
            }
            CircleCommentFragment.this.u();
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

    public static void a(BaseFragment baseFragment, BluedIngSelfFeed bluedIngSelfFeed, String str, boolean z, boolean z2, boolean z3, int i, String str2, int i2, FeedProtos.NoteSource noteSource) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("circle_data", bluedIngSelfFeed);
        bundle.putString("comment_content", str);
        bundle.putBoolean("is_can_change_anonymous", z);
        bundle.putBoolean("is_anonymous", z2);
        bundle.putBoolean("is_can_anonymous", z3);
        bundle.putInt("anonymous_header_number", i);
        bundle.putString("anonymous_header_url", str2);
        bundle.putSerializable("circle_from_page", noteSource);
        TerminalActivity.a(bundle);
        TerminalActivity.a(baseFragment, CircleCommentFragment.class, bundle, i2);
        if (baseFragment.getActivity() instanceof Activity) {
            ActivityChangeAnimationUtils.a(baseFragment.getActivity());
        }
    }

    private void a(String str) {
        this.n.setText(StringUtils.a(StringUtils.a(str, (int) this.n.getTextSize(), 3), true, true, true, (StringUtils.ClickAtLinkListener) null, true, "", ""));
        EditText editText = this.n;
        editText.setSelection(editText.length());
    }

    private void j() {
        this.t.a();
    }

    private void k() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.z = (BluedIngSelfFeed) arguments.getSerializable("circle_data");
            this.B = arguments.getString("comment_content");
            this.C = arguments.getBoolean("is_can_change_anonymous");
            this.D = arguments.getBoolean("is_anonymous");
            this.E = arguments.getBoolean("is_can_anonymous");
            this.y = arguments.getInt("anonymous_header_number");
            this.x = arguments.getString("anonymous_header_url");
            this.A = arguments.getSerializable("circle_from_page");
        }
    }

    private void l() {
        if (this.n.isFocusable()) {
            return;
        }
        this.n.setFocusable(true);
        this.n.setFocusableInTouchMode(true);
        this.n.requestFocus();
    }

    private void m() {
        KeyboardListenLinearLayout keyboardListenLinearLayout = (KeyboardListenLinearLayout) this.c.findViewById(R.id.keyboardLinearLayout);
        this.j = keyboardListenLinearLayout;
        super.a(this.r, keyboardListenLinearLayout, this.n);
    }

    private void n() {
        this.p = (ImageView) this.c.findViewById(R.id.iv_close);
        this.q = (ShapeTextView) this.c.findViewById(R.id.tv_post);
        this.l = (ImageView) this.c.findViewById(R.id.iv_image);
        this.m = (ImageView) this.c.findViewById(R.id.iv_emoji);
        this.p.setOnClickListener(this);
        this.q.setOnClickListener(this);
        this.l.setOnClickListener(this);
        this.m.setOnClickListener(this);
    }

    private void o() {
        this.u = (FrameLayout) this.c.findViewById(R.id.fl_anonymous_post);
        this.v = (CheckBox) this.c.findViewById(R.id.cb_anonymous_post);
        this.w = (ImageView) this.c.findViewById(R.id.iv_anonymous);
        ImageLoader.a(getFragmentActive(), this.x).b(CircleMethods.a(this.b, this.y)).d(CircleMethods.a(this.b, this.y)).a(this.w);
        this.v.setEnabled(this.C);
        this.v.setClickable(this.C);
        this.v.setChecked(this.D);
        this.v.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.blued.community.ui.comment.fragment.CircleCommentFragment.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                Tracker.onCheckedChanged(compoundButton, z);
                CircleCommentFragment.this.w.setVisibility(8);
            }
        });
        this.u.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.comment.fragment.CircleCommentFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                if (CircleCommentFragment.this.v.isEnabled()) {
                    return;
                }
                if (CircleCommentFragment.this.E) {
                    AppMethods.d(R.string.circle_anonymous_same_identity);
                } else {
                    AppMethods.d(R.string.circle_anonymous_not_anonymous_comment);
                }
            }
        });
    }

    private void p() {
        this.n = (EditText) this.c.findViewById(R.id.edt_news_feed);
        EditInputNumView findViewById = this.c.findViewById(R.id.inv_word_count);
        this.o = findViewById;
        findViewById.init(this.n, 512);
        this.n.addTextChangedListener(this.H);
        this.n.setOnTouchListener(new View.OnTouchListener() { // from class: com.blued.community.ui.comment.fragment.CircleCommentFragment.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (view.getId() == R.id.edt_news_feed) {
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
        a(this.B);
    }

    private void q() {
        EmojiKeyboardLayout emojiKeyboardLayout = (EmojiKeyboardLayout) this.c.findViewById(R.id.emoticon_layout);
        this.r = emojiKeyboardLayout;
        emojiKeyboardLayout.setKeyboardColor(2);
        this.r.setFragmentManager(getChildFragmentManager());
        this.r.setEmojiCallback(new EmojiKeyboardLayout.EmojiCallback() { // from class: com.blued.community.ui.comment.fragment.CircleCommentFragment.4
            @Override // com.blued.android.module.common.widget.emoji.view.EmojiKeyboardLayout.EmojiCallback
            public void a() {
                CircleCommentFragment.this.n.onKeyDown(67, new KeyEvent(0, 67));
            }

            @Override // com.blued.android.module.common.widget.emoji.view.EmojiKeyboardLayout.EmojiCallback
            public void a(Emoji emoji) {
                SpannableString spannableString = new SpannableString(emoji.a());
                if (CircleCommentFragment.this.f.getText().length() + spannableString.length() <= 512) {
                    CircleCommentFragment.this.n.getText().insert(CircleCommentFragment.this.n.getSelectionStart(), spannableString);
                }
            }
        });
    }

    private void r() {
        this.s = this.c.findViewById(R.id.rv_photo);
        this.s.setLayoutManager(new GridLayoutManager(this.b, 3));
        OnItemDragListener onItemDragListener = new OnItemDragListener() { // from class: com.blued.community.ui.comment.fragment.CircleCommentFragment.5
            public void a(RecyclerView.ViewHolder viewHolder, int i) {
                ((BaseViewHolder) viewHolder).setGone(R.id.drag, true);
            }

            public void a(RecyclerView.ViewHolder viewHolder, int i, RecyclerView.ViewHolder viewHolder2, int i2) {
            }

            public void b(RecyclerView.ViewHolder viewHolder, int i) {
                ((BaseViewHolder) viewHolder).setGone(R.id.drag, false);
                CircleCommentFragment.this.t.b();
            }
        };
        this.t = new AddPostImageAdapter(getFragmentActive());
        ItemDragAndSwipeCallback itemDragAndSwipeCallback = new ItemDragAndSwipeCallback(this.t);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(itemDragAndSwipeCallback);
        itemTouchHelper.attachToRecyclerView(this.s);
        itemDragAndSwipeCallback.a(15);
        itemDragAndSwipeCallback.b(48);
        this.t.h();
        this.t.a(itemTouchHelper);
        this.t.a(onItemDragListener);
        this.t.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: com.blued.community.ui.comment.fragment.CircleCommentFragment.6
            public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                CommunityServiceManager.b().a((Context) CircleCommentFragment.this.getActivity(), i, 0, (LoadOptions) null);
            }
        });
        this.t.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() { // from class: com.blued.community.ui.comment.fragment.CircleCommentFragment.7
            public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                CircleCommentFragment.this.s();
            }
        });
        this.s.setAdapter(this.t);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        if (t()) {
            w();
            return;
        }
        this.r.setVisibility(8);
        int f = this.t.f();
        Log.v("drb", "mPhotoAdapter.getDataListSize():" + SelectPhotoManager.a().c().size());
        AlbumSelectFragment.a(this, 4, 1, 9 - f, 109);
    }

    private boolean t() {
        if (SelectPhotoManager.a().c().size() >= 9) {
            AppMethods.a((CharSequence) String.format(getResources().getString(R.string.max_select_num), 9));
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        if (h()) {
            this.q.setAlpha(1.0f);
        } else {
            this.q.setAlpha(0.3f);
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    private void v() {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    private void w() {
        postDelaySafeRunOnUiThread(new Runnable() { // from class: com.blued.community.ui.comment.fragment.CircleCommentFragment.9
            @Override // java.lang.Runnable
            public void run() {
                if (!CircleCommentFragment.this.n.isFocusable()) {
                    CircleCommentFragment.this.n.requestFocus();
                }
                KeyboardUtils.c(CircleCommentFragment.this.getActivity());
            }
        }, 300L);
    }

    private void x() {
        Intent intent = new Intent();
        intent.putExtra("comment_content", this.n.getText().toString());
        intent.putExtra("is_anonymous", this.v.isChecked());
        intent.putExtra("is_can_change_anonymous", this.C);
        getActivity().setResult(-1, intent);
        getActivity().finish();
        ActivityChangeAnimationUtils.c(getActivity());
    }

    private void y() {
        Intent intent = new Intent();
        intent.putExtra("comment_content", "");
        intent.putExtra("is_anonymous", this.v.isChecked());
        intent.putExtra("is_can_change_anonymous", false);
        getActivity().setResult(-1, intent);
        getActivity().finish();
        ActivityChangeAnimationUtils.c(getActivity());
    }

    protected boolean h() {
        return !TextUtils.isEmpty(this.n.getText().toString().trim());
    }

    protected void i() {
        SelectPhotoManager.a().d();
        ChildPhotoManager.a().d();
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public boolean isActivitySwipeBackEnable() {
        return false;
    }

    @Override // com.blued.android.framework.activity.keyboardpage.KeyBoardFragment
    public void j_(int i) {
        if (i == -3) {
            this.F = true;
            this.r.setVisibility(8);
            this.n.setCursorVisible(true);
            this.m.setImageDrawable(BluedSkinUtils.b(this.b, R.drawable.circle_comment_post_emoji));
        } else if (i != -2) {
        } else {
            this.F = false;
            if (this.G) {
                this.r.setVisibility(0);
                this.m.setImageDrawable(BluedSkinUtils.b(this.b, R.drawable.feed_post_keyboard));
            } else {
                this.m.setImageDrawable(BluedSkinUtils.b(this.b, R.drawable.circle_comment_post_emoji));
            }
            this.G = false;
            if (this.r.getVisibility() != 0) {
                this.n.setCursorVisible(false);
            }
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        Log.v("drb", "onActivityResult resultCode:" + i2 + " -- requestCode:" + i);
        if (i2 == -1) {
            if (i != 9090) {
                w();
            } else {
                this.k.a(this.n, intent, this.H);
                w();
            }
        } else if (i == 9090) {
            w();
        }
        super.onActivityResult(i, i2, intent);
    }

    @Override // com.blued.android.core.ui.BaseFragment, com.blued.android.core.ui.BaseFragmentActivity.IOnBackPressedListener
    public boolean onBackPressed() {
        if (this.r.getVisibility() != 0) {
            x();
            return true;
        }
        this.r.setVisibility(8);
        this.m.setImageDrawable(BluedSkinUtils.b(this.b, R.drawable.circle_comment_post_emoji));
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        int id = view.getId();
        if (id == R.id.iv_close) {
            x();
        } else if (id == R.id.tv_post) {
            v();
        } else if (id == R.id.iv_image) {
            s();
        } else if (id == R.id.iv_emoji) {
            if (this.r.getVisibility() == 0) {
                KeyboardUtils.c(getActivity());
            } else if (this.F) {
                this.G = true;
                KeyboardUtils.a((Activity) getActivity());
            } else {
                l();
                this.r.setVisibility(0);
            }
        }
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.b = getActivity();
        getActivity().getWindow().setSoftInputMode(18);
        this.k = new AtChooseUserHelper(this.b);
        View view = this.c;
        if (view == null) {
            this.c = layoutInflater.inflate(R.layout.fragment_circle_comment_post, viewGroup, false);
            k();
            n();
            p();
            q();
            m();
            r();
            o();
            s();
        } else if (view.getParent() != null) {
            ((ViewGroup) this.c.getParent()).removeView(this.c);
        }
        return this.c;
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public void onResume() {
        super.onResume();
        j();
        l();
        u();
    }
}
