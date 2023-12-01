package cn.irisgw.live;

import cn.irisgw.live.BoxGiftExtra;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/BoxGiftExtraOrBuilder.class */
public interface BoxGiftExtraOrBuilder extends MessageOrBuilder {
    BoxGiftExtra.Bonus getBonus(int i);

    int getBonusCount();

    List<BoxGiftExtra.Bonus> getBonusList();

    BoxGiftExtra.BonusOrBuilder getBonusOrBuilder(int i);

    List<? extends BoxGiftExtra.BonusOrBuilder> getBonusOrBuilderList();
}
