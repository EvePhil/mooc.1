package com.rua.usercontroller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.*;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;

import model.Grade;
import model.Group;
import model.HibernateUtil;
import model.User;
import model.tmp;
import net.sf.json.JSONObject;
import net.sf.jxls.reader.ReaderBuilder;
import net.sf.jxls.reader.XLSReader;
import net.sf.jxls.transformer.Workbook;
import net.sf.jxls.transformer.XLSTransformer;

@Controller
public class xlsController {
	@RequestMapping(value="/a")
	public void test(){
		//exportUserXls("E:\\workspace\\mooc.1\\z.xls",getAllUser());
		//importUserXls("E:\\workspace\\mooc.1\\i.xls");

		//exportGradeXls("E:\\workspace\\mooc.1\\z1.xls",getAllGrade());
		//importGradeXls("E:\\workspace\\mooc.1\\i1.xls");
	}
	public void exportUserXls(HttpServletRequest request,HttpServletResponse response){//String path,List<User> list
		String path=request.getParameter("path");
		List<User> list=getAllUser();
		//List<User> user = new ArrayList<User>();
        Map<String,Object> beans = new HashMap<String,Object>();
        beans.put("User", list);
        XLSTransformer transformer = new XLSTransformer();
        try {
			transformer.transformXLS("E:\\workspace\\mooc.1\\User_template.xls", beans, path);//template.xls为输出xls的模版，待修改
		} catch (Exception e) {
			e.printStackTrace();
		} 

	}
	
	public void exportGradeTemplate(HttpServletRequest request,HttpServletResponse response){//String path,int course_id,List<User> user
		String path=request.getParameter("path");
		int course_id=Integer.parseInt(request.getParameter("course_id"));
		Session session=HibernateUtil.openSession();
		session.beginTransaction();
		List<Group> user=session.createQuery("from Group").list();
		List<tmp> exp=new ArrayList<tmp>();
		for(int i=0;i<user.size();i++){
			tmp rua=new tmp(user.get(i).getId());
			exp.add(rua);
		}
        Map<String,Object> beans = new HashMap<String,Object>();
        beans.put("tmp", exp);
        for(int i=0;i<beans.size();i++){
        System.out.print(beans.get(i)+" ");}
        XLSTransformer transformer = new XLSTransformer();
        try {
			transformer.transformXLS("E:\\workspace\\mooc.1\\Implement_template.xls", beans, path);//template.xls为输出xls的模版，待修改
		} catch (Exception e) {
			e.printStackTrace();
		} 

	}
	
	public void exportGradeXls(HttpServletRequest request,HttpServletResponse response){//String path,List<Grade> list
		String path=request.getParameter("path");
		List<Grade> list=getAllGrade();
        Map<String,Object> beans = new HashMap<String,Object>();
        beans.put("Grade", list);
        for(int i=0;i<beans.size();i++){
        System.out.print(beans.get(i)+" ");}
        XLSTransformer transformer = new XLSTransformer();
        try {
			transformer.transformXLS("E:\\workspace\\mooc.1\\Grade_template.xls", beans, path);//template.xls为输出xls的模版，待修改
		} catch (Exception e) {
			e.printStackTrace();
		} 

	}
	
	@RequestMapping(value="/team-stu")
	public String stu(Model model)
	{
		return null;
	}
	
	@RequestMapping(value="/index")
	public String index(Model model)
	{
		return null;
	}
	
	@RequestMapping(value="/login")
	public String login(Model model)
	{
		return null;
	}
	
	@RequestMapping(value="/tc-cs")
	public String cs(Model model)
	{
		return null;
	}
	
	@RequestMapping(value="/tc-hw")
	public String hw(Model model)
	{
		return null;
	}
	
	@RequestMapping(value="/tc-src")
	public String src(Model model)
	{
		return null;
	}
	
