package com.blued.android.module.yy_china.fragment;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.pool.ThreadManager;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.android.module.common.view.FlowLayout;
import com.blued.android.module.common.widget.refresh.BluedLoadMoreView;
import com.blued.android.module.live.base.music.model.YYKtvMusicModel;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.FragmentYyKtvSearchMusicBinding;
import com.blued.android.module.yy_china.fragment.YYChorusSearchMusicDialog;
import com.blued.android.module.yy_china.listener.ITextWatcher;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYKtvMusicExtra;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.blued.android.module.yy_china.utils.YYRoomPreferences;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYChorusSearchMusicDialog.class */
public final class YYChorusSearchMusicDialog extends BaseFullScreenDialog implements OnSoftKeyboardChangeListener {
    private FragmentYyKtvSearchMusicBinding a;
    private SongAdapter b;
    private YYRoomModel c;
    private String d = "";
    private String e = "";
    private boolean f;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYChorusSearchMusicDialog$SongAdapter.class */
    public final class SongAdapter extends BaseQuickAdapter<YYKtvMusicModel, BaseViewHolder> {
        final /* synthetic */ YYChorusSearchMusicDialog a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SongAdapter(YYChorusSearchMusicDialog this$0) {
            super(R.layout.item_search_chorus_music_layout);
            Intrinsics.e(this$0, "this$0");
            this.a = this$0;
        }

