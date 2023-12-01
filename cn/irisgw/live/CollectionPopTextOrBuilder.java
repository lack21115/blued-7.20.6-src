package cn.irisgw.live;

import cn.irisgw.live.CollectionPopText;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/CollectionPopTextOrBuilder.class */
public interface CollectionPopTextOrBuilder extends MessageOrBuilder {
    CollectionPopText.text getPopText(int i);

    int getPopTextCount();

    List<CollectionPopText.text> getPopTextList();

    CollectionPopText.textOrBuilder getPopTextOrBuilder(int i);

    List<? extends CollectionPopText.textOrBuilder> getPopTextOrBuilderList();
}
