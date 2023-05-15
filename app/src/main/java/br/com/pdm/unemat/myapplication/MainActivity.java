package br.com.pdm.unemat.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText ed1,ed2,ed3;
    Button b1;

    public static final String MyPREFERENCES = "arquivo" ;
    //public static final String Usuario = "userKey";
    // public static final String Email = "emailKey";
    // public static final String Senha = "senhaKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1=(EditText)findViewById(R.id.username);
        ed2=(EditText)findViewById(R.id.email);
        ed3=(EditText)findViewById(R.id.password);

        b1=(Button)findViewById(R.id.button);

        SharedPreferences sharedpreferences = getSharedPreferences(MyPREFERENCES, 0);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String produto  = ed1.getText().toString();
                String quantidade  = ed2.getText().toString();
                String valor  = ed3.getText().toString();

                SharedPreferences.Editor editor = sharedpreferences.edit();

                editor.putString("Usuario", produto);
                editor.putString("Email", quantidade);
                editor.putString("Senha", valor);
                editor.commit();
                Toast.makeText(MainActivity.this,"Produto cadastrados no arquivo .xml com sucesso!!",Toast.LENGTH_LONG).show();

                //LIMPAR O EDITTEXT
                ed1.getText().clear();
                ed2.getText().clear();
                ed3.getText().clear();
                ed1.requestFocus();

            }
        });
    }
}