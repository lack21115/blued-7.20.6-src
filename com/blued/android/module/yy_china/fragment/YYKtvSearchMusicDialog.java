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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.pool.ThreadManager;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.android.module.common.view.FlowLayout;
import com.blued.android.module.live.base.music.model.YYKtvMusicModel;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.FragmentYyKtvSearchMusicBinding;
import com.blued.android.module.yy_china.listener.ITextWatcher;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYGiftModel;
import com.blued.android.module.yy_china.model.YYKtvCardModel;
import com.blued.android.module.yy_china.model.YYKtvMusicExtra;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.blued.android.module.yy_china.utils.YYRoomPreferences;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import java.lang.ref.SoftReference;
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
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYKtvSearchMusicDialog.class */
public final class YYKtvSearchMusicDialog extends BaseFullScreenDialog implements OnSoftKeyboardChangeListener {
    private FragmentYyKtvSearchMusicBinding a;
    private SongAdapter b;
    private YYRoomModel c;
    private String d = "";
    private String e = "";
    private boolean f;
    private YYKtvCardModel g;
    private BaseYYStudioFragment h;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYKtvSearchMusicDialog$SongAdapter.class */
    public final class SongAdapter extends BaseQuickAdapter<YYKtvMusicModel, BaseViewHolder> {
        final /* synthetic */ YYKtvSearchMusicDialog a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SongAdapter(YYKtvSearchMusicDialog this$0) {
            super(R.layout.item_search_music_layout);
            Intrinsics.e(this$0, "this$0");
            this.a = this$0;
        }

        private final SpannableString a(String str, String str2) {
            String str3 = str;
            if (TextUtils.isEmpty(str3)) {
                return new SpannableString("");
            }
            SpannableString spannableString = new SpannableString(str3);
            Matcher matcher = Pattern.compile(Pattern.quote(str2)).matcher(str3);
            while (matcher.find()) {
                spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#2B72FF")), matcher.start(), matcher.end(), 33);
            }
            return spannableString;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: a */
        public void convert(BaseViewHolder baseViewHolder, YYKtvMusicModel yYKtvMusicModel) {
            TextView textView = baseViewHolder == null ? null : (TextView) baseViewHolder.getView(R.id.tv_music_name);
            TextView textView2 = baseViewHolder == null ? null : (TextView) baseViewHolder.getView(R.id.tv_music_writer);
            ImageView imageView = baseViewHolder == null ? null : (ImageView) baseViewHolder.getView(R.id.img_logo);
            if (yYKtvMusicModel == null) {
                return;
            }
            YYKtvSearchMusicDialog yYKtvSearchMusicDialog = this.a;
            if (textView != null) {
                textView.setText(a(yYKtvMusicModel.musicName, yYKtvSearchMusicDialog.e));
            }
            if (textView2 != null) {
                textView2.setText(yYKtvMusicModel.artist);
            }
            if (imageView == null) {
                return;
            }
            imageView.setVisibility(TextUtils.equals("Featured", yYKtvMusicModel.recommendType) ? 0 : 8);
        }
    }

