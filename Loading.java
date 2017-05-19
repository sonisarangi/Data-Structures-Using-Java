import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Loading {
   public static String x;
   @SuppressWarnings("serial")
   private static void createAndShowGui() {
      final JLabel label = new JLabel();
      int timerDelay = 1000;
      new Timer(timerDelay , new ActionListener() {
         int timeLeft = 3;

         @Override
         public void actionPerformed(ActionEvent e) {
            if (timeLeft > 0) {
               label.setText("Your Admin page is loading.");
               timeLeft--;
            } else {
               ((Timer)e.getSource()).stop();
               Window win = SwingUtilities.getWindowAncestor(label);
               win.setVisible(false);
               new Input(x);
            }
         }
      }){{setInitialDelay(0);}}.start();
     JOptionPane.showMessageDialog(null, label,"Loading",1,new ImageIcon("Images/mini.gif"));

   }

   Loading(String xa) { x= xa;
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGui();
         }
      });
      
   }
}