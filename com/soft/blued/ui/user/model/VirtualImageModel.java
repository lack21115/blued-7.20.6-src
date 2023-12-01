package com.soft.blued.ui.user.model;

import android.net.UrlQuerySanitizer;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/model/VirtualImageModel.class */
public final class VirtualImageModel {
    public static final int CATEGORY_PACKAGE_ID = -1;
    public static final int CATEGORY_SETTING = -2;
    public static final Companion Companion = new Companion(null);
    private List<CategoryModel> category_list;
    private int red_dot;

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/model/VirtualImageModel$CartCategoryHeader.class */
    public static final class CartCategoryHeader implements MultiItemEntity {
        private String text = "";

        @Override // com.chad.library.adapter.base.entity.MultiItemEntity
        public int getItemType() {
            return GoodsTypeInCart.Header.ordinal();
        }

        public final String getText() {
            return this.text;
        }

        public final void setText(String str) {
            Intrinsics.e(str, "<set-?>");
            this.text = str;
        }
    }

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/model/VirtualImageModel$CategoryModel.class */
    public static final class CategoryModel implements Serializable {
        private float block_code;
        private long created_at;
        private List<ImageGoodsModel> goods_list;
        private int id;
        private String name;
        private int pack_sort;
        private int parent_id;
        private String red_dot;
        private Resource resource;
        private long updated_at;
        private int zoom_in;

        public CategoryModel() {
            this(0, null, 0, null, 0.0f, 0L, 0L, null, 0, 0, null, UrlQuerySanitizer.IllegalCharacterValueSanitizer.ALL_OK, null);
        }

        public CategoryModel(int i, String str, int i2, Resource resource, float f, long j, long j2, List<ImageGoodsModel> list, int i3, int i4, String str2) {
            Intrinsics.e(str, "name");
            Intrinsics.e(str2, "red_dot");
            this.id = i;
            this.name = str;
            this.parent_id = i2;
            this.resource = resource;
            this.block_code = f;
            this.created_at = j;
            this.updated_at = j2;
            this.goods_list = list;
            this.zoom_in = i3;
            this.pack_sort = i4;
            this.red_dot = str2;
        }

        public /* synthetic */ CategoryModel(int i, String str, int i2, Resource resource, float f, long j, long j2, List list, int i3, int i4, String str2, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this((i5 & 1) != 0 ? 0 : i, (i5 & 2) != 0 ? "" : str, (i5 & 4) != 0 ? 0 : i2, (i5 & 8) != 0 ? null : resource, (i5 & 16) != 0 ? 0.0f : f, (i5 & 32) != 0 ? 0L : j, (i5 & 64) != 0 ? 0L : j2, (i5 & 128) != 0 ? null : list, (i5 & 256) != 0 ? 2 : i3, (i5 & 512) != 0 ? 0 : i4, (i5 & 1024) != 0 ? "" : str2);
        }

        public static /* synthetic */ CategoryModel copy$default(CategoryModel categoryModel, int i, String str, int i2, Resource resource, float f, long j, long j2, List list, int i3, int i4, String str2, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                i = categoryModel.id;
            }
            if ((i5 & 2) != 0) {
                str = categoryModel.name;
            }
            if ((i5 & 4) != 0) {
                i2 = categoryModel.parent_id;
            }
            if ((i5 & 8) != 0) {
                resource = categoryModel.resource;
            }
            if ((i5 & 16) != 0) {
                f = categoryModel.block_code;
            }
            if ((i5 & 32) != 0) {
                j = categoryModel.created_at;
            }
            if ((i5 & 64) != 0) {
                j2 = categoryModel.updated_at;
            }
            if ((i5 & 128) != 0) {
                list = categoryModel.goods_list;
            }
            if ((i5 & 256) != 0) {
                i3 = categoryModel.zoom_in;
            }
            if ((i5 & 512) != 0) {
                i4 = categoryModel.pack_sort;
            }
            if ((i5 & 1024) != 0) {
                str2 = categoryModel.red_dot;
            }
            return categoryModel.copy(i, str, i2, resource, f, j, j2, list, i3, i4, str2);
        }

