package com.example.networkingexample;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

//import org.chromium.base.Callback;

import java.io.IOException;
import java.net.URLEncoder;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttp;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    OkHttpClient client;
    //String getURL = "https://www.google.com";
    //String getURL = "https://www.google.com/search?q=Hima+Vadapalli";
    String getURL = "https://lamp.ms.wits.ac.za/mc/test.php";

   String postURL = "https://lamp.ms.wits.ac.za/mc/test2.php";

    TextView textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        client = new OkHttpClient();
        textview = findViewById(R.id.textView);
        Button getrequest = findViewById(R.id.getrequest);
        Button postrequest = findViewById(R.id.postrequest);

        getrequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                get();
            }
        });

        postrequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                post();
            }
        });
    }
       public void get() {
           Request request = new Request.Builder()
                   .url(getURL)
                   .build();
           client.newCall(request).enqueue(new Callback() {
               @Override
               public void onFailure(@NonNull Call call, @NonNull IOException e) {
                   textview.setText("Failure");
               }

               public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                   runOnUiThread(new Runnable() {
                       @Override
                       public void run() {
                           try {
                               textview.setText(response.body().string());
                           } catch (IOException e) {
                               throw new RuntimeException(e);
                           }
                       }
                   });
               }

           });
       }

       public void post() {
           RequestBody requestBody = new FormBody.Builder().add("username", "John").build();
           Request request = new Request.Builder()
                   .url(postURL)
                   .post(requestBody)
                   .build();
           client.newCall(request).enqueue(new Callback() {

               @Override
               public void onFailure(@NonNull Call call, @NonNull IOException e) {
                   textview.setText("Failure");
               }

               @Override
               public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                   runOnUiThread(new Runnable() {
                       @Override
                       public void run() {
                           try {
                               textview.setText(response.body().string());
                           } catch (IOException e) {
                               throw new RuntimeException(e);
                           }
                       }
                   });
               }

           });


       }
}