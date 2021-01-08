

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Timer;

/**
 *
 * author rawmilk
 */
public class TrafficSignal extends Frame 
        implements ActionListener {
    Timer t = new Timer();
    int i = 0, a = 0, j = 0;
    String msg = "", msg2 = "";
    Button red, yellow, green, auto;

    public TrafficSignal() {
        setLayout(new FlowLayout());
        red = new Button("Red");
        yellow = new Button("Yellow");
        green = new Button("Green");
        auto = new Button("Auto");

        /*ADD ITEMS TO FRAME*/
        add(red);
        add(yellow);
        add(green);
        add(auto);

        /*ADD ITEMS LISTENERS*/
        red.addActionListener(this);
        yellow.addActionListener(this);
        green.addActionListener(this);
        auto.addActionListener(this);

        /*TO SHUT DOWN THE PROGRAM*/
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    public void paint(Graphics g) {
        
        g.fillRect(238, 100, 75, 225);
        g.setColor(Color.GRAY);
        g.fillOval(250, 125, 50, 50);
        g.fillOval(250, 188, 50, 50);
        g.fillOval(250, 250, 50, 50);
        if (msg.equals("Red signal")) {
            g.setColor(Color.RED);
            g.fillOval(250, 125, 50, 50);
            g.drawOval(250, 125, 50, 50);
        } else if (msg.equals("Yellow signal")) {
            g.setColor(Color.YELLOW);
            g.fillOval(250, 188, 50, 50);
            g.drawOval(250, 188, 50, 50);
        } else if (msg.equals("Green signal")) {
            g.setColor(Color.GREEN);
            g.fillOval(250, 250, 50, 50);
            g.drawOval(250, 250, 50, 50);
        } else if (msg.equals("Auto mode")) {
            int cycles = 3;
            while (cycles != -1) {
                try {

                    g.setColor(Color.GREEN);
                    g.fillOval(250, 250, 50, 50);
                    g.drawOval(250, 250, 50, 50);

                    Thread.sleep(3000);

                    g.setColor(Color.gray);
                    g.fillOval(250, 250, 50, 50);
                    g.drawOval(250, 250, 50, 50);
                    g.setColor(Color.YELLOW);
                    g.fillOval(250, 188, 50, 50);
                    g.drawOval(250, 188, 50, 50);
                    
                    Thread.sleep(3000);

                    g.setColor(Color.gray);
                    g.fillOval(250, 188, 50, 50);
                    g.drawOval(250, 188, 50, 50);
                    g.setColor(Color.RED);
                    g.fillOval(250, 125, 50, 50);
                    g.drawOval(250, 125, 50, 50);
                    
                    Thread.sleep(5000);
                    
                    g.setColor(Color.gray);
                    g.fillOval(250, 125, 50, 50);
                    g.drawOval(250, 125, 50, 50);
                    cycles--;
                } catch (InterruptedException e) {
                    g.setColor(Color.RED);
                    g.drawString("ERROR", 30, 130);
                } catch (IllegalMonitorStateException imse) {
                    g.setColor(Color.RED);
                    g.drawString("IMSE ERROR", 30, 130);
                }
            }
        } else {
            g.drawString("", 20, 120);
        }
        g.setColor(Color.BLACK);
        g.drawString(msg, 20, 120);
        
    }

    public void actionPerformed(ActionEvent ae) {
        
        String str = ae.getActionCommand();
        if (str.equals("Red")) {
            msg = "Red signal";
        } else if (str.equals("Green")) {
            msg = "Green signal";
        } else if (str.equals("Yellow")){
            msg = "Yellow signal";
        } else{
            msg = "Auto mode";
        }
        repaint();
        
    }
    
    public static void main(String[] args) {
        TrafficSignal pr = new TrafficSignal();
        pr.setSize(new Dimension(400, 400));
        pr.setBackground(Color.white);
        pr.setVisible(true);
    }

}
