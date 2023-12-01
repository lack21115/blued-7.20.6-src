package com.soft.blued.ui.community.auto;

import com.blued.android.module.common.log.oldtrack.LogData;
import com.blued.community.auto.ICommunityTrackService;
import com.blued.community.model.BluedIngSelfFeed;
import com.blued.das.profile.PersonalProfileProtos;
import com.soft.blued.log.InstantLog;
import com.soft.blued.log.track.EventTrackPersonalProfile;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/community/auto/CommunityTrackServiceImpl.class */
public class CommunityTrackServiceImpl implements ICommunityTrackService {
    @Override // com.blued.community.auto.ICommunityTrackService
    public String a() {
        return "MAIN";
    }

    @Override // com.blued.community.auto.ICommunityTrackService
    public void a(int i) {
        InstantLog.a(i);
    }

    @Override // com.blued.community.auto.ICommunityTrackService
    public void a(int i, int i2) {
        InstantLog.a(i, i2);
    }

    @Override // com.blued.community.auto.ICommunityTrackService
    public void a(int i, BluedIngSelfFeed bluedIngSelfFeed, String str, int i2) {
        InstantLog.a(i, bluedIngSelfFeed, str, i2);
    }

    @Override // com.blued.community.auto.ICommunityTrackService
    public void a(int i, String str) {
        InstantLog.b(i, str);
    }

    @Override // com.blued.community.auto.ICommunityTrackService
    public void a(int i, String str, String str2, String str3) {
        InstantLog.a(i, str, str2, str3);
    }

    @Override // com.blued.community.auto.ICommunityTrackService
    public void a(LogData logData) {
        InstantLog.a(logData);
    }

    @Override // com.blued.community.auto.ICommunityTrackService
    public void a(PersonalProfileProtos.Event event, String str) {
        EventTrackPersonalProfile.c(event, str);
    }

    @Override // com.blued.community.auto.ICommunityTrackService
    public void a(String str) {
        InstantLog.a(str);
    }

    @Override // com.blued.community.auto.ICommunityTrackService
    public void a(String str, int i) {
        InstantLog.b(str, i);
    }

    @Override // com.blued.community.auto.ICommunityTrackService
    public void a(String str, String str2) {
        InstantLog.h(str, str2);
    }

    @Override // com.blued.community.auto.ICommunityTrackService
    public void a(String str, String str2, int i, String str3) {
        InstantLog.a(str, str2, i, str3);
    }

    @Override // com.blued.community.auto.ICommunityTrackService
    public void b() {
        InstantLog.a();
    }

    @Override // com.blued.community.auto.ICommunityTrackService
    public void b(int i, BluedIngSelfFeed bluedIngSelfFeed, String str, int i2) {
        InstantLog.b(i, bluedIngSelfFeed, str, i2);
    }

    @Override // com.blued.community.auto.ICommunityTrackService
    public void b(String str, int i) {
        InstantLog.a(str, i);
    }

    @Override // com.blued.community.auto.ICommunityTrackService
    public void b(String str, String str2) {
        InstantLog.e(str, str2);
    }

    @Override // com.blued.community.auto.ICommunityTrackService
    public void c(int i, BluedIngSelfFeed bluedIngSelfFeed, String str, int i2) {
        InstantLog.c(i, bluedIngSelfFeed, str, i2);
    }

    @Override // com.blued.community.auto.ICommunityTrackService
    public void c(String str, int i) {
        InstantLog.a(str, Integer.valueOf(i));
    }
}
