package com.pesonal.adsdk.utils;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.google.android.gms.ads.nativead.MediaView;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.ads.nativead.NativeAdView;
import com.pesonal.adsdk.R;

import java.util.Objects;

public class Inflate_ADS {
    Context activity;

    public Inflate_ADS(Context context) {
        this.activity = context;
    }

    public void inflate_NATIV_ADMOB(NativeAd nativeAd, String color, String buttonTextColor, ViewGroup cardView) {

        cardView.setVisibility(View.VISIBLE);
        LayoutInflater inflater = LayoutInflater.from(activity);
        View view = (View) inflater
                .inflate(R.layout.admob_big, null);
        cardView.removeAllViews();
        cardView.addView(view);

        populateAppInstallAdViewMediasmall(nativeAd, color,buttonTextColor,(NativeAdView) view.findViewById(R.id.unified));

    }


    public void inflate_NATIV_ADMOB_SMALL(NativeAd nativeAd, String buttonColor, String textColor,ViewGroup cardView) {

        cardView.setVisibility(View.VISIBLE);
        LayoutInflater inflater = LayoutInflater.from(activity);
        View view = (View) inflater
                .inflate(R.layout.admob_small, null);
        cardView.removeAllViews();
        cardView.addView(view);

        populateAppInstallAdViewMediaS(nativeAd,buttonColor,textColor ,(NativeAdView) view.findViewById(R.id.unified));

    }

    public void showSmall(NativeAd nativeAd, String buttonColor, String buttonTextColor, ViewGroup cardView) {
        cardView.setVisibility(View.VISIBLE);
        LayoutInflater inflater = LayoutInflater.from(activity);
        View view = (View) inflater
                .inflate(R.layout.admob_tiny, null);
        cardView.removeAllViews();
        cardView.addView(view);

        populateAppInstallAdViewMedia(nativeAd, buttonColor,buttonTextColor,(NativeAdView) view.findViewById(R.id.unified));
    }

