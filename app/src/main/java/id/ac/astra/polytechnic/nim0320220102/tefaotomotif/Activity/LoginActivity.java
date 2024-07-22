package id.ac.astra.polytechnic.nim0320220102.tefaotomotif.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import id.ac.astra.polytechnic.nim0320220102.tefaotomotif.Fragment.LoginFragment;
import id.ac.astra.polytechnic.nim0320220102.tefaotomotif.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_dan_register);
        if (savedInstanceState == null) {
            LoginFragment fragmentPickUpKurir = new LoginFragment();


            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_login, fragmentPickUpKurir)
                    .commit();
        }
    }

    public void startLogSignActivity(View view) {
        Intent intent = new Intent(this, LogSignActivity.class);
        startActivity(intent);
    }

    public void startRegisterFragment(View view) {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }


}