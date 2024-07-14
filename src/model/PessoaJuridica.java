/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.io.Serializable;

/**
 *
 * @author okidata
 */
public class PessoaJuridica extends Pessoa implements Serializable {
    
    private String cnpj;
    
    @Override
    public void exibir() {
        super.exibir();
        System.out.println("cnpj: " + getCnpj());
    }
    
    public PessoaJuridica() {
        cnpj = "";
    }
    
    public PessoaJuridica(int id, String nome, String cnpj) {
        setId(id);
        setNome(nome);
        this.cnpj = cnpj;
    }
    
    public PessoaJuridica(String cnpj) {
        this.cnpj = cnpj;
    }
    
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    
}
