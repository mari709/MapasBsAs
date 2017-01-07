package mari709.mapasbsas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public class MainActivity extends AppCompatActivity {
    private double latitud = 0.00;
    private double longitud = 0.00;
    private String nombre = null;
    private float color = 0.0f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void irMapa(View v) {
        Intent i = new Intent(this, MapsActivity.class);
        switch (v.getId()) {
            case R.id.img_jardin:
                latitud = -34.575065;
                longitud = -58.409205;
                nombre = getResources().getString(R.string.jardin);
                color = BitmapDescriptorFactory.HUE_ORANGE;

                break;
            case R.id.img_planetario:
                latitud = -34.569536;
                longitud = -58.411618;
                nombre = getResources().getString(R.string.planetario);
                color = BitmapDescriptorFactory.HUE_GREEN;

                break;
            case R.id.img_teatro:
                latitud = -34.600973;
                longitud = -58.383096;
                nombre = getResources().getString(R.string.teatro);
                color = BitmapDescriptorFactory.HUE_YELLOW;
                break;
            case R.id.img_laboca:
                latitud = -34.639343;
                longitud = -58.362753;
                nombre = getResources().getString(R.string.boca);
                color = BitmapDescriptorFactory.HUE_MAGENTA;
                break;
            default:
                break;
        }
        i.putExtra(getResources().getString(R.string.pLatitud), latitud);
        i.putExtra(getResources().getString(R.string.pLongitud), longitud);
        i.putExtra(getResources().getString(R.string.pNombre), nombre);
        i.putExtra(getResources().getString(R.string.pColor), color);

        startActivity(i);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_options, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent i = new Intent(this, Acercade.class);
            startActivity(i);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}