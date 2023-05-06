package consola_grafica;

import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class CalendarFrame implements Runnable {

    private JFrame  frame;
    
    public static JPanel getCalendar() {
    	monthPanel panel = new monthPanel(4, 2023);
    	JPanel panelCal = new JPanel();
        panelCal.setLayout(new FlowLayout());
        panelCal.setBackground(parametros.getColorCuerpo());
        panelCal.add(panel);
        // frame.setBounds(100, 100, 400, 200);
        panelCal.setVisible(true);
        return panelCal;
    }
    

    @Override
    public void run() {
        // Month is zero based
        monthPanel panel = new monthPanel(4, 2023);

        frame = new JFrame();
        frame.setTitle("Calendar");
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent event) {
                exitProcedure();
            }
        });

        frame.setLayout(new FlowLayout());
        frame.add(panel);
        frame.pack();
        // frame.setBounds(100, 100, 400, 200);
        frame.setVisible(true);
    }

    public void exitProcedure() {
        frame.dispose();
        System.exit(0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new CalendarFrame());

    }

}
