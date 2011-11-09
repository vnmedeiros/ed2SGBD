package algorithms;

/*
 * 
 * entrada:
   
   Arvore trie = new Arvore();        
   trie.adiciona("casa",1); -> para de entrada chave, indice
   trie.adiciona("cas",2);
   trie.adiciona("ca",3);        
   trie.adiciona("dama", 4);        
   trie.adiciona("data",5);
   trie.adiciona("vitoria",6);
   
 * System.out.println(trie.pesquisa("cas"));
 * 
 * saida será:[2, 1]
 * 
 */

import java.util.ArrayList;
import java.util.Stack;

public class Arvore {
    
    private class No {
        public char aresta;
        public int tamanhoCadeia;
        public ArrayList<Integer> vertices;
        public ArrayList<No> sucessores;
        public No()
        {
            this.aresta = '\0';
            this.tamanhoCadeia = 0;
            this.vertices = new ArrayList<Integer>();
            this.sucessores = new ArrayList<No>();
        }  
    }        
    
    private No raiz;
 //-------------------metodos:    
    public Arvore()
    {
        this.raiz = new No();
        this.raiz.vertices = null;
    }
    private No deslocar(String str)
    {
        No vertice = this.raiz;
        boolean existe=false;
        for(int i=0;i<str.length();i++)
        {
            existe=false;
            char letra = str.charAt(i);
            for(No proximo: vertice.sucessores)
            {
                if(letra == proximo.aresta)
                {
                    vertice=proximo;
                    vertice.tamanhoCadeia=i+1;
                    existe=true;
                    break;
                }
            }
            if(!existe) return vertice; //não existe cadeia completa
        }        
        return vertice;//cadeia completa
    }
    private boolean criarSubArvore(String str,No vertice,int indice)
    {
        if(str.length()!=0)
        {
            char letra = str.charAt(0);
            No temp = new No();
            temp.aresta = letra;
            vertice.sucessores.add(temp);
            criarSubArvore(str.substring(1), temp,indice);
        }
        else vertice.vertices.add(indice);
        return true;
    }        
    public boolean adiciona(String str, int indice)
    {
        No no = deslocar(str);
        if(no.tamanhoCadeia==str.length())
            no.vertices.add(indice);            
        else 
            criarSubArvore(str.substring(no.tamanhoCadeia), no, indice);
        return true;        
    }
    public ArrayList<Integer> pesquisa(String str)
    {
        No no = this.deslocar(str);
        if(no==null)
            return null;
        if(no.tamanhoCadeia!=str.length())return null;
        if(!no.sucessores.isEmpty())
        {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            Stack<No> pilha = new Stack<No>();
            pilha.push(no);
            
            while(!pilha.empty())
            {
                No saida = pilha.pop();
                for(No add:saida.sucessores)
                    pilha.add(add);
                for(int add:saida.vertices)
                    temp.add(add);
            }
            return temp;
        }        
        return no.vertices;
    }
}