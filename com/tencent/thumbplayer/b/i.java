package com.tencent.thumbplayer.b;

import android.util.Xml;
import com.tencent.thumbplayer.adapter.strategy.utils.TPNativeKeyMap;
import com.tencent.thumbplayer.adapter.strategy.utils.TPNativeKeyMapUtil;
import com.tencent.thumbplayer.api.composition.ITPMediaAsset;
import com.tencent.thumbplayer.api.composition.ITPMediaAssetExtraParam;
import com.tencent.thumbplayer.api.composition.ITPMediaComposition;
import com.tencent.thumbplayer.api.composition.ITPMediaDRMAsset;
import com.tencent.thumbplayer.api.composition.ITPMediaRTCAsset;
import com.tencent.thumbplayer.api.composition.ITPMediaTrack;
import com.tencent.thumbplayer.api.composition.ITPMediaTrackClip;
import com.tencent.thumbplayer.api.composition.ITPMediaUrlAsset;
import com.tencent.thumbplayer.utils.TPLogUtil;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Iterator;
import java.util.List;
import org.xmlpull.v1.XmlSerializer;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/b/i.class */
public class i {
    private static String a(int i, boolean z) {
        return i == 1 ? z ? "av_tracks" : "av_track" : i == 2 ? z ? "video_tracks" : "video_track" : i == 3 ? z ? "audio_tracks" : "audio_track" : "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(ITPMediaComposition iTPMediaComposition) {
        if (iTPMediaComposition == null) {
            return "";
        }
        XmlSerializer newSerializer = Xml.newSerializer();
        StringWriter stringWriter = new StringWriter();
        newSerializer.setOutput(stringWriter);
        newSerializer.startDocument("UTF-8", Boolean.TRUE);
        newSerializer.startTag("", "assets");
        List<ITPMediaTrack> allAVTracks = iTPMediaComposition.getAllAVTracks();
        if (com.tencent.thumbplayer.utils.b.a(allAVTracks)) {
            List<ITPMediaTrack> allVideoTracks = iTPMediaComposition.getAllVideoTracks();
            List<ITPMediaTrack> allAudioTracks = iTPMediaComposition.getAllAudioTracks();
            if (com.tencent.thumbplayer.utils.b.a(allVideoTracks) && com.tencent.thumbplayer.utils.b.a(allAudioTracks)) {
                return "";
            }
            e eVar = (e) iTPMediaComposition;
            long a2 = eVar.a();
            a(newSerializer, allVideoTracks, 2, eVar.b());
            a(newSerializer, allAudioTracks, 3, a2);
        } else {
            a(newSerializer, allAVTracks, 1, 0L);
        }
        newSerializer.endTag("", "assets");
        newSerializer.endDocument();
        return stringWriter.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(ITPMediaDRMAsset iTPMediaDRMAsset) {
        if (iTPMediaDRMAsset == null) {
            return "";
        }
        XmlSerializer newSerializer = Xml.newSerializer();
        StringWriter stringWriter = new StringWriter();
        newSerializer.setOutput(stringWriter);
        newSerializer.startDocument("UTF-8", Boolean.TRUE);
        newSerializer.startTag("", "assets");
        newSerializer.startTag("", "av_tracks");
        newSerializer.startTag("", "av_track");
        newSerializer.startTag("", "track_clip");
        newSerializer.startTag("", "clip_id");
        newSerializer.text(Integer.toString(0));
        newSerializer.endTag("", "clip_id");
        newSerializer.startTag("", "clip_placeHolder");
        newSerializer.text("0");
        newSerializer.endTag("", "clip_placeHolder");
        newSerializer.startTag("", "clip_path");
        newSerializer.text(a(iTPMediaDRMAsset.getDrmPlayUrl()));
        newSerializer.endTag("", "clip_path");
        newSerializer.startTag("", "clip_drmType");
        newSerializer.text(String.valueOf(TPNativeKeyMapUtil.toNativeIntValue(TPNativeKeyMap.MapDrmType.class, iTPMediaDRMAsset.getDrmType())));
        newSerializer.endTag("", "clip_drmType");
        newSerializer.startTag("", "clip_drmProvisionUrl");
        newSerializer.text(a(iTPMediaDRMAsset.getDrmProperty(ITPMediaDRMAsset.TP_PLAYER_DRM_PROPERTY_PROVISION_URL, "")));
        newSerializer.endTag("", "clip_drmProvisionUrl");
        newSerializer.startTag("", "clip_drmLicenseUrl");
        newSerializer.text(a(iTPMediaDRMAsset.getDrmProperty(ITPMediaDRMAsset.TP_PLAYER_DRM_PROPERTY_LICENSE_URL, "")));
        newSerializer.endTag("", "clip_drmLicenseUrl");
        newSerializer.startTag("", "clip_drmUseL1");
        newSerializer.text(iTPMediaDRMAsset.getDrmProperty(ITPMediaDRMAsset.TP_PLAYER_DRM_PROPERTY_DRM_USEL1, "1"));
        newSerializer.endTag("", "clip_drmUseL1");
        newSerializer.startTag("", "clip_drmSavePath");
        newSerializer.text(iTPMediaDRMAsset.getDrmProperty(ITPMediaDRMAsset.TP_PLAYER_DRM_PROPERTY_SAVE_PATH, ""));
        newSerializer.endTag("", "clip_drmSavePath");
        newSerializer.startTag("", "clip_drmGuid");
        newSerializer.text(iTPMediaDRMAsset.getDrmProperty(ITPMediaDRMAsset.TP_PLAYER_DRM_PROPERTY_GUID, ""));
        newSerializer.endTag("", "clip_drmGuid");
        newSerializer.startTag("", "clip_drmPlatform");
        newSerializer.text(iTPMediaDRMAsset.getDrmProperty(ITPMediaDRMAsset.TP_PLAYER_DRM_PROPERTY_PLATFORM, ""));
        newSerializer.endTag("", "clip_drmPlatform");
        newSerializer.startTag("", "clip_drmAppVersion");
        newSerializer.text(iTPMediaDRMAsset.getDrmProperty(ITPMediaDRMAsset.TP_PLAYER_DRM_PROPERTY_APPVER, ""));
        newSerializer.endTag("", "clip_drmAppVersion");
        newSerializer.startTag("", "clip_drmCookie");
        newSerializer.text(iTPMediaDRMAsset.getDrmProperty(ITPMediaDRMAsset.TP_PLAYER_DRM_PROPERTY_COOKIE, ""));
        newSerializer.endTag("", "clip_drmCookie");
        newSerializer.startTag("", "clip_drmLicenseStandardization");
        newSerializer.text(iTPMediaDRMAsset.getDrmProperty(ITPMediaDRMAsset.TP_PLAYER_DRM_PROPERTY_LICENSE_STANDARDIZATION, "0"));
        newSerializer.endTag("", "clip_drmLicenseStandardization");
        newSerializer.startTag("", "clip_drmExtXKey");
        newSerializer.text(iTPMediaDRMAsset.getDrmProperty(ITPMediaDRMAsset.TP_PLAYER_DRM_PROPERTY_EXT_X_KEY, ""));
        newSerializer.endTag("", "clip_drmExtXKey");
        newSerializer.startTag("", "clip_preferredProperty");
        a(newSerializer, iTPMediaDRMAsset);
        newSerializer.endTag("", "clip_preferredProperty");
        newSerializer.endTag("", "track_clip");
        newSerializer.endTag("", "av_track");
        newSerializer.endTag("", "av_tracks");
        newSerializer.endTag("", "assets");
        newSerializer.endDocument();
        return stringWriter.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(ITPMediaRTCAsset iTPMediaRTCAsset) {
        if (iTPMediaRTCAsset == null) {
            return "";
        }
        XmlSerializer newSerializer = Xml.newSerializer();
        StringWriter stringWriter = new StringWriter();
        newSerializer.setOutput(stringWriter);
        newSerializer.startDocument("UTF-8", Boolean.TRUE);
        newSerializer.startTag("", "assets");
        newSerializer.startTag("", "av_tracks");
        newSerializer.startTag("", "av_track");
        newSerializer.startTag("", "track_clip");
        newSerializer.startTag("", "clip_id");
        newSerializer.text(Integer.toString(0));
        newSerializer.endTag("", "clip_id");
        newSerializer.startTag("", "clip_placeHolder");
        newSerializer.text("0");
        newSerializer.endTag("", "clip_placeHolder");
        newSerializer.startTag("", "clip_path");
        newSerializer.text(a(iTPMediaRTCAsset.getRtcStreamUrl()));
        newSerializer.endTag("", "clip_path");
        newSerializer.startTag("", "clip_rtcServerUrl");
        newSerializer.text(a(iTPMediaRTCAsset.getRtcServerUrl()));
        newSerializer.endTag("", "clip_rtcServerUrl");
        newSerializer.startTag("", "clip_rtcSdpExchangeType");
        newSerializer.text(Integer.toString(iTPMediaRTCAsset.getRtcSdpExchangeType()));
        newSerializer.endTag("", "clip_rtcSdpExchangeType");
        newSerializer.startTag("", "clip_preferredProperty");
        a(newSerializer, iTPMediaRTCAsset);
        newSerializer.endTag("", "clip_preferredProperty");
        newSerializer.endTag("", "track_clip");
        newSerializer.endTag("", "av_track");
        newSerializer.endTag("", "av_tracks");
        newSerializer.endTag("", "assets");
        newSerializer.endDocument();
        return stringWriter.toString();
    }

    public static String a(ITPMediaUrlAsset iTPMediaUrlAsset) {
        if (iTPMediaUrlAsset == null) {
            return "";
        }
        XmlSerializer newSerializer = Xml.newSerializer();
        StringWriter stringWriter = new StringWriter();
        newSerializer.setOutput(stringWriter);
        newSerializer.startDocument("UTF-8", Boolean.TRUE);
        newSerializer.startTag("", "assets");
        newSerializer.startTag("", "av_tracks");
        newSerializer.startTag("", "av_track");
        newSerializer.startTag("", "track_clip");
        newSerializer.startTag("", "clip_id");
        newSerializer.text(Integer.toString(0));
        newSerializer.endTag("", "clip_id");
        newSerializer.startTag("", "clip_placeHolder");
        newSerializer.text("0");
        newSerializer.endTag("", "clip_placeHolder");
        newSerializer.startTag("", "clip_path");
        newSerializer.text(a(iTPMediaUrlAsset.getStreamUrl()));
        newSerializer.endTag("", "clip_path");
        newSerializer.startTag("", "clip_preferredProperty");
        a(newSerializer, iTPMediaUrlAsset);
        newSerializer.endTag("", "clip_preferredProperty");
        newSerializer.endTag("", "track_clip");
        newSerializer.endTag("", "av_track");
        newSerializer.endTag("", "av_tracks");
        newSerializer.endTag("", "assets");
        newSerializer.endDocument();
        return stringWriter.toString();
    }

    private static String a(String str) {
        return str.replaceAll("[^\t\r\n -\ud7ff\ue000-���-��]+", "");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(List<ITPMediaTrackClip> list, int i) {
        String str;
        String str2;
        if (com.tencent.thumbplayer.utils.b.a(list)) {
            return "";
        }
        if (i == 1) {
            str = "av_tracks";
            str2 = "av_track";
        } else if (i == 2) {
            str = "video_tracks";
            str2 = "video_track";
        } else if (i != 3) {
            return "";
        } else {
            str = "audio_tracks";
            str2 = "audio_track";
        }
        XmlSerializer newSerializer = Xml.newSerializer();
        StringWriter stringWriter = new StringWriter();
        newSerializer.setOutput(stringWriter);
        newSerializer.startDocument("UTF-8", Boolean.TRUE);
        newSerializer.startTag("", "assets");
        a(newSerializer, list, str, str2);
        newSerializer.endTag("", "assets");
        newSerializer.endDocument();
        return stringWriter.toString();
    }

    private static void a(XmlSerializer xmlSerializer, ITPMediaAsset iTPMediaAsset) {
        ITPMediaAssetExtraParam extraParam = iTPMediaAsset.getExtraParam();
        if (extraParam == null) {
            return;
        }
        a(xmlSerializer, extraParam, ITPMediaAssetExtraParam.TP_PLAYER_EXTRA_PARAM_PREFERRED_AUDIO);
        a(xmlSerializer, extraParam, ITPMediaAssetExtraParam.TP_PLAYER_EXTRA_PARAM_PREFERRED_SUBTITLE);
        a(xmlSerializer, extraParam, ITPMediaAssetExtraParam.TP_PLAYER_EXTRA_PARAM_PREFERRED_VIDEO);
    }

    private static void a(XmlSerializer xmlSerializer, ITPMediaAssetExtraParam iTPMediaAssetExtraParam, String str) {
        c cVar = (c) iTPMediaAssetExtraParam.getExtraObject(str);
        if (cVar == null) {
            return;
        }
        xmlSerializer.startTag("", str);
        xmlSerializer.text(a(cVar.getKeyValueStr()));
        xmlSerializer.endTag("", str);
    }

    private static void a(XmlSerializer xmlSerializer, ITPMediaTrackClip iTPMediaTrackClip) {
        a(xmlSerializer, iTPMediaTrackClip, 0L);
    }

    private static void a(XmlSerializer xmlSerializer, ITPMediaTrackClip iTPMediaTrackClip, long j) {
        if (iTPMediaTrackClip instanceof a) {
            b(xmlSerializer, iTPMediaTrackClip, j);
        } else if (iTPMediaTrackClip instanceof h) {
            c(xmlSerializer, iTPMediaTrackClip, j);
        }
    }

    private static void a(XmlSerializer xmlSerializer, List<ITPMediaTrack> list, int i, long j) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    String a2 = a(i, true);
                    String a3 = a(i, false);
                    xmlSerializer.startTag("", a2);
                    for (ITPMediaTrack iTPMediaTrack : list) {
                        if (iTPMediaTrack.getMediaType() == i) {
                            xmlSerializer.startTag("", a3);
                            xmlSerializer.startTag("", "track_id");
                            xmlSerializer.text(Integer.toString(iTPMediaTrack.getTrackId()));
                            xmlSerializer.endTag("", "track_id");
                            if (i != 1 && f.f39224a.equals("base_audio") && iTPMediaTrack.getTimelineDurationMs() > j) {
                                long j2 = 0;
                                Iterator<ITPMediaTrackClip> it = iTPMediaTrack.getAllTrackClips().iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        break;
                                    }
                                    ITPMediaTrackClip next = it.next();
                                    j2 += next.getOriginalDurationMs();
                                    if (j2 > j) {
                                        a(xmlSerializer, next, j2 - j);
                                        break;
                                    }
                                    a(xmlSerializer, next);
                                }
                            } else {
                                for (ITPMediaTrackClip iTPMediaTrackClip : iTPMediaTrack.getAllTrackClips()) {
                                    a(xmlSerializer, iTPMediaTrackClip);
                                }
                            }
                            xmlSerializer.endTag("", a3);
                        }
                    }
                    xmlSerializer.endTag("", a2);
                }
            } catch (IOException e) {
                TPLogUtil.e("TPMediaCompositionXmlGenerator", e);
            }
        }
    }

    private static void a(XmlSerializer xmlSerializer, List<ITPMediaTrackClip> list, String str, String str2) {
        xmlSerializer.startTag("", str);
        xmlSerializer.startTag("", str2);
        for (ITPMediaTrackClip iTPMediaTrackClip : list) {
            a(xmlSerializer, iTPMediaTrackClip);
        }
        xmlSerializer.endTag("", str2);
        xmlSerializer.endTag("", str);
    }

    private static void b(XmlSerializer xmlSerializer, ITPMediaTrackClip iTPMediaTrackClip, long j) {
        xmlSerializer.startTag("", "track_clip");
        xmlSerializer.startTag("", "clip_id");
        xmlSerializer.text(Integer.toString(iTPMediaTrackClip.getClipId()));
        xmlSerializer.endTag("", "clip_id");
        xmlSerializer.startTag("", "clip_placeHolder");
        xmlSerializer.text("1");
        xmlSerializer.endTag("", "clip_placeHolder");
        xmlSerializer.startTag("", "clip_playTimeMs");
        xmlSerializer.text(j > 0 ? Long.toString(iTPMediaTrackClip.getOriginalDurationMs() - j) : Long.toString(iTPMediaTrackClip.getOriginalDurationMs()));
        xmlSerializer.endTag("", "clip_playTimeMs");
        xmlSerializer.endTag("", "track_clip");
    }

    private static void c(XmlSerializer xmlSerializer, ITPMediaTrackClip iTPMediaTrackClip, long j) {
        String l;
        xmlSerializer.startTag("", "track_clip");
        xmlSerializer.startTag("", "clip_id");
        xmlSerializer.text(Integer.toString(iTPMediaTrackClip.getClipId()));
        xmlSerializer.endTag("", "clip_id");
        xmlSerializer.startTag("", "clip_placeHolder");
        xmlSerializer.text("0");
        xmlSerializer.endTag("", "clip_placeHolder");
        xmlSerializer.startTag("", "clip_path");
        xmlSerializer.text(a(iTPMediaTrackClip.getFilePath()));
        xmlSerializer.endTag("", "clip_path");
        xmlSerializer.startTag("", "clip_startTimeMs");
        xmlSerializer.text(Long.toString(iTPMediaTrackClip.getStartTimeMs()));
        xmlSerializer.endTag("", "clip_startTimeMs");
        xmlSerializer.startTag("", "clip_durationMs");
        xmlSerializer.text(Long.toString(iTPMediaTrackClip.getOriginalDurationMs()));
        xmlSerializer.endTag("", "clip_durationMs");
        if (j > 0) {
            long endTimeMs = iTPMediaTrackClip.getEndTimeMs();
            long originalDurationMs = iTPMediaTrackClip.getOriginalDurationMs();
            xmlSerializer.startTag("", "clip_endTimeMs");
            xmlSerializer.text(Long.toString(endTimeMs - j));
            xmlSerializer.endTag("", "clip_endTimeMs");
            xmlSerializer.startTag("", "clip_playTimeMs");
            l = Long.toString(originalDurationMs - j);
        } else {
            xmlSerializer.startTag("", "clip_endTimeMs");
            xmlSerializer.text(Long.toString(iTPMediaTrackClip.getEndTimeMs()));
            xmlSerializer.endTag("", "clip_endTimeMs");
            xmlSerializer.startTag("", "clip_playTimeMs");
            l = Long.toString(iTPMediaTrackClip.getOriginalDurationMs());
        }
        xmlSerializer.text(l);
        xmlSerializer.endTag("", "clip_playTimeMs");
        xmlSerializer.endTag("", "track_clip");
    }
}
