import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;


public class Graficas extends JFrame implements ActionListener {
    public static JTextField dato1, dato2;
    static JButton btnGraficar;
    static JLabel lbl1, lbl2;
    static int  valorMasGrande;
    static int largoPromedioV1, largoPromedioV2;
    static Graphics grafica;

    public static int v1, v2;
    static int[][] datosGrafica = new int[2][2];


    public static void main(String[] args) {
        Graficas ventana = new Graficas();
        ventana.setVisible(true);

    }


    public Graficas() {


        dato1 = new JTextField("0");
        dato1.setLocation(80, 40);
        dato1.setSize(50, 20);
        dato1.setFont(new Font("Arial", Font.PLAIN, 18));

        dato2 = new JTextField("0");
        dato2.setLocation(250, 40);
        dato2.setSize(50, 20);
        dato2.setFont(new Font("Arial", Font.PLAIN, 18));


        lbl1 = new JLabel("Dato 1.");
        lbl1.setLocation(10, 40);
        lbl1.setSize(60, 20);
        lbl1.setFont(new Font("Arial", Font.PLAIN, 18));

        lbl2 = new JLabel("Dato 2.");
        lbl2.setLocation(180, 40);
        lbl2.setSize(60, 20);
        lbl2.setFont(new Font("Arial", Font.PLAIN, 18));

        btnGraficar = new JButton("GRAFICAR");
        btnGraficar.setLocation(310, 40);
        btnGraficar.setSize(100, 20);

        btnGraficar.addActionListener(this);


        //add
        add(dato1);
        add(dato2);
        add(btnGraficar);
        add(lbl1);
        add(lbl2);

        //set
        Color c = new Color(173, 216, 230);
        getContentPane().setBackground(c);

        setLayout(null);
        setSize(480, 350);
        setTitle("Agenda de contactos");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(300, 200);

    }


    public int mayorPromedio(int[][] lista) {
        if (lista[0][0] > lista[1][0]) {
            //primer valor es mas grande

            return lista[0][0];
        } else if (lista[0][0] < lista[1][0]) {
            // segundo valor es mas grande
            return lista[1][0];
        } else {
            //son dos valores iguales
            return lista[0][0];
        }

    }

