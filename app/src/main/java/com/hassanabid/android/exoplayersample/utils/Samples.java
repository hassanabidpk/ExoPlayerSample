/*
 * Copyright (C) 2014 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.hassanabid.android.exoplayersample.utils;

import com.google.android.exoplayer.util.Util;

import java.util.Locale;

/**
 * Holds statically defined sample definitions.
 */
public class Samples {

  public static class Sample {

    public final String name;
    public final String contentId;
    public final String provider;
    public final String uri;
    public final int type;

    public Sample(String name, String uri, int type) {
      this(name, name.toLowerCase(Locale.US).replaceAll("\\s", ""), "", uri, type);
    }

    public Sample(String name, String contentId, String provider, String uri, int type) {
      this.name = name;
      this.contentId = contentId;
      this.provider = provider;
      this.uri = uri;
      this.type = type;
    }

  }

  public static final Sample[] DASH_MP4 = new Sample[] {
    new Sample("Google Glass (MP4,H264)",
        "http://www.youtube.com/api/manifest/dash/id/bf5bb2419360daf1/source/youtube?"
        + "as=fmp4_audio_clear,fmp4_sd_hd_clear&sparams=ip,ipbits,expire,source,id,as&ip=0.0.0.0&"
        + "ipbits=0&expire=19000000000&signature=51AF5F39AB0CEC3E5497CD9C900EBFEAECCCB5C7."
        + "8506521BFC350652163895D4C26DEE124209AA9E&key=ik0", Util.TYPE_DASH),
    new Sample("Google Play (MP4,H264)",
        "http://www.youtube.com/api/manifest/dash/id/3aa39fa2cc27967f/source/youtube?"
        + "as=fmp4_audio_clear,fmp4_sd_hd_clear&sparams=ip,ipbits,expire,source,id,as&ip=0.0.0.0&"
        + "ipbits=0&expire=19000000000&signature=A2716F75795F5D2AF0E88962FFCD10DB79384F29."
        + "84308FF04844498CE6FBCE4731507882B8307798&key=ik0", Util.TYPE_DASH),
     new Sample("Clash of the Titans",
           "http://90.85.25.123/VOD/Dash/WMC/Clash_Of_The_Titans_clear/Clash_Of_The_Titans.mpd",
                  Util.TYPE_DASH),
  };



  public static final Sample[] WIDEVINE_H264_MP4_CLEAR = new Sample[] {
    new Sample("WV: Clear SD & HD (MP4,H264)",
        "https://storage.googleapis.com/wvmedia/clear/h264/tears/tears.mpd",
        Util.TYPE_DASH),
    new Sample("WV: Clear SD (MP4,H264)",
        "https://storage.googleapis.com/wvmedia/clear/h264/tears/tears_sd.mpd",
        Util.TYPE_DASH),
    new Sample("WV: Clear HD (MP4,H264)",
        "https://storage.googleapis.com/wvmedia/clear/h264/tears/tears_hd.mpd",
        Util.TYPE_DASH),
    new Sample("WV: Clear UHD (MP4,H264)",
        "https://storage.googleapis.com/wvmedia/clear/h264/tears/tears_uhd.mpd",
        Util.TYPE_DASH),
  };

  public static final Sample[] WIDEVINE_H264_MP4_SECURE = new Sample[] {
    new Sample("WV: Secure SD & HD (MP4,H264)", "", "widevine_test",
        "https://storage.googleapis.com/wvmedia/cenc/h264/tears/tears.mpd",
        Util.TYPE_DASH),
    new Sample("WV: Secure SD (MP4,H264)", "", "widevine_test",
        "https://storage.googleapis.com/wvmedia/cenc/h264/tears/tears_sd.mpd",
        Util.TYPE_DASH),
    new Sample("WV: Secure HD (MP4,H264)", "", "widevine_test",
        "https://storage.googleapis.com/wvmedia/cenc/h264/tears/tears_hd.mpd",
        Util.TYPE_DASH),
    new Sample("WV: Secure UHD (MP4,H264)", "", "widevine_test",
        "https://storage.googleapis.com/wvmedia/cenc/h264/tears/tears_uhd.mpd",
        Util.TYPE_DASH),
  };

