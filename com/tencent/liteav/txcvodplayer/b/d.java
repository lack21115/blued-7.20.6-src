package com.tencent.liteav.txcvodplayer.b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.liteav.base.util.LiteavLog;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/txcvodplayer/b/d.class */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    protected e f36533a;
    protected f b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f36534c;
    private Thread h;
    private final String d = "http://playvideo.qcloud.com/getplayinfo/v2";
    private final String e = "https://playvideo.qcloud.com/getplayinfo/v2";
    private final int f = 0;
    private final int g = 1;
    private Handler i = new Handler(Looper.getMainLooper()) { // from class: com.tencent.liteav.txcvodplayer.b.d.1
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            if (d.this.f36533a == null) {
                return;
            }
            int i = message.what;
            if (i == 0) {
                d.this.f36533a.a(d.this);
            } else if (i != 1) {
            } else {
                d.this.f36533a.a(d.this, (String) message.obj, message.arg1);
            }
        }
    };
    private String j = "{\"code\":0,\"message\":\"\",\"playerInfo\":{\"playerId\":\"0\",\"name\":\"初始播放器\",\"defaultVideoClassification\":\"SD\",\"videoClassification\":[{\"id\":\"FLU\",\"name\":\"流畅\",\"definitionList\":[10,510,210,610,10046,710]},{\"id\":\"SD\",\"name\":\"标清\",\"definitionList\":[20,520,220,620,10047,720]},{\"id\":\"HD\",\"name\":\"高清\",\"definitionList\":[30,530,230,630,10048,730]},{\"id\":\"FHD\",\"name\":\"全高清\",\"definitionList\":[40,540,240,640,10049,740]},{\"id\":\"2K\",\"name\":\"2K\",\"definitionList\":[70,570,270,670,370,770]},{\"id\":\"4K\",\"name\":\"4K\",\"definitionList\":[80,580,280,680,380,780]}],\"logoLocation\":\"1\",\"logoPic\":\"\",\"logoUrl\":\"\"},\"coverInfo\":{\"coverUrl\":\"http://1255566655.vod2.myqcloud.com/7e9cee55vodtransgzp1255566655/8f5fbff14564972818519602447/coverBySnapshot/1513156403_1311093072.100_0.jpg?t=5c08d9fa&us=someus&sign=95f34beb353fe32cfe7f8b5e79cc28b1\"},\"imageSpriteInfo\":{\"imageSpriteList\":[{\"definition\":10,\"height\":80,\"width\":142,\"totalCount\":4,\"imageUrls\":[\"http://1255566655.vod2.myqcloud.com/ca754badvodgzp1255566655/8f5fbff14564972818519602447/imageSprite/1513156058_533711271_00001.jpg?t=5c08d9fa&us=someus&sign=79449db4e1fb05a3becfa096613659c3\"],\"webVttUrl\":\"http://1255566655.vod2.myqcloud.com/ca754badvodgzp1255566655/8f5fbff14564972818519602447/imageSprite/1513156058_533711271.vtt?t=5c08d9fa&us=someus&sign=79449db4e1fb05a3becfa096613659c3\"}]},\"videoInfo\":{\"sourceVideo\":{\"url\":\"http://1255566655.vod2.myqcloud.com/ca754badvodgzp1255566655/8f5fbff14564972818519602447/uAnXX0OMLSAA.wmv?t=5c08d9fa&us=someus&sign=659af5dd3f27eb92dc4ed74eb561daa4\",\"definition\":0,\"duration\":30,\"floatDuration\":30.093000411987305,\"size\":26246026,\"bitrate\":6134170,\"height\":720,\"width\":1280,\"container\":\"asf\",\"md5\":\"\",\"videoStreamList\":[{\"bitrate\":5942130,\"height\":720,\"width\":1280,\"codec\":\"vc1\",\"fps\":29}],\"audioStreamList\":[{\"samplingRate\":44100,\"bitrate\":192040,\"codec\":\"wmav2\"}]},\"mas©terPlayList1\":{\"idrAligned\":false,\"url\":\"http://1255566655.vod2.myqcloud.com/7e9cee55vodtransgzp1255566655/8f5fbff14564972818519602447/master_playlist.m3u8?t=5c08d9fa&us=someus&sign=66290475b7182c89193f03b8f74a979d\",\"definition\":10000,\"md5\":\"23ecc2cfe4cb7c8f87af41993ba8c09c\"},\"transcodeList\":[{\"url\":\"http://1255566655.vod2.myqcloud.com/7e9cee55vodtransgzp1255566655/8f5fbff14564972818519602447/v.f220.m3u8?t=5c08d9fa&us=someus&sign=66290475b7182c89193f03b8f74a979d\",\"definition\":220,\"duration\":30,\"floatDuration\":30.08329963684082,\"size\":796,\"bitrate\":646036,\"height\":360,\"width\":640,\"container\":\"hls,applehttp\",\"md5\":\"dce044407826b4d809c16b6d1a9e9f13\",\"videoStreamList\":[{\"bitrate\":607449,\"height\":360,\"width\":640,\"codec\":\"h264\",\"fps\":24}],\"audioStreamList\":[{\"samplingRate\":44100,\"bitrate\":38587,\"codec\":\"aac\"}]},{\"url\":\"http://1255566655.vod2.myqcloud.com/7e9cee55vodtransgzp1255566655/8f5fbff14564972818519602447/v.f230.m3u8?t=5c08d9fa&us=someus&sign=66290475b7182c89193f03b8f74a979d\",\"definition\":230,\"duration\":30,\"floatDuration\":30.04170036315918,\"size\":802,\"bitrate\":1224776,\"height\":720,\"width\":1280,\"container\":\"hls,applehttp\",\"md5\":\"f07bb0be9e2fee967d87b6c310d3c036\",\"videoStreamList\":[{\"bitrate\":1186189,\"height\":720,\"width\":1280,\"codec\":\"h264\",\"fps\":24}],\"audioStreamList\":[{\"samplingRate\":44100,\"bitrate\":38587,\"codec\":\"aac\"}]},{\"url\":\"http://1255566655.vod2.myqcloud.com/7e9cee55vodtransgzp1255566655/8f5fbff14564972818519602447/v.f240.m3u8?t=5c08d9fa&us=someus&sign=66290475b7182c89193f03b8f74a979d\",\"definition\":240,\"duration\":30,\"floatDuration\":0,\"size\":809,\"bitrate\":2866685,\"height\":1080,\"width\":1920,\"container\":\"hls,applehttp\",\"md5\":\"ff8190cf07afceb8ed053b198453e954\",\"videoStreamList\":[{\"bitrate\":2828098,\"height\":1080,\"width\":1920,\"codec\":\"h264\",\"fps\":24}],\"audioStreamList\":[{\"samplingRate\":44100,\"bitrate\":38587,\"codec\":\"aac\"}]},{\"url\":\"http://1255566655.vod2.myqcloud.com/7e9cee55vodtransgzp1255566655/8f5fbff14564972818519602447/v.f210.m3u8?t=5c08d9fa&us=someus&sign=66290475b7182c89193f03b8f74a979d\",\"definition\":210,\"duration\":30,\"floatDuration\":30.08329963684082,\"size\":788,\"bitrate\":358908,\"height\":180,\"width\":320,\"container\":\"hls,applehttp\",\"md5\":\"5fa784e0a588c51dc2d7428ad6787079\",\"videoStreamList\":[{\"bitrate\":320321,\"height\":180,\"width\":320,\"codec\":\"h264\",\"fps\":24}],\"audioStreamList\":[{\"samplingRate\":44100,\"bitrate\":38587,\"codec\":\"aac\"}]},{\"url\":\"http://1255566655.vod2.myqcloud.com/7e9cee55vodtransgzp1255566655/8f5fbff14564972818519602447/v.f10.mp4?t=5c08d9fa&us=someus&sign=66290475b7182c89193f03b8f74a979d\",\"definition\":10,\"duration\":30,\"floatDuration\":30.139400482177734,\"size\":1169168,\"bitrate\":303916,\"height\":180,\"width\":320,\"container\":\"mov,mp4,m4a,3gp,3g2,mj2\",\"md5\":\"85002ed20125acf150d014b192cf39a0\",\"videoStreamList\":[{\"bitrate\":255698,\"height\":180,\"width\":320,\"codec\":\"h264\",\"fps\":24}],\"audioStreamList\":[{\"samplingRate\":44100,\"bitrate\":48218,\"codec\":\"aac\"}]},{\"url\":\"http://1255566655.vod2.myqcloud.com/7e9cee55vodtransgzp1255566655/8f5fbff14564972818519602447/v.f20.mp4?t=5c08d9fa&us=someus&sign=66290475b7182c89193f03b8f74a979d\",\"definition\":20,\"duration\":30,\"floatDuration\":30.139400482177734,\"size\":2158411,\"bitrate\":566647,\"height\":360,\"width\":640,\"container\":\"mov,mp4,m4a,3gp,3g2,mj2\",\"md5\":\"cba3630e5f92325041da7fee336246b6\",\"videoStreamList\":[{\"bitrate\":518429,\"height\":360,\"width\":640,\"codec\":\"h264\",\"fps\":24}],\"audioStreamList\":[{\"samplingRate\":44100,\"bitrate\":48218,\"codec\":\"aac\"}]}]}}";

    static /* synthetic */ void a(d dVar, String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        int i = jSONObject.getInt("code");
        if (i != 0) {
            String string = jSONObject.getString("message");
            LiteavLog.e("TXCVodPlayerNetApi", string);
            dVar.a(string, i);
            return;
        }
        f fVar = new f(jSONObject);
        dVar.b = fVar;
        if (fVar.a() == null) {
            dVar.a("No playback address", -3);
        } else {
            dVar.i.sendEmptyMessage(0);
        }
    }

    public final int a(final int i, final String str, final String str2, final String str3, final int i2, final String str4) {
        if (i == 0 || str == null) {
            return -1;
        }
        if ((str2 != null || i2 > 0) && str4 == null) {
            return -1;
        }
        Thread thread = new Thread("getPlayInfo") { // from class: com.tencent.liteav.txcvodplayer.b.d.2
            @Override // java.lang.Thread, java.lang.Runnable
            public final void run() {
                BufferedReader bufferedReader;
                BufferedReader bufferedReader2 = null;
                try {
                    try {
                        Looper.prepare();
                        String format = d.this.f36534c ? String.format("%s/%d/%s", "https://playvideo.qcloud.com/getplayinfo/v2", Integer.valueOf(i), str) : String.format("%s/%d/%s", "http://playvideo.qcloud.com/getplayinfo/v2", Integer.valueOf(i), str);
                        String str5 = str2;
                        String str6 = str3;
                        int i3 = i2;
                        String str7 = str4;
                        StringBuilder sb = new StringBuilder();
                        if (str5 != null) {
                            StringBuilder sb2 = new StringBuilder("t=");
                            sb2.append(str5);
                            sb2.append("&");
                            sb.append(sb2.toString());
                        }
                        if (str6 != null) {
                            StringBuilder sb3 = new StringBuilder("us=");
                            sb3.append(str6);
                            sb3.append("&");
                            sb.append(sb3.toString());
                        }
                        if (str7 != null) {
                            StringBuilder sb4 = new StringBuilder("sign=");
                            sb4.append(str7);
                            sb4.append("&");
                            sb.append(sb4.toString());
                        }
                        if (i3 >= 0) {
                            StringBuilder sb5 = new StringBuilder("exper=");
                            sb5.append(i3);
                            sb5.append("&");
                            sb.append(sb5.toString());
                        }
                        if (sb.length() > 1) {
                            sb.deleteCharAt(sb.length() - 1);
                        }
                        String sb6 = sb.toString();
                        String str8 = format;
                        if (sb6 != null) {
                            StringBuilder sb7 = new StringBuilder();
                            sb7.append(format);
                            sb7.append("?");
                            sb7.append(sb6);
                            str8 = sb7.toString();
                        }
                        URL url = new URL(str8);
                        LiteavLog.d("TXCVodPlayerNetApi", "getplayinfo: ".concat(String.valueOf(str8)));
                        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                        httpURLConnection.connect();
                        if (httpURLConnection.getResponseCode() == 200) {
                            bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                            try {
                                StringBuilder sb8 = new StringBuilder();
                                while (true) {
                                    String readLine = bufferedReader.readLine();
                                    if (readLine == null) {
                                        break;
                                    }
                                    sb8.append(readLine);
                                }
                                d.a(d.this, sb8.toString());
                            } catch (JSONException e) {
                                d.this.a("Incorrect format", -2);
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                        return;
                                    } catch (IOException e2) {
                                        return;
                                    }
                                }
                                return;
                            } catch (Exception e3) {
                                e = e3;
                                StringBuilder sb9 = new StringBuilder("http exception: ");
                                BufferedReader bufferedReader3 = bufferedReader;
                                sb9.append(e.getMessage());
                                BufferedReader bufferedReader4 = bufferedReader;
                                LiteavLog.d("TXCVodPlayerNetApi", sb9.toString());
                                BufferedReader bufferedReader5 = bufferedReader;
                                d.this.a("The request was exceptional", -2);
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                        return;
                                    } catch (IOException e4) {
                                        return;
                                    }
                                }
                                return;
                            } catch (Throwable th) {
                                bufferedReader2 = bufferedReader;
                                th = th;
                                if (bufferedReader2 != null) {
                                    try {
                                        bufferedReader2.close();
                                    } catch (IOException e5) {
                                    }
                                }
                                throw th;
                            }
                        } else {
                            d.this.a("Request failed", -1);
                            bufferedReader = null;
                        }
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e6) {
                            }
                        }
                    } catch (JSONException e7) {
                        bufferedReader = null;
                    } catch (Exception e8) {
                        e = e8;
                        bufferedReader = null;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        };
        this.h = thread;
        thread.start();
        return 0;
    }

    public final f a() {
        return this.b;
    }

    public final void a(e eVar) {
        this.f36533a = eVar;
    }

    protected final void a(String str, int i) {
        Message message = new Message();
        message.what = 1;
        message.arg1 = i;
        message.obj = str;
        this.i.sendMessage(message);
    }
}
