package com.soft.blued.ui.msg.model;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/model/MsgChattingVideoModel.class */
public class MsgChattingVideoModel {
    public boolean identify_yellow;
    public boolean illegal;
    private MsgSourceEntity msgSource;
    private String videoCoverUrl;
    private int video_height;
    public long video_time_long;
    private int video_width;

    public MsgSourceEntity getMsgSource() {
        return this.msgSource;
    }

    public String getVideoCoverUrl() {
        return this.videoCoverUrl;
    }

    public int getVideo_height() {
        return this.video_height;
    }

    public int getVideo_width() {
        return this.video_width;
    }

    public void setMsgSource(MsgSourceEntity msgSourceEntity) {
        this.msgSource = msgSourceEntity;
    }

    public void setVideoCoverUrl(String str) {
        this.videoCoverUrl = str;
    }

    public void setVideo_height(int i) {
        this.video_height = i;
    }

    public void setVideo_width(int i) {
        this.video_width = i;
    }
}
