package date;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class gorev_list {
    public gorev_list(){}
    public List<görevler> gorevler_list(){
        List<görevler> gorevler=new ArrayList<>();
        Connection baglanti=null;
        Statement ifade=null;
        ResultSet sonuc=null;
        try{
            baglanti=databasecon.database_run();
            String sgl="SELECT * FROM `gorevler`";
            ifade=baglanti.createStatement();
            sonuc=ifade.executeQuery(sgl);
            while (sonuc.next()){
                int id=sonuc.getInt("id");
                String gorev_adi=sonuc.getString("gorev_adi");
                String gorev_acıklama=sonuc.getString("gorev_acıklama");
                String gorev_dercesi=sonuc.getString("gorev_dercesi");
                String gorev_tarihi=sonuc.getString("gorev_tarihi");
                görevler gorev1=new görevler(id,gorev_adi,gorev_acıklama,gorev_dercesi,gorev_tarihi);
                gorevler.add(gorev1);

            }
            return gorevler;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }finally {
            kapat(baglanti,ifade,sonuc);
        }


    }

    private void kapat(Connection baglanti, Statement ifade, ResultSet sonuc) {
        try {
            if(sonuc!=null){
                sonuc.close();
            }
            if(ifade !=null){
                ifade .close();
            }
            if(baglanti!=null){
                baglanti .close();
            }



        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void gorevEkle(görevler gorev1) {
        Connection baglanti=null;
        PreparedStatement ifade=null;
        ResultSet sonuc=null;
        try {
            baglanti=databasecon.database_run();
            String Sgl="INSERT INTO `gorevler`( `gorev_adi`, `gorev_acıklama`, `gorev_dercesi`, `gorev_tarihi`) VALUES (?,?,?,?)";
            ifade=baglanti.prepareStatement(Sgl);
            ifade.setString(1,gorev1.getGorev_adi());
            ifade.setString(2,gorev1.getGorev_acıklama());
            ifade.setString(3,gorev1.getGorev_dercesi());
            ifade.setString(4,gorev1.getGorev_tarihi());
            ifade.execute();





        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void gorevSil(String gorevAdi) {
        Connection baglanti=null;
        PreparedStatement ifade=null;
        ResultSet sonuc=null;
        try {
            baglanti=databasecon.database_run();
            String Sgl="DELETE FROM gorevler WHERE `gorevler`.`gorev_adi` = ?";
            ifade=baglanti.prepareStatement(Sgl);
            ifade.setString(1,gorevAdi);
            ifade.execute();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public void gorev_guncele(String guncelncekAdi,  String gorevOnem, String gorevAcıklama, String yeniTarih) {
        Connection baglanti=null;
        PreparedStatement ifade=null;
        ResultSet sonuc=null;
        try{
            baglanti=databasecon.database_run();
            String Sgl="UPDATE `gorevler` Set `gorev_acıklama`=?,`gorev_dercesi`=?,`gorev_tarihi`=? WHERE gorev_adi=?";
            ifade=baglanti.prepareStatement(Sgl);
         //   ifade.setString(1,gorevAdi);
            ifade.setString(1,gorevAcıklama);
            ifade.setString(2,gorevOnem);
            ifade.setString(3,yeniTarih);
            ifade.setString(4,guncelncekAdi);//ulaışım şekli
            ifade.execute();




        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}



