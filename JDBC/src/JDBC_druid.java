import com.alibaba.druid.pool.DruidDataSourceFactory;
import javax.sql.DataSource;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Properties;

public class JDBC_druid {
    public static void main(String[] args)throws Exception {

        System.out.println(System.getProperty("user.dir"));//返回项目路径

        Properties properties=new Properties();
        properties.load(Files.newInputStream(Paths.get("src\\druid_file.properties")));//配置文件的登录地址是项目地址加上这里的索引地址
        DataSource dataSource= DruidDataSourceFactory.createDataSource(properties);
        Connection connection= dataSource.getConnection();

        String u="UPDATE stu SET id=122 WHERE users=?";
        PreparedStatement preparedStatement= connection.prepareStatement(u);
        preparedStatement.setString(1,"王五");
        preparedStatement.executeUpdate();

        String u1="UPDATE stu SET id=121 WHERE users='李四'";
        Statement statement=connection.createStatement();
        statement.executeUpdate(u1);
    }
}
