package com.tencent.ugc.videoprocessor.transitions;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/videoprocessor/transitions/CrossZoomFilter.class */
public class CrossZoomFilter extends TXCGPUTransitionFilterBase {
    private static final String FRAGMENT = "precision mediump float;\nvarying mediump vec2 _uv;\nuniform sampler2D inputImageTexture;\nuniform float progress;\nuniform float ratio;\nconst float strength = 0.4; // = 0.4\nconst float PI = 3.141592653589793;\nvec4 getFromColor(in vec2 uv){\n    vec2 fromTexture = vec2(uv.x,1.0 - uv.y);\n    vec4 fromColor = texture2D(inputImageTexture,fromTexture);\n    return fromColor;\n}\nvec4 getToColor(in vec2 uv){\n    vec2 toTexture = vec2(uv.x,1.0-uv.y);\n    vec4 toColor = texture2D(inputImageTexture,toTexture);\n    return toColor;\n}\nfloat Linear_ease(in float begin, in float change, in float duration, in float time) {\n    return change * time / duration + begin;\n}\n\nfloat Exponential_easeInOut(in float begin, in float change, in float duration, in float time) {\n    if (time == 0.0)\n        return begin;\n    else if (time == duration)\n        return begin + change;\n    time = time / (duration / 2.0);\n    if (time < 1.0)\n        return change / 2.0 * pow(2.0, 10.0 * (time - 1.0)) + begin;\n    return change / 2.0 * (-pow(2.0, -10.0 * (time - 1.0)) + 2.0) + begin;\n}\n\nfloat Sinusoidal_easeInOut(in float begin, in float change, in float duration, in float time) {\n    return -change / 2.0 * (cos(PI * time / duration) - 1.0) + begin;\n}\n\nfloat rand (vec2 co) {\n  return fract(sin(dot(co.xy ,vec2(12.9898,78.233))) * 43758.5453);\n}\n\nvec3 crossFade(in vec2 uv, in float dissolve) {\n    return mix(getFromColor(uv).rgb, getToColor(uv).rgb, dissolve);\n}\n\nvec4 transition(vec2 uv) {\n    vec2 texCoord = uv.xy / vec2(1.0).xy;\n\n    // Linear interpolate center across center half of the image\n    vec2 center = vec2(Linear_ease(0.25, 0.5, 1.0, progress), 0.5);\n    float dissolve = Exponential_easeInOut(0.0, 1.0, 1.0, progress);\n\n    // Mirrored sinusoidal loop. 0->strength then strength->0\n    float strength = Sinusoidal_easeInOut(0.0, strength, 0.5, progress);\n\n    vec3 color = vec3(0.0);\n    float total = 0.0;\n    vec2 toCenter = center - texCoord;\n\n    /* randomize the lookup values to hide the fixed number of samples */\n    float offset = rand(uv);\n\n    for (float t = 0.0; t <= 40.0; t++) {\n        float percent = (t + offset) / 40.0;\n        float weight = 4.0 * (percent - percent * percent);\n        color += crossFade(texCoord + toCenter * percent * strength, dissolve) * weight;\n        total += weight;\n    }\n    return vec4(color / total, 1.0);\n}\nvoid main() {\n    gl_FragColor = transition(_uv);\n}";

    public CrossZoomFilter(int i) {
        super("attribute vec2 position; \nvarying mediump vec2 _uv;\n  \nvoid main() \n{ \n    gl_Position = vec4(position,0,1); \n    vec2 uv = position * 0.5 + 0.5;\n    _uv = vec2(uv.x,1.0 - uv.y);\n}", FRAGMENT, i);
    }
}
