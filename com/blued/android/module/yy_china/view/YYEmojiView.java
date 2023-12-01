package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.utils.toast.ToastUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.ClickUtils;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.adapter.YYEmojiAdapter;
import com.blued.android.module.yy_china.adapter.YYSoundAdapter;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYAudienceModel;
import com.blued.android.module.yy_china.model.YYEmojiModel;
import com.blued.android.module.yy_china.model.YYImModel;
import com.blued.android.module.yy_china.model.YYMsgEmojiExtra;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.model.YYSoundModel;
import com.blued.android.module.yy_china.trtc_audio.manager.AudioChannelManager;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.chad.library.adapter.base.BaseQuickAdapter;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYEmojiView.class */
public class YYEmojiView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private RecyclerView f18135a;
    private TextView b;

    /* renamed from: c  reason: collision with root package name */
    private BaseYYStudioFragment f18136c;
    private YYEmojiAdapter d;
    private YYSoundAdapter e;

    public YYEmojiView(Context context) {
        super(context);
        a();
    }

    public YYEmojiView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public YYEmojiView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    private void a() {
        LayoutInflater.from(getContext()).inflate(R.layout.view_yy_emoji_layout, (ViewGroup) this, true);
        this.b = (TextView) findViewById(R.id.rv_text);
        this.f18135a = (RecyclerView) findViewById(R.id.rv_list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(0);
        this.f18135a.setLayoutManager(linearLayoutManager);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(YYEmojiModel yYEmojiModel, YYRoomModel yYRoomModel) {
        EventTrackYY.i(ChatRoomProtos.Event.CHAT_ROOM_TOOLBOX_EMOJI_CLICK, yYRoomModel.room_id, yYRoomModel.uid, yYEmojiModel.id);
        YYRoomHttpUtils.g(yYRoomModel.room_id, yYEmojiModel.id, (BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntityA<YYMsgEmojiExtra>>(this.f18136c.getFragmentActive()) { // from class: com.blued.android.module.yy_china.view.YYEmojiView.5
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<YYMsgEmojiExtra> bluedEntityA) {
                if (bluedEntityA == null || !bluedEntityA.hasData()) {
                    return;
                }
                YYEmojiView.this.a(bluedEntityA.getSingleData());
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str) {
                return super.onUIFailure(i, str);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish(boolean z) {
                super.onUIFinish(z);
                if (YYEmojiView.this.f18136c != null) {
                    YYEmojiView.this.f18136c.y();
                }
            }
        }, (IRequestHost) this.f18136c.getFragmentActive());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(YYMsgEmojiExtra yYMsgEmojiExtra) {
        YYImModel yYImModel = new YYImModel();
        yYImModel.type = 27;
        YYAudienceModel yYAudienceModel = new YYAudienceModel();
        yYAudienceModel.setUid(YYRoomInfoManager.e().k());
        yYAudienceModel.setName(YYRoomInfoManager.e().l());
        yYAudienceModel.setAvatar(YYRoomInfoManager.e().m());
        yYImModel.source_profile = yYAudienceModel;
        yYImModel.setMsgExtra(AppInfo.f().toJson(yYMsgEmojiExtra));
        this.f18136c.a(YYRoomInfoManager.e().k(), yYMsgEmojiExtra.apng, yYImModel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i, final String str2) {
        YYRoomHttpUtils.h(str, i + "", (BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntityA<Object>>(this.f18136c.getFragmentActive()) { // from class: com.blued.android.module.yy_china.view.YYEmojiView.6
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
                if (YYEmojiView.this.f18136c != null) {
                    YYEmojiView.this.f18136c.y();
                }
                AudioChannelManager.j().a(2, str2);
            }
        }, (IRequestHost) this.f18136c.getFragmentActive());
    }

    private void getEmojiList() {
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null) {
            return;
        }
        YYRoomHttpUtils.s(b.room_id, (BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntityA<YYEmojiModel>>(this.f18136c.getFragmentActive()) { // from class: com.blued.android.module.yy_china.view.YYEmojiView.3
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<YYEmojiModel> bluedEntityA) {
                if (bluedEntityA == null || !bluedEntityA.hasData()) {
                    return;
                }
                YYEmojiView.this.d.setNewData(bluedEntityA.data);
            }
        }, (IRequestHost) this.f18136c.getFragmentActive());
    }

    private void getSoundList() {
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null) {
            return;
        }
        YYRoomHttpUtils.t(b.room_id, (BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntityA<YYSoundModel>>(this.f18136c.getFragmentActive()) { // from class: com.blued.android.module.yy_china.view.YYEmojiView.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<YYSoundModel> bluedEntityA) {
                if (bluedEntityA == null || !bluedEntityA.hasData()) {
                    return;
                }
                YYEmojiView.this.e.setNewData(bluedEntityA.data);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str) {
                return super.onUIFailure(i, str);
            }
        }, (IRequestHost) this.f18136c.getFragmentActive());
    }

    public void a(final BaseYYStudioFragment baseYYStudioFragment) {
        this.f18136c = baseYYStudioFragment;
        this.b.setText(getResources().getString(R.string.yy_mic_emoji));
        YYEmojiAdapter yYEmojiAdapter = new YYEmojiAdapter(baseYYStudioFragment.getFragmentActive());
        this.d = yYEmojiAdapter;
        this.f18135a.setAdapter(yYEmojiAdapter);
        this.d.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: com.blued.android.module.yy_china.view.YYEmojiView.1
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
            public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                YYRoomModel b;
                if (ClickUtils.a(view.getId()) || (b = YYRoomInfoManager.e().b()) == null) {
                    return;
                }
                if (b.isExistEmojiByUid(YYRoomInfoManager.e().k())) {
                    ToastUtils.a("请不要频繁操作!", 0);
                    return;
                }
                YYEmojiView.this.a((YYEmojiModel) baseQuickAdapter.getData().get(i), b);
                baseYYStudioFragment.y();
            }
        });
        getEmojiList();
    }

    public void b(BaseYYStudioFragment baseYYStudioFragment) {
        this.f18136c = baseYYStudioFragment;
        this.b.setText(getResources().getString(R.string.yy_mic_sound));
        YYSoundAdapter yYSoundAdapter = new YYSoundAdapter(baseYYStudioFragment.getFragmentActive());
        this.e = yYSoundAdapter;
        this.f18135a.setAdapter(yYSoundAdapter);
        this.e.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: com.blued.android.module.yy_china.view.YYEmojiView.2
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
            public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                YYSoundModel yYSoundModel = (YYSoundModel) baseQuickAdapter.getData().get(i);
                YYRoomModel b = YYRoomInfoManager.e().b();
                if (b != null) {
                    ChatRoomProtos.Event event = ChatRoomProtos.Event.CHAT_ROOM_TOOLBOX_MUSIC_SOMEONE_CLICK;
                    String str = b.room_id;
                    String str2 = b.uid;
                    EventTrackYY.j(event, str, str2, yYSoundModel.effect_id + "");
                }
                YYEmojiView.this.a(b.room_id, yYSoundModel.effect_id, yYSoundModel.media);
            }
        });
        getSoundList();
    }
}
