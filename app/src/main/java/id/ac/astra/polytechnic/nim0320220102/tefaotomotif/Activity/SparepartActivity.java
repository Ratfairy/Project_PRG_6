package id.ac.astra.polytechnic.nim0320220102.tefaotomotif.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import id.ac.astra.polytechnic.nim0320220102.tefaotomotif.Fragment.AddSparepartFragment;
import id.ac.astra.polytechnic.nim0320220102.tefaotomotif.Fragment.SparepartListFragment;
import id.ac.astra.polytechnic.nim0320220102.tefaotomotif.R;

public class SparepartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sparepart);
        if (savedInstanceState == null) {
            SparepartListFragment fragmentPickUpKurir = new SparepartListFragment();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_Sparepart, fragmentPickUpKurir)
                    .commit();
        }
    }

    public void startDashboardAdminFragment(View view) {
        Intent intent = new Intent(this, DashboardAdminActivity.class);
        startActivity(intent);
    }

    public void startAddFragmentFragment(View view) {
        Intent intent = new Intent(this, AddSparepartFragment.class);
        startActivity(intent);
    }

}
