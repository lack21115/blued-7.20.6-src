package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYAudienceModel;
import com.blued.android.module.yy_china.model.YYEmojiModel;
import com.blued.android.module.yy_china.model.YYImModel;
import com.blued.android.module.yy_china.model.YYMsgEmojiExtra;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYPlayGameView.class */
public class YYPlayGameView extends FrameLayout {
    private BaseYYStudioFragment a;
    private TextView b;
    private TextView c;
    private ImageView d;
    private TextView e;
    private LinearLayout f;
    private ShapeTextView g;
    private YYRoomModel h;
    private String i;

    public YYPlayGameView(Context context) {
        super(context);
        a();
    }

    public YYPlayGameView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public YYPlayGameView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    private void a() {
        LayoutInflater.from(getContext()).inflate(R.layout.view_yy_play_game_layout, (ViewGroup) this, true);
        this.b = (TextView) findViewById(R.id.tv_game_title);
        this.c = (TextView) findViewById(R.id.tv_game_name);
        this.d = (ImageView) findViewById(R.id.iv_game_img);
        this.e = (TextView) findViewById(R.id.tv_join_game);
        this.f = (LinearLayout) findViewById(R.id.ll_data_view);
        this.g = (ShapeTextView) findViewById(R.id.no_data_view);
        this.e.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.YYPlayGameView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                YYPlayGameView.this.b();
            }
        });
        this.g.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.YYPlayGameView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                YYPlayGameView.this.getGameInfo();
            }
        });
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
        this.a.a(YYRoomInfoManager.e().k(), yYMsgEmojiExtra.apng, yYImModel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.h == null || TextUtils.isEmpty(this.i)) {
            return;
        }
        YYRoomHttpUtils.o(this.h.room_id, this.i, new BluedUIHttpResponse<BluedEntityA<YYMsgEmojiExtra>>(this.a.getFragmentActive()) { // from class: com.blued.android.module.yy_china.view.YYPlayGameView.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<YYMsgEmojiExtra> bluedEntityA) {
                if (bluedEntityA == null || !bluedEntityA.hasData()) {
                    return;
                }
                YYPlayGameView.this.a(bluedEntityA.getSingleData());
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish(boolean z) {
                super.onUIFinish(z);
                if (YYPlayGameView.this.a != null) {
                    YYPlayGameView.this.a.y();
                }
            }
        }, this.a.getFragmentActive());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getGameInfo() {
        YYRoomModel yYRoomModel = this.h;
        if (yYRoomModel == null) {
            return;
        }
        YYRoomHttpUtils.K(yYRoomModel.room_id, new BluedUIHttpResponse<BluedEntityA<YYEmojiModel>>(this.a.getFragmentActive()) { // from class: com.blued.android.module.yy_china.view.YYPlayGameView.3
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<YYEmojiModel> bluedEntityA) {
                if (bluedEntityA == null || bluedEntityA.getSingleData() == null) {
                    YYPlayGameView.this.f.setVisibility(8);
                    YYPlayGameView.this.g.setVisibility(0);
                    return;
                }
                YYPlayGameView.this.f.setVisibility(0);
                YYPlayGameView.this.g.setVisibility(8);
                YYPlayGameView.this.i = bluedEntityA.getSingleData().id;
                ImageLoader.a(YYPlayGameView.this.a.getFragmentActive(), bluedEntityA.getSingleData().pic).b(R.drawable.defaultpicture).a(YYPlayGameView.this.d);
                YYPlayGameView.this.b.setText(String.format(YYPlayGameView.this.getResources().getString(R.string.yy_game_title), bluedEntityA.getSingleData().name));
                YYPlayGameView.this.c.setText(bluedEntityA.getSingleData().name);
            }

            @Override // com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
            public void onFailure(Throwable th) {
                super.onFailure(th);
                AppInfo.n().post(new Runnable() { // from class: com.blued.android.module.yy_china.view.YYPlayGameView.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        YYPlayGameView.this.f.setVisibility(8);
                        YYPlayGameView.this.g.setVisibility(0);
                    }
                });
            }
        }, this.a.getFragmentActive());
    }

    public void a(BaseYYStudioFragment baseYYStudioFragment) {
        this.a = baseYYStudioFragment;
        this.h = YYRoomInfoManager.e().b();
        getGameInfo();
    }
}