    public static void populateAppInstallAdViewMediaS(NativeAd unifiedNativeAd, String buttonColor, String textColor, NativeAdView unifiedNativeAdView) {
        unifiedNativeAdView.setHeadlineView(unifiedNativeAdView.findViewById(R.id.ad_headline));
        unifiedNativeAdView.setBodyView(unifiedNativeAdView.findViewById(R.id.ad_body));
        unifiedNativeAdView.setCallToActionView(unifiedNativeAdView.findViewById(R.id.ad_call_to_action));

        TextView viewById = unifiedNativeAdView.findViewById(R.id.ad_call_to_action);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            viewById.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(buttonColor)));
        }else {
            viewById.setBackgroundColor(Color.parseColor(buttonColor));
        }
        viewById.setTextColor(Color.parseColor(textColor));

        unifiedNativeAdView.setIconView(unifiedNativeAdView.findViewById(R.id.ad_app_icon));
        unifiedNativeAdView.setPriceView(unifiedNativeAdView.findViewById(R.id.ad_price));
        unifiedNativeAdView.setStarRatingView(unifiedNativeAdView.findViewById(R.id.ad_stars));
        unifiedNativeAdView.setStoreView(unifiedNativeAdView.findViewById(R.id.ad_store));
        unifiedNativeAdView.setAdvertiserView(unifiedNativeAdView.findViewById(R.id.ad_advertiser));
        ((TextView) unifiedNativeAdView.getHeadlineView()).setText(unifiedNativeAd.getHeadline());
        if (unifiedNativeAd.getBody() == null) {
            unifiedNativeAdView.getBodyView().setVisibility(View.INVISIBLE);
        } else {
            unifiedNativeAdView.getBodyView().setVisibility(View.VISIBLE);
            ((TextView) unifiedNativeAdView.getBodyView()).setText(unifiedNativeAd.getBody());
            ((TextView) Objects.requireNonNull(unifiedNativeAdView.getBodyView())).setMovementMethod(new ScrollingMovementMethod());
        }
        if (unifiedNativeAd.getCallToAction() == null) {
            unifiedNativeAdView.getCallToActionView().setVisibility(View.INVISIBLE);
        } else {
            unifiedNativeAdView.getCallToActionView().setVisibility(View.VISIBLE);
            ((TextView) unifiedNativeAdView.getCallToActionView()).setText(unifiedNativeAd.getCallToAction());
        }
        if (unifiedNativeAd.getIcon() == null) {
            unifiedNativeAdView.getIconView().setVisibility(View.GONE);
        } else {
            ((ImageView) unifiedNativeAdView.getIconView()).setImageDrawable(unifiedNativeAd.getIcon().getDrawable());
            unifiedNativeAdView.getIconView().setVisibility(View.VISIBLE);
        }
        if (unifiedNativeAd.getStarRating() == null) {
            unifiedNativeAdView.getStarRatingView().setVisibility(View.INVISIBLE);
        } else {
            ((RatingBar) unifiedNativeAdView.getStarRatingView()).setRating(unifiedNativeAd.getStarRating().floatValue());
            unifiedNativeAdView.getStarRatingView().setVisibility(View.VISIBLE);
        }
        if (unifiedNativeAd.getAdvertiser() == null) {
            unifiedNativeAdView.getAdvertiserView().setVisibility(View.INVISIBLE);
        } else {
            ((TextView) unifiedNativeAdView.getAdvertiserView()).setText(unifiedNativeAd.getAdvertiser());
            unifiedNativeAdView.getAdvertiserView().setVisibility(View.VISIBLE);
        }
        try {
            unifiedNativeAdView.setNativeAd(unifiedNativeAd);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void populateAppInstallAdViewMediasmall(NativeAd unifiedNativeAd, String buttonColor,String textColor, NativeAdView unifiedNativeAdView) {
        unifiedNativeAdView.setMediaView((MediaView) unifiedNativeAdView.findViewById(R.id.ad_media));
        unifiedNativeAdView.setHeadlineView(unifiedNativeAdView.findViewById(R.id.ad_headline));
        unifiedNativeAdView.setBodyView(unifiedNativeAdView.findViewById(R.id.ad_body));
        unifiedNativeAdView.setCallToActionView(unifiedNativeAdView.findViewById(R.id.ad_call_to_action));
        TextView viewById = unifiedNativeAdView.findViewById(R.id.ad_call_to_action);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            viewById.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(buttonColor)));
        }else {
            viewById.setBackgroundColor(Color.parseColor(buttonColor));
        }
        viewById.setTextColor(Color.parseColor(textColor));

        unifiedNativeAdView.setIconView(unifiedNativeAdView.findViewById(R.id.ad_app_icon));
        ((TextView) unifiedNativeAdView.getHeadlineView()).setText(unifiedNativeAd.getHeadline());
        unifiedNativeAdView.getMediaView().setMediaContent(unifiedNativeAd.getMediaContent());
        if (unifiedNativeAd.getBody() == null) {
            unifiedNativeAdView.getBodyView().setVisibility(View.INVISIBLE);
        } else {
            unifiedNativeAdView.getBodyView().setVisibility(View.VISIBLE);
            ((TextView) unifiedNativeAdView.getBodyView()).setText(unifiedNativeAd.getBody());
        }
        if (unifiedNativeAd.getCallToAction() == null) {
            unifiedNativeAdView.getCallToActionView().setVisibility(View.INVISIBLE);
        } else {
            unifiedNativeAdView.getCallToActionView().setVisibility(View.VISIBLE);
            ((TextView) unifiedNativeAdView.getCallToActionView()).setText(unifiedNativeAd.getCallToAction());
        }
        if (unifiedNativeAd.getIcon() != null) {
            if (unifiedNativeAd.getIcon() == null) {
                unifiedNativeAdView.getIconView().setVisibility(View.INVISIBLE);
            } else {
                ((ImageView) unifiedNativeAdView.getIconView()).setImageDrawable(unifiedNativeAd.getIcon().getDrawable());
                unifiedNativeAdView.getIconView().setVisibility(View.VISIBLE);
            }
        }
        try {
            unifiedNativeAdView.setNativeAd(unifiedNativeAd);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void populateAppInstallAdViewMedia(NativeAd unifiedNativeAd, String buttonColor, String buttonTextColor, NativeAdView unifiedNativeAdView) {
        unifiedNativeAdView.setHeadlineView(unifiedNativeAdView.findViewById(R.id.ad_headline));
        unifiedNativeAdView.setBodyView(unifiedNativeAdView.findViewById(R.id.ad_body));
        unifiedNativeAdView.setIconView(unifiedNativeAdView.findViewById(R.id.ad_app_icon));
        unifiedNativeAdView.setCallToActionView(unifiedNativeAdView.findViewById(R.id.ad_call_to_action));
        TextView viewById = unifiedNativeAdView.findViewById(R.id.ad_call_to_action);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            viewById.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(buttonColor)));
        }else {
            viewById.setBackgroundColor(Color.parseColor(buttonColor));
        }
        viewById.setTextColor(Color.parseColor(buttonTextColor));

        ((TextView) unifiedNativeAdView.getHeadlineView()).setText(unifiedNativeAd.getHeadline());
        if (unifiedNativeAd.getBody() == null) {
            unifiedNativeAdView.getBodyView().setVisibility(View.INVISIBLE);
        } else {
            unifiedNativeAdView.getBodyView().setVisibility(View.VISIBLE);
            ((TextView) unifiedNativeAdView.getBodyView()).setText(unifiedNativeAd.getBody());
        }
        if (unifiedNativeAd.getCallToAction() == null) {
            unifiedNativeAdView.getCallToActionView().setVisibility(View.INVISIBLE);
        } else {
            unifiedNativeAdView.getCallToActionView().setVisibility(View.VISIBLE);
            ((Button) unifiedNativeAdView.getCallToActionView()).setText(unifiedNativeAd.getCallToAction());
            unifiedNativeAdView.getCallToActionView().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                }
            });
        }
        if (unifiedNativeAd.getIcon() == null) {
            unifiedNativeAdView.getIconView().setVisibility(View.GONE);
        } else {
            ((ImageView) unifiedNativeAdView.getIconView()).setImageDrawable(unifiedNativeAd.getIcon().getDrawable());
            unifiedNativeAdView.getIconView().setVisibility(View.VISIBLE);
        }
        try {
            unifiedNativeAdView.setNativeAd(unifiedNativeAd);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }


}
