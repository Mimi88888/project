package form;

import java.util.ArrayList;

public class Data {
     public static ArrayList<Profil>   data= new ArrayList<Profil>();

     public Data(){}

      public static Profil ProfilRechercheSelonPseudo(String Pseudo){

        for(Profil i: data)  {
           if(i.getPseudo().equalsIgnoreCase(Pseudo)){
           return i;}
        }
           return null;
     }


}
