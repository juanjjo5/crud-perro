package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class RicoDAO {

    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    Rico r;

    Conexion conectar = new Conexion();

    public List listar() {
        List<Rico> datos = new ArrayList<>();
        try {
            con = conectar.getConnection();

            r = new Rico();
            ps = con.prepareStatement("select * from rico");
            rs = ps.executeQuery();
            r.setNombre(rs.getString(1));
            r.setEdad(rs.getInt(2));
            r.setOrigen(rs.getString(3));
            r.setFortuna(4);
            datos.add(r);

        } catch (Exception e) {
            System.out.println(e);
        }
        return datos;

    }

    public int agregar(Rico r) {
        int a = 0;
        String sql = "insert into rico (nombre,edad,origen,fortuna) value (?,?,?,?)";
        try {
            con = conectar.getConnection();

            ps = con.prepareStatement(sql);
            ps.setString(1, r.getNombre());
            ps.setInt(2, r.getEdad());
            ps.setString(3, r.getOrigen());
            ps.setDouble(4, r.getFortuna());
            a = ps.executeUpdate();
            if (a == 1) {
                return 1;
            } else {
                return 0;
            }
        } catch (Exception e) {
            System.out.println("e");
        }
        return a;
    }

    public int actualizar(Rico r) {
        int a = 0;
        String sql = "update rico  vset nombre=?,edad=?,origen=?,fortuna=? where id=?";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, r.getNombre());
            ps.setInt(2, r.getEdad());
            ps.setString(3, r.getOrigen());
            ps.setDouble(4, r.getFortuna());
            a=ps.executeUpdate();
             if (a == 1) {
                return 1;
            } else {
                return 0;
            }
            
    
        } catch (Exception e) {
            System.out.println(e);
        }
        return a;
    }
    public int delete(int  id){
    int a=0;
    String sql="delete form rico where id="+id;
    try{
        con=conectar.getConnection();
        ps=con.prepareStatement(sql);
        a=ps.executeUpdate();
         if (a == 1) {
                return 1;
            } else {
                return 0;
            }
        
    }catch(Exception e){
        System.out.println(e);
    }
    return a;
    

}

}
