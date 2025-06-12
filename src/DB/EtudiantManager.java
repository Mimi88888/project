package DB;

import java.sql.*;

public class EtudiantManager {

    Connection con = null;
    static Statement st = null;

    EtudiantManager() {
        //Mount Driver
        try {
            Class.forName(Config.DRIVER_NAME);
            System.out.println("Driver OK!");
        } catch (ClassNotFoundException e) {
            System.out.println("Erreur Driver :" + e.getMessage());
        }

        //connection a la base
         //getConnection(Config.URL_DB,Config.USERNAME)
        try {
            Connection con = DriverManager.getConnection(Config.URL_DB);
            st = con.createStatement();
            System.out.println("Connected to the DB Successfully");
        } catch (SQLException e) {
            System.out.println("Could not connect to database specified !");
        }

    }

    int insertEtudiant(int cin,String nom, String prenom, double moyenne){
        String req_insert ="insert into etudiant values (?,?,?,?)";

        if(con ==null) return 0;
        PreparedStatement ps = null;
        try{
            ps=con.prepareStatement(req_insert);
            ps.setInt(1,cin);
            ps.setString(2,nom);
            ps.setString(3,prenom);
            ps.setDouble(4,moyenne);
             return ps.executeUpdate();

        }catch(SQLException e){
            return 0;
        }
    }

    void afficherEtudiant(){
        if(st !=null){
            String req_selection = "select * from etudiant";
            try{
                ResultSet rs= st.executeQuery(req_selection);
                ResultSetMetaData rsmd = rs.getMetaData();
                int columnWidth =rsmd.getColumnCount();
                for (int i =0; i< columnWidth; i++){
                    System.out.println(rsmd.getColumnName(i+1)+"\t");
                }
                System.out.println();
                System.out.println("===================");
                while( rs.next()){
                    for(int i=0;i< columnWidth; i++){
                        System.out.println(rs.getObject(i+1) + "\t");

                    }
                    System.out.println();
                }
            } catch( SQLException e){
                System.out.println("Error printing out");
            }
        }
    }

    public ResultSet selectEtudiant(){
        String req_selection ="select * from etudiant";
        try {
            ResultSet rs =this.st.executeQuery(req_selection);
             return rs;
        } catch(SQLException e) {
            System.out.println("Error getting result set");
        }
    return null;
    }
    void supprimerEtudiant(int cin){
        String req_delete= "delete from etudiant"+ "where e.cin= ?;";
        if( con ==null) return;
        PreparedStatement ps=null;
        try{
            ps= con.prepareStatement(req_delete);
            ps.setInt(1,cin);
            ps.executeUpdate();

        } catch(SQLException e){ return; }

    }
    //ajouter les zones de saisie partie south pour la recherche de l'etudiant selon le nom ou le prenom (keylistner )
    //class externe pour tout les actions
   //click droite jTable (button supprimer )
    //modifier dans la base de données
    // ajouter  gestionEtudiant dans  le frame bureau
    void modifierEtudiant(int cin,String name, String surname,double score ){
        String req_modify="update etudiant "+ "set name= ?, surname= ?, score =? where cin= ?;";
        if( con ==null) return;
        PreparedStatement ps=null;
        try{
            ps= con.prepareStatement(req_modify);

            ps.setString(1,name);
            ps.setString(2,surname);
            ps.setDouble(3,score);
            ps.setInt(4,cin);

            ps.executeUpdate();

        } catch(SQLException e){ return; }
    }
}

