package id.ac.astra.polytechnic.nim0320220102.tefaotomotif.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import id.ac.astra.polytechnic.nim0320220102.tefaotomotif.Fragment.ServiceListFragment;
import id.ac.astra.polytechnic.nim0320220102.tefaotomotif.Fragment.SparepartListFragment;
import id.ac.astra.polytechnic.nim0320220102.tefaotomotif.R;

public class ServiceActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        if (savedInstanceState == null) {
            ServiceListFragment fragmentPickUpKurir = new ServiceListFragment();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_Service, fragmentPickUpKurir)
                    .commit();
        }
    }

    public void startDashboardAdminFragment(View view) {
        Intent intent = new Intent(this, DashboardAdminActivity.class);
        startActivity(intent);
    }

}
