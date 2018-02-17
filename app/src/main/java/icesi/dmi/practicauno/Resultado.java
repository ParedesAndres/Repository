package icesi.dmi.practicauno;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Resultado extends AppCompatActivity {

    TextView sitio_tv;
    TextView loop_tv;
    TextView local_tv;
    Button regresar_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        sitio_tv = (TextView) findViewById(R.id.sitio_tv);
        loop_tv = (TextView) findViewById(R.id.loop_tv);
        local_tv = (TextView) findViewById(R.id.local_tv);
        regresar_btn = (Button) findViewById(R.id.regresar_btn);

        regresar_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        String sitio = getIntent().getExtras().getString("sitio");
        String loop = getIntent().getExtras().getString("loop");
        String local = getIntent().getExtras().getString("local");

        sitio_tv.setText(sitio);
        loop_tv.setText(loop);
        local_tv.setText(local);
    }
}
