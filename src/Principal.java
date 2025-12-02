package RegistroEmpregados;

import javax.swing.SwingUtilities;

import RegistroEmpregados.GUI.TelaInicial;

public class Principal {
    public static void main(String[] args) {
        
       //Tela inicial
       SwingUtilities.invokeLater(() -> new TelaInicial().setVisible(true)); 
        
    }
}
