package com.qiniu.pili.droid.shortvideo.core;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/core/b.class */
public class b {

    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/core/b$a.class */
    public enum a {
        record_camera_capture(100),
        record_microphone_capture(101),
        record_video_camera_setting(102),
        record_audio_microphone_setting(103),
        record_video_encode_setting(104),
        record_audio_encode_setting(105),
        record_duration_setting(106),
        record_switch_camera(107),
        record_flash(108),
        record_exposure(109),
        record_focus(110),
        record_zoom(111),
        record_mirror(112),
        record_horizontal(113),
        record_section(114),
        record_speed(115),
        record_audio_only(116),
        record_image_rotate(117),
        record_audio_mix(118),
        record_capture_frame(119),
        record_mute(120),
        record_video_mix(121),
        record_screen(122),
        record_view(123),
        record_external_media(124),
        record_stop_resume(125),
        record_watermark(126),
        record_beauty(127),
        record_preview(128),
        record_custom_effect(129),
        record_filter(130),
        edit_preview(200),
        edit_image(201),
        edit_watermark(202),
        edit_speed(203),
        edit_text(204),
        edit_mv(205),
        edit_paint(206),
        edit_audio_mix(207),
        edit_multi_audio_mix(208),
        edit_rotate(209),
        edit_custom_effect(210),
        edit_filter(211),
        compose_video(300),
        compose_trim_video(301),
        compose_gif(302),
        compose_image(303),
        compose_item(304),
        transcode_clip_video(400),
        transcode_video(401),
        transcode_rotate(402),
        trim_video(500),
        upload_video(600),
        upload_resume(601),
        upload_speed_up(602),
        mix_video(900),
        draftbox(901),
        reverse_video(902),
        transition_make(903),
        qplayer(904);
        
        private int ai;

        a(int i) {
            this.ai = i;
        }

        public int a() {
            return this.ai;
        }
    }
}
