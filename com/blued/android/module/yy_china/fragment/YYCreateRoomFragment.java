package com.blued.android.module.yy_china.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.image.ImageWrapper;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.framework.utils.ClickUtils;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.framework.utils.upload.QiniuUploadTools;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeRelativeLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.user.model.BluedAlbum;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.adapter.ClickRoomBgListener;
import com.blued.android.module.yy_china.adapter.CreateRoomBgAdapter;
import com.blued.android.module.yy_china.adapter.CreateRoomLabelAdapter;
import com.blued.android.module.yy_china.adapter.CreateRoomTypeAdapter;
import com.blued.android.module.yy_china.databinding.FragmentYyCreateRoomBinding;
import com.blued.android.module.yy_china.listener.OnYYCreateRoomSelectPhotoListener;
import com.blued.android.module.yy_china.model.BgCollectionMode;
import com.blued.android.module.yy_china.model.HomeTopicModel;
import com.blued.android.module.yy_china.model.VeiledRoomInfoMode;
import com.blued.android.module.yy_china.model.YYCreateTypeMode;
import com.blued.android.module.yy_china.model.YYRoomExtraModel;
import com.blued.android.module.yy_china.presenter.YYCreateRoomPreSenter;
import com.blued.android.module.yy_china.utils.EnglishCharFilter;
import com.blued.android.module.yy_china.utils.PopupwindowFactory;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.bytedance.applog.tracker.Tracker;
import com.qiniu.android.storage.Configuration;
import java.io.File;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYCreateRoomFragment.class */
public final class YYCreateRoomFragment extends MvpFragment<YYCreateRoomPreSenter> implements TextWatcher, View.OnClickListener, OnClickRoomLabelListener, OnClickRoomTypeListener, OnYYCreateRoomSelectPhotoListener {
    public static final Companion a = new Companion(null);
    private FragmentYyCreateRoomBinding b;
    private CreateRoomTypeAdapter c;
    private CreateRoomLabelAdapter d;
    private CreateRoomBgAdapter e;
    private YYCreateTypeMode f;
    private HomeTopicModel g;
    private BgCollectionMode k;
    private String l;
    private String m;
    private YYCreateRoomSelectPhotoDialog n;
    private int o;
    private boolean p = true;

    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYCreateRoomFragment$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Fragment fragment, String selectTypeId, boolean z, int i) {
            Intrinsics.e(fragment, "fragment");
            Intrinsics.e(selectTypeId, "selectTypeId");
            Bundle bundle = new Bundle();
            bundle.putString("data", selectTypeId);
            bundle.putBoolean("isShowRight", z);
            bundle.putInt("anchor_level", i);
            TerminalActivity.a(bundle);
            TerminalActivity.b(bundle);
            TerminalActivity.a(fragment, YYCreateRoomFragment.class, bundle, 10001);
        }
    }

    private final void D() {
        EditText editText;
        FragmentYyCreateRoomBinding fragmentYyCreateRoomBinding = this.b;
        EditText editText2 = fragmentYyCreateRoomBinding == null ? null : fragmentYyCreateRoomBinding.a;
        if (editText2 != null) {
            editText2.setFilters(new InputFilter[]{new EnglishCharFilter(32)});
        }
        FragmentYyCreateRoomBinding fragmentYyCreateRoomBinding2 = this.b;
        if (fragmentYyCreateRoomBinding2 == null || (editText = fragmentYyCreateRoomBinding2.a) == null) {
            return;
        }
        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYCreateRoomFragment$uScrtBvTTN8d7VzlwMdaQtZnhnI
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                YYCreateRoomFragment.a(YYCreateRoomFragment.this, view, z);
            }
        });
    }

    private final void E() {
        FragmentYyCreateRoomBinding fragmentYyCreateRoomBinding = this.b;
        RecyclerView recyclerView = fragmentYyCreateRoomBinding == null ? null : fragmentYyCreateRoomBinding.s;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        }
        this.e = new CreateRoomBgAdapter(new ClickRoomBgListener() { // from class: com.blued.android.module.yy_china.fragment.YYCreateRoomFragment$initBgLayout$1
            @Override // com.blued.android.module.yy_china.adapter.ClickRoomBgListener
            public void a(BgCollectionMode item, View.OnClickListener clic) {
                Intrinsics.e(item, "item");
                Intrinsics.e(clic, "clic");
                YYCreateRoomFragment.this.a(item);
                YYCreateRoomFragment.this.L();
                clic.onClick(null);
                YYCreateRoomFragment.this.C();
            }
        }, this, j().o());
        FragmentYyCreateRoomBinding fragmentYyCreateRoomBinding2 = this.b;
        RecyclerView recyclerView2 = fragmentYyCreateRoomBinding2 == null ? null : fragmentYyCreateRoomBinding2.s;
        if (recyclerView2 == null) {
            return;
        }
        recyclerView2.setAdapter(this.e);
    }

    private final void F() {
        FragmentYyCreateRoomBinding fragmentYyCreateRoomBinding = this.b;
        if (fragmentYyCreateRoomBinding == null) {
            return;
        }
        a(new CreateRoomLabelAdapter(this));
        fragmentYyCreateRoomBinding.t.setLayoutManager(new LinearLayoutManager(fragmentYyCreateRoomBinding.t.getContext(), 0, false));
        fragmentYyCreateRoomBinding.t.setAdapter(d());
    }

    private final void G() {
        final ActivityFragmentActive fragmentActive = getFragmentActive();
        YYRoomHttpUtils.a((BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntity<HomeTopicModel, YYRoomExtraModel>>(fragmentActive) { // from class: com.blued.android.module.yy_china.fragment.YYCreateRoomFragment$getTopicList$1
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<HomeTopicModel, YYRoomExtraModel> bluedEntity) {
                if (bluedEntity == null || !bluedEntity.hasData()) {
                    return;
                }
                List<HomeTopicModel> list = bluedEntity.data;
                Iterator<HomeTopicModel> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    HomeTopicModel next = it.next();
                    if (next.getLabel_id() == 0) {
                        list.remove(next);
                        break;
                    }
                }
                CreateRoomLabelAdapter d = YYCreateRoomFragment.this.d();
                if (d != null) {
                    d.setNewData(list);
                }
                Integer valueOf = list == null ? null : Integer.valueOf(list.size());
                Intrinsics.a(valueOf);
                if (valueOf.intValue() > 0) {
                    YYCreateRoomFragment.this.a(list.get(0));
                }
                Iterator<HomeTopicModel> it2 = list.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    HomeTopicModel next2 = it2.next();
                    if (TextUtils.equals(String.valueOf(next2.getLabel_id()), YYCreateRoomFragment.this.j().m())) {
                        YYCreateRoomFragment.this.a(next2);
                        break;
                    }
                }
                CreateRoomLabelAdapter d2 = YYCreateRoomFragment.this.d();
                if (d2 == null) {
                    return;
                }
                d2.a(YYCreateRoomFragment.this.w());
            }
        }, (IRequestHost) getFragmentActive());
    }

    private final void H() {
        final ActivityFragmentActive fragmentActive = getFragmentActive();
        YYRoomHttpUtils.e((BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntityA<YYCreateTypeMode>>(fragmentActive) { // from class: com.blued.android.module.yy_china.fragment.YYCreateRoomFragment$getTypeList$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<YYCreateTypeMode> bluedEntityA) {
                if (bluedEntityA == null || !bluedEntityA.hasData()) {
                    return;
                }
                List<YYCreateTypeMode> list = bluedEntityA.data;
                FragmentYyCreateRoomBinding b = YYCreateRoomFragment.this.b();
                if (b != null) {
                    YYCreateRoomFragment yYCreateRoomFragment = YYCreateRoomFragment.this;
                    b.a.addTextChangedListener(yYCreateRoomFragment);
                    ShapeTextView shapeTextView = b.w;
                    YYCreateRoomFragment yYCreateRoomFragment2 = yYCreateRoomFragment;
                    shapeTextView.setOnClickListener(yYCreateRoomFragment2);
                    b.D.setOnClickListener(yYCreateRoomFragment2);
                    yYCreateRoomFragment.a(new CreateRoomTypeAdapter(yYCreateRoomFragment, yYCreateRoomFragment));
                    b.r.setLayoutManager(new GridLayoutManager(b.r.getContext(), 3));
                    b.r.setAdapter(yYCreateRoomFragment.c());
                    EditText editText = b.a;
                    StringCompanionObject stringCompanionObject = StringCompanionObject.a;
                    String string = yYCreateRoomFragment.getResources().getString(R.string.yy_create_room_name);
                    Intrinsics.c(string, "resources.getString(R.string.yy_create_room_name)");
                    String format = String.format(string, Arrays.copyOf(new Object[]{UserInfo.getInstance().getLoginUserInfo().getName()}, 1));
                    Intrinsics.c(format, "format(format, *args)");
                    editText.setText(format);
                    b.a.setSelection(b.a.getText().length());
                }
                CreateRoomTypeAdapter c = YYCreateRoomFragment.this.c();
                if (c != null) {
                    c.setNewData(list);
                }
                Iterator<YYCreateTypeMode> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    YYCreateTypeMode next = it.next();
                    if (next.getIs_choose() == 1) {
                        YYCreateRoomFragment.this.a(next);
                        break;
                    }
                }
                if (YYCreateRoomFragment.this.v() == null) {
                    YYCreateRoomFragment.this.a(list.get(0));
                }
                CreateRoomTypeAdapter c2 = YYCreateRoomFragment.this.c();
                if (c2 != null) {
                    c2.a(YYCreateRoomFragment.this.v());
                }
                YYCreateRoomFragment yYCreateRoomFragment3 = YYCreateRoomFragment.this;
                yYCreateRoomFragment3.a(yYCreateRoomFragment3.v(), "");
                YYCreateRoomFragment yYCreateRoomFragment4 = YYCreateRoomFragment.this;
                YYCreateTypeMode v = yYCreateRoomFragment4.v();
                yYCreateRoomFragment4.a(v == null ? null : v.getBg_collection());
                YYCreateRoomFragment.this.L();
            }
        }, (IRequestHost) getFragmentActive());
    }

    private final void I() {
        final ActivityFragmentActive fragmentActive = getFragmentActive();
        YYRoomHttpUtils.n(new BluedUIHttpResponse<BluedEntityA<VeiledRoomInfoMode>>(fragmentActive) { // from class: com.blued.android.module.yy_china.fragment.YYCreateRoomFragment$getVeiledRoomInfo$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<VeiledRoomInfoMode> result) {
                Intrinsics.e(result, "result");
                if (result.hasData()) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("·普通模式即为心动房正常模式；");
                    stringBuffer.append("\n");
                    stringBuffer.append("·开启蒙面模式后，在心动房除房主外所有用户都是蒙面状态，看不到用户头像和昵称等个人信息。");
                    stringBuffer.append("\n");
                    stringBuffer.append("·可在个人资料卡选择使用揭面卡揭面某个自己感兴趣的用户。");
                    stringBuffer.append("\n");
                    StringBuilder sb = new StringBuilder();
                    sb.append("·当在心动房交友成功或者给某用户送礼达到");
                    VeiledRoomInfoMode singleData = result.getSingleData();
                    sb.append((Object) (singleData == null ? null : singleData.getOpen_beans()));
                    sb.append("弯豆，则自动揭面。");
                    stringBuffer.append(sb.toString());
                    FragmentYyCreateRoomBinding b = YYCreateRoomFragment.this.b();
                    ShapeTextView shapeTextView = b == null ? null : b.y;
                    if (shapeTextView == null) {
                        return;
                    }
                    shapeTextView.setText(stringBuffer.toString());
                }
            }
        }, getFragmentActive());
    }

    private final void J() {
        FrameLayout frameLayout;
        TextView textView;
        ImageView imageView;
        ConstraintLayout constraintLayout;
        ConstraintLayout constraintLayout2;
        YYCreateTypeMode yYCreateTypeMode = this.f;
        if (yYCreateTypeMode != null) {
            ConstraintLayout constraintLayout3 = null;
            boolean z = false;
            if (TextUtils.equals(yYCreateTypeMode.getType(), "11")) {
                FragmentYyCreateRoomBinding b = b();
                if (b != null) {
                    constraintLayout3 = b.o;
                }
                if (constraintLayout3 != null) {
                    constraintLayout3.setVisibility(0);
                }
                if (yYCreateTypeMode.getIs_veiled() == 0) {
                    z = true;
                }
                b(z);
            } else {
                FragmentYyCreateRoomBinding b2 = b();
                ConstraintLayout constraintLayout4 = b2 == null ? null : b2.o;
                if (constraintLayout4 != null) {
                    constraintLayout4.setVisibility(8);
                }
                a(0);
            }
        }
        FragmentYyCreateRoomBinding fragmentYyCreateRoomBinding = this.b;
        if (fragmentYyCreateRoomBinding != null && (constraintLayout2 = fragmentYyCreateRoomBinding.q) != null) {
            constraintLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYCreateRoomFragment$HzZGmAEa03lkLe2CwJZu_u1u0QE
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YYCreateRoomFragment.d(YYCreateRoomFragment.this, view);
                }
            });
        }
        FragmentYyCreateRoomBinding fragmentYyCreateRoomBinding2 = this.b;
        if (fragmentYyCreateRoomBinding2 != null && (constraintLayout = fragmentYyCreateRoomBinding2.p) != null) {
            constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYCreateRoomFragment$u2Xqa1shrHj0MDuhr38fw49mslY
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YYCreateRoomFragment.e(YYCreateRoomFragment.this, view);
                }
            });
        }
        FragmentYyCreateRoomBinding fragmentYyCreateRoomBinding3 = this.b;
        if (fragmentYyCreateRoomBinding3 != null && (imageView = fragmentYyCreateRoomBinding3.f) != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYCreateRoomFragment$qFXgqkbIrmkXWPeefweNQOChu4E
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YYCreateRoomFragment.f(YYCreateRoomFragment.this, view);
                }
            });
        }
        FragmentYyCreateRoomBinding fragmentYyCreateRoomBinding4 = this.b;
        if (fragmentYyCreateRoomBinding4 != null && (textView = fragmentYyCreateRoomBinding4.B) != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYCreateRoomFragment$YGBCDw0G79lM0FPKpAlDkHwZ8Lg
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YYCreateRoomFragment.g(YYCreateRoomFragment.this, view);
                }
            });
        }
        FragmentYyCreateRoomBinding fragmentYyCreateRoomBinding5 = this.b;
        if (fragmentYyCreateRoomBinding5 == null || (frameLayout = fragmentYyCreateRoomBinding5.b) == null) {
            return;
        }
        frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYCreateRoomFragment$MGnvpRUpOyHbRhmt-hLPyzW-3rA
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYCreateRoomFragment.h(YYCreateRoomFragment.this, view);
            }
        });
    }

    private final void K() {
        this.p = !this.p;
        if (j().o() >= 11) {
            FragmentYyCreateRoomBinding fragmentYyCreateRoomBinding = this.b;
            LinearLayout linearLayout = fragmentYyCreateRoomBinding == null ? null : fragmentYyCreateRoomBinding.n;
            if (linearLayout != null) {
                linearLayout.setVisibility(0);
            }
        }
        if (this.p) {
            FragmentYyCreateRoomBinding fragmentYyCreateRoomBinding2 = this.b;
            ShapeTextView shapeTextView = fragmentYyCreateRoomBinding2 == null ? null : fragmentYyCreateRoomBinding2.m;
            if (shapeTextView == null) {
                return;
            }
            shapeTextView.setVisibility(0);
            return;
        }
        FragmentYyCreateRoomBinding fragmentYyCreateRoomBinding3 = this.b;
        ShapeTextView shapeTextView2 = fragmentYyCreateRoomBinding3 == null ? null : fragmentYyCreateRoomBinding3.m;
        if (shapeTextView2 == null) {
            return;
        }
        shapeTextView2.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L() {
        ImageView imageView;
        BgCollectionMode bgCollectionMode = this.k;
        ImageView imageView2 = null;
        if (bgCollectionMode == null) {
            YYCreateTypeMode yYCreateTypeMode = this.f;
            if (yYCreateTypeMode == null) {
                return;
            }
            ImageWrapper c = ImageLoader.a(getFragmentActive(), yYCreateTypeMode.getBackground_img()).c(500);
            FragmentYyCreateRoomBinding b = b();
            if (b != null) {
                imageView2 = b.h;
            }
            c.a(imageView2);
        } else if (bgCollectionMode == null) {
        } else {
            ImageWrapper c2 = ImageLoader.a(getFragmentActive(), bgCollectionMode.getDefault_pic()).c(500);
            FragmentYyCreateRoomBinding b2 = b();
            c2.a(b2 == null ? null : b2.h);
            if (!StringUtils.b(bgCollectionMode.getPic())) {
                ImageWrapper g = ImageLoader.a(getFragmentActive(), bgCollectionMode.getPic()).g().g(-1);
                FragmentYyCreateRoomBinding b3 = b();
                g.a(b3 == null ? null : b3.i);
                return;
            }
            FragmentYyCreateRoomBinding b4 = b();
            if (b4 == null || (imageView = b4.i) == null) {
                return;
            }
            imageView.setImageResource(R.color.transparent);
        }
    }

    private final void M() {
        YYCreateTypeMode yYCreateTypeMode = this.f;
        if (yYCreateTypeMode == null) {
            return;
        }
        List<String> recommend_text = yYCreateTypeMode.getRecommend_text();
        boolean z = false;
        if (recommend_text != null && recommend_text.size() == 0) {
            z = true;
        }
        if (z) {
            return;
        }
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.view_yy_create_room_play_info, (ViewGroup) null);
        Intrinsics.c(inflate, "from(context).inflate(R.…ate_room_play_info, null)");
        TextView textView = (TextView) inflate.findViewById(R.id.tv_info);
        StringBuilder sb = new StringBuilder();
        for (String str : yYCreateTypeMode.getRecommend_text()) {
            sb.append(str);
            Intrinsics.c(sb, "append(value)");
            sb.append('\n');
            Intrinsics.c(sb, "append('\\n')");
            sb.append("\n");
        }
        textView.setText(sb);
        new PopupwindowFactory.Builder(getContext()).a(inflate).a(80).c(-2).b(AppInfo.l).d(R.color.syc_alpha_3_000000).h();
    }

    private final void N() {
        YYRoomHttpUtils.a(getContext(), new BluedUIHttpResponse<BluedEntityA<BluedAlbum>>() { // from class: com.blued.android.module.yy_china.fragment.YYCreateRoomFragment$up7Niu$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(null);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public BluedEntityA<BluedAlbum> parseData(String response) {
                List<BluedAlbum> list;
                Intrinsics.e(response, "response");
                BluedEntityA<BluedAlbum> bluedEntityA = (BluedEntityA) super.parseData(response);
                if (bluedEntityA == null) {
                    list = null;
                } else {
                    try {
                        list = bluedEntityA.data;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if (list != null && bluedEntityA.data.size() > 0) {
                    YYCreateRoomFragment.this.a(bluedEntityA.data.get(0));
                    return bluedEntityA;
                }
                return bluedEntityA;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<BluedAlbum> bluedEntityA) {
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish(boolean z) {
                super.onUIFinish(z);
                if (z) {
                    return;
                }
                AppMethods.a((CharSequence) YYCreateRoomFragment.this.getString(R.string.yy_upload_fail));
                FragmentYyCreateRoomBinding b = YYCreateRoomFragment.this.b();
                TextView textView = b == null ? null : b.C;
                if (textView != null) {
                    textView.setText(YYCreateRoomFragment.this.getString(R.string.yy_preview_upload_faile));
                }
                FragmentYyCreateRoomBinding b2 = YYCreateRoomFragment.this.b();
                TextView textView2 = b2 == null ? null : b2.C;
                if (textView2 == null) {
                    return;
                }
                textView2.setClickable(true);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                TextView textView;
                super.onUIStart();
                FragmentYyCreateRoomBinding b = YYCreateRoomFragment.this.b();
                if (b != null && (textView = b.C) != null) {
                    textView.setText(YYCreateRoomFragment.this.getString(R.string.yy_preview_uploading));
                    Unit unit = Unit.a;
                }
                FragmentYyCreateRoomBinding b2 = YYCreateRoomFragment.this.b();
                TextView textView2 = b2 == null ? null : b2.C;
                if (textView2 == null) {
                    return;
                }
                textView2.setClickable(false);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(BluedAlbum bluedAlbum) {
        String str = this.l;
        if (str == null) {
            return;
        }
        QiniuUploadTools.a((Configuration) null, new File(str), bluedAlbum == null ? null : bluedAlbum.key, bluedAlbum == null ? null : bluedAlbum.token, new QiniuUploadTools.QiNiuListener() { // from class: com.blued.android.module.yy_china.fragment.YYCreateRoomFragment$uploadQiNiu$1$1
            @Override // com.blued.android.framework.utils.upload.QiniuUploadTools.QiNiuListener
            public void a(String str2) {
                AppMethods.a((CharSequence) YYCreateRoomFragment.this.getString(R.string.yy_upload_fail));
                FragmentYyCreateRoomBinding b = YYCreateRoomFragment.this.b();
                TextView textView = b == null ? null : b.C;
                if (textView != null) {
                    textView.setText(YYCreateRoomFragment.this.getString(R.string.yy_preview_upload_faile));
                }
                FragmentYyCreateRoomBinding b2 = YYCreateRoomFragment.this.b();
                TextView textView2 = b2 == null ? null : b2.C;
                if (textView2 == null) {
                    return;
                }
                textView2.setClickable(true);
            }

            @Override // com.blued.android.framework.utils.upload.QiniuUploadTools.QiNiuListener
            public void a(String str2, double d) {
            }

            @Override // com.blued.android.framework.utils.upload.QiniuUploadTools.QiNiuListener
            public void a(String str2, String str3) {
                FragmentYyCreateRoomBinding b = YYCreateRoomFragment.this.b();
                TextView textView = b == null ? null : b.C;
                if (textView != null) {
                    textView.setText(YYCreateRoomFragment.this.getString(R.string.yy_up_cover_succes));
                }
                YYCreateRoomFragment.this.c(str2);
                FragmentYyCreateRoomBinding b2 = YYCreateRoomFragment.this.b();
                TextView textView2 = b2 == null ? null : b2.C;
                if (textView2 == null) {
                    return;
                }
                textView2.setClickable(true);
            }

            @Override // com.blued.android.framework.utils.upload.QiniuUploadTools.QiNiuListener
            public boolean a() {
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYCreateRoomFragment this$0, View view) {
        EditText editText;
        Integer valueOf;
        EditText editText2;
        Intrinsics.e(this$0, "this$0");
        FragmentYyCreateRoomBinding fragmentYyCreateRoomBinding = this$0.b;
        ImageView imageView = fragmentYyCreateRoomBinding == null ? null : fragmentYyCreateRoomBinding.j;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        FragmentYyCreateRoomBinding fragmentYyCreateRoomBinding2 = this$0.b;
        if (fragmentYyCreateRoomBinding2 != null && (editText2 = fragmentYyCreateRoomBinding2.a) != null) {
            editText2.requestFocus();
        }
        FragmentActivity activity = this$0.getActivity();
        Object systemService = activity == null ? null : activity.getSystemService("input_method");
        if (systemService == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        }
        InputMethodManager inputMethodManager = (InputMethodManager) systemService;
        FragmentYyCreateRoomBinding fragmentYyCreateRoomBinding3 = this$0.b;
        inputMethodManager.showSoftInput(fragmentYyCreateRoomBinding3 == null ? null : fragmentYyCreateRoomBinding3.a, 0);
        FragmentYyCreateRoomBinding fragmentYyCreateRoomBinding4 = this$0.b;
        if (fragmentYyCreateRoomBinding4 == null || (editText = fragmentYyCreateRoomBinding4.a) == null) {
            return;
        }
        FragmentYyCreateRoomBinding fragmentYyCreateRoomBinding5 = this$0.b;
        if (fragmentYyCreateRoomBinding5 == null) {
            valueOf = null;
        } else {
            EditText editText3 = fragmentYyCreateRoomBinding5.a;
            if (editText3 == null) {
                valueOf = null;
            } else {
                Editable text = editText3.getText();
                valueOf = text == null ? null : Integer.valueOf(text.length());
            }
        }
        Intrinsics.a(valueOf);
        editText.setSelection(valueOf.intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYCreateRoomFragment this$0, View view, boolean z) {
        ImageView imageView;
        Intrinsics.e(this$0, "this$0");
        boolean z2 = false;
        if (!z) {
            FragmentYyCreateRoomBinding fragmentYyCreateRoomBinding = this$0.b;
            ImageView imageView2 = fragmentYyCreateRoomBinding == null ? null : fragmentYyCreateRoomBinding.j;
            if (imageView2 == null) {
                return;
            }
            imageView2.setVisibility(0);
            return;
        }
        FragmentYyCreateRoomBinding fragmentYyCreateRoomBinding2 = this$0.b;
        if (fragmentYyCreateRoomBinding2 != null && (imageView = fragmentYyCreateRoomBinding2.j) != null && imageView.getVisibility() == 8) {
            z2 = true;
        }
        if (z2) {
            return;
        }
        FragmentYyCreateRoomBinding fragmentYyCreateRoomBinding3 = this$0.b;
        ImageView imageView3 = fragmentYyCreateRoomBinding3 == null ? null : fragmentYyCreateRoomBinding3.j;
        if (imageView3 == null) {
            return;
        }
        imageView3.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(List<BgCollectionMode> list) {
        if (list != null && (!list.isEmpty())) {
            a(list.get(0));
            CreateRoomBgAdapter e = e();
            if (e != null) {
                e.a(x());
            }
            CreateRoomBgAdapter e2 = e();
            if (e2 == null) {
                return;
            }
            e2.setNewData(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(YYCreateRoomFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.K();
    }

    private final void b(boolean z) {
        FragmentYyCreateRoomBinding fragmentYyCreateRoomBinding = this.b;
        ImageView imageView = fragmentYyCreateRoomBinding == null ? null : fragmentYyCreateRoomBinding.H;
        if (imageView != null) {
            imageView.setVisibility(z ? 0 : 8);
        }
        FragmentYyCreateRoomBinding fragmentYyCreateRoomBinding2 = this.b;
        ImageView imageView2 = fragmentYyCreateRoomBinding2 == null ? null : fragmentYyCreateRoomBinding2.G;
        if (imageView2 != null) {
            int i = 0;
            if (z) {
                i = 8;
            }
            imageView2.setVisibility(i);
        }
        this.o = !z ? 1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(YYCreateRoomFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        FragmentYyCreateRoomBinding fragmentYyCreateRoomBinding = this$0.b;
        Group group = fragmentYyCreateRoomBinding == null ? null : fragmentYyCreateRoomBinding.c;
        if (group == null) {
            return;
        }
        group.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(YYCreateRoomFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.b(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(YYCreateRoomFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.b(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(YYCreateRoomFragment this$0, View view) {
        Group group;
        Intrinsics.e(this$0, "this$0");
        FragmentYyCreateRoomBinding fragmentYyCreateRoomBinding = this$0.b;
        int i = 0;
        boolean z = (fragmentYyCreateRoomBinding == null || (group = fragmentYyCreateRoomBinding.c) == null || group.getVisibility() != 0) ? false : true;
        FragmentYyCreateRoomBinding fragmentYyCreateRoomBinding2 = this$0.b;
        Group group2 = fragmentYyCreateRoomBinding2 == null ? null : fragmentYyCreateRoomBinding2.c;
        if (group2 == null) {
            return;
        }
        if (z) {
            i = 8;
        }
        group2.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(YYCreateRoomFragment this$0, View view) {
        Group group;
        Intrinsics.e(this$0, "this$0");
        FragmentYyCreateRoomBinding fragmentYyCreateRoomBinding = this$0.b;
        int i = 0;
        boolean z = (fragmentYyCreateRoomBinding == null || (group = fragmentYyCreateRoomBinding.c) == null || group.getVisibility() != 0) ? false : true;
        FragmentYyCreateRoomBinding fragmentYyCreateRoomBinding2 = this$0.b;
        Group group2 = fragmentYyCreateRoomBinding2 == null ? null : fragmentYyCreateRoomBinding2.c;
        if (group2 == null) {
            return;
        }
        if (z) {
            i = 8;
        }
        group2.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(YYCreateRoomFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        FragmentYyCreateRoomBinding fragmentYyCreateRoomBinding = this$0.b;
        Group group = fragmentYyCreateRoomBinding == null ? null : fragmentYyCreateRoomBinding.c;
        if (group == null) {
            return;
        }
        group.setVisibility(8);
    }

    public final YYCreateRoomSelectPhotoDialog A() {
        return this.n;
    }

    public final int B() {
        return this.o;
    }

    public final void C() {
        EditText editText;
        FragmentYyCreateRoomBinding fragmentYyCreateRoomBinding = this.b;
        KeyboardUtils.b(fragmentYyCreateRoomBinding == null ? null : fragmentYyCreateRoomBinding.a);
        FragmentYyCreateRoomBinding fragmentYyCreateRoomBinding2 = this.b;
        if (fragmentYyCreateRoomBinding2 == null || (editText = fragmentYyCreateRoomBinding2.a) == null) {
            return;
        }
        editText.clearFocus();
    }

    public final void a(int i) {
        this.o = i;
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public void a(Bundle bundle) {
        ShapeTextView shapeTextView;
        ImageView imageView;
        LinearLayout linearLayout;
        ShapeRelativeLayout shapeRelativeLayout;
        ImageView imageView2;
        TextView textView;
        ImageView imageView3;
        TextView textView2;
        super.a(bundle);
        this.b = FragmentYyCreateRoomBinding.a(this.i);
        if (StatusBarHelper.a()) {
            FragmentYyCreateRoomBinding fragmentYyCreateRoomBinding = this.b;
            ViewGroup.LayoutParams layoutParams = (fragmentYyCreateRoomBinding == null || (textView2 = fragmentYyCreateRoomBinding.F) == null) ? null : textView2.getLayoutParams();
            if (layoutParams == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            }
            ViewGroup.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
            ((ConstraintLayout.LayoutParams) layoutParams2).topMargin = StatusBarHelper.a(getContext());
            FragmentYyCreateRoomBinding fragmentYyCreateRoomBinding2 = this.b;
            TextView textView3 = fragmentYyCreateRoomBinding2 == null ? null : fragmentYyCreateRoomBinding2.F;
            if (textView3 != null) {
                textView3.setLayoutParams(layoutParams2);
            }
        }
        FragmentYyCreateRoomBinding fragmentYyCreateRoomBinding3 = this.b;
        TextView textView4 = fragmentYyCreateRoomBinding3 == null ? null : fragmentYyCreateRoomBinding3.C;
        if (textView4 != null) {
            textView4.setText(getString(R.string.yy_create_room_up_cover));
        }
        FragmentYyCreateRoomBinding fragmentYyCreateRoomBinding4 = this.b;
        if (fragmentYyCreateRoomBinding4 != null && (imageView3 = fragmentYyCreateRoomBinding4.g) != null) {
            imageView3.setOnClickListener(this);
        }
        FragmentYyCreateRoomBinding fragmentYyCreateRoomBinding5 = this.b;
        if (fragmentYyCreateRoomBinding5 != null && (textView = fragmentYyCreateRoomBinding5.C) != null) {
            textView.setOnClickListener(this);
        }
        FragmentYyCreateRoomBinding fragmentYyCreateRoomBinding6 = this.b;
        if (fragmentYyCreateRoomBinding6 != null && (imageView2 = fragmentYyCreateRoomBinding6.f) != null) {
            imageView2.setOnClickListener(this);
        }
        if (!Intrinsics.a((Object) j().n(), (Object) true)) {
            FragmentYyCreateRoomBinding fragmentYyCreateRoomBinding7 = this.b;
            TextView textView5 = fragmentYyCreateRoomBinding7 == null ? null : fragmentYyCreateRoomBinding7.C;
            if (textView5 != null) {
                textView5.setVisibility(8);
            }
        }
        FragmentYyCreateRoomBinding fragmentYyCreateRoomBinding8 = this.b;
        if (fragmentYyCreateRoomBinding8 != null && (shapeRelativeLayout = fragmentYyCreateRoomBinding8.u) != null) {
            shapeRelativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYCreateRoomFragment$89EJymo4DL1ryz8FGTg7mmDqse4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YYCreateRoomFragment.a(YYCreateRoomFragment.this, view);
                }
            });
        }
        D();
        F();
        E();
        G();
        H();
        I();
        FragmentYyCreateRoomBinding fragmentYyCreateRoomBinding9 = this.b;
        if (fragmentYyCreateRoomBinding9 != null && (linearLayout = fragmentYyCreateRoomBinding9.n) != null) {
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYCreateRoomFragment$MaqjfaAJZu2tNZwuxhZyOhOysMo
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YYCreateRoomFragment.b(YYCreateRoomFragment.this, view);
                }
            });
        }
        FragmentYyCreateRoomBinding fragmentYyCreateRoomBinding10 = this.b;
        if (fragmentYyCreateRoomBinding10 != null && (imageView = fragmentYyCreateRoomBinding10.l) != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYCreateRoomFragment$Opy6-roOAh4SXZqtmPnQTEwyG0g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YYCreateRoomFragment.c(YYCreateRoomFragment.this, view);
                }
            });
        }
        FragmentYyCreateRoomBinding fragmentYyCreateRoomBinding11 = this.b;
        if (fragmentYyCreateRoomBinding11 != null && (shapeTextView = fragmentYyCreateRoomBinding11.y) != null) {
            shapeTextView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYCreateRoomFragment$MWrih9KJnVKzYAzeYJV3QvuuiH0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YYCreateRoomFragment.a(view);
                }
            });
        }
        K();
    }

    public final void a(CreateRoomLabelAdapter createRoomLabelAdapter) {
        this.d = createRoomLabelAdapter;
    }

    public final void a(CreateRoomTypeAdapter createRoomTypeAdapter) {
        this.c = createRoomTypeAdapter;
    }

    public final void a(YYCreateRoomSelectPhotoDialog yYCreateRoomSelectPhotoDialog) {
        this.n = yYCreateRoomSelectPhotoDialog;
    }

    public final void a(BgCollectionMode bgCollectionMode) {
        this.k = bgCollectionMode;
    }

    public final void a(HomeTopicModel homeTopicModel) {
        this.g = homeTopicModel;
    }

    @Override // com.blued.android.module.yy_china.fragment.OnClickRoomLabelListener
    public void a(HomeTopicModel homeTopicModel, String str) {
        List data;
        RecyclerView recyclerView;
        this.g = homeTopicModel;
        CreateRoomLabelAdapter createRoomLabelAdapter = this.d;
        if (createRoomLabelAdapter != null && (data = createRoomLabelAdapter.getData()) != null) {
            int indexOf = data.indexOf(homeTopicModel);
            FragmentYyCreateRoomBinding b = b();
            if (b != null && (recyclerView = b.t) != null) {
                recyclerView.scrollToPosition(indexOf);
            }
        }
        C();
    }

    public final void a(YYCreateTypeMode yYCreateTypeMode) {
        this.f = yYCreateTypeMode;
    }

    @Override // com.blued.android.module.yy_china.fragment.OnClickRoomTypeListener
    public void a(YYCreateTypeMode yYCreateTypeMode, String str) {
        CreateRoomLabelAdapter d;
        C();
        this.f = yYCreateTypeMode;
        if (yYCreateTypeMode != null) {
            if (yYCreateTypeMode.getIs_restricted() == 1) {
                FragmentYyCreateRoomBinding b = b();
                ShapeTextView shapeTextView = b == null ? null : b.w;
                if (shapeTextView != null) {
                    shapeTextView.setClickable(false);
                }
                FragmentYyCreateRoomBinding b2 = b();
                ShapeHelper.a(b2 == null ? null : b2.w, R.color.syc_dark_ADADAD, R.color.syc_dark_7c7c7c);
            } else {
                FragmentYyCreateRoomBinding b3 = b();
                ShapeTextView shapeTextView2 = b3 == null ? null : b3.w;
                if (shapeTextView2 != null) {
                    shapeTextView2.setClickable(true);
                }
                FragmentYyCreateRoomBinding b4 = b();
                ShapeHelper.a(b4 == null ? null : b4.w, R.color.syc_00E0AB, R.color.syc_3883FD);
            }
            if (TextUtils.isEmpty(yYCreateTypeMode.getTips())) {
                FragmentYyCreateRoomBinding b5 = b();
                TextView textView = b5 == null ? null : b5.x;
                if (textView != null) {
                    textView.setText("");
                }
                FragmentYyCreateRoomBinding b6 = b();
                TextView textView2 = b6 == null ? null : b6.x;
                if (textView2 != null) {
                    textView2.setVisibility(8);
                }
            } else {
                FragmentYyCreateRoomBinding b7 = b();
                TextView textView3 = b7 == null ? null : b7.x;
                if (textView3 != null) {
                    textView3.setVisibility(0);
                }
                FragmentYyCreateRoomBinding b8 = b();
                TextView textView4 = b8 == null ? null : b8.x;
                if (textView4 != null) {
                    textView4.setText(yYCreateTypeMode.getTips());
                }
            }
            if (yYCreateTypeMode.getChecked_label() != -1 && (d = d()) != null) {
                List<HomeTopicModel> data = d.getData();
                Intrinsics.c(data, "adapter.data");
                for (HomeTopicModel homeTopicModel : data) {
                    if (yYCreateTypeMode.getChecked_label() == homeTopicModel.getLabel_id()) {
                        d.a(homeTopicModel);
                        a(homeTopicModel, str);
                    }
                }
            }
            a(yYCreateTypeMode.getBg_collection());
            J();
        }
        L();
        C();
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        FragmentYyCreateRoomBinding fragmentYyCreateRoomBinding = this.b;
        if (fragmentYyCreateRoomBinding == null) {
            return;
        }
        if (TextUtils.isEmpty(editable)) {
            fragmentYyCreateRoomBinding.w.setEnabled(false);
            ShapeHelper.a(fragmentYyCreateRoomBinding.w, R.color.syc_dark_j, R.color.syc_dark_j);
            return;
        }
        fragmentYyCreateRoomBinding.w.setEnabled(true);
        ShapeHelper.a(fragmentYyCreateRoomBinding.w, R.color.syc_00E0AB, R.color.syc_3883FD);
    }

    public final FragmentYyCreateRoomBinding b() {
        return this.b;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final CreateRoomTypeAdapter c() {
        return this.c;
    }

    public final void c(String str) {
        this.m = str;
    }

    public final CreateRoomLabelAdapter d() {
        return this.d;
    }

    @Override // com.blued.android.module.yy_china.listener.OnYYCreateRoomSelectPhotoListener
    public void d(String img) {
        Intrinsics.e(img, "img");
        this.l = img;
        N();
    }

    public final CreateRoomBgAdapter e() {
        return this.e;
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public int g() {
        return R.layout.fragment_yy_create_room;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1 && i == 22 && intent != null) {
            String stringExtra = intent.getStringExtra("photo_path");
            YYCreateRoomSelectPhotoDialog yYCreateRoomSelectPhotoDialog = this.n;
            if (yYCreateRoomSelectPhotoDialog != null) {
                yYCreateRoomSelectPhotoDialog.a(stringExtra);
            }
        }
        super.onActivityResult(i, i2, intent);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        YYCreateRoomSelectPhotoDialog A;
        Tracker.onClick(view);
        FragmentYyCreateRoomBinding fragmentYyCreateRoomBinding = this.b;
        if (fragmentYyCreateRoomBinding == null) {
            return;
        }
        Integer valueOf = view == null ? null : Integer.valueOf(view.getId());
        int i = R.id.tv_create;
        if (valueOf != null && valueOf.intValue() == i) {
            if (ClickUtils.a()) {
                return;
            }
            Intent intent = new Intent();
            YYCreateTypeMode v = v();
            intent.putExtra("typeId", v == null ? null : v.getType());
            HomeTopicModel w = w();
            intent.putExtra("labelId", String.valueOf(w == null ? null : Integer.valueOf(w.getLabel_id())));
            intent.putExtra("roomname", StringsKt.b((CharSequence) fragmentYyCreateRoomBinding.a.getText().toString()).toString());
            intent.putExtra("is_veiled", B());
            if (z() != null) {
                intent.putExtra("imgCover", z());
            }
            BgCollectionMode x = x();
            intent.putExtra("imgBackground", x == null ? null : x.getBg_id());
            intent.putExtra("is_fans_notice", this.p);
            setResult(-1, intent);
            t();
            return;
        }
        int i2 = R.id.iv_back;
        if (valueOf != null && valueOf.intValue() == i2) {
            t();
            return;
        }
        int i3 = R.id.tv_right;
        if (valueOf == null || valueOf.intValue() != i3) {
            int i4 = R.id.tv_room_play_info;
            if (valueOf != null && valueOf.intValue() == i4) {
                M();
            }
        } else if (ClickUtils.a(view.getId())) {
        } else {
            a(new YYCreateRoomSelectPhotoDialog());
            YYCreateRoomSelectPhotoDialog A2 = A();
            if (A2 != null) {
                A2.a(this, this);
            }
            YYCreateRoomSelectPhotoDialog A3 = A();
            if (A3 != null) {
                A3.show(getChildFragmentManager(), YYCreateRoomSelectPhotoDialog.class.getSimpleName());
            }
            String y = y();
            if (y != null && (A = A()) != null) {
                A.a(y);
            }
            EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_CREATE_UPLOAD_COVER_CLICK);
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final YYCreateTypeMode v() {
        return this.f;
    }

    public final HomeTopicModel w() {
        return this.g;
    }

    public final BgCollectionMode x() {
        return this.k;
    }

    public final String y() {
        return this.l;
    }

    public final String z() {
        return this.m;
    }
}
