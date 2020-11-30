
import com.mysql.jdbc.Statement;
import conexion.conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tanner1309
 */

public class PartidaRapida extends javax.swing.JFrame {
public int palabraper=0;
public String campoactivo="todo";
public String palabrac;
    /**
     * Creates new form PartidaRapida
     */
    public PartidaRapida() {
        initComponents();
        lblWin.setVisible(false);
        lblLose.setVisible(false);
        letra1cr.setVisible(false);
        letra2cr.setVisible(false);
        letra3cr.setVisible(false);
        letra4cr.setVisible(false);
        letra5cr.setVisible(false);
        letra6cr.setVisible(false);
        letra7cr.setVisible(false);
        letra8cr.setVisible(false);
        letra9cr.setVisible(false);
        letra10cr.setVisible(false);
        letra11cr.setVisible(false);
        letra12cr.setVisible(false);
        BrazoDer.setVisible(false);
        BrazoIzq.setVisible(false);
        Cabeza.setVisible(false);
        Cuerpo.setVisible(false);
        PiernaDer.setVisible(false);
        PiernaIzq.setVisible(false);
        BtnSiguiente.enable(false);
        if(palabraper==1){
        palabra=palabrac;
        }
        else
        {
        
        switch(campoactivo){
        
            case "objeto":
                palabraob();
                break;
            case "comida":
                palabraco();
                break;
            case "animal":
                palabraan();
                break;
            case "termino":
                palabratr();
                break;
            case "lugar":
                palabralg();
                break;
            case "deporte":
                palabradp();
                break;
            case "todo":
                palabrat();
                System.out.println(palabra);
                break;
        }
        letras=palabra.length();
        //System.out.println(letras);
        CirculosActivos();
        lblPista.setText(pista);
        errores=0;
        aciertos=0;
        }
    
    }
    
conexion cn=new conexion();
Statement st;
ResultSet rs;
int aleatorio;  
String pista;
String palabra;
int letras;
int aciertos;
int errores=0;
public int intentosf=1;
int aciertosp=0;
int rachavic=0;
    private  void palabrat(){
        Random rand = new Random();
        int limite=10;
         
               try {
                st=(Statement) cn.con.createStatement();
                rs=st.executeQuery("SELECT * FROM ahorcado.palabras ORDER by id desc LIMIT 1");
                rs.next();
                limite=rs.getInt("id");
            } catch (SQLException ex) {
                
            }
        aleatorio = rand.nextInt(limite);
        palabra="";
            try {
                st=(Statement) cn.con.createStatement();
                rs=st.executeQuery("SELECT * FROM ahorcado.palabras where id="+aleatorio+"");
                rs.next();
                palabra=rs.getString("palabra");
                pista=rs.getString("pista");
            } catch (SQLException ex) {
                
            }
       
    }
    private  void palabraob(){
        int limite=0;
        Random rand = new Random();
        try{
        st=(Statement) cn.con.createStatement();
        rs=st.executeQuery("SELECT * FROM ahorcado.Objetos ORDER by id desc LIMIT 1");
        rs.next();
        limite=rs.getInt("id");
        }catch (Exception e){
            System.out.println("hola"+e);
        }
        aleatorio = rand.nextInt(limite);
        palabra="";
        pista="";
        int idgeneral;
            try {
                st=(Statement) cn.con.createStatement();
                rs=st.executeQuery("SELECT * FROM ahorcado.Objetos where id="+aleatorio+"");
                rs.next();
                idgeneral=rs.getInt("id_general");
                //System.out.println(idgeneral);
                st=(Statement) cn.con.createStatement();
                rs=st.executeQuery("SELECT * FROM ahorcado.palabras where id="+idgeneral+"");
                rs.next();
                palabra=rs.getString("palabra");                         
                pista=rs.getString("pista");
            } catch (SQLException e) {
               System.out.println("hola"+e);
            }
     
    }
    private  void palabraan(){
        int limite=0;
        Random rand = new Random();
        try{
        st=(Statement) cn.con.createStatement();
        rs=st.executeQuery("SELECT * FROM ahorcado.Animales ORDER by id desc LIMIT 1");
        rs.next();
        limite=rs.getInt("id");
        
        }catch (Exception e){
        }
        aleatorio = rand.nextInt(limite);
        palabra="";
        pista="";
        int idgeneral;
            try {
                st=(Statement) cn.con.createStatement();
                rs=st.executeQuery("SELECT * FROM ahorcado.Animales where id="+aleatorio+"");
                rs.next();
                idgeneral=rs.getInt("id_general");
                System.out.println(idgeneral);
                st=(Statement) cn.con.createStatement();
                rs=st.executeQuery("SELECT * FROM ahorcado.palabras where id="+idgeneral+"");
                rs.next();
                palabra=rs.getString("palabra");                         
                pista=rs.getString("pista");
            } catch (SQLException e) {
               
            }
     
    }
    private  void palabralg(){
        int limite=0;
        Random rand = new Random();
        try{
        st=(Statement) cn.con.createStatement();
        rs=st.executeQuery("SELECT * FROM ahorcado.Lugares ORDER by id desc LIMIT 1");
        rs.next();
        limite=rs.getInt("id");
        }catch (Exception e){
        }
        aleatorio = rand.nextInt(limite);
         palabra="";
         pista="";
        int idgeneral;
            try {
                st=(Statement) cn.con.createStatement();
                rs=st.executeQuery("SELECT * FROM ahorcado.Lugares where id="+aleatorio+"");
                rs.next();
                idgeneral=rs.getInt("id_general");
                System.out.println(idgeneral);
                st=(Statement) cn.con.createStatement();
                rs=st.executeQuery("SELECT * FROM ahorcado.palabras where id="+idgeneral+"");
                rs.next();
                palabra=rs.getString("palabra");                         
                pista=rs.getString("pista");
            } catch (SQLException e) {
               
            }
     
    }
    private  void palabratr(){
        int limite=0;
        Random rand = new Random();
        try{
        st=(Statement) cn.con.createStatement();
        rs=st.executeQuery("SELECT * FROM ahorcado.Terminos ORDER by id desc LIMIT 1");
        rs.next();
        limite=rs.getInt("id");
        }catch (Exception e){
        }
        aleatorio = rand.nextInt(limite);
        palabra="";
        pista="";
        int idgeneral;
            try {
                st=(Statement) cn.con.createStatement();
                rs=st.executeQuery("SELECT * FROM ahorcado.Terminos where id="+aleatorio+"");
                rs.next();
                idgeneral=rs.getInt("id_general");
                System.out.println(idgeneral);
                st=(Statement) cn.con.createStatement();
                rs=st.executeQuery("SELECT * FROM ahorcado.palabras where id="+idgeneral+"");
                rs.next();
                palabra=rs.getString("palabra");                         
                pista=rs.getString("pista");
            } catch (SQLException e) {
               
            }
     
    }
    private  void palabraco(){
        int limite=0;
        Random rand = new Random();
        try{
        st=(Statement) cn.con.createStatement();
        rs=st.executeQuery("SELECT * FROM ahorcado.Comida ORDER by id desc LIMIT 1");
        rs.next();
        limite=rs.getInt("id");
        }catch (Exception e){
        }
        aleatorio = rand.nextInt(limite);
         palabra="";
         pista="";
        int idgeneral;
            try {
                st=(Statement) cn.con.createStatement();
                rs=st.executeQuery("SELECT * FROM ahorcado.Comida where id="+aleatorio+"");
                rs.next();
                idgeneral=rs.getInt("id_general");
                System.out.println(idgeneral);
                st=(Statement) cn.con.createStatement();
                rs=st.executeQuery("SELECT * FROM ahorcado.palabras where id="+idgeneral+"");
                rs.next();
                palabra=rs.getString("palabra");                         
                pista=rs.getString("pista");
            } catch (SQLException e) {
               
            }
    
    }
    private  void palabradp(){
        int limite=0;
        Random rand = new Random();
        try{
        st=(Statement) cn.con.createStatement();
        rs=st.executeQuery("SELECT * FROM ahorcado.Deportes ORDER by id desc LIMIT 1");
        rs.next();
        limite=rs.getInt("id");
        }catch (Exception e){
        }
        aleatorio = rand.nextInt(limite);
         palabra="";
         pista="";
        int idgeneral;
            try {
                st=(Statement) cn.con.createStatement();
                rs=st.executeQuery("SELECT * FROM ahorcado.Objetos where id="+aleatorio+"");
                rs.next();
                idgeneral=rs.getInt("id_general");
                System.out.println(idgeneral);
                st=(Statement) cn.con.createStatement();
                rs=st.executeQuery("SELECT * FROM ahorcado.palabras where id="+idgeneral+"");
                rs.next();
                palabra=rs.getString("palabra");                         
                pista=rs.getString("pista");
            } catch (SQLException e) {
               
            }
     
    }
private void CirculosActivos(){
switch (letras){
    case 1:
        letra1cr.setVisible(true);
        
        break;
    case 2:
        letra1cr.setVisible(true);
        letra2cr.setVisible(true);
        
        break;
    case 3:
        letra1cr.setVisible(true);
        letra2cr.setVisible(true);
        letra3cr.setVisible(true);
        
        break;
    case 4:
        letra1cr.setVisible(true);
        letra2cr.setVisible(true);
        letra3cr.setVisible(true);
        letra4cr.setVisible(true);
        
        break;
    case 5:
        letra1cr.setVisible(true);
        letra2cr.setVisible(true);
        letra3cr.setVisible(true);
        letra4cr.setVisible(true);
        letra5cr.setVisible(true);
        
        break;
    case 6:
        letra1cr.setVisible(true);
        letra2cr.setVisible(true);
        letra3cr.setVisible(true);
        letra4cr.setVisible(true);
        letra5cr.setVisible(true);
        letra6cr.setVisible(true);
        
        break;
    case 7:
        letra1cr.setVisible(true);
        letra2cr.setVisible(true);
        letra3cr.setVisible(true);
        letra4cr.setVisible(true);
        letra5cr.setVisible(true);
        letra6cr.setVisible(true);
        letra7cr.setVisible(true);
        
        break;
    case 8:
        letra1cr.setVisible(true);
        letra2cr.setVisible(true);
        letra3cr.setVisible(true);
        letra4cr.setVisible(true);
        letra5cr.setVisible(true);
        letra6cr.setVisible(true);
        letra7cr.setVisible(true);
        letra8cr.setVisible(true);
        
        break;
    case 9:
        letra1cr.setVisible(true);
        letra2cr.setVisible(true);
        letra3cr.setVisible(true);
        letra4cr.setVisible(true);
        letra5cr.setVisible(true);
        letra6cr.setVisible(true);
        letra7cr.setVisible(true);
        letra8cr.setVisible(true);
        letra9cr.setVisible(true);
        
        break;
    case 10:
        letra1cr.setVisible(true);
        letra2cr.setVisible(true);
        letra3cr.setVisible(true);
        letra4cr.setVisible(true);
        letra5cr.setVisible(true);
        letra6cr.setVisible(true);
        letra7cr.setVisible(true);
        letra8cr.setVisible(true);
        letra9cr.setVisible(true);
        letra10cr.setVisible(true);
       
        break;
    case 11:
        letra1cr.setVisible(true);
        letra2cr.setVisible(true);
        letra3cr.setVisible(true);
        letra4cr.setVisible(true);
        letra5cr.setVisible(true);
        letra6cr.setVisible(true);
        letra7cr.setVisible(true);
        letra8cr.setVisible(true);
        letra9cr.setVisible(true);
        letra10cr.setVisible(true);
        letra11cr.setVisible(true);
        
        break;
    case 12:
        letra1cr.setVisible(true);
        letra2cr.setVisible(true);
        letra3cr.setVisible(true);
        letra4cr.setVisible(true);
        letra5cr.setVisible(true);
        letra6cr.setVisible(true);
        letra7cr.setVisible(true);
        letra8cr.setVisible(true);
        letra9cr.setVisible(true);
        letra10cr.setVisible(true);
        letra11cr.setVisible(true);
        letra12cr.setVisible(true);
        break;
}
}
private void Aciertos(){
    String intento=FtxtLetra.getText();
    String ev;
    
for(int i=0;i<letras;i++){
    ev=Character.toString(palabra.charAt(i));
    if (intento.equals(ev)){
        //System.out.println("XD");
        aciertos++;
        aciertosp++;
      
    switch(i){
        case 0:
            lblLetra1.setText(intento);
            break;
        case 1:
            lblLetra2.setText(intento);
            break;
        case 2:
            lblLetra3.setText(intento);
            break;
        case 3:
            lblLetra4.setText(intento);
            break;
        case 4:
            lblLetra5.setText(intento);
            break;
        case 5:
            lblLetra6.setText(intento);
            break;
        case 6:
            lblLetra7.setText(intento);
            break;
        case 7:
            lblLetra8.setText(intento);
            break;
        case 8:
            lblLetra9.setText(intento);
            break;
        case 9:
            lblLetra10.setText(intento);
            break;
        case 10:
            lblLetra11.setText(intento);
            break;
        case 11:
            lblLetra12.setText(intento);
            break;
    }
    
    }
    
    
}
if(aciertosp==0){
errores++;
}
aciertosp=0;
FtxtLetra.setText(null);
wingame();
gameover();
}
private void gameover(){
    if(intentosf==6){
        //System.out.println(errores);
        switch(errores){
            case 1:
                Cabeza.setVisible(true);
                break;
            case 2:
                Cuerpo.setVisible(true);
                break;
            case 3:
                BrazoIzq.setVisible(true);
                break;
            case 4:
                BrazoDer.setVisible(true);
                break;
            case 5:
                PiernaIzq.setVisible(true);
                break;
            case 6:
                PiernaDer.setVisible(true);
                btnSubir.setEnabled(false);
                lblLose.setVisible(true);
                BtnSiguiente.setEnabled(true);
                rachavic=0;
                break;
        }   
        }
        if (intentosf==1){
            if(errores==1){
              Cabeza.setVisible(true);
              Cuerpo.setVisible(true);
              BrazoIzq.setVisible(true);
              BrazoDer.setVisible(true);
              PiernaIzq.setVisible(true);
              PiernaDer.setVisible(true);
              btnSubir.setEnabled(false);
              lblLose.setVisible(true);
              BtnSiguiente.setEnabled(true);
              rachavic=0;
            }
            if(intentosf==12){
                switch(errores){
                    case 2:
                        Cabeza.setVisible(true);
                        break;
                    case 4:
                        Cuerpo.setVisible(true);
                        break;
                    case 6:
                        BrazoIzq.setVisible(true);
                        break;
                    case 8:
                        BrazoDer.setVisible(true);
                        break;
                    case 10:
                        PiernaIzq.setVisible(true);
                        break;
                    case 12:
                        PiernaDer.setVisible(true);
                        btnSubir.setEnabled(false);
                        lblLose.setVisible(true);
                        BtnSiguiente.setEnabled(true);
                        rachavic=0;
                        break;
                          
                        }
                        if(intentosf!=6&&intentosf!=12&&intentosf!=1){
                            if(errores==intentosf){
                                        Cabeza.setVisible(true);
                                        Cuerpo.setVisible(true);
                                        BrazoIzq.setVisible(true);
                                        BrazoDer.setVisible(true);
                                        PiernaIzq.setVisible(true);
                                        PiernaDer.setVisible(true);
                                        btnSubir.setEnabled(false);
                                        lblLose.setVisible(true);
                                        BtnSiguiente.setEnabled(true);
                                        rachavic=0;
                            }
                            }
            }
        }
        
    
}
private void wingame() {
    if(aciertos==letras){
    BtnSiguiente.setEnabled(true);
    lblWin.setVisible(true);
    rachavic++;
}
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Cabeza = new javax.swing.JLabel();
        Cuerpo = new javax.swing.JLabel();
        BrazoIzq = new javax.swing.JLabel();
        BrazoDer = new javax.swing.JLabel();
        PiernaDer = new javax.swing.JLabel();
        PiernaIzq = new javax.swing.JLabel();
        lblPista = new javax.swing.JLabel();
        CuadroPista = new javax.swing.JLabel();
        FtxtLetra = new javax.swing.JTextField();
        txtLetra = new javax.swing.JLabel();
        btnSubir = new javax.swing.JLabel();
        BtnRendirse = new javax.swing.JLabel();
        BtnSiguiente = new javax.swing.JLabel();
        lblLetra1 = new javax.swing.JLabel();
        lblLetra2 = new javax.swing.JLabel();
        lblLetra3 = new javax.swing.JLabel();
        lblLetra4 = new javax.swing.JLabel();
        lblLetra5 = new javax.swing.JLabel();
        lblLetra6 = new javax.swing.JLabel();
        lblLetra7 = new javax.swing.JLabel();
        lblLetra8 = new javax.swing.JLabel();
        lblLetra9 = new javax.swing.JLabel();
        lblLetra10 = new javax.swing.JLabel();
        lblLetra11 = new javax.swing.JLabel();
        lblLetra12 = new javax.swing.JLabel();
        letra1cr = new javax.swing.JLabel();
        letra2cr = new javax.swing.JLabel();
        letra3cr = new javax.swing.JLabel();
        letra4cr = new javax.swing.JLabel();
        letra5cr = new javax.swing.JLabel();
        letra6cr = new javax.swing.JLabel();
        letra7cr = new javax.swing.JLabel();
        letra8cr = new javax.swing.JLabel();
        letra9cr = new javax.swing.JLabel();
        letra10cr = new javax.swing.JLabel();
        letra11cr = new javax.swing.JLabel();
        letra12cr = new javax.swing.JLabel();
        Stand = new javax.swing.JLabel();
        lblLose = new javax.swing.JLabel();
        lblWin = new javax.swing.JLabel();
        Titulo = new javax.swing.JLabel();
        PiePagina = new javax.swing.JLabel();
        Fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Cabeza.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Tema neon/Plantillas/Partida/Cabeza.png"))); // NOI18N
        Cabeza.setToolTipText("");
        getContentPane().add(Cabeza, new org.netbeans.lib.awtextra.AbsoluteConstraints(238, 230, -1, -1));

        Cuerpo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Tema neon/Plantillas/Partida/Cuerpo.png"))); // NOI18N
        Cuerpo.setToolTipText("");
        getContentPane().add(Cuerpo, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 270, -1, -1));

