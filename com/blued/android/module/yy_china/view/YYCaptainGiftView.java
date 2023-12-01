package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.ClickUtils;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYGiftModel;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYCaptainGiftView.class */
public class YYCaptainGiftView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private ShapeTextView f18079a;
    private ImageView b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f18080c;
    private TextView d;
    private BaseYYStudioFragment e;
    private String f;
    private YYRoomModel g;
    private OnJoinListener h;

    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYCaptainGiftView$OnJoinListener.class */
    public interface OnJoinListener {
        void a();
    }

    public YYCaptainGiftView(Context context) {
        super(context);
        a();
    }

    public YYCaptainGiftView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public YYCaptainGiftView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    private void a() {
        LayoutInflater.from(getContext()).inflate(R.layout.view_yy_captain_gift_layout, (ViewGroup) this, true);
        this.b = (ImageView) findViewById(R.id.iv_captain_gift);
        this.f18080c = (TextView) findViewById(R.id.tv_captain_gift_name);
        this.d = (TextView) findViewById(R.id.tv_captain_gift_price);
        ShapeTextView shapeTextView = (ShapeTextView) findViewById(R.id.tv_join_game);
        this.f18079a = shapeTextView;
        shapeTextView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.YYCaptainGiftView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                if (ClickUtils.a(R.id.tv_join_game) || YYCaptainGiftView.this.e == null || YYCaptainGiftView.this.g == null) {
                    return;
                }
                if (YYCaptainGiftView.this.h != null) {
                    YYCaptainGiftView.this.h.a();
                }
                YYCaptainGiftView.this.e.a(true, "", YYCaptainGiftView.this.f, YYCaptainGiftView.this.g.uid);
            }
        });
    }

    private void getCaptainGift() {
        YYRoomModel yYRoomModel = this.g;
        if (yYRoomModel == null) {
            return;
        }
        YYRoomHttpUtils.F(yYRoomModel.room_id, new BluedUIHttpResponse<BluedEntityA<YYGiftModel>>(this.e.getFragmentActive()) { // from class: com.blued.android.module.yy_china.view.YYCaptainGiftView.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<YYGiftModel> bluedEntityA) {
                if (bluedEntityA == null || !bluedEntityA.hasData()) {
                    return;
                }
                YYCaptainGiftView.this.f = bluedEntityA.getSingleData().goods_id;
                ImageLoader.a(YYCaptainGiftView.this.e.getFragmentActive(), bluedEntityA.getSingleData().images_static).b(R.drawable.gift_default_icon).a(YYCaptainGiftView.this.b);
                TextView textView = YYCaptainGiftView.this.d;
                textView.setText(bluedEntityA.getSingleData().beans + "豆");
            }
        }, this.e.getFragmentActive());
    }

    public void a(BaseYYStudioFragment baseYYStudioFragment, OnJoinListener onJoinListener) {
        this.e = baseYYStudioFragment;
        this.h = onJoinListener;
        this.g = YYRoomInfoManager.e().b();
        getCaptainGift();
    }
}
