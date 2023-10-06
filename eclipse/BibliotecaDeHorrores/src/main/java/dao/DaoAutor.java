package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import conexion.Conexion;
import entidades.Autor;

public class DaoAutor {
    public DaoAutor() {
        
    }
    
    public ArrayList<Autor> ListadoAutores() throws SQLException, Exception {
        ArrayList<Autor> listadoAutores = new ArrayList<>();
        Conexion conexion = new Conexion();
        Connection con = null;
        ResultSet rs = null;
        Statement st = null;
        
        try {
            con = conexion.getConexion();
            st = con.createStatement();
            String orderSQL = "SELECT * FROM AUTOR ORDER BY NOMBRE";
            rs = st.executeQuery(orderSQL);
            
            while (rs.next()) {
                Autor miAutor = new Autor();
                miAutor.setIdautor(rs.getInt("IDAUTOR"));
                miAutor.setNombre(rs.getString("NOMBRE"));
                //miAutor.setFechanacimiento(rs.getObject("FECHANACIMIENTO", LocalDate.class));
             
                miAutor.setFechanacimiento(rs.getDate("FECHANACIMIENTO"));

                listadoAutores.add(miAutor);
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            throw sqle;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (st != null) {
                st.close();
            }
            if (con != null) {
                con.close();
            }
        }
        
        return listadoAutores;
    }
    
    public Autor findAutorById(int idautor) throws SQLException, Exception {
        Autor a = null;
        Conexion conexion = new Conexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = null;
        
        try {
            conn = conexion.getConexion();
            String orderSQL = "SELECT IDAUTOR, NOMBRE, FECHANACIMIENTO FROM AUTOR WHERE IDAUTOR=?";
            ps = conn.prepareStatement(orderSQL);
            ps.setInt(1, idautor);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                a = new Autor();
                a.setIdautor(rs.getInt("IDAUTOR"));
                a.setNombre(rs.getString("NOMBRE"));
                a.setFechanacimiento(rs.getDate("FECHANACIMIENTO"));
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            throw sqle;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        
        return a;
    }
    
    public void update(Autor a) {
        Conexion conexion = new Conexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = null;
        
        try {
            try {
				con = conexion.getConexion();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            con.setAutoCommit(false);
            
            String orderSQL = "UPDATE AUTOR SET NOMBRE = ?, FECHANACIMIENTO = ? WHERE IDAUTOR = ?";
            PreparedStatement preparedStatement = con.prepareStatement(orderSQL);
            
            preparedStatement.setString(1, a.getNombre());
            preparedStatement.setObject(2, a.getFechanacimiento());
            preparedStatement.setInt(3, a.getIdautor());
            
            int filasAfectadas = preparedStatement.executeUpdate();
            
            if (filasAfectadas > 0) {
                con.commit();
            } else {
                con.rollback();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                if (con != null) {
                    con.rollback();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            try {
                if (con != null) {
                    con.setAutoCommit(true);
                    con.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public void añadirautor(Autor a) {
        Conexion conexion = new Conexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = null;
        
        try {
            try {
				con = conexion.getConexion();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            con.setAutoCommit(false);
            
            String orderSQL = "UPDATE AUTOR SET NOMBRE = ?, FECHANACIMIENTO = ? WHERE IDAUTOR = ?";
            PreparedStatement preparedStatement = con.prepareStatement(orderSQL);
            
            preparedStatement.setString(1, a.getNombre());
            preparedStatement.setObject(2, a.getFechanacimiento());
            preparedStatement.setInt(3, a.getIdautor());
            
            int filasAfectadas = preparedStatement.executeUpdate();
            
            if (filasAfectadas > 0) {
                con.commit();
            } else {
                con.rollback();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                if (con != null) {
                    con.rollback();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            try {
                if (con != null) {
                    con.setAutoCommit(true);
                    con.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public static void agregarAutor(Autor autor) throws SQLException, Exception {
        Conexion conexion = new Conexion();
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = conexion.getConexion();
            String insertSQL = "INSERT INTO AUTOR (IDAUTOR, NOMBRE, FECHANACIMIENTO) VALUES (?, ?, ?)";
            ps = con.prepareStatement(insertSQL);
            ps.setInt(1, autor.getIdautor());
            ps.setString(2, autor.getNombre());
            ps.setDate(3, autor.getFechanacimiento());
            
            int rowCount = ps.executeUpdate();
            if (rowCount > 0) {
                System.out.println("El autor ha sido agregado con éxito a la base de datos.");
            } else {
                System.out.println("No se pudo agregar el autor a la base de datos.");
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            throw sqle;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }
    
}
