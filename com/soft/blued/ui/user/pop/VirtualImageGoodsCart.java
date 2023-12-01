package com.soft.blued.ui.user.pop;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.ui.xpop.core.BottomPopupView;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.soft.blued.R;
import com.soft.blued.ui.user.adapter.VirtualImageGoodsCartAdapter;
import com.soft.blued.ui.user.model.VirtualImageModel;
import com.soft.blued.ui.user.utils.VirtualImageUtils;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/pop/VirtualImageGoodsCart.class */
public final class VirtualImageGoodsCart extends BottomPopupView {
    private final IRequestHost b;

    /* renamed from: c  reason: collision with root package name */
    private final List<MultiItemEntity> f20564c;
    private final VirtualImageUtils d;
    private OnCartClickListener e;
    private TextView f;
    private TextView g;
    private ShapeTextView h;
    private int i;
    private int j;

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/pop/VirtualImageGoodsCart$OnCartClickListener.class */
    public interface OnCartClickListener {
        void a(int i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public VirtualImageGoodsCart(Context context, IRequestHost iRequestHost, List<? extends MultiItemEntity> list, VirtualImageUtils virtualImageUtils, OnCartClickListener onCartClickListener) {
        super(context);
        Intrinsics.e(context, "context");
        Intrinsics.e(iRequestHost, "requestHost");
        Intrinsics.e(list, "dataList");
        Intrinsics.e(virtualImageUtils, "virtualImageUtils");
        this.b = iRequestHost;
        this.f20564c = list;
        this.d = virtualImageUtils;
        this.e = onCartClickListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(VirtualImageGoodsCart virtualImageGoodsCart, View view) {
        Tracker.onClick(view);
        Intrinsics.e(virtualImageGoodsCart, "this$0");
        virtualImageGoodsCart.p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(VirtualImageGoodsCart virtualImageGoodsCart, View view) {
        OnCartClickListener onCartClickListener;
        Tracker.onClick(view);
        Intrinsics.e(virtualImageGoodsCart, "this$0");
        int i = virtualImageGoodsCart.j;
        if (i <= 0 || (onCartClickListener = virtualImageGoodsCart.e) == null) {
            return;
        }
        onCartClickListener.a(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c() {
        ShapeHelper.ShapeView shapeView = this.h;
        if (shapeView != null) {
            ShapeHelper.b(shapeView, getTotalBeans() > 0 ? 2131101864 : 2131101625);
        }
        TextView textView = this.f;
        if (textView != null) {
            textView.setText(String.valueOf(this.j));
        }
        TextView textView2 = this.g;
        if (textView2 == null) {
            return;
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.a;
        String string = getContext().getString(R.string.user_virtual_image_total_selected);
        Intrinsics.c(string, "context.getString(R.stri…ual_image_total_selected)");
        String format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(this.i)}, 1));
        Intrinsics.c(format, "format(format, *args)");
        textView2.setText(format);
    }

    public void b() {
        super.b();
        ((FrameLayout) findViewById(R.id.fl_close)).setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.pop.-$$Lambda$VirtualImageGoodsCart$johtUlaY5OXLVyNJoZ-OlEp1E4s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VirtualImageGoodsCart.a(VirtualImageGoodsCart.this, view);
            }
        });
        for (MultiItemEntity multiItemEntity : this.f20564c) {
            if (multiItemEntity instanceof VirtualImageModel.ImageGoodsModel) {
                VirtualImageModel.ImageGoodsModel imageGoodsModel = (VirtualImageModel.ImageGoodsModel) multiItemEntity;
                if (imageGoodsModel.getCBuy()) {
                    setTotalBeans(getTotalBeans() + (imageGoodsModel.getBeans() * imageGoodsModel.getCBuyCount()));
                    setTotalCount(getTotalCount() + imageGoodsModel.getCBuyCount());
                }
            }
        }
        this.f = (TextView) findViewById(R.id.tv_total_price);
        this.g = (TextView) findViewById(R.id.tv_total_good_count);
        this.h = findViewById(R.id.stv_pay);
        c();
        ShapeTextView shapeTextView = this.h;
        if (shapeTextView != null) {
            shapeTextView.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.pop.-$$Lambda$VirtualImageGoodsCart$r_pdQYlaeM3AxqkhqwYyVUs-WLE
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    VirtualImageGoodsCart.b(VirtualImageGoodsCart.this, view);
                }
            });
        }
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_good_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        recyclerView.setAdapter(new VirtualImageGoodsCartAdapter(this.b, this.f20564c, this.d, new VirtualImageGoodsCartAdapter.OnBuyInfoChangedListener() { // from class: com.soft.blued.ui.user.pop.VirtualImageGoodsCart$initPopupContent$4
            @Override // com.soft.blued.ui.user.adapter.VirtualImageGoodsCartAdapter.OnBuyInfoChangedListener
            public void a(int i, int i2) {
                if (VirtualImageGoodsCart.this.getTotalCount() + i >= 0) {
                    VirtualImageGoodsCart virtualImageGoodsCart = VirtualImageGoodsCart.this;
                    virtualImageGoodsCart.setTotalCount(virtualImageGoodsCart.getTotalCount() + i);
                    VirtualImageGoodsCart virtualImageGoodsCart2 = VirtualImageGoodsCart.this;
                    virtualImageGoodsCart2.setTotalBeans(virtualImageGoodsCart2.getTotalBeans() + i2);
                    VirtualImageGoodsCart.this.c();
                }
            }
        }));
    }

    public final List<MultiItemEntity> getDataList() {
        return this.f20564c;
    }

    public int getImplLayoutId() {
        return R.layout.layout_virtual_image_buy;
    }

    public final OnCartClickListener getListener() {
        return this.e;
    }

    public final IRequestHost getRequestHost() {
        return this.b;
    }

    public final int getTotalBeans() {
        return this.j;
    }

    public final int getTotalCount() {
        return this.i;
    }

    public final VirtualImageUtils getVirtualImageUtils() {
        return this.d;
    }

    public final void setListener(OnCartClickListener onCartClickListener) {
        this.e = onCartClickListener;
    }

    public final void setTotalBeans(int i) {
        this.j = i;
    }

    public final void setTotalCount(int i) {
        this.i = i;
    }
}
