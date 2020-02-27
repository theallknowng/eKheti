package com.example.cropad;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;

import java.util.ArrayList;

public class expertadvice extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<expertdata> expertdataList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expertadvice);
        recyclerView = findViewById(R.id.expert_advice_recyclerview);

        expertdataList = new ArrayList<>();
        expertdataList.add(new expertdata("T. Kuhu", "Coupling crop","https://www.sciencedirect.com/science/article/pii/S0308521X19303257"));
        expertdataList.add(new expertdata("Andrew P. Smith", "Whole farm implications of lucerne transitions in temperate crop-livestock systems","https://www.sciencedirect.com/science/article/pii/S0308521X18300222"));
        expertdataList.add(new expertdata("Loksatta", "Sendriya Sheti","https://www.loksatta.com/lokshivar-news/marathi-articles-on-introduction-to-organic-farming-1507444/"));
        expertdataList.add(new expertdata("M.S Allahyari", "Precision Agriculture","https://www.sciencedirect.com/science/article/pii/S2214317316300397"));
        expertdataList.add(new expertdata("Economic Times", "Self Marketing","https://economictimes.indiatimes.com/news/economy/agriculture/agriculture-experts-call-on-farmers-to-focus-on-self-marketing/articleshow/58660917.cms"));
        expertdataList.add(new expertdata("Mr. Rajiv Ahuja", "Basic Agriculture","https://www.google.com/url?sa=t&rct=j&q=&esrc=s&source=web&cd=15&ved=2ahUKEwidwuLc6OvnAhWoxzgGHZAnBSoQFjAOegQIBBAB&url=https%3A%2F%2Fwww.manage.gov.in%2Fpublications%2Ffarmerbook.pdf&usg=AOvVaw1ongbEpgeX_Q2KsXvBMe5y"));
        expertdataList.add(new expertdata("Mr. Devinder Sharma", "Farmer's Income","https://www.bhaskar.com/news/ABH-LCL-agricultural-expert-devinder-sharma-article-over-farmers-income-5797350-NOR.html"));
        expertdataList.add(new expertdata("A. Eitzinger", "GeoFarmer","https://www.google.com/url?sa=t&rct=j&q=&esrc=s&source=web&cd=19&cad=rja&uact=8&ved=2ahUKEwidwuLc6OvnAhWoxzgGHZAnBSoQFjASegQIBhAB&url=https%3A%2F%2Fwww.ncbi.nlm.nih.gov%2Fpmc%2Farticles%2FPMC6472546%2F&usg=AOvVaw0_tD8CCbf16U5aFAcnTvtT"));
        expertdataList.add(new expertdata("S.J Dundon", "Agricultural Ethics","https://www.google.com/url?sa=t&rct=j&q=&esrc=s&source=web&cd=15&cad=rja&uact=8&ved=2ahUKEwil4Nnt6evnAhXEyzgGHR2RCBw4ChAWMAR6BAgKEAE&url=https%3A%2F%2Fwww.ncbi.nlm.nih.gov%2Fpmc%2Farticles%2FPMC523869%2F&usg=AOvVaw3oJFJofim_3sNivn8C6-bD"));
        expertdataList.add(new expertdata("B A Wood", "Agricultural Science","https://www.google.com/url?sa=t&rct=j&q=&esrc=s&source=web&cd=13&cad=rja&uact=8&ved=2ahUKEwil4Nnt6evnAhXEyzgGHR2RCBw4ChAWMAJ6BAgDEAE&url=https%3A%2F%2Fjournals.plos.org%2Fplosone%2Farticle%3Fid%3D10.1371%2Fjournal.pone.0105203&usg=AOvVaw21Ub9zs2uzGODa7sfzBHGG"));


        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        RecyclerView.LayoutManager layoutManager1 = layoutManager;
        ExpertAdapter adapter = new ExpertAdapter(getApplicationContext(), expertdataList);

        recyclerView.setLayoutManager(layoutManager1);
        recyclerView.setAdapter(adapter);

    }
}
