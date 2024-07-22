package id.ac.astra.polytechnic.nim0320220102.tefaotomotif.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

import id.ac.astra.polytechnic.nim0320220102.tefaotomotif.R;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView2;
    private int[] images = {R.drawable.welcometext, R.drawable.welcometext2, R.drawable.welcometext3};
    private int currentImageIndex = 0;
    private Handler handler = new Handler();
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            // Update image resource
            currentImageIndex = (currentImageIndex + 1) % images.length;
            imageView2.setImageResource(images[currentImageIndex]);

            // Schedule the runnable to run again after 5 seconds
            handler.postDelayed(this, 5000);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView2 = findViewById(R.id.imageView2);

        // Start the runnable for the first time
        handler.postDelayed(runnable, 5000);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Remove the callbacks to prevent memory leaks
        handler.removeCallbacks(runnable);
    }

    public void startLogSignActivity(View view) {
        Intent intent = new Intent(this, LogSignActivity.class);
        startActivity(intent);
    }

    public void startDahboardAdmin(View view) {
        Intent intent = new Intent(this, DashboardAdminActivity.class);
        startActivity(intent);
    }

    public void startDashboardActivity(View view) {
        Intent intent = new Intent(this, DashboardActivity.class);
        startActivity(intent);
    }
}
