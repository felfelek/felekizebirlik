package com.lecboxyazilim.lecbox;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import org.json.JSONStringer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Nullable;

public class TeacherFinder extends AppCompatActivity {
    private RecyclerView mHocaList;
    private List<Teachers> teachersList;
    private TeachersListAdapter teachersListAdapter;
    private List<String> teacherIds;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_finder);
        mHocaList = (RecyclerView) findViewById(R.id.hocaRecyclerView);
        //2de değiştirdim
        teachersList = new ArrayList<>();
        teacherIds = new ArrayList<>();

        teachersListAdapter = new TeachersListAdapter(teachersList);
        mHocaList.setHasFixedSize(true);
        mHocaList.setLayoutManager(new LinearLayoutManager(this));
        mHocaList.setAdapter(teachersListAdapter);

        //Şimdilik seçme işlemini yapmış gibi davranıyorum(bilgisyar)
        String choiceBolum = "bilgisayarmuhendislik";
        String choiceFakulte="muhendislikfakultesi";
        //456
        final Map<String, Object> hocaMap = new HashMap<>();
        final String[] hocaNameArray={};

        //Fakülteler/muhendislikfakultesi/bölümler/bilgisayarmuhendislik/hocalar
        if(choiceFakulte.equals("muhendislikfakultesi")){
            if(choiceBolum.equals("bilgisayarmuhendislik")){
                /*db.collection("bilmuh").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
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
                });*/

                /*db.collection("bilmuh").addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {
                        for(DocumentChange doc : queryDocumentSnapshots.getDocumentChanges()){
                            if(doc.getType() == DocumentChange.Type.ADDED){
                                //String name = doc.getDocument().getString("name");
                                //Log.d("TAG", "name"+ name);
                                Teachers teachers = doc.getDocument().toObject(Teachers.class);
                                teachersList.add(teachers);
                                teachersListAdapter.notifyDataSetChanged();
                            }
                        }

                    }
                });*/

            db.collection("bilmuh").addSnapshotListener(new EventListener<QuerySnapshot>() {
                @Override
                public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {
                    if(e != null){
                        Log.d("FirebaseError","" + e.getMessage());
                    }
                    for(DocumentChange doc: queryDocumentSnapshots.getDocumentChanges()){
                        if(doc.getType() == DocumentChange.Type.ADDED){
                            Teachers teachers = doc.getDocument().toObject(Teachers.class);
                            teachersList.add(teachers);
                            teachersListAdapter.notifyDataSetChanged();
                            String uid = doc.getDocument().getId();
                            teacherIds.add(uid);
                        }
                    }
                }
            });
            }

        }
        mHocaList.addOnItemTouchListener(new RecyclerItemClickListener(TeacherFinder.this, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                TextView nametext = view.findViewById(R.id.nameText);
                // TextView uidText = view.findViewById(R.id.statusText);
                //in order to get userId
                //Toast.makeText(TeacherFinder.this, teacherIds.get(position), Toast.LENGTH_SHORT).show();
            }
        }));
    }
}
