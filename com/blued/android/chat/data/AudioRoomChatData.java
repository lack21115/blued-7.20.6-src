package com.blued.android.chat.data;

import java.io.Serializable;
import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/data/AudioRoomChatData.class */
public class AudioRoomChatData implements Serializable {
    public long msg_type;
    public AudioRoomChatExtraData room_data;
    public long session_id;
    public short session_type;

    public void parseExtraData(Map<String, Object> map) {
        if (map == null) {
            return;
        }
        AudioRoomChatExtraData audioRoomChatExtraData = new AudioRoomChatExtraData();
        this.room_data = audioRoomChatExtraData;
        audioRoomChatExtraData.parseData(map);
    }

    public String toString() {
        return "AudioRoomChatData{session_type=" + ((int) this.session_type) + ", session_id=" + this.session_id + ", msg_type=" + this.msg_type + ", room_data=" + this.room_data.toString() + '}';
    }
}
