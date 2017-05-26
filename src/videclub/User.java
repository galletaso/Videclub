/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videclub;

import java.awt.Image;
import java.awt.image.BufferedImage;
//import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Alfonso
 */
public class User extends javax.swing.JFrame {

    JLabel caratula;
    
    Connection conn;
    Statement stat;
    ResultSet rstName;
    ResultSet rstApellido;
    ResultSet rst;
    ResultSet rstFilm;
    
    String [][] arrayResultado;
    
    String [][] arrayPeliculas;
    String [] arrayCaratulas;
    
    int x =1;
    
    String z;
    
    public User(String dni) throws IOException, ClassNotFoundException, SQLException {
        initComponents();
        
        this.setTitle("Videoclub");
        String path = "/imagenes/"+dni+".jpg";
        URL imagen1 = getClass().getResource(path);
        ImageIcon foto = new ImageIcon(new ImageIcon(imagen1).getImage().getScaledInstance(lblPic.getHeight(), lblPic.getWidth(), Image.SCALE_DEFAULT));
        conectar(dni);
        lblNombre.setText(arrayResultado[rst.getRow()-1][0]);
        lblApellido.setText(arrayResultado[rst.getRow()-1][1]);
        lblPenalizaciones.setText("Penalizaciones: " + arrayResultado[rst.getRow()-1][2]);
        lblPic.setIcon(foto);      
        
        
        /*for(x =1; x<3;x++){
            int a =0;
            System.out.println("init"+ruta(x));
            URL imagen2 = getClass().getResource(ruta(x));
            ImageIcon portada = new ImageIcon(imagen2);
            peli1.setBounds(peli1.getX(),peli1.getY(),peli1.getWidth(),peli1.getHeight());
            a++;
            if(a==1){
                peli1.setIcon(portada);
            }else if(a==2){
                peli2.setIcon(portada);
            }else if(a==3){
                peli3.setIcon(portada);
            }
        }*/
        
        System.out.println("init"+ruta(x));
        URL imagen2 = getClass().getResource(ruta(x));
        ImageIcon portada = new ImageIcon(imagen2);
        caratula = new JLabel();
        this.add(caratula);
        caratula.setVisible(true);
        caratula.setBounds(293,150,173,250);
        caratula.setIcon(portada);        
    }
    
    private void conectar(String dni) throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
            
        conn = DriverManager.getConnection("jdbc:mysql://172.16.0.187/videoclub","root","1234"); 

        stat = conn.createStatement();

        rst = stat.executeQuery("SELECT * FROM videoclub.usuarios WHERE DNI='" + dni + "'");
        rst.last();
        arrayResultado = new String[rst.getRow()][3];
        rst.first();
        arrayResultado[rst.getRow()-1][0] = rst.getString("Nombre");
        arrayResultado[rst.getRow()-1][1] = rst.getString("Apellido");
        arrayResultado[rst.getRow()-1][2] = rst.getString("Penalizacion");
        

