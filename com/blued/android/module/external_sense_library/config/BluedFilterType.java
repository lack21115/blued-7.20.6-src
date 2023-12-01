package com.blued.android.module.external_sense_library.config;

import java.io.Serializable;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/external_sense_library/config/BluedFilterType.class */
public interface BluedFilterType {

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/external_sense_library/config/BluedFilterType$FILER.class */
    public enum FILER implements BluedFilterType, Serializable {
        BABYPINK("filter_style_babypink_1.5.0_v1.model"),
        CITY("filter_style_city_1.5.0_v1.model"),
        MODERN("filter_style_modern_1.5.0_v1.model"),
        PANSY("filter_style_pansy_1.5.0_v1.model"),
        RUBY("filter_style_ruby_1.5.0_v1.model");
        
        private String value;

        FILER(String str) {
            this.value = str;
        }

        public String getValue() {
            return this.value;
        }
    }
}
