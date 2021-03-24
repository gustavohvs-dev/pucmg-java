package arquivo;

import java.io.*; 
import java.util.Scanner;

public class Exercicio3 { 
public static void comparePrecos (Produto p1, Produto p2, Produto p3) 
{ 
    if (p1.getPreco () >= p2.getPreco() && p1.getPreco () >= p3.getPreco())
    { 
        System.out.println(p1.getNome() + " 6 o mais caro - Preco R$ " + p1.getPreco()); 
        System.out.println("Com desconto o preco final 6 R$ " + (p1.getPreco()-p1.calcularDesconto())); 
    } 
    else if (p2.getPreco() >= p1.getPreco() && p2.getPreco() >= p3.getPreco()) 
    { 
        System.out.println(p2.getNome() + " 6 o mais caro - Preco R$ " + p2.getPreco()); System.out.println("Com desconto o preco final 6 R$ " + (p2.getPreco()-p2.calcularDesconto())); 
    } 
    else 
    { 
        System.out.println(p3.getNome() + " 6 o mais caro - Preco R$ " + p3.getPreco()); 
        System.out.println("Com desconto o preco final 6 R$ " + (p3.getPreco()-calcularDesconto(p3))); 
    } 
} 
    public static void relatorioEletronicos(String nomeArquivo, Produto p1, Produto p2, Produto p3) 
    { 
        FileWriter arquivo; 
        try 
        { 
            arquivo = new FileWriter(nomeArquivo); 
            write(p1.getNome() + " - " + p1.getPreco() + " - " + (p1.getPreco()-p1.calcularDesconto()) + " \n"); 
            write(p2.getNome() + " - " + p2.getPreco() + " - " + (p2.getPreco()-p2.calcularDesconto()) + " \n"); 
            write(p3.getNome() + " - " + p3.getPreco() + " - " + (p3.getPreco()-p3.calcularDesconto()) + " \n"); 
        } 
        catch (FileNotFoundException fe) 
        { 
            System.out.println(fe.getMessage()); 
        } 
        catch (IOException io) 
        { 
            System.out.println(io.getMessage()); 
        } 
    } 

    public static void main(String[] args) 
    { 
        Produto computador, celular, tablet; 
        Scanner entrada = new Scanner(System.in); 
        String nome, relatorio; 
        double preco; 

        System.out.print("Digite a marca do computador: "); 
        nome = entrada.next(); System.out.print("Digite o preco do computador: "); 
        preco = entrada.nextDouble(); 
        computador = new Produto(nome,preco); 

        System.out.print("Digite a marca do celular: "); nome = entrada.next(); System.out.print("Digite o prep:, do celular: "); 
        preco = entrada.nextDouble(); 
        celular = new Produto(nome,preco);

        System.out.print("Digite a marca do tablet: "); nome = entrada.next(); System.out.print("Digite o preco do tablet: "); 
        preco = entrada.nextDouble(); 
        tablet = new Produto(nome,preco);

        comparePrecos(computador,celular,tablet); System.out.print("Digite o caminho completo do relatorio a ser salvo: "); 
        relatorio = entrada.next(); relatorioEletronicos(relatorio,computador,celular,tablet); 
        System.out.println("Fim do programa. Boas ferias!"); entrada.close(); 
    }
    
    } 
    class Produto 
    { 
        private String nome; 
        private double preco; 

        public String getNome () 
        { 
            return nome; 
        } 

        public void setNome (String nome) 
        { 
            this.nome = nome; 
        } 
        public double getPreco() 
        { 
            return preco;   
        } 
        public void setPreco(double valor) 
        { 
            preco = valor; 
        } 
        public void Produto (String novo, double pr) 
        { 
            inicializar(novo, pr); 
        } 
        private void inicializar(String nome, double valor) 
        { 
            setNome(nome); 
            setPreco(valor); 
        } 
        public double calcularDesconto (double preco) 
        { 
            if (preco > 100) 
            { 
                return (0.15*preco);
            } 
            else 
            { 
                return (0.05*preco);
            }
        } 
        
}    
     
