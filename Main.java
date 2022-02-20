import javax.swing.JFrame; 
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import java.awt.Container;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
import java.awt.Dimension; 


public class Main extends JFrame implements ActionListener{

    //Element Definitions
    JTextField input1 = new JTextField(); 
    JTextField input2 = new JTextField(); 
    JTextField output = new JTextField(); 
    JRadioButton add_button = new JRadioButton("+"); 
    JRadioButton subtraciton_button = new JRadioButton("-"); 
    JRadioButton multiplation_button = new JRadioButton("*"); 
    JRadioButton divide_button = new JRadioButton("/"); 
    JLabel equal = new JLabel("=");

    //Button Group for Radio Buttons to be selected one at a time.
    ButtonGroup group = new ButtonGroup(); 

    public static void main(String[] args){
        new Main().display(); 
    }

    private void display(){

        setTitle("Calculator");
        Container c = getContentPane(); 
        c.setBackground(Color.pink);
        c.setLayout(null);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int height = screenSize.height;
        int width = screenSize.width;
        setSize(width/2, height/2);
        setLocationRelativeTo(null);

        //Element Bounds
        input1.setBounds(25,50,85,30); 
        input2.setBounds(165,50,85,30);
        output.setBounds(290,50,85,30);
        equal.setBounds(265,55,20,20);
        add_button.setBounds(120,15,50,30);
        subtraciton_button.setBounds(120,35,50,30);
        multiplation_button.setBounds(120,55,50,30);
        divide_button.setBounds(120,75,50,30); 

        //Add all Radio Buttons to Button Groups.
        group.add(add_button);
        group.add(subtraciton_button);
        group.add(multiplation_button);
        group.add(divide_button);

        //Listener for each RadioButton.
        add_button.addActionListener(this);
        subtraciton_button.addActionListener(this);
        multiplation_button.addActionListener(this);
        divide_button.addActionListener(this);
        
        //Add elements to the ContentPane
        c.add(input1); 
        c.add(input2);
        c.add(output);
        c.add(equal);
        c.add(add_button); 
        c.add(subtraciton_button);
        c.add(multiplation_button);
        c.add(divide_button);
        setVisible(true);
    } 

    //Arithmetic 
    public static int Addition(int x, int y){
        int z = x + y; 
        return z; 
    }
    public static int Subtraction(int x, int y){
        int z = x - y; 
        return z; 
    }
    public static int Multiplication(int x, int y){
        int z = x * y; 
        return z; 
    }
    public static float Division(float x, float y){
        if(y == 0){
            int n = (int)y; 
            int m = (int)x; 
            int z = m / n; 
            return z;
        }else{
            float z = x / y; 
            return z;
        }
    }

    public void actionPerformed(ActionEvent evt) {
        String s = evt.getActionCommand(); 

        //Get Inputs and Cast to Integer
        String input_1 = input1.getText(); 
        String input_2 = input2.getText();
        
        JOptionPane exception_pane = new JOptionPane(); 
        exception_pane.setBackground(Color.pink);

        try{
            int num1 = Integer.parseInt(input_1);
            int num2 = Integer.parseInt(input_2);

            //Control Loop
            if(s.equals("+")){
                output.setText(String.valueOf(Addition(num1,num2)));    
            }
            else if(s.equals("-")){
                output.setText(String.valueOf(Subtraction(num1,num2)));
            }
            else if(s.equals("*")){
                output.setText(String.valueOf(Multiplication(num1,num2))); 
            }
            else{
                output.setText(String.valueOf(Division(num1,num2))); 
            }

        }catch (NumberFormatException e){
            if(input_1.equals("") || input_2.equals("")){
                JOptionPane.showMessageDialog(null, "No input in one or both text fields.", "-----ERROR-----", JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, "Non integer inputs in one or both text fields.", "-----ERROR-----", JOptionPane.INFORMATION_MESSAGE);
            }
        }catch(ArithmeticException e){
            JOptionPane.showMessageDialog(null, "Division by zero.", "-----ERROR-----", JOptionPane.INFORMATION_MESSAGE);
        }finally{
            System.out.println("Try/Catch Complete");
        } 
    }
}