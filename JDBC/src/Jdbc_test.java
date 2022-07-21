import java.sql.*;

public class Jdbc_test {

    public static void main(String[] args)throws Exception {

        Class.forName("com.mysql.jdbc.Driver");//反射jar包
        String url="jdbc:mysql:///student";//数据库所在地址后面可以写ip地址可以加三个参数
        String username="root";
        String password="Ling002688ling.";
        Connection connection=DriverManager.getConnection(url,username,password);//创建连接驱动


        Statement statement=connection.createStatement();//创建sql对象

        String u3="UPDATE stu SET brithy='2001-12-01' WHERE users=? ";
        PreparedStatement preparedStatement=connection.prepareStatement(u3);

        String user="王五";
        String pod="105";


        connection.setAutoCommit(false);

        String u2="SELECT * FROM stu WHERE users='"+user+"' and passwords='"+pod+"'";
        ResultSet resultSet1=statement.executeQuery(u2);
        while (resultSet1.next()){
            System.out.println(resultSet1.getInt(3));
            System.out.println(resultSet1.getString(1));
        }

        String u="UPDATE stu SET brithy = '2000-11-11' WHERE users='王五'";
        int count=statement.executeUpdate(u);//受影响行
        System.out.println(count);

        String u1="SELECT * FROM stu WHERE brithy='2000-11-06'";
        ResultSet resultSet=statement.executeQuery(u1);
        while (resultSet.next()){
            String s=resultSet.getString(1);
            System.out.println(s);
            int i=resultSet.getInt(3);
            System.out.println(i);
        }

        preparedStatement.setString(1,"王五");
        int count1=preparedStatement.executeUpdate();
        System.out.println(count1);

        connection.commit();
        connection.rollback();
        statement.close();//释放资源
        connection.close();
    }
}
