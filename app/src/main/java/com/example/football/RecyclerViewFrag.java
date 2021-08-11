package com.example.football;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RecyclerViewFrag extends Fragment{

    List<KitInfo> kitInfoList,kitInfoList2;
    RecyclerView recyclerView,recyclerView2;


    public static RecyclerViewFrag newInstance() {

        Bundle args = new Bundle();

        RecyclerViewFrag fragment = new RecyclerViewFrag();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recycle_frag,container,false);


        kitInfoList2 = new ArrayList<>();


        FirebaseDatabase database2 = FirebaseDatabase.getInstance();
        DatabaseReference ref2 = database2.getReference().child("Kit").child("EPL");

        ref2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                kitInfoList2.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    String Name = snapshot.child("Name").getValue().toString();
                    String Price = "";
                    String Size = "";
                    KitInfo kitInfo = new KitInfo(Name,Price,Size,R.drawable.epl2);
                    kitInfoList2.add(kitInfo);
                }
                RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(), 1, RecyclerView.HORIZONTAL, false);
                AdapterRecycleview adapterRecycleview = new AdapterRecycleview(kitInfoList2, new AdapterRecycleview.ItemClickListener() {
                    @Override
                    public void onItemClick(KitInfo details) {
                        Intent intent = new Intent(getContext(), KitInfoDetails.class);
                        intent.putExtra("kit_info", (Serializable) details);
                        startActivity(intent);
                    }
                });

                recyclerView2 = view.findViewById(R.id.lvRecyclerview2);
                recyclerView2.setLayoutManager(layoutManager);
                recyclerView2.setAdapter(adapterRecycleview);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

        return view;
    }

}