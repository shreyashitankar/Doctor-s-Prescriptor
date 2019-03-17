package project0.doctorsprescriptor;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class login extends AppCompatActivity {
    EditText Uname,Pwd;
    Button SignIn;

    private  final  static String MyPrefs="MyAPPData";
    String uname="uname";
    String pwd="pwd";
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Uname=(EditText)findViewById(R.id.editText);
        Pwd=(EditText)findViewById(R.id.editText3);

        SignIn=(Button)findViewById(R.id.button2);
        sharedPreferences=getSharedPreferences(MyPrefs,MODE_PRIVATE);
    }
    @Override
    protected void onStart() {
        super.onStart();

        SignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Uname.length()==0){
                    Uname.setError("Enter Username");
                }else if(Pwd.length()==0){
                    Pwd.setError("Enter Password");
                }else if(!Uname.getText().toString().equals("admin")){
                    Uname.setError("Invalid Username");
                }else if(!Pwd.getText().toString().equals("doctor123")){
                    Pwd.setError("Invalid Password");
                }else{
                    SharedPreferences.Editor editor= sharedPreferences.edit();
                    editor.putString(uname,Uname.getText().toString());
                    editor.putString(pwd,Pwd.getText().toString());
                    editor.commit();

                    Intent i= new Intent(login.this,home.class);
                    i.putExtra("uname",Uname.getText().toString());
                    startActivity(i);
                    finish();

                }
            }
        });
    }
}
