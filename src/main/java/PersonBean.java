import com.sun.rowset.JdbcRowSetImpl;

import javax.sql.rowset.JdbcRowSet;
import java.sql.SQLException;

public class PersonBean {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";
    static final String DB_USER = "user1";
    static final String DB_PASS = "secret";
    private JdbcRowSet rowSet = null;

    public PersonBean() {
        try {
            Class.forName(JDBC_DRIVER);
            rowSet = new JdbcRowSetImpl();
            rowSet.setUrl(DB_URL);
            rowSet.setUsername(DB_USER);
            rowSet.setPassword(DB_PASS);
            rowSet.setCommand("SELECT * FROM Person");
            rowSet.execute();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public Person create(Person create) {
        try {
            rowSet.moveToInsertRow();
            rowSet.updateInt("personId", create.getPersonId());
            rowSet.updateString("firstName", create.getFirstName());
            rowSet.updateString("middleName", create.getMiddleName());
            rowSet.updateString("lastName", create.getLastName());
            rowSet.updateString("email", create.getEmail());
            rowSet.updateString("phone", create.getPhone());
            rowSet.insertRow();
            rowSet.moveToCurrentRow();
        } catch (SQLException ex) {
            try {
                rowSet.rollback();
                create = null;
            } catch (SQLException e) {
                System.out.println("Error:" + e.getMessage());
            }
        }
        return create;
    }


    public Person update(Person p) {
        try {
            rowSet.updateString("firstName", p.getFirstName());
            rowSet.updateString("middleName", p.getMiddleName());
            rowSet.updateString("lastName", p.getLastName());
            rowSet.updateString("email", p.getEmail());
            rowSet.updateString("phone", p.getPhone());
            rowSet.updateRow();
            rowSet.moveToCurrentRow();
        } catch (SQLException ex) {
            try {
                rowSet.rollback();
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }
        }
        return p;
    }

    public void delete() {
        try {
            rowSet.moveToCurrentRow();
            rowSet.deleteRow();
        } catch (SQLException ex) {
            try {
                rowSet.rollback();
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }
        }

    }

    public Person moveFirst() {
        Person p = new Person();
        try {
            rowSet.first();
            p.setPersonId(rowSet.getInt("personId"));
            p.setFirstName(rowSet.getString("firstName"));
            p.setMiddleName(rowSet.getString("middleName"));
            p.setLastName(rowSet.getString("lastName"));
            p.setEmail(rowSet.getString("email"));
            p.setPhone(rowSet.getString("phone"));

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return p;
    }

    public Person moveLast() {
        Person p = new Person();
        try {
            rowSet.last();
            p.setPersonId(rowSet.getInt("personId"));
            p.setFirstName(rowSet.getString("firstName"));
            p.setMiddleName(rowSet.getString("middleName"));
            p.setLastName(rowSet.getString("lastName"));
            p.setEmail(rowSet.getString("email"));
            p.setPhone(rowSet.getString("phone"));

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return p;
    }

    public Person moveNext() {
        Person p = new Person();
        try {
            if (rowSet.next() == false)
                rowSet.previous();
            p.setPersonId(rowSet.getInt("personId"));
            p.setFirstName(rowSet.getString("firstName"));
            p.setMiddleName(rowSet.getString("middleName"));
            p.setLastName(rowSet.getString("lastName"));
            p.setEmail(rowSet.getString("email"));
            p.setPhone(rowSet.getString("phone"));

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return p;
    }

    public Person movePrevious() {
        Person p = new Person();
        try {
            if (rowSet.previous() == false)
                rowSet.next();
            p.setPersonId(rowSet.getInt("personId"));
            p.setFirstName(rowSet.getString("firstName"));
            p.setMiddleName(rowSet.getString("middleName"));
            p.setLastName(rowSet.getString("lastName"));
            p.setEmail(rowSet.getString("email"));
            p.setPhone(rowSet.getString("phone"));

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return p;
    }

    public Person getCurrent() {
        Person p = new Person();
        try {
            rowSet.moveToCurrentRow();
            p.setPersonId(rowSet.getInt("personId"));
            p.setFirstName(rowSet.getString("firstName"));
            p.setMiddleName(rowSet.getString("middleName"));
            p.setLastName(rowSet.getString("lastName"));
            p.setEmail(rowSet.getString("email"));
            p.setPhone(rowSet.getString("phone"));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return p;
    }


}