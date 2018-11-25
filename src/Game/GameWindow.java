/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;


import javax.swing.JDialog;
import javax.swing.JOptionPane;
import ttt.james.server.TTTWebService;
import ttt.james.server.TTTWebService_Service;

/**
 *
 * @author Cailean
 */


public class GameWindow extends javax.swing.JFrame {

    /**
     * Creates new form GameScreen
     */
    private TTTWebService tttProxy;
    private int userID;
    private int gameID;
    private int player1, player2;
    private int xCord= 0; 
    private int yCord = 0;
    
    
    
    public GameWindow(int gameID, int userID) {
        initComponents();
        this.userID = userID;
        this.gameID = gameID;
        
        try
        {
            TTTWebService_Service tttService = new TTTWebService_Service();
            tttProxy = tttService.getTTTWebServicePort();
            
        }catch (Exception e){
        
            e.printStackTrace();
            System.exit(1);
        }
        
        //Thread
        jLabelTurn.setText("Opponents Turn");
    }
    
   
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jButtonX3Y3 = new javax.swing.JButton();
        jButtonX1Y3 = new javax.swing.JButton();
        jButtonX2Y3 = new javax.swing.JButton();
        jButtonX3Y2 = new javax.swing.JButton();
        jButtonX1Y2 = new javax.swing.JButton();
        jButtonX2Y2 = new javax.swing.JButton();
        jButtonX3Y1 = new javax.swing.JButton();
        jButtonX1Y1 = new javax.swing.JButton();
        jButtonX2Y1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabelTurn = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(400, 300, 0, 0));

        jButtonX3Y3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonX3Y3ActionPerformed(evt);
            }
        });

        jButtonX1Y3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonX1Y3ActionPerformed(evt);
            }
        });

        jButtonX2Y3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonX2Y3ActionPerformed(evt);
            }
        });

        jButtonX3Y2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonX3Y2ActionPerformed(evt);
            }
        });

        jButtonX1Y2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonX1Y2ActionPerformed(evt);
            }
        });

        jButtonX2Y2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonX2Y2ActionPerformed(evt);
            }
        });

        jButtonX3Y1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonX3Y1ActionPerformed(evt);
            }
        });

        jButtonX1Y1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonX1Y1ActionPerformed(evt);
            }
        });

        jButtonX2Y1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonX2Y1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Turn:");

        jLabelTurn.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabelTurn.setText("? Turn");

        jButton1.setText("Leave");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelTurn)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 117, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jButtonX1Y2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButtonX2Y2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButtonX3Y2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jButtonX1Y3, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButtonX2Y3, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButtonX3Y3, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonX1Y1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonX2Y1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonX3Y1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(192, 192, 192))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabelTurn))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonX2Y3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonX1Y3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonX3Y2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonX2Y2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonX1Y2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButtonX3Y1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButtonX1Y1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButtonX2Y1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonX3Y3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>                        

    private void jButtonX3Y1ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
        xCord = 2;
        yCord = 0;
    }                                           

    private void jButtonX2Y2ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
        xCord = 1;
        yCord = 1;
    }                                           

    private void jButtonX1Y2ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
        xCord = 0;
        yCord = 1;
    }                                           

    private void jButtonX1Y3ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
        //Top-right
        xCord = 0;
        yCord = 2;
        
    }                                           

    private void jButtonX3Y3ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
        xCord = 2;
        yCord = 2;
    }                                           

    private void jButtonX3Y2ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
        xCord = 2;
        yCord = 1;
    }                                           

    private void jButtonX2Y1ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
        xCord = 1;
        yCord =0;
    }                                           

    private void jButtonX2Y3ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
        xCord = 1;
        yCord = 2;
    }                                           

    private void jButtonX1Y1ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
        xCord = 0;
        yCord = 0;
    }                                           

    
    @Override
  public int getX(){
        return this.xCord;
       
    }
    
    @Override
    public int getY(){
        return this.yCord;
       
    }
    
    /**
     *
     */
    public void setX(int x){
        this.xCord = x;
    }
    
    public void setY(int y ){
        this.yCord = y;
       
    }
    
    public void setTurnLabelOwn(){
       jLabelTurn.setText("Your Turn");
    }
    
    public void setTurnLabelOpp(){
       jLabelTurn.setText("Opponents Turn");
    }
    
    public void setXText(int x, int y)
    {
        //jButtonX3Y3
        switch(x){
            case 0 :
                if(y == 0) jButtonX1Y1.setText("X");
                if(y == 1) jButtonX1Y2.setText("X");
                if(y == 2) jButtonX1Y3.setText("X");
                break;
            case 1:
                if(y == 0) jButtonX2Y1.setText("X");
                if(y == 1) jButtonX2Y2.setText("X");
                if(y == 2) jButtonX2Y3.setText("X");
                break;
            case 2:
                if(y == 0) jButtonX3Y1.setText("X");
                if(y == 1) jButtonX3Y2.setText("X");
                if(y == 2) jButtonX3Y3.setText("X");
                break;
            default:
               System.out.print("Error");
        
        } 
        
    
        
    }
    
    public void setOText(int x, int y)
    {
        //jButtonX3Y3
        switch(x){
            case 0 :
                if(y == 0) jButtonX1Y1.setText("O");
                if(y == 1) jButtonX1Y2.setText("O");
                if(y == 2) jButtonX1Y3.setText("O");
                break;
            case 1:
                if(y == 0) jButtonX2Y1.setText("O");
                if(y == 1) jButtonX2Y2.setText("O");
                if(y == 2) jButtonX2Y3.setText("O");
                break;
            case 2:
                if(y == 0) jButtonX3Y1.setText("O");
                if(y == 1) jButtonX3Y2.setText("O");
                if(y == 2) jButtonX3Y3.setText("O");
                break;
            default:
               System.out.print("Error");
        
        } 
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GameScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GameScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GameScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new GameScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonX1Y1;
    private javax.swing.JButton jButtonX1Y2;
    private javax.swing.JButton jButtonX1Y3;
    private javax.swing.JButton jButtonX2Y1;
    private javax.swing.JButton jButtonX2Y2;
    private javax.swing.JButton jButtonX2Y3;
    private javax.swing.JButton jButtonX3Y1;
    private javax.swing.JButton jButtonX3Y2;
    private javax.swing.JButton jButtonX3Y3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelTurn;
    // End of variables declaration                   


    
}