package io.dcloud.Hui;

import android.app.Application;
import android.util.Log;

import com.alibaba.baichuan.android.trade.AlibcTradeSDK;
import com.alibaba.baichuan.android.trade.callback.AlibcTradeInitCallback;
import com.alibaba.baichuan.trade.biz.login.AlibcLogin;
import com.alibaba.baichuan.trade.biz.login.AlibcLoginCallback;
import com.google.gson.Gson;

public class AliLoginApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        initAlibcTradeSDK();
    }

    private void initAlibcTradeSDK() {
        AlibcTradeSDK.asyncInit(this, new AlibcTradeInitCallback() {
            @Override
            public void onSuccess() {
                Log.d("Tag","百川初始化成功");
            }

            @Override
            public void onFailure(int i, String s) {
                Log.d("Tag","百川初始化失败");
            }
        });
    }



}
