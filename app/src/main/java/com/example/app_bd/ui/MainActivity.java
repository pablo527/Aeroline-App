package com.example.app_bd.ui;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.example.app_bd.R;
import com.example.app_bd.crud.CRUDFlight;
import com.example.app_bd.model.Flight;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Flight> listFlights=new ArrayList<>();
    ListView listView;
    ArrayList<String> listaInformacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView= findViewById(R.id.listView);

        listFlights();

        ArrayAdapter adaptador=new ArrayAdapter(this,android.R.layout.simple_list_item_1,listaInformacion);
        listView.setAdapter(adaptador);

        FloatingActionButton fab = findViewById(R.id.fabe);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (view.getContext(), FlightForm.class);
                startActivityForResult(intent, 0);
                startActivity(intent);
            }
        });

    }

    public void listFlights(){

        Flight flight=null;
        listFlights= new ArrayList<Flight>();
        List<Flight> flights = CRUDFlight.getAllFlights();
        for (Flight flight1 : flights){
            flight = new Flight();
            flight.setId(flight1.getId());
            flight.setName(flight1.getName());
            flight.setPrice(flight1.getPrice());
            listFlights.add(flight);
        }
        getlist();
    }
    private void getlist() {
        listaInformacion=new ArrayList<String>();

        for (int i=0; i<listFlights.size();i++){
            listaInformacion.add(listFlights.get(i).getId()+" - "
                    +listFlights.get(i).getName() + " - " + listFlights.get(i).getPrice());
        }
    }
}