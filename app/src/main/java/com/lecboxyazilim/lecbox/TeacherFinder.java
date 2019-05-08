package com.lecboxyazilim.lecbox;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import org.json.JSONStringer;

import java.util.HashMap;
import java.util.Map;

public class TeacherFinder extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_finder);
        //Şimdilik seçme işlemini yapmış gibi davranıyorum(bilgisyar)
        String choiceBolum = "bilgisayarmuhendislik";
        String choiceFakulte="muhendislikfakultesi";
        //456
        final Map<String, Object> hocaMap = new HashMap<>();
        final String[] hocaNameArray={};
        //Fakülteler/muhendislikfakultesi/bölümler/bilgisayarmuhendislik/hocalar
        if(choiceFakulte.equals("muhendislikfakultesi")){
            if(choiceBolum.equals("bilgisayarmuhendislik")){
                db.collection("bilmuh").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful()){
                            int i =0;
                            Toast.makeText(TeacherFinder.this, "basarili gibi", Toast.LENGTH_SHORT).show();
                            for (QueryDocumentSnapshot document : task.getResult()){
                                hocaMap.put("name",document.getData().toString());
                                Log.d("cikti", document.getId() + " => " + document.getData());
                            }

                        }
                    }
                });


            }

        }
    }
}
