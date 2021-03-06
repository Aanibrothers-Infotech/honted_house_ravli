package com.demo.mycommonapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.JsonElement;
import com.pesonal.adsdk.BaseAdsActivity;
import com.pesonal.adsdk.remote.APIManager;
import com.pesonal.adsdk.utils.SplashListner;

public class SplashActivity extends BaseAdsActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Log.e("TAG", "onCreate: "+"firstSplash" );
        initializeSplash(SplashActivity.this, new SplashListner() {
            @Override
            public void onSuccess() {

                Log.e("TAG", "onCreate: "+"secondSplash" );

                APIManager.getInstance(SplashActivity.this).showSplashAD(SplashActivity.this, (state) -> {
                    Log.e("SplashActivity", "state: " + state);
                    if (APIManager.getInstance(SplashActivity.this).getScreenStatus()) {
                        Intent intent = new Intent(SplashActivity.this, StartSecondActivity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                });
            }

            @Override
            public void onExtra(JsonElement extraData) {
                Log.e("TAG", "onExtra: " + extraData.toString());
            }
        });
    }
}