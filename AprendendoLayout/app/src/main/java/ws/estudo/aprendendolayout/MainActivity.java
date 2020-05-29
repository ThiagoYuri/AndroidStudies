package ws.estudo.aprendendolayout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void irTableLayout(View view) {


        Intent intent = new Intent(this,TableLayout.class);

        startActivity(intent);
    }

    public void irScrollLayout(View view) {
        Intent intent = new Intent(this,ScrollViewLayout.class);

        startActivity(intent);

    }

    public void ConstraitLayout(View view) {
        Intent intent = new Intent(this,ConstraintLayout.class);

        startActivity(intent);
    }

    public void irGuiHorizontal(View view) {
        Intent intent = new Intent(this,GuideLineHLayout.class);

        startActivity(intent);
    }

    public void irGuiVestical(View view) {
        Intent intent = new Intent(this,GuideLineVLayout.class);

        startActivity(intent);
    }

    public void irGridLayout(View view) {
        Intent intent = new Intent(this,GridLayout.class);

        startActivity(intent);
    }

    public void irCardLayout(View view) {
        Intent intent = new Intent(this,CardViewLayout.class);

        startActivity(intent);
    }
}