    private final void a(Activity activity, final OnSoftKeyboardChangeListener onSoftKeyboardChangeListener) {
        final View decorView = activity.getWindow().getDecorView();
        Intrinsics.c(decorView, "activity.window.decorView");
        decorView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.blued.android.module.yy_china.fragment.YYKtvSearchMusicDialog$observeSoftKeyboard$1
            private int c = -1;
            private final SoftReference<OnSoftKeyboardChangeListener> d;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.d = new SoftReference<>(OnSoftKeyboardChangeListener.this);
            }

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Rect rect = new Rect();
                decorView.getWindowVisibleDisplayFrame(rect);
                int i = rect.bottom;
                int height = decorView.getHeight();
                int i2 = height - i;
                if (this.c != i2) {
                    boolean z = ((double) i) / ((double) height) > 0.8d;
                    OnSoftKeyboardChangeListener onSoftKeyboardChangeListener2 = this.d.get();
                    if (onSoftKeyboardChangeListener2 != null) {
                        onSoftKeyboardChangeListener2.a(i2, true ^ z);
                    }
                }
                this.c = height;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYKtvSearchMusicDialog this$0, View view) {
        EditText editText;
        Intrinsics.e(this$0, "this$0");
        if (!this$0.f) {
            this$0.dismissAllowingStateLoss();
            return;
        }
        FragmentYyKtvSearchMusicBinding fragmentYyKtvSearchMusicBinding = this$0.a;
        Context context = (fragmentYyKtvSearchMusicBinding == null || (editText = fragmentYyKtvSearchMusicBinding.d) == null) ? null : editText.getContext();
        FragmentYyKtvSearchMusicBinding fragmentYyKtvSearchMusicBinding2 = this$0.a;
        KeyboardUtils.b(context, fragmentYyKtvSearchMusicBinding2 == null ? null : fragmentYyKtvSearchMusicBinding2.d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYKtvSearchMusicDialog this$0, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        EditText editText;
        Intrinsics.e(this$0, "this$0");
        YYKtvMusicModel yYKtvMusicModel = null;
        if (this$0.f) {
            FragmentYyKtvSearchMusicBinding fragmentYyKtvSearchMusicBinding = this$0.a;
            Context context = (fragmentYyKtvSearchMusicBinding == null || (editText = fragmentYyKtvSearchMusicBinding.d) == null) ? null : editText.getContext();
            FragmentYyKtvSearchMusicBinding fragmentYyKtvSearchMusicBinding2 = this$0.a;
            KeyboardUtils.b(context, fragmentYyKtvSearchMusicBinding2 == null ? null : fragmentYyKtvSearchMusicBinding2.d);
            return;
        }
        SongAdapter songAdapter = this$0.b;
        if (songAdapter != null) {
            yYKtvMusicModel = (YYKtvMusicModel) songAdapter.getItem(i);
        }
        if (yYKtvMusicModel == null) {
            return;
        }
        if (!YYRoomInfoManager.e().i()) {
            LiveEventBus.get("EVENT_KTV_GUIDE_APPL_UP_MIC").post("");
            YYRoomModel yYRoomModel = this$0.c;
            if (yYRoomModel == null) {
                return;
            }
            EventTrackYY.d(ChatRoomProtos.Event.CHAT_ROOM_KTV_NO_MIKE_SONG_CLICK, yYRoomModel.room_id, yYRoomModel.uid);
        } else if (this$0.l()) {
            String str = yYKtvMusicModel.musicId;
            Intrinsics.c(str, "it.musicId");
            String str2 = yYKtvMusicModel.musicName;
            Intrinsics.c(str2, "it.musicName");
            String str3 = yYKtvMusicModel.artist;
            Intrinsics.c(str3, "it.artist");
            String str4 = yYKtvMusicModel.coverUrl;
            Intrinsics.c(str4, "it.coverUrl");
            this$0.a(str, str2, str3, str4, yYKtvMusicModel.duration);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYKtvSearchMusicDialog this$0, List keywords, View view, int i) {
        EditText editText;
        EditText editText2;
        EditText editText3;
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(keywords, "$keywords");
        this$0.d = "";
        String str = (String) keywords.get(i);
        this$0.e = str;
        if (str != null) {
            FragmentYyKtvSearchMusicBinding fragmentYyKtvSearchMusicBinding = this$0.a;
            if (fragmentYyKtvSearchMusicBinding != null && (editText3 = fragmentYyKtvSearchMusicBinding.d) != null) {
                editText3.setText(str);
            }
            FragmentYyKtvSearchMusicBinding fragmentYyKtvSearchMusicBinding2 = this$0.a;
            if (fragmentYyKtvSearchMusicBinding2 != null && (editText2 = fragmentYyKtvSearchMusicBinding2.d) != null) {
                editText2.setSelection(str.length());
            }
        }
        FragmentYyKtvSearchMusicBinding fragmentYyKtvSearchMusicBinding3 = this$0.a;
        EditText editText4 = null;
        Context context = (fragmentYyKtvSearchMusicBinding3 == null || (editText = fragmentYyKtvSearchMusicBinding3.d) == null) ? null : editText.getContext();
        FragmentYyKtvSearchMusicBinding fragmentYyKtvSearchMusicBinding4 = this$0.a;
        if (fragmentYyKtvSearchMusicBinding4 != null) {
            editText4 = fragmentYyKtvSearchMusicBinding4.d;
        }
        KeyboardUtils.b(context, editText4);
        this$0.i();
    }

    private final void a(final String str, final String str2, String str3, final String str4, long j) {
        YYRoomModel yYRoomModel = this.c;
        String str5 = yYRoomModel == null ? null : yYRoomModel.room_id;
        final ActivityFragmentActive a = a();
        YYRoomHttpUtils.a(str5, str, str2, str3, str4, j, new BluedUIHttpResponse<BluedEntityA<Object>>(a) { // from class: com.blued.android.module.yy_china.fragment.YYKtvSearchMusicDialog$chooseSong$1
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
                    com.blued.android.module.yy_china.fragment.YYKtvSearchMusicDialog r0 = com.blued.android.module.yy_china.fragment.YYKtvSearchMusicDialog.this
                    com.blued.android.module.yy_china.model.YYRoomModel r0 = com.blued.android.module.yy_china.fragment.YYKtvSearchMusicDialog.i(r0)
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
                    com.blued.android.module.yy_china.fragment.YYKtvSearchMusicDialog r0 = com.blued.android.module.yy_china.fragment.YYKtvSearchMusicDialog.this
                    com.blued.android.module.yy_china.model.YYRoomModel r0 = com.blued.android.module.yy_china.fragment.YYKtvSearchMusicDialog.i(r0)
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
                    com.blued.android.module.yy_china.fragment.YYKtvSearchMusicDialog r0 = com.blued.android.module.yy_china.fragment.YYKtvSearchMusicDialog.this
                    com.blued.android.module.yy_china.model.YYRoomModel r0 = com.blued.android.module.yy_china.fragment.YYKtvSearchMusicDialog.i(r0)
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
                    com.blued.android.module.yy_china.fragment.YYKtvSearchMusicDialog r0 = com.blued.android.module.yy_china.fragment.YYKtvSearchMusicDialog.this
                    com.blued.android.module.yy_china.model.YYRoomModel r0 = com.blued.android.module.yy_china.fragment.YYKtvSearchMusicDialog.i(r0)
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
                    com.blued.android.module.yy_china.fragment.YYKtvSearchMusicDialog r0 = com.blued.android.module.yy_china.fragment.YYKtvSearchMusicDialog.this
                    com.blued.android.module.yy_china.model.YYRoomModel r0 = com.blued.android.module.yy_china.fragment.YYKtvSearchMusicDialog.i(r0)
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
                    java.lang.String r0 = "点歌成功"
                    com.blued.android.module.common.utils.ToastUtils.a(r0)
                    com.blued.android.module.yy_china.manager.YYRoomInfoManager r0 = com.blued.android.module.yy_china.manager.YYRoomInfoManager.e()
                    r0.H()
                    r0 = r4
                    com.blued.android.module.yy_china.fragment.YYKtvSearchMusicDialog r0 = com.blued.android.module.yy_china.fragment.YYKtvSearchMusicDialog.this
                    r0.dismissAllowingStateLoss()
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.yy_china.fragment.YYKtvSearchMusicDialog$chooseSong$1.onUIUpdate(com.blued.android.framework.http.parser.BluedEntityA):void");
            }
        }, a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean a(YYKtvSearchMusicDialog this$0, TextView textView, int i, KeyEvent keyEvent) {
        EditText editText;
        EditText editText2;
        Intrinsics.e(this$0, "this$0");
        if (i == 3) {
            FragmentYyKtvSearchMusicBinding fragmentYyKtvSearchMusicBinding = this$0.a;
            String obj = StringsKt.b((CharSequence) String.valueOf((fragmentYyKtvSearchMusicBinding == null || (editText = fragmentYyKtvSearchMusicBinding.d) == null) ? null : editText.getText())).toString();
            this$0.e = obj;
            String str = obj;
            if (str == null || str.length() == 0) {
                this$0.h();
                ToastUtils.a("输入歌曲名称，歌手名进行搜索");
                return true;
            }
            this$0.d = "";
            this$0.i();
            FragmentYyKtvSearchMusicBinding fragmentYyKtvSearchMusicBinding2 = this$0.a;
            Context context = (fragmentYyKtvSearchMusicBinding2 == null || (editText2 = fragmentYyKtvSearchMusicBinding2.d) == null) ? null : editText2.getContext();
            FragmentYyKtvSearchMusicBinding fragmentYyKtvSearchMusicBinding3 = this$0.a;
            KeyboardUtils.b(context, fragmentYyKtvSearchMusicBinding3 == null ? null : fragmentYyKtvSearchMusicBinding3.d);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(YYKtvSearchMusicDialog this$0, View view) {
        EditText editText;
        Intrinsics.e(this$0, "this$0");
        if (this$0.f) {
            FragmentYyKtvSearchMusicBinding fragmentYyKtvSearchMusicBinding = this$0.a;
            Context context = (fragmentYyKtvSearchMusicBinding == null || (editText = fragmentYyKtvSearchMusicBinding.d) == null) ? null : editText.getContext();
            FragmentYyKtvSearchMusicBinding fragmentYyKtvSearchMusicBinding2 = this$0.a;
            KeyboardUtils.b(context, fragmentYyKtvSearchMusicBinding2 == null ? null : fragmentYyKtvSearchMusicBinding2.d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(YYKtvSearchMusicDialog this$0, View view) {
        EditText editText;
        Editable text;
        EditText editText2;
        Editable text2;
        Intrinsics.e(this$0, "this$0");
        FragmentYyKtvSearchMusicBinding fragmentYyKtvSearchMusicBinding = this$0.a;
        CharSequence charSequence = null;
        if (fragmentYyKtvSearchMusicBinding != null && (editText2 = fragmentYyKtvSearchMusicBinding.d) != null && (text2 = editText2.getText()) != null) {
            charSequence = StringsKt.b(text2);
        }
        String valueOf = String.valueOf(charSequence);
        if (valueOf == null || valueOf.length() == 0) {
            this$0.dismissAllowingStateLoss();
            return;
        }
        FragmentYyKtvSearchMusicBinding fragmentYyKtvSearchMusicBinding2 = this$0.a;
        if (fragmentYyKtvSearchMusicBinding2 == null || (editText = fragmentYyKtvSearchMusicBinding2.d) == null || (text = editText.getText()) == null) {
            return;
        }
        text.clear();
    }

    private final void g() {
        SmartRefreshLayout smartRefreshLayout;
        EditText editText;
        TextView textView;
        EditText editText2;
        ShapeLinearLayout shapeLinearLayout;
        ConstraintLayout constraintLayout;
        View view;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            a((Activity) activity, this);
        }
        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(1);
        FragmentYyKtvSearchMusicBinding fragmentYyKtvSearchMusicBinding = this.a;
        RecyclerView recyclerView = fragmentYyKtvSearchMusicBinding == null ? null : fragmentYyKtvSearchMusicBinding.h;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(linearLayoutManager);
        }
        this.b = new SongAdapter(this);
        FragmentYyKtvSearchMusicBinding fragmentYyKtvSearchMusicBinding2 = this.a;
        RecyclerView recyclerView2 = fragmentYyKtvSearchMusicBinding2 == null ? null : fragmentYyKtvSearchMusicBinding2.h;
        if (recyclerView2 != null) {
            recyclerView2.setAdapter(this.b);
        }
        SongAdapter songAdapter = this.b;
        if (songAdapter != null) {
            songAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYKtvSearchMusicDialog$pTxmu6J98SnFUTDQgrEI9bJ99oA
                public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view2, int i) {
                    YYKtvSearchMusicDialog.a(YYKtvSearchMusicDialog.this, baseQuickAdapter, view2, i);
                }
            });
        }
        FragmentYyKtvSearchMusicBinding fragmentYyKtvSearchMusicBinding3 = this.a;
        if (fragmentYyKtvSearchMusicBinding3 != null && (view = fragmentYyKtvSearchMusicBinding3.b) != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYKtvSearchMusicDialog$f6WkvuCefxiR7knOK2aU9ZrKgUE
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    YYKtvSearchMusicDialog.a(YYKtvSearchMusicDialog.this, view2);
                }
            });
        }
        FragmentYyKtvSearchMusicBinding fragmentYyKtvSearchMusicBinding4 = this.a;
        if (fragmentYyKtvSearchMusicBinding4 != null && (constraintLayout = fragmentYyKtvSearchMusicBinding4.a) != null) {
            constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYKtvSearchMusicDialog$iq8uGJBdZB5olYV-IY1za6ICoS0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    YYKtvSearchMusicDialog.b(YYKtvSearchMusicDialog.this, view2);
                }
            });
        }
        FragmentYyKtvSearchMusicBinding fragmentYyKtvSearchMusicBinding5 = this.a;
        if (fragmentYyKtvSearchMusicBinding5 != null && (shapeLinearLayout = fragmentYyKtvSearchMusicBinding5.f) != null) {
            shapeLinearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYKtvSearchMusicDialog$nT4fmxRnQPg2czQzMJpWxoX71c4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    YYKtvSearchMusicDialog.a(view2);
                }
            });
        }
        FragmentYyKtvSearchMusicBinding fragmentYyKtvSearchMusicBinding6 = this.a;
        if (fragmentYyKtvSearchMusicBinding6 != null && (editText2 = fragmentYyKtvSearchMusicBinding6.d) != null) {
            editText2.addTextChangedListener(new ITextWatcher() { // from class: com.blued.android.module.yy_china.fragment.YYKtvSearchMusicDialog$initView$6
                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    YYKtvSearchMusicDialog.this.e = StringsKt.b((CharSequence) String.valueOf(editable)).toString();
                    String str = YYKtvSearchMusicDialog.this.e;
                    if (str == null || str.length() == 0) {
                        YYKtvSearchMusicDialog.this.h();
                        return;
                    }
                    YYKtvSearchMusicDialog.this.d = "";
                    YYKtvSearchMusicDialog.this.i();
                }
            });
        }
        FragmentYyKtvSearchMusicBinding fragmentYyKtvSearchMusicBinding7 = this.a;
        if (fragmentYyKtvSearchMusicBinding7 != null && (textView = fragmentYyKtvSearchMusicBinding7.j) != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYKtvSearchMusicDialog$zIKDU2K4TTgqlefDkiVqWl5agyk
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    YYKtvSearchMusicDialog.c(YYKtvSearchMusicDialog.this, view2);
                }
            });
        }
        FragmentYyKtvSearchMusicBinding fragmentYyKtvSearchMusicBinding8 = this.a;
        if (fragmentYyKtvSearchMusicBinding8 != null && (editText = fragmentYyKtvSearchMusicBinding8.d) != null) {
            editText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYKtvSearchMusicDialog$AXseWWrKJ4v9GXAoBhp3xxoxL9Y
                @Override // android.widget.TextView.OnEditorActionListener
                public final boolean onEditorAction(TextView textView2, int i, KeyEvent keyEvent) {
                    boolean a;
                    a = YYKtvSearchMusicDialog.a(YYKtvSearchMusicDialog.this, textView2, i, keyEvent);
                    return a;
                }
            });
        }
        FragmentYyKtvSearchMusicBinding fragmentYyKtvSearchMusicBinding9 = this.a;
        if (fragmentYyKtvSearchMusicBinding9 == null || (smartRefreshLayout = fragmentYyKtvSearchMusicBinding9.i) == null) {
            return;
        }
        smartRefreshLayout.a(new OnRefreshLoadMoreListener() { // from class: com.blued.android.module.yy_china.fragment.YYKtvSearchMusicDialog$initView$9
            public void onLoadMore(RefreshLayout refreshLayout) {
                Intrinsics.e(refreshLayout, "refreshLayout");
                YYKtvSearchMusicDialog.this.i();
            }

            public void onRefresh(RefreshLayout refreshLayout) {
                Intrinsics.e(refreshLayout, "refreshLayout");
                YYKtvSearchMusicDialog.this.d = "";
                YYKtvSearchMusicDialog.this.i();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h() {
        FlowLayout flowLayout;
        FlowLayout flowLayout2;
        FlowLayout flowLayout3;
        KeyboardUtils.a(getActivity());
        ArrayList<String> d = YYRoomPreferences.d();
        Intrinsics.c(d, "getSearchRecords()");
        final ArrayList<String> arrayList = d;
        FragmentYyKtvSearchMusicBinding fragmentYyKtvSearchMusicBinding = this.a;
        SmartRefreshLayout smartRefreshLayout = fragmentYyKtvSearchMusicBinding == null ? null : fragmentYyKtvSearchMusicBinding.i;
        if (smartRefreshLayout != null) {
            smartRefreshLayout.setVisibility(8);
        }
        FragmentYyKtvSearchMusicBinding fragmentYyKtvSearchMusicBinding2 = this.a;
        LinearLayout linearLayout = fragmentYyKtvSearchMusicBinding2 == null ? null : fragmentYyKtvSearchMusicBinding2.e;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
        }
        FragmentYyKtvSearchMusicBinding fragmentYyKtvSearchMusicBinding3 = this.a;
        if (fragmentYyKtvSearchMusicBinding3 != null && (flowLayout3 = fragmentYyKtvSearchMusicBinding3.g) != null) {
            flowLayout3.removeAllViews();
        }
        for (String str : arrayList) {
            View inflate = View.inflate(getContext(), R.layout.item_tab_text_view, null);
            ShapeTextView shapeTextView = (ShapeTextView) inflate.findViewById(R.id.tv_tab_text);
            if (shapeTextView != null) {
                shapeTextView.setText(str);
            }
            FragmentYyKtvSearchMusicBinding fragmentYyKtvSearchMusicBinding4 = this.a;
            if (fragmentYyKtvSearchMusicBinding4 != null && (flowLayout2 = fragmentYyKtvSearchMusicBinding4.g) != null) {
                flowLayout2.addView(inflate);
            }
        }
        FragmentYyKtvSearchMusicBinding fragmentYyKtvSearchMusicBinding5 = this.a;
        if (fragmentYyKtvSearchMusicBinding5 == null || (flowLayout = fragmentYyKtvSearchMusicBinding5.g) == null) {
            return;
        }
        flowLayout.setOnItemClickListener(new FlowLayout.OnItemClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYKtvSearchMusicDialog$VxFnNbs9exJgXvnJZi95XBoGJxU
            @Override // com.blued.android.module.common.view.FlowLayout.OnItemClickListener
            public final void onItemClick(View view, int i) {
                YYKtvSearchMusicDialog.a(YYKtvSearchMusicDialog.this, arrayList, view, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i() {
        FragmentYyKtvSearchMusicBinding fragmentYyKtvSearchMusicBinding = this.a;
        SmartRefreshLayout smartRefreshLayout = fragmentYyKtvSearchMusicBinding == null ? null : fragmentYyKtvSearchMusicBinding.i;
        if (smartRefreshLayout != null) {
            smartRefreshLayout.setVisibility(0);
        }
        FragmentYyKtvSearchMusicBinding fragmentYyKtvSearchMusicBinding2 = this.a;
        LinearLayout linearLayout = fragmentYyKtvSearchMusicBinding2 == null ? null : fragmentYyKtvSearchMusicBinding2.e;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        String str = this.e;
        String str2 = this.d;
        final ActivityFragmentActive a = a();
        YYRoomHttpUtils.d(str, str2, "1", (BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntity<YYKtvMusicModel, YYKtvMusicExtra>>(a) { // from class: com.blued.android.module.yy_china.fragment.YYKtvSearchMusicDialog$showMusicListUI$1
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish(boolean z) {
                String str3;
                FragmentYyKtvSearchMusicBinding fragmentYyKtvSearchMusicBinding3;
                SmartRefreshLayout smartRefreshLayout2;
                FragmentYyKtvSearchMusicBinding fragmentYyKtvSearchMusicBinding4;
                SmartRefreshLayout smartRefreshLayout3;
                super.onUIFinish(z);
                str3 = YYKtvSearchMusicDialog.this.d;
                if (TextUtils.isEmpty(str3)) {
                    fragmentYyKtvSearchMusicBinding3 = YYKtvSearchMusicDialog.this.a;
                    if (fragmentYyKtvSearchMusicBinding3 != null && (smartRefreshLayout2 = fragmentYyKtvSearchMusicBinding3.i) != null) {
                        smartRefreshLayout2.b(false);
                    }
                } else {
                    fragmentYyKtvSearchMusicBinding4 = YYKtvSearchMusicDialog.this.a;
                    if (fragmentYyKtvSearchMusicBinding4 != null && (smartRefreshLayout3 = fragmentYyKtvSearchMusicBinding4.i) != null) {
                        smartRefreshLayout3.b(true);
                    }
                }
                YYKtvSearchMusicDialog.this.j();
            }

            /* JADX WARN: Code restructure failed: missing block: B:25:0x006b, code lost:
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
                    if (r0 == 0) goto La6
                    r0 = r4
                    boolean r0 = r0.hasData()
                    if (r0 != 0) goto Le
                    goto La6
                Le:
                    r0 = r4
                    java.util.List<T> r0 = r0.data
                    r6 = r0
                    r0 = 0
                    r5 = r0
                    r0 = r6
                    if (r0 != 0) goto L1c
                    goto L2a
                L1c:
                    r0 = r6
                    java.util.Collection r0 = (java.util.Collection) r0
                    boolean r0 = r0.isEmpty()
                    if (r0 != 0) goto L2a
                    r0 = 1
                    r5 = r0
                L2a:
                    r0 = r5
                    if (r0 == 0) goto L35
                    r0 = r3
                    com.blued.android.module.yy_china.fragment.YYKtvSearchMusicDialog r0 = com.blued.android.module.yy_china.fragment.YYKtvSearchMusicDialog.this
                    com.blued.android.module.yy_china.fragment.YYKtvSearchMusicDialog.e(r0)
                L35:
                    r0 = r3
                    com.blued.android.module.yy_china.fragment.YYKtvSearchMusicDialog r0 = com.blued.android.module.yy_china.fragment.YYKtvSearchMusicDialog.this
                    java.lang.String r0 = com.blued.android.module.yy_china.fragment.YYKtvSearchMusicDialog.f(r0)
                    java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                    boolean r0 = android.text.TextUtils.isEmpty(r0)
                    if (r0 == 0) goto L5f
                    r0 = r3
                    com.blued.android.module.yy_china.fragment.YYKtvSearchMusicDialog r0 = com.blued.android.module.yy_china.fragment.YYKtvSearchMusicDialog.this
                    com.blued.android.module.yy_china.fragment.YYKtvSearchMusicDialog$SongAdapter r0 = com.blued.android.module.yy_china.fragment.YYKtvSearchMusicDialog.g(r0)
                    r6 = r0
                    r0 = r6
                    if (r0 != 0) goto L54
                    goto L85
                L54:
                    r0 = r6
                    r1 = r4
                    java.util.List<T> r1 = r1.data
                    r0.setNewData(r1)
                    goto L85
                L5f:
                    r0 = r4
                    java.util.List<T> r0 = r0.data
                    r6 = r0
                    r0 = r6
                    if (r0 != 0) goto L6b
                    goto L85
                L6b:
                    r0 = r3
                    com.blued.android.module.yy_china.fragment.YYKtvSearchMusicDialog r0 = com.blued.android.module.yy_china.fragment.YYKtvSearchMusicDialog.this
                    com.blued.android.module.yy_china.fragment.YYKtvSearchMusicDialog$SongAdapter r0 = com.blued.android.module.yy_china.fragment.YYKtvSearchMusicDialog.g(r0)
                    r7 = r0
                    r0 = r7
                    if (r0 != 0) goto L7c
                    goto L85
                L7c:
                    r0 = r7
                    r1 = r6
                    java.util.Collection r1 = (java.util.Collection) r1
                    r0.addData(r1)
                L85:
                    r0 = r3
                    com.blued.android.module.yy_china.fragment.YYKtvSearchMusicDialog r0 = com.blued.android.module.yy_china.fragment.YYKtvSearchMusicDialog.this
                    r6 = r0
                    r0 = r4
                    S extends com.blued.android.framework.http.parser.BluedEntityBaseExtra r0 = r0.extra
                    com.blued.android.module.yy_china.model.YYKtvMusicExtra r0 = (com.blued.android.module.yy_china.model.YYKtvMusicExtra) r0
                    r4 = r0
                    r0 = r4
                    if (r0 != 0) goto L9b
                    r0 = 0
                    r4 = r0
                    goto La0
                L9b:
                    r0 = r4
                    java.lang.String r0 = r0.ScrollToken
                    r4 = r0
                La0:
                    r0 = r6
                    r1 = r4
                    com.blued.android.module.yy_china.fragment.YYKtvSearchMusicDialog.b(r0, r1)
                    return
                La6:
                    r0 = r3
                    com.blued.android.module.yy_china.fragment.YYKtvSearchMusicDialog r0 = com.blued.android.module.yy_china.fragment.YYKtvSearchMusicDialog.this
                    com.blued.android.module.yy_china.fragment.YYKtvSearchMusicDialog.d(r0)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.yy_china.fragment.YYKtvSearchMusicDialog$showMusicListUI$1.onUIUpdate(com.blued.android.framework.http.parser.BluedEntity):void");
            }
        }, a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j() {
        SmartRefreshLayout smartRefreshLayout;
        SmartRefreshLayout smartRefreshLayout2;
        FragmentYyKtvSearchMusicBinding fragmentYyKtvSearchMusicBinding = this.a;
        if (fragmentYyKtvSearchMusicBinding != null && (smartRefreshLayout2 = fragmentYyKtvSearchMusicBinding.i) != null) {
            smartRefreshLayout2.h();
        }
        FragmentYyKtvSearchMusicBinding fragmentYyKtvSearchMusicBinding2 = this.a;
        if (fragmentYyKtvSearchMusicBinding2 == null || (smartRefreshLayout = fragmentYyKtvSearchMusicBinding2.i) == null) {
            return;
        }
        smartRefreshLayout.g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(YYKtvSearchMusicDialog this$0) {
        Intrinsics.e(this$0, "this$0");
        ArrayList<String> d = YYRoomPreferences.d();
        Intrinsics.c(d, "getSearchRecords()");
        if (TextUtils.isEmpty(this$0.e)) {
            return;
        }
        ChatRoomProtos.Event event = ChatRoomProtos.Event.CHAT_ROOM_KTV_SONG_SEARCH;
        YYRoomModel yYRoomModel = this$0.c;
        String str = null;
        String str2 = yYRoomModel == null ? null : yYRoomModel.room_id;
        YYRoomModel yYRoomModel2 = this$0.c;
        if (yYRoomModel2 != null) {
            str = yYRoomModel2.uid;
        }
        EventTrackYY.g(event, str2, str, this$0.e);
        if (CollectionsKt.a((Iterable<? extends String>) d, this$0.e)) {
            TypeIntrinsics.c(d).remove(this$0.e);
        }
        String str3 = this$0.e;
        if (str3 != null) {
            d.add(0, str3);
        }
        if (d.size() <= 6) {
            YYRoomPreferences.a(d);
            return;
        }
        List<String> subList = d.subList(0, 6);
        Intrinsics.c(subList, "keywords.subList(0, 6)");
        YYRoomPreferences.a(subList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k() {
        ThreadManager.a().a(new Runnable() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYKtvSearchMusicDialog$P6qb6xoVHNkhIECJpfuhfbahppM
            @Override // java.lang.Runnable
            public final void run() {
                YYKtvSearchMusicDialog.j(YYKtvSearchMusicDialog.this);
            }
        });
    }

    private final boolean l() {
        YYKtvCardModel yYKtvCardModel = this.g;
        if (yYKtvCardModel == null) {
            return false;
        }
        String str = yYKtvCardModel.sing_limit;
        if ((str != null && Integer.parseInt(str) > 0) || yYKtvCardModel.free_sing_limit > 0) {
            return true;
        }
        BaseYYStudioFragment f = f();
        if (f != null) {
            YYGiftModel yYGiftModel = yYKtvCardModel.goods_info;
            f.b(yYGiftModel == null ? null : yYGiftModel.goods_id, "");
        }
        dismiss();
        return false;
    }

    @Override // com.blued.android.module.yy_china.fragment.OnSoftKeyboardChangeListener
    public void a(int i, boolean z) {
        this.f = z;
    }

    public final void a(BaseYYStudioFragment baseYYStudioFragment) {
        this.h = baseYYStudioFragment;
    }

    public final void a(YYKtvCardModel yYKtvCardModel) {
        this.g = yYKtvCardModel;
    }

    public final BaseYYStudioFragment f() {
        return this.h;
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
        this.a = FragmentYyKtvSearchMusicBinding.a(inflate);
        g();
        return inflate;
    }

    @Override // com.blued.android.module.yy_china.fragment.BaseFullScreenDialog, com.blued.android.core.ui.BaseDialogFragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.e(view, "view");
        super.onViewCreated(view, bundle);
        h();
    }
}
