package com.pesonal.adsdk.remote;

public interface NativeCallback {
        void onLoad(boolean isFail);
    void onState(AdvertisementState state);
    }