	@RequestMapping(value="/tc-tm")
	public String tm(Model model)
	{
		return null;
	}
	
	
	public List<User> getAllUser()
	{
		User user  = null;
		Session session = null;
		List<User> results = new ArrayList<User>();
		try{
			session = HibernateUtil.factory.openSession();
			session.beginTransaction();
			String hql = "from User";
			Query query = session.createQuery(hql);
			results = query.list();
		}catch(Exception e)
		{
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally{
			HibernateUtil.closeSession(session);
		/*if(session!=null){
			if(session.isOpen()){
				session.close();
			}
		}*/
		}
		if(results.size()==0)
			return null;
		return results;
	}
	
	public List<Grade> getAllGrade()
	{
		Grade grade  = null;
		Session session = null;
		List<Grade> results = new ArrayList<Grade>();
		try{
			session = HibernateUtil.factory.openSession();
			session.beginTransaction();
			String hql = "from Grade";
			Query query = session.createQuery(hql);
			results = query.list();
		}catch(Exception e)
		{
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally{
			HibernateUtil.closeSession(session);
		/*if(session!=null){
			if(session.isOpen()){
				session.close();
			}
		}*/
		}
		if(results.size()==0)
			return null;
		return results;
	}
	
	public void importUserXls(HttpServletRequest request,HttpServletResponse response){//String path
		String path=request.getParameter("path");
		try{
			HSSFWorkbook source=new HSSFWorkbook(new FileInputStream(path));
			HSSFSheet sheet = source.getSheetAt(0);
			 int rows = sheet.getPhysicalNumberOfRows();
             //遍历行­
             for (int i = 1; i < rows; i++) {
                   // 读取左上端单元格­
                   HSSFRow row = sheet.getRow(i);
                   // 行不为空­
                   if (row != null) {
                         //获取到Excel文件中的所有的列­
                         int cells = row.getPhysicalNumberOfCells();
                         String value = "";
                        for (int j = 0; j < cells; j++) {
                               //获取到列的值­
                               HSSFCell cell = row.getCell(j);
                               if (cell != null) {
                                     switch (cell.getCellType()) {
                                           case HSSFCell.CELL_TYPE_FORMULA:
                                           break;
                                           case HSSFCell.CELL_TYPE_NUMERIC:
                                        	   	cell.setCellType(Cell.CELL_TYPE_STRING);
                                                 value += cell.getStringCellValue() + ",";        
                                           break;  
                                           case HSSFCell.CELL_TYPE_STRING:
                                                 value += cell.getStringCellValue() + ",";
                                           break;
                                           default:
                                                 value += "0";
                                           break;
                               }
                         }      
                   }
                   String[] val = value.split(",");
                   System.out.println(val[0]+" "+val[1]+" "+val[2]+" "+val[3]);//根据表格格式确定数据
 //                  saveUser(val[0],val[1],val[2],val[3],val[4]);
                   
                   Class.forName("com.mysql.jdbc.Driver");
                       
                   String url="jdbc:mysql://localhost:3306/rua";    //JDBC的URL    
                   java.sql.Connection conn;
                   conn = DriverManager.getConnection(url, "root", "");

                   java.sql.Statement stmt = conn.createStatement(); //创建Statement对象
                   System.out.println("成功连接到数据库！");

                   String sql = "insert into user values"+"("+"\""+val[0]+"\",\""+val[1]+"\",\""+val[2]+"\",\""+val[3]+"\",\""+val[4]+"\")";    //要执行的SQL
                   System.out.println(sql);
                   stmt.executeUpdate(sql);//创建数据对象
                   System.out.println("****************************************");
                       stmt.close();
                       conn.close();
                   }
		}
             }catch(Exception e ){e.printStackTrace();}
	}
	
	public void importGradeXls(HttpServletRequest request,HttpServletResponse response){//String path
		String path=request.getParameter("path");
		try{
			HSSFWorkbook source=new HSSFWorkbook(new FileInputStream(path));
			HSSFSheet sheet = source.getSheetAt(0);
			 int rows = sheet.getPhysicalNumberOfRows();
             //遍历行­
             for (int i = 1; i < rows; i++) {
                   // 读取左上端单元格­
                   HSSFRow row = sheet.getRow(i);
                   // 行不为空­
                   if (row != null) {
                         //获取到Excel文件中的所有的列­
                         int cells = row.getPhysicalNumberOfCells();
                         String value = "";
                        for (int j = 0; j < cells; j++) {
                               //获取到列的值­
                               HSSFCell cell = row.getCell(j);
                               if (cell != null) {
                                     switch (cell.getCellType()) {
                                           case HSSFCell.CELL_TYPE_FORMULA:
                                           break;
                                           case HSSFCell.CELL_TYPE_NUMERIC:
                                        	   	cell.setCellType(Cell.CELL_TYPE_STRING);
                                                 value += cell.getStringCellValue() + ",";        
                                           break;  
                                           case HSSFCell.CELL_TYPE_STRING:
                                                 value += cell.getStringCellValue() + ",";
                                           break;
                                           default:
                                                 value += "0";
                                           break;
                               }
                         }      
                   }
                   String[] val = value.split(",");
                   //System.out.println(val[0]+" "+val[1]+" "+val[2]+" "+val[3]);//根据表格格式确定数据
                   
                   Class.forName("com.mysql.jdbc.Driver");
                       
                   String url="jdbc:mysql://localhost:3306/rua";    //JDBC的URL    
                   java.sql.Connection conn;
                   conn = DriverManager.getConnection(url, "root", "");

                   java.sql.Statement stmt = conn.createStatement(); //创建Statement对象
                   System.out.println("成功连接到数据库！");

                   String sql = "insert into grade values"+"("+"\""+val[0]+"\",\""+val[1]+"\")";    //要执行的SQL
                   System.out.println(sql);
                   stmt.executeUpdate(sql);//创建数据对象
                   System.out.println("****************************************");
                       stmt.close();
                       conn.close();
                   }
		}
             }catch(Exception e ){e.printStackTrace();}
	}
	
	/*public void saveUser(String Id ,String pw,String Character,String gender,String name)
	{
		User user  = null;
		Session session = null;
		try{
			session = HibernateUtil.factory.openSession();
			session.beginTransaction();
			User a=new User(Integer.parseInt(Id.substring(0, Id.length())),pw,(byte)Integer.parseInt(Character.substring(0, Character.length())),
					(byte)Integer.parseInt(gender.substring(0, gender.length())),name);//待修改
			session.save(a);
			session.getTransaction().commit();
		}catch(Exception e)
		{
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally{
			HibernateUtil.closeSession(session);
		}
	}*/
}
