package com.blued.android.module.yy_china.view;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.utils.toast.ToastUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.ViewYyBroadcastLayoutBinding;
import com.blued.android.module.yy_china.fragment.BaseFullScreenDialog;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYRoomDescModel;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.utils.EnglishCharFilter;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.jeremyliao.liveeventbus.LiveEventBus;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYBroadcastView.class */
public final class YYBroadcastView extends BaseFullScreenDialog {
    private BaseYYStudioFragment a;
    private YYRoomModel b;
    private ViewYyBroadcastLayoutBinding c;
    private boolean d;
    private boolean e;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYBroadcastView this$0) {
        EditText editText;
        Integer valueOf;
        EditText editText2;
        Intrinsics.e(this$0, "this$0");
        ViewYyBroadcastLayoutBinding viewYyBroadcastLayoutBinding = this$0.c;
        EditText editText3 = viewYyBroadcastLayoutBinding == null ? null : viewYyBroadcastLayoutBinding.b;
        if (editText3 != null) {
            editText3.setFocusableInTouchMode(true);
        }
        ViewYyBroadcastLayoutBinding viewYyBroadcastLayoutBinding2 = this$0.c;
        EditText editText4 = viewYyBroadcastLayoutBinding2 == null ? null : viewYyBroadcastLayoutBinding2.b;
        if (editText4 != null) {
            editText4.setFocusable(true);
        }
        ViewYyBroadcastLayoutBinding viewYyBroadcastLayoutBinding3 = this$0.c;
        if (viewYyBroadcastLayoutBinding3 != null && (editText2 = viewYyBroadcastLayoutBinding3.b) != null) {
            editText2.requestFocus();
        }
        Context context = this$0.getContext();
        Object systemService = context == null ? null : context.getSystemService("input_method");
        if (systemService instanceof InputMethodManager) {
            InputMethodManager inputMethodManager = (InputMethodManager) systemService;
            ViewYyBroadcastLayoutBinding viewYyBroadcastLayoutBinding4 = this$0.c;
            inputMethodManager.showSoftInput(viewYyBroadcastLayoutBinding4 == null ? null : viewYyBroadcastLayoutBinding4.b, 0);
        }
        ViewYyBroadcastLayoutBinding viewYyBroadcastLayoutBinding5 = this$0.c;
        if (viewYyBroadcastLayoutBinding5 == null || (editText = viewYyBroadcastLayoutBinding5.b) == null) {
            return;
        }
        ViewYyBroadcastLayoutBinding viewYyBroadcastLayoutBinding6 = this$0.c;
        if (viewYyBroadcastLayoutBinding6 == null) {
            valueOf = null;
        } else {
            EditText editText5 = viewYyBroadcastLayoutBinding6.b;
            if (editText5 == null) {
                valueOf = null;
            } else {
                Editable text = editText5.getText();
                valueOf = text == null ? null : Integer.valueOf(text.length());
            }
        }
        Intrinsics.a(valueOf);
        editText.setSelection(valueOf.intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYBroadcastView this$0, View view) {
        EditText editText;
        Intrinsics.e(this$0, "this$0");
        ViewYyBroadcastLayoutBinding viewYyBroadcastLayoutBinding = this$0.c;
        Editable editable = null;
        if (viewYyBroadcastLayoutBinding != null && (editText = viewYyBroadcastLayoutBinding.b) != null) {
            editable = editText.getText();
        }
        String valueOf = String.valueOf(editable);
        int length = valueOf.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean z2 = Intrinsics.a((int) valueOf.charAt(!z ? i : length), 32) <= 0;
            if (z) {
                if (!z2) {
                    break;
                }
                length--;
            } else if (z2) {
                i++;
            } else {
                z = true;
            }
        }
        String obj = valueOf.subSequence(i, length + 1).toString();
        String str = obj;
        if (TextUtils.isEmpty(obj)) {
            str = this$0.getResources().getString(R.string.yy_live_notice);
            Intrinsics.c(str, "resources.getString(R.string.yy_live_notice)");
        }
        this$0.a(str);
    }

    private final void a(final String str) {
        if (this.b == null) {
            return;
        }
        ChatRoomProtos.Event event = ChatRoomProtos.Event.CHAT_ROOM_NOTICE_SAVE_CLICK;
        YYRoomModel yYRoomModel = this.b;
        String str2 = yYRoomModel == null ? null : yYRoomModel.room_id;
        YYRoomModel yYRoomModel2 = this.b;
        EventTrackYY.d(event, str2, yYRoomModel2 == null ? null : yYRoomModel2.uid);
        YYRoomModel yYRoomModel3 = this.b;
        String str3 = yYRoomModel3 == null ? null : yYRoomModel3.room_id;
        YYRoomModel yYRoomModel4 = this.b;
        String str4 = yYRoomModel4 == null ? null : yYRoomModel4.type_id;
        BaseYYStudioFragment baseYYStudioFragment = this.a;
        final ActivityFragmentActive fragmentActive = baseYYStudioFragment == null ? null : baseYYStudioFragment.getFragmentActive();
        BluedUIHttpResponse<BluedEntity<?, ?>> bluedUIHttpResponse = new BluedUIHttpResponse<BluedEntity<?, ?>>(fragmentActive) { // from class: com.blued.android.module.yy_china.view.YYBroadcastView$sendBroadcast$1
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish(boolean z) {
                super.onUIFinish(z);
                ViewYyBroadcastLayoutBinding h = YYBroadcastView.this.h();
                FrameLayout frameLayout = h == null ? null : h.c;
                if (frameLayout == null) {
                    return;
                }
                frameLayout.setVisibility(8);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
                ViewYyBroadcastLayoutBinding h = YYBroadcastView.this.h();
                FrameLayout frameLayout = h == null ? null : h.c;
                if (frameLayout == null) {
                    return;
                }
                frameLayout.setVisibility(0);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<?, ?> bluedEntity) {
                EditText editText;
                ToastUtils.a("保存成功", 0);
                YYRoomModel g = YYBroadcastView.this.g();
                if (g != null) {
                    g.room_desc = str;
                }
                LiveEventBus.get("notify_room_renote").post(str);
                if (YYBroadcastView.this.f() != null) {
                    ViewYyBroadcastLayoutBinding h = YYBroadcastView.this.h();
                    if (h != null && (editText = h.b) != null) {
                        editText.setText("");
                    }
                    BaseYYStudioFragment f = YYBroadcastView.this.f();
                    KeyboardUtils.a((Activity) (f == null ? null : f.getActivity()));
                }
                YYBroadcastView.this.dismissAllowingStateLoss();
            }
        };
        BaseYYStudioFragment baseYYStudioFragment2 = this.a;
        YYRoomHttpUtils.a(str3, "", str, str4, (BluedUIHttpResponse) bluedUIHttpResponse, (IRequestHost) (baseYYStudioFragment2 == null ? null : baseYYStudioFragment2.getFragmentActive()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(YYBroadcastView this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(YYBroadcastView this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    private final void i() {
        EditText editText;
        EditText editText2;
        LinearLayout linearLayout;
        ScrollView scrollView;
        TextView textView;
        ImageView imageView;
        ImageView imageView2;
        ImageView imageView3;
        ShapeTextView shapeTextView;
        EnglishCharFilter englishCharFilter = new EnglishCharFilter(500);
        englishCharFilter.a(new EnglishCharFilter.OnEnglishCharFilterToMaxLenListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYBroadcastView$0MlJeT0g0PLX8Xh7QD-Gef2g0JA
            @Override // com.blued.android.module.yy_china.utils.EnglishCharFilter.OnEnglishCharFilterToMaxLenListener
            public final void onMaxLen() {
                YYBroadcastView.k();
            }
        });
        ViewYyBroadcastLayoutBinding viewYyBroadcastLayoutBinding = this.c;
        EditText editText3 = viewYyBroadcastLayoutBinding == null ? null : viewYyBroadcastLayoutBinding.b;
        boolean z = true;
        if (editText3 != null) {
            editText3.setFilters(new InputFilter[]{englishCharFilter});
        }
        ViewYyBroadcastLayoutBinding viewYyBroadcastLayoutBinding2 = this.c;
        if (viewYyBroadcastLayoutBinding2 != null && (shapeTextView = viewYyBroadcastLayoutBinding2.a) != null) {
            shapeTextView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYBroadcastView$Hnwi7ir1j8H4pCbQ_JdL0H3CaTo
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YYBroadcastView.a(YYBroadcastView.this, view);
                }
            });
        }
        ViewYyBroadcastLayoutBinding viewYyBroadcastLayoutBinding3 = this.c;
        if (viewYyBroadcastLayoutBinding3 != null && (imageView3 = viewYyBroadcastLayoutBinding3.e) != null) {
            imageView3.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYBroadcastView$HTZ8ztK-qhFNRqfNggeM_SPKLXE
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YYBroadcastView.b(YYBroadcastView.this, view);
                }
            });
        }
        ViewYyBroadcastLayoutBinding viewYyBroadcastLayoutBinding4 = this.c;
        if (viewYyBroadcastLayoutBinding4 != null && (imageView2 = viewYyBroadcastLayoutBinding4.d) != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYBroadcastView$vcfECB4hN3pDbXBLNL0_vntT8F0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YYBroadcastView.c(YYBroadcastView.this, view);
                }
            });
        }
        YYRoomModel yYRoomModel = this.b;
        if (yYRoomModel == null) {
            return;
        }
        if (TextUtils.isEmpty(yYRoomModel == null ? null : yYRoomModel.room_desc)) {
            ViewYyBroadcastLayoutBinding viewYyBroadcastLayoutBinding5 = this.c;
            EditText editText4 = viewYyBroadcastLayoutBinding5 == null ? null : viewYyBroadcastLayoutBinding5.b;
            if (editText4 != null) {
                editText4.setHint(getResources().getString(R.string.yy_live_notice));
            }
        } else {
            ViewYyBroadcastLayoutBinding viewYyBroadcastLayoutBinding6 = this.c;
            if (viewYyBroadcastLayoutBinding6 != null && (editText = viewYyBroadcastLayoutBinding6.b) != null) {
                YYRoomModel yYRoomModel2 = this.b;
                editText.setText(yYRoomModel2 == null ? null : yYRoomModel2.room_desc);
            }
        }
        j();
        if (this.a != null) {
            ViewYyBroadcastLayoutBinding viewYyBroadcastLayoutBinding7 = this.c;
            if (viewYyBroadcastLayoutBinding7 == null || (editText2 = viewYyBroadcastLayoutBinding7.b) == null || !editText2.isEnabled()) {
                z = false;
            }
            if (z) {
                BaseYYStudioFragment baseYYStudioFragment = this.a;
                if (baseYYStudioFragment != null) {
                    baseYYStudioFragment.postDelaySafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYBroadcastView$LC-sQVZNMmDHjx9WPqzP1EXF1_I
                        @Override // java.lang.Runnable
                        public final void run() {
                            YYBroadcastView.a(YYBroadcastView.this);
                        }
                    }, 200L);
                }
                ViewYyBroadcastLayoutBinding viewYyBroadcastLayoutBinding8 = this.c;
                EditText editText5 = viewYyBroadcastLayoutBinding8 == null ? null : viewYyBroadcastLayoutBinding8.b;
                if (editText5 != null) {
                    editText5.setEnabled(this.d);
                }
                ViewYyBroadcastLayoutBinding viewYyBroadcastLayoutBinding9 = this.c;
                ShapeTextView shapeTextView2 = viewYyBroadcastLayoutBinding9 == null ? null : viewYyBroadcastLayoutBinding9.a;
                if (shapeTextView2 != null) {
                    shapeTextView2.setVisibility(this.e ? 0 : 8);
                }
                if (this.e) {
                    ViewYyBroadcastLayoutBinding viewYyBroadcastLayoutBinding10 = this.c;
                    if (viewYyBroadcastLayoutBinding10 != null && (imageView = viewYyBroadcastLayoutBinding10.e) != null) {
                        imageView.setImageResource(R.drawable.icon_back_yy_broadcast);
                    }
                    ViewYyBroadcastLayoutBinding viewYyBroadcastLayoutBinding11 = this.c;
                    if (viewYyBroadcastLayoutBinding11 != null && (textView = viewYyBroadcastLayoutBinding11.h) != null) {
                        textView.setText(R.string.yy_edit_room_notic);
                    }
                    ViewYyBroadcastLayoutBinding viewYyBroadcastLayoutBinding12 = this.c;
                    ViewGroup.LayoutParams layoutParams = (viewYyBroadcastLayoutBinding12 == null || (linearLayout = viewYyBroadcastLayoutBinding12.f) == null) ? null : linearLayout.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = -1;
                    }
                    ViewYyBroadcastLayoutBinding viewYyBroadcastLayoutBinding13 = this.c;
                    LinearLayout linearLayout2 = viewYyBroadcastLayoutBinding13 == null ? null : viewYyBroadcastLayoutBinding13.f;
                    if (linearLayout2 != null) {
                        linearLayout2.setLayoutParams(layoutParams);
                    }
                    ViewYyBroadcastLayoutBinding viewYyBroadcastLayoutBinding14 = this.c;
                    ViewGroup.LayoutParams layoutParams2 = (viewYyBroadcastLayoutBinding14 == null || (scrollView = viewYyBroadcastLayoutBinding14.g) == null) ? null : scrollView.getLayoutParams();
                    if (layoutParams2 != null) {
                        layoutParams2.height = -1;
                    }
                    ViewYyBroadcastLayoutBinding viewYyBroadcastLayoutBinding15 = this.c;
                    ScrollView scrollView2 = viewYyBroadcastLayoutBinding15 == null ? null : viewYyBroadcastLayoutBinding15.g;
                    if (scrollView2 == null) {
                        return;
                    }
                    scrollView2.setLayoutParams(layoutParams2);
                }
            }
        }
    }

    private final void j() {
        YYRoomModel yYRoomModel = this.b;
        if (yYRoomModel == null) {
            return;
        }
        Intrinsics.a(yYRoomModel);
        String str = yYRoomModel.room_id;
        BaseYYStudioFragment baseYYStudioFragment = this.a;
        Intrinsics.a(baseYYStudioFragment);
        final ActivityFragmentActive fragmentActive = baseYYStudioFragment.getFragmentActive();
        BluedUIHttpResponse<BluedEntityA<YYRoomDescModel>> bluedUIHttpResponse = new BluedUIHttpResponse<BluedEntityA<YYRoomDescModel>>(fragmentActive) { // from class: com.blued.android.module.yy_china.view.YYBroadcastView$getBroadcastContent$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<YYRoomDescModel> bluedEntityA) {
                ViewYyBroadcastLayoutBinding h;
                EditText editText;
                if (bluedEntityA == null || !bluedEntityA.hasData() || (h = YYBroadcastView.this.h()) == null || (editText = h.b) == null) {
                    return;
                }
                editText.setText(bluedEntityA.getSingleData().room_desc);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish(boolean z) {
                super.onUIFinish(z);
                ViewYyBroadcastLayoutBinding h = YYBroadcastView.this.h();
                FrameLayout frameLayout = h == null ? null : h.c;
                if (frameLayout == null) {
                    return;
                }
                frameLayout.setVisibility(8);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
                ViewYyBroadcastLayoutBinding h = YYBroadcastView.this.h();
                FrameLayout frameLayout = h == null ? null : h.c;
                if (frameLayout == null) {
                    return;
                }
                frameLayout.setVisibility(0);
            }
        };
        BaseYYStudioFragment baseYYStudioFragment2 = this.a;
        Intrinsics.a(baseYYStudioFragment2);
        YYRoomHttpUtils.q(str, (BluedUIHttpResponse) bluedUIHttpResponse, (IRequestHost) baseYYStudioFragment2.getFragmentActive());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k() {
        ToastUtils.a("已超出最大编辑字数", 0);
    }

    public final void a(BaseYYStudioFragment fragment, boolean z, boolean z2) {
        Intrinsics.e(fragment, "fragment");
        this.a = fragment;
        this.b = YYRoomInfoManager.e().b();
        this.d = z;
        this.e = z2;
    }

    @Override // com.blued.android.module.yy_china.fragment.BaseFullScreenDialog
    public boolean d() {
        return true;
    }

    public final BaseYYStudioFragment f() {
        return this.a;
    }

    public final YYRoomModel g() {
        return this.b;
    }

    public final ViewYyBroadcastLayoutBinding h() {
        return this.c;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.e(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.view_yy_broadcast_layout, viewGroup, true);
        Intrinsics.c(inflate, "inflater.inflate(R.layou…_layout, container, true)");
        this.c = ViewYyBroadcastLayoutBinding.a(inflate);
        i();
        return inflate;
    }
}
