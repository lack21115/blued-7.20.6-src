package cn.irisgw.live;

import cn.irisgw.live.MedalExtra;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/MedalExtraOrBuilder.class */
public interface MedalExtraOrBuilder extends MessageOrBuilder {
    MedalExtra.Badge getBadges(int i);

    int getBadgesCount();

    List<MedalExtra.Badge> getBadgesList();

    MedalExtra.BadgeOrBuilder getBadgesOrBuilder(int i);

    List<? extends MedalExtra.BadgeOrBuilder> getBadgesOrBuilderList();
}
