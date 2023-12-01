package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityBaseExtra;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.framework.utils.Logger;
import com.blued.android.framework.view.shape.ShapeConstraintLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.utils.CommonStringUtils;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.android.module.common.view.LiveGiftIndicatorView;
import com.blued.android.module.live.base.view.GiftHitLoadingView;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYGiftModel;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYWishListView.class */
public class YYWishListView extends ConstraintLayout {
    private ViewPager a;
    private ShapeTextView b;
    private WishPagerAdapter c;
    private LiveGiftIndicatorView d;
    private BaseYYStudioFragment e;
    private int f;
    private int g;
    private YYGiftModel h;
    private OnConfirmListener i;
    private Set<String> j;
    private int k;

    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYWishListView$OnConfirmListener.class */
    public interface OnConfirmListener {
        void a(YYGiftModel yYGiftModel, int i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYWishListView$WishItemAdapter.class */
    public class WishItemAdapter extends BaseQuickAdapter<YYGiftModel, BaseViewHolder> {
        public WishItemAdapter() {
            super(R.layout.item_yy_gift_nomer, new ArrayList());
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: a */
        public void convert(BaseViewHolder baseViewHolder, YYGiftModel yYGiftModel) {
            TextView textView = (TextView) baseViewHolder.getView(R.id.item_live_gift_price);
            ShapeTextView shapeTextView = (ShapeTextView) baseViewHolder.getView(R.id.item_live_gift_week_star);
            GiftHitLoadingView giftHitLoadingView = (GiftHitLoadingView) baseViewHolder.getView(R.id.item_live_gift_hit_loading);
            ImageView imageView = (ImageView) baseViewHolder.getView(R.id.iv_back);
            ShapeConstraintLayout shapeConstraintLayout = (ShapeConstraintLayout) baseViewHolder.getView(R.id.sha_ll_gift);
            ImageView imageView2 = (ImageView) baseViewHolder.getView(R.id.item_live_gift_view_iv);
            TextView textView2 = (TextView) baseViewHolder.getView(R.id.item_live_gift_name);
            textView.setVisibility(0);
            giftHitLoadingView.setVisibility(8);
            shapeTextView.setVisibility(8);
            textView.setText(CommonStringUtils.a(yYGiftModel.beans) + this.mContext.getString(R.string.yy_gift_beans));
            textView2.setText(yYGiftModel.name);
            ImageLoader.a((IRequestHost) null, yYGiftModel.images_static).b(R.drawable.gift_default_icon).a(imageView2);
            if (yYGiftModel.isSelected) {
                imageView.setBackgroundResource(R.drawable.shape_gift_select);
            } else {
                imageView.setBackgroundResource(R.color.transparent);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYWishListView$WishPagerAdapter.class */
    public class WishPagerAdapter extends PagerAdapter {
        private List<List<YYGiftModel>> b;
        private Context c;
        private HashMap<Integer, WishItemAdapter> d = new HashMap<>();

        public WishPagerAdapter(Context context) {
            this.c = context;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a() {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= getCount()) {
                    return;
                }
                this.d.get(Integer.valueOf(i2)).notifyDataSetChanged();
                i = i2 + 1;
            }
        }

        public void a(List<List<YYGiftModel>> list) {
            this.b = list;
            LogUtils.d("YYWishListView", "page list size = " + list.size());
            notifyDataSetChanged();
        }

        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }

        public int getCount() {
            List<List<YYGiftModel>> list = this.b;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        public Object instantiateItem(ViewGroup viewGroup, int i) {
            RecyclerView inflate = LayoutInflater.from(this.c).inflate(R.layout.yy_recycler_view_layout, (ViewGroup) null);
            inflate.setLayoutManager(new GridLayoutManager(YYWishListView.this.getContext(), YYWishListView.this.getColumn()));
            final WishItemAdapter wishItemAdapter = new WishItemAdapter();
            inflate.setAdapter(wishItemAdapter);
            inflate.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: com.blued.android.module.yy_china.view.YYWishListView.WishPagerAdapter.1
                public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
                    rect.right = DensityUtils.a(YYWishListView.this.getContext(), 5.0f);
                }
            });
            wishItemAdapter.setNewData(this.b.get(i));
            wishItemAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: com.blued.android.module.yy_china.view.YYWishListView.WishPagerAdapter.2
                public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
                    YYGiftModel yYGiftModel = (YYGiftModel) wishItemAdapter.getData().get(i2);
                    for (List<YYGiftModel> list : WishPagerAdapter.this.b) {
                        for (YYGiftModel yYGiftModel2 : list) {
                            if (TextUtils.equals(yYGiftModel.goods_id, yYGiftModel2.goods_id)) {
                                yYGiftModel2.isSelected = true;
                                YYWishListView.this.h = yYGiftModel;
                            } else {
                                yYGiftModel2.isSelected = false;
                            }
                        }
                    }
                    WishPagerAdapter.this.a();
                }
            });
            this.d.put(Integer.valueOf(i), wishItemAdapter);
            LogUtils.d("YYWishListView", "RecyclerView list size = " + this.b.get(i).size());
            viewGroup.addView(inflate);
            return inflate;
        }

        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }
    }

    public YYWishListView(Context context) {
        super(context);
        this.f = 2;
        this.g = 4;
        a();
    }

    public YYWishListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f = 2;
        this.g = 4;
        a();
    }

    public YYWishListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f = 2;
        this.g = 4;
        a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void a() {
        LayoutInflater.from(getContext()).inflate(R.layout.view_yy_wish_list, (ViewGroup) this, true);
        this.a = findViewById(R.id.gift_view_pager);
        this.d = (LiveGiftIndicatorView) findViewById(R.id.gift_indicator_view);
        this.b = (ShapeTextView) findViewById(R.id.ll_ok);
        WishPagerAdapter wishPagerAdapter = new WishPagerAdapter(getContext());
        this.c = wishPagerAdapter;
        this.a.setAdapter(wishPagerAdapter);
        this.a.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.blued.android.module.yy_china.view.YYWishListView.1
            public void onPageScrollStateChanged(int i) {
            }

            public void onPageScrolled(int i, float f, int i2) {
            }

            public void onPageSelected(int i) {
                YYWishListView.this.d.b(i);
            }
        });
        this.b.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.YYWishListView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                if (YYWishListView.this.j != null && YYWishListView.this.j.contains(YYWishListView.this.h.goods_id)) {
                    ToastUtils.a("已选择该礼物，不能重复选择");
                } else if (YYWishListView.this.i != null) {
                    YYWishListView.this.i.a(YYWishListView.this.h, YYWishListView.this.k);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<YYGiftModel> list) {
        LogUtils.d("YYWishListView", "wish list size = " + list.size());
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = null;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                this.c.a(arrayList);
                this.a.setOffscreenPageLimit(arrayList.size());
                b();
                return;
            }
            YYGiftModel yYGiftModel = list.get(i2);
            if (i2 == 0) {
                yYGiftModel.isSelected = true;
                this.h = yYGiftModel;
            }
            if (i2 % 8 == 0) {
                arrayList2 = new ArrayList();
                arrayList.add(arrayList2);
            }
            arrayList2.add(yYGiftModel);
            i = i2 + 1;
        }
    }

    private void b() {
        this.d.setSelectedImgRes(R.drawable.icon_gift_page_selected);
        this.d.a(this.c.getCount());
        this.d.setIndicatorCount(this.c.getCount());
    }

    private void getWishList() {
        if (this.e == null || YYRoomInfoManager.e().b() == null) {
            return;
        }
        YYRoomHttpUtils.B(YYRoomInfoManager.e().b().room_id, new BluedUIHttpResponse<BluedEntity<YYGiftModel, BluedEntityBaseExtra>>(this.e.getFragmentActive()) { // from class: com.blued.android.module.yy_china.view.YYWishListView.3
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<YYGiftModel, BluedEntityBaseExtra> bluedEntity) {
                if (bluedEntity == null || bluedEntity.data == null || bluedEntity.data.isEmpty()) {
                    Logger.e("YYWishListView", "从网络获取礼物列表失败 无数据");
                    return;
                }
                if (bluedEntity.extra != null) {
                    YYWishListView.this.k = bluedEntity.extra.total;
                }
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= bluedEntity.data.size()) {
                        YYWishListView.this.a(bluedEntity.data);
                        return;
                    } else {
                        bluedEntity.data.get(i2).sendGiftStatus = 0;
                        i = i2 + 1;
                    }
                }
            }
        }, this.e.getFragmentActive());
    }

    public void a(BaseYYStudioFragment baseYYStudioFragment, Set<String> set) {
        this.e = baseYYStudioFragment;
        this.j = set;
        getWishList();
    }

    public int getColumn() {
        return this.g;
    }

    public int getLine() {
        return this.f;
    }

    public YYGiftModel getSelectedItem() {
        return this.h;
    }

    public void setColumn(int i) {
        this.g = i;
    }

    public void setLine(int i) {
        this.f = i;
    }

    public void setOkListener(OnConfirmListener onConfirmListener) {
        this.i = onConfirmListener;
    }
}
