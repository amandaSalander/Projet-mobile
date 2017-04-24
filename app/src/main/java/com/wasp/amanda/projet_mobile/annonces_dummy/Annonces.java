package com.wasp.amanda.projet_mobile.annonces_dummy;

import java.io.Serializable;
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
//        for (int i = 1; i <= COUNT; i++) {
//            addItem(createAnnoncesItem(i));
//        }

        /** 1ere annonce Appartement */
        AnnoncesItem annoncesItem= new AnnoncesItem(
                "1",
                4,
                1024,
                40000,
                "Annaba",
                "Appartement",
                "Cite 08 Mars, Annaba, Annaba",
                "Fethi Berrah",
                "Annonces immobiliere Carthage offre pour locaion un F3 a cite 08 Mars residence" +
                        "Fatma d'une superficie de 95 m2 au 4eme etage avec ascenseur, bien amenager" +
                        "pres de tout les commerces",
                makeImages(1),
                "Location",
                95
        );

        ANNONCES.add(annoncesItem);
        ITEM_MAP.put(annoncesItem.id, annoncesItem);

        /** TODO: add number of rooms*/
        /** TODO: add date of announce*/
        /** Fin 1ere annonce*/


        /** 2ere annonce Appartement */
        annoncesItem= new AnnoncesItem(
                "2",
                5,
                758,
                300000,
                "Alger",
                "Appartement",
                "Presidence Ben Aknoun, Alger",
                "Nesrine Zibani",
                "Appartement de 120m2 avec cuisine equipee en open-space meubles composee" +
                        "de 3 chambres situes dans un quartier calme et securise, acces autoroute" +
                        "imediat",
                makeImages(2),
                "Location",
                120
        );

        ANNONCES.add(annoncesItem);
        ITEM_MAP.put(annoncesItem.id, annoncesItem);

        /** Fin 2eme annonce*/

        /** 3eme annonce Appartement */
        annoncesItem= new AnnoncesItem(
                "3",
                4,
                75,
                25000,
                "Tizi ouzou",
                "Appartement",
                "Boulevard Krim Belkacem, Tizi ouzou",
                "Tassaadit Nait Belkacem",
                "Cabinet de gestion immobiliere met en location un F4 situe au 2eme etage" +
                        "en toutes commodites.Sis au Boulevard Krim BelKacem, Tizi ouzou",
                makeImages(3),
                "Location",
                101
        );

        ANNONCES.add(annoncesItem);
        ITEM_MAP.put(annoncesItem.id, annoncesItem);

        /** Fin 3eme annonce*/

        /** 4eme annonce Appartement */
        annoncesItem= new AnnoncesItem(
                "4",
                2,
                8,
                120000,
                "Tlemcen",
                "Appartement",
                "Kiffan, Tlemcen",
                "Kader Tlemceni",
                "J'ai un appartement 160 m, usage habitation avec + un garage 160 usage" +
                        "commercial bien amenager, plein centre ville de Tlemcen",
                makeImages(4),
                "Location",
                160
        );

        ANNONCES.add(annoncesItem);
        ITEM_MAP.put(annoncesItem.id, annoncesItem);

        /** Fin 4eme annonce*/

        /** 5eme annonce Appartement */
        annoncesItem= new AnnoncesItem(
                "5",
                3,
                81,
                35000,
                "Oran",
                "Appartement",
                "Bie el Adjir Akid Lotfi, Oran",
                "Badro GTI",
                "je suis Badro, je mets en location mon 3eme appartement,F4 situe dans quartier" +
                        "Akid Lotfi, bien amenage, au 5eme etage avec ascenseur , contacter moi s'il vous plait",
                makeImages(5),
                "Location",
                80
        );

        ANNONCES.add(annoncesItem);
        ITEM_MAP.put(annoncesItem.id, annoncesItem);

        /** Fin 5eme annonce*/


        /** 1ere annonce Villa */
        annoncesItem= new AnnoncesItem(
                "6",
                4,
                28,
                500000,
                "Annaba",
                "Villa",
                "rue Kouba, Annaba, Annaba",
                "Mechri Maria",
                "Une grande villa avec un jardin et 3 locaux commerciaux, bien situes dans un endroit tres securises" +
                        "a cote du Messe Militaire a 100 de la plage Sait-Cloud, ayant une belle terasse avec une vue" +
                        "sur la plage Saint Cloud, un jardin menu d'une fontaine, un Hammam et 2 entrees principale" +
                        "et une entrees secondaire, les locaux sont spatiaux",
                makeImages(6),
                "Location",
                500
        );

        ANNONCES.add(annoncesItem);
        ITEM_MAP.put(annoncesItem.id, annoncesItem);

        /** Fin 1ere annonce*/


        /** 2eme annonce Villa */
        annoncesItem= new AnnoncesItem(
                "7",
                3,
                12,
                950000,
                "Alger",
                "Villa",
                "Poirsson, El Biar, Alger",
                "Yassine Hani",
                "Villa meubles, terrain, 850m2 surface habitable 500m2, R+1, garage jardin piscine, toutes" +
                        "commoditees",
                makeImages(7),
                "Location",
                850
        );

        ANNONCES.add(annoncesItem);
        ITEM_MAP.put(annoncesItem.id, annoncesItem);

        /** Fin 2eme annonce*/

        /** 3eme annonce Villa */
        annoncesItem= new AnnoncesItem(
                "8",
                5,
                999,
                40000,
                "Tizi ouzou",
                "Villa",
                "Sidi Khaled, Tigzirt, Tizi ouzou",
                "Baraka Sylia",
                "Location vacance pour l'ete 2017, Villa R+1 et sous-sol, grande terasse, bien equipes" +
                        "a Sidi Khaled, endroit calme a 5 minutes de Tigizirt toutes commodites avec eau h24" +
                        ".",
                makeImages(8),
                "Location",
                160
        );

        ANNONCES.add(annoncesItem);
        ITEM_MAP.put(annoncesItem.id, annoncesItem);

        /** Fin 3eme annonce*/


        /** 4eme annonce Villa */
        annoncesItem= new AnnoncesItem(
                "9",
                1,
                17,
                100000,
                "Tlemcen",
                "Villa",
                "Ghazaouet, Tlemcen",
                "Meraoui Mourad Bouyouf",
                "Mon equipe et moi meme seront tres heureux de vous accueuillir dans cette villa equipes" +
                        "de tout confort, une piscine, salle de sport, Ville cotiere plage tres proche, commerce" +
                        "de proximite, avec prise en charge lors du sejour" ,
                makeImages(9),
                "Location",
                180
        );

        ANNONCES.add(annoncesItem);
        ITEM_MAP.put(annoncesItem.id, annoncesItem);

        /** Fin 4eme annonce*/

        /** 5eme annonce Villa */
        annoncesItem= new AnnoncesItem(
                "10",
                4,
                25,
                120000,
                "Oran",
                "Villa",
                "Bel, air, Oran",
                "Jugurtha Ben Smail",
                "Villa en plein cente d'oran affaire residentiel, tres bien placer a bel air, ente la" +
                        "wilaya et centre Ville Gambette, et l'hypdrome dispose d'un grand jardin et un local " +
                        "apart de 40m2 commercial" ,
                makeImages(10),
                "Location",
                500
        );

        ANNONCES.add(annoncesItem);
        ITEM_MAP.put(annoncesItem.id, annoncesItem);

        /** Fin 5eme annonce*/

        /** 1ere annonce Studio */
        annoncesItem= new AnnoncesItem(
                "11",
                3,
                116,
                120000,
                "Annaba",
                "Studio",
                "Zaafrania, residence Naoures",
                "Adel Meflous",
                "Location Studio F1, meubles et equipes situes a residence naoures 50m2 en souplex bien" +
                        "amenages dans un endroit calme cite clotures garder avec acte pour 40000DZD" +
                        "par mois" ,
                makeImages(11),
                "Location",
                50
        );

        ANNONCES.add(annoncesItem);
        ITEM_MAP.put(annoncesItem.id, annoncesItem);

        /** Fin 1ereannonce*/

        /** 2eme annonce Studio */
        annoncesItem= new AnnoncesItem(
                "12",
                3,
                684,
                3500,
                "Alger",
                "Studio",
                "Beni Messous 49, 1er Mai, Alger",
                "Amina Sebaia",
                "cygnes appart Hotel vous propose la location par jour ou par semaine des studios luxueux" +
                        "avec balcons, salons spacieux tout confort, television ecran plat, climatisation" +
                        "internet...etc." ,
                makeImages(12),
                "Location",
                40
        );

        ANNONCES.add(annoncesItem);
        ITEM_MAP.put(annoncesItem.id, annoncesItem);

        /** Fin 2eme annonce*/


        /** 3eme annonce Studio */
        annoncesItem= new AnnoncesItem(
                "13",
                4,
                1856,
                30000,
                "Tizi ouzou",
                "Studio",
                "Centre Ville,ancienne Ville, Tizi ouzou",
                "Nabali Mazari",
                "Tres beau studio bien fini et bien equiper dans une belle residance securisee au centre ville" ,
                makeImages(13),
                "Location",
                30
        );

        ANNONCES.add(annoncesItem);
        ITEM_MAP.put(annoncesItem.id, annoncesItem);

        /** Fin 3eme annonce*/

        /** 4eme annonce Studio */
        annoncesItem= new AnnoncesItem(
                "14",
                4,
                1063,
                4000,
                "Tlemcen",
                "Studio",
                "Marsa Ben Mhedi,Centre Ville, Tlemcen",
                "Hassen Elaacher",
                "propmotion pour l'ete 2017 bien meubles et cuisine equipees, et venait visiter je suis tres accueillant" ,
                makeImages(14),
                "Location",
                30
        );

        ANNONCES.add(annoncesItem);
        ITEM_MAP.put(annoncesItem.id, annoncesItem);

        /** Fin 4eme annonce*/


        /** 5eme annonce Studio */
        annoncesItem= new AnnoncesItem(
                "15",
                4,
                36,
                25000,
                "Oran",
                "Studio",
                "Boulevard Marssou",
                "Riad Bechket",
                "je mets en location studio meubles, chambre a coucher avec un petit salon equipes (chauffage, chauffe bain, wifi" +
                        "une annee gratuite" ,
                makeImages(15),
                "Location",
                55
        );

        ANNONCES.add(annoncesItem);
        ITEM_MAP.put(annoncesItem.id, annoncesItem);

        /** Fin 5eme annonce*/

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
                                    "Vente",
                                    103
                                    );
    }


    public static String makeDetail(int position){
        return "I am the detail of the annonces "+ position+" you can feel free to contact me " +
                "at my phone number 066357022, all the houses are mine X) I  will not give a damn of " +
                "one cents to you.....my email ds_baraka@esi.dz :) have a nice day ";
    }

    public static List<Integer> makeImages(int position){
        List<Integer> a= new ArrayList<Integer>();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        return a;
    }

    public  static class AnnoncesItem implements Serializable{
            public final String id;
            public final int stars;
            public final int views;
            public final int price;
            public final  String region;
            public final String types;
            public final String address;
            public final String propretaire;
            public final String detail;
            public final List<Integer> images = new ArrayList<Integer>();
            public final String typeAnnonce;
            public final int superficie;



        public AnnoncesItem(String id, int stars, int views, int price, String region, String types,
                            String address, String propretaire, String detail, List<Integer> integers,
                            String typeAnnonce, int superficie) {
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
            this.superficie= superficie;
        }
        @Override
        public String toString() {
            return detail;
        }
    }
}


