package com.blued.community.ui.comment.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppMethods;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.activity.keyboardpage.KeyBoardFragment;
import com.blued.android.framework.activity.keyboardpage.KeyboardListenLinearLayout;
import com.blued.android.framework.activity.keyboardpage.SwitchPanelRelativeLayout;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.blued.android.module.common.widget.emoji.view.EmoticonsIndicatorView;
import com.blued.android.module.common.widget.emoticon.manager.EmotionManager;
import com.blued.android.module.common.widget.emoticon.model.EmoticonModel;
import com.blued.android.module.common.widget.emoticon.ui.EmoticonsPageView;
import com.blued.android.module.common.widget.emoticon.ui.EmoticonsToolBarView;
import com.blued.android.module.common.widget.emoticon.ui.Emotion;
import com.blued.android.module.common.widget.emoticon.ui.IViewStateListener;
import com.blued.community.R;
import com.blued.community.auto.CommunityServiceManager;
import com.blued.community.model.BluedIngSelfFeed;
import com.blued.community.ui.comment.adapter.FeedDetailsCommentListAdapter;
import com.blued.community.ui.comment.contract.IHotCommentsContract;
import com.blued.community.ui.comment.model.FeedComment;
import com.blued.community.ui.comment.presenter.HotCommentsPresenter;
import com.blued.community.utils.AtChooseUserHelper;
import com.bytedance.applog.tracker.Tracker;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/comment/fragment/HotCommentsFragment.class */
public class HotCommentsFragment extends KeyBoardFragment implements View.OnClickListener, IHotCommentsContract.IView {
    private EmoticonsToolBarView A;
    private AtChooseUserHelper B;
    private View C;
    private SwitchPanelRelativeLayout D;
    private TextWatcher E = new TextWatcher() { // from class: com.blued.community.ui.comment.fragment.HotCommentsFragment.9
        private int b;
        private int c;
        private String d;
        private String e;

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            this.b = HotCommentsFragment.this.v.getSelectionStart();
            this.c = HotCommentsFragment.this.v.getSelectionEnd();
            HotCommentsFragment.this.v.removeTextChangedListener(HotCommentsFragment.this.E);
            if (!HotCommentsFragment.this.B.a(HotCommentsFragment.this, this.d, this.e, editable, this.c)) {
                HotCommentsFragment.this.v.setSelection(this.b);
            }
            HotCommentsFragment.this.v.addTextChangedListener(HotCommentsFragment.this.E);
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
    public KeyboardListenLinearLayout b;
    public View c;
    private Context j;
    private View k;
    private FeedDetailsCommentListAdapter l;
    private NoDataAndLoadFailView m;
    private SmartRefreshLayout n;
    private RecyclerView o;
    private NoDataAndLoadFailView p;
    private IHotCommentsContract.IPresenter q;
    private BluedIngSelfFeed r;
    private View s;
    private Emotion t;
    private View u;
    private EditText v;
    private View w;
    private View x;
    private EmoticonsPageView y;
    private EmoticonsIndicatorView z;

    public static void a(Context context, BluedIngSelfFeed bluedIngSelfFeed) {
        if (bluedIngSelfFeed != null) {
            Bundle bundle = new Bundle();
            bundle.putSerializable("feedData", bluedIngSelfFeed);
            TerminalActivity.a(bundle);
            TerminalActivity.d(context, HotCommentsFragment.class, bundle);
        }
    }

    private void j() {
        if (getArguments() != null) {
            this.r = (BluedIngSelfFeed) getArguments().getSerializable("feedData");
        }
    }

    @Override // com.blued.community.ui.comment.contract.IHotCommentsContract.IView
    public void a() {
        this.n.b(true);
    }

    @Override // com.blued.community.ui.comment.contract.IHotCommentsContract.IView
    public void a(String str) {
        KeyboardUtils.c(getActivity());
        this.v.setHint(str);
    }

    @Override // com.blued.community.ui.comment.contract.IHotCommentsContract.IView
    public void a(List<FeedComment> list) {
        this.l.addData(list);
    }

    @Override // com.blued.community.ui.comment.contract.IHotCommentsContract.IView
    public void b() {
        this.n.b(false);
    }

    @Override // com.blued.community.ui.comment.contract.IHotCommentsContract.IView
    public void b(List<FeedComment> list) {
        this.l.setNewData(list);
    }

    @Override // com.blued.community.ui.comment.contract.IHotCommentsContract.IView
    public void c() {
        this.n.g();
        this.n.h();
    }

    @Override // com.blued.community.ui.comment.contract.IHotCommentsContract.IView
    public void d() {
        KeyboardUtils.a((Activity) getActivity());
        this.q.a(true);
        this.q.b("");
        this.q.a("");
        this.v.setHint("");
        this.v.setText("");
        KeyboardUtils.a((Activity) getActivity());
        this.D.setVisibility(8);
    }

    @Override // com.blued.community.ui.comment.contract.IHotCommentsContract.IView
    public void e() {
        this.m.d();
    }

    @Override // com.blued.community.ui.comment.contract.IHotCommentsContract.IView
    public void f() {
        this.m.a();
    }

    @Override // com.blued.community.ui.comment.contract.IHotCommentsContract.IView
    public void g() {
        this.m.b();
    }

    public void h() {
        this.C = this.k.findViewById(R.id.view_cover_edit);
        if (CommunityServiceManager.a().j()) {
            this.C.setVisibility(0);
        } else {
            this.C.setVisibility(8);
        }
        this.C.setOnClickListener(this);
        NoDataAndLoadFailView noDataAndLoadFailView = new NoDataAndLoadFailView(this.j);
        this.m = noDataAndLoadFailView;
        noDataAndLoadFailView.d();
        SmartRefreshLayout findViewById = this.k.findViewById(R.id.refresh_layout);
        this.n = findViewById;
        findViewById.c(true);
        RecyclerView findViewById2 = this.k.findViewById(R.id.recycler_view);
        this.o = findViewById2;
        findViewById2.setLayoutManager(new LinearLayoutManager(getContext()));
        this.o.setClipToPadding(false);
        this.o.setScrollBarSize(33554432);
        this.D = (SwitchPanelRelativeLayout) this.k.findViewById(R.id.emoticon_layout_root);
        if (this.l == null) {
            this.l = new FeedDetailsCommentListAdapter(this.j, getFragmentActive(), "feed_hot_comment_detail");
            NoDataAndLoadFailView noDataAndLoadFailView2 = new NoDataAndLoadFailView(getContext());
            this.p = noDataAndLoadFailView2;
            noDataAndLoadFailView2.setNoDataImg(R.drawable.icon_no_data_comment);
            this.l.setEmptyView(this.p);
            this.n.d(100);
        }
        this.o.setAdapter(this.l);
        this.n.a(new OnRefreshLoadMoreListener() { // from class: com.blued.community.ui.comment.fragment.HotCommentsFragment.3
            public void onLoadMore(RefreshLayout refreshLayout) {
                HotCommentsFragment.this.q.c();
            }

            public void onRefresh(RefreshLayout refreshLayout) {
                HotCommentsFragment.this.q.b();
            }
        });
        this.l.a(new FeedDetailsCommentListAdapter.FeedCommentListener() { // from class: com.blued.community.ui.comment.fragment.HotCommentsFragment.4
            @Override // com.blued.community.ui.comment.adapter.FeedDetailsCommentListAdapter.FeedCommentListener
            public void a(FeedComment feedComment) {
                HotCommentsFragment.this.q.d().contentClick(feedComment);
            }
        });
        View findViewById3 = this.k.findViewById(R.id.bottom_edit_view);
        this.u = findViewById3;
        EditText editText = (EditText) findViewById3.findViewById(R.id.edit_view);
        this.v = editText;
        editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(256)});
        this.v.addTextChangedListener(this.E);
        View findViewById4 = this.u.findViewById(R.id.expression_btn);
        this.w = findViewById4;
        findViewById4.setOnClickListener(this);
        View findViewById5 = this.u.findViewById(R.id.send_btn);
        this.x = findViewById5;
        findViewById5.setOnClickListener(this);
        this.b = (KeyboardListenLinearLayout) this.k.findViewById(R.id.keyboardRelativeLayout);
        this.s = this.k.findViewById(R.id.keyboard_view);
        this.c = this.k.findViewById(R.id.emoticon_layout);
        this.u.setVisibility(0);
        this.t = new Emotion(this.j);
        ArrayList arrayList = new ArrayList();
        arrayList.add(EmotionManager.g());
        this.y = (EmoticonsPageView) this.c.findViewById(R.id.view_epv);
        this.z = (EmoticonsIndicatorView) this.c.findViewById(R.id.view_eiv);
        EmoticonsToolBarView emoticonsToolBarView = (EmoticonsToolBarView) this.c.findViewById(R.id.view_etv);
        this.A = emoticonsToolBarView;
        emoticonsToolBarView.setModel(true);
        this.A.a(getFragmentActive(), arrayList);
        this.y.a(getFragmentActive(), arrayList);
        this.y.setOnIndicatorListener(new EmoticonsPageView.OnEmoticonsPageViewListener() { // from class: com.blued.community.ui.comment.fragment.HotCommentsFragment.5
            @Override // com.blued.android.module.common.widget.emoticon.ui.EmoticonsPageView.OnEmoticonsPageViewListener
            public void a(int i) {
                HotCommentsFragment.this.z.a(i);
            }

            @Override // com.blued.android.module.common.widget.emoticon.ui.EmoticonsPageView.OnEmoticonsPageViewListener
            public void a(int i, int i2) {
                HotCommentsFragment.this.z.a(i, i2);
            }

            @Override // com.blued.android.module.common.widget.emoticon.ui.EmoticonsPageView.OnEmoticonsPageViewListener
            public void b(int i) {
                HotCommentsFragment.this.z.setIndicatorCount(i);
            }

            @Override // com.blued.android.module.common.widget.emoticon.ui.EmoticonsPageView.OnEmoticonsPageViewListener
            public void c(int i) {
                HotCommentsFragment.this.z.b(i);
            }
        });
        this.y.setIViewListener(new IViewStateListener() { // from class: com.blued.community.ui.comment.fragment.HotCommentsFragment.6
            @Override // com.blued.android.module.common.widget.emoticon.ui.IViewStateListener
            public void a(int i) {
                HotCommentsFragment.this.A.setToolBtnSelect(i);
            }

            @Override // com.blued.android.module.common.widget.emoticon.ui.IViewStateListener
            public void a(EmoticonModel emoticonModel) {
                if (HotCommentsFragment.this.v != null) {
                    HotCommentsFragment.this.v.setFocusable(true);
                    HotCommentsFragment.this.v.setFocusableInTouchMode(true);
                    HotCommentsFragment.this.v.requestFocus();
                    if (emoticonModel.eventType == 1) {
                        HotCommentsFragment.this.v.onKeyDown(67, new KeyEvent(0, 67));
                    } else if (emoticonModel.eventType == 2) {
                    } else {
                        if (emoticonModel.emoji != null) {
                            HotCommentsFragment.this.v.append(emoticonModel.emoji.a());
                            return;
                        }
                        HotCommentsFragment.this.v.getText().insert(HotCommentsFragment.this.v.getSelectionStart(), HotCommentsFragment.this.t.a(emoticonModel.code));
                    }
                }
            }
        });
        this.A.setOnToolBarItemClickListener(new EmoticonsToolBarView.OnToolBarItemClickListener() { // from class: com.blued.community.ui.comment.fragment.HotCommentsFragment.7
            @Override // com.blued.android.module.common.widget.emoticon.ui.EmoticonsToolBarView.OnToolBarItemClickListener
            public void a(int i) {
                HotCommentsFragment.this.y.setPageSelect(i);
            }
        });
    }

    public void i() {
        View findViewById = this.k.findViewById(R.id.top_bar);
        ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
        layoutParams.height = StatusBarHelper.a(getContext());
        findViewById.setLayoutParams(layoutParams);
        CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans) this.k.findViewById(R.id.top_title);
        commonTopTitleNoTrans.a();
        commonTopTitleNoTrans.setCenterText(getString(R.string.hot_comment));
        commonTopTitleNoTrans.setLeftClickListener(this);
    }

    @Override // com.blued.android.framework.activity.keyboardpage.KeyBoardFragment
    public void j_(int i) {
        if (i == -3) {
            this.v.requestFocus();
            this.s.setVisibility(0);
            this.s.setOnTouchListener(new View.OnTouchListener() { // from class: com.blued.community.ui.comment.fragment.HotCommentsFragment.8
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    KeyboardUtils.a((Activity) HotCommentsFragment.this.getActivity());
                    HotCommentsFragment.this.D.setVisibility(8);
                    HotCommentsFragment.this.s.setVisibility(8);
                    return true;
                }
            });
        } else if (i == -2 && this.D.getVisibility() != 0) {
            this.s.setVisibility(8);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            if (i == 9090) {
                this.B.a(this.v, intent, this.E);
                postDelaySafeRunOnUiThread(new Runnable() { // from class: com.blued.community.ui.comment.fragment.HotCommentsFragment.1
                    @Override // java.lang.Runnable
                    public void run() {
                        HotCommentsFragment.this.v.requestFocus();
                        KeyboardUtils.c(HotCommentsFragment.this.getActivity());
                    }
                }, 300L);
            }
        } else if (i == 9090) {
            postDelaySafeRunOnUiThread(new Runnable() { // from class: com.blued.community.ui.comment.fragment.HotCommentsFragment.2
                @Override // java.lang.Runnable
                public void run() {
                    HotCommentsFragment.this.v.requestFocus();
                    KeyboardUtils.c(HotCommentsFragment.this.getActivity());
                }
            }, 300L);
        }
        super.onActivityResult(i, i2, intent);
    }

    @Override // com.blued.android.core.ui.BaseFragment, com.blued.android.core.ui.BaseFragmentActivity.IOnBackPressedListener
    public boolean onBackPressed() {
        if (this.D.getVisibility() == 0) {
            this.D.setVisibility(8);
            return true;
        }
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        int id = view.getId();
        if (id == R.id.view_cover_edit) {
            CommunityServiceManager.a().b(this.j);
        } else if (id == R.id.ctt_left) {
            getActivity().finish();
        } else if (id == R.id.expression_btn) {
            P_();
        } else if (id == R.id.send_btn) {
            String obj = this.v.getText().toString();
            if (TextUtils.isEmpty(obj.trim())) {
                AppMethods.d(R.string.feed_null);
                return;
            }
            this.q.a(this.B.b(obj), false);
        }
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        getActivity().getWindow().setSoftInputMode(16);
        FragmentActivity activity = getActivity();
        this.j = activity;
        this.B = new AtChooseUserHelper(activity);
        View view = this.k;
        if (view == null) {
            this.k = layoutInflater.inflate(R.layout.fragment_feed_hot_comment, viewGroup, false);
            j();
            this.q = new HotCommentsPresenter(this.j, this.r, this, getFragmentActive());
            h();
            a(this.D, this.b, this.v, this.c);
            i();
        } else if (view.getParent() != null) {
            ((ViewGroup) this.k.getParent()).removeView(this.k);
        }
        return this.k;
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public void onResume() {
        super.onResume();
        if (this.C != null) {
            if (CommunityServiceManager.a().j()) {
                this.C.setVisibility(0);
            } else {
                this.C.setVisibility(8);
            }
        }
    }

    @Override // com.blued.android.framework.activity.HomeTabFragment, com.blued.android.core.ui.BaseFragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
    }
}
