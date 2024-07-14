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
public class PessoaFisica extends Pessoa implements Serializable{
    
    private String cpf;
    private int idade;
    
    @Override
    public void exibir() {
        super.exibir();
        System.out.println("cpf: " + getCpf());
        System.out.println("idade: " + getIdade());
    }
    
    public PessoaFisica() {
        cpf = "";
        idade = 0;
    }
    
    public PessoaFisica(int id, String nome, String cpf, int idade) {
        setId(id);
        setNome(nome);
        this.cpf = cpf;
        this.idade = idade;
    }
    
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
    
}
