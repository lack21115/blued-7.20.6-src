package cn.irisgw.live;

import cn.irisgw.live.ActivityMessage;
import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/ActivityMessageOrBuilder.class */
public interface ActivityMessageOrBuilder extends MessageOrBuilder {
    ActivityMessage.DisplayUrl getDisplayUrls(int i);

    int getDisplayUrlsCount();

    List<ActivityMessage.DisplayUrl> getDisplayUrlsList();

    ActivityMessage.DisplayUrlOrBuilder getDisplayUrlsOrBuilder(int i);

    List<? extends ActivityMessage.DisplayUrlOrBuilder> getDisplayUrlsOrBuilderList();

    String getIcon();

    ByteString getIconBytes();

    long getId();

    ActivityMessage.Page getPage();

    int getPageValue();

    long getSort();

    int getStatus();

    String getUrl();

    ByteString getUrlBytes();
}
