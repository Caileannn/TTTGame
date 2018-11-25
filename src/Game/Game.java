/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import static java.lang.Thread.sleep;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import ttt.james.server.TTTWebService;
import ttt.james.server.TTTWebService_Service;
import Game.GameScreen;
import javax.swing.JDialog;
import javax.swing.JOptionPane;



/**
 *
 * @author Cailean
 */

public class Game extends Thread{
    
    private JFrame myPanel;
    private JLabel myLabel;
    private int interval;
    private int gameID;
    private int xCord, yCord;
    private int playerID;
    private boolean playerTurn;
    private boolean getPlayerTurn;
    private int userID;
    private TTTWebService tttProxy;
    private Thread p1, p2;
    private int checkWin;
    private int taken;
    
    public Game(JFrame p, int i, int x, int player) {
        this.myPanel = p;
        this.gameID = i;
        this.userID = x;
        this.playerID = player;
        
        
         try
        {
            TTTWebService_Service tttService = new TTTWebService_Service();
            tttProxy = tttService.getTTTWebServicePort();
            
        }catch (Exception e){
        
            e.printStackTrace();
            System.exit(1);
        }
  
    }
    
    //Gets what players turn it is
    public boolean getTurn(){
    
                    String boardString  = tttProxy.getBoard(this.gameID);
                    String board [] = boardString.split("\\n");
                    ArrayList<String> info = new ArrayList<String>();
                    String out2[];
                    
                    boolean turn = false;
                    for(int i = 0; i < board.length; i++)
                        
        
        
                     for(int x = 0; x < board.length; x++) {
                        out2 = board[x].split(",");
                        for(int y = 0; y < out2.length; y++){
                        info.add(out2[y]);
                        }
                    } 
                     
                    int length = info.size() - 3;
                   
                    if(Integer.parseInt(info.get(length)) != this.userID ) turn = true;
                    if((info.get(length).equals("ERROR-NOMOVES"))) turn = false;
                    info.clear();
                    return turn;
    }
    
    @Override
    public void run() {
        while(tttProxy.getGameState(this.gameID).equals("-1")) {
            try {
                sleep(1000);
            } catch(Exception e) {
                e.printStackTrace();
            }
            
            
        }
        
        myPanel.setVisible(true);
        System.out.println(this.playerID + "  ID");
        
        //No Moves set playerTurn to true (true = p1)
        if((tttProxy.getBoard(gameID)).equals("ERROR-NOMOVES")) playerTurn = true;
        
        //Checks if game is still ongoing
        while(tttProxy.getGameState(this.gameID).equals("0"))
        {
            //Sleeps player 2 
            while(playerTurn && playerID == 1)
            {
                
                try
                {
                    sleep(1000);
                    getPlayerTurn = getTurn();   
                    if(getPlayerTurn) playerTurn = false;
                   
                   
                }catch (Exception e)
                {
                    e.printStackTrace();
                }
            
            
            }
            
            //Sleeps player 1
            while(!playerTurn && playerID == 0)
            {
                
                try
                {
                    sleep(1000);
                    getPlayerTurn = getTurn(); 
                    if(getPlayerTurn) playerTurn = true;
                    
                }catch (Exception e)
                {
                    e.printStackTrace();
                }
            
            
            }
            
            //Player 1 Turn
            while(playerTurn && this.playerID == 0)
            {
                System.out.println("Player 1 Turn..");
                this.xCord = 0;
                this.yCord = 0;
                        //Check XCord YCord
                        do
                        {
                            this.xCord = myPanel.getX();
                            this.yCord = myPanel.getY();
                          
                            
                        }while(tttProxy.checkSquare(this.xCord, this.yCord, this.gameID).equals("1") || (this.xCord ==0 && this.yCord == 0));
                        //Takes Square
                        tttProxy.takeSquare(xCord, yCord, gameID, userID);
                        
                        //Checks the game state
                        checkWin =  Integer.parseInt(tttProxy.checkWin(gameID));
                        tttProxy.setGameState(gameID, checkWin);
                        this.playerTurn = false;
                        System.out.println("P1 Turn Over");
                
            
            
            
            }
            
            //Player 2 Turn
            while(!playerTurn && this.playerID == 1)
            {
                taken = 1;
                System.out.println("Player 2 Turn..");
                this.xCord = 0;
                this.yCord = 0;
                        //Checks XCord YCord
                         do
                        {
                            this.xCord = myPanel.getX();
                            this.yCord = myPanel.getY();
                           
                           
                            
                        }while(tttProxy.checkSquare(this.xCord, this.yCord, this.gameID).equals("1") || (this.xCord ==0 && this.yCord == 0));
                        
                        //Takes Square 
                        tttProxy.takeSquare(xCord, yCord, gameID, userID);
                        
                        //Check the game State
                        checkWin =  Integer.parseInt(tttProxy.checkWin(gameID));
                        tttProxy.setGameState(gameID, checkWin);
                        playerTurn = true;
                        System.out.println(playerTurn);
                        System.out.println("P2 Turn Over");
                
                
            
            
            
            }
       
        }
        
        if(tttProxy.getGameState(this.gameID).equals("1") && this.playerID == 0)
        {
            JOptionPane optionPane = new JOptionPane("You have won!", JOptionPane.INFORMATION_MESSAGE
            );
            JDialog dialog = optionPane.createDialog("Result");
            dialog.setAlwaysOnTop(true);
            dialog.setVisible(true);
        }else{ 
            JOptionPane optionPane = new JOptionPane("You have lost ):", JOptionPane.INFORMATION_MESSAGE
            );
            JDialog dialog = optionPane.createDialog("Result");
            dialog.setAlwaysOnTop(true);
            dialog.setVisible(true);
        }
        
        if(tttProxy.getGameState(this.gameID).equals("2") && this.playerID == 1)
        {
            JOptionPane optionPane = new JOptionPane("You have won!", JOptionPane.INFORMATION_MESSAGE
            );
            JDialog dialog = optionPane.createDialog("Result");
            dialog.setAlwaysOnTop(true);
            dialog.setVisible(true);
        }else{ 
            JOptionPane optionPane = new JOptionPane("You have lost ):", JOptionPane.INFORMATION_MESSAGE
            );
            JDialog dialog = optionPane.createDialog("Result");
            dialog.setAlwaysOnTop(true);
            dialog.setVisible(true);
        }
        
        if(tttProxy.getGameState(this.gameID).equals("3") && this.playerID == 0)
        {
            JOptionPane optionPane = new JOptionPane("Draw!", JOptionPane.INFORMATION_MESSAGE
            );
            JDialog dialog = optionPane.createDialog("Result");
            dialog.setAlwaysOnTop(true);
            dialog.setVisible(true);
        }
        
        MainMenu menu = new MainMenu(this.userID);
        menu.setVisible(true);
        myPanel.dispose();
        
       
        
        
        
    }
    
}
