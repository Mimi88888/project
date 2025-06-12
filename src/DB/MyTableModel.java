package DB;

import javax.swing.table.AbstractTableModel;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

public class MyTableModel extends AbstractTableModel {

    ArrayList<Object[]> data =new ArrayList<>();
    ResultSetMetaData rsmd;

    EtudiantManager manager;
    ResultSet rs;
    MyTableModel(ResultSet rs, EtudiantManager manger){
        try{
            rsmd= rs.getMetaData();
            this.rs = rs;
            this.manager =manager;
            while(this.rs.next()){
                Object[] login = new Object [rsmd.getColumnCount()];
                for(int i=0; i< rsmd.getColumnCount();i++){
                    login[i] =rs.getObject(i+1);
                }
                data.add(login);
            }
        }catch(SQLException e) { }
    }

    @Override
    public int getRowCount() {
        return 3;
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data.get(rowIndex) [columnIndex];
    }

    int ajouterEtudiant(int cin, String name, String surname,double score){
        int a=manager.insertEtudiant(cin,name, surname,score);
        if(a>0){
            data.add(new Object[]{cin,name,surname,score});
            fireTableDataChanged();
        }
        return a;
    }
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex){
        if(getColumnName(columnIndex).equalsIgnoreCase("score")){
            return true;
        }
            return false;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

    }

    public String getColumnName(int column) {
        try {
            return rsmd.getColumnName(column+1);
        } catch (SQLException e) {
            return null;
        }
    }
}
// ajouter les méthodes ajouter etudiant, supprimer et