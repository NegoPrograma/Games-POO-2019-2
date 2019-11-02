/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendatelefonica;

import java.awt.ComponentOrientation;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author pc janete
 */
public class InfoPanel {
        protected static JPanel infoPanel = new JPanel();
        protected static JLabel nome = new JLabel("Nome:");
        protected static JLabel telefone = new JLabel("Telefone:");
        protected static JLabel detalhes = new JLabel("Detalhes:");
        protected static JTextField nomeDisplay = new JTextField("Display pro nome");
        protected static JTextField telefoneDisplay = new JTextField("Display Telefone:");
        protected static JTextArea detalhesDisplay = new JTextArea("display detalhes:");
        
        
        
        private static void inicializaPainel(){
            infoPanel.setLayout(new GridLayout(3,3,10,20));
            infoPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
            infoPanel.add(nome);
            infoPanel.add(nomeDisplay);
            infoPanel.add(telefone);
            infoPanel.add(telefoneDisplay);
            infoPanel.add(detalhes);
            infoPanel.add(detalhesDisplay);
        }
        
        protected static void atualizaPainel(){
            Contato c = ListPanel.procuraContato();
            if(c != null){
            nomeDisplay.setText(c.getNome());
            telefoneDisplay.setText(c.getTelefone());
            detalhesDisplay.setText(c.getDetalhes());
            ListPanel.listaDeContatos.updateUI();
            } else {
                displayPadrao();
            }
            
        }
        
           protected static void atualizaPainel(Contato c){
            if(c != null){
            nomeDisplay.setText(c.getNome());
            telefoneDisplay.setText(c.getTelefone());
            detalhesDisplay.setText(c.getDetalhes());
            ListPanel.listaDeContatos.updateUI();
            } else {
              displayPadrao();
            }
        }
        
              protected static void displayPadrao(){
                nomeDisplay.setText("nenhum item selecionado");
                telefoneDisplay.setText("nenhum item selecionado");
                detalhesDisplay.setText("nenhum item selecionado");
                ListPanel.listaDeContatos.updateUI();
              }
        
        public static JPanel retornaPainel(){
            inicializaPainel();
            return infoPanel;
            
        }
        
}
