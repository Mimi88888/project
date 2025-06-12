package DB;

public class Test {

    public static void main(String[] args){
        EtudiantManager EM =new EtudiantManager();
        EM.insertEtudiant(41,"MIMI","MEL",12.3);
        EM.afficherEtudiant();
    }
}
