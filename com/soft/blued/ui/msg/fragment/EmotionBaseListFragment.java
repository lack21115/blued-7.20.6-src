package com.soft.blued.ui.msg.fragment;

import android.text.TextUtils;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.lifecycle.Observer;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.FileHttpResponseHandler;
import com.blued.android.core.net.http.FileDownloader;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.SimpleFragment;
import com.blued.android.framework.utils.HashidEncryptTool;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.module.common.widget.emoticon.manager.EmotionManager;
import com.blued.android.module.common.widget.emoticon.model.EmoticonModel;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.R;
import com.soft.blued.http.ChatHttpUtils;
import com.soft.blued.ui.msg.fragment.EmotionListAdapter;
import com.soft.blued.ui.msg.model.EmotionDownloadModel;
import com.soft.blued.ui.msg.model.EmotionListItemModel;
import java.io.File;
import java.util.Iterator;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/fragment/EmotionBaseListFragment.class */
public abstract class EmotionBaseListFragment extends SimpleFragment {

    /* renamed from: a  reason: collision with root package name */
    protected View f32336a;
    protected ListView b;

    /* renamed from: c  reason: collision with root package name */
    protected EmotionListAdapter f32337c;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Boolean bool) {
        a();
    }

    public abstract void a();

    public void a(int i, String str) {
        EmotionDetailFragment.a(getActivity(), i, str);
    }

    public abstract void a(EmotionListItemModel emotionListItemModel);

    public void b(final EmotionListItemModel emotionListItemModel) {
        if (emotionListItemModel == null) {
            return;
        }
        LogUtils.c("addEmotion: " + emotionListItemModel.name);
        ChatHttpUtils.a(emotionListItemModel.code, new BluedUIHttpResponse<BluedEntityA<EmotionDownloadModel>>(getFragmentActive()) { // from class: com.soft.blued.ui.msg.fragment.EmotionBaseListFragment.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<EmotionDownloadModel> bluedEntityA) {
                if (bluedEntityA == null || bluedEntityA.getSingleData() == null) {
                    return;
                }
                String str = bluedEntityA.getSingleData().download;
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                Iterator<EmotionListItemModel> it = EmotionDataManager.a().c().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    EmotionListItemModel next = it.next();
                    if (StringUtils.a(next.code, emotionListItemModel.code)) {
                        next.downloadUrl = str;
                        next.downloadState = 2;
                        EmotionBaseListFragment.this.c(next);
                        break;
                    }
                }
                LiveEventBus.get("EMOTION_RELOAD_DATA").post(true);
            }
        });
    }

    public void c(final EmotionListItemModel emotionListItemModel) {
        if (emotionListItemModel == null || TextUtils.isEmpty(emotionListItemModel.downloadUrl)) {
            return;
        }
        String str = emotionListItemModel.code;
        LogUtils.c("emotion id=" + str + ", download url: " + emotionListItemModel.downloadUrl);
        final String str2 = AppMethods.b(EmotionManager.a()) + File.separator + str + "." + EmotionManager.f(emotionListItemModel.downloadUrl);
        LogUtils.c("filePath: " + str2);
        new EmoticonModel().url_original = "file://" + str2;
        FileDownloader.a(emotionListItemModel.downloadUrl, str2, new FileHttpResponseHandler() { // from class: com.soft.blued.ui.msg.fragment.EmotionBaseListFragment.3
            @Override // com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
            /* renamed from: a */
            public void onSuccess(File file) {
                EmotionManager.a(str2);
                EmotionDataManager.a().b(emotionListItemModel.code);
                Iterator<EmotionListItemModel> it = EmotionDataManager.a().c().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    EmotionListItemModel next = it.next();
                    if (StringUtils.a(next.code, emotionListItemModel.code)) {
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
        }, null);
    }

    public void d(EmotionListItemModel emotionListItemModel) {
        String b = HashidEncryptTool.b(String.valueOf(emotionListItemModel.emotion_id));
        if (TextUtils.isEmpty(b)) {
            return;
        }
        LogUtils.c("removeEmotion: " + emotionListItemModel.emotion_id + ", hashId:" + b + ", code:" + emotionListItemModel.code);
        ChatHttpUtils.a(b, emotionListItemModel.code);
    }

    @Override // com.blued.android.framework.ui.SimpleFragment
    public void onInitListener() {
        super.onInitListener();
        LiveEventBus.get("EMOTION_RELOAD_DATA", Boolean.class).observe(this, new Observer() { // from class: com.soft.blued.ui.msg.fragment.-$$Lambda$EmotionBaseListFragment$6tQIVTmCjo5vgUvWLgX9YvDueiU
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                EmotionBaseListFragment.this.a((Boolean) obj);
            }
        });
    }

    @Override // com.blued.android.framework.ui.SimpleFragment
    public void onInitView() {
        super.onInitView();
        this.f32336a = this.rootView.findViewById(R.id.emotion_list_banner_layout);
        this.b = (ListView) this.rootView.findViewById(R.id.emotion_list_lv);
        EmotionListAdapter emotionListAdapter = new EmotionListAdapter(R.layout.item_emotion_layout, new EmotionListAdapter.EmotionAdapterListener() { // from class: com.soft.blued.ui.msg.fragment.EmotionBaseListFragment.1
            @Override // com.soft.blued.ui.msg.fragment.EmotionListAdapter.EmotionAdapterListener
            public void a(EmotionListItemModel emotionListItemModel) {
                EmotionBaseListFragment.this.a(emotionListItemModel);
            }
        });
        this.f32337c = emotionListAdapter;
        this.b.setAdapter((ListAdapter) emotionListAdapter);
    }

    @Override // com.blued.android.framework.ui.SimpleFragment
    public int onSetRootViewId() {
        return R.layout.fragment_emotion_list;
    }
}
