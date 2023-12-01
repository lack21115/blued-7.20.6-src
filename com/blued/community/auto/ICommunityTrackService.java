package com.blued.community.auto;

import com.blued.android.module.common.log.oldtrack.LogData;
import com.blued.community.model.BluedIngSelfFeed;
import com.blued.das.profile.PersonalProfileProtos;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/auto/ICommunityTrackService.class */
public interface ICommunityTrackService {
    String a();

    void a(int i);

    void a(int i, int i2);

    void a(int i, BluedIngSelfFeed bluedIngSelfFeed, String str, int i2);

    void a(int i, String str);

    void a(int i, String str, String str2, String str3);

    void a(LogData logData);

    void a(PersonalProfileProtos.Event event, String str);

    void a(String str);

    void a(String str, int i);

    void a(String str, String str2);

    void a(String str, String str2, int i, String str3);

    void b();

    void b(int i, BluedIngSelfFeed bluedIngSelfFeed, String str, int i2);

    void b(String str, int i);

    void b(String str, String str2);

    void c(int i, BluedIngSelfFeed bluedIngSelfFeed, String str, int i2);

    void c(String str, int i);
}
