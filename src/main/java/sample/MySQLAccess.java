package sample;

import sample.Tables.*;

import java.sql.*;
import java.util.LinkedList;

/**
 * Created by Дарья on 01.11.2015.
 */
public class MySQLAccess {
    private String login;
    private String password;
    private String dataBaseName;
    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    private PreparedStatement insertSet;
    private Statement deleteSet;

    public LinkedList<Object> objCollection=new LinkedList<Object>();   //14 коллекций таблиц

    public Object object;

    public MySQLAccess(String dataBaseName, String login, String
            password) throws SQLException, ClassNotFoundException {
      dataBaseName ="C:/Users/Дарья/IdeaProjects/Project_DB/src/test/resources/Univer.sql";
        login = "root";
        password = "0000";
        //  this.dataBaseName = dataBaseName;
       // this.login = login;
       // this.password = password;
        connectToDataBase();
    }
    //Функция для вывода данных каждой таблицы
    public LinkedList<Object> SetBranchCollection(String tableName, LinkedList<String> columns,LinkedList<Object> collection, Object obj) throws SQLException {
        resultSet=null;
        statement = connect.createStatement();
        resultSet = statement.executeQuery("select * from "+ dataBaseName +"."+tableName);
        LinkedList<String> strings=new LinkedList<String>();

        if (tableName.equals("cathedra")) {
            resultSet = statement.executeQuery("SELECT * FROM univer.cathedra;");
            //columns.set(3,"Адрес");

        }
        while (resultSet.next()) {

            strings=new LinkedList<String>();

            for (int i=0;i<columns.size();i++){
                String str = resultSet.getString(columns.get(i));
                strings.add(str);
            }
            if (tableName.equals("cathedra"))
                obj=new Cathedra(strings);
            else if (tableName.equals("education_building"))
                obj=new Education_building(strings);
            else if (tableName.equals("faculty"))
                obj=new Faculty(strings);
            else if (tableName.equals("student"))
                obj=new Student(strings);
            else if (tableName.equals("students_group"))
                obj=new Students_group(strings);
            else if (tableName.equals("teacher"))
                obj=new Teacher(strings);


            collection.add(obj);
        }
        return collection;
    }
    //Подключение к базе данных на mysql
    public void connectToDataBase() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + dataBaseName + "?user=" + login + "&password=" + password);
        statement = connect.createStatement();
    }

    //Получаем названия таблиц из базы
    public LinkedList<String> getTables() throws SQLException {
        LinkedList<String> tables = new LinkedList<String>();
        DatabaseMetaData md = connect.getMetaData();
        resultSet = md.getTables(null, null, "%", null);
        while (resultSet.next()) {
            tables.add(resultSet.getString(3));
        }
        return tables;
    }

    public LinkedList<String> getColumns(String tableName) throws
            SQLException {
        LinkedList<String> columns = new LinkedList<String>();
        ResultSet rs = statement.executeQuery("SELECT * FROM "+ dataBaseName +"."+ tableName);
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnCount = rsmd.getColumnCount();
        // Нумерация колонок начинается с 1
        for (int i = 1; i < columnCount + 1; i++ ) {
            columns.add(rsmd.getColumnName(i));
        }
        return columns;
    }

    //Добавление новой записи в таблицу
    public void Adding(String tableName, LinkedList<Object> insertData) throws SQLException {

        String first="insert into "+ dataBaseName +"."+tableName+" values(";
        StringBuffer insert=new StringBuffer();
        StringBuffer data=new StringBuffer();

        for (int i=0;i<insertData.size();i++){
            data.append("'");
            data.append(insertData.get(i));
            if (i!=insertData.size()-1)
                data.append("',");
            else data.append("')");
        }
        insert.append(first);
        insert.append(data);

        Statement insertSet = connect.createStatement();
        insertSet.executeUpdate(insert.toString());
    }

    public void Changing(String tableName,LinkedList<Object> insertData, LinkedList<String> fields) throws SQLException {
//   update кабинет set специализация='Терапевт' where код=5;
        String first="update "+ dataBaseName +"."+tableName+" set ";
        boolean flag=false;
        StringBuffer update=new StringBuffer();
        StringBuffer data=new StringBuffer();
        for (int i=1;i<insertData.size();i++){
            if (insertData.get(i).equals("")){
                flag=true;
                continue;
            }else flag=false;

            data.append(fields.get(i));
            data.append("='");
            data.append(insertData.get(i));
            if (i!=insertData.size()-1)
                data.append("',");
            else data.append("'");
        }
        if (flag==false) {
            if (data.charAt(data.length() - 1) == ',')
                data.deleteCharAt(data.length() - 1);
            String end = " where " + fields.get(0) + "=" + insertData.get(0);
            update.append(first);
            update.append(data);
            update.append(end);

            Statement updateSet = connect.createStatement();
            updateSet.executeUpdate(update.toString());
        }
    }
    public void Del(String tableName, int number)throws SQLException{
        deleteSet=connect.createStatement();
        deleteSet.executeUpdate("delete from "+ dataBaseName +"."+tableName+" where код="+number);

    }



}
