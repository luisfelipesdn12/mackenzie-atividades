package financeiro;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Teste {
	
	public static void main(String args[]) {
		System.out.println("------ read -----");
		read();
		System.out.println("------ create -----");
		try {
			create();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("------ read -----");
		read();
	}
	
	public static void create() throws Exception{
		String url = "jdbc:postgresql://aws-0-us-west-1.pooler.supabase.com:6543/postgres";
		String username="postgres.fjlshsclsuaqsconvfqx";
		String password="MyZgMuX3qUY0p86S";
		
		Connection con = DriverManager.getConnection(url,username,password);
		String sql = "INSERT INTO CONTAS VALUES (?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		long conta = 125;
		Double saldo = 1000.00;
		for(int i =0; i<100; i++) {
			pstmt.setLong(1, conta++);
			pstmt.setBigDecimal(2, new BigDecimal(saldo +=i));
			pstmt.executeUpdate();
		}
		
		//int resp = pstmt.executeUpdate();
		//System.out.println("Linhas alteradas "+resp);
	}
	
	public static void read() {
		try {
			String url = "jdbc:postgresql://aws-0-us-west-1.pooler.supabase.com:6543/postgres";
			String username="postgres.fjlshsclsuaqsconvfqx";
			String password="MyZgMuX3qUY0p86S";
			
			Connection con = DriverManager.getConnection(url,username,password);
			String sql = "SELECT * FROM CONTAS";
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				long nro = rs.getLong(1);
				BigDecimal saldo = rs.getBigDecimal(2);
				System.out.println(nro +" - "+saldo);
			}
			
			con.close();
		}catch(Exception ex ) {
			ex.printStackTrace();
		}
	}

}
