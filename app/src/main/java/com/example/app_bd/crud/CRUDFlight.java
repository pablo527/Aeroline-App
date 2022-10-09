package com.example.app_bd.crud;

import com.example.app_bd.model.Flight;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class CRUDFlight {

    static int calculateId(){
        Realm realm = Realm.getDefaultInstance();
        Number currentId = realm.where(Flight.class).max("id");
        int nextId;
        return nextId = (currentId==null) ? 0 : currentId.intValue() + 1;
    }

    public static void addFlight(Flight flight){
        try {
            Realm realm = Realm.getDefaultInstance();
            realm.beginTransaction();
            int id = CRUDFlight.calculateId();
            Flight realmFlight = realm.createObject(Flight.class, id);
            realmFlight.setName(flight.getName());
            realmFlight.setOrigin(flight.getOrigin());
            realmFlight.setDestiny(flight.getDestiny());
            realmFlight.setPrice(flight.getPrice());
            realmFlight.setPlane(flight.getPlane());
            realm.commitTransaction();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public  static List<Flight> getAllFlights(){
        Realm realm = Realm.getDefaultInstance();
        RealmResults<Flight> flights = realm.where(Flight.class).findAll();
        return flights;
    }

    public static Flight findById(int id) {
        try {
            System.out.println("ID: " + id);
            Realm realm = Realm.getDefaultInstance();
            realm.beginTransaction();
            Flight flight = realm.where(Flight.class).equalTo("id", id).findFirst();
            System.out.printf("FLIGHT: " + String.valueOf(flight));
            if (flight != null){
                System.out.printf(flight.getName());
            }
            realm.commitTransaction();
            return flight;
        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static String deletedById(int id) {
        try {
            Realm realm = Realm.getDefaultInstance();
            realm.beginTransaction();
            Flight flight = realm.where(Flight.class).equalTo("id",id).findFirst();
            if (flight != null) {
                flight.deleteFromRealm();
                realm.commitTransaction();
                return "Deleted succesfull";
            }
            realm.commitTransaction();
            return "The flight not exits";
        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static Flight updateFlight(int id, Flight flightOld) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        Flight flight = realm.where(Flight.class).equalTo("id", id).findFirst();
        if (flight !=null){
            flight.setName(flightOld.getName());
            flight.setOrigin(flightOld.getOrigin());
            flight.setDestiny(flightOld.getDestiny());
            flight.setPrice(flightOld.getPrice());
            flight.setPlane(flightOld.getPlane());
            realm.insertOrUpdate(flight);
            realm.commitTransaction();
        }
        return flight;

    }
}
