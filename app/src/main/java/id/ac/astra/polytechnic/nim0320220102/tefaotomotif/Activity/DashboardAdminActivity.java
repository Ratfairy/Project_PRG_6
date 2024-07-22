package id.ac.astra.polytechnic.nim0320220102.tefaotomotif.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import id.ac.astra.polytechnic.nim0320220102.tefaotomotif.R;

public class DashboardAdminActivity extends AppCompatActivity {

    CardView SparepartCard, ServiceCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_admin);

        SparepartCard = findViewById(R.id.SparepartCARD);
        ServiceCard = findViewById(R.id.serviceCARD);

        SparepartCard.setCardBackgroundColor(getResources().getColor(R.color.grey_young));
        ServiceCard.setCardBackgroundColor(getResources().getColor(R.color.grey_young));


        // Set OnClickListener for SparepartCard
        SparepartCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardAdminActivity.this, SparepartActivity.class);
                startActivity(intent);
            }
        });

        // Set OnClickListener for ServiceCard
        ServiceCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardAdminActivity.this, ServiceActivity.class);
                startActivity(intent);
            }
        });
    }
}
