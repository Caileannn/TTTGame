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
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import Game.GameWindow;



/**
 *
 * @author Cailean
 */

public class Game extends Thread{
    
    private GameWindow myPanel;
    private int gameID;
    private int xCord, yCord;
    private int playerID;
    private boolean playerTurn;
    private boolean getPlayerTurn;
    private int userID;
    private TTTWebService tttProxy;
    private int checkWin;
    
    public Game(GameWindow p, int i, int x, int player) {
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
    
    public void fillBoard(){
                    String boardString  = tttProxy.getBoard(this.gameID);
                    String board [] = boardString.split("\\n");
                    ArrayList<String> info = new ArrayList<String>();
                    String out2[];
                    int cords[] = new int[2];
                    int count;
                    int turn = 0;
                    
                    for(int i = 0; i < board.length; i++)
                        
        
        
                     for(int x = 0; x < board.length; x++) {
                        out2 = board[x].split(",");
                        for(int y = 0; y < out2.length; y++){
                        info.add(out2[y]);
                        }
    
                     }
                    int var = 0;
                    turn = 2;
                    if(info.size() < 2) var = 1;
                    else var = 0;
                    for(int i = var ; i < info.size(); i++)
                    {
                        count = 0;
                        
                        for(int y = i + 1; y <= (i+2); y++)
                        {
                            cords[count] = Integer.parseInt((info.get(y)));
                            count++;
                        }
                        if((turn % 2) == 0) this.myPanel.setXText(cords[0], cords[1]);
                        else this.myPanel.setOText(cords[0], cords[1]);
                        turn++;
                        i = i+2;
                    }
                    /*
                    for(int i = 0; i < gamesOpen.size(); i++)
                    {
                        rowData[0] = gamesOpen.get(i);
                         int count = 1;
                        for(int y = i + 1 ; y  <=  (i+2) ; y++)
                        {
                            if(gamesOpen.get(y) == null) rowData[count] = "";
                             else rowData[count] = gamesOpen.get(y);
                             count++;
                         }
                            i = i+2;
                            model.addRow(rowData);
            
        }
            */        
                    
    }
                    
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
                    this.myPanel.setTurnLabelOpp();
                   
                   
                }catch (Exception e)
                {
                   // e.printStackTrace();
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
                    this.myPanel.setTurnLabelOpp();
                    
                }catch (Exception e)
                {
                    e.printStackTrace();
                }
            
            
            }
            
            //Player 1 Turn
            while(playerTurn && this.playerID == 0)
            {
                fillBoard();
                System.out.println("Player 1 Turn..");
                this.myPanel.setTurnLabelOwn();
                this.xCord = 5;
                this.yCord = 5;
                this.myPanel.setX(xCord);
                this.myPanel.setY(yCord);
                        //Check XCord YCord
                       try{
                         do
                        {
                            
                            this.xCord = myPanel.getX();
                            this.yCord = myPanel.getY();
                            
                            
                           
                           
                            
                        }while(tttProxy.checkSquare(this.xCord, this.yCord, this.gameID).equals("1") || xCord == 5);
                    }catch (Exception e){
                        e.printStackTrace();
                    } 
                        //Takes Square
                        tttProxy.takeSquare(xCord, yCord, gameID, userID);
                        
                        //setSquares
                        this.myPanel.setXText(xCord, yCord);
                       
                        //Checks the game state
                        checkWin =  Integer.parseInt(tttProxy.checkWin(gameID));
                        tttProxy.setGameState(gameID, checkWin);
                        this.playerTurn = false;
                        System.out.println("P1 Turn Over");
                
            
            
            
            }
            
            //Player 2 Turn
            while(!playerTurn && this.playerID == 1)
            {
                fillBoard();
                System.out.println("Player 2 Turn..");
                this.myPanel.setTurnLabelOwn();
                this.xCord = 5;
                this.yCord = 5;
                this.myPanel.setX(xCord);
                this.myPanel.setY(yCord);
                        //Checks XCord YCord
                    try{
                         do
                        {
                            
                            this.xCord = myPanel.getX();
                            this.yCord = myPanel.getY();
                            
                           
                           
                            
                        }while(tttProxy.checkSquare(this.xCord, this.yCord, this.gameID).equals("1") || xCord == 5);
                    }catch (Exception e){
                        e.printStackTrace();
                    } 
                         
                       
                        //Takes Square 
                        tttProxy.takeSquare(xCord, yCord, gameID, userID);
                        
                        //Sets Text
                        this.myPanel.setOText(xCord, yCord);
                        
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
