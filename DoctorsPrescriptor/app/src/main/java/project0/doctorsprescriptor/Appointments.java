package project0.doctorsprescriptor;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Appointments extends AppCompatActivity  {
    ListView listView;
   FirebaseDatabase database;
    DatabaseReference ref;
    ArrayList<String> list;
    ArrayAdapter <String> adapter;
    user User1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointments);


        listView =(ListView) findViewById(R.id.lstv);
        database = FirebaseDatabase.getInstance();
        ref = database.getReference("messages");
        list = new ArrayList<String>();
        User1 = new user();
        adapter = new ArrayAdapter<String>(this,R.layout.user_info,R.id.userInfo, list);
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
            for(DataSnapshot ds:dataSnapshot.getChildren()){

                 User1= ds.getValue(user.class);
                list.add(User1.getName().toString()+" "+User1.getPhone().toString()+" "+User1.getDate().toString()+" "+User1.getTime().toString()+" "+User1.getMessage().toString());
            }
            listView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

}