        BrazoIzq.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Tema neon/Plantillas/Partida/ManoIzq.png"))); // NOI18N
        BrazoIzq.setToolTipText("");
        getContentPane().add(BrazoIzq, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 280, -1, -1));

        BrazoDer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Tema neon/Plantillas/Partida/Manoder.png"))); // NOI18N
        BrazoDer.setToolTipText("");
        getContentPane().add(BrazoDer, new org.netbeans.lib.awtextra.AbsoluteConstraints(268, 280, -1, -1));

        PiernaDer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Tema neon/Plantillas/Partida/PiernaDer.png"))); // NOI18N
        PiernaDer.setToolTipText("");
        getContentPane().add(PiernaDer, new org.netbeans.lib.awtextra.AbsoluteConstraints(265, 350, -1, -1));

        PiernaIzq.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Tema neon/Plantillas/Partida/PiernaIzq.png"))); // NOI18N
        PiernaIzq.setToolTipText("");
        getContentPane().add(PiernaIzq, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 350, -1, -1));

        lblPista.setFont(new java.awt.Font("Nunito SemiBold", 0, 14)); // NOI18N
        lblPista.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPista.setToolTipText("");
        getContentPane().add(lblPista, new org.netbeans.lib.awtextra.AbsoluteConstraints(954, 30, 250, 60));

        CuadroPista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Tema neon/Plantillas/Partida/CuadroPista.png"))); // NOI18N
        CuadroPista.setToolTipText("");
        getContentPane().add(CuadroPista, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 30, -1, -1));

        FtxtLetra.setBackground(new java.awt.Color(252, 39, 146));
        FtxtLetra.setFont(new java.awt.Font("Nunito Black", 0, 18)); // NOI18N
        FtxtLetra.setForeground(new java.awt.Color(255, 255, 255));
        FtxtLetra.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        FtxtLetra.setBorder(null);
        FtxtLetra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FtxtLetraActionPerformed(evt);
            }
        });
        getContentPane().add(FtxtLetra, new org.netbeans.lib.awtextra.AbsoluteConstraints(622, 542, 50, 30));

        txtLetra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Tema neon/Plantillas/Partida/Insertar.png"))); // NOI18N
        getContentPane().add(txtLetra, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 528, -1, -1));

        btnSubir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Tema neon/Plantillas/Partida/btmInsertar.png"))); // NOI18N
        btnSubir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSubirMouseClicked(evt);
            }
        });
        getContentPane().add(btnSubir, new org.netbeans.lib.awtextra.AbsoluteConstraints(715, 528, -1, -1));

        BtnRendirse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Tema neon/Plantillas/Partida/btnRendirse.png"))); // NOI18N
        BtnRendirse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnRendirseMouseClicked(evt);
            }
        });
        getContentPane().add(BtnRendirse, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 620, -1, -1));

        BtnSiguiente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Tema neon/Plantillas/Partida/btnSiguiente.png"))); // NOI18N
        BtnSiguiente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnSiguienteMouseClicked(evt);
            }
        });
        getContentPane().add(BtnSiguiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 630, -1, -1));

        lblLetra1.setFont(new java.awt.Font("Nunito Black", 0, 14)); // NOI18N
        lblLetra1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(lblLetra1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 390, 20, 20));

        lblLetra2.setFont(new java.awt.Font("Nunito Black", 0, 14)); // NOI18N
        lblLetra2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(lblLetra2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 390, 20, 20));

        lblLetra3.setFont(new java.awt.Font("Nunito Black", 0, 14)); // NOI18N
        lblLetra3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(lblLetra3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 390, 20, 20));

        lblLetra4.setFont(new java.awt.Font("Nunito Black", 0, 14)); // NOI18N
        lblLetra4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(lblLetra4, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 390, 20, 20));

        lblLetra5.setFont(new java.awt.Font("Nunito Black", 0, 14)); // NOI18N
        lblLetra5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(lblLetra5, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 390, 20, 20));

        lblLetra6.setFont(new java.awt.Font("Nunito Black", 0, 14)); // NOI18N
        lblLetra6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(lblLetra6, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 390, 20, 20));

        lblLetra7.setFont(new java.awt.Font("Nunito Black", 0, 14)); // NOI18N
        lblLetra7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(lblLetra7, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 390, 20, 20));

        lblLetra8.setFont(new java.awt.Font("Nunito Black", 0, 14)); // NOI18N
        lblLetra8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(lblLetra8, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 390, 20, 20));

        lblLetra9.setFont(new java.awt.Font("Nunito Black", 0, 14)); // NOI18N
        lblLetra9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(lblLetra9, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 390, 20, 20));

        lblLetra10.setFont(new java.awt.Font("Nunito Black", 0, 14)); // NOI18N
        lblLetra10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(lblLetra10, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 390, 20, 20));

        lblLetra11.setFont(new java.awt.Font("Nunito Black", 0, 14)); // NOI18N
        lblLetra11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(lblLetra11, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 390, 20, 20));

        lblLetra12.setFont(new java.awt.Font("Nunito Black", 0, 14)); // NOI18N
        lblLetra12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(lblLetra12, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 390, 20, 20));

        letra1cr.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Tema neon/Plantillas/Partida/Letra.png"))); // NOI18N
        getContentPane().add(letra1cr, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 370, -1, -1));

        letra2cr.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Tema neon/Plantillas/Partida/Letra.png"))); // NOI18N
        getContentPane().add(letra2cr, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 370, -1, -1));

        letra3cr.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Tema neon/Plantillas/Partida/Letra.png"))); // NOI18N
        getContentPane().add(letra3cr, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 370, -1, -1));

        letra4cr.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Tema neon/Plantillas/Partida/Letra.png"))); // NOI18N
        getContentPane().add(letra4cr, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 370, -1, -1));

        letra5cr.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Tema neon/Plantillas/Partida/Letra.png"))); // NOI18N
        getContentPane().add(letra5cr, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 370, -1, -1));

        letra6cr.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Tema neon/Plantillas/Partida/Letra.png"))); // NOI18N
        getContentPane().add(letra6cr, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 370, -1, -1));

        letra7cr.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Tema neon/Plantillas/Partida/Letra.png"))); // NOI18N
        getContentPane().add(letra7cr, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 370, -1, -1));

        letra8cr.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Tema neon/Plantillas/Partida/Letra.png"))); // NOI18N
        getContentPane().add(letra8cr, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 370, -1, -1));

        letra9cr.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Tema neon/Plantillas/Partida/Letra.png"))); // NOI18N
        getContentPane().add(letra9cr, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 370, -1, -1));

        letra10cr.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Tema neon/Plantillas/Partida/Letra.png"))); // NOI18N
        getContentPane().add(letra10cr, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 370, -1, -1));

        letra11cr.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Tema neon/Plantillas/Partida/Letra.png"))); // NOI18N
        getContentPane().add(letra11cr, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 370, -1, -1));

        letra12cr.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Tema neon/Plantillas/Partida/Letra.png"))); // NOI18N
        getContentPane().add(letra12cr, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 370, -1, -1));

        Stand.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Tema neon/Plantillas/Partida/Ahorcado.png"))); // NOI18N
        Stand.setToolTipText("");
        getContentPane().add(Stand, new org.netbeans.lib.awtextra.AbsoluteConstraints(73, 190, -1, -1));

        lblLose.setFont(new java.awt.Font("Nunito Black", 1, 36)); // NOI18N
        lblLose.setForeground(new java.awt.Color(255, 255, 255));
        lblLose.setText("Sigue intentando");
        getContentPane().add(lblLose, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 130, -1, -1));

        lblWin.setFont(new java.awt.Font("Nunito Black", 1, 36)); // NOI18N
        lblWin.setForeground(new java.awt.Color(255, 255, 255));
        lblWin.setText("Ganaste!");
        getContentPane().add(lblWin, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 130, -1, -1));

        Titulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Tema neon/Plantillas/Partida/Titulo.png"))); // NOI18N
        getContentPane().add(Titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        PiePagina.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Tema neon/Plantillas/Partida/PiePagina.png"))); // NOI18N
        getContentPane().add(PiePagina, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 550, -1, -1));

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Tema neon/Plantillas/menuprincipal/Fondo.png"))); // NOI18N
        getContentPane().add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void FtxtLetraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FtxtLetraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FtxtLetraActionPerformed

    private void btnSubirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSubirMouseClicked
        // TODO add your handling code here:
        Aciertos();
    }//GEN-LAST:event_btnSubirMouseClicked

    private void BtnSiguienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnSiguienteMouseClicked
        // TODO add your handling code here:
        Cabeza.setVisible(false);
        lblWin.setVisible(false);
        lblLose.setVisible(false);
        btnSubir.setEnabled(true);
        Cuerpo.setVisible(false);
        PiernaDer.setVisible(false);
        PiernaIzq.setVisible(false);
        BrazoDer.setVisible(false);
        BrazoIzq.setVisible(false);
        letra1cr.setVisible(false);
        letra2cr.setVisible(false);
        letra3cr.setVisible(false);
        letra4cr.setVisible(false);
        letra5cr.setVisible(false);
        letra6cr.setVisible(false);
        letra7cr.setVisible(false);
        letra8cr.setVisible(false);
        letra9cr.setVisible(false);
        letra10cr.setVisible(false);
        letra11cr.setVisible(false);
        letra12cr.setVisible(false);
        BrazoDer.setVisible(false);
        BrazoIzq.setVisible(false);
        Cabeza.setVisible(false);
        Cuerpo.setVisible(false);
        PiernaDer.setVisible(false);
        PiernaIzq.setVisible(false);
        BtnSiguiente.setEnabled(false);
        lblLetra1.setText(null);
        lblLetra2.setText(null);
        lblLetra3.setText(null);
        lblLetra4.setText(null);
        lblLetra5.setText(null);
        lblLetra6.setText(null);
        lblLetra7.setText(null);
        lblLetra8.setText(null);
        lblLetra9.setText(null);
        lblLetra10.setText(null);
        lblLetra11.setText(null);
        lblLetra12.setText(null);
        if(palabraper==1){
        palabra=palabrac;
        }
        else
        {
        
        switch(campoactivo){
        
            case "objeto":
                palabraob();
                break;
            case "comida":
                palabraco();
                break;
            case "animal":
                palabraan();
                break;
            case "termino":
                palabratr();
                break;
            case "lugar":
                palabralg();
                break;
            case "deporte":
                palabradp();
                break;
            case "todo":
                palabrat();
                System.out.println(palabra);
                break;
        }
        letras=palabra.length();
        System.out.println(letras);
        CirculosActivos();
        lblPista.setText(pista);
        errores=0;
        aciertos=0;
        }
    }//GEN-LAST:event_BtnSiguienteMouseClicked

    private void BtnRendirseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnRendirseMouseClicked
        // TODO add your handling code here:
        MenuPrincipal partidarapida=new MenuPrincipal();
        partidarapida.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_BtnRendirseMouseClicked

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
            java.util.logging.Logger.getLogger(PartidaRapida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PartidaRapida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PartidaRapida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PartidaRapida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PartidaRapida().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BrazoDer;
    private javax.swing.JLabel BrazoIzq;
    private javax.swing.JLabel BtnRendirse;
    private javax.swing.JLabel BtnSiguiente;
    private javax.swing.JLabel Cabeza;
    private javax.swing.JLabel CuadroPista;
    private javax.swing.JLabel Cuerpo;
    private javax.swing.JLabel Fondo;
    private javax.swing.JTextField FtxtLetra;
    private javax.swing.JLabel PiePagina;
    private javax.swing.JLabel PiernaDer;
    private javax.swing.JLabel PiernaIzq;
    private javax.swing.JLabel Stand;
    private javax.swing.JLabel Titulo;
    private javax.swing.JLabel btnSubir;
    private javax.swing.JLabel lblLetra1;
    private javax.swing.JLabel lblLetra10;
    private javax.swing.JLabel lblLetra11;
    private javax.swing.JLabel lblLetra12;
    private javax.swing.JLabel lblLetra2;
    private javax.swing.JLabel lblLetra3;
    private javax.swing.JLabel lblLetra4;
    private javax.swing.JLabel lblLetra5;
    private javax.swing.JLabel lblLetra6;
    private javax.swing.JLabel lblLetra7;
    private javax.swing.JLabel lblLetra8;
    private javax.swing.JLabel lblLetra9;
    private javax.swing.JLabel lblLose;
    private javax.swing.JLabel lblPista;
    private javax.swing.JLabel lblWin;
    private javax.swing.JLabel letra10cr;
    private javax.swing.JLabel letra11cr;
    private javax.swing.JLabel letra12cr;
    private javax.swing.JLabel letra1cr;
    private javax.swing.JLabel letra2cr;
    private javax.swing.JLabel letra3cr;
    private javax.swing.JLabel letra4cr;
    private javax.swing.JLabel letra5cr;
    private javax.swing.JLabel letra6cr;
    private javax.swing.JLabel letra7cr;
    private javax.swing.JLabel letra8cr;
    private javax.swing.JLabel letra9cr;
    private javax.swing.JLabel txtLetra;
    // End of variables declaration//GEN-END:variables
}
