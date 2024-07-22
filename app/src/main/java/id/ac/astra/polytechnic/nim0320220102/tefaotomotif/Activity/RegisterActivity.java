package id.ac.astra.polytechnic.nim0320220102.tefaotomotif.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import id.ac.astra.polytechnic.nim0320220102.tefaotomotif.Fragment.RegisterFragment;
import id.ac.astra.polytechnic.nim0320220102.tefaotomotif.R;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        if (savedInstanceState == null) {
            RegisterFragment fragmentPickUpKurir = new RegisterFragment();


            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_register, fragmentPickUpKurir)
                    .commit();
        }

    }

    public void startLogSignActivity(View view) {
        Intent intent = new Intent(this, LogSignActivity.class);
        startActivity(intent);
    }

    public void startLoginFragment(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);

    }
}