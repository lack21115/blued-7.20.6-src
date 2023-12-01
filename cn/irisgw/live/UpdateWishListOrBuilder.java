package cn.irisgw.live;

import cn.irisgw.live.UpdateWishList;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/UpdateWishListOrBuilder.class */
public interface UpdateWishListOrBuilder extends MessageOrBuilder {
    UpdateWishList.WishList getWishList(int i);

    int getWishListCount();

    List<UpdateWishList.WishList> getWishListList();

    UpdateWishList.WishListOrBuilder getWishListOrBuilder(int i);

    List<? extends UpdateWishList.WishListOrBuilder> getWishListOrBuilderList();
}