        //---------------------------------------------------------------      
            
    }
    
    private void pelis(int id) throws SQLException{
        rst = stat.executeQuery("SELECT * FROM videoclub.peliculas WHERE id_pelicula='" + id + "'");
        rst.last();
        arrayPeliculas = new String[rst.getRow()][8];
        rst.first();
        arrayPeliculas[rst.getRow()-1][0] = rst.getString("id_pelicula");
        arrayPeliculas[rst.getRow()-1][1] = rst.getString("titulo");
        arrayPeliculas[rst.getRow()-1][2] = rst.getString("año");
        arrayPeliculas[rst.getRow()-1][3] = rst.getString("pais");
        arrayPeliculas[rst.getRow()-1][4] = rst.getString("genero");
        arrayPeliculas[rst.getRow()-1][5] = rst.getString("imdb");
        arrayPeliculas[rst.getRow()-1][6] = rst.getString("clasificacion_imdb");
        arrayPeliculas[rst.getRow()-1][7] = rst.getString("resumen");
    }
    
    /*private void caratulas(String caratula){
        arrayCaratulas = new String[151];
        String c = "";
        int a=0;
        for(int j=0;j<6;j++){
            if(caratula.charAt(j)=='0'){
                a++;
            }else{
                c=c+caratula.charAt(j);
            }
            URL imagen2 = getClass().getResource(ruta(a,c));
            ImageIcon portada = new ImageIcon(new ImageIcon(imagen2).getImage().getScaledInstance(peli1.getHeight(), peli1.getWidth(), Image.SCALE_DEFAULT));
            peli1.setIcon(portada);
        }
    }*/
    
    private String ruta(int a){
        String caratula = "";
        if(a<10){
            caratula = "/caratula/" + "00000" + a + ".jpg";
        }else if(a>=10 || a<100){
            caratula = "/caratula/" + "0000" + a + ".jpg";
        }else{
            caratula = "/caratula/" + "000" + a + ".jpg";
        }
        System.out.println("ruta"+caratula);
        return caratula;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dialogInfo = new javax.swing.JDialog();
        lblPortada = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        lblAnyo = new javax.swing.JLabel();
        lblPais = new javax.swing.JLabel();
        lblGenero = new javax.swing.JLabel();
        lblClasificacion = new javax.swing.JLabel();
        taResumen = new javax.swing.JTextArea();
        lblPic = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblApellido = new javax.swing.JLabel();
        peli1 = new javax.swing.JLabel();
        peli3 = new javax.swing.JLabel();
        btnNext = new javax.swing.JButton();
        btnPrev = new javax.swing.JButton();
        lblPenalizaciones = new javax.swing.JLabel();

        dialogInfo.setBackground(new java.awt.Color(0, 102, 102));

        lblPortada.setText("jLabel1");

        lblTitulo.setText("jLabel1");

        lblAnyo.setText("jLabel2");

        lblPais.setText("jLabel3");

        lblGenero.setText("jLabel4");

        lblClasificacion.setText("jLabel1");

        taResumen.setColumns(20);
        taResumen.setRows(5);

        javax.swing.GroupLayout dialogInfoLayout = new javax.swing.GroupLayout(dialogInfo.getContentPane());
        dialogInfo.getContentPane().setLayout(dialogInfoLayout);
        dialogInfoLayout.setHorizontalGroup(
            dialogInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogInfoLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(dialogInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dialogInfoLayout.createSequentialGroup()
                        .addComponent(lblPortada, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(dialogInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTitulo)
                            .addComponent(lblAnyo)
                            .addComponent(lblPais)
                            .addComponent(lblGenero)))
                    .addComponent(lblClasificacion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(taResumen, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        dialogInfoLayout.setVerticalGroup(
            dialogInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogInfoLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(dialogInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dialogInfoLayout.createSequentialGroup()
                        .addComponent(lblTitulo)
                        .addGap(12, 12, 12)
                        .addComponent(lblAnyo)
                        .addGap(18, 18, 18)
                        .addComponent(lblPais)
                        .addGap(18, 18, 18)
                        .addComponent(lblGenero))
                    .addComponent(lblPortada, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblClasificacion)
                .addContainerGap(165, Short.MAX_VALUE))
            .addGroup(dialogInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(taResumen)
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 51, 51));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });

        lblNombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre.setText("Nombre: ");

        lblApellido.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblApellido.setText("Apellido: ");

        btnNext.setText(">");
        btnNext.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnNextMousePressed(evt);
            }
        });

        btnPrev.setText("<");
        btnPrev.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnPrevMousePressed(evt);
            }
        });

        lblPenalizaciones.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPenalizaciones.setText("Penalizaciones: ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPic, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPrev))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(peli1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(209, 209, 209)
                        .addComponent(peli3, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblNombre)
                        .addGap(223, 223, 223)
                        .addComponent(lblPenalizaciones))
                    .addComponent(lblApellido))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addComponent(btnNext)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblNombre)
                                    .addComponent(lblPenalizaciones))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblApellido))
                            .addComponent(lblPic, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(peli1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(peli3, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(84, 84, 84))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(117, 117, 117)
                                .addComponent(btnPrev, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(184, 184, 184))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNextMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNextMousePressed
        //int a =0;
        
        if(x<151){
            try{
                caratula.setVisible(false);
                x++;
                System.out.println("init"+ruta(x));
                URL imagen2 = getClass().getResource(ruta(x));
                ImageIcon portada = new ImageIcon(imagen2);
                caratula = new JLabel();
                this.add(caratula);
                caratula.setVisible(true);
                caratula.setBounds(293,150,173,250);
                caratula.setIcon(portada);
            } catch (NullPointerException e) {
                System.out.print("Caught the NullPointerException");
                caratula.setVisible(false);
                x+=2;
                URL imagen2 = getClass().getResource(ruta(x));
                ImageIcon portada = new ImageIcon(imagen2);
                caratula = new JLabel();
                this.add(caratula);
                caratula.setVisible(true);
                caratula.setBounds(293,150,173,250);
                caratula.setIcon(portada);
        }
            
            /*for(x = x; x<x+3;x++){
                System.out.println("boton(ruta(x)"+ruta(x));
                URL imagen2 = getClass().getResource(ruta(x));
                ImageIcon portada = new ImageIcon(imagen2);
                peli1.setBounds(peli1.getX(),peli1.getY(),peli1.getWidth(),peli1.getHeight());
                a++;
                if(a==1){
                    peli1.setIcon(portada);
                }else if(a==2){
                    //peli2.setIcon(portada);
                }else if(a==3){
                    peli3.setIcon(portada);
                }
            }*/
        }
    }//GEN-LAST:event_btnNextMousePressed

    private void btnPrevMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPrevMousePressed
        int a =0;
        
        if(x>1){
            try{
                caratula.setVisible(false);
                x--;
                System.out.println("init"+ruta(x));
                URL imagen2 = getClass().getResource(ruta(x));
                ImageIcon portada = new ImageIcon(imagen2);
                
                caratula = new JLabel();
                this.add(caratula);
                caratula.setVisible(true);
                caratula.setBounds(293,150,173,250);
                caratula.setIcon(portada);
            } catch (NullPointerException e) {
                System.out.print("Caught the NullPointerException");
                caratula.setVisible(false);
                x-=2;
                URL imagen2 = getClass().getResource(ruta(x));
                ImageIcon portada = new ImageIcon(imagen2);
                caratula = new JLabel();
                this.add(caratula);
                caratula.setVisible(true);
                caratula.setBounds(293,150,173,250);
                caratula.setIcon(portada);
            }
            /*for(x = x; x<x-3;x--){
                System.out.println("boton(ruta(x)"+ruta(x));
                URL imagen2 = getClass().getResource(ruta(x));
                ImageIcon portada = new ImageIcon(imagen2);
                peli1.setBounds(peli1.getX(),peli1.getY(),peli1.getWidth(),peli1.getHeight());
                a++;
                if(a==1){
                    peli1.setIcon(portada);
                }else if(a==2){
                    //peli2.setIcon(portada);
                }else if(a==3){
                    peli3.setIcon(portada);
                }
            }*/
        }
    }//GEN-LAST:event_btnPrevMousePressed

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        if(evt.getX()>293 && evt.getX()<293+173 && evt.getY()>150 && evt.getY()<150+250){
            System.out.println("a");
            try {
                pelis(x);
                taResumen.setLineWrap(true); 
                dialogInfo.setVisible(true);
                dialogInfo.setSize(800,500);
                dialogInfo.setTitle("Información" + arrayPeliculas[rst.getRow()-1][1]);
                URL imagen2 = getClass().getResource(ruta(x));
                ImageIcon portada = new ImageIcon(imagen2);
                lblPortada.setBounds(lblPortada.getX(),lblPortada.getY(),lblPortada.getWidth(),lblPortada.getHeight());
                lblPortada.setIcon(portada);
                lblTitulo.setText("Titulo: " + arrayPeliculas[rst.getRow()-1][1]);
                lblAnyo.setText("Año: " + arrayPeliculas[rst.getRow()-1][2]);
                lblPais.setText("País: " + arrayPeliculas[rst.getRow()-1][3]);
                lblGenero.setText("Género: " + arrayPeliculas[rst.getRow()-1][4]);
                lblClasificacion.setText("Clasificación: " + arrayPeliculas[rst.getRow()-1][6]);
                taResumen.setText("Resumen: " + arrayPeliculas[rst.getRow()-1][7]);
            } catch (SQLException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }//GEN-LAST:event_formMousePressed

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
            java.util.logging.Logger.getLogger(User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //try {
                    //new User(String dni).setVisible(true);
                /*} catch (IOException ex) {
                    Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
                }*/
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrev;
    private javax.swing.JDialog dialogInfo;
    private javax.swing.JLabel lblAnyo;
    private javax.swing.JLabel lblApellido;
    private javax.swing.JLabel lblClasificacion;
    private javax.swing.JLabel lblGenero;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPais;
    private javax.swing.JLabel lblPenalizaciones;
    private javax.swing.JLabel lblPic;
    private javax.swing.JLabel lblPortada;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel peli1;
    private javax.swing.JLabel peli3;
    private javax.swing.JTextArea taResumen;
    // End of variables declaration//GEN-END:variables
}
