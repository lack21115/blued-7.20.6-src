package cn.irisgw.live;

import cn.irisgw.live.PKProgressUpdateExtra;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/PKProgressUpdateExtraOrBuilder.class */
public interface PKProgressUpdateExtraOrBuilder extends MessageOrBuilder {
    int getScore();

    PKProgressUpdateExtra.BattleTopUser getTargetTop(int i);

    int getTargetTopCount();

    List<PKProgressUpdateExtra.BattleTopUser> getTargetTopList();

    PKProgressUpdateExtra.BattleTopUserOrBuilder getTargetTopOrBuilder(int i);

    List<? extends PKProgressUpdateExtra.BattleTopUserOrBuilder> getTargetTopOrBuilderList();

    PKProgressUpdateExtra.BattleTopUser getTop(int i);

    int getTopCount();

    List<PKProgressUpdateExtra.BattleTopUser> getTopList();

    PKProgressUpdateExtra.BattleTopUserOrBuilder getTopOrBuilder(int i);

    List<? extends PKProgressUpdateExtra.BattleTopUserOrBuilder> getTopOrBuilderList();

    int getTotal();

    int getUid();
}
