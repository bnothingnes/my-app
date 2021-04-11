package com.example.my_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.ContentLoadingProgressBar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {
    TextView tolog;
    Button register;
    EditText nama,email,password;
    LoadingDialog loadingDialog = new LoadingDialog(RegisterActivity.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        tolog = (TextView)findViewById(R.id.tvlogin);
        register = (Button) findViewById(R.id.btnRegister);
        nama = (EditText)findViewById(R.id.fullname);
        email = (EditText)findViewById(R.id.email);
        password = (EditText)findViewById(R.id.password);

        tolog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RegisterRequest registerRequest = new RegisterRequest();
                registerRequest.setEmail(email.getText().toString());
                registerRequest.setNama(nama.getText().toString());
                registerRequest.setPassword(password.getText().toString());
                loadingDialog.startLoading();
                registerUser(registerRequest);
            }
        });
    }

    public void registerUser(RegisterRequest registerRequest) {
        Call<RegisterResponse> registerResponseCall = ApiClient.getService().registeruser(registerRequest);
        registerResponseCall.enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                if(response.isSuccessful()) {
                    String message = response.body().getPesan();
                    String status = response.body().getStatus();
                    if (status.equals("success")) {
                        loadingDialog.closeLoading();
//                        Toast.makeText(RegisterActivity.this, message, Toast.LENGTH_LONG).show();
                        startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                        finish();
                    } else {
                        loadingDialog.closeLoading();
                        Toast.makeText(RegisterActivity.this, message, Toast.LENGTH_LONG).show();
                    }

                } else {
                    loadingDialog.closeLoading();
                    String message = "gagal mendaftar";
                    Toast.makeText(RegisterActivity.this, message, Toast.LENGTH_LONG).show();
                }
            }
            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {
                loadingDialog.closeLoading();
                String message = t.getLocalizedMessage();
                Toast.makeText(RegisterActivity.this, message, Toast.LENGTH_LONG).show();
            }
        });
    }
}