/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cadastropoo;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.PessoaFisica;
import model.PessoaFisicaRepo;
import model.PessoaJuridica;
import model.PessoaJuridicaRepo;

/**
 *
 * @author okidata
 */
public class CadastroPOO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String arquivo1;
        String arquivo2;
    
        arquivo1 = "pf.txt";
        arquivo2 = "pj.txt";
        
        PessoaFisicaRepo repo1 = new PessoaFisicaRepo(); 
        
        PessoaFisica pf1 = new PessoaFisica(001, "lucia", "212.212.212-21", 56);       
        PessoaFisica pf2 = new PessoaFisica(002, "maria", "313.313.313-31", 70);
        
        repo1.inserir(pf1);
        repo1.inserir(pf2);
        try {
            repo1.persistir(arquivo1);
        } catch (IOException ex) {
            Logger.getLogger(CadastroPOO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("Dados de Pessoa Fisica Armazenados.");
        
        PessoaFisicaRepo repo2 = new PessoaFisicaRepo();
        
        try {
            repo2.recuperar(arquivo1);
        } catch (IOException ex) {
            Logger.getLogger(CadastroPOO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CadastroPOO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("Dados de Pessoa Fisica Recuperados.");
        for (PessoaFisica pessoaF : repo2.obterTodos()) {
            pessoaF.exibir();
        }
        
        PessoaJuridicaRepo repo3 = new PessoaJuridicaRepo(); 
        
        PessoaJuridica pj1 = new PessoaJuridica(003, "xpto Sales", "3333333333");
        PessoaJuridica pj2 = new PessoaJuridica(004, "xpto Solutions", "44444444444");
        
        repo3.inserir(pj1);
        repo3.inserir(pj2);
        try {
            repo3.persistir(arquivo2);
        } catch (IOException ex) {
            Logger.getLogger(CadastroPOO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("Dados de Pessoa Juridica Armazenados.");
        
        PessoaJuridicaRepo repo4 = new PessoaJuridicaRepo();
        
        try {
            repo4.recuperar(arquivo2);
        } catch (IOException ex) {
            Logger.getLogger(CadastroPOO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CadastroPOO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("Dados de Pessoa Juridica Recuperados.");
        for (PessoaJuridica pessoaJ : repo4.obterTodos()) {
            pessoaJ.exibir();
        }

    }
    
}
