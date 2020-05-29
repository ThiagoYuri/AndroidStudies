package ws.loja.wstowers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    RelativeLayout rellay1;

    Handler handrer = new Handler();

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            rellay1.setVisibility(View.VISIBLE);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);

        rellay1 = (RelativeLayout)findViewById(R.id.rellay1);
        handrer.postDelayed(runnable,2000);
    }

    @Override
    public void onBackPressed() {

        super.onBackPressed();


    }





    public void irRegister(View view) {
        Intent intent = new Intent(MainActivity.this,MainActivityRegister.class);

        ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeCustomAnimation(getApplicationContext(),R.anim.fade_in,R.anim.move_direita);

        ActivityCompat.startActivities(MainActivity.this, new Intent[]{intent}, activityOptionsCompat.toBundle());

    }



    //Ciclo de vida
    @Override
    public void onStart(){
        super.onStart();
        Log.i("Ciclo", "onStart: Ligado");
    }

    @Override
    public void onResume(){
        super.onResume();
        Log.i("Ciclo", "onResume: Ligado");
    }
    @Override
    public void onRestart(){
        super.onRestart();
        Log.i("Ciclo", "onRestart: Ligado");
    }
    @Override
    public void onPause(){
        super.onPause();
        Log.i("Ciclo", "onPause: Ligado");
    }
    @Override
    public void onStop(){
        super.onStop();
        Log.i("Ciclo", "onStop: Ligado");
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.i("Ciclo", "onDestroy: Ligado");
    }
}
