package financeiro.dao;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import financeiro.model.Conta;

public class DaoConta extends DAO<Conta>{

    @Override
    public Conta create(Conta conta) {
        Conta aux = null;
        try {
            init();
            String sql = "INSERT INTO CONTAS VALUES (?,?)";
		    PreparedStatement pstmt = this.con.prepareStatement(sql);
		
            pstmt.setInt(1, conta.getNumero());
			pstmt.setBigDecimal(2, conta.getSaldo());
			pstmt.executeUpdate();
            aux = new Conta();
            aux.setNumero(conta.getNumero());
            aux.setSaldo(conta.getSaldo());
		
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            try {
                this.con.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        return aux;
        
    }

    @Override
    public Conta busca(int numero) {
        Conta retorno = new Conta();
        try{
            init();
            String sql = "SELECT * FROM CONTAS where numero =?";
                PreparedStatement pstmt = con.prepareStatement(sql);
                pstmt.setInt(1, numero);
                
                ResultSet rs = pstmt.executeQuery();
                
                if(rs.next()){
                    retorno.setNumero(rs.getInt(1));
                    retorno.setSaldo(rs.getBigDecimal(2));
                }
            }catch(Exception ex){
                ex.printStackTrace();
            }finally{
                try {
                    this.con.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            return retorno;
    }

    @Override
    public void delete(int numero) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public List<Conta> buscaTudo() {
        List<Conta> lista = new ArrayList<>(); 
        try{
            init();
            String sql = "SELECT * FROM CONTAS";
                PreparedStatement pstmt = con.prepareStatement(sql);
                
                ResultSet rs = pstmt.executeQuery();
                
                while(rs.next()){
                    Conta c = new Conta();
                    c.setNumero(rs.getInt(1));
                    c.setSaldo(rs.getBigDecimal(2));
                    lista.add(c);
                }
            }catch(Exception ex){
                ex.printStackTrace();
            }finally{
                try {
                    this.con.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            return lista;
    }

}
