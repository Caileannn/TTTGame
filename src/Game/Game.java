/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import static java.lang.Thread.sleep;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import ttt.james.server.TTTWebService;
import ttt.james.server.TTTWebService_Service;




/**
 *
 * @author Cailean
 */

public class Game extends Thread{
    
    private JFrame myPanel;
    private JLabel myLabel;
    private int interval;
    private int gameID;
    private TTTWebService tttProxy;
    
    public Game(JFrame p, int i) {
        myPanel = p;
        this.gameID = i;
        
         try
        {
            TTTWebService_Service tttService = new TTTWebService_Service();
            tttProxy = tttService.getTTTWebServicePort();
            
        }catch (Exception e){
        
            e.printStackTrace();
            System.exit(1);
        }
  
    }
    
    
    @Override
    public void run() {
        while(tttProxy.getGameState(this.gameID).equals("-1")) {
            try {
                sleep(1000);
            } catch(Exception e) {
                
            }
            
            
        }
        
        myPanel.setVisible(true);
    }
    
}
