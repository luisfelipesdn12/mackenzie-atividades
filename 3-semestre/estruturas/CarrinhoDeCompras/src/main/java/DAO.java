import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public abstract class DAO<T> {
    private final String url = "postgres://default:sy4bEjm6KrcY@ep-dry-star-a4n5i8cq.us-east-1.aws.neon.tech:5432/verceldb?sslmode=require";
    Connection con;

    public void init() throws SQLException {
        this.con = DriverManager.getConnection(url);
    }

    public abstract List<T> getAll() throws SQLException;
}
