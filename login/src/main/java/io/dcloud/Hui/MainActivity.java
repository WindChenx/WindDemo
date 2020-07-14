package io.dcloud.Hui;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import com.ali.auth.third.ui.context.CallbackContext;
import com.alibaba.baichuan.trade.biz.login.AlibcLogin;
import com.alibaba.baichuan.trade.biz.login.AlibcLoginCallback;


public class MainActivity extends AppCompatActivity {
    private Button taobao_Login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        taobao_Login=findViewById(R.id.login);
        taobao_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getLogin();
            }
        });
    }
    public void getLogin(){
        AlibcLogin alibcLogin=AlibcLogin.getInstance();
        alibcLogin.showLogin(new AlibcLoginCallback() {
            @Override
            public void onSuccess(int i, String s, String s1) {
                Log.d("Tag","登录成功");
                Log.i("Tag", "获取淘宝用户信息: "+AlibcLogin.getInstance().getSession());
            }

            @Override
            public void onFailure(int i, String s) {
    Log.d("Tag","登录失败");
            }
        });

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        CallbackContext.onActivityResult(requestCode, resultCode, data);
    }


}
