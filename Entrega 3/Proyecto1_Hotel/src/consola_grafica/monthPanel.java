package consola_grafica;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class monthPanel extends JPanel {

    private static final long   serialVersionUID    = 1L;

    protected int mes;
    protected int anio;

    protected String[] meses = { "Enero", "Febrero",
            "Marzo", "Abril", "Mayo", "Junio", "Julio", "Augosto", "Septiembre",
            "Octubre", "Noviembre", "Diciembre"};

    protected String[] dias = { "D", "L", "M", "M",
            "J", "V", "S"};

    public monthPanel(int mes, int anio) {
        this.mes = mes;
        this.anio = anio;

        this.add(createGUI());
    }

    protected JPanel createGUI() {
        JPanel monthPanel = new JPanel(true);
        monthPanel.setBorder(BorderFactory
                .createLineBorder(SystemColor.activeCaption));
        monthPanel.setLayout(new BorderLayout());
        monthPanel.setBackground(Color.WHITE);
        monthPanel.setForeground(Color.BLACK);
        monthPanel.add(createTitleGUI(), BorderLayout.NORTH);
        monthPanel.add(createDaysGUI(), BorderLayout.SOUTH);

        return monthPanel;
    }

    protected JPanel createTitleGUI() {
        JPanel titlePanel = new JPanel(true);
        titlePanel.setBorder(BorderFactory
                .createLineBorder(SystemColor.activeCaption));
        titlePanel.setLayout(new FlowLayout());
        titlePanel.setBackground(Color.WHITE);

        JLabel label = new JLabel(meses[mes] + " " + anio);
        label.setForeground(SystemColor.activeCaption);

        titlePanel.add(label, BorderLayout.CENTER);

        return titlePanel;
    }

    protected JPanel createDaysGUI() {
        JPanel dayPanel = new JPanel(true);
        dayPanel.setLayout(new GridLayout(0, dias.length));

        Calendar today = Calendar.getInstance();
        int tMonth = today.get(Calendar.MONTH);
        int tYear = today.get(Calendar.YEAR);
        int tDay = today.get(Calendar.DAY_OF_MONTH);

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MONTH, mes);
        calendar.set(Calendar.YEAR, anio);
        calendar.set(Calendar.DAY_OF_MONTH, 1);

        Calendar iterator = (Calendar) calendar.clone();
        iterator.add(Calendar.DAY_OF_MONTH,
                -(iterator.get(Calendar.DAY_OF_WEEK) - 1));

        Calendar maximum = (Calendar) calendar.clone();
        maximum.add(Calendar.MONTH, +1);

        for (int i = 0; i < dias.length; i++) {
            JPanel dPanel = new JPanel(true);
            dPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            JLabel dLabel = new JLabel(dias[i]);
            dPanel.add(dLabel);
            dayPanel.add(dPanel);
        }

        int count = 0;
        int limit = dias.length * 6;

        while (iterator.getTimeInMillis() < maximum.getTimeInMillis()) {
            int lMonth = iterator.get(Calendar.MONTH);
            int lYear = iterator.get(Calendar.YEAR);

            JPanel dPanel = new JPanel(true);
            dPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            JLabel dayLabel = new JLabel();

            if ((lMonth == mes) && (lYear == anio)) {
                int lDay = iterator.get(Calendar.DAY_OF_MONTH);
                dayLabel.setText(Integer.toString(lDay));
                if ((tMonth == mes) && (tYear == anio) && (tDay == lDay)) {
                    dPanel.setBackground(Color.ORANGE);
                } else {
                    dPanel.setBackground(Color.WHITE);
                }
            } else {
                dayLabel.setText(" ");
                dPanel.setBackground(Color.WHITE);
            }
            dPanel.add(dayLabel);
            dayPanel.add(dPanel);
            iterator.add(Calendar.DAY_OF_YEAR, +1);
            count++;
        }

        for (int i = count; i < limit; i++) {
            JPanel dPanel = new JPanel(true);
            dPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            JLabel dayLabel = new JLabel();
            dayLabel.setText(" ");
            dPanel.setBackground(Color.WHITE);
            dPanel.add(dayLabel);
            dayPanel.add(dPanel);
        }

        return dayPanel;
    }

}