        public final int component1() {
            return this.id;
        }

        public final int component10() {
            return this.pack_sort;
        }

        public final String component11() {
            return this.red_dot;
        }

        public final String component2() {
            return this.name;
        }

        public final int component3() {
            return this.parent_id;
        }

        public final Resource component4() {
            return this.resource;
        }

        public final float component5() {
            return this.block_code;
        }

        public final long component6() {
            return this.created_at;
        }

        public final long component7() {
            return this.updated_at;
        }

        public final List<ImageGoodsModel> component8() {
            return this.goods_list;
        }

        public final int component9() {
            return this.zoom_in;
        }

        public final CategoryModel copy(int i, String str, int i2, Resource resource, float f, long j, long j2, List<ImageGoodsModel> list, int i3, int i4, String str2) {
            Intrinsics.e(str, "name");
            Intrinsics.e(str2, "red_dot");
            return new CategoryModel(i, str, i2, resource, f, j, j2, list, i3, i4, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof CategoryModel) {
                CategoryModel categoryModel = (CategoryModel) obj;
                return this.id == categoryModel.id && Intrinsics.a(this.name, categoryModel.name) && this.parent_id == categoryModel.parent_id && Intrinsics.a(this.resource, categoryModel.resource) && Intrinsics.a(Float.valueOf(this.block_code), Float.valueOf(categoryModel.block_code)) && this.created_at == categoryModel.created_at && this.updated_at == categoryModel.updated_at && Intrinsics.a(this.goods_list, categoryModel.goods_list) && this.zoom_in == categoryModel.zoom_in && this.pack_sort == categoryModel.pack_sort && Intrinsics.a(this.red_dot, categoryModel.red_dot);
            }
            return false;
        }

        public final float getBlock_code() {
            return this.block_code;
        }

        public final long getCreated_at() {
            return this.created_at;
        }

        public final List<ImageGoodsModel> getGoods_list() {
            return this.goods_list;
        }

        public final int getId() {
            return this.id;
        }

        public final String getName() {
            return this.name;
        }

        public final int getPack_sort() {
            return this.pack_sort;
        }

        public final int getParent_id() {
            return this.parent_id;
        }

        public final String getRed_dot() {
            return this.red_dot;
        }

        public final Resource getResource() {
            return this.resource;
        }

        public final long getUpdated_at() {
            return this.updated_at;
        }

        public final int getZoom_in() {
            return this.zoom_in;
        }

