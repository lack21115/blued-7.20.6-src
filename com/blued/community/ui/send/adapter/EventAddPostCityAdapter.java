package com.blued.community.ui.send.adapter;

import com.blued.android.module.common.utils.cities.ChineseCitiesModel;
import com.blued.community.R;
import com.blued.community.utils.CityHelper;
import com.brandongogetap.stickyheaders.exposed.StickyHeader;
import com.brandongogetap.stickyheaders.exposed.StickyHeaderHandler;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/community/ui/send/adapter/EventAddPostCityAdapter.class */
public final class EventAddPostCityAdapter extends BaseMultiItemQuickAdapter<EventAddPostCity, BaseViewHolder> implements StickyHeaderHandler {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f19894a = new Companion(null);

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/community/ui/send/adapter/EventAddPostCityAdapter$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/community/ui/send/adapter/EventAddPostCityAdapter$EventAddPostCity.class */
    public static class EventAddPostCity implements MultiItemEntity {

        /* renamed from: a  reason: collision with root package name */
        private ChineseCitiesModel f19895a;
        private boolean b;

        /* renamed from: c  reason: collision with root package name */
        private int f19896c;

        public EventAddPostCity(ChineseCitiesModel city) {
            Intrinsics.e(city, "city");
            this.f19895a = city;
        }

        public final ChineseCitiesModel a() {
            return this.f19895a;
        }

        public final void a(ChineseCitiesModel chineseCitiesModel) {
            Intrinsics.e(chineseCitiesModel, "<set-?>");
            this.f19895a = chineseCitiesModel;
        }

        public final void a(boolean z) {
            this.b = z;
        }

        public final boolean b() {
            return this.b;
        }

        public int c() {
            return this.f19896c;
        }

        @Override // com.chad.library.adapter.base.entity.MultiItemEntity
        public int getItemType() {
            return c();
        }
    }

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/community/ui/send/adapter/EventAddPostCityAdapter$EventAddPostCityHeader.class */
    public static final class EventAddPostCityHeader extends EventAddPostCity {

        /* renamed from: a  reason: collision with root package name */
        private int f19897a;

        public EventAddPostCityHeader() {
            super(new ChineseCitiesModel());
            this.f19897a = 2;
        }

        @Override // com.blued.community.ui.send.adapter.EventAddPostCityAdapter.EventAddPostCity
        public int c() {
            return this.f19897a;
        }
    }

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/community/ui/send/adapter/EventAddPostCityAdapter$EventAddPostCityPinYin.class */
    public static final class EventAddPostCityPinYin extends EventAddPostCity implements StickyHeader {

        /* renamed from: a  reason: collision with root package name */
        private String f19898a;
        private int b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public EventAddPostCityPinYin(String pinYin) {
            super(new ChineseCitiesModel());
            Intrinsics.e(pinYin, "pinYin");
            this.f19898a = pinYin;
            this.b = 1;
        }

        @Override // com.blued.community.ui.send.adapter.EventAddPostCityAdapter.EventAddPostCity
        public int c() {
            return this.b;
        }

        public final String d() {
            return this.f19898a;
        }
    }

    public EventAddPostCityAdapter() {
        super(null);
        addItemType(0, R.layout.item_select_city);
        addItemType(1, R.layout.item_select_city_pinyin);
        addItemType(2, R.layout.layout_select_city_header);
    }

    @Override // com.brandongogetap.stickyheaders.exposed.StickyHeaderHandler
    public List<?> a() {
        List data = getData();
        Intrinsics.c(data, "data");
        return data;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(BaseViewHolder helper, EventAddPostCity item) {
        Intrinsics.e(helper, "helper");
        Intrinsics.e(item, "item");
        int c2 = item.c();
        if (c2 == 0) {
            helper.setText(R.id.tv_city, item.a().t);
            helper.setGone(R.id.line, !item.b());
        } else if (c2 == 1) {
            helper.setText(R.id.tv_pinyin, ((EventAddPostCityPinYin) item).d());
        } else if (c2 != 2) {
        } else {
            ChineseCitiesModel chineseCitiesModel = new ChineseCitiesModel(CityHelper.a().d(this.mContext), CityHelper.a().h(), CityHelper.a().i());
            helper.setText(R.id.tv_city, chineseCitiesModel.t);
            helper.addOnClickListener(R.id.tv_city);
            item.a(chineseCitiesModel);
        }
    }
}
