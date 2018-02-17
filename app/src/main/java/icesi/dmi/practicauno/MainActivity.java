package icesi.dmi.practicauno;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.net.InetAddress;

public class MainActivity extends AppCompatActivity {

    EditText host_et;
    Button consultar_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        host_et = (EditText) findViewById(R.id.host_et);
        consultar_btn = (Button) findViewById(R.id.consultar_btn);
        consultar_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                accion();
            }
        });
    }

    public void accion(){
        //Toast.makeText(this,host_str,Toast.LENGTH_LONG).show();
        String host_str = host_et.getText().toString();
        IPDiscover hilo = new IPDiscover();
        hilo.execute(host_str);

    }


    class IPDiscover extends AsyncTask<String,String,String>{

        @Override
        protected String doInBackground(String... strings) {
            try{
                String host_hilo = strings[0];

                InetAddress local = InetAddress.getLocalHost();
                InetAddress loopback = InetAddress.getLoopbackAddress();
                InetAddress address = InetAddress.getByName(host_hilo);

                String a = address.toString();
                String b = loopback.toString();
                String c = local.toString();

                String[] z = a.split("/");

                //return address.toString();
                return z[1]+"@"+b+"@"+c;
            }catch (Exception e){
                return null;
            }
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            //Toast.makeText(MainActivity.this,s, Toast.LENGTH_LONG).show();
            String[] ip = s.split("@");
            Intent intent = new Intent(MainActivity.this,Resultado.class);
            intent.putExtra("sitio",ip[0]);
            intent.putExtra("loop",ip[1]);
            intent.putExtra("local",ip[2]);
            startActivity(intent);
        }
    }
}
