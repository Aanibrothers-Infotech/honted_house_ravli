package com.pesonal.adsdk;

import android.os.CountDownTimer;

import com.pesonal.adsdk.qureka.CustomiseinterActivity;
import com.pesonal.adsdk.qureka.Glob;
import com.pesonal.adsdk.remote.AdvertisementState;

public class I {

//    if (showCustom || mInterstitialAd == null) {
//        if (sequenceQureka) {
//            CustomiseinterActivity.H(activity, () -> {
//                loadInter();
//                interstitialCallBack(AdvertisementState.QUREKA_INTER_AD_CLOSE);
//            }, Glob.dataset(activity));
//        } else {
//            showCustomInter(activity);
//        }
//    } else {
//        if (responseRoot.getAPPSETTINGS().getAppDialogBeforeAdShow().equals("1")) {
//            if (!activity.isFinishing())
//                dialog.show();
//            new CountDownTimer(ad_dialog_time_in_second * 1000L, 10) {
//                @Override
//                public void onTick(long millisUntilFinished) {
//                }
//
//                @Override
//                public void onFinish() {
//                    if (mInterstitialAd != null) {
//                        mInterstitialAd.show(activity);
//                        if (!activity.isFinishing() && dialog != null && dialog.isShowing())
//                            dialog.dismiss();
//                    } else {
//                        if (!activity.isFinishing() && dialog != null && dialog.isShowing())
//                            dialog.dismiss();
//                        CustomiseinterActivity.H(activity, () -> {
//                            loadInter();
//                            interstitialCallBack(AdvertisementState.QUREKA_INTER_AD_CLOSE);
//                        }, Glob.dataset(activity));
//                    }
//                }
//            }.start();
//        } else {
//            dialog.dismiss();
//            if (mInterstitialAd != null) {
//                mInterstitialAd.show(activity);
//                dialog.dismiss();
//            } else {
//                CustomiseinterActivity.H(activity, () -> {
//                    loadInter();
//                    interstitialCallBack(AdvertisementState.QUREKA_INTER_AD_CLOSE);
//                }, Glob.dataset(activity));
//            }
//        }
//    }
}