    @Override
    public void paint(Graphics grafica) {

        super.paint(grafica);
        v1 = Integer.valueOf(dato1.getText());
        v2 = Integer.valueOf(dato2.getText());


        if (v1 <= 0 || v2 <= 0 ) {
            new  Exception("NO PONGAS VALORES NEGATIVOS O UN CERO");
        } else {
            datosGrafica[0][0]= v1;
            datosGrafica[1][0]= v2;
            valorMasGrande = mayorPromedio(datosGrafica);

            largoPromedioV1 = (valorMasGrande==datosGrafica[0][0]? 400: v1  *400 / valorMasGrande);
            largoPromedioV2 = (valorMasGrande==datosGrafica[1][0]? 400: v2  *400 / valorMasGrande);
            datosGrafica[0][1] = largoPromedioV1;
            datosGrafica[1][1] = largoPromedioV2;




            //se grafic el primer valor
            grafica.setColor(Color.LIGHT_GRAY);
            grafica.fillRect(40, 120, largoPromedioV1, 40);


            grafica.setColor(Color.black);
            grafica.drawString("1. Promedio - "+datosGrafica[0][0], 40, 140);


            //barras

            grafica.setColor(Color.WHITE);
            grafica.fillRect(40,110,2,160);
            grafica.drawString("0", 40,270);


            grafica.setColor(Color.WHITE);
            grafica.fillRect(80,100,2,160);
            grafica.drawString(Math.round(valorMasGrande*0.1)+"", 80,260);


            grafica.setColor(Color.WHITE);
            grafica.fillRect(120,110,2,160);
            grafica.drawString(Math.round(valorMasGrande*0.2)+"", 120,270);


            grafica.setColor(Color.WHITE);
            grafica.fillRect(160,100,2,160);
            grafica.drawString(Math.round(valorMasGrande*0.3)+"", 160,260);


            grafica.setColor(Color.WHITE);
            grafica.fillRect(200,110,2,160);
            grafica.drawString(Math.round(valorMasGrande*0.4)+"", 200,270);


            grafica.setColor(Color.WHITE);
            grafica.fillRect(240,100,2,160);
            grafica.drawString(Math.round(valorMasGrande*0.5)+"", 240,260);


            grafica.setColor(Color.WHITE);
            grafica.fillRect(280,110,2,160);
            grafica.drawString(Math.round(valorMasGrande*0.6)+"", 280,270);


            grafica.setColor(Color.WHITE);
            grafica.fillRect(320,100,2,160);
            grafica.drawString(Math.round(valorMasGrande*0.7)+"", 320,260);


            grafica.setColor(Color.WHITE);
            grafica.fillRect(360,110,2,160);
            grafica.drawString(Math.round(valorMasGrande*0.8)+"", 360,270);


            grafica.setColor(Color.WHITE);
            grafica.fillRect(400,100,2,160);
            grafica.drawString(Math.round(valorMasGrande*0.9)+"", 400,260);

            grafica.setColor(Color.WHITE);
            grafica.fillRect(440,110,2,160);
            grafica.drawString(Math.round(valorMasGrande)+"", 440,270);








            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


            //se grafic el segundo valor
            grafica.setColor(Color.GREEN);
            grafica.fillRect(40, 200, largoPromedioV2, 40);


            //barras
            grafica.setColor(Color.WHITE);
            grafica.fillRect(40,110,2,160);
            grafica.drawString("0", 40,270);


            grafica.setColor(Color.WHITE);
            grafica.fillRect(80,100,2,160);
            grafica.drawString(Math.round(valorMasGrande*0.1)+"", 80,260);


            grafica.setColor(Color.WHITE);
            grafica.fillRect(120,110,2,160);
            grafica.drawString(Math.round(valorMasGrande*0.2)+"", 120,270);


            grafica.setColor(Color.WHITE);
            grafica.fillRect(160,100,2,160);
            grafica.drawString(Math.round(valorMasGrande*0.3)+"", 160,260);


            grafica.setColor(Color.WHITE);
            grafica.fillRect(200,110,2,160);
            grafica.drawString(Math.round(valorMasGrande*0.4)+"", 200,270);


            grafica.setColor(Color.WHITE);
            grafica.fillRect(240,100,2,160);
            grafica.drawString(Math.round(valorMasGrande*0.5)+"", 240,260);


            grafica.setColor(Color.WHITE);
            grafica.fillRect(280,110,2,160);
            grafica.drawString(Math.round(valorMasGrande*0.6)+"", 280,270);


            grafica.setColor(Color.WHITE);
            grafica.fillRect(320,100,2,160);
            grafica.drawString(Math.round(valorMasGrande*0.7)+"", 320,260);


            grafica.setColor(Color.WHITE);
            grafica.fillRect(360,110,2,160);
            grafica.drawString(Math.round(valorMasGrande*0.8)+"", 360,270);


            grafica.setColor(Color.WHITE);
            grafica.fillRect(400,100,2,160);
            grafica.drawString(Math.round(valorMasGrande*0.9)+"", 400,260);

            grafica.setColor(Color.WHITE);
            grafica.fillRect(440,110,2,160);
            grafica.drawString(Math.round(valorMasGrande)+"", 440,270);





            grafica.setColor(Color.black);
            grafica.drawString("2. Promedio - "+ datosGrafica[1][0], 40, 220);



        }


    }



    public void actualizarValores(int valor1, int valor2) {
        v1 = valor1;
        v2 = valor2;
        datosGrafica[0][0] = v1;
        datosGrafica[1][0] = v2;

        // Llamar a repaint() para actualizar la representación gráfica
        repaint();
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(btnGraficar)) {
            try {
                repaint();


            } catch (Exception exception) {
                System.out.println(e);
            }

        }

    }
}
