package com.soft.blued.log.track;

import com.blued.android.module.common.group.GroupInfoModel;
import com.blued.das.client.socialnet.SocialNetWorkProtos;
import com.blued.track.trackUtils.EventTrackUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata
/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/log/track/EventTrackGroup.class */
public final class EventTrackGroup {

    /* renamed from: a  reason: collision with root package name */
    public static final EventTrackGroup f29692a = new EventTrackGroup();

    private EventTrackGroup() {
    }

    @JvmStatic
    public static final void a(SocialNetWorkProtos.Event event) {
        Intrinsics.e(event, "event");
        EventTrackUtils.a(SocialNetWorkProtos.SocialNetWorkProto.newBuilder().setEvent(event).build());
    }

    @JvmStatic
    public static final void a(SocialNetWorkProtos.Event event, String searchWords) {
        Intrinsics.e(event, "event");
        Intrinsics.e(searchWords, "searchWords");
        EventTrackUtils.a(SocialNetWorkProtos.SocialNetWorkProto.newBuilder().setEvent(event).setName(searchWords).build());
    }

    @JvmStatic
    public static final void a(SocialNetWorkProtos.Event event, String group_id, SocialNetWorkProtos.SourceType sourceType) {
        Intrinsics.e(event, "event");
        Intrinsics.e(group_id, "group_id");
        Intrinsics.e(sourceType, "sourceType");
        EventTrackUtils.a(SocialNetWorkProtos.SocialNetWorkProto.newBuilder().setGroupId(group_id).setSource(sourceType).setEvent(event).build());
    }

    @JvmStatic
    public static final void a(SocialNetWorkProtos.Event event, List<? extends GroupInfoModel.Label> list, SocialNetWorkProtos.SourceType source, String groupId) {
        Intrinsics.e(event, "event");
        Intrinsics.e(source, "source");
        Intrinsics.e(groupId, "groupId");
        StringBuilder sb = new StringBuilder("");
        if (list != null) {
            for (GroupInfoModel.Label label : list) {
                sb.append(label.label);
                sb.append(",");
            }
        }
        String sb2 = sb.toString();
        Intrinsics.c(sb2, "sb.toString()");
        String str = sb2;
        if (StringsKt.b(sb2, ",", false, 2, (Object) null)) {
            str = sb2.substring(0, sb2.length() - 1);
            Intrinsics.c(str, "this as java.lang.String…ing(startIndex, endIndex)");
        }
        EventTrackUtils.a(SocialNetWorkProtos.SocialNetWorkProto.newBuilder().setGroupId(groupId).setEvent(event).setType(str).setSource(source).build());
    }
}
