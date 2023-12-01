package com.soft.blued.ui.msg.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.lifecycle.Observer;
import com.anythink.expressad.video.dynview.a.a;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.FileHttpResponseHandler;
import com.blued.android.core.net.http.FileDownloader;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.SimpleFragment;
import com.blued.android.framework.utils.HashidEncryptTool;
import com.blued.android.framework.utils.LocaleUtils;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.framework.utils.TypeUtils;
import com.blued.android.framework.view.badgeview.DisplayUtil;
import com.blued.android.module.common.adapter.CommonAdapter;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.common.view.ListViewForScroll;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.blued.android.module.common.widget.emoticon.manager.EmotionManager;
import com.blued.android.module.common.widget.emoticon.model.EmoticonModel;
import com.bytedance.applog.tracker.Tracker;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.R;
import com.soft.blued.http.ChatHttpUtils;
import com.soft.blued.ui.msg.fragment.EmotionDetailFragment;
import com.soft.blued.ui.msg.model.EmotionDetailModel;
import com.soft.blued.ui.msg.model.EmotionDownloadModel;
import com.soft.blued.ui.msg.model.EmotionIconsModel;
import com.soft.blued.ui.msg.model.EmotionListItemModel;
import java.io.File;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/fragment/EmotionDetailFragment.class */
public class EmotionDetailFragment extends SimpleFragment {

    /* renamed from: a  reason: collision with root package name */
    private CommonTopTitleNoTrans f32344a;
    private ImageView b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f32345c;
    private TextView d;
    private TextView e;
    private TextView f;
    private CardView g;
    private TextView h;
    private GridView i;
    private CommonAdapter<EmotionIconsModel> j;
    private TextView k;
    private TextView l;
    private ListViewForScroll m;
    private EmotionListAdapter n;
    private EmotionDetailModel o;
    private String p;
    private int q;
    private int r;
    private String s;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.soft.blued.ui.msg.fragment.EmotionDetailFragment$3  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/fragment/EmotionDetailFragment$3.class */
    public class AnonymousClass3 extends FileHttpResponseHandler {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f32347a;

