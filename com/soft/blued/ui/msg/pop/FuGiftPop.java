package com.soft.blued.ui.msg.pop;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.framework.ui.xpop.core.CenterPopupView;
import com.blued.android.framework.utils.DensityUtils;
import com.bytedance.applog.tracker.Tracker;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.R;
import com.soft.blued.constant.EventBusConstant;
import com.soft.blued.customview.SpacesItemDecoration;
import com.soft.blued.ui.msg.adapter.FuGiftAdapter;
import com.soft.blued.ui.msg.event.OpenGiftPackageEvent;
import com.soft.blued.ui.msg.model.FuGiftModel;
import com.soft.blued.utils.BluedPreferences;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/pop/FuGiftPop.class */
public class FuGiftPop extends CenterPopupView {

    /* renamed from: c  reason: collision with root package name */
    private RecyclerView f32474c;
    private List<FuGiftModel> d;
    private TextView e;
    private TextView f;
    private ImageView g;
    private ActivityFragmentActive h;
    private String i;

    public FuGiftPop(Context context, List<FuGiftModel> list, String str, ActivityFragmentActive activityFragmentActive) {
        super(context);
        this.d = list;
        this.i = str;
        this.h = activityFragmentActive;
    }

    @Override // com.blued.android.framework.ui.xpop.core.CenterPopupView, com.blued.android.framework.ui.xpop.core.BasePopupView
    public void b() {
        super.b();
        RecyclerView recyclerView = (RecyclerView) findViewById(2131369096);
        this.f32474c = recyclerView;
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
        SpacesItemDecoration spacesItemDecoration = new SpacesItemDecoration(DensityUtils.a(getContext(), 5.0f));
        spacesItemDecoration.a(true, false, false, false);
        spacesItemDecoration.a(5);
        FuGiftAdapter fuGiftAdapter = new FuGiftAdapter(this.d, this.h);
        this.f32474c.addItemDecoration(spacesItemDecoration);
        this.f32474c.setAdapter(fuGiftAdapter);
        this.e = (TextView) findViewById(2131371675);
        String string = getContext().getString(R.string.msg_get_following_gifts);
        TextView textView = this.e;
        textView.setText("- " + String.format(string, Integer.valueOf(this.d.size())) + " -");
        this.f = (TextView) findViewById(R.id.tv_add);
        this.g = (ImageView) findViewById(2131365504);
        if (!TextUtils.isEmpty(this.i)) {
            ImageLoader.a(this.h, this.i).a(this.g);
        }
        this.f.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.pop.FuGiftPop.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                BluedPreferences.aa(false);
                FuGiftPop.this.p();
                OpenGiftPackageEvent openGiftPackageEvent = new OpenGiftPackageEvent();
                openGiftPackageEvent.f32328a = FuGiftPop.this.h;
                LiveEventBus.get(EventBusConstant.KEY_EVENT_OPEN_GIFT_PACKAGE).post(openGiftPackageEvent);
            }
        });
    }

    @Override // com.blued.android.framework.ui.xpop.core.CenterPopupView, com.blued.android.framework.ui.xpop.core.BasePopupView
    public int getImplLayoutId() {
        return R.layout.pop_fu_gift;
    }

    @Override // com.blued.android.framework.ui.xpop.core.CenterPopupView, com.blued.android.framework.ui.xpop.core.BasePopupView
    public int getMaxWidth() {
        return AppInfo.l;
    }
}
