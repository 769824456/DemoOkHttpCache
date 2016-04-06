package me.jiudeng.demookhttpcache;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.zhy.http.okhttp.OkHttpUtils;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "MainActivity";
    private Button       btn_load_data;
    private TextView     tv_data;
    private OkHttpClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_load_data = (Button) findViewById(R.id.btn_load_data);
        tv_data = (TextView) findViewById(R.id.tv_data);
        btn_load_data.setOnClickListener(this);


        int  cacheSize = 10 * 1024 * 1024; // 10 MiB
        File file      = new File(FileUtil.getSDCardPath() + "/abc.txt");
        if (!file.exists()) {
            file.mkdir();
        }
        Cache cache = new Cache(file, cacheSize);

        client = new OkHttpClient.Builder().cache(cache).connectTimeout(5000, TimeUnit.MINUTES).build();
        Log.e(TAG, "run: " + cache.directory());
    }

    @Override
    public void onClick(View v) {


        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Request.Builder builder = new Request.Builder()
                            .url("http://10.0.0.12:20380/category/all");
                    //网络判断
                    boolean openNetwork = NetWorkCheck.isOpenNetwork(getApplicationContext());
                    Request request = null;
                    if (openNetwork) {//有网
                        request = builder
//                                .cacheControl(CacheControl.FORCE_NETWORK)
                                .build();

                    } else {//没有网络
                        request = builder
                                .cacheControl(CacheControl.FORCE_CACHE)
                                .build();
                    }
                    Response response = client.newCall(request).execute();
                    Log.e(TAG, "networkResponse: " + response.networkResponse());
                    Log.e(TAG, "cacheResponse: " + response.cacheResponse());
//                    boolean successful = response.isSuccessful();
//                    if (successful) {
//                        Log.e(TAG, "success: " + response.body().string());
//                    } else {
//                        Log.e(TAG, "failure: " + response.cacheResponse());
//                    }


                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
//        client.newCall(request).enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//                Log.e(TAG, "onFailure:" + e.toString());
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                boolean successful = response.isSuccessful();
//                if (successful) {
//                    ResponseBody body = response.body();
//                    final String string = body.string();
//                    Log.e(TAG, "onResponse: " + string);
//                    body.close();
//                    runOnUiThread(new Runnable() {
//                        @Override
//                        public void run() {
//                            tv_data.setText(string);
//                        }
//                    });
//
//                } else {
//                    Log.e(TAG, "onResponse: failure");
//                }
//            }
//        });


    }
}