  public static final Sample[] WIDEVINE_VP9_WEBM_CLEAR = new Sample[] {
    new Sample("WV: Clear SD & HD (WebM,VP9)",
        "https://storage.googleapis.com/wvmedia/clear/vp9/tears/tears.mpd",
        Util.TYPE_DASH),
    new Sample("WV: Clear SD (WebM,VP9)",
        "https://storage.googleapis.com/wvmedia/clear/vp9/tears/tears_sd.mpd",
        Util.TYPE_DASH),
    new Sample("WV: Clear HD (WebM,VP9)",
        "https://storage.googleapis.com/wvmedia/clear/vp9/tears/tears_hd.mpd",
        Util.TYPE_DASH),
    new Sample("WV: Clear UHD (WebM,VP9)",
        "https://storage.googleapis.com/wvmedia/clear/vp9/tears/tears_uhd.mpd",
        Util.TYPE_DASH),
  };

  public static final Sample[] WIDEVINE_H265_MP4_CLEAR = new Sample[] {
    new Sample("WV: Clear SD & HD (MP4,H265)",
        "https://storage.googleapis.com/wvmedia/clear/hevc/tears/tears.mpd",
        Util.TYPE_DASH),
    new Sample("WV: Clear SD (MP4,H265)",
        "https://storage.googleapis.com/wvmedia/clear/hevc/tears/tears_sd.mpd",
        Util.TYPE_DASH),
    new Sample("WV: Clear HD (MP4,H265)",
        "https://storage.googleapis.com/wvmedia/clear/hevc/tears/tears_hd.mpd",
        Util.TYPE_DASH),
    new Sample("WV: Clear UHD (MP4,H265)",
        "https://storage.googleapis.com/wvmedia/clear/hevc/tears/tears_uhd.mpd",
        Util.TYPE_DASH),
  };

  public static final Sample[] WIDEVINE_H265_MP4_SECURE = new Sample[] {
    new Sample("WV: Secure SD & HD (MP4,H265)", "", "widevine_test",
        "https://storage.googleapis.com/wvmedia/cenc/hevc/tears/tears.mpd",
        Util.TYPE_DASH),
    new Sample("WV: Secure SD (MP4,H265)", "", "widevine_test",
        "https://storage.googleapis.com/wvmedia/cenc/hevc/tears/tears_sd.mpd",
        Util.TYPE_DASH),
    new Sample("WV: Secure HD (MP4,H265)", "", "widevine_test",
        "https://storage.googleapis.com/wvmedia/cenc/hevc/tears/tears_hd.mpd",
        Util.TYPE_DASH),
    new Sample("WV: Secure UHD (MP4,H265)", "", "widevine_test",
        "https://storage.googleapis.com/wvmedia/cenc/hevc/tears/tears_uhd.mpd",
        Util.TYPE_DASH),
  };

  public static final Sample[] HLS = new Sample[] {
    new Sample("Apple master playlist",
        "https://devimages.apple.com.edgekey.net/streaming/examples/bipbop_4x3/"
        + "bipbop_4x3_variant.m3u8", Util.TYPE_HLS),
    new Sample("Apple master playlist advanced",
        "https://devimages.apple.com.edgekey.net/streaming/examples/bipbop_16x9/"
        + "bipbop_16x9_variant.m3u8", Util.TYPE_HLS),
    new Sample("Apple TS media playlist",
        "https://devimages.apple.com.edgekey.net/streaming/examples/bipbop_4x3/gear1/"
        + "prog_index.m3u8", Util.TYPE_HLS),
    new Sample("Apple AAC media playlist",
        "https://devimages.apple.com.edgekey.net/streaming/examples/bipbop_4x3/gear0/"
        + "prog_index.m3u8", Util.TYPE_HLS),
    new Sample("Apple ID3 metadata", "http://devimages.apple.com/samplecode/adDemo/ad.m3u8",
        Util.TYPE_HLS),
  };

  public static final Sample[] MISC = new Sample[] {
    new Sample("Dizzy", "http://html5demos.com/assets/dizzy.mp4", Util.TYPE_OTHER),
    new Sample("Big Buck Bunny (MP4 Video)",
        "http://redirector.c.youtube.com/videoplayback?id=604ed5ce52eda7ee&itag=22&source=youtube&"
        + "sparams=ip,ipbits,expire,source,id&ip=0.0.0.0&ipbits=0&expire=19000000000&signature="
        + "513F28C7FDCBEC60A66C86C9A393556C99DC47FB.04C88036EEE12565A1ED864A875A58F15D8B5300"
        + "&key=ik0", Util.TYPE_OTHER),
    new Sample("Big Buck Bunny (FLV Video)",
        "http://vod.leasewebcdn.com/bbb.flv?ri=1024&rs=150&start=0", Util.TYPE_OTHER),
  };

  private Samples() {}

}
