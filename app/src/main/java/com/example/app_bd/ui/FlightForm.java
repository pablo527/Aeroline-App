package com.example.app_bd.ui;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.example.app_bd.R;
import com.example.app_bd.crud.CRUDFlight;
import com.example.app_bd.model.Flight;

public class FlightForm extends AppCompatActivity {

    private EditText txtId, txtName,txtOrigin,txtDestiny,txtPrice,txtPlane;
    private Button btnSave, btnDelete,btnUpdate, btnFind,btnReturn;
    private Flight flight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flight_form);
        configView();
    }

    private void configView(){
        flight = new Flight();
        txtId = findViewById(R.id.txtId);
        txtName= findViewById(R.id.txtName);
        txtOrigin = findViewById(R.id.txtOrigin);
        txtDestiny = findViewById(R.id.txtDestiny);
        txtPrice= findViewById(R.id.txtPrice);
        txtPlane = findViewById(R.id.txtPlane);

        btnSave = findViewById(R.id.btnSave);
        btnDelete = findViewById(R.id.btnDelete);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnFind = findViewById(R.id.btnFind);
        btnReturn = findViewById(R.id.btnReturn);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Flight flight = new Flight();
                try {
                    flight.setName(txtName.getText().toString());
                    flight.setOrigin(txtOrigin.getText().toString());
                    flight.setDestiny(txtDestiny.getText().toString());
                    flight.setPrice(txtPrice.getText().toString());
                    flight.setPlane(txtPlane.getText().toString());
                    CRUDFlight.addFlight(flight);
                } catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }
        });
        btnFind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    flight = CRUDFlight.findById(Integer.parseInt(txtId.getText().toString()));
                    if (flight != null){
                        txtName.setText(flight.getName());
                        txtOrigin.setText(flight.getOrigin());
                        txtDestiny.setText(flight.getDestiny());
                        txtPrice.setText(flight.getPrice());
                        txtPlane.setText(flight.getPlane());
                    }
                } catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    System.out.println(CRUDFlight.deletedById(Integer.parseInt(txtId.getText().toString())));
                }
                catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }
        });
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    int id = Integer.parseInt(txtId.getText().toString());
                    Flight flight = new Flight();
                    flight.setName(txtName.getText().toString());
                    flight.setOrigin(txtOrigin.getText().toString());
                    flight.setDestiny(txtDestiny.getText().toString());
                    flight.setPrice(txtPrice.getText().toString());
                    flight.setPlane(txtPlane.getText().toString());
                    CRUDFlight.updateFlight(id,flight);
                } catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }
        });
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });
    }
}