        AnonymousClass3(String str) {
            this.f32347a = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a() {
            EmotionDetailFragment.this.c();
        }

        @Override // com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
        /* renamed from: a */
        public void onSuccess(File file) {
            EmotionManager.a(this.f32347a);
            EmotionDataManager.a().b(EmotionDetailFragment.this.p);
            EmotionDetailFragment.this.r = 3;
            EmotionDetailFragment.this.postSafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.msg.fragment.-$$Lambda$EmotionDetailFragment$3$VwCpST56UaEdrpQVUDqmIb2l-LM
                @Override // java.lang.Runnable
                public final void run() {
                    EmotionDetailFragment.AnonymousClass3.this.a();
                }
            });
            Iterator<EmotionListItemModel> it = EmotionDataManager.a().c().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                EmotionListItemModel next = it.next();
                if (StringUtils.a(next.code, EmotionDetailFragment.this.p)) {
                    next.downloadState = 3;
                    break;
                }
            }
            LiveEventBus.get("EMOTION_RELOAD_DATA").post(true);
        }

        @Override // com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
        /* renamed from: a */
        public void onFailure(Throwable th, int i, File file) {
        }

        @Override // com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
        public void onFinish() {
        }
    }

    private String a(EmotionDetailModel emotionDetailModel) {
        if (emotionDetailModel == null) {
            return "";
        }
        String str = null;
        if (j()) {
            str = emotionDetailModel.name_en;
        } else if (i()) {
            str = emotionDetailModel.name_zh_tw;
        }
        String str2 = str;
        if (TextUtils.isEmpty(str)) {
            str2 = emotionDetailModel.name;
        }
        return str2;
    }

    private void a() {
        if (!EmotionDataManager.a().a(this.p)) {
            Iterator<EmotionListItemModel> it = EmotionDataManager.a().c().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                EmotionListItemModel next = it.next();
                if (StringUtils.a(next.code, this.p)) {
                    this.r = next.downloadState;
                    break;
                }
            }
        } else {
            this.r = 3;
        }
        c();
    }

    public static void a(Context context, int i, String str) {
        Bundle bundle = new Bundle();
        bundle.putInt("emotion_id", i);
        bundle.putString("emotion_code", str);
        TerminalActivity.d(context, EmotionDetailFragment.class, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        Tracker.onClick(view);
        d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Boolean bool) {
        a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        EmotionDetailModel emotionDetailModel = this.o;
        if (emotionDetailModel == null) {
            return;
        }
        this.f32344a.setCenterText(a(emotionDetailModel));
        ImageLoader.a(getFragmentActive(), this.o.banner).a(this.b);
        this.f32345c.setText(this.o.name);
        this.d.setText(h());
        TextView textView = this.e;
        textView.setText(getString(2131887692) + this.o.download_count);
        TextView textView2 = this.f;
        StringBuilder sb = new StringBuilder();
        sb.append(getString(2131887701));
        sb.append(getString(this.o.is_free == 1 ? 2131887695 : 2131887691));
        textView2.setText(sb.toString());
        c();
        if (j()) {
            this.k.setText(this.o.creator_name_en);
        } else {
            this.k.setText(this.o.creator_name);
        }
        if (j()) {
            this.l.setText(this.o.creator_description_en);
        } else {
            this.l.setText(this.o.creator_description);
        }
        if (TypeUtils.a((List<?>) this.o.icons)) {
            return;
        }
        this.j.a(this.o.icons);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        Tracker.onClick(view);
        getActivity().finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        int i = this.r;
        if (i == 3) {
            this.h.setText(2131887700);
        } else if (i == 2) {
            this.h.setText(2131887694);
        } else if (i == 1) {
            this.h.setText(2131887690);
        } else {
            this.h.setText(2131887695);
        }
        if (this.r == 3) {
            this.g.setCardBackgroundColor(BluedSkinUtils.a(getContext(), 2131102360));
            this.h.setTextColor(getResources().getColor(2131102263));
            return;
        }
        this.g.setCardBackgroundColor(BluedSkinUtils.a(getContext(), 2131101766));
        this.h.setTextColor(getResources().getColor(2131102478));
    }

    private void d() {
        if (this.o == null) {
            return;
        }
        int i = this.r;
        if (i == 0) {
            e();
        } else if (i != 1) {
            if (i == 3) {
                g();
            }
        } else if (this.s == null) {
            e();
        } else {
            f();
        }
    }

    private void e() {
        EmotionDetailModel emotionDetailModel = this.o;
        if (emotionDetailModel == null) {
            return;
        }
        ChatHttpUtils.a(emotionDetailModel.code, new BluedUIHttpResponse<BluedEntityA<EmotionDownloadModel>>(getFragmentActive()) { // from class: com.soft.blued.ui.msg.fragment.EmotionDetailFragment.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<EmotionDownloadModel> bluedEntityA) {
                if (bluedEntityA == null || bluedEntityA.getSingleData() == null) {
                    return;
                }
                EmotionDetailFragment.this.s = bluedEntityA.getSingleData().download;
                EmotionDetailFragment.this.r = 2;
                EmotionDetailFragment.this.c();
                Iterator<EmotionListItemModel> it = EmotionDataManager.a().c().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    EmotionListItemModel next = it.next();
                    if (StringUtils.a(next.code, EmotionDetailFragment.this.p)) {
                        next.downloadState = 2;
                        break;
                    }
                }
                LiveEventBus.get("EMOTION_RELOAD_DATA").post(true);
                EmotionDetailFragment.this.f();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (TextUtils.isEmpty(this.s)) {
            return;
        }
        String str = this.o.code;
        LogUtils.c("emotion id=" + str + ", download url: " + this.s);
        String str2 = AppMethods.b(EmotionManager.a()) + File.separator + str + "." + EmotionManager.f(this.s);
        LogUtils.c("filePath: " + str2);
        new EmoticonModel().url_original = "file://" + str2;
        FileDownloader.a(this.s, str2, new AnonymousClass3(str2), null);
    }

    private void g() {
        if (this.o == null) {
            return;
        }
        String b = HashidEncryptTool.b(String.valueOf(this.q));
        if (TextUtils.isEmpty(b)) {
            return;
        }
        LogUtils.c("removeEmotion: " + this.q + ", hashId:" + b + ", code:" + this.p);
        ChatHttpUtils.a(b, this.p);
    }

    private String h() {
        if (this.o == null) {
            return "";
        }
        String str = null;
        if (j()) {
            str = this.o.description_en;
        } else if (i()) {
            str = this.o.description_zh_tw;
        }
        String str2 = str;
        if (TextUtils.isEmpty(str)) {
            str2 = this.o.description;
        }
        return str2;
    }

    private boolean i() {
        String language = LocaleUtils.c().getLanguage();
        String country = LocaleUtils.c().getCountry();
        if (a.V.equalsIgnoreCase(language)) {
            return "tw".equalsIgnoreCase(country) || "hk".equalsIgnoreCase(country);
        }
        return false;
    }

    private boolean j() {
        return "en".equalsIgnoreCase(LocaleUtils.c().getLanguage());
    }

    @Override // com.blued.android.framework.ui.SimpleFragment
    public void onInitListener() {
        super.onInitListener();
        LiveEventBus.get("EMOTION_RELOAD_DATA", Boolean.class).observe(this, new Observer() { // from class: com.soft.blued.ui.msg.fragment.-$$Lambda$EmotionDetailFragment$UvB4o8KPbOZc_s292w3dxHaTNdk
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                EmotionDetailFragment.this.a((Boolean) obj);
            }
        });
    }

    @Override // com.blued.android.framework.ui.SimpleFragment
    public void onInitView() {
        super.onInitView();
        CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans) this.rootView.findViewById(R.id.emotion_detail_title);
        this.f32344a = commonTopTitleNoTrans;
        commonTopTitleNoTrans.setLeftClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.fragment.-$$Lambda$EmotionDetailFragment$nxYwFCGeCdxcSWz7sXzydSyh8eQ
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EmotionDetailFragment.this.b(view);
            }
        });
        ImageView imageView = (ImageView) this.rootView.findViewById(R.id.emotion_detail_banner_iv);
        this.b = imageView;
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        layoutParams.height = (int) ((AppInfo.l / 320.0f) * 120.0f);
        this.b.setLayoutParams(layoutParams);
        this.f32345c = (TextView) this.rootView.findViewById(R.id.emotion_detail_name);
        this.d = (TextView) this.rootView.findViewById(R.id.emotion_detail_des);
        this.e = (TextView) this.rootView.findViewById(R.id.emotion_detail_download_count);
        this.f = (TextView) this.rootView.findViewById(R.id.emotion_detail_use_condition);
        this.g = (CardView) this.rootView.findViewById(R.id.emotion_detail_btn_cv);
        this.h = (TextView) this.rootView.findViewById(R.id.emotion_detail_btn);
        this.i = (GridView) this.rootView.findViewById(R.id.emotion_detail_grid);
        this.k = (TextView) this.rootView.findViewById(R.id.emotion_detail_anchor_name);
        this.l = (TextView) this.rootView.findViewById(R.id.emotion_detail_anchor_detail);
        this.m = (ListViewForScroll) this.rootView.findViewById(R.id.emotion_detail_lv);
        CommonAdapter<EmotionIconsModel> commonAdapter = new CommonAdapter<EmotionIconsModel>(R.layout.item_emotion_detail_icon) { // from class: com.soft.blued.ui.msg.fragment.EmotionDetailFragment.1
            @Override // com.blued.android.module.common.adapter.CommonAdapter
            public void a(CommonAdapter.ViewHolder viewHolder, EmotionIconsModel emotionIconsModel, int i) {
                ((ImageView) viewHolder.a(R.id.item_emotion_detail_icon_id)).getLayoutParams().height = (AppInfo.l - DisplayUtil.a(this.f10437a, 75.0f)) / 4;
                viewHolder.b(R.id.item_emotion_detail_icon_id, emotionIconsModel.image);
            }
        };
        this.j = commonAdapter;
        this.i.setAdapter((ListAdapter) commonAdapter);
        EmotionListAdapter emotionListAdapter = new EmotionListAdapter(R.layout.item_emotion_layout, null);
        this.n = emotionListAdapter;
        emotionListAdapter.a(2);
        this.m.setAdapter((ListAdapter) this.n);
        this.g.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.fragment.-$$Lambda$EmotionDetailFragment$hmGQPqfW1lez3SLwge8q7U0RCqA
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EmotionDetailFragment.this.a(view);
            }
        });
        a();
    }

    @Override // com.blued.android.framework.ui.SimpleFragment
    public void onLoadData() {
        super.onLoadData();
        ChatHttpUtils.a(this.q, this.args.getString("emotion_code"), new BluedUIHttpResponse<BluedEntityA<EmotionDetailModel>>(getFragmentActive()) { // from class: com.soft.blued.ui.msg.fragment.EmotionDetailFragment.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<EmotionDetailModel> bluedEntityA) {
                if (bluedEntityA == null || bluedEntityA.getSingleData() == null) {
                    return;
                }
                EmotionDetailFragment.this.o = bluedEntityA.getSingleData();
                EmotionDetailFragment.this.q = bluedEntityA.getSingleData().emotion_id;
                EmotionDetailFragment.this.p = bluedEntityA.getSingleData().code;
                EmotionDetailFragment.this.b();
            }
        });
        if (TypeUtils.a((List<?>) EmotionDataManager.a().c())) {
            ChatHttpUtils.c(new BluedUIHttpResponse<BluedEntityA<EmotionListItemModel>>(getFragmentActive()) { // from class: com.soft.blued.ui.msg.fragment.EmotionDetailFragment.5
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                /* renamed from: a */
                public void onUIUpdate(BluedEntityA<EmotionListItemModel> bluedEntityA) {
                    if (bluedEntityA != null) {
                        Iterator<EmotionListItemModel> it = bluedEntityA.data.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            EmotionListItemModel next = it.next();
                            if (StringUtils.a(next.code, EmotionDetailFragment.this.p)) {
                                next.downloadState = EmotionDetailFragment.this.r;
                                break;
                            }
                        }
                        EmotionDataManager.a().a(bluedEntityA.data);
                    }
                    EmotionDetailFragment.this.n.a(EmotionDataManager.a().c());
                }
            });
        } else {
            this.n.a(EmotionDataManager.a().c());
        }
    }

    @Override // com.blued.android.framework.ui.SimpleFragment
    public void onParseArguments() {
        super.onParseArguments();
        int i = this.args.getInt("emotion_id");
        this.q = i;
        if (i <= 0) {
            this.q = 0;
        }
        String string = this.args.getString("emotion_code");
        LogUtils.c("emotion_code:" + string);
        if (!string.contains(BridgeUtil.UNDERLINE_STR)) {
            this.p = string;
            return;
        }
        String[] split = string.split(BridgeUtil.UNDERLINE_STR);
        if (split == null || split.length <= 0) {
            return;
        }
        this.p = split[0];
    }

    @Override // com.blued.android.framework.ui.SimpleFragment
    public int onSetRootViewId() {
        return R.layout.fragment_emtoion_detail;
    }
}
