package financeiro.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import financeiro.model.Conta;

public abstract class DAO <T extends Object>{
    private String url = "jdbc:postgresql://aws-0-us-west-1.pooler.supabase.com:6543/postgres";
    private String username="postgres.akvsavdrasxcvbaswddc";
    private String password="AydgMuX3qUY0p86S";
    protected Connection con;

    protected void init() throws SQLException{
		this.con = DriverManager.getConnection(url,username,password);
    }
    public abstract T create(T obj);
    public abstract T busca(int numero);
    public abstract void delete(int numero);
    public abstract List<T> buscaTudo();
}
