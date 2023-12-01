package com.blued.android.module.live_china.model;

import com.blued.android.module.live.base.model.BasePayRemaining;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/PayRemaining.class */
public class PayRemaining extends BasePayRemaining {
    public int animation;
    public String ar_name;
    public String data;
    public long end_second;
    public String hongbao_id;
    public String image_url;
    public int is_anim;
    public String resource_url;
    public long start_second;

    @Override // com.blued.android.module.live.base.model.BasePayRemaining
    public String toString() {
        return "PayRemaining[" + super.toString() + ", image_url:" + this.image_url + ", hongbao_id:" + this.hongbao_id + ", start_second:" + this.start_second + ", start_second:" + this.end_second + ", is_anim:" + this.is_anim + ", animation:" + this.animation + ", ar_name:" + this.ar_name + ", resource_url:" + this.resource_url + ", data:" + this.data + "]";
    }
}
