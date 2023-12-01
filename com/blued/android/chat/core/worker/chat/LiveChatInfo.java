package com.blued.android.chat.core.worker.chat;

import com.blued.android.chat.data.ProfileData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/core/worker/chat/LiveChatInfo.class */
public class LiveChatInfo {
    public long sessionId;
    public short sessionType;
    public long viewerOnLineCount;
    public List<ProfileData> viewerProfileList;
    public long viewerTotalCount;

    public LiveChatInfo(LiveChatInfo liveChatInfo) {
        this.sessionType = liveChatInfo.sessionType;
        this.sessionId = liveChatInfo.sessionId;
        this.viewerOnLineCount = liveChatInfo.viewerOnLineCount;
        this.viewerTotalCount = liveChatInfo.viewerTotalCount;
        if (liveChatInfo.viewerProfileList != null) {
            ArrayList arrayList = new ArrayList();
            this.viewerProfileList = arrayList;
            arrayList.addAll(liveChatInfo.viewerProfileList);
        }
    }

    public LiveChatInfo(short s, long j) {
        this.sessionType = s;
        this.sessionId = j;
    }

    private void checkProfileListSize() {
        int size = this.viewerProfileList.size();
        int i = 50;
        while (true) {
            int i2 = size - i;
            if (i2 <= 0) {
                return;
            }
            List<ProfileData> list = this.viewerProfileList;
            list.remove(list.size() - 1);
            size = i2;
            i = 1;
        }
    }

    public void addProfileData(ProfileData profileData) {
        List<ProfileData> list = this.viewerProfileList;
        if (list != null) {
            Iterator<ProfileData> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (it.next().uid == profileData.uid) {
                    it.remove();
                    break;
                }
            }
        } else {
            this.viewerProfileList = new ArrayList();
        }
        this.viewerProfileList.add(0, profileData);
        checkProfileListSize();
    }

    public boolean equalSession(short s, long j) {
        return this.sessionType == s && this.sessionId == j;
    }

    public List<ProfileData> getViewerList() {
        if (this.viewerProfileList != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.viewerProfileList);
            return arrayList;
        }
        return null;
    }

    public boolean removeProfileData(long j) {
        List<ProfileData> list = this.viewerProfileList;
        if (list != null) {
            Iterator<ProfileData> it = list.iterator();
            while (it.hasNext()) {
                if (it.next().uid == j) {
                    it.remove();
                    return true;
                }
            }
            return false;
        }
        return false;
    }
}
