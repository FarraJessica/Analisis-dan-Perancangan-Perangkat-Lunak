// ******************************************************************
// RatePanel.java
//
// Panel for a program that converts different currencies to
// U.S. Dollars
// ******************************************************************
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.DecimalFormat;

public class RatePanel extends JPanel
{
    private double[] rate; // exchange rates
    private String[] name;
    private JLabel result, labelInput;
    JTextField fieldText;
    JComboBox currencyList;
    // ------------------------------------------------------------
    // Sets up a panel to convert cost from one of 6 currencies
    // into U.S. Dollars. The panel contains a heading, a text
    // field for the cost of the item, a combo box for selecting
    // the currency, and a label to display the result.
    // ------------------------------------------------------------
    public RatePanel ()
    {
        setPreferredSize(new Dimension(400,150));
        JLabel title = new JLabel ("Currency Converter to Dollars");
        title.setBounds(200,100,50,50);
        title.setFont (new Font ("Helvetica", Font.BOLD, 20));

        // Set up the arrays for the currency conversions
        name = new String[]
        {"Select the currency..",
        "European Euro", "Canadian Dollar",
        "Japanese Yen", "Australian Dollar",
        "Indian Rupee", "Mexican Peso"};
        rate = new double []
        {0.0, 1.2103, 0.7351,
        0.0091, 0.6969,
        0.0222, 0.0880};

        currencyList = new JComboBox(name);
        currencyList.setLocation(300,250);

        labelInput = new JLabel ("\nPut the amount of money : \n");

        fieldText = new JTextField(30);
        fieldText.addActionListener(new ComboListener());
        
        result = new JLabel ("");
        
        
        add (title);
        add(currencyList);
        add (result);
        add(labelInput);
        add(fieldText);
    }
        // ******************************************************
        // Represents an action listener for the combo box.
        // ******************************************************
        private class ComboListener implements ActionListener
        {
        // --------------------------------------------------
        // Determines which currency has been selected and
        // the value in that currency then computes and
        // displays the value in U.S. Dollars.
        // --------------------------------------------------
        public void actionPerformed (ActionEvent event)
        {
            double value = 0;
            DecimalFormat decimal = new DecimalFormat("#.## ");
            
            try{
                value = Double.parseDouble(fieldText.getText());
            }
            catch(Exception e){
                result.setText("Input a Number : ");
            }
            
            int index = currencyList.getSelectedIndex();
            
            result.setText (value + name[index] +
            " = " + decimal.format(rate[index] * value) + " U.S. Dollars");
        }
    }
}