        private final SpannableString a(String str, String str2) {
            String str3 = str;
            if (TextUtils.isEmpty(str3)) {
                return new SpannableString("");
            }
            SpannableString spannableString = new SpannableString(str3);
            Matcher matcher = Pattern.compile(str2).matcher(str3);
            while (matcher.find()) {
                spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#2B72FF")), matcher.start(), matcher.end(), 33);
            }
            return spannableString;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(YYChorusSearchMusicDialog this$0, YYKtvMusicModel yYKtvMusicModel, View view) {
            Intrinsics.e(this$0, "this$0");
            if (!this$0.f) {
                if (yYKtvMusicModel == null) {
                    return;
                }
                String str = yYKtvMusicModel.musicId;
                Intrinsics.c(str, "it.musicId");
                String str2 = yYKtvMusicModel.musicName;
                Intrinsics.c(str2, "it.musicName");
                String str3 = yYKtvMusicModel.artist;
                Intrinsics.c(str3, "it.artist");
                String str4 = yYKtvMusicModel.coverUrl;
                Intrinsics.c(str4, "it.coverUrl");
                this$0.a(str, str2, str3, str4, yYKtvMusicModel.duration);
                return;
            }
            FragmentYyKtvSearchMusicBinding fragmentYyKtvSearchMusicBinding = this$0.a;
            FragmentYyKtvSearchMusicBinding fragmentYyKtvSearchMusicBinding2 = fragmentYyKtvSearchMusicBinding;
            if (fragmentYyKtvSearchMusicBinding == null) {
                Intrinsics.c("mBinding");
                fragmentYyKtvSearchMusicBinding2 = null;
            }
            EditText editText = fragmentYyKtvSearchMusicBinding2.d;
            Context context = editText == null ? null : editText.getContext();
            FragmentYyKtvSearchMusicBinding fragmentYyKtvSearchMusicBinding3 = this$0.a;
            if (fragmentYyKtvSearchMusicBinding3 == null) {
                Intrinsics.c("mBinding");
                fragmentYyKtvSearchMusicBinding3 = null;
            }
            KeyboardUtils.b(context, fragmentYyKtvSearchMusicBinding3.d);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: a */
        public void convert(BaseViewHolder baseViewHolder, final YYKtvMusicModel yYKtvMusicModel) {
            TextView textView = baseViewHolder == null ? null : (TextView) baseViewHolder.getView(R.id.tv_music_name);
            TextView textView2 = baseViewHolder == null ? null : (TextView) baseViewHolder.getView(R.id.tv_music_writer);
            ImageView imageView = baseViewHolder == null ? null : (ImageView) baseViewHolder.getView(R.id.img_logo);
            ShapeTextView shapeTextView = baseViewHolder == null ? null : (ShapeTextView) baseViewHolder.getView(R.id.btn_book_in);
            if (yYKtvMusicModel != null) {
                YYChorusSearchMusicDialog yYChorusSearchMusicDialog = this.a;
                if (textView != null) {
                    textView.setText(a(yYKtvMusicModel.musicName, yYChorusSearchMusicDialog.e));
                }
                if (textView2 != null) {
                    textView2.setText(yYKtvMusicModel.artist);
                }
                if (imageView != null) {
                    imageView.setVisibility(TextUtils.equals("Featured", yYKtvMusicModel.recommendType) ? 0 : 8);
                }
            }
            if (shapeTextView == null) {
                return;
            }
            final YYChorusSearchMusicDialog yYChorusSearchMusicDialog2 = this.a;
            shapeTextView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYChorusSearchMusicDialog$SongAdapter$xsF3NVJm_eG9hv_pZrsO7uAKvoA
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YYChorusSearchMusicDialog.SongAdapter.a(YYChorusSearchMusicDialog.this, yYKtvMusicModel, view);
                }
            });
        }
    }

    private final void a(Activity activity, final OnSoftKeyboardChangeListener onSoftKeyboardChangeListener) {
        final View decorView = activity.getWindow().getDecorView();
        Intrinsics.c(decorView, "activity.window.decorView");
        decorView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.blued.android.module.yy_china.fragment.YYChorusSearchMusicDialog$observeSoftKeyboard$1
            private int c = -1;

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Rect rect = new Rect();
                View.this.getWindowVisibleDisplayFrame(rect);
                int i = rect.bottom;
                int height = View.this.getHeight();
                int i2 = height - i;
                if (this.c != i2) {
                    onSoftKeyboardChangeListener.a(i2, true ^ (((double) i) / ((double) height) > 0.8d));
                }
                this.c = height;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYChorusSearchMusicDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        if (!this$0.f) {
            this$0.dismissAllowingStateLoss();
            return;
        }
        FragmentYyKtvSearchMusicBinding fragmentYyKtvSearchMusicBinding = this$0.a;
        FragmentYyKtvSearchMusicBinding fragmentYyKtvSearchMusicBinding2 = fragmentYyKtvSearchMusicBinding;
        if (fragmentYyKtvSearchMusicBinding == null) {
            Intrinsics.c("mBinding");
            fragmentYyKtvSearchMusicBinding2 = null;
        }
        EditText editText = fragmentYyKtvSearchMusicBinding2.d;
        Context context = editText == null ? null : editText.getContext();
        FragmentYyKtvSearchMusicBinding fragmentYyKtvSearchMusicBinding3 = this$0.a;
        if (fragmentYyKtvSearchMusicBinding3 == null) {
            Intrinsics.c("mBinding");
            fragmentYyKtvSearchMusicBinding3 = null;
        }
        KeyboardUtils.b(context, fragmentYyKtvSearchMusicBinding3.d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYChorusSearchMusicDialog this$0, List keywords, View view, int i) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(keywords, "$keywords");
        this$0.d = "";
        String str = (String) keywords.get(i);
        this$0.e = str;
        if (str != null) {
            FragmentYyKtvSearchMusicBinding fragmentYyKtvSearchMusicBinding = this$0.a;
            FragmentYyKtvSearchMusicBinding fragmentYyKtvSearchMusicBinding2 = fragmentYyKtvSearchMusicBinding;
            if (fragmentYyKtvSearchMusicBinding == null) {
                Intrinsics.c("mBinding");
                fragmentYyKtvSearchMusicBinding2 = null;
            }
            fragmentYyKtvSearchMusicBinding2.d.setText(str);
            FragmentYyKtvSearchMusicBinding fragmentYyKtvSearchMusicBinding3 = this$0.a;
            FragmentYyKtvSearchMusicBinding fragmentYyKtvSearchMusicBinding4 = fragmentYyKtvSearchMusicBinding3;
            if (fragmentYyKtvSearchMusicBinding3 == null) {
                Intrinsics.c("mBinding");
                fragmentYyKtvSearchMusicBinding4 = null;
            }
            fragmentYyKtvSearchMusicBinding4.d.setSelection(str.length());
        }
        FragmentYyKtvSearchMusicBinding fragmentYyKtvSearchMusicBinding5 = this$0.a;
        FragmentYyKtvSearchMusicBinding fragmentYyKtvSearchMusicBinding6 = fragmentYyKtvSearchMusicBinding5;
        if (fragmentYyKtvSearchMusicBinding5 == null) {
            Intrinsics.c("mBinding");
            fragmentYyKtvSearchMusicBinding6 = null;
        }
        Context context = fragmentYyKtvSearchMusicBinding6.d.getContext();
        FragmentYyKtvSearchMusicBinding fragmentYyKtvSearchMusicBinding7 = this$0.a;
        if (fragmentYyKtvSearchMusicBinding7 == null) {
            Intrinsics.c("mBinding");
            fragmentYyKtvSearchMusicBinding7 = null;
        }
        KeyboardUtils.b(context, fragmentYyKtvSearchMusicBinding7.d);
        this$0.i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(final String str, final String str2, String str3, final String str4, long j) {
        YYRoomModel yYRoomModel = this.c;
        String str5 = yYRoomModel == null ? null : yYRoomModel.room_id;
        final ActivityFragmentActive a = a();
        YYRoomHttpUtils.l(str5, str, (BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntityA<Object>>(a) { // from class: com.blued.android.module.yy_china.fragment.YYChorusSearchMusicDialog$chooseSong$1
            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Code restructure failed: missing block: B:8:0x001c, code lost:
                r0 = r4.a.c;
             */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onUIUpdate(com.blued.android.framework.http.parser.BluedEntityA<java.lang.Object> r5) {
                /*
                    r4 = this;
                    r0 = r4
                    com.blued.android.module.yy_china.fragment.YYChorusSearchMusicDialog r0 = com.blued.android.module.yy_china.fragment.YYChorusSearchMusicDialog.this
                    com.blued.android.module.yy_china.model.YYRoomModel r0 = com.blued.android.module.yy_china.fragment.YYChorusSearchMusicDialog.j(r0)
                    r5 = r0
                    r0 = 0
                    r6 = r0
                    r0 = r5
                    if (r0 != 0) goto L13
                    r0 = 0
                    r5 = r0
                    goto L18
                L13:
                    r0 = r5
                    com.blued.android.module.yy_china.model.YYMsgKtvMusic r0 = r0.music
                    r5 = r0
                L18:
                    r0 = r5
                    if (r0 != 0) goto L36
                    r0 = r4
                    com.blued.android.module.yy_china.fragment.YYChorusSearchMusicDialog r0 = com.blued.android.module.yy_china.fragment.YYChorusSearchMusicDialog.this
                    com.blued.android.module.yy_china.model.YYRoomModel r0 = com.blued.android.module.yy_china.fragment.YYChorusSearchMusicDialog.j(r0)
                    r5 = r0
                    r0 = r5
                    if (r0 != 0) goto L2b
                    goto L36
                L2b:
                    r0 = r5
                    com.blued.android.module.yy_china.model.YYMsgKtvMusic r1 = new com.blued.android.module.yy_china.model.YYMsgKtvMusic
                    r2 = r1
                    r2.<init>()
                    r0.music = r1
                L36:
                    r0 = r4
                    com.blued.android.module.yy_china.fragment.YYChorusSearchMusicDialog r0 = com.blued.android.module.yy_china.fragment.YYChorusSearchMusicDialog.this
                    com.blued.android.module.yy_china.model.YYRoomModel r0 = com.blued.android.module.yy_china.fragment.YYChorusSearchMusicDialog.j(r0)
                    r5 = r0
                    r0 = r5
                    if (r0 != 0) goto L47
                    r0 = 0
                    r5 = r0
                    goto L4c
                L47:
                    r0 = r5
                    com.blued.android.module.yy_china.model.YYMsgKtvMusic r0 = r0.music
                    r5 = r0
                L4c:
                    r0 = r5
                    if (r0 != 0) goto L53
                    goto L5b
                L53:
                    r0 = r5
                    r1 = r4
                    java.lang.String r1 = r5
                    r0.coverUrl = r1
                L5b:
                    r0 = r4
                    com.blued.android.module.yy_china.fragment.YYChorusSearchMusicDialog r0 = com.blued.android.module.yy_china.fragment.YYChorusSearchMusicDialog.this
                    com.blued.android.module.yy_china.model.YYRoomModel r0 = com.blued.android.module.yy_china.fragment.YYChorusSearchMusicDialog.j(r0)
                    r5 = r0
                    r0 = r5
                    if (r0 != 0) goto L6c
                    r0 = 0
                    r5 = r0
                    goto L71
                L6c:
                    r0 = r5
                    com.blued.android.module.yy_china.model.YYMsgKtvMusic r0 = r0.music
                    r5 = r0
                L71:
                    r0 = r5
                    if (r0 != 0) goto L78
                    goto L80
                L78:
                    r0 = r5
                    r1 = r4
                    java.lang.String r1 = r6
                    r0.musicName = r1
                L80:
                    r0 = r4
                    com.blued.android.module.yy_china.fragment.YYChorusSearchMusicDialog r0 = com.blued.android.module.yy_china.fragment.YYChorusSearchMusicDialog.this
                    com.blued.android.module.yy_china.model.YYRoomModel r0 = com.blued.android.module.yy_china.fragment.YYChorusSearchMusicDialog.j(r0)
                    r5 = r0
                    r0 = r5
                    if (r0 != 0) goto L91
                    r0 = r6
                    r5 = r0
                    goto L96
                L91:
                    r0 = r5
                    com.blued.android.module.yy_china.model.YYMsgKtvMusic r0 = r0.music
                    r5 = r0
                L96:
                    r0 = r5
                    if (r0 != 0) goto L9d
                    goto La5
                L9d:
                    r0 = r5
                    r1 = r4
                    java.lang.String r1 = r7
                    r0.musicId = r1
                La5:
                    java.lang.String r0 = "点歌申请已发出，请等待房主或场控通过"
                    com.blued.android.module.common.utils.ToastUtils.a(r0)
                    com.blued.android.module.yy_china.manager.YYRoomInfoManager r0 = com.blued.android.module.yy_china.manager.YYRoomInfoManager.e()
                    r0.H()
                    r0 = r4
                    com.blued.android.module.yy_china.fragment.YYChorusSearchMusicDialog r0 = com.blued.android.module.yy_china.fragment.YYChorusSearchMusicDialog.this
                    r0.dismissAllowingStateLoss()
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.yy_china.fragment.YYChorusSearchMusicDialog$chooseSong$1.onUIUpdate(com.blued.android.framework.http.parser.BluedEntityA):void");
            }
        }, a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean a(YYChorusSearchMusicDialog this$0, TextView textView, int i, KeyEvent keyEvent) {
        Intrinsics.e(this$0, "this$0");
        if (i == 3) {
            FragmentYyKtvSearchMusicBinding fragmentYyKtvSearchMusicBinding = this$0.a;
            FragmentYyKtvSearchMusicBinding fragmentYyKtvSearchMusicBinding2 = fragmentYyKtvSearchMusicBinding;
            if (fragmentYyKtvSearchMusicBinding == null) {
                Intrinsics.c("mBinding");
                fragmentYyKtvSearchMusicBinding2 = null;
            }
            EditText editText = fragmentYyKtvSearchMusicBinding2.d;
            String obj = StringsKt.b((CharSequence) (editText == null ? null : editText.getText()).toString()).toString();
            this$0.e = obj;
            String str = obj;
            if (str == null || str.length() == 0) {
                this$0.h();
                ToastUtils.a("输入歌曲名称，歌手名进行搜索");
                return true;
            }
            this$0.d = "";
            this$0.i();
            FragmentYyKtvSearchMusicBinding fragmentYyKtvSearchMusicBinding3 = this$0.a;
            FragmentYyKtvSearchMusicBinding fragmentYyKtvSearchMusicBinding4 = fragmentYyKtvSearchMusicBinding3;
            if (fragmentYyKtvSearchMusicBinding3 == null) {
                Intrinsics.c("mBinding");
                fragmentYyKtvSearchMusicBinding4 = null;
            }
            EditText editText2 = fragmentYyKtvSearchMusicBinding4.d;
            Context context = editText2 == null ? null : editText2.getContext();
            FragmentYyKtvSearchMusicBinding fragmentYyKtvSearchMusicBinding5 = this$0.a;
            if (fragmentYyKtvSearchMusicBinding5 == null) {
                Intrinsics.c("mBinding");
                fragmentYyKtvSearchMusicBinding5 = null;
            }
            KeyboardUtils.b(context, fragmentYyKtvSearchMusicBinding5.d);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(YYChorusSearchMusicDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        if (this$0.f) {
            FragmentYyKtvSearchMusicBinding fragmentYyKtvSearchMusicBinding = this$0.a;
            FragmentYyKtvSearchMusicBinding fragmentYyKtvSearchMusicBinding2 = fragmentYyKtvSearchMusicBinding;
            if (fragmentYyKtvSearchMusicBinding == null) {
                Intrinsics.c("mBinding");
                fragmentYyKtvSearchMusicBinding2 = null;
            }
            EditText editText = fragmentYyKtvSearchMusicBinding2.d;
            Context context = editText == null ? null : editText.getContext();
            FragmentYyKtvSearchMusicBinding fragmentYyKtvSearchMusicBinding3 = this$0.a;
            if (fragmentYyKtvSearchMusicBinding3 == null) {
                Intrinsics.c("mBinding");
                fragmentYyKtvSearchMusicBinding3 = null;
            }
            KeyboardUtils.b(context, fragmentYyKtvSearchMusicBinding3.d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(YYChorusSearchMusicDialog this$0, View view) {
        Editable text;
        Editable text2;
        Intrinsics.e(this$0, "this$0");
        FragmentYyKtvSearchMusicBinding fragmentYyKtvSearchMusicBinding = this$0.a;
        FragmentYyKtvSearchMusicBinding fragmentYyKtvSearchMusicBinding2 = fragmentYyKtvSearchMusicBinding;
        if (fragmentYyKtvSearchMusicBinding == null) {
            Intrinsics.c("mBinding");
            fragmentYyKtvSearchMusicBinding2 = null;
        }
        EditText editText = fragmentYyKtvSearchMusicBinding2.d;
        if (String.valueOf((editText != null && (text = editText.getText()) != null) ? StringsKt.b(text) : null).length() == 0) {
            this$0.dismissAllowingStateLoss();
            return;
        }
        FragmentYyKtvSearchMusicBinding fragmentYyKtvSearchMusicBinding3 = this$0.a;
        if (fragmentYyKtvSearchMusicBinding3 == null) {
            Intrinsics.c("mBinding");
            fragmentYyKtvSearchMusicBinding3 = null;
        }
        EditText editText2 = fragmentYyKtvSearchMusicBinding3.d;
        if (editText2 == null || (text2 = editText2.getText()) == null) {
            return;
        }
        text2.clear();
    }

    private final void f() {
        View view;
        FrameLayout frameLayout;
        BluedLoadMoreView bluedLoadMoreView = new BluedLoadMoreView(getContext());
        bluedLoadMoreView.setBackgroundColorRes(R.color.transparent);
        FragmentYyKtvSearchMusicBinding fragmentYyKtvSearchMusicBinding = this.a;
        FragmentYyKtvSearchMusicBinding fragmentYyKtvSearchMusicBinding2 = fragmentYyKtvSearchMusicBinding;
        if (fragmentYyKtvSearchMusicBinding == null) {
            Intrinsics.c("mBinding");
            fragmentYyKtvSearchMusicBinding2 = null;
        }
        fragmentYyKtvSearchMusicBinding2.i.a(bluedLoadMoreView);
        FragmentYyKtvSearchMusicBinding fragmentYyKtvSearchMusicBinding3 = this.a;
        FragmentYyKtvSearchMusicBinding fragmentYyKtvSearchMusicBinding4 = fragmentYyKtvSearchMusicBinding3;
        if (fragmentYyKtvSearchMusicBinding3 == null) {
            Intrinsics.c("mBinding");
            fragmentYyKtvSearchMusicBinding4 = null;
        }
        RefreshFooter refreshFooter = fragmentYyKtvSearchMusicBinding4.i.getRefreshFooter();
        if (refreshFooter != null && (view = refreshFooter.getView()) != null && (frameLayout = (FrameLayout) view.findViewById(R.id.layout_load_more_view)) != null) {
            frameLayout.setBackgroundResource(R.color.transparent);
        }
        FragmentYyKtvSearchMusicBinding fragmentYyKtvSearchMusicBinding5 = this.a;
        if (fragmentYyKtvSearchMusicBinding5 == null) {
            Intrinsics.c("mBinding");
            fragmentYyKtvSearchMusicBinding5 = null;
        }
        fragmentYyKtvSearchMusicBinding5.i.a(new OnRefreshLoadMoreListener() { // from class: com.blued.android.module.yy_china.fragment.YYChorusSearchMusicDialog$initRefreshView$1
            public void onLoadMore(RefreshLayout refreshLayout) {
                Intrinsics.e(refreshLayout, "refreshLayout");
                YYChorusSearchMusicDialog.this.i();
            }

            public void onRefresh(RefreshLayout refreshLayout) {
                Intrinsics.e(refreshLayout, "refreshLayout");
                YYChorusSearchMusicDialog.this.d = "";
                YYChorusSearchMusicDialog.this.i();
            }
        });
    }

    private final void g() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            a((Activity) activity, this);
        }
        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(1);
        FragmentYyKtvSearchMusicBinding fragmentYyKtvSearchMusicBinding = this.a;
        FragmentYyKtvSearchMusicBinding fragmentYyKtvSearchMusicBinding2 = fragmentYyKtvSearchMusicBinding;
        if (fragmentYyKtvSearchMusicBinding == null) {
            Intrinsics.c("mBinding");
            fragmentYyKtvSearchMusicBinding2 = null;
        }
        fragmentYyKtvSearchMusicBinding2.h.setLayoutManager(linearLayoutManager);
        this.b = new SongAdapter(this);
        FragmentYyKtvSearchMusicBinding fragmentYyKtvSearchMusicBinding3 = this.a;
        FragmentYyKtvSearchMusicBinding fragmentYyKtvSearchMusicBinding4 = fragmentYyKtvSearchMusicBinding3;
        if (fragmentYyKtvSearchMusicBinding3 == null) {
            Intrinsics.c("mBinding");
            fragmentYyKtvSearchMusicBinding4 = null;
        }
        fragmentYyKtvSearchMusicBinding4.h.setAdapter(this.b);
        FragmentYyKtvSearchMusicBinding fragmentYyKtvSearchMusicBinding5 = this.a;
        FragmentYyKtvSearchMusicBinding fragmentYyKtvSearchMusicBinding6 = fragmentYyKtvSearchMusicBinding5;
        if (fragmentYyKtvSearchMusicBinding5 == null) {
            Intrinsics.c("mBinding");
            fragmentYyKtvSearchMusicBinding6 = null;
        }
        fragmentYyKtvSearchMusicBinding6.b.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYChorusSearchMusicDialog$IDiCRDdEyti8blaYlz61frR38XU
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYChorusSearchMusicDialog.a(YYChorusSearchMusicDialog.this, view);
            }
        });
        FragmentYyKtvSearchMusicBinding fragmentYyKtvSearchMusicBinding7 = this.a;
        FragmentYyKtvSearchMusicBinding fragmentYyKtvSearchMusicBinding8 = fragmentYyKtvSearchMusicBinding7;
        if (fragmentYyKtvSearchMusicBinding7 == null) {
            Intrinsics.c("mBinding");
            fragmentYyKtvSearchMusicBinding8 = null;
        }
        fragmentYyKtvSearchMusicBinding8.a.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYChorusSearchMusicDialog$GmJU1mr3ceB-3yFgiPInd-hUddc
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYChorusSearchMusicDialog.b(YYChorusSearchMusicDialog.this, view);
            }
        });
        FragmentYyKtvSearchMusicBinding fragmentYyKtvSearchMusicBinding9 = this.a;
        FragmentYyKtvSearchMusicBinding fragmentYyKtvSearchMusicBinding10 = fragmentYyKtvSearchMusicBinding9;
        if (fragmentYyKtvSearchMusicBinding9 == null) {
            Intrinsics.c("mBinding");
            fragmentYyKtvSearchMusicBinding10 = null;
        }
        fragmentYyKtvSearchMusicBinding10.f.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYChorusSearchMusicDialog$bpambYZhEnpFZRuxKBhQHpPoJK8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYChorusSearchMusicDialog.a(view);
            }
        });
        FragmentYyKtvSearchMusicBinding fragmentYyKtvSearchMusicBinding11 = this.a;
        FragmentYyKtvSearchMusicBinding fragmentYyKtvSearchMusicBinding12 = fragmentYyKtvSearchMusicBinding11;
        if (fragmentYyKtvSearchMusicBinding11 == null) {
            Intrinsics.c("mBinding");
            fragmentYyKtvSearchMusicBinding12 = null;
        }
        fragmentYyKtvSearchMusicBinding12.d.addTextChangedListener(new ITextWatcher() { // from class: com.blued.android.module.yy_china.fragment.YYChorusSearchMusicDialog$initView$5
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                YYChorusSearchMusicDialog.this.e = StringsKt.b((CharSequence) String.valueOf(editable)).toString();
                String str = YYChorusSearchMusicDialog.this.e;
                if (str == null || str.length() == 0) {
                    YYChorusSearchMusicDialog.this.h();
                    return;
                }
                YYChorusSearchMusicDialog.this.d = "";
                YYChorusSearchMusicDialog.this.i();
            }
        });
        FragmentYyKtvSearchMusicBinding fragmentYyKtvSearchMusicBinding13 = this.a;
        FragmentYyKtvSearchMusicBinding fragmentYyKtvSearchMusicBinding14 = fragmentYyKtvSearchMusicBinding13;
        if (fragmentYyKtvSearchMusicBinding13 == null) {
            Intrinsics.c("mBinding");
            fragmentYyKtvSearchMusicBinding14 = null;
        }
        fragmentYyKtvSearchMusicBinding14.j.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYChorusSearchMusicDialog$mV8JC401ZgSr0vvnH2no9iGK2J4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYChorusSearchMusicDialog.c(YYChorusSearchMusicDialog.this, view);
            }
        });
        FragmentYyKtvSearchMusicBinding fragmentYyKtvSearchMusicBinding15 = this.a;
        if (fragmentYyKtvSearchMusicBinding15 == null) {
            Intrinsics.c("mBinding");
            fragmentYyKtvSearchMusicBinding15 = null;
        }
        fragmentYyKtvSearchMusicBinding15.d.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYChorusSearchMusicDialog$KBinGNsKcmlN1kJrYs6cgqAzPgw
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                boolean a;
                a = YYChorusSearchMusicDialog.a(YYChorusSearchMusicDialog.this, textView, i, keyEvent);
                return a;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h() {
        KeyboardUtils.a(getActivity());
        ArrayList<String> a = YYRoomPreferences.a("chorus_search_records");
        Intrinsics.c(a, "getSearchHistory(BLUED_YY_CHORUS_KEYWORD)");
        final ArrayList<String> arrayList = a;
        FragmentYyKtvSearchMusicBinding fragmentYyKtvSearchMusicBinding = this.a;
        FragmentYyKtvSearchMusicBinding fragmentYyKtvSearchMusicBinding2 = fragmentYyKtvSearchMusicBinding;
        if (fragmentYyKtvSearchMusicBinding == null) {
            Intrinsics.c("mBinding");
            fragmentYyKtvSearchMusicBinding2 = null;
        }
        fragmentYyKtvSearchMusicBinding2.i.setVisibility(8);
        FragmentYyKtvSearchMusicBinding fragmentYyKtvSearchMusicBinding3 = this.a;
        FragmentYyKtvSearchMusicBinding fragmentYyKtvSearchMusicBinding4 = fragmentYyKtvSearchMusicBinding3;
        if (fragmentYyKtvSearchMusicBinding3 == null) {
            Intrinsics.c("mBinding");
            fragmentYyKtvSearchMusicBinding4 = null;
        }
        fragmentYyKtvSearchMusicBinding4.e.setVisibility(0);
        FragmentYyKtvSearchMusicBinding fragmentYyKtvSearchMusicBinding5 = this.a;
        FragmentYyKtvSearchMusicBinding fragmentYyKtvSearchMusicBinding6 = fragmentYyKtvSearchMusicBinding5;
        if (fragmentYyKtvSearchMusicBinding5 == null) {
            Intrinsics.c("mBinding");
            fragmentYyKtvSearchMusicBinding6 = null;
        }
        fragmentYyKtvSearchMusicBinding6.g.removeAllViews();
        for (String str : arrayList) {
            View inflate = View.inflate(getContext(), R.layout.item_tab_text_view, null);
            ShapeTextView shapeTextView = (ShapeTextView) inflate.findViewById(R.id.tv_tab_text);
            if (shapeTextView != null) {
                shapeTextView.setText(str);
            }
            FragmentYyKtvSearchMusicBinding fragmentYyKtvSearchMusicBinding7 = this.a;
            FragmentYyKtvSearchMusicBinding fragmentYyKtvSearchMusicBinding8 = fragmentYyKtvSearchMusicBinding7;
            if (fragmentYyKtvSearchMusicBinding7 == null) {
                Intrinsics.c("mBinding");
                fragmentYyKtvSearchMusicBinding8 = null;
            }
            fragmentYyKtvSearchMusicBinding8.g.addView(inflate);
        }
        FragmentYyKtvSearchMusicBinding fragmentYyKtvSearchMusicBinding9 = this.a;
        if (fragmentYyKtvSearchMusicBinding9 == null) {
            Intrinsics.c("mBinding");
            fragmentYyKtvSearchMusicBinding9 = null;
        }
        fragmentYyKtvSearchMusicBinding9.g.setOnItemClickListener(new FlowLayout.OnItemClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYChorusSearchMusicDialog$4f8NX4_TLgzVS3vD3qXZ5m_iBZ0
            @Override // com.blued.android.module.common.view.FlowLayout.OnItemClickListener
            public final void onItemClick(View view, int i) {
                YYChorusSearchMusicDialog.a(YYChorusSearchMusicDialog.this, arrayList, view, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i() {
        FragmentYyKtvSearchMusicBinding fragmentYyKtvSearchMusicBinding = this.a;
        FragmentYyKtvSearchMusicBinding fragmentYyKtvSearchMusicBinding2 = fragmentYyKtvSearchMusicBinding;
        if (fragmentYyKtvSearchMusicBinding == null) {
            Intrinsics.c("mBinding");
            fragmentYyKtvSearchMusicBinding2 = null;
        }
        fragmentYyKtvSearchMusicBinding2.i.setVisibility(0);
        FragmentYyKtvSearchMusicBinding fragmentYyKtvSearchMusicBinding3 = this.a;
        if (fragmentYyKtvSearchMusicBinding3 == null) {
            Intrinsics.c("mBinding");
            fragmentYyKtvSearchMusicBinding3 = null;
        }
        fragmentYyKtvSearchMusicBinding3.e.setVisibility(8);
        String str = this.e;
        String str2 = this.d;
        final ActivityFragmentActive a = a();
        YYRoomHttpUtils.d(str, str2, "2", (BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntity<YYKtvMusicModel, YYKtvMusicExtra>>(a) { // from class: com.blued.android.module.yy_china.fragment.YYChorusSearchMusicDialog$showMusicListUI$1
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish(boolean z) {
                String str3;
                super.onUIFinish(z);
                str3 = YYChorusSearchMusicDialog.this.d;
                FragmentYyKtvSearchMusicBinding fragmentYyKtvSearchMusicBinding4 = null;
                if (TextUtils.isEmpty(str3)) {
                    FragmentYyKtvSearchMusicBinding fragmentYyKtvSearchMusicBinding5 = YYChorusSearchMusicDialog.this.a;
                    if (fragmentYyKtvSearchMusicBinding5 == null) {
                        Intrinsics.c("mBinding");
                        fragmentYyKtvSearchMusicBinding5 = null;
                    }
                    fragmentYyKtvSearchMusicBinding5.i.b(false);
                } else {
                    FragmentYyKtvSearchMusicBinding fragmentYyKtvSearchMusicBinding6 = YYChorusSearchMusicDialog.this.a;
                    if (fragmentYyKtvSearchMusicBinding6 == null) {
                        Intrinsics.c("mBinding");
                    } else {
                        fragmentYyKtvSearchMusicBinding4 = fragmentYyKtvSearchMusicBinding6;
                    }
                    fragmentYyKtvSearchMusicBinding4.i.b(true);
                }
                YYChorusSearchMusicDialog.this.j();
            }

            /* JADX WARN: Code restructure failed: missing block: B:25:0x0068, code lost:
                r0 = r3.a.b;
             */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onUIUpdate(com.blued.android.framework.http.parser.BluedEntity<com.blued.android.module.live.base.music.model.YYKtvMusicModel, com.blued.android.module.yy_china.model.YYKtvMusicExtra> r4) {
                /*
                    r3 = this;
                    r0 = r4
                    if (r0 == 0) goto La3
                    r0 = r4
                    boolean r0 = r0.hasData()
                    if (r0 != 0) goto Le
                    goto La3
                Le:
                    r0 = r4
                    java.util.List<T> r0 = r0.data
                    r6 = r0
                    r0 = 0
                    r5 = r0
                    r0 = r6
                    if (r0 != 0) goto L1c
                    goto L27
                L1c:
                    r0 = r6
                    boolean r0 = r0.isEmpty()
                    if (r0 != 0) goto L27
                    r0 = 1
                    r5 = r0
                L27:
                    r0 = r5
                    if (r0 == 0) goto L32
                    r0 = r3
                    com.blued.android.module.yy_china.fragment.YYChorusSearchMusicDialog r0 = com.blued.android.module.yy_china.fragment.YYChorusSearchMusicDialog.this
                    com.blued.android.module.yy_china.fragment.YYChorusSearchMusicDialog.e(r0)
                L32:
                    r0 = r3
                    com.blued.android.module.yy_china.fragment.YYChorusSearchMusicDialog r0 = com.blued.android.module.yy_china.fragment.YYChorusSearchMusicDialog.this
                    java.lang.String r0 = com.blued.android.module.yy_china.fragment.YYChorusSearchMusicDialog.f(r0)
                    java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                    boolean r0 = android.text.TextUtils.isEmpty(r0)
                    if (r0 == 0) goto L5c
                    r0 = r3
                    com.blued.android.module.yy_china.fragment.YYChorusSearchMusicDialog r0 = com.blued.android.module.yy_china.fragment.YYChorusSearchMusicDialog.this
                    com.blued.android.module.yy_china.fragment.YYChorusSearchMusicDialog$SongAdapter r0 = com.blued.android.module.yy_china.fragment.YYChorusSearchMusicDialog.g(r0)
                    r6 = r0
                    r0 = r6
                    if (r0 != 0) goto L51
                    goto L82
                L51:
                    r0 = r6
                    r1 = r4
                    java.util.List<T> r1 = r1.data
                    r0.setNewData(r1)
                    goto L82
                L5c:
                    r0 = r4
                    java.util.List<T> r0 = r0.data
                    r6 = r0
                    r0 = r6
                    if (r0 != 0) goto L68
                    goto L82
                L68:
                    r0 = r3
                    com.blued.android.module.yy_china.fragment.YYChorusSearchMusicDialog r0 = com.blued.android.module.yy_china.fragment.YYChorusSearchMusicDialog.this
                    com.blued.android.module.yy_china.fragment.YYChorusSearchMusicDialog$SongAdapter r0 = com.blued.android.module.yy_china.fragment.YYChorusSearchMusicDialog.g(r0)
                    r7 = r0
                    r0 = r7
                    if (r0 != 0) goto L79
                    goto L82
                L79:
                    r0 = r7
                    r1 = r6
                    java.util.Collection r1 = (java.util.Collection) r1
                    r0.addData(r1)
                L82:
                    r0 = r3
                    com.blued.android.module.yy_china.fragment.YYChorusSearchMusicDialog r0 = com.blued.android.module.yy_china.fragment.YYChorusSearchMusicDialog.this
                    r6 = r0
                    r0 = r4
                    S extends com.blued.android.framework.http.parser.BluedEntityBaseExtra r0 = r0.extra
                    com.blued.android.module.yy_china.model.YYKtvMusicExtra r0 = (com.blued.android.module.yy_china.model.YYKtvMusicExtra) r0
                    r4 = r0
                    r0 = r4
                    if (r0 != 0) goto L98
                    r0 = 0
                    r4 = r0
                    goto L9d
                L98:
                    r0 = r4
                    java.lang.String r0 = r0.ScrollToken
                    r4 = r0
                L9d:
                    r0 = r6
                    r1 = r4
                    com.blued.android.module.yy_china.fragment.YYChorusSearchMusicDialog.a(r0, r1)
                    return
                La3:
                    r0 = r3
                    com.blued.android.module.yy_china.fragment.YYChorusSearchMusicDialog r0 = com.blued.android.module.yy_china.fragment.YYChorusSearchMusicDialog.this
                    com.blued.android.module.yy_china.fragment.YYChorusSearchMusicDialog.d(r0)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.yy_china.fragment.YYChorusSearchMusicDialog$showMusicListUI$1.onUIUpdate(com.blued.android.framework.http.parser.BluedEntity):void");
            }
        }, a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j() {
        FragmentYyKtvSearchMusicBinding fragmentYyKtvSearchMusicBinding = this.a;
        FragmentYyKtvSearchMusicBinding fragmentYyKtvSearchMusicBinding2 = fragmentYyKtvSearchMusicBinding;
        if (fragmentYyKtvSearchMusicBinding == null) {
            Intrinsics.c("mBinding");
            fragmentYyKtvSearchMusicBinding2 = null;
        }
        fragmentYyKtvSearchMusicBinding2.i.h();
        FragmentYyKtvSearchMusicBinding fragmentYyKtvSearchMusicBinding3 = this.a;
        if (fragmentYyKtvSearchMusicBinding3 == null) {
            Intrinsics.c("mBinding");
            fragmentYyKtvSearchMusicBinding3 = null;
        }
        fragmentYyKtvSearchMusicBinding3.i.g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k() {
        ThreadManager.a().a(new Runnable() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYChorusSearchMusicDialog$JriUuExUoR_rZS_XLwTAFCZ0TkY
            @Override // java.lang.Runnable
            public final void run() {
                YYChorusSearchMusicDialog.k(YYChorusSearchMusicDialog.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(YYChorusSearchMusicDialog this$0) {
        Intrinsics.e(this$0, "this$0");
        ArrayList<String> a = YYRoomPreferences.a("chorus_search_records");
        Intrinsics.c(a, "getSearchHistory(BLUED_YY_CHORUS_KEYWORD)");
        if (TextUtils.isEmpty(this$0.e)) {
            return;
        }
        if (CollectionsKt.a((Iterable<? extends String>) a, this$0.e)) {
            ArrayList<String> arrayList = a;
            TypeIntrinsics.c(arrayList).remove(this$0.e);
        }
        String str = this$0.e;
        if (str != null) {
            a.add(0, str);
        }
        if (a.size() <= 6) {
            YYRoomPreferences.a("chorus_search_records", a);
            return;
        }
        List<String> subList = a.subList(0, 6);
        Intrinsics.c(subList, "keywords.subList(0, 6)");
        YYRoomPreferences.a("chorus_search_records", subList);
    }

    @Override // com.blued.android.module.yy_china.fragment.OnSoftKeyboardChangeListener
    public void a(int i, boolean z) {
        this.f = z;
    }

    @Override // com.blued.android.module.yy_china.fragment.BaseFullScreenDialog, com.blued.android.core.ui.BaseDialogFragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.c = YYRoomInfoManager.e().b();
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.e(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.fragment_yy_ktv_search_music, viewGroup, true);
        Intrinsics.c(inflate, "inflater.inflate(R.layou…h_music, container, true)");
        FragmentYyKtvSearchMusicBinding a = FragmentYyKtvSearchMusicBinding.a(inflate);
        Intrinsics.c(a, "bind(view)");
        this.a = a;
        g();
        f();
        return inflate;
    }

    @Override // com.blued.android.module.yy_china.fragment.BaseFullScreenDialog, com.blued.android.core.ui.BaseDialogFragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.e(view, "view");
        super.onViewCreated(view, bundle);
        h();
    }
}
