package com.blued.android.module.live.base.music;

import com.blued.android.module.live.base.music.model.LiveMusicModel;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.blued.das.live.LiveProtos;
import com.tencent.txcopyrightedmedia.ITXCMMusicTrack;
import kotlin.Metadata;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/live/base/music/BlackMusicListener.class */
public interface BlackMusicListener {
    void J_();

    void K_();

    void L_();

    void a();

    void a(LiveMusicModel liveMusicModel);

    void a(ChatRoomProtos.Event event, LiveProtos.Event event2, String str, String str2);

    void a(ChatRoomProtos.Event event, LiveProtos.Event event2, String str, String str2, String str3);

    void a(ChatRoomProtos.Event event, LiveProtos.Event event2, String str, String str2, String str3, int i);

    void a(ITXCMMusicTrack iTXCMMusicTrack);

    void a(String str);

    void b(String str);

    void c();

    void d();

    String f();

    void g();

    void h();
}
