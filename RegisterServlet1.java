import java.util.*;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class RegisterServlet1 extends HttpServlet{
 public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException,ServletException{
 res.setContentType("text/html");
 PrintWriter pw=res.getWriter();
 String name=req.getParameter("name");
 String email=req.getParameter("email");
 String college=req.getParameter("college");
 String phone=req.getParameter("phone");
 try{
 Class.forName("com.mysql.jdbc.Driver");
 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/festdb?useSSL=false","root","1234");
 String q="insert into fest1(name,email,college,phone)values(?,?,?,?)";
 PreparedStatement stm=con.prepareStatement(q);
 stm.setString(1,name);
 stm.setString(2,email);
 stm.setString(3,college);
 stm.setString(4,phone);
 int x=stm.executeUpdate();
 if(x>0){
 pw.println("SUCCESSFULL");
 }
 else{
 pw.println("sorry!try again");
 }
}
 catch(Exception e){
 pw.println(e.getMessage());
 }
 }
}