package com.kwad.sdk.core.network;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/network/f.class */
public final class f {
    public static f agi = new f(-1, "请求超时事件");
    public static f agj = new f(-2, "请求异常");
    public static f agk = new f(-1000, "该业务组件未加载");
    public static f agl = new f(40001, "网络错误");
    public static f agm = new f(40002, "数据解析错误");
    public static f agn = new f(40003, "广告数据为空");
    public static f ago = new f(40004, "视频资源缓存失败");
    public static f agp = new f(40005, "网络超时");
    public static f agq = new f(40007, "图片下载失败");
    public static f agr = new f(40008, "广告场景不匹配");
    public static f ags = new f(100006, "更多视频请前往快手App查看");
    public static f agt = new f(100007, "复制链接失败，请稍后重试");
    public static f agu = new f(100008, "内容有点敏感，不可以发送哦");
    public static f agv = new f(130001, "数据不存在");
    public static f agw = new f(0, "网络超时");
    public int errorCode;
    public String msg;

    private f(int i, String str) {
        this.errorCode = i;
        this.msg = str;
    }
}
