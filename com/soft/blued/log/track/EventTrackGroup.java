package com.soft.blued.log.track;

import android.provider.Contacts;
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
    public static final EventTrackGroup f16002a = new EventTrackGroup();

    private EventTrackGroup() {
    }

    @JvmStatic
    public static final void a(SocialNetWorkProtos.Event event) {
        Intrinsics.e(event, "event");
        EventTrackUtils.a(SocialNetWorkProtos.SocialNetWorkProto.newBuilder().setEvent(event).build());
    }

    @JvmStatic
    public static final void a(SocialNetWorkProtos.Event event, String str) {
        Intrinsics.e(event, "event");
        Intrinsics.e(str, "searchWords");
        EventTrackUtils.a(SocialNetWorkProtos.SocialNetWorkProto.newBuilder().setEvent(event).setName(str).build());
    }

    @JvmStatic
    public static final void a(SocialNetWorkProtos.Event event, String str, SocialNetWorkProtos.SourceType sourceType) {
        Intrinsics.e(event, "event");
        Intrinsics.e(str, Contacts.GroupMembership.GROUP_ID);
        Intrinsics.e(sourceType, "sourceType");
        EventTrackUtils.a(SocialNetWorkProtos.SocialNetWorkProto.newBuilder().setGroupId(str).setSource(sourceType).setEvent(event).build());
    }

    @JvmStatic
    public static final void a(SocialNetWorkProtos.Event event, List<? extends GroupInfoModel.Label> list, SocialNetWorkProtos.SourceType sourceType, String str) {
        Intrinsics.e(event, "event");
        Intrinsics.e(sourceType, "source");
        Intrinsics.e(str, "groupId");
        StringBuilder sb = new StringBuilder("");
        if (list != null) {
            for (GroupInfoModel.Label label : list) {
                sb.append(label.label);
                sb.append(",");
            }
        }
        String sb2 = sb.toString();
        Intrinsics.c(sb2, "sb.toString()");
        String str2 = sb2;
        if (StringsKt.b(sb2, ",", false, 2, (Object) null)) {
            str2 = sb2.substring(0, sb2.length() - 1);
            Intrinsics.c(str2, "this as java.lang.String…ing(startIndex, endIndex)");
        }
        EventTrackUtils.a(SocialNetWorkProtos.SocialNetWorkProto.newBuilder().setGroupId(str).setEvent(event).setType(str2).setSource(sourceType).build());
    }
}
