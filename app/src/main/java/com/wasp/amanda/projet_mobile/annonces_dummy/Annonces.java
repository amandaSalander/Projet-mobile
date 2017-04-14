package com.wasp.amanda.projet_mobile.annonces_dummy;

import com.wasp.amanda.projet_mobile.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by amanda on 01/04/17.
 */

public class Annonces {

    public static final List<AnnoncesItem>  ANNONCES = new ArrayList<AnnoncesItem>();

    public static final Map<String, AnnoncesItem> ITEM_MAP = new HashMap<String, AnnoncesItem>();
    private static final int COUNT = 25;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createAnnoncesItem(i));
        }
    }

    private static void addItem(AnnoncesItem item) {
        ANNONCES.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static AnnoncesItem createAnnoncesItem(int position) {
        return new AnnoncesItem(String.valueOf(position),3,
                                    104,
                                    25930,
                                    "Boumerdes",
                                    "Appartement",
                                    "Frantz Fanon, Boumerdes",
                                    "Amanda, ds_baraka@esi.dz",
                                    makeDetail(position),
                                    makeImages(position),
                                    "Vente"
                                    );
    }


    public static String makeDetail(int position){
        return "I am the detail of the annonces "+ position+" you can feel free to contact me " +
                "at my phone number 066357022, all the houses are mine X) I  will not give a damn of " +
                "one cents to you.....my email ds_baraka@esi.dz :) have a nice day ";
    }

    public static List<Integer> makeImages(int position){
        List<Integer> a= new ArrayList<Integer>();
        a.add(R.drawable.annonces_1);
        a.add(2);
        a.add(3);
        a.add(4);
        return a;
    }

    public  static class AnnoncesItem{
            public final String id;
            public final int stars;
            public final int views;
            public final int price;
            public  final  String region;
            public final String types;
            public  final String address;
            public final String propretaire;
            public final String detail;
            public final List<Integer> images = new ArrayList<Integer>();
            public  final String typeAnnonce;



        public AnnoncesItem(String id, int stars, int views, int price, String region, String types,
                            String address, String propretaire, String detail, List<Integer> integers, String typeAnnonce) {
            this.id = id;
            this.stars = stars;
            this.views = views;
            this.price = price;
            this.region = region;
            this.types = types;
            this.address = address;
            this.propretaire = propretaire;
            this.detail = detail;
            this.typeAnnonce= typeAnnonce;
        }
        @Override
        public String toString() {
            return detail;
        }
    }
}