        public int hashCode() {
            int i = this.id;
            int hashCode = this.name.hashCode();
            int i2 = this.parent_id;
            Resource resource = this.resource;
            int i3 = 0;
            int hashCode2 = resource == null ? 0 : resource.hashCode();
            int floatToIntBits = Float.floatToIntBits(this.block_code);
            int hashCode3 = C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.created_at);
            int hashCode4 = C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.updated_at);
            List<ImageGoodsModel> list = this.goods_list;
            if (list != null) {
                i3 = list.hashCode();
            }
            return (((((((((((((((((((i * 31) + hashCode) * 31) + i2) * 31) + hashCode2) * 31) + floatToIntBits) * 31) + hashCode3) * 31) + hashCode4) * 31) + i3) * 31) + this.zoom_in) * 31) + this.pack_sort) * 31) + this.red_dot.hashCode();
        }

        public final void setBlock_code(float f) {
            this.block_code = f;
        }

        public final void setCreated_at(long j) {
            this.created_at = j;
        }

        public final void setGoods_list(List<ImageGoodsModel> list) {
            this.goods_list = list;
        }

        public final void setId(int i) {
            this.id = i;
        }

        public final void setName(String str) {
            Intrinsics.e(str, "<set-?>");
            this.name = str;
        }

        public final void setPack_sort(int i) {
            this.pack_sort = i;
        }

        public final void setParent_id(int i) {
            this.parent_id = i;
        }

        public final void setRed_dot(String str) {
            Intrinsics.e(str, "<set-?>");
            this.red_dot = str;
        }

        public final void setResource(Resource resource) {
            this.resource = resource;
        }

        public final void setUpdated_at(long j) {
            this.updated_at = j;
        }

        public final void setZoom_in(int i) {
            this.zoom_in = i;
        }

        public String toString() {
            return "CategoryModel(id=" + this.id + ", name=" + this.name + ", parent_id=" + this.parent_id + ", resource=" + this.resource + ", block_code=" + this.block_code + ", created_at=" + this.created_at + ", updated_at=" + this.updated_at + ", goods_list=" + this.goods_list + ", zoom_in=" + this.zoom_in + ", pack_sort=" + this.pack_sort + ", red_dot=" + this.red_dot + ')';
        }
    }

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/model/VirtualImageModel$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/model/VirtualImageModel$Extra.class */
    public static final class Extra implements Serializable {
        private List<Tags> tags;

        public final List<Tags> getTags() {
            return this.tags;
        }

        public final void setTags(List<Tags> list) {
            this.tags = list;
        }
    }

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/model/VirtualImageModel$GoodsTypeInCart.class */
    public enum GoodsTypeInCart {
        Header,
        Goods
    }

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/model/VirtualImageModel$GuestImageGoodsModel.class */
    public static final class GuestImageGoodsModel implements Serializable {
        private float block_code;
        private int id;
        private Resource resource;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (Intrinsics.a(getClass(), obj == null ? null : obj.getClass())) {
                if (obj != null) {
                    return (this.block_code > ((GuestImageGoodsModel) obj).block_code ? 1 : (this.block_code == ((GuestImageGoodsModel) obj).block_code ? 0 : -1)) == 0;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.soft.blued.ui.user.model.VirtualImageModel.GuestImageGoodsModel");
            }
            return false;
        }

        public final float getBlock_code() {
            return this.block_code;
        }

        public final int getId() {
            return this.id;
        }

        public final Resource getResource() {
            return this.resource;
        }

        public int hashCode() {
            return Float.floatToIntBits(this.block_code);
        }

        public final void setBlock_code(float f) {
            this.block_code = f;
        }

        public final void setId(int i) {
            this.id = i;
        }

        public final void setResource(Resource resource) {
            this.resource = resource;
        }
    }

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/model/VirtualImageModel$ImageGoodsModel.class */
    public static final class ImageGoodsModel implements MultiItemEntity, Serializable {
        private int beans;
        private float block_code;
        private boolean cBuy;
        private int cResourceId;
        private int created_at;
        private int current_use;
        private int days;
        private long expire_at;
        private Extra extra;
        private int id;
        private int is_default;
        private int is_have;
        private List<Resource> resource;
        private int sort;
        private int status;
        private int updated_at;
        private int category_id = -1;
        private String name = "";
        private int cBuyCount = 1;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (Intrinsics.a(getClass(), obj == null ? null : obj.getClass())) {
                if (obj != null) {
                    return (this.block_code > ((ImageGoodsModel) obj).block_code ? 1 : (this.block_code == ((ImageGoodsModel) obj).block_code ? 0 : -1)) == 0;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.soft.blued.ui.user.model.VirtualImageModel.ImageGoodsModel");
            }
            return false;
        }

        public final int getBeans() {
            return this.beans;
        }

        public final float getBlock_code() {
            return this.block_code;
        }

        public final boolean getCBuy() {
            return this.cBuy;
        }

        public final int getCBuyCount() {
            return this.cBuyCount;
        }

        public final int getCResourceId() {
            return this.cResourceId;
        }

        public final int getCategory_id() {
            return this.category_id;
        }

        public final int getCreated_at() {
            return this.created_at;
        }

        public final int getCurrent_use() {
            return this.current_use;
        }

        public final int getDays() {
            return this.days;
        }

        public final int getDaysLeft() {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            long j = this.expire_at;
            if (j > currentTimeMillis) {
                long j2 = 60;
                return (int) ((((j - currentTimeMillis) / j2) / j2) / 24);
            }
            return 0;
        }

        public final long getExpire_at() {
            return this.expire_at;
        }

        public final Extra getExtra() {
            return this.extra;
        }

        public final int getId() {
            return this.id;
        }

        @Override // com.chad.library.adapter.base.entity.MultiItemEntity
        public int getItemType() {
            return GoodsTypeInCart.Goods.ordinal();
        }

        public final String getName() {
            return this.name;
        }

        public final List<Resource> getResource() {
            return this.resource;
        }

        public final int getSort() {
            return this.sort;
        }

        public final int getStatus() {
            return this.status;
        }

        public final int getUpdated_at() {
            return this.updated_at;
        }

        public int hashCode() {
            return Float.floatToIntBits(this.block_code);
        }

        public final int is_default() {
            return this.is_default;
        }

        public final int is_have() {
            return this.is_have;
        }

        public final void setBeans(int i) {
            this.beans = i;
        }

        public final void setBlock_code(float f) {
            this.block_code = f;
        }

        public final void setCBuy(boolean z) {
            this.cBuy = z;
        }

        public final void setCBuyCount(int i) {
            this.cBuyCount = i;
        }

        public final void setCResourceId(int i) {
            this.cResourceId = i;
        }

        public final void setCategory_id(int i) {
            this.category_id = i;
        }

        public final void setCreated_at(int i) {
            this.created_at = i;
        }

        public final void setCurrent_use(int i) {
            this.current_use = i;
        }

        public final void setDays(int i) {
            this.days = i;
        }

        public final void setExpire_at(long j) {
            this.expire_at = j;
        }

        public final void setExtra(Extra extra) {
            this.extra = extra;
        }

        public final void setId(int i) {
            this.id = i;
        }

        public final void setName(String str) {
            Intrinsics.e(str, "<set-?>");
            this.name = str;
        }

        public final void setResource(List<Resource> list) {
            this.resource = list;
        }

        public final void setSort(int i) {
            this.sort = i;
        }

        public final void setStatus(int i) {
            this.status = i;
        }

        public final void setUpdated_at(int i) {
            this.updated_at = i;
        }

        public final void set_default(int i) {
            this.is_default = i;
        }

        public final void set_have(int i) {
            this.is_have = i;
        }
    }

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/model/VirtualImageModel$MarketingActive.class */
    public static final class MarketingActive implements Serializable {
        private int is_show;
        private int position;
        private String link = "";
        private String img = "";

        public final String getImg() {
            return this.img;
        }

        public final String getLink() {
            return this.link;
        }

        public final int getPosition() {
            return this.position;
        }

        public final int is_show() {
            return this.is_show;
        }

        public final void setImg(String str) {
            Intrinsics.e(str, "<set-?>");
            this.img = str;
        }

        public final void setLink(String str) {
            Intrinsics.e(str, "<set-?>");
            this.link = str;
        }

        public final void setPosition(int i) {
            this.position = i;
        }

        public final void set_show(int i) {
            this.is_show = i;
        }
    }

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/model/VirtualImageModel$MarketingPicture.class */
    public static final class MarketingPicture implements Serializable {
        private MarketingActive active;
        private MarketingPopup popup;

        public final MarketingActive getActive() {
            return this.active;
        }

        public final MarketingPopup getPopup() {
            return this.popup;
        }

        public final void setActive(MarketingActive marketingActive) {
            this.active = marketingActive;
        }

        public final void setPopup(MarketingPopup marketingPopup) {
            this.popup = marketingPopup;
        }
    }

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/model/VirtualImageModel$MarketingPopup.class */
    public static final class MarketingPopup implements Serializable {
        private int is_show;
        private String link = "";
        private String img = "";
        private String pop_key = "";

        public final String getImg() {
            return this.img;
        }

        public final String getLink() {
            return this.link;
        }

        public final String getPop_key() {
            return this.pop_key;
        }

        public final int is_show() {
            return this.is_show;
        }

        public final void setImg(String str) {
            Intrinsics.e(str, "<set-?>");
            this.img = str;
        }

        public final void setLink(String str) {
            Intrinsics.e(str, "<set-?>");
            this.link = str;
        }

        public final void setPop_key(String str) {
            Intrinsics.e(str, "<set-?>");
            this.pop_key = str;
        }

        public final void set_show(int i) {
            this.is_show = i;
        }
    }

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/model/VirtualImageModel$PaidResp.class */
    public static final class PaidResp implements Serializable {
        private int left_beans;
        private String payment_token = "";

        public final int getLeft_beans() {
            return this.left_beans;
        }

        public final String getPayment_token() {
            return this.payment_token;
        }

        public final void setLeft_beans(int i) {
            this.left_beans = i;
        }

        public final void setPayment_token(String str) {
            Intrinsics.e(str, "<set-?>");
            this.payment_token = str;
        }
    }

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/model/VirtualImageModel$PayGoodsInfo.class */
    public static final class PayGoodsInfo implements Serializable {
        private int goods_id;
        private int goods_num;

        public final int getGoods_id() {
            return this.goods_id;
        }

        public final int getGoods_num() {
            return this.goods_num;
        }

        public final void setGoods_id(int i) {
            this.goods_id = i;
        }

        public final void setGoods_num(int i) {
            this.goods_num = i;
        }
    }

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/model/VirtualImageModel$Resource.class */
    public static final class Resource implements Serializable {
        private int id;
        private int parent_id;
        private String checked = "";
        private String icon = "";

        /* renamed from: static  reason: not valid java name */
        private String f4static = "";
        private String dynamic = "";

        public final String getChecked() {
            return this.checked;
        }

        public final String getDynamic() {
            return this.dynamic;
        }

        public final String getIcon() {
            return this.icon;
        }

        public final int getId() {
            return this.id;
        }

        public final int getParent_id() {
            return this.parent_id;
        }

        public final String getStatic() {
            return this.f4static;
        }

        public final void setChecked(String str) {
            Intrinsics.e(str, "<set-?>");
            this.checked = str;
        }

        public final void setDynamic(String str) {
            Intrinsics.e(str, "<set-?>");
            this.dynamic = str;
        }

        public final void setIcon(String str) {
            Intrinsics.e(str, "<set-?>");
            this.icon = str;
        }

        public final void setId(int i) {
            this.id = i;
        }

        public final void setParent_id(int i) {
            this.parent_id = i;
        }

        public final void setStatic(String str) {
            Intrinsics.e(str, "<set-?>");
            this.f4static = str;
        }

        public String toString() {
            return "Resource(checked='" + this.checked + "', parent_id=" + this.parent_id + ", icon='" + this.icon + "', static='" + this.f4static + "', dynamic='" + this.dynamic + "')";
        }
    }

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/model/VirtualImageModel$Tags.class */
    public static final class Tags implements Serializable {
        private int position;
        private String title = "";

        public final int getPosition() {
            return this.position;
        }

        public final String getTitle() {
            return this.title;
        }

        public final void setPosition(int i) {
            this.position = i;
        }

        public final void setTitle(String str) {
            Intrinsics.e(str, "<set-?>");
            this.title = str;
        }
    }

    public final List<CategoryModel> getCategory_list() {
        return this.category_list;
    }

    public final int getRed_dot() {
        return this.red_dot;
    }

    public final void setCategory_list(List<CategoryModel> list) {
        this.category_list = list;
    }

    public final void setRed_dot(int i) {
        this.red_dot = i;
    }
}
