package Employee;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
public class Update extends JFrame implements ActionListener{
    JTextField tfname,taddress,tmobile,taadhar,temail,tsal,tdesig;
    JLabel tempid;
    @SuppressWarnings("rawtypes")
    JComboBox boxedu;
    JButton add,back;
    String num;
    Update(String num){
        this.num = num;
         getContentPane().setBackground(new Color(163,255,183));
        JLabel heading = new JLabel("Add Employee Detail");
        heading.setBounds(320,30,500,50);
        heading.setFont(new Font("serif",Font.BOLD,25));
        add(heading);

        JLabel name = new JLabel("Name");
        name.setBounds(50,150,150,30);
        name.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(name);

        JLabel tname = new JLabel();
        tname.setBounds(200,150,150,30);
        tname.setBackground(new Color(177,252,197));
        add(tname);

        JLabel fname = new JLabel("Father's Name");
        fname.setBounds(50,200,150,30);
        fname.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(fname);

        tfname = new JTextField();
        tfname.setBounds(200,200,150,30);
        tfname.setBackground(new Color(177,252,197));
        add(tfname);

        JLabel DOB = new JLabel("Date of Birth");
        DOB.setBounds(50,250,150,30);
        DOB.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(DOB);
        
        JLabel tdob = new JLabel();
        tdob.setBounds(200,250,150,30);
        tdob.setFont(new Font("Tahoma",Font.BOLD,20));
        add(tdob);

        JLabel salary = new JLabel("Salary");
        salary.setBounds(50,300,150,30);
        salary.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(salary);

        tsal = new JTextField();
        tsal.setBounds(200,300,150,30);
        tsal.setBackground(new Color(177,252,197));
        add(tsal);

        JLabel address = new JLabel("Address");
        address.setBounds(50,350,150,30);
        address.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(address);

        taddress = new JTextField();
        taddress.setBounds(200,350,150,30);
        taddress.setBackground(new Color(177,252,197));
        add(taddress);

        JLabel phone = new JLabel("Phone Number");
        phone.setBounds(400,150,150,30);
        phone.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(phone);

        tmobile = new JTextField();
        tmobile.setBounds(570,150,150,30);
        tmobile.setBackground(new Color(177,252,197));
        add(tmobile);

        JLabel aadhar = new JLabel("Aadhar Number");
        aadhar.setBounds(400,200,150,30);
        aadhar.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(aadhar);

        JLabel taadhar = new JLabel();
        taadhar.setBounds(570,200,150,30);
        taadhar.setBackground(new Color(177,252,197));
        add(taadhar);

        JLabel email = new JLabel("Email Address");
        email.setBounds(400,250,150,30);
        email.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(email);

        temail = new JTextField();
        temail.setBounds(570,250,150,30);
        temail.setBackground(new Color(177,252,197));
        add(temail);

        JLabel desig = new JLabel("Designation");
        desig.setBounds(400,300,150,30);
        desig.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(desig);

        tdesig = new JTextField();
        tdesig.setBounds(570,300,150,30);
        tdesig.setBackground(new Color(177,252,197));
        add(tdesig);

        JLabel edu = new JLabel("Education");
        edu.setBounds(400,350,150,30);
        edu.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(edu);

        String[] items = {"BBA","B.TECH","B.E","MBBS","BD","BSC","B.COM","M.E","M.Tech","PhD","MSC","BA","MBA","MCA","BCA","BSC"};
        boxedu = new JComboBox<>(items);
        boxedu.setBackground(new Color(177,252,197));
        boxedu.setBounds(570,350,150,30);
        add(boxedu);
        
        JLabel empid = new JLabel("Employee ID");
        empid.setBounds(50,400,150,30);
        empid.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(empid);

        tempid = new JLabel();
        tempid.setBounds(200,400,150,30);
        tempid.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        tempid.setForeground(new Color(300));
        add(tempid);

        setSize(900,700);
        setLayout(null);
        setLocation(300,50);
        setVisible(true);

        try{
            conn c = new conn();
            String query = "select * from e where empid = '"+ num+"'";
            ResultSet res = c.statement.executeQuery(query);
            while(res.next()){
                tname.setText(res.getString("name"));
                tfname.setText(res.getString("fname"));
                tdob.setText(res.getString("dob"));
                taddress.setText(res.getString("address"));
                tsal.setText(res.getString("salary"));
                tmobile.setText(res.getString("phone"));
                temail.setText(res.getString("email"));
                boxedu.setSelectedItem(res.getString("education"));
                taadhar.setText(res.getString("aadhar"));
                tdesig.setText(res.getString("desig"));
                tempid.setText(res.getString("empid"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        add = new JButton("Update");
        add.setBounds(400,550,150,40);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);

        back = new JButton("BACK");
        back.setBounds(570,550,150,40);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==back){
            setVisible(false);
            new View_Employee();
        }
        else{
            String fname =tfname.getText();
            String sal = tsal.getText();
            String address = taddress.getText();
            String phone = tmobile.getText();
            String email = temail.getText();
            String education = boxedu.getSelectedItem().toString();
            String desig = tdesig.getText();
            try{
                conn c = new conn();
              String query = "update employee set fname = '"+fname+"', salary = '"+sal+"', address = '"+address+"', phone = '"+phone+"', email = '"+email+"', education = '"+education+"', designation = '"+desig+"' where empId = '"+num+"'";
              c.statement.executeUpdate(query);
              JOptionPane.showMessageDialog(null, "Details Updated Successfully");
              setVisible(false);
              new Main_Class();
            }catch (Exception E){
                E.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        new Update("841123");   
    }
    
}
