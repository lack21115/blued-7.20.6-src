package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYGameRewardView.class */
public class YYGameRewardView extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private TextView f18169a;
    private TextView b;

    /* renamed from: c  reason: collision with root package name */
    private ImageView f18170c;
    private ImageView d;
    private BaseYYStudioFragment e;

    public YYGameRewardView(Context context) {
        super(context);
        a();
    }

    public YYGameRewardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public YYGameRewardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    private void a() {
        LayoutInflater.from(getContext()).inflate(R.layout.dialog_game_reward_layout, (ViewGroup) this, true);
        this.f18169a = (TextView) findViewById(R.id.tv_winner_num);
        this.b = (TextView) findViewById(R.id.tv_reward_name);
        this.f18170c = (ImageView) findViewById(R.id.iv_reward_img);
        ImageView imageView = (ImageView) findViewById(R.id.iv_close);
        this.d = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.YYGameRewardView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                YYGameRewardView.this.e.y();
            }
        });
    }

    public void a(BaseYYStudioFragment baseYYStudioFragment, int i, String str, String str2) {
        this.e = baseYYStudioFragment;
        ImageLoader.a(baseYYStudioFragment.getFragmentActive(), str).b(R.drawable.gift_default_icon).a(this.f18170c);
        TextView textView = this.f18169a;
        textView.setText("第" + i + "队队员奖励");
        this.b.setText(str2);
    }
}
